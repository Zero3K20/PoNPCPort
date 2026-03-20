/*
 * Decompiled with CFR 0.152.
 */
package app;

import app.CpCanvas;
import app.Rock;

class Ene {
    public int waza_flg;
    public int waza_wait;
    public int waza_syu;
    public int hp;
    public int max_hp;
    public int zoku;
    public int[] waza_id = new int[5];
    public int[] waza_zoku = new int[5];
    public int[] pow = new int[5];
    public int zenny;
    public int[] drop_tip = new int[4];
    public int pos_x = -1;
    public int pos_y = -1;
    public int pos_dx;
    public int pos_dy;
    public int tmp_x;
    public int tmp_y;
    public int def_x;
    public int def_y;
    public int move_flg;
    public int move_cnt;
    public int wait_cnt;
    public int syoumetu_cnt;
    public int on = 0;
    public int joutai;
    public int muteki_cnt;
    public int tmp_muteki_cnt;
    public int hit_cnt;
    public int ani_wait_cnt;
    public int tmp_wait_cnt;
    public int ani_ok;
    public int s_wait;
    public int e_wait;
    public int r_suu;
    public int r_s;
    public int r_e;
    public int ani_id;
    public int[] ani_pt = new int[3];
    public int ani_max;
    public int ani_cnt;
    public int ani_cnt_max;
    public static int[][] move = new int[22][5];
    public int chara_no = -1;
    public int chara_lv;
    public int chara_id;
    public int ene_id;
    public int bari;
    public int bari_id;
    public int ata_id;
    public int han;
    public int pane_id;
    public int tmp_move;
    public static int eria_flg;
    public int tmp_cnt;
    public int tmp_cnt2;
    public int air;
    public int tmp_lv;
    public int def_ani;
    public int navi_flg;
    public int mahi_id;
    public int muteki2;
    public int t_ani_cnt;
    public int tmp_s_wait;
    public int tmp_r_suu;
    public int tmp_e_wait;
    public int x_sp = 40;
    public int y_sp = 24;

    public void init(int n, int n2, int n3, int n4, int n5) {
        if (n2 > 5) {
            return;
        }
        this.t_ani_cnt = 0;
        this.tmp_s_wait = 0;
        this.tmp_r_suu = 0;
        this.tmp_e_wait = 0;
        this.ene_id = n5;
        this.tmp_lv = n4;
        this.pos_x = n2;
        this.pos_y = n3;
        this.pos_dx = 0;
        this.pos_dy = 0;
        this.def_x = n2;
        this.def_y = n3;
        this.ani_cnt = 0;
        this.muteki2 = 0;
        this.navi_flg = n / 21;
        this.ani_id = n + 1;
        if (this.navi_flg == 0) {
            CpCanvas.PalSet(this.ani_id, n4 + this.ani_id * 4 + 1);
        }
        this.chara_no = n;
        this.MoveSet();
        this.AniSet(0);
        this.ParaSet(n, n4);
        this.move_flg = 0;
        this.move_cnt = 0;
        this.wait_cnt = 0;
        this.waza_flg = -1;
        this.waza_wait = 0;
        this.ani_wait_cnt = 0;
        this.tmp_wait_cnt = 0;
        this.muteki_cnt = 0;
        this.tmp_muteki_cnt = 0;
        this.syoumetu_cnt = -1;
        this.joutai = 0;
        this.waza_syu = 0;
        this.mahi_id = -1;
        this.on = 1;
        ++CpCanvas.ene_cnt;
        CpCanvas.panel[this.pos_y][this.pos_x].on_chara = 2 + this.ene_id;
        this.tmp_move = 0;
        eria_flg = 0;
        this.air = 0;
        this.bari = 0;
        this.bari_id = -1;
        this.han = 0;
        this.ata_id = -1;
        this.def_ani = 0;
        this.tmp_cnt = 0;
        this.tmp_cnt2 = 0;
        this.x_sp = 40;
        this.y_sp = 24;
        this.chara_id = -1;
        for (int i = 0; i < 3; ++i) {
            if (CpCanvas.ene[i].chara_no != this.chara_no) continue;
            ++this.chara_id;
        }
        if (n == 0 && this.chara_id != 0) {
            this.wait_cnt = -1;
        }
        if (n == 32) {
            n = CpCanvas.AtaNo(0);
            CpCanvas.ata[n].Set(161, this.pos_x, this.pos_y, 0, 1);
        }
    }

    public void ParaSet(int n, int n2) {
        int[] nArray = new int[]{CpCanvas.e_data[n * 4 + n2][0], CpCanvas.e_data[n * 4 + n2][1], CpCanvas.e_data[n * 4 + n2][2], CpCanvas.e_data[n * 4 + n2][3], CpCanvas.e_data[n * 4 + n2][4]};
        this.hp = this.max_hp = (nArray[0] & 0x1FF) * 10;
        this.waza_zoku[0] = nArray[0] >> 9 & 7;
        this.waza_zoku[1] = nArray[0] >> 12 & 7;
        this.waza_zoku[2] = nArray[0] >> 15 & 7;
        this.waza_zoku[3] = nArray[0] >> 18 & 7;
        this.zenny = (nArray[0] >> 21) * 10;
        this.zoku = nArray[1] & 7;
        this.pow[0] = (nArray[1] >> 3 & 0x3F) * 10;
        this.pow[1] = (nArray[1] >> 9 & 0x3F) * 10;
        this.pow[2] = (nArray[1] >> 15 & 0x3F) * 10;
        this.pow[3] = (nArray[1] >> 21 & 0x3F) * 10;
        this.waza_id[0] = nArray[2] & 0xFF;
        this.waza_id[1] = nArray[2] >> 8 & 0xFF;
        this.waza_id[2] = nArray[2] >> 16 & 0xFF;
        this.waza_id[3] = nArray[2] >> 24 & 0xFF;
        this.drop_tip[0] = nArray[3] & 0x1FF;
        this.drop_tip[1] = nArray[3] >> 9 & 0x1FF;
        this.drop_tip[2] = nArray[4] & 0x1FF;
        this.drop_tip[3] = nArray[4] >> 9 & 0x1FF;
        if (CpCanvas.deba_flg != 0 && CpCanvas.teki_mu != 0) {
            this.hp += 1000;
        }
    }

    public void MoveSet() {
        for (int i = 0; i < 22; ++i) {
            for (int j = 0; j < 4; ++j) {
                Ene.move[i][j] = CpCanvas.teki_mo[i * 4 + j];
                Ene.move[i][j + 1] = -2;
            }
        }
    }

    public void AniSet(int n) {
        if (this.joutai == 0 || n == this.def_ani || n == 0) {
            this.ani_max = move[n][0];
            this.ani_pt[0] = move[n][1];
            this.ani_pt[1] = move[n][2];
            this.ani_pt[2] = move[n][3];
            int n2 = this.ani_pt[2];
            this.s_wait = CpCanvas.wait_data[n2 * 5];
            this.e_wait = CpCanvas.wait_data[n2 * 5 + 1];
            this.r_suu = CpCanvas.wait_data[n2 * 5 + 2];
            this.r_s = CpCanvas.wait_data[n2 * 5 + 3];
            this.r_e = CpCanvas.wait_data[n2 * 5 + 4];
            if (this.e_wait > 250) {
                this.e_wait = -1;
            }
            this.tmp_s_wait = this.s_wait;
            this.tmp_r_suu = this.r_suu;
            this.tmp_e_wait = this.e_wait;
            this.ani_cnt = 0;
            this.joutai = n;
        }
    }

    /*
     * Unable to fully structure code
     */
    public int Move() {
        block258: {
            block260: {
                block285: {
                    block287: {
                        block286: {
                            block284: {
                                block282: {
                                    block283: {
                                        block281: {
                                            block280: {
                                                block279: {
                                                    block278: {
                                                        block277: {
                                                            block276: {
                                                                block275: {
                                                                    block274: {
                                                                        block273: {
                                                                            block272: {
                                                                                block271: {
                                                                                    block270: {
                                                                                        block269: {
                                                                                            block268: {
                                                                                                block267: {
                                                                                                    block266: {
                                                                                                        block265: {
                                                                                                            block264: {
                                                                                                                block263: {
                                                                                                                    block262: {
                                                                                                                        block261: {
                                                                                                                            block259: {
                                                                                                                                if (this.on == 0) {
                                                                                                                                    return 1;
                                                                                                                                }
                                                                                                                                if (this.muteki_cnt > 0) {
                                                                                                                                    --this.muteki_cnt;
                                                                                                                                }
                                                                                                                                if (this.hit_cnt > 0) {
                                                                                                                                    --this.hit_cnt;
                                                                                                                                }
                                                                                                                                if (this.syoumetu_cnt > 0) {
                                                                                                                                    --this.syoumetu_cnt;
                                                                                                                                    if (this.syoumetu_cnt % 3 == 0 && this.syoumetu_cnt > 5) {
                                                                                                                                        this.EffSet(4);
                                                                                                                                    }
                                                                                                                                    if (this.syoumetu_cnt == 0) {
                                                                                                                                        this.Off();
                                                                                                                                    }
                                                                                                                                    return 0;
                                                                                                                                }
                                                                                                                                this.PaneCh();
                                                                                                                                this.x_sp = 40;
                                                                                                                                this.y_sp = 24;
                                                                                                                                if (this.ani_wait_cnt != 0) break block258;
                                                                                                                                this.tmp_x = this.pos_x;
                                                                                                                                this.tmp_y = this.pos_y;
                                                                                                                                if (this.chara_no != 0) break block259;
                                                                                                                                if (this.move_cnt >= 17 - this.tmp_lv * 2 && this.move_flg == 0) {
                                                                                                                                    this.move_cnt = 0;
                                                                                                                                    if (Rock.pos_y < this.pos_y && this.Check(0, -1) != 0) {
                                                                                                                                        this.move_flg = 2;
                                                                                                                                    } else if (Rock.pos_y > this.pos_y && this.Check(0, 1) != 0) {
                                                                                                                                        this.move_flg = 4;
                                                                                                                                    } else {
                                                                                                                                        this.Action(0);
                                                                                                                                        this.wait_cnt = -1;
                                                                                                                                        this.NextChara(0);
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                break block260;
                                                                                                                            }
                                                                                                                            if (this.chara_no != 1) break block261;
                                                                                                                            if (this.move_cnt <= 0 || this.move_flg != 0) break block260;
                                                                                                                            if (this.tmp_cnt != 0) ** GOTO lbl-1000
                                                                                                                            if (this.pos_y == Rock.pos_y) {
                                                                                                                                this.Action(1);
                                                                                                                                this.wait_cnt = 40;
                                                                                                                                this.tmp_cnt = 0;
                                                                                                                                this.move_cnt = 0;
                                                                                                                            } else if (this.tmp_cnt != 0 && this.wait_cnt == 0) {
                                                                                                                                this.Action(0);
                                                                                                                                this.wait_cnt = 40 - this.tmp_lv * 4;
                                                                                                                                this.tmp_cnt = 0;
                                                                                                                                this.move_cnt = 0;
                                                                                                                            }
                                                                                                                            break block260;
                                                                                                                        }
                                                                                                                        if (this.chara_no != 2) break block262;
                                                                                                                        this.x_sp = 5;
                                                                                                                        this.y_sp = 2;
                                                                                                                        if (this.move_cnt >= 15 && this.move_flg == 0) {
                                                                                                                            this.move_cnt = 0;
                                                                                                                            if (Ene.eria_flg != 0) {
                                                                                                                                this.Action(1);
                                                                                                                                this.wait_cnt = 25;
                                                                                                                                Ene.eria_flg = 0;
                                                                                                                            } else if (Rock.pos_y < this.pos_y && this.Check(0, -1) != 0) {
                                                                                                                                this.move_flg = 2;
                                                                                                                            } else if (Rock.pos_y > this.pos_y && this.Check(0, 1) != 0) {
                                                                                                                                this.move_flg = 4;
                                                                                                                            } else if (this.Check(-1, 0) != 0) {
                                                                                                                                this.move_flg = 1;
                                                                                                                            } else if (Rock.pos_y == this.pos_y) {
                                                                                                                                this.Action(0);
                                                                                                                                this.wait_cnt = 25 - this.tmp_lv * 3;
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (CpCanvas.stop_time == 0 && (CpCanvas.eria_cnt == 130 || CpCanvas.eria_cnt == 260)) {
                                                                                                                            Ene.eria_flg = 1;
                                                                                                                            ++CpCanvas.eria_cnt;
                                                                                                                        }
                                                                                                                        break block260;
                                                                                                                    }
                                                                                                                    if (this.chara_no != 3) break block263;
                                                                                                                    if (this.move_cnt > 14 - this.tmp_lv * 2 && this.move_flg == 0) {
                                                                                                                        if (this.tmp_cnt > 99) {
                                                                                                                            this.Action(0);
                                                                                                                            this.wait_cnt = 16;
                                                                                                                            this.tmp_cnt = 0;
                                                                                                                            this.move_cnt = 0;
                                                                                                                        } else {
                                                                                                                            var2_1 = this.PaneRan(0);
                                                                                                                            if (var2_1 < 100) {
                                                                                                                                var3_25 = CpCanvas.AtaNo(0);
                                                                                                                                CpCanvas.ata[var3_25].Set(59, this.pos_x, this.pos_y, 0, 2);
                                                                                                                                this.pos_x = var2_1 % 6;
                                                                                                                                this.pos_y = var2_1 / 6;
                                                                                                                                this.StBom(this.pos_x, this.pos_y);
                                                                                                                                CpCanvas.panel[this.tmp_y][this.tmp_x].NoChara(this.air);
                                                                                                                            } else {
                                                                                                                                this.tmp_cnt += 30;
                                                                                                                            }
                                                                                                                            CpCanvas.panel[this.pos_y][this.pos_x].on_chara = 2 + this.ene_id;
                                                                                                                            ++this.tmp_cnt;
                                                                                                                            if (this.tmp_cnt >= 4 - this.tmp_lv / 2) {
                                                                                                                                if (this.pos_y == Rock.pos_y) {
                                                                                                                                    this.tmp_cnt = 100;
                                                                                                                                }
                                                                                                                            }
                                                                                                                            this.move_cnt = 0;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    break block260;
                                                                                                                }
                                                                                                                if (this.chara_no != 4) break block264;
                                                                                                                this.y_sp = 3;
                                                                                                                this.air = 1;
                                                                                                                if (this.move_cnt >= 8 && this.move_flg == 0) {
                                                                                                                    this.move_cnt = 0;
                                                                                                                    if ((this.tmp_cnt & 15) >= (CpCanvas.rand.nextInt() >>> 1) % 4 + 4 - this.tmp_lv / 2) {
                                                                                                                        this.Action(0);
                                                                                                                        this.wait_cnt = 10;
                                                                                                                        this.tmp_cnt &= 16;
                                                                                                                    } else if (this.tmp_cnt >> 4 == 0) {
                                                                                                                        if (this.Check(0, 1) == 0) {
                                                                                                                            this.tmp_cnt += 16;
                                                                                                                            this.move_cnt = 4;
                                                                                                                        } else {
                                                                                                                            this.move_flg = 4;
                                                                                                                        }
                                                                                                                    } else if (this.Check(0, -1) == 0) {
                                                                                                                        this.tmp_cnt -= 16;
                                                                                                                        this.move_cnt = 4;
                                                                                                                    } else {
                                                                                                                        this.move_flg = 2;
                                                                                                                    }
                                                                                                                    ++this.tmp_cnt;
                                                                                                                }
                                                                                                                break block260;
                                                                                                            }
                                                                                                            if (this.chara_no != 5) break block265;
                                                                                                            this.x_sp = 20;
                                                                                                            this.y_sp = 12;
                                                                                                            if (this.move_cnt >= 7 && this.move_flg == 0) {
                                                                                                                this.move_cnt = 0;
                                                                                                                if (this.tmp_cnt >= (CpCanvas.rand.nextInt() >>> 1) % 3 + 4 - this.tmp_lv / 2) {
                                                                                                                    this.Action(0);
                                                                                                                    this.wait_cnt = 15 - this.tmp_lv * 3;
                                                                                                                    this.tmp_cnt = 0;
                                                                                                                } else {
                                                                                                                    var1_26 = (CpCanvas.rand.nextInt() >>> 1) % 4;
                                                                                                                    var2_2 = new int[]{-1, 0, 0, -1, 1, 0, 0, 1};
                                                                                                                    for (var3_25 = 0; var3_25 < 4; ++var3_25) {
                                                                                                                        var4_30 = (var1_26 + var3_25) % 4;
                                                                                                                        if (this.Check(var2_2[var4_30 * 2], var2_2[var4_30 * 2 + 1]) == 0) continue;
                                                                                                                        this.move_flg = var4_30 + 1;
                                                                                                                        this.wait_cnt = var4_30;
                                                                                                                        break;
                                                                                                                    }
                                                                                                                    ++this.tmp_cnt;
                                                                                                                }
                                                                                                            }
                                                                                                            break block260;
                                                                                                        }
                                                                                                        if (this.chara_no != 6) break block266;
                                                                                                        this.y_sp = 2;
                                                                                                        if (this.move_cnt >= 14 && this.move_flg == 0) {
                                                                                                            this.move_cnt = 0;
                                                                                                            if ((this.tmp_cnt & 15) > 3 + (CpCanvas.rand.nextInt() >>> 1) % 3 - this.tmp_lv / 2) {
                                                                                                                if (this.pos_x > Rock.pos_x) {
                                                                                                                    this.Action(0);
                                                                                                                    this.wait_cnt = 35 - this.tmp_lv * 5;
                                                                                                                }
                                                                                                                this.tmp_cnt &= 16;
                                                                                                            } else if (this.tmp_cnt >> 4 == 0) {
                                                                                                                if (this.Check(0, 1) == 0) {
                                                                                                                    this.tmp_cnt += 16;
                                                                                                                    this.move_cnt = 10;
                                                                                                                    if ((CpCanvas.rand.nextInt() >>> 1) % 30 != 0) {
                                                                                                                        --this.tmp_cnt;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    this.move_flg = 4;
                                                                                                                }
                                                                                                            } else if (this.Check(0, -1) == 0) {
                                                                                                                this.tmp_cnt -= 16;
                                                                                                                this.move_cnt = 10;
                                                                                                                if ((CpCanvas.rand.nextInt() >>> 1) % 30 == 0) {
                                                                                                                    --this.tmp_cnt;
                                                                                                                }
                                                                                                            } else {
                                                                                                                this.move_flg = 2;
                                                                                                            }
                                                                                                            ++this.tmp_cnt;
                                                                                                        }
                                                                                                        break block260;
                                                                                                    }
                                                                                                    if (this.chara_no != 7) break block267;
                                                                                                    if (this.move_cnt >= 11 && this.move_flg == 0) {
                                                                                                        this.move_cnt = 0;
                                                                                                        if (this.tmp_cnt > 15) {
                                                                                                            if (Rock.pos_y < this.pos_y && this.Check(0, -1) != 0) {
                                                                                                                this.move_flg = 2;
                                                                                                            } else if (Rock.pos_y > this.pos_y && this.Check(0, 1) != 0) {
                                                                                                                this.move_flg = 4;
                                                                                                            } else {
                                                                                                                this.Action(0);
                                                                                                                this.wait_cnt = 35 - this.tmp_lv * 4;
                                                                                                                this.tmp_cnt = 0;
                                                                                                            }
                                                                                                            this.move_cnt = 9;
                                                                                                        } else {
                                                                                                            var1_27 = (CpCanvas.rand.nextInt() >>> 1) % 4;
                                                                                                            var2_3 = new int[]{-1, 0, 0, -1, 1, 0, 0, 1};
                                                                                                            for (var3_25 = 0; var3_25 < 4; ++var3_25) {
                                                                                                                var4_31 = (var1_27 + var3_25) % 4;
                                                                                                                if (this.Check(var2_3[var4_31 * 2], var2_3[var4_31 * 2 + 1]) == 0) continue;
                                                                                                                var5_34 = CpCanvas.AtaNo(0);
                                                                                                                CpCanvas.ata[var5_34].Set(59, this.pos_x, this.pos_y, 0, 2);
                                                                                                                this.move_flg = var4_31 + 1;
                                                                                                                break;
                                                                                                            }
                                                                                                            ++this.tmp_cnt;
                                                                                                            if (this.tmp_cnt >= (CpCanvas.rand.nextInt() >>> 1) % 3 + 3 - this.tmp_lv / 2) {
                                                                                                                this.tmp_cnt += 16;
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                    break block260;
                                                                                                }
                                                                                                if (this.chara_no != 8) break block268;
                                                                                                if (this.move_cnt > 35 - this.tmp_lv * 2 && this.move_flg == 0) {
                                                                                                    this.Action(0);
                                                                                                    this.wait_cnt = 45 - this.tmp_lv * 2;
                                                                                                    this.move_cnt = 0;
                                                                                                }
                                                                                                this.han = this.ani_cnt > 2 ? 0 : 5;
                                                                                                break block260;
                                                                                            }
                                                                                            if (this.chara_no != 9) break block269;
                                                                                            if (this.move_cnt > 40 - this.tmp_lv * 5 && this.move_flg == 0) {
                                                                                                this.Action(0);
                                                                                                this.wait_cnt = 40 - this.tmp_lv * 5;
                                                                                                this.move_cnt = 0;
                                                                                            }
                                                                                            break block260;
                                                                                        }
                                                                                        if (this.chara_no != 10) break block270;
                                                                                        this.x_sp = 5;
                                                                                        this.y_sp = 3;
                                                                                        if (this.move_cnt >= 8 && this.move_flg == 0) {
                                                                                            this.move_cnt = 0;
                                                                                            if (this.tmp_cnt >= 3 + (CpCanvas.rand.nextInt() >>> 1) % 3 - this.tmp_lv / 2) {
                                                                                                this.Action(0);
                                                                                                this.wait_cnt = 20 - this.tmp_lv * 3;
                                                                                                this.tmp_cnt = 0;
                                                                                            } else {
                                                                                                var1_28 = (CpCanvas.rand.nextInt() >>> 1) % 4;
                                                                                                var2_4 = new int[]{-1, 0, 0, -1, 1, 0, 0, 1};
                                                                                                for (var3_25 = 0; var3_25 < 4; ++var3_25) {
                                                                                                    var4_32 = (var1_28 + var3_25) % 4;
                                                                                                    if (this.pos_x == 4 && var4_32 == 0 || this.Check(var2_4[var4_32 * 2], var2_4[var4_32 * 2 + 1]) == 0) continue;
                                                                                                    this.move_flg = var4_32 + 1;
                                                                                                    var3_25 = 10;
                                                                                                    break;
                                                                                                }
                                                                                                ++this.tmp_cnt;
                                                                                            }
                                                                                        }
                                                                                        break block260;
                                                                                    }
                                                                                    if (this.chara_no != 11) break block271;
                                                                                    this.y_sp = 2;
                                                                                    this.air = 1;
                                                                                    if (this.move_cnt >= 12 && this.move_flg == 0) {
                                                                                        this.move_cnt = 0;
                                                                                        if (this.tmp_cnt == 0) {
                                                                                            if (this.Check(0, 1) == 0) {
                                                                                                this.tmp_cnt = 1;
                                                                                                if (this.pos_y == 2) {
                                                                                                    this.Action(0);
                                                                                                    this.wait_cnt = 35;
                                                                                                }
                                                                                            } else {
                                                                                                this.move_flg = 4;
                                                                                            }
                                                                                        } else if (this.Check(0, -1) == 0) {
                                                                                            this.tmp_cnt = 0;
                                                                                            if (this.pos_y == 0) {
                                                                                                this.Action(0);
                                                                                                this.wait_cnt = 25;
                                                                                            }
                                                                                        } else {
                                                                                            this.move_flg = 2;
                                                                                        }
                                                                                    }
                                                                                    if (this.wait_cnt == 1) {
                                                                                        this.joutai = 0;
                                                                                        this.AniSet(2);
                                                                                    }
                                                                                    this.han = this.joutai == 0 ? 5 : 0;
                                                                                    break block260;
                                                                                }
                                                                                if (this.chara_no != 12) break block272;
                                                                                if (this.move_cnt == 0) {
                                                                                    this.wait_cnt = 8;
                                                                                    this.move_cnt = 1;
                                                                                    this.bari = 1;
                                                                                    this.tmp_cnt = 0;
                                                                                } else if (this.move_cnt == 2) {
                                                                                    this.Action(this.bari);
                                                                                    this.def_ani = (1 - this.bari) * 5;
                                                                                    this.move_cnt = 3;
                                                                                    this.tmp_cnt = 1;
                                                                                }
                                                                                break block260;
                                                                            }
                                                                            if (this.chara_no != 13) break block273;
                                                                            this.air = 1;
                                                                            if (this.move_cnt == 0) {
                                                                                this.wait_cnt = 8;
                                                                                this.move_cnt = 1;
                                                                            } else if (this.move_cnt == 2) {
                                                                                this.Action(0);
                                                                                this.move_cnt = 3;
                                                                            }
                                                                            break block260;
                                                                        }
                                                                        if (this.chara_no != 14) break block274;
                                                                        if (this.move_cnt > 13 && this.move_flg == 0) {
                                                                            if (this.tmp_cnt > 4) {
                                                                                this.Action(0);
                                                                                this.wait_cnt = 45 + (this.tmp_lv - this.tmp_lv / 3) * 16;
                                                                                this.tmp_cnt = 0;
                                                                            } else {
                                                                                var2_5 = this.PaneRan(this.tmp_cnt / 4 + 1);
                                                                                if (var2_5 < 100) {
                                                                                    var3_25 = CpCanvas.AtaNo(0);
                                                                                    CpCanvas.ata[var3_25].Set(59, this.pos_x, this.pos_y, 0, 2);
                                                                                    this.pos_x = var2_5 % 6;
                                                                                    this.pos_y = var2_5 / 6;
                                                                                    this.StBom(this.pos_x, this.pos_y);
                                                                                    CpCanvas.panel[this.tmp_y][this.tmp_x].NoChara(this.air);
                                                                                }
                                                                                CpCanvas.panel[this.pos_y][this.pos_x].on_chara = 2 + this.ene_id;
                                                                                ++this.tmp_cnt;
                                                                                this.move_cnt = 0;
                                                                            }
                                                                            this.move_cnt = 0;
                                                                        }
                                                                        break block260;
                                                                    }
                                                                    if (this.chara_no != 15) break block275;
                                                                    this.y_sp = 1;
                                                                    this.air = 1;
                                                                    if (this.move_cnt >= 25 && this.move_flg == 0) {
                                                                        this.move_cnt = 0;
                                                                        if (Rock.pos_y < this.pos_y && this.Check(0, -1) != 0) {
                                                                            this.move_flg = 2;
                                                                        } else if (Rock.pos_y > this.pos_y && this.Check(0, 1) != 0) {
                                                                            this.move_flg = 4;
                                                                        } else if (Rock.pos_y == this.pos_y) {
                                                                            this.def_x = this.pos_x;
                                                                            this.def_y = this.pos_y;
                                                                            var2_6 = CpCanvas.AtaNo(0);
                                                                            CpCanvas.ata[var2_6].Set(59, this.pos_x, this.pos_y, 0, 2);
                                                                            this.Action(0);
                                                                            this.wait_cnt = 15;
                                                                        }
                                                                    }
                                                                    this.han = this.joutai == 0 ? 5 : 0;
                                                                    break block260;
                                                                }
                                                                if (this.chara_no != 16) break block276;
                                                                if (this.tmp_lv % 2 == 0) {
                                                                    if (CpCanvas.bas_cnt % 4 == 0) {
                                                                        var2_7 = CpCanvas.AtaNo(0);
                                                                        CpCanvas.ata[var2_7].Set(85, 2, CpCanvas.bas_cnt % 12 / 4, 0, -2);
                                                                    }
                                                                    if (CpCanvas.bas_cnt % 20 < 5) {
                                                                        if (Rock.move_flg == 0) {
                                                                            if (Rock.tmp_x == Rock.pos_x) {
                                                                                if (Rock.tmp_y == Rock.pos_y) {
                                                                                    Rock.pos_x -= CpCanvas.rock.Check(-1, 0, 1);
                                                                                    ** GOTO lbl808
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (CpCanvas.bas_cnt % 4 == 0) {
                                                                        var2_8 = CpCanvas.AtaNo(0);
                                                                        CpCanvas.ata[var2_8].Set(86, 0, CpCanvas.bas_cnt % 12 / 4, 1, -2);
                                                                    }
                                                                    if (CpCanvas.bas_cnt % 20 < 5) {
                                                                        if (Rock.move_flg == 0) {
                                                                            if (Rock.tmp_x == Rock.pos_x) {
                                                                                if (Rock.tmp_y == Rock.pos_y) {
                                                                                    Rock.pos_x += CpCanvas.rock.Check(1, 0, 1);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                break block260;
                                                            }
                                                            if (this.chara_no >= 21) break block277;
                                                            this.y_sp = 4;
                                                            if (this.move_cnt >= 8 + (CpCanvas.rand.nextInt() >>> 1) % 4 && this.move_flg == 0) {
                                                                this.move_cnt = 0;
                                                                if ((this.tmp_cnt & 15) >= (CpCanvas.rand.nextInt() >>> 1) % 3 + 6 - this.tmp_lv) {
                                                                    this.Action(0);
                                                                    this.wait_cnt = 40 - this.tmp_lv * 5;
                                                                    this.tmp_cnt &= 16;
                                                                } else if (this.tmp_cnt >> 4 == 0) {
                                                                    if (this.Check(0, 1) == 0) {
                                                                        this.tmp_cnt += 16;
                                                                        this.move_cnt = 4;
                                                                    } else {
                                                                        this.move_flg = 4;
                                                                    }
                                                                } else if (this.Check(0, -1) == 0) {
                                                                    this.tmp_cnt -= 16;
                                                                    this.move_cnt = 4;
                                                                } else {
                                                                    this.move_flg = 2;
                                                                }
                                                                ++this.tmp_cnt;
                                                            }
                                                            break block260;
                                                        }
                                                        if (this.chara_no != 21) break block278;
                                                        if (this.move_cnt > 15 - this.tmp_lv * 2 && this.move_flg == 0 && this.joutai == 0) {
                                                            if (this.tmp_cnt > 99) {
                                                                this.Action(this.waza_syu);
                                                                this.wait_cnt = 36 - this.tmp_lv * 6;
                                                                this.tmp_cnt = 0;
                                                                this.move_cnt = 0;
                                                            } else {
                                                                var2_9 = this.PaneRan(0);
                                                                if (var2_9 < 100) {
                                                                    var3_25 = CpCanvas.AtaNo(0);
                                                                    CpCanvas.ata[var3_25].Set(59, this.pos_x, this.pos_y, 0, 2);
                                                                    this.pos_x = var2_9 % 6;
                                                                    this.pos_y = var2_9 / 6;
                                                                    this.StBom(this.pos_x, this.pos_y);
                                                                    CpCanvas.panel[this.tmp_y][this.tmp_x].NoChara(this.air);
                                                                }
                                                                CpCanvas.panel[this.pos_y][this.pos_x].on_chara = 2 + this.ene_id;
                                                                ++this.tmp_cnt;
                                                                this.move_cnt = 0;
                                                                if (this.tmp_cnt > 1 + (CpCanvas.rand.nextInt() >>> 1) % 3) {
                                                                    this.waza_syu = this.pos_y == Rock.pos_y ? 0 : 1 + (CpCanvas.rand.nextInt() >>> 1) % 2;
                                                                    this.tmp_cnt = 100;
                                                                }
                                                            }
                                                        }
                                                        break block260;
                                                    }
                                                    if (this.chara_no != 22) break block279;
                                                    if (this.move_cnt > 10 - this.tmp_lv && this.move_flg == 0 && this.joutai == 0) {
                                                        this.move_cnt = 0;
                                                        if (this.tmp_cnt > 15) {
                                                            this.Action(this.waza_syu);
                                                            this.wait_cnt = 30 - this.tmp_lv * 4;
                                                            if (this.tmp_cnt > 99) {
                                                                this.wait_cnt = 6;
                                                                this.tmp_cnt = 10;
                                                                this.move_cnt = 10 - this.tmp_lv - 5;
                                                            } else {
                                                                this.tmp_cnt = 0;
                                                                this.move_cnt = 0;
                                                            }
                                                        } else {
                                                            var1_29 = (CpCanvas.rand.nextInt() >>> 1) % 4;
                                                            var2_10 = new int[]{-1, 0, 0, -1, 1, 0, 0, 1};
                                                            for (var3_25 = 0; var3_25 < 4; ++var3_25) {
                                                                var4_33 = (var1_29 + var3_25) % 4;
                                                                if (this.Check(var2_10[var4_33 * 2], var2_10[var4_33 * 2 + 1]) == 0) continue;
                                                                var5_35 = CpCanvas.AtaNo(0);
                                                                CpCanvas.ata[var5_35].Set(59, this.pos_x, this.pos_y, 0, 2);
                                                                this.move_flg = var4_33 + 1;
                                                                break;
                                                            }
                                                            ++this.tmp_cnt;
                                                            if (this.tmp_cnt >= (CpCanvas.rand.nextInt() >>> 1) % 3 + 3) {
                                                                if (this.tmp_cnt > 10) {
                                                                    this.waza_syu = 3;
                                                                    this.tmp_cnt = 16;
                                                                } else {
                                                                    this.waza_syu = (CpCanvas.rand.nextInt() >>> 1) % 4 * ((CpCanvas.rand.nextInt() >>> 1) % 2);
                                                                    this.tmp_cnt = 16;
                                                                    if (this.waza_syu == 3) {
                                                                        this.tmp_cnt = 100;
                                                                        ** GOTO lbl808
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    break block260;
                                                }
                                                if (this.chara_no != 23) break block280;
                                                if (this.move_cnt > 12 - this.tmp_lv * 2 && this.move_flg == 0 && this.joutai == 0) {
                                                    if (this.tmp_cnt > 15) {
                                                        this.muteki2 = 1;
                                                        this.Action(this.waza_syu);
                                                        this.wait_cnt = 30 + 35 * this.waza_syu - this.tmp_lv * 2;
                                                        this.tmp_cnt = 0;
                                                        this.move_cnt = 0;
                                                    } else {
                                                        var2_11 = this.PaneRan(0);
                                                        this.muteki2 = 0;
                                                        if (var2_11 < 100) {
                                                            var3_25 = CpCanvas.AtaNo(0);
                                                            CpCanvas.ata[var3_25].Set(59, this.pos_x, this.pos_y, 0, 2);
                                                            this.pos_x = var2_11 % 6;
                                                            this.pos_y = var2_11 / 6;
                                                            this.StBom(this.pos_x, this.pos_y);
                                                            CpCanvas.panel[this.tmp_y][this.tmp_x].NoChara(this.air);
                                                        }
                                                        CpCanvas.panel[this.pos_y][this.pos_x].on_chara = 2 + this.ene_id;
                                                        ++this.tmp_cnt;
                                                        this.move_cnt = 0;
                                                        if (this.tmp_cnt > 1 + (CpCanvas.rand.nextInt() >>> 1) % 3) {
                                                            this.waza_syu = 1 - (CpCanvas.rand.nextInt() >>> 1) % 3 / 2;
                                                            this.tmp_cnt = 100;
                                                        }
                                                    }
                                                }
                                                break block260;
                                            }
                                            if (this.chara_no != 24) break block281;
                                            if (this.move_cnt > 12 - this.tmp_lv * 2 && this.move_flg == 0 && this.joutai == 0) {
                                                if (this.tmp_cnt > 15) {
                                                    this.Action(this.waza_syu);
                                                    this.wait_cnt = 45 - this.tmp_lv * 2;
                                                    if (this.waza_syu == 0) {
                                                        this.muteki2 = 1;
                                                    }
                                                    this.tmp_cnt = 0;
                                                    this.move_cnt = 0;
                                                } else {
                                                    var2_12 = this.PaneRan(0);
                                                    this.muteki2 = 0;
                                                    if (var2_12 < 100) {
                                                        var3_25 = CpCanvas.AtaNo(0);
                                                        CpCanvas.ata[var3_25].Set(59, this.pos_x, this.pos_y, 0, 2);
                                                        this.pos_x = var2_12 % 6;
                                                        this.pos_y = var2_12 / 6;
                                                        this.StBom(this.pos_x, this.pos_y);
                                                        CpCanvas.panel[this.tmp_y][this.tmp_x].NoChara(this.air);
                                                    }
                                                    CpCanvas.panel[this.pos_y][this.pos_x].on_chara = 2 + this.ene_id;
                                                    ++this.tmp_cnt;
                                                    this.move_cnt = 0;
                                                    if (this.tmp_cnt > 2 + (CpCanvas.rand.nextInt() >>> 1) % 3) {
                                                        this.waza_syu = (CpCanvas.rand.nextInt() >>> 1) % 3;
                                                        this.tmp_cnt = 100;
                                                    }
                                                }
                                            }
                                            break block260;
                                        }
                                        if (this.chara_no != 25) break block282;
                                        if (this.move_cnt <= 12 - this.tmp_lv * 2 || this.move_flg != 0 || this.joutai != 0) break block260;
                                        if (this.tmp_cnt <= 15) break block283;
                                        this.Action(this.waza_syu);
                                        this.wait_cnt = 30 - this.tmp_lv * 2;
                                        this.tmp_cnt = 0;
                                        this.move_cnt = 0;
                                        break block260;
                                    }
                                    var2_13 = this.PaneRan(0);
                                    if (var2_13 < 100) {
                                        var3_25 = CpCanvas.AtaNo(0);
                                        CpCanvas.ata[var3_25].Set(59, this.pos_x, this.pos_y, 0, 2);
                                        this.pos_x = var2_13 % 6;
                                        this.pos_y = var2_13 / 6;
                                        this.StBom(this.pos_x, this.pos_y);
                                        CpCanvas.panel[this.tmp_y][this.tmp_x].NoChara(this.air);
                                    }
                                    CpCanvas.panel[this.pos_y][this.pos_x].on_chara = 2 + this.ene_id;
                                    ++this.tmp_cnt;
                                    this.move_cnt = 0;
                                    if ((CpCanvas.rand.nextInt() >>> 1) % 4 == 0) ** GOTO lbl-1000
                                    if (this.pos_x - 1 != Rock.pos_x) ** GOTO lbl-1000
                                    if (this.pos_y == Rock.pos_y) {
                                        this.waza_syu = 3;
                                        this.tmp_cnt = 100;
                                    } else if (this.tmp_cnt > (CpCanvas.rand.nextInt() >>> 1) % 2) {
                                        this.waza_syu = (CpCanvas.rand.nextInt() >>> 1) % 3 / (2 - this.tmp_lv / 2);
                                        this.tmp_cnt = 100;
                                    }
                                    break block260;
                                }
                                if (this.chara_no != 26) break block284;
                                if (this.move_cnt > 12 - this.tmp_lv * 2 && this.move_flg == 0 && this.joutai == 0) {
                                    if (this.tmp_cnt > 15) {
                                        this.Action(this.waza_syu);
                                        this.wait_cnt = 30 - this.tmp_lv * 2;
                                        if (this.waza_syu == 1) {
                                            var2_14 = CpCanvas.AtaNo(0);
                                            CpCanvas.ata[var2_14].Set(59, this.pos_x, this.pos_y, 0, 2);
                                            this.def_x = this.pos_x;
                                            this.def_y = this.pos_y;
                                        }
                                        this.tmp_cnt = 0;
                                        this.move_cnt = 0;
                                    } else {
                                        var2_15 = this.PaneRan(0);
                                        if (var2_15 < 100) {
                                            var3_25 = CpCanvas.AtaNo(0);
                                            CpCanvas.ata[var3_25].Set(59, this.pos_x, this.pos_y, 0, 2);
                                            this.pos_x = var2_15 % 6;
                                            this.pos_y = var2_15 / 6;
                                            this.StBom(this.pos_x, this.pos_y);
                                            CpCanvas.panel[this.tmp_y][this.tmp_x].NoChara(this.air);
                                        }
                                        CpCanvas.panel[this.pos_y][this.pos_x].on_chara = 2 + this.ene_id;
                                        ++this.tmp_cnt;
                                        this.move_cnt = 0;
                                        if (this.tmp_cnt > 1 + (CpCanvas.rand.nextInt() >>> 1) % 3) {
                                            this.waza_syu = (CpCanvas.rand.nextInt() >>> 1) % 2;
                                            this.tmp_cnt = 100;
                                        }
                                    }
                                }
                                break block260;
                            }
                            if (this.chara_no != 27) break block285;
                            if (this.move_cnt <= 12 - this.tmp_lv * 2 || this.move_flg != 0 || this.joutai != 0) break block260;
                            if (this.tmp_cnt <= 15) break block286;
                            this.Action(this.waza_syu);
                            this.wait_cnt = 30 - this.tmp_lv * 2;
                            if (this.waza_syu == 1) {
                                var2_16 = CpCanvas.AtaNo(0);
                                CpCanvas.ata[var2_16].Set(59, this.pos_x, this.pos_y, 0, 2);
                                this.def_x = this.pos_x;
                                this.def_y = this.pos_y;
                            }
                            this.tmp_cnt = 0;
                            this.move_cnt = 0;
                            break block260;
                        }
                        var2_17 = this.PaneRan(0);
                        if (var2_17 < 100) {
                            var3_25 = CpCanvas.AtaNo(0);
                            CpCanvas.ata[var3_25].Set(59, this.pos_x, this.pos_y, 0, 2);
                            this.pos_x = var2_17 % 6;
                            this.pos_y = var2_17 / 6;
                            this.StBom(this.pos_x, this.pos_y);
                            CpCanvas.panel[this.tmp_y][this.tmp_x].NoChara(this.air);
                        }
                        CpCanvas.panel[this.pos_y][this.pos_x].on_chara = 2 + this.ene_id;
                        ++this.tmp_cnt;
                        this.move_cnt = 0;
                        if (this.tmp_cnt <= 2 + (CpCanvas.rand.nextInt() >>> 1) % 3) break block260;
                        if ((CpCanvas.rand.nextInt() >>> 1) % 4 == 0) break block287;
                        if (this.pos_y != Rock.pos_y) break block287;
                        if (this.pos_x - 3 <= Rock.pos_x) ** GOTO lbl-1000
                    }
                    if (this.pos_y == Rock.pos_y) {
                        ** if (this.pos_x - 1 != Rock.pos_x) goto lbl-1000
                    }
                    ** GOTO lbl-1000
lbl-1000:
                    // 2 sources

                    {
                        this.waza_syu = 0;
                        this.move_cnt = -5;
                        ** GOTO lbl645
                    }
lbl-1000:
                    // 2 sources

                    {
                        if ((CpCanvas.rand.nextInt() >>> 1) % 3 != 0 && this.pos_y != 1) {
                            this.waza_syu = 2;
                            this.move_cnt = -5;
                        } else {
                            this.waza_syu = 1;
                        }
                    }
lbl645:
                    // 3 sources

                    this.tmp_cnt = 100;
                    break block260;
                }
                if (this.chara_no == 28) {
                    if (this.move_cnt > 12 - this.tmp_lv * 2 && this.move_flg == 0 && this.joutai == 0) {
                        if (this.tmp_cnt > 15) {
                            this.Action(this.waza_syu);
                            this.wait_cnt = 45 - this.tmp_lv * 2;
                            if (this.waza_syu == 2) {
                                this.muteki2 = 1;
                            }
                            this.tmp_cnt = 0;
                            this.move_cnt = 0;
                        } else {
                            var2_18 = this.PaneRan(0);
                            this.muteki2 = 0;
                            if (var2_18 < 100) {
                                var3_25 = CpCanvas.AtaNo(0);
                                CpCanvas.ata[var3_25].Set(59, this.pos_x, this.pos_y, 0, 2);
                                this.pos_x = var2_18 % 6;
                                this.pos_y = var2_18 / 6;
                                this.StBom(this.pos_x, this.pos_y);
                                CpCanvas.panel[this.tmp_y][this.tmp_x].NoChara(this.air);
                            }
                            CpCanvas.panel[this.pos_y][this.pos_x].on_chara = 2 + this.ene_id;
                            ++this.tmp_cnt;
                            this.move_cnt = 0;
                            if (this.tmp_cnt > 1 + (CpCanvas.rand.nextInt() >>> 1) % 3) {
                                this.waza_syu = (CpCanvas.rand.nextInt() >>> 1) % 5 / 2;
                                this.tmp_cnt = 100;
                            }
                        }
                    }
                } else if (this.chara_no == 29) {
                    if (this.move_cnt > 12 - this.tmp_lv * 2 && this.move_flg == 0 && this.joutai == 0) {
                        if (this.tmp_cnt > 15) {
                            this.Action(this.waza_syu);
                            this.wait_cnt = 30 - this.tmp_lv * 2;
                            this.tmp_cnt = 0;
                            this.move_cnt = 0;
                        } else {
                            var2_19 = this.PaneRan(0);
                            if (var2_19 < 100) {
                                var3_25 = CpCanvas.AtaNo(0);
                                CpCanvas.ata[var3_25].Set(59, this.pos_x, this.pos_y, 0, 2);
                                this.pos_x = var2_19 % 6;
                                this.pos_y = var2_19 / 6;
                                this.StBom(this.pos_x, this.pos_y);
                                CpCanvas.panel[this.tmp_y][this.tmp_x].NoChara(this.air);
                            }
                            CpCanvas.panel[this.pos_y][this.pos_x].on_chara = 2 + this.ene_id;
                            ++this.tmp_cnt;
                            this.move_cnt = 0;
                            if (this.tmp_cnt > 1 + (CpCanvas.rand.nextInt() >>> 1) % 2) {
                                this.waza_syu = (CpCanvas.rand.nextInt() >>> 1) % 3;
                                if (this.waza_syu == 2 && CpCanvas.oki[2].on != 0 && CpCanvas.oki[3].on != 0) {
                                    this.waza_syu = 3;
                                }
                                this.tmp_cnt = 100;
                            }
                        }
                    }
                } else if (this.chara_no == 30) {
                    if (this.move_cnt > 12 - this.tmp_lv * 2 && this.move_flg == 0 && this.joutai == 0) {
                        if (this.tmp_cnt > 15) {
                            this.Action(this.waza_syu);
                            this.wait_cnt = 25 - this.tmp_lv * 2;
                            this.tmp_cnt = 0;
                            this.move_cnt = 0;
                        } else {
                            var2_20 = this.PaneRan(0);
                            if (var2_20 < 100) {
                                var3_25 = CpCanvas.AtaNo(0);
                                CpCanvas.ata[var3_25].Set(59, this.pos_x, this.pos_y, 0, 2);
                                this.pos_x = var2_20 % 6;
                                this.pos_y = var2_20 / 6;
                                this.StBom(this.pos_x, this.pos_y);
                                CpCanvas.panel[this.tmp_y][this.tmp_x].NoChara(this.air);
                            }
                            CpCanvas.panel[this.pos_y][this.pos_x].on_chara = 2 + this.ene_id;
                            ++this.tmp_cnt;
                            this.move_cnt = 0;
                            if (this.tmp_cnt > 1 + (CpCanvas.rand.nextInt() >>> 1) % 2) {
                                if (this.tmp_cnt2 == 0) {
                                    this.waza_syu = (CpCanvas.rand.nextInt() >>> 1) % 3;
                                } else {
                                    this.waza_syu = (CpCanvas.rand.nextInt() >>> 1) % 2 * 2;
                                    ++this.tmp_cnt2;
                                }
                                if (this.waza_syu == 1) {
                                    this.tmp_cnt2 = 1;
                                }
                                if (this.tmp_cnt2 == 3) {
                                    this.tmp_cnt2 = 0;
                                }
                                this.tmp_cnt = 100;
                            }
                        }
                    }
                } else if (this.chara_no == 31) {
                    if (this.move_cnt > 8 - this.tmp_lv && this.move_flg == 0 && this.joutai == 0) {
                        if (this.tmp_cnt > 15) {
                            this.Action(this.waza_syu);
                            this.wait_cnt = 10 - this.tmp_lv;
                            this.tmp_cnt = 0;
                            this.move_cnt = 0;
                        } else {
                            var2_21 = this.PaneRan(0);
                            if (var2_21 < 100) {
                                var3_25 = CpCanvas.AtaNo(0);
                                CpCanvas.ata[var3_25].Set(59, this.pos_x, this.pos_y, 0, 2);
                                this.pos_x = var2_21 % 6;
                                this.pos_y = var2_21 / 6;
                                this.StBom(this.pos_x, this.pos_y);
                                CpCanvas.panel[this.tmp_y][this.tmp_x].NoChara(this.air);
                            }
                            CpCanvas.panel[this.pos_y][this.pos_x].on_chara = 2 + this.ene_id;
                            ++this.tmp_cnt;
                            this.move_cnt = 0;
                            if (this.tmp_cnt > (CpCanvas.rand.nextInt() >>> 1) % 2) {
                                this.waza_syu = 1 - (CpCanvas.rand.nextInt() >>> 1) % 4 / 3;
                                if (this.waza_syu == 1 && CpCanvas.ene[1].on != 0) {
                                    this.waza_syu = 0;
                                }
                                this.tmp_cnt = 100;
                            }
                        }
                    }
                } else if (this.chara_no == 32) {
                    this.air = 1;
                    if (this.move_cnt > 12 - this.tmp_lv * 2 && this.move_flg == 0 && this.joutai == 0) {
                        if (this.tmp_cnt > 15) {
                            this.Action(this.waza_syu);
                            this.wait_cnt = 50 - this.tmp_lv * 2;
                            this.tmp_cnt = 0;
                            this.move_cnt = 0;
                        } else {
                            this.move_cnt = 0;
                            ++this.tmp_cnt;
                            if (this.tmp_cnt > (CpCanvas.rand.nextInt() >>> 1) % 2) {
                                this.waza_syu = CpCanvas.oki[2].hp > 0 ? (CpCanvas.ene[1].on == 0 ? 2 - (CpCanvas.rand.nextInt() >>> 1) % 4 / 3 * 2 : 1 + (CpCanvas.rand.nextInt() >>> 1) % 2) : 2 + (CpCanvas.rand.nextInt() >>> 1) % 5 / 4;
                                this.tmp_cnt = 100;
                            }
                        }
                    }
                } else if (this.chara_no == 33 && this.move_cnt > 10 - this.tmp_lv * 2 && this.move_flg == 0 && this.joutai == 0) {
                    if (this.tmp_cnt > 15) {
                        this.Action(this.waza_syu);
                        this.wait_cnt = 25 - this.tmp_lv * 2;
                        if (this.waza_syu == 2) {
                            var2_22 = CpCanvas.AtaNo(0);
                            CpCanvas.ata[var2_22].Set(59, this.pos_x, this.pos_y, 0, 2);
                            this.def_x = this.pos_x;
                            this.def_y = this.pos_y;
                        }
                        this.tmp_cnt = 0;
                        this.move_cnt = 0;
                    } else {
                        var2_23 = this.PaneRan(0);
                        if (var2_23 < 100) {
                            var3_25 = CpCanvas.AtaNo(0);
                            CpCanvas.ata[var3_25].Set(59, this.pos_x, this.pos_y, 0, 2);
                            this.pos_x = var2_23 % 6;
                            this.pos_y = var2_23 / 6;
                            this.StBom(this.pos_x, this.pos_y);
                            CpCanvas.panel[this.tmp_y][this.tmp_x].NoChara(this.air);
                        }
                        CpCanvas.panel[this.pos_y][this.pos_x].on_chara = 2 + this.ene_id;
                        ++this.tmp_cnt;
                        this.move_cnt = 0;
                        if (this.tmp_cnt > 1 + (CpCanvas.rand.nextInt() >>> 1) % 3) {
                            this.waza_syu = this.pos_y == Rock.pos_y ? 0 : 1 + (CpCanvas.rand.nextInt() >>> 1) % (1 + this.tmp_lv / 2 * 2);
                            this.tmp_cnt = 100;
                        }
                    }
                }
            }
            if (this.waza_flg >= 0) {
                if (this.waza_wait == 0) {
                    var2_24 = CpCanvas.AtaNo(0);
                    CpCanvas.ata[var2_24].Set(this.waza_flg, this.pos_x, this.pos_y, 0, 1);
                    CpCanvas.ata[var2_24].pow = this.pow[4];
                    CpCanvas.ata[var2_24].zoku = this.waza_zoku[4];
                    if (Rock.wana == this.waza_zoku[4]) {
                        CpCanvas.wana_flg = this.waza_zoku[4];
                        Rock.wana = 0;
                    }
                    if ((var3_25 = CpCanvas.ata[var2_24].hit_time) != 0) {
                        CpCanvas.stop_time = var3_25;
                        CpCanvas.eff_id = var2_24;
                        CpCanvas.stop_ch = 1;
                        CpCanvas.stop_name = CpCanvas.waza_str[this.chara_no / 31 + this.waza_syu / 3];
                    }
                    if (this.chara_no == 12 || this.chara_no == 13 || this.chara_no == 15 || this.chara_no == 26 && this.waza_syu == 1 || this.chara_no == 27 && this.waza_syu == 1 || this.chara_no == 33 && this.waza_syu == 2) {
                        this.ata_id = var2_24;
                        CpCanvas.ata[var2_24].hon_id = this.ene_id;
                    }
                    this.waza_flg = -1;
                }
                --this.waza_wait;
            }
            if (this.move_flg > 5) {
                if (this.move_flg == 6) {
                    this.pos_dx -= this.x_sp;
                    if (this.pos_dx <= -20) {
                        this.pos_dx = 20;
                        --this.pos_x;
                    }
                    if (this.pos_dx == 0) {
                        this.move_flg += 5;
                    }
                } else if (this.move_flg == 8) {
                    this.pos_dx += this.x_sp;
                    if (this.pos_dx >= 20) {
                        this.pos_dx = -20;
                        ++this.pos_x;
                    }
                    if (this.pos_dx == 0) {
                        this.move_flg += 5;
                    }
                } else if (this.move_flg == 7) {
                    this.pos_dy -= this.y_sp;
                    if (this.pos_dy <= -12) {
                        this.pos_dy = 12;
                        --this.pos_y;
                    }
                    if (this.pos_dy == 0) {
                        this.move_flg += 5;
                    }
                } else if (this.move_flg == 9) {
                    this.pos_dy += this.y_sp;
                    if (this.pos_dy >= 12) {
                        this.pos_dy = -12;
                        ++this.pos_y;
                    }
                    if (this.pos_dy == 0) {
                        this.move_flg += 5;
                    }
                }
                if (this.move_flg > 10) {
                    if (this.zoku != 2 && CpCanvas.panel[this.pos_y][this.pos_x].jou == 5 && this.air != 0) {
                        this.tmp_x = this.pos_x;
                        this.tmp_y = this.pos_y;
                        this.move_flg = this.move_flg - 10 == 1 && this.Check(-1, 0) == 0 || this.move_flg - 10 == 3 && this.Check(1, 0) == 0 || this.move_flg - 10 == 2 && this.Check(0, -1) == 0 || this.move_flg - 10 == 4 && this.Check(0, 1) == 0 ? 0 : (this.move_flg -= 10);
                    } else {
                        this.move_flg = 0;
                    }
                }
            }
            if (this.move_flg != 0) {
                if (this.move_flg == 1) {
                    this.pos_dx -= this.x_sp;
                    if (this.pos_dx < -20) {
                        --this.pos_x;
                        this.move_flg += 10;
                    }
                } else if (this.move_flg == 3) {
                    this.pos_dx += this.x_sp;
                    if (this.pos_dx > 20) {
                        ++this.pos_x;
                        this.move_flg += 10;
                    }
                } else if (this.move_flg == 2) {
                    this.pos_dy -= this.y_sp;
                    if (this.pos_dy < -12) {
                        --this.pos_y;
                        this.move_flg += 10;
                    }
                } else if (this.move_flg == 4) {
                    this.pos_dy += this.y_sp;
                    if (this.pos_dy > 12) {
                        ++this.pos_y;
                        this.move_flg += 10;
                    }
                }
                if (this.move_flg > 10) {
                    this.pos_dx = 0;
                    this.pos_dy = 0;
                    if (this.zoku != 2 && CpCanvas.panel[this.pos_y][this.pos_x].jou == 5) {
                        this.tmp_x = this.pos_x;
                        this.tmp_y = this.pos_y;
                        if (this.move_flg - 10 == 1 && this.Check(-1, 0) == 0 || this.move_flg - 10 == 3 && this.Check(1, 0) == 0 || this.move_flg - 10 == 2 && this.Check(0, -1) == 0 || this.move_flg - 10 == 4 && this.Check(0, 1) == 0) {
                            this.move_flg = 0;
                        } else {
                            this.move_flg -= 10;
                            this.tmp_x = this.pos_x;
                            this.tmp_y = this.pos_y;
                        }
                    } else {
                        this.move_flg = 0;
                    }
                } else if (this.move_flg < 5) {
                    this.move_flg += 5;
                }
            }
        }
        if (this.ani_wait_cnt <= 0) {
            if (this.wait_cnt == 0) {
                ++this.move_cnt;
            }
            if (this.wait_cnt > 0) {
                --this.wait_cnt;
            }
        } else {
            --this.ani_wait_cnt;
        }
        if (this.bari_id >= 0) {
            CpCanvas.ata[this.bari_id].pos_x = this.pos_x;
            CpCanvas.ata[this.bari_id].pos_y = this.pos_y;
        }
        if (this.mahi_id >= 0) {
            CpCanvas.ata[this.mahi_id].pos_x = this.pos_x;
            CpCanvas.ata[this.mahi_id].pos_y = this.pos_y;
        }
        return 0;
    }

    public int PaneRan(int n) {
        int[] nArray = new int[18];
        int n2 = 0;
        for (int i = 0; i < 18; ++i) {
            boolean bl = false;
            int n3 = CpCanvas.panel[i / 6][i % 6].on_chara - 10;
            if (n3 >= 0 && CpCanvas.oki[n3].on != 0 && CpCanvas.oki[n3].move_ok != 0) {
                bl = true;
            }
            if (CpCanvas.panel[i / 6][i % 6].jin != 1 || CpCanvas.panel[i / 6][i % 6].jou <= 0 || CpCanvas.panel[i / 6][i % 6].on_chara != 0 && !bl) continue;
            bl = true;
            if (n == 1) {
                if (Rock.pos_y == i / 6) {
                    bl = false;
                }
            }
            if (n == 2 && i % 6 != 5) {
                bl = false;
            }
            if (!bl) continue;
            nArray[n2] = i;
            ++n2;
        }
        if (n2 == 0) {
            return 100;
        }
        return nArray[(CpCanvas.rand.nextInt() >>> 1) % n2];
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

    public void PaneCh() {
        this.pane_id = CpCanvas.panel[this.pos_y][this.pos_x].jou;
        if (this.muteki2 != 0) {
            return;
        }
        if (CpCanvas.panel[this.pos_y][this.pos_x].bom_pow > 0) {
            this.Hit(1, CpCanvas.panel[this.pos_y][this.pos_x].bom_pow, 0);
            this.EffSet(4);
            CpCanvas.panel[this.pos_y][this.pos_x].bom_pow = 0;
        }
        if (this.air != 0) {
            return;
        }
        if (this.pane_id == 3) {
            if (this.zoku != 1 && this.Hit(1, 50, 1)) {
                this.EffSet(8);
                CpCanvas.panel[this.pos_y][this.pos_x].Henka(1, 0);
            }
        } else if (this.pane_id == 4) {
            if (this.zoku == 4) {
                this.hp += CpCanvas.game_cnt % 2;
                if (this.hp > this.max_hp) {
                    this.hp = this.max_hp;
                }
            }
        } else if (this.pane_id == 6 && CpCanvas.game_cnt % 2 == 0) {
            int n = this.bari;
            this.bari = 0;
            this.Hit(0, 1, 0);
            this.hit_cnt = 0;
            this.bari = n;
        }
    }

    public int Check(int n, int n2) {
        int n3 = this.pos_x + n;
        int n4 = this.pos_y + n2;
        if (n3 < 0 || n3 > 5 || n4 < 0 || n4 > 2) {
            return 0;
        }
        if (CpCanvas.panel[n4][n3].jin == 0) {
            return 0;
        }
        if (this.air == 0 && CpCanvas.panel[n4][n3].jou <= 0) {
            return 0;
        }
        if (CpCanvas.panel[n4][n3].on_chara != 0 && this.StBom(n3, n4)) {
            return 0;
        }
        CpCanvas.panel[n4][n3].on_chara = 2 + this.ene_id;
        CpCanvas.panel[this.tmp_y][this.tmp_x].NoChara(this.air);
        return 1;
    }

    public void NextChara(int n) {
        int n2;
        for (int i = n2 = (this.ene_id + 1) % 3; i < n2 + 3; ++i) {
            if (CpCanvas.ene[i % 3].chara_no != this.chara_no) continue;
            if (n != 0) break;
            CpCanvas.ene[i % 3].wait_cnt = 10;
            break;
        }
    }

    public boolean Hit(int n, int n2, int n3) {
        if ((this.muteki_cnt > 0 || this.muteki2 != 0) && CpCanvas.stop_cnt == 0) {
            return false;
        }
        if (Rock.hp == 0) {
            return false;
        }
        if (this.zoku != 0 && this.zoku % 4 + 1 == n3) {
            n2 *= 2;
            this.EffSet(39);
        }
        if (this.pane_id == 7) {
            n2 = (n2 + 1) / 2;
        }
        if (this.bari > 0) {
            this.bari -= n2;
            if (this.bari <= 0) {
                this.bari = 0;
                if (this.chara_no == 12) {
                    this.def_ani = 5;
                    this.joutai = 0;
                    this.AniSet(7);
                    return true;
                }
                CpCanvas.ata[this.bari_id].init();
                this.bari_id = -1;
            }
            return true;
        }
        this.hp -= n2;
        if (this.hp <= 0) {
            this.Syoumetu();
        }
        int n4 = this.ani_wait_cnt;
        if (n == 1) {
            this.muteki_cnt = 30;
        }
        if (this.chara_no != 12 && this.chara_no != 13 && this.chara_no != 15 && this.chara_no != 32) {
            if (n > 0) {
                this.ani_wait_cnt = 15;
            }
            if (n == 3) {
                this.ani_wait_cnt = 25;
                if (this.mahi_id < 0) {
                    this.mahi_id = CpCanvas.AtaNo(0);
                }
                CpCanvas.ata[this.mahi_id].Set(88, this.pos_x, this.pos_y, 0, 3);
                CpCanvas.ata[this.mahi_id].pos_dx = 0;
                CpCanvas.ata[this.mahi_id].pos_dy = 0;
            }
        }
        if (this.chara_no == 12) {
            this.muteki_cnt = 0;
        }
        if (n2 > 0 && CpCanvas.stop_cnt == 0) {
            this.hit_cnt = 1;
        }
        if (CpCanvas.stop_cnt != 0) {
            this.tmp_muteki_cnt = this.muteki_cnt;
            this.muteki_cnt = 0;
        }
        if (this.chara_no == 32) {
            this.ani_wait_cnt = n4;
            n = 0;
        }
        if (this.navi_flg != 0 && n > 0 && (this.ata_id < 0 || CpCanvas.stop_cnt == 0)) {
            if (this.ata_id >= 0) {
                CpCanvas.ata[this.ata_id].init();
            }
            this.move_flg = 0;
            this.waza_flg = -1;
            this.joutai = 0;
            this.AniSet(2);
            this.tmp_wait_cnt = this.ani_wait_cnt;
        }
        return true;
    }

    public void Syoumetu() {
        int n;
        this.joutai = 0;
        if (this.chara_no == 12) {
            this.AniSet(6);
        }
        if (this.chara_no == 13 || this.chara_no == 15) {
            this.AniSet(0);
        }
        if (this.navi_flg != 0) {
            this.joutai = 0;
            this.AniSet(2);
        }
        this.hp = 0;
        if (this.ata_id >= 0) {
            CpCanvas.ata[this.ata_id].hon_id = -1;
            CpCanvas.ata[this.ata_id].init();
        }
        if (CpCanvas.combo_cnt != 0) {
            ++CpCanvas.combo;
        }
        CpCanvas.combo_cnt = 3;
        if (--CpCanvas.ene_cnt == 0) {
            CpCanvas.dell_cnt = 20;
            for (n = 0; n < 30; ++n) {
                if (CpCanvas.ata[n].chara_flg != 1) continue;
                CpCanvas.ata[n].on = 0;
            }
            CpCanvas.ata_cnt = 0;
        }
        this.syoumetu_cnt = 15;
        this.muteki_cnt = 15;
        this.ani_wait_cnt = 15;
        for (n = 0; n < 18; ++n) {
            if (CpCanvas.panel[n / 6][n % 6].on_chara != this.ene_id + 2) continue;
            CpCanvas.panel[n / 6][n % 6].NoChara(this.air);
        }
        if (this.wait_cnt >= 0) {
            this.NextChara(this.chara_no);
        }
        if (this.chara_no > 30) {
            CpCanvas.combo = 0;
            if (CpCanvas.ene[1].on != 0) {
                CpCanvas.ene[1].Syoumetu();
            }
            CpCanvas.combo = 0;
            if (CpCanvas.ene[2].on != 0) {
                CpCanvas.ene[2].Syoumetu();
            }
        }
    }

    public void Off() {
        if (this.wait_cnt >= 0) {
            this.NextChara(this.chara_no);
        }
        this.move_cnt = 0;
        this.move_flg = 0;
        this.wait_cnt = 0;
        this.pos_x = 0;
        this.pos_y = 0;
        this.on = 0;
        this.chara_no = -1;
        this.chara_id = 0;
        if (this.mahi_id >= 0) {
            CpCanvas.ata[this.mahi_id].init();
        }
        this.mahi_id = -1;
        System.gc();
    }

    public void EffSet(int n) {
        int n2 = CpCanvas.AtaNo(0);
        CpCanvas.ata[n2].Set(n, this.pos_x, this.pos_y, 0, 3);
    }

    public void Action(int n) {
        this.waza_id[4] = this.waza_id[n] + 188;
        this.pow[4] = this.pow[n];
        this.waza_zoku[4] = this.waza_zoku[n];
        this.AniSet(CpCanvas.waza[this.waza_id[4]].move_id);
        this.waza_wait = CpCanvas.waza[this.waza_id[4]].wait_cnt;
        this.waza_flg = this.waza_id[4];
    }

    public int Get(int n, int n2) {
        if (n == 0) {
            if (this.navi_flg != 0) {
                if (CpCanvas.ghost >= 0) {
                    int n3 = CpCanvas.ghost;
                    CpCanvas.navi_flg[n3] = CpCanvas.navi_flg[n3] + 1;
                    if (CpCanvas.navi_flg[CpCanvas.ghost] > 3) {
                        CpCanvas.navi_flg[CpCanvas.ghost] = 3;
                    }
                }
                CpCanvas.ghost = -1;
                if (CpCanvas.teki_pt < 296 && CpCanvas.teki_pt != 293) {
                    return 0;
                }
                if (this.tmp_lv < 3) {
                    return this.drop_tip[0];
                }
                if (n2 > 10) {
                    return this.drop_tip[0];
                }
                if (n2 > 9) {
                    return this.drop_tip[1];
                }
                if (n2 > 7) {
                    return this.drop_tip[2];
                }
                if (n2 > 5) {
                    return this.drop_tip[3];
                }
            } else {
                int n4 = 0;
                if (n2 > 5) {
                    n4 = this.drop_tip[3];
                }
                if (n2 > 7) {
                    n4 = this.drop_tip[2];
                }
                if (n2 > 9) {
                    n4 = this.drop_tip[1];
                }
                if (n2 > 10) {
                    n4 = this.drop_tip[0];
                }
                if ((CpCanvas.rand.nextInt() >>> 1) % 100 < 45 + n2 * 5 || CpCanvas.skill_kouka[11] != 0) {
                    return n4;
                }
            }
            return 0;
        }
        if (n == 1) {
            if (CpCanvas.skill_kouka[12] != 0) {
                this.zenny *= 2;
            }
            return this.zenny;
        }
        if (n == 2) {
            int n5 = (CpCanvas.rand.nextInt() >>> 1) % 80;
            if ((n5 += this.hp / 10) > 70) {
                return 1;
            }
        }
        return 0;
    }

    public void Loop() {
        this.ani_ok = 1;
        if (--this.s_wait < 0) {
            this.s_wait = 0;
            if (this.r_suu != 0) {
                if (this.ani_cnt == this.r_e + 1) {
                    this.ani_cnt = this.r_s;
                    if (--this.r_suu < 0) {
                        this.r_suu = 0;
                    }
                }
            } else if (CpCanvas.ani[this.ani_id][this.ani_pt[0]][this.ani_cnt + 1] == -2) {
                if (this.e_wait < 0) {
                    this.ani_ok = 0;
                } else if (--this.e_wait < 0) {
                    this.e_wait = 0;
                } else {
                    this.ani_ok = 0;
                }
            }
        } else {
            this.ani_ok = 0;
        }
    }

    public void HpDraw() {
        if (this.hp <= 0) {
            return;
        }
        if (this.muteki2 != 0) {
            return;
        }
        int n = this.pos_x * 40 + this.pos_dx;
        int n2 = this.pos_y * 24 + 24 - 10 + 105 + this.pos_dy;
        CpCanvas.ImgSuu(this.hp, n, n2, 40, 2, 0);
    }

    public void Draw(int n) {
        int n2 = (this.muteki_cnt % 2 << 4) + (this.hit_cnt << 4);
        this.tmp_s_wait = this.s_wait;
        this.tmp_r_suu = this.r_suu;
        this.tmp_e_wait = this.e_wait;
        if (n != 0) {
            this.Loop();
        }
        for (int i = 0; i < this.ani_max; ++i) {
            if (-2 != CpCanvas.Ani(this.ani_id, this.ani_pt[i], this.ani_cnt, this.pos_x, this.pos_y + n2, this.pos_dx + this.tmp_wait_cnt % 3, this.pos_dy, 0)) continue;
            if (this.ani_pt[0] != 0) {
                this.AniSet(this.def_ani);
            } else {
                this.ani_cnt = 0;
            }
            CpCanvas.Ani(this.ani_id, this.ani_pt[i], this.ani_cnt, this.pos_x, this.pos_y + n2, this.pos_dx + this.tmp_wait_cnt % 3, this.pos_dy, 0);
        }
        this.t_ani_cnt = this.ani_cnt;
        if (this.tmp_wait_cnt == 0 && this.ani_ok != 0) {
            this.ani_cnt += n;
        }
        this.tmp_wait_cnt = this.ani_wait_cnt;
    }
}

