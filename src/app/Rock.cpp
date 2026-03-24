#include "Rock.h"
#include "CpCanvas.h"
#include "Edit.h"

/* Static member definitions */
int Rock::tip_data[30]    = {};
int Rock::tip_no          = 0;
int Rock::pow[4]          = {};
int Rock::next_tip        = 0;
int Rock::hp              = 0;
int Rock::zoku            = 0;
int Rock::pos_x           = 0;
int Rock::pos_y           = 0;
int Rock::dx              = 0;
int Rock::dy              = 0;
int Rock::tmp_x           = 0;
int Rock::tmp_y           = 0;
int Rock::joutai          = 0;
int Rock::muteki_cnt      = 0;
int Rock::tmp_muteki_cnt  = 0;
int Rock::hit_cnt         = 0;
int Rock::move_flg        = 0;
int Rock::syoumetu_cnt    = 0;
int Rock::ani_wait_cnt    = 0;
int Rock::tmp_ani_cnt     = 0;
int Rock::ani_ok          = 0;
int Rock::s_wait          = 0;
int Rock::e_wait          = 0;
int Rock::r_suu           = 0;
int Rock::r_s             = 0;
int Rock::r_e             = 0;
int Rock::ani_cnt         = 0;
int Rock::ani_cnt_max     = 0;
int Rock::ani_id[2]       = {};
int Rock::ani_pt[2]       = {};
int Rock::ani_max         = 0;
int Rock::move[22][7]     = {};
int Rock::waza_flg        = 0;
int Rock::waza_wait       = 0;
int Rock::non_cnt         = 0;
int Rock::non_cnt2        = 0;
int Rock::bas_no          = 0;
int Rock::bas_pow         = 0;
int Rock::han             = 0;
int Rock::han_id          = 0;
int Rock::bari            = 0;
int Rock::bari_id         = 0;
int Rock::wana            = 0;
int Rock::pane_id         = 0;
int Rock::tmp_move        = 0;
int Rock::non_bas         = 0;
int Rock::tmp_ata         = 0;
int Rock::air             = 0;
int Rock::move_cnt        = 0;
int Rock::noke_cnt        = 0;
int Rock::mahi_id         = 0;

Rock::Rock()
    : t_ani_cnt(0), tmp_s_wait(0), tmp_r_suu(0), tmp_e_wait(0)
{
    for (int i = 0; i < 9; i++) tip[i] = nullptr;
}

void Rock::init()
{
    for (int n = 0; n < 9; n++) {
        tip[n] = &CpCanvas::tip_obj[0];
    }
    t_ani_cnt = 0;
    tmp_s_wait = 0;
    tmp_r_suu = 0;
    tmp_e_wait = 0;
    tip_no = -1;
    hp = CpCanvas::now_hp;
    pos_x = 1;
    pos_y = 1;
    ani_max = 1;
    ani_cnt = 0;
    syoumetu_cnt = -1;
    muteki_cnt = 0;
    tmp_muteki_cnt = 0;
    ani_wait_cnt = 0;
    tmp_ani_cnt = 0;
    waza_flg = -1;
    CpCanvas::panel[Rock::pos_y][Rock::pos_x].on_chara = 1;
    bas_no = -1;
    bari_id = -1;
    bas_pow = 1;
    non_cnt = 0;
    non_cnt2 = 0;
    han = 0;
    han_id = -1;
    bari = 0;
    wana = 0;
    pow[0] = 0;
    pow[3] = 0;
    next_tip = 1;
    tmp_ata = -1;
    move_cnt = 0;
    noke_cnt = 0;
    zoku = Edit::r_zoku;
    mahi_id = -1;
    if (CpCanvas::skill_kouka[6] != 0) {
        int n = CpCanvas::AtaNo(0);
        CpCanvas::ata[n].Set(113, pos_x, pos_y, 1, 0);
    }
    air = CpCanvas::skill_kouka[7];
    MoveSet();
    AniSet(0);
}

void Rock::MoveSet()
{
    for (int i = 0; i < 22; i++) {
        for (int j = 0; j < 6; j++) {
            move[i][j] = CpCanvas::rock_mo[i * 6 + j];
            move[i][j + 1] = -2;
        }
    }
}

void Rock::AniSet(int n)
{
    if (joutai == 0 || n == 0) {
        ani_id[0] = move[n][1];
        ani_id[1] = move[n][3] * 35;
        ani_max = move[n][0];
        ani_pt[0] = move[n][2];
        ani_pt[1] = move[n][4];
        int n2 = move[n][5];
        s_wait = CpCanvas::wait_data[n2 * 5];
        e_wait = CpCanvas::wait_data[n2 * 5 + 1];
        r_suu  = CpCanvas::wait_data[n2 * 5 + 2];
        r_s    = CpCanvas::wait_data[n2 * 5 + 3];
        r_e    = CpCanvas::wait_data[n2 * 5 + 4];
        if (e_wait > 99) e_wait = -1;
        tmp_s_wait = s_wait;
        tmp_r_suu  = r_suu;
        tmp_e_wait = e_wait;
        ani_cnt = 0;
        joutai = n;
    }
}

void Rock::Move()
{
    int n, n2;
    if (tmp_ata >= 0) {
        n2 = tip_no;
        n = tmp_ata >> 2;
        if (n > 4) tip_no = n;
        Action(tmp_ata & 3);
        if (n > 4) tip_no = n2;
    }
    if (non_cnt  > 0) --non_cnt;
    if (non_cnt2 > 0) --non_cnt2;
    if (hit_cnt  > 0) --hit_cnt;
    if (syoumetu_cnt > 0) {
        if (--syoumetu_cnt == 15) EffSet(4);
        if (syoumetu_cnt == 12)   EffSet(4);
        if (syoumetu_cnt == 9)    EffSet(4);
        if (syoumetu_cnt < 7)     --muteki_cnt;
        if (syoumetu_cnt == 0)    CpCanvas::over_cnt = 1;
        return;
    }
    tmp_x = pos_x;
    tmp_y = pos_y;
    PaneCh();
    if (move_flg > 5) {
        if      (move_flg == 6) pos_x -= Check(-1, 0, 1);
        else if (move_flg == 7) pos_y -= Check(0, -1, 1);
        else if (move_flg == 8) pos_x += Check(1, 0, 1);
        else if (move_flg == 9) pos_y += Check(0, 1, 1);
        /* reset move_flg */
        move_flg = (zoku != 2 && CpCanvas::panel[pos_y][pos_x].jou == 5) ?
            ((move_flg - 5 == 1 && Check(-1,0,2)==0 || move_flg-5==3 && Check(1,0,2)==0 ||
              move_flg-5==2 && Check(0,-1,2)==0 || move_flg-5==4 && Check(0,1,2)==0) ? 0 : (move_flg -= 5)) : 0;
    }
    if (joutai == 0 && move_flg != 0) {
        if (non_cnt2 != 0) {
            move_flg = -5;
        } else if (move_flg == 1) { Check(-1, 0, 0); }
        else if   (move_flg == 2) { Check(0, -1, 0); }
        else if   (move_flg == 3) { Check(1, 0, 0); }
        else if   (move_flg == 4) { Check(0, 1, 0); }
        move_flg += 5;
    }
    if (waza_flg >= 0 && ani_wait_cnt == 0) {
        if (waza_wait == 0) {
            n2 = CpCanvas::AtaNo(0);
            CpCanvas::ata[n2].Set(waza_flg, pos_x, pos_y, 1, 0);
            waza_flg = -1;
            n = CpCanvas::ata[n2].hit_time;
            if (n != 0) {
                CpCanvas::stop_time = n;
                CpCanvas::eff_id = n2;
                CpCanvas::stop_ch = 0;
                for (int i = 1; i < 6; i++) {
                    if (tip[Rock::tip_no + i] && tip[Rock::tip_no + i]->syu >= 4) continue;
                    if (tip[Rock::tip_no + i]) CpCanvas::stop_name = tip[Rock::tip_no + i]->name;
                    break;
                }
            }
        }
        --waza_wait;
    }
    if (bas_no >= 0) { CpCanvas::ata[bas_no].pos_x = pos_x; CpCanvas::ata[bas_no].pos_y = pos_y; }
    if (bari_id >= 0) { CpCanvas::ata[bari_id].pos_x = pos_x; CpCanvas::ata[bari_id].pos_y = pos_y; }
    if (mahi_id >= 0) { CpCanvas::ata[mahi_id].pos_x = pos_x; CpCanvas::ata[mahi_id].pos_y = pos_y; }
    if (han_id >= 0)  { CpCanvas::ata[han_id].pos_x  = pos_x; CpCanvas::ata[han_id].pos_y  = pos_y; }
    if (muteki_cnt    > 0) --muteki_cnt;
    if (ani_wait_cnt  > 0) --ani_wait_cnt;
}

void Rock::PaneCh()
{
    pane_id = CpCanvas::panel[pos_y][pos_x].jou;
    if (CpCanvas::panel[pos_y][pos_x].bom_pow > 0) {
        Hit(1, CpCanvas::panel[pos_y][pos_x].bom_pow, 0);
        EffSet(4);
        CpCanvas::panel[pos_y][pos_x].bom_pow = 0;
    }
    if (pane_id == 3) {
        if (zoku != 1 && Hit(1, 50, 1)) {
            EffSet(8);
            CpCanvas::panel[pos_y][pos_x].Henka(1, 0);
        }
    } else if (pane_id == 4) {
        if (zoku == 4 && (hp += CpCanvas::game_cnt % 2) > CpCanvas::max_hp) hp = CpCanvas::max_hp;
    } else if (pane_id == 6 && CpCanvas::game_cnt % 2 == 0) {
        int n = bari;
        bari = 0;
        Hit(0, 1, 0);
        hit_cnt = 0;
        bari = n;
    }
}

int Rock::Check(int n, int n2, int n3)
{
    int n5 = pos_x + n;
    int n6 = pos_y + n2;
    if (n5 < 0 || n5 > 5 || n6 < 0 || n6 > 2) return 0;
    if (CpCanvas::panel[n6][n5].jin != 0) return 0;
    if (air == 0 && CpCanvas::panel[n6][n5].jou <= 0) return 0;
    if (CpCanvas::panel[n6][n5].on_chara != 0 && StBom(n5, n6)) return 0;
    if (n3 == 0) {
        int n4 = CpCanvas::AtaNo(0);
        CpCanvas::ata[n4].Set(59, pos_x, pos_y, 0, 2);
    }
    if (n3 == 1) {
        CpCanvas::panel[n6][n5].on_chara = 1;
        ++move_cnt;
        tmp_move = 1;
        CpCanvas::panel[tmp_y][tmp_x].NoChara(air);
        int n4 = CpCanvas::AtaNo(0);
        CpCanvas::ata[n4].Set(59, n5, n6, 0, 2);
    }
    return 1;
}

bool Rock::StBom(int n, int n2)
{
    int n3 = CpCanvas::panel[n2][n].on_chara - 10;
    if (n3 >= 0 && CpCanvas::oki[n3].on != 0 && CpCanvas::oki[n3].move_ok != 0 && CpCanvas::oki[n3].syu == 0) {
        CpCanvas::panel[n2][n].bom_pow = CpCanvas::oki[n3].pow;
        CpCanvas::oki[n3].on = 0;
        CpCanvas::panel[CpCanvas::oki[n3].pos_y][CpCanvas::oki[n3].pos_x].on_chara = 0;
        return false;
    }
    return true;
}

bool Rock::Hit(int n, int n2, int n3)
{
    if (n2 == 0) return false;
    if (CpCanvas::dell_cnt > 0) return false;
    if (muteki_cnt > 0 && CpCanvas::stop_cnt == 0) return false;
    if (zoku != 0 && zoku % 4 + 1 == n3) { n2 *= 2; EffSet(39); }
    if (pane_id == 7) n2 = (n2 + 1) / 2;
    if (bari > 0) {
        if ((bari -= n2) <= 0) {
            bari = 0;
            CpCanvas::ata[bari_id].init();
            bari_id = -1;
        }
        return true;
    }
    int n4 = hp;
    if (CpCanvas::deba_flg == 0 || (CpCanvas::rock_mu == 0 && CpCanvas::deba_flg != 0)) hp -= n2;
    if (hp <= 0) {
        if (CpCanvas::skill_kouka[8] != 0 && n4 > 1) { hp = 1; }
        else { Syoumetu(); hp = 0; return true; }
    }
    int n5 = ani_wait_cnt;
    if (n == 1) muteki_cnt = 30;
    if (n > 0) { ani_wait_cnt = 15; ++noke_cnt; }
    if (n == 3) {
        ani_wait_cnt = 25;
        if (mahi_id < 0) mahi_id = CpCanvas::AtaNo(0);
        CpCanvas::ata[mahi_id].Set(88, pos_x, pos_y, 0, 3);
        CpCanvas::ata[mahi_id].pos_dx = 0;
        CpCanvas::ata[mahi_id].pos_dy = 0;
    }
    if (CpCanvas::stop_cnt != 0) { tmp_muteki_cnt = muteki_cnt; muteki_cnt = 0; }
    if (n2 > 0) hit_cnt = 1;
    if (CpCanvas::skill_kouka[5] != 0 && n != 3) { ani_wait_cnt = n5; n = 0; }
    if (n > 0) {
        move_flg = 0;
        waza_flg = -1;
        joutai = 0;
        AniSet(1);
        if (bas_no >= 0) { CpCanvas::ata[bas_no].init(); bas_no = -1; CpCanvas::key_cnt = 0; }
        tmp_ani_cnt = ani_wait_cnt;
    }
    return true;
}

void Rock::Syoumetu()
{
    CpCanvas::over_cnt = -1;
    syoumetu_cnt = 16;
    muteki_cnt = 16;
    ani_wait_cnt = 16;
    tmp_ani_cnt = 16;
    joutai = 0;
    AniSet(1);
    if (bas_no >= 0) { CpCanvas::ata[bas_no].init(); bas_no = -1; CpCanvas::key_cnt = 0; }
}

int Rock::Chage(int n)
{
    if (joutai != 0) return 1;
    if (bas_no < 0) bas_no = CpCanvas::AtaNo(0);
    CpCanvas::ata[bas_no].Set(57 + n, pos_x, pos_y, 1, 2);
    CpCanvas::ata[bas_no].pos_dx = 0;
    CpCanvas::ata[bas_no].pos_dy = 0;
    return 0;
}

void Rock::EffSet(int n)
{
    int n2 = CpCanvas::AtaNo(0);
    CpCanvas::ata[n2].Set(n, pos_x, pos_y, 0, 3);
}

void Rock::Action(int n)
{
    if (joutai != 0) return;
    if (tip_no < 0) return;
    if (non_cnt > 0) return;
    if (non_cnt2 > 0) return;
    if (move_flg != 0) { tmp_ata = n + tip_no << 2; return; }
    if (bas_no >= 0) { CpCanvas::ata[bas_no].init(); bas_no = -1; CpCanvas::key_cnt = 0; }
    int n2 = CpCanvas::waza[tip[Rock::tip_no]->waza_id]->move_id;
    AniSet(n2);
    waza_wait = CpCanvas::waza[tip[Rock::tip_no]->waza_id]->wait_cnt;
    waza_flg = tip[Rock::tip_no]->tip_id;
    if (tip[Rock::tip_no]->syu < 3) pow[3] = pow[0];
    if (tip_no < 5) { tip_no -= next_tip; TipNext(); }
    tmp_ata = -1;
    non_bas = 1;
}

void Rock::TipNext()
{
    pow[0] = 0;
    for (int i = tip_no; i >= 0; --i) {
        if (!tip[i] || tip[i]->syu >= 4) continue;
        tip_no = i;
        next_tip = 1;
        int n = tip[i]->syu;
        --i;
        while (i >= 0 && tip[i] &&
               (tip[i]->syu == 4 && n < 2 || tip[i]->syu == 5 && n == 1)) {
            pow[0] += tip[i]->pow;
            ++next_tip;
            --i;
        }
        break;
    }
}

void Rock::TipDraw()
{
    if (tip_no < 0) return;
    for (int n = 0; n < tip_no + 1 && joutai != 21; ++n) {
        int n2 = pos_x * 40 + 16 + n * 2 - tip_no * 2;
        int n3 = pos_y * 24 + 105 - 45 - tip_no * 2 + n * 2;
        if (tip[n]) CpCanvas::drawImg3(0, tip[n]->tip_id, n2, n3, false);
    }
    Platform_SetColor(Platform_MakeColor(255, 255, 255));
    if (tip[Rock::tip_no]) {
        CpCanvas::strDraw(tip[Rock::tip_no]->name, 5, 215);
        if (tip[Rock::tip_no]->syu < 3) {
            int n = CpCanvas::max_hp - hp;
            if (n > 999) n = 999;
            CpCanvas::tip_obj[131].pow = n;
            Platform_SetColor(Platform_MakeColor(255, 255, 0));
            CpCanvas::strDraw(" " + std::to_string(tip[Rock::tip_no]->pow),
                5 + Platform_StringWidth(tip[Rock::tip_no]->name), 215);
            if (pow[0] != 0) {
                CpCanvas::strDraw("+" + std::to_string(pow[0]),
                    5 + Platform_StringWidth(tip[Rock::tip_no]->name + " " + std::to_string(tip[Rock::tip_no]->pow)), 215);
            }
        }
    }
}

void Rock::Loop()
{
    ani_ok = 1;
    if (--s_wait < 0) {
        s_wait = 0;
        if (r_suu != 0) {
            if (ani_cnt == r_e + 1) {
                ani_cnt = r_s;
                if (--r_suu < 0) r_suu = 0;
            }
        } else if (CpCanvas::ani[ani_id[0]][ani_pt[0]][ani_cnt + 1] == -2) {
            if (e_wait < 0) {
                ani_ok = 0;
            } else if (--e_wait < 0) {
                e_wait = 0;
            } else {
                ani_ok = 0;
            }
        }
    } else {
        ani_ok = 0;
    }
}

void Rock::WanaDraw()
{
    if (wana == 0) return;
    Platform_SetColor(Platform_MakeColor(255, 255, 255));
    CpCanvas::strDraw("????", 5, 75);
}

void Rock::HpDraw(int n, int n2)
{
    CpCanvas::HpDraw(hp, n, n2);
}

void Rock::Draw(int n)
{
    int n2 = (muteki_cnt % 2 << 4) + (hit_cnt << 4);
    if (non_cnt2 != 0) n2 = 0;
    tmp_s_wait = s_wait;
    tmp_r_suu  = r_suu;
    tmp_e_wait = e_wait;
    if (n != 0) Loop();
    for (int i = 0; i < ani_max; ++i) {
        if (-2 != CpCanvas::Ani(ani_id[i], ani_pt[i], ani_cnt, pos_x, pos_y + n2, dx + tmp_ani_cnt % 3, dy, 1)) continue;
        if (ani_pt[0] != 0) { AniSet(0); }
        else { ani_cnt = 0; }
        CpCanvas::Ani(ani_id[i], ani_pt[i], ani_cnt, pos_x, pos_y + n2, dx + tmp_ani_cnt % 3, dy, 1);
    }
    t_ani_cnt = ani_cnt;
    if (tmp_ani_cnt == 0 && ani_ok != 0) ani_cnt += n;
    tmp_ani_cnt = ani_wait_cnt;
}
