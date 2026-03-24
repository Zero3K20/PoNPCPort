#pragma once
/*
 * Platform.h - Win32 platform abstraction layer
 * Replaces com.nttdocomo.ui.* APIs for the PC port of P.o.N.
 */

#ifndef UNICODE
#define UNICODE
#endif
#define WIN32_LEAN_AND_MEAN
#define _WIN32_WINNT 0x0501   /* Windows XP / Server 2003 */
#include <windows.h>
#include <mmsystem.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <string>
#include <vector>

/* ---- Constants --------------------------------------------------------- */
#define SCREEN_W        240
#define SCREEN_H        240
#define SCALE           2       /* 2x pixel scaling to 480x480 */
#define WINDOW_W        (SCREEN_W * SCALE)
#define WINDOW_H        (SCREEN_H * SCALE)
#define MAX_IMAGES      64      /* PalettedImage slots */
#define MAX_AUDIO       32      /* AudioPresenter slots */

/* ---- Key bitmask constants (DoJa i-mode key mapping) ------------------- */
#define KEY_UP          0x0001  /* VK_UP */
#define KEY_DOWN        0x0002  /* VK_DOWN */
#define KEY_LEFT        0x0004  /* VK_LEFT */
#define KEY_RIGHT       0x0008  /* VK_RIGHT */
#define KEY_FIRE        0x0010  /* VK_RETURN / VK_SPACE / Z */
#define KEY_SOFTL       0x0020  /* Left soft key (X) */
#define KEY_SOFTR       0x0040  /* Right soft key (C) */

/* ---- Color type -------------------------------------------------------- */
typedef COLORREF PlatColor;   /* 0x00BBGGRR */

/* ---- Image type -------------------------------------------------------- */
struct PlatImage {
    int width;
    int height;
    RGBQUAD *pixels;          /* BGRA pixels, width*height */
    bool owns_pixels;

    PlatImage() : width(0), height(0), pixels(nullptr), owns_pixels(false) {}
    ~PlatImage() { if (owns_pixels && pixels) delete[] pixels; }
};

/* ---- Palette type ------------------------------------------------------ */
struct PlatPalette {
    RGBQUAD colors[256];
    int count;
    PlatPalette() : count(0) {}
};

/* ---- Font type --------------------------------------------------------- */
struct PlatFont {
    HFONT hfont;
    int height;
    PlatFont() : hfont(nullptr), height(12) {}
};

/* ---- Audio type -------------------------------------------------------- */
struct PlatAudio {
    int type;           /* 0=BGM(MIDI), 1=SE(WAVE) */
    bool playing;
    /* For waveOut (SE) */
    HWAVEOUT hwave;
    WAVEHDR  wavehdr;
    unsigned char *wave_data;
    DWORD    wave_size;
    /* For MIDI (BGM) */
    HMIDIOUT hmidi;
    unsigned char *midi_data;
    DWORD    midi_size;

    PlatAudio() : type(0), playing(false), hwave(nullptr),
                  wave_data(nullptr), wave_size(0),
                  hmidi(nullptr), midi_data(nullptr), midi_size(0)
    { memset(&wavehdr, 0, sizeof(wavehdr)); }
};

struct PlatSound {
    unsigned char *data;
    DWORD size;
    int format;         /* 0=unknown, 1=WAVE, 2=SMAF/MIDI */
    PlatSound() : data(nullptr), size(0), format(0) {}
    ~PlatSound() { delete[] data; }
};

/* ---- InputStream ------------------------------------------------------- */
class InputStream {
public:
    const unsigned char *buf;
    int len;
    int pos;
    bool owns;

    InputStream() : buf(nullptr), len(0), pos(0), owns(false) {}
    InputStream(const unsigned char *b, int l, bool take_ownership = false)
        : buf(b), len(l), pos(0), owns(take_ownership) {}
    ~InputStream() { if (owns) delete[] buf; }

    int read() {
        if (pos >= len) return -1;
        return (unsigned char)buf[pos++];
    }
    int read(unsigned char *dst, int n) {
        if (!dst || n <= 0) return 0;
        int avail = len - pos;
        if (n > avail) n = avail;
        if (n > 0) memcpy(dst, buf + pos, n);
        pos += n;
        return n;
    }
    int read(unsigned char *dst, int off, int n) {
        return read(dst + off, n);
    }
    void skip(long n) { pos += (int)n; if (pos > len) pos = len; }
    bool eof() const { return pos >= len; }
    void close() {}
};

/* ---- OutputStream ------------------------------------------------------ */
class OutputStream {
public:
    unsigned char *buf;
    int capacity;
    int len;
    bool owns;

    OutputStream(unsigned char *b, int cap, bool take_ownership = false)
        : buf(b), capacity(cap), len(0), owns(take_ownership) {}
    ~OutputStream() { if (owns) delete[] buf; }

    void write(const unsigned char *src, int n) {
        if (!src || n <= 0) return;
        int avail = capacity - len;
        if (n > avail) n = avail;
        if (n > 0) memcpy(buf + len, src, n);
        len += n;
    }
    void write(int b) {
        if (len < capacity) buf[len++] = (unsigned char)b;
    }
    void flush() {}
    void close() {}
};

/* ---- Global platform state --------------------------------------------- */
extern HWND         g_hwnd;
extern HDC          g_hdc_mem;       /* off-screen 240x240 DC */
extern HBITMAP      g_hbm_mem;       /* off-screen bitmap */
extern RGBQUAD     *g_screen_pixels; /* pointer to DIB pixel data (BGRA) */
extern HDC          g_hdc_win;       /* window DC (only during WM_PAINT) */
extern PlatFont     g_font;          /* current font */
extern PlatColor    g_cur_color;     /* current draw color */
extern int          g_flip_mode;     /* 0=normal, 1=flip-H */
extern int          g_game_key;      /* current key state bitmask */
extern int          g_prev_key;      /* previous frame key state */

/* Secondary surfaces (imgMap, imgMap2[], etc.) */
struct PlatSurface {
    RGBQUAD *pixels;
    int w, h;
    PlatSurface() : pixels(nullptr), w(0), h(0) {}
    ~PlatSurface() { delete[] pixels; }
};
extern PlatSurface  g_imgMap;
extern PlatSurface  g_tmp_imgMap;
extern PlatSurface  g_imgMap2[9];
extern PlatSurface *g_cur_target;    /* nullptr = screen, else off-screen */

/* Image slots */
extern PlatImage    g_images[MAX_IMAGES];

/* Audio slots */
extern PlatAudio    g_audio[MAX_AUDIO];

/* Scratchpad file */
extern FILE        *g_sp_file;
extern unsigned char *g_sp_data;
extern long         g_sp_size;

/* JAR file data */
extern unsigned char *g_jar_data;
extern long          g_jar_size;

/* ---- Platform function declarations ------------------------------------ */
/* Initialization */
bool Platform_Init(HINSTANCE hInst, int nCmdShow);
void Platform_Shutdown();
bool Platform_PumpMessages();     /* returns false when WM_QUIT */
void Platform_Present();          /* blit off-screen to window */

/* Graphics */
void Platform_SetTarget(PlatSurface *surf);  /* nullptr = screen */
void Platform_SetColor(PlatColor c);
PlatColor Platform_MakeColor(int r, int g, int b);
void Platform_FillRect(int x, int y, int w, int h);
void Platform_DrawLine(int x1, int y1, int x2, int y2);
void Platform_DrawRect(int x, int y, int w, int h);
void Platform_SetFlipMode(int mode);
void Platform_DrawImage(PlatImage *img, int dstX, int dstY,
                        int srcX, int srcY, int srcW, int srcH);
void Platform_DrawImageTo(PlatSurface *dst, PlatImage *img,
                          int dstX, int dstY, int srcX, int srcY, int srcW, int srcH);
void Platform_DrawSurface(PlatSurface *src, int dstX, int dstY);
void Platform_DrawSurfaceRect(PlatSurface *src,
                              int dstX, int dstY,
                              int srcX, int srcY, int srcW, int srcH);

/* Font & Text */
void Platform_SetFont(int size);
int  Platform_StringWidth(const std::string &s);
void Platform_DrawString(const std::string &s, int x, int y);

/* Surfaces */
PlatSurface *Platform_CreateSurface(int w, int h);
void         Platform_FreeSurface(PlatSurface *surf);

/* Images */
PlatImage *Platform_CreatePalettedImage(const unsigned char *data, int len);
PlatImage *Platform_CreateImage(int w, int h);
PlatPalette *Platform_GetPalette(PlatImage *img);
void         Platform_SetPaletteColors(PlatImage *img, PlatPalette *pal,
                                       int start, int count,
                                       const unsigned char *rgb);
void Platform_FreeImage(PlatImage *img);

/* Audio */
PlatAudio *Platform_GetAudioPresenter(int type);
PlatSound *Platform_CreateSound(const unsigned char *data, int len);
void       Platform_SetSound(PlatAudio *a, PlatSound *s);
void       Platform_SetVolume(PlatAudio *a, int vol_percent);
void       Platform_AudioPlay(PlatAudio *a);
void       Platform_AudioStop(PlatAudio *a);
int        Platform_AudioGetTime(PlatAudio *a);
void       Platform_FreeAudio(PlatAudio *a);
void       Platform_FreeSound(PlatSound *s);

/* Scratchpad I/O (maps to PoN.sp) */
bool       Platform_SP_Load();
InputStream *Platform_SP_OpenRead(int pos, int len);
int         Platform_SP_Write(int pos, const unsigned char *data, int len);

/* JAR / Resource I/O (maps to PoN.jar) */
bool       Platform_JAR_Load();
InputStream *Platform_JAR_OpenResource(const char *path);

/* ZIP/JAR block decompressor (JarInflater replacement) */
/* Returns allocated buffer with data.dat content; caller frees with delete[]. */
unsigned char *Platform_JAR_Inflate(const unsigned char *data, int len, int *out_size);

/* GIF decoder */
PlatImage *Platform_DecodeGIF(const unsigned char *data, int len);

/* Timer / Timing */
long long Platform_CurrentTimeMillis();
void      Platform_Sleep(int ms);

/* Input */
int  Platform_GetKey();   /* returns bitmask */
