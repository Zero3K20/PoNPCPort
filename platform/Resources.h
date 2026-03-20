#pragma once
#include "Platform.h"
#include <string>
#include <vector>

// Resource loading – reads assets from PoN.sp (scratchpad) and PoN.jar.
// Mirrors the original CpCanvas.JarGet() / Connector scratchpad API.
namespace Resources {
    bool init(const std::string& spPath, const std::string& jarPath);
    void quit();

    // Raw scratchpad read/write
    bool readSP (uint8_t* dst, int pos, int len);
    bool writeSP(const uint8_t* src, int pos, int len);

    // Return the decompressed bytes for scratchpad entry n.
    // dat[] is the first-75-int header table already loaded into CpCanvas::dat.
    std::vector<uint8_t> jarGet(int n, const int* dat);

    // Load a named file from inside PoN.jar (e.g. "0.gif")
    std::vector<uint8_t> jarResource(const std::string& name);

    // Save-game file I/O (local file "pon_save.dat")
    bool savegameRead (uint8_t* dst, int offset, int len);
    bool savegameWrite(const uint8_t* src, int offset, int len);
}
