/*
 * Decompiled with CFR 0.152.
 */
package app;

import java.io.InputStream;

class Mail {
    public int mail_id;
    public int face;
    public int from;
    public int to;
    public int subject;
    public int ivent;
    public String str_f;
    public String str_t;
    public String str_s;
    public static String[] str_name = new String[]{"\u30c7\u30f3\u30b5\u30f3\u30cb\u30e5\u30fc\u30b9", "\u30c7\u30ab\u30aa", "\u30e1\u30a4\u30eb", "\u65e5\u66ae", "\u30d1\u30d1", "\u30c9\u30fc\u30e0\u5927\u4f1a\u4e8b\u52d9\u5c40", "\u4fee\u4e00", "\u79d1\u5b66\u7701"};
    public static String[] net_name = new String[]{"\u79cb\u539f\uff2d\uff2c", "\u71b1\u6597", "\u71b1\u6597\u304f\u3093", "\u5149\u3000\u71b1\u6597\u9078\u624b", "\u5149\u3000\u71b1\u6597\u3055\u307e"};

    Mail(int n, InputStream inputStream, InputStream inputStream2) {
        this.mail_id = n;
        try {
            this.face = inputStream.read();
            this.from = inputStream.read();
            this.to = inputStream.read();
            this.subject = inputStream.read();
            this.str_f = str_name[this.from];
            this.str_t = net_name[this.to];
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            int n2;
            byte[] byArray = new byte[30];
            inputStream2.read(byArray);
            for (n2 = 0; n2 < 30 && byArray[n2] != 0; ++n2) {
            }
            byte[] byArray2 = new byte[n2];
            for (int i = 0; i < n2; ++i) {
                byArray2[i] = byArray[i];
            }
            this.str_s = new String(byArray2);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

