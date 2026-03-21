#include "Image.h"
#include "Graphics.h"
#include <cstring>
#include <objidl.h>   // IStream

// ── Helper: wrap a byte array in a COM IStream ─────────────────────────────
static IStream* memToStream(const uint8_t* data, size_t len) {
    HGLOBAL hMem = GlobalAlloc(GMEM_MOVEABLE, len);
    if (!hMem) return nullptr;
    void* ptr = GlobalLock(hMem);
    if (!ptr) { GlobalFree(hMem); return nullptr; }
    std::memcpy(ptr, data, len);
    GlobalUnlock(hMem);
    IStream* stream = nullptr;
    // TRUE → stream takes ownership of hMem and frees it on Release
    if (FAILED(CreateStreamOnHGlobal(hMem, TRUE, &stream)))
        GlobalFree(hMem);
    return stream;
}

// ── Image ──────────────────────────────────────────────────────────────────
Image::~Image() {
    delete bitmap; bitmap = nullptr;
}

Image* Image::createImage(int w, int h) {
    Image* img  = new Image();
    img->width  = w;
    img->height = h;
    img->bitmap = new Gdiplus::Bitmap(w, h, PixelFormat32bppARGB);
    // Clear to transparent black
    Gdiplus::Graphics g(img->bitmap);
    g.Clear(Gdiplus::Color(0, 0, 0, 0));
    return img;
}

Image* Image::createFromData(const uint8_t* data, size_t len) {
    Image* img = new Image();
    if (!data || !len) return img;
    IStream* stream = memToStream(data, len);
    if (!stream) return img;
    img->bitmap = Gdiplus::Bitmap::FromStream(stream);
    stream->Release();
    if (img->bitmap && img->bitmap->GetLastStatus() == Gdiplus::Ok) {
        img->width  = (int)img->bitmap->GetWidth();
        img->height = (int)img->bitmap->GetHeight();
    } else {
        delete img->bitmap;
        img->bitmap = nullptr;
    }
    return img;
}

Graphics* Image::getGraphics() {
    if (!bitmap) return nullptr;
    return new Graphics(bitmap);
}

// ── Palette ─────────────────────────────────────────────────────────────────
Palette* Palette::createPalette(int sz) {
    Palette* p = new Palette();
    p->size = sz;
    return p;
}

void Palette::setEntries(const int* rgb, int offset, int count) {
    for (int i = 0; i < count && (offset + i) < size; ++i) {
        int c = rgb[i];
        colors[offset + i] = Gdiplus::Color(255,
            (BYTE)((c >> 16) & 0xFF),
            (BYTE)((c >>  8) & 0xFF),
            (BYTE)( c        & 0xFF));
    }
}

// ── PalettedImage ───────────────────────────────────────────────────────────
PalettedImage* PalettedImage::createImage(const uint8_t* data, int w, int h) {
    PalettedImage* pi = new PalettedImage();
    pi->width  = w;
    pi->height = h;
    pi->pixels.assign(data, data + w * h);
    return pi;
}

PalettedImage::~PalettedImage() { delete cachedImage; }

void PalettedImage::processImage(Palette* pal) {
    delete cachedImage;
    cachedImage = nullptr;

    Gdiplus::Bitmap* bmp =
        new Gdiplus::Bitmap(width, height, PixelFormat32bppARGB);
    Gdiplus::BitmapData bd;
    Gdiplus::Rect rc(0, 0, width, height);
    if (bmp->LockBits(&rc, Gdiplus::ImageLockModeWrite, PixelFormat32bppARGB, &bd)
            == Gdiplus::Ok) {
        DWORD* dst = (DWORD*)bd.Scan0;
        for (int i = 0; i < width * height; ++i) {
            int idx = pixels[i];
            Gdiplus::Color c =
                (pal && idx < pal->size) ? pal->colors[idx]
                                         : Gdiplus::Color(255, 0, 0, 0);
            dst[i] = c.GetValue();
        }
        bmp->UnlockBits(&bd);
    }

    cachedImage         = new Image();
    cachedImage->bitmap = bmp;
    cachedImage->width  = width;
    cachedImage->height = height;
}

Image* PalettedImage::getImage() { return cachedImage; }
