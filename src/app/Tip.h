#pragma once
#include "Types.h"
#include <string>

class Tip {
public:
    int tip_id;
    int syu;
    int aiu;
    int pow;
    int zoku;
    int rea;
    int setu_id;
    int regu_you;
    int waza_id;
    std::string name;

    Tip() : tip_id(0), syu(0), aiu(0), pow(0), zoku(0), rea(0),
            setu_id(0), regu_you(0), waza_id(0) {}
    void init(int n, InputStream *inputStream, InputStream *inputStream2);
};
