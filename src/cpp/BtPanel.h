#pragma once
#include <cstdint>

// Forward declaration
class CpCanvas;

class BtPanel {
public:
    int id       = 0;
    int pos_x    = 0;
    int pos_y    = 0;
    int jin      = 0;
    int jou      = 0;
    int yokoku   = 0;
    int ana_cnt  = 0;
    int mag_cnt  = 0;
    int aria_cnt = 0;
    int on_chara = 0;
    int bom_pow  = 0;
    int hokkei   = 0;
    static int R;
    static int G;
    static int B;

    void init(int n, int n2, int n3);
    void Henka(int n, int n2);
    void NoChara(int n);
    void Move();
    bool JinCh();
    int  img();
    void BackDraw(int n, int n2, bool bl);
    void Draw(int n, bool bl);
    void Draw2();
};
