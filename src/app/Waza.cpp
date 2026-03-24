#include "Waza.h"

int Waza::data[681];

Waza::Waza(int n, InputStream *inputStream)
{
    unsigned char byArray[4];
    waza_id = n;
    if (!inputStream) return;
    try {
        inputStream->read(byArray, 4);
        move_id   = byArray[3] & 0xFF;
        eff_id    = byArray[2] & 0xFF;
        hit_id    = byArray[1] & 0xFF;
        wait_cnt  = byArray[0] & 0x3F;
        yokoku    = (byArray[0] & 0xFF) >> 6;
        inputStream->read(byArray, 4);
        noke_pt   = (byArray[3] >> 3) & 3;
        kan       = (byArray[3] >> 2) & 1;
        ana       = (byArray[3] >> 1) & 1;
        bure      = (byArray[3] >> 0) & 1;
        waza_kou  = byArray[2] & 0xFF;
        stop_time = byArray[1] & 0xFF;
    } catch (...) {}
}

void Waza::Set(InputStream *inputStream)
{
    if (!inputStream) return;
    try {
        unsigned char byArray[12];
        for (int i = 0; i < 227; ++i) {
            inputStream->read(byArray, 12);
            data[i*3+0] = ((byArray[0]&0xFF)<<24)|((byArray[1]&0xFF)<<16)|((byArray[2]&0xFF)<<8)|(byArray[3]&0xFF);
            data[i*3+1] = ((byArray[4]&0xFF)<<24)|((byArray[5]&0xFF)<<16)|((byArray[6]&0xFF)<<8)|(byArray[7]&0xFF);
            data[i*3+2] = ((byArray[8]&0xFF)<<24)|((byArray[9]&0xFF)<<16)|((byArray[10]&0xFF)<<8)|(byArray[11]&0xFF);
        }
    } catch (...) {}
}
