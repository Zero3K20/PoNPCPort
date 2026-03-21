#ifdef _MSC_VER
#pragma warning(disable: 4996)  // 'fopen': This function or variable may be unsafe
#endif
#include "Resources.h"
#include <cstdio>
#include <cstring>

// ── Resources layer for the PoNPCPort PC port ─────────────────────────────────
//
// All game asset data is pre-extracted from PoN.sp and PoN.jar into two
// subdirectories (see tools/extract_assets.py):
//
//   data/sp/NN.bin  — the 40 binary entries that were packed in PoN.sp
//   data/jar/**     — resource files that were packed in PoN.jar
//
// Save/state data goes to a separate per-user file ("pon_save.dat") so the
// read-only game assets are never modified at runtime.
// ─────────────────────────────────────────────────────────────────────────────

namespace Resources {

static std::string s_spDir;    // ".../data/sp/"
static std::string s_jarDir;   // ".../data/jar/"
static std::string s_saveFile; // "pon_save.dat"

// ── Init / quit ───────────────────────────────────────────────────────────────

bool init(const std::string& dataDir) {
    std::string base = dataDir;
    if (!base.empty() && base.back() != '/' && base.back() != '\\')
        base += '/';
    s_spDir    = base + "sp/";
    s_jarDir   = base + "jar/";
    s_saveFile = "pon_save.dat";
    return true;   // no files are opened until they are actually needed
}

void quit() {}     // nothing to close

// ── Save-state I/O (pon_save.dat) ─────────────────────────────────────────────
// readSP / writeSP map the original DoJa scratchpad offsets onto a local file.

bool readSP(uint8_t* dst, int pos, int len) {
    FILE* f = std::fopen(s_saveFile.c_str(), "rb");
    if (!f) {
        // No save file yet: behave like an uninitialised scratchpad (all 0xFF)
        std::memset(dst, 0xFF, static_cast<size_t>(len));
        return true;
    }
    std::fseek(f, pos, SEEK_SET);
    bool ok = (int)std::fread(dst, 1, static_cast<size_t>(len), f) == len;
    std::fclose(f);
    return ok;
}

bool writeSP(const uint8_t* src, int pos, int len) {
    // Open existing file for update; create it if absent
    FILE* f = std::fopen(s_saveFile.c_str(), "r+b");
    if (!f) f = std::fopen(s_saveFile.c_str(), "w+b");
    if (!f) return false;
    std::fseek(f, pos, SEEK_SET);
    bool ok = (int)std::fwrite(src, 1, static_cast<size_t>(len), f) == len;
    std::fflush(f);
    std::fclose(f);
    return ok;
}

// ── SP entry loader ───────────────────────────────────────────────────────────
// Returns the raw bytes of data/sp/NN.bin for entry n (0-39).
// The dat[] argument has been removed — no offset calculation needed.

std::vector<uint8_t> jarGet(int n) {
    char path[512];
    std::snprintf(path, sizeof(path), "%s%02d.bin", s_spDir.c_str(), n);
    FILE* f = std::fopen(path, "rb");
    if (!f) return {};
    std::fseek(f, 0, SEEK_END);
    long sz = std::ftell(f);
    std::fseek(f, 0, SEEK_SET);
    if (sz <= 0) return {};
    std::vector<uint8_t> buf(static_cast<size_t>(sz));
    std::fread(buf.data(), 1, buf.size(), f);
    std::fclose(f);
    return buf;
}

// ── JAR resource loader ───────────────────────────────────────────────────────
// Returns the raw bytes of data/jar/<name>.

std::vector<uint8_t> jarResource(const std::string& name) {
    std::string path = s_jarDir + name;
    FILE* f = std::fopen(path.c_str(), "rb");
    if (!f) return {};
    std::fseek(f, 0, SEEK_END);
    long sz = std::ftell(f);
    std::fseek(f, 0, SEEK_SET);
    if (sz <= 0) return {};
    std::vector<uint8_t> buf(static_cast<size_t>(sz));
    std::fread(buf.data(), 1, buf.size(), f);
    std::fclose(f);
    return buf;
}

// ── Legacy save-game wrappers ─────────────────────────────────────────────────
// Kept for compatibility; they delegate to readSP / writeSP.

bool savegameRead(uint8_t* dst, int offset, int len) {
    return readSP(dst, offset, len);
}

bool savegameWrite(const uint8_t* src, int offset, int len) {
    return writeSP(src, offset, len);
}

} // namespace Resources
