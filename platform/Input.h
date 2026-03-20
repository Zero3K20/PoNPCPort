#pragma once
#include "Platform.h"

// Keyboard + gamepad input layer.
// Translates SDL events to the DoJa key bitmasks used by CpCanvas::key.
//
// Gamepad mapping:
//   D-pad / left stick up/down/left/right → KEY_UP/DOWN/LEFT/RIGHT
//   A (Xbox) / Cross (PS)                 → KEY_FIRE   (confirm / attack)
//   B (Xbox) / Circle (PS)                → KEY_SOFT2  (cancel / back)
//   X (Xbox) / Square (PS)                → KEY_SOFT1  (left soft key)
//   Y (Xbox) / Triangle (PS)              → KEY_SOFT1  (alt left soft key)
//   Start                                  → KEY_SELECT
//   Back / Select                          → KEY_MENU
//   Right shoulder (RB / R1)              → KEY_SOFT3
//   Left  shoulder (LB / L1)              → KEY_SOFT4
//
// Keyboard mapping:
//   Arrow / WASD     → directional
//   Z / Enter / Space → KEY_FIRE
//   X / Backspace / Esc → KEY_SOFT2
//   Q / F            → KEY_SOFT1
//   E                → KEY_SOFT3
//   R                → KEY_SOFT4
//   Return2          → KEY_SELECT
//   M                → KEY_MENU
namespace Input {
    void init();
    void quit();

    // Poll SDL events; returns false when SDL_QUIT is received.
    bool pollEvents();

    // Pending single-press bitmask for this frame (consumed by game code).
    int  getKey();

    // Clear the pending press.
    void clearKey();

    // Currently-held bitmask (all buttons held right now).
    int  getHeld();
}
