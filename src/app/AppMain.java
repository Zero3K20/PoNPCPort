/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.nttdocomo.ui.Display
 *  com.nttdocomo.ui.Frame
 *  com.nttdocomo.ui.IApplication
 *  com.nttdocomo.ui.PhoneSystem
 */
package app;

import app.CpCanvas;
import com.nttdocomo.ui.Display;
import com.nttdocomo.ui.Frame;
import com.nttdocomo.ui.IApplication;
import com.nttdocomo.ui.PhoneSystem;

public class AppMain
extends IApplication {
    public void start() {
        PhoneSystem.setAttribute((int)0, (int)1);
        CpCanvas cpCanvas = new CpCanvas();
        Display.setCurrent((Frame)cpCanvas);
        cpCanvas.exe();
    }

    public void resume() {
        CpCanvas.play_flg = 1;
        PhoneSystem.setAttribute((int)0, (int)1);
    }
}

