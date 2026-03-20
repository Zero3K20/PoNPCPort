/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.nttdocomo.io.HttpConnection
 *  com.nttdocomo.ui.AudioPresenter
 *  com.nttdocomo.ui.Canvas
 *  com.nttdocomo.ui.Dialog
 *  com.nttdocomo.ui.Font
 *  com.nttdocomo.ui.Graphics
 *  com.nttdocomo.ui.IApplication
 *  com.nttdocomo.ui.Image
 *  com.nttdocomo.ui.MediaImage
 *  com.nttdocomo.ui.MediaManager
 *  com.nttdocomo.ui.MediaSound
 *  com.nttdocomo.ui.Palette
 *  com.nttdocomo.ui.PalettedImage
 *  com.nttdocomo.ui.PhoneSystem
 *  com.nttdocomo.ui.UIException
 *  com.nttdocomo.util.JarInflater
 *  javax.microedition.io.Connector
 */
package app;

import app.Attack;
import app.BtPanel;
import app.CpDataDownload;
import app.Edit;
import app.Ene;
import app.Folder;
import app.Mail;
import app.Okimono;
import app.Rock;
import app.Skill;
import app.Tip;
import app.Waza;
import com.nttdocomo.io.HttpConnection;
import com.nttdocomo.ui.AudioPresenter;
import com.nttdocomo.ui.Canvas;
import com.nttdocomo.ui.Dialog;
import com.nttdocomo.ui.Font;
import com.nttdocomo.ui.Graphics;
import com.nttdocomo.ui.IApplication;
import com.nttdocomo.ui.Image;
import com.nttdocomo.ui.MediaImage;
import com.nttdocomo.ui.MediaManager;
import com.nttdocomo.ui.MediaSound;
import com.nttdocomo.ui.Palette;
import com.nttdocomo.ui.PalettedImage;
import com.nttdocomo.ui.PhoneSystem;
import com.nttdocomo.ui.UIException;
import com.nttdocomo.util.JarInflater;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.microedition.io.Connector;

class CpCanvas
extends Canvas {
    public static int deba_flg = 0;
    static String dev = "/i/";
    public static final int DATA_SUU = 37;
    public static final int IMG_SUU1 = 42;
    public static final int IMG_SUU2 = 16;
    public static final int IMG_SUU3 = 22;
    public static final int IMG_SUU = 59;
    public static final int SOUND_SUU = 16;
    public static final int BGM_SUU = 11;
    public static final int GAMEN_X = 240;
    public static final int GAMEN_Y = 240;
    public static final int BT_OFF_X = 0;
    public static final int BT_OFF_Y = 105;
    public static final int BT_SIZE_X = 40;
    public static final int BT_SIZE_Y = 24;
    public static final int ATA_MAX = 30;
    public static final int ROCK_WAZA = 188;
    public static final int TEKI_WAZA = 77;
    public static final int WAZA_MAX = 265;
    public static final int SKILL_SUU = 29;
    public static final int TIP_SUU = 213;
    public static final int STAN_TIP = 123;
    public static final int MEGA_TIP = 52;
    public static final int GIGA_TIP = 4;
    public static final int PA_TIP = 28;
    public static final int SAVE_DATA = 437;
    public static final int ROCK_MO = 22;
    public static final int EFF_MO = 148;
    public static final int TEKI_MO = 22;
    public static final int AD_TOP = 3396;
    static Random rand = new Random();
    static Rock rock;
    static Ene[] ene;
    static Okimono[] oki;
    static BtPanel[][] panel;
    static Folder[] fol;
    static Tip[] tip;
    static Attack[] ata;
    static Waza[] waza;
    static Mail[] mail;
    static Skill[] skill;
    static Edit edit;
    public static Graphics g;
    public static Image imgMap;
    public static Image tmp_imgMap;
    public static Graphics graMap;
    public static Graphics tmp_graMap;
    public static Image[] imgMap2;
    public static Graphics[] graMap2;
    static Font f;
    private static int audio_flg;
    private static int i;
    private static int j;
    private static int x;
    private static int y;
    private int gapX = (this.getWidth() - 240) / 2;
    private int gapY = (this.getHeight() - 240) / 2;
    public static int game_cnt;
    private static int scene;
    public int[] pix = new int[38400];
    public static PalettedImage[] image;
    public static Image dmy_image;
    public static Palette[] pal;
    public static AudioPresenter[] audio;
    public static int se_check;
    public static int play_flg;
    public static long mill;
    public static long fade;
    public static int kai;
    public static int key;
    public static int okey;
    public static int key_cnt;
    public static int[] tip_list;
    public static int[] skill_list;
    public static int[] dat;
    public static int score;
    public static int user_id;
    public static int sina_no;
    public static int sina_flg;
    public static int[][] item_flg;
    public static int[][] tobi_flg;
    public static int[][] chara_flg;
    public static int[][] pa_data;
    public static int mode;
    public static int mode2;
    public static int option_flg;
    public static int o_mode;
    public static int o_cnt;
    public static int teki_pt;
    public static int[][] teki_ren;
    public static int ren_id;
    public static int ren_flg;
    public static int cus_gage;
    public static int cus_sp;
    public static int fade_cnt;
    public static int stop_time;
    public static int stop_cnt;
    public static int eff_id;
    public static String stop_name;
    public static int win_flg;
    public static int boss_flg;
    public static int ene_cnt;
    public static int dell_cnt;
    public static int bas_flg;
    public static int bas_lv;
    public static int bas_cnt;
    public static int[] bt_get;
    public static long audio_mill;
    public static int over_cnt;
    public static int over_flg;
    public static int wana_flg;
    public static int[] wana_pow;
    public static int combo;
    public static int combo_cnt;
    public static int combo_time;
    public static int stop_ch;
    public static int dell_lv;
    public static int[] cas_tip;
    public static int[] fol_tip_no;
    public static int[] set_tip;
    public static int sel_cas_mode;
    public static int sel_cas_tip;
    public static int max_sel;
    public static int sel_cnt;
    public static int now_code;
    public static int[] sel_code;
    public static int[] cas_ok;
    public static int cas_cnt;
    public static int regu_flg;
    public static int esc_flg;
    public static int[] fol_d;
    public static int pa_no;
    public static int pa_start;
    public static int pa_cnt;
    public static int pa_cnt2;
    public static int[] pa_tip;
    public static int pa_code_flg;
    public static int ata_cnt;
    public static int[][] gx;
    public static int[][] gy;
    public static int[][] sx;
    public static int[][] sy;
    public static int[][] dx;
    public static int[][] dy;
    public static int[][][] ani;
    public static int[][][] a_dx;
    public static int[][][] a_dy;
    public static String str;
    static int[] p_siz;
    public static int drop_ene;
    public static int eria_cnt;
    public static int sec_cha;
    public static int zan;
    public static int map_no;
    public static int map_x;
    public static int map_y;
    public static int map_sp;
    public static int key2;
    public static int encount;
    public static int move_cnt;
    public static int move_flg;
    public static int muki;
    public static int warp_flg;
    public static int warp_cnt;
    public static int eff_cnt;
    public static int mes_no;
    public static int mes_flg;
    public static int mes_data;
    public static int machi_damy_flg;
    public static int hit_flg;
    public static int en_flg;
    public static int[] wait_data;
    public static int[] rock_mo;
    public static int[] eff_mo;
    public static int[] eff_se;
    public static int[] teki_mo;
    public static int[] soft_id;
    public static int R;
    public static int G;
    public static int B;
    public static int tmp_hp;
    public static String[] map_str;
    public static String[] t_str;
    public static String[] o_str;
    public static String[] m_name;
    public static String[] p_name;
    public static String q_str2;
    public static String[] menu_str;
    public static String[] soft_str;
    public static String[] waza_str;
    public static String[] r_str;
    public String[] set_str = new String[]{"PET Operating System", "ROCKMAN.EXE starting now...", "\u4f1a\u54e1\u8a8d\u8a3c\uff1a", "Connecting...", "Done.", "\u521d\u56de\u30c7\u30fc\u30bf\u30c0\u30a6\u30f3\u30ed\u30fc\u30c9\uff1a", "\u30c7\u30fc\u30bf\u5c55\u958b\u4e2d...", "rockman.dat:", "chip.dat   :", "navi.dat   :", "folder.dat :", "ERROR!", "\u4f1a\u54e1\u767b\u9332\u3055\u308c\u3066\u3044\u307e\u305b\u3093\u3002", "\u8d77\u52d5\u306b\u306f\u4f1a\u54e1\u767b\u9332\u304c\u5fc5\u8981\u3067\u3059\u3002", "Press any key.", "\u30cd\u30c3\u30c8\u30ef\u30fc\u30af\u63a5\u7d9a\u306b\u5931\u6557\u3057\u307e\u3057\u305f\u3002", "\u518d\u63a5\u7d9a\u3057\u307e\u3059\u304b\uff1f", "                   YES        NO", ">>", "Don't press power key.", "\u7d42\u4e86\u3057\u307e\u3059\u3002"};
    public static int[][] e_data;
    public static String[] e_name;
    public static int tmp_R;
    public static int tmp_G;
    public static int tmp_B;
    public static int non_esc;
    public static int ok_code;
    public static int ok_tip;
    public static int[] m_data;
    public static int[] m_ene;
    public static int[] m_warp;
    public static int[][] m_item;
    public static int[][] m_tobi;
    public static int[][] m_chara;
    public static int[] p_pat;
    public static int[] p_col;
    public static int[][] ene_set;
    public static int tip_pt;
    public static int key_get;
    public static byte[][] mes;
    public static int tmp_m_no;
    public static int tmp_m_flg;
    public static int mes_id;
    public static int mes_cnt;
    public static int machi_no;
    public static int[][] talk_flg;
    public static int talk_cnt;
    public static int quest_flg;
    public static int[] move_ok;
    public static int[] plg_ok;
    public static int machi_flg;
    public static int machi_sel;
    public static int machi_cnt;
    public static int machi_move;
    public static int rank_flg;
    public static int pla_ok;
    public static int[] m_move;
    public static int[][] m_ivent;
    public static int[] m_plg;
    public static int[][] i_chara;
    public static int[] r_ivent;
    public static int q_sel;
    public static int q_jou;
    public static int q_get;
    public static int q_cnt;
    public static int[] q_flg;
    public static int[] q_list;
    public static int site_point;
    public static int tmp_point;
    public static int mes_draw;
    public static int shop_syu;
    public static int shop_id;
    public static int zai_cnt;
    public static int[] sh_syu;
    public static int[] sh_id;
    public static int[] sh_kin;
    public static int[] sh_list;
    public static int[][] sh_zai;
    public static int[] set_t;
    public static int in_cnt;
    public static int get_tr;
    public static int tr_max;
    public static int[] tr_list;
    public static int rank_menu;
    public static int rank_cnt;
    public static int rank_no;
    public static int rank_mes;
    public static int rank_fol;
    public static int face;
    public static String[] r_jun;
    public static int[] r_sco;
    public static String[] r_name;
    public static int[] r_id;
    public static int[] sco_cnt;
    public static int[] sco;
    public static int[] r_tip;
    public static int[][] r_map;
    public static int[][] r_ene;
    public static int ivent_end;
    public static int ivent_flg;
    public static int ivent_id;
    public static int ivent_set;
    public static int ivent_cnt;
    public static int[] i_id;
    public static int[] talk_ch;
    public static int kouka_flg;
    public static int kouka_cnt;
    public static int yure;
    public static int mail_flg;
    public static int mail_cnt;
    public static int skill_flg;
    public static int yes_no_flg;
    public static int jump_ivent;
    public static int[] navi_flg;
    public static int come_back;
    public static int[] i_set;
    public static int[] i_x;
    public static int[] i_y;
    public static int s_hen;
    public static int q_hen;
    public static int now_bgm;
    public static int[] i_data;
    public static int[] i_cnt;
    public static int[][] i_siz;
    public static int ivent_syu;
    public static int talk_cnt2;
    public static int[][] face_x;
    public static int[] face_dx;
    public static int menu_no;
    public static int back_menu;
    public static int menu_sel;
    public static int menu_cnt;
    public static int menu_flg;
    public static int sel_tip;
    public static int sel_tip2;
    public static int sel_jou;
    public static int sel_jou2;
    public static int tmp_tip;
    public static int sort;
    public static int fol_cnt;
    public static int[] TIP_MAX;
    public static int ata_lv;
    public static int cha_lv;
    public static int max_hp;
    public static int now_hp;
    public static int zenny;
    public static int piece;
    public static int full_ene;
    public static int now_fol;
    public static int fol_suu;
    public static int regu_you;
    public static int get_tip;
    public static int[] get_tip2;
    public static int[] get_list;
    public static int[] sort_list;
    public static int[] sort_skill;
    public static int mail_suu;
    public static int mail_open;
    public static int skill_suu;
    public static byte[] q_data;
    public static String[] q_str;
    public static int quest_no;
    public static int http_error;
    public static int[] s_pos;
    public static String url;
    public static int[] skill_kouka;
    public static int sort_flg;
    public static int m_max;
    public static int g_max;
    public static int d_ene_syu;
    public static int d_ene_lv;
    public static int rock_mu;
    public static int teki_mu;
    public static int teki_mark;
    public static int list_suu;
    public static int[] fol_data;
    public static int[] list_data;
    public static int que_su;
    public int bgm_no;
    public int se_no;
    public static int p_no;
    public static int p_no2;
    public static int hyo;
    public static int ch_no;
    public static int g_no;
    public static int awa;
    public static int plt;
    public static int ani_pt;
    public static int ani_cnt;
    public static int flp;
    public int deba_tip_id;
    public int cus_se_flg;
    static int[] img_siz3;
    public static int rika_cnt;
    public static int ghost;
    public static int map_bgm;
    public static String[] q_txt;
    public int rank_mes_id;
    public static Image[] image_add;
    public int m_syokai_flg = 1;
    MediaSound[] se = new MediaSound[30];
    public static final int BGM_MAX = 11;
    public static final int SE_MAX = 19;
    public static final int MLD_MAX = 30;
    public static AudioPresenter[] m_audio;
    public static AudioPresenter[] m_audio_se;
    public static int port_suu;
    public static int[] se_set;
    public static int[] se_flg;
    public static int[] now_se;
    public static int[] now_se_flg;
    public static int[] now_se_cnt;
    public static int[] sys_dat;
    public static final int SOUND_AD = 0;
    public static final int SOUND_SIZE = 1;
    public static final int HI_SCORE = 2;
    public static final int HI_SCORE_FLG = 3;
    public static final int KIDOU_FLG = 100;
    static String DomeUrl;
    static String Ver;
    static String AppID;

    public CpCanvas() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 6; ++j) {
                CpCanvas.panel[i][j] = new BtPanel();
            }
        }
    }

    public void paint(Graphics graphics) {
    }

    public void waku() {
        g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
        g.fillRect(-this.gapX, -this.gapY, this.getWidth(), this.gapY);
        g.fillRect(-this.gapX, 240, this.getWidth(), this.gapY + 1);
        g.fillRect(-this.gapX, 0, this.gapX, 240);
        g.fillRect(240, 0, this.gapX, 240);
    }

    void exe() {
        boolean bl = false;
        int n = 15;
        boolean bl2 = false;
        long l = 0L;
        g = this.getGraphics();
        imgMap = Image.createImage((int)240, (int)240);
        graMap = imgMap.getGraphics();
        tmp_imgMap = Image.createImage((int)240, (int)240);
        tmp_graMap = tmp_imgMap.getGraphics();
        for (int i = 0; i < 9; ++i) {
            Image cfr_ignored_0 = imgMap2[i];
            CpCanvas.imgMap2[i] = Image.createImage((int)240, (int)(240 - i / 6 * 172));
            CpCanvas.graMap2[i] = imgMap2[i].getGraphics();
        }
        g.setOrigin(this.getWidth() / 2 - 120, this.getHeight() / 2 - 120);
        f = Font.getFont((int)0);
        g.setFont(f);
        graMap.setFont(f);
        try {
            MediaImage mediaImage = MediaManager.getImage((String)"resource:///0.gif");
            mediaImage.use();
            dmy_image = mediaImage.getImage();
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.SetUp();
        CpCanvas.Audio(1, 0);
        scene = -2;
        key = 0;
        try {
            while (true) {
                System.gc();
                Thread.yield();
                if (System.currentTimeMillis() - mill < (long)(1000 / (n + 1))) continue;
                mill = System.currentTimeMillis();
                PhoneSystem.setAttribute((int)0, (int)1);
                g.lock();
                if (scene == -2) {
                    this.Title2();
                } else if (scene == -1) {
                    this.Test();
                } else if (scene == 0) {
                    this.Title();
                } else if (scene == 1) {
                    this.BattleMain();
                } else if (scene == 2) {
                    this.BattleTip();
                } else if (scene == 3) {
                    this.FieldMain();
                } else if (scene == 4) {
                    this.Menu();
                } else if (scene == 5) {
                    this.Machi();
                } else if (scene == 6) {
                    this.Keiji();
                } else if (scene == 7) {
                    this.Shop();
                } else if (scene == 8) {
                    this.Trader();
                } else if (scene == 9) {
                    this.Ranking();
                } else if (scene == 10) {
                    this.ZokuMain();
                }
                if (play_flg != 0) {
                    for (int i = 0; i < 16; ++i) {
                        audio[i].stop();
                    }
                    CpCanvas.Audio(1, now_bgm);
                    play_flg = 0;
                }
                this.waku();
                g.unlock(true);
                this.sePlay();
                this.Soft(0, soft_id[0]);
                this.Soft(1, soft_id[1]);
                ++game_cnt;
            }
        }
        catch (Exception exception) {
            return;
        }
    }

    public void Wait(int n) {
        g.unlock(true);
        mill = System.currentTimeMillis();
        while (System.currentTimeMillis() - mill < (long)n) {
        }
        g.lock();
    }

    public void SetUp() {
        int n;
        url = IApplication.getCurrentApp().getSourceURL();
        CpCanvas.readSP();
        this.urlSet();
        g.lock();
        PhoneSystem.setAttribute((int)0, (int)1);
        g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        g.fillRect(0, 0, 240, 240);
        this.waku();
        key = 0;
        if (dat[49] == 0 || deba_flg != 0) {
            // empty if block
        }
        g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
        mill = System.currentTimeMillis();
        int n2 = 0;
        while (n2 < 160) {
            n2 = (int)(System.currentTimeMillis() - mill) / 3;
            if (n2 > 160) {
                n2 = 160;
            }
            y = 120 - n2 / 2;
            g.lock();
            g.fillRect(0, y, 240, n2);
            g.unlock(true);
        }
        this.Wait(-1);
        g.setColor(Graphics.getColorOfRGB((int)170, (int)170, (int)170));
        CpCanvas.strDraw(this.set_str[0], (240 - f.stringWidth(this.set_str[0])) / 2, 55);
        CpCanvas.strDraw(this.set_str[19], 5, 195);
        g.drawImage(dmy_image, 40, 42);
        g.drawImage(dmy_image, 185, 42);
        this.Wait(300);
        CpCanvas.strDraw(this.set_str[1], 5, 75);
        this.Wait(300);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int n3 = calendar.get(2) + 1;
        this.kidou();
        CpCanvas.dat[52] = 1;
        this.NetData();
        if (http_error < 0) {
            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
            g.fillRect(150, 90, 240, 16);
            g.setColor(Graphics.getColorOfRGB((int)255, (int)0, (int)0));
            CpCanvas.strDraw(this.set_str[11], 150, 105);
            g.setColor(Graphics.getColorOfRGB((int)170, (int)170, (int)170));
            CpCanvas.strDraw(this.set_str[15], (240 - f.stringWidth(this.set_str[15])) / 2, 140);
            CpCanvas.strDraw(this.set_str[20], (240 - f.stringWidth(this.set_str[15])) / 2, 155);
            CpCanvas.strDraw(this.set_str[14], (240 - f.stringWidth(this.set_str[14])) / 2, 170);
            key = 0;
            this.Wait(100);
            while (key == 0) {
                try {
                    Thread.sleep(100L);
                }
                catch (Exception exception) {}
            }
            IApplication.getCurrentApp().terminate();
        }
        this.MldSet();
        this.mldAddSet();
        this.PASet();
        this.DrawBar(2, 38);
        this.TipSet();
        try {
            int n4;
            int n5;
            InputStream inputStream = null;
            InputStream inputStream2 = null;
            inputStream = CpCanvas.JarGet(24);
            for (n5 = 0; n5 < 265; ++n5) {
                CpCanvas.waza[n5] = new Waza(n5, inputStream);
                if (n5 % 10 != 0) continue;
                this.DrawBar(2, 50 + (n5 + 1) / 10 * 50 / 26);
            }
            inputStream.close();
            inputStream = null;
            System.gc();
            inputStream = CpCanvas.JarGet(25);
            waza[0].Set(inputStream);
            inputStream.close();
            inputStream = null;
            System.gc();
            inputStream = CpCanvas.JarGet(23);
            inputStream2 = CpCanvas.JarGet(22);
            for (n5 = 0; n5 < 213; ++n5) {
                CpCanvas.tip[n5] = new Tip();
                tip[n5].init(n5, inputStream, inputStream2);
                if (n5 % 10 == 0) {
                    this.DrawBar(3, n5 / 10 * 30 / 21);
                }
                System.gc();
            }
            inputStream.close();
            inputStream = null;
            System.gc();
            inputStream2.close();
            inputStream2 = null;
            System.gc();
            inputStream = CpCanvas.JarGet(26);
            byte[] byArray = new byte[8];
            for (n4 = 0; n4 < 22; ++n4) {
                inputStream.read(byArray);
                CpCanvas.rock_mo[n4 * 6 + 0] = byArray[3] & 0xFF;
                CpCanvas.rock_mo[n4 * 6 + 1] = byArray[2] & 0xFF;
                CpCanvas.rock_mo[n4 * 6 + 2] = byArray[1] & 0xFF;
                CpCanvas.rock_mo[n4 * 6 + 3] = byArray[0] & 0xFF;
                CpCanvas.rock_mo[n4 * 6 + 4] = byArray[7] & 0xFF;
                CpCanvas.rock_mo[n4 * 6 + 5] = byArray[6] & 0xFF;
            }
            inputStream.close();
            inputStream = null;
            System.gc();
            this.DrawBar(3, 35);
            inputStream = CpCanvas.JarGet(27);
            for (n4 = 0; n4 < 148; ++n4) {
                inputStream.read(byArray, 0, 4);
                CpCanvas.eff_mo[n4 * 3 + 0] = byArray[3] & 0xFF;
                CpCanvas.eff_mo[n4 * 3 + 1] = byArray[2] & 0xFF;
                CpCanvas.eff_mo[n4 * 3 + 2] = byArray[1] & 0xFF;
                if (n4 % 10 != 0) continue;
                this.DrawBar(3, 35 + (n4 / 10 + 1) * 30 / 14);
            }
            inputStream.close();
            inputStream = null;
            System.gc();
            inputStream = CpCanvas.dataGetRes(1);
            for (n4 = 0; n4 < 148; ++n4) {
                inputStream.read(byArray, 0, 4);
                CpCanvas.eff_se[n4] = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                inputStream.read(byArray, 0, 4);
            }
            inputStream.close();
            inputStream = null;
            System.gc();
            inputStream = CpCanvas.JarGet(28);
            for (n4 = 0; n4 < 22; ++n4) {
                inputStream.read(byArray, 0, 4);
                CpCanvas.teki_mo[n4 * 4 + 0] = byArray[3] & 0xFF;
                CpCanvas.teki_mo[n4 * 4 + 1] = byArray[2] & 0xFF;
                CpCanvas.teki_mo[n4 * 4 + 2] = byArray[1] & 0xFF;
                CpCanvas.teki_mo[n4 * 4 + 3] = byArray[0] & 0xFF;
            }
            inputStream.close();
            inputStream = null;
            System.gc();
            this.DrawBar(3, 75);
            inputStream = CpCanvas.JarGet(8);
            inputStream2 = CpCanvas.JarGet(9);
            for (n4 = 0; n4 < 18; ++n4) {
                CpCanvas.mail[n4] = new Mail(n4, inputStream, inputStream2);
                System.gc();
            }
            inputStream.close();
            inputStream = null;
            System.gc();
            inputStream2.close();
            inputStream2 = null;
            System.gc();
            this.DrawBar(3, 90);
            inputStream = CpCanvas.JarGet(36);
            for (n4 = 0; n4 < 45; ++n4) {
                inputStream.read(byArray, 0, 8);
                for (int i = 0; i < 5; ++i) {
                    CpCanvas.wait_data[n4 * 5 + i] = byArray[i] & 0xFF;
                }
            }
            inputStream.close();
            inputStream = null;
            System.gc();
            inputStream = CpCanvas.JarGet(18);
            inputStream2 = CpCanvas.JarGet(19);
            this.DrawBar(3, 100);
            for (n4 = 0; n4 < 29; ++n4) {
                CpCanvas.skill[n4] = new Skill(n4, inputStream, inputStream2);
            }
            CpCanvas.SortSkill(0);
            this.Wait(350);
            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
            for (n4 = 0; n4 < 7; ++n4) {
                g.fillRect(0, 40, 240, 21 + n4 * 15);
                this.Wait(100);
            }
            g.fillRect(0, 40, 240, 160);
            this.Wait(100);
            this.EneSet(-1, 0);
            inputStream.close();
            inputStream = null;
            System.gc();
            inputStream2.close();
            inputStream2 = null;
            System.gc();
        }
        catch (Exception exception) {
            // empty catch block
        }
        mill = System.currentTimeMillis();
        while (n2 < 240) {
            n2 = 160 + (int)(System.currentTimeMillis() - mill) / 3;
            y = 120 - n2 / 2;
            g.lock();
            g.fillRect(0, y, 240, n2);
            g.unlock(true);
        }
        this.Wait(800);
        this.ImgSet2(21);
        this.imgAddSet();
        this.imgAddDraw(0, 12, 99);
        g.unlock(true);
        mill = System.currentTimeMillis();
        g.lock();
        for (n = 0; n < 145; ++n) {
            CpCanvas.skill_list[n] = (n % 5 << 8) + n / 5;
        }
        for (n = 0; n < 4; ++n) {
            CpCanvas.fol[n] = new Folder();
            for (int i = 0; i < 30; ++i) {
                fol[n].FolSet(i, fol_d[i]);
            }
            fol[n].init();
            System.gc();
        }
        this.init(1);
        this.Load(0);
        this.MapSet(map_no, 0);
        sort_flg = -1;
        this.ListSort(0);
        CpCanvas.SortSkill(0);
        this.ImgSet2(20);
        while (System.currentTimeMillis() - mill < 1000L) {
        }
        key = 0;
        System.gc();
        g.fillRect(0, y, 240, 240);
        this.Wait(100);
    }

    public void DrawBar(int n, int n2) {
        g.lock();
        g.fillRect(95, 98 + n * 15, n2, 2);
        g.unlock(true);
        if (n2 >= 100) {
            this.Wait(50);
            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
            g.fillRect(85, 95 + n * 15, 240, 12);
            g.setColor(Graphics.getColorOfRGB((int)0, (int)255, (int)0));
            CpCanvas.strDraw(this.set_str[4], 90, 105 + n * 15);
            if (n == 3) {
                CpCanvas.strDraw(this.set_str[4], 100, 90);
            }
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        }
    }

    public void Soft(int n, int n2) {
        if (soft_id[2 + n] == n2) {
            return;
        }
        this.setSoftLabel(n, soft_str[n2]);
        CpCanvas.soft_id[2 + n] = n2;
    }

    public int CGI(int n, int n2) {
        http_error = 1;
        String[] stringArray = new String[]{"http://game.capcom.jp/i/exe/sreg/iexe_score.php?uid=NULLGWDOCOMO", "http://game.capcom.jp/i/exe/sreg/iexe_score.php?uid=NULLGWDOCOMO&ty=scck&sc=" + n2, "http://game.capcom.jp/i/exe/sreg/iexe_score.php?uid=NULLGWDOCOMO&ty=pts&qt=" + n2, "http://game.capcom.jp/i/exe/sreg/iexe_score.php?uid=NULLGWDOCOMO&ty=fg&x0=" + r_id[n2], "" + DomeUrl + dev + "party/sreg/isr.php?uid=NULLGWDOCOMO&k=" + AppID + "&v0=" + Ver + "&ty=buyreg", "" + DomeUrl + dev + "party/sreg/isr.php?uid=NULLGWDOCOMO&k=" + AppID + "&v0=" + Ver, "" + DomeUrl + dev + "party/sreg/isr.php?uid=NULLGWDOCOMO&k=" + AppID + "&v0=" + Ver + "&ty=exefg&x0=" + r_id[n2]};
        System.out.println("url:" + stringArray[n]);
        HttpConnection httpConnection = null;
        InputStream inputStream = null;
        String string = stringArray[n];
        byte[] byArray = new byte[61];
        try {
            httpConnection = (HttpConnection)Connector.open((String)string, (int)1);
            httpConnection.setRequestMethod("GET");
            httpConnection.connect();
            String string2 = httpConnection.getHeaderField("X-CAPCOM-STATUS");
            if (n < 4) {
                string2 = "OK";
            }
            if (string2 == null) {
                http_error = 200;
            } else if (string2.compareTo("NG") == 0) {
                http_error = 100;
            } else if (string2.compareTo("MT") == 0) {
                http_error = 150;
            } else if (string2.compareTo("OK") == 0) {
                int n3;
                inputStream = httpConnection.openInputStream();
                inputStream.read(byArray);
                http_error = byArray[0] & 0xFF;
                if (n == 0) {
                    n3 = (byArray[1] & 0xFF) << 24 | (byArray[2] & 0xFF) << 16 | (byArray[3] & 0xFF) << 8 | byArray[4] & 0xFF;
                    CpCanvas.dat[51] = n3 / 10000;
                    CpCanvas.dat[52] = n3 / 100 % 100;
                }
                if (n == 1) {
                    n3 = (byArray[1] & 0xFF) << 8 | byArray[2] & 0xFF;
                    str = n3 / 100 + "\u6708" + n3 % 100 + "\u65e5";
                }
                if (n == 2) {
                    site_point = n3 = (byArray[1] & 0xFF) << 8 | byArray[2] & 0xFF;
                }
                if (n == 6) {
                    for (n3 = 0; n3 < 30; ++n3) {
                        CpCanvas.r_tip[n3] = byArray[n3 * 2 + 1] & 0xFF | (byArray[n3 * 2 + 2] & 0xFF) << 8;
                    }
                }
                if (n == 5) {
                    n3 = (byArray[1] & 0xFF) << 24 | (byArray[2] & 0xFF) << 16 | (byArray[3] & 0xFF) << 8 | byArray[4] & 0xFF;
                    CpCanvas.dat[51] = n3 / 10000;
                    CpCanvas.dat[52] = n3 / 100 % 100;
                }
                inputStream.close();
                inputStream = null;
            } else {
                http_error = 255;
            }
            httpConnection.close();
            httpConnection = null;
        }
        catch (Exception exception) {
            http_error = 255;
            try {
                inputStream.close();
                httpConnection.close();
            }
            catch (Exception exception2) {
                // empty catch block
            }
        }
        return http_error;
    }

    public void init(int n) {
        max_sel = 5;
        ivent_flg = -1;
        R = 155;
        G = 255;
        B = 210;
        this.RockIventSet();
        if (n == 0) {
            int n2;
            this.SetFlg(0);
            this.SetFlg(1);
            map_no = 0;
            map_x = 40;
            map_y = 60;
            max_hp = 100;
            now_hp = 100;
            zenny = 0;
            piece = 0;
            full_ene = 1;
            now_fol = 0;
            fol_suu = 1;
            regu_you = 4;
            get_tip = 0;
            CpCanvas.get_tip2[0] = 0;
            CpCanvas.get_tip2[1] = 0;
            CpCanvas.get_tip2[2] = 0;
            CpCanvas.get_tip2[3] = 0;
            mail_suu = 0;
            back_menu = 5;
            mail_open = 0;
            now_bgm = -1;
            skill_suu = 0;
            for (n2 = 0; n2 < 224; ++n2) {
                CpCanvas.get_list[n2] = 0;
            }
            for (n2 = 0; n2 < 4; ++n2) {
                int n3;
                for (n3 = 0; n3 < 30; ++n3) {
                    CpCanvas.fol[n2].tip_id[n3] = 0;
                }
                for (n3 = 0; n3 < 30; ++n3) {
                    fol[n2].FolSet(n3, fol_d[n3]);
                }
                fol[n2].init();
                CpCanvas.fol[n2].regu_id = 0;
                CpCanvas.fol[n2].regu_flg = 0;
                System.gc();
            }
            n2 = 0;
            while (n2 < 512) {
                int n4 = n2++;
                tip_list[n4] = tip_list[n4] & 0xFFFF;
            }
            n2 = 0;
            while (n2 < 148) {
                int n5 = n2++;
                skill_list[n5] = skill_list[n5] & 0xFFFF;
            }
            for (n2 = 0; n2 < 12; ++n2) {
                Edit.set[n2] = 0;
                Edit.set2[n2] = 0;
                Edit.flg[n2] = 0;
            }
            this.SkillRun(0);
            for (n2 = 0; n2 < 5; ++n2) {
                Edit.zoku[n2] = 0;
            }
            Edit.r_zoku = 0;
            Edit.set_cnt = 0;
            Edit.now_slot = 0;
            Edit.max_slot = 3;
            quest_flg = 0;
            machi_no = 0;
            sina_no = 1;
            sina_flg = -1;
            skill_flg = 0;
            s_hen = 0;
            q_hen = 0;
            CpCanvas.i_cnt[0] = 0;
            CpCanvas.i_cnt[1] = 0;
            quest_no = 0;
            q_get = 0;
            for (n2 = 0; n2 < 10; ++n2) {
                CpCanvas.q_list[n2] = 0;
            }
            site_point = 0;
            tmp_point = 0;
            for (n2 = 0; n2 < 22; ++n2) {
                CpCanvas.teki_ren[n2 / 11][n2 % 11] = 0;
            }
            for (n2 = 0; n2 < 12; ++n2) {
                CpCanvas.navi_flg[n2] = 0;
            }
            for (n2 = 29; n2 >= 0; --n2) {
                CpCanvas.fol_data[n2] = CpCanvas.fol[0].tip_id[n2];
            }
            score = 0;
            CpCanvas.dat[58] = 0;
            CpCanvas.dat[59] = 0;
            CpCanvas.dat[60] = 0;
            CpCanvas.dat[61] = 0;
            CpCanvas.dat[62] = 0;
            CpCanvas.dat[63] = 0;
            CpCanvas.sh_zai[0][0] = 0;
            CpCanvas.q_flg[0] = 0;
            CpCanvas.q_flg[1] = 0;
        }
    }

    public void SetFlg(int n) {
        if (n == 0) {
            int n2;
            byte[] byArray;
            InputStream inputStream;
            try {
                inputStream = CpCanvas.GetData(1);
                byArray = new byte[40];
                inputStream.read(byArray);
                for (n2 = 0; n2 < 40; ++n2) {
                    if (n2 % 2 == 0) {
                        CpCanvas.move_ok[n2 / 2] = byArray[n2];
                        continue;
                    }
                    CpCanvas.plg_ok[n2 / 2] = byArray[n2];
                }
                inputStream.close();
                inputStream = null;
                System.gc();
            }
            catch (Exception exception) {
                // empty catch block
            }
            try {
                inputStream = CpCanvas.GetData(2);
                byArray = new byte[4];
                for (n2 = 0; n2 < 20; n2 += 2) {
                    inputStream.read(byArray);
                    int n3 = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                    CpCanvas.talk_flg[n2 + 1][0] = n3 & 0xF;
                    CpCanvas.talk_flg[n2 + 1][1] = n3 >> 4 & 0xF;
                    CpCanvas.talk_flg[n2 + 1][2] = n3 >> 8 & 0xF;
                    CpCanvas.talk_flg[n2 + 1][3] = n3 >> 12 & 0xF;
                    CpCanvas.talk_flg[n2][0] = n3 >> 16 & 0xF;
                    CpCanvas.talk_flg[n2][1] = n3 >> 20 & 0xF;
                    CpCanvas.talk_flg[n2][2] = n3 >> 24 & 0xF;
                    CpCanvas.talk_flg[n2][3] = n3 >> 28 & 0xF;
                }
                CpCanvas.talk_flg[20][0] = 1;
                inputStream.close();
                inputStream = null;
                System.gc();
            }
            catch (Exception exception) {}
        } else {
            try {
                InputStream inputStream = CpCanvas.GetData(4);
                byte[] byArray = new byte[4];
                for (int i = 0; i < 69; ++i) {
                    inputStream.read(byArray);
                    int n4 = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                    CpCanvas.item_flg[i][0] = n4 & 1;
                    CpCanvas.item_flg[i][1] = n4 >> 1 & 1;
                    CpCanvas.item_flg[i][2] = n4 >> 2 & 1;
                    CpCanvas.item_flg[i][3] = n4 >> 3 & 1;
                    CpCanvas.tobi_flg[i][0] = n4 >> 4 & 3;
                    CpCanvas.tobi_flg[i][1] = n4 >> 6 & 3;
                    CpCanvas.chara_flg[i][0] = n4 >> 8 & 3;
                    CpCanvas.chara_flg[i][1] = n4 >> 10 & 3;
                    CpCanvas.chara_flg[i][2] = n4 >> 12 & 3;
                    CpCanvas.chara_flg[i][3] = n4 >> 14 & 3;
                }
                inputStream.close();
                inputStream = null;
                System.gc();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public void PASet() {
        try {
            InputStream inputStream = CpCanvas.JarGet(20);
            byte[] byArray = new byte[4];
            for (int i = 0; i < 34; ++i) {
                inputStream.read(byArray);
                CpCanvas.pa_data[i][0] = byArray[3] & 0xFF;
                CpCanvas.pa_data[i][1] = byArray[2] & 0xFF;
                CpCanvas.pa_data[i][2] = byArray[1] & 0xFF;
                CpCanvas.pa_data[i][3] = byArray[0] & 0xFF;
                inputStream.read(byArray);
                int n = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                CpCanvas.pa_data[i][4] = n & 0x1F;
                CpCanvas.pa_data[i][5] = n >> 5 & 0x1F;
                CpCanvas.pa_data[i][6] = n >> 10 & 0x1F;
                CpCanvas.pa_data[i][7] = n >> 15 & 0x1F;
                CpCanvas.pa_data[i][8] = n >> 20;
            }
            inputStream.close();
            inputStream = null;
            System.gc();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void EneSet(int n, int n2) {
        if (n < 0) {
            try {
                InputStream inputStream = CpCanvas.JarGet(30);
                byte[] byArray = new byte[4];
                for (int i = 0; i < 680; ++i) {
                    inputStream.read(byArray);
                    CpCanvas.e_data[i / 5][i % 5] = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                }
                inputStream.close();
                inputStream = null;
                System.gc();
            }
            catch (Exception exception) {}
        } else {
            try {
                int n3;
                InputStream inputStream = CpCanvas.JarGet(29);
                byte[] byArray = new byte[16];
                inputStream.skip(16 * n2);
                inputStream.read(byArray);
                for (n3 = 0; n3 < 16 && byArray[n3] != 0; ++n3) {
                }
                byte[] byArray2 = new byte[n3];
                for (int i = 0; i < n3; ++i) {
                    byArray2[i] = byArray[i];
                }
                CpCanvas.e_name[n] = new String(byArray2);
                inputStream.close();
                inputStream = null;
                System.gc();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public void Title2() {
        int n;
        CpCanvas.soft_id[0] = 0;
        CpCanvas.soft_id[1] = 0;
        if (machi_flg == 3) {
            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
            g.fillRect(0, 0, 240, 240);
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            g.fillRect(2, 162, 236, 76);
            if (mode == 0) {
                CpCanvas.MesRead(50, null, 3);
                if (key == 0x100000) {
                    ++mode;
                    key = 0;
                }
            } else if (mode == 1) {
                now_bgm = 3;
                this.Save(0);
                CpCanvas.Audio(1, 11);
                now_bgm = 0;
                ++mode;
            } else if (mode == 2) {
                CpCanvas.MesRead(51, null, 3);
                if (key == 0x100000) {
                    machi_flg = 0;
                    mes_flg = 1;
                    yes_no_flg = 1;
                    mode = 0;
                    mode2 = 4;
                    CpCanvas.MesRead(0, null, 10);
                    key = 0;
                    return;
                }
            }
            CpCanvas.MesDraw(1);
            CpCanvas.drawImg3(44, 108, 225, 222 + game_cnt / 3 % 2, false);
            return;
        }
        if (option_flg != 0) {
            this.Option();
            return;
        }
        g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        g.fillRect(0, 0, 240, 240);
        int n2 = game_cnt;
        int n3 = 125 + 10 * (n2 % 26 - n2 % 26 / 14 * (n2 % 13 * 2));
        g.setColor(Graphics.getColorOfRGB((int)n3, (int)0, (int)0));
        g.fillRect(112, 32, 54, 20);
        g.fillRect(64, 53, 95, 75);
        this.imgAddDraw(2, 0, 0);
        this.imgAddDraw(3, 178, 123);
        if (mes_flg != 0) {
            boolean bl = false;
            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
            g.fillRect(0, 160, 240, 80);
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            g.fillRect(2, 162, 236, 76);
            if (yes_no_flg != 0) {
                if (key == 65536) {
                    yes_no_flg = 1;
                    key = 0;
                }
                if (key == 262144) {
                    yes_no_flg = 2;
                    key = 0;
                }
            }
            if (mode2 == 0) {
                CpCanvas.MesRead(41, null, 3);
                if (key == 0x100000) {
                    mode2 = yes_no_flg == 1 ? ++mode2 : 8;
                    yes_no_flg = 0;
                    bl = true;
                    key = 0;
                }
            } else if (mode2 == 1) {
                CpCanvas.MesRead(96, null, 3);
                ++mode2;
            } else if (mode2 == 2) {
                http_error = 0;
                if (http_error == 0) {
                    ++mode2;
                    sina_flg = 2;
                    now_bgm = back_menu == 3 ? map_bgm : 3;
                    this.Save(0);
                    now_bgm = 0;
                } else if (http_error == 1) {
                    mode2 = 14;
                } else if (http_error == 2) {
                    mode2 = 10;
                } else if (http_error == 15) {
                    mode2 = 18;
                }
                key = 0;
            } else if (mode2 == 3) {
                CpCanvas.MesRead(46, null, 3);
                if (key == 0x100000) {
                    CpCanvas.MesRead(0, null, 10);
                    yes_no_flg = 1;
                    ++mode2;
                    key = 0;
                }
            } else if (mode2 == 4) {
                if (key == 0x100000) {
                    mode2 = yes_no_flg == 1 ? ++mode2 : 13;
                    yes_no_flg = 0;
                    bl = true;
                    key = 0;
                }
            } else if (mode2 == 5) {
                CpCanvas.MesRead(3, null, 10);
                ++mode2;
            } else if (mode2 == 6) {
                CpCanvas.dat[39] = 1;
                CpCanvas.writeSP();
                this.GetScenario(sina_no + 1);
                if (http_error == 0) {
                    int n4;
                    ++sina_no;
                    machi_no = 0;
                    back_menu = 5;
                    CpCanvas.i_cnt[0] = 0;
                    now_bgm = -1;
                    int[] nArray = new int[20];
                    for (n4 = 0; n4 < 20; ++n4) {
                        nArray[n4] = talk_flg[n4][2];
                    }
                    this.SetFlg(0);
                    for (n4 = 0; n4 < 20; ++n4) {
                        CpCanvas.talk_flg[n4][2] = nArray[n4];
                    }
                    sina_flg = -1;
                    this.RockIventSet();
                    this.Save(0);
                    now_bgm = 0;
                    ++mode2;
                    CpCanvas.dat[39] = 0;
                    CpCanvas.writeSP();
                } else {
                    mode2 = 15;
                }
                key = 0;
            } else if (mode2 == 7) {
                CpCanvas.MesRead(2, null, 10);
                if (key == 0x100000) {
                    mode = 0;
                    mes_flg = 0;
                    key = 0;
                }
            } else if (mode2 == 8) {
                CpCanvas.MesRead(42, null, 3);
                if (key == 0x100000) {
                    ++mode2;
                    key = 0;
                }
            } else if (mode2 == 9) {
                CpCanvas.MesRead(43, null, 3);
                if (key == 0x100000) {
                    mes_flg = 0;
                    key = 0;
                }
            } else if (mode2 == 10) {
                CpCanvas.MesRead(44, str.getBytes(), 3);
                if (key == 0x100000) {
                    ++mode2;
                    key = 0;
                }
            } else if (mode2 == 11) {
                CpCanvas.MesRead(45, null, 3);
                if (key == 0x100000) {
                    mes_flg = 0;
                    key = 0;
                }
            } else if (mode2 == 12) {
                CpCanvas.MesRead(70, null, 3);
                if (key == 0x100000) {
                    mes_flg = 0;
                    key = 0;
                }
            } else if (mode2 == 13) {
                CpCanvas.MesRead(1, null, 10);
                if (key == 0x100000) {
                    mes_flg = 0;
                    key = 0;
                }
            } else if (mode2 == 14) {
                CpCanvas.MesRead(99, null, 3);
                if (key == 0x100000) {
                    mode2 = 8;
                    key = 0;
                }
            } else if (mode2 == 15) {
                CpCanvas.MesRead(88, null, 3);
                if (key == 0x100000) {
                    ++mode2;
                    CpCanvas.MesRead(18, null, 10);
                    yes_no_flg = 1;
                    key = 0;
                }
            } else if (mode2 == 16) {
                CpCanvas.MesRead(18, null, 10);
                if (key == 0x100000) {
                    mode2 = yes_no_flg == 1 ? 5 : ++mode2;
                    yes_no_flg = 0;
                    bl = true;
                    key = 0;
                }
            } else if (mode2 == 17) {
                CpCanvas.MesRead(98, null, 3);
                if (key == 0x100000) {
                    IApplication.getCurrentApp().terminate();
                }
            } else if (mode2 == 18) {
                CpCanvas.MesRead(161, null, 3);
                if (key == 0x100000) {
                    IApplication.getCurrentApp().terminate();
                }
            }
            CpCanvas.MesDraw(1);
            if (yes_no_flg != 0) {
                CpCanvas.drawImg3(44, 33, 55 + (yes_no_flg - 1) * 96 + game_cnt / 2 % 3, 207, false);
            } else if (!bl && this.MesFlg()) {
                CpCanvas.drawImg3(44, 108, 225, 222 + game_cnt / 3 % 2, false);
            }
            return;
        }
        if (deba_flg != 0) {
            if (key == 2) {
                ++sina_flg;
                sina_flg %= 3;
                key = 0;
            }
            if (key == 65536) {
                if (mode == 3) {
                    --sina_no;
                }
                key = 0;
            }
            if (key == 262144) {
                if (mode == 3) {
                    ++sina_no;
                }
                key = 0;
            }
            if (key == 0x200000) {
                scene = 0;
                key = 0;
                return;
            }
        }
        if (key == 131072) {
            if (--mode < 0) {
                mode = 2;
                if (sina_flg > 0 && sina_no < 8) {
                    ++mode;
                }
            }
            key = 0;
        } else if (key == 524288) {
            ++mode;
            n = 2;
            if (sina_flg > 0 && sina_no < 8) {
                ++n;
            }
            if (mode > n) {
                mode = 0;
            }
            key = 0;
        } else if (key == 0x200000 && deba_flg == 0) {
            IApplication.getCurrentApp().terminate();
        }
        CpCanvas.soft_id[0] = 8;
        CpCanvas.soft_id[1] = 0;
        g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
        CpCanvas.strDraw("\u7b2c " + sina_no + " \u8a71", 180, 150);
        CpCanvas.strDraw(t_str[0], (240 - f.stringWidth(t_str[0])) / 2, 185);
        CpCanvas.strDraw(t_str[1], (240 - f.stringWidth(t_str[1])) / 2, 200);
        CpCanvas.strDraw("\u30b5\u30a4\u30c8\u3078\u79fb\u52d5", (240 - f.stringWidth("\u30b5\u30a4\u30c8\u3078\u79fb\u52d5")) / 2, 215);
        if (sina_flg == 1 && sina_no < 8) {
            CpCanvas.strDraw("" + (sina_no + 1) + t_str[3], (240 - f.stringWidth("" + (sina_no + 1) + t_str[3])) / 2, 230);
        }
        if (sina_flg == 2 && sina_no < 8) {
            CpCanvas.strDraw("" + (sina_no + 1) + t_str[3], (240 - f.stringWidth("" + (sina_no + 1) + t_str[3])) / 2, 230);
        }
        for (n = 0; n < 6; ++n) {
            if (dat[58 + n] == 0) continue;
            CpCanvas.drawImg3(44, 131 + n, 166 + n * 12, 173, false);
            CpCanvas.drawImg3(44, 137 + n, 166 + n * 12, 173, false);
        }
        CpCanvas.drawImg3(44, 33, 60 + game_cnt / 2 % 3, 170 + mode * 15, false);
        if (key == 0x100000) {
            if (mode == 0) {
                CpCanvas.Audio(0, 0);
                this.Load(0);
                this.MachiSet(machi_no, 0);
                sort_flg = -1;
                this.ListSort(0);
                CpCanvas.SortSkill(0);
                scene = back_menu;
                if (scene == 5) {
                    this.MachiSet(machi_no, 1);
                }
                n = map_x;
                int n5 = map_y;
                mode = 0;
                this.MapSet(map_no, 0);
                map_x = n;
                map_y = n5;
                now_bgm = scene == 3 ? map_bgm : 3;
                if (sina_flg >= 0) {
                    CpCanvas.Audio(1, now_bgm);
                } else {
                    this.IventRead(1, 0);
                    now_bgm = -1;
                    sina_flg = 0;
                }
            } else if (mode == 1) {
                option_flg = 1;
            } else if (mode == 2) {
                String string = DomeUrl + "/i/party/?uid=NULLGWDOCOMO";
                IApplication.getCurrentApp().launch(1, new String[]{string});
            } else if (mode == 3) {
                if (sina_flg == 1) {
                    mes_flg = 1;
                    yes_no_flg = 1;
                    mode = 0;
                    mode2 = 4;
                    CpCanvas.MesRead(0, null, 10);
                } else if (sina_flg == 2) {
                    mes_flg = 1;
                    yes_no_flg = 1;
                    mode = 0;
                    mode2 = 4;
                    CpCanvas.MesRead(0, null, 10);
                }
            }
            key = 0;
        }
    }

    public void Title() {
        if (key == 131072) {
            --mode;
            key = 0;
        }
        if (key == 524288) {
            ++mode;
            key = 0;
        }
        if (key == 4) {
            if (mode == 0) {
                teki_pt += 10;
            }
            if (mode == 2) {
                map_no += 10;
            }
            key = 0;
        }
        if (key == 2) {
            if (mode == 0) {
                teki_pt -= 10;
            }
            if (mode == 2) {
                map_no -= 10;
            }
            key = 0;
        }
        if (key == 65536) {
            if (mode == 0) {
                --teki_pt;
            }
            if (mode == 2) {
                --map_no;
            }
            if (mode == 3) {
                --machi_no;
            }
            if (mode == 5) {
                --this.se_no;
            }
            if (mode == 6) {
                --this.bgm_no;
            }
            key = 0;
        }
        if (key == 262144) {
            if (mode == 0) {
                ++teki_pt;
            }
            if (mode == 2) {
                ++map_no;
            }
            if (mode == 3) {
                ++machi_no;
            }
            if (mode == 5) {
                ++this.se_no;
            }
            if (mode == 6) {
                ++this.bgm_no;
            }
            key = 0;
        }
        if (key == 0x100000) {
            if (mode == 0) {
                this.BtSet(teki_pt);
                scene = 1;
                eff_cnt = 1;
                mode = 0;
            } else if (mode == 1) {
                scene = -1;
                mode = 0;
            } else if (mode == 2) {
                scene = 3;
                this.MapSet(map_no, 0);
                CpCanvas.Audio(1, map_bgm);
                mode = 0;
            } else if (mode == 3) {
                this.MachiSet(machi_no, 1);
                CpCanvas.Audio(1, 3);
                scene = 5;
                mode = 0;
            } else if (mode == 4) {
                this.ImgSet2(20);
                CpCanvas.Audio(1, 0);
                scene = -2;
                mode = 0;
            } else if (mode == 5) {
                CpCanvas.seSet(this.se_no, 0);
            } else if (mode == 6) {
                CpCanvas.Audio(1, this.bgm_no);
            }
            key = 0;
        }
        g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
        g.fillRect(0, 0, 240, 240);
        g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        CpCanvas.strDraw("\u6226 " + teki_pt, 40, 30);
        CpCanvas.strDraw("\u8868\u793a\u30c6\u30b9\u30c8", 40, 45);
        CpCanvas.strDraw("\u96fb " + map_no + " " + map_str[map_no], 40, 60);
        CpCanvas.strDraw("\u8857 " + machi_no + " " + m_name[machi_no], 40, 75);
        CpCanvas.strDraw("\u30bf\u30a4\u30c8\u30eb\u3078", 40, 90);
        CpCanvas.strDraw("SE\uff1a" + this.se_no, 40, 105);
        CpCanvas.strDraw("BGM\uff1a" + this.bgm_no, 40, 120);
        if (deba_flg != 0) {
            int n;
            if (key == 16) {
                rock_mu ^= 1;
                key = 0;
            }
            if (key == 32) {
                teki_mu ^= 1;
                key = 0;
            }
            String[] stringArray = new String[]{"off", "on"};
            CpCanvas.strDraw("[4]\u30ed\u30c3\u30af\u30de\u30f3\u7121\u6575\uff1a" + stringArray[rock_mu], 40, 150);
            CpCanvas.strDraw("[5]\u6575HP\uff0b\uff11\uff10\uff10\uff10\uff1a" + stringArray[teki_mu], 40, 165);
            CpCanvas.strDraw("[#]\u5f37:", 40, 190);
            CpCanvas.strDraw("[3]\uff31:" + que_su, 40, 220);
            if (key == 0x400000) {
                CpCanvas.q_flg[0] = 0;
                CpCanvas.q_flg[1] = 0;
                for (n = 1; n < que_su + 1; ++n) {
                    int n2 = (n - 1) / 32;
                    q_flg[n2] = q_flg[n2] | 1 << 31 - (n - 1) % 32;
                    quest_flg = 0;
                    quest_no = 0;
                }
                if (q_flg[0] == -1 && q_flg[1] == -2) {
                    CpCanvas.dat[63] = 1;
                    CpCanvas.writeSP();
                }
                this.Save(0);
                CpCanvas.Audio(1, 14);
                key = 0;
            }
            if (key == 8) {
                if ((que_su += 7) > 63) {
                    que_su = 0;
                }
                key = 0;
            }
            if (key == 2048) {
                max_hp = 1000;
                now_hp = 1000;
                zenny = 990000;
                piece = 9900;
                regu_you = 99;
                get_tip = 400;
                CpCanvas.get_tip2[0] = 123;
                CpCanvas.get_tip2[1] = 52;
                CpCanvas.get_tip2[2] = 4;
                CpCanvas.get_tip2[3] = 28;
                CpCanvas.dat[59] = 1;
                CpCanvas.dat[60] = 1;
                CpCanvas.dat[61] = 1;
                CpCanvas.dat[62] = 1;
                Edit.max_slot = 12;
                for (n = 0; n < 145; ++n) {
                    CpCanvas.skill_list[n] = 196608 + (n % 5 << 8) + n / 5;
                }
                for (n = 0; n < 224; ++n) {
                    CpCanvas.get_list[n] = 1;
                }
                n = 2;
                while (n < 509) {
                    int n3 = n++;
                    tip_list[n3] = tip_list[n3] | 0x30000;
                }
                sort_flg = -1;
                this.ListSort(0);
                CpCanvas.SortSkill(0);
                CpCanvas.Audio(1, 13);
                skill_flg = 1;
                key = 0;
            }
        }
        CpCanvas.strDraw(">", 15, 30 + mode * 15);
    }

    public void Option() {
        int n;
        CpCanvas.soft_id[0] = 0;
        CpCanvas.soft_id[1] = 0;
        if (option_flg < 10) {
            CpCanvas.drawImg3(44, 0, 0, 0, true);
            CpCanvas.drawImg3(44, 90, 8, 8, true);
            graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
            graMap.fillRect(4, 20, 232, 136);
            graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            graMap.fillRect(2, 162, 236, 76);
            for (n = 0; n < 5; ++n) {
                CpCanvas.strDrawG(o_str[n], 39, 50 + n * 21);
            }
            graMap.setColor(Graphics.getColorOfRGB((int)180, (int)180, (int)180));
            if (option_flg == 2) {
                CpCanvas.strDrawG(o_str[2], 39, 92);
                CpCanvas.strDrawG(o_str[3], 39, 113);
                CpCanvas.strDrawG(o_str[4], 39, 134);
            }
            mode = 0;
            option_flg += 10;
        }
        if (o_mode == 0) {
            CpCanvas.soft_id[0] = 2;
            CpCanvas.soft_id[1] = 0;
            if (key == 131072) {
                if (--mode < 0) {
                    mode = 4 - option_flg / 12 * 3;
                }
                key = 0;
            } else if (key == 524288) {
                if (++mode > 4 - option_flg / 12 * 3) {
                    mode = 0;
                }
                key = 0;
            }
            if (key == 65536) {
                if (mode == 0) {
                    if (++audio_flg > 3) {
                        audio_flg = 0;
                    }
                    for (i = 0; i < 16; ++i) {
                        audio[i].setAttribute(4, (3 - audio_flg) * 100 / 3);
                    }
                    for (i = 0; i < 30; ++i) {
                        m_audio[i].setAttribute(4, (3 - audio_flg) * 100 / 3);
                    }
                    CpCanvas.dat[53] = audio_flg;
                    CpCanvas.writeSP();
                }
                key = 0;
            }
            if (key == 262144) {
                if (mode == 0) {
                    if (--audio_flg < 0) {
                        audio_flg = 3;
                    }
                    for (i = 0; i < 16; ++i) {
                        audio[i].setAttribute(4, (3 - audio_flg) * 100 / 3);
                    }
                    for (i = 0; i < 30; ++i) {
                        m_audio[i].setAttribute(4, (3 - audio_flg) * 100 / 3);
                    }
                    CpCanvas.dat[53] = audio_flg;
                    CpCanvas.writeSP();
                }
                key = 0;
            }
            int[] nArray = new int[]{93, 94, 71, 76, 82};
            CpCanvas.MesRead(nArray[mode], null, 3);
            if (key == 0x100000) {
                if (mode == 0) {
                    if (--audio_flg < 0) {
                        audio_flg = 3;
                    }
                    for (i = 0; i < 16; ++i) {
                        audio[i].setAttribute(4, (3 - audio_flg) * 100 / 3);
                    }
                    for (i = 0; i < 30; ++i) {
                        m_audio[i].setAttribute(4, (3 - audio_flg) * 100 / 3);
                    }
                    CpCanvas.dat[53] = audio_flg;
                    CpCanvas.writeSP();
                }
                if (mode == 1) {
                    if (option_flg - 10 == 1) {
                        option_flg = 0;
                        mode = 0;
                    } else {
                        CpCanvas.MesRead(97, null, 3);
                        yes_no_flg = 1;
                        o_mode = 1;
                        o_cnt = 0;
                    }
                }
                if (mode == 2) {
                    CpCanvas.MesRead(72, null, 3);
                    o_mode = 2;
                    o_cnt = 0;
                }
                if (mode == 3) {
                    CpCanvas.MesRead(77, null, 3);
                    o_mode = 3;
                    o_cnt = 0;
                }
                if (mode == 4) {
                    CpCanvas.MesRead(83, null, 3);
                    o_mode = 4;
                    o_cnt = 0;
                }
                key = 0;
            } else if (key == 0x200000) {
                if (option_flg - 10 == 2) {
                    str = " " + full_ene;
                    CpCanvas.MesRead(menu_sel + 5, str.getBytes(), 3);
                    menu_cnt = -1;
                    option_flg = 0;
                    mode = 0;
                    key = 0;
                    return;
                }
                option_flg = 0;
                mode = 0;
                key = 0;
            }
        } else {
            if (yes_no_flg != 0) {
                if (key == 65536) {
                    yes_no_flg = 1;
                    key = 0;
                }
                if (key == 262144) {
                    yes_no_flg = 2;
                    key = 0;
                }
            }
            if (o_mode == 1) {
                if (o_cnt == 0) {
                    if (key == 0x100000) {
                        if (yes_no_flg == 1) {
                            this.Save(0);
                            CpCanvas.Audio(1, 11);
                            o_mode = 0;
                            yes_no_flg = 0;
                            mode = 0;
                            option_flg = 0;
                            this.ImgSet2(20);
                            CpCanvas.Audio(1, 0);
                            scene = -2;
                        } else {
                            CpCanvas.MesRead(95, null, 3);
                            yes_no_flg = 2;
                            ++o_cnt;
                        }
                        key = 0;
                    }
                } else if (o_cnt == 1 && key == 0x100000) {
                    if (yes_no_flg == 1) {
                        o_mode = 0;
                        yes_no_flg = 0;
                        mode = 0;
                        option_flg = 0;
                        this.ImgSet2(20);
                        this.Load(0);
                        CpCanvas.Audio(1, 0);
                        scene = -2;
                    } else {
                        o_mode = 0;
                    }
                    yes_no_flg = 0;
                    key = 20;
                }
            } else if (o_mode == 2) {
                if (o_cnt == 0) {
                    if (key == 0x100000) {
                        CpCanvas.MesRead(73, null, 3);
                        yes_no_flg = 2;
                        ++o_cnt;
                        key = 0;
                    }
                } else if (o_cnt == 1) {
                    if (key == 0x100000) {
                        if (yes_no_flg == 1) {
                            CpCanvas.MesRead(74, null, 3);
                        } else {
                            o_mode = 0;
                        }
                        yes_no_flg = 0;
                        ++o_cnt;
                        key = 0;
                    }
                } else if (o_cnt == 2) {
                    this.Load(0);
                    this.Save(1);
                    now_bgm = 0;
                    if (http_error == 3) {
                        CpCanvas.dat[39] = 0;
                        CpCanvas.writeSP();
                        CpCanvas.MesRead(75, null, 3);
                        o_cnt = 7;
                    } else if (http_error == 141) {
                        CpCanvas.MesRead(191, null, 3);
                        CpCanvas.dat[39] = 0;
                        CpCanvas.writeSP();
                        o_cnt = 3;
                    } else if (http_error == 110) {
                        CpCanvas.MesRead(6, null, 10);
                        o_cnt = 9;
                        yes_no_flg = 1;
                    } else if (http_error == 120) {
                        CpCanvas.MesRead(7, null, 10);
                        o_cnt = 8;
                        yes_no_flg = 1;
                    } else if (http_error == 150) {
                        CpCanvas.MesRead(8, null, 10);
                        o_cnt = 6;
                        o_cnt = 3;
                    } else {
                        str = "" + http_error;
                        CpCanvas.MesRead(9, str.getBytes(), 10);
                        o_cnt = 4;
                    }
                    key = 0;
                } else if (o_cnt == 3) {
                    if (key == 0x100000) {
                        o_mode = 0;
                        key = 0;
                    }
                } else if (o_cnt == 4) {
                    if (key == 0x100000) {
                        CpCanvas.MesRead(18, null, 10);
                        yes_no_flg = 1;
                        ++o_cnt;
                        key = 0;
                    }
                } else if (o_cnt == 5) {
                    if (key == 0x100000) {
                        if (yes_no_flg == 1) {
                            CpCanvas.MesRead(74, null, 3);
                            o_cnt = 2;
                        } else {
                            o_mode = 0;
                        }
                        yes_no_flg = 0;
                        key = 0;
                    }
                } else if (o_cnt == 6) {
                    if (key == 0x100000) {
                        IApplication.getCurrentApp().terminate();
                    }
                } else if (o_cnt == 7) {
                    if (key == 0x100000) {
                        str = "" + zan;
                        CpCanvas.MesRead(188, str.getBytes(), 3);
                        o_cnt = 3;
                        key = 0;
                    }
                } else if (o_cnt == 8) {
                    if (key == 0x100000) {
                        if (yes_no_flg == 1) {
                            String string = DomeUrl + "/i/party/?uid=NULLGWDOCOMO&appid=" + AppID + "&page=verup";
                            IApplication.getCurrentApp().launch(1, new String[]{string});
                        }
                        o_cnt = 6;
                        CpCanvas.MesRead(15, null, 10);
                        yes_no_flg = 0;
                        key = 0;
                    }
                } else if (o_cnt == 9 && key == 0x100000) {
                    if (yes_no_flg == 1) {
                        String string = DomeUrl + "/i/party/?uid=NULLGWDOCOMO&web=reg";
                        IApplication.getCurrentApp().launch(1, new String[]{string});
                    } else {
                        o_mode = 0;
                    }
                    o_mode = 0;
                    yes_no_flg = 0;
                    key = 0;
                }
            } else if (o_mode == 3) {
                if (o_cnt == 0) {
                    if (key == 0x100000) {
                        CpCanvas.MesRead(78, null, 3);
                        yes_no_flg = 2;
                        ++o_cnt;
                        key = 0;
                    }
                } else if (o_cnt == 1) {
                    if (key == 0x100000) {
                        if (yes_no_flg == 1) {
                            CpCanvas.MesRead(79, null, 3);
                            yes_no_flg = 2;
                        } else {
                            yes_no_flg = 0;
                            o_mode = 0;
                        }
                        ++o_cnt;
                        key = 0;
                    }
                } else if (o_cnt == 2) {
                    if (key == 0x100000) {
                        if (yes_no_flg == 1) {
                            CpCanvas.MesRead(80, null, 3);
                        } else {
                            o_mode = 0;
                            o_cnt = 0;
                        }
                        yes_no_flg = 0;
                        ++o_cnt;
                        key = 0;
                    }
                } else if (o_cnt == 3) {
                    this.Load(1);
                    if (http_error == 3) {
                        this.Save(0);
                        http_error = 0;
                        if (http_error == 0 && quest_no > 0) {
                            this.QAll();
                        }
                        if (http_error == 0) {
                            this.GetScenario(1);
                        }
                        if (http_error == 0) {
                            this.GetScenario(sina_no);
                        }
                        if (http_error == 0) {
                            this.QDawn(0, quest_no);
                        }
                        this.Load(0);
                        this.Save(0);
                        http_error = 0;
                        if (http_error == 0) {
                            now_bgm = 0;
                            this.RockIventSet();
                            CpCanvas.dat[39] = 0;
                            CpCanvas.writeSP();
                            CpCanvas.MesRead(81, null, 3);
                            o_cnt = 8;
                        } else {
                            CpCanvas.MesRead(88, null, 3);
                            o_cnt = 5;
                        }
                    } else if (http_error == 140) {
                        CpCanvas.MesRead(192, null, 3);
                        CpCanvas.dat[39] = 0;
                        CpCanvas.writeSP();
                        o_cnt = 4;
                    } else if (http_error == 141) {
                        CpCanvas.MesRead(191, null, 3);
                        CpCanvas.dat[39] = 0;
                        CpCanvas.writeSP();
                        o_cnt = 4;
                    } else if (http_error == 110) {
                        CpCanvas.MesRead(6, null, 10);
                        o_cnt = 10;
                        yes_no_flg = 1;
                    } else if (http_error == 120) {
                        CpCanvas.MesRead(7, null, 10);
                        o_cnt = 9;
                        yes_no_flg = 1;
                    } else if (http_error == 150) {
                        CpCanvas.MesRead(8, null, 10);
                        o_cnt = 4;
                    } else {
                        str = "" + http_error;
                        CpCanvas.MesRead(9, str.getBytes(), 10);
                        o_cnt = 5;
                    }
                    key = 0;
                } else if (o_cnt == 4) {
                    if (key == 0x100000) {
                        o_mode = 0;
                        key = 0;
                    }
                } else if (o_cnt == 5) {
                    if (key == 0x100000) {
                        CpCanvas.MesRead(18, null, 10);
                        yes_no_flg = 1;
                        ++o_cnt;
                        key = 0;
                    }
                } else if (o_cnt == 6) {
                    if (key == 0x100000) {
                        if (yes_no_flg == 1) {
                            CpCanvas.MesRead(80, null, 3);
                            o_cnt = 3;
                        } else {
                            o_mode = 0;
                        }
                        yes_no_flg = 0;
                        key = 0;
                    }
                } else if (o_cnt == 7) {
                    if (key == 0x100000) {
                        IApplication.getCurrentApp().terminate();
                    }
                } else if (o_cnt == 8) {
                    if (key == 0x100000) {
                        str = "" + zan;
                        CpCanvas.MesRead(189, str.getBytes(), 3);
                        o_cnt = 4;
                        key = 0;
                    }
                } else if (o_cnt == 9) {
                    if (key == 0x100000) {
                        if (yes_no_flg == 1) {
                            String string = DomeUrl + "/i/party/?uid=NULLGWDOCOMO&appid=" + AppID + "&page=verup";
                            IApplication.getCurrentApp().launch(1, new String[]{string});
                        }
                        o_cnt = 7;
                        CpCanvas.MesRead(15, null, 10);
                        yes_no_flg = 0;
                        key = 0;
                    }
                } else if (o_cnt == 10 && key == 0x100000) {
                    if (yes_no_flg == 1) {
                        String string = DomeUrl + "/i/party/?uid=NULLGWDOCOMO&web=reg";
                        IApplication.getCurrentApp().launch(1, new String[]{string});
                    } else {
                        o_mode = 0;
                    }
                    o_mode = 0;
                    yes_no_flg = 0;
                    key = 0;
                }
            } else if (o_mode == 4) {
                if (o_cnt == 0) {
                    if (key == 0x100000) {
                        CpCanvas.MesRead(84, null, 3);
                        yes_no_flg = 2;
                        ++o_cnt;
                        key = 0;
                    }
                } else if (o_cnt == 1) {
                    if (key == 0x100000) {
                        if (yes_no_flg == 1) {
                            CpCanvas.MesRead(85, null, 3);
                            yes_no_flg = 2;
                        } else {
                            yes_no_flg = 0;
                            o_mode = 0;
                        }
                        ++o_cnt;
                        key = 0;
                    }
                } else if (o_cnt == 2) {
                    if (key == 0x100000) {
                        if (yes_no_flg == 1) {
                            CpCanvas.MesRead(86, null, 3);
                        } else {
                            o_mode = 0;
                            o_cnt = 0;
                        }
                        yes_no_flg = 0;
                        ++o_cnt;
                        key = 0;
                    }
                } else if (o_cnt == 3) {
                    CpCanvas.dat[39] = 7;
                    CpCanvas.writeSP();
                    this.GetScenario(1);
                    if (http_error == 0) {
                        CpCanvas.i_cnt[0] = 0;
                        machi_no = 0;
                        for (n = 0; n < 29; ++n) {
                            CpCanvas.skill_kouka[n] = 0;
                        }
                        this.init(0);
                        this.Save(0);
                        this.Load(0);
                        this.RockIventSet();
                        sina_no = 1;
                        sina_flg = -1;
                        now_bgm = 0;
                        CpCanvas.dat[39] = 0;
                        CpCanvas.writeSP();
                        CpCanvas.MesRead(87, null, 3);
                        ++o_cnt;
                    } else {
                        CpCanvas.MesRead(88, null, 3);
                        o_cnt = 5;
                    }
                    key = 0;
                } else if (o_cnt == 4) {
                    if (key == 0x100000) {
                        o_mode = 0;
                        key = 0;
                    }
                } else if (o_cnt == 5) {
                    if (key == 0x100000) {
                        CpCanvas.MesRead(18, null, 10);
                        yes_no_flg = 1;
                        ++o_cnt;
                        key = 0;
                    }
                } else if (o_cnt == 6) {
                    if (key == 0x100000) {
                        if (yes_no_flg == 1) {
                            CpCanvas.MesRead(86, null, 3);
                            o_cnt = 3;
                        } else {
                            CpCanvas.MesRead(98, null, 3);
                            ++o_cnt;
                        }
                        yes_no_flg = 0;
                        key = 0;
                    }
                } else if (o_cnt == 7 && key == 0x100000) {
                    IApplication.getCurrentApp().terminate();
                }
            }
        }
        g.drawImage(imgMap, 0, 0);
        g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        CpCanvas.strDraw(o_str[5 + audio_flg], 120, 50);
        if (o_mode == 0) {
            CpCanvas.drawImg3(44, 33, 15 + game_cnt / 2 % 3, 35 + mode * 21, false);
        }
        CpCanvas.MesDraw(1);
        if (yes_no_flg != 0) {
            CpCanvas.drawImg3(44, 33, 55 + (yes_no_flg - 1) * 96 + game_cnt / 2 % 3, 207, false);
        } else if (o_mode != 0 && this.MesFlg()) {
            CpCanvas.drawImg3(44, 108, 225, 222 + game_cnt / 3 % 2, false);
        }
    }

    public boolean MesFlg() {
        int[] nArray = new int[]{24, 63, 69, 74, 80, 86, 96};
        for (int i = 0; i < 7; ++i) {
            if (mes_id != nArray[i]) continue;
            return false;
        }
        return true;
    }

    public void Test() {
        int n;
        CpCanvas.Audio(0, 0);
        if (key == 0x200000) {
            scene = 0;
            key = 0;
        }
        if (key == 131072) {
            if (--mode < 0) {
                mode = 4;
            }
            key = 0;
        }
        if (key == 524288) {
            if (++mode > 4) {
                mode = 0;
            }
            key = 0;
        }
        if (key == 65536) {
            if (mode == 0) {
                if (--ch_no < 0) {
                    ch_no = 53;
                }
                ani_pt = 0;
                g_no = 0;
                ani_cnt = 0;
            }
            if (mode == 1 && --g_no < 0) {
                g_no = dx[ch_no].length - 1;
            }
            if (mode == 2 && ch_no < 42) {
                if (--ani_pt < 0) {
                    ani_pt = ani[ch_no].length - 1;
                }
                ani_cnt = 0;
            }
            if (mode == 3) {
                flp ^= 1;
            }
            if (mode == 4 && ch_no < 22) {
                if (--plt < 0) {
                    plt = 3;
                    if (ch_no == 0) {
                        ++plt;
                    }
                }
                n = plt + ch_no * 4;
                if (ch_no > 0) {
                    ++n;
                }
                CpCanvas.PalSet(ch_no, n);
            }
            key = 0;
        }
        if (key == 262144) {
            if (mode == 0) {
                if (++ch_no > 53) {
                    ch_no = 0;
                }
                ani_pt = 0;
                g_no = 0;
                ani_cnt = 0;
            }
            if (mode == 1 && ++g_no > dx[ch_no].length - 1) {
                g_no = 0;
            }
            if (mode == 2 && ch_no < 42) {
                if (++ani_pt > ani[ch_no].length - 1) {
                    ani_pt = 0;
                }
                ani_cnt = 0;
            }
            if (mode == 3) {
                flp ^= 1;
            }
            if (mode == 4 && ch_no < 22) {
                ++plt;
                if (ch_no == 0) {
                    if (plt > 4) {
                        plt = 0;
                    }
                } else if (plt > 3) {
                    plt = 0;
                }
                n = plt + ch_no * 4;
                if (ch_no > 0) {
                    ++n;
                }
                CpCanvas.PalSet(ch_no, n);
            }
            key = 0;
        }
        if (key == 0x100000) {
            if (mode == 2) {
                ani_cnt = 0;
            }
            if (mode == 3) {
                flp ^= 1;
            }
            key = 0;
        }
        g.drawImage(imgMap, 0, 0);
        g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
        g.fillRect(0, 0, 240, 75);
        g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        CpCanvas.strDraw("\u8868\u793a\u30c6\u30b9\u30c8", (240 - f.stringWidth("\u8868\u793a\u30c6\u30b9\u30c8")) / 2, 25);
        CpCanvas.strDraw("ch :" + ch_no, 15, 15);
        CpCanvas.strDraw("no :" + g_no, 15, 30);
        CpCanvas.strDraw("ani:" + ani_pt, 15, 45);
        CpCanvas.strDraw("flp:" + flp, 15, 60);
        CpCanvas.strDraw("plt:" + plt, 15, 75);
        CpCanvas.strDraw(">", 5, 15 + mode * 15);
        CpCanvas.drawImg3(ch_no, g_no, 50, 200, false);
        if (ch_no < 42 && CpCanvas.Ani(ch_no, ani_pt, ani_cnt, 1, 1, 0, 0, flp) == -2) {
            CpCanvas.Ani(ch_no, ani_pt, --ani_cnt, 1, 1, 0, 0, flp);
        }
        ++ani_cnt;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void BattleMain() {
        int n;
        int n2;
        int n3;
        block138: {
            block139: {
                block142: {
                    block141: {
                        block140: {
                            CpCanvas.soft_id[0] = 0;
                            CpCanvas.soft_id[1] = 0;
                            if (eff_cnt > 0) {
                                g.drawImage(imgMap, 0, 0);
                                this.CharaDraw(0);
                                this.EnEff(--eff_cnt);
                                g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
                                g.fillRect(0, 0, 240, 40);
                                g.fillRect(0, 200, 240, 40);
                                if (eff_cnt == 0) {
                                    fol[now_fol].RandSet(max_sel);
                                    ++scene;
                                    key = 0;
                                    if (ren_flg > 0) {
                                        cas_cnt = 0;
                                    }
                                }
                                key = 0;
                                return;
                            }
                            if (dell_cnt < 0) {
                                int n4;
                                for (n4 = 0; n4 < 3; ++n4) {
                                    ene[n4].Move();
                                }
                                g.drawImage(imgMap, 0, 0);
                                for (n4 = 0; n4 < 30; ++n4) {
                                    if (CpCanvas.ata[n4].on == 0) continue;
                                    ata[n4].Move(1);
                                }
                                this.CharaDraw(1);
                                rock.HpDraw(0, 0);
                                g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
                                g.fillRect(0, 0, 240, 40);
                                g.fillRect(0, 200, 240, 40);
                                if (++dell_cnt != 0) {
                                    if (dell_cnt >= -5) return;
                                    int[] nArray = new int[]{4, 9, 16, 18, 16, 16, 16, 16, 16, 16, 16, 16, 16, 9, 4};
                                    g.drawScaledImage((Image)image[43], 52, 104 + (16 - nArray[20 + dell_cnt]) / 2, 60, nArray[20 + dell_cnt], 120, 32, 60, 16);
                                    g.drawScaledImage((Image)image[43], 112, 104 + (16 - nArray[20 + dell_cnt]) / 2, 76, nArray[20 + dell_cnt], 120, 64, 76, 16);
                                    return;
                                }
                                come_back = 0;
                                if (ren_flg > 0) {
                                    if (rank_flg != 0) {
                                        int n5;
                                        come_back = 1;
                                        bas_cnt = (bas_cnt + 1) * 20 + (rand.nextInt() >>> 1) % 10 - 5;
                                        n4 = 7;
                                        if (bas_cnt / 300 >= 5) {
                                            --n4;
                                        }
                                        if (bas_cnt / 300 >= 12) {
                                            --n4;
                                        }
                                        if (bas_cnt / 300 >= 36) {
                                            --n4;
                                        }
                                        n4 = (n5 = Rock.noke_cnt) > 4 ? (n4 -= 3) : (n4 -= n5 - 1);
                                        if (Rock.move_cnt < 3) {
                                            ++n4;
                                        }
                                        n4 += dell_lv;
                                        sco_cnt[0] = sco_cnt[0] + bas_cnt;
                                        if (dell_lv / 2 == 1) {
                                            sco_cnt[1] = sco_cnt[1] + 1;
                                        }
                                        if (dell_lv / 2 == 2) {
                                            sco_cnt[2] = sco_cnt[2] + 1;
                                        }
                                        sco_cnt[3] = sco_cnt[3] + Rock.move_cnt;
                                        sco_cnt[4] = sco_cnt[4] + Rock.noke_cnt;
                                        sco_cnt[5] = sco_cnt[5] + rika_cnt;
                                        CpCanvas.sco_cnt[6] = Rock.hp * 100 / max_hp;
                                    }
                                    if (teki_ren[ren_id][ren_flg] > 0) {
                                        g.fillRect(0, 200, 240, 240);
                                        g.unlock(true);
                                        while (System.currentTimeMillis() - audio_mill < 1800L) {
                                        }
                                        g.lock();
                                        now_hp = Rock.hp;
                                        this.BtSet(teki_ren[ren_id][ren_flg]);
                                        ++ren_flg;
                                        eff_cnt = 8;
                                        return;
                                    }
                                    ren_flg = 0;
                                    scene = back_menu;
                                    while (System.currentTimeMillis() - audio_mill < 1800L) {
                                    }
                                    if (back_menu == 3) {
                                        CpCanvas.Audio(1, map_bgm);
                                        now_hp = Rock.hp;
                                    } else {
                                        if (rank_flg == 0) {
                                            CpCanvas.Audio(1, 3);
                                            this.MachiSet(machi_no, 0);
                                        } else {
                                            rank_flg = 0;
                                            CpCanvas.Audio(1, 6);
                                        }
                                        ivent_flg = 0;
                                    }
                                    win_flg = 1;
                                    key = 0;
                                    return;
                                }
                                bas_cnt = (bas_cnt + 1) * 20 + (rand.nextInt() >>> 1) % 10 - 5;
                                bas_lv = this.BasLv();
                                CpCanvas.bt_get[0] = ene[drop_ene].Get(0, bas_lv);
                                bas_flg = 1;
                                graMap.setColor(Graphics.getColorOfRGB((int)96, (int)112, (int)192));
                                graMap.fillRect(0, 0, 240, 240);
                                CpCanvas.drawImg3(44, 84, 0, 0, true);
                                CpCanvas.drawImg3(44, 85, 187, 0, true);
                                graMap.setColor(Graphics.getColorOfRGB((int)200, (int)224, (int)248));
                                graMap.fillRect(6, 3, 181, 120);
                                graMap.setColor(Graphics.getColorOfRGB((int)96, (int)112, (int)192));
                                graMap.fillRect(6, 3, 178, 13);
                                graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
                                graMap.fillRect(6, 16, 178, 107);
                                CpCanvas.drawImg3(44, 118, 15, 6, true);
                                graMap.setColor(Graphics.getColorOfRGB((int)96, (int)112, (int)192));
                                graMap.fillRect(15, 22, 164, 18);
                                graMap.setColor(Graphics.getColorOfRGB((int)240, (int)240, (int)240));
                                graMap.fillRect(13, 20, 164, 18);
                                graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
                                graMap.fillRect(15, 21, 160, 16);
                                graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                                CpCanvas.strDrawG(menu_str[28], 17, 35);
                                CpCanvas.drawImg3(44, 119, 127, 24, true);
                                CpCanvas.drawImg3(44, 119, 151, 24, true);
                                graMap.setColor(Graphics.getColorOfRGB((int)96, (int)112, (int)192));
                                graMap.fillRect(15, 46, 164, 18);
                                graMap.setColor(Graphics.getColorOfRGB((int)240, (int)240, (int)240));
                                graMap.fillRect(13, 44, 164, 18);
                                graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
                                graMap.fillRect(15, 45, 160, 16);
                                graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                                CpCanvas.strDrawG(menu_str[29], 17, 59);
                                graMap.setColor(Graphics.getColorOfRGB((int)96, (int)112, (int)192));
                                graMap.fillRect(10, 67, 171, 53);
                                graMap.setColor(Graphics.getColorOfRGB((int)240, (int)240, (int)240));
                                graMap.fillRect(11, 68, 169, 51);
                                graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
                                graMap.fillRect(13, 69, 165, 49);
                                CpCanvas.drawImg3(44, 110, 20, 72, true);
                                graMap.setColor(Graphics.getColorOfRGB((int)51, (int)61, (int)108));
                                graMap.fillRect(42, 85, 111, 16);
                                graMap.fillRect(41, 86, 113, 14);
                                graMap.setColor(Graphics.getColorOfRGB((int)96, (int)112, (int)192));
                                graMap.fillRect(42, 86, 111, 14);
                                while (System.currentTimeMillis() - audio_mill < 1800L) {
                                }
                                CpCanvas.Audio(1, 6);
                                key = 0;
                                return;
                            }
                            if (bas_flg != 0) {
                                g.drawImage(imgMap, 24, 63, 0, 0, 190, 127);
                                CpCanvas.ImgSuu(bas_cnt / 18000, 135, 87, 16, 3, 1);
                                CpCanvas.ImgSuu(bas_cnt / 300 % 60, 159, 87, 16, 3, 1);
                                CpCanvas.ImgSuu(bas_cnt / 3 % 100, 183, 87, 16, 3, 1);
                                if (bas_lv > 10) {
                                    CpCanvas.drawImg3(44, 116, 180, 111, false);
                                } else {
                                    CpCanvas.ImgSuu(bas_lv, 180, 111, 16, 1, 1);
                                }
                                CpCanvas.drawImg3(44, 114, 116, 181 + game_cnt / 3 % 2, false);
                                if (bas_flg == 1) {
                                    if (key != 0) {
                                        bas_flg = bt_get[0] != 0 ? 2 : 3;
                                        if (teki_pt == 340 || teki_pt == 344) {
                                            bas_flg = 0;
                                        }
                                        key = 0;
                                    }
                                } else if (bas_flg == 2) {
                                    int n6 = tip_list[bt_get[0]] >> 8 & 0xFF;
                                    int n7 = tip_list[bt_get[0]] & 0xFF;
                                    str = this.ItemName(0, bt_get[0]);
                                    g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                                    CpCanvas.strDraw(str, 68, 162);
                                    CpCanvas.drawImg3(44, 112, 47, 165, false);
                                    CpCanvas.drawImg3(44, 113, 126, 165, false);
                                    tip[n6].Draw(47, 149, 1, true);
                                    tip[n6].DrawPow(91, 166);
                                    tip[n6].DrawZoku(178, 165);
                                    if (key != 0) {
                                        ++bas_flg;
                                        key = 0;
                                    }
                                } else if (bas_flg == 3) {
                                    CpCanvas.ImgSuu(bt_get[1], 132, 151, 36, 1, 1);
                                    CpCanvas.drawImg3(44, 42, 169, 153, false);
                                    if (key != 0) {
                                        bas_flg = bt_get[2] != 0 ? ++bas_flg : 0;
                                        key = 0;
                                    }
                                } else if (bas_flg == 4) {
                                    g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                                    CpCanvas.strDraw(menu_str[30], 68, 162);
                                    CpCanvas.ImgSuu(bt_get[2], 132, 151, 36, 1, 1);
                                    CpCanvas.drawImg3(44, 43, 169, 153, false);
                                    if (key != 0) {
                                        bas_flg = 0;
                                        key = 0;
                                    }
                                }
                                if (bas_flg != 0) return;
                                this.GetItem(0, 0, bt_get[0]);
                                this.GetItem(1, 0, bt_get[1]);
                                this.GetItem(2, 0, bt_get[2]);
                                bas_flg = 0;
                                scene = back_menu;
                                if (back_menu == 3) {
                                    CpCanvas.Audio(1, map_bgm);
                                } else {
                                    CpCanvas.Audio(1, 3);
                                    this.MachiSet(machi_no, 0);
                                    ivent_flg = 0;
                                }
                                win_flg = 1;
                                now_hp = Rock.hp;
                                key = 0;
                                return;
                            }
                            if (over_flg != 0) {
                                int n8 = over_cnt * 4;
                                if (n8 > 18) {
                                    n8 = 18;
                                }
                                g.setColor(Graphics.getColorOfRGB((int)45, (int)50, (int)89));
                                g.fillRect(0, 125 - (n8 + 4) / 2, 240, n8 + 4);
                                g.drawScaledImage((Image)image[43], 59, 116 + (18 - n8) / 2, 56, n8, 120, 80, 56, 18);
                                g.drawScaledImage((Image)image[43], 125, 116 + (18 - n8) / 2, 53, n8, 120, 98, 53, 18);
                                if (n8 == 18 && (key == 0x100000 || over_cnt == 100)) {
                                    over_flg = 0;
                                    over_cnt = 0;
                                    this.ImgSet2(20);
                                    CpCanvas.Audio(1, 0);
                                    scene = -2;
                                    mes_flg = 0;
                                    key = 0;
                                }
                                ++over_cnt;
                                return;
                            }
                            if (over_cnt > 0) {
                                if (over_cnt == 1) {
                                    ren_flg = 0;
                                    if (come_back != 0) {
                                        come_back = 0;
                                        scene = back_menu;
                                        now_hp = tmp_hp;
                                        if (back_menu == 3) {
                                            CpCanvas.Audio(1, map_bgm);
                                        } else {
                                            CpCanvas.Audio(1, 3);
                                            if (rank_flg == 0) {
                                                this.MachiSet(machi_no, 0);
                                            } else {
                                                rank_flg = 0;
                                                rank_cnt = 1;
                                            }
                                            ivent_flg = 0;
                                        }
                                        win_flg = 0;
                                        return;
                                    }
                                    key = 0;
                                }
                                g.drawImage(imgMap, 0, 0);
                                this.CharaDraw(1);
                                rock.HpDraw(0, 0);
                                g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
                                g.fillRect(0, 0, 240, 40);
                                g.fillRect(0, 200, 240, 40);
                                if (over_cnt < 16) {
                                    int[] nArray = new int[]{4, 9, 16, 18, 16, 16, 16, 16, 16, 16, 16, 16, 16, 9, 4};
                                    g.drawScaledImage((Image)image[43], 52, 104 + (16 - nArray[over_cnt - 1]) / 2, 76, nArray[over_cnt - 1], 120, 48, 76, 16);
                                    g.drawScaledImage((Image)image[43], 128, 104 + (16 - nArray[over_cnt - 1]) / 2, 76, nArray[over_cnt - 1], 120, 64, 76, 16);
                                } else {
                                    int n9;
                                    if (over_cnt == 16) {
                                        CpCanvas.Audio(0, 0);
                                    }
                                    if ((n9 = (over_cnt - 16) * (over_cnt - 16) * 3) > 240) {
                                        n9 = 240;
                                        over_flg = 1;
                                        over_cnt = 0;
                                    }
                                    g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                                    g.fillRect(0, 112, n9, 2);
                                    g.fillRect(240 - n9, 136, 240, 2);
                                }
                                ++over_cnt;
                                return;
                            }
                            if (stop_cnt > 0) {
                                int n10;
                                if (stop_cnt == 1) {
                                    this.MotionBack();
                                    Rock.tmp_muteki_cnt = Rock.muteki_cnt;
                                    for (n10 = 0; n10 < 3; ++n10) {
                                        CpCanvas.ene[n10].tmp_muteki_cnt = CpCanvas.ene[n10].muteki_cnt;
                                    }
                                }
                                if (stop_cnt < 4) {
                                    this.Ann(0, stop_cnt - 1);
                                }
                                ++stop_cnt;
                                tmp_graMap.drawImage(imgMap, 0, 0);
                                g.drawImage(tmp_imgMap, 0, 0);
                                for (n10 = 0; n10 < 30; ++n10) {
                                    if (CpCanvas.ata[n10].on == 0) continue;
                                    ata[n10].Move(0);
                                }
                                for (n10 = 0; n10 < 30; ++n10) {
                                    if (CpCanvas.ata[n10].on == 0) continue;
                                    ata[n10].HitGo(0);
                                }
                                this.CharaDraw(0);
                                CpCanvas.drawImg3(43, 0, 48, 40, false);
                                rock.HpDraw(0, 0);
                                rock.TipDraw();
                                if (stop_cnt < 15) {
                                    g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                                    CpCanvas.strDraw(stop_name, (120 - f.stringWidth(stop_name)) / 2 + 120 * stop_ch, 80);
                                }
                                if (wana_flg >= 100 && stop_cnt == 16) {
                                    for (n10 = 0; n10 < 3; ++n10) {
                                        if (CpCanvas.ene[n10].on == 0) continue;
                                        if (wana_flg - 100 == 1 && CpCanvas.panel[CpCanvas.ene[n10].pos_y][CpCanvas.ene[n10].pos_x].jou == 4 || wana_flg - 100 == 3 && CpCanvas.panel[CpCanvas.ene[n10].pos_y][CpCanvas.ene[n10].pos_x].jou == 5) {
                                            wana_pow[0] = wana_pow[0] * 2;
                                        }
                                        if (wana_flg - 100 == 1 && CpCanvas.panel[CpCanvas.ene[n10].pos_y][CpCanvas.ene[n10].pos_x].jou == 4 || wana_flg - 100 == 2 && CpCanvas.panel[CpCanvas.ene[n10].pos_y][CpCanvas.ene[n10].pos_x].jou == 3) {
                                            panel[CpCanvas.ene[n10].pos_y][CpCanvas.ene[n10].pos_x].Henka(1, 0);
                                        }
                                        ene[n10].Hit(1, wana_pow[0], wana_flg - 100);
                                        CpCanvas.ene[n10].hit_cnt = 0;
                                    }
                                    wana_flg = 0;
                                }
                                rock.WanaDraw();
                                g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
                                g.fillRect(0, 0, 240, 40);
                                g.fillRect(0, 200, 240, 40);
                                if (stop_cnt >= stop_time) {
                                    n10 = stop_cnt - stop_time;
                                    this.Ann(1, 4 - n10);
                                    if (n10 == 4) {
                                        int n11;
                                        for (n11 = 0; n11 < 30; ++n11) {
                                            if (CpCanvas.ata[n11].on == 0 || CpCanvas.ata[n11].hit_time <= 0) continue;
                                            ata[n11].init();
                                        }
                                        Rock.muteki_cnt = Rock.tmp_muteki_cnt;
                                        for (n11 = 0; n11 < 3; ++n11) {
                                            CpCanvas.ene[n11].muteki_cnt = CpCanvas.ene[n11].tmp_muteki_cnt;
                                            CpCanvas.ene[n11].tmp_muteki_cnt = 0;
                                        }
                                        stop_cnt = 0;
                                        stop_time = 0;
                                        key = 0;
                                    }
                                }
                                key = 0;
                                return;
                            }
                            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
                            if (dell_cnt != 0 || over_cnt != 0) break block138;
                            if (key == 65536) {
                                if (Rock.joutai == 0) {
                                    if (Rock.move_flg == 0) {
                                        Rock.move_flg = 1;
                                    }
                                }
                                key = 0;
                            } else if (key == 262144) {
                                if (Rock.joutai == 0) {
                                    if (Rock.move_flg == 0) {
                                        Rock.move_flg = 3;
                                    }
                                }
                                key = 0;
                            } else if (key == 131072) {
                                if (Rock.joutai == 0) {
                                    if (Rock.move_flg == 0) {
                                        Rock.move_flg = 2;
                                    }
                                }
                                key = 0;
                            } else if (key == 524288) {
                                if (Rock.joutai == 0) {
                                    if (Rock.move_flg == 0) {
                                        Rock.move_flg = 4;
                                    }
                                }
                                key = 0;
                            } else if (key == 0x100000) {
                                if (Rock.tmp_ata < 0) {
                                    rock.Action(0);
                                }
                                key = 0;
                            } else if (key == 0x200000 || key == 0x400000) {
                                key = 0;
                                if (cus_gage == 128) {
                                    ++scene;
                                    fol[now_fol].RandSet(max_sel);
                                    this.MotionBack();
                                    return;
                                }
                            }
                            if (deba_flg != 0) {
                                if (key == 4) {
                                    --this.deba_tip_id;
                                    if (this.deba_tip_id < 0) {
                                        this.deba_tip_id = 212;
                                    }
                                    key = 0;
                                }
                                if (key == 8) {
                                    ++this.deba_tip_id;
                                    if (this.deba_tip_id > 212) {
                                        this.deba_tip_id = 0;
                                    }
                                    key = 0;
                                }
                                if (key == 16) {
                                    n3 = Rock.tip_no;
                                    Rock.tip_no = 8;
                                    CpCanvas.rock.tip[8] = tip[this.deba_tip_id];
                                    rock.Action(0);
                                    Rock.tip_no = n3;
                                    key = 0;
                                }
                                if (key == 2) {
                                    n3 = Rock.tip_no;
                                    Rock.tip_no = 8;
                                    CpCanvas.rock.tip[8] = tip[179];
                                    rock.Action(0);
                                    Rock.tip_no = n3;
                                    key = 0;
                                }
                                if (key == 32) {
                                    n3 = Rock.tip_no;
                                    rock.Action(0);
                                    Rock.tip_no = n3;
                                    key = 0;
                                }
                                if (key == 256) {
                                    scene = 0;
                                    key = 0;
                                }
                                if (key == 1) {
                                    this.BtSet(++teki_pt);
                                    key = 0;
                                }
                            }
                            n3 = this.getKeypadState();
                            if (Rock.tmp_ata >= 0) break block139;
                            if (Rock.non_cnt2 != 0) break block139;
                            n2 = 42 - cha_lv * 5;
                            if (key_cnt >= 0) break block140;
                            ++key_cnt;
                            break block139;
                        }
                        if ((n3 & 0x800) != 0 || (n3 & 0x200) != 0 || (n3 & 0x400) != 0 || (n3 & 0x80) != 0) break block141;
                        if ((n3 & 0x100000) == 0) break block142;
                        if (Rock.tip_no >= 0) break block142;
                    }
                    if (Rock.non_bas == 0) {
                        if (Rock.joutai == 0 && key_cnt <= n2) {
                            if (key_cnt == 4) {
                                key_cnt -= rock.Chage(0);
                            } else if (key_cnt == n2) {
                                rock.Chage(1);
                            }
                            ++key_cnt;
                        }
                    }
                    break block139;
                }
                if (key_cnt > 0) {
                    n = 0;
                    if (key_cnt > n2) {
                        int[] nArray = new int[]{1, 209, 210, 211, 212};
                        n = nArray[Edit.r_zoku];
                    }
                    int n12 = Rock.tip_no;
                    Rock.tip_no = 5;
                    CpCanvas.rock.tip[5] = tip[n];
                    rock.Action(0);
                    Rock.tip_no = n12;
                    key_cnt = -4;
                }
            }
            Rock.non_bas = 0;
        }
        n3 = 0;
        for (n2 = 0; n2 < 3; ++n2) {
            ene[n2].Move();
        }
        if (stop_time != 0) {
            stop_time += 20;
            stop_cnt = 1;
            return;
        }
        if (wana_flg != 0 && CpCanvas.ene[0].muteki2 == 0) {
            n2 = 0;
            n = 0;
            while (true) {
                if (n >= 3) {
                    stop_cnt = 1;
                    stop_name = CpCanvas.tip[114 + CpCanvas.wana_flg].name;
                    wana_flg += 100;
                    return;
                }
                if (CpCanvas.ene[n].on != 0) {
                    n2 = CpCanvas.AtaNo(0);
                    ata[n2].Set(94 + wana_flg, CpCanvas.ene[n].pos_x, CpCanvas.ene[n].pos_y, 1, -2);
                    stop_time = CpCanvas.ata[n2].hit_time + 20;
                    n2 = CpCanvas.AtaNo(0);
                    ata[n2].Set(52, CpCanvas.ene[n].pos_x, CpCanvas.ene[n].pos_y, 0, 2);
                    CpCanvas.ata[n2].hit_time = 1;
                }
                ++n;
            }
        }
        rock.Move();
        if (wana_flg != 0 && CpCanvas.ene[0].muteki2 == 0) {
            n2 = CpCanvas.AtaNo(0);
            ata[n2].Set(94 + wana_flg, Rock.pos_x, Rock.pos_y, 0, -2);
            CpCanvas.ata[n2].chara_flg = 1;
            CpCanvas.ata[n2].pow = wana_pow[1];
            CpCanvas.ata[n2].zoku = wana_flg;
            stop_time = CpCanvas.ata[n2].hit_time;
            stop_cnt = 1;
            stop_name = CpCanvas.tip[114 + CpCanvas.wana_flg].name;
            n2 = CpCanvas.AtaNo(0);
            ata[n2].Set(52, Rock.pos_x, Rock.pos_y, 0, 2);
            CpCanvas.ata[n2].hit_time = 1;
            wana_flg = 0;
            return;
        }
        if (stop_time != 0) {
            stop_time += 20;
            stop_cnt = 1;
            return;
        }
        for (n2 = 0; n2 < 6; ++n2) {
            oki[n2].Move();
        }
        for (n2 = 0; n2 < 30; ++n2) {
            if (CpCanvas.ata[n2].on == 0) continue;
            ata[n2].HitGo(-1);
        }
        for (n2 = 0; n2 < 30; ++n2) {
            if (CpCanvas.ata[n2].on == 0) continue;
            ata[n2].Move(1);
        }
        for (n2 = 0; n2 < 30; ++n2) {
            if (CpCanvas.ata[n2].on == 0) continue;
            ata[n2].HitGo(0);
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 3; ++n) {
                panel[n][n2].Move();
            }
        }
        for (n2 = 5; n2 > 2; --n2) {
            for (n = 0; n < 3; ++n) {
                panel[n][n2].Move();
            }
        }
        g.drawImage(imgMap, 0, 0);
        this.CharaDraw(1);
        CpCanvas.drawImg3(43, 0, 48, 40, false);
        if (cus_gage < 128) {
            g.setColor(Graphics.getColorOfRGB((int)198, (int)210, (int)234));
        } else {
            g.setColor(Graphics.getColorOfRGB((int)(game_cnt / 3 % 2 * 248), (int)248, (int)(game_cnt / 3 % 2 * 248)));
        }
        g.fillRect(56, 50, cus_gage, 6);
        rock.WanaDraw();
        rock.HpDraw(0, 0);
        if (combo_time > 0) {
            dell_lv = (combo - 1) * 2;
            CpCanvas.drawImg3(43, 39 + combo, 67, 65, false);
            CpCanvas.drawImg3(43, 43, 122, 65, false);
            if (--combo_time == 0) {
                combo = 1;
            }
        }
        g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
        g.fillRect(0, 0, 240, 40);
        g.fillRect(0, 200, 240, 40);
        rock.TipDraw();
        if (deba_flg != 0) {
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            CpCanvas.strDraw("set:" + teki_pt, 15, 15);
            CpCanvas.strDraw(this.deba_tip_id + " tip\u3010" + CpCanvas.tip[this.deba_tip_id].name + "\u3011", 15, 30);
            for (n2 = 0; n2 < ene_cnt; ++n2) {
                CpCanvas.strDraw(e_name[n2], 240 - f.stringWidth(e_name[n2]) - 5, 13 + n2 * 13);
            }
        }
        if (dell_cnt > 0) {
            if (combo > 1 && combo_time == 0) {
                combo_time = 15;
            }
            if (--dell_cnt != 10) return;
            CpCanvas.Audio(1, 5);
            audio_mill = System.currentTimeMillis();
            dell_cnt = -20;
            key = 0;
            return;
        }
        if ((cus_gage += cus_sp) > 128) {
            if (this.cus_se_flg == 0) {
                CpCanvas.seSet(11, 99);
                this.cus_se_flg = 1;
            }
            CpCanvas.soft_id[0] = 1;
            CpCanvas.soft_id[1] = 1;
            cus_gage = 128;
        }
        if (combo_cnt > 0) {
            --combo_cnt;
        } else if (combo > 1 && combo_time == 0) {
            combo_time = 15;
        } else if (combo_time == 0) {
            combo = 1;
        }
        ++eria_cnt;
        ++bas_cnt;
    }

    public void MotionBack() {
        int n;
        if (Rock.ani_cnt > 0) {
            Rock.ani_cnt = CpCanvas.rock.t_ani_cnt;
            Rock.s_wait = CpCanvas.rock.tmp_s_wait;
            Rock.r_suu = CpCanvas.rock.tmp_r_suu;
            Rock.e_wait = CpCanvas.rock.tmp_e_wait;
        }
        for (n = 0; n < 3; ++n) {
            if (CpCanvas.ene[n].on == 0 || CpCanvas.ene[n].ani_cnt <= 0) continue;
            CpCanvas.ene[n].ani_cnt = CpCanvas.ene[n].t_ani_cnt;
            CpCanvas.ene[n].s_wait = CpCanvas.ene[n].tmp_s_wait;
            CpCanvas.ene[n].r_suu = CpCanvas.ene[n].tmp_r_suu;
            CpCanvas.ene[n].e_wait = CpCanvas.ene[n].tmp_e_wait;
        }
        for (n = 0; n < 30; ++n) {
            if (CpCanvas.ata[n].on == 0) continue;
            CpCanvas.ata[n].ani_cnt = CpCanvas.ata[n].t_ani_cnt;
            CpCanvas.ata[n].s_wait = CpCanvas.ata[n].tmp_s_wait;
            CpCanvas.ata[n].r_suu = CpCanvas.ata[n].tmp_r_suu;
            CpCanvas.ata[n].e_wait = CpCanvas.ata[n].tmp_e_wait;
        }
    }

    public int BasLv() {
        int n;
        int n2 = 7;
        if (boss_flg == 0) {
            n2 = 7;
            if (bas_cnt / 300 >= 5) {
                --n2;
            }
            if (bas_cnt / 300 >= 12) {
                --n2;
            }
            if (bas_cnt / 300 >= 36) {
                --n2;
            }
        } else {
            n2 = 10;
            if (bas_cnt / 300 >= 30) {
                n2 -= 2;
            }
            if (bas_cnt / 300 >= 40) {
                n2 -= 2;
            }
            if (bas_cnt / 300 >= 50) {
                n2 -= 2;
            }
        }
        n2 = (n = Rock.noke_cnt) > 4 ? (n2 -= 3) : (n2 -= n - 1);
        if (Rock.move_cnt < 3) {
            ++n2;
        }
        return n2 += dell_lv;
    }

    public void Ann(int n, int n2) {
        if (n == 0) {
            if (n2 == 0) {
                BtPanel cfr_ignored_0 = panel[0][0];
                tmp_R = BtPanel.R;
                BtPanel cfr_ignored_1 = panel[0][0];
                tmp_G = BtPanel.G;
                BtPanel cfr_ignored_2 = panel[0][0];
                tmp_B = BtPanel.B;
            }
            BtPanel cfr_ignored_3 = panel[0][0];
            BtPanel cfr_ignored_4 = panel[0][0];
            BtPanel.R = BtPanel.R * 4 / 5;
            BtPanel cfr_ignored_5 = panel[0][0];
            BtPanel cfr_ignored_6 = panel[0][0];
            BtPanel.G = BtPanel.G * 4 / 5;
            BtPanel cfr_ignored_7 = panel[0][0];
            BtPanel cfr_ignored_8 = panel[0][0];
            BtPanel.B = BtPanel.B * 4 / 5;
        } else {
            BtPanel cfr_ignored_9 = panel[0][0];
            BtPanel cfr_ignored_10 = panel[0][0];
            BtPanel.R = BtPanel.R * 45 / 40;
            BtPanel cfr_ignored_11 = panel[0][0];
            if (BtPanel.R > 255) {
                BtPanel cfr_ignored_12 = panel[0][0];
                BtPanel.R = 255;
            }
            BtPanel cfr_ignored_13 = panel[0][0];
            BtPanel cfr_ignored_14 = panel[0][0];
            BtPanel.G = BtPanel.G * 45 / 40;
            BtPanel cfr_ignored_15 = panel[0][0];
            if (BtPanel.G > 255) {
                BtPanel cfr_ignored_16 = panel[0][0];
                BtPanel.G = 255;
            }
            BtPanel cfr_ignored_17 = panel[0][0];
            BtPanel cfr_ignored_18 = panel[0][0];
            BtPanel.B = BtPanel.B * 45 / 40;
            BtPanel cfr_ignored_19 = panel[0][0];
            if (BtPanel.B > 255) {
                BtPanel cfr_ignored_20 = panel[0][0];
                BtPanel.B = 255;
            }
            if (n2 == 0) {
                BtPanel cfr_ignored_21 = panel[0][0];
                BtPanel.R = tmp_R;
                BtPanel cfr_ignored_22 = panel[0][0];
                BtPanel.G = tmp_G;
                BtPanel cfr_ignored_23 = panel[0][0];
                BtPanel.B = tmp_B;
            }
        }
        BtPanel cfr_ignored_24 = panel[0][0];
        BtPanel cfr_ignored_25 = panel[0][0];
        BtPanel cfr_ignored_26 = panel[0][0];
        graMap.setColor(Graphics.getColorOfRGB((int)BtPanel.R, (int)BtPanel.G, (int)BtPanel.B));
        graMap.fillRect(0, 0, 240, 240);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 6; ++j) {
                panel[i][j].Draw(-1, true);
            }
        }
    }

    public void CharaDraw(int n) {
        int n2;
        int n3;
        for (n3 = 0; n3 < 3; ++n3) {
            for (n2 = 0; n2 < 6; ++n2) {
                panel[n3][n2].Draw2();
            }
        }
        for (n3 = 0; n3 < 3; ++n3) {
            for (n2 = 0; n2 < 4; ++n2) {
                if (n2 < 3) {
                    if (CpCanvas.ene[n2].on == 0 || CpCanvas.ene[n2].pos_y != n3) continue;
                    ene[n2].Draw(n);
                    continue;
                }
                if (Rock.pos_y != n3) continue;
                rock.Draw(n);
            }
            for (n2 = 0; n2 < 6; ++n2) {
                if (n3 != CpCanvas.oki[n2].pos_y) continue;
                oki[n2].Draw();
            }
            for (n2 = 0; n2 < 30; ++n2) {
                if (n3 != CpCanvas.ata[n2].pos_y) continue;
                ata[n2].Draw(1, n);
            }
        }
        for (n3 = 0; n3 < 30; ++n3) {
            ata[n3].Draw(2, n);
        }
        for (n3 = 0; n3 < 3; ++n3) {
            if (CpCanvas.ene[n3].on == 0) continue;
            ene[n3].HpDraw();
        }
        g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
        g.fillRect(0, 0, 240, 40);
    }

    public void BattleTip() {
        int n;
        int n2;
        CpCanvas.soft_id[0] = 0;
        CpCanvas.soft_id[1] = 0;
        g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
        g.fillRect(0, 200, 240, 40);
        if (esc_flg != 0) {
            if (esc_flg > 1) {
                g.drawImage(imgMap, 0, 40, 0, 40, 240, 160);
                this.CharaDraw(0);
            }
            g.fillRect(0, 160, 240, 80);
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            g.fillRect(2, 162, 236, 76);
            this.FaceDraw(6);
            n2 = CpCanvas.MesDraw(0);
            if (yes_no_flg != 0) {
                if (key == 65536) {
                    yes_no_flg = 1;
                    key = 0;
                }
                if (key == 262144) {
                    yes_no_flg = 2;
                    key = 0;
                }
            }
            if (key == 0x100000) {
                if (esc_flg == 1) {
                    if (n2 != 0) {
                        if (yes_no_flg == 0) {
                            esc_flg = 0;
                        }
                        if (yes_no_flg == 1) {
                            ++esc_flg;
                            CpCanvas.MesRead(122, null, 3);
                            Rock.tip_no = -1;
                            for (n = 0; n < 10; ++n) {
                                CpCanvas.cas_ok[n] = 1;
                            }
                        } else {
                            esc_flg = 0;
                            g.drawImage(imgMap, 0, 40, 0, 40, 240, 160);
                            this.CharaDraw(0);
                        }
                        yes_no_flg = 0;
                    } else {
                        mes_cnt = 90;
                    }
                } else if (esc_flg == 2) {
                    if (n2 != 0) {
                        if (this.EscCh()) {
                            CpCanvas.MesRead(123, null, 3);
                            esc_flg = 3;
                        } else {
                            CpCanvas.MesRead(124, null, 3);
                            esc_flg = 4;
                        }
                    }
                } else if (esc_flg == 3) {
                    if (n2 != 0) {
                        bas_flg = 0;
                        scene = back_menu;
                        if (back_menu == 3) {
                            CpCanvas.Audio(1, map_bgm);
                        } else {
                            CpCanvas.Audio(1, 3);
                            this.MachiSet(machi_no, 0);
                            ivent_flg = 0;
                        }
                        win_flg = 1;
                        if (ivent_flg < 0) {
                            now_hp = Rock.hp;
                        }
                        esc_flg = 0;
                        return;
                    }
                    mes_cnt = 90;
                } else if (esc_flg == 4) {
                    if (n2 != 0) {
                        cas_cnt = 15;
                        esc_flg = 0;
                    } else {
                        mes_cnt = 90;
                    }
                }
                key = 0;
            }
            if (esc_flg != 0) {
                return;
            }
        }
        if (pa_cnt2 > 0) {
            if (pa_cnt2 < 4) {
                this.Ann(0, pa_cnt2 - 1);
            }
            ++pa_cnt2;
            tmp_graMap.drawImage(imgMap, 0, 0);
            g.drawImage(tmp_imgMap, 0, 0);
            rock.HpDraw(0, 0);
            this.CharaDraw(0);
            CpCanvas.drawImg3(43, 0, 48, 40, false);
            CpCanvas.drawImg3(44, 124, 8, 65, false);
            if (pa_cnt2 < 45) {
                for (n2 = 0; n2 < sel_cnt && (pa_cnt2 - 10) / 5 > n2; ++n2) {
                    if (n2 >= pa_start && n2 < pa_start + pa_cnt) {
                        g.setColor(Graphics.getColorOfRGB((int)(128 + (game_cnt + 1) / 4 % 2 * 127), (int)(128 + game_cnt / 4 % 2 * 127), (int)(128 + (game_cnt + 1) / 4 % 2 * 127)));
                    } else {
                        g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                    }
                    CpCanvas.strDraw(this.ItemName(0, pa_tip[n2]), 20, 95 + n2 * 18);
                }
            } else {
                for (n2 = 0; n2 < sel_cnt; ++n2) {
                    g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                    if (n2 < pa_start) {
                        CpCanvas.strDraw(this.ItemName(0, pa_tip[n2]), 20, 95 + n2 * 18);
                        continue;
                    }
                    if (n2 >= pa_start && n2 < pa_start + pa_cnt) {
                        g.setColor(Graphics.getColorOfRGB((int)(128 + (game_cnt + 1) / 4 % 2 * 127), (int)(128 + game_cnt / 4 % 2 * 127), (int)(128 + (game_cnt + 1) / 4 % 2 * 127)));
                        CpCanvas.strDraw(CpCanvas.tip[CpCanvas.pa_no].name, 20, 95 + pa_start * 18);
                        continue;
                    }
                    CpCanvas.strDraw(this.ItemName(0, pa_tip[n2]), 20, 95 + (n2 - pa_cnt + 1) * 18);
                }
            }
            rock.WanaDraw();
            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
            g.fillRect(0, 0, 240, 40);
            g.fillRect(0, 200, 240, 40);
            if (pa_cnt2 >= 60) {
                this.Ann(1, 64 - pa_cnt2);
                if (pa_cnt2 == 64) {
                    pa_cnt2 = 0;
                    key = 0;
                }
            }
            key = 0;
            return;
        }
        if (ren_flg > 0 && bas_cnt == 0) {
            g.drawImage(imgMap, 0, 40, 0, 40, 240, 160);
            this.CharaDraw(0);
            CpCanvas.drawImg3(43, 0, 48, 40, false);
            rock.HpDraw(0, 0);
            int[] nArray = new int[]{4, 9, 16, 18, 16, 16, 16, 16, 16, 16, 16, 16, 16, 9, 4};
            g.drawScaledImage((Image)image[43], 44, 104 + (16 - nArray[cas_cnt]) / 2, 68, nArray[cas_cnt], 120, 0, 68, 16);
            g.drawScaledImage((Image)image[43], 112, 104 + (16 - nArray[cas_cnt]) / 2, 8, nArray[cas_cnt], 170, 16, 8, 16);
            g.drawScaledImage((Image)image[43], 120, 104 + (16 - nArray[cas_cnt]) / 2, 8, nArray[cas_cnt], 170, 16, 8, 16);
            g.drawScaledImage((Image)image[43], 128, 104 + (16 - nArray[cas_cnt]) / 2, 68, nArray[cas_cnt], 120, 16, 68, 16);
            g.drawScaledImage((Image)image[43], 120 + dx[43][45 + ren_flg % 10], 104 + dy[43][45 + ren_flg % 10] + (16 - nArray[cas_cnt]) / 2, sx[43][45 + ren_flg % 10], nArray[cas_cnt], gx[43][45 + ren_flg % 10], gy[43][45 + ren_flg % 10], sx[43][45 + ren_flg % 10], sy[43][45 + ren_flg % 10]);
            g.drawScaledImage((Image)image[43], 112 + dx[43][45 + ren_flg / 10], 104 + dy[43][45 + ren_flg / 10] + (16 - nArray[cas_cnt]) / 2, sx[43][45 + ren_flg / 10], nArray[cas_cnt] * (ren_flg / 10), gx[43][45 + ren_flg / 10], gy[43][45 + ren_flg / 10], sx[43][45 + ren_flg / 10], sy[43][45 + ren_flg / 10]);
            if (++cas_cnt == 14) {
                bas_cnt = 1;
                cus_gage = 0;
                cas_cnt = -3;
                this.cus_se_flg = 0;
                key = 0;
            }
        } else if (cas_cnt < 0) {
            int n3 = cas_tip[sel_cas_tip];
            if (n3 > 0) {
                n3 = tip_list[n3] >> 8 & 0xFF;
                CpCanvas.MesRead(CpCanvas.tip[n3].setu_id, null, 4);
            }
            g.drawImage(imgMap, 0, 40, 0, 40, 240, 160);
            this.CharaDraw(0);
            CpCanvas.drawImg3(43, 2, cas_cnt * 40, 40, false);
            rock.HpDraw(120 + cas_cnt * 40, 0);
            ++cas_cnt;
            key = 0;
        } else if (cas_cnt > 0) {
            g.drawImage(imgMap, 0, 40, 0, 40, 240, 160);
            this.CharaDraw(0);
            CpCanvas.drawImg3(43, 0, 48, 40, false);
            rock.HpDraw(0, 0);
            int[] nArray = new int[]{4, 9, 16, 18, 16, 16, 16, 16, 16, 16, 16, 16, 16, 9, 4};
            g.drawScaledImage((Image)image[43], 52, 104 + (16 - nArray[15 - cas_cnt]) / 2, 68, nArray[15 - cas_cnt], 120, 0, 68, 16);
            g.drawScaledImage((Image)image[43], 120, 104 + (16 - nArray[15 - cas_cnt]) / 2, 68, nArray[15 - cas_cnt], 120, 16, 68, 16);
            if (--cas_cnt == 0) {
                --scene;
                cus_gage = 0;
                this.cus_se_flg = 0;
                key = 0;
            }
        } else {
            int n4;
            int n5;
            CpCanvas.soft_id[0] = 2;
            CpCanvas.soft_id[1] = 3;
            if (key == 65536) {
                if (sel_cas_mode == 0) {
                    if (sel_cas_tip % 5 == 0) {
                        sel_cas_mode = 1;
                    } else {
                        --sel_cas_tip;
                    }
                } else {
                    if (max_sel != 0) {
                        sel_cas_mode = 0;
                    }
                    if ((sel_cas_tip = 4) >= max_sel - 1) {
                        sel_cas_tip = max_sel - 1;
                    }
                }
                key = 0;
            } else if (key == 262144) {
                if (sel_cas_mode == 0) {
                    if (max_sel - 1 == sel_cas_tip || sel_cas_tip == 4) {
                        sel_cas_mode = 1;
                    } else {
                        ++sel_cas_tip;
                    }
                } else {
                    if (max_sel != 0) {
                        sel_cas_mode = 0;
                    }
                    sel_cas_tip = 0;
                }
                key = 0;
            } else if (key == 131072) {
                if (sel_cas_mode == 0) {
                    if (sel_cas_tip > 4) {
                        sel_cas_tip -= 5;
                    }
                } else {
                    sel_cas_mode = 1;
                }
                key = 0;
            } else if (key == 524288) {
                if (sel_cas_mode == 0) {
                    if (sel_cas_tip + 5 < max_sel) {
                        sel_cas_tip += 5;
                    }
                } else if (sec_cha != 0 || sel_cnt > 0) {
                    sel_cas_mode = 2;
                }
                key = 0;
            }
            CpCanvas.drawImg3(43, 2, 0, 40, false);
            if (sec_cha != 0 && sel_cnt == 0) {
                CpCanvas.drawImg3(43, 61, 90, 179, false);
            }
            rock.HpDraw(120, 0);
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            g.fillRect(2, 202, 236, 36);
            if (bas_cnt < 2) {
                if (deba_flg != 0) {
                    if (key == 1) {
                        n2 = scene;
                        this.BtSet(++teki_pt);
                        scene = n2;
                        key = 0;
                    }
                    g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
                    g.fillRect(0, 0, 240, 40);
                    g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                    CpCanvas.strDraw("set:" + teki_pt, 15, 15);
                }
                for (n2 = 0; n2 < ene_cnt; ++n2) {
                    CpCanvas.strDraw(e_name[n2], 240 - f.stringWidth(e_name[n2]) - 5, 13 + n2 * 13);
                }
            }
            this.CasOk();
            for (n2 = 0; n2 < 10; ++n2) {
                n5 = cas_tip[n2];
                if (n5 < 0) continue;
                n4 = tip_list[n5] & 0xFF;
                if (n4 < 100) {
                    CpCanvas.drawImg3(43, 3 + n4, 12 + n2 % 5 * 16, 106 + n2 / 5 * 24 + 55, false);
                } else {
                    CpCanvas.drawImg3(43, 3, 13 + n2 % 5 * 16, 106 + n2 / 5 * 24 + 55, false);
                }
                if (cas_ok[n2] == 0) continue;
                n = 0;
                n = this.CasCh(n5) ? 1 : 0;
                CpCanvas.cas_ok[n2] = n == 0 ? 2 : 1;
                tip[tip_list[n5] >> 8 & 0xFF].Draw(9 + n2 % 5 * 16, 106 + n2 / 5 * 24 + 40, 2, n != 0);
            }
            for (n2 = 0; n2 < sel_cnt; ++n2) {
                n5 = cas_tip[set_tip[n2]];
                tip[tip_list[n5] >> 8 & 0xFF].Draw(97, 71 + n2 * 16, 2, true);
            }
            if (CpCanvas.fol[CpCanvas.now_fol].regu_flg != 0 && cas_tip[0] == CpCanvas.fol[CpCanvas.now_fol].tip_id[CpCanvas.fol[CpCanvas.now_fol].regu_id] && bas_cnt == 0) {
                CpCanvas.drawImg3(43, 44, 3, 143, false);
            }
            g.setColor(Graphics.getColorOfRGB((int)255, (int)(208 * (game_cnt / 3 % 2)), (int)0));
            if (sel_cas_mode == 0) {
                int n6 = sel_cas_tip % 5;
                int n7 = sel_cas_tip / 5;
                g.drawRect(7 + n6 * 16, 144 + n7 * 24, 15, 15);
                g.drawRect(8 + n6 * 16, 145 + n7 * 24, 13, 13);
                if (cas_tip[sel_cas_tip] > 0) {
                    n5 = tip_list[cas_tip[sel_cas_tip]] >> 8 & 0xFF;
                    n4 = tip_list[cas_tip[sel_cas_tip]] & 0xFF;
                    g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
                    CpCanvas.strDraw(CpCanvas.tip[n5].name, 2, 62);
                    tip[n5].DrawPow2(20, 79);
                    tip[n5].DrawCode(n4, 61, 90, 1);
                    tip[n5].DrawZoku(58, 96);
                    CpCanvas.drawImg3(44, 65 + n5 / 125 + n5 / 177, 34, 126, false);
                    CpCanvas.MesRead(CpCanvas.tip[n5].setu_id, null, 4);
                    CpCanvas.MesDraw2(2, 40, 217, 0);
                }
            } else if (sel_cas_mode == 1) {
                g.drawRect(90, 158, 21, 19);
                g.drawRect(89, 157, 23, 21);
                CpCanvas.MesRead(157, null, 3);
                CpCanvas.MesDraw2(2, 40, 217, 0);
            } else {
                g.drawRect(90, 179, 20, 12);
                g.drawRect(89, 178, 22, 14);
                if (sec_cha != 0 && sel_cnt == 0) {
                    CpCanvas.MesRead(159, null, 3);
                } else {
                    CpCanvas.MesRead(158, null, 3);
                }
                CpCanvas.MesDraw2(2, 40, 217, 0);
            }
            if (key == 0x200000) {
                if (sel_cnt > 0 && sel_cas_mode != 2) {
                    CpCanvas.cas_ok[CpCanvas.set_tip[--CpCanvas.sel_cnt]] = 1;
                    CpCanvas.set_tip[CpCanvas.sel_cnt] = -1;
                    if (sel_cnt == 0) {
                        for (n2 = 0; n2 < 10; ++n2) {
                            CpCanvas.cas_ok[n2] = 1;
                        }
                    }
                }
                key = 0;
            } else if (key == 0x100000) {
                if (sel_cas_mode == 0) {
                    if (sel_cnt < 5 && cas_ok[sel_cas_tip] == 1) {
                        CpCanvas.set_tip[CpCanvas.sel_cnt] = sel_cas_tip;
                        CpCanvas.cas_ok[CpCanvas.sel_cas_tip] = 0;
                        ++sel_cnt;
                        CpCanvas.Audio(1, 11);
                    } else {
                        CpCanvas.Audio(1, 12);
                    }
                } else {
                    CpCanvas.Audio(1, 11);
                    if (sel_cas_mode == 1) {
                        this.TipIn();
                    } else if (sel_cas_mode == 2) {
                        if (sec_cha != 0 && sel_cnt == 0) {
                            for (n2 = 0; n2 < max_sel; ++n2) {
                                if (cas_ok[n2] == 0) continue;
                                CpCanvas.fol[CpCanvas.now_fol].used[CpCanvas.fol_tip_no[n2]] = 0;
                                ++CpCanvas.fol[CpCanvas.now_fol].tip_zan;
                                CpCanvas.cas_tip[n2] = -1;
                            }
                            n2 = sel_cnt;
                            fol[now_fol].RandSet(max_sel);
                            cas_cnt = 0;
                            sel_cnt = n2;
                            sel_cas_mode = 1;
                            sec_cha = 0;
                            key = 0;
                            return;
                        }
                        for (n2 = 0; n2 < sel_cnt; ++n2) {
                            CpCanvas.cas_tip[CpCanvas.set_tip[n2]] = -1;
                        }
                        Rock.tip_no = -1;
                        if ((max_sel += sel_cnt) > 9) {
                            max_sel = 10;
                        }
                    }
                    for (n2 = 0; n2 < 10; ++n2) {
                        if (cas_tip[n2] >= 0) continue;
                        for (n = n2 + 1; n < 10; ++n) {
                            if (cas_tip[n] < 0) continue;
                            CpCanvas.cas_tip[n2] = cas_tip[n];
                            CpCanvas.cas_ok[n2] = 1;
                            CpCanvas.cas_tip[n] = -1;
                            CpCanvas.cas_ok[n] = 0;
                            n += 10;
                        }
                    }
                    cas_cnt = 15;
                    sec_cha = 0;
                }
                key = 0;
            } else if (key == 0x400000) {
                esc_flg = 1;
                if (non_esc == 0) {
                    CpCanvas.MesRead(121, null, 3);
                    yes_no_flg = 2;
                } else {
                    CpCanvas.MesRead(152, null, 3);
                }
                key = 0;
            }
        }
    }

    public boolean EscCh() {
        int n = 1;
        int n2 = (rand.nextInt() >>> 1) % 100;
        for (i = 0; i < 3; ++i) {
            if (CpCanvas.ene[CpCanvas.i].on == 0) continue;
            n += CpCanvas.ene[CpCanvas.i].hp;
        }
        return (n = max_hp * 30 / n) > n2;
    }

    public void CasOk() {
        int n;
        if (sel_cnt == 0) {
            ok_code = 0;
            ok_tip = 0;
            return;
        }
        ok_tip = tip_list[cas_tip[set_tip[0]]] >> 8 & 0xFF;
        for (n = 0; n < sel_cnt && (ok_code = tip_list[cas_tip[set_tip[n]]] & 0xFF) == 100; ++n) {
        }
        n = 1;
        for (int i = 1; i < sel_cnt; ++i) {
            int n2 = tip_list[cas_tip[set_tip[i]]] & 0xFF;
            int n3 = tip_list[cas_tip[set_tip[i]]] >> 8 & 0xFF;
            if (n2 == 100) {
                ++n;
            }
            if (n2 != 100 && n2 != ok_code) {
                ok_code = -1;
            }
            if (n3 == ok_tip) continue;
            ok_tip = -1;
        }
        if (ok_code == 100 && n == sel_cnt) {
            ok_code = 0;
        }
    }

    public boolean CasCh(int n) {
        if (ok_tip == 0 || ok_code == 0) {
            return true;
        }
        int n2 = tip_list[n] & 0xFF;
        int n3 = tip_list[n] >> 8 & 0xFF;
        if (ok_tip == n3) {
            return true;
        }
        return ok_code > 0 && n2 == 100 || ok_code == n2;
    }

    public void TipIn() {
        int n;
        int n2;
        if (sel_cnt == 0) {
            return;
        }
        pa_no = this.PACh();
        for (n2 = 0; n2 < sel_cnt; ++n2) {
            CpCanvas.pa_tip[n2] = cas_tip[set_tip[n2]];
            n = tip_list[pa_tip[n2]] >> 8 & 0xFF;
            if (pa_no < 0) {
                CpCanvas.rock.tip[CpCanvas.sel_cnt - n2 - 1] = tip[n];
            }
            CpCanvas.cas_tip[CpCanvas.set_tip[n2]] = -1;
            if (set_tip[n2] != 0) continue;
            regu_flg = 0;
        }
        Rock.tip_no = sel_cnt - 1;
        if (pa_no > 0) {
            n2 = pa_no;
            CpCanvas.AddLib(n2);
            for (int i = 0; i < sel_cnt; ++i) {
                n = tip_list[pa_tip[i]] >> 8 & 0xFF;
                if (i < pa_start) {
                    CpCanvas.rock.tip[CpCanvas.sel_cnt - i - CpCanvas.pa_cnt] = tip[n];
                    continue;
                }
                if (i >= pa_start && i < pa_start + pa_cnt) {
                    CpCanvas.rock.tip[CpCanvas.sel_cnt - CpCanvas.pa_start - CpCanvas.pa_cnt] = tip[pa_no];
                    continue;
                }
                CpCanvas.rock.tip[CpCanvas.sel_cnt - i - 1] = tip[n];
            }
            Rock.tip_no -= pa_cnt - 1;
            pa_cnt2 = 1;
        }
        rock.TipNext();
    }

    public int PACh() {
        if (sel_cnt < 3) {
            return -1;
        }
        int n = -1;
        int n2 = 0;
        for (int i = 0; i < sel_cnt; ++i) {
            int n3 = cas_tip[set_tip[i]];
            int n4 = tip_list[n3] >> 8 & 0xFF;
            int n5 = tip_list[n3] & 0xFF;
            for (int j = 0; j < 34; ++j) {
                pa_code_flg = 0;
                n = this.PaNo(n4, n5, j, 0);
                if (n < 0) continue;
                pa_start = i;
                for (n2 = 1; n2 < 4; ++n2) {
                    if (n2 == 3 && pa_data[n][3] == 0) {
                        n2 = 4;
                        pa_cnt = 3;
                        CpCanvas.pa_tip[3] = 0;
                        break;
                    }
                    if (i + n2 < sel_cnt) {
                        int n6 = cas_tip[set_tip[i + n2]];
                        int n7 = tip_list[n6] >> 8 & 0xFF;
                        int n8 = tip_list[n6] & 0xFF;
                        if (this.PaNo(n7, n8, n, n2) != n) {
                            n = -1;
                            break;
                        }
                    } else {
                        pa_cnt = -1;
                        break;
                    }
                    pa_cnt = 4;
                }
                if (n2 != 4) continue;
                return pa_data[n][8];
            }
        }
        return -1;
    }

    public int PaNo(int n, int n2, int n3, int n4) {
        if (pa_data[n3][n4] == 0) {
            return n3;
        }
        if (pa_data[n3][n4] == n) {
            if (pa_data[n3][n4 + 4] == 0) {
                return n3;
            }
            if (pa_data[n3][n4 + 4] == n2) {
                return n3;
            }
            if (n2 == 100 && pa_code_flg == 0) {
                pa_code_flg = 1;
                return n3;
            }
        }
        return -1;
    }

    public void MldSet() {
        InputStream inputStream = null;
        int[] nArray = new int[16];
        try {
            inputStream = CpCanvas.JarGet(5);
            byte[] byArray = new byte[4];
            for (int i = 0; i < 64; i += 4) {
                inputStream.read(byArray);
                nArray[i / 4] = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
            }
            MediaSound[] mediaSoundArray = new MediaSound[16];
            for (i = 0; i < 16; ++i) {
                byte[] byArray2 = new byte[nArray[i]];
                inputStream.read(byArray2, 0, nArray[i]);
                System.gc();
                CpCanvas.audio[CpCanvas.i] = i < 11 ? AudioPresenter.getAudioPresenter((int)0) : AudioPresenter.getAudioPresenter((int)1);
                mediaSoundArray[CpCanvas.i] = MediaManager.getSound((byte[])byArray2);
                try {
                    mediaSoundArray[i].use();
                }
                catch (Exception exception) {
                    // empty catch block
                }
                audio[i].setSound(mediaSoundArray[i]);
                audio[i].setAttribute(4, (3 - audio_flg) * 100 / 3);
                System.gc();
                this.DrawBar(2, (i + 1) * 35 / 16);
            }
            inputStream.close();
            inputStream = null;
            System.gc();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void ImgSet2(int n) {
        InputStream inputStream = null;
        byte[] byArray = new byte[4];
        try {
            int n2;
            inputStream = CpCanvas.JarGet(3);
            if (img_siz3[0] == 0) {
                for (n2 = 0; n2 < 88; n2 += 4) {
                    inputStream.read(byArray);
                    CpCanvas.img_siz3[n2 / 4] = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                }
            } else {
                inputStream.skip(88L);
            }
            n2 = 0;
            for (int i = 0; i < n; ++i) {
                n2 += img_siz3[i];
            }
            inputStream.skip(n2);
            try {
                byte[] byArray2 = new byte[img_siz3[n]];
                x = inputStream.read(byArray2);
                CpCanvas.image[58] = PalettedImage.createPalettedImage((byte[])byArray2);
                inputStream.close();
                inputStream = null;
                System.gc();
            }
            catch (Exception exception) {}
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static void PalSet(int n, int n2) {
        InputStream inputStream = null;
        try {
            int n3;
            inputStream = CpCanvas.JarGet(4);
            if (p_siz[0] == 0) {
                byte[] byArray = new byte[4];
                for (n3 = 0; n3 < 392; n3 += 4) {
                    inputStream.read(byArray);
                    CpCanvas.p_siz[n3 / 4] = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                }
            } else {
                inputStream.skip(392L);
            }
            int n4 = 0;
            for (n3 = 0; n3 < n2; ++n3) {
                n4 += p_siz[n3];
            }
            inputStream.skip(n4);
            CpCanvas.pal[n2] = image[n].getPalette();
            byte[] byArray = new byte[3];
            for (int i = 0; i < p_siz[n2] / 3; ++i) {
                inputStream.read(byArray);
                int n5 = byArray[0] & 0xFF;
                int n6 = byArray[1] & 0xFF;
                int n7 = byArray[2] & 0xFF;
                pal[n2].setEntry(i, Graphics.getColorOfRGB((int)n5, (int)n6, (int)n7));
            }
            inputStream.close();
            inputStream = null;
            System.gc();
            image[n].setPalette(pal[n2]);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    /*
     * Unable to fully structure code
     */
    public void ImgSet() {
        var1_1 = null;
        var2_2 = new int[58];
        var3_3 = new int[56];
        var4_4 = new byte[4];
        var5_5 = new int[37];
        var5_5[0] = 3544;
        for (var6_6 = 1; var6_6 < 37; ++var6_6) {
            var5_5[var6_6] = var5_5[var6_6 - 1] + CpCanvas.dat[var6_6 - 1];
            this.DrawBar(0, (var6_6 + 1) * 10 / 37);
        }
        try {
            var1_1 = CpCanvas.JarGet(1);
            for (var6_6 = 0; var6_6 < 168; var6_6 += 4) {
                var1_1.read(var4_4);
                var2_2[var6_6 / 4] = (var4_4[0] & 255) << 24 | (var4_4[1] & 255) << 16 | (var4_4[2] & 255) << 8 | var4_4[3] & 255;
            }
lbl18:
            // 3 sources

            try {
                for (var7_14 = 0; var7_14 < 42; ++var7_14) {
                    block21: {
                        var8_15 = new byte[var2_2[var7_14]];
                        CpCanvas.x = var1_1.read(var8_15);
                        CpCanvas.image[var7_14] = PalettedImage.createPalettedImage((byte[])var8_15);
                        this.DrawBar(0, 10 + (var7_14 + 1) * 90 / 42);
                        System.gc();
                        if (var7_14 != 0) break block21;
                        for (var9_17 = 0; var9_17 < 5; ++var9_17) {
                            CpCanvas.pal[var9_17] = CpCanvas.image[var7_14].getPalette();
                        }
                        ** GOTO lbl18
                    }
                    if (var7_14 >= 22) continue;
                    for (var9_17 = 0; var9_17 < 4; ++var9_17) {
                        CpCanvas.pal[var9_17 * 4 + 5] = CpCanvas.image[var7_14].getPalette();
                    }
                    ** GOTO lbl18
                }
                var1_1.close();
                var1_1 = null;
                System.gc();
            }
            catch (Exception var6_7) {
                // empty catch block
            }
            var1_1 = CpCanvas.JarGet(2);
            for (var6_8 = 168; var6_8 < 232; var6_8 += 4) {
                var1_1.read(var4_4);
                var2_2[var6_8 / 4] = (var4_4[0] & 255) << 24 | (var4_4[1] & 255) << 16 | (var4_4[2] & 255) << 8 | var4_4[3] & 255;
            }
            try {
                for (var7_14 = 42; var7_14 < 57; ++var7_14) {
                    var8_15 = new byte[var2_2[var7_14]];
                    CpCanvas.x = var1_1.read(var8_15);
                    CpCanvas.image[var7_14] = PalettedImage.createPalettedImage((byte[])var8_15);
                    this.DrawBar(1, (var7_14 + 1 - 42) * 70 / 15);
                    System.gc();
                    if (var7_14 <= 49 || var7_14 == 56) continue;
                    CpCanvas.pal[var7_14 + 40] = CpCanvas.image[var7_14].getPalette();
                    CpCanvas.PalSet(var7_14, var7_14 + 40);
                }
                var1_1.close();
                var1_1 = null;
                System.gc();
            }
            catch (Exception var6_9) {
                // empty catch block
            }
            var1_1 = CpCanvas.JarGet(0);
            for (var6_10 = 0; var6_10 < 224; var6_10 += 4) {
                var1_1.read(var4_4);
                var3_3[var6_10 / 4] = (var4_4[0] & 255) << 24 | (var4_4[1] & 255) << 16 | (var4_4[2] & 255) << 8 | var4_4[3] & 255;
            }
        }
        catch (Exception var6_11) {
            // empty catch block
        }
        System.gc();
        try {
            for (var6_12 = 0; var6_12 < 56; ++var6_12) {
                this.DrawBar(1, 70 + (var6_12 + 1) * 30 / 56);
                CpCanvas.x = 0 + var6_12 * 10;
                System.gc();
                var1_1.read(var4_4);
                var7_14 = (var4_4[0] & 255) << 24 | (var4_4[1] & 255) << 16 | (var4_4[2] & 255) << 8 | var4_4[3] & 255;
                CpCanvas.gx[var6_12] = new int[var7_14];
                CpCanvas.gy[var6_12] = new int[var7_14];
                CpCanvas.sx[var6_12] = new int[var7_14];
                CpCanvas.sy[var6_12] = new int[var7_14];
                CpCanvas.dx[var6_12] = new int[var7_14];
                CpCanvas.dy[var6_12] = new int[var7_14];
                for (var8_16 = 0; var8_16 < var7_14; ++var8_16) {
                    var1_1.read(var4_4);
                    CpCanvas.gx[var6_12][var8_16] = (var4_4[0] & 255) << 24 | (var4_4[1] & 255) << 16 | (var4_4[2] & 255) << 8 | var4_4[3] & 255;
                    var1_1.read(var4_4);
                    CpCanvas.gy[var6_12][var8_16] = (var4_4[0] & 255) << 24 | (var4_4[1] & 255) << 16 | (var4_4[2] & 255) << 8 | var4_4[3] & 255;
                    var1_1.read(var4_4);
                    CpCanvas.sx[var6_12][var8_16] = (var4_4[0] & 255) << 24 | (var4_4[1] & 255) << 16 | (var4_4[2] & 255) << 8 | var4_4[3] & 255;
                    var1_1.read(var4_4);
                    CpCanvas.sy[var6_12][var8_16] = (var4_4[0] & 255) << 24 | (var4_4[1] & 255) << 16 | (var4_4[2] & 255) << 8 | var4_4[3] & 255;
                    var1_1.read(var4_4);
                    CpCanvas.dx[var6_12][var8_16] = (var4_4[0] & 255) << 24 | (var4_4[1] & 255) << 16 | (var4_4[2] & 255) << 8 | var4_4[3] & 255;
                    var1_1.read(var4_4);
                    CpCanvas.dy[var6_12][var8_16] = (var4_4[0] & 255) << 24 | (var4_4[1] & 255) << 16 | (var4_4[2] & 255) << 8 | var4_4[3] & 255;
                }
                if (var6_12 < 42) {
                    var8_16 = 0;
                    var9_17 = 0;
                    var10_18 = false;
                    var1_1.read(var4_4);
                    var11_19 = (var4_4[0] & 255) << 24 | (var4_4[1] & 255) << 16 | (var4_4[2] & 255) << 8 | var4_4[3] & 255;
                    CpCanvas.ani[var6_12] = new int[var11_19][1];
                    CpCanvas.a_dx[var6_12] = new int[var11_19][1];
                    CpCanvas.a_dy[var6_12] = new int[var11_19][1];
                    for (var12_20 = 0; var12_20 < var11_19; ++var12_20) {
                        var1_1.read(var4_4);
                        var9_17 = (var4_4[0] & 255) << 24 | (var4_4[1] & 255) << 16 | (var4_4[2] & 255) << 8 | var4_4[3] & 255;
                        CpCanvas.ani[var6_12][var12_20] = new int[var9_17 + 2];
                        CpCanvas.a_dx[var6_12][var12_20] = new int[var9_17 + 2];
                        CpCanvas.a_dy[var6_12][var12_20] = new int[var9_17 + 2];
                        for (var13_21 = 0; var13_21 < var9_17; ++var13_21) {
                            var1_1.read(var4_4);
                            CpCanvas.ani[var6_12][var12_20][var13_21] = (var4_4[0] & 255) << 24 | (var4_4[1] & 255) << 16 | (var4_4[2] & 255) << 8 | var4_4[3] & 255;
                            var1_1.read(var4_4);
                            CpCanvas.a_dx[var6_12][var12_20][var13_21] = (var4_4[0] & 255) << 24 | (var4_4[1] & 255) << 16 | (var4_4[2] & 255) << 8 | var4_4[3] & 255;
                            var1_1.read(var4_4);
                            CpCanvas.a_dy[var6_12][var12_20][var13_21] = (var4_4[0] & 255) << 24 | (var4_4[1] & 255) << 16 | (var4_4[2] & 255) << 8 | var4_4[3] & 255;
                            CpCanvas.ani[var6_12][var12_20][var13_21 + 1] = -2;
                        }
                    }
                }
                CpCanvas.x = 3 + var6_12 * 10;
            }
            var1_1.close();
            var1_1 = null;
            System.gc();
        }
        catch (Exception var6_13) {
            // empty catch block
        }
        this.ImgSet2(0);
    }

    public static InputStream JarGet(int n) {
        int n2;
        InputStream inputStream = null;
        JarInflater jarInflater = null;
        int[] nArray = new int[37];
        nArray[0] = 3544;
        for (n2 = 1; n2 < 37; ++n2) {
            nArray[n2] = nArray[n2 - 1] + dat[n2 - 1];
        }
        n2 = 1;
        int[] nArray2 = new int[]{0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0};
        if (nArray2[n] != 0) {
            n2 = 0;
        }
        try {
            inputStream = Connector.openInputStream((String)("scratchpad:///0;pos=" + nArray[n] + ",length=" + dat[n]));
            System.gc();
            if (n2 != 0) {
                jarInflater = new JarInflater(inputStream);
                System.gc();
                inputStream.close();
                inputStream = null;
                System.gc();
                inputStream = jarInflater.getInputStream("data.dat");
                jarInflater.close();
                jarInflater = null;
                System.gc();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return inputStream;
    }

    public static int Ani(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        int n9 = a_dx[n][n2][n3] + n6;
        int n10 = a_dy[n][n2][n3] + n7;
        if ((n2 = ani[n][n2][n3]) < 0) {
            return n2;
        }
        n5 *= 24;
        CpCanvas.drawImg2(n, n2, n4 *= 40, n5 += 105, n9, n10, n8);
        return n2;
    }

    public static int AniSe(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        int n11 = a_dx[n][n2][n3] + n6;
        int n12 = a_dy[n][n2][n3] + n7;
        if ((n2 = ani[n][n2][n3]) < 0) {
            return n2;
        }
        n5 *= 24;
        CpCanvas.drawImg2(n, n2, n4 *= 40, n5 += 105, n11, n12, n8);
        if (n10 == 0 && n9 > 0) {
            CpCanvas.seSet(n9 -= 10, 0);
        }
        return n2;
    }

    public static int Ani(int n, int n2, int n3, int n4, int n5) {
        int n6 = 0;
        if (n2 == 2) {
            n6 = 1;
        }
        if ((n2 = ani[n][n2][n3]) < 0) {
            return n2;
        }
        CpCanvas.drawImg2(n, n2, n4 += 0, n5 += 0, n6);
        return n2;
    }

    public static void drawImg2(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        if (n7 == 1) {
            g.setFlipMode(n7);
            n3 = n3 - dx[n][n2] * 2 - n5 * 2 - sx[n][n2] + 40;
        }
        g.drawImage((Image)image[n], n3 + dx[n][n2] + n5, n4 + dy[n][n2] + n6, gx[n][n2], gy[n][n2], sx[n][n2], sy[n][n2]);
        if (n7 != 0) {
            g.setFlipMode(0);
        }
    }

    public static void drawImg2(int n, int n2, int n3, int n4, int n5) {
        if (n5 == 1) {
            g.setFlipMode(n5);
            n3 = n3 - dx[n][n2] * 2 - sx[n][n2] + 20;
        }
        g.drawImage((Image)image[n], n3 + dx[n][n2], n4 + dy[n][n2], gx[n][n2], gy[n][n2], sx[n][n2], sy[n][n2]);
        if (n5 != 0) {
            g.setFlipMode(0);
        }
    }

    public static void drawImg3(int n, int n2, int n3, int n4, boolean bl) {
        if (bl) {
            graMap.drawImage((Image)image[n], n3 + dx[n][n2], n4 + dy[n][n2], gx[n][n2], gy[n][n2], sx[n][n2], sy[n][n2]);
        } else {
            g.drawImage((Image)image[n], n3 + dx[n][n2], n4 + dy[n][n2], gx[n][n2], gy[n][n2], sx[n][n2], sy[n][n2]);
        }
    }

    public static void drawImg4(int n, int n2, int n3, int n4) {
        tmp_graMap.drawImage((Image)image[n], n3, n4, gx[n][n2], gy[n][n2], sx[n][n2], sy[n][n2]);
    }

    public void BtSet(int n) {
        int n2;
        int n3;
        int[] nArray = new int[18];
        int[] nArray2 = new int[12];
        ghost = -1;
        cus_sp = 1;
        ene_cnt = 0;
        dell_cnt = 0;
        bas_cnt = 0;
        rika_cnt = 0;
        over_cnt = 0;
        combo = 1;
        combo_cnt = 0;
        combo_time = 0;
        CpCanvas.bt_get[0] = 0;
        CpCanvas.bt_get[1] = 0;
        CpCanvas.bt_get[2] = 0;
        eria_cnt = 0;
        dell_lv = 0;
        sec_cha = skill_kouka[15];
        ata_cnt = 0;
        non_esc = 0;
        boss_flg = 0;
        try {
            int n4;
            byte[] byArray = new byte[4];
            if (rank_flg == 0) {
                InputStream inputStream = CpCanvas.JarGet(31);
                inputStream.skip(n * 4 * 4);
                inputStream.read(byArray);
                int n5 = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                for (n3 = 0; n3 < 3; ++n3) {
                    inputStream.read(byArray);
                    n4 = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                    nArray2[n3 * 4 + 0] = n4 & 3;
                    nArray2[n3 * 4 + 1] = n4 >> 2 & 0x3F;
                    nArray2[n3 * 4 + 2] = n4 >> 8 & 0xF;
                    nArray2[n3 * 4 + 3] = n4 >> 12 & 0xF;
                    if (nArray2[n3 * 4 + 3] != 0) continue;
                    nArray2[n3 * 4 + 3] = 10;
                }
                inputStream.close();
                inputStream = null;
                System.gc();
                inputStream = CpCanvas.JarGet(32);
                inputStream.skip(n5 * 4 * 3);
                for (n3 = 0; n3 < 3; ++n3) {
                    inputStream.read(byArray);
                    n4 = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                    nArray[n3 * 6 + 5] = n4 & 0xF;
                    nArray[n3 * 6 + 4] = n4 >> 4 & 0xF;
                    nArray[n3 * 6 + 3] = n4 >> 8 & 0xF;
                    nArray[n3 * 6 + 2] = n4 >> 12 & 0xF;
                    nArray[n3 * 6 + 1] = n4 >> 16 & 0xF;
                    nArray[n3 * 6 + 0] = n4 >> 20 & 0xF;
                }
                inputStream.close();
                inputStream = null;
                System.gc();
                if (ren_flg == 0) {
                    if (n == 292 || n == 293 || n > 295) {
                        boss_flg = 1;
                    }
                    if (n == 299 || n > 343 && n < 348) {
                        boss_flg = 8;
                    }
                }
            } else {
                int n6;
                for (n6 = 0; n6 < 3; ++n6) {
                    n4 = r_ene[n][n6];
                    nArray2[n6 * 4 + 0] = n4 & 3;
                    nArray2[n6 * 4 + 1] = n4 >> 2 & 0x3F;
                    nArray2[n6 * 4 + 2] = n4 >> 8 & 0xF;
                    nArray2[n6 * 4 + 3] = n4 >> 12 & 0xF;
                    if (nArray2[n6 * 4 + 3] != 0) continue;
                    nArray2[n6 * 4 + 3] = 10;
                }
                for (n6 = 0; n6 < 3; ++n6) {
                    n4 = r_map[n][n6];
                    nArray[n6 * 6 + 5] = n4 & 0xF;
                    nArray[n6 * 6 + 4] = n4 >> 4 & 0xF;
                    nArray[n6 * 6 + 3] = n4 >> 8 & 0xF;
                    nArray[n6 * 6 + 2] = n4 >> 12 & 0xF;
                    nArray[n6 * 6 + 1] = n4 >> 16 & 0xF;
                    nArray[n6 * 6 + 0] = n4 >> 20 & 0xF;
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (boss_flg != 0 || rank_flg != 0 || ren_flg != 0 || ivent_flg >= 0) {
            non_esc = 1;
        }
        CpCanvas.Audio(1, 1 + boss_flg);
        if (scene == 5) {
            BtPanel cfr_ignored_0 = panel[0][0];
            BtPanel.R = 155;
            BtPanel cfr_ignored_1 = panel[0][0];
            BtPanel.G = 255;
            BtPanel cfr_ignored_2 = panel[0][0];
            BtPanel.B = 210;
        } else {
            BtPanel cfr_ignored_3 = panel[0][0];
            BtPanel.R = R;
            BtPanel cfr_ignored_4 = panel[0][0];
            BtPanel.G = G;
            BtPanel cfr_ignored_5 = panel[0][0];
            BtPanel.B = B;
        }
        BtPanel cfr_ignored_6 = panel[0][0];
        BtPanel cfr_ignored_7 = panel[0][0];
        BtPanel cfr_ignored_8 = panel[0][0];
        graMap.setColor(Graphics.getColorOfRGB((int)BtPanel.R, (int)BtPanel.G, (int)BtPanel.B));
        graMap.fillRect(0, 0, 240, 240);
        for (n2 = 0; n2 < 3; ++n2) {
            for (int i = 0; i < 6; ++i) {
                if (nArray[n2 * 6 + i] < 9) {
                    panel[n2][i].init(i, n2, nArray[n2 * 6 + i] - 1);
                } else {
                    panel[n2][i].init(i, n2, 1);
                }
                panel[n2][i].Draw(-1, true);
            }
        }
        fol[now_fol].init();
        for (n2 = 0; n2 < 30; ++n2) {
            CpCanvas.ata[n2] = new Attack(n2);
        }
        if (n == 344) {
            now_hp = max_hp;
        }
        rock = new Rock();
        CpCanvas.ene[0] = new Ene();
        CpCanvas.ene[1] = new Ene();
        CpCanvas.ene[2] = new Ene();
        for (n2 = 0; n2 < 6; ++n2) {
            CpCanvas.oki[n2] = new Okimono(n2);
        }
        rock.init();
        for (n2 = 0; n2 < 3; ++n2) {
            for (int i = 0; i < 6; ++i) {
                n3 = nArray[n2 * 6 + i];
                if (n3 <= 8) continue;
                if (n3 == 9) {
                    oki[4].Set(1, i, n2, 0, 0);
                }
                if (n3 == 10) {
                    oki[5].Set(1, i, n2, 0, 0);
                }
                if (n3 == 13) {
                    oki[2].Set(12, i, n2, 0, 0);
                }
                if (n3 == 14) {
                    oki[4].Set(13, i, n2, 0, 0);
                }
                if (n3 != 15) continue;
                oki[5].Set(13, i, n2, 0, 0);
            }
        }
        key_cnt = 0;
        for (n2 = 0; n2 < 3; ++n2) {
            ene[n2].init(nArray2[1 + 4 * n2], nArray2[3 + 4 * n2], nArray2[2 + 4 * n2], nArray2[0 + 4 * n2], n2);
            this.EneSet(n2, nArray2[1 + 4 * n2] * 4 + nArray2[4 * n2]);
        }
        drop_ene = (rand.nextInt() >>> 1) % ene_cnt;
        for (n2 = 0; n2 < ene_cnt; ++n2) {
            bt_get[1] = bt_get[1] + ene[n2].Get(1, 0);
            bt_get[2] = bt_get[2] + ene[n2].Get(2, 0);
        }
        max_sel = 5 + skill_kouka[0] + skill_kouka[1] * 2;
        if (max_sel > 10) {
            max_sel = 10;
        }
        if (CpCanvas.fol[CpCanvas.now_fol].regu_flg != 0) {
            regu_flg = 1;
        }
        if (scene != 1) {
            back_menu = scene;
        }
        if (back_menu == 3 && map_no > 53 && map_no < 58) {
            max_sel -= 2;
        }
        scene = 1;
    }

    public static int AtaNo(int n) {
        int n2;
        for (n2 = n; n2 < 29 && CpCanvas.ata[n2].on != 0; ++n2) {
        }
        ++ata_cnt;
        return n2;
    }

    public void TipSet() {
        try {
            InputStream inputStream = CpCanvas.JarGet(21);
            byte[] byArray = new byte[4];
            for (int i = 0; i < 255; ++i) {
                inputStream.read(byArray);
                CpCanvas.tip_list[i << 1] = (byArray[0] & 0xFF) << 8 | byArray[1] & 0xFF;
                CpCanvas.tip_list[(i << 1) + 1] = (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                if (i % 20 != 0) continue;
                this.DrawBar(2, 38 + (i + 1) / 20);
            }
            inputStream.close();
            inputStream = null;
            System.gc();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void FieldMain() {
        int[] nArray = new int[]{-1, 0, 1, 0};
        int[] nArray2 = new int[]{0, -1, 0, 1};
        CpCanvas.soft_id[0] = 0;
        CpCanvas.soft_id[1] = 0;
        if (machi_cnt > 0) {
            this.MapDraw(map_x, map_y);
            this.ObjDraw(0);
            if (this.PlgEfe(machi_cnt, machi_flg)) {
                if (machi_flg == 1) {
                    warp_cnt = 7;
                    warp_flg = 2;
                    ivent_end = 0;
                    machi_cnt = 0;
                } else {
                    this.MachiSet(machi_no, 1);
                    scene = 5;
                    machi_flg = 2;
                    machi_cnt = 1;
                    while (System.currentTimeMillis() - mill < 1000L) {
                        try {
                            Thread.sleep(100L);
                        }
                        catch (Exception exception) {}
                    }
                }
            } else {
                ++machi_cnt;
            }
            key = 0;
            return;
        }
        if (eff_cnt > 0) {
            this.EnEff(eff_cnt++);
            if (eff_cnt > 8) {
                int n = -1;
                if (ivent_flg < 0) {
                    int n2 = (rand.nextInt() >>> 1) % 9;
                    teki_pt = ene_set[map_no][n2 / 3] >> n2 % 3 * 10 & 0x3FF;
                    if (map_no < 12) {
                        n2 = (rand.nextInt() >>> 1) % 15;
                        if (skill_kouka[14] != 0) {
                            n2 /= 5;
                        }
                        if (n2 == 0) {
                            int[] nArray3 = new int[]{99, 0, 2, 0, 99, 0, 4, 2, 99, 0, 6, 3, 3, 1, 99, 0, 7, 9, 99, 0, 99, 0, 8, 7};
                            int n3 = nArray3[map_no * 2];
                            int n4 = nArray3[map_no * 2 + 1];
                            if (sina_no >= n3) {
                                teki_pt = 300 + n4 * 4 + navi_flg[n4];
                                n = n4;
                            }
                        }
                    }
                }
                this.BtSet(teki_pt);
                this.EnSet();
                scene = 1;
                --eff_cnt;
                ghost = n;
                key = 0;
            }
        } else {
            int n;
            int n5;
            int n6 = map_sp;
            int n7 = 0;
            int n8 = m_data[(map_y + 5) / 30 * 24 + map_x / 30];
            if (mes_flg == 0) {
                if (n8 > 2 && n8 < 7) {
                    if (this.PaneHit(n8 & 1)) {
                        if (n8 == 3) {
                            n7 = this.MoveChack(-2, 0) << 1;
                            map_x -= n7;
                        }
                        if (n8 == 4) {
                            n7 = this.MoveChack(0, -2) << 1;
                            map_y -= n7;
                        }
                        if (n8 == 5) {
                            n7 = this.MoveChack(2, 0) << 1;
                            map_x += n7;
                        }
                        if (n8 == 6) {
                            n7 = this.MoveChack(0, 2) << 1;
                            map_y += n7;
                        }
                    }
                    if (n7 != 0) {
                        muki = n8 - 3;
                        move_flg = 0;
                    }
                }
                if (warp_cnt == 0 && n7 == 0) {
                    CpCanvas.soft_id[0] = 5;
                    CpCanvas.soft_id[1] = 4;
                    key2 = this.getKeypadState();
                    if ((key2 & 0x20000) != 0) {
                        if (n7 == 0) {
                            muki = 1;
                        }
                        n7 = this.MoveChack(0, -1);
                        map_y -= n7;
                        move_cnt += n7;
                        n7 = 1;
                    } else if ((key2 & 0x80000) != 0) {
                        if (n7 == 0) {
                            muki = 3;
                        }
                        n7 = this.MoveChack(0, 1);
                        map_y += n7;
                        move_cnt += n7;
                        n7 = 3;
                    }
                    if ((key2 & 0x10000) != 0) {
                        if (n7 == 0) {
                            muki = 0;
                        }
                        n7 = this.MoveChack(-1, 0);
                        map_x -= n7;
                        move_cnt += n7;
                        n7 = 1;
                    } else if ((key2 & 0x40000) != 0) {
                        if (n7 == 0) {
                            muki = 2;
                        }
                        n7 = this.MoveChack(1, 0);
                        map_x += n7;
                        move_cnt += n7;
                        n7 = 1;
                    }
                    n8 = m_data[(map_y + 5) / 30 * 24 + map_x / 30];
                }
                if ((n8 & 0x80) != 0) {
                    if (warp_cnt == 0) {
                        n5 = n8 & 0xF;
                        n = m_chara[n5][chara_flg[map_no][n5]];
                        if (m_chara[n5][3] == 31 && n > 0) {
                            this.IventRead(n, n5 / 3 * 1);
                            mes_flg = 1;
                        }
                    }
                } else if (n8 > 6 && n8 < 11) {
                    if (warp_flg == 0 && 22 > map_x % 30 && 8 < map_x % 30 && 22 > (map_y + 8) % 30 && 8 < (map_y + 8) % 30) {
                        warp_flg = 1;
                        warp_cnt = 1;
                    }
                } else if (ivent_end == 0) {
                    warp_flg = 0;
                }
                if (warp_cnt == 0 && n7 == 0 && mes_flg == 0) {
                    if (key == 0x100000) {
                        if (mes_no > 0) {
                            this.MoveChack(nArray[muki], nArray2[muki]);
                        }
                        if (mes_no > 0) {
                            mes_flg = 1;
                            this.MesChack();
                            n7 = 0;
                        }
                        key = 0;
                    } else if (key == 0x200000) {
                        mes_flg = 2;
                        CpCanvas.MesRead(39, null, 3);
                        yes_no_flg = 2;
                        key = 0;
                    } else if (key == 0x400000) {
                        back_menu = scene;
                        scene = 4;
                        menu_sel = 0;
                        menu_no = 0;
                        menu_cnt = -1;
                        CpCanvas.MesRead(5, null, 3);
                        key = 0;
                    }
                    if (deba_flg != 0) {
                        if (key == 256) {
                            scene = 0;
                            key = 0;
                        } else if (key == 2) {
                            ++map_sp;
                            key = 0;
                        } else if (key == 4) {
                            --map_sp;
                            key = 0;
                        } else if (key == 1) {
                            hit_flg ^= 1;
                            key = 0;
                        } else if (key == 512) {
                            en_flg ^= 1;
                            key = 0;
                        } else if (key == 32) {
                            encount = move_cnt - 1;
                            key = 0;
                        }
                    }
                }
                if (warp_flg == 0 && encount < move_cnt && mes_flg == 0 && (en_flg == 0 || deba_flg == 0)) {
                    eff_cnt = 1;
                }
                move_flg = n7 == 0 ? 0 : move_flg % 8 + 1;
            }
            this.MapDraw(map_x, map_y);
            this.ObjDraw(0);
            if (warp_cnt > 0) {
                if (warp_cnt == (warp_flg - 1) * 6 + 1) {
                    CpCanvas.Audio(1, 15);
                }
                muki = 3;
                if (warp_cnt < 3) {
                    CpCanvas.Ani(41, 3, 0, 110, 103);
                }
                if ((warp_cnt += (warp_flg & 1) * 2 - 1) == 7) {
                    if (ivent_end != 0) {
                        warp_cnt = 0;
                        machi_flg = 3;
                        machi_cnt = 1;
                        ivent_end = 0;
                    } else if (n8 == 7) {
                        if (m_warp[0] < 100) {
                            warp_cnt = 0;
                            machi_flg = 3;
                            machi_cnt = 1;
                        } else {
                            m_warp[0] = m_warp[0] - 100;
                            n5 = m_warp[n8 - 7] >> 8;
                            map_no = m_warp[n8 - 7] & 0xFF;
                            this.MapSet(map_no, n5);
                            warp_cnt = 7;
                            warp_flg = 2;
                        }
                    } else {
                        n = map_bgm;
                        n5 = m_warp[n8 - 7] >> 8;
                        map_no = m_warp[n8 - 7] & 0xFF;
                        this.MapSet(map_no, n5);
                        if (n != map_bgm) {
                            CpCanvas.Audio(1, map_bgm);
                        }
                        warp_cnt = 7;
                        warp_flg = 2;
                    }
                } else if (warp_cnt > 2) {
                    g.setColor(Graphics.getColorOfRGB((int)128, (int)128, (int)255));
                    g.fillRect(111 + warp_cnt * 3 / 2, 0, 18 - warp_cnt * 3, 135);
                    g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                    g.fillRect(114 + warp_cnt, 0, 12 - warp_cnt * 2, 135);
                }
            } else {
                if (mes_flg != 0) {
                    move_flg = 0;
                }
                CpCanvas.Ani(41, muki, move_flg % 9, 110 + yure, 103);
            }
            if (scene != 5) {
                this.ObjDraw(1);
            } else {
                g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                g.fillRect(0, 0, 240, 240);
            }
            if (mes_flg != 0) {
                g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
                g.fillRect(0, 160, 240, 80);
                g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                g.fillRect(2, 162, 236, 76);
                if (ivent_flg >= 0) {
                    for (n5 = 0; n5 < 4; ++n5) {
                        if (i_set[n5] == 0 || i_set[n5] >= 31) continue;
                        n = i_x[n5] - map_x + yure;
                        int n9 = i_y[n5] - map_y;
                        CpCanvas.drawImg3(46, i_set[n5], n, n9, false);
                    }
                    if (machi_damy_flg >= 0) {
                        g.drawImage(imgMap, 0 + yure, 0);
                        CpCanvas.drawImg3(48, 1, 25 + yure, 5, false);
                        this.Basyo(m_name[machi_damy_flg], 100 + yure, 5);
                        if (kouka_flg == 0) {
                            this.FaceDrawA(talk_ch[0], talk_ch[1], talk_ch[2], 31);
                        }
                    }
                    if (this.IventMain() < 0) {
                        back_menu = scene;
                        mes_flg = 0;
                        if (ivent_end == 4) {
                            ivent_end = 0;
                            scene = 7;
                            return;
                        }
                        if (ivent_end == 5) {
                            ivent_end = 0;
                            scene = 8;
                            return;
                        }
                        if (ivent_end == 6) {
                            ivent_end = 0;
                            scene = 10;
                            return;
                        }
                        if (ivent_end == 7) {
                            ivent_end = 0;
                            mes_flg = 1;
                            return;
                        }
                    }
                } else {
                    n5 = CpCanvas.MesDraw(0) ? 1 : 0;
                    if (mes_flg == 1) {
                        if (key == 0x100000) {
                            if (n5 != 0) {
                                mes_flg = 0;
                            } else {
                                mes_cnt = 90;
                            }
                            key = 0;
                        }
                    } else {
                        this.FaceDraw(0);
                        if (yes_no_flg != 0) {
                            if (key == 65536) {
                                yes_no_flg = 1;
                                key = 0;
                            }
                            if (key == 262144) {
                                yes_no_flg = 2;
                                key = 0;
                            }
                        }
                        if (key == 0x100000) {
                            if (n5 != 0) {
                                if (yes_no_flg != 0) {
                                    if (yes_no_flg == 1) {
                                        CpCanvas.MesRead(40, null, 3);
                                    } else {
                                        mes_flg = 0;
                                    }
                                    yes_no_flg = 0;
                                } else {
                                    mes_flg = 0;
                                    warp_flg = 1;
                                    warp_cnt = 1;
                                    ivent_end = 1;
                                }
                            } else {
                                mes_cnt = 90;
                            }
                            key = 0;
                        }
                    }
                }
            }
            if (mes_flg == 0) {
                CpCanvas.HpDraw(now_hp, 0, -40);
                this.AriaName();
            }
        }
    }

    public void AriaName() {
        g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
        g.fillRect(69, 1, 169, 18);
        g.fillRect(70, 2, 169, 18);
        g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        g.fillRect(70, 2, 167, 16);
        g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
        CpCanvas.strDraw(map_str[map_no], (167 - f.stringWidth(map_str[map_no])) / 2 + 71, 17);
    }

    public void EnEff(int n) {
        g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
        for (int i = 0; i < 6; ++i) {
            g.fillRect(0, i * 40, n * 40 - n * 5, 20);
            g.fillRect(240 - (n * 40 - n * 5), i * 40 + 20, 240, 20);
        }
    }

    public int MoveChack(int n, int n2) {
        int n3 = map_x + n * map_sp;
        int n4 = map_y + n2 * map_sp;
        mes_no = -1;
        if (n3 - 8 < 0 || n3 + 8 > 719 || n4 < 0 || n4 + 10 > 719) {
            n3 -= n * map_sp;
            n4 -= n2 * map_sp;
            for (int i = 0; i < map_sp; ++i) {
                if ((n3 += n) - 8 >= 0 && n3 + 8 <= 719 && (n4 += n2) >= 0 && n4 + 10 <= 719) continue;
                return i;
            }
            return 0;
        }
        if (hit_flg != 0 && deba_flg != 0) {
            return map_sp;
        }
        if (m_data[n4 / 30 * 24 + (n3 - 8) / 30] == 0 || m_data[n4 / 30 * 24 + (n3 + 8) / 30] == 0 || m_data[(n4 + 10) / 30 * 24 + (n3 - 8) / 30] == 0 || m_data[(n4 + 10) / 30 * 24 + (n3 + 8) / 30] == 0) {
            n3 -= n * map_sp;
            n4 -= n2 * map_sp;
            for (int i = 0; i < map_sp; ++i) {
                if (m_data[(n4 += n2) / 30 * 24 + ((n3 += n) - 8) / 30] != 0 && m_data[n4 / 30 * 24 + (n3 + 8) / 30] != 0 && m_data[(n4 + 10) / 30 * 24 + (n3 - 8) / 30] != 0 && m_data[(n4 + 10) / 30 * 24 + (n3 + 8) / 30] != 0) continue;
                return i;
            }
            return 0;
        }
        int n5 = m_data[(n4 + 5) / 30 * 24 + n3 / 30];
        if ((n5 & 0x20) != 0 && 26 > n3 % 30 && 3 < n3 % 30 && 22 > (n4 + 8) % 30 && 8 < (n4 + 8) % 30) {
            mes_data = (n4 + 5) / 30 * 24 + n3 / 30;
            n3 -= n * map_sp;
            n4 -= n2 * map_sp;
            for (int i = 0; i < map_sp; ++i) {
                if (26 <= (n3 += n) % 30 || 3 >= n3 % 30 || 22 <= ((n4 += n2) + 8) % 30 || 8 >= (n4 + 8) % 30) continue;
                mes_no = 32 + (n5 & 0xF);
                return i;
            }
            return 0;
        }
        int n6 = this.TobiCh(n3, n4, n, n2, 6);
        if (n6 >= 0) {
            return n6;
        }
        n6 = this.TobiCh(n3, n4, n, n2, 7);
        if (n6 >= 0) {
            return n6;
        }
        if ((n5 & 0x80) != 0) {
            int n7 = n5 & 0xF;
            int n8 = m_chara[n7][3] - 2;
            int[][] nArrayArray = new int[][]{{26, 3, 22, 8}, {29, 6, 22, 4}, {29, 6, 19, 4}, {23, 1, 19, 4}, {23, 1, 19, 4}, {26, 3, 22, 8}, {26, 3, 22, 8}, {23, 1, 25, 4}, {29, 1, 25, 4}, {29, 1, 22, 4}, {26, 3, 22, 8}};
            if (n8 > 10 || n8 < 0) {
                n8 = 10;
            }
            if (nArrayArray[n8][0] > n3 % 30 && nArrayArray[n8][1] < n3 % 30 && nArrayArray[n8][2] > (n4 + 8) % 30 && nArrayArray[n8][3] < (n4 + 8) % 30) {
                mes_data = (n4 + 5) / 30 * 24 + n3 / 30;
                n3 -= n * map_sp;
                n4 -= n2 * map_sp;
                for (int i = 0; i < map_sp; ++i) {
                    if (nArrayArray[n8][0] <= (n3 += n) % 30 || nArrayArray[n8][1] >= n3 % 30 || nArrayArray[n8][2] <= ((n4 += n2) + 8) % 30 || nArrayArray[n8][3] >= (n4 + 8) % 30) continue;
                    mes_no = 128 + n7;
                    return i;
                }
                return 0;
            }
        }
        return map_sp;
    }

    public int TobiCh(int n, int n2, int n3, int n4, int n5) {
        int n6;
        int n7;
        int n8;
        int n9;
        for (n9 = 0; n9 < 4; ++n9) {
            n8 = m_data[(n2 + n9 / 2 * 10) / 30 * 24 + (n + (1 - (n9 & 1) * 2) * 8) / 30];
            if ((n8 & 1 << n5) == 0) continue;
            if (n5 != 7 || (n7 = m_chara[n6 = n8 & 0xF][3] - 1) == 0) break;
            n9 = 10;
            break;
        }
        if (n9 < 4) {
            n -= n3 * map_sp;
            n2 -= n4 * map_sp;
            for (n6 = 0; n6 < map_sp; ++n6) {
                n += n3;
                n2 += n4;
                for (n7 = 0; n7 < 4; ++n7) {
                    n8 = m_data[(n2 + n7 / 2 * 10) / 30 * 24 + (n + (1 - (n7 & 1) * 2) * 8) / 30];
                    if ((n8 & 1 << n5) == 0) continue;
                    mes_no = (1 << n5) + (n8 & 0xF);
                    mes_data = (map_y + n7 / 2 * 10 + n4 * map_sp) / 30 * 24 + (map_x + (1 - (n7 & 1) * 2) * 8 + n3 * map_sp) / 30;
                    return n6;
                }
            }
            return 0;
        }
        return -1;
    }

    public boolean PaneHit(int n) {
        return n == 0 ? m_data[(map_y + 5) / 30 * 24 + (map_x + 2) / 30] > 2 && m_data[(map_y + 5) / 30 * 24 + (map_x + 2) / 30] < 7 && m_data[(map_y + 5) / 30 * 24 + (map_x - 2) / 30] > 2 && m_data[(map_y + 5) / 30 * 24 + (map_x - 2) / 30] < 7 : n == 1 && m_data[(map_y + 3) / 30 * 24 + map_x / 30] > 2 && m_data[(map_y + 3) / 30 * 24 + map_x / 30] < 7 && m_data[(map_y + 7) / 30 * 24 + map_x / 30] > 2 && m_data[(map_y + 7) / 30 * 24 + map_x / 30] < 7;
    }

    public void MapSet(int n, int n2) {
        int n3;
        int n4;
        int n5;
        int n6;
        InputStream inputStream;
        n2 += 7;
        byte[] byArray = new byte[4];
        map_bgm = 4;
        if (sina_no == 8 && n > 63) {
            map_bgm = 8;
        }
        if (p_pat[0] == 0) {
            try {
                int n7;
                inputStream = CpCanvas.JarGet(7);
                for (n7 = 0; n7 < 14; ++n7) {
                    inputStream.read(byArray);
                    CpCanvas.p_col[n7] = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                }
                for (n7 = 0; n7 < 69; ++n7) {
                    inputStream.read(byArray);
                    CpCanvas.p_pat[n7] = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                }
                for (n7 = 0; n7 < 69; ++n7) {
                    inputStream.read(byArray);
                    CpCanvas.ene_set[n7][0] = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                    inputStream.read(byArray);
                    CpCanvas.ene_set[n7][1] = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                    inputStream.read(byArray);
                    CpCanvas.ene_set[n7][2] = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                }
                inputStream.close();
                inputStream = null;
                System.gc();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        try {
            System.gc();
            inputStream = CpCanvas.JarGet(6);
            inputStream.skip(n * 216);
            for (int i = 0; i < 432; i += 8) {
                inputStream.read(byArray);
                for (n6 = 0; n6 < 8; ++n6) {
                    CpCanvas.m_data[i + n6] = (byArray[n6 / 2] & 0xFF) >> 4 * (n6 & 1 ^ 1) & 0xF;
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            inputStream = CpCanvas.GetData(3);
            inputStream.skip(n * 48);
            inputStream.read(byArray);
            CpCanvas.m_warp[0] = (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
            CpCanvas.m_warp[1] = (byArray[0] & 0xFF) << 8 | byArray[1] & 0xFF;
            inputStream.read(byArray);
            CpCanvas.m_warp[2] = (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
            CpCanvas.m_warp[3] = (byArray[0] & 0xFF) << 8 | byArray[1] & 0xFF;
            int n8 = 0;
            for (n6 = 0; n6 < 4; ++n6) {
                inputStream.read(byArray);
                n8 = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                CpCanvas.m_item[n6][0] = n8 & 0x1F;
                CpCanvas.m_item[n6][1] = n8 >> 5 & 0x1FF;
                CpCanvas.m_item[n6][2] = n8 >> 14 & 0x1F;
                CpCanvas.m_item[n6][3] = n8 >> 19 & 0x1F;
                if (m_item[n6][0] == 0 && m_item[n6][1] == 0) {
                    CpCanvas.item_flg[CpCanvas.map_no][n6] = 0;
                }
                if (m_item[n6][0] != 1) continue;
                int[] nArray = m_item[n6];
                nArray[1] = nArray[1] * 10;
            }
            for (n6 = 0; n6 < 2; ++n6) {
                inputStream.read(byArray);
                n8 = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                CpCanvas.m_tobi[n6][0] = 0;
                CpCanvas.m_tobi[n6][1] = n8 & 0xFF;
                CpCanvas.m_tobi[n6][2] = n8 >> 8 & 0xFF;
                CpCanvas.m_tobi[n6][3] = n8 >> 16 & 0x1F;
                CpCanvas.m_tobi[n6][4] = n8 >> 21 & 0x1F;
            }
            for (n6 = 0; n6 < 4; ++n6) {
                inputStream.read(byArray);
                n8 = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                CpCanvas.m_chara[n6][0] = 0;
                CpCanvas.m_chara[n6][1] = n8 >> 5 & 0xFF;
                CpCanvas.m_chara[n6][2] = n8 >> 13 & 0xFF;
                CpCanvas.m_chara[n6][3] = n8 & 0x1F;
                CpCanvas.m_chara[n6][4] = n8 >> 21 & 0x1F;
                CpCanvas.m_chara[n6][5] = n8 >> 26 & 0x1F;
            }
            inputStream.close();
            inputStream = null;
            System.gc();
        }
        catch (Exception exception) {
            // empty catch block
        }
        tip_pt = p_pat[map_no] & 0xF;
        R = p_col[tip_pt] & 0xFF;
        G = p_col[tip_pt] >> 8 & 0xFF;
        B = p_col[tip_pt] >> 16 & 0xFF;
        for (n5 = 0; n5 < 9; ++n5) {
            graMap2[n5].setColor(Graphics.getColorOfRGB((int)R, (int)G, (int)B));
            graMap2[n5].fillRect(0, 0, 240, 248);
        }
        for (n4 = 0; n4 < 18; ++n4) {
            for (n3 = 0; n3 < 24; ++n3) {
                n = m_data[n4 * 24 + n3];
                if (n != 0) {
                    if (n == 1) {
                        graMap2[n4 / 8 * 3 + n3 / 8].drawImage((Image)image[45], (n3 & 7) * 30, (n4 & 7) * 30, gx[45][tip_pt * 2], gy[45][tip_pt * 2], 30, 38);
                        if (n4 % 8 == 7 && n4 < 16) {
                            graMap2[(n4 + 1) / 8 * 3 + n3 / 8].drawImage((Image)image[45], (n3 & 7) * 30, -30, gx[45][tip_pt * 2], gy[45][tip_pt * 2], 30, 38);
                        }
                    } else if (n == 2) {
                        graMap2[n4 / 8 * 3 + n3 / 8].drawImage((Image)image[45], (n3 & 7) * 30, (n4 & 7) * 30, gx[45][tip_pt * 2 + 1], gy[45][tip_pt * 2 + 1], 30, 38);
                        if (n4 % 8 == 7 && n4 < 16) {
                            graMap2[(n4 + 1) / 8 * 3 + n3 / 8].drawImage((Image)image[45], (n3 & 7) * 30, -30, gx[45][tip_pt * 2 + 1], gy[45][tip_pt * 2 + 1], 30, 38);
                        }
                    } else if (n <= 6) {
                        graMap2[n4 / 8 * 3 + n3 / 8].drawImage((Image)image[45], (n3 & 7) * 30, (n4 & 7) * 30, gx[45][27 + n], gy[45][27 + n], 30, 38);
                        if (n4 % 8 == 7 && n4 < 16) {
                            graMap2[(n4 + 1) / 8 * 3 + n3 / 8].drawImage((Image)image[45], (n3 & 7) * 30, -30, gx[45][27 + n], gy[45][27 + n], 30, 38);
                        }
                    } else if (n == 7) {
                        if (m_warp[0] == machi_no) {
                            graMap2[n4 / 8 * 3 + n3 / 8].drawImage((Image)image[45], (n3 & 7) * 30, (n4 & 7) * 30, gx[45][29], gy[45][29], 30, 38);
                            if (n4 % 8 == 7 && n4 < 16) {
                                graMap2[(n4 + 1) / 8 * 3 + n3 / 8].drawImage((Image)image[45], (n3 & 7) * 30, -30, gx[45][29], gy[45][29], 30, 38);
                            }
                        } else if (m_warp[0] > 99) {
                            graMap2[n4 / 8 * 3 + n3 / 8].drawImage((Image)image[45], (n3 & 7) * 30, (n4 & 7) * 30, gx[45][28], gy[45][28], 30, 38);
                            if (n4 % 8 == 7 && n4 < 16) {
                                graMap2[(n4 + 1) / 8 * 3 + n3 / 8].drawImage((Image)image[45], (n3 & 7) * 30, -30, gx[45][28], gy[45][28], 30, 38);
                            }
                        } else {
                            CpCanvas.m_data[n4 * 24 + n3] = 2;
                            graMap2[n4 / 8 * 3 + n3 / 8].drawImage((Image)image[45], (n3 & 7) * 30, (n4 & 7) * 30, gx[45][tip_pt * 2 + 1], gy[45][tip_pt * 2 + 1], 30, 38);
                            if (n4 % 8 == 7 && n4 < 16) {
                                graMap2[(n4 + 1) / 8 * 3 + n3 / 8].drawImage((Image)image[45], (n3 & 7) * 30, -30, gx[45][tip_pt * 2 + 1], gy[45][tip_pt * 2 + 1], 30, 38);
                            }
                        }
                    } else if (n <= 10) {
                        graMap2[n4 / 8 * 3 + n3 / 8].drawImage((Image)image[45], (n3 & 7) * 30, (n4 & 7) * 30, gx[45][28], gy[45][28], 30, 38);
                        if (n4 % 8 == 7 && n4 < 16) {
                            graMap2[(n4 + 1) / 8 * 3 + n3 / 8].drawImage((Image)image[45], (n3 & 7) * 30, -30, gx[45][28], gy[45][28], 30, 38);
                        }
                    } else if (n == 11) {
                        CpCanvas.m_data[n4 * 24 + n3] = 0;
                        graMap2[n4 / 8 * 3 + n3 / 8].drawImage((Image)image[46], (n3 & 7) * 30 + dx[46][0], (n4 & 7) * 30 + dy[46][0], gx[46][0], gy[46][0], sx[46][0], sy[46][0]);
                    } else if (n <= 15) {
                        int n9 = n4 * 24 + n3;
                        m_data[n9] = m_data[n9] - 5;
                        graMap2[n4 / 8 * 3 + n3 / 8].drawImage((Image)image[45], (n3 & 7) * 30, (n4 & 7) * 30, gx[45][34], gy[45][34], 30, 38);
                        if (n4 % 8 == 7 && n4 < 16) {
                            graMap2[(n4 + 1) / 8 * 3 + n3 / 8].drawImage((Image)image[45], (n3 & 7) * 30, -30, gx[45][34], gy[45][34], 30, 38);
                        }
                    }
                }
                if (m_data[n4 * 24 + n3] != n2) continue;
                map_x = n3 * 30 + 15;
                map_y = n4 * 30 + 8;
            }
        }
        for (n5 = 0; n5 < 4; ++n5) {
            n3 = m_item[n5][2];
            n4 = m_item[n5][3];
            CpCanvas.m_item[n5][2] = n3 * 30 + 120;
            CpCanvas.m_item[n5][3] = n4 * 30 + 124;
            if (item_flg[map_no][n5] == 0) continue;
            CpCanvas.m_data[n4 * 24 + n3] = 32 + n5;
        }
        for (n5 = 0; n5 < 2; ++n5) {
            n3 = m_tobi[n5][3];
            n4 = m_tobi[n5][4];
            CpCanvas.m_tobi[n5][3] = n3 * 30 + 120;
            CpCanvas.m_tobi[n5][4] = n4 * 30 + 124;
            if (tobi_flg[map_no][n5] == 0) continue;
            CpCanvas.m_data[n4 * 24 + n3] = 64 + n5;
        }
        for (n5 = 0; n5 < 4; ++n5) {
            n3 = m_chara[n5][4];
            n4 = m_chara[n5][5];
            CpCanvas.m_chara[n5][4] = n3 * 30 + 120;
            CpCanvas.m_chara[n5][5] = n4 * 30 + 124;
            if (chara_flg[map_no][n5] == 0 || m_chara[n5][3] <= 0) continue;
            CpCanvas.m_data[n4 * 24 + n3] = (m_data[n4 * 24 + n3] << 16) + 128 + n5;
        }
        this.EnSet();
        warp_flg = 1;
    }

    public void ObjDraw(int n) {
        if (n == 0) {
            int n2;
            int n3;
            int n4;
            for (n4 = 0; n4 < 4; ++n4) {
                if (item_flg[map_no][n4] == 0) continue;
                n3 = m_item[n4][2] - map_x + yure;
                n2 = m_item[n4][3] - map_y;
                CpCanvas.drawImg3(46, 7, n3, n2, false);
            }
            for (n4 = 0; n4 < 2; ++n4) {
                if (tobi_flg[map_no][n4] == 0) continue;
                n3 = m_tobi[n4][3] - map_x + yure;
                n2 = m_tobi[n4][4] - map_y;
                CpCanvas.drawImg3(46, 1, n3, n2, false);
            }
            for (n4 = 0; n4 < 4; ++n4) {
                if (chara_flg[map_no][n4] == 0 || m_chara[n4][3] >= 31 || m_chara[n4][3] <= 0) continue;
                n3 = m_chara[n4][4] - map_x + yure;
                n2 = m_chara[n4][5] - map_y;
                CpCanvas.drawImg3(46, m_chara[n4][3], n3, n2, false);
            }
        } else {
            int n5;
            if ((m_data[(map_y + 15) / 30 * 24 + map_x / 30] >> 5 & 1) != 0 && (map_y + 15) % 30 < 20) {
                int n6 = m_data[(map_y + 15) / 30 * 24 + map_x / 30] & 0xF;
                int n7 = m_item[n6][2] - map_x + yure;
                int n8 = m_item[n6][3] - map_y;
                CpCanvas.drawImg3(46, 7, n7, n8, false);
                return;
            }
            for (n5 = -1; n5 < 2 && map_y >= 35; ++n5) {
                if ((m_data[(map_y + 35) / 30 * 24 + map_x / 30 + n5] >> 6 & 1) == 0) continue;
                int n9 = m_data[(map_y + 35) / 30 * 24 + map_x / 30 + n5] & 0xF;
                int n10 = m_tobi[n9][3] - map_x + yure;
                int n11 = m_tobi[n9][4] - map_y;
                CpCanvas.drawImg3(46, 1, n10, n11, false);
                return;
            }
            if ((m_data[(map_y + 15) / 30 * 24 + map_x / 30] >> 7 & 1) != 0 && (map_y + 15) % 30 < 20) {
                n5 = m_data[(map_y + 15) / 30 * 24 + map_x / 30] & 0xF;
                int n12 = m_chara[n5][4] - map_x + yure;
                int n13 = m_chara[n5][5] - map_y;
                if (chara_flg[map_no][n5] != 0 && m_chara[n5][3] < 31 && m_chara[n5][3] > 0) {
                    CpCanvas.drawImg3(46, m_chara[n5][3], n12, n13, false);
                }
                return;
            }
            if ((m_data[(map_y + 35) / 30 * 24 + map_x / 30] >> 7 & 1) == 1) {
                n5 = m_data[(map_y + 35) / 30 * 24 + map_x / 30] & 0xF;
                int n14 = m_chara[n5][4] - map_x + yure;
                int n15 = m_chara[n5][5] - map_y;
                if (m_chara[n5][3] < 31) {
                    CpCanvas.drawImg3(46, m_chara[n5][3], n14, n15, false);
                }
            }
        }
    }

    public void MapDraw(int n, int n2) {
        R = p_col[tip_pt] & 0xFF;
        G = p_col[tip_pt] >> 8 & 0xFF;
        B = p_col[tip_pt] >> 16 & 0xFF;
        g.setColor(Graphics.getColorOfRGB((int)R, (int)G, (int)B));
        g.fillRect(0, 0, 240, 240);
        int[] nArray = new int[]{(n -= 120 + yure) / 240, n / 240 + 1, (n2 -= 120) / 240, n2 / 240 + 1};
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
        int[] nArray2 = new int[]{-n + nArray[0] * 240, -n + nArray[1] * 240};
        int[] nArray3 = new int[]{-n2 + nArray[2] * 240, -n2 + nArray[3] * 240};
        for (int i = 0; i < 4; ++i) {
            int n3 = nArray[i & 1] + nArray[i / 2 + 2] * 3;
            if (nArray[i & 1] >= 3 || nArray[i / 2 + 2] >= 3) continue;
            g.drawImage(imgMap2[n3], nArray2[i & 1], nArray3[i / 2] + 4);
        }
    }

    public void EnSet() {
        int n = (rand.nextInt() >>> 1) % 100;
        encount = n < 80 ? (rand.nextInt() >>> 1) % 400 + 400 : (n < 88 ? (rand.nextInt() >>> 1) % 200 + 200 : (n < 96 ? (rand.nextInt() >>> 1) % 200 + 800 : (n < 98 ? (rand.nextInt() >>> 1) % 400 + 1200 : (rand.nextInt() >>> 1) % 200 + 100)));
        encount = encount * (p_pat[map_no] >> 8 & 0xFF) / 10;
        n = skill_kouka[10] * 7;
        encount += encount * n / 10;
        n = skill_kouka[13] * 2;
        encount -= encount * n / 12;
        move_cnt = 0;
    }

    public void MesChack() {
        int n = mes_no >> 5;
        int n2 = mes_no & 0xF;
        String string = "?";
        if (n == 1) {
            n = 0;
            string = this.ItemName(m_item[n2][0], m_item[n2][1]);
            int n3 = (user_id / 10 + map_no) % 5;
            if (m_item[n2][0] == 3) {
                this.GetItem(m_item[n2][0], 0, m_item[n2][1] * 5 + n3);
            } else {
                this.GetItem(m_item[n2][0], 0, m_item[n2][1]);
            }
            CpCanvas.item_flg[CpCanvas.map_no][CpCanvas.m_data[CpCanvas.mes_data] & 0xF] = 0;
            CpCanvas.m_data[CpCanvas.mes_data] = 1;
            CpCanvas.MesRead(n, string.getBytes(), 3);
        } else if (n == 2) {
            n = m_tobi[n2][tobi_flg[map_no][n2]];
            this.IventRead(n, 3);
        } else if (n == 4) {
            n = m_chara[n2][chara_flg[map_no][n2]];
            this.IventRead(n, n2 / 3 * 1);
        }
    }

    public static void MesRead(int n, byte[] byArray, int n2) {
        mes_cnt = 0;
        if (tmp_m_no == n && tmp_m_flg == n2 && byArray == null) {
            return;
        }
        mes_id = n;
        try {
            int n3;
            InputStream inputStream = null;
            if (n2 == 0) {
                n3 = n;
                if (n > 499) {
                    inputStream = CpCanvas.GetData(12);
                    inputStream.skip((n - 400) * 90);
                } else {
                    inputStream = CpCanvas.GetData(8 + n3 / 100);
                    inputStream.skip(n % 100 * 90);
                }
            } else if (n2 == 1) {
                inputStream = CpCanvas.GetData(6);
                inputStream.skip(n * 90);
            } else if (n2 == 2) {
                inputStream = Connector.openInputStream((String)"resource:///data/new/10mail_mes.dat");
                inputStream.skip(n * 90);
            } else if (n2 == 3) {
                n3 = CpCanvas.MesNo(n);
                if (n3 < 0) {
                    inputStream = CpCanvas.JarGet(11);
                    inputStream.skip(n * 90);
                } else {
                    inputStream = CpCanvas.JarGet(35);
                    inputStream.skip(n3 * 90);
                }
            } else if (n2 == 4) {
                inputStream = CpCanvas.JarGet(12);
                inputStream.skip(n * 60);
            } else if (n2 == 5) {
                inputStream = CpCanvas.JarGet(13);
                inputStream.skip(n * 60);
            } else if (n2 == 6) {
                inputStream = CpCanvas.GetQstr(n);
            } else if (n2 == 10) {
                inputStream = Connector.openInputStream((String)"resource:///data/new/sys_mes2.dat");
                inputStream.skip(n * 90);
            } else if (n2 == 11) {
                inputStream = Connector.openInputStream((String)"resource:///data/new/sina_mes2.dat");
                inputStream.skip(n * 90);
            }
            for (n3 = 0; n3 < 3; ++n3) {
                int n4;
                byte[] byArray2 = new byte[30];
                int n5 = 0;
                inputStream.read(byArray2);
                if (byArray2[0] == -127 && byArray2[1] == -112) {
                    q_cnt = 100;
                }
                for (n4 = 0; n4 < 30; ++n4) {
                    if (n4 < 29 && byArray2[n4] == -127 && byArray2[n4 + 1] == -113) {
                        n5 = 1;
                    }
                    if (byArray2[n4] == 0) break;
                }
                if (n5 != 0) {
                    n5 = byArray.length;
                }
                CpCanvas.mes[n3] = new byte[n4 += n5];
                n5 = 0;
                int n6 = 0;
                int n7 = 0;
                while (n6 < n4 - n5) {
                    if (n7 < n4 - 1 && byArray2[n7] == -127 && byArray2[n7 + 1] == -113) {
                        for (n5 = 0; n5 < byArray.length; ++n5) {
                            CpCanvas.mes[n3][n7 + n5] = byArray[n5];
                        }
                        n6 += 2;
                    }
                    CpCanvas.mes[n3][n7 + n5] = byArray2[n6];
                    ++n6;
                    ++n7;
                }
            }
            inputStream.close();
            inputStream = null;
            System.gc();
        }
        catch (Exception exception) {
            System.out.println("mes e: " + exception);
        }
        tmp_m_no = n;
        tmp_m_flg = n2;
    }

    public static int MesNo(int n) {
        int n2 = -1;
        int[] nArray = new int[]{5, 6, 7, 8, 9, 10, 11, 15, 28, 29, 30, 31, 32, 33, 35, 39, 54, 71, 76, 82, 93, 94, 110, 111, 137, 157, 158, 159};
        for (int i = 27; i >= 0; --i) {
            if (nArray[i] != n) continue;
            n2 = i;
            break;
        }
        return n2;
    }

    public static boolean MesDraw(int n) {
        int n2 = mes_cnt + n * 100;
        int n3 = 0;
        g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
        for (int i = 0; i < 3 && n3 >= i; ++i) {
            String string;
            if (n2 > mes[i].length) {
                n2 -= mes[i].length;
                string = new String(mes[i]);
                ++n3;
            } else {
                string = new String(mes[i], 0, n2);
            }
            CpCanvas.strDraw(string, 55, 190 + i * 15);
            if (n == 2 && i == 1 || n == 3) break;
        }
        if (n3 == 3) {
            if (n == 0) {
                if (yes_no_flg == 0) {
                    CpCanvas.drawImg3(44, 108, 225, 222 + game_cnt / 3 % 2, false);
                } else {
                    CpCanvas.drawImg3(44, 33, 55 + (yes_no_flg - 1) * 96 + game_cnt / 2 % 3, 207, false);
                }
            }
            return true;
        }
        mes_cnt += 3;
        return false;
    }

    public static boolean MesDraw2(int n, int n2, int n3, int n4) {
        int n5 = mes_cnt + n * 100;
        int n6 = 0;
        g.setColor(Graphics.getColorOfRGB((int)n4, (int)n4, (int)n4));
        for (int i = 0; i < 3 && n6 >= i; ++i) {
            String string;
            if (n5 > mes[i].length) {
                n5 -= mes[i].length;
                string = new String(mes[i]);
                ++n6;
            } else {
                string = new String(mes[i], 0, n5);
            }
            CpCanvas.strDraw(string, n2, n3 + i * 15);
            if (n == 2 && i == 1 || n == 3) break;
        }
        if (n6 == 3) {
            if (n == 0) {
                if (yes_no_flg == 0) {
                    CpCanvas.drawImg3(44, 108, 225, 222 + game_cnt / 3 % 2, false);
                } else {
                    CpCanvas.drawImg3(44, 33, 55 + (yes_no_flg - 1) * 96 + game_cnt / 2 % 3, 207, false);
                }
            }
            return true;
        }
        mes_cnt += 3;
        return false;
    }

    public void Machi() {
        int n;
        now_hp = max_hp;
        CpCanvas.soft_id[0] = 0;
        CpCanvas.soft_id[1] = 0;
        if (machi_move > 0) {
            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
            g.fillRect(0, 0, 240, 160);
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            g.fillRect(2, 162, 236, 76);
            if (--machi_move == 0) {
                this.MachiSet(machi_no, 1);
                while (System.currentTimeMillis() - mill < 500L) {
                    try {
                        Thread.sleep(100L);
                    }
                    catch (Exception exception) {}
                }
            }
            key = 0;
            return;
        }
        if (eff_cnt > 0) {
            this.EnEff(eff_cnt++);
            if (eff_cnt > 8) {
                this.BtSet(teki_pt);
                this.EnSet();
                scene = 1;
                --eff_cnt;
                key = 0;
            }
            return;
        }
        if (machi_cnt > 0) {
            if (this.PlgEfe(machi_cnt, machi_flg)) {
                if (machi_flg == 0) {
                    scene = 3;
                    map_no = m_plg[menu_cnt];
                    this.MapSet(map_no, 0);
                    machi_flg = 1;
                    machi_cnt = 1;
                    while (System.currentTimeMillis() - mill < 1000L) {
                        try {
                            Thread.sleep(100L);
                        }
                        catch (Exception exception) {}
                    }
                    CpCanvas.Audio(1, map_bgm);
                } else {
                    machi_flg = 0;
                    machi_cnt = 0;
                    CpCanvas.Audio(1, 3);
                }
                key = 0;
            } else {
                ++machi_cnt;
            }
            return;
        }
        if (ivent_flg >= 0) {
            g.drawImage(imgMap, 0 + yure, 0);
            CpCanvas.drawImg3(48, 1, 25 + yure, 5, false);
            this.Basyo(m_name[machi_no], 100 + yure, 5);
            if (this.IventMain() < 0) {
                machi_flg = ivent_end;
                machi_sel = 0;
                machi_cnt = 0;
                talk_cnt = this.CharaCnt();
                ivent_end = 0;
                back_menu = scene;
                key = 0;
                if (machi_flg == 3) {
                    g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
                    g.fillRect(0, 0, 240, 240);
                    mode = 0;
                    if (sina_no == 8) {
                        if (dat[58] == 0) {
                            this.Load(0);
                            CpCanvas.dat[58] = 1;
                            CpCanvas.writeSP();
                            this.Save(0);
                            now_bgm = 0;
                            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
                            g.fillRect(0, 160, 240, 80);
                            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                            g.fillRect(2, 162, 236, 76);
                            CpCanvas.MesRead(163, null, 3);
                            CpCanvas.MesDraw(1);
                            CpCanvas.drawImg3(44, 108, 225, 222, false);
                            this.Wait(0);
                            key = 0;
                            while (key == 0) {
                            }
                            key = 0;
                            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
                            g.fillRect(0, 0, 240, 240);
                        }
                        this.Wait(800);
                        this.imgAddDraw(0, 12, 99);
                        g.unlock(true);
                        this.Wait(1500);
                        machi_flg = 0;
                    }
                    scene = -2;
                    this.ImgSet2(20);
                    CpCanvas.Audio(1, 0);
                    key = 0;
                    return;
                }
                if (machi_flg == 4) {
                    scene = 7;
                    return;
                }
                if (machi_flg == 10) {
                    machi_flg = 0;
                    scene = 9;
                    rank_menu = 0;
                    rank_cnt = 0;
                    rank_no = 0;
                    if (dat[51] * 100 + dat[52] != dat[55] * 100 + dat[56]) {
                        rank_menu = -1;
                    }
                    rank_menu = -1;
                    this.MakeRank(0);
                }
            }
            if (kouka_flg == 0) {
                this.FaceDrawA(talk_ch[0], talk_ch[1], talk_ch[2], 31);
            }
            return;
        }
        if (mail_flg == 0) {
            if (key == 65536) {
                if (machi_flg == 0 && --machi_sel < 0) {
                    machi_sel = 3;
                }
                if (machi_flg == 2 && --menu_cnt < 0) {
                    menu_cnt = talk_cnt - 1 + talk_cnt2;
                }
                key = 0;
            } else if (key == 262144) {
                if (machi_flg == 0 && ++machi_sel > 3) {
                    machi_sel = 0;
                }
                if (machi_flg == 2 && ++menu_cnt > talk_cnt - 1 + talk_cnt2) {
                    menu_cnt = 0;
                }
                key = 0;
            } else if (key == 131072) {
                if (machi_flg == 1 && --menu_cnt < 0) {
                    menu_cnt = move_ok[machi_no] - 1;
                }
                if (machi_flg == 2) {
                    machi_flg = 0;
                    menu_cnt = 0;
                }
                if (machi_flg == 3 && --menu_cnt < 0) {
                    menu_cnt = plg_ok[machi_no] - 1;
                }
                key = 0;
            } else if (key == 524288) {
                if (machi_flg == 1 && ++menu_cnt > move_ok[machi_no] - 1) {
                    menu_cnt = 0;
                }
                if (machi_flg == 3 && ++menu_cnt > plg_ok[machi_no] - 1) {
                    menu_cnt = 0;
                }
                key = 0;
            }
            if (deba_flg != 0) {
                if (key == 2) {
                    int[] nArray = talk_flg[machi_no];
                    nArray[0] = nArray[0] + 1;
                    if (talk_flg[machi_no][0] > 4) {
                        CpCanvas.talk_flg[CpCanvas.machi_no][0] = 0;
                    }
                    talk_cnt = this.CharaCnt();
                    key = 0;
                }
                if (key == 4) {
                    int[] nArray = talk_flg[machi_no];
                    nArray[1] = nArray[1] + 1;
                    if (talk_flg[machi_no][1] > 4) {
                        CpCanvas.talk_flg[CpCanvas.machi_no][1] = 0;
                    }
                    talk_cnt = this.CharaCnt();
                    key = 0;
                }
                if (key == 8) {
                    int[] nArray = talk_flg[machi_no];
                    nArray[2] = nArray[2] + 1;
                    if (talk_flg[machi_no][2] > 4) {
                        CpCanvas.talk_flg[CpCanvas.machi_no][2] = 0;
                    }
                    talk_cnt = this.CharaCnt();
                    key = 0;
                }
                if (key == 16) {
                    int[] nArray = talk_flg[machi_no];
                    nArray[3] = nArray[3] + 1;
                    if (talk_flg[machi_no][3] > 4) {
                        CpCanvas.talk_flg[CpCanvas.machi_no][3] = 0;
                    }
                    talk_cnt = this.CharaCnt();
                    key = 0;
                }
            }
        }
        g.drawImage(imgMap, 0, 0);
        if (mail_flg != 0) {
            for (n = 0; n < 4; ++n) {
                CpCanvas.drawImg3(48, n, 25 + n * 49, 5, false);
            }
            this.Basyo(m_name[machi_no], 100, 47);
            this.FaceDrawA(0, i_chara[0][talk_flg[machi_no][0]], i_chara[1][talk_flg[machi_no][1]], i_chara[2][talk_flg[machi_no][2]]);
            if (mail_cnt == 0) {
                CpCanvas.Audio(1, 13);
                CpCanvas.MesRead(37, null, 3);
                ++mail_cnt;
            }
            CpCanvas.drawImg3(44, 109, 5 + game_cnt / 2 % 3, 5, false);
            this.FaceDraw(6);
            n = CpCanvas.MesDraw(0) ? 1 : 0;
            if (key == 0x100000) {
                if (n != 0) {
                    mail_flg = 0;
                } else {
                    mes_cnt = 90;
                }
                key = 0;
            }
        } else if (machi_flg == 0) {
            CpCanvas.soft_id[0] = 2;
            CpCanvas.soft_id[1] = 4;
            for (n = 0; n < 4; ++n) {
                if (n == machi_sel) {
                    CpCanvas.drawImg3(48, n, 25 + n * 49, 8 + game_cnt / 3 % 2, false);
                    continue;
                }
                CpCanvas.drawImg3(48, n, 25 + n * 49, 5, false);
            }
            g.setColor(Graphics.getColorOfRGB((int)255, (int)0, (int)0));
            g.drawRect(26 + machi_sel * 49, 9 + game_cnt / 3 % 2, 37, 29);
            g.drawRect(25 + machi_sel * 49, 8 + game_cnt / 3 % 2, 39, 31);
            this.Basyo(m_name[machi_no], 100, 47);
            this.FaceDrawA(0, i_chara[0][talk_flg[machi_no][0]], i_chara[1][talk_flg[machi_no][1]], i_chara[2][talk_flg[machi_no][2]]);
            if (mail_flg == 0) {
                CpCanvas.MesRead(28 + machi_sel, null, 3);
                CpCanvas.MesDraw(1);
            }
        } else if (machi_flg == 1) {
            CpCanvas.soft_id[0] = 2;
            CpCanvas.soft_id[1] = 0;
            CpCanvas.drawImg3(48, 0, 25, 5, false);
            this.Basyo(m_name[machi_no], 100, 5);
            for (n = 0; n < move_ok[machi_no] && m_move[n] <= 20; ++n) {
                this.Basyo(m_name[m_move[n]], 56, 47 + n * 22);
            }
            CpCanvas.drawImg3(44, 33, 50 + game_cnt / 2 % 3, 49 + menu_cnt * 22, false);
            this.FaceDraw(6);
            CpCanvas.MesRead(32, null, 3);
            CpCanvas.MesDraw(1);
        } else if (machi_flg == 2) {
            CpCanvas.soft_id[0] = 2;
            CpCanvas.soft_id[1] = 0;
            CpCanvas.drawImg3(48, 1, 25, 5, false);
            this.Basyo(m_name[machi_no], 100, 5);
            n = this.FaceDrawA(0, i_chara[0][talk_flg[machi_no][0]], i_chara[1][talk_flg[machi_no][1]], i_chara[2][talk_flg[machi_no][2]]) - 1;
            CpCanvas.drawImg3(44, 33, face_x[n][1] - 10 + face_dx[n] * menu_cnt + game_cnt / 2 % 3, 124, false);
            this.FaceDraw(6);
            if (mail_flg == 0) {
                CpCanvas.MesRead(33, null, 3);
                CpCanvas.MesDraw(1);
            }
        } else if (machi_flg == 3) {
            CpCanvas.soft_id[0] = 2;
            CpCanvas.soft_id[1] = 0;
            CpCanvas.drawImg3(48, 2, 25, 5, false);
            this.Basyo(m_name[machi_no], 100, 5);
            for (n = 0; n < plg_ok[machi_no] && m_plg[2 + n] <= 31; ++n) {
                this.Basyo(p_name[m_plg[2 + n]], 56, 47 + n * 22);
            }
            CpCanvas.drawImg3(44, 33, 50 + game_cnt / 2 % 3, 49 + menu_cnt * 22, false);
            this.FaceDraw(6);
            CpCanvas.MesRead(35, null, 3);
            CpCanvas.MesDraw(1);
        } else if (machi_flg == 5) {
            CpCanvas.drawImg3(48, 1, 25, 5, false);
            this.Basyo(m_name[machi_no], 100, 5);
            this.FaceDrawA(0, 31, 31, 31);
            this.FaceDraw(6);
            CpCanvas.MesDraw(1);
        } else if (machi_flg == 6) {
            int n2;
            CpCanvas.drawImg3(48, 2, 25, 5, false);
            this.Basyo(m_name[machi_no], 100, 5);
            for (n2 = 0; n2 < plg_ok[machi_no] && m_plg[2 + n2] <= 31; ++n2) {
                this.Basyo(p_name[m_plg[2 + n2]], 56, 47 + n2 * 22);
            }
            CpCanvas.drawImg3(44, 33, 50 + game_cnt / 2 % 3, 49 + menu_cnt * 22, false);
            this.FaceDraw(0);
            n2 = CpCanvas.MesDraw(0) ? 1 : 0;
            if (key == 0x100000) {
                if (n2 != 0) {
                    CpCanvas.Audio(0, 0);
                    machi_flg = 0;
                    machi_cnt = 1;
                    CpCanvas.Audio(1, 14);
                    return;
                }
                mes_cnt = 90;
                key = 0;
            }
            return;
        }
        if (deba_flg != 0) {
            g.setColor(Graphics.getColorOfRGB((int)255, (int)0, (int)0));
            for (n = 0; n < 4; ++n) {
                CpCanvas.strDraw("" + m_ivent[n][talk_flg[machi_no][n]] + " : " + talk_flg[machi_no][n], 5, 55 + n * 15);
            }
        }
        if (mail_flg == 0) {
            if (key == 0x100000) {
                if (machi_flg == 0) {
                    machi_flg = machi_sel + 1;
                    menu_cnt = 0;
                    if (machi_flg == 1 && move_ok[machi_no] == 0) {
                        CpCanvas.MesRead(180, null, 3);
                        machi_flg = 5;
                    }
                    if (machi_flg == 2 && talk_cnt + talk_cnt2 == 0) {
                        CpCanvas.MesRead(34, null, 3);
                        machi_flg = 5;
                    }
                    if (machi_flg == 4) {
                        n = 0;
                        for (int i = 0; i < 4; ++i) {
                            if (talk_flg[20][i] == 0) continue;
                            n = r_ivent[talk_flg[20][i] + i * 4];
                            break;
                        }
                        machi_flg = 0;
                        this.IventRead(n, 0);
                    }
                } else if (machi_flg == 1) {
                    machi_move = 2;
                    machi_no = m_move[menu_cnt];
                } else if (machi_flg == 2) {
                    if (menu_cnt < talk_cnt) {
                        n = m_ivent[menu_cnt][talk_flg[machi_no][menu_cnt]];
                        if (n == 0) {
                            n = m_ivent[1][talk_flg[machi_no][1]];
                        }
                        this.IventRead(n, 0);
                    } else {
                        n = m_ivent[2][talk_flg[machi_no][2]];
                        this.IventRead(n, 1);
                    }
                } else if (machi_flg == 3) {
                    if (machi_no == 4) {
                        back_menu = scene;
                        if (menu_cnt == 0) {
                            this.QMake();
                            scene = 6;
                        } else {
                            this.MakeTr();
                            this.ReadTr(0);
                            scene = 8;
                        }
                    } else {
                        machi_flg = 6;
                        CpCanvas.MesRead(36, null, 3);
                    }
                } else if (machi_flg == 5) {
                    machi_flg = 0;
                    menu_cnt = 0;
                }
                key = 0;
            } else if (key == 0x200000) {
                machi_flg = 0;
                menu_cnt = 0;
                key = 0;
            } else if (key == 0x400000) {
                if (machi_flg == 0) {
                    back_menu = scene;
                    menu_no = 0;
                    menu_cnt = -1;
                    CpCanvas.MesRead(5, null, 3);
                    scene = 4;
                    menu_sel = 0;
                }
                key = 0;
            }
            if (deba_flg != 0) {
                if (key == 256) {
                    scene = 0;
                }
                key = 0;
            }
        }
    }

    public void Basyo(String string, int n, int n2) {
        g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
        g.fillRect(n, n2, 128, 18);
        g.fillRect(n + 1, n2 + 1, 128, 18);
        g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        g.fillRect(n + 1, n2 + 1, 126, 16);
        g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
        CpCanvas.strDraw(string, n + (128 - f.stringWidth(string)) / 2, n2 + 15);
    }

    public boolean PlgEfe(int n, int n2) {
        boolean bl = false;
        g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        if (n2 == 0) {
            int n3 = 120 - n * n * 5;
            if (n3 < 0) {
                n3 = 0;
            }
            int n4 = (120 - n3) * 2;
            int n5 = 118;
            if (n3 == 0) {
                n5 -= (n -= 4) * n * 3;
            }
            if (n5 < 0) {
                n5 = 0;
                if (pla_ok == 0) {
                    ++pla_ok;
                } else {
                    pla_ok = 0;
                    bl = true;
                }
            }
            int n6 = (120 - n5) * 2;
            g.fillRect(n3, n5, n4, n6);
        } else if (n2 == 1) {
            int n7 = 120 - n * n * 3;
            if (n7 < 0) {
                n7 = 0;
                if (pla_ok == 0) {
                    ++pla_ok;
                } else {
                    pla_ok = 0;
                    bl = true;
                }
            }
            int n8 = 240 - n7;
            g.fillRect(0, 0, 240, n7);
            g.fillRect(0, n8, 240, 120);
        } else if (n2 == 2) {
            int n9 = n * n * 3;
            if (n9 > 120) {
                n9 = 120;
                if (pla_ok == 0) {
                    ++pla_ok;
                } else {
                    pla_ok = 0;
                    bl = true;
                }
            }
            int n10 = 240 - n9 * 2;
            g.drawImage(imgMap, 0, 0);
            g.fillRect(0, n9, 240, n10);
        } else if (n2 == 3) {
            int n11 = n * n * 3;
            if (n11 > 120) {
                n11 = 120;
                if (pla_ok == 0) {
                    ++pla_ok;
                } else {
                    pla_ok = 0;
                    bl = true;
                }
            }
            int n12 = 240 - n11;
            g.fillRect(0, 0, 240, n11);
            g.fillRect(0, n12, 240, 120);
        }
        return bl;
    }

    public static void HpDraw(int n, int n2, int n3) {
        if (n < 0) {
            n = 0;
        }
        g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        g.fillRect(n2, n3 + 42, 40, 20);
        if (n * 4 > max_hp) {
            g.setColor(Graphics.getColorOfRGB((int)56, (int)80, (int)104));
        } else {
            g.setColor(Graphics.getColorOfRGB((int)204, (int)0, (int)0));
        }
        g.fillRect(n2 + 2, n3 + 44, 36, 16);
        CpCanvas.ImgSuu(n, n2 + 4, n3 + 47, 32, 1, 1);
    }

    public void MachiSet(int n, int n2) {
        ivent_flg = -1;
        mail_flg = 0;
        if (n2 != 0) {
            try {
                int n3;
                InputStream inputStream = CpCanvas.GetData(0);
                inputStream.skip(n * 36);
                byte[] byArray = new byte[4];
                inputStream.read(byArray);
                int n4 = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                for (n3 = 0; n3 < 5; ++n3) {
                    CpCanvas.m_move[n3] = n4 >> n3 * 5 & 0x1F;
                }
                inputStream.read(byArray);
                for (n3 = 0; n3 < 4; ++n3) {
                    CpCanvas.m_ivent[0][n3 + 1] = byArray[3 - n3] & 0xFF;
                }
                inputStream.read(byArray);
                for (n3 = 0; n3 < 4; ++n3) {
                    CpCanvas.m_ivent[1][n3 + 1] = byArray[3 - n3] & 0xFF;
                }
                inputStream.read(byArray);
                for (n3 = 0; n3 < 4; ++n3) {
                    CpCanvas.m_ivent[2][n3 + 1] = byArray[3 - n3] & 0xFF;
                }
                inputStream.read(byArray);
                for (n3 = 0; n3 < 4; ++n3) {
                    CpCanvas.m_ivent[3][n3 + 1] = byArray[3 - n3] & 0xFF;
                }
                inputStream.read(byArray);
                for (n3 = 0; n3 < 4; ++n3) {
                    CpCanvas.i_chara[0][n3 + 1] = byArray[3 - n3] & 0xFF;
                }
                inputStream.read(byArray);
                for (n3 = 0; n3 < 4; ++n3) {
                    CpCanvas.i_chara[1][n3 + 1] = byArray[3 - n3] & 0xFF;
                }
                inputStream.read(byArray);
                for (n3 = 0; n3 < 4; ++n3) {
                    CpCanvas.i_chara[2][n3 + 1] = (byArray[3 - n3] & 0xFF) + 100;
                }
                CpCanvas.i_chara[0][0] = 31;
                CpCanvas.i_chara[1][0] = 31;
                CpCanvas.i_chara[2][0] = 31;
                inputStream.read(byArray);
                for (n3 = 0; n3 < 4; ++n3) {
                    CpCanvas.m_plg[n3] = byArray[3 - n3] & 0xFF;
                }
                inputStream.close();
                inputStream = null;
                System.gc();
            }
            catch (Exception exception) {
                // empty catch block
            }
            this.ImgSet2(machi_no);
            this.IventRead(m_ivent[3][talk_flg[machi_no][3]], 0);
        }
        graMap.setColor(Graphics.getColorOfRGB((int)200, (int)200, (int)200));
        graMap.fillRect(0, 0, 240, 160);
        graMap.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
        graMap.fillRect(0, 160, 240, 80);
        graMap.fillRect(29, 57, 182, 62);
        graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        graMap.fillRect(2, 162, 236, 76);
        graMap.drawImage((Image)image[58], 30, 58);
        talk_cnt = this.CharaCnt();
        menu_cnt = 0;
        machi_sel = 0;
        machi_flg = 0;
        machi_cnt = 0;
        key = 0;
    }

    public void RockIventSet() {
        try {
            int n;
            InputStream inputStream = CpCanvas.GetData(0);
            inputStream.skip(724L);
            byte[] byArray = new byte[4];
            inputStream.read(byArray);
            for (n = 0; n < 4; ++n) {
                CpCanvas.r_ivent[n + 1] = byArray[3 - n] & 0xFF;
            }
            inputStream.read(byArray);
            for (n = 0; n < 4; ++n) {
                CpCanvas.r_ivent[n + 5] = byArray[3 - n] & 0xFF;
            }
            inputStream.read(byArray);
            for (n = 0; n < 4; ++n) {
                CpCanvas.r_ivent[n + 9] = byArray[3 - n] & 0xFF;
            }
            inputStream.read(byArray);
            for (n = 0; n < 4; ++n) {
                CpCanvas.r_ivent[n + 13] = byArray[3 - n] & 0xFF;
            }
            inputStream.close();
            inputStream = null;
            System.gc();
        }
        catch (Exception exception) {
            // empty catch block
        }
        key = 0;
    }

    public void Keiji() {
        int n;
        CpCanvas.soft_id[0] = 2;
        CpCanvas.soft_id[1] = 0;
        int n2 = this.getKeypadState();
        if ((n2 & 0x20000) == 0 && (n2 & 0x80000) == 0 && (n2 & 2) == 0 && (n2 & 0x10) == 0) {
            key_cnt = 0;
        }
        if (key_cnt > 0) {
            if (key_cnt < 4) {
                n2 = 0;
            }
            ++key_cnt;
        }
        g.drawImage(imgMap, 0, 0);
        if (key == 131072 || (n2 & 0x20000) != 0) {
            if (mes_flg == 0) {
                if (q_sel > 0 && --q_sel - q_jou < 0) {
                    --q_jou;
                }
                ++key_cnt;
            }
            key = 0;
        } else if (key == 524288 || (n2 & 0x80000) != 0) {
            if (mes_flg == 0) {
                if (q_sel < q_get - 1 && ++q_sel - q_jou >= 7) {
                    ++q_jou;
                }
                ++key_cnt;
            }
            key = 0;
        } else if (key == 2 || (n2 & 2) != 0) {
            if (mes_flg == 0) {
                if (q_jou > 0) {
                    if ((q_jou -= 7) < 0) {
                        q_sel -= 7 + q_jou;
                        q_jou = 0;
                    } else {
                        q_sel -= 7;
                    }
                }
                ++key_cnt;
            }
            key = 0;
        } else if (key == 16 || (n2 & 0x10) != 0) {
            if (mes_flg == 0) {
                if (q_jou < q_get - 7) {
                    if ((q_jou += 7) > q_get - 7) {
                        q_sel += 7 - (q_jou - (q_get - 7));
                        q_jou = q_get - 7;
                    } else {
                        q_sel += 7;
                    }
                }
                ++key_cnt;
            }
            key = 0;
        }
        int n3 = 32;
        if (q_get > 7) {
            n3 += q_jou * 92 / (q_get - 7);
        }
        CpCanvas.drawImg3(44, 34, 229, n3, false);
        g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        for (n = 6; n >= 0; --n) {
            if (q_get <= n) continue;
            int n4 = q_jou + n;
            if (quest_no == q_list[n4]) {
                CpCanvas.drawImg3(44, 127, 15, 22 + n * 17, false);
            }
            CpCanvas.strDraw(q_str[n4], 32, 35 + n * 17);
        }
        g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
        if (q_cnt > 0 || q_cnt < -2) {
            // empty if block
        }
        if (mes_flg == 0) {
            CpCanvas.drawImg3(44, 33, 5 + game_cnt / 2 % 3, 23 + (q_sel - q_jou) * 17, false);
        }
        if (yes_no_flg != 0) {
            if (key == 65536) {
                yes_no_flg = 1;
                key = 0;
            } else if (key == 262144) {
                yes_no_flg = 2;
                key = 0;
            }
        }
        if (q_cnt == -5) {
            key = 0;
            while (key == 0) {
            }
            CpCanvas.MesRead(160, null, 3);
            q_cnt = -6;
            yes_no_flg = 1;
            key = 0;
            return;
        }
        if (q_cnt == -6) {
            if (key == 0x100000) {
                if (yes_no_flg == 1) {
                    q_cnt = -4;
                    CpCanvas.MesRead(63, null, 3);
                    this.FaceDraw(6);
                    mes_draw = 1;
                } else {
                    CpCanvas.MesRead(98, null, 3);
                    yes_no_flg = 0;
                    q_cnt = -7;
                }
                yes_no_flg = 0;
                key = 0;
            }
            if (yes_no_flg != 0) {
                CpCanvas.drawImg3(44, 33, 55 + (yes_no_flg - 1) * 96 + game_cnt / 2 % 3, 207, false);
            }
            CpCanvas.MesDraw(1);
            return;
        }
        if (q_cnt == -7) {
            key = 0;
            while (key == 0) {
            }
            IApplication.getCurrentApp().terminate();
        }
        if (q_cnt == -4) {
            http_error = 0;
            if (http_error == 0 || http_error == 3) {
                n = http_error;
                CpCanvas.dat[39] = 2;
                CpCanvas.dat[38] = q_list[q_sel];
                CpCanvas.writeSP();
                this.QDawn(0, dat[38]);
                if (http_error == 0) {
                    tmp_point = site_point;
                    quest_no = dat[38];
                    this.Save(0);
                    if (n == 0) {
                        CpCanvas.MesRead(68, null, 3);
                    } else {
                        CpCanvas.MesRead(193, null, 3);
                    }
                    yes_no_flg = 0;
                    mes_draw = 1;
                    mes_flg = 1;
                    q_sel = 0;
                    q_jou = 0;
                    q_cnt = 2;
                    CpCanvas.dat[39] = 0;
                    CpCanvas.writeSP();
                } else {
                    CpCanvas.MesRead(58, null, 3);
                    yes_no_flg = 0;
                    q_cnt = -5;
                    http_error = 0;
                }
            } else if (http_error == 1) {
                CpCanvas.MesRead(58, null, 3);
                yes_no_flg = 0;
                q_cnt = 2;
                http_error = 0;
            } else if (http_error == 2) {
                tmp_point = site_point;
                CpCanvas.MesRead(65, null, 3);
                yes_no_flg = 0;
                q_cnt = 2;
            } else if (http_error == 15) {
                CpCanvas.MesRead(161, null, 3);
                yes_no_flg = 0;
                CpCanvas.dat[50] = -1;
                CpCanvas.writeSP();
                q_cnt = 2;
            }
            key = 0;
        } else if (q_cnt == -2) {
            this.QAll();
            if (http_error == 0) {
                if (q_get == 0) {
                    CpCanvas.MesRead(66, null, 3);
                    mes_flg = 1;
                    q_cnt = 1;
                } else {
                    this.GetQTit();
                    CpCanvas.MesRead(54, null, 3);
                    mes_flg = 0;
                    q_sel = 0;
                    q_jou = 0;
                    q_cnt = 3;
                }
                yes_no_flg = 0;
                mes_draw = 1;
            } else if (http_error == 1) {
                q_get = 0;
                CpCanvas.MesRead(58, null, 3);
                yes_no_flg = 0;
                mes_flg = 1;
                mes_draw = 1;
                q_cnt = 1;
                http_error = 0;
            } else if (http_error == 15) {
                q_get = 0;
                CpCanvas.MesRead(161, null, 3);
                yes_no_flg = 0;
                mes_flg = 1;
                mes_draw = 1;
                q_cnt = 1;
                http_error = 0;
                CpCanvas.dat[50] = -1;
                CpCanvas.writeSP();
                q_cnt = 1;
            }
            key = 0;
        }
        if (q_cnt < 4 || q_cnt > 7 && q_cnt < 13) {
            this.FaceDraw(6);
        }
        n = CpCanvas.MesDraw(mes_draw) ? 1 : 0;
        if (q_cnt == -3) {
            --q_cnt;
        } else if (q_cnt == -1) {
            --q_cnt;
        }
        if (key == 0x100000) {
            if (n != 0) {
                if (q_cnt == 0) {
                    if (yes_no_flg == 1) {
                        CpCanvas.MesRead(69, null, 3);
                        yes_no_flg = 0;
                        mes_flg = 1;
                        mes_draw = 1;
                        q_cnt = -1;
                    } else {
                        CpCanvas.MesRead(57, null, 3);
                        yes_no_flg = 0;
                        mes_flg = 1;
                        mes_draw = 1;
                        q_cnt = 1;
                    }
                } else if (q_cnt == 1) {
                    yes_no_flg = 0;
                    mes_draw = 0;
                    mes_flg = 0;
                    this.MachiSet(machi_no, 0);
                    scene = 5;
                } else if (q_cnt == 2) {
                    CpCanvas.MesRead(54, null, 3);
                    yes_no_flg = 0;
                    mes_flg = 0;
                    mes_draw = 1;
                    q_sel = 0;
                    q_jou = 0;
                    q_cnt = 3;
                } else if (q_cnt >= 3 && q_cnt <= 7) {
                    if (q_cnt == 3 && q_list[q_sel] == quest_no) {
                        CpCanvas.MesRead(60, null, 3);
                        yes_no_flg = 1;
                        mes_flg = 1;
                        mes_draw = 0;
                        q_cnt = 10;
                    } else {
                        CpCanvas.MesRead(q_sel * 3 + q_cnt - 3, null, 6);
                        yes_no_flg = 0;
                        mes_flg = 1;
                        mes_draw = 0;
                        if (++q_cnt > 6) {
                            q_cnt = 8;
                            CpCanvas.MesRead(4, null, 10);
                            yes_no_flg = 1;
                        }
                    }
                } else if (q_cnt == 8) {
                    if (yes_no_flg == 1) {
                        if (quest_no > 0 && quest_flg == 0) {
                            CpCanvas.MesRead(59, null, 3);
                            yes_no_flg = 0;
                            q_cnt = 9;
                        } else {
                            CpCanvas.MesRead(63, null, 3);
                            mes_draw = 1;
                            q_cnt = -3;
                            this.Save(0);
                        }
                    } else {
                        CpCanvas.MesRead(54, null, 3);
                        yes_no_flg = 0;
                        mes_draw = 1;
                        mes_flg = 0;
                        q_cnt = 3;
                    }
                } else if (q_cnt == 9) {
                    CpCanvas.MesRead(60, null, 3);
                    yes_no_flg = 1;
                    ++q_cnt;
                } else if (q_cnt == 10) {
                    if (yes_no_flg == 1) {
                        CpCanvas.MesRead(this.QNo(), null, 6);
                        mes_flg = 1;
                        mes_draw = 0;
                        q_cnt = 13;
                    } else {
                        CpCanvas.MesRead(61, null, 3);
                        ++q_cnt;
                    }
                    yes_no_flg = 0;
                } else if (q_cnt == 11) {
                    CpCanvas.MesRead(62, null, 3);
                    yes_no_flg = 2;
                    ++q_cnt;
                } else if (q_cnt == 12) {
                    if (yes_no_flg == 1) {
                        CpCanvas.dat[39] = 4;
                        CpCanvas.writeSP();
                        this.QClear();
                        quest_flg = 0;
                        quest_no = 0;
                        this.Save(0);
                        CpCanvas.dat[39] = 0;
                        CpCanvas.writeSP();
                        CpCanvas.MesRead(64, null, 3);
                        yes_no_flg = 0;
                        q_cnt = 2;
                    } else {
                        CpCanvas.MesRead(60, null, 3);
                        yes_no_flg = 1;
                        q_cnt = 10;
                    }
                } else if (q_cnt >= 13) {
                    CpCanvas.MesRead(this.QNo() + q_cnt - 12, null, 6);
                    yes_no_flg = 0;
                    mes_flg = 1;
                    mes_draw = 0;
                    if (++q_cnt > 15) {
                        CpCanvas.MesRead(54, null, 3);
                        yes_no_flg = 0;
                        mes_flg = 0;
                        mes_draw = 1;
                        q_cnt = 3;
                    }
                }
            } else {
                mes_cnt = 90;
            }
            key = 0;
        }
        if (key == 0x200000) {
            if (n != 0) {
                if (q_cnt == 0 || q_cnt == 1 || q_cnt == 3) {
                    yes_no_flg = 0;
                    mes_draw = 0;
                    mes_flg = 0;
                    this.MachiSet(machi_no, 0);
                    scene = 5;
                } else {
                    CpCanvas.MesRead(54, null, 3);
                    yes_no_flg = 0;
                    mes_draw = 1;
                    mes_flg = 0;
                    q_sel = 0;
                    q_jou = 0;
                    q_cnt = 3;
                }
            } else {
                mes_cnt = 90;
            }
            key = 0;
        }
    }

    public void QAll() {
        int n;
        if (quest_flg == 1) {
            int n2 = (quest_no - 1) / 32;
            q_flg[n2] = q_flg[n2] | 1 << 31 - (quest_no - 1) % 32;
            if (q_flg[0] == -1 && q_flg[1] == -2) {
                CpCanvas.dat[63] = 1;
                CpCanvas.writeSP();
            }
            quest_flg = 0;
            quest_no = 0;
            this.QClear();
            this.Save(0);
        }
        q_get = 0;
        http_error = 1;
        Object var1_1 = null;
        Object var2_2 = null;
        OutputStream outputStream = null;
        System.gc();
        byte[] byArray = new byte[8];
        byte[] byArray2 = new byte[3010];
        for (n = 0; n < 8; n += 4) {
            byArray[n] = (byte)(q_flg[n >> 2] >>> 24 & 0xFF);
            byArray[n + 1] = (byte)(q_flg[n >> 2] >>> 16 & 0xFF);
            byArray[n + 2] = (byte)(q_flg[n >> 2] >>> 8 & 0xFF);
            byArray[n + 3] = (byte)(q_flg[n >> 2] & 0xFF);
        }
        n = sina_no;
        if (dat[58] != 0) {
            ++n;
        }
        http_error = 0;
        byArray2 = CpCanvas.qestGet(n, byArray);
        for (int i = 0; i < 10; ++i) {
            int n3;
            CpCanvas.q_list[i] = n3 = byArray2[i];
            if (n3 <= 0) continue;
            ++q_get;
        }
        try {
            outputStream = Connector.openOutputStream((String)("scratchpad:///0;pos=" + (dat[48] + 34120)));
            outputStream.write(byArray2, 10, 3000);
            outputStream.flush();
            outputStream.close();
            outputStream = null;
            System.gc();
        }
        catch (Exception exception) {
            http_error = 1;
        }
    }

    public static byte[] qestGet(int n, byte[] byArray) {
        byte[] byArray2 = new byte[3010];
        InputStream inputStream = null;
        byArray2 = CpCanvas.qestNo(n, byArray);
        byte[] byArray3 = new byte[360];
        try {
            inputStream = Connector.openInputStream((String)"resource:///data/quest/quest.dat");
            for (int i = 0; i < 10; ++i) {
                int n2 = byArray2[i] - 1;
                if (i > 0) {
                    n2 -= byArray2[i - 1];
                }
                inputStream.skip(n2 * 360);
                byArray3 = new byte[360];
                inputStream.read(byArray3);
                for (int j = 0; j < 300; ++j) {
                    byArray2[10 + i * 300 + j] = byArray3[60 + j];
                }
            }
        }
        catch (Exception exception) {
            System.out.println(str + "   e:" + exception);
        }
        return byArray2;
    }

    public static byte[] qestNo(int n, byte[] byArray) {
        int[] nArray = new int[]{1, 0, 1, 1, 0, 2, 1, 0, 3, 1, 0, 4, 1, 0, 5, 1, 0, 6, 1, 0, 7, 2, 0, 8, 2, 0, 9, 2, 0, 10, 2, 0, 11, 2, 0, 12, 2, 0, 13, 2, 0, 14, 3, 0, 15, 3, 0, 16, 3, 0, 17, 3, 0, 18, 3, 12, 19, 3, 7, 20, 3, 14, 21, 4, 0, 22, 4, 0, 23, 4, 0, 24, 4, 0, 25, 4, 19, 26, 4, 13, 27, 4, 21, 28, 5, 0, 29, 5, 0, 30, 5, 0, 31, 5, 18, 32, 5, 26, 33, 5, 20, 34, 5, 28, 35, 6, 0, 36, 6, 0, 37, 6, 0, 38, 6, 0, 39, 6, 17, 40, 6, 31, 41, 6, 35, 42, 7, 27, 43, 7, 0, 44, 7, 0, 45, 7, 32, 46, 7, 34, 47, 7, 0, 48, 7, 42, 49, 8, 9, 50, 8, 0, 51, 8, 0, 52, 8, 38, 53, 8, 0, 54, 8, 33, 55, 8, 49, 56, 9, 0, 57, 9, 0, 58, 9, 46, 59, 9, 43, 60, 9, 47, 61, 9, 56, 62, 9, 62, 63};
        byte[] byArray2 = new byte[3010];
        int n2 = 0;
        for (int i = 0; i < 63; ++i) {
            int n3 = nArray[i * 3 + 0];
            int n4 = nArray[i * 3 + 1];
            int n5 = nArray[i * 3 + 2];
            if (CpCanvas.qestOK(n5, byArray) || n < n3) continue;
            if (n4 > 0) {
                if (!CpCanvas.qestOK(n4, byArray)) continue;
                byArray2[n2] = (byte)n5;
                ++n2;
                continue;
            }
            byArray2[n2] = (byte)n5;
            ++n2;
        }
        return byArray2;
    }

    public static boolean qestOK(int n, byte[] byArray) {
        int n2;
        int n3;
        boolean bl = false;
        if ((n3 = byArray[n2 = --n / 8] >> 7 - n % 8 & 1) != 0) {
            bl = true;
        }
        return bl;
    }

    public int QNo() {
        for (int i = 0; i < 10; ++i) {
            if (q_list[i] != quest_no) continue;
            return i * 3;
        }
        return 0;
    }

    public void QMake() {
        CpCanvas.drawImg3(44, 0, 0, 0, true);
        graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
        graMap.fillRect(4, 20, 232, 119);
        graMap.setColor(Graphics.getColorOfRGB((int)96, (int)112, (int)192));
        for (int i = 0; i < 3; ++i) {
            graMap.fillRect(4, 37 + i * 34, 232, 17);
        }
        graMap.setColor(Graphics.getColorOfRGB((int)255, (int)240, (int)0));
        CpCanvas.strDrawG(p_name[30], 8, 17);
        graMap.setColor(Graphics.getColorOfRGB((int)240, (int)248, (int)248));
        graMap.fillRect(228, 20, 1, 122);
        graMap.setColor(Graphics.getColorOfRGB((int)200, (int)224, (int)248));
        graMap.fillRect(4, 139, 232, 17);
        graMap.fillRect(229, 20, 7, 122);
        graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        graMap.fillRect(2, 162, 236, 76);
        CpCanvas.drawImg3(44, 3, 228, 27, true);
        CpCanvas.drawImg3(44, 68, 229, 15, true);
        CpCanvas.drawImg3(44, 69, 229, 143, true);
        if (quest_no == 0 || quest_flg == 1) {
            q_sel = 0;
            q_jou = 0;
            q_get = 0;
            mes_flg = 1;
            this.QAll();
            if (q_get == 0) {
                CpCanvas.MesRead(66, null, 3);
                mes_flg = 1;
                q_cnt = 1;
            } else {
                this.GetQTit();
                CpCanvas.MesRead(54, null, 3);
                mes_flg = 0;
                q_sel = 0;
                q_jou = 0;
                q_cnt = 3;
            }
            yes_no_flg = 0;
            mes_draw = 1;
        } else {
            this.GetQTit();
            CpCanvas.MesRead(54, null, 3);
            yes_no_flg = 0;
            mes_draw = 1;
            mes_flg = 0;
            q_sel = 0;
            q_jou = 0;
            q_cnt = 3;
        }
    }

    public void Shop() {
        int n;
        int n2;
        int n3;
        CpCanvas.soft_id[0] = 2;
        CpCanvas.soft_id[1] = 0;
        int n4 = this.getKeypadState();
        if ((n4 & 0x20000) == 0 && (n4 & 0x80000) == 0 && (n4 & 2) == 0 && (n4 & 0x10) == 0) {
            key_cnt = 0;
        }
        if (key_cnt > 0) {
            if (key_cnt < 4) {
                n4 = 0;
            }
            ++key_cnt;
        }
        g.drawImage(imgMap, 0, 0);
        if (mes_flg == 0) {
            if (key == 131072 || (n4 & 0x20000) != 0) {
                if (sel_tip2 > 0 && --sel_tip2 - sel_jou2 < 0) {
                    --sel_jou2;
                }
                ++key_cnt;
                key = 0;
            } else if (key == 524288 || (n4 & 0x80000) != 0) {
                if (sel_tip2 < zai_cnt - 1 && ++sel_tip2 - sel_jou2 >= 7) {
                    ++sel_jou2;
                }
                ++key_cnt;
                key = 0;
            } else if (key == 2 || (n4 & 2) != 0) {
                if (sel_jou2 > 0) {
                    if ((sel_jou2 -= 7) < 0) {
                        sel_tip2 -= 7 + sel_jou2;
                        sel_jou2 = 0;
                    } else {
                        sel_tip2 -= 7;
                    }
                }
                ++key_cnt;
                key = 0;
            } else if (key == 16 || (n4 & 0x10) != 0) {
                if (sel_jou2 < zai_cnt - 7) {
                    if ((sel_jou2 += 7) > zai_cnt - 7) {
                        sel_tip2 += 7 - (sel_jou2 - (zai_cnt - 7));
                        sel_jou2 = zai_cnt - 7;
                    } else {
                        sel_tip2 += 7;
                    }
                }
                ++key_cnt;
                key = 0;
            } else if (key == 0x100000) {
                mes_flg = 1;
                yes_no_flg = 1;
                n3 = sh_list[sel_tip2];
                str = sh_syu[n3] == 3 ? this.ItemName(sh_syu[n3], sh_id[n3] / 5) : this.ItemName(sh_syu[n3], sh_id[n3]);
                CpCanvas.MesRead(100, str.getBytes(), 3);
                key = 0;
            }
        }
        for (n2 = 6; n2 >= 0; --n2) {
            int n5;
            n3 = sh_list[sel_jou2 + n2];
            if (sel_jou2 + n2 >= zai_cnt) continue;
            if (sh_syu[n3] == 0) {
                n = tip_list[sh_id[n3]] >> 8 & 0xFF;
                n5 = tip_list[sh_id[n3]] & 0xFF;
                tip[n].Draw(11, 10 + n2 * 16, 1, true);
                g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
                tip[n].DrawName(28, 22 + n2 * 16);
                tip[n].DrawCode(n5, 136, 22 + n2 * 16, 1);
            }
            if (sh_syu[n3] == 3) {
                n = skill_list[sh_id[n3]] & 0xFF;
                n5 = skill_list[sh_id[n3]] >> 8 & 0xFF;
                CpCanvas.drawImg3(51 + n5, n, 11, 10 + n2 * 16, false);
                CpCanvas.strDraw(CpCanvas.skill[CpCanvas.sh_id[n3] / 5].name, 28, 22 + n2 * 16);
            }
            if (sh_syu[n3] == 4) {
                CpCanvas.strDraw(menu_str[2], 28, 22 + n2 * 16);
            }
            if (sh_syu[n3] == 6) {
                CpCanvas.strDraw(menu_str[25], 28, 22 + n2 * 16);
            }
            if (shop_syu == 1) {
                CpCanvas.strDraw(sh_kin[n3] + "\uff7a", 206 - f.stringWidth(sh_kin[n3] + "\uff7a"), 22 + n2 * 16);
                continue;
            }
            CpCanvas.strDraw(sh_kin[n3] + "z", 206 - f.stringWidth(sh_kin[n3] + "z"), 22 + n2 * 16);
        }
        n3 = sh_list[sel_tip2];
        if (zai_cnt > 0) {
            if (sh_syu[n3] == 0) {
                n = tip_list[sh_id[n3]] >> 8 & 0xFF;
                tip[n].DrawPow(50, 137);
                tip[n].DrawZoku(123, 135);
                CpCanvas.drawImg3(44, 65 + n / 125 + n / 177, 102, 152, false);
                if (mes_flg == 0 && key_cnt < 5) {
                    CpCanvas.MesRead(CpCanvas.tip[n].setu_id, null, 4);
                    tip[n].DrawSetu();
                }
            }
            if (sh_syu[n3] == 3) {
                g.drawImage(tmp_imgMap, 4, 131, 0, 0, 140, 27);
                CpCanvas.ImgSuu(CpCanvas.skill[CpCanvas.sh_id[n3] / 5].you, 50, 137, 16, 1, 1);
                CpCanvas.drawImg3(44, 25 + sh_id[n3] % 5, 123, 135, false);
                if (mes_flg == 0 && key_cnt < 5) {
                    CpCanvas.MesRead(sh_id[n3] / 5, null, 5);
                    CpCanvas.MesDraw(2);
                }
            }
            if (sh_syu[n3] == 4) {
                g.drawImage(tmp_imgMap, 4, 131, 0, 30, 140, 27);
                if (mes_flg == 0 && key_cnt < 5) {
                    CpCanvas.MesRead(111, null, 3);
                    CpCanvas.MesDraw(1);
                }
            }
            if (sh_syu[n3] == 6) {
                g.drawImage(tmp_imgMap, 4, 131, 0, 30, 140, 27);
                if (mes_flg == 0 && key_cnt < 5) {
                    CpCanvas.MesRead(110, null, 3);
                    CpCanvas.MesDraw(1);
                }
            }
        }
        if (sel_jou2 != 0) {
            CpCanvas.drawImg3(44, 115, 105, 5, false);
        }
        if (sel_jou2 + 7 < zai_cnt) {
            CpCanvas.drawImg3(44, 114, 105, 120, false);
        }
        if (mes_flg == 0) {
            CpCanvas.drawImg3(44, 33, 1 + game_cnt / 2 % 3, 10 + (sel_tip2 - sel_jou2) * 16, false);
        }
        if (mes_flg != 0) {
            if (mes_flg == 1) {
                if (key == 65536) {
                    yes_no_flg = 1;
                    key = 0;
                } else if (key == 262144) {
                    yes_no_flg = 2;
                    key = 0;
                }
                if (key == 0x100000) {
                    if (yes_no_flg == 1) {
                        n = 1;
                        if (shop_syu == 1) {
                            n = 2;
                        }
                        n2 = zenny;
                        int n6 = piece;
                        if (this.GetItem(n, 1, sh_kin[n3]) == 0) {
                            if (this.GetItem(sh_syu[n3], 0, sh_id[n3]) == 0) {
                                if (shop_syu == 2) {
                                    mes_flg = 5;
                                    this.FaceDraw(9);
                                    CpCanvas.MesRead(102, null, 3);
                                } else {
                                    ++mes_flg;
                                    if (sh_zai[shop_id][n3] < 100) {
                                        int[] nArray = sh_zai[shop_id];
                                        int n7 = n3;
                                        nArray[n7] = nArray[n7] - 1;
                                    }
                                    CpCanvas.MesRead(0, str.getBytes(), 3);
                                    CpCanvas.Audio(1, 11);
                                }
                            } else {
                                zenny = n2;
                                piece = n6;
                                mes_flg = 4;
                            }
                        } else {
                            zenny = n2;
                            piece = n6;
                            mes_flg = 3;
                        }
                    } else {
                        mes_flg = 0;
                    }
                    yes_no_flg = 0;
                    key = 0;
                }
                if (mes_flg == 1 || mes_flg == 3 || mes_flg == 4) {
                    this.FaceDraw(6);
                }
            } else if (mes_flg == 2) {
                CpCanvas.MesRead(0, str.getBytes(), 3);
                CpCanvas.drawImg3(44, 108, 225, 222 + game_cnt / 3 % 2, false);
                if (key == 0x100000) {
                    this.ShSort();
                    mes_flg = 0;
                    key = 0;
                }
            } else if (mes_flg == 3) {
                n = 104;
                if (shop_syu == 1) {
                    n = 109;
                }
                CpCanvas.MesRead(n, null, 3);
                this.FaceDraw(6);
                CpCanvas.drawImg3(44, 108, 225, 222 + game_cnt / 3 % 2, false);
                if (key == 0x100000) {
                    mes_flg = 0;
                    key = 0;
                }
            } else if (mes_flg == 4) {
                CpCanvas.MesRead(112, null, 3);
                this.FaceDraw(6);
                CpCanvas.drawImg3(44, 108, 225, 222 + game_cnt / 3 % 2, false);
                if (key == 0x100000) {
                    mes_flg = 0;
                    key = 0;
                }
            } else if (mes_flg == 5) {
                this.FaceDraw(9);
                CpCanvas.drawImg3(44, 108, 225, 222 + game_cnt / 3 % 2, false);
                if (key == 0x100000) {
                    ++mes_flg;
                    key = 0;
                }
            } else if (mes_flg == 6) {
                CpCanvas.MesRead(103, null, 3);
                if (key == 0x100000) {
                    mes_flg = 2;
                    CpCanvas.MesRead(0, str.getBytes(), 3);
                    CpCanvas.Audio(1, 11);
                    key = 0;
                } else {
                    CpCanvas.drawImg3(44, 108, 225, 222 + game_cnt / 3 % 2, false);
                }
            }
            CpCanvas.MesDraw(1);
            if (yes_no_flg != 0) {
                CpCanvas.drawImg3(44, 33, 55 + (yes_no_flg - 1) * 96 + game_cnt / 2 % 3, 207, false);
            }
        }
        if (shop_syu == 1) {
            CpCanvas.ImgSuu(piece, 158, 143, 63, 1, 1);
        } else {
            CpCanvas.ImgSuu(zenny, 158, 143, 63, 1, 1);
        }
        if (key == 0x200000) {
            if (mes_flg == 0) {
                this.MachiSet(machi_no, 0);
                scene = back_menu;
            }
            key = 0;
        }
    }

    public void MakeSh() {
        graMap.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
        graMap.fillRect(0, 0, 240, 240);
        graMap.setColor(Graphics.getColorOfRGB((int)168, (int)168, (int)168));
        graMap.fillRect(2, 2, 236, 158);
        graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        graMap.fillRect(2, 162, 236, 76);
        graMap.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
        graMap.fillRect(2, 2, 216, 127);
        graMap.setColor(Graphics.getColorOfRGB((int)168, (int)168, (int)168));
        graMap.fillRect(2, 2, 215, 126);
        graMap.setColor(Graphics.getColorOfRGB((int)112, (int)112, (int)112));
        graMap.fillRect(3, 3, 214, 125);
        graMap.setColor(Graphics.getColorOfRGB((int)136, (int)136, (int)136));
        graMap.fillRect(3, 3, 213, 124);
        graMap.setColor(Graphics.getColorOfRGB((int)248, (int)240, (int)200));
        graMap.fillRect(7, 7, 205, 116);
        graMap.setColor(Graphics.getColorOfRGB((int)232, (int)224, (int)192));
        graMap.fillRect(7, 25, 205, 16);
        graMap.fillRect(7, 57, 205, 16);
        graMap.fillRect(7, 89, 205, 16);
        graMap.setColor(Graphics.getColorOfRGB((int)240, (int)240, (int)248));
        graMap.fillRect(3, 130, 142, 29);
        graMap.setColor(Graphics.getColorOfRGB((int)136, (int)136, (int)144));
        graMap.fillRect(4, 131, 140, 20);
        graMap.setColor(Graphics.getColorOfRGB((int)96, (int)96, (int)104));
        graMap.fillRect(4, 151, 140, 7);
        CpCanvas.drawImg3(44, 112, 5, 133, true);
        CpCanvas.drawImg3(44, 113, 76, 133, true);
        CpCanvas.drawImg3(44, 111, 70, 152, true);
        CpCanvas.drawImg3(44, 48, 147, 129, true);
        if (shop_syu == 1) {
            CpCanvas.drawImg3(44, 51, 151, 132, true);
            CpCanvas.drawImg3(44, 43, 222, 146, true);
        } else {
            CpCanvas.drawImg3(44, 50, 151, 132, true);
            CpCanvas.drawImg3(44, 42, 222, 146, true);
        }
        tmp_graMap.setColor(Graphics.getColorOfRGB((int)136, (int)136, (int)144));
        tmp_graMap.fillRect(0, 0, 140, 20);
        tmp_graMap.setColor(Graphics.getColorOfRGB((int)96, (int)96, (int)104));
        tmp_graMap.fillRect(0, 20, 140, 7);
        CpCanvas.drawImg4(44, 117, 1, 2);
        CpCanvas.drawImg4(44, 113, 72, 2);
        tmp_graMap.setColor(Graphics.getColorOfRGB((int)136, (int)136, (int)144));
        tmp_graMap.fillRect(0, 30, 140, 20);
        tmp_graMap.setColor(Graphics.getColorOfRGB((int)96, (int)96, (int)104));
        tmp_graMap.fillRect(0, 50, 140, 7);
    }

    public void ReadSh(int n) {
        shop_id = n;
        byte[] byArray = new byte[4];
        try {
            if (n < 8) {
                int n2;
                int n3;
                shop_syu = n / 6;
                InputStream inputStream = CpCanvas.JarGet(34);
                if (sh_zai[0][0] == 0) {
                    for (n3 = 0; n3 < 8; ++n3) {
                        for (n2 = 0; n2 < 12; n2 += 4) {
                            inputStream.read(byArray);
                            CpCanvas.sh_zai[n3][n2] = byArray[3];
                            CpCanvas.sh_zai[n3][n2 + 1] = byArray[2];
                            CpCanvas.sh_zai[n3][n2 + 2] = byArray[1];
                            CpCanvas.sh_zai[n3][n2 + 3] = byArray[0];
                        }
                    }
                } else {
                    inputStream.skip(96L);
                }
                inputStream.skip(48 * n);
                for (n3 = 0; n3 < 12; ++n3) {
                    inputStream.read(byArray);
                    n2 = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                    CpCanvas.sh_syu[n3] = n2 & 0xF;
                    CpCanvas.sh_id[n3] = n2 >> 4 & 0x3FF;
                    CpCanvas.sh_kin[n3] = n2 >> 14 & 0xFFFF;
                }
                inputStream.close();
                inputStream = null;
                System.gc();
            } else {
                shop_syu = 2;
                InputStream inputStream = CpCanvas.JarGet(16);
                for (int i = 0; i < 175; ++i) {
                    inputStream.read(byArray);
                    int n4 = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                    CpCanvas.sh_syu[i] = 0;
                    CpCanvas.sh_id[i] = n4 & 0xFFFF;
                    CpCanvas.sh_kin[i] = n4 >> 16 & 0xFFFF;
                }
                inputStream.close();
                inputStream = null;
                System.gc();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        sel_tip2 = 0;
        sel_jou2 = 0;
        this.ShSort();
    }

    public void ShSort() {
        int n = 0;
        if (shop_syu != 2) {
            for (int i = 0; i < 12; ++i) {
                CpCanvas.sh_list[i] = 0;
                if (sh_zai[shop_id][i] <= 0) continue;
                CpCanvas.sh_list[n] = i;
                ++n;
            }
        } else {
            for (int i = 0; i < 175; ++i) {
                CpCanvas.sh_list[i] = 0;
                if (get_list[i + 2] <= 0) continue;
                CpCanvas.sh_list[n] = i;
                ++n;
            }
        }
        if ((zai_cnt = n) >= 7 && zai_cnt - sel_jou2 < 7) {
            --sel_tip2;
            --sel_jou2;
        }
        if (zai_cnt <= sel_tip2) {
            --sel_tip2;
        }
    }

    public void Trader() {
        int n;
        int n2;
        int n3;
        int n4 = this.getKeypadState();
        CpCanvas.soft_id[0] = 2;
        CpCanvas.soft_id[1] = 0;
        if ((n4 & 0x20000) == 0 && (n4 & 0x80000) == 0 && (n4 & 2) == 0 && (n4 & 0x10) == 0) {
            key_cnt = 0;
        }
        if (key_cnt > 0) {
            if (key_cnt < 4) {
                n4 = 0;
            }
            ++key_cnt;
        }
        g.drawImage(imgMap, 0, 0);
        if (mes_flg == 0) {
            if (key == 131072 || (n4 & 0x20000) != 0) {
                if (sel_tip2 > 0 && --sel_tip2 - sel_jou2 < 0) {
                    --sel_jou2;
                }
                ++key_cnt;
                key = 0;
            } else if (key == 524288 || (n4 & 0x80000) != 0) {
                if (sel_tip2 < get_tip - 1 && ++sel_tip2 - sel_jou2 >= 7) {
                    ++sel_jou2;
                }
                ++key_cnt;
                key = 0;
            } else if (key == 2 || (n4 & 2) != 0) {
                if (sel_jou2 > 0) {
                    if ((sel_jou2 -= 7) < 0) {
                        sel_tip2 -= 7 + sel_jou2;
                        sel_jou2 = 0;
                    } else {
                        sel_tip2 -= 7;
                    }
                }
                ++key_cnt;
                key = 0;
            } else if (key == 16 || (n4 & 0x10) != 0) {
                if (sel_jou2 < get_tip - 7) {
                    if ((sel_jou2 += 7) > get_tip - 7) {
                        sel_tip2 += 7 - (sel_jou2 - (get_tip - 7));
                        sel_jou2 = get_tip - 7;
                    } else {
                        sel_tip2 += 7;
                    }
                }
                ++key_cnt;
                key = 0;
            } else if (key == 0x100000) {
                if (get_tip > 0) {
                    CpCanvas.Audio(1, 11);
                    this.TrIO(1);
                    if (in_cnt == tr_max) {
                        mes_flg = 1;
                        yes_no_flg = 1;
                        str = "" + tr_max;
                        CpCanvas.MesRead(105, str.getBytes(), 3);
                    }
                } else {
                    CpCanvas.Audio(1, 12);
                }
                key = 0;
            }
        }
        int n5 = 43;
        if (get_tip > 7) {
            n5 += sel_jou2 * 92 / (get_tip - 7);
        }
        CpCanvas.drawImg3(44, 34, 171, n5, false);
        for (n3 = 6; n3 >= 0; --n3) {
            if (get_tip <= n3) continue;
            n2 = tip_list[sort_list[sel_jou2 + n3]] >> 8 & 0xFF;
            n = tip_list[sort_list[sel_jou2 + n3]] & 0xFF;
            tip[n2].Draw(12, 41 + n3 * 15, 1, true);
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            tip[n2].DrawName(28, 54 + n3 * 15);
            tip[n2].DrawZoku(127, 41 + n3 * 15);
            tip[n2].DrawCode(n, 143, 54 + n3 * 15, 1);
            n2 = tip_list[sort_list[sel_jou2 + n3]] >> 16 & 0xFF;
            if (n2 > 9) {
                CpCanvas.strDraw("" + n2, 157, 54 + n3 * 15);
                continue;
            }
            CpCanvas.strDraw("" + n2, 163, 54 + n3 * 15);
        }
        for (n3 = 6; n3 >= 0; --n3) {
            int n6 = n3;
            if (in_cnt > 6) {
                n6 += in_cnt - 7;
            }
            if (in_cnt <= n3) continue;
            n2 = tip_list[set_t[n6]] >> 8 & 0xFF;
            n = tip_list[set_t[n6]] & 0xFF;
            tip[n2].Draw(191, 41 + n3 * 15, 1, true);
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            tip[n2].DrawCode(n, 209, 54 + n3 * 15, 1);
        }
        n2 = tip_list[sort_list[sel_tip2]] >> 8 & 0xFF;
        if (mes_flg == 0) {
            str = "" + tr_max;
            CpCanvas.MesRead(137, str.getBytes(), 3);
            CpCanvas.MesDraw(1);
            CpCanvas.drawImg3(44, 33, 1 + game_cnt / 2 % 3, 41 + (sel_tip2 - sel_jou2) * 15, false);
        } else {
            if (yes_no_flg != 0) {
                if (key == 65536) {
                    yes_no_flg = 1;
                    key = 0;
                } else if (key == 262144) {
                    yes_no_flg = 2;
                    key = 0;
                }
            }
            if (mes_flg == 1) {
                this.FaceDraw(6);
                if (key == 0x100000) {
                    if (yes_no_flg == 1) {
                        ++mes_flg;
                        for (n3 = 0; n3 < 10; ++n3) {
                            CpCanvas.set_t[n3] = 0;
                        }
                        get_tr = this.GetTr(tr_max / 10);
                        CpCanvas.MesRead(106, null, 3);
                        in_cnt = 0;
                    } else {
                        this.TrIO(0);
                        mes_flg = 0;
                    }
                    yes_no_flg = 0;
                    key = 0;
                }
            } else if (mes_flg == 2) {
                CpCanvas.MesRead(106, null, 3);
                if (key == 0x100000) {
                    ++mes_flg;
                    this.GetItem(0, 0, get_tr);
                    this.Save(0);
                    str = this.ItemName(0, get_tr);
                    CpCanvas.Audio(1, 11);
                    key = 0;
                }
            } else if (mes_flg == 3) {
                n2 = tip_list[get_tr] >> 8 & 0xFF;
                n = tip_list[get_tr] & 0xFF;
                CpCanvas.MesRead(CpCanvas.tip[n2].setu_id, null, 4);
                g.drawImage(tmp_imgMap, 44, 62, 0, 0, 150, 58);
                CpCanvas.drawImg3(44, 65 + n2 / 125 + n2 / 177, 127, 75, false);
                tip[n2].Draw(173, 66, 1, true);
                g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                tip[n2].DrawName(58, 99);
                tip[n2].DrawPow(90, 105);
                tip[n2].DrawZoku(173, 103);
                tip[n2].DrawCode(n, 166, 99, 1);
                if (key == 0x100000) {
                    ++mes_flg;
                    key = 0;
                }
            } else if (mes_flg == 4) {
                CpCanvas.MesRead(0, str.getBytes(), 3);
                if (key == 0x100000) {
                    ++mes_flg;
                    CpCanvas.MesRead(108, null, 3);
                    yes_no_flg = 1;
                    key = 0;
                }
            } else if (mes_flg == 5) {
                CpCanvas.MesRead(108, null, 3);
                if (key == 0x100000) {
                    for (n3 = 0; n3 < 10; ++n3) {
                        CpCanvas.set_t[n3] = 0;
                    }
                    if (yes_no_flg == 1) {
                        mes_flg = 0;
                        sort_flg = -1;
                        this.ListSort(5);
                    } else {
                        this.MachiSet(machi_no, 0);
                        scene = back_menu;
                        mes_flg = 0;
                    }
                    sel_tip2 = 0;
                    sel_jou2 = 0;
                    yes_no_flg = 0;
                    key = 0;
                }
            }
            if (mes_flg == 3 || mes_flg == 4) {
                CpCanvas.MesDraw(2);
            } else {
                CpCanvas.MesDraw(1);
            }
            if (yes_no_flg != 0) {
                CpCanvas.drawImg3(44, 33, 55 + (yes_no_flg - 1) * 96 + game_cnt / 2 % 3, 207, false);
            } else if (mes_flg != 0) {
                CpCanvas.drawImg3(44, 108, 225, 222 + game_cnt / 3 % 2, false);
            }
        }
        CpCanvas.ImgSuu(in_cnt, 184, 23, 16, 1, 1);
        CpCanvas.ImgSuu(tr_max, 208, 23, 16, 1, 1);
        CpCanvas.drawImg3(44, 64, 200, 23, false);
        if (key == 0x200000) {
            if (mes_flg == 0) {
                if (in_cnt > 0) {
                    this.TrIO(0);
                } else {
                    this.MachiSet(machi_no, 0);
                    scene = back_menu;
                }
            }
            key = 0;
        }
    }

    public void TrIO(int n) {
        if (n == 0) {
            this.GetItem(0, 0, set_t[--in_cnt]);
            CpCanvas.set_t[CpCanvas.in_cnt] = 0;
        }
        if (n == 1) {
            CpCanvas.set_t[CpCanvas.in_cnt] = sort_list[sel_tip2];
            if (this.GetItem(0, 1, sort_list[sel_tip2]) == 1) {
                if (get_tip >= 7 && get_tip - sel_jou2 < 7) {
                    --sel_tip2;
                    --sel_jou2;
                }
                if (get_tip <= sel_tip2) {
                    --sel_tip2;
                }
            }
            ++in_cnt;
        }
    }

    public void MakeTr() {
        CpCanvas.drawImg3(44, 0, 0, 0, true);
        CpCanvas.drawImg3(44, 91, 8, 8, true);
        graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
        graMap.fillRect(4, 20, 232, 136);
        CpCanvas.drawImg3(44, 1, 4, 28, true);
        CpCanvas.drawImg3(44, 2, 150, 28, true);
        graMap.setColor(Graphics.getColorOfRGB((int)200, (int)224, (int)248));
        graMap.fillRect(7, 37, 224, 112);
        CpCanvas.drawImg3(44, 4, 97, 21, true);
        CpCanvas.drawImg3(44, 5, 105, 21, true);
        CpCanvas.drawImg3(44, 5, 156, 21, true);
        CpCanvas.drawImg3(44, 6, 225, 21, true);
        graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        graMap.fillRect(181, 21, 43, 15);
        graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
        graMap.fillRect(182, 22, 41, 13);
        graMap.fillRect(10, 38, 160, 112);
        graMap.fillRect(186, 38, 35, 112);
        CpCanvas.drawImg3(44, 3, 170, 37, true);
        CpCanvas.drawImg3(44, 68, 170, 26, true);
        CpCanvas.drawImg3(44, 69, 170, 144, true);
        graMap.setColor(Graphics.getColorOfRGB((int)32, (int)40, (int)81));
        CpCanvas.strDrawG(menu_str[7], 110, 35);
        graMap.setColor(Graphics.getColorOfRGB((int)68, (int)80, (int)138));
        CpCanvas.strDrawG(menu_str[7], 109, 35);
        graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        graMap.fillRect(2, 162, 236, 76);
        CpCanvas.drawImg3(44, 107, 181, 90, true);
        tmp_graMap.setColor(Graphics.getColorOfRGB((int)40, (int)40, (int)40));
        tmp_graMap.fillRect(2, 2, 150, 58);
        tmp_graMap.setColor(Graphics.getColorOfRGB((int)240, (int)248, (int)248));
        tmp_graMap.fillRect(0, 0, 150, 58);
        tmp_graMap.setColor(Graphics.getColorOfRGB((int)96, (int)96, (int)104));
        tmp_graMap.fillRect(2, 2, 146, 18);
        tmp_graMap.setColor(Graphics.getColorOfRGB((int)136, (int)136, (int)144));
        tmp_graMap.fillRect(2, 20, 146, 36);
        CpCanvas.drawImg4(44, 110, 5, 6);
        CpCanvas.drawImg4(44, 111, 83, 6);
        CpCanvas.drawImg4(44, 112, 3, 41);
        CpCanvas.drawImg4(44, 113, 81, 41);
    }

    public void ReadTr(int n) {
        tr_max = 3;
        if (n == 1) {
            tr_max = 10;
        }
        try {
            InputStream inputStream = CpCanvas.JarGet(17);
            byte[] byArray = new byte[4];
            inputStream.skip(1132 * n);
            for (int i = 0; i < 283; ++i) {
                inputStream.read(byArray);
                int n2 = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                n2 += CpCanvas.tip[CpCanvas.tip_list[n2] >> 8 & 0xFF].rea << 16;
                CpCanvas.tr_list[i] = n2;
            }
            inputStream.close();
            inputStream = null;
            System.gc();
        }
        catch (Exception exception) {
            // empty catch block
        }
        sel_tip2 = 0;
        sel_jou2 = 0;
        sort_flg = -1;
        if (n < 2) {
            this.ListSort(5);
        }
    }

    public int GetTr(int n) {
        int n2;
        int n3 = 0;
        int[] nArray = new int[]{34, 54, 63, 64, 8, 26, 51, 63, 0, 12, 37, 62};
        n3 = (rand.nextInt() >>> 1) % 64;
        int n4 = 0;
        for (n2 = 0; n2 < 4; ++n2) {
            n4 = n2 + 1;
            if (n3 < nArray[n2 + n * 4]) break;
            ++n4;
        }
        n2 = 0;
        int[] nArray2 = new int[283];
        while (n2 == 0) {
            for (int i = 0; i < 283; ++i) {
                if ((tr_list[i] >> 16 & 0xF) != n4 || (tr_list[i] & 0xFFFF) == 0) continue;
                nArray2[n2] = i;
                ++n2;
            }
            --n4;
        }
        n3 = (rand.nextInt() >>> 1) % n2;
        return tr_list[nArray2[n3]] & 0xFFFF;
    }

    public void ZokuMain() {
        int n;
        int n2;
        CpCanvas.soft_id[0] = 2;
        CpCanvas.soft_id[1] = 0;
        int n3 = this.getKeypadState();
        if ((n3 & 0x20000) == 0 && (n3 & 0x80000) == 0 && (n3 & 2) == 0 && (n3 & 0x10) == 0) {
            key_cnt = 0;
        }
        if (key_cnt > 0) {
            if (key_cnt < 4) {
                n3 = 0;
            }
            ++key_cnt;
        }
        g.drawImage(imgMap, 0, 0);
        int n4 = skill_list[sort_skill[sel_tip2]] & 0xFF;
        int n5 = skill_list[sort_skill[sel_tip2]] >> 8 & 0xFF;
        if (mes_flg == 0) {
            if (key == 131072 || (n3 & 0x20000) != 0) {
                if (sel_tip2 > 0 && --sel_tip2 - sel_jou2 < 0) {
                    --sel_jou2;
                }
                ++key_cnt;
                key = 0;
            } else if (key == 524288 || (n3 & 0x80000) != 0) {
                if (sel_tip2 < skill_suu - 1 && ++sel_tip2 - sel_jou2 >= 7) {
                    ++sel_jou2;
                }
                ++key_cnt;
                key = 0;
            } else if (key == 2 || (n3 & 2) != 0) {
                if (sel_jou2 > 0) {
                    if ((sel_jou2 -= 7) < 0) {
                        sel_tip2 -= 7 + sel_jou2;
                        sel_jou2 = 0;
                    } else {
                        sel_tip2 -= 7;
                    }
                }
                ++key_cnt;
                key = 0;
            } else if (key == 16 || (n3 & 0x10) != 0) {
                if (sel_jou2 < skill_suu - 7) {
                    if ((sel_jou2 += 7) > skill_suu - 7) {
                        sel_tip2 += 7 - (sel_jou2 - (skill_suu - 7));
                        sel_jou2 = skill_suu - 7;
                    } else {
                        sel_tip2 += 7;
                    }
                }
                ++key_cnt;
                key = 0;
            } else if (key == 0x100000) {
                if (skill_suu > 0) {
                    mes_flg = 1;
                    sel_tip = 0;
                    if (sel_tip == n5) {
                        ++sel_tip;
                    }
                    n2 = skill_list[sort_skill[sel_tip2]] & 0xFF;
                    str = CpCanvas.skill[n2].name;
                } else {
                    scene = 3;
                }
                key = 0;
            }
        }
        for (n = 6; n >= 0; --n) {
            n2 = skill_list[sort_skill[sel_jou2 + n]] & 0xFF;
            int n6 = skill_list[sort_skill[sel_jou2 + n]] >> 8 & 0xFF;
            if (sel_jou2 + n >= skill_suu) continue;
            CpCanvas.drawImg3(51 + n6, n2, 11, 10 + n * 16, false);
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            CpCanvas.strDraw(CpCanvas.skill[n2].name, 40, 23 + n * 16);
            g.setColor(Graphics.getColorOfRGB((int)255, (int)234, (int)0));
            CpCanvas.strDraw("x" + CpCanvas.skill[n2].you, 26, 23 + n * 16);
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            CpCanvas.strDraw(CpCanvas.skill[n2].you * 50 + "\uff7a", 206 - f.stringWidth(CpCanvas.skill[n2].you * 50 + "\uff7a"), 23 + n * 16);
            n2 = skill_list[sort_skill[sel_jou2 + n]] >> 16 & 0xFF;
            CpCanvas.strDraw("" + n2, 138, 23 + n * 16);
        }
        if (sel_jou2 != 0) {
            CpCanvas.drawImg3(44, 115, 105, 5, false);
        }
        if (sel_jou2 + 7 < skill_suu) {
            CpCanvas.drawImg3(44, 114, 105, 120, false);
        }
        if (mes_flg == 0) {
            if (skill_suu == 0) {
                CpCanvas.MesRead(190, null, 3);
            } else {
                CpCanvas.MesRead(181, null, 3);
                CpCanvas.drawImg3(44, 33, 1 + game_cnt / 2 % 3, 10 + (sel_tip2 - sel_jou2) * 16, false);
            }
            CpCanvas.MesDraw(1);
        } else {
            CpCanvas.drawImg3(44, 128, 1 + game_cnt / 2 % 3, 10 + (sel_tip2 - sel_jou2) * 16, false);
            if (yes_no_flg != 0) {
                if (key == 65536) {
                    yes_no_flg = 1;
                    key = 0;
                } else if (key == 262144) {
                    yes_no_flg = 2;
                    key = 0;
                }
            }
            if (mes_flg == 1) {
                CpCanvas.MesRead(182, str.getBytes(), 3);
                if (key == 65536) {
                    if (--sel_tip < 0) {
                        sel_tip = 4;
                    }
                    if (sel_tip == n5 && --sel_tip < 0) {
                        sel_tip = 4;
                    }
                    key = 0;
                } else if (key == 262144) {
                    ++sel_tip;
                    if ((sel_tip %= 5) == n5) {
                        ++sel_tip;
                        sel_tip %= 5;
                    }
                    key = 0;
                } else if (key == 0x100000) {
                    ++mes_flg;
                    str = "" + CpCanvas.skill[n4].you * 50;
                    yes_no_flg = 1;
                    key = 0;
                } else if (key == 0x200000) {
                    mes_flg = 0;
                    key = 0;
                }
                CpCanvas.drawImg3(44, 128, 6 + n5 * 26, 141, false);
                CpCanvas.drawImg3(44, 33, 6 + sel_tip * 26 + game_cnt / 2 % 3, 141, false);
            } else if (mes_flg == 2) {
                CpCanvas.MesRead(183, str.getBytes(), 3);
                CpCanvas.drawImg3(44, 128, 6 + n5 * 26, 141, false);
                CpCanvas.drawImg3(44, 33, 6 + sel_tip * 26 + game_cnt / 2 % 3, 141, false);
                if (key == 0x100000) {
                    if (yes_no_flg == 1) {
                        n = piece;
                        if (this.GetItem(2, 1, CpCanvas.skill[n4].you * 50) == 0) {
                            if (this.GetItem(3, 0, n4 * 5 + sel_tip) == 0) {
                                this.GetItem(3, 1, n4 * 5 + n5);
                                ++mes_flg;
                                CpCanvas.MesRead(184, null, 3);
                            } else {
                                piece = n;
                                mes_flg = 6;
                            }
                        } else {
                            piece = n;
                            mes_flg = 5;
                        }
                    } else {
                        mes_flg = 1;
                    }
                    yes_no_flg = 0;
                    key = 0;
                } else if (key == 0x200000) {
                    mes_flg = 1;
                    yes_no_flg = 0;
                    key = 0;
                }
            } else if (mes_flg == 3) {
                while (System.currentTimeMillis() - mill < 500L) {
                }
                ++mes_flg;
                CpCanvas.Audio(1, 11);
                key = 0;
            } else if (mes_flg == 4) {
                CpCanvas.MesRead(185, null, 3);
                if (key == 0x100000) {
                    mes_flg = 0;
                    key = 0;
                }
                CpCanvas.drawImg3(44, 108, 225, 222 + game_cnt / 3 % 2, false);
            } else if (mes_flg == 5) {
                CpCanvas.MesRead(187, null, 3);
                if (key == 0x100000) {
                    mes_flg = 0;
                    key = 0;
                }
            } else if (mes_flg == 6) {
                CpCanvas.MesRead(186, null, 3);
                if (key == 0x100000) {
                    mes_flg = 0;
                    key = 0;
                }
            }
            CpCanvas.MesDraw(1);
            if (yes_no_flg != 0) {
                CpCanvas.drawImg3(44, 33, 55 + (yes_no_flg - 1) * 96 + game_cnt / 2 % 3, 207, false);
            }
        }
        CpCanvas.ImgSuu(piece, 158, 143, 63, 1, 1);
        if (key == 0x200000) {
            if (mes_flg == 0) {
                scene = 3;
            }
            key = 0;
        }
    }

    public void MakeZoku() {
        graMap.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
        graMap.fillRect(0, 0, 240, 240);
        graMap.setColor(Graphics.getColorOfRGB((int)72, (int)96, (int)120));
        graMap.fillRect(2, 2, 236, 158);
        graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        graMap.fillRect(2, 162, 236, 76);
        graMap.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
        graMap.fillRect(2, 2, 216, 127);
        graMap.setColor(Graphics.getColorOfRGB((int)240, (int)248, (int)248));
        graMap.fillRect(2, 2, 215, 126);
        graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
        graMap.fillRect(3, 3, 214, 125);
        graMap.setColor(Graphics.getColorOfRGB((int)200, (int)224, (int)248));
        graMap.fillRect(3, 3, 213, 124);
        graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
        graMap.fillRect(7, 7, 205, 116);
        graMap.setColor(Graphics.getColorOfRGB((int)240, (int)240, (int)248));
        graMap.fillRect(3, 130, 142, 29);
        graMap.setColor(Graphics.getColorOfRGB((int)136, (int)136, (int)144));
        graMap.fillRect(4, 131, 140, 20);
        graMap.setColor(Graphics.getColorOfRGB((int)96, (int)96, (int)104));
        graMap.fillRect(4, 151, 140, 7);
        CpCanvas.drawImg3(44, 48, 147, 129, true);
        CpCanvas.drawImg3(44, 51, 151, 132, true);
        CpCanvas.drawImg3(44, 43, 222, 146, true);
        CpCanvas.drawImg3(44, 113, 5, 132, true);
        for (int i = 0; i < 5; ++i) {
            CpCanvas.drawImg3(44, 25 + i, 15 + 26 * i, 141, true);
        }
        sel_tip2 = 0;
        sel_jou2 = 0;
    }

    public void Ranking() {
        CpCanvas.soft_id[0] = 0;
        CpCanvas.soft_id[1] = 0;
        if (eff_cnt > 0) {
            this.EnEff(eff_cnt++);
            if (eff_cnt > 8) {
                for (int i = 0; i < 7; ++i) {
                    CpCanvas.sco_cnt[i] = 0;
                }
                this.BtSet(teki_pt);
                this.EnSet();
                scene = 1;
                --eff_cnt;
                key = 0;
            }
            return;
        }
        g.drawImage(imgMap, 0, 0);
        int n = this.getKeypadState();
        if ((n & 0x20000) == 0 && (n & 0x80000) == 0 && (n & 2) == 0 && (n & 0x10) == 0) {
            key_cnt = 0;
        }
        if (key_cnt > 0) {
            if (key_cnt < 4) {
                n = 0;
            }
            ++key_cnt;
        }
        if (rank_menu == -1) {
            g.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
            g.fillRect(31, 26, 176, 40);
            if (yes_no_flg != 0) {
                if (key == 65536) {
                    yes_no_flg = 1;
                    key = 0;
                } else if (key == 262144) {
                    yes_no_flg = 2;
                    key = 0;
                }
            }
            if (rank_no == 0) {
                mes_flg = 1;
                rank_mes = 10;
                this.rank_mes_id = 10;
                if (key == 0x100000) {
                    ++rank_no;
                    rank_mes = 11;
                    this.rank_mes_id = 10;
                    yes_no_flg = 1;
                    key = 0;
                }
            } else if (rank_no == 1) {
                if (key == 0x100000) {
                    if (yes_no_flg == 1) {
                        rank_no = 2;
                        rank_mes = 141;
                        this.rank_mes_id = 3;
                        mes_flg = 0;
                    } else {
                        rank_no = 4;
                        rank_mes = 143;
                        this.rank_mes_id = 3;
                    }
                    yes_no_flg = 0;
                    key = 0;
                }
            } else if (rank_no == 2) {
                this.CGI(5, 0);
                if (http_error == 1) {
                    if (dat[51] * 100 + dat[52] != dat[55] * 100 + dat[56]) {
                        this.GetRank(0, dat[52]);
                        if (http_error == 0) {
                            CpCanvas.dat[54] = 0;
                            CpCanvas.dat[55] = dat[51];
                            CpCanvas.dat[56] = dat[52];
                            CpCanvas.dat[57] = 0;
                            rank_no = 3;
                            rank_mes = 142;
                            this.rank_mes_id = 3;
                        } else {
                            rank_no = 1;
                            rank_mes = 160;
                            this.rank_mes_id = 3;
                            yes_no_flg = 1;
                        }
                    } else {
                        rank_no = 3;
                        rank_mes = 142;
                        this.rank_mes_id = 3;
                    }
                } else if (http_error == 110) {
                    rank_no = 6;
                    rank_mes = 12;
                    this.rank_mes_id = 10;
                } else if (http_error == 120) {
                    rank_no = 9;
                    rank_mes = 7;
                    this.rank_mes_id = 10;
                    yes_no_flg = 1;
                } else if (http_error == 150) {
                    rank_no = 5;
                    rank_mes = 8;
                    this.rank_mes_id = 10;
                } else {
                    rank_no = 8;
                    rank_mes = 9;
                    this.rank_mes_id = 10;
                }
                CpCanvas.writeSP();
                mes_flg = 1;
                key = 0;
            } else if (rank_no == 3) {
                if (key == 0x100000) {
                    rank_menu = 0;
                    rank_mes = 0;
                    this.rank_mes_id = 3;
                    rank_no = 0;
                    this.MakeRank(0);
                    key = 0;
                    return;
                }
            } else if (rank_no == 4) {
                if (key == 0x100000) {
                    ++rank_no;
                    rank_mes = 144;
                    this.rank_mes_id = 3;
                    key = 0;
                }
            } else if (rank_no == 5) {
                if (key == 0x100000) {
                    this.MachiSet(machi_no, 0);
                    scene = 5;
                    mes_flg = 0;
                    key = 0;
                }
            } else if (rank_no == 6) {
                if (key == 0x100000) {
                    rank_no = 7;
                    rank_mes = 13;
                    this.rank_mes_id = 10;
                    yes_no_flg = 1;
                    key = 0;
                }
            } else if (rank_no == 7) {
                if (key == 0x100000) {
                    if (yes_no_flg == 1) {
                        rank_no = 11;
                        rank_mes = 16;
                        this.rank_mes_id = 10;
                        yes_no_flg = 1;
                    } else {
                        this.MachiSet(machi_no, 0);
                        scene = 5;
                        yes_no_flg = 0;
                        mes_flg = 0;
                    }
                    key = 0;
                }
            } else if (rank_no == 8) {
                if (key == 0x100000) {
                    rank_no = 1;
                    rank_mes = 160;
                    this.rank_mes_id = 3;
                    yes_no_flg = 1;
                    key = 0;
                }
            } else if (rank_no == 9) {
                if (key == 0x100000) {
                    if (yes_no_flg == 1) {
                        rank_no = 13;
                        rank_mes = 16;
                        this.rank_mes_id = 10;
                        yes_no_flg = 1;
                    } else {
                        rank_no = 10;
                        rank_mes = 15;
                        this.rank_mes_id = 10;
                        yes_no_flg = 0;
                    }
                    key = 0;
                }
            } else if (rank_no == 10) {
                if (key == 0x100000) {
                    IApplication.getCurrentApp().terminate();
                }
            } else if (rank_no == 11) {
                if (key == 0x100000) {
                    if (yes_no_flg == 1) {
                        this.Save(0);
                        CpCanvas.Audio(1, 11);
                        rank_no = 12;
                        rank_mes = 17;
                        this.rank_mes_id = 10;
                    } else {
                        String string = DomeUrl + "/i/party/?uid=NULLGWDOCOMO&web=reg";
                        IApplication.getCurrentApp().launch(1, new String[]{string});
                        this.MachiSet(machi_no, 0);
                        scene = 5;
                        mes_flg = 0;
                    }
                    yes_no_flg = 0;
                    key = 0;
                }
            } else if (rank_no == 12) {
                if (key == 0x100000) {
                    String string = DomeUrl + "/i/party/?uid=NULLGWDOCOMO&web=reg";
                    IApplication.getCurrentApp().launch(1, new String[]{string});
                    this.MachiSet(machi_no, 0);
                    scene = 5;
                    mes_flg = 0;
                    key = 0;
                }
            } else if (rank_no == 13) {
                if (key == 0x100000) {
                    if (yes_no_flg == 1) {
                        this.Save(0);
                        CpCanvas.Audio(1, 11);
                        rank_no = 14;
                        rank_mes = 17;
                        this.rank_mes_id = 10;
                    } else {
                        rank_no = 10;
                        rank_mes = 15;
                        this.rank_mes_id = 10;
                    }
                    yes_no_flg = 0;
                    key = 0;
                }
            } else if (rank_no == 14 && key == 0x100000) {
                String string = DomeUrl + "/i/party/?uid=NULLGWDOCOMO&appid=" + AppID + "&page=verup";
                IApplication.getCurrentApp().launch(1, new String[]{string});
                rank_no = 10;
                rank_mes = 15;
                this.rank_mes_id = 10;
                key = 0;
            }
            CpCanvas.MesRead(rank_mes, null, this.rank_mes_id);
            if (rank_no == 8) {
                str = "" + http_error;
                CpCanvas.MesRead(9, str.getBytes(), 10);
            }
            CpCanvas.MesDraw(1);
            if (yes_no_flg != 0) {
                CpCanvas.drawImg3(44, 33, 55 + (yes_no_flg - 1) * 96 + game_cnt / 2 % 3, 207, false);
            } else if (mes_flg != 0) {
                CpCanvas.drawImg3(44, 108, 225, 222 + game_cnt / 3 % 2, false);
            }
        } else if (rank_menu == 0) {
            CpCanvas.ImgSuu(dat[54], 130, 52, 48, 1, 1);
            if (yes_no_flg != 0) {
                if (key == 65536) {
                    yes_no_flg = 1;
                    key = 0;
                } else if (key == 262144) {
                    yes_no_flg = 2;
                    key = 0;
                }
            }
            face = 31;
            if (rank_no == -1) {
                if (rank_cnt == 0) {
                    rank_menu = 3;
                    rank_cnt = 0;
                    rank_no = 0;
                    this.MakeRank(3);
                    g.drawImage(imgMap, 0, 0);
                    return;
                }
                rank_mes = 149;
                yes_no_flg = 1;
                this.MakeRank(0);
                g.drawImage(imgMap, 0, 0);
                rank_no = 3;
            } else if (rank_no == 0) {
                CpCanvas.soft_id[0] = 2;
                CpCanvas.soft_id[1] = 0;
                rank_mes = 145 + rank_cnt;
                mes_flg = 0;
                face = 26;
                if (key == 131072 || key == 524288) {
                    key = 0;
                    rank_mes = 145 + (rank_cnt ^= 1);
                } else if (key == 0x100000) {
                    if (rank_cnt == 0) {
                        rank_no = 1;
                        rank_mes = 147;
                    } else {
                        rank_no = 4;
                        rank_mes = 153;
                    }
                    mes_flg = 1;
                    yes_no_flg = 1;
                    key = 0;
                } else {
                    if (key == 2) {
                        for (int i = 0; i < 30; ++i) {
                            CpCanvas.r_tip[i] = CpCanvas.fol[3].tip_id[i];
                        }
                        rank_no = 0;
                        menu_cnt = 0;
                        rank_menu = 2;
                        rank_cnt = -1;
                        this.MakeRank(2);
                        key = 0;
                        return;
                    }
                    if (key == 0x200000) {
                        this.MachiSet(machi_no, 0);
                        scene = 5;
                        key = 0;
                    }
                }
            } else if (rank_no == 1) {
                face = 26;
                if (key == 0x100000) {
                    if (yes_no_flg == 1) {
                        rank_no = 2;
                        rank_mes = 148;
                    } else {
                        rank_no = 0;
                        rank_cnt = 0;
                        mes_flg = 0;
                    }
                    yes_no_flg = 0;
                    key = 0;
                }
            } else if (rank_no == 2) {
                face = 26;
                if (key == 0x100000) {
                    for (int i = 0; i < 10; ++i) {
                        CpCanvas.teki_ren[1][i] = i;
                    }
                    now_hp = max_hp;
                    this.GetRank(1, 0);
                    ren_flg = 1;
                    ren_id = 1;
                    eff_cnt = 1;
                    teki_pt = teki_ren[ren_id][0];
                    come_back = 1;
                    rank_flg = 1;
                    rank_cnt = 0;
                    rank_no = -1;
                    key = 0;
                }
            } else if (rank_no == 3) {
                face = 26;
                if (key == 0x100000) {
                    if (yes_no_flg == 1) {
                        rank_no = 2;
                        rank_mes = 148;
                    } else {
                        rank_no = 0;
                        rank_cnt = 0;
                        mes_flg = 0;
                    }
                    yes_no_flg = 0;
                    key = 0;
                }
            } else if (rank_no == 4) {
                if (key == 0x100000) {
                    if (yes_no_flg == 1) {
                        rank_no = 5;
                        rank_mes = 154;
                        mes_flg = 0;
                    } else {
                        rank_no = 0;
                        mes_flg = 0;
                    }
                    yes_no_flg = 0;
                    key = 0;
                }
            } else if (rank_no == 5) {
                CpCanvas.RankUp();
                if (http_error == 1) {
                    rank_no = 0;
                    rank_menu = 1;
                    rank_cnt = 0;
                    this.MakeRank(1);
                    back_menu = 5;
                    CpCanvas.writeSP();
                    this.Save(0);
                    return;
                }
                if (http_error == 110) {
                    rank_menu = -1;
                    rank_no = 6;
                    rank_mes = 12;
                    this.rank_mes_id = 10;
                    CpCanvas.dat[50] = -1;
                    CpCanvas.writeSP();
                } else {
                    rank_no = 4;
                    rank_mes = 160;
                    yes_no_flg = 1;
                }
                mes_flg = 1;
            } else if (rank_no == 6 && key == 0x100000) {
                this.MachiSet(machi_no, 0);
                scene = 5;
                key = 0;
            }
            if (rank_no == 0) {
                CpCanvas.drawImg3(44, 33, 40 + rank_cnt * 18, 108 + rank_cnt * 20, false);
            }
            CpCanvas.MesRead(rank_mes, null, 3);
            this.FaceDraw(face);
            CpCanvas.MesDraw(1);
            if (yes_no_flg != 0) {
                CpCanvas.drawImg3(44, 33, 55 + (yes_no_flg - 1) * 96 + game_cnt / 2 % 3, 207, false);
            } else if (mes_flg != 0) {
                CpCanvas.drawImg3(44, 108, 225, 222 + game_cnt / 3 % 2, false);
            }
        } else if (rank_menu == 1) {
            if (yes_no_flg != 0) {
                if (key == 65536) {
                    yes_no_flg = 1;
                    key = 0;
                } else if (key == 262144) {
                    yes_no_flg = 2;
                    key = 0;
                }
            }
            face = 31;
            if (rank_no == 0) {
                CpCanvas.soft_id[0] = 2;
                CpCanvas.soft_id[1] = 0;
                if (key == 131072) {
                    if (--rank_cnt < 0) {
                        rank_cnt = rank_fol - 1;
                    }
                    key = 0;
                } else if (key == 524288) {
                    if (++rank_cnt > rank_fol - 1) {
                        rank_cnt = 0;
                    }
                    key = 0;
                } else if (key == 0x100000) {
                    rank_no = 1;
                    rank_mes = 155;
                    yes_no_flg = 1;
                    face = 6;
                    key = 0;
                } else if (key == 0x200000) {
                    rank_menu = 0;
                    rank_cnt = 0;
                    this.MakeRank(0);
                    key = 0;
                }
            } else if (rank_no == 1) {
                face = 6;
                if (key == 0x100000) {
                    if (yes_no_flg == 1) {
                        rank_no = 2;
                        rank_mes = 96;
                        face = 31;
                    } else {
                        rank_no = 0;
                        mes_flg = 0;
                    }
                    yes_no_flg = 0;
                    key = 0;
                }
            } else if (rank_no == 2) {
                this.CGI(6, rank_cnt);
                if (http_error == 1) {
                    rank_no = 0;
                    menu_cnt = 0;
                    rank_menu = 2;
                    this.MakeRank(2);
                    return;
                }
                if (http_error == 110) {
                    rank_no = 3;
                    rank_mes = 161;
                    CpCanvas.dat[50] = -1;
                    CpCanvas.writeSP();
                } else {
                    rank_no = 1;
                    rank_mes = 160;
                    yes_no_flg = 1;
                }
                mes_flg = 1;
            } else if (rank_no == 3 && key == 0x100000) {
                this.MachiSet(machi_no, 0);
                scene = 5;
                mes_flg = 0;
                key = 0;
            }
            CpCanvas.drawImg3(44, 33, 174, 45 + rank_cnt * 14, false);
            if (rank_no != 0) {
                g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
                g.fillRect(0, 160, 240, 80);
                g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                g.fillRect(2, 162, 236, 76);
                CpCanvas.MesRead(rank_mes, null, 3);
                this.FaceDraw(face);
                CpCanvas.MesDraw(1);
                if (yes_no_flg != 0) {
                    CpCanvas.drawImg3(44, 33, 55 + (yes_no_flg - 1) * 96 + game_cnt / 2 % 3, 207, false);
                }
            }
        } else if (rank_menu == 2) {
            CpCanvas.soft_id[0] = 2;
            CpCanvas.soft_id[1] = 0;
            if (key == 131072 || (n & 0x20000) != 0) {
                if (--menu_cnt < 0) {
                    menu_cnt = 0;
                }
                ++key_cnt;
                key = 0;
            } else if (key == 524288 || (n & 0x80000) != 0) {
                if (++menu_cnt > 23) {
                    menu_cnt = 23;
                }
                ++key_cnt;
                mes_flg = 2;
                key = 0;
            } else if (key == 2 || (n & 2) != 0) {
                if ((menu_cnt -= 7) < 0) {
                    menu_cnt = 0;
                }
                ++key_cnt;
                key = 0;
            } else if (key == 16 || (n & 0x10) != 0) {
                if ((menu_cnt += 7) > 23) {
                    menu_cnt = 23;
                }
                ++key_cnt;
                key = 0;
            }
            g.setColor(Graphics.getColorOfRGB((int)32, (int)40, (int)81));
            if (rank_cnt >= 0) {
                CpCanvas.strDraw(r_jun[rank_cnt] + r_name[rank_cnt], 37, 35);
            } else {
                CpCanvas.strDraw(r_str[19], 37, 35);
            }
            g.setColor(Graphics.getColorOfRGB((int)68, (int)80, (int)138));
            if (rank_cnt >= 0) {
                CpCanvas.strDraw(r_jun[rank_cnt] + r_name[rank_cnt], 36, 35);
            } else {
                CpCanvas.strDraw(r_str[19], 36, 35);
            }
            CpCanvas.drawImg3(44, 34, 201, 43 + menu_cnt * 92 / 23, false);
            for (int i = 6; i >= 0; --i) {
                int n2 = tip_list[r_tip[menu_cnt + i]] >> 8 & 0xFF;
                int n3 = tip_list[r_tip[menu_cnt + i]] & 0xFF;
                tip[n2].Draw(40, 41 + i * 15, 1, true);
                g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                tip[n2].DrawName(56, 54 + i * 15);
                tip[n2].DrawZoku(155, 41 + i * 15);
                tip[n2].DrawCode(n3, 173, 55 + i * 15, 1);
                tip[n2].DrawRegu(182, 41 + i * 15);
            }
            this.FaceDraw(6);
            CpCanvas.MesDraw(1);
            if (key == 0x200000) {
                if (rank_cnt >= 0) {
                    rank_menu = 1;
                    this.MakeRank(1);
                } else {
                    rank_menu = 0;
                    rank_cnt = 0;
                    this.MakeRank(0);
                }
                key = 0;
            }
        } else if (rank_menu == 3) {
            if (rank_no == 0) {
                this.Wait(300);
                graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                int[] nArray = new int[]{30000, -1, 0, 1000, 0, 2500, 20000, -100, 20000, -1000, 10000, -1000, 0, 250};
                score = 0;
                for (int i = 0; i < 7; ++i) {
                    if (i == 0) {
                        if (sco_cnt[0] > 1782000) {
                            CpCanvas.sco_cnt[0] = 1782000;
                        }
                        int n4 = sco_cnt[0] / 18000;
                        int n5 = sco_cnt[0] / 300 % 60;
                        int n6 = sco_cnt[0] / 3 % 100;
                        str = n4 > 9 ? "" + n4 : "0" + n4;
                        str = n5 > 9 ? str + ":" + n5 : str + ":0" + n5;
                        str = n6 > 9 ? str + ":" + n6 : str + ":0" + n6;
                        CpCanvas.sco_cnt[0] = sco_cnt[0] / 3;
                    }
                    if (i == 1) {
                        if (sco_cnt[1] > 10) {
                            CpCanvas.sco_cnt[1] = 10;
                        }
                        str = sco_cnt[1] + r_str[16];
                    }
                    if (i == 2) {
                        if (sco_cnt[2] > 10) {
                            CpCanvas.sco_cnt[2] = 10;
                        }
                        str = sco_cnt[2] + r_str[16];
                    }
                    if (i == 3) {
                        str = sco_cnt[3] + r_str[17];
                    }
                    if (i == 4) {
                        str = sco_cnt[4] + r_str[16];
                    }
                    if (i == 5) {
                        str = sco_cnt[5] + r_str[16];
                    }
                    if (i == 6) {
                        if (sco_cnt[6] > 100) {
                            CpCanvas.sco_cnt[6] = 100;
                        }
                        str = sco_cnt[6] + r_str[18];
                    }
                    CpCanvas.sco[i] = nArray[i * 2] + sco_cnt[i] * nArray[i * 2 + 1];
                    if (sco[i] < 0) {
                        CpCanvas.sco[i] = 0;
                    }
                    score += sco[i];
                    CpCanvas.strDrawG(str, 170 - f.stringWidth(str), 60 + i * 18);
                    str = "" + sco[i];
                    CpCanvas.strDrawG(str, 225 - f.stringWidth(str), 60 + i * 18);
                    g.drawImage(imgMap, 0, 0);
                    this.Wait(200);
                }
                this.Wait(300);
                graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)0));
                str = "" + score;
                CpCanvas.strDrawG(str, 225 - f.stringWidth(str), 193);
                if (dat[54] < score) {
                    graMap.setColor(Graphics.getColorOfRGB((int)255, (int)0, (int)0));
                    str = r_str[15];
                    CpCanvas.strDrawG(str, 180 - f.stringWidth(str), 193);
                }
                rank_no = 1;
                key = 0;
            } else if (key == 0x100000) {
                rank_no = 0;
                rank_menu = 0;
                this.MakeRank(0);
                back_menu = 5;
                if (dat[54] < score) {
                    rank_no = 4;
                    rank_mes = 150;
                    yes_no_flg = 1;
                    for (int i = 0; i < 30; ++i) {
                        CpCanvas.fol[3].tip_id[i] = CpCanvas.fol[CpCanvas.now_fol].tip_id[i];
                        System.out.println(i + "tip:" + CpCanvas.fol[3].tip_id[i] + " now_fol");
                    }
                    CpCanvas.dat[54] = score;
                    CpCanvas.dat[57] = 0;
                    CpCanvas.writeSP();
                }
                CpCanvas.Audio(1, 3);
                this.Save(0);
                key = 0;
            }
        }
    }

    public void MakeRank(int n) {
        int n2;
        if (n == 0) {
            CpCanvas.drawImg3(44, 0, 0, 0, true);
            CpCanvas.drawImg3(44, 121, 8, 8, true);
            graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            graMap.fillRect(2, 162, 236, 76);
            graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
            graMap.fillRect(4, 20, 232, 136);
            graMap.setColor(Graphics.getColorOfRGB((int)96, (int)112, (int)192));
            graMap.fillRect(28, 24, 182, 44);
            graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            graMap.fillRect(29, 25, 180, 42);
            graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
            graMap.fillRect(31, 26, 176, 40);
            CpCanvas.drawImg3(44, 122, 37, 30, true);
            graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            CpCanvas.strDrawG(dat[55] + "/" + dat[56], 205 - f.stringWidth(dat[55] + "/" + dat[56]), 40);
            graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)0));
            if (dat[57] != 0) {
                CpCanvas.strDrawG(dat[57] + r_str[0], 120 - f.stringWidth(dat[57] + r_str[0]), 62);
            } else {
                CpCanvas.strDrawG("--" + r_str[0], 120 - f.stringWidth("--" + r_str[0]), 62);
            }
            CpCanvas.drawImg3(44, 125, 182, 54, true);
            graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            CpCanvas.strDrawG(r_str[1], 103, 82);
            CpCanvas.drawImg3(44, 123, 37, 88, true);
            CpCanvas.strDrawG(r_str[2], 51, 120);
            CpCanvas.strDrawG(r_str[3], 69, 140);
        }
        if (n == 1) {
            CpCanvas.drawImg3(44, 0, 0, 0, true);
            CpCanvas.drawImg3(44, 121, 8, 8, true);
            CpCanvas.drawImg3(44, 126, 0, 156, true);
            graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
            graMap.fillRect(4, 20, 232, 216);
            graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)0));
            CpCanvas.strDrawG(dat[55] + "/" + dat[56] + r_str[4], 6, 37);
            graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            rank_fol = 0;
            n2 = 1;
            for (int i = 0; i < 10; ++i) {
                if (i > 0 && r_sco[i] < r_sco[i - 1]) {
                    n2 = i + 1;
                }
                CpCanvas.r_jun[i] = n2 + r_str[0];
                CpCanvas.strDrawG(r_jun[i], 17 - n2 / 10 * 6, 57 + i * 14);
                CpCanvas.strDrawG(r_name[i], 50, 57 + i * 14);
                CpCanvas.strDrawG("" + r_sco[i], 168 - f.stringWidth("" + r_sco[i]), 57 + i * 14);
                if (i != 0 && r_sco[i] <= 0) continue;
                ++rank_fol;
                CpCanvas.strDrawG(r_str[5], 183, 57 + i * 14);
            }
            graMap.fillRect(10, 189, 220, 2);
            graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)0));
            CpCanvas.strDrawG(r_str[6], 8, 205);
            graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            CpCanvas.strDrawG(dat[57] + r_str[0], 122 - f.stringWidth(dat[57] + r_str[0]), 220);
            CpCanvas.strDrawG("" + dat[54], 165 - f.stringWidth("" + dat[54]), 220);
        }
        if (n == 2) {
            CpCanvas.drawImg3(44, 0, 0, 0, true);
            CpCanvas.drawImg3(44, 121, 8, 8, true);
            graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            graMap.fillRect(2, 162, 236, 76);
            graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
            graMap.fillRect(4, 20, 232, 136);
            CpCanvas.drawImg3(44, 1, 27, 28, true);
            CpCanvas.drawImg3(44, 2, 127, 28, true);
            graMap.setColor(Graphics.getColorOfRGB((int)200, (int)224, (int)248));
            graMap.fillRect(30, 37, 178, 112);
            CpCanvas.drawImg3(44, 4, 28, 21, true);
            CpCanvas.drawImg3(44, 5, 35, 21, true);
            CpCanvas.drawImg3(44, 5, 76, 21, true);
            CpCanvas.drawImg3(44, 6, 144, 21, true);
            graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
            graMap.fillRect(36, 37, 164, 112);
            CpCanvas.drawImg3(44, 3, 200, 37, true);
            CpCanvas.drawImg3(44, 68, 201, 26, true);
            CpCanvas.drawImg3(44, 69, 201, 144, true);
            str = dat[55] + "/" + dat[56];
            CpCanvas.MesRead(156, str.getBytes(), 3);
            if (rank_cnt < 0) {
                CpCanvas.MesRead(151, null, 3);
            }
        }
        if (n == 3) {
            CpCanvas.drawImg3(44, 0, 0, 0, true);
            CpCanvas.drawImg3(44, 121, 8, 8, true);
            CpCanvas.drawImg3(44, 126, 0, 156, true);
            graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
            graMap.fillRect(4, 20, 232, 216);
            graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            for (n2 = 0; n2 < 7; ++n2) {
                CpCanvas.strDrawG(r_str[7 + n2], 23, 60 + n2 * 18);
            }
            graMap.fillRect(10, 175, 220, 2);
            graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)0));
            CpCanvas.strDrawG(r_str[14], 23, 193);
        }
    }

    public static int RankUp() {
        http_error = 255;
        HttpConnection httpConnection = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        byte[] byArray = new byte[60];
        byte[] byArray2 = new byte[269];
        for (int i = 0; i < 60; i += 2) {
            byArray[i] = (byte)(CpCanvas.fol[CpCanvas.now_fol].tip_id[i / 2] & 0xFF);
            byArray[i + 1] = (byte)(CpCanvas.fol[CpCanvas.now_fol].tip_id[i / 2] >> 8);
            System.out.println("tip[ " + i / 2 + " ]:" + CpCanvas.fol[CpCanvas.now_fol].tip_id[i / 2]);
        }
        try {
            String string = "http://game.capcom.jp/i/exe/sreg/iexe_score.php?uid=NULLGWDOCOMO&ty=sr&s=" + dat[54] + "&ym=" + (dat[55] * 100 + dat[56]);
            string = DomeUrl + dev + "party/sreg/isr.php?uid=NULLGWDOCOMO&k=" + AppID + "&v0=" + Ver + "&ty=exesr&ym=" + (dat[55] * 100 + dat[56]) + "&s=" + dat[54];
            httpConnection = (HttpConnection)Connector.open((String)string, (int)3, (boolean)true);
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "application/octet-stream");
            outputStream = httpConnection.openOutputStream();
            outputStream.write(byArray);
            outputStream.close();
            outputStream = null;
            System.gc();
            httpConnection.connect();
            String string2 = httpConnection.getHeaderField("X-CAPCOM-STATUS");
            if (string2 == null) {
                http_error = 200;
            } else if (string2.compareTo("NG") == 0) {
                http_error = 100;
            } else if (string2.compareTo("MT") == 0) {
                http_error = 150;
            } else if (string2.compareTo("OK") == 0) {
                int n;
                inputStream = httpConnection.openInputStream();
                inputStream.read(byArray2);
                http_error = byArray2[0];
                if (http_error != 1) {
                    inputStream.close();
                    inputStream = null;
                    httpConnection.close();
                    return http_error;
                }
                CpCanvas.dat[57] = (byArray2[1] & 0xFF) << 24 | (byArray2[2] & 0xFF) << 16 | (byArray2[3] & 0xFF) << 8 | byArray2[4] & 0xFF;
                CpCanvas.dat[54] = (byArray2[5] & 0xFF) << 24 | (byArray2[6] & 0xFF) << 16 | (byArray2[7] & 0xFF) << 8 | byArray2[8] & 0xFF;
                for (n = 0; n < 10; ++n) {
                    CpCanvas.r_sco[n] = (byArray2[9 + n * 4] & 0xFF) << 24 | (byArray2[10 + n * 4] & 0xFF) << 16 | (byArray2[11 + n * 4] & 0xFF) << 8 | byArray2[12 + n * 4] & 0xFF;
                }
                for (n = 0; n < 10; ++n) {
                    int n2;
                    byte[] byArray3 = new byte[12];
                    for (n2 = 0; n2 < 12 && byArray2[49 + n * 12 + n2] != 0; ++n2) {
                        byArray3[n2] = byArray2[49 + n * 12 + n2];
                    }
                    byte[] byArray4 = new byte[n2];
                    for (int i = 0; i < n2; ++i) {
                        byArray4[i] = byArray3[i];
                    }
                    CpCanvas.r_name[n] = new String(byArray4);
                }
                for (n = 0; n < 10; ++n) {
                    CpCanvas.r_id[n] = (byArray2[169 + n * 4] & 0xFF) << 24 | (byArray2[170 + n * 4] & 0xFF) << 16 | (byArray2[171 + n * 4] & 0xFF) << 8 | byArray2[172 + n * 4] & 0xFF;
                }
                for (n = 0; n < 30; ++n) {
                    CpCanvas.fol[3].tip_id[n] = byArray2[n * 2 + 209] & 0xFF | (byArray2[n * 2 + 210] & 0xFF) << 8;
                    System.out.println(n + "tip:" + CpCanvas.fol[3].tip_id[n]);
                }
                inputStream.close();
                inputStream = null;
            } else {
                http_error = 255;
            }
            httpConnection.close();
        }
        catch (Exception exception) {
            http_error = 255;
            try {
                httpConnection.close();
                outputStream.close();
                inputStream.close();
            }
            catch (Exception exception2) {
                // empty catch block
            }
        }
        return http_error;
    }

    public int IventMain() {
        while (ivent_flg == 0) {
            int n = i_data[ivent_cnt];
            CpCanvas.i_id[0] = n >> 2 & 0x3F;
            CpCanvas.i_id[1] = n >> 8 & 0xFF;
            CpCanvas.i_id[2] = n >> 16 & 0x3FF;
            CpCanvas.i_id[3] = n >> 26 & 0x1F;
            ivent_set = n & 3;
            this.IventSet(ivent_set);
        }
        ivent_flg = this.Ivent(ivent_set);
        return ivent_flg;
    }

    public void IventSet(int n) {
        ++ivent_cnt;
        ivent_flg = 0;
        if (n == 0) {
            CpCanvas.MesRead(i_id[2], null, i_id[1]);
            if (ivent_syu == 1 && i_id[0] > 19) {
                i_id[0] = i_id[0] + 100;
            }
            ivent_flg = 1;
        } else if (n == 1) {
            yure = 0;
            if (i_id[0] != 10 && i_id[0] != 11) {
                kouka_flg = i_id[0];
                kouka_cnt = i_id[1];
            }
            if (i_id[0] == 12) {
                CpCanvas.Audio(1, 13);
            }
            if (i_id[0] == 11) {
                CpCanvas.Audio(i_id[1], i_id[2]);
                kouka_cnt = 0;
            }
            if (i_id[0] == 13) {
                CpCanvas.i_id[3] = i_id[2] * 30 + 124;
                CpCanvas.i_id[2] = i_id[1] * 30 + 120;
                CpCanvas.i_x[4] = i_id[1] * 30 + 125;
                CpCanvas.i_y[4] = i_id[2] * 30 + 130;
                kouka_cnt = 0;
            }
            if (i_id[0] == 14) {
                kouka_flg = i_id[0];
                CpCanvas.MesRead(i_id[2], null, i_id[3]);
                kouka_cnt = i_id[1];
            }
            if (i_id[0] == 10 || i_id[0] > 5 && i_id[0] < 9 || i_id[0] == 13 || i_id[0] == 14) {
                ivent_flg = 1;
            }
        } else if (n == 2) {
            if (i_id[0] == 0) {
                if (i_id[3] == 10) {
                    int[] nArray = talk_flg[i_id[1]];
                    int n2 = i_id[2];
                    nArray[n2] = nArray[n2] + 1;
                } else {
                    CpCanvas.talk_flg[CpCanvas.i_id[1]][CpCanvas.i_id[2]] = i_id[3];
                }
                if (talk_flg[i_id[1]][i_id[2]] > 4 || talk_flg[i_id[1]][i_id[2]] < 0) {
                    CpCanvas.talk_flg[CpCanvas.i_id[1]][CpCanvas.i_id[2]] = 0;
                }
                talk_cnt = this.CharaCnt();
            } else if (i_id[0] == 1) {
                boolean bl = false;
                if (i_id[2] < 4) {
                    CpCanvas.item_flg[CpCanvas.i_id[1]][CpCanvas.i_id[2]] = i_id[3];
                    if (map_no == i_id[1]) {
                        int n3 = (m_item[i_id[2]][2] - 120) / 30;
                        int n4 = (m_item[i_id[2]][3] - 124) / 30;
                        CpCanvas.m_data[n4 * 24 + n3] = i_id[3] == 0 ? 1 : 32 + i_id[2];
                    }
                } else if (i_id[2] < 6) {
                    CpCanvas.tobi_flg[CpCanvas.i_id[1]][CpCanvas.i_id[2] - 4] = i_id[3];
                    if (map_no == i_id[1]) {
                        int n5 = (m_tobi[i_id[2] - 4][3] - 120) / 30;
                        int n6 = (m_tobi[i_id[2] - 4][4] - 124) / 30;
                        CpCanvas.m_data[n6 * 24 + n5] = i_id[3] == 0 ? 1 : 64 + i_id[2] - 4;
                    }
                } else {
                    CpCanvas.chara_flg[CpCanvas.i_id[1]][CpCanvas.i_id[2] - 6] = i_id[3];
                    if (map_no == i_id[1]) {
                        int n7 = (m_chara[i_id[2] - 6][4] - 120) / 30;
                        int n8 = (m_chara[i_id[2] - 6][5] - 124) / 30;
                        CpCanvas.m_data[n8 * 24 + n7] = i_id[3] == 0 ? 1 : 128 + i_id[2] - 6;
                    }
                }
            } else if (i_id[0] == 3) {
                if (i_id[2] == 0) {
                    if (move_ok[i_id[1]] < i_id[3]) {
                        CpCanvas.move_ok[CpCanvas.i_id[1]] = i_id[3];
                    }
                } else if (plg_ok[i_id[1]] < i_id[3]) {
                    CpCanvas.plg_ok[CpCanvas.i_id[1]] = i_id[3];
                }
            } else if (i_id[0] == 4) {
                CpCanvas.talk_ch[0] = i_id[1];
                CpCanvas.talk_ch[1] = i_id[2];
                CpCanvas.talk_ch[2] = i_id[3];
                if (ivent_syu == 1) {
                    talk_ch[1] = talk_ch[1] + 100;
                    talk_ch[2] = talk_ch[2] + 100;
                }
            } else if (i_id[0] == 5) {
                yes_no_flg = 1;
                jump_ivent = i_id[2];
            } else if (i_id[0] > 5 && i_id[0] < 10) {
                if (i_id[0] == 9) {
                    i_id[2] = i_id[2] + (user_id + ivent_id) % 5;
                }
                if (i_id[0] == 7) {
                    i_id[2] = i_id[2] * 100;
                }
                this.GetItem(i_id[0] - 6, i_id[1], i_id[2]);
            } else if (i_id[0] == 10) {
                map_x = i_id[1] * 30 + 15;
                map_y = i_id[2] * 30 + 8;
                muki = i_id[3];
            } else if (i_id[0] == 11) {
                this.IventRead(i_id[2], ivent_syu);
                ivent_flg = 1;
            } else if (i_id[0] == 12) {
                this.GetItem(5, 0, i_id[1]);
            } else if (i_id[0] == 13) {
                mail_suu = i_id[1];
                if (mail_suu > 18) {
                    mail_suu = 18;
                }
                mail_flg = 1;
                mail_cnt = 0;
            } else if (i_id[0] == 14) {
                int n9 = i_id[1];
                navi_flg[n9] = navi_flg[n9] + 1;
                if (navi_flg[i_id[1]] > 3) {
                    CpCanvas.navi_flg[CpCanvas.i_id[1]] = 3;
                }
            } else if (i_id[0] == 15) {
                skill_flg = 1;
            } else if (i_id[0] == 16) {
                this.GetItem(6, 0, 0);
            } else if (i_id[0] == 17) {
                this.GetItem(7, 0, 0);
            } else if (i_id[0] == 18) {
                if (++fol_suu > 3) {
                    fol_suu = 3;
                }
            } else if (i_id[0] == 19) {
                quest_flg = 1;
            } else if (i_id[0] == 20) {
                sina_flg = 1;
            } else if (i_id[0] == 21) {
                warp_flg = 1;
                warp_cnt = 1;
            } else if (i_id[0] > 21 && i_id[0] < 26) {
                CpCanvas.i_set[CpCanvas.i_id[0] - 22] = i_id[1];
                CpCanvas.i_x[CpCanvas.i_id[0] - 22] = i_id[2] * 30 + 120;
                CpCanvas.i_y[CpCanvas.i_id[0] - 22] = i_id[3] * 30 + 124;
            } else if (i_id[0] == 26) {
                eff_cnt = 1;
                teki_pt = i_id[2];
                if (i_id[2] >= 300) {
                    teki_pt += navi_flg[i_id[1]];
                }
                come_back = i_id[3];
                tmp_hp = now_hp;
                ivent_flg = 1;
            } else if (i_id[0] == 27) {
                ren_flg = 1;
                ren_id = i_id[1];
                eff_cnt = 1;
                teki_pt = teki_ren[ren_id][0];
                come_back = i_id[3];
                tmp_hp = now_hp;
                ivent_flg = 1;
            } else if (i_id[0] == 28) {
                boolean bl = false;
                if (i_id[3] == 0 && zenny >= i_id[2] * 100) {
                    bl = true;
                }
                if (i_id[3] == 1 && get_tip2[0] + get_tip2[1] + get_tip2[2] >= i_id[2]) {
                    bl = true;
                }
                if (i_id[3] == 2 && get_tip2[0] >= i_id[2]) {
                    bl = true;
                }
                if (i_id[3] == 3 && get_tip2[1] >= i_id[2]) {
                    bl = true;
                }
                if (i_id[3] == 4 && get_tip2[2] >= i_id[2]) {
                    bl = true;
                }
                if (i_id[3] == 5 && piece >= i_id[2]) {
                    bl = true;
                }
                if (i_id[3] == 6 && navi_flg[i_id[2] % 100] < i_id[2] / 100) {
                    bl = true;
                }
                if (i_id[3] == 7 && win_flg != 0) {
                    bl = true;
                }
                if (i_id[3] == 8 && (tip_list[i_id[2]] >> 16 & 0xFF) > 0) {
                    bl = true;
                }
                if (i_id[3] == 9 && s_hen >= i_id[2]) {
                    bl = true;
                }
                if (i_id[3] == 10 && q_hen >= i_id[2]) {
                    bl = true;
                }
                if (i_id[3] == 11 && s_hen == i_id[2]) {
                    bl = true;
                }
                if (i_id[3] == 12 && q_hen == i_id[2]) {
                    bl = true;
                }
                if (i_id[3] == 13 && dat[58] != 0) {
                    bl = true;
                }
                if (i_id[3] == 14 && dat[63] != 0) {
                    bl = true;
                }
                if (bl) {
                    this.IventRead(i_id[1], ivent_syu);
                }
            } else if (i_id[0] == 29) {
                if (i_id[2] == 0) {
                    machi_no = i_id[1];
                    this.MachiSet(machi_no, 1);
                } else {
                    machi_damy_flg = -1;
                    if (i_id[1] < 31) {
                        this.ImgSet2(i_id[1]);
                        this.MachiSet(i_id[1], 0);
                        ivent_flg = 0;
                        machi_damy_flg = i_id[1];
                    }
                }
            } else if (i_id[0] == 30) {
                if (i_id[1] == 0) {
                    ++s_hen;
                }
                if (i_id[1] == 1) {
                    --s_hen;
                }
                if (i_id[1] == 2) {
                    s_hen = i_id[2];
                }
            } else if (i_id[0] == 31) {
                if (i_id[1] == 0) {
                    ++q_hen;
                }
                if (i_id[1] == 1) {
                    --q_hen;
                }
                if (i_id[1] == 2) {
                    q_hen = i_id[2];
                }
            } else if (i_id[0] == 32) {
                CpCanvas.teki_ren[CpCanvas.i_id[1]][CpCanvas.i_id[3]] = i_id[2];
                CpCanvas.teki_ren[CpCanvas.i_id[1]][CpCanvas.i_id[3] + 1] = 0;
            }
        } else if (n == 3) {
            if (i_id[0] == 0) {
                ivent_end = i_id[1];
                if (i_id[1] == 0) {
                    ivent_end = 0;
                } else if (i_id[1] == 1) {
                    ivent_end = 2;
                }
            }
            if (i_id[0] == 1) {
                this.ReadSh(i_id[1]);
                this.MakeSh();
                ivent_end = 4;
            }
            if (i_id[0] == 2) {
                this.MakeTr();
                this.ReadTr(i_id[1]);
                ivent_end = 5;
            }
            if (i_id[0] == 3) {
                this.ReadTr(2);
                get_tr = this.GetTr(2);
                this.GetItem(0, 0, get_tr);
                this.Save(0);
                str = this.ItemName(0, get_tr);
                CpCanvas.MesRead(0, str.getBytes(), 3);
                CpCanvas.Audio(1, 11);
                ivent_end = 7;
            }
            if (i_id[0] == 4) {
                ivent_end = 10;
            }
            if (i_id[0] == 5) {
                ivent_end = 6;
                this.MakeZoku();
            }
            ivent_flg = -1;
        }
    }

    public int Ivent(int n) {
        int n2 = 1;
        if (ivent_flg < 0) {
            return -1;
        }
        this.Kouka(kouka_flg);
        if (n == 0) {
            this.FaceDraw(i_id[0]);
            boolean bl = CpCanvas.MesDraw(0);
            if (key == 65536) {
                if (yes_no_flg != 0) {
                    yes_no_flg = 1;
                }
                key = 0;
            } else if (key == 262144) {
                if (yes_no_flg != 0) {
                    yes_no_flg = 2;
                }
                key = 0;
            } else if (key == 0x100000) {
                if (bl) {
                    n2 = 0;
                } else {
                    mes_cnt = 90;
                }
                key = 0;
            }
            if (yes_no_flg != 0 && n2 == 0) {
                if (yes_no_flg == 1) {
                    this.IventRead(jump_ivent, ivent_syu);
                    jump_ivent = 0;
                }
                yes_no_flg = 0;
            }
        } else if (n == 1) {
            i_id[1] = i_id[1] - 1;
            if (i_id[1] == 0) {
                n2 = 0;
            }
        } else if (n == 2) {
            n2 = 0;
        } else if (n == 3) {
            n2 = 0;
        }
        return n2;
    }

    public void Kouka(int n) {
        if (n == 0) {
            return;
        }
        if (n == 1) {
            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
            g.fillRect(0, 0, 240, 160);
        } else if (n == 2) {
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            g.fillRect(0, 0, 240, 160);
        } else if (n == 3) {
            if (game_cnt % 3 != 0) {
                g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                g.fillRect(0, 0, 240, 240);
            }
        } else if (n == 4) {
            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
            g.fillRect(0, 0, 240, 240);
        } else if (n == 5) {
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            g.fillRect(0, 0, 240, 240);
        } else if (n == 6) {
            ++kouka_cnt;
            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
            for (int i = 0; i < 12; ++i) {
                g.fillRect(0, i * 20 + 10 - kouka_cnt, 240, kouka_cnt * 2);
            }
            if (kouka_cnt > 10) {
                kouka_flg = 4;
                CpCanvas.i_id[1] = 1;
            }
        } else if (n == 7) {
            --kouka_cnt;
            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
            for (int i = 0; i < 10; ++i) {
                g.fillRect(0, i * 24 + 12 - kouka_cnt, 240, kouka_cnt * 2);
            }
            CpCanvas.i_id[1] = 10;
            if (kouka_cnt == 0) {
                kouka_flg = 0;
                CpCanvas.i_id[1] = 1;
            }
        } else if (n == 8) {
            if (this.PlgEfe(++kouka_cnt, 0)) {
                kouka_flg = 5;
                CpCanvas.i_id[1] = 1;
            } else {
                CpCanvas.i_id[1] = 10;
            }
        } else if (n == 9) {
            yure = (game_cnt % 4 - 1) * (1 - game_cnt % 4 / 3);
        } else if (n == 12) {
            CpCanvas.drawImg3(44, 109, 5 + game_cnt / 2 % 3, 5, false);
        } else if (n == 13) {
            CpCanvas.Ani(37, 4, kouka_cnt % 7, i_id[2] - map_x, i_id[3] - map_y);
            if (kouka_cnt > 3) {
                CpCanvas.Ani(37, 4, (kouka_cnt - 4) % 7, i_x[4] - map_x, i_y[4] - map_y);
            }
            if (kouka_cnt % 7 == 6) {
                i_id[2] = i_id[2] + ((rand.nextInt() >>> 1) % 10 - 5);
                i_id[3] = i_id[3] + ((rand.nextInt() >>> 1) % 10 - 5);
            }
            if ((kouka_cnt - 4) % 7 == 6) {
                i_x[4] = i_x[4] + ((rand.nextInt() >>> 1) % 10 - 5);
                i_y[4] = i_y[4] + ((rand.nextInt() >>> 1) % 10 - 5);
            }
            CpCanvas.i_id[1] = 10;
            if (kouka_cnt == 14) {
                kouka_flg = 0;
                CpCanvas.i_id[1] = 1;
            }
            ++kouka_cnt;
        } else if (n == 14) {
            CpCanvas.i_id[1] = 10;
            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
            g.fillRect(0, 0, 240, 240);
            if (CpCanvas.MesDraw2(0, 30, 90, 255)) {
                --kouka_cnt;
            }
            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
            g.fillRect(0, 200, 240, 240);
            if (kouka_cnt == 0) {
                kouka_flg = 4;
                CpCanvas.i_id[1] = 1;
            }
        }
    }

    public String ItemName(int n, int n2) {
        String string = "*";
        if (n == 0) {
            int n3 = tip_list[n2] & 0xFF;
            if (n3 != 100) {
                byte[] byArray = new byte[]{(byte)(n3 + 64)};
                string = new String(byArray);
            }
            string = CpCanvas.tip[CpCanvas.tip_list[n2] >> 8 & 0xFF].name + " " + string;
        }
        if (n == 1) {
            string = "" + n2 + menu_str[20];
        }
        if (n == 2) {
            string = menu_str[30] + n2 + menu_str[31];
        }
        if (n == 3) {
            string = CpCanvas.skill[n2].name;
        }
        if (n == 4) {
            string = menu_str[2];
        }
        if (n == 5) {
            string = menu_str[26] + n2;
        }
        if (n == 6) {
            string = menu_str[25];
        }
        if (n == 7) {
            string = menu_str[27];
        }
        return string;
    }

    public int GetItem(int n, int n2, int n3) {
        int n4 = 1 + -n2 * 2;
        int n5 = 0;
        if (n == 0) {
            if (n3 == 0) {
                return 0;
            }
            if (n4 > 0) {
                int n6 = tip_list[n3] >> 8 & 0xFF;
                CpCanvas.AddLib(n6);
                if ((tip_list[n3] >> 16 & 0xFF) < 99) {
                    int n7 = n3;
                    tip_list[n7] = tip_list[n7] + 65536;
                    if ((tip_list[n3] >> 16 & 0xFF) == 1) {
                        ++get_tip;
                        if (scene == 4) {
                            CpCanvas.sort_list[CpCanvas.get_tip - 1] = n3;
                        } else {
                            for (int i = 0; i < get_tip - 1; ++i) {
                                CpCanvas.sort_list[CpCanvas.get_tip - i - 1] = sort_list[get_tip - i - 2];
                            }
                            CpCanvas.sort_list[0] = n3;
                        }
                    }
                } else {
                    n5 = -1;
                }
            } else if ((tip_list[n3] >> 16 & 0xFF) > 0) {
                int n8 = n3;
                tip_list[n8] = tip_list[n8] - 65536;
                if ((tip_list[n3] >> 16 & 0xFF) == 0) {
                    --get_tip;
                    int n9 = 0;
                    for (int i = 0; i < 510; ++i) {
                        if ((tip_list[sort_list[i]] >> 16 & 0xFF) == 0) continue;
                        CpCanvas.sort_list[n9] = sort_list[i];
                        ++n9;
                    }
                    if (get_tip != 0) {
                        n5 = 1;
                    }
                }
            } else {
                n5 = -1;
            }
        } else if (n == 1) {
            if ((zenny += n4 * n3) > 9999999) {
                zenny = 9999999;
            }
            if (zenny < 0) {
                n5 = -1;
            }
        } else if (n == 2) {
            if ((piece += n4 * n3) > 9999999) {
                piece = 9999999;
            }
            if (piece < 0) {
                n5 = -1;
            }
        } else if (n == 3) {
            if (n4 > 0) {
                if ((skill_list[n3] >> 16 & 0xFF) < 99) {
                    int n10 = n3;
                    skill_list[n10] = skill_list[n10] + 65536;
                }
            } else if ((skill_list[n3] >> 16 & 0xFF) > 0) {
                int n11 = n3;
                skill_list[n11] = skill_list[n11] - 65536;
            } else {
                n5 = -1;
            }
            CpCanvas.SortSkill(0);
        } else if (n == 4) {
            if ((full_ene += n4) > 9) {
                full_ene = 9;
                n5 = 1;
            }
        } else if (n == 5) {
            regu_you += n3;
        } else if (n == 6) {
            int n12;
            int n13 = max_hp;
            for (n12 = 23; n12 < 29; ++n12) {
                n13 -= skill_kouka[n12] * CpCanvas.skill[n12].param;
            }
            if (skill_kouka[22] != 0) {
                n13 *= 2;
            }
            if ((n13 += (n12 = 20)) > 1000) {
                n12 = 0;
            }
            max_hp += n12;
            now_hp += n12;
            if (skill_kouka[22] != 0) {
                max_hp -= n12 / 2;
                now_hp -= n12 / 2;
            }
            if (max_hp > 2000) {
                max_hp = 2000;
            }
        } else if (n == 7) {
            if ((Edit.max_slot += 3) > 12) {
                Edit.max_slot = 12;
            }
        }
        return n5;
    }

    public void IventRead(int n, int n2) {
        if (n <= 0) {
            return;
        }
        ivent_id = n--;
        InputStream inputStream = null;
        byte[] byArray = new byte[4];
        int n3 = 0;
        ivent_syu = n2;
        kouka_flg = 0;
        machi_damy_flg = -1;
        try {
            int n4;
            inputStream = n2 == 0 ? CpCanvas.GetData(7) : (n2 == 1 ? CpCanvas.GetData(5) : (n2 == 2 ? CpCanvas.JarGet(14) : (n2 == 3 ? CpCanvas.JarGet(15) : CpCanvas.GetData(7))));
            if (i_cnt[n2] == 0) {
                inputStream.read(byArray);
                CpCanvas.i_cnt[n2] = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                for (n4 = 0; n4 < i_cnt[n2]; ++n4) {
                    inputStream.read(byArray);
                    CpCanvas.i_siz[n2][n4] = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                }
            } else {
                inputStream.skip(i_cnt[n2] + 1 << 2);
            }
            for (n4 = 0; n4 < n; ++n4) {
                n3 += i_siz[n2][n4];
            }
            inputStream.skip(n3 << 2);
            for (n4 = 0; n4 < i_siz[n2][n]; ++n4) {
                inputStream.read(byArray);
                CpCanvas.i_data[n4] = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
            }
            inputStream.close();
            inputStream = null;
            System.gc();
        }
        catch (Exception exception) {
            // empty catch block
        }
        for (int i = 0; i < 4; ++i) {
            CpCanvas.i_set[i] = 0;
        }
        ivent_flg = 0;
        ivent_cnt = 0;
    }

    public int CharaCnt() {
        int n = 0;
        talk_cnt2 = 0;
        if (i_chara[0][talk_flg[machi_no][0]] < 31) {
            ++n;
        }
        if (i_chara[1][talk_flg[machi_no][1]] < 31) {
            ++n;
        }
        if (i_chara[2][talk_flg[machi_no][2]] % 100 < 31) {
            talk_cnt2 = 1;
        }
        return n;
    }

    public int FaceDrawA(int n, int n2, int n3, int n4) {
        int n5;
        int[] nArray = new int[]{n, n2, n3, n4};
        int n6 = 0;
        for (n5 = 0; n5 < 4; ++n5) {
            if (nArray[n5] % 100 == 31) continue;
            nArray[n6] = nArray[n5];
            ++n6;
        }
        for (n5 = n6 - 1; n5 >= 0; --n5) {
            this.FaceDraw2(nArray[n5], face_x[n6 - 1][n5], 110);
        }
        return n6;
    }

    public void FaceDraw(int n) {
        if (n % 100 == 31) {
            return;
        }
        if (n < 100) {
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        } else {
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)0));
        }
        g.fillRect(7, 176, 40, 46);
        if (n < 20) {
            CpCanvas.drawImg3(47, n, 8, 177, false);
        } else if (n < 100) {
            CpCanvas.drawImg3(49, n - 20, 8, 177, false);
        } else {
            CpCanvas.drawImg3(50, n - 120, 8, 177, false);
        }
    }

    public void FaceDraw2(int n, int n2, int n3) {
        if (n % 100 == 31) {
            return;
        }
        n2 += yure;
        if (n < 100) {
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        } else {
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)0));
        }
        g.fillRect(n2 - 1, n3 - 1, 40, 46);
        if (n < 20) {
            CpCanvas.drawImg3(47, n, n2, n3, false);
        } else if (n < 100) {
            CpCanvas.drawImg3(49, n - 20, n2, n3, false);
        } else {
            CpCanvas.drawImg3(50, n - 120, n2, n3, false);
        }
    }

    public void Menu() {
        CpCanvas.soft_id[0] = 2;
        CpCanvas.soft_id[1] = 0;
        if (option_flg != 0) {
            this.Option();
            return;
        }
        if (menu_cnt < 0) {
            this.MenuMake(menu_no);
            menu_flg = 0;
            menu_cnt = 0;
        }
        g.drawImage(imgMap, 0, 0);
        int n = this.getKeypadState();
        if ((n & 0x20000) == 0 && (n & 0x80000) == 0 && (n & 2) == 0 && (n & 0x10) == 0) {
            key_cnt = 0;
        }
        if (key_cnt > 0) {
            if (key_cnt < 4) {
                n = 0;
            }
            ++key_cnt;
        }
        if (menu_no == 0) {
            String string;
            CpCanvas.soft_id[0] = 2;
            CpCanvas.soft_id[1] = 6;
            if (key == 131072 || (n & 0x20000) != 0) {
                if (menu_cnt == 0) {
                    if (mes_flg == 0) {
                        if (--menu_sel < 0) {
                            menu_sel = 5;
                        }
                        string = " " + full_ene;
                        CpCanvas.MesRead(menu_sel + 5, string.getBytes(), 3);
                        ++key_cnt;
                    } else {
                        mes_flg = 1;
                    }
                }
                key = 0;
            } else if (key == 524288 || (n & 0x80000) != 0) {
                if (menu_cnt == 0) {
                    if (mes_flg == 0) {
                        if (++menu_sel > 5) {
                            menu_sel = 0;
                        }
                        string = " " + full_ene;
                        CpCanvas.MesRead(menu_sel + 5, string.getBytes(), 3);
                        ++key_cnt;
                    } else {
                        mes_flg = 2;
                    }
                }
                key = 0;
            } else if (key == 65536) {
                sel_tip = 0;
                key = 0;
            } else if (key == 262144) {
                sel_tip = 1;
                key = 0;
            }
            CpCanvas.ImgSuu(now_hp, 148, 42, 32, 1, 1);
            CpCanvas.ImgSuu(max_hp, 188, 42, 32, 1, 1);
            CpCanvas.ImgSuu(zenny, 148, 77, 63, 1, 1);
            CpCanvas.ImgSuu(piece, 148, 112, 63, 1, 1);
            CpCanvas.drawImg3(44, 53, 34, 28 + menu_sel * 21, false);
            g.setColor(Graphics.getColorOfRGB((int)72, (int)96, (int)120));
            CpCanvas.strDraw(menu_str[menu_sel], 37, 43 + menu_sel * 21);
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            CpCanvas.strDraw(menu_str[menu_sel], 36, 42 + menu_sel * 21);
            for (int i = 0; i < 6; ++i) {
                if (i == menu_sel) {
                    CpCanvas.drawImg3(44, 35, 14, 30 + i * 21, false);
                    CpCanvas.drawImg3(44, 36 + i, 16, 32 + i * 21, false);
                    continue;
                }
                CpCanvas.drawImg3(44, 35, 7, 30 + i * 21, false);
                CpCanvas.drawImg3(44, 36 + i, 9, 32 + i * 21, false);
            }
            if (menu_cnt == 3) {
                this.Save(0);
                CpCanvas.MesRead(25, null, 3);
                menu_cnt = 4;
                CpCanvas.Audio(1, 11);
                key = 0;
            }
            if (key == 0x100000) {
                if (menu_sel == 0) {
                    menu_no = 1;
                    menu_cnt = -1;
                    menu_sel = 0;
                    CpCanvas.MesRead(11, null, 3);
                    sel_tip = 0;
                    sel_tip2 = 0;
                    sel_jou = 0;
                    sel_jou2 = 0;
                    mes_flg = 0;
                    key = 0;
                    return;
                }
                if (menu_sel == 1) {
                    menu_no = 4;
                    menu_cnt = -1;
                    menu_sel = 0;
                }
                if (menu_sel == 2) {
                    if (menu_cnt == 0) {
                        string = " " + full_ene;
                        CpCanvas.MesRead(20, string.getBytes(), 3);
                        menu_cnt = 1;
                    } else if (menu_cnt == 1) {
                        if (sel_tip == 0) {
                            if (full_ene == 0) {
                                CpCanvas.MesRead(26, null, 3);
                            } else if (max_hp == now_hp) {
                                CpCanvas.MesRead(27, null, 3);
                            } else {
                                CpCanvas.MesRead(21, null, 3);
                                now_hp = max_hp;
                                menu_flg = 1;
                                --full_ene;
                                CpCanvas.Audio(1, 11);
                            }
                            menu_cnt = 2;
                        } else {
                            string = " " + full_ene;
                            CpCanvas.MesRead(menu_sel + 5, string.getBytes(), 3);
                            menu_cnt = 0;
                        }
                    } else if (menu_cnt == 2) {
                        string = " " + full_ene;
                        CpCanvas.MesRead(menu_sel + 5, string.getBytes(), 3);
                        menu_flg = 0;
                        menu_cnt = 0;
                    }
                }
                if (menu_sel == 3) {
                    menu_no = 6;
                    menu_cnt = -1;
                    menu_sel = 0;
                }
                if (menu_sel == 4) {
                    menu_no = 5;
                    menu_cnt = -1;
                    menu_sel = 0;
                }
                if (menu_sel == 5) {
                    if (menu_cnt == 0) {
                        CpCanvas.MesRead(22, null, 3);
                        menu_cnt = 1;
                    } else if (menu_cnt == 1) {
                        if (sel_tip == 0) {
                            CpCanvas.MesRead(23, null, 3);
                            menu_cnt = 2;
                        } else {
                            CpCanvas.MesRead(menu_sel + 5, null, 3);
                            menu_cnt = 0;
                        }
                    } else if (menu_cnt == 2) {
                        if (sel_tip == 0) {
                            CpCanvas.MesRead(24, null, 3);
                            menu_cnt = 3;
                        } else {
                            CpCanvas.MesRead(menu_sel + 5, null, 3);
                            menu_cnt = 0;
                        }
                    } else if (menu_cnt == 4) {
                        CpCanvas.MesRead(menu_sel + 5, null, 3);
                        menu_cnt = 0;
                    }
                }
                sel_tip = 0;
                sel_tip2 = 0;
                sel_jou = 0;
                sel_jou2 = 0;
                mes_flg = 0;
                key = 0;
            } else if (key == 0x200000) {
                if (menu_cnt == 0) {
                    this.MachiSet(machi_no, 0);
                    scene = back_menu;
                    menu_cnt = -1;
                    menu_sel = 0;
                }
                key = 0;
            } else if (key == 0x400000) {
                if (menu_cnt == 0) {
                    option_flg = 2;
                }
                key = 0;
            }
            if (menu_flg == 0) {
                this.FaceDraw(6);
            }
            CpCanvas.MesDraw(1);
            if (menu_cnt != 0) {
                CpCanvas.soft_id[0] = 0;
                CpCanvas.soft_id[1] = 0;
            }
            if (menu_cnt == 4) {
                CpCanvas.drawImg3(44, 108, 225, 222 + game_cnt / 3 % 2, false);
            }
            if (menu_cnt == 1 || menu_cnt == 2 && menu_sel == 5) {
                CpCanvas.drawImg3(44, 33, 55 + sel_tip * 96 + game_cnt / 2 % 3, 207, false);
            }
        } else if (menu_no == 1) {
            if (key == 65536) {
                if (mes_flg == 0) {
                    if (--menu_sel < 0) {
                        menu_sel = fol_suu - 1;
                    }
                    menu_cnt = 0;
                }
                key = 0;
            } else if (key == 262144) {
                if (mes_flg == 0) {
                    if (++menu_sel > fol_suu - 1) {
                        menu_sel = 0;
                    }
                    menu_cnt = 0;
                }
                key = 0;
            } else if (key == 131072 || (n & 0x20000) != 0) {
                if (mes_flg == 0) {
                    if (--menu_cnt < 0) {
                        menu_cnt = 0;
                    }
                    ++key_cnt;
                } else if (mes_flg < 3) {
                    mes_flg = 1;
                }
                key = 0;
            } else if (key == 524288 || (n & 0x80000) != 0) {
                if (mes_flg == 0) {
                    if (++menu_cnt > 23) {
                        menu_cnt = 23;
                    }
                    ++key_cnt;
                } else if (mes_flg < 3) {
                    mes_flg = 2;
                }
                key = 0;
            } else if (key == 2 || (n & 2) != 0) {
                if (mes_flg == 0) {
                    if ((menu_cnt -= 7) < 0) {
                        menu_cnt = 0;
                    }
                    ++key_cnt;
                }
                key = 0;
            } else if (key == 16 || (n & 0x10) != 0) {
                if (mes_flg == 0) {
                    if ((menu_cnt += 7) > 23) {
                        menu_cnt = 23;
                    }
                    ++key_cnt;
                }
                key = 0;
            }
            CpCanvas.drawImg3(44, 21, 135 + menu_sel * 22, 21, false);
            CpCanvas.drawImg3(44, 22 + menu_sel, 141 + menu_sel * 22, 27, false);
            g.setColor(Graphics.getColorOfRGB((int)32, (int)40, (int)81));
            CpCanvas.strDraw(menu_str[6] + (menu_sel + 1), 51, 35);
            g.setColor(Graphics.getColorOfRGB((int)68, (int)80, (int)138));
            CpCanvas.strDraw(menu_str[6] + (menu_sel + 1), 50, 35);
            if (menu_sel == now_fol) {
                CpCanvas.drawImg3(44, 19, 12, 23, false);
            }
            CpCanvas.drawImg3(44, 34, 201, 43 + menu_cnt * 92 / 23, false);
            for (int i = 6; i >= 0; --i) {
                int n2 = tip_list[CpCanvas.fol[CpCanvas.menu_sel].tip_id[menu_cnt + i]] >> 8 & 0xFF;
                int n3 = tip_list[CpCanvas.fol[CpCanvas.menu_sel].tip_id[menu_cnt + i]] & 0xFF;
                tip[n2].Draw(40, 41 + i * 15, 1, true);
                g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                tip[n2].DrawName(56, 54 + i * 15);
                tip[n2].DrawZoku(155, 41 + i * 15);
                tip[n2].DrawCode(n3, 173, 55 + i * 15, 1);
                tip[n2].DrawRegu(182, 41 + i * 15);
                if (CpCanvas.fol[CpCanvas.menu_sel].regu_flg == 0 || menu_cnt + i != CpCanvas.fol[CpCanvas.menu_sel].regu_id) continue;
                g.setColor(Graphics.getColorOfRGB((int)255, (int)0, (int)0));
                g.drawRect(39, 40 + i * 15, 159, 15);
            }
            this.FaceDraw(6);
            CpCanvas.MesDraw(1);
            if (mes_flg == 1 || mes_flg == 2) {
                CpCanvas.drawImg3(44, 33, 55 + game_cnt / 2 % 3, 177 + mes_flg * 15, false);
            }
            if (mes_flg == 3) {
                CpCanvas.drawImg3(44, 108, 225, 222 + game_cnt / 3 % 2, false);
            }
            if (key == 0x100000) {
                if (mes_flg == 0) {
                    CpCanvas.MesRead(12, null, 3);
                    mes_flg = 1;
                } else if (mes_flg == 1) {
                    menu_no = 2;
                    menu_cnt = -1;
                    sel_tip = 0;
                    sel_tip2 = 0;
                    sel_jou = 0;
                    sel_jou2 = 0;
                    fol_cnt = 30;
                    tmp_tip = -1;
                    sort = -1;
                    this.CasBack(0);
                    mes_flg = 0;
                    CpCanvas.MesRead(CpCanvas.tip[CpCanvas.tip_list[CpCanvas.fol[CpCanvas.menu_sel].tip_id[CpCanvas.sel_tip]] >> 8 & 0xFF].setu_id, null, 4);
                } else if (mes_flg == 2) {
                    now_fol = menu_sel;
                    mes_flg = 3;
                    str = "" + (now_fol + 1);
                    CpCanvas.MesRead(4, str.getBytes(), 3);
                    CpCanvas.Audio(1, 11);
                } else if (mes_flg == 3) {
                    mes_flg = 0;
                    CpCanvas.MesRead(11, null, 3);
                }
                key = 0;
            } else if (key == 0x200000) {
                if (mes_flg == 0) {
                    menu_no = 0;
                    menu_cnt = -1;
                    menu_sel = 0;
                    CpCanvas.MesRead(5, null, 3);
                } else {
                    mes_flg = 0;
                    CpCanvas.MesRead(11, null, 3);
                }
                key = 0;
            }
        } else if (menu_no == 2) {
            int n4;
            int n5;
            int n6;
            CpCanvas.soft_id[0] = 2;
            CpCanvas.soft_id[1] = 7;
            if (key == 131072 || (n & 0x20000) != 0) {
                if (sort < 0) {
                    if (mes_flg == 0) {
                        if (sel_tip > 0 && --sel_tip - sel_jou < 0) {
                            --sel_jou;
                        }
                    } else if (mes_flg > 1) {
                        mes_flg = 2;
                    }
                } else if (--sort < 0) {
                    sort = 6;
                }
                ++key_cnt;
                key = 0;
            } else if (key == 524288 || (n & 0x80000) != 0) {
                if (sort < 0) {
                    if (mes_flg == 0) {
                        if (sel_tip < 29 && ++sel_tip - sel_jou >= 7) {
                            ++sel_jou;
                        }
                    } else if (mes_flg > 1) {
                        mes_flg = 3;
                    }
                } else if (++sort > 6) {
                    sort = 0;
                }
                ++key_cnt;
                key = 0;
            } else if (key == 2 || (n & 2) != 0) {
                if (sort < 0 && mes_flg == 0) {
                    if (sel_jou > 0) {
                        if ((sel_jou -= 7) < 0) {
                            sel_tip -= 7 + sel_jou;
                            sel_jou = 0;
                        } else {
                            sel_tip -= 7;
                        }
                    }
                    ++key_cnt;
                }
                key = 0;
            } else if (key == 16 || (n & 0x10) != 0) {
                if (sort < 0 && mes_flg == 0) {
                    if (sel_jou < 23) {
                        if ((sel_jou += 7) > 23) {
                            sel_tip += 7 - (sel_jou - 23);
                            sel_jou = 23;
                        } else {
                            sel_tip += 7;
                        }
                    }
                    ++key_cnt;
                }
                key = 0;
            } else if (key == 2048) {
                if (sort < 0 && mes_flg == 0 && (n6 = tip_list[CpCanvas.fol[CpCanvas.menu_sel].tip_id[sel_tip]] >> 8 & 0xFF) > 0) {
                    if (regu_you >= CpCanvas.tip[n6].regu_you) {
                        CpCanvas.fol[CpCanvas.menu_sel].regu_flg = CpCanvas.fol[CpCanvas.menu_sel].regu_flg != 0 && sel_tip == CpCanvas.fol[CpCanvas.menu_sel].regu_id ? 0 : 1;
                        CpCanvas.Audio(1, 11);
                        CpCanvas.fol[CpCanvas.menu_sel].regu_id = sel_tip;
                    } else {
                        mes_flg = -1;
                        CpCanvas.MesRead(117, null, 3);
                    }
                }
                key = 0;
            } else if (key == 0x100000) {
                if (sort < 0) {
                    if (mes_flg == 0) {
                        if (tmp_tip < 0) {
                            tmp_tip = sel_tip;
                        } else if (tmp_tip < 30) {
                            if (tmp_tip == sel_tip) {
                                this.FolCustom(sel_tip, tmp_tip, 1);
                            } else {
                                this.FolCustom(sel_tip, tmp_tip, 0);
                            }
                            tmp_tip = -1;
                        } else {
                            n5 = this.FolCustom(sel_tip, tmp_tip - 100, 4);
                            if (n5 > 0) {
                                mes_flg = -1;
                            }
                            tmp_tip = -1;
                        }
                    } else if (mes_flg == 1) {
                        CpCanvas.MesRead(14, null, 3);
                        ++mes_flg;
                    } else {
                        if (mes_flg == 2) {
                            this.CasBack(1);
                            menu_no = 1;
                            menu_cnt = -1;
                            mes_flg = 0;
                            CpCanvas.MesRead(11, null, 3);
                            key = 0;
                            return;
                        }
                        mes_flg = 0;
                    }
                } else {
                    sort_flg = fol[menu_sel].Sort(sort, sort_flg);
                    CpCanvas.Audio(1, 11);
                }
                key = 0;
            }
            if (fol_cnt < 30) {
                g.setColor(Graphics.getColorOfRGB((int)(190 + game_cnt / 2 % 3 * 30), (int)(60 + game_cnt / 2 % 3 * 10), (int)(60 + game_cnt / 2 % 3 * 15)));
                g.fillRect(175, 22, 47, 13);
            }
            CpCanvas.ImgSuu(fol_cnt, 179, 23, 16, 1, 1);
            CpCanvas.ImgSuu(30, 203, 23, 16, 1, 1);
            CpCanvas.drawImg3(44, 64, 195, 23, false);
            CpCanvas.ImgSuu(regu_you, 124, 23, 16, 1, 2);
            CpCanvas.drawImg3(44, 34, 228, 43 + sel_jou * 92 / 23, false);
            CpCanvas.drawImg3(44, 129, 198 + game_cnt / 2 % 3, 6, false);
            for (n5 = 6; n5 >= 0; --n5) {
                n6 = tip_list[CpCanvas.fol[CpCanvas.menu_sel].tip_id[sel_jou + n5]] >> 8 & 0xFF;
                n4 = tip_list[CpCanvas.fol[CpCanvas.menu_sel].tip_id[sel_jou + n5]] & 0xFF;
                if (n6 == 0) continue;
                tip[n6].Draw(68, 41 + n5 * 15, 1, true);
                g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                tip[n6].DrawName(84, 54 + n5 * 15);
                tip[n6].DrawZoku(183, 41 + n5 * 15);
                tip[n6].DrawCode(n4, 200, 54 + n5 * 15, 1);
                tip[n6].DrawRegu(210, 41 + n5 * 15);
                if (CpCanvas.fol[CpCanvas.menu_sel].regu_flg == 0 || sel_jou + n5 != CpCanvas.fol[CpCanvas.menu_sel].regu_id) continue;
                g.setColor(Graphics.getColorOfRGB((int)255, (int)0, (int)0));
                g.drawRect(67, 40 + n5 * 15, 159, 15);
            }
            n6 = tip_list[CpCanvas.fol[CpCanvas.menu_sel].tip_id[sel_tip]] >> 8 & 0xFF;
            n4 = tip_list[CpCanvas.fol[CpCanvas.menu_sel].tip_id[sel_tip]] & 0xFF;
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            if (n6 != 0) {
                tip[n6].DrawPow(30, 56);
                tip[n6].DrawCode(n4, 46, 85, 1);
                tip[n6].DrawZoku(40, 94);
                CpCanvas.drawImg3(44, 65 + n6 / 125 + n6 / 177, 15, 122, false);
                if (mes_flg == 0 && sort < 0 && key_cnt < 5) {
                    CpCanvas.MesRead(CpCanvas.tip[n6].setu_id, null, 4);
                    tip[n6].DrawSetu();
                }
            }
            if (sort < 0) {
                if (mes_flg == 0) {
                    if (tmp_tip >= 0 && tmp_tip < 30 && tmp_tip - sel_jou >= 0 && tmp_tip - sel_jou < 7) {
                        CpCanvas.drawImg3(44, 128, 60 + game_cnt / 2 % 2 * 300, 38 + (tmp_tip - sel_jou) * 15, false);
                    }
                    CpCanvas.drawImg3(44, 33, 58 + game_cnt / 2 % 3, 41 + (sel_tip - sel_jou) * 15, false);
                }
            } else {
                g.drawImage(tmp_imgMap, 5, 28, 0, 0, 61, 128);
                CpCanvas.drawImg3(44, 33, 5 + game_cnt / 2 % 3, 41 + sort * 15, false);
            }
            if (mes_flg != 0) {
                this.FaceDraw(6);
                CpCanvas.MesDraw(1);
            }
            if (mes_flg > 1) {
                CpCanvas.drawImg3(44, 33, 55 + game_cnt / 2 % 3, 162 + mes_flg * 15, false);
            }
            if (key == 262144) {
                if (sort < 0 && mes_flg == 0) {
                    menu_no = 3;
                    menu_cnt = -1;
                }
                key = 0;
            } else if (key == 0x200000) {
                if (sort >= 0) {
                    sort = -1;
                } else if (tmp_tip >= 0) {
                    tmp_tip = -1;
                } else {
                    fol_cnt = 0;
                    for (n5 = 0; n5 < 30; ++n5) {
                        if (CpCanvas.fol[CpCanvas.menu_sel].tip_id[n5] == 0) continue;
                        ++fol_cnt;
                    }
                    if (fol_cnt < 30) {
                        CpCanvas.MesRead(13, null, 3);
                        mes_flg = 1;
                    } else {
                        menu_no = 1;
                        menu_cnt = -1;
                        mes_flg = 0;
                        CpCanvas.MesRead(11, null, 3);
                    }
                }
                key = 0;
            } else if (key == 0x400000) {
                if (mes_flg == 0) {
                    if (sort < 0) {
                        sort_flg = -1;
                        sort = 0;
                        this.MakeSort();
                    } else {
                        sort = -1;
                    }
                }
                key = 0;
            }
        } else if (menu_no == 3) {
            int n7;
            int n8;
            int n9;
            int n10;
            CpCanvas.soft_id[0] = 2;
            CpCanvas.soft_id[1] = 7;
            if (key == 131072 || (n & 0x20000) != 0) {
                if (sort < 0) {
                    if (mes_flg == 0) {
                        if (sel_tip2 > 0 && --sel_tip2 - sel_jou2 < 0) {
                            --sel_jou2;
                        }
                    } else if (mes_flg > 1) {
                        mes_flg = 2;
                    }
                } else if (--sort < 0) {
                    sort = 6;
                }
                ++key_cnt;
                key = 0;
            } else if (key == 524288 || (n & 0x80000) != 0) {
                if (sort < 0) {
                    if (mes_flg == 0) {
                        if (sel_tip2 < get_tip - 1 && ++sel_tip2 - sel_jou2 >= 7) {
                            ++sel_jou2;
                        }
                    } else if (mes_flg > 1) {
                        mes_flg = 3;
                    }
                } else if (++sort > 6) {
                    sort = 0;
                }
                ++key_cnt;
                key = 0;
            } else if (key == 2 || (n & 2) != 0) {
                if (sort < 0 && mes_flg == 0) {
                    if (sel_jou2 > 0) {
                        if ((sel_jou2 -= 7) < 0) {
                            sel_tip2 -= 7 + sel_jou2;
                            sel_jou2 = 0;
                        } else {
                            sel_tip2 -= 7;
                        }
                    }
                    ++key_cnt;
                }
                key = 0;
            } else if (key == 16 || (n & 0x10) != 0) {
                if (sort < 0 && mes_flg == 0) {
                    if (sel_jou2 < get_tip - 7) {
                        if ((sel_jou2 += 7) > get_tip - 7) {
                            sel_tip2 += 7 - (sel_jou2 - (get_tip - 7));
                            sel_jou2 = get_tip - 7;
                        } else {
                            sel_tip2 += 7;
                        }
                    }
                    ++key_cnt;
                }
                key = 0;
            } else if (key == 0x100000) {
                if (sort < 0) {
                    if (mes_flg == 0) {
                        if (tmp_tip < 0) {
                            tmp_tip = sel_tip2 + 100;
                        } else if (tmp_tip > 99) {
                            if (tmp_tip - 100 == sel_tip2) {
                                n10 = this.FolCustom(sel_tip2, tmp_tip, 3);
                                if (n10 > 0) {
                                    mes_flg = -1;
                                }
                            } else {
                                this.FolCustom(sel_tip2, tmp_tip, 2);
                            }
                            tmp_tip = -1;
                        } else {
                            n10 = this.FolCustom(tmp_tip, sel_tip2, 4);
                            if (n10 > 0) {
                                mes_flg = -1;
                            }
                            tmp_tip = -1;
                        }
                    } else if (mes_flg == 1) {
                        CpCanvas.MesRead(14, null, 3);
                        ++mes_flg;
                    } else {
                        if (mes_flg == 2) {
                            this.CasBack(1);
                            menu_no = 1;
                            menu_cnt = -1;
                            mes_flg = 0;
                            CpCanvas.MesRead(11, null, 3);
                            key = 0;
                            return;
                        }
                        mes_flg = 0;
                    }
                } else {
                    this.ListSort(sort);
                    CpCanvas.Audio(1, 11);
                }
                key = 0;
            }
            n10 = 43;
            if (get_tip > 7) {
                n10 += sel_jou2 * 92 / (get_tip - 7);
            }
            CpCanvas.drawImg3(44, 34, 182, n10, false);
            CpCanvas.drawImg3(44, 130, 7 - game_cnt / 2 % 3, 6, false);
            for (n9 = 6; n9 >= 0; --n9) {
                if (get_tip <= n9) continue;
                n8 = tip_list[sort_list[sel_jou2 + n9]] >> 8 & 0xFF;
                n7 = tip_list[sort_list[sel_jou2 + n9]] & 0xFF;
                tip[n8].Draw(9, 41 + n9 * 15, 1, true);
                g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                tip[n8].DrawName(25, 54 + n9 * 15);
                tip[n8].DrawZoku(124, 41 + n9 * 15);
                tip[n8].DrawCode(n7, 141, 54 + n9 * 15, 1);
                tip[n8].DrawRegu(151, 41 + n9 * 15);
                n8 = tip_list[sort_list[sel_jou2 + n9]] >> 16 & 0xFF;
                if (n8 > 9) {
                    CpCanvas.strDraw("" + n8, 168, 54 + n9 * 15);
                    continue;
                }
                CpCanvas.strDraw("" + n8, 174, 54 + n9 * 15);
            }
            if (get_tip > 0) {
                n8 = tip_list[sort_list[sel_tip2]] >> 8 & 0xFF;
                n7 = tip_list[sort_list[sel_tip2]] & 0xFF;
                tip[n8].DrawPow(207, 56);
                tip[n8].DrawCode(n7, 223, 85, 1);
                tip[n8].DrawZoku(217, 94);
                CpCanvas.drawImg3(44, 65 + n8 / 125 + n8 / 177, 192, 122, false);
                if (mes_flg == 0 && sort < 0 && key_cnt < 5) {
                    CpCanvas.MesRead(CpCanvas.tip[n8].setu_id, null, 4);
                    tip[n8].DrawSetu();
                }
            }
            if (sort < 0) {
                if (mes_flg == 0) {
                    if (tmp_tip >= 100 && tmp_tip - 100 - sel_jou2 >= 0 && tmp_tip - 100 - sel_jou2 < 7) {
                        CpCanvas.drawImg3(44, 128, 3 + game_cnt / 2 % 2 * 300, 38 + (tmp_tip - 100 - sel_jou2) * 15, false);
                    }
                    CpCanvas.drawImg3(44, 33, 1 + game_cnt / 2 % 3, 41 + (sel_tip2 - sel_jou2) * 15, false);
                }
            } else {
                g.drawImage(tmp_imgMap, 175, 28, 0, 0, 61, 128);
                CpCanvas.drawImg3(44, 33, 175 + game_cnt / 2 % 3, 41 + sort * 15, false);
            }
            if (mes_flg != 0) {
                this.FaceDraw(6);
                CpCanvas.MesDraw(1);
            }
            if (mes_flg > 1) {
                CpCanvas.drawImg3(44, 33, 55 + game_cnt / 2 % 3, 162 + mes_flg * 15, false);
            }
            if (key == 65536) {
                if (sort < 0 && mes_flg == 0) {
                    menu_no = 2;
                    menu_cnt = -1;
                }
                key = 0;
            } else if (key == 0x200000) {
                if (sort >= 0) {
                    sort = -1;
                } else if (tmp_tip >= 0) {
                    tmp_tip = -1;
                } else {
                    fol_cnt = 0;
                    for (n9 = 0; n9 < 30; ++n9) {
                        if (CpCanvas.fol[CpCanvas.menu_sel].tip_id[n9] == 0) continue;
                        ++fol_cnt;
                    }
                    if (fol_cnt < 30) {
                        CpCanvas.MesRead(13, null, 3);
                        mes_flg = 1;
                    } else {
                        menu_no = 1;
                        menu_cnt = -1;
                        mes_flg = 0;
                        CpCanvas.MesRead(11, null, 3);
                    }
                }
                key = 0;
            } else if (key == 0x400000) {
                if (mes_flg == 0) {
                    if (sort < 0) {
                        sort_flg = -1;
                        sort = 0;
                        this.MakeSort();
                    } else {
                        sort = -1;
                    }
                }
                key = 0;
            }
        } else if (menu_no == 4) {
            int n11 = 2;
            if (menu_sel > 0) {
                n11 += TIP_MAX[0];
            }
            if (menu_sel > 1) {
                n11 += TIP_MAX[1];
            }
            if (menu_sel > 2) {
                n11 += TIP_MAX[2];
            }
            int n12 = sel_tip + n11;
            if (key == 131072 || (n & 0x20000) != 0) {
                if (sel_tip > 0 && --sel_tip - sel_jou < 0) {
                    --sel_jou;
                }
                ++key_cnt;
                key = 0;
            } else if (key == 524288 || (n & 0x80000) != 0) {
                if (sel_tip < TIP_MAX[menu_sel] - 1 && ++sel_tip - sel_jou >= 7) {
                    ++sel_jou;
                }
                ++key_cnt;
                key = 0;
            } else if (key == 2 || (n & 2) != 0) {
                if (sel_jou > 0) {
                    if ((sel_jou -= 7) < 0) {
                        sel_tip -= 7 + sel_jou;
                        sel_jou = 0;
                    } else {
                        sel_tip -= 7;
                    }
                }
                ++key_cnt;
                key = 0;
            } else if (key == 16 || (n & 0x10) != 0) {
                if (sel_jou < TIP_MAX[menu_sel] - 7) {
                    if ((sel_jou += 7) > TIP_MAX[menu_sel] - 7) {
                        sel_tip += 7 - (sel_jou - (TIP_MAX[menu_sel] - 7));
                        sel_jou = TIP_MAX[menu_sel] - 7;
                    } else {
                        sel_tip += 7;
                    }
                }
                ++key_cnt;
                key = 0;
            }
            CpCanvas.ImgSuu(get_tip2[menu_sel], 167, 23, 24, 1, 1);
            CpCanvas.ImgSuu(TIP_MAX[menu_sel], 199, 23, 24, 1, 1);
            int n13 = 43;
            if (TIP_MAX[menu_sel] > 7) {
                n13 += sel_jou * 92 / (TIP_MAX[menu_sel] - 7);
            }
            CpCanvas.drawImg3(44, 34, 228, n13, false);
            if (menu_sel > 0) {
                CpCanvas.drawImg3(44, 31, 7 + game_cnt / 3 % 2 * 300, 25, false);
            }
            if (menu_sel < 3) {
                CpCanvas.drawImg3(44, 30, 128 + game_cnt / 3 % 2 * 300, 25, false);
            }
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            for (int i = 6; i >= 0; --i) {
                n12 = sel_jou + i + n11;
                if (menu_sel == 2 && n12 >= TIP_MAX[4]) continue;
                CpCanvas.ImgSuu(n12 - n11 + 1, 68, 43 + i * 15, 24, 1, 1);
                g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                if (get_list[n12] != 0) {
                    tip[n12].DrawName(110, 54 + i * 15);
                    if (menu_sel >= 3) continue;
                    tip[n12].DrawRea(210, 44 + i * 15);
                    tip[n12].Draw(94, 41 + i * 15, 1, true);
                    continue;
                }
                CpCanvas.strDraw(menu_str[32], 110, 54 + i * 15);
            }
            n12 = sel_tip + n11;
            if (get_list[n12] != 0) {
                n12 = sel_tip + n11;
                tip[n12].DrawPow(30, 56);
                tip[n12].DrawZoku(40, 94);
                if (menu_sel < 3) {
                    CpCanvas.drawImg3(44, 65 + n12 / 125 + n12 / 177, 15, 122, false);
                }
                if (key_cnt < 5) {
                    CpCanvas.MesRead(CpCanvas.tip[n12].setu_id, null, 4);
                    tip[n12].DrawSetu();
                }
            }
            CpCanvas.drawImg3(44, 33, 58 + game_cnt / 2 % 3, 41 + (sel_tip - sel_jou) * 15, false);
            if (key == 65536) {
                if (menu_sel > 0) {
                    --menu_sel;
                    menu_cnt = -1;
                    sel_tip = 0;
                    sel_jou = 0;
                }
                key = 0;
            }
            if (key == 262144) {
                if (menu_sel < 3) {
                    ++menu_sel;
                    menu_cnt = -1;
                    sel_tip = 0;
                    sel_jou = 0;
                }
                key = 0;
            } else if (key == 0x200000) {
                menu_no = 0;
                menu_cnt = -1;
                menu_sel = 1;
                CpCanvas.MesRead(6, null, 3);
                key = 0;
            }
        } else if (menu_no == 5) {
            int n14;
            if (mes_flg == 0) {
                if (key == 131072 || (n & 0x20000) != 0) {
                    if (mes_flg == 0 && menu_cnt > 0 && --menu_cnt - sel_jou < 0) {
                        --sel_jou;
                    }
                    ++key_cnt;
                    key = 0;
                } else if (key == 524288 || (n & 0x80000) != 0) {
                    if (mes_flg == 0 && menu_cnt < mail_suu - 1 && ++menu_cnt - sel_jou >= 8) {
                        ++sel_jou;
                    }
                    ++key_cnt;
                    key = 0;
                } else if (key == 0x100000) {
                    if (mail_suu > 0) {
                        n14 = mail_suu - menu_cnt;
                        this.IventRead(n14, 2);
                        ++mes_flg;
                    }
                    key = 0;
                }
            }
            int n15 = 42;
            if (mail_suu > 8) {
                n15 += sel_jou * 92 / (mail_suu - 8);
            }
            CpCanvas.drawImg3(44, 34, 57, n15, false);
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            for (int i = 7; i >= 0; --i) {
                if (mail_suu <= i + sel_jou) continue;
                n14 = mail_open >> mail_suu - (sel_jou + i) - 1 & 1;
                if (n14 == 0) {
                    CpCanvas.drawImg3(44, 80, 18, 42 + i * 14, false);
                    CpCanvas.drawImg3(44, 82, 16, 37 + i * 14, false);
                } else {
                    CpCanvas.drawImg3(44, 81, 18, 42 + i * 14, false);
                }
                n14 = mail_suu - (sel_jou + i);
                CpCanvas.ImgSuu(n14, 36, 39 + i * 14, 16, 3, 1);
            }
            if (mail_suu > 0) {
                n14 = mail_open >> mail_suu - menu_cnt - 1 & 1;
                if (n14 == 0) {
                    CpCanvas.drawImg3(44, 80, 197, 53, false);
                } else {
                    CpCanvas.drawImg3(44, 81, 197, 53, false);
                }
                n14 = mail_suu - menu_cnt - 1;
                CpCanvas.ImgSuu(n14 + 1, 213, 51, 16, 3, 1);
                this.FaceDraw2(CpCanvas.mail[n14].face, 71, 52);
                CpCanvas.strDraw(CpCanvas.mail[n14].str_f, 130, 76);
                CpCanvas.strDraw(CpCanvas.mail[n14].str_t, 130, 99);
                g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
                CpCanvas.strDraw(CpCanvas.mail[n14].str_s, 72, 126);
            }
            CpCanvas.drawImg3(44, 33, 5 + game_cnt / 2 % 3, 38 + (menu_cnt - sel_jou) * 14, false);
            if (ivent_flg >= 0) {
                CpCanvas.soft_id[0] = 0;
                CpCanvas.soft_id[1] = 0;
                if (this.IventMain() < 0) {
                    mes_flg = 0;
                    n14 = mail_suu - menu_cnt - 1;
                    mail_open |= 1 << n14;
                }
                return;
            }
            CpCanvas.MesRead(15, null, 3);
            this.FaceDraw(6);
            CpCanvas.MesDraw(1);
            if (key == 0x200000) {
                if (mes_flg == 0) {
                    menu_no = 0;
                    menu_sel = 4;
                    menu_cnt = -1;
                    CpCanvas.MesRead(9, null, 3);
                } else {
                    mes_cnt = 90;
                }
                key = 0;
            }
        } else if (menu_no == 6) {
            if (key == 131072 || (n & 0x20000) != 0) {
                if (menu_cnt > 0) {
                    --menu_cnt;
                }
                ++key_cnt;
                key = 0;
            } else if (key == 524288 || (n & 0x80000) != 0) {
                if (menu_cnt + 7 < Edit.set_cnt) {
                    ++menu_cnt;
                }
                ++key_cnt;
                key = 0;
            }
            int n16 = 42;
            if (Edit.set_cnt > 7) {
                n16 += menu_cnt * 92 / (Edit.set_cnt - 7);
            }
            CpCanvas.drawImg3(44, 34, 224, n16, false);
            CpCanvas.ImgSuu(now_hp, 12, 28, 32, 1, 1);
            CpCanvas.ImgSuu(max_hp, 52, 28, 32, 1, 1);
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            for (int i = 6; i >= 0; --i) {
                if (Edit.set2[menu_cnt + i] < 0) continue;
                int n17 = skill_list[Edit.set2[menu_cnt + i]] & 0xFF;
                int n18 = skill_list[Edit.set2[menu_cnt + i]] >> 8 & 0xFF;
                if (i >= Edit.set_cnt) continue;
                CpCanvas.drawImg3(51 + n18, n17, 101, 41 + i * 15, false);
                CpCanvas.strDraw(CpCanvas.skill[n17].name, 118, 54 + i * 15);
            }
            if (skill_flg == 0) {
                CpCanvas.MesRead(16, null, 3);
            } else {
                CpCanvas.MesRead(17, null, 3);
            }
            this.FaceDraw(6);
            CpCanvas.MesDraw(1);
            if (skill_flg != 0) {
                CpCanvas.drawImg3(44, 33, 68 + game_cnt / 2 % 3, 192, false);
            }
            if (key == 0x100000) {
                if (skill_flg != 0) {
                    ++menu_no;
                    menu_sel = 0;
                    menu_cnt = -1;
                }
                key = 0;
            } else if (key == 0x200000) {
                menu_no = 0;
                menu_sel = 3;
                menu_cnt = -1;
                CpCanvas.MesRead(8, null, 3);
                key = 0;
            }
        } else if (menu_no == 7) {
            int n19;
            int n20;
            int n21;
            if (key == 131072 || (n & 0x20000) != 0 && menu_sel == 0) {
                if (menu_sel == 0) {
                    if (sel_tip > 0 && --sel_tip - sel_jou < 0) {
                        --sel_jou;
                    }
                } else if (menu_sel == 1 && sel_tip2 - 3 >= 0) {
                    sel_tip2 -= 3;
                }
                ++key_cnt;
                key = 0;
            } else if (key == 524288 || (n & 0x80000) != 0 && menu_sel == 0) {
                if (menu_sel == 0) {
                    if (sel_tip < skill_suu - 1 && ++sel_tip - sel_jou >= 7) {
                        ++sel_jou;
                    }
                } else if (menu_sel == 1) {
                    if (sel_tip2 + 3 < Edit.max_slot) {
                        sel_tip2 += 3;
                    }
                }
                ++key_cnt;
                key = 0;
            } else if (key == 65536) {
                if (menu_sel == 0) {
                    menu_sel = 1;
                    sel_tip2 = 2;
                } else if (menu_sel == 1) {
                    if (sel_tip2 % 3 != 0) {
                        --sel_tip2;
                    }
                } else if (menu_sel == 3) {
                    menu_cnt = 0;
                }
                key = 0;
            } else if (key == 262144) {
                if (menu_sel == 1) {
                    if (sel_tip2 % 3 < 2) {
                        ++sel_tip2;
                    } else {
                        menu_sel = 0;
                    }
                } else if (menu_sel == 3) {
                    menu_cnt = 1;
                }
                key = 0;
            } else if (key == 2 || (n & 2) != 0) {
                if (menu_sel == 0 && sel_jou > 0) {
                    if ((sel_jou -= 7) < 0) {
                        sel_tip -= 7 + sel_jou;
                        sel_jou = 0;
                    } else {
                        sel_tip -= 7;
                    }
                }
                ++key_cnt;
                key = 0;
            } else if (key == 16 || (n & 0x10) != 0) {
                if (menu_sel == 0 && sel_jou < skill_suu - 7) {
                    if ((sel_jou += 7) > skill_suu - 7) {
                        sel_tip += 7 - (sel_jou - (skill_suu - 7));
                        sel_jou = skill_suu - 7;
                    } else {
                        sel_tip += 7;
                    }
                }
                ++key_cnt;
                key = 0;
            } else if (key == 0x100000) {
                n21 = Edit.r_zoku;
                if (menu_sel == 0) {
                    if (skill_suu > 0) {
                        n20 = edit.Set(sort_skill[sel_tip]);
                        if (n20 >= 0) {
                            CpCanvas.Audio(1, 11);
                            CpCanvas.PalSet(0, n20);
                            g.setColor(Graphics.getColorOfRGB((int)255, (int)100, (int)100));
                            edit.Slect(Edit.now_slot - 1);
                        } else {
                            CpCanvas.MesRead(18, null, 3);
                            menu_sel = 2;
                        }
                    }
                } else if (menu_sel == 1) {
                    if (Edit.set[sel_tip2] > 0) {
                        CpCanvas.MesRead(19, null, 3);
                        menu_cnt = 0;
                        menu_sel = 3;
                    }
                } else if (menu_sel == 2) {
                    menu_sel = 0;
                } else if (menu_sel == 3) {
                    menu_sel = 1;
                    if (menu_cnt == 0) {
                        edit.Dell(sel_tip2);
                        CpCanvas.PalSet(0, Edit.r_zoku);
                        CpCanvas.Audio(1, 11);
                        n20 = now_hp;
                        if (this.SkillRun(1) != 0) {
                            CpCanvas.MesRead(138, null, 3);
                            menu_sel = 2;
                        }
                        now_hp = n20;
                    }
                }
                if (n21 != Edit.r_zoku) {
                    menu_cnt = 5;
                }
                key = 0;
            }
            n21 = 42;
            if (skill_suu > 7) {
                n21 += sel_jou * 92 / (skill_suu - 7);
            }
            CpCanvas.drawImg3(44, 34, 224, n21, false);
            for (n20 = 6; n20 >= 0; --n20) {
                n19 = skill_list[sort_skill[sel_jou + n20]] & 0xFF;
                int n22 = skill_list[sort_skill[sel_jou + n20]] >> 8 & 0xFF;
                if (sel_jou + n20 >= skill_suu) continue;
                CpCanvas.drawImg3(51 + n22, n19, 89, 41 + n20 * 15, false);
                g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                CpCanvas.strDraw(CpCanvas.skill[n19].name, 118, 54 + n20 * 15);
                g.setColor(Graphics.getColorOfRGB((int)255, (int)234, (int)0));
                CpCanvas.strDraw("x" + CpCanvas.skill[n19].you, 104, 54 + n20 * 15);
                g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
                n19 = skill_list[sort_skill[sel_jou + n20]] >> 16 & 0xFF;
                CpCanvas.strDraw("" + n19, 216, 54 + n20 * 15);
            }
            if (menu_sel == 0) {
                if (skill_suu > 0 && key_cnt < 5) {
                    n19 = skill_list[sort_skill[sel_tip]] & 0xFF;
                    CpCanvas.MesRead(n19, null, 5);
                    CpCanvas.MesDraw(2);
                }
            } else if (menu_sel == 1) {
                if (Edit.set[sel_tip2] >= 0) {
                    if (Edit.now_slot > sel_tip2) {
                        n19 = skill_list[Edit.set[sel_tip2] & 0xFF] & 0xFF;
                        CpCanvas.MesRead(n19, null, 5);
                        CpCanvas.MesDraw(2);
                    }
                }
            }
            if (menu_sel == 0) {
                CpCanvas.drawImg3(44, 33, 78 + game_cnt / 2 % 3, 41 + (sel_tip - sel_jou) * 15, false);
                n19 = skill_list[sort_skill[sel_tip]] & 0xFF;
                n20 = skill_list[sort_skill[sel_tip]] >> 8 & 0xFF;
                int n23 = CpCanvas.skill[n19].you;
                if (skill_suu > 0 && game_cnt / 2 % 2 == 0) {
                    if (n23 + Edit.now_slot <= Edit.max_slot) {
                        int n24 = Edit.now_slot;
                        while (true) {
                            if (n24 >= Edit.now_slot + n23) break;
                            CpCanvas.drawImg3(51 + n20, n19, 16 + n24 % 3 * 19, 52 + n24 / 3 * 20, false);
                            ++n24;
                        }
                    }
                }
                edit.Draw();
            } else if (menu_sel == 1) {
                g.setColor(Graphics.getColorOfRGB((int)100, (int)237, (int)215));
                edit.Slect(sel_tip2);
                edit.Draw();
                CpCanvas.drawImg3(44, 33, 5 + sel_tip2 % 3 * 19 + game_cnt / 2 % 3, 52 + sel_tip2 / 3 * 20, false);
            } else if (menu_sel == 3) {
                g.setColor(Graphics.getColorOfRGB((int)100, (int)237, (int)215));
                edit.Slect(sel_tip2);
                edit.Draw();
                CpCanvas.drawImg3(44, 33, 5 + sel_tip2 % 3 * 19 + game_cnt / 2 % 3, 52 + sel_tip2 / 3 * 20, false);
                CpCanvas.drawImg3(44, 33, 55 + menu_cnt * 96 + game_cnt / 2 % 3, 207, false);
            } else {
                edit.Draw();
            }
            if (menu_cnt < 2) {
                g.setFlipMode(1);
                CpCanvas.drawImg3(0, 0, 8, 203, false);
                g.setFlipMode(0);
            } else {
                --menu_cnt;
            }
            if (menu_sel > 1) {
                CpCanvas.MesDraw(1);
            }
            if (key == 0x200000) {
                if (this.SkillRun(1) != 0) {
                    CpCanvas.MesRead(138, null, 3);
                    menu_sel = 2;
                } else {
                    --menu_no;
                    menu_sel = 0;
                    menu_cnt = -1;
                }
                key = 0;
            }
        }
    }

    public void MenuMake(int n) {
        if (n == 0) {
            int n2;
            CpCanvas.drawImg3(44, 0, 0, 0, true);
            CpCanvas.drawImg3(44, 47, 125, 10, true);
            graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
            graMap.fillRect(4, 20, 232, 136);
            for (n2 = 0; n2 < 6; ++n2) {
                CpCanvas.drawImg3(44, 52, 34, 28 + n2 * 21, true);
                graMap.setColor(Graphics.getColorOfRGB((int)72, (int)96, (int)120));
                CpCanvas.strDrawG(menu_str[n2], 37, 43 + n2 * 21);
                graMap.setColor(Graphics.getColorOfRGB((int)208, (int)208, (int)208));
                CpCanvas.strDrawG(menu_str[n2], 36, 42 + n2 * 21);
            }
            for (n2 = 0; n2 < 3; ++n2) {
                CpCanvas.drawImg3(44, 48, 138, 27 + n2 * 35, true);
                CpCanvas.drawImg3(44, 49 + n2, 143, 30 + n2 * 35, true);
            }
            CpCanvas.drawImg3(44, 64, 182, 42, true);
            CpCanvas.drawImg3(44, 42, 212, 80, true);
            CpCanvas.drawImg3(44, 43, 212, 115, true);
        } else if (n == 1) {
            CpCanvas.drawImg3(44, 0, 0, 0, true);
            CpCanvas.drawImg3(44, 46, 8, 8, true);
            graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
            graMap.fillRect(4, 20, 232, 136);
            CpCanvas.drawImg3(44, 1, 27, 28, true);
            CpCanvas.drawImg3(44, 2, 127, 28, true);
            graMap.setColor(Graphics.getColorOfRGB((int)200, (int)224, (int)248));
            graMap.fillRect(30, 37, 178, 112);
            CpCanvas.drawImg3(44, 4, 28, 21, true);
            CpCanvas.drawImg3(44, 5, 35, 21, true);
            CpCanvas.drawImg3(44, 5, 46, 21, true);
            CpCanvas.drawImg3(44, 6, 114, 21, true);
            if (fol_suu > 1) {
                for (int i = 0; i < fol_suu; ++i) {
                    CpCanvas.drawImg3(44, 20, 135 + i * 22, 21, true);
                    CpCanvas.drawImg3(44, 22 + i, 141 + i * 22, 27, true);
                }
                CpCanvas.drawImg3(44, 31, 18, 89, true);
                CpCanvas.drawImg3(44, 30, 214, 89, true);
            }
            graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
            graMap.fillRect(36, 37, 164, 112);
            CpCanvas.drawImg3(44, 3, 200, 37, true);
            CpCanvas.drawImg3(44, 68, 201, 26, true);
            CpCanvas.drawImg3(44, 69, 201, 144, true);
        } else if (n == 2) {
            CpCanvas.drawImg3(44, 0, 0, 0, true);
            CpCanvas.drawImg3(44, 45, 8, 8, true);
            graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
            graMap.fillRect(0, 20, 240, 136);
            CpCanvas.drawImg3(44, 1, 0, 28, true);
            CpCanvas.drawImg3(44, 2, 154, 28, true);
            graMap.setColor(Graphics.getColorOfRGB((int)200, (int)224, (int)248));
            graMap.fillRect(3, 37, 232, 112);
            CpCanvas.drawImg3(44, 4, 1, 21, true);
            CpCanvas.drawImg3(44, 5, 9, 21, true);
            CpCanvas.drawImg3(44, 5, 78, 21, true);
            CpCanvas.drawImg3(44, 5, 88, 21, true);
            CpCanvas.drawImg3(44, 6, 157, 21, true);
            CpCanvas.drawImg3(44, 44, 13, 37, true);
            graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
            graMap.fillRect(65, 37, 162, 112);
            CpCanvas.drawImg3(44, 3, 227, 37, true);
            CpCanvas.drawImg3(44, 68, 228, 26, true);
            CpCanvas.drawImg3(44, 69, 228, 144, true);
            graMap.setColor(Graphics.getColorOfRGB((int)32, (int)40, (int)81));
            CpCanvas.strDrawG(menu_str[6] + (menu_sel + 1), 66, 35);
            graMap.setColor(Graphics.getColorOfRGB((int)68, (int)80, (int)138));
            CpCanvas.strDrawG(menu_str[6] + (menu_sel + 1), 65, 35);
            CpCanvas.drawImg3(44, 18, 127, 30, true);
            graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            graMap.fillRect(174, 21, 49, 15);
            graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
            graMap.fillRect(175, 22, 47, 13);
            CpCanvas.drawImg3(44, 120, 12, 135, true);
        } else if (n == 3) {
            CpCanvas.drawImg3(44, 0, 0, 0, true);
            CpCanvas.drawImg3(44, 45, 144, 8, true);
            graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
            graMap.fillRect(0, 20, 240, 136);
            CpCanvas.drawImg3(44, 1, 0, 28, true);
            CpCanvas.drawImg3(44, 2, 154, 28, true);
            graMap.setColor(Graphics.getColorOfRGB((int)200, (int)224, (int)248));
            graMap.fillRect(3, 37, 232, 112);
            CpCanvas.drawImg3(44, 4, 126, 21, true);
            CpCanvas.drawImg3(44, 5, 134, 21, true);
            CpCanvas.drawImg3(44, 5, 160, 21, true);
            CpCanvas.drawImg3(44, 6, 229, 21, true);
            CpCanvas.drawImg3(44, 44, 190, 37, true);
            graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
            graMap.fillRect(6, 37, 175, 112);
            graMap.setColor(Graphics.getColorOfRGB((int)32, (int)40, (int)81));
            CpCanvas.strDrawG(menu_str[7], 133, 35);
            graMap.setColor(Graphics.getColorOfRGB((int)68, (int)80, (int)138));
            CpCanvas.strDrawG(menu_str[7], 132, 35);
            CpCanvas.drawImg3(44, 3, 181, 37, true);
            CpCanvas.drawImg3(44, 68, 182, 26, true);
            CpCanvas.drawImg3(44, 69, 182, 144, true);
        } else if (n == 4) {
            CpCanvas.drawImg3(44, 0, 0, 0, true);
            CpCanvas.drawImg3(44, 70, 8, 8, true);
            graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
            graMap.fillRect(0, 20, 240, 136);
            CpCanvas.drawImg3(44, 1, 0, 28, true);
            CpCanvas.drawImg3(44, 2, 154, 28, true);
            graMap.setColor(Graphics.getColorOfRGB((int)200, (int)224, (int)248));
            graMap.fillRect(3, 37, 232, 112);
            CpCanvas.drawImg3(44, 4, 1, 21, true);
            CpCanvas.drawImg3(44, 5, 9, 21, true);
            CpCanvas.drawImg3(44, 5, 78, 21, true);
            CpCanvas.drawImg3(44, 5, 88, 21, true);
            CpCanvas.drawImg3(44, 6, 157, 21, true);
            CpCanvas.drawImg3(44, 44, 13, 37, true);
            graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
            graMap.fillRect(65, 37, 162, 112);
            CpCanvas.drawImg3(44, 3, 227, 37, true);
            CpCanvas.drawImg3(44, 68, 228, 26, true);
            CpCanvas.drawImg3(44, 69, 228, 144, true);
            graMap.setColor(Graphics.getColorOfRGB((int)32, (int)40, (int)81));
            CpCanvas.strDrawG(menu_str[8 + menu_sel], 16, 35);
            graMap.setColor(Graphics.getColorOfRGB((int)68, (int)80, (int)138));
            CpCanvas.strDrawG(menu_str[8 + menu_sel], 15, 35);
            graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            graMap.fillRect(163, 21, 65, 15);
            graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
            graMap.fillRect(164, 22, 63, 13);
            CpCanvas.drawImg3(44, 64, 191, 23, true);
        } else if (n == 5) {
            CpCanvas.drawImg3(44, 0, 0, 0, true);
            CpCanvas.drawImg3(44, 76, 8, 8, true);
            graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
            graMap.fillRect(0, 20, 240, 136);
            CpCanvas.drawImg3(44, 1, 0, 28, true);
            CpCanvas.drawImg3(44, 2, 154, 28, true);
            graMap.setColor(Graphics.getColorOfRGB((int)200, (int)224, (int)248));
            graMap.fillRect(3, 37, 232, 112);
            CpCanvas.drawImg3(44, 4, 1, 21, true);
            CpCanvas.drawImg3(44, 5, 9, 21, true);
            CpCanvas.drawImg3(44, 5, 78, 21, true);
            CpCanvas.drawImg3(44, 5, 88, 21, true);
            CpCanvas.drawImg3(44, 6, 157, 21, true);
            graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
            graMap.fillRect(13, 37, 43, 112);
            graMap.setColor(Graphics.getColorOfRGB((int)96, (int)112, (int)192));
            for (int i = 0; i < 8; ++i) {
                graMap.fillRect(13, 51 + i / 2 * 28, 43, 14);
            }
            CpCanvas.drawImg3(44, 3, 56, 37, true);
            graMap.setColor(Graphics.getColorOfRGB((int)96, (int)112, (int)192));
            graMap.fillRect(67, 37, 164, 9);
            CpCanvas.drawImg3(44, 77, 68, 39, true);
            graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)218));
            graMap.fillRect(67, 48, 164, 62);
            graMap.setColor(Graphics.getColorOfRGB((int)240, (int)248, (int)248));
            graMap.fillRect(231, 37, 1, 9);
            graMap.fillRect(231, 48, 1, 84);
            graMap.fillRect(67, 110, 164, 22);
            CpCanvas.drawImg3(44, 78, 122, 56, true);
            CpCanvas.drawImg3(44, 79, 122, 79, true);
            CpCanvas.drawImg3(44, 83, 67, 104, true);
            graMap.setColor(Graphics.getColorOfRGB((int)32, (int)40, (int)81));
            CpCanvas.strDrawG(menu_str[19 + menu_sel], 16, 35);
            graMap.setColor(Graphics.getColorOfRGB((int)68, (int)80, (int)138));
            CpCanvas.strDrawG(menu_str[19 + menu_sel], 15, 35);
        } else if (menu_no == 6) {
            CpCanvas.drawImg3(44, 0, 0, 0, true);
            CpCanvas.drawImg3(44, 86, 8, 8, true);
            for (int i = 0; i < 15; ++i) {
                CpCanvas.drawImg3(44, 92, 4 + i % 5 * 48 - i % 5 / 4 * 8, 20 + i / 5 * 48 - i / 10 * 8, true);
            }
            CpCanvas.drawImg3(44, 97, 6, 110, true);
            CpCanvas.drawImg3(44, 98, 6, 137, true);
            CpCanvas.drawImg3(44, 88, 9, 113, true);
            CpCanvas.drawImg3(44, 99, 93, 28, true);
            CpCanvas.drawImg3(44, 100, 220, 28, true);
            graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            graMap.fillRect(9, 25, 78, 16);
            graMap.setColor(Graphics.getColorOfRGB((int)48, (int)60, (int)78));
            graMap.fillRect(10, 26, 76, 14);
            graMap.setColor(Graphics.getColorOfRGB((int)200, (int)224, (int)248));
            graMap.fillRect(96, 37, 135, 112);
            graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
            graMap.fillRect(100, 37, 124, 112);
            CpCanvas.drawImg3(44, 3, 223, 37, true);
            CpCanvas.drawImg3(44, 4, 94, 21, true);
            CpCanvas.drawImg3(44, 5, 102, 21, true);
            CpCanvas.drawImg3(44, 6, 169, 21, true);
            CpCanvas.drawImg3(44, 64, 45, 28, true);
            graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            CpCanvas.strDrawG(menu_str[23] + ata_lv, 11, 132);
            CpCanvas.strDrawG(menu_str[24] + cha_lv, 11, 147);
            graMap.setColor(Graphics.getColorOfRGB((int)32, (int)40, (int)81));
            CpCanvas.strDrawG(menu_str[21], 102, 35);
            graMap.setColor(Graphics.getColorOfRGB((int)68, (int)80, (int)138));
            CpCanvas.strDrawG(menu_str[21], 101, 35);
            graMap.setFlipMode(1);
            CpCanvas.drawImg3(0, 0, 27, 79, true);
            graMap.setFlipMode(0);
        } else if (menu_no == 7) {
            int n3;
            CpCanvas.drawImg3(44, 0, 0, 0, true);
            CpCanvas.drawImg3(44, 87, 8, 8, true);
            for (n3 = 0; n3 < 15; ++n3) {
                CpCanvas.drawImg3(44, 92, 4 + n3 % 5 * 48 - n3 % 5 / 4 * 8, 20 + n3 / 5 * 48 - n3 / 10 * 8, true);
            }
            CpCanvas.drawImg3(44, 99, 82, 28, true);
            CpCanvas.drawImg3(44, 100, 220, 28, true);
            graMap.setColor(Graphics.getColorOfRGB((int)200, (int)224, (int)248));
            graMap.fillRect(87, 33, 144, 120);
            graMap.setColor(Graphics.getColorOfRGB((int)120, (int)152, (int)216));
            graMap.fillRect(88, 37, 135, 112);
            CpCanvas.drawImg3(44, 3, 223, 37, true);
            CpCanvas.drawImg3(44, 4, 83, 21, true);
            CpCanvas.drawImg3(44, 5, 91, 21, true);
            CpCanvas.drawImg3(44, 5, 119, 21, true);
            CpCanvas.drawImg3(44, 6, 188, 21, true);
            graMap.setColor(Graphics.getColorOfRGB((int)32, (int)40, (int)81));
            CpCanvas.strDrawG(menu_str[22], 102, 35);
            graMap.setColor(Graphics.getColorOfRGB((int)68, (int)80, (int)138));
            CpCanvas.strDrawG(menu_str[22], 101, 35);
            CpCanvas.drawImg3(44, 101, 6, 39, true);
            CpCanvas.drawImg3(44, 102, 72, 39, true);
            CpCanvas.drawImg3(44, 103, 6, 48, true);
            CpCanvas.drawImg3(44, 104, 75, 48, true);
            CpCanvas.drawImg3(44, 105, 6, 132, true);
            CpCanvas.drawImg3(44, 106, 72, 132, true);
            CpCanvas.drawImg3(44, 89, 15, 42, true);
            graMap.setColor(Graphics.getColorOfRGB((int)200, (int)224, (int)248));
            graMap.fillRect(9, 48, 66, 85);
            graMap.setColor(Graphics.getColorOfRGB((int)61, (int)81, (int)101));
            graMap.fillRect(12, 48, 60, 84);
            n3 = 0;
            while (true) {
                if (n3 >= Edit.max_slot) break;
                CpCanvas.drawImg3(44, 93, 15 + n3 % 3 * 19, 51 + n3 / 3 * 20, true);
                ++n3;
            }
        }
        graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        graMap.fillRect(2, 162, 236, 76);
        key = 0;
    }

    public void MakeSort() {
        tmp_graMap.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
        tmp_graMap.fillRect(0, 0, 128, 240);
        CpCanvas.drawImg4(44, 94, 0, 0);
        CpCanvas.drawImg4(44, 95, 0, 11);
        CpCanvas.drawImg4(44, 95, 0, 39);
        CpCanvas.drawImg4(44, 95, 0, 67);
        CpCanvas.drawImg4(44, 95, 0, 95);
        CpCanvas.drawImg4(44, 96, 0, 123);
        tmp_graMap.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        for (int i = 0; i < 7; ++i) {
            CpCanvas.strDrawTG(menu_str[12 + i], 13, 26 + i * 15);
        }
    }

    public static void AddLib(int n) {
        if (n < 2) {
            return;
        }
        if (get_list[n] == 0) {
            CpCanvas.get_list[n] = 1;
            n = n < 125 ? 0 : (n < 177 ? 1 : (n < 181 ? 2 : 3));
            int n2 = n;
            get_tip2[n2] = get_tip2[n2] + 1;
            if (n == 0) {
                CpCanvas.get_tip2[0] = 0;
                for (int i = 2; i < 125; ++i) {
                    if (get_list[i] == 0) continue;
                    get_tip2[0] = get_tip2[0] + 1;
                }
            }
            if (get_tip2[n] >= TIP_MAX[n]) {
                CpCanvas.get_tip2[n] = TIP_MAX[n];
                CpCanvas.dat[59 + n] = 1;
                CpCanvas.writeSP();
            }
        }
    }

    public void CasBack(int n) {
        if (n == 0) {
            int n2;
            list_suu = get_tip;
            for (n2 = 29; n2 >= 0; --n2) {
                CpCanvas.fol_data[n2] = CpCanvas.fol[CpCanvas.menu_sel].tip_id[n2];
            }
            for (n2 = 508; n2 >= 0; --n2) {
                CpCanvas.list_data[n2] = sort_list[n2] + (tip_list[n2] & 0xFFFF0000);
            }
            CpCanvas.list_data[509] = CpCanvas.fol[CpCanvas.menu_sel].regu_id;
            CpCanvas.list_data[510] = CpCanvas.fol[CpCanvas.menu_sel].regu_flg;
        } else {
            int n3;
            get_tip = list_suu;
            for (n3 = 29; n3 >= 0; --n3) {
                CpCanvas.fol[CpCanvas.menu_sel].tip_id[n3] = fol_data[n3];
            }
            for (n3 = 508; n3 >= 0; --n3) {
                CpCanvas.sort_list[n3] = list_data[n3] & 0xFFFF;
                CpCanvas.tip_list[n3] = (tip_list[n3] & 0xFFFF) + (list_data[n3] & 0xFFFF0000);
            }
            CpCanvas.fol[CpCanvas.menu_sel].regu_id = list_data[509];
            CpCanvas.fol[CpCanvas.menu_sel].regu_flg = list_data[510];
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public int FolCustom(int n, int n2, int n3) {
        block27: {
            int n4;
            block31: {
                block30: {
                    block29: {
                        block28: {
                            block25: {
                                block26: {
                                    if (n3 != 0) break block25;
                                    int n5 = CpCanvas.fol[CpCanvas.menu_sel].tip_id[n];
                                    CpCanvas.fol[CpCanvas.menu_sel].tip_id[n] = CpCanvas.fol[CpCanvas.menu_sel].tip_id[n2];
                                    CpCanvas.fol[CpCanvas.menu_sel].tip_id[n2] = n5;
                                    if (CpCanvas.fol[CpCanvas.menu_sel].regu_id != n) break block26;
                                    CpCanvas.fol[CpCanvas.menu_sel].regu_id = n2;
                                    break block27;
                                }
                                if (CpCanvas.fol[CpCanvas.menu_sel].regu_id != n2) break block27;
                                CpCanvas.fol[CpCanvas.menu_sel].regu_id = n;
                                break block27;
                            }
                            if (n3 != 1) break block28;
                            int n6 = CpCanvas.fol[CpCanvas.menu_sel].tip_id[n];
                            if (n6 == 0) {
                                return 0;
                            }
                            fol[menu_sel].FolNon(n);
                            --fol_cnt;
                            this.GetItem(0, 0, n6);
                            if (CpCanvas.fol[CpCanvas.menu_sel].regu_id != n) break block27;
                            CpCanvas.fol[CpCanvas.menu_sel].regu_flg = 0;
                            break block27;
                        }
                        if (n3 != 2) break block29;
                        int n7 = sort_list[n];
                        CpCanvas.sort_list[n] = sort_list[n2 -= 100];
                        CpCanvas.sort_list[n2] = n7;
                        break block27;
                    }
                    if (n3 != 3) break block30;
                    if (fol_cnt >= 30) {
                        CpCanvas.Audio(1, 12);
                        return -1;
                    }
                    n4 = sort_list[n];
                    break block31;
                }
                if (n3 != 4) break block27;
                int n8 = CpCanvas.fol[CpCanvas.menu_sel].tip_id[n];
                if (n8 == 0) {
                    ++fol_cnt;
                } else {
                    fol[menu_sel].FolNon(n);
                    this.GetItem(0, 0, n8);
                }
                int n9 = sort_list[n2];
                n3 = fol[menu_sel].FolSet(n, n9);
                if (n3 != 0) {
                    fol[menu_sel].FolSet(n, n8);
                    this.GetItem(0, 1, n8);
                    if (n3 == 1) {
                        CpCanvas.MesRead(120, null, 3);
                    }
                    if (n3 == 2) {
                        CpCanvas.MesRead(115, null, 3);
                    }
                    if (n3 == 3) {
                        CpCanvas.MesRead(116, null, 3);
                    }
                    if (n3 == 4) {
                        str = "" + m_max;
                        CpCanvas.MesRead(113, str.getBytes(), 3);
                    }
                    if (n3 == 5) {
                        str = "" + g_max;
                        CpCanvas.MesRead(114, str.getBytes(), 3);
                    }
                    if (n8 == 0) {
                        --fol_cnt;
                    }
                    return n3;
                }
                if (CpCanvas.fol[CpCanvas.menu_sel].regu_id == n) {
                    CpCanvas.fol[CpCanvas.menu_sel].regu_flg = 0;
                }
                if (this.GetItem(0, 1, n9) == 1) {
                    if (get_tip >= 7 && get_tip - sel_jou2 < 7) {
                        --sel_tip2;
                        --sel_jou2;
                    }
                    if (get_tip <= sel_tip2) {
                        --sel_tip2;
                    }
                }
                break block27;
            }
            for (int i = 0; i < 30; ++i) {
                if (CpCanvas.fol[CpCanvas.menu_sel].tip_id[i] != 0) continue;
                n3 = fol[menu_sel].FolSet(i, n4);
                if (n3 != 0) {
                    if (n3 == 1) {
                        CpCanvas.MesRead(120, null, 3);
                    }
                    if (n3 == 2) {
                        CpCanvas.MesRead(115, null, 3);
                    }
                    if (n3 == 3) {
                        CpCanvas.MesRead(116, null, 3);
                    }
                    if (n3 == 4) {
                        str = "" + m_max;
                        CpCanvas.MesRead(113, str.getBytes(), 3);
                    }
                    if (n3 == 5) {
                        str = "" + g_max;
                        CpCanvas.MesRead(114, str.getBytes(), 3);
                    }
                    CpCanvas.Audio(1, 12);
                    return n3;
                }
                if (this.GetItem(0, 1, n4) == 1) {
                    if (get_tip >= 7 && get_tip - sel_jou2 < 7) {
                        --sel_tip2;
                        --sel_jou2;
                    }
                    if (get_tip <= sel_tip2) {
                        --sel_tip2;
                    }
                }
                ++fol_cnt;
                break;
            }
        }
        CpCanvas.Audio(1, 11);
        return 0;
    }

    public void ListSort(int n) {
        int n2;
        int n3 = 0;
        int[] nArray = new int[510];
        for (n2 = 2; n2 < 509; ++n2) {
            if ((tip_list[n2] >> 16 & 0xFF) <= 0) continue;
            CpCanvas.sort_list[n3] = n2;
            ++n3;
        }
        if (n == 0) {
            if (sort_flg == n) {
                int n4;
                n3 = 0;
                for (n2 = 2; n2 < 509; ++n2) {
                    if ((tip_list[n2] >> 16 & 0xFF) <= 0) continue;
                    nArray[n3] = n2;
                    ++n3;
                }
                int[] nArray2 = new int[n3];
                for (n4 = 0; n4 < n3; ++n4) {
                    nArray2[n4] = tip_list[nArray[n4]] & 0xFF00 | 255 - (tip_list[nArray[n4]] & 0xFF);
                }
                for (n4 = 0; n4 < n3; ++n4) {
                    int n5 = n4;
                    for (int i = n4 + 1; i < n3; ++i) {
                        if (nArray2[n5] >= nArray2[i]) continue;
                        n5 = i;
                    }
                    int n6 = nArray2[n4];
                    nArray2[n4] = nArray2[n5];
                    nArray2[n5] = n6;
                    n6 = nArray[n4];
                    nArray[n4] = nArray[n5];
                    nArray[n5] = n6;
                    CpCanvas.sort_list[n4] = nArray[n4];
                }
            }
        } else if (n == 1) {
            if (sort_flg != n) {
                for (i = 0; i < n3; ++i) {
                    for (j = 0; j < n3 - 1 - i; ++j) {
                        int n7 = tip_list[sort_list[j]] >> 8 & 0xFF;
                        int n8 = tip_list[sort_list[j + 1]] >> 8 & 0xFF;
                        if (CpCanvas.tip[n7].aiu <= CpCanvas.tip[n8].aiu) continue;
                        int n9 = sort_list[j];
                        CpCanvas.sort_list[CpCanvas.j] = sort_list[j + 1];
                        CpCanvas.sort_list[CpCanvas.j + 1] = n9;
                    }
                }
            } else {
                for (i = 0; i < n3; ++i) {
                    for (j = 0; j < n3 - 1 - i; ++j) {
                        int n10 = tip_list[sort_list[j]] >> 8 & 0xFF;
                        int n11 = tip_list[sort_list[j + 1]] >> 8 & 0xFF;
                        if (CpCanvas.tip[n10].aiu >= CpCanvas.tip[n11].aiu) continue;
                        int n12 = sort_list[j];
                        CpCanvas.sort_list[CpCanvas.j] = sort_list[j + 1];
                        CpCanvas.sort_list[CpCanvas.j + 1] = n12;
                    }
                }
            }
        } else if (n == 2) {
            if (sort_flg != n) {
                for (i = 0; i < n3; ++i) {
                    for (j = 0; j < n3 - 1 - i; ++j) {
                        int n13 = tip_list[sort_list[j]] & 0xFF;
                        int n14 = tip_list[sort_list[j + 1]] & 0xFF;
                        if (n13 <= n14) continue;
                        int n15 = sort_list[j];
                        CpCanvas.sort_list[CpCanvas.j] = sort_list[j + 1];
                        CpCanvas.sort_list[CpCanvas.j + 1] = n15;
                    }
                }
            } else {
                for (i = 0; i < n3; ++i) {
                    for (j = 0; j < n3 - 1 - i; ++j) {
                        int n16 = tip_list[sort_list[j]] & 0xFF;
                        int n17 = tip_list[sort_list[j + 1]] & 0xFF;
                        if (n16 >= n17) continue;
                        int n18 = sort_list[j];
                        CpCanvas.sort_list[CpCanvas.j] = sort_list[j + 1];
                        CpCanvas.sort_list[CpCanvas.j + 1] = n18;
                    }
                }
            }
        } else if (n == 3) {
            if (sort_flg != n) {
                for (i = 0; i < n3; ++i) {
                    for (j = 0; j < n3 - 1 - i; ++j) {
                        int n19 = tip_list[sort_list[j]] >> 8 & 0xFF;
                        int n20 = tip_list[sort_list[j + 1]] >> 8 & 0xFF;
                        if (CpCanvas.tip[n19].pow >= CpCanvas.tip[n20].pow) continue;
                        int n21 = sort_list[j];
                        CpCanvas.sort_list[CpCanvas.j] = sort_list[j + 1];
                        CpCanvas.sort_list[CpCanvas.j + 1] = n21;
                    }
                }
            } else {
                for (i = 0; i < n3; ++i) {
                    for (j = 0; j < n3 - 1 - i; ++j) {
                        int n22 = tip_list[sort_list[j]] >> 8 & 0xFF;
                        int n23 = tip_list[sort_list[j + 1]] >> 8 & 0xFF;
                        if (CpCanvas.tip[n22].pow <= CpCanvas.tip[n23].pow) continue;
                        int n24 = sort_list[j];
                        CpCanvas.sort_list[CpCanvas.j] = sort_list[j + 1];
                        CpCanvas.sort_list[CpCanvas.j + 1] = n24;
                    }
                }
            }
        } else if (n == 4) {
            if (sort_flg != n) {
                for (i = 0; i < n3; ++i) {
                    for (j = 0; j < n3 - 1 - i; ++j) {
                        int n25 = tip_list[sort_list[j]] >> 8 & 0xFF;
                        int n26 = tip_list[sort_list[j + 1]] >> 8 & 0xFF;
                        if ((CpCanvas.tip[n25].zoku + 4) % 5 <= (CpCanvas.tip[n26].zoku + 4) % 5) continue;
                        int n27 = sort_list[j];
                        CpCanvas.sort_list[CpCanvas.j] = sort_list[j + 1];
                        CpCanvas.sort_list[CpCanvas.j + 1] = n27;
                    }
                }
            } else {
                for (i = 0; i < n3; ++i) {
                    for (j = 0; j < n3 - 1 - i; ++j) {
                        int n28 = tip_list[sort_list[j]] >> 8 & 0xFF;
                        int n29 = tip_list[sort_list[j + 1]] >> 8 & 0xFF;
                        if ((CpCanvas.tip[n28].zoku + 4) % 5 >= (CpCanvas.tip[n29].zoku + 4) % 5) continue;
                        int n30 = sort_list[j];
                        CpCanvas.sort_list[CpCanvas.j] = sort_list[j + 1];
                        CpCanvas.sort_list[CpCanvas.j + 1] = n30;
                    }
                }
            }
        } else if (n == 5) {
            if (sort_flg != n) {
                for (i = 0; i < n3; ++i) {
                    for (j = 0; j < n3 - 1 - i; ++j) {
                        int n31 = tip_list[sort_list[j]] >> 16 & 0xFF;
                        int n32 = tip_list[sort_list[j + 1]] >> 16 & 0xFF;
                        if (n31 >= n32) continue;
                        int n33 = sort_list[j];
                        CpCanvas.sort_list[CpCanvas.j] = sort_list[j + 1];
                        CpCanvas.sort_list[CpCanvas.j + 1] = n33;
                    }
                }
            } else {
                for (i = 0; i < n3; ++i) {
                    for (j = 0; j < n3 - 1 - i; ++j) {
                        int n34 = tip_list[sort_list[j]] >> 16 & 0xFF;
                        int n35 = tip_list[sort_list[j + 1]] >> 16 & 0xFF;
                        if (n34 <= n35) continue;
                        int n36 = sort_list[j];
                        CpCanvas.sort_list[CpCanvas.j] = sort_list[j + 1];
                        CpCanvas.sort_list[CpCanvas.j + 1] = n36;
                    }
                }
            }
        } else if (n == 6) {
            if (sort_flg != n) {
                for (i = 0; i < n3; ++i) {
                    for (j = 0; j < n3 - 1 - i; ++j) {
                        int n37 = tip_list[sort_list[j]] >> 8 & 0xFF;
                        int n38 = tip_list[sort_list[j + 1]] >> 8 & 0xFF;
                        if (CpCanvas.tip[n37].regu_you <= CpCanvas.tip[n38].regu_you) continue;
                        int n39 = sort_list[j];
                        CpCanvas.sort_list[CpCanvas.j] = sort_list[j + 1];
                        CpCanvas.sort_list[CpCanvas.j + 1] = n39;
                    }
                }
            } else {
                for (i = 0; i < n3; ++i) {
                    for (j = 0; j < n3 - 1 - i; ++j) {
                        int n40 = tip_list[sort_list[j]] >> 8 & 0xFF;
                        int n41 = tip_list[sort_list[j + 1]] >> 8 & 0xFF;
                        if (CpCanvas.tip[n40].regu_you >= CpCanvas.tip[n41].regu_you) continue;
                        int n42 = sort_list[j];
                        CpCanvas.sort_list[CpCanvas.j] = sort_list[j + 1];
                        CpCanvas.sort_list[CpCanvas.j + 1] = n42;
                    }
                }
            }
        }
        sort_flg = sort_flg != n ? n : -1;
        sort = n;
        get_tip = n3;
    }

    public static void SortSkill(int n) {
        int n2 = 0;
        for (int i = 0; i < 145; ++i) {
            if ((skill_list[i] >> 16 & 0xFF) <= 0) continue;
            CpCanvas.sort_skill[n2] = i;
            ++n2;
        }
        skill_suu = n2;
        if (n != 0 && skill_suu != 0) {
            if (skill_suu >= 7 && skill_suu - sel_jou < 7) {
                --sel_tip;
                --sel_jou;
            }
            if (skill_suu <= sel_tip) {
                --sel_tip;
            }
        }
    }

    public int SkillRun(int n) {
        int n2;
        int n3;
        if (n != 2) {
            for (n3 = 23; n3 < 29; ++n3) {
                max_hp -= skill_kouka[n3] * CpCanvas.skill[n3].param;
            }
            if (skill_kouka[22] != 0) {
                max_hp *= 2;
            }
        }
        ata_lv = 1;
        cha_lv = 1;
        m_max = 5;
        g_max = 1;
        for (n3 = 0; n3 < 29; ++n3) {
            CpCanvas.skill_kouka[n3] = 0;
        }
        if (n != 0) {
            n3 = 0;
            while (true) {
                if (n3 >= Edit.set_cnt) break;
                int n4 = n2 = skill_list[Edit.set2[n3]] & 0xFF;
                skill_kouka[n4] = skill_kouka[n4] + 1;
                ++n3;
            }
            if (skill_kouka[22] != 0) {
                max_hp /= 2;
                skill_kouka[0] = skill_kouka[0] + 1;
                CpCanvas.skill_kouka[6] = 1;
                ++m_max;
                CpCanvas.skill_kouka[9] = 1;
            }
            if (skill_kouka[20] != 0) {
                ata_lv += 3;
                cha_lv += 3;
            }
            if (skill_kouka[9] != 0) {
                CpCanvas.skill_kouka[5] = 1;
                CpCanvas.skill_kouka[7] = 1;
                CpCanvas.skill_kouka[8] = 1;
            }
            m_max += skill_kouka[2] + skill_kouka[3] * 2;
            g_max += skill_kouka[4];
            ata_lv += skill_kouka[16];
            cha_lv += skill_kouka[17];
            if (skill_kouka[18] != 0) {
                ata_lv = 5;
            }
            if (skill_kouka[19] != 0) {
                cha_lv = 5;
            }
            if (ata_lv > 5) {
                ata_lv = 5;
            }
            if (cha_lv > 5) {
                cha_lv = 5;
            }
            for (n3 = 23; n3 < 29; ++n3) {
                max_hp += skill_kouka[n3] * CpCanvas.skill[n3].param;
            }
        }
        if (back_menu != 3) {
            now_hp = max_hp;
        } else if (now_hp > max_hp) {
            now_hp = max_hp;
        }
        for (n3 = 0; n3 < fol_suu; ++n3) {
            n2 = fol[n3].FolCh();
            if (n2 <= 0) continue;
            return n2;
        }
        return 0;
    }

    public void Save(int n) {
        int n2;
        int n3;
        int[] nArray = new int[437];
        int n4 = now_hp;
        this.SkillRun(0);
        now_hp = n4;
        nArray[0] = map_no;
        nArray[1] = map_x;
        nArray[2] = map_y;
        nArray[3] = max_hp;
        nArray[4] = now_hp;
        nArray[5] = zenny;
        nArray[6] = piece;
        nArray[7] = full_ene;
        nArray[8] = now_fol;
        nArray[9] = fol_suu;
        nArray[10] = regu_you;
        nArray[11] = get_tip;
        nArray[12] = get_tip2[0];
        nArray[13] = get_tip2[1];
        nArray[14] = (get_tip2[2] << 8) + get_tip2[3];
        nArray[15] = mail_suu;
        nArray[16] = back_menu;
        nArray[17] = mail_open;
        nArray[18] = now_bgm;
        nArray[19] = skill_suu;
        nArray[20] = user_id;
        for (n3 = 0; n3 < 7; ++n3) {
            for (n2 = 0; n2 < 32; ++n2) {
                int n5 = 21 + n3;
                nArray[n5] = nArray[n5] + ((get_list[n3 * 32 + n2] & 1) << n2);
            }
        }
        for (n3 = 0; n3 < 60; ++n3) {
            nArray[28 + n3] = CpCanvas.fol[n3 / 15].tip_id[n3 % 15 * 2] + (CpCanvas.fol[n3 / 15].tip_id[n3 % 15 * 2 + 1] << 16);
        }
        for (n3 = 0; n3 < 128; ++n3) {
            nArray[88 + n3] = (tip_list[n3 * 4] >> 16 & 0xFF) + ((tip_list[n3 * 4 + 1] >> 16 & 0xFF) << 8) + ((tip_list[n3 * 4 + 2] >> 16 & 0xFF) << 16) + ((tip_list[n3 * 4 + 3] >> 16 & 0xFF) << 24);
        }
        for (n3 = 0; n3 < 37; ++n3) {
            nArray[216 + n3] = (skill_list[n3 * 4] >> 16 & 0xFF) + ((skill_list[n3 * 4 + 1] >> 16 & 0xFF) << 8) + ((skill_list[n3 * 4 + 2] >> 16 & 0xFF) << 16) + ((skill_list[n3 * 4 + 3] >> 16 & 0xFF) << 24);
        }
        for (n3 = 0; n3 < 12; ++n3) {
            nArray[253 + n3] = Edit.set[n3];
        }
        for (n3 = 0; n3 < 12; ++n3) {
            nArray[265 + n3] = Edit.set2[n3];
        }
        for (n3 = 0; n3 < 5; ++n3) {
            nArray[277 + n3] = Edit.zoku[n3];
        }
        nArray[282] = Edit.r_zoku;
        nArray[283] = Edit.set_cnt;
        nArray[284] = Edit.now_slot;
        nArray[285] = Edit.max_slot;
        for (n3 = 0; n3 < 21; ++n3) {
            nArray[286 + n3] = talk_flg[n3][0] + (talk_flg[n3][1] << 8) + (talk_flg[n3][2] << 16) + (talk_flg[n3][3] << 24);
        }
        for (n3 = 0; n3 < 5; ++n3) {
            nArray[307 + n3] = move_ok[n3 * 4] + (move_ok[n3 * 4 + 1] << 8) + (move_ok[n3 * 4 + 2] << 16) + (move_ok[n3 * 4 + 3] << 24);
        }
        for (n3 = 0; n3 < 5; ++n3) {
            nArray[312 + n3] = plg_ok[n3 * 4] + (plg_ok[n3 * 4 + 1] << 8) + (plg_ok[n3 * 4 + 2] << 16) + (plg_ok[n3 * 4 + 3] << 24);
        }
        for (n3 = 0; n3 < 9; ++n3) {
            for (n2 = 0; n2 < 32; ++n2) {
                int n6 = 317 + n3;
                nArray[n6] = nArray[n6] + ((item_flg[n3 * 8 + n2 / 4][n2 % 4] & 1) << n2);
            }
        }
        for (n3 = 0; n3 < 9; ++n3) {
            for (n2 = 0; n2 < 8; ++n2) {
                int n7 = 326 + n3;
                nArray[n7] = nArray[n7] + (tobi_flg[n3 * 8 + n2][0] + tobi_flg[n3 * 8 + n2][1] * 4 << n2 * 4);
            }
        }
        for (n3 = 0; n3 < 18; ++n3) {
            for (n2 = 0; n2 < 4; ++n2) {
                int n8 = 335 + n3;
                nArray[n8] = nArray[n8] + (chara_flg[n3 * 4 + n2][0] + (chara_flg[n3 * 4 + n2][1] << 2) + (chara_flg[n3 * 4 + n2][2] << 4) + (chara_flg[n3 * 4 + n2][3] << 6) << n2 * 8);
            }
        }
        nArray[353] = quest_flg;
        nArray[354] = machi_no;
        nArray[355] = sina_no;
        nArray[356] = sina_flg;
        nArray[357] = skill_flg;
        nArray[358] = s_hen;
        nArray[359] = q_hen;
        nArray[360] = quest_no;
        nArray[361] = q_get;
        for (n3 = 0; n3 < 10; ++n3) {
            nArray[362 + n3] = q_list[n3];
        }
        nArray[372] = tmp_point;
        for (n3 = 0; n3 < 20; ++n3) {
            nArray[373 + n3] = teki_ren[n3 / 10][n3 % 10];
        }
        for (n3 = 0; n3 < 12; ++n3) {
            nArray[393] = nArray[393] + (navi_flg[n3] << n3 * 2);
        }
        nArray[394] = dat[58] + (dat[59] << 4) + (dat[60] << 8) + (dat[61] << 12) + (dat[62] << 16) + (dat[63] << 20);
        for (n3 = 0; n3 < 8; ++n3) {
            for (j = 0; j < 3; ++j) {
                nArray[395 + n3 * 3 + CpCanvas.j] = sh_zai[n3][j * 4] + (sh_zai[n3][j * 4 + 1] << 8) + (sh_zai[n3][j * 4 + 2] << 16) + (sh_zai[n3][j * 4 + 3] << 24);
            }
        }
        for (n3 = 0; n3 < 3; ++n3) {
            nArray[419 + n3] = CpCanvas.fol[n3].regu_id;
        }
        nArray[422] = CpCanvas.fol[0].regu_flg + (CpCanvas.fol[1].regu_flg << 1) + (CpCanvas.fol[2].regu_flg << 2);
        nArray[423] = q_flg[0];
        nArray[424] = q_flg[1];
        for (n3 = 0; n3 < 12; ++n3) {
            nArray[425 + n3] = Edit.flg[n3];
        }
        this.SkillRun(1);
        now_hp = n4;
        if (n == 0) {
            DataOutputStream dataOutputStream = null;
            try {
                dataOutputStream = Connector.openDataOutputStream((String)"scratchpad:///0;pos=300,length=3096");
                for (n2 = 0; n2 < 437; ++n2) {
                    dataOutputStream.writeInt(nArray[n2]);
                }
                dataOutputStream.flush();
                dataOutputStream.close();
                dataOutputStream = null;
                System.gc();
            }
            catch (Exception exception) {}
        } else {
            this.DataSave(nArray, n);
        }
        System.gc();
    }

    public void Load(int n) {
        int n2;
        int n3;
        DataInputStream dataInputStream;
        int[] nArray = new int[437];
        if (n == 0) {
            dataInputStream = null;
            try {
                dataInputStream = Connector.openDataInputStream((String)"scratchpad:///0;pos=300,length=3096");
                for (n3 = 0; n3 < 437; ++n3) {
                    nArray[n3] = dataInputStream.readInt();
                }
                dataInputStream.close();
                dataInputStream = null;
                System.gc();
            }
            catch (Exception exception) {}
        } else {
            http_error = 1;
            dataInputStream = null;
            InputStream inputStream = null;
            byte[] byArray = new byte[4];
            try {
                String string = "http://game.capcom.jp/i/exe/sreg/iexe_score.php?uid=NULLGWDOCOMO&ty=load";
                if (n == 2) {
                    string = string + "&re=1";
                }
                int n4 = nArray.length * 4;
                string = DomeUrl + dev + "party/sreg/isr.php?uid=NULLGWDOCOMO&k=" + AppID + "&v0=" + Ver + "&ty=load&b0=" + n4;
                System.out.println("w_url:" + string);
                dataInputStream = (HttpConnection)Connector.open((String)string, (int)3, (boolean)true);
                dataInputStream.setRequestMethod("GET");
                dataInputStream.connect();
                String string2 = dataInputStream.getHeaderField("X-CAPCOM-STATUS");
                System.out.println("flg = " + n + " X-CAPCOM-STATUS = " + string2);
                if (string2 == null) {
                    http_error = 200;
                } else if (string2.compareTo("NG") == 0) {
                    http_error = 100;
                } else if (string2.compareTo("MT") == 0) {
                    http_error = 150;
                } else if (string2.compareTo("OK") == 0) {
                    inputStream = dataInputStream.openInputStream();
                    inputStream.read(byArray, 0, 1);
                    http_error = byArray[0] & 0xFF;
                    inputStream.read(byArray, 0, 1);
                    zan = byArray[0] & 0xFF;
                    System.out.println("load http_error:" + http_error + " zan:" + zan);
                    if (http_error == 3) {
                        for (int i = 0; i < 437; ++i) {
                            inputStream.read(byArray);
                            nArray[i] = (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                        }
                    }
                    inputStream.close();
                    inputStream = null;
                } else {
                    http_error = 255;
                }
                System.gc();
                dataInputStream.close();
            }
            catch (Exception exception) {
                try {
                    dataInputStream.close();
                    inputStream.close();
                }
                catch (Exception exception2) {
                    // empty catch block
                }
                http_error = 255;
            }
            System.out.println("load2 http_error:" + http_error + " zan:" + zan);
            if (http_error != 3) {
                return;
            }
        }
        muki = 3;
        if (nArray[3] == 0) {
            this.init(0);
            this.Save(0);
            return;
        }
        map_no = nArray[0];
        map_x = nArray[1];
        map_y = nArray[2];
        max_hp = nArray[3];
        now_hp = nArray[4];
        zenny = nArray[5];
        piece = nArray[6];
        full_ene = nArray[7];
        now_fol = nArray[8];
        fol_suu = nArray[9];
        regu_you = nArray[10];
        get_tip = nArray[11];
        CpCanvas.get_tip2[0] = nArray[12];
        CpCanvas.get_tip2[1] = nArray[13];
        CpCanvas.get_tip2[2] = nArray[14] >> 8;
        CpCanvas.get_tip2[3] = nArray[14] & 0xFF;
        mail_suu = nArray[15];
        back_menu = nArray[16];
        mail_open = nArray[17];
        now_bgm = nArray[18];
        skill_suu = nArray[19];
        user_id = nArray[20];
        for (n2 = 0; n2 < 7; ++n2) {
            for (n3 = 0; n3 < 32; ++n3) {
                CpCanvas.get_list[n2 * 32 + n3] = nArray[21 + n2] >> n3 & 1;
            }
        }
        for (n2 = 0; n2 < 60; ++n2) {
            CpCanvas.fol[n2 / 15].tip_id[n2 % 15 * 2] = nArray[28 + n2] & 0xFFFF;
            CpCanvas.fol[n2 / 15].tip_id[n2 % 15 * 2 + 1] = nArray[28 + n2] >> 16;
        }
        for (n2 = 0; n2 < 128; ++n2) {
            CpCanvas.tip_list[n2 * 4] = (tip_list[n2 * 4] & 0xFFFF) + ((nArray[88 + n2] & 0xFF) << 16);
            CpCanvas.tip_list[n2 * 4 + 1] = (tip_list[n2 * 4 + 1] & 0xFFFF) + ((nArray[88 + n2] >> 8 & 0xFF) << 16);
            CpCanvas.tip_list[n2 * 4 + 2] = (tip_list[n2 * 4 + 2] & 0xFFFF) + ((nArray[88 + n2] >> 16 & 0xFF) << 16);
            CpCanvas.tip_list[n2 * 4 + 3] = (tip_list[n2 * 4 + 3] & 0xFFFF) + ((nArray[88 + n2] >> 24 & 0xFF) << 16);
        }
        for (n2 = 0; n2 < 37; ++n2) {
            CpCanvas.skill_list[n2 * 4] = (skill_list[n2 * 4] & 0xFFFF) + ((nArray[216 + n2] & 0xFF) << 16);
            CpCanvas.skill_list[n2 * 4 + 1] = (skill_list[n2 * 4 + 1] & 0xFFFF) + ((nArray[216 + n2] >> 8 & 0xFF) << 16);
            CpCanvas.skill_list[n2 * 4 + 2] = (skill_list[n2 * 4 + 2] & 0xFFFF) + ((nArray[216 + n2] >> 16 & 0xFF) << 16);
            CpCanvas.skill_list[n2 * 4 + 3] = (skill_list[n2 * 4 + 3] & 0xFFFF) + ((nArray[216 + n2] >> 24 & 0xFF) << 16);
        }
        for (n2 = 0; n2 < 12; ++n2) {
            Edit.set[n2] = nArray[253 + n2];
        }
        for (n2 = 0; n2 < 12; ++n2) {
            Edit.set2[n2] = nArray[265 + n2];
        }
        for (n2 = 0; n2 < 5; ++n2) {
            Edit.zoku[n2] = nArray[277 + n2];
        }
        Edit.r_zoku = nArray[282];
        Edit.set_cnt = nArray[283];
        Edit.now_slot = nArray[284];
        Edit.max_slot = nArray[285];
        for (n2 = 0; n2 < 21; ++n2) {
            CpCanvas.talk_flg[n2][0] = nArray[286 + n2] & 0xFF;
            CpCanvas.talk_flg[n2][1] = nArray[286 + n2] >> 8 & 0xFF;
            CpCanvas.talk_flg[n2][2] = nArray[286 + n2] >> 16 & 0xFF;
            CpCanvas.talk_flg[n2][3] = nArray[286 + n2] >> 24 & 0xFF;
        }
        for (n2 = 0; n2 < 5; ++n2) {
            CpCanvas.move_ok[n2 * 4] = nArray[307 + n2] & 0xFF;
            CpCanvas.move_ok[n2 * 4 + 1] = nArray[307 + n2] >> 8 & 0xFF;
            CpCanvas.move_ok[n2 * 4 + 2] = nArray[307 + n2] >> 16 & 0xFF;
            CpCanvas.move_ok[n2 * 4 + 3] = nArray[307 + n2] >> 24 & 0xFF;
        }
        for (n2 = 0; n2 < 5; ++n2) {
            CpCanvas.plg_ok[n2 * 4] = nArray[312 + n2] & 0xFF;
            CpCanvas.plg_ok[n2 * 4 + 1] = nArray[312 + n2] >> 8 & 0xFF;
            CpCanvas.plg_ok[n2 * 4 + 2] = nArray[312 + n2] >> 16 & 0xFF;
            CpCanvas.plg_ok[n2 * 4 + 3] = nArray[312 + n2] >> 24 & 0xFF;
        }
        for (n2 = 0; n2 < 9; ++n2) {
            for (n3 = 0; n3 < 32; ++n3) {
                CpCanvas.item_flg[n2 * 8 + n3 / 4][n3 % 4] = nArray[317 + n2] >> n3 & 1;
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            for (n3 = 0; n3 < 8; ++n3) {
                CpCanvas.tobi_flg[n2 * 8 + n3][0] = nArray[326 + n2] >> n3 * 4 & 3;
                CpCanvas.tobi_flg[n2 * 8 + n3][1] = nArray[326 + n2] >> n3 * 4 >> 2 & 3;
            }
        }
        for (n2 = 0; n2 < 18; ++n2) {
            for (n3 = 0; n3 < 4; ++n3) {
                CpCanvas.chara_flg[n2 * 4 + n3][0] = nArray[335 + n2] >> n3 * 8 & 3;
                CpCanvas.chara_flg[n2 * 4 + n3][1] = nArray[335 + n2] >> n3 * 8 >> 2 & 3;
                CpCanvas.chara_flg[n2 * 4 + n3][2] = nArray[335 + n2] >> n3 * 8 >> 4 & 3;
                CpCanvas.chara_flg[n2 * 4 + n3][3] = nArray[335 + n2] >> n3 * 8 >> 6 & 3;
            }
        }
        quest_flg = nArray[353];
        machi_no = nArray[354];
        sina_no = nArray[355];
        sina_flg = nArray[356];
        skill_flg = nArray[357];
        s_hen = nArray[358];
        q_hen = nArray[359];
        quest_no = nArray[360];
        q_get = nArray[361];
        for (n2 = 0; n2 < 10; ++n2) {
            CpCanvas.q_list[n2] = nArray[362 + n2];
        }
        tmp_point = nArray[372];
        for (n2 = 0; n2 < 20; ++n2) {
            CpCanvas.teki_ren[n2 / 10][n2 % 10] = nArray[373 + n2];
        }
        for (n2 = 0; n2 < 12; ++n2) {
            CpCanvas.navi_flg[n2] = nArray[393] >> n2 * 2 & 3;
        }
        CpCanvas.dat[58] = nArray[394] & 0xF;
        CpCanvas.dat[59] = nArray[394] >> 4 & 0xF;
        CpCanvas.dat[60] = nArray[394] >> 8 & 0xF;
        CpCanvas.dat[61] = nArray[394] >> 12 & 0xF;
        CpCanvas.dat[62] = nArray[394] >> 16 & 0xF;
        CpCanvas.dat[63] = nArray[394] >> 20 & 0xF;
        for (n2 = 0; n2 < 8; ++n2) {
            for (j = 0; j < 3; ++j) {
                CpCanvas.sh_zai[n2][CpCanvas.j * 4] = nArray[395 + n2 * 3 + j] & 0xFF;
                CpCanvas.sh_zai[n2][CpCanvas.j * 4 + 1] = nArray[395 + n2 * 3 + j] >> 8 & 0xFF;
                CpCanvas.sh_zai[n2][CpCanvas.j * 4 + 2] = nArray[395 + n2 * 3 + j] >> 16 & 0xFF;
                CpCanvas.sh_zai[n2][CpCanvas.j * 4 + 3] = nArray[395 + n2 * 3 + j] >> 24 & 0xFF;
            }
        }
        for (n2 = 0; n2 < 3; ++n2) {
            CpCanvas.fol[n2].regu_id = nArray[419 + n2];
        }
        CpCanvas.fol[0].regu_flg = nArray[422] & 1;
        CpCanvas.fol[1].regu_flg = nArray[422] >> 1 & 1;
        CpCanvas.fol[2].regu_flg = nArray[422] >> 2 & 1;
        CpCanvas.q_flg[0] = nArray[423];
        CpCanvas.q_flg[1] = nArray[424];
        for (n2 = 0; n2 < 12; ++n2) {
            Edit.flg[n2] = nArray[425 + n2];
        }
        this.SkillRun(2);
        CpCanvas.PalSet(0, Edit.r_zoku);
        System.gc();
    }

    public static void ImgSuu(int n, int n2, int n3, int n4, int n5, int n6) {
        block16: {
            int n7;
            int[] nArray;
            block17: {
                block15: {
                    int n8 = 8;
                    nArray = new int[7];
                    n7 = 1;
                    if (n >= 1000000) {
                        n = 999999;
                    }
                    int n9 = n;
                    if (n > 0) {
                        n7 = 0;
                        while (n9 > 0) {
                            n9 /= 10;
                            ++n7;
                        }
                    }
                    for (i = 6; i >= 0; --i) {
                        n9 = 10;
                        for (j = i - 1; j >= 0; --j) {
                            n9 *= 10;
                        }
                        nArray[CpCanvas.i] = n % n9 * 10 / n9;
                    }
                    if (n5 != 0) {
                        if (n5 == 1) {
                            n2 += n4 - n7 * 8;
                        } else if (n5 == 2) {
                            if (n4 > 0) {
                                n2 += (n4 - n7 * n8) / 2;
                            }
                        } else if (n5 == 3) {
                            n7 = n4 / 8;
                        }
                    }
                    if (n6 != 0) break block15;
                    for (i = n7 - 1; i >= 0; --i) {
                        CpCanvas.drawImg2(43, 30 + nArray[i], n2 + (n7 - 1 - i) * 8, n3, 0, 0, 0);
                    }
                    break block16;
                }
                if (n6 != 1) break block17;
                for (i = n7 - 1; i >= 0; --i) {
                    CpCanvas.drawImg2(44, 54 + nArray[i], n2 + (n7 - 1 - i) * 8, n3, 0, 0, 0);
                }
                break block16;
            }
            if (n6 != 2) break block16;
            for (i = n7 - 1; i >= 0; --i) {
                CpCanvas.drawImg2(44, 7 + nArray[i], n2 + (n7 - 1 - i) * 8, n3, 0, 0, 0);
            }
        }
    }

    public static void readSP() {
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = Connector.openDataInputStream((String)"scratchpad:///0;pos=0,length=300");
            for (int i = 0; i < 75; ++i) {
                CpCanvas.dat[i] = dataInputStream.readInt();
            }
            dataInputStream.close();
            dataInputStream = null;
            System.gc();
            audio_flg = dat[53];
        }
        catch (Exception exception) {
            // empty catch block
        }
        CpCanvas.sysLoad();
    }

    public static void writeSP() {
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = Connector.openDataOutputStream((String)"scratchpad:///0;pos=0,length=300");
            for (int i = 0; i < 75; ++i) {
                dataOutputStream.writeInt(dat[i]);
            }
            dataOutputStream.flush();
            dataOutputStream.close();
            dataOutputStream = null;
            System.gc();
        }
        catch (Exception exception) {
            // empty catch block
        }
        CpCanvas.sysSave();
    }

    public void processEvent(int n, int n2) {
        if (n == 0) {
            key = 1 << n2;
        }
    }

    private void NetData() {
        int n;
        http_error = 0;
        int n2 = 0;
        int n3 = 3396;
        byte[] byArray = new byte[128000];
        mill = System.currentTimeMillis();
        n2 = (int)(mill /= 10000L);
        if (dat[49] == 0) {
            CpCanvas.dat[53] = audio_flg = 1;
            g.setColor(Graphics.getColorOfRGB((int)170, (int)170, (int)170));
            CpCanvas.strDraw(this.set_str[5], 5, 105);
            CpCanvas.strDraw(this.set_str[3], 150, 105);
            g.fillRect(58, 110, 2, 4);
            g.fillRect(180, 110, 2, 4);
            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
            g.fillRect(59, 111, 122, 2);
            g.setColor(Graphics.getColorOfRGB((int)80, (int)80, (int)80));
            g.fillRect(60, 111, 120, 2);
            g.unlock(true);
            user_id = n2;
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            g.lock();
            try {
                n = 0;
                OutputStream outputStream = null;
                n2 = 1;
                for (i = 0; i < 3; ++i) {
                    outputStream = Connector.openOutputStream((String)("scratchpad:///0;pos=" + n3 + ",length=" + 128000));
                    n2 = CpDataDownload.getDataEx(url + "data/data%s.dat", 128000 * i, 128000, true, byArray);
                    if (n2 < 0) {
                        http_error = -1;
                        return;
                    }
                    outputStream.write(byArray, 0, n2);
                    outputStream.flush();
                    outputStream.close();
                    outputStream = null;
                    System.gc();
                    n3 += n2;
                    g.fillRect(60, 111, (i + 1) * 100 / 3, 2);
                    g.unlock(true);
                    g.lock();
                }
                CpCanvas.dat[48] = n3;
                this.GetScenario(1);
                if (http_error != 0) {
                    http_error = -1;
                    return;
                }
                n2 = this.mldAddDL();
                if (n2 < 0) {
                    http_error = -1;
                    return;
                }
                g.fillRect(60, 111, 120, 2);
                g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
                g.fillRect(150, 90, 240, 16);
                g.setColor(Graphics.getColorOfRGB((int)0, (int)255, (int)0));
                CpCanvas.strDraw(this.set_str[4], 150, 105);
                this.Wait(500);
                DataInputStream dataInputStream = null;
                try {
                    dataInputStream = Connector.openDataInputStream((String)"scratchpad:///0;pos=3396,length=1024");
                    for (int i = 0; i < 37; ++i) {
                        CpCanvas.dat[i] = dataInputStream.readInt();
                    }
                    dataInputStream.close();
                    dataInputStream = null;
                    System.gc();
                }
                catch (Exception exception) {
                    http_error = -1;
                    return;
                }
                CpCanvas.dat[49] = 1;
                CpCanvas.writeSP();
                n2 = 0;
            }
            catch (Exception exception) {
                System.out.println("DL e:" + exception);
                http_error = -1;
                return;
            }
            g.lock();
            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
            g.fillRect(0, 76, 240, 16);
            this.Wait(300);
            g.fillRect(0, 90, 240, 16);
            this.Wait(300);
            g.fillRect(0, 90, 240, 40);
            this.Wait(300);
        } else {
            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
            g.fillRect(0, 76, 240, 16);
            this.Wait(300);
        }
        g.setColor(Graphics.getColorOfRGB((int)170, (int)170, (int)170));
        CpCanvas.strDraw(this.set_str[6], 5, 90);
        this.Wait(300);
        for (n = 0; n < 4; ++n) {
            g.setColor(Graphics.getColorOfRGB((int)170, (int)170, (int)170));
            CpCanvas.strDraw(this.set_str[7 + n], 15, 105 + n * 15);
            g.fillRect(93, 97 + n * 15, 2, 4);
            g.fillRect(195, 97 + n * 15, 2, 4);
            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
            g.fillRect(94, 98 + n * 15, 102, 2);
            g.setColor(Graphics.getColorOfRGB((int)80, (int)80, (int)80));
            g.fillRect(95, 98 + n * 15, 100, 2);
            if (n >= 3) continue;
            this.Wait(150);
        }
        this.waku();
        g.unlock(true);
        g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
        this.ImgSet();
        System.gc();
    }

    public int GetScenario(int n) {
        OutputStream outputStream = null;
        byte[] byArray = new byte[20480];
        http_error = 0;
        try {
            int n2;
            int n3 = CpCanvas.dataGet("resource:///data/scenario/" + n + "/m.dat", byArray);
            if (n == 1) {
                outputStream = Connector.openOutputStream((String)("scratchpad:///0;pos=" + dat[48]));
                outputStream.write(byArray, 0, n3);
                outputStream.flush();
                outputStream.close();
                outputStream = null;
                System.gc();
            } else {
                this.QGard(0);
                outputStream = Connector.openOutputStream((String)("scratchpad:///0;pos=" + dat[48]));
                outputStream.write(byArray, 0, 836);
                outputStream.flush();
                outputStream.close();
                outputStream = null;
                System.gc();
                for (n2 = 0; n2 < 69; ++n2) {
                    outputStream = Connector.openOutputStream((String)("scratchpad:///0;pos=" + (dat[48] + 836 + n2 * 48 + 32)));
                    outputStream.write(byArray, 836 + n2 * 12, 12);
                    outputStream.flush();
                    outputStream.close();
                    outputStream = null;
                    System.gc();
                }
                for (n2 = 0; n2 < 4; ++n2) {
                    byte by = byArray[1664 + n2];
                    if (by < 100) {
                        CpCanvas.item_flg[by][3] = 1;
                    }
                    if (n == 7) {
                        CpCanvas.item_flg[9][3] = 1;
                    }
                    if (((by = byArray[1668 + n2]) & 0x7F) >= 100) continue;
                    CpCanvas.tobi_flg[by & 0x7F][by >> 7] = 0;
                }
                for (n2 = 0; n2 < 69; ++n2) {
                    CpCanvas.chara_flg[n2][0] = byArray[1675 + n2 * 4];
                    CpCanvas.chara_flg[n2][1] = byArray[1674 + n2 * 4];
                    CpCanvas.chara_flg[n2][2] = byArray[1673 + n2 * 4];
                }
                this.QGard(1);
            }
            n3 = CpCanvas.dataGet("resource:///data/scenario/" + n + "/e.jar", byArray);
            if (n3 < 0) {
                http_error = 1;
                return 1;
            }
            outputStream = Connector.openOutputStream((String)("scratchpad:///0;pos=" + (dat[48] + 8520)));
            CpCanvas.dat[42] = n3;
            outputStream.write(byArray, 0, n3);
            outputStream.flush();
            outputStream.close();
            outputStream = null;
            System.gc();
            n3 = CpCanvas.dataGet("resource:///data/scenario/" + n + "/s.dat", byArray);
            if (n3 < 0) {
                http_error = 1;
                return 1;
            }
            outputStream = Connector.openOutputStream((String)("scratchpad:///0;pos=" + (dat[48] + 13640)));
            for (n2 = 0; n2 < 5; ++n2) {
                CpCanvas.dat[43 + n2] = (byArray[n2 * 4 + 0] & 0xFF) << 24 | (byArray[n2 * 4 + 1] & 0xFF) << 16 | (byArray[n2 * 4 + 2] & 0xFF) << 8 | byArray[n2 * 4 + 3] & 0xFF;
            }
            outputStream.write(byArray, 20, n3 - 20);
            outputStream.flush();
            outputStream.close();
            outputStream = null;
            System.gc();
            CpCanvas.i_cnt[0] = 0;
            s_hen = 0;
            CpCanvas.writeSP();
        }
        catch (Exception exception) {
            try {
                outputStream.close();
            }
            catch (Exception exception2) {
                // empty catch block
            }
            http_error = 1;
        }
        return http_error;
    }

    public static int dataGet(String string, byte[] byArray) {
        InputStream inputStream = null;
        int n = 0;
        try {
            inputStream = Connector.openInputStream((String)string);
            n = inputStream.read(byArray);
        }
        catch (Exception exception) {
            System.out.println(string + "   e:" + exception);
        }
        return n;
    }

    public static InputStream dataGetRes(int n) {
        InputStream inputStream = null;
        String[] stringArray = new String[]{"resource:///data/new/tab/se00.dat", "resource:///data/new/tab/se01.dat", "resource:///data/new/tab/se02.dat"};
        if (n >= stringArray.length) {
            return null;
        }
        try {
            inputStream = Connector.openInputStream((String)stringArray[n]);
        }
        catch (Exception exception) {
            System.out.println(n + " dataGetRes e:" + exception);
        }
        return inputStream;
    }

    public void QDawn(int n, int n2) {
        OutputStream outputStream = null;
        byte[] byArray = new byte[3072];
        boolean bl = false;
        if (n2 <= 0) {
            return;
        }
        http_error = 0;
        try {
            if (n == 0) {
                int n3;
                byte by;
                int n4;
                int n5 = CpCanvas.dataGet("resource:///data/quest/" + n2 + "/m.dat", byArray);
                if (n5 < 0) {
                    http_error = 1;
                    return;
                }
                for (n4 = 0; n4 < 8; ++n4) {
                    by = byArray[n4 * 8 + 3];
                    n3 = byArray[n4 * 8 + 2];
                    if (by >= 100) continue;
                    CpCanvas.chara_flg[by][3] = n3;
                    outputStream = Connector.openOutputStream((String)("scratchpad:///0;pos=" + (dat[48] + 836 + by * 48 + 44)));
                    outputStream.write(byArray, n4 * 8 + 4, 4);
                    outputStream.flush();
                    outputStream.close();
                    outputStream = null;
                    System.gc();
                }
                for (n4 = 0; n4 < 4; ++n4) {
                    by = byArray[64 + n4 * 12 + 3];
                    n3 = byArray[64 + n4 * 12 + 2];
                    if (by >= 100) continue;
                    CpCanvas.talk_flg[by][2] = n3;
                    CpCanvas.q_data[by * 8 + 0] = byArray[64 + n4 * 12 + 4];
                    CpCanvas.q_data[by * 8 + 1] = byArray[64 + n4 * 12 + 5];
                    CpCanvas.q_data[by * 8 + 2] = byArray[64 + n4 * 12 + 6];
                    CpCanvas.q_data[by * 8 + 3] = byArray[64 + n4 * 12 + 7];
                    CpCanvas.q_data[by * 8 + 4] = byArray[64 + n4 * 12 + 8];
                    CpCanvas.q_data[by * 8 + 5] = byArray[64 + n4 * 12 + 9];
                    CpCanvas.q_data[by * 8 + 6] = byArray[64 + n4 * 12 + 10];
                    CpCanvas.q_data[by * 8 + 7] = byArray[64 + n4 * 12 + 11];
                }
                this.QGard(1);
                n5 = CpCanvas.dataGet("resource:///data/quest/" + n2 + "/e.jar", byArray);
                if (n5 < 0) {
                    this.QClear();
                    http_error = 1;
                    return;
                }
                outputStream = Connector.openOutputStream((String)("scratchpad:///0;pos=" + (dat[48] + 4424)));
                CpCanvas.dat[40] = n5;
                outputStream.write(byArray, 0, n5);
                outputStream.flush();
                outputStream.close();
                outputStream = null;
                System.gc();
                n5 = CpCanvas.dataGet("resource:///data/quest/" + n2 + "/s.jar", byArray);
                if (n5 < 0) {
                    this.QClear();
                    http_error = n2;
                    return;
                }
                outputStream = Connector.openOutputStream((String)("scratchpad:///0;pos=" + (dat[48] + 5448)));
                CpCanvas.dat[41] = n5;
                outputStream.write(byArray, 0, n5);
                outputStream.flush();
                outputStream.close();
                outputStream = null;
                System.gc();
                CpCanvas.i_cnt[1] = 0;
                q_hen = 0;
                CpCanvas.writeSP();
            } else {
                int n6 = CpCanvas.dataGet("resource:///data/quest/" + n2 + "/t.dat", byArray);
                if (n6 < 0) {
                    http_error = 1;
                    return;
                }
                outputStream = Connector.openOutputStream((String)("scratchpad:///0;pos=" + (dat[48] + 34120 + (n - 1) * 390)));
                outputStream.write(byArray, 0, n6);
                outputStream.flush();
                outputStream.close();
                outputStream = null;
                System.gc();
            }
        }
        catch (Exception exception) {
            http_error = 1;
            try {
                outputStream.flush();
                outputStream.close();
                outputStream = null;
                System.gc();
            }
            catch (Exception exception2) {
                // empty catch block
            }
        }
    }

    public void GetRank(int n, int n2) {
        OutputStream outputStream = null;
        byte[] byArray = new byte[240];
        http_error = 1;
        if (n == 0) {
            try {
                int n3 = CpDataDownload.getDataEx(url + "data/rank/" + n2 + ".dat", 0, 0, false, byArray);
                if (n3 < 0) {
                    System.out.println("rank l:" + n3 + " id" + n2);
                    http_error = 1;
                    return;
                }
                outputStream = Connector.openOutputStream((String)("scratchpad:///0;pos=" + (dat[48] + 37120)));
                outputStream.write(byArray, 0, n3);
                outputStream.flush();
                outputStream.close();
                outputStream = null;
                System.gc();
                CpCanvas.writeSP();
                http_error = 0;
            }
            catch (Exception exception) {
                try {
                    outputStream.close();
                }
                catch (Exception exception2) {
                    // empty catch block
                }
                System.out.println("rank e" + exception);
                http_error = 1;
                return;
            }
        }
        try {
            InputStream inputStream = Connector.openInputStream((String)("scratchpad:///0;pos=" + (dat[48] + 37120)));
            inputStream.read(byArray);
            for (int i = 0; i < 10; ++i) {
                for (int j = 0; j < 3; ++j) {
                    int n4 = (i * 3 + j) * 4;
                    CpCanvas.r_ene[i][j] = (byArray[n4] & 0xFF) << 24 | (byArray[n4 + 1] & 0xFF) << 16 | (byArray[n4 + 2] & 0xFF) << 8 | byArray[n4 + 3] & 0xFF;
                    CpCanvas.r_map[i][j] = (byArray[n4 += 120] & 0xFF) << 24 | (byArray[n4 + 1] & 0xFF) << 16 | (byArray[n4 + 2] & 0xFF) << 8 | byArray[n4 + 3] & 0xFF;
                }
            }
            inputStream.close();
            inputStream = null;
            System.gc();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void QClear() {
        OutputStream outputStream = null;
        for (int i = 0; i < 69; ++i) {
            CpCanvas.chara_flg[i][3] = 0;
        }
        byte[] byArray = new byte[3312];
        try {
            InputStream inputStream = CpCanvas.GetData(3);
            inputStream.read(byArray);
            for (int i = 0; i < 69; ++i) {
                byArray[44 + i * 48] = 0;
                byArray[45 + i * 48] = 0;
                byArray[46 + i * 48] = 0;
                byArray[47 + i * 48] = 0;
            }
            inputStream.close();
            inputStream = null;
            System.gc();
            outputStream = Connector.openOutputStream((String)("scratchpad:///0;pos=" + (dat[48] + 836)));
            outputStream.write(byArray, 0, 3312);
            outputStream.flush();
            outputStream.close();
            outputStream = null;
            System.gc();
        }
        catch (Exception exception) {
            // empty catch block
        }
        for (int i = 0; i < 20; ++i) {
            CpCanvas.talk_flg[i][2] = 0;
            CpCanvas.q_data[i * 8 + 0] = 0;
            CpCanvas.q_data[i * 8 + 1] = 0;
            CpCanvas.q_data[i * 8 + 2] = 0;
            CpCanvas.q_data[i * 8 + 3] = 0;
            CpCanvas.q_data[i * 8 + 4] = 31;
            CpCanvas.q_data[i * 8 + 5] = 31;
            CpCanvas.q_data[i * 8 + 6] = 31;
            CpCanvas.q_data[i * 8 + 7] = 31;
        }
        CpCanvas.i_cnt[1] = 0;
        q_hen = 0;
        this.QGard(1);
    }

    public void GetQTit() {
        InputStream inputStream = null;
        try {
            inputStream = Connector.openInputStream((String)("scratchpad:///0;pos=" + (dat[48] + 34120)));
            for (int i = 0; i < q_get; ++i) {
                int n;
                byte[] byArray = new byte[30];
                inputStream.read(byArray);
                for (n = 0; n < 30 && byArray[n] != 0; ++n) {
                }
                byte[] byArray2 = new byte[n];
                for (int j = 0; j < n; ++j) {
                    byArray2[j] = byArray[j];
                }
                CpCanvas.q_str[i] = new String(byArray2);
                inputStream.skip(270L);
            }
            inputStream.close();
            inputStream = null;
            System.gc();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static InputStream GetQstr(int n) {
        InputStream inputStream = null;
        try {
            inputStream = Connector.openInputStream((String)("scratchpad:///0;pos=" + (dat[48] + 34120 + n * 90 + (n / 3 + 1) * 30)));
        }
        catch (Exception exception) {
            // empty catch block
        }
        return inputStream;
    }

    public static InputStream GetData(int n) {
        int n2;
        InputStream inputStream = null;
        JarInflater jarInflater = null;
        int n3 = dat[48];
        for (n2 = 0; n2 < n; ++n2) {
            n3 += s_pos[n2];
            if (n2 == 7) break;
        }
        try {
            if (n < 5) {
                inputStream = Connector.openInputStream((String)("scratchpad:///0;pos=" + n3 + ",length=" + s_pos[n]));
            } else {
                if (n < 8) {
                    inputStream = Connector.openInputStream((String)("scratchpad:///0;pos=" + n3 + ",length=" + dat[35 + n]));
                } else {
                    for (n2 = 0; n2 < n - 8; ++n2) {
                        n3 += dat[43 + n2];
                    }
                    inputStream = Connector.openInputStream((String)("scratchpad:///0;pos=" + n3 + ",length=" + dat[35 + n]));
                }
                jarInflater = new JarInflater(inputStream);
                System.gc();
                inputStream.close();
                inputStream = null;
                System.gc();
                inputStream = jarInflater.getInputStream("data.dat");
                jarInflater.close();
                jarInflater = null;
                System.gc();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return inputStream;
    }

    public void QGard(int n) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        byte[] byArray = new byte[4];
        try {
            if (n == 0) {
                inputStream = CpCanvas.GetData(0);
                inputStream.skip(12L);
                for (int i = 0; i < 20; ++i) {
                    inputStream.read(byArray);
                    CpCanvas.q_data[i * 8 + 0] = byArray[0];
                    CpCanvas.q_data[i * 8 + 1] = byArray[1];
                    CpCanvas.q_data[i * 8 + 2] = byArray[2];
                    CpCanvas.q_data[i * 8 + 3] = byArray[3];
                    inputStream.skip(12L);
                    inputStream.read(byArray);
                    CpCanvas.q_data[i * 8 + 4] = byArray[0];
                    CpCanvas.q_data[i * 8 + 5] = byArray[1];
                    CpCanvas.q_data[i * 8 + 6] = byArray[2];
                    CpCanvas.q_data[i * 8 + 7] = byArray[3];
                    inputStream.skip(16L);
                }
                inputStream.close();
                inputStream = null;
                System.gc();
            } else {
                for (int i = 0; i < 20; ++i) {
                    outputStream = Connector.openOutputStream((String)("scratchpad:///0;pos=" + (dat[48] + i * 36 + 12)));
                    outputStream.write(q_data, i * 8, 4);
                    outputStream.flush();
                    outputStream.close();
                    outputStream = null;
                    System.gc();
                    outputStream = Connector.openOutputStream((String)("scratchpad:///0;pos=" + (dat[48] + i * 36 + 28)));
                    outputStream.write(q_data, i * 8 + 4, 4);
                    outputStream.flush();
                    outputStream.close();
                    outputStream = null;
                    System.gc();
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void DataSave(int[] nArray, int n) {
        http_error = 255;
        HttpConnection httpConnection = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        byte[] byArray = new byte[1748];
        for (int i = 0; i < 1748; i += 4) {
            byArray[i] = (byte)(nArray[i >> 2] >> 24 & 0xFF);
            byArray[i + 1] = (byte)(nArray[i >> 2] >> 16 & 0xFF);
            byArray[i + 2] = (byte)(nArray[i >> 2] >> 8 & 0xFF);
            byArray[i + 3] = (byte)(nArray[i >> 2] & 0xFF);
        }
        try {
            String string = "http://game.capcom.jp/i/exe/sreg/iexe_score.php?uid=NULLGWDOCOMO&ty=save";
            int n2 = nArray.length * 4;
            string = DomeUrl + dev + "party/sreg/isr.php?uid=NULLGWDOCOMO&k=" + AppID + "&v0=" + Ver + "&ty=save&b0=" + n2;
            if (n == 2) {
                string = string + "&re=1";
            }
            httpConnection = (HttpConnection)Connector.open((String)string, (int)3, (boolean)true);
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "application/octet-stream");
            outputStream = httpConnection.openOutputStream();
            outputStream.write(byArray);
            outputStream.close();
            outputStream = null;
            System.gc();
            httpConnection.connect();
            String string2 = httpConnection.getHeaderField("X-CAPCOM-STATUS");
            if (string2 == null) {
                http_error = 200;
            } else if (string2.compareTo("NG") == 0) {
                http_error = 100;
            } else if (string2.compareTo("MT") == 0) {
                http_error = 150;
            } else if (string2.compareTo("OK") == 0) {
                inputStream = httpConnection.openInputStream();
                inputStream.read(byArray, 0, 2);
                http_error = byArray[0] & 0xFF;
                zan = byArray[1] & 0xFF;
                inputStream.close();
                inputStream = null;
            } else {
                http_error = 255;
            }
            httpConnection.close();
        }
        catch (Exception exception) {
            http_error = 255;
            try {
                httpConnection.close();
                outputStream.close();
                inputStream.close();
            }
            catch (Exception exception2) {
                // empty catch block
            }
        }
    }

    public void imgAddSet() {
        try {
            for (int i = 0; i < image_add.length; ++i) {
                MediaImage mediaImage = MediaManager.getImage((String)("resource:///data/new/img/" + i + ".gif"));
                mediaImage.use();
                CpCanvas.image_add[i] = mediaImage.getImage();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void imgAddDraw(int n, int n2, int n3) {
        if (n >= image_add.length) {
            return;
        }
        g.drawImage(image_add[n], n2, n3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void Audio(int n, int n2) {
        if (n2 < 0) {
            return;
        }
        System.gc();
        if (n == 0) {
            int n3;
            for (n3 = 0; n3 < 16; ++n3) {
                audio[n3].stop();
            }
            for (n3 = 0; n3 < 30; ++n3) {
                m_audio[n3].stop();
            }
            now_bgm = -1;
            return;
        }
        if (n != 1) return;
        if (n2 < 11) {
            now_bgm = n2;
            for (int i = 0; i < 11; ++i) {
                m_audio[i].stop();
            }
        } else {
            for (int i = 11; i < 16; ++i) {
                audio[i].stop();
            }
        }
        while (true) {
            try {
                if (n2 < 11) {
                    m_audio[n2].setAttribute(4, (3 - audio_flg) * 100 / 3);
                    m_audio[n2].play();
                    return;
                }
                m_audio[n2 += 12].setAttribute(4, (3 - audio_flg) * 100 / 3);
                m_audio[n2].play();
                return;
            }
            catch (UIException uIException) {
                try {
                    Thread.sleep(10L);
                }
                catch (Exception exception) {
                    return;
                }
            }
        }
    }

    public void sePlay() {
        int n;
        int n2 = port_suu - 1;
        if (n2 < 1) {
            n2 = 1;
        }
        int[] nArray = new int[n2];
        for (n = 0; n < port_suu - 1; ++n) {
            if ((now_se_cnt[n] <= 2 || m_audio_se[n + 1].getCurrentTime() != 0) && (now_se_flg[n] != 99 || now_se_cnt[n] <= 0 || m_audio[now_se[n]].getCurrentTime() != 0)) continue;
            CpCanvas.now_se[n] = 0;
            CpCanvas.now_se_cnt[n] = 0;
            CpCanvas.now_se_flg[n] = 0;
        }
        for (n = 0; n < port_suu - 1; ++n) {
            if (se_set[n] != 0) {
                try {
                    int n3;
                    int n4 = 0;
                    for (n3 = 0; n3 < port_suu - 1; ++n3) {
                        if (now_se[n3] != 0) continue;
                        n4 = n3 + 1;
                        break;
                    }
                    if (n4 == 0) {
                        int n5;
                        int[] nArray2 = new int[port_suu - 1];
                        int n6 = 0;
                        for (n5 = 0; n5 < port_suu - 1; ++n5) {
                            if (now_se_flg[n5] > se_flg[n]) continue;
                            nArray2[n6] = n5;
                            ++n6;
                        }
                        for (n5 = 0; n5 < n6; ++n5) {
                            if (nArray[nArray2[n5]] != 0) continue;
                            n4 = nArray2[n5] + 1;
                            break;
                        }
                    }
                    if (n4 == 0) break;
                    try {
                        m_audio_se[n4].stop();
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    n3 = 2;
                    do {
                        try {
                            Thread.yield();
                            try {
                                CpCanvas.m_audio_se[n4] = AudioPresenter.getAudioPresenter((int)n4);
                                m_audio_se[n4].setSound(this.se[se_set[n]]);
                                m_audio_se[n4].setAttribute(4, (3 - audio_flg) * 100 / 3);
                                nArray[n4 - 1] = se_set[n];
                            }
                            catch (Exception exception) {
                                System.out.println("e:" + exception);
                            }
                            m_audio_se[n4].play();
                            n3 = 0;
                        }
                        catch (Exception exception) {
                            --n3;
                        }
                    } while (n3 != 0);
                    CpCanvas.now_se[n4 - 1] = se_set[n];
                    CpCanvas.now_se_flg[n4 - 1] = se_flg[n];
                    CpCanvas.now_se_cnt[n4 - 1] = 1;
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            CpCanvas.se_set[n] = 0;
        }
        for (n = 0; n < port_suu - 1; ++n) {
            if (now_se_cnt[n] <= 0) continue;
            int n7 = n;
            now_se_cnt[n7] = now_se_cnt[n7] + 1;
        }
    }

    public void seDraw() {
        g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)0));
        for (int i = 0; i < port_suu - 1; ++i) {
            CpCanvas.strDraw(i + ": se:" + now_se[i] + " p:" + now_se_flg[i] + " cnt:" + now_se_cnt[i] + " au:" + m_audio_se[i + 1].getCurrentTime() + " \\ set:" + se_set[i], 0, 205 + i * 15);
        }
    }

    public static void seSet(int n, int n2) {
        if (3 - audio_flg == 0) {
            return;
        }
        if (n >= 0) {
            n += 11;
            for (int i = 0; i < port_suu - 1; ++i) {
                if (se_set[i] != 0) continue;
                boolean bl = false;
                for (int j = 0; j < port_suu - 1; ++j) {
                    if (se_set[j] != n) continue;
                    bl = true;
                }
                if (bl) break;
                CpCanvas.se_set[i] = n;
                CpCanvas.se_flg[i] = n2;
                break;
            }
        }
    }

    public void syokai() {
        while (true) {
            g.lock();
            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
            g.fillRect(0, 0, 240, 240);
            if (key == 131072) {
                this.m_syokai_flg ^= 1;
                key = 0;
            }
            if (key == 524288) {
                this.m_syokai_flg ^= 1;
                key = 0;
            }
            g.setColor(Graphics.getColorOfRGB((int)255, (int)255, (int)255));
            CpCanvas.strDraw("\u521d\u56de\u30c7\u30fc\u30bf\u306e\u66f4\u65b0\u3092\u884c\u3044\u307e\u3059\u304b\uff1f", 50, 100);
            CpCanvas.strDraw("\u306f\u3044", 50, 120);
            CpCanvas.strDraw("\u3044\u3044\u3048", 50, 135);
            CpCanvas.strDraw(">>", 35, 120 + this.m_syokai_flg * 15);
            if (key == 0x100000) {
                if (this.m_syokai_flg == 0) {
                    CpCanvas.dat[49] = 0;
                }
                break;
            }
            g.unlock(true);
        }
        key = 0;
    }

    public int mldAddDL() {
        int n = 128000;
        byte[] byArray = new byte[n];
        String string = IApplication.getCurrentApp().getSourceURL() + "data/mld/mld%s.jar";
        try {
            CpCanvas.sys_dat[0] = 420624;
            int n2 = CpDataDownload.getDataEx(string, 0, n, true, byArray);
            if (n2 < 0) {
                return -1;
            }
            CpCanvas.sys_dat[1] = n2;
            CpCanvas.spSave(byArray, sys_dat[0], n2);
        }
        catch (Exception exception) {
            System.out.println("!!! mldAddDL e:" + exception);
            return -1;
        }
        return 0;
    }

    public void mldAddSet() {
        InputStream inputStream = null;
        byte[] byArray = new byte[4];
        int[] nArray = new int[30];
        int n = -1;
        try {
            int n2;
            ++n;
            inputStream = CpCanvas.dataMldGet();
            ++n;
            inputStream.read(byArray);
            for (n2 = 0; n2 < 30; ++n2) {
                inputStream.read(byArray);
                nArray[n2] = CpCanvas.intChange(byArray, 0);
            }
            port_suu = 0;
            for (n2 = 0; n2 < 10; ++n2) {
                try {
                    CpCanvas.m_audio[0] = AudioPresenter.getAudioPresenter((int)n2);
                    ++port_suu;
                    continue;
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            se_set = new int[port_suu - 1];
            se_flg = new int[port_suu - 1];
            now_se = new int[port_suu - 1];
            now_se_flg = new int[port_suu - 1];
            now_se_cnt = new int[port_suu - 1];
            for (n2 = 0; n2 < port_suu - 1; ++n2) {
                CpCanvas.now_se[n2] = 0;
            }
            for (n2 = 0; n2 < 30; ++n2) {
                n = n2 * 100;
                byte[] byArray2 = new byte[nArray[n2]];
                inputStream.read(byArray2);
                System.gc();
                ++n;
                CpCanvas.m_audio[n2] = n2 < 11 ? AudioPresenter.getAudioPresenter((int)0) : AudioPresenter.getAudioPresenter((int)1);
                ++n;
                this.se[n2] = MediaManager.getSound((byte[])byArray2);
                ++n;
                try {
                    this.se[n2].use();
                }
                catch (Exception exception) {
                    // empty catch block
                }
                ++n;
                m_audio[n2].setSound(this.se[n2]);
                ++n;
                System.gc();
            }
            for (n2 = 0; n2 < 4; ++n2) {
                CpCanvas.m_audio_se[n2] = AudioPresenter.getAudioPresenter((int)1);
                m_audio_se[n2].setSound(this.se[11]);
                System.gc();
            }
            inputStream.close();
            inputStream = null;
            System.gc();
        }
        catch (Exception exception) {
            System.out.println("mld e:" + exception);
            CpCanvas.dialogDraw("eee", n + "  mld e:" + exception);
        }
    }

    public void kidou() {
        int n = 255;
        CpCanvas.writeSP();
        int n2 = 0;
        while (sys_dat[100] == 0) {
            ++n2;
            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
            g.fillRect(70, 76, 240, 20);
            g.fillRect(0, 90, 240, 90);
            g.setColor(Graphics.getColorOfRGB((int)170, (int)170, (int)170));
            CpCanvas.strDraw("\u8cfc\u5165\u8a8d\u8a3c\uff1a", 5, 90);
            CpCanvas.strDraw(this.set_str[3], 70, 90);
            this.Wait(200);
            if (n2 < 10) {
                n = this.CGI(4, 0);
            }
            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
            g.fillRect(70, 76, 240, 20);
            g.setColor(Graphics.getColorOfRGB((int)255, (int)0, (int)0));
            CpCanvas.strDraw(this.set_str[11], 70, 90);
            g.setColor(Graphics.getColorOfRGB((int)170, (int)170, (int)170));
            key = 0;
            if (n == 1) {
                CpCanvas.sys_dat[100] = n;
                CpCanvas.writeSP();
                g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
                g.fillRect(70, 76, 240, 20);
                g.setColor(Graphics.getColorOfRGB((int)0, (int)255, (int)0));
                CpCanvas.strDraw(this.set_str[4], 70, 90);
                g.setColor(Graphics.getColorOfRGB((int)170, (int)170, (int)170));
                CpCanvas.strDraw("\u88fd\u54c1\u3092\u3054\u8cfc\u5165\u3044\u305f\u3060\u304d\u307e\u3057\u3066\u3001", (240 - f.stringWidth(this.set_str[15])) / 2, 120);
                CpCanvas.strDraw("\u3042\u308a\u304c\u3068\u3046\u3054\u3056\u3044\u307e\u3059\u3002", (240 - f.stringWidth(this.set_str[15])) / 2, 135);
                CpCanvas.strDraw("\u30a2\u30d7\u30ea\u3092\u8d77\u52d5\u3057\u307e\u3059\u3002", (240 - f.stringWidth(this.set_str[15])) / 2, 155);
                this.Wait(100);
                while (key == 0) {
                }
            } else {
                String string;
                if (n == 110) {
                    CpCanvas.strDraw("\u3053\u306e\u30a2\u30d7\u30ea\u3092\u3054\u5229\u7528\u306b\u306a\u308b\u306b\u306f\u3001", (240 - f.stringWidth(this.set_str[15])) / 2, 115);
                    CpCanvas.strDraw("\u8cfc\u5165\u3059\u308b\u5fc5\u8981\u304c\u3042\u308a\u307e\u3059\u3002", (240 - f.stringWidth(this.set_str[15])) / 2, 130);
                    CpCanvas.strDraw("\u8cfc\u5165\u30b5\u30a4\u30c8\u3078\u63a5\u7d9a\u3057\u307e\u3059\u304b\uff1f", (240 - f.stringWidth(this.set_str[15])) / 2, 145);
                    yes_no_flg = 0;
                    key = 0;
                    while (true) {
                        g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
                        g.fillRect(0, 150, 240, 30);
                        g.setColor(Graphics.getColorOfRGB((int)170, (int)170, (int)170));
                        CpCanvas.strDraw("\u30b5\u30a4\u30c8\u3078\u63a5\u7d9a\u3059\u308b", (240 - f.stringWidth(this.set_str[15])) / 2, 165);
                        CpCanvas.strDraw("\u30a2\u30d7\u30ea\u3092\u7d42\u4e86\u3059\u308b", (240 - f.stringWidth(this.set_str[15])) / 2, 180);
                        CpCanvas.strDraw(">>", 5, 165 + yes_no_flg * 15);
                        this.Wait(100);
                        if (key == 131072) {
                            yes_no_flg = 0;
                            key = 0;
                        } else if (key == 524288) {
                            yes_no_flg = 1;
                            key = 0;
                        }
                        if (key != 0x100000) continue;
                        if (yes_no_flg == 0) {
                            string = DomeUrl + "/i/party/?uid=NULLGWDOCOMO&appid=" + AppID;
                            IApplication.getCurrentApp().launch(1, new String[]{string});
                        } else {
                            IApplication.getCurrentApp().terminate();
                        }
                        key = 0;
                    }
                }
                if (n == 150) {
                    CpCanvas.strDraw("\u53ea\u4eca\u30b5\u30fc\u30d0\u30fc\u30e1\u30f3\u30c6\u30ca\u30f3\u30b9\u4e2d\u3067\u3059\u3002", (240 - f.stringWidth(this.set_str[15])) / 2, 120);
                    CpCanvas.strDraw("\u3057\u3070\u3089\u304f\u305f\u3063\u3066\u304b\u3089\u518d\u5ea6\u304a\u8a66\u3057\u4e0b\u3055\u3044\u3002", (240 - f.stringWidth(this.set_str[15])) / 2, 135);
                    CpCanvas.strDraw("\u30a2\u30d7\u30ea\u3092\u7d42\u4e86\u3057\u307e\u3059\u3002", (240 - f.stringWidth(this.set_str[15])) / 2, 155);
                    this.Wait(100);
                    while (key == 0) {
                    }
                    IApplication.getCurrentApp().terminate();
                } else if (n == 120) {
                    CpCanvas.strDraw("\u30a2\u30d7\u30ea\u30d0\u30fc\u30b8\u30e7\u30f3\u30a8\u30e9\u30fc\u3067\u3059\u3002", (240 - f.stringWidth(this.set_str[15])) / 2, 115);
                    CpCanvas.strDraw("\u30b5\u30a4\u30c8\u306b\u3066\u5185\u5bb9\u306e\u3054\u78ba\u8a8d\u3092", (240 - f.stringWidth(this.set_str[15])) / 2, 130);
                    CpCanvas.strDraw("\u304a\u9858\u3044\u3057\u307e\u3059\u3002", (240 - f.stringWidth(this.set_str[15])) / 2, 145);
                    yes_no_flg = 0;
                    key = 0;
                    while (key != 0x100000) {
                        g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
                        g.fillRect(0, 150, 240, 30);
                        g.setColor(Graphics.getColorOfRGB((int)170, (int)170, (int)170));
                        CpCanvas.strDraw("\u30b5\u30a4\u30c8\u3078\u63a5\u7d9a\u3059\u308b", (240 - f.stringWidth(this.set_str[15])) / 2, 165);
                        CpCanvas.strDraw("\u30a2\u30d7\u30ea\u3092\u7d42\u4e86\u3059\u308b", (240 - f.stringWidth(this.set_str[15])) / 2, 180);
                        CpCanvas.strDraw(">>", 5, 165 + yes_no_flg * 15);
                        this.Wait(100);
                        if (key == 131072) {
                            yes_no_flg = 0;
                            key = 0;
                            continue;
                        }
                        if (key != 524288) continue;
                        yes_no_flg = 1;
                        key = 0;
                    }
                    if (yes_no_flg == 0) {
                        string = DomeUrl + "/i/party/?uid=NULLGWDOCOMO&appid=" + AppID + "&page=verup";
                        IApplication.getCurrentApp().launch(1, new String[]{string});
                        IApplication.getCurrentApp().terminate();
                    } else {
                        IApplication.getCurrentApp().terminate();
                    }
                } else {
                    CpCanvas.strDraw(this.set_str[15], (240 - f.stringWidth(this.set_str[15])) / 2, 115);
                    CpCanvas.strDraw(this.set_str[16], (240 - f.stringWidth(this.set_str[15])) / 2, 130);
                    CpCanvas.strDraw("(\u30a8\u30e9\u30fc\u30b3\u30fc\u30c9\uff1a" + n + ")", (240 - f.stringWidth("(\u30a8\u30e9\u30fc\u30b3\u30fc\u30c9\uff1a" + n + ")")) / 2, 145);
                    yes_no_flg = 0;
                    key = 0;
                    while (key != 0x100000) {
                        g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
                        g.fillRect(0, 150, 240, 30);
                        g.setColor(Graphics.getColorOfRGB((int)170, (int)170, (int)170));
                        CpCanvas.strDraw("\u30ea\u30c8\u30e9\u30a4\u3059\u308b", (240 - f.stringWidth(this.set_str[15])) / 2, 165);
                        CpCanvas.strDraw("\u30a2\u30d7\u30ea\u3092\u7d42\u4e86\u3059\u308b", (240 - f.stringWidth(this.set_str[15])) / 2, 180);
                        CpCanvas.strDraw(">>", 5, 165 + yes_no_flg * 15);
                        this.Wait(100);
                        if (key == 131072) {
                            yes_no_flg = 0;
                            key = 0;
                            continue;
                        }
                        if (key != 524288) continue;
                        yes_no_flg = 1;
                        key = 0;
                    }
                    if (yes_no_flg != 0) {
                        IApplication.getCurrentApp().terminate();
                    }
                    g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
                    g.fillRect(70, 76, 240, 20);
                }
            }
            if (n != 1) continue;
            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
            g.fillRect(70, 76, 240, 20);
            g.fillRect(0, 90, 240, 80);
            g.setColor(Graphics.getColorOfRGB((int)170, (int)170, (int)170));
            CpCanvas.strDraw("\u8cfc\u5165\u8a8d\u8a3c\uff1a", 5, 90);
            g.setColor(Graphics.getColorOfRGB((int)0, (int)0, (int)0));
            g.fillRect(70, 76, 240, 20);
            g.setColor(Graphics.getColorOfRGB((int)0, (int)255, (int)0));
            CpCanvas.strDraw(this.set_str[4], 70, 90);
            this.Wait(300);
        }
    }

    public static InputStream dataMldGet() {
        InputStream inputStream = null;
        JarInflater jarInflater = null;
        try {
            inputStream = CpCanvas.spLoad(sys_dat[0], sys_dat[1]);
            jarInflater = new JarInflater(inputStream);
            System.gc();
            inputStream.close();
            inputStream = null;
            System.gc();
            inputStream = jarInflater.getInputStream("data.dat");
            jarInflater.close();
            jarInflater = null;
            System.gc();
        }
        catch (Exception exception) {
            System.out.println("mldget e:" + exception);
        }
        return inputStream;
    }

    public static void dialogDraw(String string, String string2) {
        Dialog dialog = new Dialog(2, string);
        dialog.setText(string2);
        dialog.show();
    }

    public static int spSave(byte[] byArray, int n, int n2) {
        if (n2 < 0) {
            return -1;
        }
        try {
            OutputStream outputStream = Connector.openOutputStream((String)("scratchpad:///0;pos=" + n + ",length=" + n2));
            outputStream.write(byArray, 0, n2);
            outputStream.flush();
            outputStream.close();
            outputStream = null;
            System.gc();
        }
        catch (Exception exception) {
            System.out.println("SpSave e:" + exception);
            return -1;
        }
        return n2;
    }

    public static int spSave(int[] nArray, int n, int n2) {
        if (n2 < 0) {
            return -1;
        }
        byte[] byArray = new byte[n2 * 4];
        for (int i = 0; i < n2; ++i) {
            byArray[i * 4 + 0] = (byte)(nArray[i] >> 24 & 0xFF);
            byArray[i * 4 + 1] = (byte)(nArray[i] >> 16 & 0xFF);
            byArray[i * 4 + 2] = (byte)(nArray[i] >> 8 & 0xFF);
            byArray[i * 4 + 3] = (byte)(nArray[i] & 0xFF);
        }
        n2 = CpCanvas.spSave(byArray, n, n2 * 4);
        return n2;
    }

    public static int spLoad(byte[] byArray, int n, int n2) {
        if (n2 < 0) {
            return -1;
        }
        try {
            InputStream inputStream = Connector.openInputStream((String)("scratchpad:///0;pos=" + n + ",length=" + n2));
            inputStream.read(byArray, 0, n2);
            inputStream.close();
            inputStream = null;
            System.gc();
        }
        catch (Exception exception) {
            System.out.println("SpLoad e" + exception + " pos:" + n + " siz:" + n2 + " len:" + byArray.length);
            return -1;
        }
        return n2;
    }

    public static int spLoad(int[] nArray, int n, int n2) {
        if (n2 < 0) {
            return -1;
        }
        byte[] byArray = new byte[n2 * 4];
        int n3 = CpCanvas.spLoad(byArray, n, n2 * 4);
        for (int i = 0; i < n2; ++i) {
            nArray[i] = CpCanvas.intChange(byArray, i * 4);
        }
        if (n3 < 0) {
            n2 = -1;
        }
        return n2;
    }

    public static InputStream spLoad(int n, int n2) {
        InputStream inputStream = null;
        if (n2 < 0) {
            return inputStream;
        }
        try {
            inputStream = Connector.openInputStream((String)("scratchpad:///0;pos=" + n + ",length=" + n2));
        }
        catch (Exception exception) {
            System.out.println("SpLoad e" + exception + " pos:" + n + " siz:" + n2);
            return null;
        }
        return inputStream;
    }

    public static int intChange(byte[] byArray, int n) {
        int n2 = (byArray[n + 0] & 0xFF) << 24 | (byArray[n + 1] & 0xFF) << 16 | (byArray[n + 2] & 0xFF) << 8 | byArray[n + 3] & 0xFF;
        return n2;
    }

    public static void sysSave() {
        CpCanvas.spSave(sys_dat, 409600, sys_dat.length);
    }

    public static void sysLoad() {
        CpCanvas.spLoad(sys_dat, 409600, sys_dat.length);
    }

    public void urlSet() {
        try {
            String string = IApplication.getCurrentApp().getSourceURL();
            String[] stringArray = CpCanvas.splitStr(string, '/');
            DomeUrl = "http://" + stringArray[2];
            String[] stringArray2 = IApplication.getCurrentApp().getArgs();
            Ver = stringArray2[0];
            if (!Ver.equals(this.verLaod(0))) {
                CpCanvas.sys_dat[2] = 0;
                CpCanvas.sys_dat[3] = 0;
                this.verSave(Ver, 1);
                CpCanvas.sysSave();
            }
            this.verSave(Ver, 0);
        }
        catch (Exception exception) {
            System.out.println("urlSet e:" + exception);
        }
    }

    static String[] splitStr(String string, char c) {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        if (string.equals("") || string.charAt(string.length() - 1) != c) {
            string = string + c;
        }
        int n4 = string.indexOf(c);
        while (n4 >= 0) {
            ++n;
            n4 = string.indexOf(c, n4 + 1);
        }
        String[] stringArray = new String[n];
        n = 0;
        n3 = string.indexOf(c);
        while (n3 >= 0) {
            stringArray[n++] = string.substring(n2, n3);
            n2 = n3 + 1;
            System.gc();
            n3 = string.indexOf(c, n2);
        }
        return stringArray;
    }

    public void verSave(String string, int n) {
        int n2 = 410624 + n * 10;
        byte[] byArray = new byte[5];
        byArray = string.getBytes();
        CpCanvas.spSave(byArray, n2, 5);
    }

    public String verLaod(int n) {
        int n2 = 410624 + n * 10;
        byte[] byArray = new byte[5];
        CpCanvas.spLoad(byArray, n2, 5);
        String string = new String(byArray, 0, 5);
        return string;
    }

    public static void strDraw(String string, int n, int n2) {
        g.drawString(string, n, n2 -= f.getDescent());
    }

    public static void strDrawG(String string, int n, int n2) {
        graMap.drawString(string, n, n2 -= f.getDescent());
    }

    public static void strDrawTG(String string, int n, int n2) {
        tmp_graMap.drawString(string, n, n2 -= f.getDescent());
    }

    static {
        ene = new Ene[3];
        oki = new Okimono[6];
        panel = new BtPanel[3][6];
        fol = new Folder[4];
        tip = new Tip[213];
        ata = new Attack[30];
        waza = new Waza[265];
        mail = new Mail[18];
        skill = new Skill[29];
        edit = new Edit();
        imgMap2 = new Image[9];
        graMap2 = new Graphics[9];
        image = new PalettedImage[59];
        pal = new Palette[98];
        audio = new AudioPresenter[16];
        key = 0;
        okey = 0;
        key_cnt = 0;
        tip_list = new int[512];
        skill_list = new int[148];
        dat = new int[75];
        item_flg = new int[72][4];
        tobi_flg = new int[72][2];
        chara_flg = new int[72][4];
        pa_data = new int[34][9];
        teki_ren = new int[2][11];
        bas_lv = 8;
        bt_get = new int[]{2, 100, 1};
        wana_pow = new int[2];
        cas_tip = new int[10];
        fol_tip_no = new int[10];
        set_tip = new int[5];
        sel_code = new int[5];
        cas_ok = new int[10];
        fol_d = new int[]{2, 2, 3, 3, 28, 28, 28, 30, 30, 30, 36, 36, 152, 152, 152, 156, 156, 94, 94, 95, 95, 338, 338, 385, 347, 347, 348, 348, 440, 440};
        pa_tip = new int[5];
        gx = new int[56][1];
        gy = new int[56][1];
        sx = new int[56][1];
        sy = new int[56][1];
        dx = new int[56][1];
        dy = new int[56][1];
        ani = new int[42][1][1];
        a_dx = new int[42][1][1];
        a_dy = new int[42][1][1];
        p_siz = new int[98];
        map_sp = 5;
        wait_data = new int[225];
        rock_mo = new int[132];
        eff_mo = new int[444];
        eff_se = new int[148];
        teki_mo = new int[88];
        soft_id = new int[4];
        map_str = new String[]{"\u79cb\u539f\u30a8\u30ea\u30a21", "\u79cb\u539f\u30a8\u30ea\u30a22", "\u79cb\u539f\u30a8\u30ea\u30a23", "\u30c7\u30f3\u30b5\u30f3\u30a8\u30ea\u30a21", "\u30c7\u30f3\u30b5\u30f3\u30a8\u30ea\u30a22", "\u30c7\u30f3\u30b5\u30f3\u30a8\u30ea\u30a23", "\u5b98\u5e81\u30a8\u30ea\u30a21", "\u5b98\u5e81\u30a8\u30ea\u30a22", "\u30a6\u30e9\u30a4\u30f3\u30bf\u30fc\u30cd\u30c3\u30c81", "\u30a6\u30e9\u30a4\u30f3\u30bf\u30fc\u30cd\u30c3\u30c82", "\u30a6\u30e9\u30a4\u30f3\u30bf\u30fc\u30cd\u30c3\u30c83", "\u30a6\u30e9\u30a4\u30f3\u30bf\u30fc\u30cd\u30c3\u30c84", "\u30a6\u30e9\u30a4\u30f3\u30bf\u30fc\u30cd\u30c3\u30c85", "\u30b7\u30fc\u30af\u30ec\u30c3\u30c8\u30a8\u30ea\u30a21", "\u30b7\u30fc\u30af\u30ec\u30c3\u30c8\u30a8\u30ea\u30a22", "\u71b1\u6597\u306ePC\u306e\u96fb\u8133", "\u30c6\u30ec\u30d3\u306e\u96fb\u8133", "\u51b7\u8535\u5eab\u306e\u96fb\u8133", "\u72ac\u5c0f\u5c4b\u306e\u96fb\u8133", "\u306c\u3044\u3050\u308b\u307f\u306e\u96fb\u8133", "\u9ed2\u677f\u306e\u96fb\u8133", "\u673a\u306e\u96fb\u8133", "\u5148\u751f\u306ePC\u306e\u96fb\u8133", "\u5238\u58f2\u6a5f\u306e\u96fb\u8133", "\u767b\u9332\u30de\u30b7\u30f3\u306e\u96fb\u8133", "\u89b3\u8449\u690d\u7269\u306e\u96fb\u8133", "\u770b\u677f\u306e\u96fb\u8133", "\u4fe1\u53f7\u6a5f\u306e\u96fb\u8133", "\u65b0\u578bPET\u306e\u96fb\u8133", "\u76e3\u8996\u30b7\u30b9\u30c6\u30e0\u306e\u96fb\u8133", "\u5ea7\u5e2d\u306e\u96fb\u8133", "\u81ea\u52d5\u30c9\u30a2\u306e\u96fb\u8133", "\u30e2\u30cb\u30e5\u30e1\u30f3\u30c8\u306e\u96fb\u8133", "\u30d1\u30d1\u306ePC\u306e\u96fb\u8133", "\u64cd\u4f5c\u30d1\u30cd\u30eb\u306e\u96fb\u8133", "\u30a2\u30f3\u30c6\u30ca\u306e\u96fb\u8133", "\u30e1\u30a4\u30eb\u306ePC\u306e\u96fb\u81331", "\u30e1\u30a4\u30eb\u306ePC\u306e\u96fb\u81332", "\u30e1\u30a4\u30eb\u306ePC\u306e\u96fb\u81333", "\u6c34\u9053\u7ba1\u7406\u30b5\u30fc\u30d0\u30fc\u306e\u96fb\u81331", "\u6c34\u9053\u7ba1\u7406\u30b5\u30fc\u30d0\u30fc\u306e\u96fb\u81332", "\u6c34\u9053\u7ba1\u7406\u30b5\u30fc\u30d0\u30fc\u306e\u96fb\u81333", "\u30d0\u30c8\u30eb\u30de\u30b7\u30f3\u306e\u96fb\u81331", "\u30d0\u30c8\u30eb\u30de\u30b7\u30f3\u306e\u96fb\u81332", "\u30d0\u30c8\u30eb\u30de\u30b7\u30f3\u306e\u96fb\u81333", "\u30c6\u30f3\u30c8\u306e\u96fb\u81331", "\u30c6\u30f3\u30c8\u306e\u96fb\u81332", "\u821e\u53f0\u88c5\u7f6e\u306e\u96fb\u81331", "\u821e\u53f0\u88c5\u7f6e\u306e\u96fb\u81332", "\u821e\u53f0\u88c5\u7f6e\u306e\u96fb\u81333", "IPC\u30b5\u30fc\u30d0\u30fc\u306e\u96fb\u81331", "IPC\u30b5\u30fc\u30d0\u30fc\u306e\u96fb\u81332", "IPC\u30b5\u30fc\u30d0\u30fc\u306e\u96fb\u81333", "IPC\u30b5\u30fc\u30d0\u30fc\u306e\u96fb\u81334", "\u30e2\u30d0\u30a4\u30eb\u30a8\u30ea\u30a2\u306e\u96fb\u81331", "\u30e2\u30d0\u30a4\u30eb\u30a8\u30ea\u30a2\u306e\u96fb\u81332", "\u30e2\u30d0\u30a4\u30eb\u30a8\u30ea\u30a2\u306e\u96fb\u81333", "\u30e2\u30d0\u30a4\u30eb\u30a8\u30ea\u30a2\u306e\u96fb\u81334", "\u96fb\u8133\u4e16\u754c\u306e\u7a74\u306e\u96fb\u81331", "\u96fb\u8133\u4e16\u754c\u306e\u7a74\u306e\u96fb\u81332", "\u96fb\u8133\u4e16\u754c\u306e\u7a74\u306e\u96fb\u81333", "\u96fb\u8133\u4e16\u754c\u306e\u7a74\u306e\u96fb\u81334", "\u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u30b5\u30fc\u30d0\u30fc\u306e\u96fb\u81331", "\u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u30b5\u30fc\u30d0\u30fc\u306e\u96fb\u81332", "\u30ad\u30e3\u30c3\u30b7\u30e5\u30b5\u30fc\u30d0\u30fc\u306e\u96fb\u81331", "\u30ad\u30e3\u30c3\u30b7\u30e5\u30b5\u30fc\u30d0\u30fc\u306e\u96fb\u81332", "\u30ad\u30e3\u30c3\u30b7\u30e5\u30b5\u30fc\u30d0\u30fc\u306e\u96fb\u81333", "\u30ad\u30e3\u30c3\u30b7\u30e5\u30b5\u30fc\u30d0\u30fc\u306e\u96fb\u81334", "\u30ad\u30e3\u30c3\u30b7\u30e5\u30b5\u30fc\u30d0\u30fc\u306e\u96fb\u81335"};
        t_str = new String[]{"\u30b2\u30fc\u30e0\u30b9\u30bf\u30fc\u30c8", "\u30aa\u30d7\u30b7\u30e7\u30f3", "\u66f4\u65b0\u30c1\u30a7\u30c3\u30af", "\u8a71\u306b\u66f4\u65b0"};
        o_str = new String[]{"\u30b5\u30a6\u30f3\u30c9\u3000\uff1a\u3000", "\u30bf\u30a4\u30c8\u30eb\u306b\u623b\u308b", "\u30b5\u30fc\u30d0\u30fc\u30c7\u30fc\u30bf\u30bb\u30fc\u30d6", "\u30b5\u30fc\u30d0\u30fc\u30c7\u30fc\u30bf\u30ed\u30fc\u30c9", "\u521d\u671f\u5316\u3057\u3066\u59cb\u3081\u304b\u3089\u30d7\u30ec\u30a4", "< \u5927 >", "< \u4e2d >", "< \u5c0f >", "< OFF >"};
        m_name = new String[]{"\u71b1\u6597\u306e\u90e8\u5c4b", "\u71b1\u6597\u306e\u5bb6", "\u79cb\u539f\u753a", "\u30e1\u30a4\u30eb\u306e\u5bb6", "\u30d2\u30b0\u30ec\u30e4", "\u5b66\u6821\u2212\u6559\u5ba4", "\u5b66\u6821\u2212\u8077\u54e1\u5ba4", "\u30c7\u30f3\u30b5\u30f3\u30bf\u30a6\u30f3", "\u30c7\u30f3\u30b5\u30f3\u30c9\u30fc\u30e0", "\u30d0\u30c8\u30eb\u30b9\u30bf\u30b8\u30a2\u30e0", "\u30c6\u30f3\u30c8\u5185", "\u30b9\u30bf\u30c3\u30d5\u30a8\u30ea\u30a2", "IPC\u2212\u30ed\u30d3\u30fc", "IPC\u2212\u7ba1\u7406\u5ba4", "\u5b98\u5e81\u8857", "\u30d1\u30d1\u306e\u7814\u7a76\u5ba4", "\u30e2\u30d0\u30a4\u30eb\u57fa\u5730\u5c40", "\u65e7\u96fb\u8133\u7814\u7a76\u6240", "\u30b5\u30fc\u30d0\u30fc\u30eb\u30fc\u30e0", "\u30e1\u30c8\u30ed\u30e9\u30a4\u30f3\u99c5"};
        p_name = new String[]{"\u71b1\u6597\u306ePC", "\u30c6\u30ec\u30d3", "\u51b7\u8535\u5eab", "\u72ac\u5c0f\u5c4b", "\u306c\u3044\u3050\u308b\u307f", "\u9ed2\u677f", "\u673a", "\u5148\u751f\u306ePC", "\u5238\u58f2\u6a5f", "\u767b\u9332\u30de\u30b7\u30f3", "\u89b3\u8449\u690d\u7269", "\u770b\u677f", "\u4fe1\u53f7\u6a5f", "\u65b0\u578bPET", "\u76e3\u8996\u30b7\u30b9\u30c6\u30e0", "\u5ea7\u5e2d", "\u81ea\u52d5\u30c9\u30a2", "\u30e2\u30cb\u30e5\u30e1\u30f3\u30c8", "\u30d1\u30d1\u306ePC", "\u64cd\u4f5c\u30d1\u30cd\u30eb", "\u30a2\u30f3\u30c6\u30ca", "\u30e1\u30a4\u30eb\u306ePC", "\u6c34\u9053\u7ba1\u7406\u30b5\u30fc\u30d0\u30fc", "\u30d0\u30c8\u30eb\u30de\u30b7\u30f3", "\u30c6\u30f3\u30c8", "\u821e\u53f0\u88c5\u7f6e", "IPC\u30b5\u30fc\u30d0\u30fc", "\u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u30b5\u30fc\u30d0\u30fc", "\u30ad\u30e3\u30c3\u30b7\u30e5\u30b5\u30fc\u30d0\u30fc", "\u30c1\u30c3\u30d7\u30c8\u30ec\u30fc\u30c0\u30fc", "\u4f9d\u983c\u63b2\u793a\u677f"};
        q_str2 = "\u6b8b\u308a\u30dd\u30a4\u30f3\u30c8\uff1a";
        menu_str = new String[]{"\u30c1\u30c3\u30d7\u30d5\u30a9\u30eb\u30c0", "\u30e9\u30a4\u30d6\u30e9\u30ea", "\u30d5\u30eb\u30a8\u30cd\u30eb\u30ae\u30fc", "\u30ed\u30c3\u30af\u30de\u30f3", "\u30e1\u30fc\u30eb", "\u30bb\u30fc\u30d6", "\u30d5\u30a9\u30eb\u30c0", "\u30ea\u30e5\u30c3\u30af", "\u30b9\u30bf\u30f3\u30c0\u30fc\u30c9\u30c1\u30c3\u30d7", "\u30e1\u30ac\u30af\u30e9\u30b9\u30c1\u30c3\u30d7", "\u30ae\u30ac\u30af\u30e9\u30b9\u30c1\u30c3\u30d7", "\uff30.\uff21\u30e1\u30e2", "\uff29\uff24", "50\u97f3", "\u30b3\u30fc\u30c9", "\u653b\u6483\u529b", "\u5c5e\u6027", "\u679a\u6570", "\u5bb9\u91cf", "\u53d7\u4fe1\u30d5\u30a9\u30eb\u30c0", "\u30bc\u30cb\u30fc", "\u30b9\u30ad\u30eb", "\u30b9\u30ad\u30eb\u30ea\u30b9\u30c8", "\u30a2\u30bf\u30c3\u30af LV", "\u30c1\u30e3\u30fc\u30b8 LV", "HP\u30e1\u30e2\u30ea", "\u30ec\u30ae\u30e5\u30e9\u30fcUP", "\u30b9\u30ad\u30eb\u30b9\u30ed\u30c3\u30c8+3", "\u30c7\u30ea\u30fc\u30c8\u30bf\u30a4\u30e0", "\u30d0\u30b9\u30c6\u30a3\u30f3\u30b0\u30ec\u30d9\u30eb", "\u30d0\u30b0\u306e\u30ab\u30b1\u30e9", "\u500b", "\u3000\u3000\u3000\uff1f\uff1f"};
        soft_str = new String[]{null, "\uff76\uff7d\uff80\uff91", "\uff77\uff6c\uff9d\uff7e\uff99", "\u9003\u3052\u308b", "PET", "P-OUT", "\uff75\uff8c\uff9f\uff7c\uff6e\uff9d", "\uff7f\uff70\uff84", "\u7d42\u4e86"};
        waza_str = new String[]{"\u30a8\u30ea\u30a2\u30b9\u30c1\u30fc\u30eb", "\u30ad\u30e3\u30c3\u30b7\u30e5\u30ed\u30fc\u30c9", "\u30ea\u30d6\u30fc\u30c8"};
        r_str = new String[]{"\u4f4d\uff1a", "1\uff77\uff70\uff1a\u30d5\u30a9\u30eb\u30c0\u3092\u898b\u308b", "\u30e9\u30f3\u30ad\u30f3\u30b0\u306b\u53c2\u52a0\u3059\u308b", "\u30e9\u30f3\u30ad\u30f3\u30b0\u3092\u66f4\u65b0\u3059\u308b", "\u6708\u5ea6\u30e9\u30f3\u30ad\u30f3\u30b0", "\u30d5\u30a9\u30eb\u30c0", "Your Score", "\u30c7\u30ea\u30fc\u30c8\u30bf\u30a4\u30e0", "DOUBLE DELETE", "TRIPLE DELETE", "\u79fb\u52d5\u6b69\u6570", "\u30c0\u30e1\u30fc\u30b8\u56de\u6570", "\u30ea\u30ab\u30d0\u30ea\u30fc\u4f7f\u7528", "\uff28\uff30\u6b8b\u308a\uff05", "\u30c8\u30fc\u30bf\u30eb\u30b9\u30b3\u30a2", "New Record!", "\u56de", "\u6b69", "\uff05", "\u30de\u30a4\u30d5\u30a9\u30eb\u30c0"};
        e_data = new int[136][5];
        e_name = new String[3];
        m_data = new int[457];
        m_ene = new int[16];
        m_warp = new int[4];
        m_item = new int[4][4];
        m_tobi = new int[2][5];
        m_chara = new int[4][6];
        p_pat = new int[69];
        p_col = new int[14];
        ene_set = new int[69][3];
        mes = new byte[3][1];
        tmp_m_no = -1;
        talk_flg = new int[21][4];
        move_ok = new int[20];
        plg_ok = new int[20];
        m_move = new int[5];
        m_ivent = new int[4][5];
        m_plg = new int[4];
        i_chara = new int[3][5];
        r_ivent = new int[17];
        q_flg = new int[2];
        q_list = new int[10];
        sh_syu = new int[175];
        sh_id = new int[175];
        sh_kin = new int[175];
        sh_list = new int[175];
        sh_zai = new int[8][12];
        set_t = new int[10];
        tr_list = new int[283];
        r_jun = new String[10];
        r_sco = new int[10];
        r_name = new String[10];
        r_id = new int[100];
        sco_cnt = new int[7];
        sco = new int[7];
        r_tip = new int[30];
        r_map = new int[10][3];
        r_ene = new int[10][3];
        i_id = new int[4];
        talk_ch = new int[3];
        navi_flg = new int[12];
        i_set = new int[4];
        i_x = new int[5];
        i_y = new int[5];
        i_data = new int[256];
        i_cnt = new int[4];
        i_siz = new int[4][256];
        face_x = new int[][]{{46, 0}, {46, 154}, {39, 100, 161}, {20, 73, 127, 182}};
        face_dx = new int[]{0, 0, 61, 54};
        sort = -1;
        TIP_MAX = new int[]{123, 52, 4, 28, 181};
        ata_lv = 1;
        cha_lv = 1;
        get_tip2 = new int[4];
        get_list = new int[224];
        sort_list = new int[510];
        sort_skill = new int[145];
        q_data = new byte[160];
        q_str = new String[10];
        s_pos = new int[]{756, 40, 40, 3312, 276, 1024, 3072, 5120};
        skill_kouka = new int[29];
        sort_flg = -1;
        m_max = 5;
        g_max = 1;
        d_ene_syu = 126;
        fol_data = new int[30];
        list_data = new int[511];
        p_no = 0;
        p_no2 = 0;
        hyo = 10;
        ch_no = 0;
        g_no = 0;
        awa = 0;
        ani_pt = 0;
        ani_cnt = 0;
        flp = 0;
        img_siz3 = new int[22];
        q_txt = new String[100];
        image_add = new Image[10];
        m_audio = new AudioPresenter[30];
        m_audio_se = new AudioPresenter[4];
        sys_dat = new int[255];
        AppID = "4420";
    }
}

