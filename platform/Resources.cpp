#include "Resources.h"
#include <cstdio>
#include <cstring>
#include <zip.h>

namespace Resources {

static std::string s_spPath;
static std::string s_jarPath;
static FILE*       s_sp  = nullptr;

// From CpCanvas.JarGet(): index n has compressed flag at nArray2[n]
static const int COMPRESSED[40] = {
    0,1,0,1,0, 0,0,0,1,0,   // 0-9
    0,0,1,1,0, 0,1,0,1,0,   // 10-19
    1,0,0,0,0, 0,1,0,1,0,   // 20-29
    0,0,1,0,1, 1,0,0,0,0    // 30-39
};

bool init(const std::string& spPath, const std::string& jarPath) {
    s_spPath  = spPath;
    s_jarPath = jarPath;
    s_sp = std::fopen(spPath.c_str(), "r+b");
    if (!s_sp) s_sp = std::fopen(spPath.c_str(), "w+b");
    return s_sp != nullptr;
}

void quit() {
    if (s_sp) { std::fclose(s_sp); s_sp = nullptr; }
}

bool readSP(uint8_t* dst, int pos, int len) {
    if (!s_sp) return false;
    if (std::fseek(s_sp, pos, SEEK_SET)) return false;
    return (int)std::fread(dst, 1, len, s_sp) == len;
}

bool writeSP(const uint8_t* src, int pos, int len) {
    if (!s_sp) return false;
    if (std::fseek(s_sp, pos, SEEK_SET)) return false;
    return (int)std::fwrite(src, 1, len, s_sp) == len;
}

// Read entry n from the scratchpad as a raw or ZIP-deflated blob.
// dat[] = the 75-int header table at SP offset 0.
std::vector<uint8_t> jarGet(int n, const int* dat) {
    // Rebuild offset table exactly as CpCanvas.JarGet() does
    int offsets[40] = {};
    offsets[0] = 3544;
    for (int i = 1; i < 40; ++i)
        offsets[i] = offsets[i-1] + dat[i-1];

    int offset = offsets[n];
    int len    = dat[n];
    if (len <= 0) return {};

    std::vector<uint8_t> raw(len);
    if (!readSP(raw.data(), offset, len)) return {};

    if (n < 40 && COMPRESSED[n]) {
        // The blob is a tiny ZIP containing "data.dat"; extract it via libzip
        zip_error_t ze;
        zip_source_t* src = zip_source_buffer_create(raw.data(), raw.size(), 0, &ze);
        if (!src) return {};
        zip_t* za = zip_open_from_source(src, ZIP_RDONLY, &ze);
        if (!za) { zip_source_free(src); return {}; }
        zip_stat_t st;
        if (zip_stat(za, "data.dat", 0, &st) < 0) { zip_close(za); return {}; }
        std::vector<uint8_t> out(st.size);
        zip_file_t* zf = zip_fopen(za, "data.dat", 0);
        if (zf) { zip_fread(zf, out.data(), out.size()); zip_fclose(zf); }
        zip_close(za);
        return out;
    }
    return raw;
}

std::vector<uint8_t> jarResource(const std::string& name) {
    int ec = 0;
    zip_t* za = zip_open(s_jarPath.c_str(), ZIP_RDONLY, &ec);
    if (!za) return {};
    zip_stat_t st;
    if (zip_stat(za, name.c_str(), 0, &st) < 0) { zip_close(za); return {}; }
    std::vector<uint8_t> out(st.size);
    zip_file_t* zf = zip_fopen(za, name.c_str(), 0);
    if (zf) { zip_fread(zf, out.data(), out.size()); zip_fclose(zf); }
    zip_close(za);
    return out;
}

bool savegameRead(uint8_t* dst, int offset, int len) {
    FILE* f = std::fopen("pon_save.dat", "rb");
    if (!f) return false;
    std::fseek(f, offset, SEEK_SET);
    bool ok = (int)std::fread(dst, 1, len, f) == len;
    std::fclose(f);
    return ok;
}

bool savegameWrite(const uint8_t* src, int offset, int len) {
    FILE* f = std::fopen("pon_save.dat", "r+b");
    if (!f) f = std::fopen("pon_save.dat", "w+b");
    if (!f) return false;
    std::fseek(f, offset, SEEK_SET);
    bool ok = (int)std::fwrite(src, 1, len, f) == len;
    std::fflush(f);
    std::fclose(f);
    return ok;
}

} // namespace Resources
