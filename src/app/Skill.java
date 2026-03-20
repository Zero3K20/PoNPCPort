/*
 * Decompiled with CFR 0.152.
 */
package app;

import java.io.InputStream;

class Skill {
    public static int ski_id;
    public int you;
    public int param;
    public String name;

    Skill(int n, InputStream inputStream, InputStream inputStream2) {
        byte[] byArray;
        ski_id = n;
        try {
            byArray = new byte[4];
            inputStream.read(byArray);
            this.you = byArray[3] & 0xFF;
            this.param = (byArray[0] & 0xFF) << 8 | byArray[1] & 0xFF;
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            int n2;
            byArray = new byte[16];
            inputStream2.read(byArray);
            for (n2 = 0; n2 < 16 && byArray[n2] != 0; ++n2) {
            }
            byte[] byArray2 = new byte[n2];
            for (int i = 0; i < n2; ++i) {
                byArray2[i] = byArray[i];
            }
            this.name = new String(byArray2);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

