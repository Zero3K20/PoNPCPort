#pragma once
#include "Types.h"

class BtPanel {
public:
    int id;
    int pos_x;
    int pos_y;
    int jin;
    int jou;
    int yokoku;
    int ana_cnt;
    int mag_cnt;
    int aria_cnt;
    int on_chara;
    int bom_pow;
    int hokkei;
    static int R;
    static int G;
    static int B;

    BtPanel() : id(0), pos_x(0), pos_y(0), jin(0), jou(1), yokoku(0),
        ana_cnt(0), mag_cnt(0), aria_cnt(0), on_chara(0), bom_pow(0), hokkei(0) {}
    void init(int n, int n2, int n3);
    void Henka(int n, int n2);
    void NoChara(int n);
    void Move();
    void Draw(int n, bool bl);
};
