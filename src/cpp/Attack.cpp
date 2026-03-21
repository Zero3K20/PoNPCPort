#include "Attack.h"
#include "CpCanvas_fwd.h"
#include "Waza.h"
#include "Rock.h"
#include "Ene.h"
#include "BtPanel.h"
#include "Okimono.h"
#include "Tip.h"

Attack::Attack(int n) {
    ata_id = n;
    ani_cnt = 0;
    on = 0;
}

void Attack::init() {
    if (on != 0) {
        --CpCanvas::ata_cnt;
    }
    on = 0;
    if (hon_id >= 0 && CpCanvas::ene[hon_id]->on != 0) {
        CpCanvas::ene[hon_id]->pos_x = CpCanvas::ene[hon_id]->def_x;
        CpCanvas::ene[hon_id]->pos_y = CpCanvas::ene[hon_id]->def_y;
        CpCanvas::ene[hon_id]->pos_dx = 0;
        CpCanvas::ene[hon_id]->pos_dy = 0;
        CpCanvas::ene[hon_id]->move_cnt = 0;
        if (CpCanvas::ene[hon_id]->chara_no == 12) {
            CpCanvas::ene[hon_id]->wait_cnt = 8;
            CpCanvas::ene[hon_id]->move_cnt = 1;
            CpCanvas::ene[hon_id]->tmp_cnt = 0;
        }
        CpCanvas::ene[hon_id]->joutai = 0;
        CpCanvas::ene[hon_id]->AniSet(CpCanvas::ene[hon_id]->def_ani);
        CpCanvas::ene[hon_id]->ata_id = -1;
    }
    if (ata_id == Rock::bas_no) {
        Rock::bas_no = -1;
    }
    if (ata_id == Rock::mahi_id) {
        Rock::mahi_id = -1;
    }
    for (int i = 0; i < 3; ++i) {
        if (ata_id != CpCanvas::ene[i]->mahi_id) continue;
        CpCanvas::ene[i]->mahi_id = -1;
    }
    if (param[8] == 5) {
        CpCanvas::panel[pos_y][pos_x].hokkei = 0;
    }
}

int Attack::Set(int n, int n2, int n3, int n4, int n5) {
    if (n2 < 0 || n2 > 5 || n3 < 0 || n3 > 2) {
        --CpCanvas::ata_cnt;
        return -1;
    }
    loop_flg = 0;
    pos_x = n2;
    pos_y = n3;
    pos_dx = 0;
    pos_dy = 0;
    chara_flg = n5;
    flp = n4;
    tmp_id = n;
    hit_time = 0;
    on = 1;
    zoku = 0;
    hon_id = -1;
    ren_hit = 0;
    if (n5 == -2) {
        waza_id = n;
        WazaSet();
    } else if (n5 == 0) {
        pow = CpCanvas::tip[n]->pow + Rock::pow[3];
        zoku = CpCanvas::tip[n]->zoku;
        waza_id = CpCanvas::tip[n]->waza_id;
        if (n < 2) {
            pow *= CpCanvas::ata_lv;
        }
        Rock::pow[3] = 0;
        WazaSet();
    } else if (n5 == 1) {
        waza_id = n;
        WazaSet();
    } else if (n5 == 2) {
        pos_dx = (int)((unsigned int)(CpCanvas::rand()) >> 1) % 6 - 3;
        pos_dy = (int)((unsigned int)(CpCanvas::rand()) >> 1) % 8;
        eff_id = n;
    } else if (n5 == 3) {
        eff_id = n;
        pos_dx = (int)((unsigned int)(CpCanvas::rand()) >> 1) % 10 - 5;
        pos_dy = (int)((unsigned int)(CpCanvas::rand()) >> 1) % 25 - 25;
    }
    EffSet();
    stop = 0;
    ani_cnt = 0;
    ani_ok = 1;
    move_cnt = 0;
    move_flg = 0;
    move_x = 0;
    move_y = 0;
    hit_flg = 0;
    oki_hit = 0;
    tmp_s_wait = s_wait;
    tmp_r_suu = r_suu;
    tmp_e_wait = e_wait;
    t_ani_cnt = ani_cnt;
    return 1;
}

void Attack::EffSet() {
    ani_id = CpCanvas::eff_mo[eff_id * 3];
    ani_pt = CpCanvas::eff_mo[eff_id * 3 + 1];
    int n = CpCanvas::eff_mo[eff_id * 3 + 2];
    s_wait = CpCanvas::wait_data[n * 5];
    e_wait = CpCanvas::wait_data[n * 5 + 1];
    r_suu = CpCanvas::wait_data[n * 5 + 2];
    r_s = CpCanvas::wait_data[n * 5 + 3];
    r_e = CpCanvas::wait_data[n * 5 + 4];
    se_id = CpCanvas::eff_se[eff_id];
    if (e_wait > 254) {
        e_wait = -1;
    }
    if (r_suu > 99) {
        r_suu = -1;
    }
}

int Attack::CopySet(int n, int n2, int n3, int n4) {
    int n5 = CpCanvas::AtaNo(ata_id);
    if (CpCanvas::ata[n5]->Set(tmp_id, n, n2, flp, chara_flg) > 0) {
        CpCanvas::ata[n5]->zoku = zoku;
        if (n3 == 1) {
            CpCanvas::ata[n5]->hit_kou = n4;
            CpCanvas::ata[n5]->KouSet();
        } else if (n3 == 2) {
            CpCanvas::ata[n5]->pos_x = n;
            CpCanvas::ata[n5]->pos_y = n2;
            CpCanvas::ata[n5]->waza_id = n4;
            CpCanvas::ata[n5]->WazaSet();
            CpCanvas::ata[n5]->EffSet();
        } else if (n3 == 3) {
            CpCanvas::ata[n5]->pos_x = n;
            CpCanvas::ata[n5]->pos_y = n2;
            CpCanvas::ata[n5]->hit_kou = n4;
            CpCanvas::ata[n5]->KouSet();
        }
        CpCanvas::ata[n5]->pow = pow;
        CpCanvas::ata[n5]->hit_time = hit_time;
        return n5;
    }
    return -1;
}

void Attack::WazaSet() {
    eff_id = CpCanvas::waza[waza_id]->eff_id;
    yokoku = CpCanvas::waza[waza_id]->yokoku;
    hit_eff = CpCanvas::waza[waza_id]->hit_id;
    hit_param = CpCanvas::waza[waza_id]->noke_pt;
    hit_kan = CpCanvas::waza[waza_id]->kan;
    hit_ana = CpCanvas::waza[waza_id]->ana;
    hit_bure = CpCanvas::waza[waza_id]->bure;
    hit_kou = CpCanvas::waza[waza_id]->waza_kou;
    hit_time = CpCanvas::waza[waza_id]->stop_time;
    KouSet();
}

void Attack::KouSet() {
    for (int i = 0; i < 12; ++i) {
        param[i] = Waza::data[hit_kou * 3 + i / 4] >> i % 4 * 8 & 0xFF;
    }
    PosSet(param[9]);
    HitSet(param[0]);
    on += param[4];
}

void Attack::PosSet(int n) {
    if (n == 0) {
        return;
    }
    if (n == 1) {
        pos_x += flp * 2 - 1;
    } else if (n == 2) {
        pos_x += (flp * 2 - 1) * 2;
    } else if (n == 3) {
        pos_x += (flp * 2 - 1) * 3;
    } else if (n == 4) {
        pos_x += flp * 2 - 1;
        --pos_y;
    } else if (n == 5) {
        pos_x += (flp * 2 - 1) * 2;
        --pos_y;
    } else if (n == 6) {
        if (flp == 0) {
            int n2 = EneZa(-1);
            pos_x = n2 & 0xFF;
            pos_y = n2 >> 8;
        } else {
            pos_x = Rock::pos_x;
            pos_y = Rock::pos_y;
        }
    } else if (n == 7) {
        pos_x = flp * 5;
        pos_y = 0;
    } else if (n == 8) {
        for (int i = 0; i < 6; ++i) {
            if (flp == 0) {
                if (CpCanvas::panel[pos_y][5 - i].jin != 0) continue;
                pos_x = 5 - i;
            } else {
                if (CpCanvas::panel[pos_y][i].jin == 0) continue;
                pos_x = i;
            }
            break;
        }
    } else if (n == 9) {
        pos_x = flp * 5;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 6; ++j) {
                if (flp == 0) {
                    if (CpCanvas::panel[i][5 - j].jin != 0) continue;
                    if (pos_x >= 5 - j) goto lbl_block1_continue;
                    pos_x = 5 - j;
                    goto lbl_block1_continue;
                }
                if (CpCanvas::panel[i][j].jin == 0) continue;
                if (pos_x <= j) goto lbl_block1_continue;
                pos_x = j;
                goto lbl_block1_continue;
            }
            lbl_block1_continue:;
        }
        pos_y = 0;
    } else if (n == 10) {
        int n3 = PaneRan(flp, 1, 0);
        pos_x = n3 % 6;
        pos_y = n3 / 6;
    } else if (n == 12) {
        pos_x = 5 - flp * 5;
        pos_y = 0;
    } else if (n == 13) {
        pos_x = 5 - flp * 5;
        pos_y = flp * 2;
    } else if (n == 14) {
        pos_x = 5;
        pos_y += 1 + (int)((unsigned int)(CpCanvas::rand()) >> 1) % 2;
        pos_y %= 3;
    } else if (n == 15) {
        pos_x = Rock::pos_x + 1;
        pos_y = Rock::pos_y;
    } else if (n == 16) {
        int n4 = PaneRan(flp ^ 1, 1, 0);
        pos_x = n4 % 6;
        pos_y = n4 / 6;
    } else if (n == 17) {
        pos_x = 5;
        int n5 = EneZa(-1);
        pos_x = (n5 & 0xFF) - 1;
        pos_y = n5 >> 8;
    } else if (n == 18) {
        pos_x = 5;
        int n6 = EneZa(0);
        if ((n6 & 0xFF) < 100) {
            pos_x = (n6 & 0xFF) - 1;
            pos_y = n6 >> 8;
        }
    } else if (n == 19) {
        pos_x = 5;
        int n7 = EneZa(1);
        if ((n7 & 0xFF) < 100) {
            pos_x = (n7 & 0xFF) - 1;
            pos_y = n7 >> 8;
        }
    } else if (n == 20) {
        pos_x = 5;
        int n8 = EneZa(2);
        if ((n8 & 0xFF) < 100) {
            pos_x = (n8 & 0xFF) - 1;
            pos_y = n8 >> 8;
        }
    } else if (n == 21) {
        if (flp != 0) {
            int n9 = EneZa(-1);
            pos_x = n9 & 0xFF;
            pos_y = n9 >> 8;
        } else {
            pos_x = Rock::pos_x;
            pos_y = Rock::pos_y;
        }
    }
}

int Attack::EneZa(int n) {
    int n2 = 100;
    int n3 = 100;
    for (int i = 0; i < 6; ++i) {
        for (int j = 0; j < 3; ++j) {
            int n4 = CpCanvas::panel[j][i].on_chara;
            if (n4 <= 1 || n4 >= 5 || n >= 0 && (n4 -= 2) != n || CpCanvas::ene[n4]->hp <= 0) continue;
            if (CpCanvas::ene[n4]->ata_id >= 0) {
                n2 = CpCanvas::ata[CpCanvas::ene[n4]->ata_id]->pos_x;
                n3 = CpCanvas::ata[CpCanvas::ene[n4]->ata_id]->pos_y;
                if (n2 >= 0 && n2 < 6) {
                    CpCanvas::ene[n4]->pos_x = n2;
                    CpCanvas::ene[n4]->pos_y = n3;
                    CpCanvas::ene[n4]->pos_dx = CpCanvas::ata[CpCanvas::ene[n4]->ata_id]->pos_dx;
                    CpCanvas::ene[n4]->pos_dy = CpCanvas::ata[CpCanvas::ene[n4]->ata_id]->pos_dy;
                }
            } else {
                n2 = i;
                n3 = j;
            }
            return (n3 << 8) + n2;
        }
    }
    return (n3 << 8) + n2;
}

void Attack::HitSet(int n) {
    hit_x = pos_x;
    hit_y = pos_y;
    if (n == 0) {
        return;
    }
    if (n == 1) {
        hit_x += flp * 2 - 1;
    } else if (n == 2) {
        hit_x += (flp * 2 - 1) * 2;
    } else if (n == 3) {
        hit_x += (flp * 2 - 1) * 3;
    } else if (n == 4) {
        hit_x += flp * 2 - 1;
        --hit_y;
    } else if (n == 5) {
        if (pos_x > Rock::pos_x) {
            hit_x = Rock::pos_x;
            hit_y = Rock::pos_y;
        } else {
            hit_x = 0;
        }
    }
}

void Attack::Move(int n) {
    // ALL variables declared at top to avoid goto initialization issues
    int n2 = 0, n3 = 0, n4 = 0, n5 = 0, n6 = 0;
    int n7 = 0, n8 = 0, n9 = 0, n10 = 0;
    int n11 = 0, n12 = 0, n13 = 0, n14 = 0, n15 = 0;
    int n16 = 0, n17 = 0, n18 = 0, n19 = 0, n20 = 0, n21 = 0, n22 = 0, n23 = 0;
    int n24 = 0, n25 = 0, n26 = 0, n27 = 0, n28 = 0, n29 = 0, n30 = 0;
    int n31 = 0, n32 = 0, n33 = 0, n34 = 0, n35 = 0, n36 = 0, n37 = 0, n38 = 0, n39 = 0, n40 = 0;
    int n41 = 0, n42 = 0, n43 = 0, n44 = 0, n45 = 0, n46 = 0, n47 = 0, n48 = 0, n49 = 0, n50 = 0;
    int n51 = 0, n52 = 0, n53 = 0, n54 = 0, n55 = 0, n56 = 0, n57 = 0, n58 = 0, n59 = 0, n60 = 0;
    int n61 = 0, n62 = 0, n63 = 0, n64 = 0, n65 = 0, n66 = 0, n67 = 0, n68 = 0, n69 = 0, n70 = 0;
    int n71 = 0, n72 = 0, n73 = 0, n74 = 0, n75 = 0, n76 = 0, n77 = 0, n78 = 0, n79 = 0, n80 = 0;
    int n81 = 0, n82 = 0, n83 = 0, n84 = 0, n85 = 0, n86 = 0, n87 = 0, n88 = 0, n89 = 0, n90 = 0;
    int n91 = 0, n92 = 0, n93 = 0, n94 = 0, n95 = 0, n96 = 0, n97 = 0;

    int nArray[18] = {};
    int nArray2[18] = {};
    int nArray3[18] = {};
    int nArray4[18] = {};
    int nArray5[12] = {};
    int nArray6[18] = {};
    int nArray7[13] = {0, -15, -10, -6, -3, -1, 0, 1, 2, 3, 4, 5, 0};
    int nArray8[6] = {};
    int nArray9[6] = {};
    int nArray10[3] = {};
    int nArray11[8] = {};
    int nArray12[8] = {};
    int nArray13[3] = {};
    int nArray14[18] = {};
    int nArray15[3] = {0, 1, 2};
    int nArray16[3] = {0, 1, 2};
    int nArray17[3] = {25, 27, 30};
    int nArray18[3] = {0, 1, 2};

    if (param[8] != 1) goto lbl_block345_end;
    n3 = 10;
    n2 = 6;
    if (move_cnt == 0) {
        int nArray7_tmp[13] = {0, -15, -10, -6, -3, -1, 0, 1, 2, 3, 4, 5, 0};
        for (int i = 0; i < 13; ++i) nArray7[i] = nArray7_tmp[i];
        move_flg = 1;
        pos_dy = 0;
    }
    if (move_cnt > 1 && move_cnt < 14 && move_flg == 1) {
        pos_dy = nArray7[move_cnt - 2];
        move_flg = 1;
        n3 = 10;
    }
    goto lbl_block346_end;
lbl_block345_end:;
    if (param[8] != 2) goto lbl_block347_end;
    if (ani_cnt == 4 && pos_x > 0 && pos_x < 5) {
        CopySet(pos_x, pos_y, 2, 30);
    }
    goto lbl_block346_end;
lbl_block347_end:;
    if (param[8] != 3) goto lbl_block348_end;
    n3 = 10;
    n2 = 6;
    n23 = pos_y;
    if (move_cnt == 0) {
        move_flg = 1;
    }
    if (move_cnt % 4 != 0 || move_flg != 1) goto lbl_block349_end;
    goto lbl_block350_end;
lbl_block349_end:;
    if (move_cnt % 4 != 2) goto lbl_block351_end;
    oki_hit = 0;
    goto lbl_block351_end;
lbl_block350_end:;
    for (int i = 0; i < 2; ++i) {
        n23 = (n23 + 1) % 3;
        int n96 = CpCanvas::panel[n23][pos_x].on_chara;
        if (chara_flg == 0) {
            if (n96 <= 1 || n96 >= 5) continue;
            if (n23 > pos_y) {
                move_flg = 4;
                continue;
            }
            move_flg = 2;
            continue;
        }
        if (n96 != 1) continue;
        move_flg = n23 > pos_y ? 4 : 2;
        pos_dx = 0;
        pos_dy = 0;
    }
lbl_block351_end:;
    hit_x = pos_x;
    hit_y = pos_y;
    goto lbl_block346_end;
lbl_block348_end:;
    if (param[8] != 4) goto lbl_block352_end;
    if (param[11] == 0) {
        n37 = PaneRan(flp, 1, 0);
        if (ani_cnt == 1) {
            SetOki(param[11]);
        }
        pos_x = n37 % 6;
        pos_y = n37 / 6;
    }
    if (move_cnt == 4) {
        SetOki(param[11]);
    }
    goto lbl_block346_end;
lbl_block352_end:;
    if (param[8] != 5) goto lbl_block353_end;
    if (move_cnt == 0) {
        CpCanvas::panel[pos_y][pos_x].hokkei = ata_id;
    }
    goto lbl_block346_end;
lbl_block353_end:;
    if (param[8] != 6) goto lbl_block354_end;
    n3 = 10;
    n2 = 6;
    move_flg = 1;
    goto lbl_block346_end;
lbl_block354_end:;
    if (param[8] != 7) goto lbl_block355_end;
    n3 = 10;
    move_flg = 1;
    if (move_cnt == 0) {
        n38 = (int)((unsigned int)(CpCanvas::rand()) >> 1) % 2 * 2;
        if (n38 == 0) {
            pos_dy = -6;
        } else {
            pos_dy = 6;
        }
    }
    if (move_cnt > 1 && move_cnt % 4 == 0) {
        oki_hit = 0;
    }
    goto lbl_block346_end;
lbl_block355_end:;
    if (param[8] != 8) goto lbl_block356_end;
    n3 = 10;
    move_flg = 1;
    if (move_cnt == 0) {
        hit_x = pos_x;
        for (int i = 0; i < 6; ++i) {
            if (flp == 0) {
                if (CpCanvas::panel[pos_y][5 - i].jin != 0) continue;
                pos_x = 5 - i;
            } else {
                if (CpCanvas::panel[pos_y][i].jin == 0) continue;
                pos_x = i;
            }
            break;
        }
    }
    goto lbl_block346_end;
lbl_block356_end:;
    if (param[8] != 9) goto lbl_block357_end;
    if (move_cnt == 0) {
        n39 = (int)((unsigned int)(CpCanvas::rand()) >> 1) % 9 + 1;
        if (n39 < 4) {
            move_flg = 1;
        } else if (n39 < 7) {
            move_flg = 2;
        } else {
            move_flg = 4;
        }
    }
    if (move_cnt > 0 && move_cnt % 10 == 0) {
        n40 = (int)((unsigned int)(CpCanvas::rand()) >> 1) % 9 + 1;
        if (n40 < 4) {
            move_flg = 1;
        } else if (n40 < 7) {
            move_flg = 2;
        } else {
            move_flg = 4;
        }
        oki_hit = 0;
    }
    n3 = 10;
    n2 = 6;
    hit_x = pos_x;
    hit_y = pos_y;
    goto lbl_block346_end;
lbl_block357_end:;
    if (param[8] != 10) goto lbl_block358_end;
    if (move_cnt == 15) {
        init();
    }
    goto lbl_block346_end;
lbl_block358_end:;
    if (param[8] != 11) goto lbl_block359_end;
    n3 = 10;
    move_flg = 1;
    if (move_cnt > 1 && move_cnt % 4 == 0) {
        oki_hit = 0;
    }
    goto lbl_block346_end;
lbl_block359_end:;
    if (param[8] != 12) goto lbl_block360_end;
    n3 = 20;
    move_flg = 1;
    goto lbl_block346_end;
lbl_block360_end:;
    if (param[8] != 13) goto lbl_block361_end;
    n3 = 10;
    move_flg = 1;
    goto lbl_block346_end;
lbl_block361_end:;
    if (param[8] != 14) goto lbl_block362_end;
    n3 = 20;
    move_flg = 1;
    goto lbl_block346_end;
lbl_block362_end:;
    if (param[8] != 15) goto lbl_block363_end;
    n3 = 10;
    move_flg = 1;
    goto lbl_block346_end;
lbl_block363_end:;
    if (param[8] != 16) goto lbl_block364_end;
    n3 = 30;
    move_flg = 1;
    if (move_cnt == 0) {
        hit_x = pos_x;
    }
    goto lbl_block346_end;
lbl_block364_end:;
    if (param[8] != 17) goto lbl_block367_end;
    n3 = 10;
    n2 = 6;
    if (move_cnt == 0) {
        if (flp != 0) {
            Rock::non_cnt = param[11];
        }
        move_flg = pos_y == 2 ? 1 : 4;
    } else if (move_cnt % 4 == 0) {
        if (move_flg == 1) {
            move_flg = pos_y == 0 ? 4 : 2;
        } else if (move_flg == 2) {
            if (pos_y == 0) {
                move_flg = 1;
            }
        } else if (move_flg == 4 && pos_y == 2) {
            move_flg = 1;
        }
    }
    hit_x = pos_x;
    hit_y = pos_y;
    if (flp == 0) {
        CpCanvas::ene[hon_id]->pos_x = pos_x;
        CpCanvas::ene[hon_id]->pos_y = pos_y;
        CpCanvas::ene[hon_id]->pos_dx = pos_dx;
        CpCanvas::ene[hon_id]->pos_dy = pos_dy;
        if (move_flg == 1) {
            CpCanvas::ene[hon_id]->pos_dx -= n3;
        }
        if (move_cnt % 4 == 0) {
            n49 = CpCanvas::panel[pos_y][pos_x].on_chara - 10;
            if (n49 >= 0 && CpCanvas::oki[n49]->on != 0 && CpCanvas::oki[n49]->syu == 0) {
                CpCanvas::ene[0]->StBom(pos_x, pos_y);
            }
            oki_hit = 0;
            hit_flg = 0;
        }
    }
    goto lbl_block346_end;
lbl_block367_end:;
    if (param[8] != 18) goto lbl_block368_end;
    n3 = 20;
    n2 = 6;
    move_flg = 1;
    if (pos_x == flp * 5 && pos_dx < 0) {
        move_flg = 3;
    }
    goto lbl_block346_end;
lbl_block368_end:;
    if (param[8] != 19) goto lbl_block369_end;
    n3 = 30;
    move_flg = 1;
    goto lbl_block346_end;
lbl_block369_end:;
    if (param[8] != 20) goto lbl_block370_end;
    n3 = 0;
    if (move_cnt == 0) {
        move_flg = 1;
    }
    if (move_cnt < 30) {
        n50 = (int)((unsigned int)(CpCanvas::rand()) >> 1) % 50 - 25;
        n51 = (int)((unsigned int)(CpCanvas::rand()) >> 1) % 50 - 25;
        pos_dx = n50;
        pos_dy = n51;
    }
    if (move_cnt % 4 == 3 && move_cnt > 0 && move_cnt < 40) {
        oki_hit = 0;
    }
    goto lbl_block346_end;
lbl_block370_end:;
    if (param[8] != 21) goto lbl_block371_end;
    n3 = 30;
    move_flg = 1;
    if (move_cnt == 0) {
        n52 = PaneRan(flp, 1, 0);
        if (n52 < 100) {
            pos_x = n52 % 6;
            pos_y = n52 / 6;
        }
        hit_x = pos_x;
        hit_y = pos_y;
    }
    goto lbl_block346_end;
lbl_block371_end:;
    if (param[8] != 22) goto lbl_block372_end;
    if (move_cnt == 4) {
        int nArray8_tmp[6] = {1, 1, 1, 0, 0, 0};
        for (int i = 0; i < 6; ++i) nArray8[i] = nArray8_tmp[i];
        for (int i = 0; i < 30; ++i) {
            n53 = (int)((unsigned int)(CpCanvas::rand()) >> 1) % 6;
            n54 = (int)((unsigned int)(CpCanvas::rand()) >> 1) % 6;
            n55 = nArray8[n53];
            nArray8[n53] = nArray8[n54];
            nArray8[n54] = n55;
        }
        for (int i = 0; i < 6; ++i) {
            if (nArray8[i] == 0) continue;
            n56 = CopySet(i, pos_y, 2, 35);
            if (n56 < 0) continue;
            CpCanvas::ata[n56]->pos_dx = -100 - i * 10;
        }
    }
    goto lbl_block346_end;
lbl_block372_end:;
    if (param[8] != 23) goto lbl_block373_end;
    n3 = 30;
    move_flg = 1;
    if (move_cnt == 0) {
        hit_x = pos_x;
        pos_dx = -100 - param[11] * 10;
    }
    goto lbl_block346_end;
lbl_block373_end:;
    if (param[8] != 24) goto lbl_block374_end;
    n3 = 30;
    move_flg = 1;
    goto lbl_block346_end;
lbl_block374_end:;
    if (param[8] != 25) goto lbl_block375_end;
    if (move_cnt == 10) {
        CopySet(pos_x, pos_y, 2, 37);
    }
    goto lbl_block346_end;
lbl_block375_end:;
    if (param[8] != 26) goto lbl_block376_end;
    n3 = 20;
    move_flg = 1;
    goto lbl_block346_end;
lbl_block376_end:;
    if (param[8] != 27) goto lbl_block377_end;
    if (move_cnt == 0) {
        eff_id = 37;
        EffSet();
        ani_cnt = 0;
        CpCanvas::ene[hon_id]->pos_x = pos_x;
        CpCanvas::ene[hon_id]->pos_y = pos_y;
    }
    if (move_cnt % 4 == 3 && move_cnt > 2 && move_cnt < 23) {
        n57 = CopySet(pos_x, pos_y, 2, 40);
        if (n57 >= 0) {
            CpCanvas::ata[n57]->pos_dx = (int)((unsigned int)(CpCanvas::rand()) >> 1) % 80 - 40;
            CpCanvas::ata[n57]->pos_dy = (int)((unsigned int)(CpCanvas::rand()) >> 1) % 80 - 40;
        }
    }
    if (move_cnt == 28) {
        eff_id = 38;
        EffSet();
        ani_cnt = 0;
    }
    goto lbl_block346_end;
lbl_block377_end:;
    if (param[8] != 28) goto lbl_block379_end;
    if (move_cnt >= 1 && move_cnt <= 6) {
        int nArray9_tmp[6] = {0, 5, 10, -5, -10, 0};
        for (int i = 0; i < 6; ++i) nArray9[i] = nArray9_tmp[i];
        pos_dy = nArray9[move_cnt - 1];
    }
    goto lbl_block346_end;
lbl_block379_end:;
    if (param[8] != 29) goto lbl_block403_end;
    if (move_cnt != 0) goto lbl_block405_end;
    {
    int nArray10_tmp[3] = {0, 1, 2};
    for (int i = 0; i < 3; ++i) nArray10[i] = nArray10_tmp[i];
    }
    for (int i = 0; i < 10; ++i) {
        n64 = (int)((unsigned int)(CpCanvas::rand()) >> 1) % 3;
        n65 = (int)((unsigned int)(CpCanvas::rand()) >> 1) % 3;
        n66 = nArray10[n64];
        nArray10[n64] = nArray10[n65];
        nArray10[n65] = n66;
    }
    n67 = CopySet(pos_x, nArray10[0], 2, 42);
    if (n67 >= 0) {
        CpCanvas::ata[n67]->param[10] = 30;
    }
    n68 = CopySet(pos_x, nArray10[1], 2, 42);
    if (n68 >= 0) {
        CpCanvas::ata[n68]->param[10] = 60;
    }
    n69 = CopySet(pos_x, nArray10[2], 2, 42);
    if (n69 >= 0) {
        CpCanvas::ata[n69]->param[10] = 90;
    }
lbl_block405_end:;
    if (move_cnt != 110) goto lbl_block403_end;
    init();
    goto lbl_block346_end;
lbl_block403_end:;
    if (param[8] != 30) goto lbl_block411_end;
    if (move_cnt != 0) goto lbl_block413_end;
    n4 = 0;
    for (int i = 0; i < 18; ++i) {
        if (CpCanvas::panel[i / 6][i % 6].jin != flp || CpCanvas::panel[i / 6][i % 6].on_chara != 0 || CpCanvas::panel[i / 6][i % 6].jou <= 0) continue;
        nArray4[n4] = i;
        ++n4;
    }
    if (n4 == 0) {
        init();
        return;
    }
    for (int i = 0; i < 30; ++i) {
        n20 = (int)((unsigned int)(CpCanvas::rand()) >> 1) % n4;
        n19 = (int)((unsigned int)(CpCanvas::rand()) >> 1) % n4;
        n21 = nArray4[n20];
        nArray4[n20] = nArray4[n19];
        nArray4[n19] = n21;
    }
    if (n4 <= 3) goto lbl_block413_end;
    n4 = 3;
lbl_block413_end:;
    if (move_cnt != 5) goto lbl_block411_end;
    for (n21 = 0; n21 < 3; ++n21) {
        n20 = nArray4[n21] % 6;
        n19 = nArray4[n21] / 6;
        if (n21 == 0) {
            CopySet(n20, n19, 2, 117);
            continue;
        }
        CopySet(n20, n19, 2, 33);
    }
    init();
    goto lbl_block346_end;
lbl_block411_end:;
    if (param[8] != 31) goto lbl_block428_end;
    if (move_cnt != 0) goto lbl_block429_end;
    n5 = 0;
    for (int i = 0; i < 18; ++i) {
        if (CpCanvas::panel[i / 6][i % 6].jin != flp || CpCanvas::panel[i / 6][i % 6].on_chara != 0 || CpCanvas::panel[i / 6][i % 6].jou <= 0) continue;
        nArray3[n5] = i;
        ++n5;
    }
    if (n5 == 0) {
        init();
        return;
    }
    for (int i = 0; i < 30; ++i) {
        n17 = (int)((unsigned int)(CpCanvas::rand()) >> 1) % n5;
        n16 = (int)((unsigned int)(CpCanvas::rand()) >> 1) % n5;
        n18 = nArray3[n17];
        nArray3[n17] = nArray3[n16];
        nArray3[n16] = n18;
    }
    if (n5 <= 4) goto lbl_block429_end;
    n5 = 4;
lbl_block429_end:;
    if (move_cnt != 5) goto lbl_block428_end;
    for (n18 = 0; n18 < 4; ++n18) {
        n17 = nArray3[n18] % 6;
        n16 = nArray3[n18] / 6;
        if (n18 == 0) {
            CopySet(n17, n16, 2, 118);
            continue;
        }
        CopySet(n17, n16, 2, 33);
    }
    goto lbl_block346_end;
lbl_block428_end:;
    if (param[8] != 32) goto lbl_block434_end;
    if (move_cnt != 0) goto lbl_block436_end;
    n6 = 0;
    for (int i = 0; i < 18; ++i) {
        if (CpCanvas::panel[i / 6][i % 6].jin != (flp ^ 1) || CpCanvas::panel[i / 6][i % 6].on_chara != 0 || CpCanvas::panel[i / 6][i % 6].jou <= 0) continue;
        nArray2[n6] = i;
        ++n6;
    }
    if (n6 == 0) {
        init();
        return;
    }
    for (int i = 0; i < 30; ++i) {
        n14 = (int)((unsigned int)(CpCanvas::rand()) >> 1) % n6;
        n13 = (int)((unsigned int)(CpCanvas::rand()) >> 1) % n6;
        n15 = nArray2[n14];
        nArray2[n14] = nArray2[n13];
        nArray2[n13] = n15;
    }
    if (n6 <= 7) goto lbl_block436_end;
    n6 = 7;
lbl_block436_end:;
    if (move_cnt <= 0 || move_cnt >= 60) goto lbl_block438_end;
    if (move_cnt % 4 != 0) goto lbl_block438_end;
    if ((move_cnt - 4) / 4 >= n6) goto lbl_block438_end;
    n12 = nArray2[(move_cnt - 4) / 4] % 6;
    n11 = nArray2[(move_cnt - 4) / 4] / 6;
    CopySet(n12, n11, 2, 43);
lbl_block438_end:;
    if (move_cnt != 65) goto lbl_block434_end;
    init();
    goto lbl_block346_end;
lbl_block434_end:;
    if (param[8] != 33) goto lbl_block432_end;
    if (move_cnt != param[10]) goto lbl_block432_end;
    init();
    goto lbl_block346_end;
lbl_block432_end:;
    if (param[8] != 34) goto lbl_block466_end;
    if (move_cnt != 0) goto lbl_block468_end;
    nArray = new int[18];
    n7 = 0;
    for (int i = 0; i < 18; ++i) {
        if (CpCanvas::panel[i / 6][i % 6].jin != (flp ^ 1) || CpCanvas::panel[i / 6][i % 6].on_chara != 0 || CpCanvas::panel[i / 6][i % 6].jou <= 0) continue;
        nArray[n7] = i;
        ++n7;
    }
    if (n7 == 0) {
        init();
        return;
    }
    for (int i = 0; i < 30; ++i) {
        n9 = (int)((unsigned int)(CpCanvas::rand()) >> 1) % n7;
        n8 = (int)((unsigned int)(CpCanvas::rand()) >> 1) % n7;
        n10 = nArray[n9];
        nArray[n9] = nArray[n8];
        nArray[n8] = n10;
    }
    if (n7 <= 10) goto lbl_block468_end;
    n7 = 10;
lbl_block468_end:;
    if (move_cnt <= 0 || move_cnt >= 90) goto lbl_block466_end;
    if (move_cnt % 4 != 0) goto lbl_block466_end;
    if ((move_cnt - 4) / 4 >= n7) goto lbl_block466_end;
    n10 = nArray[(move_cnt - 4) / 4] % 6;
    n9 = nArray[(move_cnt - 4) / 4] / 6;
    CopySet(n10, n9, 2, 44);
lbl_block466_end:;
    if (move_cnt == 95) {
        init();
    }
    goto lbl_block346_end;
lbl_block346_end:;

    if (move_flg == 1) {
        pos_dx -= n3;
    } else if (move_flg == 2) {
        pos_dy -= n2;
    } else if (move_flg == 4) {
        pos_dy += n2;
    }

    if (nArray[0] != 0 || nArray[1] != 0) {
        if (pos_x * 40 + pos_dx < nArray[move_cnt] * 5 || pos_x * 40 + pos_dx > nArray[move_cnt] * 5 + 30) {
            if (pos_x * 40 + pos_dx < nArray[move_cnt] * 5) {
                move_flg = 1;
            } else {
                move_flg = 3;
            }
        }
        if (pos_y * 24 + pos_dy < nArray2[move_cnt] * 5 || pos_y * 24 + pos_dy > nArray2[move_cnt] * 5 + 14) {
            if (pos_y * 24 + pos_dy < nArray2[move_cnt] * 5) {
                move_flg = 4;
            } else {
                move_flg = 2;
            }
        }
    }

    if (nArray3[0] != 0 || nArray3[1] != 0) {
        if (pos_x * 40 + pos_dx < nArray3[move_cnt] || pos_x * 40 + pos_dx > nArray3[move_cnt] + 30) {
            if (pos_x * 40 + pos_dx < nArray3[move_cnt]) {
                move_flg = 1;
            } else {
                move_flg = 3;
            }
        }
        if (pos_y * 24 + pos_dy < nArray4[move_cnt] || pos_y * 24 + pos_dy > nArray4[move_cnt] + 14) {
            if (pos_y * 24 + pos_dy < nArray4[move_cnt]) {
                move_flg = 4;
            } else {
                move_flg = 2;
            }
        }
    }

    if (pos_dx >= 40) {
        ++pos_x;
        pos_dx -= 40;
    } else if (pos_dx <= -40) {
        --pos_x;
        pos_dx += 40;
    }
    if (pos_dy >= 24) {
        ++pos_y;
        pos_dy -= 24;
    } else if (pos_dy <= -24) {
        --pos_y;
        pos_dy += 24;
    }
    ++move_cnt;
}

void Attack::MocoSet() {
    if (hon_id < 0) {
        return;
    }
    for (int i = 1; i < 3; ++i) {
        if (CpCanvas::ene[(hon_id + i) % 3]->on == 0 || CpCanvas::ene[(hon_id + i) % 3]->chara_no != CpCanvas::ene[hon_id]->chara_no || CpCanvas::ene[(hon_id + i) % 3]->pos_y != pos_y) continue;
        pos_y = (pos_y + 1) % 3;
    }
    CpCanvas::ene[hon_id]->AniSet(0);
    CpCanvas::ene[hon_id]->pos_x = pos_x;
    CpCanvas::ene[hon_id]->pos_y = pos_y;
    CpCanvas::ene[hon_id]->pos_dx = pos_dx - 8;
    CpCanvas::ene[hon_id]->pos_dy = pos_dy;
    CpCanvas::ene[hon_id]->def_ani = 0;
}

void Attack::HitGo(int n) {
    if (n == 0) {
        hit_ok = 0;
    }
    if (HitTime() && hit_ok == 0) {
        HitCheck(param[2]);
    }
}

bool Attack::HitTime() {
    if (hit_time == 0 && CpCanvas::stop_time != 0) {
        return false;
    }
    if (move_cnt < param[5]) {
        return false;
    }
    if (param[6] == 99 && move_cnt % 2 == 0) {
        return false;
    }
    if (param[6] == 0) {
        return true;
    }
    return move_cnt <= param[5] + param[6] - 1;
}

void Attack::HitCheck(int n) {
    int n2;
    if (hit_flg != 0) goto lbl_block21_end;
    n2 = 0;
    if (yokoku == 1) {
        CpCanvas::panel[hit_y][hit_x].yokoku = 1;
    }
    if (param[3] != 4) {
        ren_hit = 0;
    }
    if (n != 0) goto lbl_block22_end;
    for (int i = hit_x; i < 6 && i >= 0; i += flp * 2 - 1) {
        int n3 = i;
        int n4 = hit_y;
        if (Hit(n3, n4, 0)) {
            if (param[7] != 15) {
                HitExp(n3, n4);
            }
            PaneRetrun(n3, n4, 0);
            if (param[3] == 2) {
                init();
                goto lbl_block21_end;
            }
            if (param[3] == 0) {
                goto lbl_block21_end;
            }
        } else if (param[8] == 46) {
            if (CpCanvas::panel[n4][n3].jou > 0) {
                HitExp(n3, n4);
            }
            init();
        } else if (param[8] == 1 && CpCanvas::panel[n4][n3].jou > 0) {
            HitExp(n3, n4);
        } else if (param[7] > 6 && param[7] < 27) {
            HitExp(n3, n4);
        }
        PaneRetrun(n3, n4, 1);
        if (param[1] > 1) {
            PaneRetrun(n3, n4, 0);
        }
        if (HitEnd(param[1]) > ++n2) {
            continue;
        }
        goto lbl_block21_end;
    }
    goto lbl_block21_end;
lbl_block22_end:;
    if (n != 1) goto lbl_block23_end;
    {
    int n5 = hit_y;
    while (n5 < 3) {
        int n6 = hit_x;
        int n7 = n5++;
        Hit(n6, n7, 0);
        HitExp(n6, n7);
        PaneRetrun(n6, n7, 0);
        if (HitEnd(param[1]) > ++n2) {
            continue;
        }
        goto lbl_block21_end;
    }
    goto lbl_block21_end;
    }
lbl_block23_end:;
    if (n != 3) goto lbl_block21_end;
    for (int i = hit_x; i < 6 && i >= 0; i += flp * 2 - 1) {
        for (int j = 0; j < 3; ++j) {
            int n8 = hit_y + j;
            Hit(i, n8, 0);
            HitExp(i, n8);
        }
        if (++n2 != 2) {
            continue;
        }
        break;
    }
lbl_block21_end:;
}

void Attack::PaneRetrun(int n, int n2, int n3) {
    if (n < 0 || n > 5 || n2 < 0 || n2 > 2) {
        return;
    }
    if ((zoku == 1 && CpCanvas::panel[n2][n].jou == 4 || zoku == 2 && CpCanvas::panel[n2][n].jou == 3) && (n3 == 0 || param[0] != 1 && param[1] != 0)) {
        CpCanvas::panel[n2][n].Henka(1, flp);
    }
}

int Attack::PaneRan(int n, int n2, int n3) {
    int nArray[18] = {};
    int n4 = 0;
    if (n2 == 0) {
        for (int i = 0; i < 18; ++i) {
            if (CpCanvas::panel[i % 3][5 - i / 3].jin != n) continue;
            nArray[n4] = i;
            ++n4;
        }
        return nArray[n3 % n4];
    }
    for (int i = 0; i < 18; ++i) {
        if (CpCanvas::panel[i / 6][i % 6].jin != n || CpCanvas::panel[i / 6][i % 6].on_chara != 0 || CpCanvas::panel[i / 6][i % 6].jou <= 0) continue;
        nArray[n4] = i;
        ++n4;
    }
    if (n4 == 0) {
        return 100;
    }
    return nArray[(int)((unsigned int)(CpCanvas::rand()) >> 1) % n4];
}

void Attack::HitExp(int n, int n2) {
    if (n < 0 || n > 5 || n2 < 0 || n2 > 2) {
        return;
    }
    int n3 = param[7];
    if (n3 == 0) {
        return;
    }
    if (n3 > 6) {
        hit_ok = 1;
    }
    if (n3 < 7) {
        int nArray[8] = {0, 1, 1, 1, 0, -1, -1, -1};
        int nArray2[8] = {-1, -1, 0, 1, 1, 1, 0, -1};
        int nArray3[6] = {4, 10, 17, 85, 255, 0};
        --n3;
        int n4 = flp * 2 - 1;
        for (int i = 0; i < 8; ++i) {
            if ((nArray3[n3] & 1 << i) == 0) continue;
            int n5 = n + nArray[i] * n4;
            int n6 = n2 + nArray2[i];
            if (!Hit(n5, n6, 1)) {
                HitEff(n5, n6, flp);
            }
            PaneRetrun(n5, n6, 0);
        }
    } else if (n3 < 16) {
        CpCanvas::panel[n2][n].Henka(n3 -= 7, flp);
        if (param[8] != 65 && param[2] == 0) {
            param[7] = 0;
        }
    } else if (n3 == 16) {
        if (flp != 0) {
            Rock::tmp_muteki_cnt = 90;
        }
    } else if (n3 == 17) {
        if (flp != 0) {
            Rock::bari = param[11];
            if (Rock::bari_id >= 0) {
                CpCanvas::ata[Rock::bari_id]->init();
            }
            Rock::bari_id = ata_id;
        } else {
            CpCanvas::ene[0]->bari = param[11];
            if (CpCanvas::ene[0]->bari_id >= 0) {
                CpCanvas::ata[CpCanvas::ene[0]->bari_id]->init();
            }
            CpCanvas::ene[0]->bari_id = ata_id;
        }
        param[7] = 0;
    } else if (n3 == 18) {
        if (flp == 0) {
            Rock::bari = 0;
            if (Rock::bari_id >= 0) {
                Rock::bari = 0;
                CpCanvas::ata[Rock::bari_id]->init();
                Rock::bari_id = -1;
            }
        } else {
            for (int i = 0; i < 3; ++i) {
                if (CpCanvas::ene[i]->chara_no == 12 || CpCanvas::ene[i]->bari_id < 0 || CpCanvas::ene[i]->hp <= 0) continue;
                CpCanvas::ene[i]->bari = 0;
                CpCanvas::ata[CpCanvas::ene[i]->bari_id]->init();
                CpCanvas::ene[i]->bari_id = -1;
            }
        }
    } else if (n3 == 19) {
        CpCanvas::cus_sp = 2;
    } else if (n3 == 20) {
        CpCanvas::cus_gage = 128;
    } else if (n3 == 26) {
        if (chara_flg == 0) {
            ++CpCanvas::rika_cnt;
            if ((Rock::hp += pow) > CpCanvas::max_hp) {
                Rock::hp = CpCanvas::max_hp;
            }
        }
        param[7] = 0;
    } else if (n3 == 27) {
        for (int i = 0; i < 3; ++i) {
            if (CpCanvas::ene[i]->on == 0 || CpCanvas::ene[i]->ani_id != 2 || CpCanvas::ene[i]->pos_y != pos_y) continue;
            CpCanvas::ene[i]->tmp_cnt = 1;
            CpCanvas::ene[i]->wait_cnt = 1;
        }
        param[7] = 0;
    } else if (n3 == 28) {
        Rock::tip_no -= Rock::next_tip;
        CpCanvas::rock->TipNext();
        param[7] = 0;
    } else if (n3 == 29) {
        CopySet(hit_x + (1 - flp * 2), hit_y, 2, 169);
        param[7] = 0;
    }
}

void Attack::SetOki(int n) {
    int n2;
    int n3;
    if (CpCanvas::boss_flg == 8 && pos_x > 3) {
        return;
    }
    if (CpCanvas::panel[pos_y][pos_x].jou <= 0) {
        return;
    }
    if (CpCanvas::panel[pos_y][pos_x].on_chara != 0) {
        return;
    }
    int n4 = chara_flg * 2;
    int n5 = -1;
    if (CpCanvas::oki[n4 + 0]->on == 0) {
        CpCanvas::oki[n4 + 0]->Set(n, pos_x, pos_y, flp, pow);
        n5 = n4 + 0;
    } else if (CpCanvas::oki[n4 + 1]->on == 0) {
        CpCanvas::oki[n4 + 1]->Set(n, pos_x, pos_y, flp, pow);
        n5 = n4 + 1;
    } else {
        n3 = Okimono::o_data[n] >> 30 & 1;
        n4 = n3 != 0 ? ((n2 = OnlyOki(n4)) < 0 ? CpCanvas::oki[n4]->next_off : n2) : CpCanvas::oki[n4]->next_off;
        CpCanvas::oki[n4]->Off();
        CpCanvas::oki[n4]->Set(n, pos_x, pos_y, flp, pow);
        n5 = n4;
    }
    if (n5 >= 0 && CpCanvas::oki[n5]->only_flg != 0) {
        for (n3 = 0; n3 < 2; ++n3) {
            n2 = n4 + n3;
            if (n2 == n5 || CpCanvas::oki[n2]->on == 0 || CpCanvas::oki[n2]->only_flg == 0) continue;
            CpCanvas::oki[n2]->Off();
        }
    }
}

int Attack::OnlyOki(int n) {
    for (int i = 0; i < 2; ++i) {
        int n2 = n + i;
        if (CpCanvas::oki[n2]->on == 0 || CpCanvas::oki[n2]->only_flg == 0) continue;
        return n2;
    }
    return -1;
}

int Attack::HitEnd(int n) {
    if (n == 0) {
        return 99;
    }
    if (n < 4) {
        return n;
    }
    return 99;
}

bool Attack::Hit(int n, int n2, int n3) {
    if (n < 0 || n > 5 || n2 < 0 || n2 > 2) {
        return false;
    }
    if (chara_flg > 1) {
        return false;
    }
    if (param[7] == 26) {
        return false;
    }
    int n4 = 1;
    if (zoku == 1 && CpCanvas::panel[n2][n].jou == 4 || zoku == 3 && CpCanvas::panel[n2][n].jou == 5) {
        n4 = 2;
    }
    if (hit_ana != 0 && CpCanvas::panel[n2][n].jou <= 0) {
        if (n3 == 0) {
            init();
        }
        return false;
    }
    if (param[8] == 1 || param[8] == 46) {
        if (CpCanvas::panel[n2][n].jou <= 0) {
            param[7] = 0;
        }
        if (hit_ana != 0) {
            HitEff(n, n2, flp);
        }
    }
    if (param[3] == 3 && hit_flg != 0) {
        return false;
    }
    if (param[8] == 20) {
        HitEff(n, n2, flp);
    }
    if (chara_flg == 0) {
        int n5;
        int n6 = CpCanvas::panel[n2][n].on_chara;
        int n7 = 0;
        for (n5 = 0; n5 < 3; ++n5) {
            if (CpCanvas::ene[n5]->on == 0 || CpCanvas::ene[n5]->ata_id < 0 || (CpCanvas::ene[n5]->pos_x != n || CpCanvas::ene[n5]->pos_y != n2) && (CpCanvas::ene[n5]->tmp_x != n || CpCanvas::ene[n5]->tmp_y != n2)) continue;
            n7 = 100;
            n6 = n5 + 2;
            break;
        }
        if ((ren_hit >> n6 & 1) != 0) {
            return false;
        }
        if (n6 > 1 && n6 < 5) {
            if (CpCanvas::ene[n6 -= 2]->muteki_cnt != 0 || CpCanvas::ene[n6]->muteki2 != 0) {
                return false;
            }
            if (CpCanvas::ene[n6]->hp <= 0) {
                return false;
            }
            if (!(n7 == 100 || CpCanvas::ene[n6]->ata_id < 0 || CpCanvas::ene[n6]->pos_x == n && CpCanvas::ene[n6]->pos_y == n2 || CpCanvas::ene[n6]->tmp_x == n && CpCanvas::ene[n6]->tmp_y == n2)) {
                return false;
            }
            if (CpCanvas::ene[n6]->han != 0 && pow > 0 && hit_bure == 0) {
                n5 = hit_eff;
                hit_eff = 45;
                HitEff(n, n2, flp ^ 1);
                hit_eff = n5;
                ren_hit |= 1 << n6 + 2;
                hit_flg = 1;
                hit_ok = 1;
                return true;
            }
            CpCanvas::ene[n6]->Hit(hit_param, pow * n4, zoku);
            if (param[8] != 1) {
                HitEff(n, n2, flp);
            }
            ren_hit |= 1 << n6 + 2;
            hit_flg = 1;
            hit_ok = 1;
            return true;
        }
        if (n6 > 9) {
            if (CpCanvas::oki[n6 -= 10]->pos_x != n) {
                return false;
            }
            if (CpCanvas::oki[n6]->pos_y != n2) {
                return false;
            }
            if (oki_hit != 0) {
                return false;
            }
            if (CpCanvas::oki[n6]->rock_ata == 0) {
                return false;
            }
            CpCanvas::oki[n6]->Hit(pow * n4, hit_bure);
            if (param[8] != 1) {
                HitEff(n, n2, flp);
            }
            oki_hit = 1;
            hit_ok = 1;
            return true;
        }
    } else if (chara_flg == 1) {
        int n8 = CpCanvas::panel[n2][n].on_chara;
        if (n8 == 1) {
            int n9;
            if (ren_hit != 0) {
                return false;
            }
            if (Rock::han != 0 && pow > 0) {
                if (Rock::han_id >= 0) {
                    n9 = Rock::han;
                    if (hit_bure == 0) {
                        int n10;
                        n8 = CpCanvas::AtaNo(ata_id);
                        if (n9 == 1) {
                            CpCanvas::ata[n8]->Set(52, n, n2, 1, 0);
                            CpCanvas::ata[n8]->pow = CpCanvas::ata[Rock::han_id]->pow;
                        }
                        if (n9 == 2) {
                            CpCanvas::ata[n8]->Set(89, n, n2, 1, -2);
                            CpCanvas::ata[n8]->chara_flg = 0;
                            CpCanvas::ata[n8]->pow = CpCanvas::ata[Rock::han_id]->pow;
                        }
                        if (n9 == 3) {
                            for (n10 = 0; n10 < 3; ++n10) {
                                n8 = CpCanvas::AtaNo(ata_id);
                                CpCanvas::ata[n8]->Set(89, n, n2 + n10 - 1, 1, -2);
                                CpCanvas::ata[n8]->chara_flg = 0;
                                CpCanvas::ata[n8]->pow = CpCanvas::ata[Rock::han_id]->pow;
                            }
                        }
                        n10 = hit_eff;
                        hit_eff = 45;
                        HitEff(n, n2, flp ^ 1);
                        hit_eff = n10;
                        if (n9 != 1) {
                            CpCanvas::ata[Rock::han_id]->init();
                            Rock::han = 0;
                            Rock::han_id = -1;
                            Rock::muteki_cnt = 0;
                        }
                        init();
                        hit_ok = 1;
                        return true;
                    }
                    CpCanvas::ata[Rock::han_id]->init();
                    Rock::han = 0;
                    Rock::han_id = -1;
                    Rock::muteki_cnt = 0;
                }
            }
            if (Rock::muteki_cnt != 0) {
                return false;
            }
            if (Rock::wana == 5) {
                if (Rock::muteki_cnt == 0) {
                    if (Rock::bari == 0 && pow > 0) {
                        Rock::wana = 0;
                        Rock::muteki_cnt = 10;
                        Rock::hit_cnt = 10;
                        hit_eff = 59;
                        HitEff(n, n2, flp);
                        for (n9 = 0; n9 < 3; ++n9) {
                            if (CpCanvas::ene[n9]->on == 0) continue;
                            n8 = CpCanvas::AtaNo(ata_id);
                            CpCanvas::ata[n8]->Set(99, CpCanvas::ene[n9]->pos_x, CpCanvas::ene[n9]->pos_y, 1, -2);
                            CpCanvas::ata[n8]->chara_flg = 0;
                            CpCanvas::ata[n8]->pow = CpCanvas::wana_pow[0];
                            CpCanvas::ata[n8]->zoku = 0;
                            break;
                        }
                        hit_ok = 1;
                        return true;
                    }
                }
            }
            CpCanvas::rock->Hit(hit_param, pow * n4, zoku);
            if (param[8] != 1) {
                HitEff(n, n2, flp);
            }
            ren_hit = 1;
            hit_flg = 1;
            hit_ok = 1;
            return true;
        }
        if (n8 > 9) {
            if (param[8] == 49) {
                init();
                hit_ok = 1;
                return true;
            }
            if (CpCanvas::oki[n8 -= 10]->pos_x != n) {
                return false;
            }
            if (CpCanvas::oki[n8]->pos_y != n2) {
                return false;
            }
            if (oki_hit != 0) {
                return false;
            }
            if (CpCanvas::oki[n8]->teki_ata == 0) {
                return false;
            }
            CpCanvas::oki[n8]->Hit(pow * n4, hit_bure);
            if (param[8] != 1) {
                HitEff(n, n2, flp);
            }
            oki_hit = 1;
            hit_ok = 1;
            return true;
        }
    }
    return false;
}

bool Attack::HitEff(int n, int n2, int n3) {
    if (n < 0 || n > 5 || n2 < 0 || n2 > 2) {
        return false;
    }
    if (hit_eff == 0) {
        return false;
    }
    int n4 = CpCanvas::AtaNo(ata_id);
    CpCanvas::ata[n4]->Set(hit_eff, n, n2, n3, 2);
    CpCanvas::ata[n4]->hit_time = hit_time;
    return true;
}

void Attack::Loop() {
    ani_ok = 1;
    if (--s_wait < 0) {
        s_wait = 0;
        if (r_suu != 0) {
            if (ani_cnt == r_e + 1) {
                ani_cnt = r_s;
                --r_suu;
            }
        } else if (CpCanvas::ani[ani_id][ani_pt][ani_cnt + 1] == -2) {
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

void Attack::Draw(int n, int n2) {
    if (on != n) {
        return;
    }
    if (Rock::bas_no == ata_id) {
        if (Rock::hit_cnt != 0) {
            return;
        }
    }
    if (hit_time != 0 && CpCanvas::stop_cnt < 15) {
        return;
    }
    tmp_s_wait = s_wait;
    tmp_r_suu = r_suu;
    tmp_e_wait = e_wait;
    if (n2 != 0 || hit_time != 0) {
        Loop();
    }
    t_ani_cnt = ani_cnt;
    int n3 = 1;
    if (loop_flg == 0) {
        n3 = 0;
    }
    if (hit_time == 0 && n2 == 0) {
        n3 = 1;
    }
    int n4 = CpCanvas::AniSe(ani_id, ani_pt, ani_cnt, pos_x, pos_y, pos_dx, pos_dy, flp, se_id, n3);
    if (n3 == 0 && n4 >= 0) {
        loop_flg = 1;
    }
    if (-2 != n4) {
        if (ani_ok != 0) {
            if (hit_time == 0) {
                if (CpCanvas::stop_cnt == 0) {
                    ani_cnt += n2;
                }
            } else {
                ++ani_cnt;
            }
        }
    } else {
        init();
    }
}
