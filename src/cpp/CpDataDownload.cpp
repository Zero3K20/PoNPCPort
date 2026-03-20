#include "CpDataDownload.h"

// The original game downloaded additional data from Capcom's server
// (http://game.capcom.jp/i/sreg/dataget.php) which is no longer available.
// All download attempts return -1 (error) so the game falls back gracefully.
int CpDataDownload::getDataEx(const std::string& /*path*/, int /*offset*/,
                               int /*length*/, bool /*checkmodel*/,
                               uint8_t* /*buf*/) {
    return -1;
}
