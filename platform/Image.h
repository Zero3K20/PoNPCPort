#pragma once
#include "Platform.h"
#include <vector>

class Graphics;
class Palette;

// SDL2-backed replacement for com.nttdocomo.ui.Image
class Image {
public:
    SDL_Texture*  texture  = nullptr;
    SDL_Surface*  surface  = nullptr;
    SDL_Renderer* renderer = nullptr;
    int  width      = 0;
    int  height     = 0;
    bool ownsTexture = true;

    ~Image();

    static Image* createImage(int w, int h);
    static Image* createFromData(const uint8_t* data, size_t len, SDL_Renderer* r);

    Graphics* getGraphics();
    int getWidth()  const { return width; }
    int getHeight() const { return height; }

    void uploadSurface();
    void setRenderer(SDL_Renderer* r);
};

// SDL2-backed replacement for com.nttdocomo.ui.Palette
class Palette {
public:
    SDL_Color colors[256] = {};
    int       size        = 0;

    static Palette* createPalette(int sz);
    void setEntries(const int* rgb, int offset, int count);
};

// SDL2-backed replacement for com.nttdocomo.ui.PalettedImage
class PalettedImage {
public:
    std::vector<uint8_t> pixels;
    int    width       = 0;
    int    height      = 0;
    Image* cachedImage = nullptr;

    static PalettedImage* createImage(const uint8_t* data, int w, int h);
    ~PalettedImage();

    void   processImage(Palette* pal, SDL_Renderer* r);
    Image* getImage();
};
