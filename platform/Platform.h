#pragma once
// Shared Win32 / GDI+ includes and game-wide constants for the PC port.

#ifndef WIN32_LEAN_AND_MEAN
#define WIN32_LEAN_AND_MEAN
#endif
#include <windows.h>
#include <shellapi.h>   // ShellExecute

// GDI+ ─────────────────────────────────────────────────────────────────────
// Note: NOMINMAX is intentionally NOT defined here. GDI+ (GdiplusTypes.h)
// uses unqualified min/max which are provided as macros by <windows.h>.
// Our own code uses std::min / std::max with qualified names.
#include <algorithm>    // std::min, std::max (also ensures C++ overloads visible)
#include <gdiplus.h>
#pragma comment(lib, "gdiplus.lib")

// XAudio2 ──────────────────────────────────────────────────────────────────
#include <xaudio2.h>
#pragma comment(lib, "xaudio2.lib")

// Windows Imaging Component (WIC) for GIF/PNG/JPG decode ────────────────────
#include <wincodec.h>
#pragma comment(lib, "windowscodecs.lib")

#pragma comment(lib, "shell32.lib")

#include <string>
#include <vector>
#include <cstdint>
#include <cstring>
#include <cstdlib>
#include <cmath>
#include <memory>

// ── Screen dimensions (original DoJa display) ──────────────────────────────
static const int SCREEN_W     = 240;
static const int SCREEN_H     = 240;
static const int WINDOW_SCALE = 3;   // PC window = 720×720

// ── DoJa Graphics anchor flags ─────────────────────────────────────────────
static const int GFX_HCENTER  = 1;
static const int GFX_VCENTER  = 2;
static const int GFX_LEFT     = 4;
static const int GFX_RIGHT    = 8;
static const int GFX_TOP      = 16;
static const int GFX_BOTTOM   = 32;
static const int GFX_BASELINE = 64;

// ── DoJa key bit-positions (key = 1 << bitpos) ─────────────────────────────
//   These values are what the original processEvent() produces.
static const int KEY_UP     = (1 << 0);   //       1
static const int KEY_DOWN   = (1 << 1);   //       2
static const int KEY_LEFT   = (1 << 2);   //       4
static const int KEY_RIGHT  = (1 << 3);   //       8
static const int KEY_FIRE   = (1 << 4);   //      16
static const int KEY_SOFT1  = (1 << 16);  //   65536
static const int KEY_SOFT2  = (1 << 17);  //  131072
static const int KEY_SOFT3  = (1 << 18);  //  262144
static const int KEY_SOFT4  = (1 << 19);  //  524288
static const int KEY_SELECT = (1 << 20);  // 1048576  (0x100000)
static const int KEY_MENU   = (1 << 21);  // 2097152  (0x200000)
