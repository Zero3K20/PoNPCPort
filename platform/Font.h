#pragma once
#include "Platform.h"
#include <string>

// GDI+-backed replacement for com.nttdocomo.ui.Font
class Font {
public:
    Gdiplus::Font*       gdipFont = nullptr;
    Gdiplus::FontFamily* family   = nullptr;
    int                  height   = 11;

    static Font* getFont(int style);  // style 0 = default
    int  stringWidth(const std::string& s) const;
    int  getHeight()                       const;
    int  getDescent()                      const;
    ~Font();

private:
    Font() = default;
};
