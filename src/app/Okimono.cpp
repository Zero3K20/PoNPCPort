#include "Okimono.h"
#include "CpCanvas.h"
#include "Rock.h"

int Okimono::o_data[14] = {
    537011713, 481781268, 481764869, 1346823684, 1348920836, 1350493700,
    1362110474, 1362126858, 134440712, 134440714, 134440716, 134440718,
    1208002620, 134358529
};

Okimono::Okimono(int n)
    : oki_id(n), on(0), syu(0), hp(50), drop_time(0),
      rock_ata(0), teki_ata(0), move_ok(0), only_flg(0),
      pos_x(-1), pos_y(-1), pos_dx(0), pos_dy(0), flp(0),
      pow(0), hit_cnt(0), ani_id(0), ani_pt(0), ani_max(0),
      ani_cnt(0), next_off(0), move_cnt(0), waza_syu(0) {}

void Okimono::init() { hp = 50; on = 0; }

void Okimono::Set(int n, int n2, int n3, int n4, int n5)
{
    syu = n;
    on = 1;
    pos_dx = 0; pos_dy = 0;
    pos_x = n2; pos_y = n3;
    hit_cnt = 0;
    flp = n4;
    hp       = (o_data[n] & 0xFF) * 10;
    ani_id   = (o_data[n] >> 8)  & 0x3F;
    ani_pt   = (o_data[n] >> 14) & 0x1F;
    drop_time= ((o_data[n] >> 19) & 0xFF) * 10;
    rock_ata = (o_data[n] >> 27) & 1;
    teki_ata = (o_data[n] >> 28) & 1;
    move_ok  = (o_data[n] >> 29) & 1;
    only_flg = (o_data[n] >> 30) & 1;
    CpCanvas::panel[pos_y][pos_x].on_chara = 10 + oki_id;
    ani_cnt = 0;
    move_cnt = 0;
    NextOff();
    waza_syu = 0;
    pow = n5;
}

void Okimono::Move()
{
    if (on == 0) return;
    --drop_time;
    if (drop_time == 1) { Off(); return; }
    if (syu > 2 && syu < 6) {
        if (move_cnt % 10 == 0) {
            int n = PaneRan(flp);
            int n2 = n % 6, n3 = n / 6;
            int n4 = CpCanvas::AtaNo(0);
            CpCanvas::ata[n4].Set(80, n2, n3, flp, -2);
            CpCanvas::ata[n4].pow = pow;
            CpCanvas::ata[n4].chara_flg = 1 - flp;
            CpCanvas::ata[n4].zoku = 1;
        }
    }
    ++move_cnt;
}

int Okimono::PaneRan(int n)
{
    int nArray[18]; int n3 = 0;
    for (int n2 = 0; n2 < 18; n2++) {
        if (CpCanvas::panel[n2/6][n2%6].jin != n || CpCanvas::panel[n2/6][n2%6].jou <= 0) continue;
        nArray[n3] = n2;
        ++n3;
    }
    if (n3 == 0) return 100;
    int n2 = (CpCanvas::nextInt() & 0x7FFFFFFF) % (3 + CpCanvas::ene_cnt);
    if (n2 < 3) {
        if (n == 0 && n2 == 0) return Rock::pos_x + Rock::pos_y * 6;
        if (n != 0 && CpCanvas::ene[n2].on != 0)
            return CpCanvas::ene[n2].pos_x + CpCanvas::ene[n2].pos_y * 6;
        return nArray[(CpCanvas::nextInt() & 0x7FFFFFFF) % n3];
    }
    return nArray[(CpCanvas::nextInt() & 0x7FFFFFFF) % n3];
}

void Okimono::Hit(int n, int n2)
{
    if (syu == 13) { CpCanvas::oki[2].Hit(n, n2); return; }
    if (CpCanvas::panel[pos_y][pos_x].jou == 7) n = (n + 1) / 2;
    hp -= n;
    if (n2 != 0 && syu < 12) hp = 0;
    if (hp <= 0) {
        hp = 0;
        if (syu < 12) { Off(); }
        else if (ani_pt != 3) {
            ani_pt = 3;
            for (int r = 0; r < 3; r++) {
                int n3 = CpCanvas::AtaNo(0);
                CpCanvas::ata[n3].Set(4, pos_x, r, 0, 3);
            }
            int n3 = CpCanvas::AtaNo(0);
            CpCanvas::ata[n3].Set(115, pos_x, 0, 0, 3);
            CpCanvas::ata[n3].pos_dx = 0;
            CpCanvas::ata[n3].pos_dy = 0;
        }
    }
    if (n > 0 && syu < 12) hit_cnt = 1;
}

void Okimono::Off()
{
    on = 0;
    int n = CpCanvas::AtaNo(0);
    CpCanvas::ata[n].Set(4, pos_x, pos_y, 0, 3);
    CpCanvas::panel[pos_y][pos_x].NoChara(0);
}

void Okimono::NextOff()
{
    if (oki_id % 2 == 0) {
        next_off = (CpCanvas::oki[oki_id+1].on == 0) ? oki_id : oki_id + 1;
    } else {
        CpCanvas::oki[oki_id-1].next_off = (CpCanvas::oki[oki_id-1].on == 0) ? oki_id : oki_id - 1;
    }
}

void Okimono::Draw()
{
    if (on == 0) return;
    if (ani_id == 0) return;
    if (hit_cnt != 0) { hit_cnt = 0; return; }
    if (-2 == CpCanvas::Ani(ani_id, ani_pt, ani_cnt, pos_x, pos_y, pos_dx, pos_dy, flp)) {
        ani_cnt = 0;
        CpCanvas::Ani(ani_id, ani_pt, ani_cnt, pos_x, pos_y, pos_dx, pos_dy, flp);
    }
    pos_dx = 0; pos_dy = 0;
    ++ani_cnt;
}
