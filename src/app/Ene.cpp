#include "Ene.h"
#include "CpCanvas.h"
#include "Rock.h"

int Ene::move[22][5] = {};
int Ene::eria_flg = 0;

Ene::Ene()
    : waza_flg(0), waza_wait(0), waza_syu(0), hp(0), max_hp(0), zoku(0),
      zenny(0), pos_x(-1), pos_y(-1), pos_dx(0), pos_dy(0),
      tmp_x(-1), tmp_y(-1), def_x(-1), def_y(-1),
      move_flg(0), move_cnt(0), wait_cnt(0), syoumetu_cnt(0), on(0),
      joutai(0), muteki_cnt(0), tmp_muteki_cnt(0), hit_cnt(0),
      ani_wait_cnt(0), tmp_wait_cnt(0), ani_ok(0),
      s_wait(0), e_wait(0), r_suu(0), r_s(0), r_e(0),
      ani_id(0), ani_max(0), ani_cnt(0), ani_cnt_max(0),
      chara_no(-1), chara_lv(0), chara_id(0), ene_id(0),
      bari(0), bari_id(-1), ata_id(-1), han(0), pane_id(0), tmp_move(0),
      tmp_cnt(0), tmp_cnt2(0), air(0), tmp_lv(0), def_ani(0),
      navi_flg(0), mahi_id(-1), muteki2(0),
      t_ani_cnt(0), tmp_s_wait(0), tmp_r_suu(0), tmp_e_wait(0),
      x_sp(40), y_sp(24)
{
    memset(waza_id, 0, sizeof(waza_id));
    memset(waza_zoku, 0, sizeof(waza_zoku));
    memset(pow, 0, sizeof(pow));
    memset(drop_tip, 0, sizeof(drop_tip));
    memset(ani_pt, 0, sizeof(ani_pt));
}

void Ene::init(int n, int n2, int n3, int n4, int n5)
{
    if (n2 > 5) return;
    t_ani_cnt = 0; tmp_s_wait = 0; tmp_r_suu = 0; tmp_e_wait = 0;
    ene_id = n5; tmp_lv = n4;
    pos_x = n2; pos_y = n3;
    pos_dx = 0; pos_dy = 0;
    def_x = n2; def_y = n3;
    ani_cnt = 0; muteki2 = 0;
    navi_flg = n / 21;
    ani_id = n + 1;
    if (navi_flg == 0) {
        CpCanvas::PalSet(ani_id, n4 + ani_id * 4 + 1);
    }

    chara_no = n;
    chara_lv = n4;
    chara_id = ene_id;
    on = 1;
    air = 0;
    tmp_cnt = 0; tmp_cnt2 = 0;
    def_ani = 0;
    bari = 0;
    bari_id = -1;
    ata_id = -1;
    mahi_id = -1;
    move_cnt = 0;
    move_flg = 0;
    hit_cnt = 0;
    wait_cnt = 0;
    syoumetu_cnt = 0;
    muteki_cnt = 0;
    joutai = 0;
    han = 0;
    waza_flg = -1;
    waza_syu = 0;

    /* Set HP from data */
    hp = 100 + n4 * 50;
    max_hp = hp;
    for (int i = 0; i < 5; i++) {
        waza_id[i] = 0;
        waza_zoku[i] = 0;
        pow[i] = 20 + n4 * 10;
    }
    zenny = 50 + n4 * 20;

    CpCanvas::panel[pos_y][pos_x].on_chara = 10 + n;

    AniSet(0);
    ++CpCanvas::ene_cnt;
}

void Ene::AniSet(int n)
{
    if (joutai == 0 || n == 0) {
        ani_pt[0] = n;
        ani_max = 1;
        ani_cnt = 0;
        joutai = n;
        s_wait = 0; e_wait = 0;
        r_suu = 0; r_s = 0; r_e = 0;
    }
}

void Ene::MoveSet()
{
    for (int i = 0; i < 22; i++) {
        for (int j = 0; j < 5; j++) {
            move[i][j] = CpCanvas::waza_mo ? CpCanvas::waza_mo[i * 5 + j] : 0;
        }
    }
}

void Ene::Move()
{
    if (!on) return;
    if (hit_cnt  > 0) --hit_cnt;
    if (wait_cnt > 0) --wait_cnt;
    if (muteki_cnt > 0) --muteki_cnt;
    if (ani_wait_cnt > 0) --ani_wait_cnt;
    if (syoumetu_cnt > 0) {
        if (--syoumetu_cnt == 0) {
            on = 0;
            --CpCanvas::ene_cnt;
            CpCanvas::panel[pos_y][pos_x].on_chara = 0;
        }
        return;
    }
    tmp_x = pos_x;
    tmp_y = pos_y;
    /* Simple AI: try to move toward player every 30 frames */
    if (move_cnt % 30 == 0 && joutai == 0) {
        int dx = Rock::pos_x - pos_x;
        int dy2 = Rock::pos_y - pos_y;
        if (abs(dx) > abs(dy2)) {
            int new_x = pos_x + (dx > 0 ? 1 : -1);
            if (new_x >= 3 && new_x <= 5 && CpCanvas::panel[pos_y][new_x].jou > 0 && CpCanvas::panel[pos_y][new_x].on_chara == 0) {
                CpCanvas::panel[pos_y][pos_x].on_chara = 0;
                pos_x = new_x;
                CpCanvas::panel[pos_y][pos_x].on_chara = 10 + chara_no;
            }
        } else if (dy2 != 0) {
            int new_y = pos_y + (dy2 > 0 ? 1 : -1);
            if (new_y >= 0 && new_y <= 2 && CpCanvas::panel[new_y][pos_x].jou > 0 && CpCanvas::panel[new_y][pos_x].on_chara == 0) {
                CpCanvas::panel[pos_y][pos_x].on_chara = 0;
                pos_y = new_y;
                CpCanvas::panel[pos_y][pos_x].on_chara = 10 + chara_no;
            }
        }
    }
    PaneCh();
    Action();
    ++move_cnt;
}

void Ene::PaneCh()
{
    if (pos_x < 0 || pos_y < 0) return;
    pane_id = CpCanvas::panel[pos_y][pos_x].jou;
}

int Ene::Check(int n, int n2)
{
    int nx = pos_x + n;
    int ny = pos_y + n2;
    if (nx < 3 || nx > 5 || ny < 0 || ny > 2) return 0;
    if (CpCanvas::panel[ny][nx].jin == 0) return 0;  /* player side */
    if (CpCanvas::panel[ny][nx].jou <= 0) return 0;
    if (CpCanvas::panel[ny][nx].on_chara != 0) return 0;
    return 1;
}

bool Ene::Hit(int n, int n2, int n3)
{
    if (n2 == 0) return false;
    if (muteki_cnt > 0) return false;
    if (bari > 0) {
        bari -= n2;
        if (bari <= 0) { bari = 0; if (bari_id >= 0) { CpCanvas::ata[bari_id].init(); bari_id = -1; } }
        return true;
    }
    hp -= n2;
    if (hp <= 0) { hp = 0; Syoumetu(); return true; }
    if (n > 0) { muteki_cnt = 20; hit_cnt = 1; ani_wait_cnt = 10; joutai = 0; AniSet(1); }
    return true;
}

void Ene::Syoumetu()
{
    /* Drop loot */
    int zenny_drop = zenny;
    CpCanvas::zenny += zenny_drop;
    syoumetu_cnt = 15;
    joutai = 99;
    int n = CpCanvas::AtaNo(0);
    CpCanvas::ata[n].Set(4, pos_x, pos_y, 0, 3);
    /* Check win condition */
    if (--CpCanvas::ene_cnt <= 0) {
        CpCanvas::win_flg = 1;
        CpCanvas::over_cnt = 1;
    }
}

void Ene::EffSet(int n)
{
    int n2 = CpCanvas::AtaNo(0);
    CpCanvas::ata[n2].Set(n, pos_x, pos_y, 0, 3);
}

void Ene::WazaSet()
{
    waza_flg = -1;
    waza_wait = 0;
}

void Ene::Action()
{
    if (joutai != 0) return;
    if (wait_cnt > 0) return;
    /* Attack every 60 frames */
    if (move_cnt % 60 == 0) {
        int n = CpCanvas::AtaNo(0);
        if (n >= 0 && waza_id[0] >= 0) {
            CpCanvas::ata[n].Set(waza_id[0] > 0 ? waza_id[0] : 5, pos_x, pos_y, 0, 1);  /* enemy attacks target player */
            CpCanvas::ata[n].pow = pow[0];
        }
        wait_cnt = 30;
    }
}

void Ene::Loop()
{
    ani_ok = 1;
    if (s_wait > 0) { --s_wait; ani_ok = 0; }
}

void Ene::HpDraw(int n, int n2)
{
    CpCanvas::HpDraw(hp, n, n2);
}

void Ene::Draw(int n)
{
    if (!on) return;
    if (syoumetu_cnt > 0) return;
    if (hit_cnt != 0) { hit_cnt = 0; return; }
    if (n != 0) Loop();
    if (-2 == CpCanvas::Ani(ani_id, ani_pt[0], ani_cnt, pos_x, pos_y, pos_dx, pos_dy, 1)) {
        ani_cnt = 0;
        CpCanvas::Ani(ani_id, ani_pt[0], ani_cnt, pos_x, pos_y, pos_dx, pos_dy, 1);
    }
    pos_dx = 0; pos_dy = 0;
    if (n != 0 && ani_ok) ++ani_cnt;
}
