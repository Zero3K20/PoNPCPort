#include "Input.h"

namespace Input {

static int s_key  = 0;
static int s_held = 0;

static int vkToKey(WPARAM vk) {
    switch (vk) {
        case VK_UP:     return KEY_UP;
        case VK_DOWN:   return KEY_DOWN;
        case VK_LEFT:   return KEY_LEFT;
        case VK_RIGHT:  return KEY_RIGHT;
        case 'W':       return KEY_UP;
        case 'S':       return KEY_DOWN;
        case 'A':       return KEY_LEFT;
        case 'D':       return KEY_RIGHT;
        case 'Z':
        case VK_RETURN:
        case VK_SPACE:  return KEY_FIRE;
        case 'X':
        case VK_BACK:
        case VK_ESCAPE: return KEY_SOFT2;
        case 'Q':
        case 'F':       return KEY_SOFT1;
        case 'E':       return KEY_SOFT3;
        case 'R':       return KEY_SOFT4;
        case VK_NUMPAD5:
        case VK_CLEAR:  return KEY_SELECT;   // numpad centre key → Select
        case 'M':       return KEY_MENU;
        default:        return 0;
    }
}

void init()  {}
void quit()  {}

bool pollEvents() {
    s_key = 0;   // clear per-frame press accumulator

    MSG msg;
    while (PeekMessage(&msg, nullptr, 0, 0, PM_REMOVE)) {
        if (msg.message == WM_QUIT)
            return false;

        if (msg.message == WM_KEYDOWN) {
            // Bit 30 of lParam (KF_REPEAT in the high word) indicates a repeat
            bool isRepeat = (HIWORD(msg.lParam) & KF_REPEAT) != 0;
            if (!isRepeat) {
                int k = vkToKey(msg.wParam);
                if (k) { s_key |= k; s_held |= k; }
            }
        } else if (msg.message == WM_KEYUP) {
            int k = vkToKey(msg.wParam);
            if (k) s_held &= ~k;
        } else {
            TranslateMessage(&msg);
            DispatchMessage(&msg);
        }
    }
    return true;
}

int  getKey()  { return s_key; }
void clearKey(){ s_key = 0; }
int  getHeld() { return s_held; }

} // namespace Input
