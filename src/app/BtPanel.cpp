#include "BtPanel.h"
#include "CpCanvas.h"

int BtPanel::R = 0;
int BtPanel::G = 0;
int BtPanel::B = 0;

void BtPanel::init(int n, int n2, int n3)
{
    id = n + n2 * 6;
    jou = n3;
    pos_x = n;
    pos_y = n2;
    on_chara = 0;
    jin = (n < 3) ? 0 : 1;
    ana_cnt = 0;
    aria_cnt = 0;
    bom_pow = 0;
    hokkei = 0;
    mag_cnt = (jou == 3) ? 250 : 0;
}

void BtPanel::Henka(int n, int n2)
{
    if (jou < 0) return;
    if (jou == 0 && n != 8 && n != 1) return;
    if (jou == 2 && n == 2) n = 0;
    if (n == 0) {
        if (CpCanvas::boss_flg == 8 && pos_x > 3) return;
        if (on_chara == 0) { jou = n; ana_cnt = 300; }
        else { jou = 2; }
        Draw(-1, true);
    } else if (n == 2) {
        if (jou > 0) jou = n;
        Draw(-1, true);
    } else if (n == 3) {
        jou = 3;
        mag_cnt = 300;
        Draw(-1, true);
    } else if (n == 8) {
        if (CpCanvas::boss_flg == 8 && pos_x > 3) return;
        if (n2 != jin) return;
        if (hokkei != 0) return;
        if ((on_chara == 0 || on_chara == 12 - n2*2 || on_chara == 13 - n2*2) &&
            (jin == 0 && pos_x != 0 || jin == 1 && pos_x != 5)) {
            jin ^= 1;
            for (int i = 0; i < 3; i++) {
                if (jin != CpCanvas::panel[i][pos_x].jin) continue;
                CpCanvas::panel[i][pos_x].aria_cnt = 450;
                if (jin != pos_x / 3) continue;
                CpCanvas::panel[i][pos_x].aria_cnt = 0;
            }
            Draw(-1, true);
        }
    } else {
        jou = n;
        Draw(-1, true);
    }
}

void BtPanel::NoChara(int n)
{
    on_chara = 0;
}

void BtPanel::Move()
{
    if (ana_cnt > 0) {
        if (--ana_cnt == 0) jou = 1;
    }
    if (mag_cnt > 0) {
        if (--mag_cnt == 0) jou = 1;
    }
    if (aria_cnt > 0) {
        if (--aria_cnt == 0) jin = pos_x / 3;
    }
}

void BtPanel::Draw(int n, bool bl)
{
    int bx = pos_x * CpCanvas::BT_SIZE_X + CpCanvas::BT_OFF_X;
    int by = pos_y * CpCanvas::BT_SIZE_Y + CpCanvas::BT_OFF_Y;

    PlatColor col;
    switch (jou) {
    case 0: col = Platform_MakeColor(50, 50, 50);   break; /* broken */
    case 1: col = (jin == 0) ? Platform_MakeColor(80, 80, 200)   /* player side */
                             : Platform_MakeColor(200, 80, 80);  /* enemy side */
            break;
    case 2: col = Platform_MakeColor(200, 200, 80);  break; /* cracked */
    case 3: col = Platform_MakeColor(80, 160, 255);  break; /* ice */
    case 4: col = Platform_MakeColor(80, 200, 80);   break; /* grass */
    case 5: col = Platform_MakeColor(200, 200, 200); break; /* conveyor */
    case 6: col = Platform_MakeColor(200, 100, 0);   break; /* lava */
    case 7: col = Platform_MakeColor(140, 100, 60);  break; /* holy */
    default: col = Platform_MakeColor(60, 60, 60);   break;
    }

    Platform_SetColor(col);
    Platform_FillRect(bx + 1, by + 1, CpCanvas::BT_SIZE_X - 2, CpCanvas::BT_SIZE_Y - 2);
    Platform_SetColor(Platform_MakeColor(0, 0, 0));
    Platform_DrawRect(bx, by, CpCanvas::BT_SIZE_X, CpCanvas::BT_SIZE_Y);
}
