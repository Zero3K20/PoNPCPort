#include "../platform/Platform.h"
#include "../platform/Audio.h"
#include "../platform/Input.h"
#include "../platform/Resources.h"
#include "../platform/Graphics.h"
#include "../platform/Image.h"
#include "../platform/Font.h"
#include "CpCanvas_fwd.h"
#include <cstdio>

// CpCanvas is declared in CpCanvas_fwd.h; full definition in CpCanvas.cpp
// We need exe() accessible here - include the full class via fwd header
// and use extern declaration for the constructor/exe.
// The exe() method is defined in CpCanvas.cpp and declared in CpCanvas_fwd.h.

// Forward-declare the exe and constructor so we can call them.
// CpCanvas_fwd.h already declares the class; CpCanvas.cpp provides the body.

// Extend the CpCanvas declaration with the methods we need here.
// These are implemented in CpCanvas.cpp.
extern void CpCanvas_exe_impl();  // helper forwarding call

int main(int argc, char* argv[]) {
    // 1. SDL initialisation
    if (SDL_Init(SDL_INIT_VIDEO | SDL_INIT_AUDIO | SDL_INIT_GAMECONTROLLER) != 0) {
        SDL_Log("SDL_Init failed: %s", SDL_GetError());
        return 1;
    }

    // 2. Window + renderer (720×720, i.e. 240×3 logical scale)
    SDL_Window* window = SDL_CreateWindow(
        "PoNPCPort",
        SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED,
        SCREEN_W * WINDOW_SCALE, SCREEN_H * WINDOW_SCALE,
        SDL_WINDOW_SHOWN
    );
    if (!window) {
        SDL_Log("SDL_CreateWindow failed: %s", SDL_GetError());
        SDL_Quit();
        return 1;
    }

    SDL_Renderer* renderer = SDL_CreateRenderer(window, -1,
        SDL_RENDERER_ACCELERATED | SDL_RENDERER_PRESENTVSYNC);
    if (!renderer) {
        SDL_Log("SDL_CreateRenderer failed: %s", SDL_GetError());
        SDL_DestroyWindow(window);
        SDL_Quit();
        return 1;
    }

    // Scale logical 240×240 up to 720×720
    SDL_RenderSetLogicalSize(renderer, SCREEN_W, SCREEN_H);

    // 3. SDL_ttf and SDL_image
    if (TTF_Init() != 0) {
        SDL_Log("TTF_Init failed: %s", TTF_GetError());
    }
    if (IMG_Init(IMG_INIT_PNG | IMG_INIT_JPG) == 0) {
        SDL_Log("IMG_Init failed: %s", IMG_GetError());
    }

    // 4. Audio + Input subsystems
    Audio::init();
    Input::init();

    // 5. Resource layer
    if (!Resources::init("PoN.sp", "PoN.jar")) {
        SDL_Log("Resources::init failed – PoN.sp or PoN.jar missing");
        Input::quit();
        Audio::quit();
        IMG_Quit();
        TTF_Quit();
        SDL_DestroyRenderer(renderer);
        SDL_DestroyWindow(window);
        SDL_Quit();
        return 1;
    }

    // 6. Graphics object wrapping the renderer
    Graphics* gfx = new Graphics(renderer);

    // 7. Set the global graphics pointer used by all game classes
    CpCanvas::g = gfx;

    // 8. Create CpCanvas (constructor initialises BtPanel array etc.)
    CpCanvas* cpCanvas = new CpCanvas();

    // 9. Enter the game loop (returns when SDL_QUIT received)
    cpCanvas->exe();

    // 10. Cleanup
    delete cpCanvas;
    delete gfx;

    Input::quit();
    Audio::quit();
    Resources::quit();
    IMG_Quit();
    TTF_Quit();
    SDL_DestroyRenderer(renderer);
    SDL_DestroyWindow(window);
    SDL_Quit();

    return 0;
}
