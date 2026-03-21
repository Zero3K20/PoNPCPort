#pragma once
#include "Platform.h"

class Image;
class Font;

// GDI+-backed replacement for com.nttdocomo.ui.Graphics
class Graphics {
public:
    Gdiplus::Bitmap*   bitmap  = nullptr;   // backing off-screen bitmap
    Gdiplus::Graphics* gfx     = nullptr;   // GDI+ graphics context on bitmap
    bool ownsBitmap = false;

    int originX = 0;
    int originY = 0;
    Gdiplus::ARGB color = 0xFF000000;       // current ARGB color
    Font* currentFont = nullptr;

    // Window-mode constructor: creates a 240×240 backbuffer; present() → HWND.
    explicit Graphics(HWND hwnd);
    // Off-screen constructor: wraps an existing Gdiplus::Bitmap (Image::getGraphics).
    explicit Graphics(Gdiplus::Bitmap* bmp);
    ~Graphics();

    // ── DoJa API ────────────────────────────────────────────────────────────
    static int  getColorOfRGB(int r, int g, int b);
    void        setColor(int rgb);
    void        fillRect(int x, int y, int w, int h);
    void        drawRect(int x, int y, int w, int h);
    void        drawLine(int x1, int y1, int x2, int y2);
    void        drawImage(Image* img, int x, int y);
    void        drawImage(Image* img, int x, int y, int anchor);
    void        drawImage(Image* img, int dx, int dy, int sx, int sy, int sw, int sh);
    void        setFont(Font* f);
    void        drawString(const std::string& s, int x, int y);
    void        drawString(const std::string& s, int x, int y, int anchor);
    int         stringWidth(const std::string& s);
    int         getFontHeight();
    void        lock();
    void        unlock(bool flush);
    void        setOrigin(int x, int y);
    void        translate(int dx, int dy);
    void        copyArea(int sx, int sy, int sw, int sh, int dx, int dy, int anchor);
    void        fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3);

    // Blit the backbuffer to the window (called by unlock(true) on the main target).
    void        present();

    // Called from WM_PAINT in the window procedure.
    static void onPaint(HWND hwnd, HDC hdc);

private:
    static HWND    s_hwnd;
    static HBITMAP s_lastFrame;   // GDI HBITMAP copy of last presented frame

    void applyOrigin(Gdiplus::REAL& x, Gdiplus::REAL& y) const;
};
