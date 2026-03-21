#include "Graphics.h"
#include "Image.h"
#include "Font.h"
#include <algorithm>

// ── Static storage ─────────────────────────────────────────────────────────
HWND    Graphics::s_hwnd      = nullptr;
HBITMAP Graphics::s_lastFrame = nullptr;

// ── Helpers ────────────────────────────────────────────────────────────────
static std::wstring toWide(const std::string& s) {
    if (s.empty()) return {};
    int n = MultiByteToWideChar(CP_UTF8, 0, s.c_str(), -1, nullptr, 0);
    std::wstring w(n, L'\0');
    MultiByteToWideChar(CP_UTF8, 0, s.c_str(), -1, &w[0], n);
    return w;
}

// ── Constructors / destructor ──────────────────────────────────────────────
Graphics::Graphics(HWND hwnd) {
    s_hwnd      = hwnd;
    ownsBitmap  = true;
    bitmap      = new Gdiplus::Bitmap(SCREEN_W, SCREEN_H, PixelFormat32bppARGB);
    gfx         = new Gdiplus::Graphics(bitmap);
    gfx->SetSmoothingMode(Gdiplus::SmoothingModeNone);
    gfx->SetTextRenderingHint(Gdiplus::TextRenderingHintSingleBitPerPixelGridFit);
}

Graphics::Graphics(Gdiplus::Bitmap* bmp) {
    ownsBitmap = false;
    bitmap     = bmp;
    gfx        = new Gdiplus::Graphics(bmp);
    gfx->SetSmoothingMode(Gdiplus::SmoothingModeNone);
    gfx->SetTextRenderingHint(Gdiplus::TextRenderingHintSingleBitPerPixelGridFit);
}

Graphics::~Graphics() {
    delete gfx; gfx = nullptr;
    if (ownsBitmap) { delete bitmap; bitmap = nullptr; }
}

// ── applyOrigin ────────────────────────────────────────────────────────────
void Graphics::applyOrigin(Gdiplus::REAL& x, Gdiplus::REAL& y) const {
    x += (Gdiplus::REAL)originX;
    y += (Gdiplus::REAL)originY;
}

// ── Color ──────────────────────────────────────────────────────────────────
int Graphics::getColorOfRGB(int r, int g, int b) {
    return ((r & 0xFF) << 16) | ((g & 0xFF) << 8) | (b & 0xFF);
}

void Graphics::setColor(int rgb) {
    int r = (rgb >> 16) & 0xFF;
    int g = (rgb >>  8) & 0xFF;
    int b =  rgb        & 0xFF;
    color = Gdiplus::Color::MakeARGB(255, (BYTE)r, (BYTE)g, (BYTE)b);
}

// ── Shapes ─────────────────────────────────────────────────────────────────
void Graphics::fillRect(int x, int y, int w, int h) {
    Gdiplus::REAL fx = (Gdiplus::REAL)x, fy = (Gdiplus::REAL)y;
    applyOrigin(fx, fy);
    Gdiplus::SolidBrush br(color);
    gfx->FillRectangle(&br, fx, fy, (Gdiplus::REAL)w, (Gdiplus::REAL)h);
}

void Graphics::drawRect(int x, int y, int w, int h) {
    Gdiplus::REAL fx = (Gdiplus::REAL)x, fy = (Gdiplus::REAL)y;
    applyOrigin(fx, fy);
    Gdiplus::Pen pen(color, 1.0f);
    gfx->DrawRectangle(&pen, fx, fy, (Gdiplus::REAL)w, (Gdiplus::REAL)h);
}

void Graphics::drawLine(int x1, int y1, int x2, int y2) {
    Gdiplus::REAL fx1 = (Gdiplus::REAL)x1, fy1 = (Gdiplus::REAL)y1;
    Gdiplus::REAL fx2 = (Gdiplus::REAL)x2, fy2 = (Gdiplus::REAL)y2;
    applyOrigin(fx1, fy1);
    applyOrigin(fx2, fy2);
    Gdiplus::Pen pen(color, 1.0f);
    gfx->DrawLine(&pen, fx1, fy1, fx2, fy2);
}

void Graphics::fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
    Gdiplus::REAL fx1 = (Gdiplus::REAL)x1, fy1 = (Gdiplus::REAL)y1;
    Gdiplus::REAL fx2 = (Gdiplus::REAL)x2, fy2 = (Gdiplus::REAL)y2;
    Gdiplus::REAL fx3 = (Gdiplus::REAL)x3, fy3 = (Gdiplus::REAL)y3;
    applyOrigin(fx1, fy1); applyOrigin(fx2, fy2); applyOrigin(fx3, fy3);
    Gdiplus::PointF pts[3] = {
        { fx1, fy1 }, { fx2, fy2 }, { fx3, fy3 }
    };
    Gdiplus::SolidBrush br(color);
    gfx->FillPolygon(&br, pts, 3);
}

// ── Images ─────────────────────────────────────────────────────────────────
void Graphics::drawImage(Image* img, int x, int y) {
    if (!img || !img->bitmap) return;
    Gdiplus::REAL fx = (Gdiplus::REAL)x, fy = (Gdiplus::REAL)y;
    applyOrigin(fx, fy);
    gfx->DrawImage(img->bitmap, fx, fy,
                   (Gdiplus::REAL)img->width, (Gdiplus::REAL)img->height);
}

void Graphics::drawImage(Image* img, int x, int y, int anchor) {
    if (!img || !img->bitmap) return;
    Gdiplus::REAL fx = (Gdiplus::REAL)x, fy = (Gdiplus::REAL)y;
    if (anchor & GFX_HCENTER) fx -= img->width  / 2.0f;
    else if (anchor & GFX_RIGHT) fx -= (Gdiplus::REAL)img->width;
    if (anchor & GFX_VCENTER) fy -= img->height / 2.0f;
    else if (anchor & GFX_BOTTOM) fy -= (Gdiplus::REAL)img->height;
    applyOrigin(fx, fy);
    gfx->DrawImage(img->bitmap, fx, fy,
                   (Gdiplus::REAL)img->width, (Gdiplus::REAL)img->height);
}

void Graphics::drawImage(Image* img, int dx, int dy, int sx, int sy, int sw, int sh) {
    if (!img || !img->bitmap) return;
    Gdiplus::REAL fdx = (Gdiplus::REAL)dx, fdy = (Gdiplus::REAL)dy;
    applyOrigin(fdx, fdy);
    Gdiplus::RectF dst(fdx, fdy, (Gdiplus::REAL)sw, (Gdiplus::REAL)sh);
    gfx->DrawImage(img->bitmap, dst,
                   (Gdiplus::REAL)sx, (Gdiplus::REAL)sy,
                   (Gdiplus::REAL)sw, (Gdiplus::REAL)sh,
                   Gdiplus::UnitPixel);
}

// ── Text ───────────────────────────────────────────────────────────────────
void Graphics::setFont(Font* f) { currentFont = f; }

void Graphics::drawString(const std::string& s, int x, int y) {
    if (s.empty() || !currentFont || !currentFont->gdipFont) return;
    Gdiplus::REAL fx = (Gdiplus::REAL)x, fy = (Gdiplus::REAL)y;
    applyOrigin(fx, fy);
    std::wstring ws = toWide(s);
    Gdiplus::SolidBrush br(color);
    Gdiplus::StringFormat fmt;
    fmt.SetAlignment(Gdiplus::StringAlignmentNear);
    fmt.SetLineAlignment(Gdiplus::StringAlignmentNear);
    fmt.SetFormatFlags(Gdiplus::StringFormatFlagsNoWrap);
    gfx->DrawString(ws.c_str(), -1, currentFont->gdipFont,
                    Gdiplus::PointF(fx, fy), &fmt, &br);
}

void Graphics::drawString(const std::string& s, int x, int y, int anchor) {
    if (s.empty() || !currentFont || !currentFont->gdipFont) return;
    int sw = stringWidth(s);
    int sh = getFontHeight();
    Gdiplus::REAL fx = (Gdiplus::REAL)x, fy = (Gdiplus::REAL)y;
    if (anchor & GFX_HCENTER) fx -= sw / 2.0f;
    else if (anchor & GFX_RIGHT) fx -= (Gdiplus::REAL)sw;
    if (anchor & GFX_VCENTER) fy -= sh / 2.0f;
    else if (anchor & GFX_BOTTOM) fy -= (Gdiplus::REAL)sh;
    applyOrigin(fx, fy);
    std::wstring ws = toWide(s);
    Gdiplus::SolidBrush br(color);
    Gdiplus::StringFormat fmt;
    fmt.SetFormatFlags(Gdiplus::StringFormatFlagsNoWrap);
    gfx->DrawString(ws.c_str(), -1, currentFont->gdipFont,
                    Gdiplus::PointF(fx, fy), &fmt, &br);
}

int Graphics::stringWidth(const std::string& s) {
    if (!currentFont || !currentFont->gdipFont) return (int)s.size() * 6;
    std::wstring ws = toWide(s);
    Gdiplus::StringFormat fmt;
    fmt.SetFormatFlags(Gdiplus::StringFormatFlagsNoWrap |
                       Gdiplus::StringFormatFlagsMeasureTrailingSpaces);
    Gdiplus::RectF bounds;
    gfx->MeasureString(ws.c_str(), -1, currentFont->gdipFont,
                       Gdiplus::PointF(0, 0), &fmt, &bounds);
    return (int)bounds.Width;
}

int Graphics::getFontHeight() {
    return currentFont ? currentFont->height : 11;
}

// ── Misc ───────────────────────────────────────────────────────────────────
void Graphics::lock()  {}
void Graphics::unlock(bool flush) { if (flush && ownsBitmap) present(); }

void Graphics::setOrigin(int x, int y) { originX = x; originY = y; }
void Graphics::translate(int dx, int dy) { originX += dx; originY += dy; }

void Graphics::copyArea(int sx, int sy, int sw, int sh, int dx, int dy, int /*anchor*/) {
    int ox = originX, oy = originY;
    Gdiplus::Bitmap* tmp = bitmap->Clone(
        (INT)(sx + ox), (INT)(sy + oy), (INT)sw, (INT)sh, PixelFormat32bppARGB);
    if (tmp) {
        gfx->DrawImage(tmp, (INT)(dx + ox), (INT)(dy + oy));
        delete tmp;
    }
}

// ── Present (blit backbuffer to the window) ────────────────────────────────
void Graphics::present() {
    if (!s_hwnd) return;

    // Convert GDI+ Bitmap to a GDI HBITMAP
    HBITMAP hbm = nullptr;
    bitmap->GetHBITMAP(Gdiplus::Color(0, 0, 0), &hbm);

    // Swap into s_lastFrame (delete old only after new one is obtained)
    HBITMAP old = s_lastFrame;
    s_lastFrame  = hbm;
    if (old) DeleteObject(old);

    if (!s_lastFrame) return;

    HDC hdc    = GetDC(s_hwnd);
    HDC memDC  = CreateCompatibleDC(hdc);
    HGDIOBJ prev = SelectObject(memDC, s_lastFrame);
    StretchBlt(hdc,
               0, 0, SCREEN_W * WINDOW_SCALE, SCREEN_H * WINDOW_SCALE,
               memDC,
               0, 0, SCREEN_W, SCREEN_H,
               SRCCOPY);
    SelectObject(memDC, prev);
    DeleteDC(memDC);
    ReleaseDC(s_hwnd, hdc);
}

// ── onPaint (WM_PAINT handler) ─────────────────────────────────────────────
void Graphics::onPaint(HWND /*hwnd*/, HDC hdc) {
    if (!s_lastFrame) return;
    HDC memDC  = CreateCompatibleDC(hdc);
    HGDIOBJ old = SelectObject(memDC, s_lastFrame);
    StretchBlt(hdc,
               0, 0, SCREEN_W * WINDOW_SCALE, SCREEN_H * WINDOW_SCALE,
               memDC,
               0, 0, SCREEN_W, SCREEN_H,
               SRCCOPY);
    SelectObject(memDC, old);
    DeleteDC(memDC);
}
