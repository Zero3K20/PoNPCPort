#include "BtPanel.h"
#include "CpCanvas_fwd.h"
int BtPanel::R = 0;
int BtPanel::G = 0;
int BtPanel::B = 0;

void BtPanel::init(int n, int n2, int n3) {
    id        = n + n2 * 6;
    jou       = n3;
    pos_x     = n;
    pos_y     = n2;
    on_chara  = 0;
    jin       = n < 3 ? 0 : 1;
    ana_cnt   = 0;
    aria_cnt  = 0;
    bom_pow   = 0;
    hokkei    = 0;
    mag_cnt   = (jou == 3) ? 250 : 0;
}

void BtPanel::Henka(int n, int n2) {
    if (jou < 0) return;
    if (jou == 0 && n != 8 && n != 1) return;
    if (jou == 2 && n == 2) n = 0;

    if (n == 0) {
        if (CpCanvas::boss_flg == 8 && pos_x > 3) return;
        if (on_chara == 0) {
            jou     = n;
            ana_cnt = 300;
        } else {
            jou = 2;
        }
        Draw(-1, true);
    } else if (n == 2) {
        if (jou > 0) jou = n;
        Draw(-1, true);
    } else if (n == 3) {
        jou     = 3;
        mag_cnt = 300;
        Draw(-1, true);
    } else if (n == 8) {
        if (CpCanvas::boss_flg == 8 && pos_x > 3) return;
        if (n2 != jin) return;
        if (hokkei != 0) return;
        if ((on_chara == 0 || on_chara == 12 - n2 * 2 || on_chara == 13 - n2 * 2) &&
            (jin == 0 && pos_x != 0 || jin == 1 && pos_x != 5)) {
            jin ^= 1;
            for (int i = 0; i < 3; ++i) {
                BtPanel& p = CpCanvas::panel[i][pos_x];
                if (p.jin != jin) continue;
                p.aria_cnt = 450;
                if (jin != pos_x / 3) continue;
                p.aria_cnt = 0;
            }
            Draw(-1, true);
        }
    } else {
        jou = n;
        Draw(-1, true);
    }
}

void BtPanel::NoChara(int n) {
    on_chara = 0;
    if (jou == 2 && n == 0) {
        Henka(0, 0);
    }
}

void BtPanel::Move() {
    int n;
    if (ana_cnt > 0) {
        if (jou != 0) {
            ana_cnt = 0;
        } else {
            --ana_cnt;
            if (ana_cnt < 30) {
                n = jou;
                if (ana_cnt / 2 % 2 == 0) jou = 1;
                Draw(-1, true);
                jou = n;
            }
            if (ana_cnt == 0) {
                jou = 1;
                Draw(-1, true);
            }
        }
    }

    if (mag_cnt > 0) {
        if (jou != 3) {
            mag_cnt = 0;
        } else {
            --mag_cnt;
            if (mag_cnt < 30) {
                n = jou;
                if (mag_cnt / 2 % 2 == 0) jou = 1;
                Draw(-1, true);
                jou = n;
            }
            if (mag_cnt == 0) {
                jou = 1;
                Draw(-1, true);
            }
        }
    }

    if (aria_cnt > 0 || pos_x / 3 != jin) {
        --aria_cnt;
        if (aria_cnt == 45) {
            int adj = pos_x - 1 + pos_x / 3 * 2;
            if (CpCanvas::panel[0][adj].jin == pos_x / 3 &&
                CpCanvas::panel[1][adj].jin == pos_x / 3 &&
                CpCanvas::panel[2][adj].jin == pos_x / 3) {
                if (JinCh()) {
                    jin ^= 1;
                } else {
                    aria_cnt = 46;
                }
            } else {
                aria_cnt = 46;
            }
        }
        if (aria_cnt < 45) {
            n = jin;
            if (aria_cnt / 2 % 2 == 0) jin ^= 1;
            Draw(-1, true);
            jin = n;
        }
        if (aria_cnt <= 0) {
            Draw(-1, true);
        }
    }
}

bool BtPanel::JinCh() {
    int n, n2 = 0;
    for (n = 0; n < 3; ++n) {
        if (CpCanvas::panel[n][pos_x].on_chara != 0) continue;
        ++n2;
    }
    if (n2 == 3) return true;

    n2 = 0;
    for (n = 0; n < 3; ++n) {
        if (pos_x / 3 == 0 &&
            (CpCanvas::panel[n][pos_x].on_chara > 4 || CpCanvas::panel[n][pos_x].on_chara == 1))
            ++n2;
        if (pos_x / 3 == 0 || CpCanvas::panel[n][pos_x].on_chara == 1) continue;
        ++n2;
    }
    return n2 == 3;
}

int BtPanel::img() {
    int n = jou + 2;
    if (jou < 3 && jin != 0) n += 10;
    return n;
}

void BtPanel::BackDraw(int n, int n2, bool bl) {
    if (bl) {
        CpCanvas::graMap->setColor(Graphics::getColorOfRGB(R, G, B));
        CpCanvas::graMap->fillRect(n, n2, 40, 24);
    } else {
        CpCanvas::g->setColor(Graphics::getColorOfRGB(R, G, B));
        CpCanvas::g->fillRect(n, n2, 40, 24);
    }
}

void BtPanel::Draw(int n, bool bl) {
    int n2;
    int n3 = pos_x * 40 + 0;
    int n4 = pos_y * 24 + 105;

    if (n < 0 || jou == 0) {
        n2 = jin * 10;
        BackDraw(n3, n4, bl);
        CpCanvas::drawImg3(42, n2, n3, n4, bl);
    }
    if (n != 0 && pos_y == 2) {
        n2 = jin * 10 + 1;
        CpCanvas::drawImg3(42, n2, n3, n4, bl);
    }
    if (jou < 0) return;
    n2 = img();
    CpCanvas::drawImg3(42, n2, n3, n4, bl);
}

void BtPanel::Draw2() {
    if (yokoku == 0) return;
    int n  = pos_x * 40 + 0;
    int n2 = pos_y * 24 + 105;
    CpCanvas::drawImg3(42, 15, n, n2, false);
    yokoku = 0;
}
