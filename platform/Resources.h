#pragma once
#include "Platform.h"
#include <string>
#include <vector>

// ── Resources — asset & save I/O for the PoNPCPort PC port ───────────────────
//
// Game assets live in two subdirectories created by tools/extract_assets.py:
//
//   data/sp/NN.bin  — the 40 packed binary entries from the original PoN.sp
//   data/jar/**     — resource files extracted from PoN.jar
//
// Player save data is stored separately in "pon_save.dat".
// ─────────────────────────────────────────────────────────────────────────────
namespace Resources {
    // Call once at startup.  dataDir is the path to the data/ folder
    // (e.g. "data" or "/usr/share/pon/data").
    bool init(const std::string& dataDir);
    void quit();

    // ── Save-state I/O ────────────────────────────────────────────────────────
    // Mirror the original DoJa scratchpad read/write at byte offset [pos, pos+len).
    bool readSP (uint8_t* dst,        int pos, int len);
    bool writeSP(const uint8_t* src,  int pos, int len);

    // ── SP entry loader ───────────────────────────────────────────────────────
    // Returns the raw bytes of data/sp/NN.bin for entry index n (0–39).
    std::vector<uint8_t> jarGet(int n);

    // ── JAR resource loader ───────────────────────────────────────────────────
    // Returns the raw bytes of data/jar/<name>.
    std::vector<uint8_t> jarResource(const std::string& name);

    // ── Legacy save-game wrappers (delegate to readSP / writeSP) ─────────────
    bool savegameRead (uint8_t* dst,       int offset, int len);
    bool savegameWrite(const uint8_t* src, int offset, int len);
}
