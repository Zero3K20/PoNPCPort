/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.nttdocomo.ui.Graphics
 *  com.nttdocomo.ui.Image
 */
package app;

import app.CpCanvas;
import com.nttdocomo.ui.Graphics;
import com.nttdocomo.ui.Image;
import java.io.InputStream;

class Tip {
    public int tip_id;
    public int syu;
    public int aiu;
    public int pow;
    public int zoku;
    public int rea;
    public int setu_id;
    public int regu_you;
    public int waza_id;
    public String name;

    public void init(int n, InputStream inputStream, InputStream inputStream2) {
        byte[] byArray;
        this.tip_id = n;
        try {
            byArray = new byte[4];
            inputStream.read(byArray);
            this.syu = byArray[0] & 0xFF;
            this.aiu = byArray[1] & 0xFF;
            this.pow = (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
            inputStream.read(byArray);
            this.zoku = (byArray[0] & 0xF0) >> 4;
            this.rea = byArray[0] & 0xF;
            this.setu_id = byArray[1] & 0xFF;
            this.regu_you = byArray[2] & 0xFF;
            this.waza_id = byArray[3] & 0xFF;
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

    public void DrawSetu() {
        CpCanvas.MesDraw(2);
    }

    public void DrawRea(int n, int n2) {
        CpCanvas.drawImg3(44, 70 + this.rea, n, n2, false);
    }

    public void DrawRegu(int n, int n2) {
        CpCanvas.ImgSuu(this.regu_you, n, n2, 16, 1, 2);
        CpCanvas.drawImg3(44, 17, n + 3, n2 + 7, false);
    }

    public void DrawPow(int n, int n2) {
        if (this.pow > 0 && this.syu < 4 && this.tip_id != 131) {
            CpCanvas.ImgSuu(this.pow, n, n2, 24, 1, 1);
        }
    }

    public void DrawPow2(int n, int n2) {
        if (this.pow > 0 && this.tip_id != 131) {
            CpCanvas.ImgSuu(this.pow, n, n2, 24, 1, 0);
        }
    }

    public void DrawCode(int n, int n2, int n3, int n4) {
        String string = "*";
        if (n != 100) {
            byte[] byArray = new byte[]{(byte)(n + 64)};
            string = new String(byArray);
        }
        CpCanvas.strDraw(string, n2, n3);
    }

    public void DrawZoku(int n, int n2) {
        CpCanvas.drawImg3(44, 25 + this.zoku, n, n2, false);
    }

    public void DrawName(int n, int n2) {
        CpCanvas.strDraw(this.name, n, n2);
    }

    public void Draw(int n, int n2, int n3, boolean bl) {
        int n4 = this.tip_id % 15 * 16 + n3;
        int n5 = this.tip_id / 15 * 16 + n3;
        if (bl) {
            if (this.tip_id < 125) {
                CpCanvas.g.setColor(Graphics.getColorOfRGB((int)232, (int)216, (int)128));
            } else if (this.tip_id < 177) {
                CpCanvas.g.setColor(Graphics.getColorOfRGB((int)184, (int)220, (int)222));
            } else {
                CpCanvas.g.setColor(Graphics.getColorOfRGB((int)206, (int)145, (int)172));
            }
        } else {
            CpCanvas.g.setColor(Graphics.getColorOfRGB((int)184, (int)184, (int)176));
        }
        CpCanvas.g.fillRect(n, n2, 16 - n3 * 2, 16 - n3 * 2);
        CpCanvas.g.drawImage((Image)CpCanvas.image[56], n, n2, n4, n5, 16 - n3 * 2, 16 - n3 * 2);
    }
}

