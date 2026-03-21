#include "../platform/Platform.h"
#include "../platform/Audio.h"
#include "../platform/Input.h"
#include "../platform/Resources.h"
#include "../platform/Graphics.h"
#include "../platform/Image.h"
#include "../platform/Font.h"
#include "CpCanvas_fwd.h"

// ── Window procedure ──────────────────────────────────────────────────────
static LRESULT CALLBACK WndProc(HWND hwnd, UINT msg, WPARAM wParam, LPARAM lParam) {
    switch (msg) {
    case WM_PAINT: {
        PAINTSTRUCT ps;
        HDC hdc = BeginPaint(hwnd, &ps);
        Graphics::onPaint(hwnd, hdc);
        EndPaint(hwnd, &ps);
        return 0;
    }
    case WM_CLOSE:
        PostQuitMessage(0);
        return 0;
    default:
        return DefWindowProc(hwnd, msg, wParam, lParam);
    }
}

// ── WinMain ────────────────────────────────────────────────────────────────
int WINAPI WinMain(HINSTANCE hInst, HINSTANCE, LPSTR, int) {
    // 1. GDI+ initialisation
    Gdiplus::GdiplusStartupInput gdiplusInput;
    ULONG_PTR gdiplusToken = 0;
    Gdiplus::GdiplusStartup(&gdiplusToken, &gdiplusInput, nullptr);

    // 2. COM initialisation (required by XAudio2)
    CoInitializeEx(nullptr, COINIT_MULTITHREADED);

    // 3. Register window class
    WNDCLASSEX wc     = {};
    wc.cbSize         = sizeof(wc);
    wc.style          = CS_HREDRAW | CS_VREDRAW;
    wc.lpfnWndProc    = WndProc;
    wc.hInstance      = hInst;
    wc.hCursor        = LoadCursor(nullptr, IDC_ARROW);
    wc.hbrBackground  = (HBRUSH)GetStockObject(BLACK_BRUSH);
    wc.lpszClassName  = L"PoNPCPort";
    RegisterClassEx(&wc);

    // 4. Calculate window size to fit the 720×720 client area
    RECT rc = { 0, 0, SCREEN_W * WINDOW_SCALE, SCREEN_H * WINDOW_SCALE };
    AdjustWindowRect(&rc, WS_CAPTION | WS_SYSMENU | WS_MINIMIZEBOX, FALSE);

    HWND hwnd = CreateWindowEx(
        0,
        L"PoNPCPort",
        L"PoNPCPort",
        WS_CAPTION | WS_SYSMENU | WS_MINIMIZEBOX,
        CW_USEDEFAULT, CW_USEDEFAULT,
        rc.right - rc.left, rc.bottom - rc.top,
        nullptr, nullptr, hInst, nullptr);

    if (!hwnd) {
        CoUninitialize();
        Gdiplus::GdiplusShutdown(gdiplusToken);
        return 1;
    }

    ShowWindow(hwnd, SW_SHOW);
    UpdateWindow(hwnd);

    // 5. Audio + Input subsystems
    Audio::init();
    Input::init();

    // 6. Resource layer – data/ subdirectories created by tools/extract_assets.py
    if (!Resources::init("data")) {
        MessageBoxW(hwnd,
            L"data\\ directory not found.\n"
            L"Run tools\\extract_assets.py first to unpack PoN.sp and PoN.jar.",
            L"PoNPCPort", MB_OK | MB_ICONERROR);
        Input::quit();
        Audio::quit();
        DestroyWindow(hwnd);
        CoUninitialize();
        Gdiplus::GdiplusShutdown(gdiplusToken);
        return 1;
    }

    // 7. Graphics object wrapping the window
    Graphics* gfx = new Graphics(hwnd);

    // 8. Set the global graphics pointer used by all game classes
    CpCanvas::g = gfx;

    // 9. Create CpCanvas (constructor initialises BtPanel array etc.)
    CpCanvas* cpCanvas = new CpCanvas();

    // 10. Enter the game loop (returns when WM_QUIT is received)
    cpCanvas->exe();

    // 11. Cleanup
    delete cpCanvas;
    delete gfx;

    Input::quit();
    Audio::quit();
    Resources::quit();
    CoUninitialize();
    Gdiplus::GdiplusShutdown(gdiplusToken);

    return 0;
}
