/*
 * Decompiled with CFR 0.152.
 */
package app;

import app.CpCanvas;

class Edit {
    public static int[] set = new int[12];
    public static int[] set2 = new int[12];
    public static int[] flg = new int[12];
    public static int[] zoku = new int[5];
    public static int r_zoku;
    public static int set_cnt;
    public static int now_slot;
    public static int max_slot;

    Edit() {
    }

    public int Set(int n) {
        int n2;
        int n3 = CpCanvas.skill[CpCanvas.skill_list[n] & 0xFF].you;
        if (n3 + now_slot > max_slot) {
            return -1;
        }
        int n4 = CpCanvas.skill_list[n] >> 8 & 0xFF;
        zoku[n4] = zoku[n4] + n3;
        int n5 = 0;
        for (n2 = 0; n2 < 12; ++n2) {
            if (flg[n2] != 0) continue;
            Edit.flg[n2] = 1;
            n5 = n2;
            break;
        }
        for (n2 = 0; n2 < n3; ++n2) {
            Edit.set[Edit.now_slot + n2] = n + (n5 + 1 << 8);
        }
        Edit.set2[Edit.set_cnt] = n;
        ++set_cnt;
        now_slot += n3;
        int n6 = n;
        CpCanvas.skill_list[n6] = CpCanvas.skill_list[n6] - 65536;
        if ((CpCanvas.skill_list[n] >> 16 & 0xFF) == 0) {
            CpCanvas.SortSkill(1);
        }
        r_zoku = this.ZokuCh();
        return r_zoku;
    }

    public void Dell(int n) {
        int n2;
        int n3 = set[n];
        if (n3 <= 0) {
            return;
        }
        Edit.flg[(Edit.set[n] >> 8) - 1] = 0;
        boolean bl = false;
        int n4 = -1;
        int n5 = 0;
        for (n2 = 0; n2 < 12 && set[n2] != n3; ++n2) {
            if (set[n2] == n4) continue;
            n4 = set[n2];
            ++n5;
        }
        Edit.set2[n5] = -1;
        n5 = 0;
        for (n2 = 0; n2 < 12; ++n2) {
            if (n3 != set[n2]) continue;
            Edit.set[n2] = 0;
            ++n5;
        }
        --set_cnt;
        now_slot -= n5;
        int n6 = CpCanvas.skill_list[n3 & 0xFF] >> 8 & 0xFF;
        zoku[n6] = zoku[n6] - n5;
        n5 = 0;
        for (n2 = 0; n2 < 12; ++n2) {
            if (set[n2] == 0) continue;
            Edit.set[n5] = set[n2];
            ++n5;
        }
        for (n2 = n5; n2 < 12; ++n2) {
            Edit.set[n2] = -1;
        }
        n5 = 0;
        for (n2 = 0; n2 < 12; ++n2) {
            if (set2[n2] < 0) continue;
            Edit.set2[n5] = set2[n2];
            ++n5;
        }
        for (n2 = n5; n2 < 12; ++n2) {
            Edit.set2[n2] = -1;
        }
        int n7 = n3 & 0xFF;
        CpCanvas.skill_list[n7] = CpCanvas.skill_list[n7] + 65536;
        if ((CpCanvas.skill_list[n3 & 0xFF] >> 16 & 0xFF) == 1) {
            CpCanvas.SortSkill(1);
        }
        r_zoku = this.ZokuCh();
    }

    public int ZokuCh() {
        int n;
        int n2 = 1;
        int n3 = 0;
        int[] nArray = new int[5];
        for (n = 2; n < 5; ++n) {
            if (zoku[n] <= zoku[n2]) continue;
            n2 = n;
        }
        for (n = 1; n < 5; ++n) {
            if (zoku[n] != zoku[n2]) continue;
            nArray[n] = 1;
            ++n3;
        }
        if (n3 == 1) {
            return n2;
        }
        if (n3 == 4) {
            return 0;
        }
        if (n3 == 3) {
            for (n = 1; n < 5; ++n) {
                if (nArray[n] != 0) continue;
                n2 = n - 1;
                if (n2 == 0) {
                    n2 = 4;
                }
                return n2;
            }
        }
        n2 = 0;
        if (n3 == 2) {
            for (n = 1; n < 5; ++n) {
                if (nArray[n] == 0) continue;
                if (n2 == 0) {
                    n2 = n;
                    continue;
                }
                if (n2 + 2 == n) {
                    return 0;
                }
                if (n2 + 1 == n) {
                    return n;
                }
                return n2;
            }
        }
        return 0;
    }

    public void Draw() {
        for (int i = 0; i < now_slot; ++i) {
            int n = CpCanvas.skill_list[set[i] & 0xFF] & 0xFF;
            int n2 = CpCanvas.skill_list[set[i] & 0xFF] >> 8 & 0xFF;
            CpCanvas.drawImg3(51 + n2, n, 16 + i % 3 * 19, 52 + i / 3 * 20, false);
        }
    }

    public void Slect(int n) {
        if (set[n] <= 0) {
            return;
        }
        for (int i = 0; i < 12; ++i) {
            if (set[n] != set[i]) continue;
            CpCanvas.g.fillRect(14 + i % 3 * 19, 50 + i / 3 * 20, 18, 18);
        }
    }
}

