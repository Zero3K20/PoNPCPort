/*
 * Platform.cpp - Win32 platform implementation for P.o.N. PC port
 */
#include "Platform.h"
#include "../support/puff.h"
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

#pragma comment(lib, "winmm.lib")
#pragma comment(lib, "gdi32.lib")
#pragma comment(lib, "user32.lib")
#pragma comment(lib, "kernel32.lib")

/* ---- Globals ----------------------------------------------------------- */
HWND          g_hwnd          = nullptr;
HDC           g_hdc_mem       = nullptr;
HBITMAP       g_hbm_mem       = nullptr;
RGBQUAD      *g_screen_pixels = nullptr;
HDC           g_hdc_win       = nullptr;
PlatFont      g_font;
PlatColor     g_cur_color     = 0;
int           g_flip_mode     = 0;
int           g_game_key      = 0;
int           g_prev_key      = 0;
PlatSurface   g_imgMap;
PlatSurface   g_tmp_imgMap;
PlatSurface   g_imgMap2[9];
PlatSurface  *g_cur_target    = nullptr;
PlatImage     g_images[MAX_IMAGES];
PlatAudio     g_audio[MAX_AUDIO];
FILE         *g_sp_file       = nullptr;
unsigned char *g_sp_data      = nullptr;
long          g_sp_size       = 0;
unsigned char *g_jar_data     = nullptr;
long          g_jar_size      = 0;

/* WndClass name */
static const wchar_t *WND_CLASS = L"PoNPCPort";

/* Forward declare WndProc */
static LRESULT CALLBACK WndProc(HWND hw, UINT msg, WPARAM wp, LPARAM lp);

/* Key mapping: maps VK codes to game key bits */
/* Game uses processEvent(0, keycode) where keycode bit positions:
   bit0=1 (VK_LEFT?), etc.
   From Java: key = 1 << n2
   Phone keypad: 0=softleft,1=up,2=softright,3=left,4=center,5=right,
                 6=#,7=down,8=*,9=0,10=1..19=9 etc.
   High bits: Up=65536(2^16), Down=262144(2^18), Left=2048(2^11), Right=512(2^9),
              Fire=1048576(2^20)
*/
#define KEY_UP       0x00010000   /* 2^16 */
#define KEY_DOWN     0x00040000   /* 2^18 */
#define KEY_LEFT     0x00000800   /* 2^11 */
#define KEY_RIGHT    0x00000200   /* 2^9  */
#define KEY_FIRE     0x00100000   /* 2^20 - center key / fire */
#define KEY_SOFTL    0x00000001   /* soft key left */
#define KEY_SOFTR    0x00000004   /* soft key right */

/* ---- Window procedure -------------------------------------------------- */
static LRESULT CALLBACK WndProc(HWND hw, UINT msg, WPARAM wp, LPARAM lp)
{
    switch (msg) {
    case WM_DESTROY:
        PostQuitMessage(0);
        return 0;
    case WM_PAINT: {
        PAINTSTRUCT ps;
        HDC hdc = BeginPaint(hw, &ps);
        if (g_hdc_mem) {
            StretchBlt(hdc, 0, 0, WINDOW_W, WINDOW_H,
                       g_hdc_mem, 0, 0, SCREEN_W, SCREEN_H, SRCCOPY);
        }
        EndPaint(hw, &ps);
        return 0;
    }
    case WM_KEYDOWN:
    case WM_SYSKEYDOWN: {
        switch (wp) {
        case VK_UP:     g_game_key |= KEY_UP;    break;
        case VK_DOWN:   g_game_key |= KEY_DOWN;  break;
        case VK_LEFT:   g_game_key |= KEY_LEFT;  break;
        case VK_RIGHT:  g_game_key |= KEY_RIGHT; break;
        case VK_RETURN:
        case VK_SPACE:  g_game_key |= KEY_FIRE;  break;
        case 'Z':       g_game_key |= KEY_FIRE;  break;
        case 'X':       g_game_key |= KEY_SOFTL; break;
        case 'C':       g_game_key |= KEY_SOFTR; break;
        case VK_ESCAPE: PostQuitMessage(0);       break;
        }
        return 0;
    }
    case WM_KEYUP:
    case WM_SYSKEYUP: {
        switch (wp) {
        case VK_UP:     g_game_key &= ~KEY_UP;    break;
        case VK_DOWN:   g_game_key &= ~KEY_DOWN;  break;
        case VK_LEFT:   g_game_key &= ~KEY_LEFT;  break;
        case VK_RIGHT:  g_game_key &= ~KEY_RIGHT; break;
        case VK_RETURN:
        case VK_SPACE:  g_game_key &= ~KEY_FIRE;  break;
        case 'Z':       g_game_key &= ~KEY_FIRE;  break;
        case 'X':       g_game_key &= ~KEY_SOFTL; break;
        case 'C':       g_game_key &= ~KEY_SOFTR; break;
        }
        return 0;
    }
    case WM_CLOSE:
        PostQuitMessage(0);
        return 0;
    }
    return DefWindowProc(hw, msg, wp, lp);
}

/* ---- Init / Shutdown --------------------------------------------------- */
bool Platform_Init(HINSTANCE hInst, int nCmdShow)
{
    /* Register window class */
    WNDCLASSEX wc;
    memset(&wc, 0, sizeof(wc));
    wc.cbSize        = sizeof(wc);
    wc.style         = CS_HREDRAW | CS_VREDRAW;
    wc.lpfnWndProc   = WndProc;
    wc.hInstance     = hInst;
    wc.hCursor       = LoadCursor(nullptr, IDC_ARROW);
    wc.hbrBackground = (HBRUSH)GetStockObject(BLACK_BRUSH);
    wc.lpszClassName = WND_CLASS;
    wc.hIcon         = LoadIcon(nullptr, IDI_APPLICATION);
    if (!RegisterClassEx(&wc)) return false;

    /* Calculate window size with title bar / borders */
    RECT rc = {0, 0, WINDOW_W, WINDOW_H};
    AdjustWindowRect(&rc, WS_OVERLAPPED | WS_CAPTION | WS_SYSMENU | WS_MINIMIZEBOX, FALSE);

    g_hwnd = CreateWindowEx(0, WND_CLASS, L"P.o.N. PC Port",
        WS_OVERLAPPED | WS_CAPTION | WS_SYSMENU | WS_MINIMIZEBOX,
        CW_USEDEFAULT, CW_USEDEFAULT,
        rc.right - rc.left, rc.bottom - rc.top,
        nullptr, nullptr, hInst, nullptr);
    if (!g_hwnd) return false;

    /* Create off-screen DIBSection (240x240) */
    HDC hdc_screen = GetDC(g_hwnd);
    BITMAPINFO bmi;
    memset(&bmi, 0, sizeof(bmi));
    bmi.bmiHeader.biSize        = sizeof(BITMAPINFOHEADER);
    bmi.bmiHeader.biWidth       = SCREEN_W;
    bmi.bmiHeader.biHeight      = -SCREEN_H; /* top-down */
    bmi.bmiHeader.biPlanes      = 1;
    bmi.bmiHeader.biBitCount    = 32;
    bmi.bmiHeader.biCompression = BI_RGB;
    g_hbm_mem = CreateDIBSection(hdc_screen, &bmi, DIB_RGB_COLORS,
                                  (void**)&g_screen_pixels, nullptr, 0);
    g_hdc_mem = CreateCompatibleDC(hdc_screen);
    SelectObject(g_hdc_mem, g_hbm_mem);
    ReleaseDC(g_hwnd, hdc_screen);

    /* Create font (MS Gothic, 12px, suitable for Japanese) */
    g_font.hfont = CreateFont(12, 0, 0, 0, FW_NORMAL, FALSE, FALSE, FALSE,
                               SHIFTJIS_CHARSET, OUT_DEFAULT_PRECIS,
                               CLIP_DEFAULT_PRECIS, DEFAULT_QUALITY,
                               FIXED_PITCH | FF_MODERN, L"MS Gothic");
    g_font.height = 12;
    SelectObject(g_hdc_mem, g_font.hfont);
    SetBkMode(g_hdc_mem, TRANSPARENT);

    /* Init secondary surfaces */
    g_imgMap.pixels = new RGBQUAD[SCREEN_W * SCREEN_H];
    g_imgMap.w = SCREEN_W; g_imgMap.h = SCREEN_H;
    g_tmp_imgMap.pixels = new RGBQUAD[SCREEN_W * SCREEN_H];
    g_tmp_imgMap.w = SCREEN_W; g_tmp_imgMap.h = SCREEN_H;
    for (int i = 0; i < 9; i++) {
        int sh = (i >= 6) ? (SCREEN_H - 172) : SCREEN_H;
        if (sh < 1) sh = 1;
        g_imgMap2[i].pixels = new RGBQUAD[SCREEN_W * sh];
        g_imgMap2[i].w = SCREEN_W; g_imgMap2[i].h = sh;
    }

    /* Load data files */
    Platform_SP_Load();
    Platform_JAR_Load();

    timeBeginPeriod(1);

    ShowWindow(g_hwnd, nCmdShow);
    UpdateWindow(g_hwnd);
    return true;
}

void Platform_Shutdown()
{
    timeEndPeriod(1);
    if (g_font.hfont) { DeleteObject(g_font.hfont); g_font.hfont = nullptr; }
    if (g_hbm_mem)    { DeleteObject(g_hbm_mem);    g_hbm_mem = nullptr; }
    if (g_hdc_mem)    { DeleteDC(g_hdc_mem);         g_hdc_mem = nullptr; }
    delete[] g_imgMap.pixels;     g_imgMap.pixels = nullptr;
    delete[] g_tmp_imgMap.pixels; g_tmp_imgMap.pixels = nullptr;
    for (int i = 0; i < 9; i++) { delete[] g_imgMap2[i].pixels; g_imgMap2[i].pixels = nullptr; }
    delete[] g_sp_data;  g_sp_data = nullptr;
    delete[] g_jar_data; g_jar_data = nullptr;
    if (g_sp_file) { fclose(g_sp_file); g_sp_file = nullptr; }
}

bool Platform_PumpMessages()
{
    MSG msg;
    while (PeekMessage(&msg, nullptr, 0, 0, PM_REMOVE)) {
        if (msg.message == WM_QUIT) return false;
        TranslateMessage(&msg);
        DispatchMessage(&msg);
    }
    return true;
}

void Platform_Present()
{
    if (!g_hwnd || !g_hdc_mem) return;
    HDC hdc = GetDC(g_hwnd);
    StretchBlt(hdc, 0, 0, WINDOW_W, WINDOW_H,
               g_hdc_mem, 0, 0, SCREEN_W, SCREEN_H, SRCCOPY);
    ReleaseDC(g_hwnd, hdc);
}

/* ---- Graphics helpers -------------------------------------------------- */
static inline RGBQUAD *GetTargetPixels(int *out_w = nullptr, int *out_h = nullptr)
{
    if (g_cur_target) {
        if (out_w) *out_w = g_cur_target->w;
        if (out_h) *out_h = g_cur_target->h;
        return g_cur_target->pixels;
    }
    if (out_w) *out_w = SCREEN_W;
    if (out_h) *out_h = SCREEN_H;
    return g_screen_pixels;
}

void Platform_SetTarget(PlatSurface *surf)
{
    g_cur_target = surf;
    if (!surf && g_hdc_mem) {
        /* Sync screen pixels from DIB if needed */
    }
}

void Platform_SetColor(PlatColor c)
{
    g_cur_color = c;
    if (g_hdc_mem) {
        SetTextColor(g_hdc_mem, c);
    }
}

PlatColor Platform_MakeColor(int r, int g, int b)
{
    return RGB(r, g, b);  /* Windows RGB = 0x00BBGGRR */
}

void Platform_FillRect(int x, int y, int w, int h)
{
    if (w <= 0 || h <= 0) return;
    int tw, th;
    RGBQUAD *pix = GetTargetPixels(&tw, &th);
    if (!pix) return;

    RGBQUAD col;
    col.rgbRed   = GetRValue(g_cur_color);
    col.rgbGreen = GetGValue(g_cur_color);
    col.rgbBlue  = GetBValue(g_cur_color);
    col.rgbReserved = 0xFF;

    int x0 = x < 0 ? 0 : x;
    int y0 = y < 0 ? 0 : y;
    int x1 = x + w; if (x1 > tw) x1 = tw;
    int y1 = y + h; if (y1 > th) y1 = th;

    for (int py = y0; py < y1; py++) {
        RGBQUAD *row = pix + py * tw + x0;
        for (int px = x0; px < x1; px++) {
            *row++ = col;
        }
    }
}

void Platform_DrawLine(int x1, int y1, int x2, int y2)
{
    /* Bresenham's line */
    int tw, th;
    RGBQUAD *pix = GetTargetPixels(&tw, &th);
    if (!pix) return;
    RGBQUAD col;
    col.rgbRed   = GetRValue(g_cur_color);
    col.rgbGreen = GetGValue(g_cur_color);
    col.rgbBlue  = GetBValue(g_cur_color);
    col.rgbReserved = 0xFF;
    int dx = abs(x2-x1), dy = abs(y2-y1);
    int sx = x1 < x2 ? 1 : -1, sy = y1 < y2 ? 1 : -1;
    int err = dx - dy;
    while (true) {
        if (x1 >= 0 && x1 < tw && y1 >= 0 && y1 < th)
            pix[y1*tw+x1] = col;
        if (x1 == x2 && y1 == y2) break;
        int e2 = 2*err;
        if (e2 > -dy) { err -= dy; x1 += sx; }
        if (e2 <  dx) { err += dx; y1 += sy; }
    }
}

void Platform_DrawRect(int x, int y, int w, int h)
{
    Platform_DrawLine(x, y, x+w-1, y);
    Platform_DrawLine(x, y+h-1, x+w-1, y+h-1);
    Platform_DrawLine(x, y, x, y+h-1);
    Platform_DrawLine(x+w-1, y, x+w-1, y+h-1);
}

void Platform_SetFlipMode(int mode)
{
    g_flip_mode = mode;
}

void Platform_DrawImage(PlatImage *img, int dstX, int dstY,
                        int srcX, int srcY, int srcW, int srcH)
{
    if (!img || !img->pixels) return;
    if (srcW <= 0 || srcH <= 0) return;
    int tw, th;
    RGBQUAD *dst_pix = GetTargetPixels(&tw, &th);
    if (!dst_pix) return;

    int flipped = g_flip_mode;
    for (int py = 0; py < srcH; py++) {
        int dy = dstY + py;
        if (dy < 0 || dy >= th) continue;
        for (int px = 0; px < srcW; px++) {
            int dx = flipped ? (dstX + srcW - 1 - px) : (dstX + px);
            if (dx < 0 || dx >= tw) continue;
            int sx = srcX + px;
            int sy = srcY + py;
            if (sx < 0 || sx >= img->width || sy < 0 || sy >= img->height) continue;
            RGBQUAD src = img->pixels[sy * img->width + sx];
            if (src.rgbReserved == 0) continue; /* transparent */
            dst_pix[dy * tw + dx] = src;
        }
    }
}

void Platform_DrawImageTo(PlatSurface *dst, PlatImage *img,
                          int dstX, int dstY,
                          int srcX, int srcY, int srcW, int srcH)
{
    if (!dst || !img || !img->pixels) return;
    PlatSurface *old = g_cur_target;
    g_cur_target = dst;
    Platform_DrawImage(img, dstX, dstY, srcX, srcY, srcW, srcH);
    g_cur_target = old;
}

void Platform_DrawSurface(PlatSurface *src, int dstX, int dstY)
{
    if (!src || !src->pixels) return;
    int tw, th;
    RGBQUAD *dst_pix = GetTargetPixels(&tw, &th);
    if (!dst_pix) return;
    for (int py = 0; py < src->h; py++) {
        int dy = dstY + py;
        if (dy < 0 || dy >= th) continue;
        for (int px = 0; px < src->w; px++) {
            int dx = dstX + px;
            if (dx < 0 || dx >= tw) continue;
            dst_pix[dy*tw+dx] = src->pixels[py*src->w+px];
        }
    }
}

void Platform_DrawSurfaceRect(PlatSurface *src, int dstX, int dstY,
                              int srcX, int srcY, int srcW, int srcH)
{
    if (!src || !src->pixels) return;
    int tw, th;
    RGBQUAD *dst_pix = GetTargetPixels(&tw, &th);
    if (!dst_pix) return;
    for (int py = 0; py < srcH; py++) {
        int sy = srcY + py;
        if (sy < 0 || sy >= src->h) continue;
        int dy = dstY + py;
        if (dy < 0 || dy >= th) continue;
        for (int px = 0; px < srcW; px++) {
            int sx2 = srcX + px;
            if (sx2 < 0 || sx2 >= src->w) continue;
            int dx = dstX + px;
            if (dx < 0 || dx >= tw) continue;
            dst_pix[dy*tw+dx] = src->pixels[sy*src->w+sx2];
        }
    }
}

/* ---- Font & Text ------------------------------------------------------- */
void Platform_SetFont(int size)
{
    if (g_font.hfont) {
        DeleteObject(g_font.hfont);
        g_font.hfont = nullptr;
    }
    g_font.height = size;
    g_font.hfont = CreateFont(size, 0, 0, 0, FW_NORMAL, FALSE, FALSE, FALSE,
                               SHIFTJIS_CHARSET, OUT_DEFAULT_PRECIS,
                               CLIP_DEFAULT_PRECIS, DEFAULT_QUALITY,
                               FIXED_PITCH | FF_MODERN, L"MS Gothic");
    if (g_hdc_mem) {
        SelectObject(g_hdc_mem, g_font.hfont);
        SetBkMode(g_hdc_mem, TRANSPARENT);
    }
}

/* Convert UTF-8 to wide string for Win32 */
static std::wstring utf8_to_wide(const std::string &s)
{
    if (s.empty()) return L"";
    int n = MultiByteToWideChar(CP_UTF8, 0, s.c_str(), -1, nullptr, 0);
    if (n <= 0) {
        /* Try Shift-JIS */
        n = MultiByteToWideChar(932, 0, s.c_str(), -1, nullptr, 0);
        if (n <= 0) return std::wstring(s.begin(), s.end());
        std::wstring w(n, 0);
        MultiByteToWideChar(932, 0, s.c_str(), -1, &w[0], n);
        return w;
    }
    std::wstring w(n, 0);
    MultiByteToWideChar(CP_UTF8, 0, s.c_str(), -1, &w[0], n);
    return w;
}

int Platform_StringWidth(const std::string &s)
{
    if (!g_hdc_mem || s.empty()) return (int)s.size() * 6;
    std::wstring ws = utf8_to_wide(s);
    SIZE sz;
    GetTextExtentPoint32(g_hdc_mem, ws.c_str(), (int)ws.size() - 1, &sz);
    return sz.cx;
}

void Platform_DrawString(const std::string &s, int x, int y)
{
    if (!g_hdc_mem || s.empty()) return;

    /* If target is off-screen surface, we need manual text rendering */
    /* For simplicity, only draw to the main screen DC */
    if (!g_cur_target) {
        SelectObject(g_hdc_mem, g_font.hfont);
        SetTextColor(g_hdc_mem, g_cur_color);
        SetBkMode(g_hdc_mem, TRANSPARENT);
        std::wstring ws = utf8_to_wide(s);
        TextOut(g_hdc_mem, x, y - g_font.height, ws.c_str(), (int)ws.size() - 1);
    }
}

/* ---- Surfaces ---------------------------------------------------------- */
PlatSurface *Platform_CreateSurface(int w, int h)
{
    PlatSurface *s = new PlatSurface();
    s->w = w; s->h = h;
    s->pixels = new RGBQUAD[w * h];
    memset(s->pixels, 0, w * h * sizeof(RGBQUAD));
    return s;
}

void Platform_FreeSurface(PlatSurface *surf)
{
    if (surf) { delete[] surf->pixels; delete surf; }
}

/* ---- Images ------------------------------------------------------------ */

/* GIF decoder - minimal implementation */
struct GifDecoder {
    const unsigned char *data;
    int len;
    int pos;
    RGBQUAD gct[256]; /* global color table */
    int gct_size;
    int bg_color;
    int transparent_idx;

    GifDecoder(const unsigned char *d, int l)
        : data(d), len(l), pos(0), gct_size(0),
          bg_color(0), transparent_idx(-1) {}

    int read_byte() { return pos < len ? (unsigned char)data[pos++] : -1; }
    int read_word() {
        int lo = read_byte(), hi = read_byte();
        return lo | (hi << 8);
    }

    PlatImage *decode() {
        /* Check signature */
        if (pos + 6 > len) return nullptr;
        if (memcmp(data, "GIF87a", 6) && memcmp(data, "GIF89a", 6)) return nullptr;
        pos = 6;

        int lsd_w = read_word();
        int lsd_h = read_word();
        int flags = read_byte();
        bg_color  = read_byte();
        /* pixel aspect ratio */ read_byte();

        /* Global color table */
        if (flags & 0x80) {
            gct_size = 2 << (flags & 7);
            for (int i = 0; i < gct_size; i++) {
                gct[i].rgbRed   = (unsigned char)read_byte();
                gct[i].rgbGreen = (unsigned char)read_byte();
                gct[i].rgbBlue  = (unsigned char)read_byte();
                gct[i].rgbReserved = 0xFF;
            }
        }

        /* Parse blocks */
        while (pos < len) {
            int block = read_byte();
            if (block == 0x3B) break; /* GIF trailer */
            if (block == 0x21) {
                /* Extension */
                int ext = read_byte();
                if (ext == 0xF9) {
                    /* Graphic Control Extension */
                    read_byte(); /* block size */
                    int ef = read_byte();
                    read_word(); /* delay */
                    int ti = read_byte();
                    read_byte(); /* terminator */
                    if (ef & 1) transparent_idx = ti;
                } else {
                    /* Skip extension */
                    while (true) {
                        int sz = read_byte();
                        if (sz <= 0) break;
                        pos += sz;
                    }
                }
            } else if (block == 0x2C) {
                /* Image descriptor */
                int img_x = read_word();
                int img_y = read_word();
                int img_w = read_word();
                int img_h = read_word();
                int img_f = read_byte();
                (void)img_x; (void)img_y;

                RGBQUAD lct[256];
                RGBQUAD *ct = gct;
                int ct_size = gct_size;
                if (img_f & 0x80) {
                    ct_size = 2 << (img_f & 7);
                    for (int i = 0; i < ct_size; i++) {
                        lct[i].rgbRed   = (unsigned char)read_byte();
                        lct[i].rgbGreen = (unsigned char)read_byte();
                        lct[i].rgbBlue  = (unsigned char)read_byte();
                        lct[i].rgbReserved = 0xFF;
                    }
                    ct = lct;
                }

                /* Decode LZW */
                int min_code_size = read_byte();
                /* Collect all sub-blocks */
                std::vector<unsigned char> lzw_data;
                while (pos < len) {
                    int sz = read_byte();
                    if (sz == 0) break;
                    if (sz < 0) break;
                    for (int i = 0; i < sz && pos < len; i++)
                        lzw_data.push_back((unsigned char)read_byte());
                }

                /* LZW decode */
                std::vector<unsigned char> pixels;
                pixels.resize(img_w * img_h, (unsigned char)bg_color);
                lzw_decode(lzw_data, min_code_size, pixels);

                /* Create image */
                PlatImage *img = new PlatImage();
                img->width = img_w;
                img->height = img_h;
                img->pixels = new RGBQUAD[img_w * img_h];
                img->owns_pixels = true;
                for (int i = 0; i < img_w * img_h; i++) {
                    int idx = (int)(unsigned char)pixels[i];
                    if (idx == transparent_idx) {
                        img->pixels[i] = {0, 0, 0, 0}; /* transparent */
                    } else if (idx < ct_size) {
                        img->pixels[i] = ct[idx];
                        img->pixels[i].rgbReserved = 0xFF;
                    } else {
                        img->pixels[i] = {0, 0, 0, 0xFF};
                    }
                }
                return img;
            }
        }
        return nullptr;
    }

    void lzw_decode(const std::vector<unsigned char> &src, int min_code_size,
                    std::vector<unsigned char> &out)
    {
        if (src.empty()) return;
        int clear_code = 1 << min_code_size;
        int eoi_code   = clear_code + 1;
        int code_size  = min_code_size + 1;
        int next_code  = eoi_code + 1;

        /* Code table: each entry is a string (stored as chain) */
        struct Entry { int prefix; int suffix; };
        std::vector<Entry> table(4096);
        for (int i = 0; i < 256; i++) { table[i].prefix = -1; table[i].suffix = i; }

        int bit_pos = 0;
        int total_bits = (int)src.size() * 8;
        auto read_code = [&]() -> int {
            if (bit_pos + code_size > total_bits) return -1;
            int val = 0;
            for (int b = 0; b < code_size; b++) {
                int byte_idx = (bit_pos + b) / 8;
                int bit_idx  = (bit_pos + b) % 8;
                if ((src[byte_idx] >> bit_idx) & 1) val |= (1 << b);
            }
            bit_pos += code_size;
            return val;
        };

        /* Reset table */
        auto reset_table = [&]() {
            code_size = min_code_size + 1;
            next_code = eoi_code + 1;
        };

        /* Decode string for code c */
        std::vector<unsigned char> str_buf;
        auto decode_str = [&](int c) {
            str_buf.clear();
            while (c >= 0) {
                str_buf.push_back((unsigned char)table[c].suffix);
                c = table[c].prefix;
            }
            /* reverse */
            int lo = 0, hi = (int)str_buf.size()-1;
            while (lo < hi) { unsigned char t = str_buf[lo]; str_buf[lo]=str_buf[hi]; str_buf[hi]=t; lo++; hi--; }
        };

        int prev = -1;
        int code;
        while ((code = read_code()) >= 0) {
            if (code == clear_code) {
                reset_table();
                prev = -1;
                continue;
            }
            if (code == eoi_code) break;
            if (code >= next_code + 1) break; /* error */

            int str_code = code;
            if (code == next_code) {
                /* Special case: code not yet in table */
                if (prev < 0) break;
                decode_str(prev);
                str_buf.push_back(str_buf[0]);
                /* don't re-decode */
            } else {
                decode_str(code);
            }
            for (unsigned char b : str_buf) out.push_back(b);

            if (prev >= 0 && next_code < 4096) {
                int first_pixel = str_buf[0];
                table[next_code].prefix = prev;
                table[next_code].suffix = first_pixel;
                next_code++;
                if (next_code == (1 << code_size) && code_size < 12)
                    code_size++;
            }
            prev = str_code;
        }
    }
};

PlatImage *Platform_DecodeGIF(const unsigned char *data, int len)
{
    GifDecoder dec(data, len);
    return dec.decode();
}

PlatImage *Platform_CreatePalettedImage(const unsigned char *data, int len)
{
    if (!data || len < 6) return nullptr;
    /* Try GIF */
    if (data[0]=='G' && data[1]=='I' && data[2]=='F') {
        return Platform_DecodeGIF(data, len);
    }
    /* Fallback: create placeholder */
    PlatImage *img = new PlatImage();
    img->width = 32; img->height = 32;
    img->pixels = new RGBQUAD[32*32];
    img->owns_pixels = true;
    memset(img->pixels, 0, 32*32*sizeof(RGBQUAD));
    return img;
}

PlatImage *Platform_CreateImage(int w, int h)
{
    PlatImage *img = new PlatImage();
    img->width = w; img->height = h;
    img->pixels = new RGBQUAD[w * h];
    img->owns_pixels = true;
    memset(img->pixels, 0, w * h * sizeof(RGBQUAD));
    return img;
}

PlatPalette *Platform_GetPalette(PlatImage *img)
{
    /* Return a palette constructed from image (simplified) */
    PlatPalette *pal = new PlatPalette();
    pal->count = 0;
    return pal;
}

void Platform_SetPaletteColors(PlatImage *img, PlatPalette *pal,
                               int start, int count,
                               const unsigned char *rgb)
{
    if (!pal || !rgb) return;
    for (int i = 0; i < count; i++) {
        int idx = start + i;
        if (idx >= 256) break;
        pal->colors[idx].rgbRed   = rgb[i*3+0];
        pal->colors[idx].rgbGreen = rgb[i*3+1];
        pal->colors[idx].rgbBlue  = rgb[i*3+2];
        pal->colors[idx].rgbReserved = 0xFF;
    }
}

void Platform_FreeImage(PlatImage *img)
{
    delete img;
}

/* ---- Audio ------------------------------------------------------------- */
PlatAudio *Platform_GetAudioPresenter(int type)
{
    /* Find free slot */
    for (int i = 0; i < MAX_AUDIO; i++) {
        if (!g_audio[i].wave_data && !g_audio[i].midi_data) {
            g_audio[i].type = type;
            return &g_audio[i];
        }
    }
    return &g_audio[0]; /* fallback */
}

PlatSound *Platform_CreateSound(const unsigned char *data, int len)
{
    if (!data || len < 4) return nullptr;
    PlatSound *s = new PlatSound();
    s->data = new unsigned char[len];
    memcpy(s->data, data, len);
    s->size = (DWORD)len;
    /* Detect format */
    if (data[0]=='R' && data[1]=='I' && data[2]=='F' && data[3]=='F') s->format = 1; /* WAVE */
    else if (data[0]=='M' && data[1]=='M' && data[2]=='M' && data[3]=='D') s->format = 2; /* SMAF */
    else s->format = 0;
    return s;
}

void Platform_SetSound(PlatAudio *a, PlatSound *s)
{
    if (!a || !s) return;
    a->type = (s->format == 1) ? 1 : 0;
    if (s->format == 1) {
        a->wave_data = s->data;
        a->wave_size = s->size;
    } else {
        a->midi_data = s->data;
        a->midi_size = s->size;
    }
}

void Platform_SetVolume(PlatAudio *a, int vol_percent)
{
    /* Not implemented in this version */
    (void)a; (void)vol_percent;
}

void Platform_AudioPlay(PlatAudio *a)
{
    if (!a) return;
    /* For waveOut (type=1, PCM/WAVE) */
    if (a->type == 1 && a->wave_data && a->wave_size > 44) {
        /* Play using PlaySound (simple) or waveOut */
        /* Using PlaySound with SND_MEMORY */
        PlaySoundA((LPCSTR)a->wave_data, nullptr,
                   SND_MEMORY | SND_ASYNC | SND_LOOP);
        a->playing = true;
    }
    /* BGM (SMAF/MIDI): not implemented in basic version */
}

void Platform_AudioStop(PlatAudio *a)
{
    if (!a) return;
    if (a->playing) {
        if (a->type == 1) PlaySoundA(nullptr, nullptr, 0);
        a->playing = false;
    }
}

int Platform_AudioGetTime(PlatAudio *a)
{
    if (!a || !a->playing) return 0;
    return a->playing ? 1 : 0;
}

void Platform_FreeAudio(PlatAudio *a)
{
    if (!a) return;
    Platform_AudioStop(a);
    a->wave_data = nullptr;
    a->midi_data = nullptr;
}

void Platform_FreeSound(PlatSound *s)
{
    delete s;
}

/* ---- Scratchpad I/O ---------------------------------------------------- */
bool Platform_SP_Load()
{
    /* Look for PoN.sp in current directory and parent directories */
    const char *paths[] = {
        "PoN.sp", ".\\PoN.sp", "..\\PoN.sp",
        nullptr
    };
    for (int i = 0; paths[i]; i++) {
        FILE *f = nullptr;
        fopen_s(&f, paths[i], "rb");
        if (!f) continue;
        fseek(f, 0, SEEK_END);
        g_sp_size = ftell(f);
        fseek(f, 0, SEEK_SET);
        g_sp_data = new unsigned char[(size_t)g_sp_size];
        fread(g_sp_data, 1, (size_t)g_sp_size, f);
        fclose(f);
        fopen_s(&g_sp_file, paths[i], "r+b");
        if (!g_sp_file) fopen_s(&g_sp_file, paths[i], "rb");
        return true;
    }
    return false;
}

InputStream *Platform_SP_OpenRead(int pos, int len)
{
    if (!g_sp_data) return new InputStream();
    if (pos < 0 || len <= 0 || pos + len > g_sp_size) {
        /* Return empty stream */
        return new InputStream(g_sp_data, 0);
    }
    return new InputStream(g_sp_data + pos, len);
}

int Platform_SP_Write(int pos, const unsigned char *data, int len)
{
    if (!g_sp_data || pos < 0 || len <= 0) return -1;
    long end = (long)pos + len;
    if (end > g_sp_size) {
        /* Reallocate */
        unsigned char *new_data = new unsigned char[(size_t)end];
        memcpy(new_data, g_sp_data, (size_t)g_sp_size);
        memset(new_data + g_sp_size, 0, (size_t)(end - g_sp_size));
        delete[] g_sp_data;
        g_sp_data = new_data;
        g_sp_size = end;
    }
    memcpy(g_sp_data + pos, data, (size_t)len);
    /* Also write to file */
    if (g_sp_file) {
        fseek(g_sp_file, pos, SEEK_SET);
        fwrite(data, 1, (size_t)len, g_sp_file);
        fflush(g_sp_file);
    }
    return len;
}

/* ---- JAR / Resource I/O ----------------------------------------------- */

/* Minimal ZIP reader */
struct ZipEntry {
    std::string name;
    int compressed_size;
    int uncompressed_size;
    int compression;
    int offset;  /* local header offset */
    int data_offset; /* actual data offset */
};

static std::vector<ZipEntry> g_jar_entries;

static bool ParseZIP(const unsigned char *data, long size)
{
    if (!data || size < 22) return false;
    /* Find End of Central Directory record */
    long eocd_pos = -1;
    for (long i = size - 22; i >= 0; i--) {
        if (data[i]=='P' && data[i+1]=='K' && data[i+2]==5 && data[i+3]==6) {
            eocd_pos = i;
            break;
        }
    }
    if (eocd_pos < 0) return false;

    long cd_offset = (long)(data[eocd_pos+16] | (data[eocd_pos+17]<<8) |
                            (data[eocd_pos+18]<<16) | (data[eocd_pos+19]<<24));
    int num_entries = data[eocd_pos+8] | (data[eocd_pos+9]<<8);

    long pos = cd_offset;
    for (int i = 0; i < num_entries && pos + 46 <= size; i++) {
        if (data[pos]!='P' || data[pos+1]!='K' || data[pos+2]!=1 || data[pos+3]!=2) break;
        int compression = data[pos+10] | (data[pos+11]<<8);
        int comp_size   = (int)(data[pos+20] | (data[pos+21]<<8) | (data[pos+22]<<16) | (data[pos+23]<<24));
        int uncomp_size = (int)(data[pos+24] | (data[pos+25]<<8) | (data[pos+26]<<16) | (data[pos+27]<<24));
        int name_len    = data[pos+28] | (data[pos+29]<<8);
        int extra_len   = data[pos+30] | (data[pos+31]<<8);
        int comment_len = data[pos+32] | (data[pos+33]<<8);
        int local_hdr   = (int)(data[pos+42] | (data[pos+43]<<8) | (data[pos+44]<<16) | (data[pos+45]<<24));

        std::string name((const char*)data + pos + 46, name_len);

        /* Find data offset in local header */
        int data_off = 0;
        if (local_hdr + 30 <= size) {
            int lname_len  = data[local_hdr+26] | (data[local_hdr+27]<<8);
            int lextra_len = data[local_hdr+28] | (data[local_hdr+29]<<8);
            data_off = local_hdr + 30 + lname_len + lextra_len;
        }

        ZipEntry e;
        e.name             = name;
        e.compression      = compression;
        e.compressed_size  = comp_size;
        e.uncompressed_size= uncomp_size;
        e.offset           = local_hdr;
        e.data_offset      = data_off;
        g_jar_entries.push_back(e);

        pos += 46 + name_len + extra_len + comment_len;
    }
    return !g_jar_entries.empty();
}

bool Platform_JAR_Load()
{
    const char *paths[] = {"PoN.jar", ".\\PoN.jar", "..\\PoN.jar", nullptr};
    for (int i = 0; paths[i]; i++) {
        FILE *f = nullptr;
        fopen_s(&f, paths[i], "rb");
        if (!f) continue;
        fseek(f, 0, SEEK_END);
        g_jar_size = ftell(f);
        fseek(f, 0, SEEK_SET);
        g_jar_data = new unsigned char[(size_t)g_jar_size];
        fread(g_jar_data, 1, (size_t)g_jar_size, f);
        fclose(f);
        ParseZIP(g_jar_data, g_jar_size);
        return true;
    }
    return false;
}

static const ZipEntry *FindEntry(const std::string &name)
{
    for (const auto &e : g_jar_entries) {
        if (e.name == name) return &e;
    }
    return nullptr;
}

static unsigned char *ExtractEntry(const ZipEntry &e, const unsigned char *zip_data, int *out_size)
{
    const unsigned char *src = zip_data + e.data_offset;
    int out_len = e.uncompressed_size;
    if (out_len < 0) out_len = e.compressed_size * 4;
    unsigned char *out = new unsigned char[out_len + 1];
    if (e.compression == 0) {
        /* Store (uncompressed) */
        memcpy(out, src, e.compressed_size);
        out[e.compressed_size] = 0;
        if (out_size) *out_size = e.compressed_size;
    } else if (e.compression == 8) {
        /* Deflate */
        unsigned long dest_len = (unsigned long)out_len;
        unsigned long src_len  = (unsigned long)e.compressed_size;
        int r = puff(out, &dest_len, src, &src_len);
        if (r != 0) { delete[] out; return nullptr; }
        out[(int)dest_len] = 0;
        if (out_size) *out_size = (int)dest_len;
    } else {
        delete[] out;
        return nullptr;
    }
    return out;
}

InputStream *Platform_JAR_OpenResource(const char *path)
{
    if (!g_jar_data) return new InputStream();
    /* Strip "resource:///" prefix */
    const char *name = path;
    if (strncmp(name, "resource:///", 12) == 0) name += 12;
    const ZipEntry *e = FindEntry(name);
    if (!e) return new InputStream();
    int sz = 0;
    unsigned char *data = ExtractEntry(*e, g_jar_data, &sz);
    if (!data) return new InputStream();
    return new InputStream(data, sz, true);
}

unsigned char *Platform_JAR_Inflate(const unsigned char *data, int len, int *out_size)
{
    if (!data || len < 4) { if (out_size) *out_size = 0; return nullptr; }
    /* Try to parse as ZIP in memory */
    if (data[0]=='P' && data[1]=='K') {
        /* It's a mini-ZIP */
        std::vector<ZipEntry> entries;
        long pos = 0;
        /* Scan for local file headers */
        while (pos + 30 <= len) {
            if (data[pos]=='P' && data[pos+1]=='K' && data[pos+2]==3 && data[pos+3]==4) {
                int compression = data[pos+8] | (data[pos+9]<<8);
                int comp_size   = (int)(data[pos+18] | (data[pos+19]<<8) | (data[pos+20]<<16) | (data[pos+21]<<24));
                int uncomp_size = (int)(data[pos+22] | (data[pos+23]<<8) | (data[pos+24]<<16) | (data[pos+25]<<24));
                int name_len    = data[pos+26] | (data[pos+27]<<8);
                int extra_len   = data[pos+28] | (data[pos+29]<<8);
                std::string name((const char*)data + pos + 30, name_len);
                int data_off = (int)pos + 30 + name_len + extra_len;
                ZipEntry e;
                e.name = name; e.compression = compression;
                e.compressed_size = comp_size; e.uncompressed_size = uncomp_size;
                e.offset = (int)pos; e.data_offset = data_off;
                entries.push_back(e);
                pos = data_off + comp_size;
            } else pos++;
        }
        for (const auto &e : entries) {
            if (e.name == "data.dat") {
                int sz = 0;
                unsigned char *out = ExtractEntry(e, data, &sz);
                if (out_size) *out_size = sz;
                return out;
            }
        }
    }
    if (out_size) *out_size = 0;
    return nullptr;
}

/* ---- Timing ------------------------------------------------------------ */
long long Platform_CurrentTimeMillis()
{
    return (long long)timeGetTime();
}

void Platform_Sleep(int ms)
{
    Sleep((DWORD)ms);
}

int Platform_GetKey()
{
    return g_game_key;
}
