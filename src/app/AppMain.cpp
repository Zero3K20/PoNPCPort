#include "AppMain.h"

void AppMain::start()
{
    CpCanvas canvas;
    canvas.exe();
}

void AppMain::resume()
{
    CpCanvas::play_flg = 1;
}
