#include "Tip.h"
#include "CpCanvas_fwd.h"

void Tip::init(int n, const uint8_t* tipData, const uint8_t* nameData) {
    tip_id = n;

    syu      = tipData[0] & 0xFF;
    aiu      = tipData[1] & 0xFF;
    pow      = ((tipData[2] & 0xFF) << 8) | (tipData[3] & 0xFF);
    zoku     = (tipData[4] & 0xF0) >> 4;
    rea      = tipData[4] & 0xF;
    setu_id  = tipData[5] & 0xFF;
    regu_you = tipData[6] & 0xFF;
    waza_id  = tipData[7] & 0xFF;

    int n2 = 0;
    while (n2 < 16 && nameData[n2] != 0) ++n2;
    name.assign(reinterpret_cast<const char*>(nameData), n2);
}

void Tip::DrawSetu() {
    CpCanvas::MesDraw(2);
}

void Tip::DrawRea(int n, int n2) {
    CpCanvas::drawImg3(44, 70 + rea, n, n2, false);
}

void Tip::DrawRegu(int n, int n2) {
    CpCanvas::ImgSuu(regu_you, n, n2, 16, 1, 2);
    CpCanvas::drawImg3(44, 17, n + 3, n2 + 7, false);
}

void Tip::DrawPow(int n, int n2) {
    if (pow > 0 && syu < 4 && tip_id != 131) {
        CpCanvas::ImgSuu(pow, n, n2, 24, 1, 1);
    }
}

void Tip::DrawPow2(int n, int n2) {
    if (pow > 0 && tip_id != 131) {
        CpCanvas::ImgSuu(pow, n, n2, 24, 1, 0);
    }
}

void Tip::DrawCode(int n, int n2, int n3, int /*n4*/) {
    std::string s = "*";
    if (n != 100) {
        char c = static_cast<char>(n + 64);
        s = std::string(1, c);
    }
    CpCanvas::strDraw(s, n2, n3);
}

void Tip::DrawZoku(int n, int n2) {
    CpCanvas::drawImg3(44, 25 + zoku, n, n2, false);
}

void Tip::DrawName(int n, int n2) {
    CpCanvas::strDraw(name, n, n2);
}

void Tip::Draw(int n, int n2, int n3, bool bl) {
    int n4 = tip_id % 15 * 16 + n3;
    int n5 = tip_id / 15 * 16 + n3;
    int sw = 16 - n3 * 2;
    int sh = 16 - n3 * 2;

    if (bl) {
        if (tip_id < 125) {
            CpCanvas::g->setColor(Graphics::getColorOfRGB(232, 216, 128));
        } else if (tip_id < 177) {
            CpCanvas::g->setColor(Graphics::getColorOfRGB(184, 220, 222));
        } else {
            CpCanvas::g->setColor(Graphics::getColorOfRGB(206, 145, 172));
        }
    } else {
        CpCanvas::g->setColor(Graphics::getColorOfRGB(184, 184, 176));
    }
    CpCanvas::g->fillRect(n, n2, sw, sh);
    CpCanvas::g->drawImage(CpCanvas::image[56]->getImage(), n, n2, n4, n5, sw, sh);
}
