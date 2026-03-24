#pragma once
#include "Types.h"

class Okimono {
public:
    int oki_id;
    int on;
    int syu;
    int hp;
    int drop_time;
    int rock_ata;
    int teki_ata;
    int move_ok;
    int only_flg;
    int pos_x;
    int pos_y;
    int pos_dx;
    int pos_dy;
    int flp;
    int pow;
    int hit_cnt;
    int ani_id;
    int ani_pt;
    int ani_max;
    int ani_cnt;
    int next_off;
    int move_cnt;
    int waza_syu;
    static int o_data[14];

    Okimono(int n);
    void init();
    void Set(int n, int n2, int n3, int n4, int n5);
    void Move();
    static int PaneRan(int n);
    void Hit(int n, int n2);
    void Off();
    void NextOff();
    void Draw();
};
