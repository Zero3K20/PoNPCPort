#pragma once
#include "Platform.h"

class Image;
class Font;

// SDL2-backed replacement for com.nttdocomo.ui.Graphics
class Graphics {
public:
    SDL_Renderer* renderer = nullptr;
    SDL_Texture*  target   = nullptr;   // nullptr → default window target
    int originX = 0;
    int originY = 0;
    Uint8 cr = 0, cg = 0, cb = 0, ca = 255;
    Font* currentFont = nullptr;

    Graphics(SDL_Renderer* r, SDL_Texture* tgt = nullptr);

    // ── DoJa API ────────────────────────────────────────────────────────────
    static int  getColorOfRGB(int r, int g, int b);
    void        setColor(int rgb);
    void        fillRect(int x, int y, int w, int h);
    void        drawRect(int x, int y, int w, int h);
    void        drawLine(int x1, int y1, int x2, int y2);
    // Draw entire image at (x,y)
    void        drawImage(Image* img, int x, int y);
    // Draw entire image at (x,y) with anchor
    void        drawImage(Image* img, int x, int y, int anchor);
    // Draw sub-region (sx,sy,sw,sh) of img at (dx,dy)  [used by Tip::Draw etc.]
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

    // Flush the renderer (called by unlock(true) on the main target)
    void        present();

private:
    void applyOrigin(int& x, int& y) const;
    void setRT() const;
};
