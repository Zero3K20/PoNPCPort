#include "Waza.h"

int Waza::data[681] = {};

void Waza::init(int n, const uint8_t* s) {
    waza_id   = n;
    move_id   = s[3] & 0xFF;
    eff_id    = s[2] & 0xFF;
    hit_id    = s[1] & 0xFF;
    wait_cnt  = s[0] & 0x3F;
    yokoku    = (s[0] & 0xFF) >> 6;
    noke_pt   = (s[7] >> 3) & 3;
    kan       = (s[7] >> 2) & 1;
    ana       = (s[7] >> 1) & 1;
    bure      =  s[7]       & 1;
    waza_kou  = s[6] & 0xFF;
    stop_time = s[5] & 0xFF;
}

void Waza::Set(const uint8_t* s) {
    for (int i = 0; i < 227; ++i) {
        const uint8_t* b = s + i * 12;
        data[i*3+0] = ((b[0]&0xFF)<<24)|((b[1]&0xFF)<<16)|((b[2]&0xFF)<<8)|(b[3]&0xFF);
        data[i*3+1] = ((b[4]&0xFF)<<24)|((b[5]&0xFF)<<16)|((b[6]&0xFF)<<8)|(b[7]&0xFF);
        data[i*3+2] = ((b[8]&0xFF)<<24)|((b[9]&0xFF)<<16)|((b[10]&0xFF)<<8)|(b[11]&0xFF);
    }
}
