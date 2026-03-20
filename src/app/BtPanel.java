/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.nttdocomo.ui.Graphics
 */
package app;

import app.CpCanvas;
import com.nttdocomo.ui.Graphics;

class BtPanel {
    public int id;
    public int pos_x;
    public int pos_y;
    public int jin;
    public int jou;
    public int yokoku;
    public int ana_cnt;
    public int mag_cnt;
    public int aria_cnt;
    public int on_chara;
    public int bom_pow;
    public int hokkei;
    static int R;
    static int G;
    static int B;

    public void init(int n, int n2, int n3) {
        this.id = n + n2 * 6;
        this.jou = n3;
        this.pos_x = n;
        this.pos_y = n2;
        this.on_chara = 0;
        this.jin = n < 3 ? 0 : 1;
        this.ana_cnt = 0;
        this.aria_cnt = 0;
        this.bom_pow = 0;
        this.hokkei = 0;
        this.mag_cnt = this.jou == 3 ? 250 : 0;
    }

    public void Henka(int n, int n2) {
        if (this.jou < 0) {
            return;
        }
        if (this.jou == 0 && n != 8 && n != 1) {
            return;
        }
        if (this.jou == 2 && n == 2) {
            n = 0;
        }
        if (n == 0) {
            if (CpCanvas.boss_flg == 8 && this.pos_x > 3) {
                return;
            }
            if (this.on_chara == 0) {
                this.jou = n;
                this.ana_cnt = 300;
            } else {
                this.jou = 2;
            }
            this.Draw(-1, true);
        } else if (n == 2) {
            if (this.jou > 0) {
                this.jou = n;
            }
            this.Draw(-1, true);
        } else if (n == 3) {
            this.jou = 3;
            this.mag_cnt = 300;
            this.Draw(-1, true);
        } else if (n == 8) {
            if (CpCanvas.boss_flg == 8 && this.pos_x > 3) {
                return;
            }
            if (n2 != this.jin) {
                return;
            }
            if (this.hokkei != 0) {
                return;
            }
            if ((this.on_chara == 0 || this.on_chara == 12 - n2 * 2 || this.on_chara == 13 - n2 * 2) && (this.jin == 0 && this.pos_x != 0 || this.jin == 1 && this.pos_x != 5)) {
                this.jin ^= 1;
                for (int i = 0; i < 3; ++i) {
                    if (this.jin != CpCanvas.panel[i][this.pos_x].jin) continue;
                    CpCanvas.panel[i][this.pos_x].aria_cnt = 450;
                    if (this.jin != this.pos_x / 3) continue;
                    CpCanvas.panel[i][this.pos_x].aria_cnt = 0;
                }
                this.Draw(-1, true);
            }
        } else {
            this.jou = n;
            this.Draw(-1, true);
        }
    }

    public void NoChara(int n) {
        this.on_chara = 0;
        if (this.jou == 2 && n == 0) {
            this.Henka(0, 0);
        }
    }

    public void Move() {
        int n;
        if (this.ana_cnt > 0) {
            if (this.jou != 0) {
                this.ana_cnt = 0;
            } else {
                --this.ana_cnt;
                if (this.ana_cnt < 30) {
                    n = this.jou;
                    if (this.ana_cnt / 2 % 2 == 0) {
                        this.jou = 1;
                    }
                    this.Draw(-1, true);
                    this.jou = n;
                }
                if (this.ana_cnt == 0) {
                    this.jou = 1;
                    this.Draw(-1, true);
                }
            }
        }
        if (this.mag_cnt > 0) {
            if (this.jou != 3) {
                this.mag_cnt = 0;
            } else {
                --this.mag_cnt;
                if (this.mag_cnt < 30) {
                    n = this.jou;
                    if (this.mag_cnt / 2 % 2 == 0) {
                        this.jou = 1;
                    }
                    this.Draw(-1, true);
                    this.jou = n;
                }
                if (this.mag_cnt == 0) {
                    this.jou = 1;
                    this.Draw(-1, true);
                }
            }
        }
        if (this.aria_cnt > 0 || this.pos_x / 3 != this.jin) {
            --this.aria_cnt;
            if (this.aria_cnt == 45) {
                if (CpCanvas.panel[0][this.pos_x - 1 + this.pos_x / 3 * 2].jin == this.pos_x / 3 && CpCanvas.panel[1][this.pos_x - 1 + this.pos_x / 3 * 2].jin == this.pos_x / 3 && CpCanvas.panel[2][this.pos_x - 1 + this.pos_x / 3 * 2].jin == this.pos_x / 3) {
                    if (this.JinCh()) {
                        this.jin ^= 1;
                    } else {
                        this.aria_cnt = 46;
                    }
                } else {
                    this.aria_cnt = 46;
                }
            }
            if (this.aria_cnt < 45) {
                n = this.jin;
                if (this.aria_cnt / 2 % 2 == 0) {
                    this.jin ^= 1;
                }
                this.Draw(-1, true);
                this.jin = n;
            }
            if (this.aria_cnt <= 0) {
                this.Draw(-1, true);
            }
        }
    }

    public boolean JinCh() {
        int n;
        int n2 = 0;
        for (n = 0; n < 3; ++n) {
            if (CpCanvas.panel[n][this.pos_x].on_chara != 0) continue;
            ++n2;
        }
        if (n2 == 3) {
            return true;
        }
        n2 = 0;
        for (n = 0; n < 3; ++n) {
            if (this.pos_x / 3 == 0 && (CpCanvas.panel[n][this.pos_x].on_chara > 4 || CpCanvas.panel[n][this.pos_x].on_chara == 1)) {
                ++n2;
            }
            if (this.pos_x / 3 == 0 || CpCanvas.panel[n][this.pos_x].on_chara == 1) continue;
            ++n2;
        }
        return n2 == 3;
    }

    public int img() {
        int n = this.jou + 2;
        if (this.jou < 3 && this.jin != 0) {
            n += 10;
        }
        return n;
    }

    public void BackDraw(int n, int n2, boolean bl) {
        if (bl) {
            CpCanvas.graMap.setColor(Graphics.getColorOfRGB((int)R, (int)G, (int)B));
            CpCanvas.graMap.fillRect(n, n2, 40, 24);
        } else {
            CpCanvas.g.setColor(Graphics.getColorOfRGB((int)R, (int)G, (int)B));
            CpCanvas.g.fillRect(n, n2, 40, 24);
        }
    }

    public void Draw(int n, boolean bl) {
        int n2;
        int n3 = this.pos_x * 40 + 0;
        int n4 = this.pos_y * 24 + 105;
        if (n < 0 || this.jou == 0) {
            n2 = this.jin * 10;
            this.BackDraw(n3, n4, bl);
            CpCanvas.drawImg3(42, n2, n3, n4, bl);
        }
        if (n != 0 && this.pos_y == 2) {
            n2 = this.jin * 10 + 1;
            CpCanvas.drawImg3(42, n2, n3, n4, bl);
        }
        if (this.jou < 0) {
            return;
        }
        n2 = this.img();
        CpCanvas.drawImg3(42, n2, n3, n4, bl);
    }

    public void Draw2() {
        if (this.yokoku == 0) {
            return;
        }
        int n = this.pos_x * 40 + 0;
        int n2 = this.pos_y * 24 + 105;
        CpCanvas.drawImg3(42, 15, n, n2, false);
        this.yokoku = 0;
    }
}

