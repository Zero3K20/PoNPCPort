/*
 * main.cpp - WinMain entry point for P.o.N. PC Port
 * Requires Windows XP / Server 2003 or later.
 * No external dependencies (uses only Win32 API + WinMM).
 */
#include "src/app/AppMain.h"

int WINAPI WinMain(HINSTANCE hInst, HINSTANCE, LPSTR, int nCmdShow)
{
    if (!Platform_Init(hInst, nCmdShow)) {
        MessageBoxW(nullptr, L"Failed to initialize platform.", L"Error", MB_ICONERROR);
        return 1;
    }

    AppMain app;
    app.start();  /* enters game loop; returns when window is closed */

    Platform_Shutdown();
    return 0;
}
