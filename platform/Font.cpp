#include "Font.h"

Font::~Font() {
    delete gdipFont; gdipFont = nullptr;
    delete family;   family   = nullptr;
}

Font* Font::getFont(int /*style*/) {
    Font* f = new Font();

    // Try well-known monospace system fonts (no external file needed)
    static const wchar_t* families[] = {
        L"Courier New",
        L"Lucida Console",
        L"Consolas",
        L"Arial",
        nullptr
    };

    for (int i = 0; families[i]; ++i) {
        f->family = new Gdiplus::FontFamily(families[i]);
        if (f->family->GetLastStatus() == Gdiplus::Ok) {
            f->gdipFont = new Gdiplus::Font(f->family, 11.0f,
                                            Gdiplus::FontStyleRegular,
                                            Gdiplus::UnitPixel);
            if (f->gdipFont->GetLastStatus() == Gdiplus::Ok) {
                f->height = 11;
                return f;
            }
            delete f->gdipFont; f->gdipFont = nullptr;
        }
        delete f->family; f->family = nullptr;
    }

    // Last resort: generic Sans Serif
    f->gdipFont = new Gdiplus::Font(L"Arial", 11.0f,
                                    Gdiplus::FontStyleRegular,
                                    Gdiplus::UnitPixel);
    f->height = 11;
    return f;
}

int Font::stringWidth(const std::string& s) const {
    if (!gdipFont) return (int)s.size() * 6;
    // Convert UTF-8 to UTF-16 properly
    int n = MultiByteToWideChar(CP_UTF8, 0, s.c_str(), -1, nullptr, 0);
    std::wstring ws(n, L'\0');
    MultiByteToWideChar(CP_UTF8, 0, s.c_str(), -1, &ws[0], n);
    // Measure on a temporary 1×1 bitmap
    Gdiplus::Bitmap tmp(1, 1, PixelFormat32bppARGB);
    Gdiplus::Graphics g(&tmp);
    Gdiplus::StringFormat fmt;
    fmt.SetFormatFlags(Gdiplus::StringFormatFlagsNoWrap |
                       Gdiplus::StringFormatFlagsMeasureTrailingSpaces);
    Gdiplus::RectF bounds;
    g.MeasureString(ws.c_str(), -1, gdipFont,
                    Gdiplus::PointF(0, 0), &fmt, &bounds);
    return (int)bounds.Width;
}

int Font::getHeight() const { return height; }
