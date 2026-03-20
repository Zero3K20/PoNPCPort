#pragma once
#include <cstdint>

class Waza {
public:
    int waza_id   = 0;
    int move_id   = 0;
    int eff_id    = 0;
    int hit_id    = 0;
    int wait_cnt  = 0;
    int yokoku    = 0;
    int noke_pt   = 0;
    int kan       = 0;
    int ana       = 0;
    int bure      = 0;
    int waza_kou  = 0;
    int stop_time = 0;

    // KOU_SUU = 227, data[681] holds 3 ints per waza
    static int data[681];

    void init(int n, const uint8_t* stream);  // reads 8 bytes
    void Set(const uint8_t* stream);           // reads 227*12 bytes
};
