/*
 * Decompiled with CFR 0.152.
 */
package app;

import java.io.InputStream;

class Waza {
    public static final int KOU_SUU = 227;
    public int waza_id;
    public int move_id;
    public int eff_id;
    public int hit_id;
    public int wait_cnt;
    public int yokoku;
    public int noke_pt;
    public int kan;
    public int ana;
    public int bure;
    public int waza_kou;
    public int stop_time;
    static int[] data = new int[681];

    Waza(int n, InputStream inputStream) {
        byte[] byArray = new byte[4];
        this.waza_id = n;
        try {
            inputStream.read(byArray);
            this.move_id = byArray[3] & 0xFF;
            this.eff_id = byArray[2] & 0xFF;
            this.hit_id = byArray[1] & 0xFF;
            this.wait_cnt = byArray[0] & 0x3F;
            this.yokoku = (byArray[0] & 0xFF) >> 6;
            inputStream.read(byArray);
            this.noke_pt = byArray[3] >> 3 & 3;
            this.kan = byArray[3] >> 2 & 1;
            this.ana = byArray[3] >> 1 & 1;
            this.bure = byArray[3] >> 0 & 1;
            this.waza_kou = byArray[2] & 0xFF;
            this.stop_time = byArray[1] & 0xFF;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void Set(InputStream inputStream) {
        try {
            byte[] byArray = new byte[12];
            for (int i = 0; i < 227; ++i) {
                inputStream.read(byArray);
                Waza.data[i * 3 + 0] = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                Waza.data[i * 3 + 1] = (byArray[4] & 0xFF) << 24 | (byArray[5] & 0xFF) << 16 | (byArray[6] & 0xFF) << 8 | byArray[7] & 0xFF;
                Waza.data[i * 3 + 2] = (byArray[8] & 0xFF) << 24 | (byArray[9] & 0xFF) << 16 | (byArray[10] & 0xFF) << 8 | byArray[11] & 0xFF;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

