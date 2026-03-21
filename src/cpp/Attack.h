#pragma once
#include <cstdint>

// Minimal Attack class header - Attack.cpp is implemented separately
class Attack {
public:
    int ata_id    = 0;
    int tmp_id    = 0;
    int eff_id    = 0;
    int pos_x     = 0;
    int pos_y     = 0;
    int pos_dx    = 0;
    int pos_dy    = 0;
    int waza_id   = 0;
    int yokoku    = 0;
    int move_flg  = 0;
    int pow       = 0;
    int zoku      = 0;
    int hit_x     = 0;
    int hit_y     = 0;
    int hit_kou   = 0;
    int hit_eff   = 0;
    int hit_param = 0;
    int hit_kan   = 0;
    int hit_ana   = 0;
    int hit_bure  = 0;
    int hit_time  = 0;
    int oki_hit   = 0;
    int hit_flg   = 0;
    int param[12] = {};
    int ani_id    = 0;
    int ani_pt    = 0;
    int ani_max   = 0;
    int ani_cnt   = 0;
    int ani_ok    = 0;
    int stop      = 0;
    int move_cnt  = 0;
    int move_x    = 0;
    int move_y    = 0;
    int s_wait    = 0;
    int e_wait    = 0;
    int r_suu     = 0;
    int r_s       = 0;
    int r_e       = 0;
    int on        = 0;
    int chara_flg = 0;
    int flp       = 0;
    int ren_hit   = 0;
    int hon_id    = -1;
    int t_ani_cnt = 0;
    int tmp_s_wait= 0;
    int tmp_r_suu = 0;
    int tmp_e_wait= 0;
    int hit_ok    = 0;
    int loop_flg  = 0;
    int se_id     = 0;
    int se_flg    = 0;

    explicit Attack(int n);

    void init();
    int Set(int waza, int x, int y, int flp, int chara);
    void EffSet();
    int CopySet(int n, int n2, int n3, int n4);
    void WazaSet();
    void KouSet();
    void PosSet(int n);
    int EneZa(int n);
    void HitSet(int n);
    void Move(int n);
    void MocoSet();
    void HitGo(int n);
    bool HitTime();
    void HitCheck(int n);
    void PaneRetrun(int n, int n2, int n3);
    int PaneRan(int n, int n2, int n3);
    void HitExp(int n, int n2);
    void SetOki(int n);
    int OnlyOki(int n);
    int HitEnd(int n);
    bool Hit(int n, int n2, int n3);
    bool HitEff(int n, int n2, int n3);
    void Loop();
    void Draw(int n, int n2);
};
