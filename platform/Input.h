#pragma once
#include "Platform.h"

// Win32 keyboard + gamepad input layer.
// Translates WM_KEYDOWN/WM_KEYUP messages (pumped via PeekMessage in
// pollEvents()) to the DoJa key bitmasks used by CpCanvas::key.
//
// Keyboard mapping:
//   Arrow / WASD           → directional
//   Z / Enter / Space      → KEY_FIRE   (confirm / attack)
//   X / Backspace / Escape → KEY_SOFT2  (cancel / back)
//   Q / F                  → KEY_SOFT1  (left soft key)
//   E                      → KEY_SOFT3
//   R                      → KEY_SOFT4
//   Numpad Enter           → KEY_SELECT
//   M                      → KEY_MENU
namespace Input {
    void init();
    void quit();

    // Pump Win32 messages; returns false when WM_QUIT is received.
    bool pollEvents();

    // Pending single-press bitmask for this frame (consumed by game code).
    int  getKey();

    // Clear the pending press.
    void clearKey();

    // Currently-held bitmask (all buttons held right now).
    int  getHeld();
}
