# PoNPCPort – PC Port (C++ / SDL2)

A work-in-progress PC port of the 2009 NTT DoCoMo DoJa i-mode mobile game originally distributed as `PoN.jar` / `PoN.sp`.

## Requirements

| Library | Purpose |
|---------|---------|
| [SDL2](https://libsdl.org) ≥ 2.0.14 | Window, renderer, gamepad |
| [SDL2_mixer](https://wiki.libsdl.org/SDL2_mixer) | Audio |
| [SDL2_ttf](https://wiki.libsdl.org/SDL2_ttf) | Text rendering |
| [SDL2_image](https://wiki.libsdl.org/SDL2_image) | GIF/PNG loading |
| [libzip](https://libzip.org) | Reading assets from PoN.jar / PoN.sp |
| zlib | Decompression |
| CMake ≥ 3.16 | Build system |
| C++17 compiler | g++ / clang++ / MSVC 2019+ |

### Ubuntu / Debian

```bash
sudo apt install cmake libsdl2-dev libsdl2-mixer-dev libsdl2-ttf-dev libsdl2-image-dev libzip-dev zlib1g-dev
```

### macOS (Homebrew)

```bash
brew install cmake sdl2 sdl2_mixer sdl2_ttf sdl2_image libzip
```

### Windows (vcpkg)

```powershell
vcpkg install sdl2 sdl2-mixer sdl2-ttf sdl2-image libzip
```

## Build

```bash
mkdir build && cd build
cmake .. -DCMAKE_BUILD_TYPE=Release
make -j$(nproc)
```

The `PoN.jar` and `PoN.sp` files are copied automatically to the build directory after the build completes. Place a monospace TTF font at `data/font.ttf` inside the build directory for best text rendering (the port falls back to common system fonts if absent).

## Controls

| Action | Keyboard | Gamepad |
|--------|----------|---------|
| Move up | ↑ / W | D-pad up / Left stick up |
| Move down | ↓ / S | D-pad down / Left stick down |
| Move left | ← / A | D-pad left / Left stick left |
| Move right | → / D | D-pad right / Left stick right |
| Confirm / Attack | Z / Enter / Space | A (Xbox) / Cross (PS) |
| Cancel / Back | X / Backspace / Esc | B (Xbox) / Circle (PS) |
| Left soft key | Q / F | X (Xbox) / Square (PS) |
| Right soft key | E | RB (Xbox) / R1 (PS) |
| Extra soft | R | LB (Xbox) / L1 (PS) |
| Select | Return2 | Start |
| Menu | M | Select / Back |

## Notes

- The original game requires first-run data to be downloaded from Capcom's server, which is no longer online.  The `CpDataDownload` stub returns a "server unavailable" error, so scenes that depend on live data may show error screens.
- `PoN.sp` is a binary "scratchpad" file containing compressed game data (sprites, map data, etc.).  Asset loading reads directly from this file.
- The 240 × 240 game canvas is upscaled 3× to a 720 × 720 window by default.
