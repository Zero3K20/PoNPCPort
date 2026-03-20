#pragma once
#include <string>
#include <cstdint>

class Tip {
public:
    int tip_id   = 0;
    int syu      = 0;
    int aiu      = 0;
    int pow      = 0;
    int zoku     = 0;
    int rea      = 0;
    int setu_id  = 0;
    int regu_you = 0;
    int waza_id  = 0;
    std::string name;

    Tip() = default;
    void init(int n, const uint8_t* tipData, const uint8_t* nameData);

    void DrawSetu();
    void DrawRea(int n, int n2);
    void DrawRegu(int n, int n2);
    void DrawPow(int n, int n2);
    void DrawPow2(int n, int n2);
    void DrawCode(int n, int n2, int n3, int n4);
    void DrawZoku(int n, int n2);
    void DrawName(int n, int n2);
    void Draw(int n, int n2, int n3, bool bl);
};
