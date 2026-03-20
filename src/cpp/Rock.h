#pragma once
#include <cstdint>

class Tip;

class Rock {
public:
    // ── Instance fields (small helpers for animation bookkeeping) ──────────
    Tip* tip[9] = {};
    int t_ani_cnt   = 0;
    int tmp_s_wait  = 0;
    int tmp_r_suu   = 0;
    int tmp_e_wait  = 0;

    // ── Static fields (shared game state) ─────────────────────────────────
    static int  tip_data[30];
    static int  tip_no;
    static int* pow;           // pow[4]
    static int  next_tip;
    static int  hp;
    static int  zoku;
    static int  pos_x;
    static int  pos_y;
    static int  dx;
    static int  dy;
    static int  tmp_x;
    static int  tmp_y;
    static int  joutai;
    static int  muteki_cnt;
    static int  tmp_muteki_cnt;
    static int  hit_cnt;
    static int  move_flg;
    static int  syoumetu_cnt;
    static int  ani_wait_cnt;
    static int  tmp_ani_cnt;
    static int  ani_ok;
    static int  s_wait;
    static int  e_wait;
    static int  r_suu;
    static int  r_s;
    static int  r_e;
    static int  ani_cnt;
    static int  ani_cnt_max;
    static int* ani_id;        // ani_id[2]
    static int* ani_pt;        // ani_pt[2]
    static int  ani_max;
    static int**move;          // move[22][7]
    static int  waza_flg;
    static int  waza_wait;
    static int  non_cnt;
    static int  non_cnt2;
    static int  bas_no;
    static int  bas_pow;
    static int  han;
    static int  han_id;
    static int  bari;
    static int  bari_id;
    static int  wana;
    static int  pane_id;
    static int  tmp_move;
    static int  non_bas;
    static int  tmp_ata;
    static int  air;
    static int  move_cnt;
    static int  noke_cnt;
    static int  mahi_id;

    Rock();

    void init();
    void MoveSet();
    void AniSet(int n);
    void Move();
    void PaneCh();
    int  Check(int n, int n2, int n3);
    bool StBom(int n, int n2);
    bool Hit(int n, int n2, int n3);
    void Syoumetu();
    int  Chage(int n);
    void EffSet(int n);
    void Action(int n);
    void TipNext();
    void TipDraw();
    void Loop();
    void WanaDraw();
    void HpDraw(int n, int n2);
    void Draw(int n);
};
