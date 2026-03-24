/*
 * CpCanvas.cpp - Main game class for P.o.N. PC Port
 * Translated from CpCanvas.java (decompiled from P.o.N. i-mode game)
 */
#include "CpCanvas.h"
#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <algorithm>

/* =========================================================
 * Static field definitions
 * ========================================================= */
int  CpCanvas::deba_flg = 0;
int  CpCanvas::audio_flg = 1;
int  CpCanvas::game_cnt = 0;
int  CpCanvas::scene = -2;
int  CpCanvas::se_check = 0;
int  CpCanvas::play_flg = 0;
long long CpCanvas::mill = 0;
long long CpCanvas::fade = 0;
int  CpCanvas::kai = 0;
int  CpCanvas::key = 0;
int  CpCanvas::okey = 0;
int  CpCanvas::key_cnt = 0;
int *CpCanvas::tip_list = nullptr;
int *CpCanvas::skill_list = nullptr;
int *CpCanvas::dat = nullptr;
int  CpCanvas::score = 0;
int  CpCanvas::user_id = 0;
int  CpCanvas::sina_no = 0;
int  CpCanvas::sina_flg = 0;
int  CpCanvas::item_flg[20][2] = {};
int  CpCanvas::tobi_flg[20][2] = {};
int  CpCanvas::chara_flg[40][2] = {};
int  CpCanvas::pa_data[50][4] = {};
int  CpCanvas::mode = 0;
int  CpCanvas::mode2 = 0;
int  CpCanvas::option_flg = 0;
int  CpCanvas::o_mode = 0;
int  CpCanvas::o_cnt = 0;
int  CpCanvas::teki_pt = 0;
int  CpCanvas::teki_ren[10][4] = {};
int  CpCanvas::ren_id = 0;
int  CpCanvas::ren_flg = 0;
int  CpCanvas::cus_gage = 0;
int  CpCanvas::cus_sp = 0;
int  CpCanvas::fade_cnt = 0;
int  CpCanvas::stop_time = 0;
int  CpCanvas::stop_cnt = 0;
int  CpCanvas::eff_id = 0;
std::string CpCanvas::stop_name;
int  CpCanvas::win_flg = 0;
int  CpCanvas::boss_flg = 0;
int  CpCanvas::ene_cnt = 0;
int  CpCanvas::dell_cnt = 0;
int  CpCanvas::bas_flg = 0;
int  CpCanvas::bas_lv = 0;
int  CpCanvas::bas_cnt = 0;
int  CpCanvas::bt_get[10] = {};
long long CpCanvas::audio_mill = 0;
int  CpCanvas::over_cnt = 0;
int  CpCanvas::over_flg = 0;
int  CpCanvas::wana_flg = 0;
int  CpCanvas::wana_pow[6] = {};
int  CpCanvas::combo = 0;
int  CpCanvas::combo_cnt = 0;
int  CpCanvas::combo_time = 0;
int  CpCanvas::stop_ch = 0;
int  CpCanvas::dell_lv = 0;
int  CpCanvas::cas_tip[10] = {};
int  CpCanvas::fol_tip_no[10] = {};
int  CpCanvas::set_tip[10] = {};
int  CpCanvas::sel_cas_mode = 0;
int  CpCanvas::sel_cas_tip = 0;
int  CpCanvas::max_sel = 0;
int  CpCanvas::sel_cnt = 0;
int  CpCanvas::now_code = 0;
int  CpCanvas::sel_code[5] = {};
int  CpCanvas::cas_ok[10] = {};
int  CpCanvas::cas_cnt = 0;
int  CpCanvas::regu_flg = 0;
int  CpCanvas::esc_flg = 0;
int  CpCanvas::fol_d[10] = {};
int  CpCanvas::pa_no = 0;
int  CpCanvas::pa_start = 0;
int  CpCanvas::pa_cnt = 0;
int  CpCanvas::pa_cnt2 = 0;
int  CpCanvas::pa_tip[20] = {};
int  CpCanvas::pa_code_flg = 0;
int  CpCanvas::ata_cnt = 0;
int **CpCanvas::gx = nullptr;
int **CpCanvas::gy = nullptr;
int **CpCanvas::sx = nullptr;
int **CpCanvas::sy = nullptr;
int **CpCanvas::dx = nullptr;
int **CpCanvas::dy = nullptr;
int ***CpCanvas::ani = nullptr;
int ***CpCanvas::a_dx = nullptr;
int ***CpCanvas::a_dy = nullptr;
std::string CpCanvas::str;
int *CpCanvas::p_siz = nullptr;
int  CpCanvas::drop_ene = 0;
int  CpCanvas::eria_cnt = 0;
int  CpCanvas::sec_cha = 0;
int  CpCanvas::zan = 0;
int  CpCanvas::map_no = 0;
int  CpCanvas::map_x = 0;
int  CpCanvas::map_y = 0;
int  CpCanvas::ivent_flg = 0;
int  CpCanvas::ivent_id = 0;
int  CpCanvas::ivent_set = 0;
int  CpCanvas::ivent_cnt = 0;
int  CpCanvas::i_id[20] = {};
int  CpCanvas::talk_ch[6] = {};
int  CpCanvas::kouka_flg = 0;
int  CpCanvas::kouka_cnt = 0;
int  CpCanvas::yure = 0;
int  CpCanvas::mail_flg = 0;
int  CpCanvas::mail_cnt = 0;
int  CpCanvas::skill_flg = 0;
int  CpCanvas::yes_no_flg = 0;
int  CpCanvas::jump_ivent = 0;
int  CpCanvas::navi_flg[4] = {};
int  CpCanvas::come_back = 0;
int  CpCanvas::i_set[10] = {};
int  CpCanvas::i_x[10] = {};
int  CpCanvas::i_y[10] = {};
int  CpCanvas::s_hen = 0;
int  CpCanvas::q_hen = 0;
int  CpCanvas::now_bgm = 0;
int  CpCanvas::i_data[200] = {};
int  CpCanvas::i_cnt[10] = {};
int  CpCanvas::i_siz[10][2] = {};
int  CpCanvas::ivent_syu = 0;
int  CpCanvas::talk_cnt2 = 0;
int  CpCanvas::face_x[8][2] = {};
int  CpCanvas::face_dx[8] = {};
int  CpCanvas::menu_no = 0;
int  CpCanvas::back_menu = 0;
int  CpCanvas::menu_sel = 0;
int  CpCanvas::menu_cnt = 0;
int  CpCanvas::menu_flg = 0;
int  CpCanvas::sel_tip = 0;
int  CpCanvas::sel_tip2 = 0;
int  CpCanvas::sel_jou = 0;
int  CpCanvas::sel_jou2 = 0;
int  CpCanvas::tmp_tip = 0;
int  CpCanvas::sort_v = 0;
int  CpCanvas::fol_cnt = 0;
int  CpCanvas::TIP_MAX[5] = {};
int  CpCanvas::ata_lv = 0;
int  CpCanvas::cha_lv = 0;
int  CpCanvas::max_hp = 0;
int  CpCanvas::now_hp = 0;
int  CpCanvas::zenny = 0;
int  CpCanvas::piece = 0;
int  CpCanvas::full_ene = 0;
int  CpCanvas::now_fol = 0;
int  CpCanvas::fol_suu = 0;
int  CpCanvas::regu_you = 0;
int  CpCanvas::get_tip = 0;
int *CpCanvas::get_tip2 = nullptr;
int *CpCanvas::get_list = nullptr;
int *CpCanvas::sort_list = nullptr;
int *CpCanvas::sort_skill = nullptr;
int  CpCanvas::mail_suu = 0;
int  CpCanvas::mail_open = 0;
int  CpCanvas::skill_suu = 0;
unsigned char *CpCanvas::q_data = nullptr;
std::string *CpCanvas::q_str = nullptr;
int  CpCanvas::quest_no = 0;
int  CpCanvas::http_error = 0;
int  CpCanvas::s_pos[20] = {};
std::string CpCanvas::url;
int  CpCanvas::skill_kouka[15] = {};
int  CpCanvas::sort_flg = 0;
int  CpCanvas::m_max = 0;
int  CpCanvas::g_max = 0;
int  CpCanvas::d_ene_syu = 0;
int  CpCanvas::d_ene_lv = 0;
int  CpCanvas::rock_mu = 0;
int  CpCanvas::teki_mu = 0;
int  CpCanvas::teki_mark = 0;
int  CpCanvas::list_suu = 0;
int *CpCanvas::fol_data = nullptr;
int *CpCanvas::list_data = nullptr;
int  CpCanvas::que_su = 0;
int  CpCanvas::p_no = 0;
int  CpCanvas::p_no2 = 0;
int  CpCanvas::hyo = 0;
int  CpCanvas::ch_no = 0;
int  CpCanvas::g_no = 0;
int  CpCanvas::awa = 0;
int  CpCanvas::plt = 0;
int  CpCanvas::ani_pt_g = 0;
int  CpCanvas::ani_cnt_g = 0;
int  CpCanvas::flp = 0;
int *CpCanvas::img_siz3 = nullptr;
int  CpCanvas::rika_cnt = 0;
int  CpCanvas::ghost = 0;
int  CpCanvas::map_bgm = 0;
std::string *CpCanvas::q_txt = nullptr;
int  CpCanvas::port_suu = 0;
int *CpCanvas::se_set = nullptr;
int *CpCanvas::se_flg = nullptr;
int *CpCanvas::now_se = nullptr;
int *CpCanvas::now_se_flg = nullptr;
int *CpCanvas::now_se_cnt = nullptr;
int *CpCanvas::sys_dat = nullptr;
std::string CpCanvas::DomeUrl;
std::string CpCanvas::Ver;
std::string CpCanvas::AppID;
int *CpCanvas::wait_data = nullptr;
int *CpCanvas::rock_mo = nullptr;
int *CpCanvas::eff_mo = nullptr;
int *CpCanvas::sh_syu = nullptr;
int *CpCanvas::sh_id = nullptr;
int *CpCanvas::sh_kin = nullptr;
int  CpCanvas::sh_zai[8][12] = {};
int  CpCanvas::shop_syu = 0;
int  CpCanvas::soft_id[2] = {0, 1};
long long CpCanvas::rand_seed = 12345;
std::string CpCanvas::set_str[10];
int *CpCanvas::waza_mo = nullptr;

Ene     CpCanvas::ene[3];
Okimono *CpCanvas::oki = nullptr;
BtPanel  CpCanvas::panel[3][6];
Folder  *CpCanvas::fol = nullptr;
Tip      CpCanvas::tip_obj[TIP_SUU];
Attack  *CpCanvas::ata   = nullptr;
Waza   **CpCanvas::waza  = nullptr;
Mail   **CpCanvas::mail  = nullptr;
Skill  **CpCanvas::skill = nullptr;
Rock    *CpCanvas::rock  = nullptr;

PlatImage    *CpCanvas::image[IMG_SUU]     = {};
PlatImage    *CpCanvas::image_add[10]      = {};
PlatPalette  *CpCanvas::pal[IMG_SUU]       = {};
PlatAudio    *CpCanvas::audio[SOUND_SUU + BGM_SUU] = {};
PlatAudio    *CpCanvas::m_audio[BGM_MAX]   = {};
PlatAudio    *CpCanvas::m_audio_se[SE_MAX] = {};
PlatSound    *CpCanvas::se_sounds[MLD_MAX] = {};

/* =========================================================
 * Random number generator (Java's java.util.Random equivalent)
 * ========================================================= */
int CpCanvas::nextInt()
{
    rand_seed = (rand_seed * 0x5DEECE66DLL + 0xBLL) & 0xFFFFFFFFFFFFLL;
    return (int)(rand_seed >> 16);
}

/* =========================================================
 * intChange - big-endian 32-bit read
 * ========================================================= */
int CpCanvas::intChange(const unsigned char *b, int off)
{
    return ((b[off]&0xFF)<<24)|((b[off+1]&0xFF)<<16)|((b[off+2]&0xFF)<<8)|(b[off+3]&0xFF);
}

/* =========================================================
 * String drawing helpers
 * ========================================================= */
void CpCanvas::strDraw(const std::string &s, int x, int y)
{
    Platform_DrawString(s, x, y - 1);  /* Java y is baseline, Win32 y is top */
}

/* =========================================================
 * Image drawing
 * ========================================================= */
void CpCanvas::drawImg(int n, int x, int y, bool flip)
{
    if (n < 0 || n >= IMG_SUU) return;
    PlatImage *img = image[n];
    if (!img) return;
    Platform_SetFlipMode(flip ? 1 : 0);
    Platform_DrawImage(img, x, y, 0, 0, img->width, img->height);
    Platform_SetFlipMode(0);
}

void CpCanvas::drawImg2(int n, int x, int y, int scale, int alpha)
{
    if (n < 0 || n >= IMG_SUU) return;
    PlatImage *img = image[n];
    if (!img) return;
    /* Scale not supported in basic version */
    Platform_DrawImage(img, x, y, 0, 0, img->width, img->height);
}

void CpCanvas::drawImg3(int img_no, int n, int x, int y, bool flip)
{
    /* img_no = image array index, n = sprite index within image */
    if (img_no < 0 || img_no >= IMG_SUU) return;
    PlatImage *img = image[img_no];
    if (!img || !gx || !gy || !sx || !sy) return;
    if (!gx[img_no] || !gy[img_no] || !sx[img_no] || !sy[img_no]) return;
    Platform_SetFlipMode(flip ? 1 : 0);
    Platform_DrawImage(img, x, y,
                       gx[img_no][n], gy[img_no][n],
                       sx[img_no][n], sy[img_no][n]);
    Platform_SetFlipMode(0);
}

/* =========================================================
 * Ani - animation frame draw
 * Returns -2 if animation ended
 * ========================================================= */
int CpCanvas::Ani(int img_no, int pt, int cnt, int px, int py, int adx, int ady, int flip)
{
    if (img_no <= 0 || img_no >= IMG_SUU) return -1;
    PlatImage *img = image[img_no];
    if (!img || !ani || !ani[img_no]) return -1;
    if (!ani[img_no][pt]) return -2;

    int frame = ani[img_no][pt][cnt];
    if (frame == -2) return -2;
    if (frame < 0) return -1;

    /* Calculate screen position */
    int screen_x = px * BT_SIZE_X + BT_OFF_X + adx;
    int screen_y = py * BT_SIZE_Y + BT_OFF_Y + ady;

    if (!gx || !gy || !sx || !sy || !a_dx || !a_dy) return -1;
    if (!gx[img_no] || !gy[img_no] || !sx[img_no] || !sy[img_no]) return -1;
    if (!a_dx[img_no] || !a_dx[img_no][pt] || !a_dy[img_no] || !a_dy[img_no][pt]) return -1;

    int draw_x = screen_x + a_dx[img_no][pt][cnt];
    int draw_y = screen_y + a_dy[img_no][pt][cnt];

    Platform_SetFlipMode(flip);
    Platform_DrawImage(img, draw_x, draw_y,
                       gx[img_no][frame], gy[img_no][frame],
                       sx[img_no][frame], sy[img_no][frame]);
    Platform_SetFlipMode(0);
    return frame;
}

/* =========================================================
 * HP bar drawing
 * ========================================================= */
void CpCanvas::HpDraw(int hp, int x, int y)
{
    /* Draw HP as colored bar */
    int bar_w = 40;
    int bar_h = 4;
    int fill = hp > 0 ? (hp * bar_w / (max_hp > 0 ? max_hp : 1)) : 0;
    if (fill > bar_w) fill = bar_w;
    Platform_SetColor(Platform_MakeColor(0, 0, 0));
    Platform_FillRect(x, y, bar_w, bar_h);
    Platform_SetColor(fill > bar_w/3 ? Platform_MakeColor(0, 200, 0) : Platform_MakeColor(200, 0, 0));
    if (fill > 0) Platform_FillRect(x, y, fill, bar_h);
    Platform_SetColor(Platform_MakeColor(255, 255, 255));
    strDraw(std::to_string(hp), x, y + 12);
}

/* =========================================================
 * PalSet - apply palette to image
 * ========================================================= */
void CpCanvas::PalSet(int n, int pal_no)
{
    /* Palette application - not fully implemented yet */
    (void)n; (void)pal_no;
}

/* =========================================================
 * AddLib - add chip to library
 * ========================================================= */
void CpCanvas::AddLib(int n)
{
    /* Update tip_list library count */
    if (!tip_list || n < 0 || n >= TIP_SUU) return;
    int idx = (tip_list[n] >> 24) & 0xFF;
    if (idx == 0) {
        /* Mark as owned */
        tip_list[n] |= (1 << 24);
    }
}

/* =========================================================
 * AtaNo - find free attack slot
 * ========================================================= */
int CpCanvas::AtaNo(int n)
{
    if (!ata) return 0;
    for (int i = 0; i < ATA_MAX; i++) {
        if (ata[i].on == 0) {
            ata[i].on = n < 0 ? 0 : 1;
            ++ata_cnt;
            return i;
        }
    }
    return 0;
}

/* =========================================================
 * Audio
 * ========================================================= */
void CpCanvas::Audio(int type, int n)
{
    /* type: 0=stop, 1=play BGM, 2=fade */
    now_bgm = n;
    if (type == 0) {
        if (m_audio[n % BGM_MAX]) Platform_AudioStop(m_audio[n % BGM_MAX]);
    } else if (type == 1) {
        if (m_audio[n % BGM_MAX]) Platform_AudioPlay(m_audio[n % BGM_MAX]);
    }
}

void CpCanvas::sePlay()
{
    /* Play sound effects */
    for (int i = 0; i < SE_MAX; i++) {
        if (m_audio_se[i] && se_flg && se_flg[i]) {
            Platform_AudioPlay(m_audio_se[i]);
            se_flg[i] = 0;
        }
    }
}

void CpCanvas::Soft(int n, int id)
{
    /* Draw soft key labels */
    /* Minimal implementation - draw key hint at bottom */
}

/* =========================================================
 * Scratchpad I/O
 * ========================================================= */
void CpCanvas::readSP()
{
    if (!dat) {
        dat = new int[100];
        memset(dat, 0, 100 * sizeof(int));
    }
    InputStream *is = Platform_SP_OpenRead(0, 300);
    if (is && is->len >= 4) {
        unsigned char buf[4];
        for (int i = 0; i < 75 && i < 100; i++) {
            if (is->read(buf, 4) < 4) break;
            dat[i] = ((buf[0]&0xFF)<<24)|((buf[1]&0xFF)<<16)|((buf[2]&0xFF)<<8)|(buf[3]&0xFF);
        }
    }
    delete is;
    sysLoad();
}

void CpCanvas::writeSP()
{
    if (!dat) return;
    unsigned char buf[300];
    for (int i = 0; i < 75; i++) {
        buf[i*4+0] = (dat[i] >> 24) & 0xFF;
        buf[i*4+1] = (dat[i] >> 16) & 0xFF;
        buf[i*4+2] = (dat[i] >> 8)  & 0xFF;
        buf[i*4+3] =  dat[i]        & 0xFF;
    }
    Platform_SP_Write(0, buf, 300);
}

int CpCanvas::spSave(const unsigned char *data, int pos, int len)
{
    return Platform_SP_Write(pos, data, len);
}

int CpCanvas::spSave(const int *nArray, int pos, int len)
{
    std::vector<unsigned char> buf(len * 4);
    for (int i = 0; i < len; i++) {
        buf[i*4+0] = (nArray[i] >> 24) & 0xFF;
        buf[i*4+1] = (nArray[i] >> 16) & 0xFF;
        buf[i*4+2] = (nArray[i] >> 8)  & 0xFF;
        buf[i*4+3] =  nArray[i]        & 0xFF;
    }
    return Platform_SP_Write(pos, buf.data(), len * 4);
}

int CpCanvas::spLoad(unsigned char *data, int pos, int len)
{
    InputStream *is = Platform_SP_OpenRead(pos, len);
    if (!is) return -1;
    int r = is->read(data, len);
    delete is;
    return r;
}

int CpCanvas::spLoad(int *nArray, int pos, int len)
{
    unsigned char buf[4];
    InputStream *is = Platform_SP_OpenRead(pos, len * 4);
    if (!is) return -1;
    for (int i = 0; i < len; i++) {
        if (is->read(buf, 4) < 4) break;
        nArray[i] = ((buf[0]&0xFF)<<24)|((buf[1]&0xFF)<<16)|((buf[2]&0xFF)<<8)|(buf[3]&0xFF);
    }
    delete is;
    return len * 4;
}

InputStream *CpCanvas::spLoad_stream(int pos, int len)
{
    return Platform_SP_OpenRead(pos, len);
}

void CpCanvas::sysLoad()
{
    if (!sys_dat) {
        sys_dat = new int[255];
        memset(sys_dat, 0, 255 * sizeof(int));
    }
    InputStream *is = Platform_SP_OpenRead(409600, 255 * 4);
    if (is && is->len >= 4) {
        unsigned char buf[4];
        for (int i = 0; i < 255; i++) {
            if (is->read(buf, 4) < 4) break;
            sys_dat[i] = ((buf[0]&0xFF)<<24)|((buf[1]&0xFF)<<16)|((buf[2]&0xFF)<<8)|(buf[3]&0xFF);
        }
    }
    delete is;
}

void CpCanvas::sysSave()
{
    if (!sys_dat) return;
    unsigned char buf[255 * 4];
    for (int i = 0; i < 255; i++) {
        buf[i*4+0] = (sys_dat[i] >> 24) & 0xFF;
        buf[i*4+1] = (sys_dat[i] >> 16) & 0xFF;
        buf[i*4+2] = (sys_dat[i] >> 8)  & 0xFF;
        buf[i*4+3] =  sys_dat[i]        & 0xFF;
    }
    Platform_SP_Write(409600, buf, 255 * 4);
}

/* =========================================================
 * JarGet - get data block from scratchpad
 * ========================================================= */
InputStream *CpCanvas::JarGet(int n)
{
    if (!dat) return new InputStream();
    static int nArray[37];
    static int nArray2[37] = {
        1,1,1,1,1,1,0,1,0,0,0,0,0,0,1,1,
        1,0,1,1,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,1,0
    };

    nArray[0] = AD_TOP + 37 * 4;  /* = 3544 */
    for (int n2 = 1; n2 < 37; n2++) {
        nArray[n2] = nArray[n2-1] + dat[n2-1];
    }

    if (n < 0 || n >= 37) return new InputStream();
    if (dat[n] <= 0) return new InputStream();

    InputStream *base_is = Platform_SP_OpenRead(nArray[n], dat[n]);
    if (!base_is || base_is->len <= 0) {
        delete base_is;
        return new InputStream();
    }

    if (nArray2[n] == 0) {
        /* Raw data */
        return base_is;
    } else {
        /* Compressed JAR - inflate data.dat */
        int out_size = 0;
        unsigned char *out = Platform_JAR_Inflate(base_is->buf, base_is->len, &out_size);
        delete base_is;
        if (!out || out_size <= 0) return new InputStream();
        return new InputStream(out, out_size, true);
    }
}

/* =========================================================
 * GetData - get scenario/quest data from scratchpad
 * ========================================================= */
InputStream *CpCanvas::GetData(int n)
{
    if (!dat) return new InputStream();
    int n3 = dat[48];
    int n2;
    for (n2 = 0; n2 < n; n2++) {
        n3 += s_pos[n2];
        if (n2 == 7) break;
    }

    InputStream *is = nullptr;
    if (n < 5) {
        is = Platform_SP_OpenRead(n3, s_pos[n]);
    } else {
        int size;
        if (n < 8) {
            size = dat[35 + n];
        } else {
            for (n2 = 0; n2 < n - 8; n2++) {
                n3 += dat[43 + n2];
            }
            size = dat[35 + n];
        }
        InputStream *raw = Platform_SP_OpenRead(n3, size);
        if (!raw || raw->len <= 0) { delete raw; return new InputStream(); }
        /* Inflate data.dat */
        int out_size = 0;
        unsigned char *out = Platform_JAR_Inflate(raw->buf, raw->len, &out_size);
        delete raw;
        if (!out || out_size <= 0) return new InputStream();
        is = new InputStream(out, out_size, true);
    }
    return is ? is : new InputStream();
}

/* =========================================================
 * dataGet - read resource from JAR
 * ========================================================= */
int CpCanvas::dataGet(const std::string &path, unsigned char *buf)
{
    InputStream *is = Platform_JAR_OpenResource(path.c_str());
    if (!is || is->len <= 0) { delete is; return -1; }
    int r = is->read(buf, is->len);
    delete is;
    return r;
}

/* =========================================================
 * SortSkill / SortTip
 * ========================================================= */
void CpCanvas::SortSkill(int n)
{
    if (!skill_list || skill_suu <= 0) return;
    /* Simple bubble sort */
    for (int i = 0; i < skill_suu - 1; i++) {
        for (int j = 0; j < skill_suu - 1 - i; j++) {
            int a = skill_list[j];
            int b = skill_list[j+1];
            bool swap = (n == 0) ? (a > b) : ((a >> 16 & 0xFF) < (b >> 16 & 0xFF));
            if (swap) { skill_list[j] = b; skill_list[j+1] = a; }
        }
    }
}

void CpCanvas::SortTip(int mode_s, int dir)
{
    if (!tip_list || !sort_list) return;
    /* Uses sort_list as working buffer */
}

/* =========================================================
 * MesRead / MesFlg / MesDraw - message display
 * ========================================================= */
static std::string s_mes_text;
static int s_mes_cnt = 0;
static int s_mes_max = 0;
static int s_mes_type = 0;

void CpCanvas::MesRead(int n, const unsigned char *data, int type)
{
    s_mes_type = type;
    s_mes_cnt = 0;
    /* Get message text from resource */
    /* For now, store the id and draw a placeholder */
    s_mes_text = "[MES " + std::to_string(n) + "]";
    s_mes_max = (int)s_mes_text.size();
}

bool CpCanvas::MesFlg()
{
    return s_mes_cnt >= s_mes_max;
}

void CpCanvas::MesDraw(int n)
{
    Platform_SetColor(Platform_MakeColor(255, 255, 255));
    Platform_FillRect(0, 190, 240, 50);
    Platform_SetColor(Platform_MakeColor(0, 0, 0));
    Platform_DrawRect(0, 190, 240, 50);
    Platform_SetColor(Platform_MakeColor(0, 0, 0));
    strDraw(s_mes_text, 5, 210);
    if (s_mes_cnt < s_mes_max) s_mes_cnt++;
}

/* =========================================================
 * Constructor
 * ========================================================= */
CpCanvas::CpCanvas()
    : bgm_no(0), se_no(0), deba_tip_id(0), cus_se_flg(0),
      rank_mes_id(0), m_syokai_flg(1), gapX(0), gapY(0)
{
    /* Allocate static arrays on first construction */
    static bool initialized = false;
    if (initialized) return;
    initialized = true;

    /* Initialize static arrays */
    dat        = new int[100];        memset(dat, 0, 100 * sizeof(int));
    tip_list   = new int[TIP_SUU*2]; memset(tip_list, 0, TIP_SUU*2 * sizeof(int));
    skill_list = new int[SKILL_SUU*4]; memset(skill_list, 0, SKILL_SUU*4 * sizeof(int));
    get_tip2   = new int[TIP_SUU];   memset(get_tip2, 0, TIP_SUU * sizeof(int));
    get_list   = new int[TIP_SUU];   memset(get_list, 0, TIP_SUU * sizeof(int));
    sort_list  = new int[TIP_SUU];   memset(sort_list, 0, TIP_SUU * sizeof(int));
    sort_skill = new int[SKILL_SUU]; memset(sort_skill, 0, SKILL_SUU * sizeof(int));
    q_str      = new std::string[30];
    q_txt      = new std::string[30];
    q_data     = new unsigned char[4096]; memset(q_data, 0, 4096);
    fol_data   = new int[200];       memset(fol_data, 0, 200 * sizeof(int));
    list_data  = new int[200];       memset(list_data, 0, 200 * sizeof(int));

    se_set     = new int[SE_MAX];    memset(se_set, 0, SE_MAX * sizeof(int));
    se_flg     = new int[SE_MAX];    memset(se_flg, 0, SE_MAX * sizeof(int));
    now_se     = new int[SE_MAX];    memset(now_se, 0, SE_MAX * sizeof(int));
    now_se_flg = new int[SE_MAX];    memset(now_se_flg, 0, SE_MAX * sizeof(int));
    now_se_cnt = new int[SE_MAX];    memset(now_se_cnt, 0, SE_MAX * sizeof(int));
    sys_dat    = new int[255];       memset(sys_dat, 0, 255 * sizeof(int));

    /* Sprite data arrays */
    wait_data  = new int[500];       memset(wait_data, 0, 500 * sizeof(int));
    rock_mo    = new int[ROCK_MO * 6]; memset(rock_mo, 0, ROCK_MO * 6 * sizeof(int));
    eff_mo     = new int[EFF_MO * 6]; memset(eff_mo, 0, EFF_MO * 6 * sizeof(int));
    waza_mo    = new int[TEKI_MO * 6]; memset(waza_mo, 0, TEKI_MO * 6 * sizeof(int));
    sh_syu     = new int[200];       memset(sh_syu, 0, 200 * sizeof(int));
    sh_id      = new int[200];       memset(sh_id, 0, 200 * sizeof(int));
    sh_kin     = new int[200];       memset(sh_kin, 0, 200 * sizeof(int));

    p_siz      = new int[100];       memset(p_siz, 0, 100 * sizeof(int));
    img_siz3   = new int[IMG_SUU3];  memset(img_siz3, 0, IMG_SUU3 * sizeof(int));

    /* Allocate game objects */
    oki  = new Okimono[6] {Okimono(0), Okimono(1), Okimono(2), Okimono(3), Okimono(4), Okimono(5)};
    fol  = new Folder[6];
    ata  = new Attack[ATA_MAX] { Attack(0), Attack(1), Attack(2), Attack(3), Attack(4),
                                  Attack(5), Attack(6), Attack(7), Attack(8), Attack(9),
                                  Attack(10), Attack(11), Attack(12), Attack(13), Attack(14),
                                  Attack(15), Attack(16), Attack(17), Attack(18), Attack(19),
                                  Attack(20), Attack(21), Attack(22), Attack(23), Attack(24),
                                  Attack(25), Attack(26), Attack(27), Attack(28), Attack(29) };
    waza = new Waza*[WAZA_MAX];
    for (int i2 = 0; i2 < WAZA_MAX; i2++) waza[i2] = nullptr; /* filled later */
    mail = new Mail*[30];
    for (int i2 = 0; i2 < 30; i2++) mail[i2] = nullptr;
    skill = new Skill*[SKILL_SUU];
    for (int i2 = 0; i2 < SKILL_SUU; i2++) skill[i2] = nullptr;
    rock = new Rock();

    /* Image/palette arrays */
    for (int i2 = 0; i2 < IMG_SUU; i2++) { image[i2] = nullptr; pal[i2] = nullptr; }
    for (int i2 = 0; i2 < 10; i2++) image_add[i2] = nullptr;
    for (int i2 = 0; i2 < SOUND_SUU + BGM_SUU; i2++) audio[i2] = nullptr;
    for (int i2 = 0; i2 < BGM_MAX; i2++) m_audio[i2] = nullptr;
    for (int i2 = 0; i2 < SE_MAX; i2++) m_audio_se[i2] = nullptr;
    for (int i2 = 0; i2 < MLD_MAX; i2++) { se_sounds[i2] = nullptr; se_inst[i2] = nullptr; }

    /* Sprite data - allocate placeholder arrays */
    gx = new int*[IMG_SUU];  memset(gx, 0, IMG_SUU * sizeof(int*));
    gy = new int*[IMG_SUU];  memset(gy, 0, IMG_SUU * sizeof(int*));
    sx = new int*[IMG_SUU];  memset(sx, 0, IMG_SUU * sizeof(int*));
    sy = new int*[IMG_SUU];  memset(sy, 0, IMG_SUU * sizeof(int*));
    dx = new int*[IMG_SUU];  memset(dx, 0, IMG_SUU * sizeof(int*));
    dy = new int*[IMG_SUU];  memset(dy, 0, IMG_SUU * sizeof(int*));
    ani = new int**[IMG_SUU]; memset(ani, 0, IMG_SUU * sizeof(int**));
    a_dx = new int**[IMG_SUU]; memset(a_dx, 0, IMG_SUU * sizeof(int**));
    a_dy = new int**[IMG_SUU]; memset(a_dy, 0, IMG_SUU * sizeof(int**));

    /* Init BtPanel */
    for (int i2 = 0; i2 < 3; i2++)
        for (int j2 = 0; j2 < 6; j2++)
            panel[i2][j2].init(j2, i2, (j2 < 3) ? 1 : 1);

    /* Set up set_str */
    set_str[0] = "P.o.N.";
    set_str[1] = "Loading...";
    set_str[2] = "Please Wait";
    set_str[3] = "100%";
    set_str[4] = "Complete!";
    set_str[5] = "0%";
    set_str[6] = "Setting Up...";
}

/* =========================================================
 * urlSet - initialize URLs (stub for PC port)
 * ========================================================= */
void CpCanvas::urlSet()
{
    url = "";
    DomeUrl = "";
    Ver = "1.0";
    AppID = "PON";
}

/* =========================================================
 * kidou - startup authentication (stub for PC port)
 * ========================================================= */
void CpCanvas::kidou()
{
    dat[52] = 1;
}

/* =========================================================
 * SetUp - game initialization
 * ========================================================= */
void CpCanvas::SetUp()
{
    readSP();
    urlSet();
    kidou();
    dat[52] = 1;

    /* Loading screen */
    Platform_SetColor(Platform_MakeColor(0, 0, 0));
    Platform_FillRect(0, 0, GAMEN_X, GAMEN_Y);
    Platform_SetColor(Platform_MakeColor(170, 170, 170));
    strDraw(set_str[0], (GAMEN_X - Platform_StringWidth(set_str[0])) / 2, 55);

    /* Skip download if data already present */
    /* dat[49] = download flag (0 = need download, non-zero = done) */
    /* For PC port, always skip download and use PoN.sp */
    if (dat[49] == 0) {
        /* Initialize with default values */
        dat[49] = 1;
        dat[48] = 3396 + 37*4;   /* Point past block table */
        writeSP();
        /* Also load block sizes from scratchpad offset 3396 */
        unsigned char buf[148];
        if (spLoad(buf, AD_TOP, 148) > 0) {
            for (int i2 = 0; i2 < 37; i2++) {
                dat[i2] = ((buf[i2*4]&0xFF)<<24)|((buf[i2*4+1]&0xFF)<<16)|
                          ((buf[i2*4+2]&0xFF)<<8)|(buf[i2*4+3]&0xFF);
            }
        }
    } else {
        /* Load block sizes from scratchpad */
        unsigned char buf[148];
        if (spLoad(buf, AD_TOP, 148) > 0) {
            for (int i2 = 0; i2 < 37; i2++) {
                dat[i2] = ((buf[i2*4]&0xFF)<<24)|((buf[i2*4+1]&0xFF)<<16)|
                          ((buf[i2*4+2]&0xFF)<<8)|(buf[i2*4+3]&0xFF);
            }
        }
    }

    /* Load game data */
    MldSet();
    TipSet();
    WazaSet();
    SkillSet();
    MailSet();
    ImgSet();

    /* Load save data */
    unsigned char save_buf[SAVE_DATA * 4 + 4];
    int save_pos = 300;  /* Save data starts at offset 300 in scratchpad */
    if (spLoad(save_buf, save_pos, SAVE_DATA * 4) > 0) {
        int off = 0;
        max_hp      = ((save_buf[off]&0xFF)<<8)|(save_buf[off+1]&0xFF); off += 2;
        now_hp      = ((save_buf[off]&0xFF)<<8)|(save_buf[off+1]&0xFF); off += 2;
        zenny       = ((save_buf[off]&0xFF)<<8)|(save_buf[off+1]&0xFF); off += 2;
        ata_lv      = save_buf[off++] & 0xFF;
        cha_lv      = save_buf[off++] & 0xFF;
    }
    /* Defaults if corrupt */
    if (max_hp <= 0) max_hp = 100;
    if (now_hp <= 0) now_hp = max_hp;
    if (zenny  < 0)  zenny  = 0;

    map_no = 0;
    map_x = 0;
    map_y = 0;
    mode = 0;
    mode2 = 0;
    fol_suu = 1;
    now_fol = 0;
    FolSet();
    imgAddSet();   /* load all JAR images into image_add[] */

    scene = 0;
}

/* =========================================================
 * ImgSet - load images from scratchpad blocks
 * ========================================================= */
void CpCanvas::ImgSet()
{
    /* Load sprites using JarGet. Blocks 0-15 may be empty in our SP file.
       Try to load what we can from blocks 16+ and JAR resources. */

    /* Try to load sprite sheet data from block 0 (if available) */
    InputStream *is0 = JarGet(0);
    if (is0 && is0->len > 0) {
        unsigned char by4[4];
        /* Read sprite metadata for IMG_SUU1 * 6 entries */
        for (int i2 = 0; i2 < IMG_SUU1 && !is0->eof(); i2++) {
            if (!gx[i2]) { gx[i2] = new int[64]; gy[i2] = new int[64];
                           sx[i2] = new int[64]; sy[i2] = new int[64];
                           dx[i2] = new int[64]; dy[i2] = new int[64]; }
            for (int k = 0; k < 6 && !is0->eof(); k++) {
                is0->read(by4, 4);
                gx[i2][k] = ((by4[0]&0xFF)<<8)|(by4[1]&0xFF);
                gy[i2][k] = ((by4[2]&0xFF)<<8)|(by4[3]&0xFF);
            }
        }
    }
    delete is0;

    /* Load indexed images from JAR into image[] for direct sprite use */
    for (int i2 = 0; i2 < 10; i2++) {
        char path[64];
        snprintf(path, sizeof(path), "data/new/img/%d.gif", i2);
        InputStream *is = Platform_JAR_OpenResource(path);
        if (is && is->len > 6) {
            PlatImage *img = Platform_DecodeGIF(is->buf, is->len);
            if (img) image[i2] = img;
        }
        delete is;
    }

    /* Initialize palette slots */
    for (int i2 = 0; i2 < IMG_SUU; i2++) {
        if (!pal[i2]) pal[i2] = new PlatPalette();
    }
}

void CpCanvas::ImgSet2(int n)
{
    /* Load additional images */
    (void)n;
}

/* =========================================================
 * imgAddSet - load all JAR images into image_add[] (indices 0-9)
 * Mirrors the original Java: loads data/new/img/{n}.gif from the JAR
 * ========================================================= */
void CpCanvas::imgAddSet()
{
    for (int i2 = 0; i2 < 10; i2++) {
        if (image_add[i2]) continue;   /* already loaded */
        char path[64];
        snprintf(path, sizeof(path), "data/new/img/%d.gif", i2);
        InputStream *is = Platform_JAR_OpenResource(path);
        if (is && is->len > 6) {
            PlatImage *img = Platform_DecodeGIF(is->buf, is->len);
            if (img) image_add[i2] = img;
        }
        delete is;
    }
}

/* =========================================================
 * imgAddDraw - draw image_add[n] at screen position (x, y)
 * Mirrors the original Java: g.drawImage(image_add[n], x, y)
 * ========================================================= */
void CpCanvas::imgAddDraw(int n, int x, int y)
{
    if (n < 0 || n >= 10) return;
    PlatImage *img = image_add[n];
    if (!img) return;
    Platform_DrawImage(img, x, y, 0, 0, img->width, img->height);
}

/* =========================================================
 * MldSet - load music
 * ========================================================= */
void CpCanvas::MldSet()
{
    /* Load MLD/audio data - stubs for now */
    for (int i2 = 0; i2 < BGM_MAX; i2++) {
        m_audio[i2] = Platform_GetAudioPresenter(0);  /* BGM type */
    }
    for (int i2 = 0; i2 < SE_MAX; i2++) {
        m_audio_se[i2] = Platform_GetAudioPresenter(1);  /* SE type */
    }
}

void CpCanvas::mldAddSet()
{
    /* Additional MLD setup */
}

int CpCanvas::mldAddDL()
{
    return 0;
}

/* =========================================================
 * PASet - palette animation setup
 * ========================================================= */
void CpCanvas::PASet()
{
}

/* =========================================================
 * TipSet - load battle chips
 * ========================================================= */
void CpCanvas::TipSet()
{
    InputStream *is_data = JarGet(22);   /* Tip data block */
    InputStream *is_name = JarGet(23);   /* Tip name block */
    if (!is_data || is_data->len <= 0) {
        delete is_data; delete is_name;
        /* Initialize with defaults */
        for (int i2 = 0; i2 < TIP_SUU; i2++) tip_obj[i2].tip_id = i2;
        return;
    }
    for (int i2 = 0; i2 < TIP_SUU; i2++) {
        tip_obj[i2].init(i2, is_data, is_name);
        if (!tip_list) break;
        tip_list[i2] = (i2 < 10) ? ((1 << 16) | (i2 << 8) | 0x10) : 0;
    }
    delete is_data;
    delete is_name;

    m_max = 0;
    g_max = 0;
    TIP_MAX[0] = 4;
    TIP_MAX[1] = 4;
    TIP_MAX[2] = 1;
    TIP_MAX[3] = 1;
    TIP_MAX[4] = 1;
    regu_you = 30;
}

/* =========================================================
 * WazaSet - load waza (move) data
 * ========================================================= */
void CpCanvas::WazaSet()
{
    InputStream *is = JarGet(24);
    if (!is || is->len <= 0) {
        delete is;
        /* Allocate stubs */
        for (int i2 = 0; i2 < WAZA_MAX; i2++) {
            InputStream dummy(nullptr, 0);
            waza[i2] = new Waza(i2, &dummy);
        }
        return;
    }
    /* Initialize move data arrays */
    InputStream *is25 = JarGet(25);
    for (int i2 = 0; i2 < WAZA_MAX; i2++) {
        waza[i2] = new Waza(i2, is);
    }
    if (is25) waza[0]->Set(is25);
    delete is; delete is25;

    wait_data = new int[500]; memset(wait_data, 0, 500 * sizeof(int));
    /* load wait_data from block 26 */
    InputStream *is26 = JarGet(26);
    if (is26 && is26->len > 0) {
        unsigned char b4[4];
        for (int i2 = 0; i2 < 100 && !is26->eof(); i2++) {
            for (int k = 0; k < 5 && !is26->eof(); k++) {
                is26->read(b4, 4);
                wait_data[i2*5+k] = ((b4[0]&0xFF)<<24)|((b4[1]&0xFF)<<16)|((b4[2]&0xFF)<<8)|(b4[3]&0xFF);
            }
        }
    }
    delete is26;

    /* load rock_mo from block 27 */
    InputStream *is27 = JarGet(27);
    if (is27 && is27->len > 0) {
        unsigned char b4[4];
        for (int i2 = 0; i2 < ROCK_MO * 6 && !is27->eof(); i2++) {
            is27->read(b4, 4);
            rock_mo[i2] = ((b4[0]&0xFF)<<24)|((b4[1]&0xFF)<<16)|((b4[2]&0xFF)<<8)|(b4[3]&0xFF);
        }
    }
    delete is27;
}

/* =========================================================
 * SkillSet - load skill data
 * ========================================================= */
void CpCanvas::SkillSet()
{
    InputStream *is_data = JarGet(28);
    InputStream *is_name = JarGet(29);
    skill_suu = SKILL_SUU;
    for (int i2 = 0; i2 < SKILL_SUU; i2++) {
        skill[i2] = new Skill(i2, is_data, is_name);
        skill_list[i2] = i2;  /* Default: all available */
    }
    delete is_data; delete is_name;

    memset(skill_kouka, 0, sizeof(skill_kouka));
}

/* =========================================================
 * MailSet - load mail data
 * ========================================================= */
void CpCanvas::MailSet()
{
    InputStream *is_data = JarGet(30);
    InputStream *is_name = JarGet(31);
    mail_suu = 30;
    for (int i2 = 0; i2 < mail_suu; i2++) {
        mail[i2] = new Mail(i2, is_data, is_name);
    }
    delete is_data; delete is_name;
}

/* =========================================================
 * FolSet - initialize folders
 * ========================================================= */
void CpCanvas::FolSet()
{
    for (int i2 = 0; i2 < 6; i2++) {
        for (int j2 = 0; j2 < 30; j2++) fol[i2].tip_id[j2] = 0;
        fol[i2].regu_id = 0;
        fol[i2].regu_flg = 0;
    }
}

/* =========================================================
 * ScenarioSet / QuestSet
 * ========================================================= */
void CpCanvas::ScenarioSet(int n)
{
    (void)n;
}

void CpCanvas::QuestSet(int n)
{
    (void)n;
}

/* =========================================================
 * BtPanelSet - initialize battle panels
 * ========================================================= */
void CpCanvas::BtPanelSet()
{
    for (int i2 = 0; i2 < 3; i2++) {
        for (int j2 = 0; j2 < 6; j2++) {
            panel[i2][j2].init(j2, i2, 1);
        }
    }
}

/* =========================================================
 * numStr - format number as string
 * ========================================================= */
std::string CpCanvas::numStr(int n)
{
    return std::to_string(n);
}

std::string CpCanvas::numStr2(int n, int digits)
{
    std::string s = std::to_string(n);
    while ((int)s.size() < digits) s = "0" + s;
    return s;
}

/* =========================================================
 * RandSet - initialize random data for battle
 * ========================================================= */
void CpCanvas::RandSet()
{
    fol[now_fol].RandSet(max_sel);
}

/* =========================================================
 * Wait
 * ========================================================= */
void CpCanvas::Wait(int n)
{
    if (n <= 0) return;
    Platform_Present();
    Platform_Sleep(n);
}

/* =========================================================
 * ShSort / ShSet - shop management
 * ========================================================= */
void CpCanvas::ShSort()
{
    if (!sh_id || !sh_kin || !sh_syu) return;
    /* Sort shop items */
}

void CpCanvas::ShSet(int n)
{
    InputStream *is = JarGet(34);
    if (!is || is->len <= 0) { delete is; shop_syu = 2; return; }
    shop_syu = 2;
    /* Fill sh_zai and sh_syu/sh_id/sh_kin arrays */
    delete is;
}

/* =========================================================
 * QGard - quest guard/save
 * ========================================================= */
void CpCanvas::QGard(int n)
{
    (void)n;
}

/* =========================================================
 * verLaod / verSave - version management
 * ========================================================= */
std::string CpCanvas::verLaod(int n)
{
    (void)n;
    return Ver;
}

void CpCanvas::verSave(const std::string &v, int n)
{
    (void)v; (void)n;
}

/* =========================================================
 * GetScenario - load scenario data
 * ========================================================= */
void CpCanvas::GetScenario(int n)
{
    (void)n;
}

/* =========================================================
 * BtSet - battle setup
 * ========================================================= */
void CpCanvas::BtSet(int n)
{
    (void)n;
    BtPanelSet();
    ene_cnt = 0;
    over_cnt = 0;
    over_flg = 0;
    cus_gage = 0;
    cus_sp = 0;
    combo = 0;
    combo_cnt = 0;
    ata_cnt = 0;
    stop_time = 0;
    stop_cnt = 0;
    dell_cnt = 0;
    bas_flg = 0;
    win_flg = 0;
    rock->init();
}

/* =========================================================
 * NetData - data download (stubbed for PC port)
 * ========================================================= */
void CpCanvas::NetData()
{
    http_error = 0;
    /* For PC port, data is read from PoN.sp directly */
    /* Nothing to download */
}

/* =========================================================
 * Scene stubs - to be filled in
 * ========================================================= */
void CpCanvas::Title()
{
    /* Black background */
    Platform_SetColor(Platform_MakeColor(0, 0, 0));
    Platform_FillRect(0, 0, GAMEN_X, GAMEN_Y);

    /* Title screen image (image_add[2] = data/new/img/2.gif, 240x168) */
    if (image_add[2]) {
        imgAddDraw(2, 0, 0);
        if (image_add[3])
            imgAddDraw(3, 178, 123);
    } else {
        /* Fallback: draw title text */
        Platform_SetColor(Platform_MakeColor(0, 100, 200));
        Platform_FillRect(0, 0, GAMEN_X, 90);
        Platform_SetColor(Platform_MakeColor(255, 255, 255));
        strDraw("PHANTOM", 40, 20);
        strDraw("OF NETWORK", 25, 45);
        Platform_SetColor(Platform_MakeColor(200, 200, 0));
        strDraw("CAPCOM 2009", 60, 70);
    }

    /* Bottom area: black strip for menu */
    Platform_SetColor(Platform_MakeColor(0, 0, 0));
    Platform_FillRect(0, 168, GAMEN_X, GAMEN_Y - 168);

    /* Menu cursor */
    Platform_SetColor(Platform_MakeColor(255, 255, 255));
    strDraw(">", 15, 180 + mode * 20);

    /* Menu items */
    strDraw("GAME START", 30, 180);
    strDraw("RETURN TO TITLE", 30, 200);

    /* Navigate menu */
    if ((key & KEY_UP) && !(okey & KEY_UP)) {
        mode = (mode > 0) ? mode - 1 : 1;
        key &= ~KEY_UP;
    }
    if ((key & KEY_DOWN) && !(okey & KEY_DOWN)) {
        mode = (mode < 1) ? mode + 1 : 0;
        key &= ~KEY_DOWN;
    }

    if (key & KEY_FIRE) {
        if (mode == 0) {
            /* Start new game: go to field map */
            map_no = 0; map_x = 0; map_y = 0;
            Audio(1, map_bgm);
            scene = 3;   /* FieldMain */
            mode = 0;
        } else {
            /* Return to splash screen */
            scene = -2;
            game_cnt = 0;
            mode = 0;
        }
        key = 0;
    }
}

void CpCanvas::Title2()
{
    /* CAPCOM / Phantom of Network splash screen (scene = -2) */

    /* Black background */
    Platform_SetColor(Platform_MakeColor(0, 0, 0));
    Platform_FillRect(0, 0, GAMEN_X, GAMEN_Y);

    /* Title screen image (image_add[2] = data/new/img/2.gif, 240x168) */
    if (image_add[2]) {
        imgAddDraw(2, 0, 0);
        if (image_add[3])
            imgAddDraw(3, 178, 123);
    } else {
        /* Fallback: stylised text title */
        Platform_SetColor(Platform_MakeColor(0, 100, 200));
        Platform_FillRect(0, 0, GAMEN_X, 90);
        Platform_SetColor(Platform_MakeColor(255, 255, 255));
        strDraw("PHANTOM", 40, 20);
        strDraw("OF NETWORK", 25, 45);
        Platform_SetColor(Platform_MakeColor(200, 200, 0));
        strDraw("CAPCOM 2009", 60, 70);
    }

    /* Bottom strip */
    Platform_SetColor(Platform_MakeColor(0, 0, 0));
    Platform_FillRect(0, 168, GAMEN_X, GAMEN_Y - 168);

    /* Blinking "Press ENTER" prompt (10-frame period) */
    if ((game_cnt / 10) % 2 == 0) {
        Platform_SetColor(Platform_MakeColor(255, 255, 255));
        strDraw("Press ENTER to start", 20, 195);
    }

    /* Copyright line */
    Platform_SetColor(Platform_MakeColor(150, 150, 150));
    strDraw("(C) CAPCOM 2009", 45, 218);

    /* Advance to Title menu on any key press */
    if (key & KEY_FIRE) {
        scene = 0;
        mode = 0;
        key = 0;
    }
}

void CpCanvas::Test()
{
    scene = 0;
}

void CpCanvas::BattleMain()
{
    /* Main battle scene */
    Platform_SetColor(Platform_MakeColor(20, 20, 80));
    Platform_FillRect(0, 0, GAMEN_X, BT_OFF_Y);
    Platform_SetColor(Platform_MakeColor(60, 60, 140));
    Platform_FillRect(0, BT_OFF_Y, GAMEN_X, BT_SIZE_Y * 3);
    Platform_SetColor(Platform_MakeColor(0, 0, 30));
    Platform_FillRect(0, BT_OFF_Y + BT_SIZE_Y * 3, GAMEN_X, GAMEN_Y - BT_OFF_Y - BT_SIZE_Y * 3);

    /* Draw battle grid */
    for (int py = 0; py < 3; py++) {
        for (int px = 0; px < 6; px++) {
            int sx2 = BT_OFF_X + px * BT_SIZE_X;
            int sy2 = BT_OFF_Y + py * BT_SIZE_Y;
            int col = (px < 3) ? 0x4040C0 : 0xC04040;
            Platform_SetColor(col);
            Platform_DrawRect(sx2, sy2, BT_SIZE_X, BT_SIZE_Y);
        }
    }

    /* Handle input */
    if (key & KEY_FIRE) {
        /* select / use chip */
    }

    /* Rock move */
    if (rock) rock->Draw(1);

    /* Update all attacks */
    for (int i2 = 0; i2 < ATA_MAX; i2++) {
        if (ata[i2].on) {
            ata[i2].Move();
            ata[i2].Draw();
        }
    }

    /* Check game over / win */
    if (over_cnt > 0) {
        scene = 3;  /* Return to field */
    }

    ++game_cnt;
}

void CpCanvas::BattleTip()
{
    /* Chip select scene */
    Platform_SetColor(Platform_MakeColor(0, 0, 0));
    Platform_FillRect(0, 0, GAMEN_X, GAMEN_Y);
    Platform_SetColor(Platform_MakeColor(255, 255, 255));
    strDraw("Select Chip", 80, 20);

    /* Draw available chips */
    for (int i2 = 0; i2 < max_sel && i2 < 5; i2++) {
        int cx = 30 + i2 * 42;
        Platform_SetColor(cas_ok[i2] ? Platform_MakeColor(100, 200, 100) : Platform_MakeColor(100, 100, 100));
        Platform_FillRect(cx, 50, 36, 36);
        if (cas_tip[i2] >= 0 && cas_tip[i2] < TIP_SUU) {
            Platform_SetColor(Platform_MakeColor(255, 255, 255));
            strDraw(std::to_string(cas_tip[i2]), cx + 2, 70);
        }
    }

    if (key & KEY_FIRE) {
        scene = 1;
        key = 0;
    }
}

void CpCanvas::FieldMain()
{
    /* Field map scene */
    Platform_SetColor(Platform_MakeColor(0, 60, 0));
    Platform_FillRect(0, 0, GAMEN_X, GAMEN_Y);
    Platform_SetColor(Platform_MakeColor(255, 255, 255));
    strDraw("Field", 100, 10);

    /* Draw map */
    for (int my = 0; my < 5; my++) {
        for (int mx2 = 0; mx2 < 5; mx2++) {
            Platform_SetColor(Platform_MakeColor(0, 80 + mx2*10, 0));
            Platform_FillRect(mx2*40 + 20, my*30 + 40, 36, 26);
        }
    }

    /* Player indicator */
    Platform_SetColor(Platform_MakeColor(255, 255, 0));
    Platform_FillRect(map_x * 40 + 22, map_y * 30 + 42, 10, 10);

    /* Input */
    if (key & KEY_UP    && map_y > 0) { map_y--; key &= ~KEY_UP;    Platform_Sleep(100); }
    if (key & KEY_DOWN  && map_y < 4) { map_y++; key &= ~KEY_DOWN;  Platform_Sleep(100); }
    if (key & KEY_LEFT  && map_x > 0) { map_x--; key &= ~KEY_LEFT;  Platform_Sleep(100); }
    if (key & KEY_RIGHT && map_x < 4) { map_x++; key &= ~KEY_RIGHT; Platform_Sleep(100); }

    if (key & KEY_FIRE) {
        /* Start battle */
        BtSet(0);
        RandSet();
        scene = 2;  /* BattleTip */
        key = 0;
    }

    /* Menu */
    if (key & KEY_SOFTL) {
        scene = 4;
        key = 0;
    }
}

void CpCanvas::Menu()
{
    Platform_SetColor(Platform_MakeColor(0, 0, 80));
    Platform_FillRect(0, 0, GAMEN_X, GAMEN_Y);
    Platform_SetColor(Platform_MakeColor(255, 255, 255));
    strDraw("MENU", 100, 20);
    strDraw("HP: " + numStr(now_hp) + "/" + numStr(max_hp), 10, 50);
    strDraw("Zenny: " + numStr(zenny), 10, 70);
    strDraw("Map: " + numStr(map_no), 10, 90);

    if (key & KEY_SOFTR) {
        scene = 3;  /* Back to field */
        key = 0;
    }
}

void CpCanvas::Machi()
{
    Platform_SetColor(Platform_MakeColor(100, 80, 60));
    Platform_FillRect(0, 0, GAMEN_X, GAMEN_Y);
    Platform_SetColor(Platform_MakeColor(255, 255, 255));
    strDraw("Town", 100, 10);
    if (key & KEY_SOFTR) { scene = 3; key = 0; }
}

void CpCanvas::Keiji()
{
    Platform_SetColor(Platform_MakeColor(50, 50, 100));
    Platform_FillRect(0, 0, GAMEN_X, GAMEN_Y);
    Platform_SetColor(Platform_MakeColor(255, 255, 255));
    strDraw("Notice Board", 60, 10);
    if (key & KEY_SOFTR) { scene = 3; key = 0; }
}

void CpCanvas::Shop()
{
    Platform_SetColor(Platform_MakeColor(100, 80, 40));
    Platform_FillRect(0, 0, GAMEN_X, GAMEN_Y);
    Platform_SetColor(Platform_MakeColor(255, 255, 255));
    strDraw("Shop", 100, 10);
    strDraw("Zenny: " + numStr(zenny), 10, 40);
    if (key & KEY_SOFTR) { scene = 3; key = 0; }
}

void CpCanvas::Trader()
{
    Platform_SetColor(Platform_MakeColor(80, 60, 40));
    Platform_FillRect(0, 0, GAMEN_X, GAMEN_Y);
    Platform_SetColor(Platform_MakeColor(255, 255, 255));
    strDraw("Trader", 90, 10);
    if (key & KEY_SOFTR) { scene = 3; key = 0; }
}

void CpCanvas::Ranking()
{
    Platform_SetColor(Platform_MakeColor(0, 0, 0));
    Platform_FillRect(0, 0, GAMEN_X, GAMEN_Y);
    Platform_SetColor(Platform_MakeColor(255, 255, 0));
    strDraw("Ranking", 90, 10);
    strDraw("Score: " + numStr(score), 10, 50);
    if (key & KEY_SOFTR) { scene = 3; key = 0; }
}

void CpCanvas::ZokuMain()
{
    Platform_SetColor(Platform_MakeColor(0, 0, 0));
    Platform_FillRect(0, 0, GAMEN_X, GAMEN_Y);
    Platform_SetColor(Platform_MakeColor(255, 255, 255));
    strDraw("Zoku Mode", 80, 10);
    if (key & KEY_SOFTR) { scene = 0; key = 0; }
}

/* =========================================================
 * exe() - main game loop
 * ========================================================= */
void CpCanvas::exe()
{
    int fps_target = 15;   /* ~15 FPS like original game */
    long long frame_ms = 1000 / (fps_target + 1);

    /* Initialize off-screen drawing */
    Platform_SetTarget(nullptr);
    Platform_SetColor(Platform_MakeColor(0, 0, 0));
    Platform_FillRect(0, 0, GAMEN_X, GAMEN_Y);

    SetUp();
    Audio(1, 0);
    scene = -2;
    key = 0;
    game_cnt = 0;
    mill = Platform_CurrentTimeMillis();

    while (Platform_PumpMessages()) {
        long long now = Platform_CurrentTimeMillis();
        if (now - mill < frame_ms) {
            Platform_Sleep(1);
            continue;
        }
        mill = now;

        /* Get input */
        okey = key;
        key = Platform_GetKey();

        /* Fill background */
        Platform_SetTarget(nullptr);
        Platform_SetColor(Platform_MakeColor(0, 0, 0));
        Platform_FillRect(0, 0, GAMEN_X, GAMEN_Y);

        /* Dispatch scene */
        if      (scene == -2) Title2();
        else if (scene == -1) Test();
        else if (scene ==  0) Title();
        else if (scene ==  1) BattleMain();
        else if (scene ==  2) BattleTip();
        else if (scene ==  3) FieldMain();
        else if (scene ==  4) Menu();
        else if (scene ==  5) Machi();
        else if (scene ==  6) Keiji();
        else if (scene ==  7) Shop();
        else if (scene ==  8) Trader();
        else if (scene ==  9) Ranking();
        else if (scene == 10) ZokuMain();

        /* Audio: re-start BGM if app was paused */
        if (play_flg) {
            for (int i2 = 0; i2 < BGM_MAX; i2++) {
                if (m_audio[i2]) Platform_AudioStop(m_audio[i2]);
            }
            Audio(1, now_bgm);
            play_flg = 0;
        }

        sePlay();
        ++game_cnt;

        /* Present frame */
        Platform_Present();
    }
}
