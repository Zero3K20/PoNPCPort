#pragma once
#include <cstdint>
#include <string>

class CpDataDownload {
public:
    // The Capcom server is offline; always returns -1.
    static int getDataEx(const std::string& path, int offset, int length, bool checkmodel, uint8_t* buf);
};
