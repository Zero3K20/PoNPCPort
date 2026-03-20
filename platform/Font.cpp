#include "Font.h"
#include <cstdio>

const char* Font::DEFAULT_FONT_PATH = "data/font.ttf";

Font::~Font() {
    if (ttfFont) { TTF_CloseFont(ttfFont); ttfFont = nullptr; }
}

Font* Font::getFont(int /*style*/) {
    Font* f = new Font();
    static const char* candidates[] = {
        Font::DEFAULT_FONT_PATH,
        "/usr/share/fonts/truetype/dejavu/DejaVuSansMono.ttf",
        "/usr/share/fonts/truetype/liberation/LiberationMono-Regular.ttf",
        "/usr/share/fonts/truetype/freefont/FreeMono.ttf",
        "/System/Library/Fonts/Menlo.ttc",
        "C:\\Windows\\Fonts\\cour.ttf",
        nullptr
    };
    for (int i = 0; candidates[i]; ++i) {
        f->ttfFont = TTF_OpenFont(candidates[i], 11);
        if (f->ttfFont) break;
    }
    f->height = f->ttfFont ? TTF_FontHeight(f->ttfFont) : 11;
    return f;
}

int Font::stringWidth(const std::string& s) const {
    if (!ttfFont) return (int)s.size() * 6;
    int w = 0, h = 0;
    TTF_SizeUTF8(ttfFont, s.c_str(), &w, &h);
    return w;
}

int Font::getHeight() const { return height; }
