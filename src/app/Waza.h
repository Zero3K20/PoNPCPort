#pragma once
#include "Types.h"
#include <string>

class Waza {
public:
    static const int KOU_SUU = 227;
    int waza_id;
    int move_id;
    int eff_id;
    int hit_id;
    int wait_cnt;
    int yokoku;
    int noke_pt;
    int kan;
    int ana;
    int bure;
    int waza_kou;
    int stop_time;
    static int data[681];

    Waza(int n, InputStream *inputStream);
    void Set(InputStream *inputStream);
};
