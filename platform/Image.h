#pragma once
#include "Platform.h"
#include <vector>

class Graphics;

// GDI+-backed replacement for com.nttdocomo.ui.Image
class Image {
public:
    Gdiplus::Bitmap* bitmap = nullptr;
    int  width  = 0;
    int  height = 0;

    ~Image();

    static Image* createImage(int w, int h);
    static Image* createFromData(const uint8_t* data, size_t len);

    // No-op: retained for call-site compatibility; GDI+ does not need
    // an explicit renderer/context to be associated with an image.
    void setRenderer(Graphics* /*g*/) {}

    Graphics* getGraphics();
    int getWidth()  const { return width; }
    int getHeight() const { return height; }
};

// GDI+-backed replacement for com.nttdocomo.ui.Palette
class Palette {
public:
    Gdiplus::Color colors[256] = {};
    int            size        = 0;

    static Palette* createPalette(int sz);
    void setEntries(const int* rgb, int offset, int count);
};

// GDI+-backed replacement for com.nttdocomo.ui.PalettedImage
class PalettedImage {
public:
    std::vector<uint8_t> pixels;
    int    width       = 0;
    int    height      = 0;
    Image* cachedImage = nullptr;

    static PalettedImage* createImage(const uint8_t* data, int w, int h);
    ~PalettedImage();

    void   processImage(Palette* pal);
    Image* getImage();
};
