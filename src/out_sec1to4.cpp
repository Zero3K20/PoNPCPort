#include "CpCanvas_fwd.h"
#include "Attack.h"
#include "BtPanel.h"
#include "Edit.h"
#include "Ene.h"
#include "Folder.h"
#include "Mail.h"
#include "Okimono.h"
#include "Rock.h"
#include "Skill.h"
#include "Tip.h"
#include "Waza.h"
#include "CpDataDownload.h"
#include "../platform/Font.h"
#include "../platform/Input.h"
#include "../platform/Resources.h"
#include <cstring>
#include <ctime>
#include <algorithm>
#include <SDL2/SDL.h>

// ==================== Static member definitions ====================
// From CpCanvas_fwd.h
int CpCanvas::deba_flg = 0;
std::mt19937 CpCanvas::rand{std::random_device{}()};
Rock* CpCanvas::rock = nullptr;
Ene** CpCanvas::ene = nullptr;
Okimono** CpCanvas::oki = nullptr;
BtPanel** CpCanvas::panel = nullptr;
Folder** CpCanvas::fol = nullptr;
Tip** CpCanvas::tip = nullptr;
Attack** CpCanvas::ata = nullptr;
Waza** CpCanvas::waza = nullptr;
Mail** CpCanvas::mail = nullptr;
Skill** CpCanvas::skill = nullptr;
Edit* CpCanvas::edit = nullptr;
Graphics* CpCanvas::g = nullptr;
Image* CpCanvas::imgMap = nullptr;
Image* CpCanvas::tmp_imgMap = nullptr;
Graphics* CpCanvas::graMap = nullptr;
Graphics* CpCanvas::tmp_graMap = nullptr;
Image** CpCanvas::imgMap2 = nullptr;
Graphics** CpCanvas::graMap2 = nullptr;
Font* CpCanvas::f = nullptr;
int CpCanvas::game_cnt = 0;
int CpCanvas::scene = 0;
PalettedImage** CpCanvas::image = nullptr;
Image* CpCanvas::dmy_image = nullptr;
Palette** CpCanvas::pal = nullptr;
AudioPresenter** CpCanvas::audio = nullptr;
int CpCanvas::key = 0;
int CpCanvas::okey = 0;
int CpCanvas::key_cnt = 0;
int CpCanvas::key2 = 0;
int* CpCanvas::tip_list = nullptr;
int* CpCanvas::skill_list = nullptr;
int* CpCanvas::dat = nullptr;
int CpCanvas::score = 0;
int CpCanvas::user_id = 0;
int CpCanvas::max_hp = 0;
int CpCanvas::now_hp = 0;
int CpCanvas::zenny = 0;
int CpCanvas::piece = 0;
int CpCanvas::now_fol = 0;
int CpCanvas::fol_suu = 0;
int CpCanvas::ata_lv = 0;
int CpCanvas::cha_lv = 0;
int CpCanvas::regu_you = 0;
int CpCanvas::full_ene = 0;
int CpCanvas::mode = 0;
int CpCanvas::mode2 = 0;
int CpCanvas::boss_flg = 0;
int CpCanvas::ene_cnt = 0;
int CpCanvas::dell_cnt = 0;
int CpCanvas::over_cnt = 0;
int CpCanvas::over_flg = 0;
int CpCanvas::cus_gage = 0;
int CpCanvas::cus_sp = 0;
int CpCanvas::stop_time = 0;
int CpCanvas::stop_cnt = 0;
int CpCanvas::stop_ch = 0;
int CpCanvas::eff_id = 0;
std::string CpCanvas::stop_name = "";
int CpCanvas::win_flg = 0;
int CpCanvas::bas_flg = 0;
int CpCanvas::bas_lv = 0;
int CpCanvas::bas_cnt = 0;
int* CpCanvas::bt_get = nullptr;
int CpCanvas::wana_flg = 0;
int* CpCanvas::wana_pow = nullptr;
int CpCanvas::combo = 0;
int CpCanvas::combo_cnt = 0;
int CpCanvas::combo_time = 0;
int CpCanvas::dell_lv = 0;
int* CpCanvas::cas_tip = nullptr;
int* CpCanvas::fol_tip_no = nullptr;
int* CpCanvas::set_tip = nullptr;
int CpCanvas::sel_cas_mode = 0;
int CpCanvas::sel_cas_tip = 0;
int CpCanvas::max_sel = 0;
int CpCanvas::sel_cnt = 0;
int CpCanvas::now_code = 0;
int* CpCanvas::sel_code = nullptr;
int* CpCanvas::cas_ok = nullptr;
int CpCanvas::cas_cnt = 0;
int CpCanvas::regu_flg = 0;
int CpCanvas::esc_flg = 0;
int CpCanvas::m_max = 0;
int CpCanvas::g_max = 0;
int*** CpCanvas::ani = nullptr;
int*** CpCanvas::a_dx = nullptr;
int*** CpCanvas::a_dy = nullptr;
int** CpCanvas::gx = nullptr;
int** CpCanvas::gy = nullptr;
int** CpCanvas::sx = nullptr;
int** CpCanvas::sy = nullptr;
int** CpCanvas::dx = nullptr;
int** CpCanvas::dy = nullptr;
int* CpCanvas::rock_mo = nullptr;
int* CpCanvas::eff_mo = nullptr;
int* CpCanvas::eff_se = nullptr;
int* CpCanvas::teki_mo = nullptr;
int* CpCanvas::wait_data = nullptr;
int CpCanvas::R = 0;
int CpCanvas::G = 0;
int CpCanvas::B = 0;
int* CpCanvas::soft_id = nullptr;
int CpCanvas::rock_mu = 0;
int CpCanvas::teki_mu = 0;
int CpCanvas::teki_mark = 0;
int CpCanvas::eria_cnt = 0;
int CpCanvas::ata_cnt = 0;
int CpCanvas::teki_pt = 0;
int* CpCanvas::teki_ren = nullptr;
int** CpCanvas::e_data = nullptr;
std::string* CpCanvas::e_name = nullptr;
int CpCanvas::now_bgm = 0;
AudioPresenter** CpCanvas::m_audio = nullptr;
AudioPresenter** CpCanvas::m_audio_se = nullptr;
int* CpCanvas::se_set = nullptr;
int* CpCanvas::se_flg = nullptr;
int* CpCanvas::now_se = nullptr;
int* CpCanvas::now_se_flg = nullptr;
int* CpCanvas::now_se_cnt = nullptr;
std::string CpCanvas::str = "";
std::string* CpCanvas::waza_str = nullptr;
std::string* CpCanvas::map_str = nullptr;
std::string* CpCanvas::t_str = nullptr;
std::string* CpCanvas::o_str = nullptr;
std::string* CpCanvas::m_name = nullptr;
std::string* CpCanvas::p_name = nullptr;
int* CpCanvas::skill_kouka = nullptr;
int CpCanvas::sort = 0;
int CpCanvas::sort_flg = 0;
int* CpCanvas::sort_list = nullptr;
int* CpCanvas::sort_skill = nullptr;
int CpCanvas::ghost = 0;
int* CpCanvas::navi_flg = nullptr;
int* CpCanvas::TIP_MAX = nullptr;
int CpCanvas::tmp_hp = 0;
int CpCanvas::sel_tip = 0;
int CpCanvas::sel_tip2 = 0;
int CpCanvas::rika_cnt = 0;

// Additional static fields from Java source
int CpCanvas::gapX = 0;
int CpCanvas::gapY = 0;
int CpCanvas::bgm_no = 0;
int CpCanvas::se_no = 0;
int CpCanvas::deba_tip_id = 0;
int CpCanvas::cus_se_flg = 0;
int CpCanvas::rank_mes_id = 0;
int CpCanvas::m_syokai_flg = 0;
std::string CpCanvas::set_str[21] = {};
int CpCanvas::audio_flg = 0;
long long CpCanvas::mill = 0;
long long CpCanvas::fade = 0;
int CpCanvas::se_check = 0;
int CpCanvas::play_flg = 0;
int CpCanvas::kai = 0;
int CpCanvas::sina_no = 0;
int CpCanvas::sina_flg = 0;
int CpCanvas::option_flg = 0;
int CpCanvas::o_mode = 0;
int CpCanvas::o_cnt = 0;
int CpCanvas::fade_cnt = 0;
int CpCanvas::drop_ene = 0;
int CpCanvas::sec_cha = 0;
int CpCanvas::zan = 0;
int CpCanvas::map_no = 0;
int CpCanvas::map_x = 0;
int CpCanvas::map_y = 0;
int CpCanvas::map_sp = 0;
int CpCanvas::encount = 0;
int CpCanvas::move_cnt = 0;
int CpCanvas::move_flg = 0;
int CpCanvas::muki = 0;
int CpCanvas::warp_flg = 0;
int CpCanvas::warp_cnt = 0;
int CpCanvas::eff_cnt = 0;
int CpCanvas::mes_no = 0;
int CpCanvas::mes_flg = 0;
int CpCanvas::mes_data = 0;
int CpCanvas::machi_damy_flg = 0;
int CpCanvas::hit_flg = 0;
int CpCanvas::en_flg = 0;
int CpCanvas::tmp_R = 0;
int CpCanvas::tmp_G = 0;
int CpCanvas::tmp_B = 0;
int CpCanvas::non_esc = 0;
int CpCanvas::ok_code = 0;
int CpCanvas::ok_tip = 0;
int CpCanvas::tip_pt = 0;
int CpCanvas::key_get = 0;
int CpCanvas::tmp_m_no = 0;
int CpCanvas::tmp_m_flg = 0;
int CpCanvas::mes_id = 0;
int CpCanvas::mes_cnt = 0;
int CpCanvas::machi_no = 0;
int CpCanvas::talk_cnt = 0;
int CpCanvas::quest_flg = 0;
int CpCanvas::machi_flg = 0;
int CpCanvas::machi_sel = 0;
int CpCanvas::machi_cnt = 0;
int CpCanvas::machi_move = 0;
int CpCanvas::rank_flg = 0;
int CpCanvas::pla_ok = 0;
int CpCanvas::q_sel = 0;
int CpCanvas::q_jou = 0;
int CpCanvas::q_get = 0;
int CpCanvas::q_cnt = 0;
int CpCanvas::site_point = 0;
int CpCanvas::tmp_point = 0;
int CpCanvas::mes_draw = 0;
int CpCanvas::shop_syu = 0;
int CpCanvas::shop_id = 0;
int CpCanvas::zai_cnt = 0;
int CpCanvas::in_cnt = 0;
int CpCanvas::get_tr = 0;
int CpCanvas::tr_max = 0;
int CpCanvas::rank_menu = 0;
int CpCanvas::rank_cnt = 0;
int CpCanvas::rank_no = 0;
int CpCanvas::rank_mes = 0;
int CpCanvas::rank_fol = 0;
int CpCanvas::face = 0;
int CpCanvas::ivent_end = 0;
int CpCanvas::ivent_flg = 0;
int CpCanvas::ivent_id = 0;
int CpCanvas::ivent_set = 0;
int CpCanvas::ivent_cnt = 0;
int CpCanvas::kouka_flg = 0;
int CpCanvas::kouka_cnt = 0;
int CpCanvas::yure = 0;
int CpCanvas::mail_flg = 0;
int CpCanvas::mail_cnt = 0;
int CpCanvas::skill_flg = 0;
int CpCanvas::yes_no_flg = 0;
int CpCanvas::jump_ivent = 0;
int CpCanvas::come_back = 0;
int CpCanvas::s_hen = 0;
int CpCanvas::q_hen = 0;
int CpCanvas::ivent_syu = 0;
int CpCanvas::talk_cnt2 = 0;
int CpCanvas::menu_no = 0;
int CpCanvas::back_menu = 0;
int CpCanvas::menu_sel = 0;
int CpCanvas::menu_cnt = 0;
int CpCanvas::menu_flg = 0;
int CpCanvas::sel_jou = 0;
int CpCanvas::sel_jou2 = 0;
int CpCanvas::tmp_tip = 0;
int CpCanvas::fol_cnt = 0;
int CpCanvas::get_tip = 0;
int CpCanvas::mail_suu = 0;
int CpCanvas::mail_open = 0;
int CpCanvas::skill_suu = 0;
int CpCanvas::quest_no = 0;
int CpCanvas::http_error = 0;
int CpCanvas::d_ene_syu = 0;
int CpCanvas::d_ene_lv = 0;
int CpCanvas::list_suu = 0;
int CpCanvas::que_su = 0;
int CpCanvas::p_no = 0;
int CpCanvas::p_no2 = 0;
int CpCanvas::hyo = 0;
int CpCanvas::ch_no = 0;
int CpCanvas::g_no = 0;
int CpCanvas::awa = 0;
int CpCanvas::plt = 0;
int CpCanvas::ani_pt = 0;
int CpCanvas::ani_cnt = 0;
int CpCanvas::flp = 0;
int CpCanvas::map_bgm = 0;
int CpCanvas::port_suu = 0;
int CpCanvas::pa_no = 0;
int CpCanvas::pa_start = 0;
int CpCanvas::pa_cnt = 0;
int CpCanvas::pa_cnt2 = 0;
int CpCanvas::pa_code_flg = 0;
int CpCanvas::ren_id = 0;
int CpCanvas::ren_flg = 0;
int* CpCanvas::p_siz = nullptr;
int* CpCanvas::teki_ren_ptr = nullptr;
int* CpCanvas::item_flg = nullptr;
int* CpCanvas::tobi_flg = nullptr;
int* CpCanvas::chara_flg = nullptr;
int* CpCanvas::pa_data = nullptr;
int* CpCanvas::m_data = nullptr;
int* CpCanvas::m_ene = nullptr;
int* CpCanvas::m_warp = nullptr;
int* CpCanvas::m_item = nullptr;
int* CpCanvas::m_tobi = nullptr;
int* CpCanvas::m_chara = nullptr;
int* CpCanvas::p_pat = nullptr;
int* CpCanvas::p_col = nullptr;
int* CpCanvas::ene_set = nullptr;
int* CpCanvas::mes = nullptr;
int* CpCanvas::talk_flg = nullptr;
int* CpCanvas::move_ok = nullptr;
int* CpCanvas::plg_ok = nullptr;
int* CpCanvas::m_move = nullptr;
int* CpCanvas::m_ivent = nullptr;
int* CpCanvas::m_plg = nullptr;
int* CpCanvas::i_chara = nullptr;
int* CpCanvas::r_ivent = nullptr;
int* CpCanvas::q_flg = nullptr;
int* CpCanvas::q_list = nullptr;
int* CpCanvas::sh_syu = nullptr;
int* CpCanvas::sh_id = nullptr;
int* CpCanvas::sh_kin = nullptr;
int* CpCanvas::sh_list = nullptr;
int* CpCanvas::sh_zai = nullptr;
int* CpCanvas::set_t = nullptr;
int* CpCanvas::tr_list = nullptr;
int* CpCanvas::r_jun = nullptr;
int* CpCanvas::r_sco = nullptr;
std::string* CpCanvas::r_name = nullptr;
int* CpCanvas::r_id = nullptr;
int* CpCanvas::sco_cnt = nullptr;
int* CpCanvas::sco = nullptr;
int* CpCanvas::r_tip = nullptr;
int* CpCanvas::r_map = nullptr;
int* CpCanvas::r_ene = nullptr;
int* CpCanvas::i_id = nullptr;
int* CpCanvas::talk_ch = nullptr;
int* CpCanvas::i_set = nullptr;
int* CpCanvas::i_x = nullptr;
int* CpCanvas::i_y = nullptr;
int* CpCanvas::i_data = nullptr;
int* CpCanvas::i_cnt = nullptr;
int* CpCanvas::i_siz = nullptr;
int* CpCanvas::face_x = nullptr;
int* CpCanvas::face_dx = nullptr;
int* CpCanvas::get_tip2 = nullptr;
int* CpCanvas::get_list = nullptr;
int* CpCanvas::q_data = nullptr;
std::string* CpCanvas::q_str = nullptr;
int* CpCanvas::s_pos = nullptr;
int* CpCanvas::fol_data = nullptr;
int* CpCanvas::list_data = nullptr;
int* CpCanvas::img_siz3 = nullptr;
std::string* CpCanvas::q_txt = nullptr;
Image** CpCanvas::image_add = nullptr;
std::string CpCanvas::q_str2 = "";
std::string CpCanvas::DomeUrl = "";
std::string CpCanvas::Ver = "";
std::string CpCanvas::AppID = "";
std::string CpCanvas::url = "";
std::string* CpCanvas::menu_str = nullptr;
std::string* CpCanvas::soft_str = nullptr;
int* CpCanvas::sys_dat = nullptr;
int* CpCanvas::pa_tip = nullptr;
std::string* CpCanvas::r_str = nullptr;
std::string* CpCanvas::t_str2 = nullptr;
long long CpCanvas::audio_mill = 0;
int* CpCanvas::fol_d = nullptr;


// ==================== Constructor ====================
CpCanvas::CpCanvas() {
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 6; ++j) {
            CpCanvas::panel[i * 6 + j] = new BtPanel();
        }
    }
}

// ==================== paint ====================
void CpCanvas::paint(Graphics* graphics) {
    // empty
}

// ==================== waku ====================
void CpCanvas::waku() {
    CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
    CpCanvas::g->fillRect(-CpCanvas::gapX, -CpCanvas::gapY, 240 + CpCanvas::gapX * 2, CpCanvas::gapY);
    CpCanvas::g->fillRect(-CpCanvas::gapX, 240, 240 + CpCanvas::gapX * 2, CpCanvas::gapY + 1);
    CpCanvas::g->fillRect(-CpCanvas::gapX, 0, CpCanvas::gapX, 240);
    CpCanvas::g->fillRect(240, 0, CpCanvas::gapX, 240);
}

// ==================== exe ====================
void CpCanvas::exe() {
    int n = 15;
    CpCanvas::imgMap = Image::createImage(240, 240);
    CpCanvas::imgMap->setRenderer(CpCanvas::g->renderer);
    CpCanvas::graMap = CpCanvas::imgMap->getGraphics();
    CpCanvas::tmp_imgMap = Image::createImage(240, 240);
    CpCanvas::tmp_imgMap->setRenderer(CpCanvas::g->renderer);
    CpCanvas::tmp_graMap = CpCanvas::tmp_imgMap->getGraphics();
    for (int _i = 0; _i < 9; ++_i) {
        CpCanvas::imgMap2[_i] = Image::createImage(240, (_i < 6) ? 240 : 68);
        CpCanvas::imgMap2[_i]->setRenderer(CpCanvas::g->renderer);
        CpCanvas::graMap2[_i] = CpCanvas::imgMap2[_i]->getGraphics();
    }
    CpCanvas::g->setOrigin(0, 0);
    CpCanvas::f = Font::getFont(0);
    CpCanvas::g->setFont(CpCanvas::f);
    CpCanvas::graMap->setFont(CpCanvas::f);
    {
        auto _d = Resources::jarResource("0.gif");
        if (!_d.empty()) CpCanvas::dmy_image = Image::createFromData(_d.data(), _d.size(), CpCanvas::g->renderer);
    }
    SetUp();
    Audio(1, 0);
    CpCanvas::scene = -2;
    CpCanvas::key = 0;
    CpCanvas::mill = (long long)SDL_GetTicks64();
    while (true) {
        SDL_Delay(1);
        if (!Input::pollEvents()) break;
        CpCanvas::key = Input::getKey();
        Input::clearKey();
        if ((long long)SDL_GetTicks64() - CpCanvas::mill < (long long)(1000 / (n + 1))) continue;
        CpCanvas::mill = (long long)SDL_GetTicks64();
        if (CpCanvas::scene == -2) Title2();
        else if (CpCanvas::scene == -1) Test();
        else if (CpCanvas::scene == 0) Title();
        else if (CpCanvas::scene == 1) BattleMain();
        else if (CpCanvas::scene == 2) BattleTip();
        else if (CpCanvas::scene == 3) FieldMain();
        else if (CpCanvas::scene == 4) Menu();
        else if (CpCanvas::scene == 5) Machi();
        else if (CpCanvas::scene == 6) Keiji();
        else if (CpCanvas::scene == 7) Shop();
        else if (CpCanvas::scene == 8) Trader();
        else if (CpCanvas::scene == 9) Ranking();
        else if (CpCanvas::scene == 10) ZokuMain();
        if (CpCanvas::play_flg != 0) {
            for (int _i = 0; _i < 16; ++_i) CpCanvas::audio[_i]->stop();
            Audio(1, CpCanvas::now_bgm);
            CpCanvas::play_flg = 0;
        }
        waku();
        CpCanvas::g->present();
        sePlay();
        Soft(0, CpCanvas::soft_id[0]);
        Soft(1, CpCanvas::soft_id[1]);
        ++CpCanvas::game_cnt;
    }
}

// ==================== Wait ====================
void CpCanvas::Wait(int n) {
    CpCanvas::mill = (long long)SDL_GetTicks64();
    while ((long long)SDL_GetTicks64() - CpCanvas::mill < (long long)n) {
        SDL_Delay(1);
    }
}

// ==================== DrawBar ====================
void CpCanvas::DrawBar(int n, int n2) {
    CpCanvas::g->fillRect(95, 98 + n * 15, n2, 2);
    if (n2 >= 100) {
        Wait(50);
        CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
        CpCanvas::g->fillRect(85, 95 + n * 15, 240, 12);
        CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 255, 0));
        strDraw(CpCanvas::set_str[4], 90, 105 + n * 15);
        if (n == 3) {
            strDraw(CpCanvas::set_str[4], 100, 90);
        }
        CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 255, 255));
    }
}

// ==================== Soft ====================
void CpCanvas::Soft(int n, int n2) {
    if (CpCanvas::soft_id[2 + n] == n2) {
        return;
    }
    // setSoftLabel(n, soft_str[n2]); // Platform-specific, stub
    CpCanvas::soft_id[2 + n] = n2;
}

// ==================== CGI (stub) ====================
int CpCanvas::CGI(int n, int n2) {
    CpCanvas::http_error = -1;
    return CpCanvas::http_error;
}

// ==================== NetData (stub) ====================
void CpCanvas::NetData() {
    CpCanvas::http_error = -1;
}

// ==================== GetRank (stub) ====================
int CpCanvas::GetRank(int n, int n2) {
    CpCanvas::http_error = -1;
    return -1;
}

// ==================== GetQstr (stub) ====================
std::vector<uint8_t> CpCanvas::GetQstr(int n) {
    CpCanvas::http_error = -1;
    return std::vector<uint8_t>();
}

// ==================== GetData (stub) ====================
std::vector<uint8_t> CpCanvas::GetData(int n) {
    CpCanvas::http_error = -1;
    return Resources::jarGet(n, CpCanvas::dat);
}

// ==================== dataMldGet (stub) ====================
void CpCanvas::dataMldGet() {
    CpCanvas::http_error = -1;
}

// ==================== mldAddDL (stub) ====================
void CpCanvas::mldAddDL() {
    CpCanvas::http_error = -1;
}

// ==================== DataSave (stub) ====================
void CpCanvas::DataSave(int n) {
    CpCanvas::http_error = -1;
}

// ==================== urlSet (stub) ====================
void CpCanvas::urlSet() {
    CpCanvas::http_error = -1;
}


// ==================== init ====================
void CpCanvas::init(int n) {
    CpCanvas::max_sel = 5;
    CpCanvas::ivent_flg = -1;
    CpCanvas::R = 155;
    CpCanvas::G = 255;
    CpCanvas::B = 210;
    RockIventSet();
    if (n == 0) {
        int n2;
        SetFlg(0);
        SetFlg(1);
        CpCanvas::map_no = 0;
        CpCanvas::map_x = 40;
        CpCanvas::map_y = 60;
        CpCanvas::max_hp = 100;
        CpCanvas::now_hp = 100;
        CpCanvas::zenny = 0;
        CpCanvas::piece = 0;
        CpCanvas::full_ene = 1;
        CpCanvas::now_fol = 0;
        CpCanvas::fol_suu = 1;
        CpCanvas::regu_you = 4;
        CpCanvas::get_tip = 0;
        CpCanvas::get_tip2[0] = 0;
        CpCanvas::get_tip2[1] = 0;
        CpCanvas::get_tip2[2] = 0;
        CpCanvas::get_tip2[3] = 0;
        CpCanvas::mail_suu = 0;
        CpCanvas::back_menu = 5;
        CpCanvas::mail_open = 0;
        CpCanvas::now_bgm = -1;
        CpCanvas::skill_suu = 0;
        for (n2 = 0; n2 < 224; ++n2) {
            CpCanvas::get_list[n2] = 0;
        }
        for (n2 = 0; n2 < 4; ++n2) {
            int n3;
            for (n3 = 0; n3 < 30; ++n3) {
                CpCanvas::fol[n2]->tip_id[n3] = 0;
            }
            for (n3 = 0; n3 < 30; ++n3) {
                CpCanvas::fol[n2]->FolSet(n3, CpCanvas::fol_d[n3]);
            }
            CpCanvas::fol[n2]->init();
            CpCanvas::fol[n2]->regu_id = 0;
            CpCanvas::fol[n2]->regu_flg = 0;
        }
        n2 = 0;
        while (n2 < 512) {
            int n4 = n2++;
            CpCanvas::tip_list[n4] = CpCanvas::tip_list[n4] & 0xFFFF;
        }
        n2 = 0;
        while (n2 < 148) {
            int n5 = n2++;
            CpCanvas::skill_list[n5] = CpCanvas::skill_list[n5] & 0xFFFF;
        }
        for (n2 = 0; n2 < 12; ++n2) {
            Edit::set[n2] = 0;
            Edit::set2[n2] = 0;
            Edit::flg[n2] = 0;
        }
        SkillRun(0);
        for (n2 = 0; n2 < 5; ++n2) {
            Edit::zoku[n2] = 0;
        }
        Edit::r_zoku = 0;
        Edit::set_cnt = 0;
        Edit::now_slot = 0;
        Edit::max_slot = 3;
        CpCanvas::quest_flg = 0;
        CpCanvas::machi_no = 0;
        CpCanvas::sina_no = 1;
        CpCanvas::sina_flg = -1;
        CpCanvas::skill_flg = 0;
        CpCanvas::s_hen = 0;
        CpCanvas::q_hen = 0;
        CpCanvas::i_cnt[0] = 0;
        CpCanvas::i_cnt[1] = 0;
        CpCanvas::quest_no = 0;
        CpCanvas::q_get = 0;
        for (n2 = 0; n2 < 10; ++n2) {
            CpCanvas::q_list[n2] = 0;
        }
        CpCanvas::site_point = 0;
        CpCanvas::tmp_point = 0;
        for (n2 = 0; n2 < 22; ++n2) {
            CpCanvas::teki_ren[n2] = 0;
        }
        for (n2 = 0; n2 < 12; ++n2) {
            CpCanvas::navi_flg[n2] = 0;
        }
        for (n2 = 29; n2 >= 0; --n2) {
            CpCanvas::fol_data[n2] = CpCanvas::fol[0]->tip_id[n2];
        }
        CpCanvas::score = 0;
        CpCanvas::dat[58] = 0;
        CpCanvas::dat[59] = 0;
        CpCanvas::dat[60] = 0;
        CpCanvas::dat[61] = 0;
        CpCanvas::dat[62] = 0;
        CpCanvas::dat[63] = 0;
        CpCanvas::sh_zai[0] = 0;
        CpCanvas::q_flg[0] = 0;
        CpCanvas::q_flg[1] = 0;
    }
}

// ==================== SetFlg ====================
void CpCanvas::SetFlg(int n) {
    if (n == 0) {
        int n2;
        try {
            auto _buf = Resources::jarGet(1, CpCanvas::dat);
            int _p = 0;
            auto _ri = [&]() -> int {
                int v = ((int)(uint8_t)_buf[_p]<<24)|((int)(uint8_t)_buf[_p+1]<<16)|((int)(uint8_t)_buf[_p+2]<<8)|(int)(uint8_t)_buf[_p+3];
                _p+=4; return v;
            };
            auto _rb = [&]() -> int { return (int)(uint8_t)_buf[_p++]; };
            for (n2 = 0; n2 < 40; ++n2) {
                if (n2 % 2 == 0) {
                    CpCanvas::move_ok[n2 / 2] = _rb();
                } else {
                    CpCanvas::plg_ok[n2 / 2] = _rb();
                }
            }
        } catch (...) {}
        try {
            auto _buf = Resources::jarGet(2, CpCanvas::dat);
            int _p = 0;
            auto _ri = [&]() -> int {
                int v = ((int)(uint8_t)_buf[_p]<<24)|((int)(uint8_t)_buf[_p+1]<<16)|((int)(uint8_t)_buf[_p+2]<<8)|(int)(uint8_t)_buf[_p+3];
                _p+=4; return v;
            };
            for (n2 = 0; n2 < 20; n2 += 2) {
                int n3 = _ri();
                CpCanvas::talk_flg[(n2 + 1) * 4 + 0] = n3 & 0xF;
                CpCanvas::talk_flg[(n2 + 1) * 4 + 1] = (n3 >> 4) & 0xF;
                CpCanvas::talk_flg[(n2 + 1) * 4 + 2] = (n3 >> 8) & 0xF;
                CpCanvas::talk_flg[(n2 + 1) * 4 + 3] = (n3 >> 12) & 0xF;
                CpCanvas::talk_flg[n2 * 4 + 0] = (n3 >> 16) & 0xF;
                CpCanvas::talk_flg[n2 * 4 + 1] = (n3 >> 20) & 0xF;
                CpCanvas::talk_flg[n2 * 4 + 2] = (n3 >> 24) & 0xF;
                CpCanvas::talk_flg[n2 * 4 + 3] = (int)((unsigned int)n3 >> 28) & 0xF;
            }
            CpCanvas::talk_flg[20 * 4 + 0] = 1;
        } catch (...) {}
    } else {
        try {
            auto _buf = Resources::jarGet(4, CpCanvas::dat);
            int _p = 0;
            auto _ri = [&]() -> int {
                int v = ((int)(uint8_t)_buf[_p]<<24)|((int)(uint8_t)_buf[_p+1]<<16)|((int)(uint8_t)_buf[_p+2]<<8)|(int)(uint8_t)_buf[_p+3];
                _p+=4; return v;
            };
            for (int i = 0; i < 69; ++i) {
                int n4 = _ri();
                CpCanvas::item_flg[i * 4 + 0] = n4 & 1;
                CpCanvas::item_flg[i * 4 + 1] = (n4 >> 1) & 1;
                CpCanvas::item_flg[i * 4 + 2] = (n4 >> 2) & 1;
                CpCanvas::item_flg[i * 4 + 3] = (n4 >> 3) & 1;
                CpCanvas::tobi_flg[i * 2 + 0] = (n4 >> 4) & 3;
                CpCanvas::tobi_flg[i * 2 + 1] = (n4 >> 6) & 3;
                CpCanvas::chara_flg[i * 4 + 0] = (n4 >> 8) & 3;
                CpCanvas::chara_flg[i * 4 + 1] = (n4 >> 10) & 3;
                CpCanvas::chara_flg[i * 4 + 2] = (n4 >> 12) & 3;
                CpCanvas::chara_flg[i * 4 + 3] = (n4 >> 14) & 3;
            }
        } catch (...) {}
    }
}

// ==================== PASet ====================
void CpCanvas::PASet() {
    try {
        auto _buf = Resources::jarGet(20, CpCanvas::dat);
        int _p = 0;
        auto _rb = [&]() -> int { return (int)(uint8_t)_buf[_p++]; };
        auto _ri = [&]() -> int {
            int v = ((int)(uint8_t)_buf[_p]<<24)|((int)(uint8_t)_buf[_p+1]<<16)|((int)(uint8_t)_buf[_p+2]<<8)|(int)(uint8_t)_buf[_p+3];
            _p+=4; return v;
        };
        for (int i = 0; i < 34; ++i) {
            CpCanvas::pa_data[i * 9 + 0] = _rb();
            CpCanvas::pa_data[i * 9 + 1] = _rb();
            CpCanvas::pa_data[i * 9 + 2] = _rb();
            CpCanvas::pa_data[i * 9 + 3] = _rb();
            int n = _ri();
            CpCanvas::pa_data[i * 9 + 4] = n & 0x1F;
            CpCanvas::pa_data[i * 9 + 5] = (n >> 5) & 0x1F;
            CpCanvas::pa_data[i * 9 + 6] = (n >> 10) & 0x1F;
            CpCanvas::pa_data[i * 9 + 7] = (n >> 15) & 0x1F;
            CpCanvas::pa_data[i * 9 + 8] = n >> 20;
        }
    } catch (...) {}
}

// ==================== EneSet ====================
void CpCanvas::EneSet(int n, int n2) {
    if (n < 0) {
        try {
            auto _buf = Resources::jarGet(30, CpCanvas::dat);
            int _p = 0;
            auto _ri = [&]() -> int {
                int v = ((int)(uint8_t)_buf[_p]<<24)|((int)(uint8_t)_buf[_p+1]<<16)|((int)(uint8_t)_buf[_p+2]<<8)|(int)(uint8_t)_buf[_p+3];
                _p+=4; return v;
            };
            for (int i = 0; i < 680; ++i) {
                CpCanvas::e_data[i / 5][i % 5] = _ri();
            }
        } catch (...) {}
    } else {
        try {
            auto _buf = Resources::jarGet(29, CpCanvas::dat);
            int _p = 16 * n2;
            int n3 = 0;
            for (n3 = 0; n3 < 16 && _buf[_p + n3] != 0; ++n3) {}
            CpCanvas::e_name[n] = std::string((char*)&_buf[_p], n3);
        } catch (...) {}
    }
}


// ==================== Title2 ====================
void CpCanvas::Title2() {
    int n;
    CpCanvas::soft_id[0] = 0;
    CpCanvas::soft_id[1] = 0;
    if (CpCanvas::machi_flg == 3) {
        CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
        CpCanvas::g->fillRect(0, 0, 240, 240);
        CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 255, 255));
        CpCanvas::g->fillRect(2, 162, 236, 76);
        if (CpCanvas::mode == 0) {
            MesRead(50, nullptr, 3);
            if (CpCanvas::key == 0x100000) {
                ++CpCanvas::mode;
                CpCanvas::key = 0;
            }
        } else if (CpCanvas::mode == 1) {
            CpCanvas::now_bgm = 3;
            Save(0);
            Audio(1, 11);
            CpCanvas::now_bgm = 0;
            ++CpCanvas::mode;
        } else if (CpCanvas::mode == 2) {
            MesRead(51, nullptr, 3);
            if (CpCanvas::key == 0x100000) {
                CpCanvas::machi_flg = 0;
                CpCanvas::mes_flg = 1;
                CpCanvas::yes_no_flg = 1;
                CpCanvas::mode = 0;
                CpCanvas::mode2 = 4;
                MesRead(0, nullptr, 10);
                CpCanvas::key = 0;
                return;
            }
        }
        MesDraw(1);
        drawImg3(44, 108, 225, 222 + CpCanvas::game_cnt / 3 % 2, false);
        return;
    }
    if (CpCanvas::option_flg != 0) {
        Option();
        return;
    }
    CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 255, 255));
    CpCanvas::g->fillRect(0, 0, 240, 240);
    int n2 = CpCanvas::game_cnt;
    int n3 = 125 + 10 * (n2 % 26 - n2 % 26 / 14 * (n2 % 13 * 2));
    CpCanvas::g->setColor(Graphics::getColorOfRGB(n3, 0, 0));
    CpCanvas::g->fillRect(112, 32, 54, 20);
    CpCanvas::g->fillRect(64, 53, 95, 75);
    imgAddDraw(2, 0, 0);
    imgAddDraw(3, 178, 123);
    if (CpCanvas::mes_flg != 0) {
        bool bl = false;
        CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
        CpCanvas::g->fillRect(0, 160, 240, 80);
        CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 255, 255));
        CpCanvas::g->fillRect(2, 162, 236, 76);
        if (CpCanvas::yes_no_flg != 0) {
            if (CpCanvas::key == 65536) {
                CpCanvas::yes_no_flg = 1;
                CpCanvas::key = 0;
            }
            if (CpCanvas::key == 262144) {
                CpCanvas::yes_no_flg = 2;
                CpCanvas::key = 0;
            }
        }
        if (CpCanvas::mode2 == 0) {
            MesRead(41, nullptr, 3);
            if (CpCanvas::key == 0x100000) {
                CpCanvas::mode2 = CpCanvas::yes_no_flg == 1 ? ++CpCanvas::mode2 : 8;
                CpCanvas::yes_no_flg = 0;
                bl = true;
                CpCanvas::key = 0;
            }
        } else if (CpCanvas::mode2 == 1) {
            MesRead(96, nullptr, 3);
            ++CpCanvas::mode2;
        } else if (CpCanvas::mode2 == 2) {
            CpCanvas::http_error = 0;
            if (CpCanvas::http_error == 0) {
                ++CpCanvas::mode2;
                CpCanvas::sina_flg = 2;
                CpCanvas::now_bgm = CpCanvas::back_menu == 3 ? CpCanvas::map_bgm : 3;
                Save(0);
                CpCanvas::now_bgm = 0;
            } else if (CpCanvas::http_error == 1) {
                CpCanvas::mode2 = 14;
            } else if (CpCanvas::http_error == 2) {
                CpCanvas::mode2 = 10;
            } else if (CpCanvas::http_error == 15) {
                CpCanvas::mode2 = 18;
            }
            CpCanvas::key = 0;
        } else if (CpCanvas::mode2 == 3) {
            MesRead(46, nullptr, 3);
            if (CpCanvas::key == 0x100000) {
                MesRead(0, nullptr, 10);
                CpCanvas::yes_no_flg = 1;
                ++CpCanvas::mode2;
                CpCanvas::key = 0;
            }
        } else if (CpCanvas::mode2 == 4) {
            if (CpCanvas::key == 0x100000) {
                CpCanvas::mode2 = CpCanvas::yes_no_flg == 1 ? ++CpCanvas::mode2 : 13;
                CpCanvas::yes_no_flg = 0;
                bl = true;
                CpCanvas::key = 0;
            }
        } else if (CpCanvas::mode2 == 5) {
            MesRead(3, nullptr, 10);
            ++CpCanvas::mode2;
        } else if (CpCanvas::mode2 == 6) {
            CpCanvas::dat[39] = 1;
            writeSP();
            GetScenario(CpCanvas::sina_no + 1);
            if (CpCanvas::http_error == 0) {
                int n4;
                ++CpCanvas::sina_no;
                CpCanvas::machi_no = 0;
                CpCanvas::back_menu = 5;
                CpCanvas::i_cnt[0] = 0;
                CpCanvas::now_bgm = -1;
                int nArray[20];
                for (n4 = 0; n4 < 20; ++n4) {
                    nArray[n4] = CpCanvas::talk_flg[n4 * 4 + 2];
                }
                SetFlg(0);
                for (n4 = 0; n4 < 20; ++n4) {
                    CpCanvas::talk_flg[n4 * 4 + 2] = nArray[n4];
                }
                CpCanvas::sina_flg = -1;
                RockIventSet();
                Save(0);
                CpCanvas::now_bgm = 0;
                ++CpCanvas::mode2;
                CpCanvas::dat[39] = 0;
                writeSP();
            } else {
                CpCanvas::mode2 = 15;
            }
            CpCanvas::key = 0;
        } else if (CpCanvas::mode2 == 7) {
            MesRead(2, nullptr, 10);
            if (CpCanvas::key == 0x100000) {
                CpCanvas::mode = 0;
                CpCanvas::mes_flg = 0;
                CpCanvas::key = 0;
            }
        } else if (CpCanvas::mode2 == 8) {
            MesRead(42, nullptr, 3);
            if (CpCanvas::key == 0x100000) {
                ++CpCanvas::mode2;
                CpCanvas::key = 0;
            }
        } else if (CpCanvas::mode2 == 9) {
            MesRead(43, nullptr, 3);
            if (CpCanvas::key == 0x100000) {
                CpCanvas::mes_flg = 0;
                CpCanvas::key = 0;
            }
        } else if (CpCanvas::mode2 == 10) {
            MesRead(44, (uint8_t*)CpCanvas::str.c_str(), 3);
            if (CpCanvas::key == 0x100000) {
                ++CpCanvas::mode2;
                CpCanvas::key = 0;
            }
        } else if (CpCanvas::mode2 == 11) {
            MesRead(45, nullptr, 3);
            if (CpCanvas::key == 0x100000) {
                CpCanvas::mes_flg = 0;
                CpCanvas::key = 0;
            }
        } else if (CpCanvas::mode2 == 12) {
            MesRead(70, nullptr, 3);
            if (CpCanvas::key == 0x100000) {
                CpCanvas::mes_flg = 0;
                CpCanvas::key = 0;
            }
        } else if (CpCanvas::mode2 == 13) {
            MesRead(1, nullptr, 10);
            if (CpCanvas::key == 0x100000) {
                CpCanvas::mes_flg = 0;
                CpCanvas::key = 0;
            }
        } else if (CpCanvas::mode2 == 14) {
            MesRead(99, nullptr, 3);
            if (CpCanvas::key == 0x100000) {
                CpCanvas::mode2 = 8;
                CpCanvas::key = 0;
            }
        } else if (CpCanvas::mode2 == 15) {
            MesRead(88, nullptr, 3);
            if (CpCanvas::key == 0x100000) {
                ++CpCanvas::mode2;
                MesRead(18, nullptr, 10);
                CpCanvas::yes_no_flg = 1;
                CpCanvas::key = 0;
            }
        } else if (CpCanvas::mode2 == 16) {
            MesRead(18, nullptr, 10);
            if (CpCanvas::key == 0x100000) {
                CpCanvas::mode2 = CpCanvas::yes_no_flg == 1 ? 5 : ++CpCanvas::mode2;
                CpCanvas::yes_no_flg = 0;
                bl = true;
                CpCanvas::key = 0;
            }
        } else if (CpCanvas::mode2 == 17) {
            MesRead(98, nullptr, 3);
            if (CpCanvas::key == 0x100000) {
                exit(0);
            }
        } else if (CpCanvas::mode2 == 18) {
            MesRead(161, nullptr, 3);
            if (CpCanvas::key == 0x100000) {
                exit(0);
            }
        }
        MesDraw(1);
        if (CpCanvas::yes_no_flg != 0) {
            drawImg3(44, 33, 55 + (CpCanvas::yes_no_flg - 1) * 96 + CpCanvas::game_cnt / 2 % 3, 207, false);
        } else if (!bl && MesFlg()) {
            drawImg3(44, 108, 225, 222 + CpCanvas::game_cnt / 3 % 2, false);
        }
        return;
    }
    if (CpCanvas::deba_flg != 0) {
        if (CpCanvas::key == 2) {
            ++CpCanvas::sina_flg;
            CpCanvas::sina_flg %= 3;
            CpCanvas::key = 0;
        }
        if (CpCanvas::key == 65536) {
            if (CpCanvas::mode == 3) {
                --CpCanvas::sina_no;
            }
            CpCanvas::key = 0;
        }
        if (CpCanvas::key == 262144) {
            if (CpCanvas::mode == 3) {
                ++CpCanvas::sina_no;
            }
            CpCanvas::key = 0;
        }
        if (CpCanvas::key == 0x200000) {
            CpCanvas::scene = 0;
            CpCanvas::key = 0;
            return;
        }
    }
    if (CpCanvas::key == 131072) {
        if (--CpCanvas::mode < 0) {
            CpCanvas::mode = 2;
            if (CpCanvas::sina_flg > 0 && CpCanvas::sina_no < 8) {
                ++CpCanvas::mode;
            }
        }
        CpCanvas::key = 0;
    } else if (CpCanvas::key == 524288) {
        ++CpCanvas::mode;
        n = 2;
        if (CpCanvas::sina_flg > 0 && CpCanvas::sina_no < 8) {
            ++n;
        }
        if (CpCanvas::mode > n) {
            CpCanvas::mode = 0;
        }
        CpCanvas::key = 0;
    } else if (CpCanvas::key == 0x200000 && CpCanvas::deba_flg == 0) {
        exit(0);
    }
    CpCanvas::soft_id[0] = 8;
    CpCanvas::soft_id[1] = 0;
    CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
    strDraw(std::string(u8"\u7b2c ") + std::to_string(CpCanvas::sina_no) + std::string(u8" \u8a71"), 180, 150);
    strDraw(CpCanvas::t_str[0], (240 - CpCanvas::f->stringWidth(CpCanvas::t_str[0])) / 2, 185);
    strDraw(CpCanvas::t_str[1], (240 - CpCanvas::f->stringWidth(CpCanvas::t_str[1])) / 2, 200);
    strDraw(std::string(u8"\u30b5\u30a4\u30c8\u3078\u79fb\u52d5"), (240 - CpCanvas::f->stringWidth(std::string(u8"\u30b5\u30a4\u30c8\u3078\u79fb\u52d5"))) / 2, 215);
    if (CpCanvas::sina_flg == 1 && CpCanvas::sina_no < 8) {
        strDraw(std::to_string(CpCanvas::sina_no + 1) + CpCanvas::t_str[3], (240 - CpCanvas::f->stringWidth(std::to_string(CpCanvas::sina_no + 1) + CpCanvas::t_str[3])) / 2, 230);
    }
    if (CpCanvas::sina_flg == 2 && CpCanvas::sina_no < 8) {
        strDraw(std::to_string(CpCanvas::sina_no + 1) + CpCanvas::t_str[3], (240 - CpCanvas::f->stringWidth(std::to_string(CpCanvas::sina_no + 1) + CpCanvas::t_str[3])) / 2, 230);
    }
    for (n = 0; n < 6; ++n) {
        if (CpCanvas::dat[58 + n] == 0) continue;
        drawImg3(44, 131 + n, 166 + n * 12, 173, false);
        drawImg3(44, 137 + n, 166 + n * 12, 173, false);
    }
    drawImg3(44, 33, 60 + CpCanvas::game_cnt / 2 % 3, 170 + CpCanvas::mode * 15, false);
    if (CpCanvas::key == 0x100000) {
        if (CpCanvas::mode == 0) {
            Audio(0, 0);
            Load(0);
            MachiSet(CpCanvas::machi_no, 0);
            CpCanvas::sort_flg = -1;
            ListSort(0);
            SortSkill(0);
            CpCanvas::scene = CpCanvas::back_menu;
            if (CpCanvas::scene == 5) {
                MachiSet(CpCanvas::machi_no, 1);
            }
            n = CpCanvas::map_x;
            int n5 = CpCanvas::map_y;
            CpCanvas::mode = 0;
            MapSet(CpCanvas::map_no, 0);
            CpCanvas::map_x = n;
            CpCanvas::map_y = n5;
            CpCanvas::now_bgm = CpCanvas::scene == 3 ? CpCanvas::map_bgm : 3;
            if (CpCanvas::sina_flg >= 0) {
                Audio(1, CpCanvas::now_bgm);
            } else {
                IventRead(1, 0);
                CpCanvas::now_bgm = -1;
                CpCanvas::sina_flg = 0;
            }
        } else if (CpCanvas::mode == 1) {
            CpCanvas::option_flg = 1;
        } else if (CpCanvas::mode == 2) {
            std::string urlStr = CpCanvas::DomeUrl + "/i/party/?uid=NULLGWDOCOMO";
            SDL_OpenURL(urlStr.c_str());
        } else if (CpCanvas::mode == 3) {
            if (CpCanvas::sina_flg == 1) {
                CpCanvas::mes_flg = 1;
                CpCanvas::yes_no_flg = 1;
                CpCanvas::mode = 0;
                CpCanvas::mode2 = 4;
                MesRead(0, nullptr, 10);
            } else if (CpCanvas::sina_flg == 2) {
                CpCanvas::mes_flg = 1;
                CpCanvas::yes_no_flg = 1;
                CpCanvas::mode = 0;
                CpCanvas::mode2 = 4;
                MesRead(0, nullptr, 10);
            }
        }
        CpCanvas::key = 0;
    }
}

// ==================== Title ====================
void CpCanvas::Title() {
    if (CpCanvas::key == 131072) {
        --CpCanvas::mode;
        CpCanvas::key = 0;
    }
    if (CpCanvas::key == 524288) {
        ++CpCanvas::mode;
        CpCanvas::key = 0;
    }
    if (CpCanvas::key == 4) {
        if (CpCanvas::mode == 0) {
            CpCanvas::teki_pt += 10;
        }
        if (CpCanvas::mode == 2) {
            CpCanvas::map_no += 10;
        }
        CpCanvas::key = 0;
    }
    if (CpCanvas::key == 2) {
        if (CpCanvas::mode == 0) {
            CpCanvas::teki_pt -= 10;
        }
        if (CpCanvas::mode == 2) {
            CpCanvas::map_no -= 10;
        }
        CpCanvas::key = 0;
    }
    if (CpCanvas::key == 65536) {
        if (CpCanvas::mode == 0) --CpCanvas::teki_pt;
        if (CpCanvas::mode == 2) --CpCanvas::map_no;
        if (CpCanvas::mode == 3) --CpCanvas::machi_no;
        if (CpCanvas::mode == 5) --CpCanvas::se_no;
        if (CpCanvas::mode == 6) --CpCanvas::bgm_no;
        CpCanvas::key = 0;
    }
    if (CpCanvas::key == 262144) {
        if (CpCanvas::mode == 0) ++CpCanvas::teki_pt;
        if (CpCanvas::mode == 2) ++CpCanvas::map_no;
        if (CpCanvas::mode == 3) ++CpCanvas::machi_no;
        if (CpCanvas::mode == 5) ++CpCanvas::se_no;
        if (CpCanvas::mode == 6) ++CpCanvas::bgm_no;
        CpCanvas::key = 0;
    }
    if (CpCanvas::key == 0x100000) {
        if (CpCanvas::mode == 0) {
            BtSet(CpCanvas::teki_pt);
            CpCanvas::scene = 1;
            CpCanvas::eff_cnt = 1;
            CpCanvas::mode = 0;
        } else if (CpCanvas::mode == 1) {
            CpCanvas::scene = -1;
            CpCanvas::mode = 0;
        } else if (CpCanvas::mode == 2) {
            CpCanvas::scene = 3;
            MapSet(CpCanvas::map_no, 0);
            Audio(1, CpCanvas::map_bgm);
            CpCanvas::mode = 0;
        } else if (CpCanvas::mode == 3) {
            MachiSet(CpCanvas::machi_no, 1);
            Audio(1, 3);
            CpCanvas::scene = 5;
            CpCanvas::mode = 0;
        } else if (CpCanvas::mode == 4) {
            ImgSet2(20);
            Audio(1, 0);
            CpCanvas::scene = -2;
            CpCanvas::mode = 0;
        } else if (CpCanvas::mode == 5) {
            seSet(CpCanvas::se_no, 0);
        } else if (CpCanvas::mode == 6) {
            Audio(1, CpCanvas::bgm_no);
        }
        CpCanvas::key = 0;
    }
    CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
    CpCanvas::g->fillRect(0, 0, 240, 240);
    CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 255, 255));
    strDraw(std::string(u8"\u6226 ") + std::to_string(CpCanvas::teki_pt), 40, 30);
    strDraw(std::string(u8"\u8868\u793a\u30c6\u30b9\u30c8"), 40, 45);
    strDraw(std::string(u8"\u96fb ") + std::to_string(CpCanvas::map_no) + " " + CpCanvas::map_str[CpCanvas::map_no], 40, 60);
    strDraw(std::string(u8"\u8857 ") + std::to_string(CpCanvas::machi_no) + " " + CpCanvas::m_name[CpCanvas::machi_no], 40, 75);
    strDraw(std::string(u8"\u30bf\u30a4\u30c8\u30eb\u3078"), 40, 90);
    strDraw(std::string("SE:") + std::to_string(CpCanvas::se_no), 40, 105);
    strDraw(std::string("BGM:") + std::to_string(CpCanvas::bgm_no), 40, 120);
    if (CpCanvas::deba_flg != 0) {
        if (CpCanvas::key == 16) {
            CpCanvas::rock_mu ^= 1;
            CpCanvas::key = 0;
        }
        if (CpCanvas::key == 32) {
            CpCanvas::teki_mu ^= 1;
            CpCanvas::key = 0;
        }
        std::string stringArray[2] = {"off", "on"};
        strDraw(std::string(u8"[4]\u30ed\u30c3\u30af\u30de\u30f3\u7121\u6575\uff1a") + stringArray[CpCanvas::rock_mu], 40, 150);
        strDraw(std::string(u8"[5]\u6575HP\uff0b\uff11\uff10\uff10\uff10\uff1a") + stringArray[CpCanvas::teki_mu], 40, 165);
        strDraw(std::string(u8"[#]\u5f37:"), 40, 190);
        strDraw(std::string(u8"[3]\uff31:") + std::to_string(CpCanvas::que_su), 40, 220);
    }
    strDraw(">", 15, 30 + CpCanvas::mode * 15);
}


// ==================== Option ====================
void CpCanvas::Option() {
    int n;
    CpCanvas::soft_id[0] = 0;
    CpCanvas::soft_id[1] = 0;
    if (CpCanvas::option_flg < 10) {
        drawImg3(44, 0, 0, 0, true);
        drawImg3(44, 90, 8, 8, true);
        CpCanvas::graMap->setColor(Graphics::getColorOfRGB(120, 152, 216));
        CpCanvas::graMap->fillRect(4, 20, 232, 136);
        CpCanvas::graMap->setColor(Graphics::getColorOfRGB(255, 255, 255));
        CpCanvas::graMap->fillRect(2, 162, 236, 76);
        for (n = 0; n < 5; ++n) {
            strDrawG(CpCanvas::o_str[n], 39, 50 + n * 21);
        }
        CpCanvas::graMap->setColor(Graphics::getColorOfRGB(180, 180, 180));
        if (CpCanvas::option_flg == 2) {
            strDrawG(CpCanvas::o_str[2], 39, 92);
            strDrawG(CpCanvas::o_str[3], 39, 113);
            strDrawG(CpCanvas::o_str[4], 39, 134);
        }
        CpCanvas::mode = 0;
        CpCanvas::option_flg += 10;
    }
    if (CpCanvas::o_mode == 0) {
        CpCanvas::soft_id[0] = 2;
        CpCanvas::soft_id[1] = 0;
        if (CpCanvas::key == 131072) {
            if (--CpCanvas::mode < 0) {
                CpCanvas::mode = 4 - CpCanvas::option_flg / 12 * 3;
            }
            CpCanvas::key = 0;
        } else if (CpCanvas::key == 524288) {
            if (++CpCanvas::mode > 4 - CpCanvas::option_flg / 12 * 3) {
                CpCanvas::mode = 0;
            }
            CpCanvas::key = 0;
        }
        if (CpCanvas::key == 65536) {
            if (CpCanvas::mode == 0) {
                if (++CpCanvas::audio_flg > 3) {
                    CpCanvas::audio_flg = 0;
                }
                for (int i = 0; i < 16; ++i) {
                    CpCanvas::audio[i]->setAttribute(4, (3 - CpCanvas::audio_flg) * 100 / 3);
                }
                for (int i = 0; i < 30; ++i) {
                    CpCanvas::m_audio[i]->setAttribute(4, (3 - CpCanvas::audio_flg) * 100 / 3);
                }
                CpCanvas::dat[53] = CpCanvas::audio_flg;
                writeSP();
            }
            CpCanvas::key = 0;
        }
        if (CpCanvas::key == 262144) {
            if (CpCanvas::mode == 0) {
                if (--CpCanvas::audio_flg < 0) {
                    CpCanvas::audio_flg = 3;
                }
                for (int i = 0; i < 16; ++i) {
                    CpCanvas::audio[i]->setAttribute(4, (3 - CpCanvas::audio_flg) * 100 / 3);
                }
                for (int i = 0; i < 30; ++i) {
                    CpCanvas::m_audio[i]->setAttribute(4, (3 - CpCanvas::audio_flg) * 100 / 3);
                }
                CpCanvas::dat[53] = CpCanvas::audio_flg;
                writeSP();
            }
            CpCanvas::key = 0;
        }
        int nArray[] = {93, 94, 71, 76, 82};
        MesRead(nArray[CpCanvas::mode], nullptr, 3);
        if (CpCanvas::key == 0x100000) {
            if (CpCanvas::mode == 0) {
                if (--CpCanvas::audio_flg < 0) {
                    CpCanvas::audio_flg = 3;
                }
                for (int i = 0; i < 16; ++i) {
                    CpCanvas::audio[i]->setAttribute(4, (3 - CpCanvas::audio_flg) * 100 / 3);
                }
                for (int i = 0; i < 30; ++i) {
                    CpCanvas::m_audio[i]->setAttribute(4, (3 - CpCanvas::audio_flg) * 100 / 3);
                }
                CpCanvas::dat[53] = CpCanvas::audio_flg;
                writeSP();
            }
            if (CpCanvas::mode == 1) {
                if (CpCanvas::option_flg - 10 == 1) {
                    CpCanvas::option_flg = 0;
                    CpCanvas::mode = 0;
                } else {
                    MesRead(97, nullptr, 3);
                    CpCanvas::yes_no_flg = 1;
                    CpCanvas::o_mode = 1;
                    CpCanvas::o_cnt = 0;
                }
            }
            if (CpCanvas::mode == 2) {
                MesRead(72, nullptr, 3);
                CpCanvas::o_mode = 2;
                CpCanvas::o_cnt = 0;
            }
            if (CpCanvas::mode == 3) {
                MesRead(77, nullptr, 3);
                CpCanvas::o_mode = 3;
                CpCanvas::o_cnt = 0;
            }
            if (CpCanvas::mode == 4) {
                MesRead(83, nullptr, 3);
                CpCanvas::o_mode = 4;
                CpCanvas::o_cnt = 0;
            }
            CpCanvas::key = 0;
        } else if (CpCanvas::key == 0x200000) {
            if (CpCanvas::option_flg - 10 == 2) {
                CpCanvas::str = " " + std::to_string(CpCanvas::full_ene);
                MesRead(CpCanvas::menu_sel + 5, (uint8_t*)CpCanvas::str.c_str(), 3);
                CpCanvas::menu_cnt = -1;
                CpCanvas::option_flg = 0;
                CpCanvas::mode = 0;
                CpCanvas::key = 0;
                return;
            }
            CpCanvas::option_flg = 0;
            CpCanvas::mode = 0;
            CpCanvas::key = 0;
        }
    } else {
        if (CpCanvas::yes_no_flg != 0) {
            if (CpCanvas::key == 65536) {
                CpCanvas::yes_no_flg = 1;
                CpCanvas::key = 0;
            }
            if (CpCanvas::key == 262144) {
                CpCanvas::yes_no_flg = 2;
                CpCanvas::key = 0;
            }
        }
        if (CpCanvas::o_mode == 1) {
            if (CpCanvas::o_cnt == 0) {
                if (CpCanvas::key == 0x100000) {
                    if (CpCanvas::yes_no_flg == 1) {
                        Save(0);
                        Audio(1, 11);
                        CpCanvas::o_mode = 0;
                        CpCanvas::yes_no_flg = 0;
                        CpCanvas::mode = 0;
                        CpCanvas::option_flg = 0;
                        ImgSet2(20);
                        Audio(1, 0);
                        CpCanvas::scene = -2;
                    } else {
                        MesRead(95, nullptr, 3);
                        CpCanvas::yes_no_flg = 2;
                        ++CpCanvas::o_cnt;
                    }
                    CpCanvas::key = 0;
                }
            } else if (CpCanvas::o_cnt == 1 && CpCanvas::key == 0x100000) {
                if (CpCanvas::yes_no_flg == 1) {
                    CpCanvas::o_mode = 0;
                    CpCanvas::yes_no_flg = 0;
                    CpCanvas::mode = 0;
                    CpCanvas::option_flg = 0;
                    ImgSet2(20);
                    Load(0);
                    Audio(1, 0);
                    CpCanvas::scene = -2;
                } else {
                    CpCanvas::o_mode = 0;
                }
                CpCanvas::yes_no_flg = 0;
                CpCanvas::key = 20;
            }
        } else if (CpCanvas::o_mode == 2) {
            // Stub: online functionality
            if (CpCanvas::key == 0x100000) {
                CpCanvas::o_mode = 0;
                CpCanvas::key = 0;
            }
        } else if (CpCanvas::o_mode == 3) {
            // Stub: online functionality
            if (CpCanvas::key == 0x100000) {
                CpCanvas::o_mode = 0;
                CpCanvas::key = 0;
            }
        } else if (CpCanvas::o_mode == 4) {
            // Stub: online functionality
            if (CpCanvas::key == 0x100000) {
                CpCanvas::o_mode = 0;
                CpCanvas::key = 0;
            }
        }
    }
    CpCanvas::g->drawImage(CpCanvas::imgMap, 0, 0);
    CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 255, 255));
    strDraw(CpCanvas::o_str[5 + CpCanvas::audio_flg], 120, 50);
    if (CpCanvas::o_mode == 0) {
        drawImg3(44, 33, 15 + CpCanvas::game_cnt / 2 % 3, 35 + CpCanvas::mode * 21, false);
    }
    MesDraw(1);
    if (CpCanvas::yes_no_flg != 0) {
        drawImg3(44, 33, 55 + (CpCanvas::yes_no_flg - 1) * 96 + CpCanvas::game_cnt / 2 % 3, 207, false);
    } else if (CpCanvas::o_mode != 0 && MesFlg()) {
        drawImg3(44, 108, 225, 222 + CpCanvas::game_cnt / 3 % 2, false);
    }
}

// ==================== MesFlg ====================
bool CpCanvas::MesFlg() {
    int nArray[] = {24, 63, 69, 74, 80, 86, 96};
    for (int i = 0; i < 7; ++i) {
        if (CpCanvas::mes_id == nArray[i]) {
            return false;
        }
    }
    return true;
}

// ==================== Test ====================
void CpCanvas::Test() {
    int n;
    Audio(0, 0);
    if (CpCanvas::key == 0x200000) {
        CpCanvas::scene = 0;
        CpCanvas::key = 0;
    }
    if (CpCanvas::key == 131072) {
        if (--CpCanvas::mode < 0) {
            CpCanvas::mode = 4;
        }
        CpCanvas::key = 0;
    }
    if (CpCanvas::key == 524288) {
        if (++CpCanvas::mode > 4) {
            CpCanvas::mode = 0;
        }
        CpCanvas::key = 0;
    }
    if (CpCanvas::key == 65536) {
        if (CpCanvas::mode == 0) {
            if (--CpCanvas::ch_no < 0) {
                CpCanvas::ch_no = 53;
            }
            CpCanvas::ani_pt = 0;
            CpCanvas::g_no = 0;
            CpCanvas::ani_cnt = 0;
        }
        if (CpCanvas::mode == 1 && --CpCanvas::g_no < 0) {
            CpCanvas::g_no = CpCanvas::dx[CpCanvas::ch_no][0] - 1; // simplified
        }
        if (CpCanvas::mode == 2 && CpCanvas::ch_no < 42) {
            if (--CpCanvas::ani_pt < 0) {
                CpCanvas::ani_pt = 0; // simplified
            }
            CpCanvas::ani_cnt = 0;
        }
        if (CpCanvas::mode == 3) {
            CpCanvas::flp ^= 1;
        }
        if (CpCanvas::mode == 4 && CpCanvas::ch_no < 22) {
            if (--CpCanvas::plt < 0) {
                CpCanvas::plt = 3;
                if (CpCanvas::ch_no == 0) {
                    ++CpCanvas::plt;
                }
            }
            n = CpCanvas::plt + CpCanvas::ch_no * 4;
            if (CpCanvas::ch_no > 0) {
                ++n;
            }
            PalSet(CpCanvas::ch_no, n);
        }
        CpCanvas::key = 0;
    }
    if (CpCanvas::key == 262144) {
        if (CpCanvas::mode == 0) {
            if (++CpCanvas::ch_no > 53) {
                CpCanvas::ch_no = 0;
            }
            CpCanvas::ani_pt = 0;
            CpCanvas::g_no = 0;
            CpCanvas::ani_cnt = 0;
        }
        if (CpCanvas::mode == 1 && ++CpCanvas::g_no > 10) {
            CpCanvas::g_no = 0;
        }
        if (CpCanvas::mode == 2 && CpCanvas::ch_no < 42) {
            if (++CpCanvas::ani_pt > 10) {
                CpCanvas::ani_pt = 0;
            }
            CpCanvas::ani_cnt = 0;
        }
        if (CpCanvas::mode == 3) {
            CpCanvas::flp ^= 1;
        }
        if (CpCanvas::mode == 4 && CpCanvas::ch_no < 22) {
            ++CpCanvas::plt;
            if (CpCanvas::ch_no == 0) {
                if (CpCanvas::plt > 4) {
                    CpCanvas::plt = 0;
                }
            } else if (CpCanvas::plt > 3) {
                CpCanvas::plt = 0;
            }
            n = CpCanvas::plt + CpCanvas::ch_no * 4;
            if (CpCanvas::ch_no > 0) {
                ++n;
            }
            PalSet(CpCanvas::ch_no, n);
        }
        CpCanvas::key = 0;
    }
    if (CpCanvas::key == 0x100000) {
        if (CpCanvas::mode == 2) {
            CpCanvas::ani_cnt = 0;
        }
        if (CpCanvas::mode == 3) {
            CpCanvas::flp ^= 1;
        }
        CpCanvas::key = 0;
    }
    CpCanvas::g->drawImage(CpCanvas::imgMap, 0, 0);
    CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
    CpCanvas::g->fillRect(0, 0, 240, 75);
    CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 255, 255));
    strDraw(std::string(u8"\u8868\u793a\u30c6\u30b9\u30c8"), (240 - CpCanvas::f->stringWidth(std::string(u8"\u8868\u793a\u30c6\u30b9\u30c8"))) / 2, 25);
    strDraw("ch :" + std::to_string(CpCanvas::ch_no), 15, 15);
    strDraw("no :" + std::to_string(CpCanvas::g_no), 15, 30);
    strDraw("ani:" + std::to_string(CpCanvas::ani_pt), 15, 45);
    strDraw("flp:" + std::to_string(CpCanvas::flp), 15, 60);
    strDraw("plt:" + std::to_string(CpCanvas::plt), 15, 75);
    strDraw(">", 5, 15 + CpCanvas::mode * 15);
    drawImg3(CpCanvas::ch_no, CpCanvas::g_no, 50, 200, false);
    if (CpCanvas::ch_no < 42 && Ani(CpCanvas::ch_no, CpCanvas::ani_pt, CpCanvas::ani_cnt, 1, 1, 0, 0, CpCanvas::flp) == -2) {
        Ani(CpCanvas::ch_no, CpCanvas::ani_pt, --CpCanvas::ani_cnt, 1, 1, 0, 0, CpCanvas::flp);
    }
    ++CpCanvas::ani_cnt;
}


// ==================== BattleMain ====================
void CpCanvas::BattleMain() {
    int n;
    int n2;
    int n3;
    CpCanvas::soft_id[0] = 0;
    CpCanvas::soft_id[1] = 0;
    
    if (CpCanvas::eff_cnt > 0) {
        CpCanvas::g->drawImage(CpCanvas::imgMap, 0, 0);
        CharaDraw(0);
        EnEff(--CpCanvas::eff_cnt);
        CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
        CpCanvas::g->fillRect(0, 0, 240, 40);
        CpCanvas::g->fillRect(0, 200, 240, 40);
        if (CpCanvas::eff_cnt == 0) {
            CpCanvas::fol[CpCanvas::now_fol]->RandSet(CpCanvas::max_sel);
            ++CpCanvas::scene;
            CpCanvas::key = 0;
            if (CpCanvas::ren_flg > 0) {
                CpCanvas::cas_cnt = 0;
            }
        }
        CpCanvas::key = 0;
        return;
    }
    
    if (CpCanvas::dell_cnt < 0) {
        int n4;
        for (n4 = 0; n4 < 3; ++n4) {
            CpCanvas::ene[n4]->Move();
        }
        CpCanvas::g->drawImage(CpCanvas::imgMap, 0, 0);
        for (n4 = 0; n4 < 30; ++n4) {
            if (CpCanvas::ata[n4]->on == 0) continue;
            CpCanvas::ata[n4]->Move(1);
        }
        CharaDraw(1);
        CpCanvas::rock->HpDraw(0, 0);
        CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
        CpCanvas::g->fillRect(0, 0, 240, 40);
        CpCanvas::g->fillRect(0, 200, 240, 40);
        if (++CpCanvas::dell_cnt != 0) {
            if (CpCanvas::dell_cnt >= -5) return;
            int nArray[] = {4, 9, 16, 18, 16, 16, 16, 16, 16, 16, 16, 16, 16, 9, 4};
            CpCanvas::g->drawScaledImage((Image*)CpCanvas::image[43], 52, 104 + (16 - nArray[20 + CpCanvas::dell_cnt]) / 2, 60, nArray[20 + CpCanvas::dell_cnt], 120, 32, 60, 16);
            CpCanvas::g->drawScaledImage((Image*)CpCanvas::image[43], 112, 104 + (16 - nArray[20 + CpCanvas::dell_cnt]) / 2, 76, nArray[20 + CpCanvas::dell_cnt], 120, 64, 76, 16);
            return;
        }
        CpCanvas::come_back = 0;
        if (CpCanvas::ren_flg > 0) {
            // handle ren_flg logic
            if (CpCanvas::rank_flg != 0) {
                CpCanvas::come_back = 1;
                CpCanvas::bas_cnt = (CpCanvas::bas_cnt + 1) * 20 + (int)((unsigned int)CpCanvas::rand() >> 1) % 10 - 5;
            }
        }
        CpCanvas::bas_cnt = (CpCanvas::bas_cnt + 1) * 20 + (int)((unsigned int)CpCanvas::rand() >> 1) % 10 - 5;
        CpCanvas::bas_lv = BasLv();
        CpCanvas::bt_get[0] = CpCanvas::ene[CpCanvas::drop_ene]->Get(0, CpCanvas::bas_lv);
        CpCanvas::bas_flg = 1;
        CpCanvas::graMap->setColor(Graphics::getColorOfRGB(96, 112, 192));
        CpCanvas::graMap->fillRect(0, 0, 240, 240);
        drawImg3(44, 84, 0, 0, true);
        drawImg3(44, 85, 187, 0, true);
        CpCanvas::graMap->setColor(Graphics::getColorOfRGB(200, 224, 248));
        CpCanvas::graMap->fillRect(6, 3, 181, 120);
        CpCanvas::graMap->setColor(Graphics::getColorOfRGB(96, 112, 192));
        CpCanvas::graMap->fillRect(6, 3, 178, 13);
        CpCanvas::graMap->setColor(Graphics::getColorOfRGB(120, 152, 216));
        CpCanvas::graMap->fillRect(6, 16, 178, 107);
        drawImg3(44, 118, 15, 6, true);
        Audio(1, 6);
        CpCanvas::key = 0;
        return;
    }
    
    if (CpCanvas::bas_flg != 0) {
        CpCanvas::g->drawImage(CpCanvas::imgMap, 24, 63, 0, 0, 190, 127);
        ImgSuu(CpCanvas::bas_cnt / 18000, 135, 87, 16, 3, 1);
        ImgSuu(CpCanvas::bas_cnt / 300 % 60, 159, 87, 16, 3, 1);
        ImgSuu(CpCanvas::bas_cnt / 3 % 100, 183, 87, 16, 3, 1);
        if (CpCanvas::bas_lv > 10) {
            drawImg3(44, 116, 180, 111, false);
        } else {
            ImgSuu(CpCanvas::bas_lv, 180, 111, 16, 1, 1);
        }
        drawImg3(44, 114, 116, 181 + CpCanvas::game_cnt / 3 % 2, false);
        if (CpCanvas::bas_flg == 1) {
            if (CpCanvas::key != 0) {
                CpCanvas::bas_flg = CpCanvas::bt_get[0] != 0 ? 2 : 3;
                if (CpCanvas::teki_pt == 340 || CpCanvas::teki_pt == 344) {
                    CpCanvas::bas_flg = 0;
                }
                CpCanvas::key = 0;
            }
        } else if (CpCanvas::bas_flg == 2) {
            int n6 = CpCanvas::tip_list[CpCanvas::bt_get[0]] >> 8 & 0xFF;
            CpCanvas::str = ItemName(0, CpCanvas::bt_get[0]);
            CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 255, 255));
            strDraw(CpCanvas::str, 68, 162);
            drawImg3(44, 112, 47, 165, false);
            drawImg3(44, 113, 126, 165, false);
            CpCanvas::tip[n6]->Draw(47, 149, 1, true);
            CpCanvas::tip[n6]->DrawPow(91, 166);
            CpCanvas::tip[n6]->DrawZoku(178, 165);
            if (CpCanvas::key != 0) {
                ++CpCanvas::bas_flg;
                CpCanvas::key = 0;
            }
        } else if (CpCanvas::bas_flg == 3) {
            ImgSuu(CpCanvas::bt_get[1], 132, 151, 36, 1, 1);
            drawImg3(44, 42, 169, 153, false);
            if (CpCanvas::key != 0) {
                CpCanvas::bas_flg = CpCanvas::bt_get[2] != 0 ? ++CpCanvas::bas_flg : 0;
                CpCanvas::key = 0;
            }
        } else if (CpCanvas::bas_flg == 4) {
            CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 255, 255));
            strDraw(CpCanvas::menu_str[30], 68, 162);
            ImgSuu(CpCanvas::bt_get[2], 132, 151, 36, 1, 1);
            drawImg3(44, 43, 169, 153, false);
            if (CpCanvas::key != 0) {
                CpCanvas::bas_flg = 0;
                CpCanvas::key = 0;
            }
        }
        if (CpCanvas::bas_flg != 0) return;
        GetItem(0, 0, CpCanvas::bt_get[0]);
        GetItem(1, 0, CpCanvas::bt_get[1]);
        GetItem(2, 0, CpCanvas::bt_get[2]);
        CpCanvas::bas_flg = 0;
        CpCanvas::scene = CpCanvas::back_menu;
        if (CpCanvas::back_menu == 3) {
            Audio(1, CpCanvas::map_bgm);
        } else {
            Audio(1, 3);
            MachiSet(CpCanvas::machi_no, 0);
            CpCanvas::ivent_flg = 0;
        }
        CpCanvas::win_flg = 1;
        CpCanvas::now_hp = Rock::hp;
        CpCanvas::key = 0;
        return;
    }
    
    if (CpCanvas::over_flg != 0) {
        int n8 = CpCanvas::over_cnt * 4;
        if (n8 > 18) {
            n8 = 18;
        }
        CpCanvas::g->setColor(Graphics::getColorOfRGB(45, 50, 89));
        CpCanvas::g->fillRect(0, 125 - (n8 + 4) / 2, 240, n8 + 4);
        CpCanvas::g->drawScaledImage((Image*)CpCanvas::image[43], 59, 116 + (18 - n8) / 2, 56, n8, 120, 80, 56, 18);
        CpCanvas::g->drawScaledImage((Image*)CpCanvas::image[43], 125, 116 + (18 - n8) / 2, 53, n8, 120, 98, 53, 18);
        if (n8 == 18 && (CpCanvas::key == 0x100000 || CpCanvas::over_cnt == 100)) {
            CpCanvas::over_flg = 0;
            CpCanvas::over_cnt = 0;
            ImgSet2(20);
            Audio(1, 0);
            CpCanvas::scene = -2;
            CpCanvas::mes_flg = 0;
            CpCanvas::key = 0;
        }
        ++CpCanvas::over_cnt;
        return;
    }
    
    if (CpCanvas::over_cnt > 0) {
        if (CpCanvas::over_cnt == 1) {
            CpCanvas::ren_flg = 0;
            if (CpCanvas::come_back != 0) {
                CpCanvas::come_back = 0;
                CpCanvas::scene = CpCanvas::back_menu;
                CpCanvas::now_hp = CpCanvas::tmp_hp;
                if (CpCanvas::back_menu == 3) {
                    Audio(1, CpCanvas::map_bgm);
                } else {
                    Audio(1, 3);
                    if (CpCanvas::rank_flg == 0) {
                        MachiSet(CpCanvas::machi_no, 0);
                    } else {
                        CpCanvas::rank_flg = 0;
                        CpCanvas::rank_cnt = 1;
                    }
                    CpCanvas::ivent_flg = 0;
                }
                CpCanvas::win_flg = 0;
                return;
            }
            CpCanvas::key = 0;
        }
        CpCanvas::g->drawImage(CpCanvas::imgMap, 0, 0);
        CharaDraw(1);
        CpCanvas::rock->HpDraw(0, 0);
        CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
        CpCanvas::g->fillRect(0, 0, 240, 40);
        CpCanvas::g->fillRect(0, 200, 240, 40);
        if (CpCanvas::over_cnt < 16) {
            int nArray[] = {4, 9, 16, 18, 16, 16, 16, 16, 16, 16, 16, 16, 16, 9, 4};
            CpCanvas::g->drawScaledImage((Image*)CpCanvas::image[43], 52, 104 + (16 - nArray[CpCanvas::over_cnt - 1]) / 2, 76, nArray[CpCanvas::over_cnt - 1], 120, 48, 76, 16);
            CpCanvas::g->drawScaledImage((Image*)CpCanvas::image[43], 128, 104 + (16 - nArray[CpCanvas::over_cnt - 1]) / 2, 76, nArray[CpCanvas::over_cnt - 1], 120, 64, 76, 16);
        } else {
            int n9;
            if (CpCanvas::over_cnt == 16) {
                Audio(0, 0);
            }
            if ((n9 = (CpCanvas::over_cnt - 16) * (CpCanvas::over_cnt - 16) * 3) > 240) {
                n9 = 240;
                CpCanvas::over_flg = 1;
                CpCanvas::over_cnt = 0;
            }
            CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 255, 255));
            CpCanvas::g->fillRect(0, 112, n9, 2);
            CpCanvas::g->fillRect(240 - n9, 136, 240, 2);
        }
        ++CpCanvas::over_cnt;
        return;
    }
    
    if (CpCanvas::stop_cnt > 0) {
        int n10;
        if (CpCanvas::stop_cnt == 1) {
            MotionBack();
            Rock::tmp_muteki_cnt = Rock::muteki_cnt;
            for (n10 = 0; n10 < 3; ++n10) {
                CpCanvas::ene[n10]->tmp_muteki_cnt = CpCanvas::ene[n10]->muteki_cnt;
            }
        }
        if (CpCanvas::stop_cnt < 4) {
            Ann(0, CpCanvas::stop_cnt - 1);
        }
        ++CpCanvas::stop_cnt;
        CpCanvas::tmp_graMap->drawImage(CpCanvas::imgMap, 0, 0);
        CpCanvas::g->drawImage(CpCanvas::tmp_imgMap, 0, 0);
        for (n10 = 0; n10 < 30; ++n10) {
            if (CpCanvas::ata[n10]->on == 0) continue;
            CpCanvas::ata[n10]->Move(0);
        }
        for (n10 = 0; n10 < 30; ++n10) {
            if (CpCanvas::ata[n10]->on == 0) continue;
            CpCanvas::ata[n10]->HitGo(0);
        }
        CharaDraw(0);
        drawImg3(43, 0, 48, 40, false);
        CpCanvas::rock->HpDraw(0, 0);
        CpCanvas::rock->TipDraw();
        if (CpCanvas::stop_cnt < 15) {
            CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 255, 255));
            strDraw(CpCanvas::stop_name, (120 - CpCanvas::f->stringWidth(CpCanvas::stop_name)) / 2 + 120 * CpCanvas::stop_ch, 80);
        }
        if (CpCanvas::wana_flg >= 100 && CpCanvas::stop_cnt == 16) {
            for (n10 = 0; n10 < 3; ++n10) {
                if (CpCanvas::ene[n10]->on == 0) continue;
                if (CpCanvas::wana_flg - 100 == 1 && CpCanvas::panel[CpCanvas::ene[n10]->pos_y * 6 + CpCanvas::ene[n10]->pos_x]->jou == 4 || CpCanvas::wana_flg - 100 == 3 && CpCanvas::panel[CpCanvas::ene[n10]->pos_y * 6 + CpCanvas::ene[n10]->pos_x]->jou == 5) {
                    CpCanvas::wana_pow[0] = CpCanvas::wana_pow[0] * 2;
                }
                if (CpCanvas::wana_flg - 100 == 1 && CpCanvas::panel[CpCanvas::ene[n10]->pos_y * 6 + CpCanvas::ene[n10]->pos_x]->jou == 4 || CpCanvas::wana_flg - 100 == 2 && CpCanvas::panel[CpCanvas::ene[n10]->pos_y * 6 + CpCanvas::ene[n10]->pos_x]->jou == 3) {
                    CpCanvas::panel[CpCanvas::ene[n10]->pos_y * 6 + CpCanvas::ene[n10]->pos_x]->Henka(1, 0);
                }
                CpCanvas::ene[n10]->Hit(1, CpCanvas::wana_pow[0], CpCanvas::wana_flg - 100);
                CpCanvas::ene[n10]->hit_cnt = 0;
            }
            CpCanvas::wana_flg = 0;
        }
        CpCanvas::rock->WanaDraw();
        CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
        CpCanvas::g->fillRect(0, 0, 240, 40);
        CpCanvas::g->fillRect(0, 200, 240, 40);
        if (CpCanvas::stop_cnt >= CpCanvas::stop_time) {
            n10 = CpCanvas::stop_cnt - CpCanvas::stop_time;
            Ann(1, 4 - n10);
            if (n10 == 4) {
                int n11;
                for (n11 = 0; n11 < 30; ++n11) {
                    if (CpCanvas::ata[n11]->on == 0 || CpCanvas::ata[n11]->hit_time <= 0) continue;
                    CpCanvas::ata[n11]->init();
                }
                Rock::muteki_cnt = Rock::tmp_muteki_cnt;
                for (n11 = 0; n11 < 3; ++n11) {
                    CpCanvas::ene[n11]->muteki_cnt = CpCanvas::ene[n11]->tmp_muteki_cnt;
                    CpCanvas::ene[n11]->tmp_muteki_cnt = 0;
                }
                CpCanvas::stop_cnt = 0;
                CpCanvas::stop_time = 0;
                CpCanvas::key = 0;
            }
        }
        CpCanvas::key = 0;
        return;
    }
    
    CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
    if (CpCanvas::dell_cnt != 0 || CpCanvas::over_cnt != 0) {
        // skip input handling
    } else {
        if (CpCanvas::key == 65536) {
            if (Rock::joutai == 0) {
                if (Rock::move_flg == 0) {
                    Rock::move_flg = 1;
                }
            }
            CpCanvas::key = 0;
        } else if (CpCanvas::key == 262144) {
            if (Rock::joutai == 0) {
                if (Rock::move_flg == 0) {
                    Rock::move_flg = 3;
                }
            }
            CpCanvas::key = 0;
        } else if (CpCanvas::key == 131072) {
            if (Rock::joutai == 0) {
                if (Rock::move_flg == 0) {
                    Rock::move_flg = 2;
                }
            }
            CpCanvas::key = 0;
        } else if (CpCanvas::key == 524288) {
            if (Rock::joutai == 0) {
                if (Rock::move_flg == 0) {
                    Rock::move_flg = 4;
                }
            }
            CpCanvas::key = 0;
        } else if (CpCanvas::key == 0x100000) {
            if (Rock::tmp_ata < 0) {
                CpCanvas::rock->Action(0);
            }
            CpCanvas::key = 0;
        } else if (CpCanvas::key == 0x200000 || CpCanvas::key == 0x400000) {
            CpCanvas::key = 0;
            if (CpCanvas::cus_gage == 128) {
                ++CpCanvas::scene;
                CpCanvas::fol[CpCanvas::now_fol]->RandSet(CpCanvas::max_sel);
                MotionBack();
                return;
            }
        }
    }
    
    Rock::non_bas = 0;
    n3 = 0;
    for (n2 = 0; n2 < 3; ++n2) {
        CpCanvas::ene[n2]->Move();
    }
    if (CpCanvas::stop_time != 0) {
        CpCanvas::stop_time += 20;
        CpCanvas::stop_cnt = 1;
        return;
    }
    CpCanvas::rock->Move();
    if (CpCanvas::stop_time != 0) {
        CpCanvas::stop_time += 20;
        CpCanvas::stop_cnt = 1;
        return;
    }
    for (n2 = 0; n2 < 6; ++n2) {
        CpCanvas::oki[n2]->Move();
    }
    for (n2 = 0; n2 < 30; ++n2) {
        if (CpCanvas::ata[n2]->on == 0) continue;
        CpCanvas::ata[n2]->HitGo(-1);
    }
    for (n2 = 0; n2 < 30; ++n2) {
        if (CpCanvas::ata[n2]->on == 0) continue;
        CpCanvas::ata[n2]->Move(1);
    }
    for (n2 = 0; n2 < 30; ++n2) {
        if (CpCanvas::ata[n2]->on == 0) continue;
        CpCanvas::ata[n2]->HitGo(0);
    }
    for (n2 = 0; n2 < 3; ++n2) {
        for (n = 0; n < 3; ++n) {
            CpCanvas::panel[n * 6 + n2]->Move();
        }
    }
    for (n2 = 5; n2 > 2; --n2) {
        for (n = 0; n < 3; ++n) {
            CpCanvas::panel[n * 6 + n2]->Move();
        }
    }
    CpCanvas::g->drawImage(CpCanvas::imgMap, 0, 0);
    CharaDraw(1);
    drawImg3(43, 0, 48, 40, false);
    if (CpCanvas::cus_gage < 128) {
        CpCanvas::g->setColor(Graphics::getColorOfRGB(198, 210, 234));
    } else {
        CpCanvas::g->setColor(Graphics::getColorOfRGB(CpCanvas::game_cnt / 3 % 2 * 248, 248, CpCanvas::game_cnt / 3 % 2 * 248));
    }
    CpCanvas::g->fillRect(56, 50, CpCanvas::cus_gage, 6);
    CpCanvas::rock->WanaDraw();
    CpCanvas::rock->HpDraw(0, 0);
    if (CpCanvas::combo_time > 0) {
        CpCanvas::dell_lv = (CpCanvas::combo - 1) * 2;
        drawImg3(43, 39 + CpCanvas::combo, 67, 65, false);
        drawImg3(43, 43, 122, 65, false);
        if (--CpCanvas::combo_time == 0) {
            CpCanvas::combo = 1;
        }
    }
    CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
    CpCanvas::g->fillRect(0, 0, 240, 40);
    CpCanvas::g->fillRect(0, 200, 240, 40);
    CpCanvas::rock->TipDraw();
    if (CpCanvas::dell_cnt > 0) {
        if (CpCanvas::combo > 1 && CpCanvas::combo_time == 0) {
            CpCanvas::combo_time = 15;
        }
        if (--CpCanvas::dell_cnt != 10) return;
        Audio(1, 5);
        CpCanvas::audio_mill = (long long)SDL_GetTicks64();
        CpCanvas::dell_cnt = -20;
        CpCanvas::key = 0;
        return;
    }
    if ((CpCanvas::cus_gage += CpCanvas::cus_sp) > 128) {
        if (CpCanvas::cus_se_flg == 0) {
            seSet(11, 99);
            CpCanvas::cus_se_flg = 1;
        }
        CpCanvas::soft_id[0] = 1;
        CpCanvas::soft_id[1] = 1;
        CpCanvas::cus_gage = 128;
    }
    if (CpCanvas::combo_cnt > 0) {
        --CpCanvas::combo_cnt;
    } else if (CpCanvas::combo > 1 && CpCanvas::combo_time == 0) {
        CpCanvas::combo_time = 15;
    } else if (CpCanvas::combo_time == 0) {
        CpCanvas::combo = 1;
    }
    ++CpCanvas::eria_cnt;
    ++CpCanvas::bas_cnt;
}


// ==================== MotionBack ====================
void CpCanvas::MotionBack() {
    int n;
    if (Rock::ani_cnt > 0) {
        Rock::ani_cnt = CpCanvas::rock->t_ani_cnt;
        Rock::s_wait = CpCanvas::rock->tmp_s_wait;
        Rock::r_suu = CpCanvas::rock->tmp_r_suu;
        Rock::e_wait = CpCanvas::rock->tmp_e_wait;
    }
    for (n = 0; n < 3; ++n) {
        if (CpCanvas::ene[n]->on == 0 || CpCanvas::ene[n]->ani_cnt <= 0) continue;
        CpCanvas::ene[n]->ani_cnt = CpCanvas::ene[n]->t_ani_cnt;
        CpCanvas::ene[n]->s_wait = CpCanvas::ene[n]->tmp_s_wait;
        CpCanvas::ene[n]->r_suu = CpCanvas::ene[n]->tmp_r_suu;
        CpCanvas::ene[n]->e_wait = CpCanvas::ene[n]->tmp_e_wait;
    }
    for (n = 0; n < 30; ++n) {
        if (CpCanvas::ata[n]->on == 0) continue;
        CpCanvas::ata[n]->ani_cnt = CpCanvas::ata[n]->t_ani_cnt;
        CpCanvas::ata[n]->s_wait = CpCanvas::ata[n]->tmp_s_wait;
        CpCanvas::ata[n]->r_suu = CpCanvas::ata[n]->tmp_r_suu;
        CpCanvas::ata[n]->e_wait = CpCanvas::ata[n]->tmp_e_wait;
    }
}

// ==================== BasLv ====================
int CpCanvas::BasLv() {
    int n;
    int n2 = 7;
    if (CpCanvas::boss_flg == 0) {
        n2 = 7;
        if (CpCanvas::bas_cnt / 300 >= 5) {
            --n2;
        }
        if (CpCanvas::bas_cnt / 300 >= 12) {
            --n2;
        }
        if (CpCanvas::bas_cnt / 300 >= 36) {
            --n2;
        }
    } else {
        n2 = 10;
        if (CpCanvas::bas_cnt / 300 >= 30) {
            n2 -= 2;
        }
        if (CpCanvas::bas_cnt / 300 >= 40) {
            n2 -= 2;
        }
        if (CpCanvas::bas_cnt / 300 >= 50) {
            n2 -= 2;
        }
    }
    n2 = (n = Rock::noke_cnt) > 4 ? (n2 -= 3) : (n2 -= n - 1);
    if (Rock::move_cnt < 3) {
        ++n2;
    }
    return n2 += CpCanvas::dell_lv;
}

// ==================== Ann ====================
void CpCanvas::Ann(int n, int n2) {
    if (n == 0) {
        if (n2 == 0) {
            CpCanvas::tmp_R = BtPanel::R;
            CpCanvas::tmp_G = BtPanel::G;
            CpCanvas::tmp_B = BtPanel::B;
        }
        BtPanel::R = BtPanel::R * 4 / 5;
        BtPanel::G = BtPanel::G * 4 / 5;
        BtPanel::B = BtPanel::B * 4 / 5;
    } else {
        BtPanel::R = BtPanel::R * 5 / 4;
        BtPanel::G = BtPanel::G * 5 / 4;
        BtPanel::B = BtPanel::B * 5 / 4;
        if (BtPanel::R > CpCanvas::tmp_R) BtPanel::R = CpCanvas::tmp_R;
        if (BtPanel::G > CpCanvas::tmp_G) BtPanel::G = CpCanvas::tmp_G;
        if (BtPanel::B > CpCanvas::tmp_B) BtPanel::B = CpCanvas::tmp_B;
    }
    CpCanvas::graMap->setColor(Graphics::getColorOfRGB(BtPanel::R, BtPanel::G, BtPanel::B));
    CpCanvas::graMap->fillRect(0, 0, 240, 240);
    for (int n3 = 0; n3 < 3; ++n3) {
        for (int n4 = 0; n4 < 6; ++n4) {
            CpCanvas::panel[n3 * 6 + n4]->Draw(n3, true);
        }
    }
}

// ==================== CharaDraw ====================
void CpCanvas::CharaDraw(int n) {
    int n2;
    int n3;
    for (n3 = 0; n3 < 3; ++n3) {
        for (n2 = 0; n2 < 6; ++n2) {
            CpCanvas::panel[n3 * 6 + n2]->Draw2();
        }
    }
    for (n3 = 0; n3 < 3; ++n3) {
        for (n2 = 0; n2 < 4; ++n2) {
            if (n2 < 3) {
                if (CpCanvas::ene[n2]->on == 0 || CpCanvas::ene[n2]->pos_y != n3) continue;
                CpCanvas::ene[n2]->Draw(n);
                continue;
            }
            if (Rock::pos_y != n3) continue;
            CpCanvas::rock->Draw(n);
        }
        for (n2 = 0; n2 < 6; ++n2) {
            if (n3 != CpCanvas::oki[n2]->pos_y) continue;
            CpCanvas::oki[n2]->Draw();
        }
        for (n2 = 0; n2 < 30; ++n2) {
            if (n3 != CpCanvas::ata[n2]->pos_y) continue;
            CpCanvas::ata[n2]->Draw(1, n);
        }
    }
    for (n3 = 0; n3 < 30; ++n3) {
        CpCanvas::ata[n3]->Draw(2, n);
    }
    for (n3 = 0; n3 < 3; ++n3) {
        if (CpCanvas::ene[n3]->on == 0) continue;
        CpCanvas::ene[n3]->HpDraw();
    }
    CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
    CpCanvas::g->fillRect(0, 0, 240, 40);
}

// ==================== BattleTip ====================
void CpCanvas::BattleTip() {
    int n;
    int n2;
    CpCanvas::soft_id[0] = 0;
    CpCanvas::soft_id[1] = 0;
    CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
    CpCanvas::g->fillRect(0, 200, 240, 40);
    
    if (CpCanvas::esc_flg != 0) {
        if (CpCanvas::esc_flg > 1) {
            CpCanvas::g->drawImage(CpCanvas::imgMap, 0, 40, 0, 40, 240, 160);
            CharaDraw(0);
        }
        CpCanvas::g->fillRect(0, 160, 240, 80);
        CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 255, 255));
        CpCanvas::g->fillRect(2, 162, 236, 76);
        FaceDraw(6);
        n2 = MesDraw(0) ? 1 : 0;
        if (CpCanvas::yes_no_flg != 0) {
            if (CpCanvas::key == 65536) {
                CpCanvas::yes_no_flg = 1;
                CpCanvas::key = 0;
            }
            if (CpCanvas::key == 262144) {
                CpCanvas::yes_no_flg = 2;
                CpCanvas::key = 0;
            }
        }
        if (CpCanvas::key == 0x100000) {
            if (CpCanvas::esc_flg == 1) {
                if (n2 != 0) {
                    if (CpCanvas::yes_no_flg == 0) {
                        CpCanvas::esc_flg = 0;
                    }
                    if (CpCanvas::yes_no_flg == 1) {
                        ++CpCanvas::esc_flg;
                        MesRead(122, nullptr, 3);
                        Rock::tip_no = -1;
                        for (n = 0; n < 10; ++n) {
                            CpCanvas::cas_ok[n] = 1;
                        }
                    } else {
                        CpCanvas::esc_flg = 0;
                        CpCanvas::g->drawImage(CpCanvas::imgMap, 0, 40, 0, 40, 240, 160);
                        CharaDraw(0);
                    }
                    CpCanvas::yes_no_flg = 0;
                } else {
                    CpCanvas::mes_cnt = 90;
                }
            } else if (CpCanvas::esc_flg == 2) {
                if (n2 != 0) {
                    if (EscCh()) {
                        MesRead(123, nullptr, 3);
                        CpCanvas::esc_flg = 3;
                    } else {
                        MesRead(124, nullptr, 3);
                        CpCanvas::esc_flg = 4;
                    }
                }
            } else if (CpCanvas::esc_flg == 3) {
                if (n2 != 0) {
                    CpCanvas::bas_flg = 0;
                    CpCanvas::scene = CpCanvas::back_menu;
                    if (CpCanvas::back_menu == 3) {
                        Audio(1, CpCanvas::map_bgm);
                    } else {
                        Audio(1, 3);
                        MachiSet(CpCanvas::machi_no, 0);
                        CpCanvas::ivent_flg = 0;
                    }
                    CpCanvas::win_flg = 1;
                    if (CpCanvas::ivent_flg < 0) {
                        CpCanvas::now_hp = Rock::hp;
                    }
                    CpCanvas::esc_flg = 0;
                    return;
                }
                CpCanvas::mes_cnt = 90;
            } else if (CpCanvas::esc_flg == 4) {
                if (n2 != 0) {
                    CpCanvas::cas_cnt = 15;
                    CpCanvas::esc_flg = 0;
                } else {
                    CpCanvas::mes_cnt = 90;
                }
            }
            CpCanvas::key = 0;
        }
        if (CpCanvas::esc_flg != 0) {
            return;
        }
    }
    
    if (CpCanvas::pa_cnt2 > 0) {
        // PA animation
        if (CpCanvas::pa_cnt2 < 4) {
            Ann(0, CpCanvas::pa_cnt2 - 1);
        }
        ++CpCanvas::pa_cnt2;
        CpCanvas::tmp_graMap->drawImage(CpCanvas::imgMap, 0, 0);
        CpCanvas::g->drawImage(CpCanvas::tmp_imgMap, 0, 0);
        CpCanvas::rock->HpDraw(0, 0);
        CharaDraw(0);
        drawImg3(43, 0, 48, 40, false);
        drawImg3(44, 124, 8, 65, false);
        // Additional PA drawing code...
        CpCanvas::rock->WanaDraw();
        CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
        CpCanvas::g->fillRect(0, 0, 240, 40);
        CpCanvas::g->fillRect(0, 200, 240, 40);
        if (CpCanvas::pa_cnt2 >= 60) {
            Ann(1, 64 - CpCanvas::pa_cnt2);
            if (CpCanvas::pa_cnt2 == 64) {
                CpCanvas::pa_cnt2 = 0;
                CpCanvas::key = 0;
            }
        }
        CpCanvas::key = 0;
        return;
    }
    
    if (CpCanvas::ren_flg > 0 && CpCanvas::bas_cnt == 0) {
        // Ren battle start animation
        CpCanvas::g->drawImage(CpCanvas::imgMap, 0, 40, 0, 40, 240, 160);
        CharaDraw(0);
        drawImg3(43, 0, 48, 40, false);
        CpCanvas::rock->HpDraw(0, 0);
        if (++CpCanvas::cas_cnt == 14) {
            CpCanvas::bas_cnt = 1;
            CpCanvas::cus_gage = 0;
            CpCanvas::cas_cnt = -3;
            CpCanvas::cus_se_flg = 0;
            CpCanvas::key = 0;
        }
    } else if (CpCanvas::cas_cnt < 0) {
        int n3 = CpCanvas::cas_tip[CpCanvas::sel_cas_tip];
        if (n3 > 0) {
            n3 = CpCanvas::tip_list[n3] >> 8 & 0xFF;
            MesRead(CpCanvas::tip[n3]->setu_id, nullptr, 4);
        }
        CpCanvas::g->drawImage(CpCanvas::imgMap, 0, 40, 0, 40, 240, 160);
        CharaDraw(0);
        drawImg3(43, 2, CpCanvas::cas_cnt * 40, 40, false);
        CpCanvas::rock->HpDraw(120 + CpCanvas::cas_cnt * 40, 0);
        ++CpCanvas::cas_cnt;
        CpCanvas::key = 0;
    } else if (CpCanvas::cas_cnt > 0) {
        CpCanvas::g->drawImage(CpCanvas::imgMap, 0, 40, 0, 40, 240, 160);
        CharaDraw(0);
        drawImg3(43, 0, 48, 40, false);
        CpCanvas::rock->HpDraw(0, 0);
        int nArray[] = {4, 9, 16, 18, 16, 16, 16, 16, 16, 16, 16, 16, 16, 9, 4};
        CpCanvas::g->drawScaledImage((Image*)CpCanvas::image[43], 52, 104 + (16 - nArray[15 - CpCanvas::cas_cnt]) / 2, 68, nArray[15 - CpCanvas::cas_cnt], 120, 0, 68, 16);
        CpCanvas::g->drawScaledImage((Image*)CpCanvas::image[43], 120, 104 + (16 - nArray[15 - CpCanvas::cas_cnt]) / 2, 68, nArray[15 - CpCanvas::cas_cnt], 120, 16, 68, 16);
        if (--CpCanvas::cas_cnt == 0) {
            --CpCanvas::scene;
            CpCanvas::cus_gage = 0;
            CpCanvas::cus_se_flg = 0;
            CpCanvas::key = 0;
        }
    } else {
        int n4;
        int n5;
        CpCanvas::soft_id[0] = 2;
        CpCanvas::soft_id[1] = 3;
        if (CpCanvas::key == 65536) {
            if (CpCanvas::sel_cas_mode == 0) {
                if (CpCanvas::sel_cas_tip % 5 == 0) {
                    CpCanvas::sel_cas_mode = 1;
                } else {
                    --CpCanvas::sel_cas_tip;
                }
            } else {
                if (CpCanvas::max_sel != 0) {
                    CpCanvas::sel_cas_mode = 0;
                }
                if ((CpCanvas::sel_cas_tip = 4) >= CpCanvas::max_sel - 1) {
                    CpCanvas::sel_cas_tip = CpCanvas::max_sel - 1;
                }
            }
            CpCanvas::key = 0;
        } else if (CpCanvas::key == 262144) {
            if (CpCanvas::sel_cas_mode == 0) {
                if (CpCanvas::max_sel - 1 == CpCanvas::sel_cas_tip || CpCanvas::sel_cas_tip == 4) {
                    CpCanvas::sel_cas_mode = 1;
                } else {
                    ++CpCanvas::sel_cas_tip;
                }
            } else {
                if (CpCanvas::max_sel != 0) {
                    CpCanvas::sel_cas_mode = 0;
                }
                CpCanvas::sel_cas_tip = 0;
            }
            CpCanvas::key = 0;
        } else if (CpCanvas::key == 131072) {
            if (CpCanvas::sel_cas_mode == 0) {
                if (CpCanvas::sel_cas_tip > 4) {
                    CpCanvas::sel_cas_tip -= 5;
                }
            } else {
                CpCanvas::sel_cas_mode = 1;
            }
            CpCanvas::key = 0;
        } else if (CpCanvas::key == 524288) {
            if (CpCanvas::sel_cas_mode == 0) {
                if (CpCanvas::sel_cas_tip + 5 < CpCanvas::max_sel) {
                    CpCanvas::sel_cas_tip += 5;
                }
            } else if (CpCanvas::sec_cha != 0 || CpCanvas::sel_cnt > 0) {
                CpCanvas::sel_cas_mode = 2;
            }
            CpCanvas::key = 0;
        }
        drawImg3(43, 2, 0, 40, false);
        if (CpCanvas::sec_cha != 0 && CpCanvas::sel_cnt == 0) {
            drawImg3(43, 61, 90, 179, false);
        }
        CpCanvas::rock->HpDraw(120, 0);
        CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 255, 255));
        CpCanvas::g->fillRect(2, 202, 236, 36);
        CasOk();
        for (n2 = 0; n2 < 10; ++n2) {
            n5 = CpCanvas::cas_tip[n2];
            if (n5 < 0) continue;
            n4 = CpCanvas::tip_list[n5] & 0xFF;
            if (n4 < 100) {
                drawImg3(43, 3 + n4, 12 + n2 % 5 * 16, 106 + n2 / 5 * 24 + 55, false);
            } else {
                drawImg3(43, 3, 13 + n2 % 5 * 16, 106 + n2 / 5 * 24 + 55, false);
            }
            if (CpCanvas::cas_ok[n2] == 0) continue;
            n = CasCh(n5) ? 1 : 0;
            CpCanvas::cas_ok[n2] = n == 0 ? 2 : 1;
            CpCanvas::tip[CpCanvas::tip_list[n5] >> 8 & 0xFF]->Draw(9 + n2 % 5 * 16, 106 + n2 / 5 * 24 + 40, 2, n != 0);
        }
        for (n2 = 0; n2 < CpCanvas::sel_cnt; ++n2) {
            n5 = CpCanvas::cas_tip[CpCanvas::set_tip[n2]];
            CpCanvas::tip[CpCanvas::tip_list[n5] >> 8 & 0xFF]->Draw(97, 71 + n2 * 16, 2, true);
        }
        if (CpCanvas::fol[CpCanvas::now_fol]->regu_flg != 0 && CpCanvas::cas_tip[0] == CpCanvas::fol[CpCanvas::now_fol]->tip_id[CpCanvas::fol[CpCanvas::now_fol]->regu_id] && CpCanvas::bas_cnt == 0) {
            drawImg3(43, 44, 3, 143, false);
        }
        CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 208 * (CpCanvas::game_cnt / 3 % 2), 0));
        if (CpCanvas::sel_cas_mode == 0) {
            int n6 = CpCanvas::sel_cas_tip % 5;
            int n7 = CpCanvas::sel_cas_tip / 5;
            CpCanvas::g->drawRect(7 + n6 * 16, 144 + n7 * 24, 15, 15);
            CpCanvas::g->drawRect(8 + n6 * 16, 145 + n7 * 24, 13, 13);
            if (CpCanvas::cas_tip[CpCanvas::sel_cas_tip] > 0) {
                n5 = CpCanvas::tip_list[CpCanvas::cas_tip[CpCanvas::sel_cas_tip]] >> 8 & 0xFF;
                n4 = CpCanvas::tip_list[CpCanvas::cas_tip[CpCanvas::sel_cas_tip]] & 0xFF;
                CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
                strDraw(CpCanvas::tip[n5]->name, 2, 62);
                CpCanvas::tip[n5]->DrawPow2(20, 79);
                CpCanvas::tip[n5]->DrawCode(n4, 61, 90, 1);
                CpCanvas::tip[n5]->DrawZoku(58, 96);
                drawImg3(44, 65 + n5 / 125 + n5 / 177, 34, 126, false);
                MesRead(CpCanvas::tip[n5]->setu_id, nullptr, 4);
                MesDraw2(2, 40, 217, 0);
            }
        } else if (CpCanvas::sel_cas_mode == 1) {
            CpCanvas::g->drawRect(90, 158, 21, 19);
            CpCanvas::g->drawRect(89, 157, 23, 21);
            MesRead(157, nullptr, 3);
            MesDraw2(2, 40, 217, 0);
        } else {
            CpCanvas::g->drawRect(90, 179, 20, 12);
            CpCanvas::g->drawRect(89, 178, 22, 14);
            if (CpCanvas::sec_cha != 0 && CpCanvas::sel_cnt == 0) {
                MesRead(159, nullptr, 3);
            } else {
                MesRead(158, nullptr, 3);
            }
            MesDraw2(2, 40, 217, 0);
        }
        if (CpCanvas::key == 0x200000) {
            if (CpCanvas::sel_cnt > 0 && CpCanvas::sel_cas_mode != 2) {
                CpCanvas::cas_ok[CpCanvas::set_tip[--CpCanvas::sel_cnt]] = 1;
                CpCanvas::set_tip[CpCanvas::sel_cnt] = -1;
                if (CpCanvas::sel_cnt == 0) {
                    for (n2 = 0; n2 < 10; ++n2) {
                        CpCanvas::cas_ok[n2] = 1;
                    }
                }
            }
            CpCanvas::key = 0;
        } else if (CpCanvas::key == 0x100000) {
            if (CpCanvas::sel_cas_mode == 0) {
                if (CpCanvas::sel_cnt < 5 && CpCanvas::cas_ok[CpCanvas::sel_cas_tip] == 1) {
                    CpCanvas::set_tip[CpCanvas::sel_cnt] = CpCanvas::sel_cas_tip;
                    CpCanvas::cas_ok[CpCanvas::sel_cas_tip] = 0;
                    ++CpCanvas::sel_cnt;
                    Audio(1, 11);
                } else {
                    Audio(1, 12);
                }
            } else {
                Audio(1, 11);
                if (CpCanvas::sel_cas_mode == 1) {
                    TipIn();
                } else if (CpCanvas::sel_cas_mode == 2) {
                    if (CpCanvas::sec_cha != 0 && CpCanvas::sel_cnt == 0) {
                        for (n2 = 0; n2 < CpCanvas::max_sel; ++n2) {
                            if (CpCanvas::cas_ok[n2] == 0) continue;
                            CpCanvas::fol[CpCanvas::now_fol]->used[CpCanvas::fol_tip_no[n2]] = 0;
                            ++CpCanvas::fol[CpCanvas::now_fol]->tip_zan;
                            CpCanvas::cas_tip[n2] = -1;
                        }
                        n2 = CpCanvas::sel_cnt;
                        CpCanvas::fol[CpCanvas::now_fol]->RandSet(CpCanvas::max_sel);
                        CpCanvas::cas_cnt = 0;
                        CpCanvas::sel_cnt = n2;
                        CpCanvas::sel_cas_mode = 1;
                        CpCanvas::sec_cha = 0;
                        CpCanvas::key = 0;
                        return;
                    }
                    for (n2 = 0; n2 < CpCanvas::sel_cnt; ++n2) {
                        CpCanvas::cas_tip[CpCanvas::set_tip[n2]] = -1;
                    }
                    Rock::tip_no = -1;
                    if ((CpCanvas::max_sel += CpCanvas::sel_cnt) > 9) {
                        CpCanvas::max_sel = 10;
                    }
                }
                for (n2 = 0; n2 < 10; ++n2) {
                    if (CpCanvas::cas_tip[n2] >= 0) continue;
                    for (n = n2 + 1; n < 10; ++n) {
                        if (CpCanvas::cas_tip[n] < 0) continue;
                        CpCanvas::cas_tip[n2] = CpCanvas::cas_tip[n];
                        CpCanvas::cas_ok[n2] = 1;
                        CpCanvas::cas_tip[n] = -1;
                        CpCanvas::cas_ok[n] = 0;
                        n += 10;
                    }
                }
                CpCanvas::cas_cnt = 15;
                CpCanvas::sec_cha = 0;
            }
            CpCanvas::key = 0;
        } else if (CpCanvas::key == 0x400000) {
            CpCanvas::esc_flg = 1;
            if (CpCanvas::non_esc == 0) {
                MesRead(121, nullptr, 3);
                CpCanvas::yes_no_flg = 2;
            } else {
                MesRead(152, nullptr, 3);
            }
            CpCanvas::key = 0;
        }
    }
}


// ==================== EscCh ====================
bool CpCanvas::EscCh() {
    int n = 1;
    int n2 = (int)((unsigned int)CpCanvas::rand() >> 1) % 100;
    for (int i = 0; i < 3; ++i) {
        if (CpCanvas::ene[i]->on == 0) continue;
        n += CpCanvas::ene[i]->hp;
    }
    return (n = CpCanvas::max_hp * 30 / n) > n2;
}

// ==================== CasOk ====================
void CpCanvas::CasOk() {
    int n;
    if (CpCanvas::sel_cnt == 0) {
        CpCanvas::ok_code = 0;
        CpCanvas::ok_tip = 0;
        return;
    }
    CpCanvas::ok_tip = CpCanvas::tip_list[CpCanvas::cas_tip[CpCanvas::set_tip[0]]] >> 8 & 0xFF;
    for (n = 0; n < CpCanvas::sel_cnt && (CpCanvas::ok_code = CpCanvas::tip_list[CpCanvas::cas_tip[CpCanvas::set_tip[n]]] & 0xFF) == 100; ++n) {
    }
    n = 1;
    for (int i = 1; i < CpCanvas::sel_cnt; ++i) {
        int n2 = CpCanvas::tip_list[CpCanvas::cas_tip[CpCanvas::set_tip[i]]] & 0xFF;
        int n3 = CpCanvas::tip_list[CpCanvas::cas_tip[CpCanvas::set_tip[i]]] >> 8 & 0xFF;
        if (n2 == 100) {
            ++n;
        }
        if (n2 != 100 && n2 != CpCanvas::ok_code) {
            CpCanvas::ok_code = -1;
        }
        if (n3 == CpCanvas::ok_tip) continue;
        CpCanvas::ok_tip = -1;
    }
    if (CpCanvas::ok_code == 100 && n == CpCanvas::sel_cnt) {
        CpCanvas::ok_code = 0;
    }
}

// ==================== CasCh ====================
bool CpCanvas::CasCh(int n) {
    if (CpCanvas::ok_tip == 0 || CpCanvas::ok_code == 0) {
        return true;
    }
    int n2 = CpCanvas::tip_list[n] & 0xFF;
    int n3 = CpCanvas::tip_list[n] >> 8 & 0xFF;
    if (CpCanvas::ok_tip == n3) {
        return true;
    }
    return CpCanvas::ok_code > 0 && n2 == 100 || CpCanvas::ok_code == n2;
}

// ==================== TipIn ====================
void CpCanvas::TipIn() {
    int n;
    int n2;
    if (CpCanvas::sel_cnt == 0) {
        return;
    }
    CpCanvas::pa_no = PACh();
    for (n2 = 0; n2 < CpCanvas::sel_cnt; ++n2) {
        CpCanvas::pa_tip[n2] = CpCanvas::cas_tip[CpCanvas::set_tip[n2]];
        n = CpCanvas::tip_list[CpCanvas::pa_tip[n2]] >> 8 & 0xFF;
        if (CpCanvas::pa_no < 0) {
            CpCanvas::rock->tip[CpCanvas::sel_cnt - n2 - 1] = CpCanvas::tip[n];
        }
        CpCanvas::cas_tip[CpCanvas::set_tip[n2]] = -1;
        if (CpCanvas::set_tip[n2] != 0) continue;
        CpCanvas::regu_flg = 0;
    }
    Rock::tip_no = CpCanvas::sel_cnt - 1;
    if (CpCanvas::pa_no > 0) {
        n2 = CpCanvas::pa_no;
        AddLib(n2);
        for (int i = 0; i < CpCanvas::sel_cnt; ++i) {
            n = CpCanvas::tip_list[CpCanvas::pa_tip[i]] >> 8 & 0xFF;
            if (i < CpCanvas::pa_start) {
                CpCanvas::rock->tip[CpCanvas::sel_cnt - i - CpCanvas::pa_cnt] = CpCanvas::tip[n];
                continue;
            }
            if (i >= CpCanvas::pa_start && i < CpCanvas::pa_start + CpCanvas::pa_cnt) {
                CpCanvas::rock->tip[CpCanvas::sel_cnt - CpCanvas::pa_start - CpCanvas::pa_cnt] = CpCanvas::tip[CpCanvas::pa_no];
                continue;
            }
            CpCanvas::rock->tip[CpCanvas::sel_cnt - i - 1] = CpCanvas::tip[n];
        }
        Rock::tip_no -= CpCanvas::pa_cnt - 1;
        CpCanvas::pa_cnt2 = 1;
    }
    CpCanvas::rock->TipNext();
}

// ==================== PACh ====================
int CpCanvas::PACh() {
    if (CpCanvas::sel_cnt < 3) {
        return -1;
    }
    int n = -1;
    int n2 = 0;
    for (int i = 0; i < CpCanvas::sel_cnt; ++i) {
        int n3 = CpCanvas::cas_tip[CpCanvas::set_tip[i]];
        int n4 = CpCanvas::tip_list[n3] >> 8 & 0xFF;
        int n5 = CpCanvas::tip_list[n3] & 0xFF;
        for (int j = 0; j < 34; ++j) {
            CpCanvas::pa_code_flg = 0;
            n = PaNo(n4, n5, j, 0);
            if (n < 0) continue;
            CpCanvas::pa_start = i;
            for (n2 = 1; n2 < 4; ++n2) {
                if (n2 == 3 && CpCanvas::pa_data[n * 9 + 3] == 0) {
                    n2 = 4;
                    CpCanvas::pa_cnt = 3;
                    CpCanvas::pa_tip[3] = 0;
                    break;
                }
                if (i + n2 < CpCanvas::sel_cnt) {
                    int n6 = CpCanvas::cas_tip[CpCanvas::set_tip[i + n2]];
                    int n7 = CpCanvas::tip_list[n6] >> 8 & 0xFF;
                    int n8 = CpCanvas::tip_list[n6] & 0xFF;
                    if (PaNo(n7, n8, n, n2) != n) {
                        n = -1;
                        break;
                    }
                } else {
                    CpCanvas::pa_cnt = -1;
                    break;
                }
                CpCanvas::pa_cnt = 4;
            }
            if (n2 != 4) continue;
            return CpCanvas::pa_data[n * 9 + 8];
        }
    }
    return -1;
}

// ==================== PaNo ====================
int CpCanvas::PaNo(int n, int n2, int n3, int n4) {
    if (CpCanvas::pa_data[n3 * 9 + n4] == 0) {
        return n3;
    }
    if (CpCanvas::pa_data[n3 * 9 + n4] == n) {
        if (CpCanvas::pa_data[n3 * 9 + n4 + 4] == 0) {
            return n3;
        }
        if (CpCanvas::pa_data[n3 * 9 + n4 + 4] == n2) {
            return n3;
        }
        if (n2 == 100 && CpCanvas::pa_code_flg == 0) {
            CpCanvas::pa_code_flg = 1;
            return n3;
        }
    }
    return -1;
}

// ==================== MldSet ====================
void CpCanvas::MldSet() {
    // Simplified: audio setup is handled differently in SDL2
    try {
        auto _buf = Resources::jarGet(5, CpCanvas::dat);
        int _p = 0;
        auto _ri = [&]() -> int {
            int v = ((int)(uint8_t)_buf[_p]<<24)|((int)(uint8_t)_buf[_p+1]<<16)|((int)(uint8_t)_buf[_p+2]<<8)|(int)(uint8_t)_buf[_p+3];
            _p+=4; return v;
        };
        int nArray[16];
        for (int i = 0; i < 16; ++i) {
            nArray[i] = _ri();
        }
        for (int i = 0; i < 16; ++i) {
            CpCanvas::audio[i] = new AudioPresenter(i < 11 ? AudioPresenter::Type::BGM : AudioPresenter::Type::SE);
            DrawBar(2, (i + 1) * 35 / 16);
        }
    } catch (...) {}
}

// ==================== ImgSet2 ====================
void CpCanvas::ImgSet2(int n) {
    try {
        auto _buf = Resources::jarGet(3, CpCanvas::dat);
        int _p = 0;
        auto _ri = [&]() -> int {
            int v = ((int)(uint8_t)_buf[_p]<<24)|((int)(uint8_t)_buf[_p+1]<<16)|((int)(uint8_t)_buf[_p+2]<<8)|(int)(uint8_t)_buf[_p+3];
            _p+=4; return v;
        };
        if (CpCanvas::img_siz3[0] == 0) {
            for (int n2 = 0; n2 < 22; ++n2) {
                CpCanvas::img_siz3[n2] = _ri();
            }
        }
        // Skip to correct image
        int skipBytes = 88;
        for (int i = 0; i < n; ++i) {
            skipBytes += CpCanvas::img_siz3[i];
        }
        // Load image data
    } catch (...) {}
}

// ==================== PalSet ====================
void CpCanvas::PalSet(int n, int n2) {
    try {
        auto _buf = Resources::jarGet(4, CpCanvas::dat);
        // Palette loading implementation
    } catch (...) {}
}

// ==================== ImgSet ====================
void CpCanvas::ImgSet() {
    int nArray[37];
    nArray[0] = 3544;
    for (int i = 1; i < 37; ++i) {
        nArray[i] = nArray[i - 1] + CpCanvas::dat[i - 1];
        DrawBar(0, (i + 1) * 10 / 37);
    }
    try {
        auto _buf = Resources::jarGet(1, CpCanvas::dat);
        int _p = 0;
        auto _ri = [&]() -> int {
            int v = ((int)(uint8_t)_buf[_p]<<24)|((int)(uint8_t)_buf[_p+1]<<16)|((int)(uint8_t)_buf[_p+2]<<8)|(int)(uint8_t)_buf[_p+3];
            _p+=4; return v;
        };
        int imgSizes[58];
        for (int i = 0; i < 42; ++i) {
            imgSizes[i] = _ri();
        }
        // Load images
        for (int i = 0; i < 42; ++i) {
            DrawBar(0, 10 + (i + 1) * 90 / 42);
        }
    } catch (...) {}
    ImgSet2(0);
}

// ==================== JarGet ====================
std::vector<uint8_t> CpCanvas::JarGet(int n) {
    return Resources::jarGet(n, CpCanvas::dat);
}


// ==================== Ani (8 params) ====================
int CpCanvas::Ani(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
    if (n >= 42 || n2 < 0) return -2;
    int n9 = CpCanvas::a_dx[n][n2][n3] + n6;
    int n10 = CpCanvas::a_dy[n][n2][n3] + n7;
    int animId = CpCanvas::ani[n][n2][n3];
    if (animId < 0) {
        return animId;
    }
    n5 *= 24;
    drawImg2(n, animId, n4 * 40, n5 + 105, n9, n10, n8);
    return animId;
}

// ==================== AniSe ====================
int CpCanvas::AniSe(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
    if (n >= 42 || n2 < 0) return -2;
    int n11 = CpCanvas::a_dx[n][n2][n3] + n6;
    int n12 = CpCanvas::a_dy[n][n2][n3] + n7;
    int animId = CpCanvas::ani[n][n2][n3];
    if (animId < 0) {
        return animId;
    }
    n5 *= 24;
    drawImg2(n, animId, n4 * 40, n5 + 105, n11, n12, n8);
    if (n10 == 0 && n9 > 0) {
        seSet(n9 - 10, 0);
    }
    return animId;
}

// ==================== Ani (5 params) ====================
int CpCanvas::Ani(int n, int n2, int n3, int n4, int n5) {
    if (n >= 42 || n2 < 0) return -2;
    int n6 = 0;
    if (n2 == 2) {
        n6 = 1;
    }
    int animId = CpCanvas::ani[n][n2][n3];
    if (animId < 0) {
        return animId;
    }
    drawImg2(n, animId, n4, n5, n6);
    return animId;
}

// ==================== drawImg2 (7 params) ====================
void CpCanvas::drawImg2(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
    if (n7 == 1) {
        CpCanvas::g->setFlipMode(n7);
        n3 = n3 - CpCanvas::dx[n][n2] * 2 - n5 * 2 - CpCanvas::sx[n][n2] + 40;
    }
    CpCanvas::g->drawImage((Image*)CpCanvas::image[n], n3 + CpCanvas::dx[n][n2] + n5, n4 + CpCanvas::dy[n][n2] + n6, CpCanvas::gx[n][n2], CpCanvas::gy[n][n2], CpCanvas::sx[n][n2], CpCanvas::sy[n][n2]);
    if (n7 != 0) {
        CpCanvas::g->setFlipMode(0);
    }
}

// ==================== drawImg2 (5 params) ====================
void CpCanvas::drawImg2(int n, int n2, int n3, int n4, int n5) {
    if (n5 == 1) {
        CpCanvas::g->setFlipMode(n5);
        n3 = n3 - CpCanvas::dx[n][n2] * 2 - CpCanvas::sx[n][n2] + 20;
    }
    CpCanvas::g->drawImage((Image*)CpCanvas::image[n], n3 + CpCanvas::dx[n][n2], n4 + CpCanvas::dy[n][n2], CpCanvas::gx[n][n2], CpCanvas::gy[n][n2], CpCanvas::sx[n][n2], CpCanvas::sy[n][n2]);
    if (n5 != 0) {
        CpCanvas::g->setFlipMode(0);
    }
}

// ==================== drawImg3 ====================
void CpCanvas::drawImg3(int n, int n2, int n3, int n4, bool bl) {
    if (bl) {
        CpCanvas::graMap->drawImage((Image*)CpCanvas::image[n], n3 + CpCanvas::dx[n][n2], n4 + CpCanvas::dy[n][n2], CpCanvas::gx[n][n2], CpCanvas::gy[n][n2], CpCanvas::sx[n][n2], CpCanvas::sy[n][n2]);
    } else {
        CpCanvas::g->drawImage((Image*)CpCanvas::image[n], n3 + CpCanvas::dx[n][n2], n4 + CpCanvas::dy[n][n2], CpCanvas::gx[n][n2], CpCanvas::gy[n][n2], CpCanvas::sx[n][n2], CpCanvas::sy[n][n2]);
    }
}

// ==================== drawImg4 ====================
void CpCanvas::drawImg4(int n, int n2, int n3, int n4) {
    CpCanvas::tmp_graMap->drawImage((Image*)CpCanvas::image[n], n3, n4, CpCanvas::gx[n][n2], CpCanvas::gy[n][n2], CpCanvas::sx[n][n2], CpCanvas::sy[n][n2]);
}

// ==================== BtSet ====================
void CpCanvas::BtSet(int n) {
    int n2;
    int n3;
    int nArray[18];
    int nArray2[12];
    CpCanvas::ghost = -1;
    CpCanvas::cus_sp = 1;
    CpCanvas::ene_cnt = 0;
    CpCanvas::dell_cnt = 0;
    CpCanvas::bas_cnt = 0;
    CpCanvas::rika_cnt = 0;
    CpCanvas::over_cnt = 0;
    CpCanvas::combo = 1;
    CpCanvas::combo_cnt = 0;
    CpCanvas::combo_time = 0;
    CpCanvas::bt_get[0] = 0;
    CpCanvas::bt_get[1] = 0;
    CpCanvas::bt_get[2] = 0;
    CpCanvas::eria_cnt = 0;
    CpCanvas::dell_lv = 0;
    CpCanvas::sec_cha = CpCanvas::skill_kouka[15];
    CpCanvas::ata_cnt = 0;
    CpCanvas::non_esc = 0;
    CpCanvas::boss_flg = 0;
    
    try {
        auto _buf = Resources::jarGet(31, CpCanvas::dat);
        int _p = n * 4 * 4;
        auto _ri = [&]() -> int {
            int v = ((int)(uint8_t)_buf[_p]<<24)|((int)(uint8_t)_buf[_p+1]<<16)|((int)(uint8_t)_buf[_p+2]<<8)|(int)(uint8_t)_buf[_p+3];
            _p+=4; return v;
        };
        if (CpCanvas::rank_flg == 0) {
            int n5 = _ri();
            for (n3 = 0; n3 < 3; ++n3) {
                int n4 = _ri();
                nArray2[n3 * 4 + 0] = n4 & 3;
                nArray2[n3 * 4 + 1] = (n4 >> 2) & 0x3F;
                nArray2[n3 * 4 + 2] = (n4 >> 8) & 0xF;
                nArray2[n3 * 4 + 3] = (n4 >> 12) & 0xF;
                if (nArray2[n3 * 4 + 3] == 0) {
                    nArray2[n3 * 4 + 3] = 10;
                }
            }
            auto _buf2 = Resources::jarGet(32, CpCanvas::dat);
            int _p2 = n5 * 4 * 3;
            auto _ri2 = [&]() -> int {
                int v = ((int)(uint8_t)_buf2[_p2]<<24)|((int)(uint8_t)_buf2[_p2+1]<<16)|((int)(uint8_t)_buf2[_p2+2]<<8)|(int)(uint8_t)_buf2[_p2+3];
                _p2+=4; return v;
            };
            for (n3 = 0; n3 < 3; ++n3) {
                int n4 = _ri2();
                nArray[n3 * 6 + 5] = n4 & 0xF;
                nArray[n3 * 6 + 4] = (n4 >> 4) & 0xF;
                nArray[n3 * 6 + 3] = (n4 >> 8) & 0xF;
                nArray[n3 * 6 + 2] = (n4 >> 12) & 0xF;
                nArray[n3 * 6 + 1] = (n4 >> 16) & 0xF;
                nArray[n3 * 6 + 0] = (n4 >> 20) & 0xF;
            }
            if (CpCanvas::ren_flg == 0) {
                if (n == 292 || n == 293 || n > 295) {
                    CpCanvas::boss_flg = 1;
                }
                if (n == 299 || n > 343 && n < 348) {
                    CpCanvas::boss_flg = 8;
                }
            }
        }
    } catch (...) {}
    
    if (CpCanvas::boss_flg != 0 || CpCanvas::rank_flg != 0 || CpCanvas::ren_flg != 0 || CpCanvas::ivent_flg >= 0) {
        CpCanvas::non_esc = 1;
    }
    Audio(1, 1 + CpCanvas::boss_flg);
    if (CpCanvas::scene == 5) {
        BtPanel::R = 155;
        BtPanel::G = 255;
        BtPanel::B = 210;
    } else {
        BtPanel::R = CpCanvas::R;
        BtPanel::G = CpCanvas::G;
        BtPanel::B = CpCanvas::B;
    }
    CpCanvas::graMap->setColor(Graphics::getColorOfRGB(BtPanel::R, BtPanel::G, BtPanel::B));
    CpCanvas::graMap->fillRect(0, 0, 240, 240);
    for (n2 = 0; n2 < 3; ++n2) {
        for (int i = 0; i < 6; ++i) {
            if (nArray[n2 * 6 + i] < 9) {
                CpCanvas::panel[n2 * 6 + i]->init(i, n2, nArray[n2 * 6 + i] - 1);
            } else {
                CpCanvas::panel[n2 * 6 + i]->init(i, n2, 1);
            }
            CpCanvas::panel[n2 * 6 + i]->Draw(-1, true);
        }
    }
    CpCanvas::fol[CpCanvas::now_fol]->init();
    for (n2 = 0; n2 < 30; ++n2) {
        CpCanvas::ata[n2] = new Attack(n2);
    }
    if (n == 344) {
        CpCanvas::now_hp = CpCanvas::max_hp;
    }
    CpCanvas::rock = new Rock();
    CpCanvas::ene[0] = new Ene();
    CpCanvas::ene[1] = new Ene();
    CpCanvas::ene[2] = new Ene();
    for (n2 = 0; n2 < 6; ++n2) {
        CpCanvas::oki[n2] = new Okimono(n2);
    }
    CpCanvas::rock->init();
    for (n2 = 0; n2 < 3; ++n2) {
        for (int i = 0; i < 6; ++i) {
            n3 = nArray[n2 * 6 + i];
            if (n3 <= 8) continue;
            if (n3 == 9) {
                CpCanvas::oki[4]->Set(1, i, n2, 0, 0);
            }
            if (n3 == 10) {
                CpCanvas::oki[5]->Set(1, i, n2, 0, 0);
            }
            if (n3 == 13) {
                CpCanvas::oki[2]->Set(12, i, n2, 0, 0);
            }
            if (n3 == 14) {
                CpCanvas::oki[4]->Set(13, i, n2, 0, 0);
            }
            if (n3 != 15) continue;
            CpCanvas::oki[5]->Set(13, i, n2, 0, 0);
        }
    }
    CpCanvas::key_cnt = 0;
    for (n2 = 0; n2 < 3; ++n2) {
        CpCanvas::ene[n2]->init(nArray2[1 + 4 * n2], nArray2[3 + 4 * n2], nArray2[2 + 4 * n2], nArray2[0 + 4 * n2], n2);
        EneSet(n2, nArray2[1 + 4 * n2] * 4 + nArray2[4 * n2]);
    }
    CpCanvas::drop_ene = (int)((unsigned int)CpCanvas::rand() >> 1) % CpCanvas::ene_cnt;
    for (n2 = 0; n2 < CpCanvas::ene_cnt; ++n2) {
        CpCanvas::bt_get[1] = CpCanvas::bt_get[1] + CpCanvas::ene[n2]->Get(1, 0);
        CpCanvas::bt_get[2] = CpCanvas::bt_get[2] + CpCanvas::ene[n2]->Get(2, 0);
    }
    CpCanvas::max_sel = 5 + CpCanvas::skill_kouka[0] + CpCanvas::skill_kouka[1] * 2;
    if (CpCanvas::max_sel > 10) {
        CpCanvas::max_sel = 10;
    }
    if (CpCanvas::fol[CpCanvas::now_fol]->regu_flg != 0) {
        CpCanvas::regu_flg = 1;
    }
    if (CpCanvas::scene != 1) {
        CpCanvas::back_menu = CpCanvas::scene;
    }
    if (CpCanvas::back_menu == 3 && CpCanvas::map_no > 53 && CpCanvas::map_no < 58) {
        CpCanvas::max_sel -= 2;
    }
    CpCanvas::scene = 1;
}

// ==================== AtaNo ====================
int CpCanvas::AtaNo(int n) {
    int n2;
    for (n2 = n; n2 < 29 && CpCanvas::ata[n2]->on != 0; ++n2) {
    }
    ++CpCanvas::ata_cnt;
    return n2;
}

// ==================== TipSet ====================
void CpCanvas::TipSet() {
    try {
        auto _buf = Resources::jarGet(21, CpCanvas::dat);
        int _p = 0;
        for (int i = 0; i < 255; ++i) {
            CpCanvas::tip_list[i << 1] = ((int)(uint8_t)_buf[_p] << 8) | (int)(uint8_t)_buf[_p + 1];
            CpCanvas::tip_list[(i << 1) + 1] = ((int)(uint8_t)_buf[_p + 2] << 8) | (int)(uint8_t)_buf[_p + 3];
            _p += 4;
            if (i % 20 == 0) {
                DrawBar(2, 38 + (i + 1) / 20);
            }
        }
    } catch (...) {}
}


// ==================== FieldMain ====================
void CpCanvas::FieldMain() {
    int nArray[] = {-1, 0, 1, 0};
    int nArray2[] = {0, -1, 0, 1};
    CpCanvas::soft_id[0] = 0;
    CpCanvas::soft_id[1] = 0;
    if (CpCanvas::machi_cnt > 0) {
        MapDraw(CpCanvas::map_x, CpCanvas::map_y);
        ObjDraw(0);
        if (PlgEfe(CpCanvas::machi_cnt, CpCanvas::machi_flg)) {
            if (CpCanvas::machi_flg == 1) {
                CpCanvas::warp_cnt = 7;
                CpCanvas::warp_flg = 2;
                CpCanvas::ivent_end = 0;
                CpCanvas::machi_cnt = 0;
            } else {
                MachiSet(CpCanvas::machi_no, 1);
                CpCanvas::scene = 5;
                CpCanvas::machi_flg = 2;
                CpCanvas::machi_cnt = 1;
                Wait(1000);
            }
        } else {
            ++CpCanvas::machi_cnt;
        }
        CpCanvas::key = 0;
        return;
    }
    if (CpCanvas::eff_cnt > 0) {
        EnEff(CpCanvas::eff_cnt++);
        if (CpCanvas::eff_cnt > 8) {
            int n = -1;
            if (CpCanvas::ivent_flg < 0) {
                int n2 = (int)((unsigned int)CpCanvas::rand() >> 1) % 9;
                CpCanvas::teki_pt = CpCanvas::ene_set[CpCanvas::map_no * 3 + n2 / 3] >> ((n2 % 3) * 10) & 0x3FF;
            }
            BtSet(CpCanvas::teki_pt);
            EnSet();
            CpCanvas::scene = 1;
            --CpCanvas::eff_cnt;
            CpCanvas::ghost = n;
            CpCanvas::key = 0;
        }
    } else {
        int n;
        int n5;
        int n6 = CpCanvas::map_sp;
        int n7 = 0;
        int n8 = CpCanvas::m_data[(CpCanvas::map_y + 5) / 30 * 24 + CpCanvas::map_x / 30];
        if (CpCanvas::mes_flg == 0) {
            if (n8 > 2 && n8 < 7) {
                if (PaneHit(n8 & 1)) {
                    if (n8 == 3) {
                        n7 = MoveChack(-2, 0) << 1;
                        CpCanvas::map_x -= n7;
                    }
                    if (n8 == 4) {
                        n7 = MoveChack(0, -2) << 1;
                        CpCanvas::map_y -= n7;
                    }
                    if (n8 == 5) {
                        n7 = MoveChack(2, 0) << 1;
                        CpCanvas::map_x += n7;
                    }
                    if (n8 == 6) {
                        n7 = MoveChack(0, 2) << 1;
                        CpCanvas::map_y += n7;
                    }
                }
                if (n7 != 0) {
                    CpCanvas::muki = n8 - 3;
                    CpCanvas::move_flg = 0;
                }
            }
            if (CpCanvas::warp_cnt == 0 && n7 == 0) {
                CpCanvas::soft_id[0] = 5;
                CpCanvas::soft_id[1] = 4;
                CpCanvas::key2 = getKeypadState();
                if ((CpCanvas::key2 & 0x20000) != 0) {
                    if (n7 == 0) {
                        CpCanvas::muki = 1;
                    }
                    n7 = MoveChack(0, -1);
                    CpCanvas::map_y -= n7;
                    CpCanvas::move_cnt += n7;
                    n7 = 1;
                } else if ((CpCanvas::key2 & 0x80000) != 0) {
                    if (n7 == 0) {
                        CpCanvas::muki = 3;
                    }
                    n7 = MoveChack(0, 1);
                    CpCanvas::map_y += n7;
                    CpCanvas::move_cnt += n7;
                    n7 = 3;
                }
                if ((CpCanvas::key2 & 0x10000) != 0) {
                    if (n7 == 0) {
                        CpCanvas::muki = 0;
                    }
                    n7 = MoveChack(-1, 0);
                    CpCanvas::map_x -= n7;
                    CpCanvas::move_cnt += n7;
                    n7 = 1;
                } else if ((CpCanvas::key2 & 0x40000) != 0) {
                    if (n7 == 0) {
                        CpCanvas::muki = 2;
                    }
                    n7 = MoveChack(1, 0);
                    CpCanvas::map_x += n7;
                    CpCanvas::move_cnt += n7;
                    n7 = 1;
                }
                n8 = CpCanvas::m_data[(CpCanvas::map_y + 5) / 30 * 24 + CpCanvas::map_x / 30];
            }
            if ((n8 & 0x80) != 0) {
                if (CpCanvas::warp_cnt == 0) {
                    n5 = n8 & 0xF;
                    n = CpCanvas::m_chara[n5 * 6 + CpCanvas::chara_flg[CpCanvas::map_no * 4 + n5]];
                    if (CpCanvas::m_chara[n5 * 6 + 3] == 31 && n > 0) {
                        IventRead(n, n5 / 3 * 1);
                        CpCanvas::mes_flg = 1;
                    }
                }
            } else if (n8 > 6 && n8 < 11) {
                if (CpCanvas::warp_flg == 0 && 22 > CpCanvas::map_x % 30 && 8 < CpCanvas::map_x % 30 && 22 > (CpCanvas::map_y + 8) % 30 && 8 < (CpCanvas::map_y + 8) % 30) {
                    CpCanvas::warp_flg = 1;
                    CpCanvas::warp_cnt = 1;
                }
            } else if (CpCanvas::ivent_end == 0) {
                CpCanvas::warp_flg = 0;
            }
            if (CpCanvas::warp_cnt == 0 && n7 == 0 && CpCanvas::mes_flg == 0) {
                if (CpCanvas::key == 0x100000) {
                    if (CpCanvas::mes_no > 0) {
                        MoveChack(nArray[CpCanvas::muki], nArray2[CpCanvas::muki]);
                    }
                    if (CpCanvas::mes_no > 0) {
                        CpCanvas::mes_flg = 1;
                        MesChack();
                        n7 = 0;
                    }
                    CpCanvas::key = 0;
                } else if (CpCanvas::key == 0x200000) {
                    CpCanvas::mes_flg = 2;
                    MesRead(39, nullptr, 3);
                    CpCanvas::yes_no_flg = 2;
                    CpCanvas::key = 0;
                } else if (CpCanvas::key == 0x400000) {
                    CpCanvas::back_menu = CpCanvas::scene;
                    CpCanvas::scene = 4;
                    CpCanvas::menu_sel = 0;
                    CpCanvas::menu_no = 0;
                    CpCanvas::menu_cnt = -1;
                    MesRead(5, nullptr, 3);
                    CpCanvas::key = 0;
                }
            }
            if (CpCanvas::warp_flg == 0 && CpCanvas::encount < CpCanvas::move_cnt && CpCanvas::mes_flg == 0 && (CpCanvas::en_flg == 0 || CpCanvas::deba_flg == 0)) {
                CpCanvas::eff_cnt = 1;
            }
            CpCanvas::move_flg = n7 == 0 ? 0 : CpCanvas::move_flg % 8 + 1;
        }
        MapDraw(CpCanvas::map_x, CpCanvas::map_y);
        ObjDraw(0);
        if (CpCanvas::warp_cnt > 0) {
            if (CpCanvas::warp_cnt == (CpCanvas::warp_flg - 1) * 6 + 1) {
                Audio(1, 15);
            }
            CpCanvas::muki = 3;
            if (CpCanvas::warp_cnt < 3) {
                Ani(41, 3, 0, 110, 103);
            }
            CpCanvas::warp_cnt += (CpCanvas::warp_flg & 1) * 2 - 1;
            if (CpCanvas::warp_cnt == 7) {
                if (CpCanvas::ivent_end != 0) {
                    CpCanvas::warp_cnt = 0;
                    CpCanvas::machi_flg = 3;
                    CpCanvas::machi_cnt = 1;
                    CpCanvas::ivent_end = 0;
                } else if (n8 == 7) {
                    if (CpCanvas::m_warp[0] < 100) {
                        CpCanvas::warp_cnt = 0;
                        CpCanvas::machi_flg = 3;
                        CpCanvas::machi_cnt = 1;
                    } else {
                        CpCanvas::m_warp[0] = CpCanvas::m_warp[0] - 100;
                        n5 = CpCanvas::m_warp[n8 - 7] >> 8;
                        CpCanvas::map_no = CpCanvas::m_warp[n8 - 7] & 0xFF;
                        MapSet(CpCanvas::map_no, n5);
                        CpCanvas::warp_cnt = 7;
                        CpCanvas::warp_flg = 2;
                    }
                } else {
                    n = CpCanvas::map_bgm;
                    n5 = CpCanvas::m_warp[n8 - 7] >> 8;
                    CpCanvas::map_no = CpCanvas::m_warp[n8 - 7] & 0xFF;
                    MapSet(CpCanvas::map_no, n5);
                    if (n != CpCanvas::map_bgm) {
                        Audio(1, CpCanvas::map_bgm);
                    }
                    CpCanvas::warp_cnt = 7;
                    CpCanvas::warp_flg = 2;
                }
            } else if (CpCanvas::warp_cnt > 2) {
                CpCanvas::g->setColor(Graphics::getColorOfRGB(128, 128, 255));
                CpCanvas::g->fillRect(111 + CpCanvas::warp_cnt * 3 / 2, 0, 18 - CpCanvas::warp_cnt * 3, 135);
                CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 255, 255));
                CpCanvas::g->fillRect(114 + CpCanvas::warp_cnt, 0, 12 - CpCanvas::warp_cnt * 2, 135);
            }
        } else {
            if (CpCanvas::mes_flg != 0) {
                CpCanvas::move_flg = 0;
            }
            Ani(41, CpCanvas::muki, CpCanvas::move_flg % 9, 110 + CpCanvas::yure, 103);
        }
        if (CpCanvas::scene != 5) {
            ObjDraw(1);
        } else {
            CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 255, 255));
            CpCanvas::g->fillRect(0, 0, 240, 240);
        }
        if (CpCanvas::mes_flg != 0) {
            CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
            CpCanvas::g->fillRect(0, 160, 240, 80);
            CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 255, 255));
            CpCanvas::g->fillRect(2, 162, 236, 76);
            if (CpCanvas::ivent_flg >= 0) {
                for (n5 = 0; n5 < 4; ++n5) {
                    if (CpCanvas::i_set[n5] == 0 || CpCanvas::i_set[n5] >= 31) continue;
                    n = CpCanvas::i_x[n5] - CpCanvas::map_x + CpCanvas::yure;
                    int n9 = CpCanvas::i_y[n5] - CpCanvas::map_y;
                    drawImg3(46, CpCanvas::i_set[n5], n, n9, false);
                }
                if (CpCanvas::machi_damy_flg >= 0) {
                    CpCanvas::g->drawImage(CpCanvas::imgMap, 0 + CpCanvas::yure, 0);
                    drawImg3(48, 1, 25 + CpCanvas::yure, 5, false);
                    Basyo(CpCanvas::m_name[CpCanvas::machi_damy_flg], 100 + CpCanvas::yure, 5);
                    if (CpCanvas::kouka_flg == 0) {
                        FaceDrawA(CpCanvas::talk_ch[0], CpCanvas::talk_ch[1], CpCanvas::talk_ch[2], 31);
                    }
                }
                if (IventMain() < 0) {
                    CpCanvas::back_menu = CpCanvas::scene;
                    CpCanvas::mes_flg = 0;
                    if (CpCanvas::ivent_end == 4) {
                        CpCanvas::ivent_end = 0;
                        CpCanvas::scene = 7;
                        return;
                    }
                    if (CpCanvas::ivent_end == 5) {
                        CpCanvas::ivent_end = 0;
                        CpCanvas::scene = 8;
                        return;
                    }
                    if (CpCanvas::ivent_end == 6) {
                        CpCanvas::ivent_end = 0;
                        CpCanvas::scene = 10;
                        return;
                    }
                    if (CpCanvas::ivent_end == 7) {
                        CpCanvas::ivent_end = 0;
                        CpCanvas::mes_flg = 1;
                        return;
                    }
                }
            } else {
                n5 = MesDraw(0) ? 1 : 0;
                if (CpCanvas::mes_flg == 1) {
                    if (CpCanvas::key == 0x100000) {
                        if (n5 != 0) {
                            CpCanvas::mes_flg = 0;
                        } else {
                            CpCanvas::mes_cnt = 90;
                        }
                        CpCanvas::key = 0;
                    }
                } else {
                    FaceDraw(0);
                    if (CpCanvas::yes_no_flg != 0) {
                        if (CpCanvas::key == 65536) {
                            CpCanvas::yes_no_flg = 1;
                            CpCanvas::key = 0;
                        }
                        if (CpCanvas::key == 262144) {
                            CpCanvas::yes_no_flg = 2;
                            CpCanvas::key = 0;
                        }
                    }
                    if (CpCanvas::key == 0x100000) {
                        if (n5 != 0) {
                            if (CpCanvas::yes_no_flg != 0) {
                                if (CpCanvas::yes_no_flg == 1) {
                                    MesRead(40, nullptr, 3);
                                } else {
                                    CpCanvas::mes_flg = 0;
                                }
                                CpCanvas::yes_no_flg = 0;
                            } else {
                                CpCanvas::mes_flg = 0;
                                CpCanvas::warp_flg = 1;
                                CpCanvas::warp_cnt = 1;
                                CpCanvas::ivent_end = 1;
                            }
                        } else {
                            CpCanvas::mes_cnt = 90;
                        }
                        CpCanvas::key = 0;
                    }
                }
            }
        }
        if (CpCanvas::mes_flg == 0) {
            HpDraw(CpCanvas::now_hp, 0, -40);
            AriaName();
        }
    }
}

// ==================== AriaName ====================
void CpCanvas::AriaName() {
    CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
    CpCanvas::g->fillRect(69, 1, 169, 18);
    CpCanvas::g->fillRect(70, 2, 169, 18);
    CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 255, 255));
    CpCanvas::g->fillRect(70, 2, 167, 16);
    CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
    strDraw(CpCanvas::map_str[CpCanvas::map_no], (167 - CpCanvas::f->stringWidth(CpCanvas::map_str[CpCanvas::map_no])) / 2 + 71, 17);
}

// ==================== EnEff ====================
void CpCanvas::EnEff(int n) {
    CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
    for (int i = 0; i < 6; ++i) {
        CpCanvas::g->fillRect(0, i * 40, n * 40 - n * 5, 20);
        CpCanvas::g->fillRect(240 - (n * 40 - n * 5), i * 40 + 20, 240, 20);
    }
}

// ==================== MoveChack ====================
int CpCanvas::MoveChack(int n, int n2) {
    int n3 = CpCanvas::map_x + n * CpCanvas::map_sp;
    int n4 = CpCanvas::map_y + n2 * CpCanvas::map_sp;
    CpCanvas::mes_no = -1;
    if (n3 - 8 < 0 || n3 + 8 > 719 || n4 < 0 || n4 + 10 > 719) {
        n3 -= n * CpCanvas::map_sp;
        n4 -= n2 * CpCanvas::map_sp;
        for (int i = 0; i < CpCanvas::map_sp; ++i) {
            n3 += n;
            n4 += n2;
            if (n3 - 8 >= 0 && n3 + 8 <= 719 && n4 >= 0 && n4 + 10 <= 719) continue;
            return i;
        }
        return 0;
    }
    if (CpCanvas::hit_flg != 0 && CpCanvas::deba_flg != 0) {
        return CpCanvas::map_sp;
    }
    if (CpCanvas::m_data[n4 / 30 * 24 + (n3 - 8) / 30] == 0 || CpCanvas::m_data[n4 / 30 * 24 + (n3 + 8) / 30] == 0 || CpCanvas::m_data[(n4 + 10) / 30 * 24 + (n3 - 8) / 30] == 0 || CpCanvas::m_data[(n4 + 10) / 30 * 24 + (n3 + 8) / 30] == 0) {
        n3 -= n * CpCanvas::map_sp;
        n4 -= n2 * CpCanvas::map_sp;
        for (int i = 0; i < CpCanvas::map_sp; ++i) {
            n3 += n;
            n4 += n2;
            if (CpCanvas::m_data[n4 / 30 * 24 + (n3 - 8) / 30] != 0 && CpCanvas::m_data[n4 / 30 * 24 + (n3 + 8) / 30] != 0 && CpCanvas::m_data[(n4 + 10) / 30 * 24 + (n3 - 8) / 30] != 0 && CpCanvas::m_data[(n4 + 10) / 30 * 24 + (n3 + 8) / 30] != 0) continue;
            return i;
        }
        return 0;
    }
    return CpCanvas::map_sp;
}


// ==================== TobiCh ====================
int CpCanvas::TobiCh(int n, int n2, int n3, int n4, int n5) {
    // Stub implementation
    return -1;
}

// ==================== PaneHit ====================
bool CpCanvas::PaneHit(int n) {
    // Stub implementation
    return true;
}

// ==================== MapSet ====================
void CpCanvas::MapSet(int n, int n2) {
    CpCanvas::map_bgm = 4;
    // Stub - full map loading code would go here
}

// ==================== ObjDraw ====================
void CpCanvas::ObjDraw(int n) {
    if (n == 0) {
        int n2;
        int n3;
        int n4;
        for (n4 = 0; n4 < 4; ++n4) {
            if (CpCanvas::item_flg[CpCanvas::map_no * 4 + n4] == 0) continue;
            n3 = CpCanvas::m_item[n4 * 4 + 2] - CpCanvas::map_x + CpCanvas::yure;
            n2 = CpCanvas::m_item[n4 * 4 + 3] - CpCanvas::map_y;
            drawImg3(46, 7, n3, n2, false);
        }
        for (n4 = 0; n4 < 2; ++n4) {
            if (CpCanvas::tobi_flg[CpCanvas::map_no * 2 + n4] == 0) continue;
            n3 = CpCanvas::m_tobi[n4 * 5 + 3] - CpCanvas::map_x + CpCanvas::yure;
            n2 = CpCanvas::m_tobi[n4 * 5 + 4] - CpCanvas::map_y;
            drawImg3(46, 1, n3, n2, false);
        }
        for (n4 = 0; n4 < 4; ++n4) {
            if (CpCanvas::chara_flg[CpCanvas::map_no * 4 + n4] == 0 || CpCanvas::m_chara[n4 * 6 + 3] >= 31 || CpCanvas::m_chara[n4 * 6 + 3] <= 0) continue;
            n3 = CpCanvas::m_chara[n4 * 6 + 4] - CpCanvas::map_x + CpCanvas::yure;
            n2 = CpCanvas::m_chara[n4 * 6 + 5] - CpCanvas::map_y;
            drawImg3(46, CpCanvas::m_chara[n4 * 6 + 3], n3, n2, false);
        }
    }
}

// ==================== MapDraw ====================
void CpCanvas::MapDraw(int n, int n2) {
    CpCanvas::R = CpCanvas::p_col[CpCanvas::tip_pt] & 0xFF;
    CpCanvas::G = (CpCanvas::p_col[CpCanvas::tip_pt] >> 8) & 0xFF;
    CpCanvas::B = (CpCanvas::p_col[CpCanvas::tip_pt] >> 16) & 0xFF;
    CpCanvas::g->setColor(Graphics::getColorOfRGB(CpCanvas::R, CpCanvas::G, CpCanvas::B));
    CpCanvas::g->fillRect(0, 0, 240, 240);
    n -= 120 + CpCanvas::yure;
    n2 -= 120;
    int nArray[] = {n / 240, n / 240 + 1, n2 / 240, n2 / 240 + 1};
    if (nArray[0] < 0) {
        nArray[0] = 0;
    }
    if (nArray[2] < 0) {
        nArray[2] = 0;
    }
    if (n % 240 == 0) {
        nArray[1] = nArray[1] - 1;
    }
    if (n2 % 240 == 0) {
        nArray[3] = nArray[3] - 1;
    }
    int nArray2[] = {-n + nArray[0] * 240, -n + nArray[1] * 240};
    int nArray3[] = {-n2 + nArray[2] * 240, -n2 + nArray[3] * 240};
    for (int i = 0; i < 4; ++i) {
        int n3 = nArray[i & 1] + nArray[i / 2 + 2] * 3;
        if (nArray[i & 1] >= 3 || nArray[i / 2 + 2] >= 3) continue;
        CpCanvas::g->drawImage(CpCanvas::imgMap2[n3], nArray2[i & 1], nArray3[i / 2] + 4);
    }
}

// ==================== EnSet ====================
void CpCanvas::EnSet() {
    int n = (int)((unsigned int)CpCanvas::rand() >> 1) % 100;
    CpCanvas::encount = n < 80 ? ((int)((unsigned int)CpCanvas::rand() >> 1) % 400 + 400) : (n < 88 ? ((int)((unsigned int)CpCanvas::rand() >> 1) % 200 + 200) : (n < 96 ? ((int)((unsigned int)CpCanvas::rand() >> 1) % 200 + 800) : (n < 98 ? ((int)((unsigned int)CpCanvas::rand() >> 1) % 400 + 1200) : ((int)((unsigned int)CpCanvas::rand() >> 1) % 200 + 100))));
    CpCanvas::encount = CpCanvas::encount * ((CpCanvas::p_pat[CpCanvas::map_no] >> 8) & 0xFF) / 10;
    n = CpCanvas::skill_kouka[10] * 7;
    CpCanvas::encount += CpCanvas::encount * n / 10;
    n = CpCanvas::skill_kouka[13] * 2;
    CpCanvas::encount -= CpCanvas::encount * n / 12;
    CpCanvas::move_cnt = 0;
}

// ==================== MesChack ====================
void CpCanvas::MesChack() {
    int n = CpCanvas::mes_no >> 5;
    int n2 = CpCanvas::mes_no & 0xF;
    std::string string = "?";
    if (n == 1) {
        n = 0;
        string = ItemName(CpCanvas::m_item[n2 * 4 + 0], CpCanvas::m_item[n2 * 4 + 1]);
        int n3 = (CpCanvas::user_id / 10 + CpCanvas::map_no) % 5;
        if (CpCanvas::m_item[n2 * 4 + 0] == 3) {
            GetItem(CpCanvas::m_item[n2 * 4 + 0], 0, CpCanvas::m_item[n2 * 4 + 1] * 5 + n3);
        } else {
            GetItem(CpCanvas::m_item[n2 * 4 + 0], 0, CpCanvas::m_item[n2 * 4 + 1]);
        }
        CpCanvas::item_flg[CpCanvas::map_no * 4 + (CpCanvas::m_data[CpCanvas::mes_data] & 0xF)] = 0;
        CpCanvas::m_data[CpCanvas::mes_data] = 1;
        MesRead(n, (uint8_t*)string.c_str(), 3);
    } else if (n == 2) {
        n = CpCanvas::m_tobi[n2 * 5 + CpCanvas::tobi_flg[CpCanvas::map_no * 2 + n2]];
        IventRead(n, 3);
    } else if (n == 4) {
        n = CpCanvas::m_chara[n2 * 6 + CpCanvas::chara_flg[CpCanvas::map_no * 4 + n2]];
        IventRead(n, n2 / 3 * 1);
    }
}

// ==================== MesRead ====================
void CpCanvas::MesRead(int n, uint8_t* byArray, int n2) {
    CpCanvas::mes_cnt = 0;
    if (CpCanvas::tmp_m_no == n && CpCanvas::tmp_m_flg == n2 && byArray == nullptr) {
        return;
    }
    CpCanvas::mes_id = n;
    try {
        std::vector<uint8_t> _buf;
        if (n2 == 0) {
            int n3 = n;
            if (n > 499) {
                _buf = GetData(12);
                // Skip to message
            } else {
                _buf = GetData(8 + n3 / 100);
            }
        } else if (n2 == 3) {
            int n3 = MesNo(n);
            if (n3 < 0) {
                _buf = Resources::jarGet(11, CpCanvas::dat);
            } else {
                _buf = Resources::jarGet(35, CpCanvas::dat);
            }
        } else if (n2 == 4) {
            _buf = Resources::jarGet(12, CpCanvas::dat);
        } else if (n2 == 5) {
            _buf = Resources::jarGet(13, CpCanvas::dat);
        }
        // Load message strings
        for (int n3 = 0; n3 < 3; ++n3) {
            CpCanvas::mes[n3] = 0; // placeholder
        }
    } catch (...) {}
    CpCanvas::tmp_m_no = n;
    CpCanvas::tmp_m_flg = n2;
}

// ==================== MesNo ====================
int CpCanvas::MesNo(int n) {
    int n2 = -1;
    int nArray[] = {5, 6, 7, 8, 9, 10, 11, 15, 28, 29, 30, 31, 32, 33, 35, 39, 54, 71, 76, 82, 93, 94, 110, 111, 137, 157, 158, 159};
    for (int i = 27; i >= 0; --i) {
        if (nArray[i] != n) continue;
        n2 = i;
        break;
    }
    return n2;
}

// ==================== MesDraw ====================
bool CpCanvas::MesDraw(int n) {
    int n2 = CpCanvas::mes_cnt + n * 100;
    int n3 = 0;
    CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
    // Draw messages
    if (n3 == 3) {
        if (n == 0) {
            if (CpCanvas::yes_no_flg == 0) {
                drawImg3(44, 108, 225, 222 + CpCanvas::game_cnt / 3 % 2, false);
            } else {
                drawImg3(44, 33, 55 + (CpCanvas::yes_no_flg - 1) * 96 + CpCanvas::game_cnt / 2 % 3, 207, false);
            }
        }
        return true;
    }
    CpCanvas::mes_cnt += 3;
    return false;
}

// ==================== MesDraw2 ====================
bool CpCanvas::MesDraw2(int n, int n2, int n3, int n4) {
    int n5 = CpCanvas::mes_cnt + n * 100;
    int n6 = 0;
    CpCanvas::g->setColor(Graphics::getColorOfRGB(n4, n4, n4));
    // Draw messages
    if (n6 == 3) {
        if (n == 0) {
            if (CpCanvas::yes_no_flg == 0) {
                drawImg3(44, 108, 225, 222 + CpCanvas::game_cnt / 3 % 2, false);
            } else {
                drawImg3(44, 33, 55 + (CpCanvas::yes_no_flg - 1) * 96 + CpCanvas::game_cnt / 2 % 3, 207, false);
            }
        }
        return true;
    }
    CpCanvas::mes_cnt += 3;
    return false;
}

// ==================== Machi ====================
void CpCanvas::Machi() {
    int n;
    CpCanvas::now_hp = CpCanvas::max_hp;
    CpCanvas::soft_id[0] = 0;
    CpCanvas::soft_id[1] = 0;
    if (CpCanvas::machi_move > 0) {
        CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
        CpCanvas::g->fillRect(0, 0, 240, 160);
        CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 255, 255));
        CpCanvas::g->fillRect(2, 162, 236, 76);
        if (--CpCanvas::machi_move == 0) {
            MachiSet(CpCanvas::machi_no, 1);
            Wait(500);
        }
        CpCanvas::key = 0;
        return;
    }
    if (CpCanvas::eff_cnt > 0) {
        EnEff(CpCanvas::eff_cnt++);
        if (CpCanvas::eff_cnt > 8) {
            BtSet(CpCanvas::teki_pt);
            EnSet();
            CpCanvas::scene = 1;
            --CpCanvas::eff_cnt;
            CpCanvas::key = 0;
        }
        return;
    }
    if (CpCanvas::machi_cnt > 0) {
        if (PlgEfe(CpCanvas::machi_cnt, CpCanvas::machi_flg)) {
            if (CpCanvas::machi_flg == 2) {
                CpCanvas::machi_flg = 0;
            }
            if (CpCanvas::machi_flg == 3) {
                CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
                CpCanvas::g->fillRect(0, 0, 240, 240);
                CpCanvas::mode = 0;
                CpCanvas::scene = -2;
                ImgSet2(20);
                Audio(1, 0);
                CpCanvas::key = 0;
                return;
            }
            if (CpCanvas::machi_flg == 4) {
                CpCanvas::scene = 7;
                return;
            }
            if (CpCanvas::machi_flg == 10) {
                CpCanvas::machi_flg = 0;
                CpCanvas::scene = 9;
                CpCanvas::rank_menu = 0;
                CpCanvas::rank_cnt = 0;
                CpCanvas::rank_no = 0;
                CpCanvas::rank_menu = -1;
                MakeRank(0);
            }
        }
        if (CpCanvas::kouka_flg == 0) {
            FaceDrawA(CpCanvas::talk_ch[0], CpCanvas::talk_ch[1], CpCanvas::talk_ch[2], 31);
        }
        return;
    }
    if (CpCanvas::mail_flg == 0) {
        if (CpCanvas::key == 65536) {
            if (CpCanvas::machi_flg == 0 && --CpCanvas::machi_sel < 0) {
                CpCanvas::machi_sel = 3;
            }
            if (CpCanvas::machi_flg == 2 && --CpCanvas::menu_cnt < 0) {
                CpCanvas::menu_cnt = CpCanvas::talk_cnt - 1 + CpCanvas::talk_cnt2;
            }
            CpCanvas::key = 0;
        } else if (CpCanvas::key == 262144) {
            if (CpCanvas::machi_flg == 0 && ++CpCanvas::machi_sel > 3) {
                CpCanvas::machi_sel = 0;
            }
            if (CpCanvas::machi_flg == 2 && ++CpCanvas::menu_cnt > CpCanvas::talk_cnt - 1 + CpCanvas::talk_cnt2) {
                CpCanvas::menu_cnt = 0;
            }
            CpCanvas::key = 0;
        } else if (CpCanvas::key == 131072) {
            if (CpCanvas::machi_flg == 1 && --CpCanvas::menu_cnt < 0) {
                CpCanvas::menu_cnt = CpCanvas::move_ok[CpCanvas::machi_no] - 1;
            }
            if (CpCanvas::machi_flg == 2) {
                CpCanvas::machi_flg = 0;
                CpCanvas::menu_cnt = 0;
            }
            if (CpCanvas::machi_flg == 3 && --CpCanvas::menu_cnt < 0) {
                CpCanvas::menu_cnt = CpCanvas::plg_ok[CpCanvas::machi_no] - 1;
            }
            CpCanvas::key = 0;
        } else if (CpCanvas::key == 524288) {
            if (CpCanvas::machi_flg == 1 && ++CpCanvas::menu_cnt > CpCanvas::move_ok[CpCanvas::machi_no] - 1) {
                CpCanvas::menu_cnt = 0;
            }
            if (CpCanvas::machi_flg == 3 && ++CpCanvas::menu_cnt > CpCanvas::plg_ok[CpCanvas::machi_no] - 1) {
                CpCanvas::menu_cnt = 0;
            }
            CpCanvas::key = 0;
        }
    }
    CpCanvas::g->drawImage(CpCanvas::imgMap, 0, 0);
    if (CpCanvas::machi_flg == 0) {
        CpCanvas::soft_id[0] = 2;
        CpCanvas::soft_id[1] = 4;
        for (n = 0; n < 4; ++n) {
            if (n == CpCanvas::machi_sel) {
                drawImg3(48, n, 25 + n * 49, 8 + CpCanvas::game_cnt / 3 % 2, false);
                continue;
            }
            drawImg3(48, n, 25 + n * 49, 5, false);
        }
        CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 0, 0));
        CpCanvas::g->drawRect(26 + CpCanvas::machi_sel * 49, 9 + CpCanvas::game_cnt / 3 % 2, 37, 29);
        CpCanvas::g->drawRect(25 + CpCanvas::machi_sel * 49, 8 + CpCanvas::game_cnt / 3 % 2, 39, 31);
        Basyo(CpCanvas::m_name[CpCanvas::machi_no], 100, 47);
        FaceDrawA(0, CpCanvas::i_chara[0 * 5 + CpCanvas::talk_flg[CpCanvas::machi_no * 4 + 0]], CpCanvas::i_chara[1 * 5 + CpCanvas::talk_flg[CpCanvas::machi_no * 4 + 1]], CpCanvas::i_chara[2 * 5 + CpCanvas::talk_flg[CpCanvas::machi_no * 4 + 2]]);
        if (CpCanvas::mail_flg == 0) {
            MesRead(28 + CpCanvas::machi_sel, nullptr, 3);
            MesDraw(1);
        }
    }
    if (CpCanvas::mail_flg == 0) {
        if (CpCanvas::key == 0x100000) {
            if (CpCanvas::machi_flg == 0) {
                CpCanvas::machi_flg = CpCanvas::machi_sel + 1;
                CpCanvas::menu_cnt = 0;
            }
            CpCanvas::key = 0;
        } else if (CpCanvas::key == 0x200000) {
            CpCanvas::machi_flg = 0;
            CpCanvas::menu_cnt = 0;
            CpCanvas::key = 0;
        } else if (CpCanvas::key == 0x400000) {
            if (CpCanvas::machi_flg == 0) {
                CpCanvas::back_menu = CpCanvas::scene;
                CpCanvas::menu_no = 0;
                CpCanvas::menu_cnt = -1;
                MesRead(5, nullptr, 3);
                CpCanvas::scene = 4;
                CpCanvas::menu_sel = 0;
            }
            CpCanvas::key = 0;
        }
    }
}


// ==================== Basyo ====================
void CpCanvas::Basyo(std::string string, int n, int n2) {
    CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
    CpCanvas::g->fillRect(n, n2, 128, 18);
    CpCanvas::g->fillRect(n + 1, n2 + 1, 128, 18);
    CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 255, 255));
    CpCanvas::g->fillRect(n + 1, n2 + 1, 126, 16);
    CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
    strDraw(string, n + (128 - CpCanvas::f->stringWidth(string)) / 2, n2 + 15);
}

// ==================== PlgEfe ====================
bool CpCanvas::PlgEfe(int n, int n2) {
    bool bl = false;
    CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 255, 255));
    if (n2 == 0) {
        int n3 = 120 - n * n * 5;
        if (n3 < 0) {
            n3 = 0;
        }
        int n4 = (120 - n3) * 2;
        int n5 = 118;
        if (n3 == 0) {
            n5 -= (n - 4) * (n - 4) * 3;
        }
        if (n5 < 0) {
            n5 = 0;
            if (CpCanvas::pla_ok == 0) {
                ++CpCanvas::pla_ok;
            } else {
                CpCanvas::pla_ok = 0;
                bl = true;
            }
        }
        int n6 = (120 - n5) * 2;
        CpCanvas::g->fillRect(n3, n5, n4, n6);
    } else if (n2 == 1) {
        int n7 = 120 - n * n * 3;
        if (n7 < 0) {
            n7 = 0;
            if (CpCanvas::pla_ok == 0) {
                ++CpCanvas::pla_ok;
            } else {
                CpCanvas::pla_ok = 0;
                bl = true;
            }
        }
        int n8 = 240 - n7;
        CpCanvas::g->fillRect(0, 0, 240, n7);
        CpCanvas::g->fillRect(0, n8, 240, 120);
    } else if (n2 == 2) {
        int n9 = n * n * 3;
        if (n9 > 120) {
            n9 = 120;
            if (CpCanvas::pla_ok == 0) {
                ++CpCanvas::pla_ok;
            } else {
                CpCanvas::pla_ok = 0;
                bl = true;
            }
        }
        int n10 = 240 - n9 * 2;
        CpCanvas::g->drawImage(CpCanvas::imgMap, 0, 0);
        CpCanvas::g->fillRect(0, n9, 240, n10);
    } else if (n2 == 3) {
        int n11 = n * n * 3;
        if (n11 > 120) {
            n11 = 120;
            if (CpCanvas::pla_ok == 0) {
                ++CpCanvas::pla_ok;
            } else {
                CpCanvas::pla_ok = 0;
                bl = true;
            }
        }
        int n12 = 240 - n11;
        CpCanvas::g->fillRect(0, 0, 240, n11);
        CpCanvas::g->fillRect(0, n12, 240, 120);
    }
    return bl;
}

// ==================== HpDraw ====================
void CpCanvas::HpDraw(int n, int n2, int n3) {
    if (n < 0) {
        n = 0;
    }
    CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 255, 255));
    CpCanvas::g->fillRect(n2, n3 + 42, 40, 20);
    if (n * 4 > CpCanvas::max_hp) {
        CpCanvas::g->setColor(Graphics::getColorOfRGB(56, 80, 104));
    } else {
        CpCanvas::g->setColor(Graphics::getColorOfRGB(204, 0, 0));
    }
    CpCanvas::g->fillRect(n2 + 2, n3 + 44, 36, 16);
    ImgSuu(n, n2 + 4, n3 + 47, 32, 1, 1);
}

// ==================== MachiSet ====================
void CpCanvas::MachiSet(int n, int n2) {
    CpCanvas::ivent_flg = -1;
    CpCanvas::mail_flg = 0;
    if (n2 != 0) {
        try {
            auto _buf = GetData(0);
            // Load machi data
        } catch (...) {}
        ImgSet2(CpCanvas::machi_no);
        IventRead(CpCanvas::m_ivent[3 * 5 + CpCanvas::talk_flg[CpCanvas::machi_no * 4 + 3]], 0);
    }
    CpCanvas::graMap->setColor(Graphics::getColorOfRGB(200, 200, 200));
    CpCanvas::graMap->fillRect(0, 0, 240, 160);
    CpCanvas::graMap->setColor(Graphics::getColorOfRGB(0, 0, 0));
    CpCanvas::graMap->fillRect(0, 160, 240, 80);
    CpCanvas::graMap->fillRect(29, 57, 182, 62);
    CpCanvas::graMap->setColor(Graphics::getColorOfRGB(255, 255, 255));
    CpCanvas::graMap->fillRect(2, 162, 236, 76);
    CpCanvas::graMap->drawImage((Image*)CpCanvas::image[58], 30, 58);
    CpCanvas::talk_cnt = CharaCnt();
    CpCanvas::menu_cnt = 0;
    CpCanvas::machi_sel = 0;
    CpCanvas::machi_flg = 0;
    CpCanvas::machi_cnt = 0;
    CpCanvas::key = 0;
}

// ==================== RockIventSet ====================
void CpCanvas::RockIventSet() {
    try {
        auto _buf = GetData(0);
        // Load rock ivent data
    } catch (...) {}
    CpCanvas::key = 0;
}

// ==================== Keiji ====================
void CpCanvas::Keiji() {
    int n;
    CpCanvas::soft_id[0] = 2;
    CpCanvas::soft_id[1] = 0;
    int n2 = getKeypadState();
    if ((n2 & 0x20000) == 0 && (n2 & 0x80000) == 0 && (n2 & 2) == 0 && (n2 & 0x10) == 0) {
        CpCanvas::key_cnt = 0;
    }
    if (CpCanvas::key_cnt > 0) {
        if (CpCanvas::key_cnt < 4) {
            n2 = 0;
        }
        ++CpCanvas::key_cnt;
    }
    CpCanvas::g->drawImage(CpCanvas::imgMap, 0, 0);
    if (CpCanvas::key == 131072 || (n2 & 0x20000) != 0) {
        if (CpCanvas::mes_flg == 0) {
            if (CpCanvas::q_sel > 0 && --CpCanvas::q_sel - CpCanvas::q_jou < 0) {
                --CpCanvas::q_jou;
            }
            ++CpCanvas::key_cnt;
        }
        CpCanvas::key = 0;
    } else if (CpCanvas::key == 524288 || (n2 & 0x80000) != 0) {
        if (CpCanvas::mes_flg == 0) {
            if (CpCanvas::q_sel < CpCanvas::q_get - 1 && ++CpCanvas::q_sel - CpCanvas::q_jou >= 7) {
                ++CpCanvas::q_jou;
            }
            ++CpCanvas::key_cnt;
        }
        CpCanvas::key = 0;
    }
    int n3 = 32;
    if (CpCanvas::q_get > 7) {
        n3 += CpCanvas::q_jou * 92 / (CpCanvas::q_get - 7);
    }
    drawImg3(44, 34, 229, n3, false);
    CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 255, 255));
    for (n = 6; n >= 0; --n) {
        if (CpCanvas::q_get <= n) continue;
        int n4 = CpCanvas::q_jou + n;
        if (CpCanvas::quest_no == CpCanvas::q_list[n4]) {
            drawImg3(44, 127, 15, 22 + n * 17, false);
        }
        strDraw(CpCanvas::q_str[n4], 32, 35 + n * 17);
    }
    CpCanvas::g->setColor(Graphics::getColorOfRGB(0, 0, 0));
    if (CpCanvas::mes_flg == 0) {
        drawImg3(44, 33, 5 + CpCanvas::game_cnt / 2 % 3, 23 + (CpCanvas::q_sel - CpCanvas::q_jou) * 17, false);
    }
    if (CpCanvas::yes_no_flg != 0) {
        if (CpCanvas::key == 65536) {
            CpCanvas::yes_no_flg = 1;
            CpCanvas::key = 0;
        } else if (CpCanvas::key == 262144) {
            CpCanvas::yes_no_flg = 2;
            CpCanvas::key = 0;
        }
    }
    if (CpCanvas::key == 0x200000) {
        CpCanvas::yes_no_flg = 0;
        CpCanvas::mes_draw = 0;
        CpCanvas::mes_flg = 0;
        MachiSet(CpCanvas::machi_no, 0);
        CpCanvas::scene = 5;
        CpCanvas::key = 0;
    }
}

// ==================== Shop ====================
void CpCanvas::Shop() {
    CpCanvas::soft_id[0] = 2;
    CpCanvas::soft_id[1] = 0;
    CpCanvas::g->drawImage(CpCanvas::imgMap, 0, 0);
    // Shop logic stub
    if (CpCanvas::key == 0x200000) {
        MachiSet(CpCanvas::machi_no, 0);
        CpCanvas::scene = 5;
        CpCanvas::key = 0;
    }
}

// ==================== Trader ====================
void CpCanvas::Trader() {
    CpCanvas::soft_id[0] = 2;
    CpCanvas::soft_id[1] = 0;
    CpCanvas::g->drawImage(CpCanvas::imgMap, 0, 0);
    // Trader logic stub
    if (CpCanvas::key == 0x200000) {
        MachiSet(CpCanvas::machi_no, 0);
        CpCanvas::scene = 5;
        CpCanvas::key = 0;
    }
}

// ==================== Ranking ====================
void CpCanvas::Ranking() {
    CpCanvas::soft_id[0] = 2;
    CpCanvas::soft_id[1] = 0;
    CpCanvas::g->drawImage(CpCanvas::imgMap, 0, 0);
    // Ranking logic stub
    if (CpCanvas::key == 0x200000) {
        MachiSet(CpCanvas::machi_no, 0);
        CpCanvas::scene = 5;
        CpCanvas::key = 0;
    }
}

// ==================== ZokuMain ====================
void CpCanvas::ZokuMain() {
    CpCanvas::soft_id[0] = 2;
    CpCanvas::soft_id[1] = 0;
    CpCanvas::g->drawImage(CpCanvas::imgMap, 0, 0);
    // ZokuMain logic stub
    if (CpCanvas::key == 0x200000) {
        MachiSet(CpCanvas::machi_no, 0);
        CpCanvas::scene = 5;
        CpCanvas::key = 0;
    }
}

// ==================== Menu ====================
void CpCanvas::Menu() {
    CpCanvas::soft_id[0] = 2;
    CpCanvas::soft_id[1] = 0;
    if (CpCanvas::menu_cnt < 0) {
        drawImg3(44, 0, 0, 0, true);
        CpCanvas::graMap->setColor(Graphics::getColorOfRGB(120, 152, 216));
        CpCanvas::graMap->fillRect(4, 20, 232, 136);
        ++CpCanvas::menu_cnt;
    }
    CpCanvas::g->drawImage(CpCanvas::imgMap, 0, 0);
    if (CpCanvas::key == 131072) {
        if (--CpCanvas::menu_sel < 0) {
            CpCanvas::menu_sel = 4;
        }
        CpCanvas::key = 0;
    }
    if (CpCanvas::key == 524288) {
        if (++CpCanvas::menu_sel > 4) {
            CpCanvas::menu_sel = 0;
        }
        CpCanvas::key = 0;
    }
    CpCanvas::g->setColor(Graphics::getColorOfRGB(255, 255, 255));
    for (int i = 0; i < 5; ++i) {
        strDraw(CpCanvas::menu_str[i], 40, 50 + i * 21);
    }
    drawImg3(44, 33, 15 + CpCanvas::game_cnt / 2 % 3, 35 + CpCanvas::menu_sel * 21, false);
    if (CpCanvas::key == 0x100000) {
        CpCanvas::menu_no = CpCanvas::menu_sel + 1;
        CpCanvas::key = 0;
    } else if (CpCanvas::key == 0x200000) {
        CpCanvas::scene = CpCanvas::back_menu;
        CpCanvas::key = 0;
    }
}


// ==================== Audio ====================
void CpCanvas::Audio(int n, int n2) {
    if (n == 0) {
        for (int i = 0; i < 16; ++i) {
            if (CpCanvas::audio[i] != nullptr) {
                CpCanvas::audio[i]->stop();
            }
        }
    } else if (n == 1) {
        CpCanvas::now_bgm = n2;
        if (n2 >= 0 && n2 < 16 && CpCanvas::audio[n2] != nullptr) {
            CpCanvas::audio[n2]->play(-1);
        }
    }
}

// ==================== sePlay ====================
void CpCanvas::sePlay() {
    for (int i = 0; i < 5; ++i) {
        if (CpCanvas::now_se_flg[i] == 0) continue;
        if (CpCanvas::now_se_cnt[i] > 0) {
            --CpCanvas::now_se_cnt[i];
            continue;
        }
        if (CpCanvas::m_audio_se[CpCanvas::now_se[i]] != nullptr) {
            CpCanvas::m_audio_se[CpCanvas::now_se[i]]->play(0);
        }
        CpCanvas::now_se_flg[i] = 0;
    }
}

// ==================== seSet ====================
void CpCanvas::seSet(int n, int n2) {
    for (int i = 0; i < 5; ++i) {
        if (CpCanvas::now_se_flg[i] != 0) continue;
        CpCanvas::now_se[i] = n;
        CpCanvas::now_se_cnt[i] = n2;
        CpCanvas::now_se_flg[i] = 1;
        break;
    }
}

// ==================== SortSkill ====================
void CpCanvas::SortSkill(int n) {
    if (n == 0) {
        for (int i = 0; i < 74; ++i) {
            CpCanvas::sort_skill[i] = 0;
        }
        int cnt = 0;
        for (int i = 0; i < 148; ++i) {
            if ((CpCanvas::skill_list[i] >> 16) != 0) {
                CpCanvas::sort_skill[cnt++] = i + 1;
            }
        }
        CpCanvas::skill_suu = cnt;
    }
}

// ==================== AddLib ====================
void CpCanvas::AddLib(int n) {
    if (n > 0 && n <= 224) {
        if ((CpCanvas::tip_list[n] >> 16) == 0) {
            CpCanvas::tip_list[n] = CpCanvas::tip_list[n] | (1 << 16);
            ++CpCanvas::get_tip;
        }
    }
}

// ==================== ImgSuu ====================
void CpCanvas::ImgSuu(int v, int x, int y, int w, int a, int b) {
    std::string str = std::to_string(v);
    int len = (int)str.length();
    if (a == 1) {
        for (int i = 0; i < len; ++i) {
            int digit = str[i] - '0';
            drawImg3(44, 45 + digit, x + i * 8, y, false);
        }
    } else {
        for (int i = 0; i < len; ++i) {
            int digit = str[i] - '0';
            drawImg3(44, 45 + digit, x + (w - len * 8) + i * 8, y, false);
        }
    }
}

// ==================== strDraw ====================
void CpCanvas::strDraw(std::string s, int x, int y) {
    CpCanvas::g->drawString(s, x, y);
}

// ==================== strDrawG ====================
void CpCanvas::strDrawG(std::string s, int x, int y) {
    CpCanvas::graMap->drawString(s, x, y);
}

// ==================== FaceDraw ====================
void CpCanvas::FaceDraw(int n) {
    // Face drawing stub
}

// ==================== FaceDrawA ====================
int CpCanvas::FaceDrawA(int a, int b, int c, int d) {
    // Face drawing stub
    return 1;
}

// ==================== IventRead ====================
void CpCanvas::IventRead(int n, int n2) {
    CpCanvas::ivent_flg = 0;
    CpCanvas::ivent_id = n;
    CpCanvas::ivent_cnt = 0;
    CpCanvas::kouka_flg = 0;
    CpCanvas::kouka_cnt = 0;
    CpCanvas::machi_damy_flg = -1;
}

// ==================== IventMain ====================
int CpCanvas::IventMain() {
    return -1;
}

// ==================== imgAddDraw ====================
void CpCanvas::imgAddDraw(int n, int x, int y) {
    if (CpCanvas::image_add[n] != nullptr) {
        CpCanvas::g->drawImage(CpCanvas::image_add[n], x, y);
    }
}

// ==================== CharaCnt ====================
int CpCanvas::CharaCnt() {
    return 4;
}

// ==================== GetItem ====================
void CpCanvas::GetItem(int n, int n2, int n3) {
    if (n == 0 && n3 > 0) {
        AddLib(n3);
    } else if (n == 1) {
        CpCanvas::zenny += n3;
    } else if (n == 2) {
        CpCanvas::piece += n3;
    }
}

// ==================== ItemName ====================
std::string CpCanvas::ItemName(int n, int n2) {
    if (n == 0) {
        int tipId = CpCanvas::tip_list[n2] >> 8 & 0xFF;
        if (tipId > 0 && tipId < 224) {
            return CpCanvas::tip[tipId]->name;
        }
    }
    return "?";
}

// ==================== Load ====================
void CpCanvas::Load(int n) {
    // Savegame loading stub
}

// ==================== Save ====================
void CpCanvas::Save(int n) {
    // Savegame saving stub
}

// ==================== writeSP ====================
void CpCanvas::writeSP() {
    // Scratchpad writing stub
}

// ==================== SkillRun ====================
void CpCanvas::SkillRun(int n) {
    for (int i = 0; i < 25; ++i) {
        CpCanvas::skill_kouka[i] = 0;
    }
}

// ==================== ListSort ====================
void CpCanvas::ListSort(int n) {
    // List sorting stub
}

// ==================== MakeRank ====================
void CpCanvas::MakeRank(int n) {
    // Ranking make stub
}

// ==================== GetScenario ====================
void CpCanvas::GetScenario(int n) {
    CpCanvas::http_error = 0;
}

// ==================== QMake ====================
void CpCanvas::QMake() {
    // Quest make stub
}

// ==================== MakeTr ====================
void CpCanvas::MakeTr() {
    // Trade make stub
}

// ==================== ReadTr ====================
void CpCanvas::ReadTr(int n) {
    // Trade read stub
}

// ==================== QNo ====================
int CpCanvas::QNo() {
    return 0;
}

// ==================== QClear ====================
void CpCanvas::QClear() {
    // Quest clear stub
}

// ==================== QAll ====================
void CpCanvas::QAll() {
    CpCanvas::q_get = 0;
    CpCanvas::http_error = 0;
}

// ==================== GetQTit ====================
void CpCanvas::GetQTit() {
    // Get quest title stub
}

// ==================== QDawn ====================
void CpCanvas::QDawn(int n, int n2) {
    // Quest download stub
}

// ==================== getKeypadState ====================
int CpCanvas::getKeypadState() {
    return CpCanvas::key2;
}

// ==================== SetUp ====================
void CpCanvas::SetUp() {
    // Allocate arrays
    CpCanvas::panel = new BtPanel*[18];
    for (int i = 0; i < 18; ++i) {
        CpCanvas::panel[i] = new BtPanel();
    }
    CpCanvas::ene = new Ene*[3];
    CpCanvas::oki = new Okimono*[6];
    CpCanvas::ata = new Attack*[30];
    CpCanvas::fol = new Folder*[4];
    for (int i = 0; i < 4; ++i) {
        CpCanvas::fol[i] = new Folder();
    }
    CpCanvas::tip = new Tip*[256];
    for (int i = 0; i < 256; ++i) {
        CpCanvas::tip[i] = new Tip(i);
    }
    CpCanvas::waza = new Waza*[64];
    CpCanvas::mail = new Mail*[32];
    CpCanvas::skill = new Skill*[148];
    CpCanvas::image = new PalettedImage*[64];
    CpCanvas::pal = new Palette*[128];
    CpCanvas::audio = new AudioPresenter*[16];
    CpCanvas::m_audio = new AudioPresenter*[30];
    CpCanvas::m_audio_se = new AudioPresenter*[30];
    CpCanvas::imgMap2 = new Image*[9];
    CpCanvas::graMap2 = new Graphics*[9];
    CpCanvas::image_add = new Image*[16];
    
    CpCanvas::tip_list = new int[512]();
    CpCanvas::skill_list = new int[148]();
    CpCanvas::dat = new int[128]();
    CpCanvas::bt_get = new int[3]();
    CpCanvas::wana_pow = new int[4]();
    CpCanvas::cas_tip = new int[10]();
    CpCanvas::fol_tip_no = new int[10]();
    CpCanvas::set_tip = new int[5]();
    CpCanvas::sel_code = new int[5]();
    CpCanvas::cas_ok = new int[10]();
    CpCanvas::soft_id = new int[4]();
    CpCanvas::teki_ren = new int[22]();
    CpCanvas::e_data = new int*[136];
    for (int i = 0; i < 136; ++i) {
        CpCanvas::e_data[i] = new int[5]();
    }
    CpCanvas::e_name = new std::string[3];
    CpCanvas::se_set = new int[5]();
    CpCanvas::se_flg = new int[5]();
    CpCanvas::now_se = new int[5]();
    CpCanvas::now_se_flg = new int[5]();
    CpCanvas::now_se_cnt = new int[5]();
    CpCanvas::skill_kouka = new int[25]();
    CpCanvas::sort_list = new int[224]();
    CpCanvas::sort_skill = new int[74]();
    CpCanvas::navi_flg = new int[12]();
    CpCanvas::TIP_MAX = new int[5]();
    CpCanvas::p_siz = new int[98]();
    CpCanvas::item_flg = new int[276]();
    CpCanvas::tobi_flg = new int[138]();
    CpCanvas::chara_flg = new int[276]();
    CpCanvas::pa_data = new int[306]();
    CpCanvas::m_data = new int[432]();
    CpCanvas::m_ene = new int[207]();
    CpCanvas::m_warp = new int[4]();
    CpCanvas::m_item = new int[16]();
    CpCanvas::m_tobi = new int[10]();
    CpCanvas::m_chara = new int[24]();
    CpCanvas::p_pat = new int[69]();
    CpCanvas::p_col = new int[14]();
    CpCanvas::ene_set = new int[207]();
    CpCanvas::mes = new int[3]();
    CpCanvas::talk_flg = new int[84]();
    CpCanvas::move_ok = new int[21]();
    CpCanvas::plg_ok = new int[21]();
    CpCanvas::m_move = new int[5]();
    CpCanvas::m_ivent = new int[20]();
    CpCanvas::m_plg = new int[6]();
    CpCanvas::i_chara = new int[15]();
    CpCanvas::r_ivent = new int[17]();
    CpCanvas::q_flg = new int[2]();
    CpCanvas::q_list = new int[10]();
    CpCanvas::sh_syu = new int[16]();
    CpCanvas::sh_id = new int[16]();
    CpCanvas::sh_kin = new int[16]();
    CpCanvas::sh_list = new int[16]();
    CpCanvas::sh_zai = new int[1]();
    CpCanvas::set_t = new int[16]();
    CpCanvas::tr_list = new int[32]();
    CpCanvas::r_jun = new int[10]();
    CpCanvas::r_sco = new int[10]();
    CpCanvas::r_name = new std::string[10];
    CpCanvas::r_id = new int[10]();
    CpCanvas::sco_cnt = new int[10]();
    CpCanvas::sco = new int[10]();
    CpCanvas::r_tip = new int[20]();
    CpCanvas::r_map = new int[60]();
    CpCanvas::r_ene = new int[30]();
    CpCanvas::i_id = new int[10]();
    CpCanvas::talk_ch = new int[4]();
    CpCanvas::i_set = new int[4]();
    CpCanvas::i_x = new int[4]();
    CpCanvas::i_y = new int[4]();
    CpCanvas::i_data = new int[16]();
    CpCanvas::i_cnt = new int[2]();
    CpCanvas::i_siz = new int[2]();
    CpCanvas::face_x = new int[16]();
    CpCanvas::face_dx = new int[4]();
    CpCanvas::get_tip2 = new int[4]();
    CpCanvas::get_list = new int[224]();
    CpCanvas::q_data = new int[300]();
    CpCanvas::q_str = new std::string[10];
    CpCanvas::s_pos = new int[4]();
    CpCanvas::fol_data = new int[30]();
    CpCanvas::list_data = new int[224]();
    CpCanvas::img_siz3 = new int[22]();
    CpCanvas::q_txt = new std::string[10];
    CpCanvas::menu_str = new std::string[40];
    CpCanvas::soft_str = new std::string[10];
    CpCanvas::sys_dat = new int[128]();
    CpCanvas::pa_tip = new int[5]();
    CpCanvas::r_str = new std::string[10];
    CpCanvas::t_str2 = new std::string[10];
    CpCanvas::waza_str = new std::string[64];
    CpCanvas::map_str = new std::string[69];
    CpCanvas::t_str = new std::string[10];
    CpCanvas::o_str = new std::string[10];
    CpCanvas::m_name = new std::string[21];
    CpCanvas::p_name = new std::string[32];
    CpCanvas::rock_mo = new int[32]();
    CpCanvas::eff_mo = new int[32]();
    CpCanvas::eff_se = new int[32]();
    CpCanvas::teki_mo = new int[32]();
    CpCanvas::wait_data = new int[32]();
    CpCanvas::fol_d = new int[30]();
    
    CpCanvas::gx = new int*[64];
    CpCanvas::gy = new int*[64];
    CpCanvas::sx = new int*[64];
    CpCanvas::sy = new int*[64];
    CpCanvas::dx = new int*[64];
    CpCanvas::dy = new int*[64];
    for (int i = 0; i < 64; ++i) {
        CpCanvas::gx[i] = new int[128]();
        CpCanvas::gy[i] = new int[128]();
        CpCanvas::sx[i] = new int[128]();
        CpCanvas::sy[i] = new int[128]();
        CpCanvas::dx[i] = new int[128]();
        CpCanvas::dy[i] = new int[128]();
    }
    
    CpCanvas::ani = new int**[64];
    CpCanvas::a_dx = new int**[64];
    CpCanvas::a_dy = new int**[64];
    for (int i = 0; i < 64; ++i) {
        CpCanvas::ani[i] = new int*[32];
        CpCanvas::a_dx[i] = new int*[32];
        CpCanvas::a_dy[i] = new int*[32];
        for (int j = 0; j < 32; ++j) {
            CpCanvas::ani[i][j] = new int[32]();
            CpCanvas::a_dx[i][j] = new int[32]();
            CpCanvas::a_dy[i][j] = new int[32]();
        }
    }
    
    // Initialize strings
    for (int i = 0; i < 10; ++i) {
        CpCanvas::set_str[i] = "";
        CpCanvas::t_str[i] = "";
        CpCanvas::o_str[i] = "";
    }
    CpCanvas::set_str[4] = "OK";
    
    // Load data
    ImgSet();
    TipSet();
    MldSet();
    PASet();
    EneSet(-1, 0);
    init(0);
}

// ==================== qestGet ====================
std::vector<uint8_t> CpCanvas::qestGet(int n, uint8_t* byArray) {
    std::vector<uint8_t> result(3010);
    // Quest data loading stub
    return result;
}

// ==================== qestNo ====================
std::vector<uint8_t> CpCanvas::qestNo(int n, uint8_t* byArray) {
    std::vector<uint8_t> result(3010);
    // Quest number loading stub
    return result;
}

// ==================== qestOK ====================
bool CpCanvas::qestOK(int n, uint8_t* byArray) {
    return false;
}

