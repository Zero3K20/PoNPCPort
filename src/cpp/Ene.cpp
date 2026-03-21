#include "Ene.h"
#include "CpCanvas_fwd.h"
#include "BtPanel.h"
#include "Okimono.h"
#include "Rock.h"
#include "Attack.h"
#include "Waza.h"

// ── Static member definitions ───────────────────────────────────────────────
int Ene::move[22][5] = {};
int Ene::eria_flg    = 0;

// ── init ────────────────────────────────────────────────────────────────────
void Ene::init(int n, int n2, int n3, int n4, int n5) {
    if (n2 > 5) return;
    t_ani_cnt  = 0;
    tmp_s_wait = 0;
    tmp_r_suu  = 0;
    tmp_e_wait = 0;
    ene_id     = n5;
    tmp_lv     = n4;
    pos_x      = n2;
    pos_y      = n3;
    pos_dx     = 0;
    pos_dy     = 0;
    def_x      = n2;
    def_y      = n3;
    ani_cnt    = 0;
    muteki2    = 0;
    navi_flg   = n / 21;
    ani_id     = n + 1;
    if (navi_flg == 0) {
        CpCanvas::PalSet(ani_id, n4 + ani_id * 4 + 1);
    }
    chara_no = n;
    MoveSet();
    AniSet(0);
    ParaSet(n, n4);
    move_flg      = 0;
    move_cnt      = 0;
    wait_cnt      = 0;
    waza_flg      = -1;
    waza_wait     = 0;
    ani_wait_cnt  = 0;
    tmp_wait_cnt  = 0;
    muteki_cnt    = 0;
    tmp_muteki_cnt = 0;
    syoumetu_cnt  = -1;
    joutai        = 0;
    waza_syu      = 0;
    mahi_id       = -1;
    on            = 1;
    ++CpCanvas::ene_cnt;
    CpCanvas::panel[pos_y][pos_x].on_chara = 2 + ene_id;
    tmp_move  = 0;
    eria_flg  = 0;
    air       = 0;
    bari      = 0;
    bari_id   = -1;
    han       = 0;
    ata_id    = -1;
    def_ani   = 0;
    tmp_cnt   = 0;
    tmp_cnt2  = 0;
    x_sp      = 40;
    y_sp      = 24;
    chara_id  = -1;
    for (int i = 0; i < 3; ++i) {
        if (CpCanvas::ene[i]->chara_no != chara_no) continue;
        ++chara_id;
    }
    if (n == 0 && chara_id != 0) wait_cnt = -1;
    if (n == 32) {
        int na = CpCanvas::AtaNo(0);
        CpCanvas::ata[na]->Set(161, pos_x, pos_y, 0, 1);
    }
}

void Ene::ParaSet(int n, int n2) {
    int* d0 = CpCanvas::e_data[n * 4 + n2];
    hp = max_hp = (d0[0] & 0x1FF) * 10;
    waza_zoku[0] = d0[0] >> 9  & 7;
    waza_zoku[1] = d0[0] >> 12 & 7;
    waza_zoku[2] = d0[0] >> 15 & 7;
    waza_zoku[3] = d0[0] >> 18 & 7;
    zenny        = (d0[0] >> 21) * 10;
    zoku         = d0[1] & 7;
    pow[0]       = (d0[1] >> 3  & 0x3F) * 10;
    pow[1]       = (d0[1] >> 9  & 0x3F) * 10;
    pow[2]       = (d0[1] >> 15 & 0x3F) * 10;
    pow[3]       = (d0[1] >> 21 & 0x3F) * 10;
    waza_id[0]   = d0[2]        & 0xFF;
    waza_id[1]   = d0[2] >> 8   & 0xFF;
    waza_id[2]   = d0[2] >> 16  & 0xFF;
    waza_id[3]   = d0[2] >> 24  & 0xFF;
    drop_tip[0]  = d0[3]        & 0x1FF;
    drop_tip[1]  = d0[3] >> 9   & 0x1FF;
    drop_tip[2]  = d0[4]        & 0x1FF;
    drop_tip[3]  = d0[4] >> 9   & 0x1FF;
    if (CpCanvas::deba_flg != 0 && CpCanvas::teki_mu != 0) hp += 1000;
}

void Ene::MoveSet() {
    for (int i = 0; i < 22; ++i) {
        for (int j = 0; j < 4; ++j) {
            Ene::move[i][j]     = CpCanvas::teki_mo[i * 4 + j];
            Ene::move[i][j + 1] = -2;
        }
    }
}

void Ene::AniSet(int n) {
    if (joutai == 0 || n == def_ani || n == 0) {
        ani_max  = move[n][0];
        ani_pt[0] = move[n][1];
        ani_pt[1] = move[n][2];
        ani_pt[2] = move[n][3];
        int n2    = ani_pt[2];
        s_wait = CpCanvas::wait_data[n2 * 5];
        e_wait = CpCanvas::wait_data[n2 * 5 + 1];
        r_suu  = CpCanvas::wait_data[n2 * 5 + 2];
        r_s    = CpCanvas::wait_data[n2 * 5 + 3];
        r_e    = CpCanvas::wait_data[n2 * 5 + 4];
        if (e_wait > 250) e_wait = -1;
        tmp_s_wait = s_wait;
        tmp_r_suu  = r_suu;
        tmp_e_wait = e_wait;
        ani_cnt    = 0;
        joutai     = n;
    }
}

// ── Move (AI) ───────────────────────────────────────────────────────────────
int Ene::Move() {
    if (on == 0) return 1;
    if (muteki_cnt > 0) --muteki_cnt;
    if (hit_cnt > 0)    --hit_cnt;

    if (syoumetu_cnt > 0) {
        --syoumetu_cnt;
        if (syoumetu_cnt % 3 == 0 && syoumetu_cnt > 5) EffSet(4);
        if (syoumetu_cnt == 0) Off();
        return 0;
    }

    PaneCh();
    x_sp = 40;
    y_sp = 24;

    if (ani_wait_cnt == 0) {
        tmp_x = pos_x;
        tmp_y = pos_y;

        // ── Per-enemy AI dispatch ──────────────────────────────────────────
        if (chara_no == 0) {
            if (move_cnt >= 17 - tmp_lv * 2 && move_flg == 0) {
                move_cnt = 0;
                if (Rock::pos_y < pos_y && Check(0, -1) != 0) {
                    move_flg = 2;
                } else if (Rock::pos_y > pos_y && Check(0, 1) != 0) {
                    move_flg = 4;
                } else {
                    Action(0);
                    wait_cnt = -1;
                    NextChara(0);
                }
            }
        } else if (chara_no == 1) {
            if (move_cnt > 0 && move_flg == 0) {
                if (tmp_cnt == 0) {
                    if (pos_y == Rock::pos_y) {
                        Action(1);
                        wait_cnt = 40;
                        tmp_cnt  = 0;
                        move_cnt = 0;
                    }
                } else if (tmp_cnt != 0 && wait_cnt == 0) {
                    Action(0);
                    wait_cnt = 40 - tmp_lv * 4;
                    tmp_cnt  = 0;
                    move_cnt = 0;
                }
            }
        } else if (chara_no == 2) {
            x_sp = 5; y_sp = 2;
            if (move_cnt >= 15 && move_flg == 0) {
                move_cnt = 0;
                if (eria_flg != 0) {
                    Action(1);
                    wait_cnt = 25;
                    eria_flg = 0;
                } else if (Rock::pos_y < pos_y && Check(0, -1) != 0) {
                    move_flg = 2;
                } else if (Rock::pos_y > pos_y && Check(0, 1) != 0) {
                    move_flg = 4;
                } else if (Check(-1, 0) != 0) {
                    move_flg = 1;
                } else if (Rock::pos_y == pos_y) {
                    Action(0);
                    wait_cnt = 25 - tmp_lv * 3;
                }
            }
            if (CpCanvas::stop_time == 0 &&
                (CpCanvas::eria_cnt == 130 || CpCanvas::eria_cnt == 260)) {
                eria_flg = 1;
                ++CpCanvas::eria_cnt;
            }
        } else if (chara_no == 3) {
            if (move_cnt > 14 - tmp_lv * 2 && move_flg == 0) {
                if (tmp_cnt > 99) {
                    Action(0);
                    wait_cnt = 16;
                    tmp_cnt  = 0;
                    move_cnt = 0;
                } else {
                    int v = PaneRan(0);
                    if (v < 100) {
                        int na = CpCanvas::AtaNo(0);
                        CpCanvas::ata[na]->Set(59, pos_x, pos_y, 0, 2);
                        pos_x = v % 6; pos_y = v / 6;
                        StBom(pos_x, pos_y);
                        CpCanvas::panel[tmp_y][tmp_x].NoChara(air);
                    } else {
                        tmp_cnt += 30;
                    }
                    CpCanvas::panel[pos_y][pos_x].on_chara = 2 + ene_id;
                    ++tmp_cnt;
                    move_cnt = 0;
                }
            }
        } else if (chara_no == 4) {
            if (move_cnt > 14 - tmp_lv * 2 && move_flg == 0) {
                move_cnt = 0;
                if (tmp_cnt > 1 + (int)((CpCanvas::rand() & 0x7FFFFFFF) % 3)) {
                    Action(0);
                    wait_cnt = 40 - tmp_lv * 5;
                    tmp_cnt  = 0;
                } else {
                    if (Rock::pos_y < pos_y && Check(0, -1) != 0) {
                        move_flg = 2;
                    } else if (Rock::pos_y > pos_y && Check(0, 1) != 0) {
                        move_flg = 4;
                    } else if (Rock::pos_y == pos_y) {
                        Action(0);
                        wait_cnt = 40 - tmp_lv * 5;
                        tmp_cnt  = 0;
                    }
                    ++tmp_cnt;
                }
            }
        } else if (chara_no == 5) {
            if (move_cnt > 13 - tmp_lv * 2 && move_flg == 0) {
                move_cnt = 0;
                if (tmp_cnt > (int)((CpCanvas::rand() & 0x7FFFFFFF) % 3) + 2 - tmp_lv / 2) {
                    Action(0);
                    wait_cnt = 35 - tmp_lv * 5;
                    tmp_cnt  = 0;
                } else {
                    int dirs[8] = {-1, 0, 0, -1, 1, 0, 0, 1};
                    int start   = (CpCanvas::rand() & 0x7FFFFFFF) % 4;
                    for (int i = 0; i < 4; ++i) {
                        int d = (start + i) % 4;
                        if (Check(dirs[d*2], dirs[d*2+1]) == 0) continue;
                        int na = CpCanvas::AtaNo(0);
                        CpCanvas::ata[na]->Set(59, pos_x, pos_y, 0, 2);
                        move_flg = d + 1;
                        break;
                    }
                    ++tmp_cnt;
                }
            }
        } else if (chara_no == 6) {
            y_sp = 2;
            if (move_cnt >= 14 && move_flg == 0) {
                move_cnt = 0;
                if ((tmp_cnt & 15) > 3 + (int)((CpCanvas::rand() & 0x7FFFFFFF) % 3) - tmp_lv / 2) {
                    if (pos_x > Rock::pos_x) {
                        Action(0);
                        wait_cnt = 35 - tmp_lv * 5;
                    }
                    tmp_cnt &= 16;
                } else if (tmp_cnt >> 4 == 0) {
                    if (Check(0, 1) == 0) {
                        tmp_cnt   += 16;
                        move_cnt   = 10;
                        if ((CpCanvas::rand() & 0x7FFFFFFF) % 30 != 0) --tmp_cnt;
                    } else {
                        move_flg = 4;
                    }
                } else if (Check(0, -1) == 0) {
                    tmp_cnt -= 16;
                    move_cnt = 10;
                    if ((CpCanvas::rand() & 0x7FFFFFFF) % 30 == 0) --tmp_cnt;
                } else {
                    move_flg = 2;
                }
                ++tmp_cnt;
            }
        } else if (chara_no == 7) {
            if (move_cnt >= 11 && move_flg == 0) {
                move_cnt = 0;
                if (tmp_cnt > 15) {
                    if (Rock::pos_y < pos_y && Check(0,-1) != 0) {
                        move_flg = 2;
                    } else if (Rock::pos_y > pos_y && Check(0,1) != 0) {
                        move_flg = 4;
                    } else {
                        Action(0);
                        wait_cnt = 35 - tmp_lv * 4;
                        tmp_cnt  = 0;
                    }
                    move_cnt = 9;
                } else {
                    int start  = (CpCanvas::rand() & 0x7FFFFFFF) % 4;
                    int dirs[8]= {-1,0,0,-1,1,0,0,1};
                    for (int i = 0; i < 4; ++i) {
                        int d = (start + i) % 4;
                        if (Check(dirs[d*2], dirs[d*2+1]) == 0) continue;
                        int na = CpCanvas::AtaNo(0);
                        CpCanvas::ata[na]->Set(59, pos_x, pos_y, 0, 2);
                        move_flg = d + 1;
                        break;
                    }
                    ++tmp_cnt;
                    if (tmp_cnt >= (int)((CpCanvas::rand() & 0x7FFFFFFF) % 3) + 3 - tmp_lv / 2) {
                        tmp_cnt += 16;
                    }
                }
            }
        } else if (chara_no == 8) {
            if (move_cnt > 35 - tmp_lv * 2 && move_flg == 0) {
                Action(0);
                wait_cnt = 45 - tmp_lv * 2;
                move_cnt = 0;
            }
            han = ani_cnt > 2 ? 0 : 5;
        } else if (chara_no == 9) {
            if (move_cnt > 40 - tmp_lv * 5 && move_flg == 0) {
                Action(0);
                wait_cnt = 40 - tmp_lv * 5;
                move_cnt = 0;
            }
        } else if (chara_no == 10) {
            x_sp = 5; y_sp = 3;
            if (move_cnt >= 8 && move_flg == 0) {
                move_cnt = 0;
                if (tmp_cnt >= 3 + (int)((CpCanvas::rand() & 0x7FFFFFFF) % 3) - tmp_lv / 2) {
                    Action(0);
                    wait_cnt = 20 - tmp_lv * 3;
                    tmp_cnt  = 0;
                } else {
                    int start = (CpCanvas::rand() & 0x7FFFFFFF) % 4;
                    int dirs[8]= {-1,0,0,-1,1,0,0,1};
                    for (int i = 0; i < 4; ++i) {
                        int d = (start + i) % 4;
                        if (pos_x == 4 && d == 0) continue;
                        if (Check(dirs[d*2], dirs[d*2+1]) == 0) continue;
                        move_flg = d + 1;
                        break;
                    }
                    ++tmp_cnt;
                }
            }
        } else if (chara_no == 11) {
            y_sp = 2; air = 1;
            if (move_cnt >= 12 && move_flg == 0) {
                move_cnt = 0;
                if (tmp_cnt == 0) {
                    if (Check(0, 1) == 0) {
                        tmp_cnt = 1;
                        if (pos_y == 2) { Action(0); wait_cnt = 35; }
                    } else {
                        move_flg = 4;
                    }
                } else if (Check(0, -1) == 0) {
                    tmp_cnt = 0;
                    if (pos_y == 0) { Action(0); wait_cnt = 25; }
                } else {
                    move_flg = 2;
                }
            }
            if (wait_cnt == 1) { joutai = 0; AniSet(2); }
            han = (joutai == 0) ? 5 : 0;
        } else if (chara_no == 12) {
            if (move_cnt == 0) {
                wait_cnt = 8; move_cnt = 1; bari = 1; tmp_cnt = 0;
            } else if (move_cnt == 2) {
                Action(bari);
                def_ani = (1 - bari) * 5;
                move_cnt = 3; tmp_cnt = 1;
            }
        } else if (chara_no == 13) {
            air = 1;
            if (move_cnt == 0) {
                wait_cnt = 8; move_cnt = 1;
            } else if (move_cnt == 2) {
                Action(0); move_cnt = 3;
            }
        } else if (chara_no == 14) {
            if (move_cnt > 13 && move_flg == 0) {
                if (tmp_cnt > 4) {
                    Action(0);
                    wait_cnt = 45 + (tmp_lv - tmp_lv / 3) * 16;
                    tmp_cnt  = 0;
                } else {
                    int v = PaneRan(tmp_cnt / 4 + 1);
                    if (v < 100) {
                        int na = CpCanvas::AtaNo(0);
                        CpCanvas::ata[na]->Set(59, pos_x, pos_y, 0, 2);
                        pos_x = v % 6; pos_y = v / 6;
                        StBom(pos_x, pos_y);
                        CpCanvas::panel[tmp_y][tmp_x].NoChara(air);
                    }
                    CpCanvas::panel[pos_y][pos_x].on_chara = 2 + ene_id;
                    ++tmp_cnt;
                    move_cnt = 0;
                }
                move_cnt = 0;
            }
        } else if (chara_no == 15) {
            y_sp = 1; air = 1;
            if (move_cnt >= 25 && move_flg == 0) {
                move_cnt = 0;
                if (Rock::pos_y < pos_y && Check(0,-1) != 0) {
                    move_flg = 2;
                } else if (Rock::pos_y > pos_y && Check(0,1) != 0) {
                    move_flg = 4;
                } else if (Rock::pos_y == pos_y) {
                    def_x = pos_x; def_y = pos_y;
                    int na = CpCanvas::AtaNo(0);
                    CpCanvas::ata[na]->Set(59, pos_x, pos_y, 0, 2);
                    Action(0); wait_cnt = 15;
                }
            }
            han = (joutai == 0) ? 5 : 0;
        } else if (chara_no == 16) {
            if (tmp_lv % 2 == 0) {
                if (CpCanvas::bas_cnt % 4 == 0) {
                    int na = CpCanvas::AtaNo(0);
                    CpCanvas::ata[na]->Set(85, 2, CpCanvas::bas_cnt % 12 / 4, 0, -2);
                }
                if (CpCanvas::bas_cnt % 20 < 5 &&
                    Rock::move_flg == 0 &&
                    Rock::tmp_x == Rock::pos_x &&
                    Rock::tmp_y == Rock::pos_y) {
                    Rock::pos_x -= CpCanvas::rock->Check(-1, 0, 1);
                }
            } else {
                if (CpCanvas::bas_cnt % 4 == 0) {
                    int na = CpCanvas::AtaNo(0);
                    CpCanvas::ata[na]->Set(86, 0, CpCanvas::bas_cnt % 12 / 4, 1, -2);
                }
                if (CpCanvas::bas_cnt % 20 < 5 &&
                    Rock::move_flg == 0 &&
                    Rock::tmp_x == Rock::pos_x &&
                    Rock::tmp_y == Rock::pos_y) {
                    Rock::pos_x += CpCanvas::rock->Check(1, 0, 1);
                }
            }
        } else if (chara_no >= 17 && chara_no < 21) {
            y_sp = 4;
            if (move_cnt >= 8 + (int)((CpCanvas::rand() & 0x7FFFFFFF) % 4) && move_flg == 0) {
                move_cnt = 0;
                if ((tmp_cnt & 15) >= (int)((CpCanvas::rand() & 0x7FFFFFFF) % 3) + 6 - tmp_lv) {
                    Action(0);
                    wait_cnt = 40 - tmp_lv * 5;
                    tmp_cnt &= 16;
                } else if (tmp_cnt >> 4 == 0) {
                    if (Check(0, 1) == 0) {
                        tmp_cnt  += 16;
                        move_cnt  = 4;
                    } else {
                        move_flg = 4;
                    }
                } else if (Check(0, -1) == 0) {
                    tmp_cnt -= 16;
                    move_cnt = 4;
                } else {
                    move_flg = 2;
                }
                ++tmp_cnt;
            }
        } else if (chara_no == 21) {
            if (move_cnt > 15 - tmp_lv * 2 && move_flg == 0 && joutai == 0) {
                if (tmp_cnt > 99) {
                    Action(waza_syu);
                    wait_cnt = 36 - tmp_lv * 6;
                    tmp_cnt  = 0; move_cnt = 0;
                } else {
                    int v = PaneRan(0);
                    if (v < 100) {
                        int na = CpCanvas::AtaNo(0);
                        CpCanvas::ata[na]->Set(59, pos_x, pos_y, 0, 2);
                        pos_x = v % 6; pos_y = v / 6;
                        StBom(pos_x, pos_y);
                        CpCanvas::panel[tmp_y][tmp_x].NoChara(air);
                    }
                    CpCanvas::panel[pos_y][pos_x].on_chara = 2 + ene_id;
                    ++tmp_cnt; move_cnt = 0;
                    if (tmp_cnt > 1 + (int)((CpCanvas::rand() & 0x7FFFFFFF) % 3)) {
                        waza_syu = (pos_y == Rock::pos_y) ? 0 :
                                   1 + (int)((CpCanvas::rand() & 0x7FFFFFFF) % 2);
                        tmp_cnt = 100;
                    }
                }
            }
        } else if (chara_no == 22) {
            if (move_cnt > 10 - tmp_lv && move_flg == 0 && joutai == 0) {
                move_cnt = 0;
                if (tmp_cnt > 15) {
                    Action(waza_syu);
                    wait_cnt = 30 - tmp_lv * 4;
                    if (tmp_cnt > 99) {
                        wait_cnt = 6;
                        tmp_cnt  = 10;
                        move_cnt = 10 - tmp_lv - 5;
                    } else {
                        tmp_cnt = 0; move_cnt = 0;
                    }
                } else {
                    int start = (CpCanvas::rand() & 0x7FFFFFFF) % 4;
                    int dirs[8]= {-1,0,0,-1,1,0,0,1};
                    for (int i = 0; i < 4; ++i) {
                        int d = (start + i) % 4;
                        if (Check(dirs[d*2], dirs[d*2+1]) == 0) continue;
                        int na = CpCanvas::AtaNo(0);
                        CpCanvas::ata[na]->Set(59, pos_x, pos_y, 0, 2);
                        move_flg = d + 1;
                        break;
                    }
                    ++tmp_cnt;
                    if (tmp_cnt >= (int)((CpCanvas::rand() & 0x7FFFFFFF) % 3) + 3) {
                        if (tmp_cnt > 10) {
                            waza_syu = 3; tmp_cnt = 16;
                        } else {
                            waza_syu = (int)((CpCanvas::rand() & 0x7FFFFFFF) % 4) *
                                       (int)((CpCanvas::rand() & 0x7FFFFFFF) % 2);
                            tmp_cnt = 16;
                            if (waza_syu == 3) tmp_cnt = 100;
                        }
                    }
                }
            }
        } else if (chara_no == 23) {
            if (move_cnt > 12 - tmp_lv * 2 && move_flg == 0 && joutai == 0) {
                if (tmp_cnt > 15) {
                    muteki2 = 1;
                    Action(waza_syu);
                    wait_cnt = 30 + 35 * waza_syu - tmp_lv * 2;
                    tmp_cnt = 0; move_cnt = 0;
                } else {
                    int v = PaneRan(0); muteki2 = 0;
                    if (v < 100) {
                        int na = CpCanvas::AtaNo(0);
                        CpCanvas::ata[na]->Set(59, pos_x, pos_y, 0, 2);
                        pos_x = v % 6; pos_y = v / 6;
                        StBom(pos_x, pos_y);
                        CpCanvas::panel[tmp_y][tmp_x].NoChara(air);
                    }
                    CpCanvas::panel[pos_y][pos_x].on_chara = 2 + ene_id;
                    ++tmp_cnt; move_cnt = 0;
                    if (tmp_cnt > 1 + (int)((CpCanvas::rand() & 0x7FFFFFFF) % 3)) {
                        waza_syu = 1 - (int)((CpCanvas::rand() & 0x7FFFFFFF) % 3) / 2;
                        tmp_cnt  = 100;
                    }
                }
            }
        } else if (chara_no == 24) {
            if (move_cnt > 12 - tmp_lv * 2 && move_flg == 0 && joutai == 0) {
                if (tmp_cnt > 15) {
                    Action(waza_syu);
                    wait_cnt = 45 - tmp_lv * 2;
                    if (waza_syu == 0) muteki2 = 1;
                    tmp_cnt = 0; move_cnt = 0;
                } else {
                    int v = PaneRan(0); muteki2 = 0;
                    if (v < 100) {
                        int na = CpCanvas::AtaNo(0);
                        CpCanvas::ata[na]->Set(59, pos_x, pos_y, 0, 2);
                        pos_x = v % 6; pos_y = v / 6;
                        StBom(pos_x, pos_y);
                        CpCanvas::panel[tmp_y][tmp_x].NoChara(air);
                    }
                    CpCanvas::panel[pos_y][pos_x].on_chara = 2 + ene_id;
                    ++tmp_cnt; move_cnt = 0;
                    if (tmp_cnt > 2 + (int)((CpCanvas::rand() & 0x7FFFFFFF) % 3)) {
                        waza_syu = (CpCanvas::rand() & 0x7FFFFFFF) % 3;
                        tmp_cnt = 100;
                    }
                }
            }
        } else if (chara_no == 25) {
            if (move_cnt > 12 - tmp_lv * 2 && move_flg == 0 && joutai == 0) {
                if (tmp_cnt > 15) {
                    Action(waza_syu);
                    wait_cnt = 30 - tmp_lv * 2;
                    tmp_cnt = 0; move_cnt = 0;
                } else {
                    int v = PaneRan(0);
                    if (v < 100) {
                        int na = CpCanvas::AtaNo(0);
                        CpCanvas::ata[na]->Set(59, pos_x, pos_y, 0, 2);
                        pos_x = v % 6; pos_y = v / 6;
                        StBom(pos_x, pos_y);
                        CpCanvas::panel[tmp_y][tmp_x].NoChara(air);
                    }
                    CpCanvas::panel[pos_y][pos_x].on_chara = 2 + ene_id;
                    ++tmp_cnt; move_cnt = 0;
                    // Check for proximity to Rock
                    if ((CpCanvas::rand() & 0x7FFFFFFF) % 4 != 0 &&
                        pos_x - 1 == Rock::pos_x) {
                        if (pos_y == Rock::pos_y) {
                            waza_syu = 3; tmp_cnt = 100;
                        } else if (tmp_cnt > (int)((CpCanvas::rand() & 0x7FFFFFFF) % 2)) {
                            waza_syu = (CpCanvas::rand() & 0x7FFFFFFF) % 3 /
                                       (2 - tmp_lv / 2);
                            tmp_cnt = 100;
                        }
                    }
                }
            }
        } else if (chara_no == 26) {
            if (move_cnt > 12 - tmp_lv * 2 && move_flg == 0 && joutai == 0) {
                if (tmp_cnt > 15) {
                    Action(waza_syu);
                    wait_cnt = 30 - tmp_lv * 2;
                    if (waza_syu == 1) {
                        int na = CpCanvas::AtaNo(0);
                        CpCanvas::ata[na]->Set(59, pos_x, pos_y, 0, 2);
                        def_x = pos_x; def_y = pos_y;
                    }
                    tmp_cnt = 0; move_cnt = 0;
                } else {
                    int v = PaneRan(0);
                    if (v < 100) {
                        int na = CpCanvas::AtaNo(0);
                        CpCanvas::ata[na]->Set(59, pos_x, pos_y, 0, 2);
                        pos_x = v % 6; pos_y = v / 6;
                        StBom(pos_x, pos_y);
                        CpCanvas::panel[tmp_y][tmp_x].NoChara(air);
                    }
                    CpCanvas::panel[pos_y][pos_x].on_chara = 2 + ene_id;
                    ++tmp_cnt; move_cnt = 0;
                    if (tmp_cnt > 1 + (int)((CpCanvas::rand() & 0x7FFFFFFF) % 3)) {
                        waza_syu = (CpCanvas::rand() & 0x7FFFFFFF) % 2;
                        tmp_cnt  = 100;
                    }
                }
            }
        } else if (chara_no == 27) {
            if (move_cnt > 12 - tmp_lv * 2 && move_flg == 0 && joutai == 0) {
                if (tmp_cnt > 15) {
                    Action(waza_syu);
                    wait_cnt = 30 - tmp_lv * 2;
                    if (waza_syu == 1) {
                        int na = CpCanvas::AtaNo(0);
                        CpCanvas::ata[na]->Set(59, pos_x, pos_y, 0, 2);
                        def_x = pos_x; def_y = pos_y;
                    }
                    tmp_cnt = 0; move_cnt = 0;
                } else {
                    int v = PaneRan(0);
                    if (v < 100) {
                        int na = CpCanvas::AtaNo(0);
                        CpCanvas::ata[na]->Set(59, pos_x, pos_y, 0, 2);
                        pos_x = v % 6; pos_y = v / 6;
                        StBom(pos_x, pos_y);
                        CpCanvas::panel[tmp_y][tmp_x].NoChara(air);
                    }
                    CpCanvas::panel[pos_y][pos_x].on_chara = 2 + ene_id;
                    ++tmp_cnt; move_cnt = 0;
                    if (tmp_cnt > 2 + (int)((CpCanvas::rand() & 0x7FFFFFFF) % 3)) {
                        if ((CpCanvas::rand() & 0x7FFFFFFF) % 4 == 0 ||
                            pos_y == Rock::pos_y) {
                            waza_syu = 0; move_cnt = -5;
                        } else if ((CpCanvas::rand() & 0x7FFFFFFF) % 3 != 0 && pos_y != 1) {
                            waza_syu = 2; move_cnt = -5;
                        } else {
                            waza_syu = 1;
                        }
                        tmp_cnt = 100;
                    }
                }
            }
        } else if (chara_no == 28) {
            if (move_cnt > 12 - tmp_lv * 2 && move_flg == 0 && joutai == 0) {
                if (tmp_cnt > 15) {
                    Action(waza_syu);
                    wait_cnt = 30 - tmp_lv * 2;
                    tmp_cnt = 0; move_cnt = 0;
                } else {
                    int v = PaneRan(0);
                    if (v < 100) {
                        int na = CpCanvas::AtaNo(0);
                        CpCanvas::ata[na]->Set(59, pos_x, pos_y, 0, 2);
                        pos_x = v % 6; pos_y = v / 6;
                        StBom(pos_x, pos_y);
                        CpCanvas::panel[tmp_y][tmp_x].NoChara(air);
                    }
                    CpCanvas::panel[pos_y][pos_x].on_chara = 2 + ene_id;
                    ++tmp_cnt; move_cnt = 0;
                    if (tmp_cnt > 1 + (int)((CpCanvas::rand() & 0x7FFFFFFF) % 3)) {
                        waza_syu = (pos_y == Rock::pos_y) ? 0 :
                                   1 + (int)((CpCanvas::rand() & 0x7FFFFFFF) % (1 + tmp_lv / 2 * 2));
                        tmp_cnt = 100;
                    }
                }
            }
        } else if (chara_no == 29) {
            if (move_cnt > 10 - tmp_lv * 2 && move_flg == 0 && joutai == 0) {
                if (tmp_cnt > 15) {
                    Action(waza_syu);
                    wait_cnt = 30 - tmp_lv * 4;
                    tmp_cnt = 0; move_cnt = 0;
                } else {
                    int v = PaneRan(0);
                    if (v < 100) {
                        int na = CpCanvas::AtaNo(0);
                        CpCanvas::ata[na]->Set(59, pos_x, pos_y, 0, 2);
                        pos_x = v % 6; pos_y = v / 6;
                        StBom(pos_x, pos_y);
                        CpCanvas::panel[tmp_y][tmp_x].NoChara(air);
                    }
                    CpCanvas::panel[pos_y][pos_x].on_chara = 2 + ene_id;
                    ++tmp_cnt; move_cnt = 0;
                    if (tmp_cnt > 1 + (int)((CpCanvas::rand() & 0x7FFFFFFF) % 2)) {
                        if (tmp_cnt2 == 0) {
                            waza_syu = (CpCanvas::rand() & 0x7FFFFFFF) % 3;
                        } else {
                            waza_syu = (int)((CpCanvas::rand() & 0x7FFFFFFF) % 2) * 2;
                            ++tmp_cnt2;
                        }
                        if (waza_syu == 1) tmp_cnt2 = 1;
                        if (tmp_cnt2 == 3) tmp_cnt2 = 0;
                        tmp_cnt = 100;
                    }
                }
            }
        } else if (chara_no == 30) {
            if (move_cnt > 8 - tmp_lv && move_flg == 0 && joutai == 0) {
                if (tmp_cnt > 15) {
                    Action(waza_syu);
                    wait_cnt = 10 - tmp_lv;
                    tmp_cnt = 0; move_cnt = 0;
                } else {
                    int v = PaneRan(0);
                    if (v < 100) {
                        int na = CpCanvas::AtaNo(0);
                        CpCanvas::ata[na]->Set(59, pos_x, pos_y, 0, 2);
                        pos_x = v % 6; pos_y = v / 6;
                        StBom(pos_x, pos_y);
                        CpCanvas::panel[tmp_y][tmp_x].NoChara(air);
                    }
                    CpCanvas::panel[pos_y][pos_x].on_chara = 2 + ene_id;
                    ++tmp_cnt; move_cnt = 0;
                    if (tmp_cnt > 1 + (int)((CpCanvas::rand() & 0x7FFFFFFF) % 2)) {
                        waza_syu = 1 - (int)((CpCanvas::rand() & 0x7FFFFFFF) % 4) / 3;
                        if (waza_syu == 1 && CpCanvas::ene[1]->on != 0) waza_syu = 0;
                        tmp_cnt = 100;
                    }
                }
            }
        } else if (chara_no == 31) {
            if (move_cnt > 8 - tmp_lv && move_flg == 0 && joutai == 0) {
                if (tmp_cnt > 15) {
                    Action(waza_syu);
                    wait_cnt = 10 - tmp_lv;
                    tmp_cnt = 0; move_cnt = 0;
                } else {
                    int v = PaneRan(0);
                    if (v < 100) {
                        int na = CpCanvas::AtaNo(0);
                        CpCanvas::ata[na]->Set(59, pos_x, pos_y, 0, 2);
                        pos_x = v % 6; pos_y = v / 6;
                        StBom(pos_x, pos_y);
                        CpCanvas::panel[tmp_y][tmp_x].NoChara(air);
                    }
                    CpCanvas::panel[pos_y][pos_x].on_chara = 2 + ene_id;
                    ++tmp_cnt; move_cnt = 0;
                    if (tmp_cnt > (int)((CpCanvas::rand() & 0x7FFFFFFF) % 2)) {
                        waza_syu = 1 - (int)((CpCanvas::rand() & 0x7FFFFFFF) % 4) / 3;
                        if (waza_syu == 1 && CpCanvas::ene[1]->on != 0) waza_syu = 0;
                        tmp_cnt = 100;
                    }
                }
            }
        } else if (chara_no == 32) {
            air = 1;
            if (move_cnt > 12 - tmp_lv * 2 && move_flg == 0 && joutai == 0) {
                if (tmp_cnt > 15) {
                    Action(waza_syu);
                    wait_cnt = 50 - tmp_lv * 2;
                    tmp_cnt = 0; move_cnt = 0;
                } else {
                    move_cnt = 0; ++tmp_cnt;
                    if (tmp_cnt > (int)((CpCanvas::rand() & 0x7FFFFFFF) % 2)) {
                        waza_syu = (CpCanvas::oki[2]->hp > 0)
                            ? ((CpCanvas::ene[1]->on == 0)
                               ? 2 - (int)((CpCanvas::rand() & 0x7FFFFFFF) % 4) / 3 * 2
                               : 1 + (int)((CpCanvas::rand() & 0x7FFFFFFF) % 2))
                            : 2 + (int)((CpCanvas::rand() & 0x7FFFFFFF) % 5) / 4;
                        tmp_cnt = 100;
                    }
                }
            }
        } else if (chara_no == 33) {
            if (move_cnt > 10 - tmp_lv * 2 && move_flg == 0 && joutai == 0) {
                if (tmp_cnt > 15) {
                    Action(waza_syu);
                    wait_cnt = 25 - tmp_lv * 2;
                    if (waza_syu == 2) {
                        int na = CpCanvas::AtaNo(0);
                        CpCanvas::ata[na]->Set(59, pos_x, pos_y, 0, 2);
                        def_x = pos_x; def_y = pos_y;
                    }
                    tmp_cnt = 0; move_cnt = 0;
                } else {
                    int v = PaneRan(0);
                    if (v < 100) {
                        int na = CpCanvas::AtaNo(0);
                        CpCanvas::ata[na]->Set(59, pos_x, pos_y, 0, 2);
                        pos_x = v % 6; pos_y = v / 6;
                        StBom(pos_x, pos_y);
                        CpCanvas::panel[tmp_y][tmp_x].NoChara(air);
                    }
                    CpCanvas::panel[pos_y][pos_x].on_chara = 2 + ene_id;
                    ++tmp_cnt; move_cnt = 0;
                    if (tmp_cnt > 1 + (int)((CpCanvas::rand() & 0x7FFFFFFF) % 3)) {
                        waza_syu = (pos_y == Rock::pos_y) ? 0 :
                                   1 + (int)((CpCanvas::rand() & 0x7FFFFFFF) % (1 + tmp_lv / 2 * 2));
                        tmp_cnt = 100;
                    }
                }
            }
        }

        // ── Waza firing ───────────────────────────────────────────────────
        if (waza_flg >= 0) {
            if (waza_wait == 0) {
                int na = CpCanvas::AtaNo(0);
                CpCanvas::ata[na]->Set(waza_flg, pos_x, pos_y, 0, 1);
                CpCanvas::ata[na]->pow  = pow[4];
                CpCanvas::ata[na]->zoku = waza_zoku[4];
                if (Rock::wana == waza_zoku[4]) {
                    CpCanvas::wana_flg = waza_zoku[4];
                    Rock::wana = 0;
                }
                int ht = CpCanvas::ata[na]->hit_time;
                if (ht != 0) {
                    CpCanvas::stop_time = ht;
                    CpCanvas::eff_id    = na;
                    CpCanvas::stop_ch   = 1;
                    CpCanvas::stop_name = CpCanvas::waza_str[chara_no / 31 + waza_syu / 3];
                }
                if (chara_no == 12 || chara_no == 13 || chara_no == 15 ||
                    (chara_no == 26 && waza_syu == 1) ||
                    (chara_no == 27 && waza_syu == 1) ||
                    (chara_no == 33 && waza_syu == 2)) {
                    ata_id = na;
                    CpCanvas::ata[na]->hon_id = ene_id;
                }
                waza_flg = -1;
            }
            --waza_wait;
        }

        // ── Smooth movement (fractional) ──────────────────────────────────
        if (move_flg > 5) {
            if (move_flg == 6) {
                pos_dx -= x_sp;
                if (pos_dx <= -20) { pos_dx = 20; --pos_x; }
                if (pos_dx == 0)   move_flg += 5;
            } else if (move_flg == 8) {
                pos_dx += x_sp;
                if (pos_dx >= 20) { pos_dx = -20; ++pos_x; }
                if (pos_dx == 0)  move_flg += 5;
            } else if (move_flg == 7) {
                pos_dy -= y_sp;
                if (pos_dy <= -12) { pos_dy = 12; --pos_y; }
                if (pos_dy == 0)   move_flg += 5;
            } else if (move_flg == 9) {
                pos_dy += y_sp;
                if (pos_dy >= 12) { pos_dy = -12; ++pos_y; }
                if (pos_dy == 0)  move_flg += 5;
            }
            if (move_flg > 10) {
                if (zoku != 2 && CpCanvas::panel[pos_y][pos_x].jou == 5 && air != 0) {
                    tmp_x = pos_x; tmp_y = pos_y;
                    bool slip = (move_flg - 10 == 1 && Check(-1, 0) == 0) ||
                                (move_flg - 10 == 3 && Check( 1, 0) == 0) ||
                                (move_flg - 10 == 2 && Check(0,-1) == 0) ||
                                (move_flg - 10 == 4 && Check(0, 1) == 0);
                    move_flg = slip ? 0 : (move_flg -= 10);
                } else {
                    move_flg = 0;
                }
            }
        }

        if (move_flg != 0) {
            if      (move_flg == 1) { pos_dx -= x_sp; if (pos_dx < -20) { --pos_x; move_flg += 10; } }
            else if (move_flg == 3) { pos_dx += x_sp; if (pos_dx >  20) { ++pos_x; move_flg += 10; } }
            else if (move_flg == 2) { pos_dy -= y_sp; if (pos_dy < -12) { --pos_y; move_flg += 10; } }
            else if (move_flg == 4) { pos_dy += y_sp; if (pos_dy >  12) { ++pos_y; move_flg += 10; } }

            if (move_flg > 10) {
                pos_dx = 0; pos_dy = 0;
                if (zoku != 2 && CpCanvas::panel[pos_y][pos_x].jou == 5) {
                    tmp_x = pos_x; tmp_y = pos_y;
                    if ((move_flg - 10 == 1 && Check(-1, 0) == 0) ||
                        (move_flg - 10 == 3 && Check( 1, 0) == 0) ||
                        (move_flg - 10 == 2 && Check(0,-1) == 0) ||
                        (move_flg - 10 == 4 && Check(0, 1) == 0)) {
                        move_flg = 0;
                    } else {
                        move_flg -= 10;
                        tmp_x = pos_x; tmp_y = pos_y;
                    }
                } else {
                    move_flg = 0;
                }
            } else if (move_flg < 5) {
                move_flg += 5;
            }
        }
    } // end if (ani_wait_cnt == 0)

    if (ani_wait_cnt <= 0) {
        if (wait_cnt == 0) ++move_cnt;
        if (wait_cnt > 0)  --wait_cnt;
    } else {
        --ani_wait_cnt;
    }

    if (bari_id >= 0) {
        CpCanvas::ata[bari_id]->pos_x = pos_x;
        CpCanvas::ata[bari_id]->pos_y = pos_y;
    }
    if (mahi_id >= 0) {
        CpCanvas::ata[mahi_id]->pos_x = pos_x;
        CpCanvas::ata[mahi_id]->pos_y = pos_y;
    }
    return 0;
}

// ── PaneRan ─────────────────────────────────────────────────────────────────
int Ene::PaneRan(int n) {
    int nArray[18] = {};
    int n2 = 0;
    for (int i = 0; i < 18; ++i) {
        bool bl = false;
        int n3 = CpCanvas::panel[i / 6][i % 6].on_chara - 10;
        if (n3 >= 0 && CpCanvas::oki[n3]->on != 0 && CpCanvas::oki[n3]->move_ok != 0)
            bl = true;
        if (CpCanvas::panel[i / 6][i % 6].jin != 1 ||
            CpCanvas::panel[i / 6][i % 6].jou <= 0 ||
            (CpCanvas::panel[i / 6][i % 6].on_chara != 0 && !bl)) continue;
        bl = true;
        if (n == 1 && Rock::pos_y == i / 6) bl = false;
        if (n == 2 && i % 6 != 5) bl = false;
        if (!bl) continue;
        nArray[n2] = i;
        ++n2;
    }
    if (n2 == 0) return 100;
    return nArray[(CpCanvas::rand() & 0x7FFFFFFF) % n2];
}

// ── StBom ───────────────────────────────────────────────────────────────────
bool Ene::StBom(int n, int n2) {
    int n3 = CpCanvas::panel[n2][n].on_chara - 10;
    if (n3 >= 0 && CpCanvas::oki[n3]->on != 0 &&
        CpCanvas::oki[n3]->move_ok != 0 && CpCanvas::oki[n3]->syu == 0) {
        CpCanvas::panel[n2][n].bom_pow = CpCanvas::oki[n3]->pow;
        CpCanvas::oki[n3]->on = 0;
        CpCanvas::panel[CpCanvas::oki[n3]->pos_y][CpCanvas::oki[n3]->pos_x].on_chara = 0;
        return false;
    }
    return true;
}

// ── PaneCh ───────────────────────────────────────────────────────────────────
void Ene::PaneCh() {
    pane_id = CpCanvas::panel[pos_y][pos_x].jou;
    if (muteki2 != 0) return;
    if (CpCanvas::panel[pos_y][pos_x].bom_pow > 0) {
        Hit(1, CpCanvas::panel[pos_y][pos_x].bom_pow, 0);
        EffSet(4);
        CpCanvas::panel[pos_y][pos_x].bom_pow = 0;
    }
    if (air != 0) return;
    if (pane_id == 3) {
        if (zoku != 1 && Hit(1, 50, 1)) {
            EffSet(8);
            CpCanvas::panel[pos_y][pos_x].Henka(1, 0);
        }
    } else if (pane_id == 4) {
        if (zoku == 4) {
            hp += CpCanvas::game_cnt % 2;
            if (hp > max_hp) hp = max_hp;
        }
    } else if (pane_id == 6 && CpCanvas::game_cnt % 2 == 0) {
        int n = bari; bari = 0;
        Hit(0, 1, 0);
        hit_cnt = 0;
        bari = n;
    }
}

// ── Check ────────────────────────────────────────────────────────────────────
int Ene::Check(int n, int n2) {
    int n3 = pos_x + n;
    int n4 = pos_y + n2;
    if (n3 < 0 || n3 > 5 || n4 < 0 || n4 > 2) return 0;
    if (CpCanvas::panel[n4][n3].jin == 0)       return 0;
    if (air == 0 && CpCanvas::panel[n4][n3].jou <= 0) return 0;
    if (CpCanvas::panel[n4][n3].on_chara != 0 && StBom(n3, n4)) return 0;
    CpCanvas::panel[n4][n3].on_chara = 2 + ene_id;
    CpCanvas::panel[tmp_y][tmp_x].NoChara(air);
    return 1;
}

// ── NextChara ────────────────────────────────────────────────────────────────
void Ene::NextChara(int n) {
    int n2 = (ene_id + 1) % 3;
    for (int i = n2; i < n2 + 3; ++i) {
        if (CpCanvas::ene[i % 3]->chara_no != chara_no) continue;
        if (n != 0) break;
        CpCanvas::ene[i % 3]->wait_cnt = 10;
        break;
    }
}

// ── Hit ──────────────────────────────────────────────────────────────────────
bool Ene::Hit(int n, int n2, int n3) {
    if ((muteki_cnt > 0 || muteki2 != 0) && CpCanvas::stop_cnt == 0) return false;
    if (Rock::hp == 0) return false;

    if (zoku != 0 && zoku % 4 + 1 == n3) { n2 *= 2; EffSet(39); }
    if (pane_id == 7) n2 = (n2 + 1) / 2;

    if (bari > 0) {
        bari -= n2;
        if (bari <= 0) {
            bari = 0;
            if (chara_no == 12) {
                def_ani = 5; joutai = 0; AniSet(7);
                return true;
            }
            CpCanvas::ata[bari_id]->init();
            bari_id = -1;
        }
        return true;
    }

    hp -= n2;
    if (hp <= 0) Syoumetu();

    int n4 = ani_wait_cnt;
    if (n == 1) muteki_cnt = 30;
    if (chara_no != 12 && chara_no != 13 && chara_no != 15 && chara_no != 32) {
        if (n > 0) ani_wait_cnt = 15;
        if (n == 3) {
            ani_wait_cnt = 25;
            if (mahi_id < 0) mahi_id = CpCanvas::AtaNo(0);
            CpCanvas::ata[mahi_id]->Set(88, pos_x, pos_y, 0, 3);
            CpCanvas::ata[mahi_id]->pos_dx = 0;
            CpCanvas::ata[mahi_id]->pos_dy = 0;
        }
    }
    if (chara_no == 12) muteki_cnt = 0;
    if (n2 > 0 && CpCanvas::stop_cnt == 0) hit_cnt = 1;
    if (CpCanvas::stop_cnt != 0) {
        tmp_muteki_cnt = muteki_cnt;
        muteki_cnt     = 0;
    }
    if (chara_no == 32) { ani_wait_cnt = n4; n = 0; }
    if (navi_flg != 0 && n > 0 && (ata_id < 0 || CpCanvas::stop_cnt == 0)) {
        if (ata_id >= 0) CpCanvas::ata[ata_id]->init();
        move_flg = 0; waza_flg = -1; joutai = 0;
        AniSet(2);
        tmp_wait_cnt = ani_wait_cnt;
    }
    return true;
}

// ── Syoumetu ─────────────────────────────────────────────────────────────────
void Ene::Syoumetu() {
    int n;
    joutai = 0;
    if (chara_no == 12)               AniSet(6);
    if (chara_no == 13 || chara_no == 15) AniSet(0);
    if (navi_flg != 0) { joutai = 0; AniSet(2); }
    hp = 0;
    if (ata_id >= 0) {
        CpCanvas::ata[ata_id]->hon_id = -1;
        CpCanvas::ata[ata_id]->init();
    }
    if (CpCanvas::combo_cnt != 0) ++CpCanvas::combo;
    CpCanvas::combo_cnt = 3;
    if (--CpCanvas::ene_cnt == 0) {
        CpCanvas::dell_cnt = 20;
        for (n = 0; n < 30; ++n) {
            if (CpCanvas::ata[n]->chara_flg != 1) continue;
            CpCanvas::ata[n]->on = 0;
        }
        CpCanvas::ata_cnt = 0;
    }
    syoumetu_cnt  = 15;
    muteki_cnt    = 15;
    ani_wait_cnt  = 15;
    for (n = 0; n < 18; ++n) {
        if (CpCanvas::panel[n / 6][n % 6].on_chara != ene_id + 2) continue;
        CpCanvas::panel[n / 6][n % 6].NoChara(air);
    }
    if (wait_cnt >= 0) NextChara(chara_no);
    if (chara_no > 30) {
        CpCanvas::combo = 0;
        if (CpCanvas::ene[1]->on != 0) CpCanvas::ene[1]->Syoumetu();
        CpCanvas::combo = 0;
        if (CpCanvas::ene[2]->on != 0) CpCanvas::ene[2]->Syoumetu();
    }
}

// ── Off ──────────────────────────────────────────────────────────────────────
void Ene::Off() {
    if (wait_cnt >= 0) NextChara(chara_no);
    move_cnt = 0; move_flg = 0; wait_cnt = 0;
    pos_x = 0;   pos_y = 0;
    on = 0; chara_no = -1; chara_id = 0;
    if (mahi_id >= 0) CpCanvas::ata[mahi_id]->init();
    mahi_id = -1;
}

// ── EffSet ────────────────────────────────────────────────────────────────────
void Ene::EffSet(int n) {
    int n2 = CpCanvas::AtaNo(0);
    CpCanvas::ata[n2]->Set(n, pos_x, pos_y, 0, 3);
}

// ── Action ────────────────────────────────────────────────────────────────────
void Ene::Action(int n) {
    waza_id[4]   = waza_id[n] + 188;
    pow[4]       = pow[n];
    waza_zoku[4] = waza_zoku[n];
    AniSet(CpCanvas::waza[waza_id[4]]->move_id);
    waza_wait = CpCanvas::waza[waza_id[4]]->wait_cnt;
    waza_flg  = waza_id[4];
}

// ── Get ───────────────────────────────────────────────────────────────────────
int Ene::Get(int n, int n2) {
    if (n == 0) {
        if (navi_flg != 0) {
            if (CpCanvas::ghost >= 0) {
                int n3 = CpCanvas::ghost;
                CpCanvas::navi_flg[n3] = CpCanvas::navi_flg[n3] + 1;
                if (CpCanvas::navi_flg[CpCanvas::ghost] > 3)
                    CpCanvas::navi_flg[CpCanvas::ghost] = 3;
            }
            CpCanvas::ghost = -1;
            if (CpCanvas::teki_pt < 296 && CpCanvas::teki_pt != 293) return 0;
            if (tmp_lv < 3)   return drop_tip[0];
            if (n2 > 10)      return drop_tip[0];
            if (n2 > 9)       return drop_tip[1];
            if (n2 > 7)       return drop_tip[2];
            if (n2 > 5)       return drop_tip[3];
        } else {
            int n4 = 0;
            if (n2 > 5)  n4 = drop_tip[3];
            if (n2 > 7)  n4 = drop_tip[2];
            if (n2 > 9)  n4 = drop_tip[1];
            if (n2 > 10) n4 = drop_tip[0];
            if ((int)((CpCanvas::rand() & 0x7FFFFFFF) % 100) < 45 + n2 * 5 ||
                CpCanvas::skill_kouka[11] != 0) {
                return n4;
            }
        }
        return 0;
    }
    if (n == 1) {
        if (CpCanvas::skill_kouka[12] != 0) zenny *= 2;
        return zenny;
    }
    if (n == 2) {
        int n5 = (CpCanvas::rand() & 0x7FFFFFFF) % 80;
        if ((n5 += hp / 10) > 70) return 1;
    }
    return 0;
}

// ── Loop ─────────────────────────────────────────────────────────────────────
void Ene::Loop() {
    ani_ok = 1;
    if (--s_wait < 0) {
        s_wait = 0;
        if (r_suu != 0) {
            if (ani_cnt == r_e + 1) {
                ani_cnt = r_s;
                if (--r_suu < 0) r_suu = 0;
            }
        } else if (CpCanvas::ani[ani_id][ani_pt[0]][ani_cnt + 1] == -2) {
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

// ── HpDraw ───────────────────────────────────────────────────────────────────
void Ene::HpDraw() {
    if (hp <= 0)    return;
    if (muteki2 != 0) return;
    int n  = pos_x * 40 + pos_dx;
    int n2 = pos_y * 24 + 24 - 10 + 105 + pos_dy;
    CpCanvas::ImgSuu(hp, n, n2, 40, 2, 0);
}

// ── Draw ─────────────────────────────────────────────────────────────────────
void Ene::Draw(int n) {
    int n2 = (muteki_cnt % 2 << 4) + (hit_cnt << 4);
    tmp_s_wait = s_wait;
    tmp_r_suu  = r_suu;
    tmp_e_wait = e_wait;
    if (n != 0) Loop();
    for (int i = 0; i < ani_max; ++i) {
        if (-2 != CpCanvas::Ani(ani_id, ani_pt[i], ani_cnt,
                                 pos_x, pos_y + n2,
                                 pos_dx + tmp_wait_cnt % 3, pos_dy, 0)) continue;
        if (ani_pt[0] != 0) {
            AniSet(def_ani);
        } else {
            ani_cnt = 0;
        }
        CpCanvas::Ani(ani_id, ani_pt[i], ani_cnt,
                      pos_x, pos_y + n2,
                      pos_dx + tmp_wait_cnt % 3, pos_dy, 0);
    }
    t_ani_cnt = ani_cnt;
    if (tmp_wait_cnt == 0 && ani_ok != 0) ani_cnt += n;
    tmp_wait_cnt = ani_wait_cnt;
}
