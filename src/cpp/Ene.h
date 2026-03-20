#pragma once
#include <cstdint>

class Ene {
public:
    // ── Instance fields ──────────────────────────────────────────────────
    int waza_flg   = 0;
    int waza_wait  = 0;
    int waza_syu   = 0;
    int hp         = 0;
    int max_hp     = 0;
    int zoku       = 0;
    int waza_id[5]   = {};
    int waza_zoku[5] = {};
    int pow[5]       = {};
    int zenny        = 0;
    int drop_tip[4]  = {};
    int pos_x        = -1;
    int pos_y        = -1;
    int pos_dx       = 0;
    int pos_dy       = 0;
    int tmp_x        = 0;
    int tmp_y        = 0;
    int def_x        = 0;
    int def_y        = 0;
    int move_flg     = 0;
    int move_cnt     = 0;
    int wait_cnt     = 0;
    int syoumetu_cnt = 0;
    int on           = 0;
    int joutai       = 0;
    int muteki_cnt   = 0;
    int tmp_muteki_cnt = 0;
    int hit_cnt      = 0;
    int ani_wait_cnt = 0;
    int tmp_wait_cnt = 0;
    int ani_ok       = 0;
    int s_wait       = 0;
    int e_wait       = 0;
    int r_suu        = 0;
    int r_s          = 0;
    int r_e          = 0;
    int ani_id       = 0;
    int ani_pt[3]    = {};
    int ani_max      = 0;
    int ani_cnt      = 0;
    int ani_cnt_max  = 0;
    int chara_no     = -1;
    int chara_lv     = 0;
    int chara_id     = 0;
    int ene_id       = 0;
    int bari         = 0;
    int bari_id      = 0;
    int ata_id       = 0;
    int han          = 0;
    int pane_id      = 0;
    int tmp_move     = 0;
    int tmp_cnt      = 0;
    int tmp_cnt2     = 0;
    int air          = 0;
    int tmp_lv       = 0;
    int def_ani      = 0;
    int navi_flg     = 0;
    int mahi_id      = 0;
    int muteki2      = 0;
    int t_ani_cnt    = 0;
    int tmp_s_wait   = 0;
    int tmp_r_suu    = 0;
    int tmp_e_wait   = 0;
    int x_sp         = 40;
    int y_sp         = 24;

    // ── Static fields ─────────────────────────────────────────────────────
    static int move[22][5];
    static int eria_flg;

    // ── Methods ───────────────────────────────────────────────────────────
    void init(int n, int n2, int n3, int n4, int n5);
    void ParaSet(int n, int n2);
    void MoveSet();
    void AniSet(int n);
    int  Move();
    int  PaneRan(int n);
    bool StBom(int n, int n2);
    void PaneCh();
    int  Check(int n, int n2);
    void NextChara(int n);
    bool Hit(int n, int n2, int n3);
    void Syoumetu();
    void Off();
    void EffSet(int n);
    void Action(int n);
    int  Get(int n, int n2);
    void Loop();
    void HpDraw();
    void Draw(int n);
};
