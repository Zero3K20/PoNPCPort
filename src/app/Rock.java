/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.nttdocomo.ui.Graphics
 */
package app;

import app.CpCanvas;
import app.Edit;
import app.Tip;
import com.nttdocomo.ui.Graphics;

class Rock {
    Tip[] tip = new Tip[9];
    public static int[] tip_data = new int[30];
    public static int tip_no;
    public static int[] pow;
    public static int next_tip;
    public static int hp;
    public static int zoku;
    public static int pos_x;
    public static int pos_y;
    public static int dx;
    public static int dy;
    public static int tmp_x;
    public static int tmp_y;
    public static int joutai;
    public static int muteki_cnt;
    public static int tmp_muteki_cnt;
    public static int hit_cnt;
    public static int move_flg;
    public static int syoumetu_cnt;
    public static int ani_wait_cnt;
    public static int tmp_ani_cnt;
    public static int ani_ok;
    public static int s_wait;
    public static int e_wait;
    public static int r_suu;
    public static int r_s;
    public static int r_e;
    public static int ani_cnt;
    public static int ani_cnt_max;
    public static int[] ani_id;
    public static int[] ani_pt;
    public static int ani_max;
    public static int[][] move;
    public static int waza_flg;
    public static int waza_wait;
    public static int non_cnt;
    public static int non_cnt2;
    public static int bas_no;
    public static int bas_pow;
    public static int han;
    public static int han_id;
    public static int bari;
    public static int bari_id;
    public static int wana;
    public static int pane_id;
    public static int tmp_move;
    public static int non_bas;
    public static int tmp_ata;
    public static int air;
    public static int move_cnt;
    public static int noke_cnt;
    public static int mahi_id;
    public int t_ani_cnt;
    public int tmp_s_wait;
    public int tmp_r_suu;
    public int tmp_e_wait;

    Rock() {
    }

    public void init() {
        int n;
        System.gc();
        for (n = 0; n < 9; ++n) {
            this.tip[n] = new Tip();
            this.tip[n] = CpCanvas.tip[0];
        }
        this.t_ani_cnt = 0;
        this.tmp_s_wait = 0;
        this.tmp_r_suu = 0;
        this.tmp_e_wait = 0;
        tip_no = -1;
        hp = CpCanvas.now_hp;
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
        CpCanvas.panel[Rock.pos_y][Rock.pos_x].on_chara = 1;
        bas_no = -1;
        bari_id = -1;
        bas_pow = 1;
        non_cnt = 0;
        non_cnt2 = 0;
        han = 0;
        han_id = -1;
        bari = 0;
        wana = 0;
        Rock.pow[0] = 0;
        Rock.pow[3] = 0;
        next_tip = 1;
        tmp_ata = -1;
        move_cnt = 0;
        noke_cnt = 0;
        zoku = Edit.r_zoku;
        mahi_id = -1;
        if (CpCanvas.skill_kouka[6] != 0) {
            n = CpCanvas.AtaNo(0);
            CpCanvas.ata[n].Set(113, pos_x, pos_y, 1, 0);
        }
        air = CpCanvas.skill_kouka[7];
        this.MoveSet();
        this.AniSet(0);
    }

    public void MoveSet() {
        for (int i = 0; i < 22; ++i) {
            for (int j = 0; j < 6; ++j) {
                Rock.move[i][j] = CpCanvas.rock_mo[i * 6 + j];
                Rock.move[i][j + 1] = -2;
            }
        }
    }

    public void AniSet(int n) {
        if (joutai == 0 || n == 0) {
            Rock.ani_id[0] = move[n][1];
            Rock.ani_id[1] = move[n][3] * 35;
            ani_max = move[n][0];
            Rock.ani_pt[0] = move[n][2];
            Rock.ani_pt[1] = move[n][4];
            int n2 = move[n][5];
            s_wait = CpCanvas.wait_data[n2 * 5];
            e_wait = CpCanvas.wait_data[n2 * 5 + 1];
            r_suu = CpCanvas.wait_data[n2 * 5 + 2];
            r_s = CpCanvas.wait_data[n2 * 5 + 3];
            r_e = CpCanvas.wait_data[n2 * 5 + 4];
            if (e_wait > 99) {
                e_wait = -1;
            }
            this.tmp_s_wait = s_wait;
            this.tmp_r_suu = r_suu;
            this.tmp_e_wait = e_wait;
            ani_cnt = 0;
            joutai = n;
        }
    }

    public void Move() {
        int n;
        int n2;
        if (tmp_ata >= 0) {
            n2 = tip_no;
            n = tmp_ata >> 2;
            if (n > 4) {
                tip_no = n;
            }
            this.Action(tmp_ata & 3);
            if (n > 4) {
                tip_no = n2;
            }
        }
        if (non_cnt > 0) {
            --non_cnt;
        }
        if (non_cnt2 > 0) {
            --non_cnt2;
        }
        if (hit_cnt > 0) {
            --hit_cnt;
        }
        if (syoumetu_cnt > 0) {
            if (--syoumetu_cnt == 15) {
                this.EffSet(4);
            }
            if (syoumetu_cnt == 12) {
                this.EffSet(4);
            }
            if (syoumetu_cnt == 9) {
                this.EffSet(4);
            }
            if (syoumetu_cnt < 7) {
                --muteki_cnt;
            }
            if (syoumetu_cnt == 0) {
                CpCanvas.over_cnt = 1;
            }
            return;
        }
        tmp_x = pos_x;
        tmp_y = pos_y;
        this.PaneCh();
        if (move_flg > 5) {
            if (move_flg == 6) {
                pos_x -= this.Check(-1, 0, 1);
            } else if (move_flg == 7) {
                pos_y -= this.Check(0, -1, 1);
            } else if (move_flg == 8) {
                pos_x += this.Check(1, 0, 1);
            } else if (move_flg == 9) {
                pos_y += this.Check(0, 1, 1);
            }
            move_flg = zoku != 2 && CpCanvas.panel[Rock.pos_y][Rock.pos_x].jou == 5 ? (move_flg - 5 == 1 && this.Check(-1, 0, 2) == 0 || move_flg - 5 == 3 && this.Check(1, 0, 2) == 0 || move_flg - 5 == 2 && this.Check(0, -1, 2) == 0 || move_flg - 5 == 4 && this.Check(0, 1, 2) == 0 ? 0 : (move_flg -= 5)) : 0;
        }
        if (joutai == 0 && move_flg != 0) {
            if (non_cnt2 != 0) {
                move_flg = -5;
            } else if (move_flg == 1) {
                this.Check(-1, 0, 0);
            } else if (move_flg == 2) {
                this.Check(0, -1, 0);
            } else if (move_flg == 3) {
                this.Check(1, 0, 0);
            } else if (move_flg == 4) {
                this.Check(0, 1, 0);
            }
            move_flg += 5;
        }
        if (waza_flg >= 0 && ani_wait_cnt == 0) {
            if (waza_wait == 0) {
                n2 = CpCanvas.AtaNo(0);
                CpCanvas.ata[n2].Set(waza_flg, pos_x, pos_y, 1, 0);
                waza_flg = -1;
                n = CpCanvas.ata[n2].hit_time;
                if (n != 0) {
                    CpCanvas.stop_time = n;
                    CpCanvas.eff_id = n2;
                    CpCanvas.stop_ch = 0;
                    for (int i = 1; i < 6; ++i) {
                        if (this.tip[Rock.tip_no + i].syu >= 4) continue;
                        CpCanvas.stop_name = this.tip[Rock.tip_no + i].name;
                        break;
                    }
                }
            }
            --waza_wait;
        }
        if (bas_no >= 0) {
            CpCanvas.ata[Rock.bas_no].pos_x = pos_x;
            CpCanvas.ata[Rock.bas_no].pos_y = pos_y;
        }
        if (bari_id >= 0) {
            CpCanvas.ata[Rock.bari_id].pos_x = pos_x;
            CpCanvas.ata[Rock.bari_id].pos_y = pos_y;
        }
        if (mahi_id >= 0) {
            CpCanvas.ata[Rock.mahi_id].pos_x = pos_x;
            CpCanvas.ata[Rock.mahi_id].pos_y = pos_y;
        }
        if (han_id >= 0) {
            CpCanvas.ata[Rock.han_id].pos_x = pos_x;
            CpCanvas.ata[Rock.han_id].pos_y = pos_y;
        }
        if (muteki_cnt > 0) {
            --muteki_cnt;
        }
        if (ani_wait_cnt > 0) {
            --ani_wait_cnt;
        }
    }

    public void PaneCh() {
        pane_id = CpCanvas.panel[Rock.pos_y][Rock.pos_x].jou;
        if (CpCanvas.panel[Rock.pos_y][Rock.pos_x].bom_pow > 0) {
            this.Hit(1, CpCanvas.panel[Rock.pos_y][Rock.pos_x].bom_pow, 0);
            this.EffSet(4);
            CpCanvas.panel[Rock.pos_y][Rock.pos_x].bom_pow = 0;
        }
        if (pane_id == 3) {
            if (zoku != 1 && this.Hit(1, 50, 1)) {
                this.EffSet(8);
                CpCanvas.panel[pos_y][pos_x].Henka(1, 0);
            }
        } else if (pane_id == 4) {
            if (zoku == 4 && (hp += CpCanvas.game_cnt % 2) > CpCanvas.max_hp) {
                hp = CpCanvas.max_hp;
            }
        } else if (pane_id == 6 && CpCanvas.game_cnt % 2 == 0) {
            int n = bari;
            bari = 0;
            this.Hit(0, 1, 0);
            hit_cnt = 0;
            bari = n;
        }
    }

    public int Check(int n, int n2, int n3) {
        int n4;
        int n5 = pos_x + n;
        int n6 = pos_y + n2;
        if (n5 < 0 || n5 > 5 || n6 < 0 || n6 > 2) {
            return 0;
        }
        if (CpCanvas.panel[n6][n5].jin != 0) {
            return 0;
        }
        if (air == 0 && CpCanvas.panel[n6][n5].jou <= 0) {
            return 0;
        }
        if (CpCanvas.panel[n6][n5].on_chara != 0 && this.StBom(n5, n6)) {
            return 0;
        }
        if (n3 == 0) {
            n4 = CpCanvas.AtaNo(0);
            CpCanvas.ata[n4].Set(59, pos_x, pos_y, 0, 2);
        }
        if (n3 == 1) {
            CpCanvas.panel[n6][n5].on_chara = 1;
            ++move_cnt;
            tmp_move = 1;
            CpCanvas.panel[tmp_y][tmp_x].NoChara(air);
            n4 = CpCanvas.AtaNo(0);
            CpCanvas.ata[n4].Set(59, n5, n6, 0, 2);
        }
        return 1;
    }

    public boolean StBom(int n, int n2) {
        int n3 = CpCanvas.panel[n2][n].on_chara - 10;
        if (n3 >= 0 && CpCanvas.oki[n3].on != 0 && CpCanvas.oki[n3].move_ok != 0 && CpCanvas.oki[n3].syu == 0) {
            CpCanvas.panel[n2][n].bom_pow = CpCanvas.oki[n3].pow;
            CpCanvas.oki[n3].on = 0;
            CpCanvas.panel[CpCanvas.oki[n3].pos_y][CpCanvas.oki[n3].pos_x].on_chara = 0;
            return false;
        }
        return true;
    }

    public boolean Hit(int n, int n2, int n3) {
        if (n2 == 0) {
            return false;
        }
        if (CpCanvas.dell_cnt > 0) {
            return false;
        }
        if (muteki_cnt > 0 && CpCanvas.stop_cnt == 0) {
            return false;
        }
        if (zoku != 0 && zoku % 4 + 1 == n3) {
            n2 *= 2;
            this.EffSet(39);
        }
        if (pane_id == 7) {
            n2 = (n2 + 1) / 2;
        }
        if (bari > 0) {
            if ((bari -= n2) <= 0) {
                bari = 0;
                CpCanvas.ata[bari_id].init();
                bari_id = -1;
            }
            return true;
        }
        int n4 = hp;
        if (CpCanvas.deba_flg == 0 || CpCanvas.rock_mu == 0 && CpCanvas.deba_flg != 0) {
            hp -= n2;
        }
        if (hp <= 0) {
            if (CpCanvas.skill_kouka[8] != 0 && n4 > 1) {
                hp = 1;
            } else {
                this.Syoumetu();
                hp = 0;
                return true;
            }
        }
        int n5 = ani_wait_cnt;
        if (n == 1) {
            muteki_cnt = 30;
        }
        if (n > 0) {
            ani_wait_cnt = 15;
            ++noke_cnt;
        }
        if (n == 3) {
            ani_wait_cnt = 25;
            if (mahi_id < 0) {
                mahi_id = CpCanvas.AtaNo(0);
            }
            CpCanvas.ata[mahi_id].Set(88, pos_x, pos_y, 0, 3);
            CpCanvas.ata[Rock.mahi_id].pos_dx = 0;
            CpCanvas.ata[Rock.mahi_id].pos_dy = 0;
        }
        if (CpCanvas.stop_cnt != 0) {
            tmp_muteki_cnt = muteki_cnt;
            muteki_cnt = 0;
        }
        if (n2 > 0) {
            hit_cnt = 1;
        }
        if (CpCanvas.skill_kouka[5] != 0 && n != 3) {
            ani_wait_cnt = n5;
            n = 0;
        }
        if (n > 0) {
            move_flg = 0;
            waza_flg = -1;
            joutai = 0;
            this.AniSet(1);
            if (bas_no >= 0) {
                CpCanvas.ata[bas_no].init();
                bas_no = -1;
                CpCanvas.key_cnt = 0;
            }
            tmp_ani_cnt = ani_wait_cnt;
        }
        return true;
    }

    public void Syoumetu() {
        CpCanvas.over_cnt = -1;
        syoumetu_cnt = 16;
        muteki_cnt = 16;
        ani_wait_cnt = 16;
        tmp_ani_cnt = 16;
        joutai = 0;
        this.AniSet(1);
        if (bas_no >= 0) {
            CpCanvas.ata[bas_no].init();
            bas_no = -1;
            CpCanvas.key_cnt = 0;
        }
    }

    public int Chage(int n) {
        if (joutai != 0) {
            return 1;
        }
        if (bas_no < 0) {
            bas_no = CpCanvas.AtaNo(0);
        }
        CpCanvas.ata[bas_no].Set(57 + n, pos_x, pos_y, 1, 2);
        CpCanvas.ata[Rock.bas_no].pos_dx = 0;
        CpCanvas.ata[Rock.bas_no].pos_dy = 0;
        return 0;
    }

    public void EffSet(int n) {
        int n2 = CpCanvas.AtaNo(0);
        CpCanvas.ata[n2].Set(n, pos_x, pos_y, 0, 3);
    }

    public void Action(int n) {
        if (joutai != 0) {
            return;
        }
        if (tip_no < 0) {
            return;
        }
        if (non_cnt > 0) {
            return;
        }
        if (non_cnt2 > 0) {
            return;
        }
        if (move_flg != 0) {
            tmp_ata = n + tip_no << 2;
            return;
        }
        if (bas_no >= 0) {
            CpCanvas.ata[bas_no].init();
            bas_no = -1;
            CpCanvas.key_cnt = 0;
        }
        int n2 = CpCanvas.waza[this.tip[Rock.tip_no].waza_id].move_id;
        this.AniSet(n2);
        waza_wait = CpCanvas.waza[this.tip[Rock.tip_no].waza_id].wait_cnt;
        waza_flg = this.tip[Rock.tip_no].tip_id;
        if (this.tip[Rock.tip_no].syu < 3) {
            Rock.pow[3] = pow[0];
        }
        if (tip_no < 5) {
            tip_no -= next_tip;
            this.TipNext();
        }
        tmp_ata = -1;
        non_bas = 1;
    }

    public void TipNext() {
        Rock.pow[0] = 0;
        for (int i = tip_no; i >= 0; --i) {
            if (this.tip[i].syu >= 4) continue;
            tip_no = i;
            next_tip = 1;
            int n = this.tip[i].syu;
            --i;
            while (i >= 0 && (this.tip[i].syu == 4 && n < 2 || this.tip[i].syu == 5 && n == 1)) {
                pow[0] = pow[0] + this.tip[i].pow;
                ++next_tip;
                --i;
            }
            break;
        }
    }

    public void TipDraw() {
        int n;
        if (tip_no < 0) {
            return;
        }
        for (n = 0; n < tip_no + 1 && joutai != 21; ++n) {
            int n2 = pos_x * 40 + 16 + n * 2 - tip_no * 2;
            int n3 = pos_y * 24 + 105 - 45 - tip_no * 2 + n * 2;
            CpCanvas.tip[this.tip[n].tip_id].Draw(n2, n3, 0, true);
        }
        CpCanvas.g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        CpCanvas.strDraw(this.tip[Rock.tip_no].name, 5, 215);
        if (this.tip[Rock.tip_no].syu < 3) {
            n = CpCanvas.max_hp - hp;
            if (n > 999) {
                n = 999;
            }
            CpCanvas.tip[131].pow = n;
            CpCanvas.g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)0));
            CpCanvas.strDraw(" " + this.tip[Rock.tip_no].pow, 5 + CpCanvas.f.stringWidth(this.tip[Rock.tip_no].name), 215);
            if (pow[0] != 0) {
                CpCanvas.strDraw("+" + pow[0], 5 + CpCanvas.f.stringWidth(this.tip[Rock.tip_no].name + " " + this.tip[Rock.tip_no].pow), 215);
            }
        }
    }

    public void Loop() {
        ani_ok = 1;
        if (--s_wait < 0) {
            s_wait = 0;
            if (r_suu != 0) {
                if (ani_cnt == r_e + 1) {
                    ani_cnt = r_s;
                    if (--r_suu < 0) {
                        r_suu = 0;
                    }
                }
            } else if (CpCanvas.ani[ani_id[0]][ani_pt[0]][ani_cnt + 1] == -2) {
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

    public void WanaDraw() {
        if (wana == 0) {
            return;
        }
        CpCanvas.g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        CpCanvas.strDraw("????", 5, 75);
    }

    public void HpDraw(int n, int n2) {
        CpCanvas.HpDraw(hp, n, n2);
    }

    public void Draw(int n) {
        int n2 = (muteki_cnt % 2 << 4) + (hit_cnt << 4);
        if (non_cnt2 != 0) {
            n2 = 0;
        }
        this.tmp_s_wait = s_wait;
        this.tmp_r_suu = r_suu;
        this.tmp_e_wait = e_wait;
        if (n != 0) {
            this.Loop();
        }
        for (int i = 0; i < ani_max; ++i) {
            if (-2 != CpCanvas.Ani(ani_id[i], ani_pt[i], ani_cnt, pos_x, pos_y + n2, dx + tmp_ani_cnt % 3, dy, 1)) continue;
            if (ani_pt[0] != 0) {
                this.AniSet(0);
            } else {
                ani_cnt = 0;
            }
            CpCanvas.Ani(ani_id[i], ani_pt[i], ani_cnt, pos_x, pos_y + n2, dx + tmp_ani_cnt % 3, dy, 1);
        }
        this.t_ani_cnt = ani_cnt;
        if (tmp_ani_cnt == 0 && ani_ok != 0) {
            ani_cnt += n;
        }
        tmp_ani_cnt = ani_wait_cnt;
    }

    static {
        pow = new int[4];
        ani_id = new int[2];
        ani_pt = new int[2];
        move = new int[22][7];
    }
}

