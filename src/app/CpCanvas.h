#pragma once
#include "Types.h"
#include "Tip.h"
#include "Waza.h"
#include "Skill.h"
#include "Mail.h"
#include "BtPanel.h"
#include "Edit.h"
#include "Folder.h"
#include "Okimono.h"
#include "Attack.h"
#include "Ene.h"
#include "Rock.h"
#include <string>
#include <vector>

/* =========================================================
 * CpCanvas - main game class
 * ========================================================= */
class CpCanvas {
public:
    /* ------- constants ------- */
    static const int DATA_SUU  = 37;
    static const int IMG_SUU1  = 42;
    static const int IMG_SUU2  = 16;
    static const int IMG_SUU3  = 22;
    static const int IMG_SUU   = 59;
    static const int SOUND_SUU = 16;
    static const int BGM_SUU   = 11;
    static const int GAMEN_X   = 240;
    static const int GAMEN_Y   = 240;
    static const int BT_OFF_X  = 0;
    static const int BT_OFF_Y  = 105;
    static const int BT_SIZE_X = 40;
    static const int BT_SIZE_Y = 24;
    static const int ATA_MAX   = 30;
    static const int ROCK_WAZA = 188;
    static const int TEKI_WAZA = 77;
    static const int WAZA_MAX  = 265;
    static const int SKILL_SUU = 29;
    static const int TIP_SUU   = 213;
    static const int STAN_TIP  = 123;
    static const int MEGA_TIP  = 52;
    static const int GIGA_TIP  = 4;
    static const int PA_TIP    = 28;
    static const int SAVE_DATA = 437;
    static const int ROCK_MO   = 22;
    static const int EFF_MO    = 148;
    static const int TEKI_MO   = 22;
    static const int AD_TOP    = 3396;
    static const int BGM_MAX   = 11;
    static const int SE_MAX    = 19;
    static const int MLD_MAX   = 30;

    /* ------- game objects ------- */
    static Ene     ene[3];
    static Okimono *oki;       /* oki[6] */
    static BtPanel  panel[3][6];
    static Folder  *fol;       /* fol[6] */
    static Tip      tip_obj[TIP_SUU];  /* tip[] renamed to tip_obj */
    static Attack  *ata;       /* ata[ATA_MAX], new Attack[ATA_MAX] */
    static Waza   **waza;      /* waza[WAZA_MAX], array of Waza pointers */
    static Mail   **mail;      /* mail[30], array of Mail pointers */
    static Skill  **skill;     /* skill[SKILL_SUU], array of Skill pointers */
    static Rock    *rock;      /* the player */

    /* Images */
    static PlatImage *image[IMG_SUU];
    static PlatImage *image_add[10];
    static PlatPalette *pal[IMG_SUU];

    /* Audio */
    static PlatAudio *audio[SOUND_SUU + BGM_SUU];
    static PlatAudio *m_audio[BGM_MAX];
    static PlatAudio *m_audio_se[SE_MAX];
    static PlatSound *se_sounds[MLD_MAX];

    /* ------- static game state fields ------- */
    static int  deba_flg;
    static int  audio_flg;
    static int  game_cnt;
    static int  scene;
    static int  se_check;
    static int  play_flg;
    static long long mill;
    static long long fade;
    static int  kai;
    static int  key;
    static int  okey;
    static int  key_cnt;
    static int *tip_list;       /* tip_list[TIP_SUU*2] */
    static int *skill_list;     /* skill_list[SKILL_SUU*2] */
    static int *dat;            /* dat[100] */
    static int  score;
    static int  user_id;
    static int  sina_no;
    static int  sina_flg;
    static int  item_flg[20][2];
    static int  tobi_flg[20][2];
    static int  chara_flg[40][2];
    static int  pa_data[50][4];
    static int  mode;
    static int  mode2;
    static int  option_flg;
    static int  o_mode;
    static int  o_cnt;
    static int  teki_pt;
    static int  teki_ren[10][4];
    static int  ren_id;
    static int  ren_flg;
    static int  cus_gage;
    static int  cus_sp;
    static int  fade_cnt;
    static int  stop_time;
    static int  stop_cnt;
    static int  eff_id;
    static std::string stop_name;
    static int  win_flg;
    static int  boss_flg;
    static int  ene_cnt;
    static int  dell_cnt;
    static int  bas_flg;
    static int  bas_lv;
    static int  bas_cnt;
    static int  bt_get[10];
    static long long audio_mill;
    static int  over_cnt;
    static int  over_flg;
    static int  wana_flg;
    static int  wana_pow[6];
    static int  combo;
    static int  combo_cnt;
    static int  combo_time;
    static int  stop_ch;
    static int  dell_lv;
    static int  cas_tip[10];
    static int  fol_tip_no[10];
    static int  set_tip[10];
    static int  sel_cas_mode;
    static int  sel_cas_tip;
    static int  max_sel;
    static int  sel_cnt;
    static int  now_code;
    static int  sel_code[5];
    static int  cas_ok[10];
    static int  cas_cnt;
    static int  regu_flg;
    static int  esc_flg;
    static int  fol_d[10];
    static int  pa_no;
    static int  pa_start;
    static int  pa_cnt;
    static int  pa_cnt2;
    static int  pa_tip[20];
    static int  pa_code_flg;
    static int  ata_cnt;

    /* Sprite data arrays - big, loaded from scratchpad */
    static int **gx;   /* gx[IMG_SUU][*] */
    static int **gy;
    static int **sx;
    static int **sy;
    static int **dx;
    static int **dy;
    static int ***ani;   /* ani[IMG_SUU][*][*] */
    static int ***a_dx;
    static int ***a_dy;

    static std::string str;
    static int *p_siz;
    static int  drop_ene;
    static int  eria_cnt;
    static int  sec_cha;
    static int  zan;
    static int  map_no;
    static int  map_x;
    static int  map_y;
    static int  ivent_flg;
    static int  ivent_id;
    static int  ivent_set;
    static int  ivent_cnt;
    static int  i_id[20];
    static int  talk_ch[6];
    static int  kouka_flg;
    static int  kouka_cnt;
    static int  yure;
    static int  mail_flg;
    static int  mail_cnt;
    static int  skill_flg;
    static int  yes_no_flg;
    static int  jump_ivent;
    static int  navi_flg[4];
    static int  come_back;
    static int  i_set[10];
    static int  i_x[10];
    static int  i_y[10];
    static int  s_hen;
    static int  q_hen;
    static int  now_bgm;
    static int  i_data[200];
    static int  i_cnt[10];
    static int  i_siz[10][2];
    static int  ivent_syu;
    static int  talk_cnt2;
    static int  face_x[8][2];
    static int  face_dx[8];
    static int  menu_no;
    static int  back_menu;
    static int  menu_sel;
    static int  menu_cnt;
    static int  menu_flg;
    static int  sel_tip;
    static int  sel_tip2;
    static int  sel_jou;
    static int  sel_jou2;
    static int  tmp_tip;
    static int  sort_v;   /* 'sort' is keyword in some contexts */
    static int  fol_cnt;
    static int  TIP_MAX[5];
    static int  ata_lv;
    static int  cha_lv;
    static int  max_hp;
    static int  now_hp;
    static int  zenny;
    static int  piece;
    static int  full_ene;
    static int  now_fol;
    static int  fol_suu;
    static int  regu_you;
    static int  get_tip;
    static int *get_tip2;
    static int *get_list;
    static int *sort_list;
    static int *sort_skill;
    static int  mail_suu;
    static int  mail_open;
    static int  skill_suu;
    static unsigned char *q_data;
    static std::string *q_str;
    static int  quest_no;
    static int  http_error;
    static int  s_pos[20];
    static std::string url;
    static int  skill_kouka[15];
    static int  sort_flg;
    static int  m_max;
    static int  g_max;
    static int  d_ene_syu;
    static int  d_ene_lv;
    static int  rock_mu;
    static int  teki_mu;
    static int  teki_mark;
    static int  list_suu;
    static int *fol_data;
    static int *list_data;
    static int  que_su;
    static int  p_no;
    static int  p_no2;
    static int  hyo;
    static int  ch_no;
    static int  g_no;
    static int  awa;
    static int  plt;
    static int  ani_pt_g;
    static int  ani_cnt_g;
    static int  flp;
    static int *img_siz3;
    static int  rika_cnt;
    static int  ghost;
    static int  map_bgm;
    static std::string *q_txt;
    static int  port_suu;
    static int *se_set;
    static int *se_flg;
    static int *now_se;
    static int *now_se_flg;
    static int *now_se_cnt;
    static int *sys_dat;   /* sys_dat[255] */
    static std::string DomeUrl;
    static std::string Ver;
    static std::string AppID;

    /* wait animation data */
    static int *wait_data;   /* wait_data[N*5] */
    static int *rock_mo;     /* rock_mo[ROCK_MO*6] */
    static int *eff_mo;      /* eff_mo[EFF_MO*6] */
    static int *sh_syu;
    static int *sh_id;
    static int *sh_kin;
    static int  sh_zai[8][12];
    static int  shop_syu;

    /* soft key labels */
    static int  soft_id[2];

    /* SEPlay state */
    static int  now_se_buf[19];
    static int  se_buf_flg[19];

    /* ------------------------------------------------------------------ */
    /* Methods                                                               */
    /* ------------------------------------------------------------------ */
    CpCanvas();
    void exe();
    void SetUp();
    void readSP();
    void writeSP();

    /* Scene methods */
    void Title();
    void Title2();
    void Test();
    void BattleMain();
    void BattleTip();
    void FieldMain();
    void Menu();
    void Machi();
    void Keiji();
    void Shop();
    void Trader();
    void Ranking();
    void ZokuMain();

    /* Initialization */
    void ImgSet();
    void ImgSet2(int n);
    void imgAddSet();
    void MldSet();
    void PASet();
    void TipSet();
    void WazaSet();
    void SkillSet();
    void MailSet();
    void FolSet();
    void ScenarioSet(int n);
    void QuestSet(int n);
    void BtPanelSet();
    void RandSet();

    /* Drawing */
    static void strDraw(const std::string &s, int x, int y);
    void imgAddDraw(int n, int x, int y);
    static void drawImg(int n, int x, int y, bool flip);
    static void drawImg2(int n, int x, int y, int scale, int alpha);
    static void drawImg3(int img_no, int n, int x, int y, bool flip);
    static int  Ani(int img_no, int pt, int cnt, int px, int py, int dx, int dy, int flip);
    static void HpDraw(int hp, int x, int y);
    static void PalSet(int n, int pal_no);
    static void AddLib(int n);

    /* Resource loading */
    static InputStream *JarGet(int n);
    static InputStream *GetData(int n);
    static int dataGet(const std::string &url, unsigned char *buf);

    /* Game logic */
    static int  AtaNo(int n);
    static void MesRead(int n, const unsigned char *data, int type);
    static bool MesFlg();
    static void MesDraw(int n);
    static int  intChange(const unsigned char *b, int off);

    /* Audio */
    static void Audio(int type, int n);
    static void sePlay();
    void Soft(int n, int id);

    /* Save/Load */
    static int  spSave(const unsigned char *data, int pos, int len);
    static int  spSave(const int *nArray, int pos, int len);
    static int  spLoad(unsigned char *data, int pos, int len);
    static int  spLoad(int *nArray, int pos, int len);
    static InputStream *spLoad_stream(int pos, int len);
    static void sysSave();
    static void sysLoad();

    /* Utilities */
    static void SortSkill(int n);
    static void SortTip(int mode, int dir);
    static void SortFol(int n, int fol_id);
    void GetScenario(int n);
    void BtSet(int n);
    void Wait(int n);
    void NetData();
    void mldAddSet();
    int  mldAddDL();
    void ShSort();
    void ShSet(int n);
    std::string numStr(int n);
    std::string numStr2(int n, int digits);
    static int rand_next();
    void kidou();
    std::string verLaod(int n);
    void verSave(const std::string &v, int n);
    void urlSet();
    void QGard(int n);

    /* Random number generator (Java-compatible) */
    static long long rand_seed;
    static int nextInt();

    /* Instance fields */
    int bgm_no;
    int se_no;
    int deba_tip_id;
    int cus_se_flg;
    int rank_mes_id;
    int m_syokai_flg;
    PlatSound *se_inst[MLD_MAX];

    /* More complex fields */
    static std::string set_str[10];
    int gapX;
    int gapY;
    /* waza move data */
    static int *waza_mo;
};

/* Folder class definition (small, forward-declared above) */
#include "Folder.h"

