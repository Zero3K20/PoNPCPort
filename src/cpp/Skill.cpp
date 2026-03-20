#include "Skill.h"
#include <cstring>

void Skill::init(int n, const uint8_t* paramData, const uint8_t* nameData) {
    ski_id = n;
    you    = paramData[3] & 0xFF;
    param  = ((paramData[0] & 0xFF) << 8) | (paramData[1] & 0xFF);
    int len = 0;
    while (len < 16 && nameData[len] != 0) ++len;
    name.assign(reinterpret_cast<const char*>(nameData), len);
}
