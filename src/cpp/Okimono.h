#pragma once
#include <cstdint>

class Okimono {
public:
    int oki_id    = 0;
    int on        = 0;
    int syu       = 0;
    int hp        = 0;
    int drop_time = 0;
    int rock_ata  = 0;
    int teki_ata  = 0;
    int move_ok   = 0;
    int only_flg  = 0;
    int pos_x     = 0;
    int pos_y     = 0;
    int pos_dx    = 0;
    int pos_dy    = 0;
    int flp       = 0;
    int pow       = 0;
    int hit_cnt   = 0;
    int ani_id    = 0;
    int ani_pt    = 0;
    int ani_max   = 0;
    int ani_cnt   = 0;
    int next_off  = 0;
    int move_cnt  = 0;
    int waza_syu  = 0;

    static int o_data[14];

    explicit Okimono(int n);

    void init();
    void Set(int n, int n2, int n3, int n4, int n5);
    void Move();
    void Hit(int n, int n2);
    void Off();
    void NextOff();
    void Draw();

    static int PaneRan(int n);
};
