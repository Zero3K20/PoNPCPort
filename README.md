# PoNPCPort – Phantom of Network PC Port

A Windows PC port of **Phantom of Network** (ファントム オブ ネットワーク), a 2009 NTT DoCoMo DoJa i-mode mobile game by CAPCOM featuring Rockman.EXE (Mega Man Battle Network).

## Requirements

Place the following files in the **same directory** as the compiled executable:

| File | Description |
|------|-------------|
| `PoN.jar` | Original game JAR (contains images and class files) |
| `PoN.sp`  | Original scratchpad file (contains game data and audio) |

## Controls

| Key | Action |
|-----|--------|
| Enter / Space / Z | Fire / Confirm |
| Arrow keys | Move cursor / navigate |
| X | Left soft key |
| C | Right soft key |
| Escape | Quit |

## Building

Open `PoNPCPort.sln` in Visual Studio 2019 (or newer) and build in Release or Debug configuration.  
The project targets Win32 and uses Win32/GDI+/XAudio2 — no external SDK is required beyond the Windows SDK.

## Running the game

1. Build or download the executable.
2. Copy `PoN.jar` and `PoN.sp` into the same directory.
3. Run `PoNPCPort.exe`.
4. The **Phantom of Network** title screen will appear — press **Enter** to start.
5. From the **GAME START / RETURN TO TITLE** menu press **Enter** again to enter the field map.
6. On the field map use arrow keys to move and **Enter** to start a battle.

## Alternative: running the original JAR with SquirrelJME

[SquirrelJME](https://github.com/squirreljme/squirreljme) is an open-source Java ME 8 virtual machine that targets preservation of mobile Java software, including Japanese keitai (DoJa / i-mode) applications.

Using SquirrelJME may provide a more accurate emulation of the original game compared to this C++ port, which is a work-in-progress decompilation:

1. Clone or download SquirrelJME from <https://github.com/squirreljme/squirreljme>.
2. Follow its [build instructions](https://github.com/squirreljme/squirreljme/blob/trunk/building.mkd) (requires Java 8+ and Gradle).
3. Launch `PoN.jar` through the SquirrelJME runner.

> **Note:** DoJa i-mode APIs (`com.nttdocomo.ui.*`) differ from standard MIDP/J2ME.  
> SquirrelJME support for DoJa-specific APIs may be incomplete — check their  
> [compatibility list](https://github.com/squirreljme/squirreljme/blob/trunk/assets/doc/compatibility.mkd) for the current status.

## Known limitations

- **Audio**: The audio blocks in `PoN.sp` use an obfuscated/proprietary format. Music and sound effects are currently silent.
- **Sprites**: Only the images bundled in `PoN.jar` (`data/new/img/0–9.gif`) are loaded. The full sprite sheets stored in `PoN.sp` require additional reverse-engineering of the SP block format.
- Several game systems (scenario events, ranking, network features) are stub implementations.

## License / credits

This project is a fan decompilation for preservation purposes.  
Original game © CAPCOM Co., Ltd. 2009.
