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

    // ── Battle state (rika_cnt added) ──────────────────────────────────────────
    static int rika_cnt;

    // ── Static methods called by other classes ────────────────────────────────
    static bool MesDraw(int n);
    static void drawImg3(int n, int n2, int x, int y, bool bl);
    static void ImgSuu(int v, int x, int y, int w, int a, int b);
    static void strDraw(std::string s, int x, int y);
    static void strDrawG(std::string s, int x, int y);
    static void strDrawTG(std::string s, int x, int y);
    static void SortSkill(int n);
    static void AddLib(int n);
    static void PalSet(int n, int n2);
    static int  Ani(int n, int n2, int n3, int n4, int n5, int dx, int dy, int flp);
    static int  AniSe(int ani_id, int ani_pt, int ani_cnt, int x, int y, int dx, int dy, int flp, int se_id, int n3);
    static int  AtaNo(int n);
    static void seSet(int n, int n2);
    static void HpDraw(int hp, int x, int y);
    static void Audio(int n, int n2);
    static void readSP();
    static void writeSP();
    static int  spSave(uint8_t* byArray, int n, int n2);
    static int  spSave(int* nArray, int n, int n2);
    static int  spLoad(uint8_t* byArray, int n, int n2);
    static int  spLoad(int* nArray, int n, int n2);
    static int  intChange(uint8_t* byArray, int n);
    static void sysSave();
    static void sysLoad();
    static void dialogDraw(std::string title, std::string msg);
    static int* sys_dat;
    static int  sys_dat_len;

    // ── Additional static fields (from Java source) ───────────────────────────
    static int gapX;
    static int gapY;
    static int bgm_no;
    static int se_no;
    static int deba_tip_id;
    static int cus_se_flg;
    static int rank_mes_id;
    static int m_syokai_flg;
    static std::string set_str[21];
    static int audio_flg;
    static long long mill;
    static long long fade;
    static int se_check;
    static int play_flg;
    static int kai;
    static int sina_no;
    static int sina_flg;
    static int option_flg;
    static int o_mode;
    static int o_cnt;
    static int fade_cnt;
    static int drop_ene;
    static int sec_cha;
    static int zan;
    static int map_no;
    static int map_x;
    static int map_y;
    static int map_sp;
    static int encount;
    static int move_cnt;
    static int move_flg;
    static int muki;
    static int warp_flg;
    static int warp_cnt;
    static int eff_cnt;
    static int mes_no;
    static int mes_flg;
    static int mes_data;
    static int machi_damy_flg;
    static int hit_flg;
    static int en_flg;
    static int tmp_R;
    static int tmp_G;
    static int tmp_B;
    static int non_esc;
    static int ok_code;
    static int ok_tip;
    static int tip_pt;
    static int key_get;
    static int tmp_m_no;
    static int tmp_m_flg;
    static int mes_id;
    static int mes_cnt;
    static int machi_no;
    static int talk_cnt;
    static int quest_flg;
    static int machi_flg;
    static int machi_sel;
    static int machi_cnt;
    static int machi_move;
    static int rank_flg;
    static int pla_ok;
    static int q_sel;
    static int q_jou;
    static int q_get;
    static int q_cnt;
    static int site_point;
    static int tmp_point;
    static int mes_draw;
    static int shop_syu;
    static int shop_id;
    static int zai_cnt;
    static int in_cnt;
    static int get_tr;
    static int tr_max;
    static int rank_menu;
    static int rank_cnt;
    static int rank_no;
    static int rank_mes;
    static int rank_fol;
    static int face;
    static int ivent_end;
    static int ivent_flg;
    static int ivent_id;
    static int ivent_set;
    static int ivent_cnt;
    static int kouka_flg;
    static int kouka_cnt;
    static int yure;
    static int mail_flg;
    static int mail_cnt;
    static int skill_flg;
    static int yes_no_flg;
    static int jump_ivent;
    static int come_back;
    static int s_hen;
    static int q_hen;
    static int ivent_syu;
    static int talk_cnt2;
    static int menu_no;
    static int back_menu;
    static int menu_sel;
    static int menu_cnt;
    static int menu_flg;
    static int sel_jou;
    static int sel_jou2;
    static int tmp_tip;
    static int fol_cnt;
    static int get_tip;
    static int mail_suu;
    static int mail_open;
    static int skill_suu;
    static int quest_no;
    static int http_error;
    static int d_ene_syu;
    static int d_ene_lv;
    static int list_suu;
    static int que_su;
    static int p_no;
    static int p_no2;
    static int hyo;
    static int ch_no;
    static int g_no;
    static int awa;
    static int plt;
    static int ani_pt;
    static int ani_cnt;
    static int flp;
    static int map_bgm;
    static int port_suu;
    static int pa_no;
    static int pa_start;
    static int pa_cnt;
    static int pa_cnt2;
    static int pa_code_flg;
    static int ren_id;
    static int ren_flg;
    static int* p_siz;
    static int* teki_ren_ptr;
    static int* item_flg;
    static int* tobi_flg;
    static int* chara_flg;
    static int* pa_data;
    static int* m_data;
    static int* m_ene;
    static int* m_warp;
    static int* m_item;
    static int* m_tobi;
    static int* m_chara;
    static int* p_pat;
    static int* p_col;
    static int* ene_set;
    static int* mes;
    static int* talk_flg;
    static int* move_ok;
    static int* plg_ok;
    static int* m_move;
    static int* m_ivent;
    static int* m_plg;
    static int* i_chara;
    static int* r_ivent;
    static int* q_flg;
    static int* q_list;
    static int* sh_syu;
    static int* sh_id;
    static int* sh_kin;
    static int* sh_list;
    static int (*sh_zai)[12];
    static int* set_t;
    static int* tr_list;
    static int* r_jun;
    static int* r_sco;
    static std::string* r_name;
    static int* r_id;
    static int* sco_cnt;
    static int* sco;
    static int* r_tip;
    static int* r_map;
    static int* r_ene;
    static int* i_id;
    static int* talk_ch;
    static int* i_set;
    static int* i_x;
    static int* i_y;
    static int* i_data;
    static int* i_cnt;
    static int* i_siz;
    static int* face_x;
    static int* face_dx;
    static int* get_tip2;
    static int* get_list;
    static int* q_data;
    static std::string* q_str;
    static int* s_pos;
    static int* fol_data;
    static int* list_data;
    static int* img_siz3;
    static std::string* q_txt;
    static Image** image_add;
    static std::string q_str2;
    static std::string DomeUrl;
    static std::string Ver;
    static std::string AppID;
    static std::string url;
    static std::string* menu_str;
    static std::string* soft_str;
    static int* pa_tip;
    static std::string* r_str;
    static std::string* t_str2;
    static long long audio_mill;
    static int* fol_d;

    // ── Constructor / primary game loop ──────────────────────────────────────
    CpCanvas();
    void exe();
    void paint(Graphics* graphics);
    void waku();

    // ── Game scene / utility methods ─────────────────────────────────────────
    static void Wait(int n);
    static void DrawBar(int n, int n2);
    static void Soft(int n, int n2);
    static int  CGI(int n, int n2);
    static void NetData();
    static int  GetRank(int n, int n2);
    static std::vector<uint8_t> GetQstr(int n);
    static std::vector<uint8_t> GetData(int n);
    static void DataSave(int n);
    static void SetFlg(int n);
    static void PASet();
    static void EneSet(int n, int n2);
    static void Title2();
    static void Title();
    static void Option();
    static bool MesFlg();
    static void Test();
    static void BattleMain();
    static void MotionBack();
    static int  BasLv();
    static void Ann(int n, int n2);
    static void CharaDraw(int n);
    static void BattleTip();
    static bool EscCh();
    static void CasOk();
    static bool CasCh(int n);
    static void TipIn();
    static int  PACh();
    static int  PaNo(int n, int n2, int n3, int n4);
    static void MldSet();
    static void ImgSet2(int n);
    static void ImgSet();
    static std::vector<uint8_t> JarGet(int n);
    static int  Ani(int n, int n2, int n3, int n4, int n5);
    static void BtSet(int n);
    static void TipSet();
    static void FieldMain();
    static void AriaName();
    static void EnEff(int n);
    static int  MoveChack(int n, int n2);
    static int  TobiCh(int n, int n2, int n3, int n4, int n5);
    static bool PaneHit(int n);
    static void MapSet(int n, int n2);
    static void ObjDraw(int n);
    static void MapDraw(int n, int n2);
    static void EnSet();
    static void MesChack();
    static void MesRead(int n, uint8_t* byArray, int n2);
    static int  MesNo(int n);
    static bool MesDraw2(int n, int n2, int n3, int n4);
    static void Machi();
    static void Basyo(std::string s, int n, int n2);
    static bool PlgEfe(int n, int n2);
    static void MachiSet(int n, int n2);
    static void RockIventSet();
    static void Keiji();
    static void Shop();
    static void Trader();
    static void Ranking();
    static void ZokuMain();
    static void Menu();
    static void sePlay();
    static void drawImg2(int n, int n2, int n3, int n4, int n5, int n6, int n7);
    static void drawImg2(int n, int n2, int n3, int n4, int n5);
    static void drawImg4(int n, int n2, int n3, int n4);
    static void FaceDraw(int n);
    static int  FaceDrawA(int a, int b, int c, int d);
    static void IventRead(int n, int n2);
    static int  IventMain();
    static void imgAddDraw(int n, int x, int y);
    static int  CharaCnt();
    static int  GetItem(int n, int n2, int n3);
    static std::string ItemName(int n, int n2);
    static void Load(int n);
    static void Save(int n);
    static void SkillRun(int n);
    static void ListSort(int n);
    static void MakeRank(int n);
    static void GetScenario(int n);
    static void QMake();
    static void MakeTr();
    static void ReadTr(int n);
    static int  QNo();
    static void QClear();
    static void QAll();
    static void GetQTit();
    static void QDawn(int n, int n2);
    static int  getKeypadState();
    static void SetUp();
    static bool qestOK(int n, uint8_t* byArray);
    static std::vector<uint8_t> qestGet(int n, uint8_t* byArray);
    static std::vector<uint8_t> qestNo(int n, uint8_t* byArray);
    static void dataMldGet();
    static void mldAddDL();
    static void urlSet();
    static void init(int n = 0);

    // ── Instance methods ──────────────────────────────────────────────────────
    void MakeSh();
    void ReadSh(int n);
    void ShSort();
    void TrIO(int n);
    int  GetTr(int n);
    void MakeZoku();
    void IventSet(int n);
    int  Ivent(int n);
    void Kouka(int n);
    void FaceDraw2(int n, int n2, int n3);
    void MenuMake(int n);
    void MakeSort();
    void CasBack(int n);
    int  FolCustom(int n, int n2, int n3);
    void processEvent(int n, int n2);
    void QGard(int n);
    void imgAddSet();
    void seDraw();
    void syokai();
    void mldAddSet();
    void verSave(std::string str_, int n);
    std::string verLaod(int n);
};
