/*
 * Decompiled with CFR 0.152.
 */
package app;

import app.CpCanvas;
import app.Rock;

class Okimono {
    public int oki_id;
    public int on;
    public int syu;
    public int hp;
    public int drop_time;
    public int rock_ata;
    public int teki_ata;
    public int move_ok;
    public int only_flg;
    public int pos_x;
    public int pos_y;
    public int pos_dx;
    public int pos_dy;
    public int flp;
    public int pow;
    public int hit_cnt;
    public int ani_id;
    public int ani_pt;
    public int ani_max;
    public int ani_cnt;
    public int next_off;
    public int move_cnt;
    public int waza_syu;
    public static int[] o_data = new int[]{537011713, 481781268, 481764869, 1346823684, 1348920836, 1350493700, 1362110474, 1362126858, 134440712, 134440714, 134440716, 134440718, 1208002620, 134358529};

    Okimono(int n) {
        this.oki_id = n;
    }

    public void init() {
        this.hp = 50;
        this.on = 0;
    }

    public void Set(int n, int n2, int n3, int n4, int n5) {
        this.syu = n;
        this.on = 1;
        this.pos_dx = 0;
        this.pos_dy = 0;
        this.pos_x = n2;
        this.pos_y = n3;
        this.hit_cnt = 0;
        this.flp = n4;
        this.hp = (o_data[n] & 0xFF) * 10;
        this.ani_id = o_data[n] >> 8 & 0x3F;
        this.ani_pt = o_data[n] >> 14 & 0x1F;
        this.drop_time = (o_data[n] >> 19 & 0xFF) * 10;
        this.rock_ata = o_data[n] >> 27 & 1;
        this.teki_ata = o_data[n] >> 28 & 1;
        this.move_ok = o_data[n] >> 29 & 1;
        this.only_flg = o_data[n] >> 30 & 1;
        CpCanvas.panel[this.pos_y][this.pos_x].on_chara = 10 + this.oki_id;
        this.ani_cnt = 0;
        this.move_cnt = 0;
        this.NextOff();
        this.waza_syu = 0;
        this.pow = n5;
    }

    public void Move() {
        if (this.on == 0) {
            return;
        }
        --this.drop_time;
        if (this.drop_time == 1) {
            this.Off();
        } else if (this.syu > 2 && this.syu < 6) {
            if (this.move_cnt % 10 == 0) {
                int n = Okimono.PaneRan(this.flp);
                int n2 = n % 6;
                int n3 = n / 6;
                int n4 = CpCanvas.AtaNo(0);
                CpCanvas.ata[n4].Set(80, n2, n3, this.flp, -2);
                CpCanvas.ata[n4].pow = this.pow;
                CpCanvas.ata[n4].chara_flg = 1 - this.flp;
                CpCanvas.ata[n4].zoku = 1;
            }
        } else if (this.syu == 6) {
            int n;
            if (this.move_cnt % 4 == 0) {
                n = CpCanvas.AtaNo(0);
                CpCanvas.ata[n].Set(85, 2 + this.flp, this.move_cnt % 12 / 4, this.flp, -2);
            }
            n = this.move_cnt % 15 / 5;
            if (this.move_cnt % 45 < 15 && CpCanvas.ene[n].chara_no != 12 && CpCanvas.ene[n].chara_no != 13 && CpCanvas.ene[n].chara_no != 32 && CpCanvas.ene[n].move_flg == 0 && CpCanvas.ene[n].tmp_x == CpCanvas.ene[n].pos_x && CpCanvas.ene[n].tmp_y == CpCanvas.ene[n].pos_y) {
                CpCanvas.ene[n].pos_x += CpCanvas.ene[n].Check(1, 0);
            }
        } else if (this.syu == 7) {
            int n;
            if (this.move_cnt % 4 == 0) {
                n = CpCanvas.AtaNo(0);
                CpCanvas.ata[n].Set(86, this.flp * 5, this.move_cnt % 12 / 4, this.flp ^ 1, -2);
            }
            n = this.move_cnt % 15 / 5;
            if (this.move_cnt % 45 < 15 && CpCanvas.ene[n].chara_no != 12 && CpCanvas.ene[n].chara_no != 13 && CpCanvas.ene[n].chara_no != 32 && CpCanvas.ene[n].move_flg == 0 && CpCanvas.ene[n].tmp_x == CpCanvas.ene[n].pos_x && CpCanvas.ene[n].tmp_y == CpCanvas.ene[n].pos_y) {
                CpCanvas.ene[n].pos_x -= CpCanvas.ene[n].Check(-1, 0);
            }
        } else if (this.syu > 7 && this.syu < 12 && this.move_cnt > 60) {
            this.pos_dx = 2;
            int n = CpCanvas.AtaNo(0);
            CpCanvas.ata[n].Set(125, this.pos_x, this.pos_y, this.flp, -2);
            CpCanvas.ata[n].pow = this.pow;
            CpCanvas.ata[n].chara_flg = 1 - this.flp;
            if (this.waza_syu == 0) {
                this.move_cnt = -(CpCanvas.rand.nextInt() >>> 1) % 30;
            } else {
                this.move_cnt = 40;
                this.waza_syu = 0;
            }
        }
        ++this.move_cnt;
    }

    public static int PaneRan(int n) {
        int n2;
        int[] nArray = new int[18];
        int n3 = 0;
        for (n2 = 0; n2 < 18; ++n2) {
            if (CpCanvas.panel[n2 / 6][n2 % 6].jin != n || CpCanvas.panel[n2 / 6][n2 % 6].jou <= 0) continue;
            nArray[n3] = n2;
            ++n3;
        }
        if (n3 == 0) {
            return 100;
        }
        n2 = (CpCanvas.rand.nextInt() >>> 1) % (3 + CpCanvas.ene_cnt);
        if (n2 < 3) {
            if (n == 0 && n2 == 0) {
                return Rock.pos_x + Rock.pos_y * 6;
            }
            if (n != 0 && CpCanvas.ene[n2].on != 0) {
                return CpCanvas.ene[n2].pos_x + CpCanvas.ene[n2].pos_y * 6;
            }
            return nArray[(CpCanvas.rand.nextInt() >>> 1) % n3];
        }
        return nArray[(CpCanvas.rand.nextInt() >>> 1) % n3];
    }

    public void Hit(int n, int n2) {
        if (this.syu == 13) {
            CpCanvas.oki[2].Hit(n, n2);
            return;
        }
        if (CpCanvas.panel[this.pos_y][this.pos_x].jou == 7) {
            n = (n + 1) / 2;
        }
        this.hp -= n;
        if (n2 != 0 && this.syu < 12) {
            this.hp = 0;
        }
        if (this.hp <= 0) {
            this.hp = 0;
            if (this.syu < 12) {
                this.Off();
            } else if (this.ani_pt != 3) {
                this.ani_pt = 3;
                int n3 = CpCanvas.AtaNo(0);
                CpCanvas.ata[n3].Set(4, this.pos_x, 0, 0, 3);
                n3 = CpCanvas.AtaNo(0);
                CpCanvas.ata[n3].Set(4, this.pos_x, 1, 0, 3);
                n3 = CpCanvas.AtaNo(0);
                CpCanvas.ata[n3].Set(4, this.pos_x, 2, 0, 3);
                n3 = CpCanvas.AtaNo(0);
                CpCanvas.ata[n3].Set(115, this.pos_x, 0, 0, 3);
                CpCanvas.ata[n3].pos_dx = 0;
                CpCanvas.ata[n3].pos_dy = 0;
            }
        }
        if (n > 0 && this.syu < 12) {
            this.hit_cnt = 1;
        }
    }

    public void Off() {
        this.on = 0;
        int n = CpCanvas.AtaNo(0);
        CpCanvas.ata[n].Set(4, this.pos_x, this.pos_y, 0, 3);
        CpCanvas.panel[this.pos_y][this.pos_x].NoChara(0);
    }

    public void NextOff() {
        if (this.oki_id % 2 == 0) {
            this.next_off = CpCanvas.oki[this.oki_id + 1].on == 0 ? this.oki_id : this.oki_id + 1;
        } else {
            CpCanvas.oki[this.oki_id - 1].next_off = CpCanvas.oki[this.oki_id - 1].on == 0 ? this.oki_id : this.oki_id - 1;
        }
    }

    public void Draw() {
        if (this.on == 0) {
            return;
        }
        if (this.ani_id == 0) {
            return;
        }
        if (this.hit_cnt != 0) {
            this.hit_cnt = 0;
            return;
        }
        if (-2 == CpCanvas.Ani(this.ani_id, this.ani_pt, this.ani_cnt, this.pos_x, this.pos_y, this.pos_dx, this.pos_dy, this.flp)) {
            this.ani_cnt = 0;
            CpCanvas.Ani(this.ani_id, this.ani_pt, this.ani_cnt, this.pos_x, this.pos_y, this.pos_dx, this.pos_dy, this.flp);
        }
        this.pos_dx = 0;
        this.pos_dy = 0;
        ++this.ani_cnt;
    }
}

