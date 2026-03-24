#pragma once
#include "Types.h"

class Edit {
public:
    static int set[12];
    static int set2[12];
    static int flg[12];
    static int zoku[5];
    static int r_zoku;
    static int set_cnt;
    static int now_slot;
    static int max_slot;

    Edit() {}
    int  Set(int n);
    void Dell(int n);
    int  ZokuCh();
    void Draw();
    void Slect(int n);
};
