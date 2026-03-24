#include "Attack.h"
#include "CpCanvas.h"
#include "Rock.h"
#include "Okimono.h"
#include "Waza.h"

Attack::Attack(int n)
    : ata_id(n), tmp_id(0), eff_id(0), pos_x(0), pos_y(0),
      pos_dx(0), pos_dy(0), waza_id(0), yokoku(0), move_flg(0),
      pow(0), zoku(0), hit_x(0), hit_y(0), hit_kou(0), hit_eff(0),
      hit_param(0), hit_kan(0), hit_ana(0), hit_bure(0), hit_time(0),
      oki_hit(0), hit_flg(0), ani_id(0), ani_pt(0), ani_max(0),
      ani_cnt(0), ani_ok(0), stop(0), move_cnt(0), move_x(0), move_y(0),
      s_wait(0), e_wait(0), r_suu(0), r_s(0), r_e(0), on(0),
      chara_flg(0), flp(0), ren_hit(0), hon_id(-1),
      t_ani_cnt(0), tmp_s_wait(0), tmp_r_suu(0), tmp_e_wait(0),
      hit_ok(0), loop_flg(0), se_id(0), se_flg(0)
{
    memset(param, 0, sizeof(param));
}

void Attack::init()
{
    if (on != 0) --CpCanvas::ata_cnt;
    on = 0;
    if (hon_id >= 0 && CpCanvas::ene[hon_id].on != 0) {
        CpCanvas::ene[hon_id].pos_x = CpCanvas::ene[hon_id].def_x;
        CpCanvas::ene[hon_id].pos_y = CpCanvas::ene[hon_id].def_y;
        CpCanvas::ene[hon_id].pos_dx = 0;
        CpCanvas::ene[hon_id].pos_dy = 0;
        CpCanvas::ene[hon_id].move_cnt = 0;
    }
    hon_id = -1;
    hit_ok = 0;
}

int Attack::Set(int n, int n2, int n3, int n4, int n5)
{
    waza_id = n;
    pos_x   = n2;
    pos_y   = n3;
    flp     = n4;
    chara_flg = n5;
    on      = 1;
    hit_ok  = 0;
    move_cnt = 0;
    move_flg = 0;
    hon_id  = -1;
    ani_cnt = 0;

    if (n < 0 || n >= CpCanvas::WAZA_MAX || !CpCanvas::waza || !CpCanvas::waza[n])
        return 0;

    Waza *w = CpCanvas::waza[n];
    pow      = 0;
    zoku     = 0;
    hit_kan  = w->kan;
    hit_ana  = w->ana;
    hit_bure = w->bure;
    hit_time = w->stop_time;
    hit_eff  = w->eff_id;
    yokoku   = w->yokoku;

    WazaSet();
    KouSet();
    return on;
}

void Attack::EffSet()
{
    /* Spawn effect attack */
    if (eff_id <= 0) return;
    int n = CpCanvas::AtaNo(0);
    CpCanvas::ata[n].Set(eff_id, pos_x, pos_y, flp, 3);
}

int Attack::CopySet(int n, int n2, int n3, int n4)
{
    return Set(n, n2, n3, n4, chara_flg);
}

void Attack::WazaSet()
{
    if (!CpCanvas::waza || !CpCanvas::waza[waza_id]) return;
    Waza *w = CpCanvas::waza[waza_id];
    /* Load animation data from ani_id */
    ani_id = w->move_id;
    ani_pt = 0;
    ani_max = 1;
    s_wait = 0; e_wait = 0; r_suu = 0;
}

void Attack::KouSet()
{
    if (!CpCanvas::waza || !CpCanvas::waza[waza_id]) return;
    Waza *w = CpCanvas::waza[waza_id];
    pow       = w->waza_kou;
    hit_eff   = w->eff_id;
    hit_param = w->noke_pt;
}

void Attack::PosSet(int n)
{
    /* Move position by n panels in current direction */
    (void)n;
}

int Attack::EneZa(int n)
{
    /* Find enemy at position, return index or -1 */
    for (int i = 0; i < 3; i++) {
        if (!CpCanvas::ene[i].on) continue;
        if (CpCanvas::ene[i].pos_x == pos_x && CpCanvas::ene[i].pos_y == pos_y)
            return i;
    }
    return -1;
}

void Attack::HitSet(int n)
{
    hit_flg = n;
}

void Attack::Move()
{
    if (!on) return;
    ++move_cnt;

    /* Basic movement */
    if (move_flg == 1) {
        pos_x += flp ? -1 : 1;
        if (pos_x < 0 || pos_x > 5) { init(); return; }
    }

    /* Hit detection */
    if (!hit_ok) {
        RockHit();
        EneHit();
        OkiHit();
    }

    /* Animation loop */
    Loop();
}

void Attack::Loop()
{
    if (!CpCanvas::ani || !CpCanvas::ani[ani_id]) return;
    ani_ok = 1;
    if (s_wait > 0) { --s_wait; ani_ok = 0; return; }
    /* Check if animation ended */
    if (!CpCanvas::ani[ani_id][ani_pt]) return;
    if (CpCanvas::ani[ani_id][ani_pt][ani_cnt + 1] == -2) {
        if (e_wait >= 0 && --e_wait < 0) {
            /* Animation done - destroy self */
            init();
        } else {
            ani_ok = 0;
        }
    }
}

void Attack::Draw()
{
    if (!on) return;
    if (-2 == CpCanvas::Ani(ani_id, ani_pt, ani_cnt,
                             pos_x, pos_y, pos_dx, pos_dy, flp)) {
        ani_cnt = 0;
        CpCanvas::Ani(ani_id, ani_pt, ani_cnt, pos_x, pos_y, pos_dx, pos_dy, flp);
    }
    pos_dx = 0; pos_dy = 0;
    if (ani_ok) ++ani_cnt;
}

void Attack::RockHit()
{
    if (!CpCanvas::rock) return;
    if (chara_flg == 1) return;  /* enemy-only */
    if (Rock::pos_x != pos_x || Rock::pos_y != pos_y) return;
    if (hit_flg) return;
    if (pow <= 0) return;
    CpCanvas::rock->Hit(hit_param, pow, zoku);
    hit_ok = 1;
    hit_flg = 1;
    EffSet();
}

void Attack::EneHit()
{
    if (chara_flg == 0) return;  /* player-only */
    for (int i = 0; i < 3; i++) {
        if (!CpCanvas::ene[i].on) continue;
        if (CpCanvas::ene[i].pos_x != pos_x || CpCanvas::ene[i].pos_y != pos_y) continue;
        if (hit_flg && !ren_hit) continue;
        if (pow <= 0) continue;
        CpCanvas::ene[i].Hit(1, pow, zoku);
        hit_ok = 1;
        hit_flg = 1;
        EffSet();
    }
}

void Attack::OkiHit()
{
    if (!CpCanvas::oki) return;
    for (int i = 0; i < 6; i++) {
        if (!CpCanvas::oki[i].on) continue;
        if (CpCanvas::oki[i].pos_x != pos_x || CpCanvas::oki[i].pos_y != pos_y) continue;
        if (CpCanvas::oki[i].rock_ata == 0 && chara_flg == 1) continue;
        if (CpCanvas::oki[i].teki_ata == 0 && chara_flg == 0) continue;
        CpCanvas::oki[i].Hit(pow, 0);
        hit_ok = 1;
    }
}
