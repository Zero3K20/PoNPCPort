#pragma once
#include "../platform/Graphics.h"
#include "../platform/Image.h"
#include "../platform/Audio.h"
#include <random>
#include <string>

// Forward declarations of all game classes
class Attack;
class BtPanel;
class Ene;
class Folder;
class Mail;
class Okimono;
class Rock;
class Skill;
class Tip;
class Waza;
class Edit;
class Font;

// Forward declarations for CpCanvas static fields/methods used by other classes
class CpCanvas {
public:
    // ── Debug / constants ──────────────────────────────────────────────────
    static int deba_flg;

    // ── Random ─────────────────────────────────────────────────────────────
    static std::mt19937 rand;

    // ── Game objects ────────────────────────────────────────────────────────
    static Rock*         rock;
    static Ene**         ene;          // ene[3]
    static Okimono**     oki;
    static BtPanel**     panel;        // panel[3][6] - accessed as panel[row][col]
    static Folder**      fol;
    static Tip**         tip;
    static Attack**      ata;
    static Waza**        waza;
    static Mail**        mail;
    static Skill**       skill;
    static Edit*         edit;

    // ── Graphics ────────────────────────────────────────────────────────────
    static Graphics*       g;
    static Image*          imgMap;
    static Image*          tmp_imgMap;
    static Graphics*       graMap;
    static Graphics*       tmp_graMap;
    static Image**         imgMap2;
    static Graphics**      graMap2;
    static Font*           f;

    // ── Game state ──────────────────────────────────────────────────────────
    static int game_cnt;
    static int scene;

    // ── Images / palette ────────────────────────────────────────────────────
    static PalettedImage** image;      // image[IMG_SUU]
    static Image*          dmy_image;
    static Palette**       pal;
    static AudioPresenter** audio;

    // ── Input ────────────────────────────────────────────────────────────────
    static int key;
    static int okey;
    static int key_cnt;
    static int key2;

    // ── Chip / tip data ──────────────────────────────────────────────────────
    static int* tip_list;
    static int* skill_list;
    static int* dat;

    // ── Player stats ──────────────────────────────────────────────────────────
    static int score;
    static int user_id;
    static int max_hp;
    static int now_hp;
    static int zenny;
    static int piece;
    static int now_fol;
    static int fol_suu;
    static int ata_lv;
    static int cha_lv;
    static int regu_you;
    static int full_ene;

    // ── Mode flags ────────────────────────────────────────────────────────────
    static int mode;
    static int mode2;
    static int boss_flg;
    static int ene_cnt;
    static int dell_cnt;
    static int over_cnt;
    static int over_flg;

    // ── Battle ────────────────────────────────────────────────────────────────
    static int cus_gage;
    static int cus_sp;
    static int stop_time;
    static int stop_cnt;
    static int stop_ch;
    static int eff_id;
    static std::string stop_name;
    static int win_flg;
    static int bas_flg;
    static int bas_lv;
    static int bas_cnt;
    static int* bt_get;
    static int wana_flg;
    static int* wana_pow;
    static int combo;
    static int combo_cnt;
    static int combo_time;
    static int dell_lv;

    // ── Custom screen / folder ────────────────────────────────────────────────
    static int* cas_tip;
    static int* fol_tip_no;
    static int* set_tip;
    static int  sel_cas_mode;
    static int  sel_cas_tip;
    static int  max_sel;
    static int  sel_cnt;
    static int  now_code;
    static int* sel_code;
    static int* cas_ok;
    static int  cas_cnt;
    static int  regu_flg;
    static int  esc_flg;
    static int  m_max;
    static int  g_max;

    // ── Animation data ────────────────────────────────────────────────────────
    static int*** ani;
    static int*** a_dx;
    static int*** a_dy;
    static int**  gx;
    static int**  gy;
    static int**  sx;
    static int**  sy;
    static int**  dx;
    static int**  dy;

    // ── Motion data ───────────────────────────────────────────────────────────
    static int* rock_mo;
    static int* eff_mo;
    static int* eff_se;
    static int* teki_mo;
    static int* wait_data;

    // ── RGB color work ────────────────────────────────────────────────────────
    static int R;
    static int G;
    static int B;

    // ── Soft / config ─────────────────────────────────────────────────────────
    static int* soft_id;

    // ── Debug / test flags ────────────────────────────────────────────────────
    static int rock_mu;
    static int teki_mu;
    static int teki_mark;

    // ── Map / field ───────────────────────────────────────────────────────────
    static int eria_cnt;
    static int ata_cnt;
    static int teki_pt;
    static int* teki_ren;

    // ── Encounter data ────────────────────────────────────────────────────────
    static int** e_data;
    static std::string* e_name;

    // ── BGM/SE ────────────────────────────────────────────────────────────────
    static int now_bgm;
    static AudioPresenter** m_audio;
    static AudioPresenter** m_audio_se;
    static int* se_set;
    static int* se_flg;
    static int* now_se;
    static int* now_se_flg;
    static int* now_se_cnt;

    // ── Font / strings ────────────────────────────────────────────────────────
    static std::string str;
    static std::string* waza_str;
    static std::string* map_str;
    static std::string* t_str;
    static std::string* o_str;
    static std::string* m_name;
    static std::string* p_name;

    // ── Skill effects ─────────────────────────────────────────────────────────
    static int* skill_kouka;

    // ── Sort ──────────────────────────────────────────────────────────────────
    static int sort;
    static int sort_flg;
    static int* sort_list;
    static int* sort_skill;

    // ── Miscellaneous ─────────────────────────────────────────────────────────
    static int ghost;
    static int* navi_flg;
    static int* TIP_MAX;
    static int tmp_hp;
    static int sel_tip;
    static int sel_tip2;

    // ── Static methods called by other classes ────────────────────────────────
    static void MesDraw(int n);
    static void drawImg3(int n, int n2, int x, int y, bool bl);
    static void ImgSuu(int v, int x, int y, int w, int a, int b);
    static void strDraw(const std::string& s, int x, int y);
    static void SortSkill(int n);
    static void AddLib(int n);
    static void PalSet(int n, int n2);
    static int  Ani(int n, int n2, int n3, int n4, int n5, int dx, int dy, int flp);
    static int  AtaNo(int n);
    static void seSet(int n, int n2);
    static void HpDraw(int hp, int x, int y);
};
