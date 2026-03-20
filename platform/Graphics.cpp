#include "Graphics.h"
#include "Image.h"
#include "Font.h"
#include <algorithm>

Graphics::Graphics(SDL_Renderer* r, SDL_Texture* tgt)
    : renderer(r), target(tgt) {}

void Graphics::applyOrigin(int& x, int& y) const {
    x += originX;
    y += originY;
}

void Graphics::setRT() const {
    SDL_SetRenderTarget(renderer, target);
}

int Graphics::getColorOfRGB(int r, int g, int b) {
    return ((r & 0xFF) << 16) | ((g & 0xFF) << 8) | (b & 0xFF);
}

void Graphics::setColor(int rgb) {
    cr = (rgb >> 16) & 0xFF;
    cg = (rgb >>  8) & 0xFF;
    cb =  rgb        & 0xFF;
    ca = 255;
}

void Graphics::fillRect(int x, int y, int w, int h) {
    setRT();
    applyOrigin(x, y);
    SDL_SetRenderDrawColor(renderer, cr, cg, cb, ca);
    SDL_Rect r = {x, y, w, h};
    SDL_RenderFillRect(renderer, &r);
}

void Graphics::drawRect(int x, int y, int w, int h) {
    setRT();
    applyOrigin(x, y);
    SDL_SetRenderDrawColor(renderer, cr, cg, cb, ca);
    SDL_Rect r = {x, y, w, h};
    SDL_RenderDrawRect(renderer, &r);
}

void Graphics::drawLine(int x1, int y1, int x2, int y2) {
    setRT();
    applyOrigin(x1, y1);
    applyOrigin(x2, y2);
    SDL_SetRenderDrawColor(renderer, cr, cg, cb, ca);
    SDL_RenderDrawLine(renderer, x1, y1, x2, y2);
}

void Graphics::drawImage(Image* img, int x, int y) {
    if (!img || !img->texture) return;
    setRT();
    applyOrigin(x, y);
    SDL_Rect dst = {x, y, img->width, img->height};
    SDL_RenderCopy(renderer, img->texture, nullptr, &dst);
}

void Graphics::drawImage(Image* img, int x, int y, int anchor) {
    if (!img || !img->texture) return;
    int px = x, py = y;
    if (anchor & GFX_HCENTER) px -= img->width  / 2;
    else if (anchor & GFX_RIGHT)  px -= img->width;
    if (anchor & GFX_VCENTER) py -= img->height / 2;
    else if (anchor & GFX_BOTTOM) py -= img->height;
    setRT();
    applyOrigin(px, py);
    SDL_Rect dst = {px, py, img->width, img->height};
    SDL_RenderCopy(renderer, img->texture, nullptr, &dst);
}

void Graphics::drawImage(Image* img, int dx, int dy, int sx, int sy, int sw, int sh) {
    if (!img || !img->texture) return;
    setRT();
    applyOrigin(dx, dy);
    SDL_Rect src = {sx, sy, sw, sh};
    SDL_Rect dst = {dx, dy, sw, sh};
    SDL_RenderCopy(renderer, img->texture, &src, &dst);
}

void Graphics::setFont(Font* f) { currentFont = f; }

void Graphics::drawString(const std::string& s, int x, int y) {
    if (s.empty() || !currentFont || !currentFont->ttfFont) return;
    setRT();
    SDL_Color col = {cr, cg, cb, ca};
    SDL_Surface* surf = TTF_RenderUTF8_Blended(currentFont->ttfFont, s.c_str(), col);
    if (!surf) return;
    SDL_Texture* tex = SDL_CreateTextureFromSurface(renderer, surf);
    SDL_FreeSurface(surf);
    if (!tex) return;
    applyOrigin(x, y);
    int tw, th;
    SDL_QueryTexture(tex, nullptr, nullptr, &tw, &th);
    SDL_Rect dst = {x, y, tw, th};
    SDL_RenderCopy(renderer, tex, nullptr, &dst);
    SDL_DestroyTexture(tex);
}

void Graphics::drawString(const std::string& s, int x, int y, int anchor) {
    if (s.empty() || !currentFont || !currentFont->ttfFont) return;
    SDL_Color col = {cr, cg, cb, ca};
    SDL_Surface* surf = TTF_RenderUTF8_Blended(currentFont->ttfFont, s.c_str(), col);
    if (!surf) return;
    if (anchor & GFX_HCENTER) x -= surf->w / 2;
    else if (anchor & GFX_RIGHT)   x -= surf->w;
    if (anchor & GFX_VCENTER) y -= surf->h / 2;
    else if (anchor & GFX_BOTTOM)  y -= surf->h;
    SDL_Texture* tex = SDL_CreateTextureFromSurface(renderer, surf);
    SDL_FreeSurface(surf);
    if (!tex) return;
    applyOrigin(x, y);
    int tw, th;
    SDL_QueryTexture(tex, nullptr, nullptr, &tw, &th);
    SDL_Rect dst = {x, y, tw, th};
    SDL_RenderCopy(renderer, tex, nullptr, &dst);
    SDL_DestroyTexture(tex);
}

int Graphics::stringWidth(const std::string& s) {
    if (!currentFont || !currentFont->ttfFont) return (int)s.size() * 6;
    int w = 0, h = 0;
    TTF_SizeUTF8(currentFont->ttfFont, s.c_str(), &w, &h);
    return w;
}

int Graphics::getFontHeight() {
    return currentFont ? currentFont->height : 12;
}

void Graphics::lock() { setRT(); }

void Graphics::unlock(bool flush) {
    if (flush && target == nullptr) present();
}

void Graphics::present() {
    SDL_RenderPresent(renderer);
}

void Graphics::setOrigin(int x, int y) { originX = x; originY = y; }
void Graphics::translate(int dx, int dy) { originX += dx; originY += dy; }

void Graphics::copyArea(int sx, int sy, int sw, int sh, int dx, int dy, int /*anchor*/) {
    setRT();
    SDL_Rect srcR = {sx + originX, sy + originY, sw, sh};
    SDL_Rect dstR = {dx + originX, dy + originY, sw, sh};
    SDL_Surface* tmp = SDL_CreateRGBSurfaceWithFormat(0, sw, sh, 32, SDL_PIXELFORMAT_RGBA32);
    if (!tmp) return;
    SDL_RenderReadPixels(renderer, &srcR, SDL_PIXELFORMAT_RGBA32, tmp->pixels, tmp->pitch);
    SDL_Texture* tex = SDL_CreateTextureFromSurface(renderer, tmp);
    SDL_FreeSurface(tmp);
    if (!tex) return;
    SDL_RenderCopy(renderer, tex, nullptr, &dstR);
    SDL_DestroyTexture(tex);
}

void Graphics::fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
    setRT();
    SDL_SetRenderDrawColor(renderer, cr, cg, cb, ca);
    applyOrigin(x1,y1); applyOrigin(x2,y2); applyOrigin(x3,y3);
    if (y1>y2){std::swap(x1,x2);std::swap(y1,y2);}
    if (y1>y3){std::swap(x1,x3);std::swap(y1,y3);}
    if (y2>y3){std::swap(x2,x3);std::swap(y2,y3);}
    for (int y = y1; y <= y3; ++y) {
        float t1 = (y3!=y1) ? (float)(y-y1)/(y3-y1) : 0.f;
        int xa = (int)(x1 + t1*(x3-x1));
        int xb;
        if (y < y2) {
            float t2 = (y2!=y1) ? (float)(y-y1)/(y2-y1) : 0.f;
            xb = (int)(x1 + t2*(x2-x1));
        } else {
            float t2 = (y3!=y2) ? (float)(y-y2)/(y3-y2) : 0.f;
            xb = (int)(x2 + t2*(x3-x2));
        }
        if (xa>xb) std::swap(xa,xb);
        SDL_RenderDrawLine(renderer, xa, y, xb, y);
    }
}
