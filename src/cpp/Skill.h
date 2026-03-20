#pragma once
#include <string>
#include <cstdint>

class Skill {
public:
    int ski_id = 0;
    int you    = 0;
    int param  = 0;
    std::string name;

    void init(int n, const uint8_t* paramData, const uint8_t* nameData);
};
