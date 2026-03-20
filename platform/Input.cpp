#include "Input.h"
#include <cstring>

namespace Input {

static int s_key  = 0;
static int s_held = 0;
static SDL_GameController* s_controller = nullptr;

static int scancodeToKey(SDL_Scancode sc) {
    switch (sc) {
        case SDL_SCANCODE_UP:    case SDL_SCANCODE_W: return KEY_UP;
        case SDL_SCANCODE_DOWN:  case SDL_SCANCODE_S: return KEY_DOWN;
        case SDL_SCANCODE_LEFT:  case SDL_SCANCODE_A: return KEY_LEFT;
        case SDL_SCANCODE_RIGHT: case SDL_SCANCODE_D: return KEY_RIGHT;
        case SDL_SCANCODE_Z:
        case SDL_SCANCODE_RETURN:
        case SDL_SCANCODE_SPACE:    return KEY_FIRE;
        case SDL_SCANCODE_X:
        case SDL_SCANCODE_BACKSPACE:
        case SDL_SCANCODE_ESCAPE:   return KEY_SOFT2;
        case SDL_SCANCODE_Q:
        case SDL_SCANCODE_F:        return KEY_SOFT1;
        case SDL_SCANCODE_E:        return KEY_SOFT3;
        case SDL_SCANCODE_R:        return KEY_SOFT4;
        case SDL_SCANCODE_KP_ENTER: return KEY_SELECT;
        case SDL_SCANCODE_M:        return KEY_MENU;
        default: return 0;
    }
}

static int buttonToKey(SDL_GameControllerButton btn) {
    switch (btn) {
        case SDL_CONTROLLER_BUTTON_A:             return KEY_FIRE;
        case SDL_CONTROLLER_BUTTON_B:             return KEY_SOFT2;
        case SDL_CONTROLLER_BUTTON_X:             return KEY_SOFT1;
        case SDL_CONTROLLER_BUTTON_Y:             return KEY_SOFT1;
        case SDL_CONTROLLER_BUTTON_START:         return KEY_SELECT;
        case SDL_CONTROLLER_BUTTON_BACK:          return KEY_MENU;
        case SDL_CONTROLLER_BUTTON_RIGHTSHOULDER: return KEY_SOFT3;
        case SDL_CONTROLLER_BUTTON_LEFTSHOULDER:  return KEY_SOFT4;
        case SDL_CONTROLLER_BUTTON_DPAD_UP:       return KEY_UP;
        case SDL_CONTROLLER_BUTTON_DPAD_DOWN:     return KEY_DOWN;
        case SDL_CONTROLLER_BUTTON_DPAD_LEFT:     return KEY_LEFT;
        case SDL_CONTROLLER_BUTTON_DPAD_RIGHT:    return KEY_RIGHT;
        default: return 0;
    }
}

void init() {
    // Load community controller mappings if present
    SDL_GameControllerAddMappingsFromFile("gamecontrollerdb.txt");
    for (int i = 0; i < SDL_NumJoysticks(); ++i) {
        if (SDL_IsGameController(i)) {
            s_controller = SDL_GameControllerOpen(i);
            if (s_controller) {
                SDL_Log("Gamepad: %s", SDL_GameControllerName(s_controller));
                break;
            }
        }
    }
}

void quit() {
    if (s_controller) { SDL_GameControllerClose(s_controller); s_controller = nullptr; }
}

bool pollEvents() {
    s_key = 0;  // clear per-frame press accumulator
    SDL_Event ev;
    while (SDL_PollEvent(&ev)) {
        switch (ev.type) {
        case SDL_QUIT: return false;

        case SDL_KEYDOWN: {
            if (!ev.key.repeat) {
                int k = scancodeToKey(ev.key.keysym.scancode);
                if (k) { s_key |= k; s_held |= k; }
            }
            break;
        }
        case SDL_KEYUP: {
            int k = scancodeToKey(ev.key.keysym.scancode);
            if (k) s_held &= ~k;
            break;
        }

        case SDL_CONTROLLERBUTTONDOWN: {
            int k = buttonToKey((SDL_GameControllerButton)ev.cbutton.button);
            if (k) { s_key |= k; s_held |= k; }
            break;
        }
        case SDL_CONTROLLERBUTTONUP: {
            int k = buttonToKey((SDL_GameControllerButton)ev.cbutton.button);
            if (k) s_held &= ~k;
            break;
        }

        case SDL_CONTROLLERAXISMOTION: {
            const int DEAD = 8000;
            if (ev.caxis.axis == SDL_CONTROLLER_AXIS_LEFTX) {
                if (ev.caxis.value < -DEAD) { s_key |= KEY_LEFT;  s_held |= KEY_LEFT;  s_held &= ~KEY_RIGHT; }
                else if (ev.caxis.value > DEAD) { s_key |= KEY_RIGHT; s_held |= KEY_RIGHT; s_held &= ~KEY_LEFT; }
                else s_held &= ~(KEY_LEFT | KEY_RIGHT);
            } else if (ev.caxis.axis == SDL_CONTROLLER_AXIS_LEFTY) {
                if (ev.caxis.value < -DEAD) { s_key |= KEY_UP;   s_held |= KEY_UP;   s_held &= ~KEY_DOWN; }
                else if (ev.caxis.value > DEAD) { s_key |= KEY_DOWN; s_held |= KEY_DOWN; s_held &= ~KEY_UP; }
                else s_held &= ~(KEY_UP | KEY_DOWN);
            }
            break;
        }

        case SDL_CONTROLLERDEVICEADDED:
            if (!s_controller) {
                s_controller = SDL_GameControllerOpen(ev.cdevice.which);
                if (s_controller)
                    SDL_Log("Gamepad connected: %s", SDL_GameControllerName(s_controller));
            }
            break;
        case SDL_CONTROLLERDEVICEREMOVED:
            if (s_controller) {
                SDL_Joystick* j = SDL_GameControllerGetJoystick(s_controller);
                if (j && SDL_JoystickInstanceID(j) == ev.cdevice.which) {
                    SDL_Log("Gamepad disconnected");
                    SDL_GameControllerClose(s_controller);
                    s_controller = nullptr;
                    // Try to open another controller
                    for (int i = 0; i < SDL_NumJoysticks(); ++i) {
                        if (SDL_IsGameController(i)) {
                            s_controller = SDL_GameControllerOpen(i);
                            if (s_controller) break;
                        }
                    }
                }
            }
            break;

        default: break;
        }
    }
    return true;
}

int  getKey()  { return s_key; }
void clearKey(){ s_key = 0; }
int  getHeld() { return s_held; }

} // namespace Input
