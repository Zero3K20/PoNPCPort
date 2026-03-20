#pragma once
#include "Platform.h"
#include <string>

// SDL2_ttf-backed replacement for com.nttdocomo.ui.Font
class Font {
public:
    TTF_Font* ttfFont = nullptr;
    int       height  = 0;

    static Font* getFont(int style);  // style 0 = default
    int  stringWidth(const std::string& s) const;
    int  getHeight()                       const;
    ~Font();

    static const char* DEFAULT_FONT_PATH;
private:
    Font() = default;
};
