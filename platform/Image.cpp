#include "Image.h"
#include "Graphics.h"
#include <cstring>

Image::~Image() {
    if (ownsTexture && texture) { SDL_DestroyTexture(texture); texture = nullptr; }
    if (surface) { SDL_FreeSurface(surface); surface = nullptr; }
}

void Image::setRenderer(SDL_Renderer* r) { renderer = r; }

Image* Image::createImage(int w, int h) {
    Image* img = new Image();
    img->width  = w;
    img->height = h;
    return img;
}

Image* Image::createFromData(const uint8_t* data, size_t len, SDL_Renderer* r) {
    Image* img = new Image();
    img->renderer = r;
    SDL_RWops* rw = SDL_RWFromConstMem(data, (int)len);
    if (!rw) return img;
    img->surface = IMG_Load_RW(rw, 1);
    if (!img->surface) return img;
    img->width  = img->surface->w;
    img->height = img->surface->h;
    img->uploadSurface();
    return img;
}

void Image::uploadSurface() {
    if (!surface || !renderer) return;
    if (texture && ownsTexture) SDL_DestroyTexture(texture);
    texture = SDL_CreateTextureFromSurface(renderer, surface);
    ownsTexture = true;
}

Graphics* Image::getGraphics() {
    if (!renderer) return nullptr;
    if (!texture) {
        texture = SDL_CreateTexture(renderer,
                                    SDL_PIXELFORMAT_RGBA32,
                                    SDL_TEXTUREACCESS_TARGET,
                                    width, height);
        ownsTexture = true;
    }
    return new Graphics(renderer, texture);
}

// ── Palette ─────────────────────────────────────────────────────────────────
Palette* Palette::createPalette(int sz) {
    Palette* p = new Palette();
    p->size = sz;
    return p;
}

void Palette::setEntries(const int* rgb, int offset, int count) {
    for (int i = 0; i < count && (offset+i) < size; ++i) {
        int c = rgb[i];
        colors[offset+i].r = (c>>16)&0xFF;
        colors[offset+i].g = (c>> 8)&0xFF;
        colors[offset+i].b =  c     &0xFF;
        colors[offset+i].a = 255;
    }
}

// ── PalettedImage ───────────────────────────────────────────────────────────
PalettedImage* PalettedImage::createImage(const uint8_t* data, int w, int h) {
    PalettedImage* pi = new PalettedImage();
    pi->width  = w;
    pi->height = h;
    pi->pixels.assign(data, data + w*h);
    return pi;
}

PalettedImage::~PalettedImage() { delete cachedImage; }

void PalettedImage::processImage(Palette* pal, SDL_Renderer* r) {
    delete cachedImage;
    cachedImage = nullptr;
    SDL_Surface* surf = SDL_CreateRGBSurfaceWithFormat(0, width, height, 32, SDL_PIXELFORMAT_RGBA32);
    if (!surf) return;
    Uint32* dst = (Uint32*)surf->pixels;
    for (int i = 0; i < width*height; ++i) {
        int idx = pixels[i];
        SDL_Color col = (pal && idx < pal->size) ? pal->colors[idx] : SDL_Color{0,0,0,255};
        dst[i] = SDL_MapRGBA(surf->format, col.r, col.g, col.b, col.a);
    }
    cachedImage = new Image();
    cachedImage->renderer = r;
    cachedImage->surface  = surf;
    cachedImage->width    = width;
    cachedImage->height   = height;
    cachedImage->uploadSurface();
}

Image* PalettedImage::getImage() { return cachedImage; }
