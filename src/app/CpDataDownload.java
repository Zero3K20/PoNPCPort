/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.nttdocomo.io.HttpConnection
 *  com.nttdocomo.net.URLEncoder
 *  javax.microedition.io.Connector
 */
package app;

import com.nttdocomo.io.HttpConnection;
import com.nttdocomo.net.URLEncoder;
import java.io.InputStream;
import javax.microedition.io.Connector;

class CpDataDownload {
    private static final String php = "http://game.capcom.jp/i/sreg/dataget.php";

    CpDataDownload() {
    }

    public static int getDataEx(String string, int n, int n2, boolean bl, byte[] byArray) {
        String string2 = "offset=" + n;
        String string3 = "length=" + n2;
        String string4 = "checkmodel=" + new Boolean(bl).toString();
        int n3 = 0;
        HttpConnection httpConnection = null;
        InputStream inputStream = null;
        string = URLEncoder.encode((String)string);
        try {
            httpConnection = (HttpConnection)Connector.open((String)("http://game.capcom.jp/i/sreg/dataget.php?path=" + string + "&" + string2 + "&" + string3 + "&" + string4), (int)1);
            httpConnection.setRequestMethod("GET");
            httpConnection.connect();
            inputStream = httpConnection.openInputStream();
            n3 = inputStream.read(byArray);
            inputStream.close();
            httpConnection.close();
        }
        catch (Exception exception) {
            System.out.println("e:" + exception);
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpConnection != null) {
                    httpConnection.close();
                }
            }
            catch (Exception exception2) {
                // empty catch block
            }
        }
        if (n3 < 2) {
            n3 = -1;
        }
        return n3;
    }
}

