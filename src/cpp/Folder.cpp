#include "Folder.h"
#include "CpCanvas_fwd.h"
#include "BtPanel.h"
#include "Tip.h"

void Folder::init() {
    for (int n = 0; n < 30; ++n) {
        used[n] = 0;
    }
    for (int n = 0; n < 10; ++n) {
        CpCanvas::cas_tip[n] = -1;
    }
    tip_zan = 30;
}

int Folder::FolSet(int n, int n2) {
    int n3 = tip_id[n];
    tip_id[n] = n2;
    int n4 = CpCanvas::tip_list[n2] >> 8 & 0xFF;
    CpCanvas::AddLib(n4);
    int n5 = FolCh();
    if (n5 != 0) {
        tip_id[n] = n3;
    }
    return n5;
}

void Folder::FolNon(int n) {
    tip_id[n] = 0;
}

int Folder::FolCh() {
    int n;
    m_cnt = 0;
    g_cnt = 0;
    for (n = 0; n < 200; ++n) {
        tip_cnt[n] = 0;
    }
    for (n = 0; n < 30; ++n) {
        int n2;
        int n3 = n2 = CpCanvas::tip_list[tip_id[n]] >> 8 & 0xFF;
        tip_cnt[n3] = tip_cnt[n3] + 1;
        if (n2 > 176) {
            ++g_cnt;
            if (tip_cnt[n2] > 1) return 3;
            if (g_cnt > CpCanvas::g_max) return 5;
        } else if (n2 > 124) {
            ++m_cnt;
            if (tip_cnt[n2] > 1) return 2;
            if (m_cnt > CpCanvas::m_max) return 4;
        } else if (n2 != 0 && tip_cnt[n2] > 4) {
            return 1;
        }
    }
    return 0;
}

int Folder::Sort(int n, int n2) {
    int n3, n4, n5, n6, n7;
    int nArray[30]  = {};
    int nArray2[30] = {};
    int n8 = 0;
    int n9 = tip_id[regu_id];

    for (n7 = 0; n7 < 30; ++n7) {
        if (tip_id[n7] == 0) continue;
        tip_id[n8] = tip_id[n7];
        ++n8;
    }
    for (n7 = n8; n7 < 30; ++n7) tip_id[n7] = 0;

    // Sort by id ascending
    for (n7 = 0; n7 < n8; ++n7) {
        for (n6 = 0; n6 < n8 - 1 - n7; ++n6) {
            n5 = tip_id[n6]; n4 = tip_id[n6 + 1];
            if (n5 <= n4) continue;
            n3 = tip_id[n6]; tip_id[n6] = tip_id[n6 + 1]; tip_id[n6 + 1] = n3;
        }
    }

    for (n7 = 0; n7 < 510; ++n7) tip_cnt[n7] = 0;
    for (n7 = 0; n7 < n8; ++n7) {
        int n10 = tip_id[n7];
        tip_cnt[n10] = tip_cnt[n10] + 1;
    }

    if (n == 0) {
        if (n2 == n) {
            for (n7 = 0; n7 < n8; ++n7) nArray[n7] = tip_id[n7];
            for (n7 = 0; n7 < n8; ++n7) {
                nArray2[n7] = CpCanvas::tip_list[nArray[n7]] & 0xFF00 |
                              255 - (CpCanvas::tip_list[nArray[n7]] & 0xFF);
            }
            for (n7 = 0; n7 < n8; ++n7) {
                n3 = n7;
                for (n6 = n7 + 1; n6 < n8; ++n6) {
                    if (nArray2[n3] >= nArray2[n6]) continue;
                    n3 = n6;
                }
                int n11 = nArray2[n7]; nArray2[n7] = nArray2[n3]; nArray2[n3] = n11;
                n11 = nArray[n7]; nArray[n7] = nArray[n3]; nArray[n3] = n11;
                tip_id[n7] = nArray[n7];
            }
        }
    } else if (n == 1) {
        if (n2 != n) {
            for (n7 = 0; n7 < n8; ++n7) {
                for (n6 = 0; n6 < n8 - 1 - n7; ++n6) {
                    n5 = CpCanvas::tip_list[tip_id[n6]] >> 8 & 0xFF;
                    n4 = CpCanvas::tip_list[tip_id[n6 + 1]] >> 8 & 0xFF;
                    if (CpCanvas::tip[n5]->aiu <= CpCanvas::tip[n4]->aiu) continue;
                    n3 = tip_id[n6]; tip_id[n6] = tip_id[n6 + 1]; tip_id[n6 + 1] = n3;
                }
            }
        } else {
            for (n7 = 0; n7 < n8; ++n7) {
                for (n6 = 0; n6 < n8 - 1 - n7; ++n6) {
                    n5 = CpCanvas::tip_list[tip_id[n6]] >> 8 & 0xFF;
                    n4 = CpCanvas::tip_list[tip_id[n6 + 1]] >> 8 & 0xFF;
                    if (CpCanvas::tip[n5]->aiu >= CpCanvas::tip[n4]->aiu) continue;
                    n3 = tip_id[n6]; tip_id[n6] = tip_id[n6 + 1]; tip_id[n6 + 1] = n3;
                }
            }
        }
    } else if (n == 2) {
        if (n2 != n) {
            for (n7 = 0; n7 < n8; ++n7) {
                for (n6 = 0; n6 < n8 - 1 - n7; ++n6) {
                    n5 = CpCanvas::tip_list[tip_id[n6]] & 0xFF;
                    n4 = CpCanvas::tip_list[tip_id[n6 + 1]] & 0xFF;
                    if (n5 <= n4) continue;
                    n3 = tip_id[n6]; tip_id[n6] = tip_id[n6 + 1]; tip_id[n6 + 1] = n3;
                }
            }
        } else {
            for (n7 = 0; n7 < n8; ++n7) {
                for (n6 = 0; n6 < n8 - 1 - n7; ++n6) {
                    n5 = CpCanvas::tip_list[tip_id[n6]] & 0xFF;
                    n4 = CpCanvas::tip_list[tip_id[n6 + 1]] & 0xFF;
                    if (n5 >= n4) continue;
                    n3 = tip_id[n6]; tip_id[n6] = tip_id[n6 + 1]; tip_id[n6 + 1] = n3;
                }
            }
        }
    } else if (n == 3) {
        if (n2 != n) {
            for (n7 = 0; n7 < n8; ++n7) {
                for (n6 = 0; n6 < n8 - 1 - n7; ++n6) {
                    n5 = CpCanvas::tip_list[tip_id[n6]] >> 8 & 0xFF;
                    n4 = CpCanvas::tip_list[tip_id[n6 + 1]] >> 8 & 0xFF;
                    if (CpCanvas::tip[n5]->pow >= CpCanvas::tip[n4]->pow) continue;
                    n3 = tip_id[n6]; tip_id[n6] = tip_id[n6 + 1]; tip_id[n6 + 1] = n3;
                }
            }
        } else {
            for (n7 = 0; n7 < n8; ++n7) {
                for (n6 = 0; n6 < n8 - 1 - n7; ++n6) {
                    n5 = CpCanvas::tip_list[tip_id[n6]] >> 8 & 0xFF;
                    n4 = CpCanvas::tip_list[tip_id[n6 + 1]] >> 8 & 0xFF;
                    if (CpCanvas::tip[n5]->pow <= CpCanvas::tip[n4]->pow) continue;
                    n3 = tip_id[n6]; tip_id[n6] = tip_id[n6 + 1]; tip_id[n6 + 1] = n3;
                }
            }
        }
    } else if (n == 4) {
        if (n2 != n) {
            for (n7 = 0; n7 < n8; ++n7) {
                for (n6 = 0; n6 < n8 - 1 - n7; ++n6) {
                    n5 = CpCanvas::tip_list[tip_id[n6]] >> 8 & 0xFF;
                    n4 = CpCanvas::tip_list[tip_id[n6 + 1]] >> 8 & 0xFF;
                    if ((CpCanvas::tip[n5]->zoku + 4) % 5 <= (CpCanvas::tip[n4]->zoku + 4) % 5) continue;
                    n3 = tip_id[n6]; tip_id[n6] = tip_id[n6 + 1]; tip_id[n6 + 1] = n3;
                }
            }
        } else {
            for (n7 = 0; n7 < n8; ++n7) {
                for (n6 = 0; n6 < n8 - 1 - n7; ++n6) {
                    n5 = CpCanvas::tip_list[tip_id[n6]] >> 8 & 0xFF;
                    n4 = CpCanvas::tip_list[tip_id[n6 + 1]] >> 8 & 0xFF;
                    if ((CpCanvas::tip[n5]->zoku + 4) % 5 >= (CpCanvas::tip[n4]->zoku + 4) % 5) continue;
                    n3 = tip_id[n6]; tip_id[n6] = tip_id[n6 + 1]; tip_id[n6 + 1] = n3;
                }
            }
        }
    } else if (n == 5) {
        if (n2 != n) {
            for (n7 = 0; n7 < n8; ++n7) {
                for (n6 = 0; n6 < n8 - 1 - n7; ++n6) {
                    n5 = tip_cnt[tip_id[n6]];
                    n4 = tip_cnt[tip_id[n6 + 1]];
                    if (n5 >= n4) continue;
                    n3 = tip_id[n6]; tip_id[n6] = tip_id[n6 + 1]; tip_id[n6 + 1] = n3;
                }
            }
        } else {
            for (n7 = 0; n7 < n8; ++n7) {
                for (n6 = 0; n6 < n8 - 1 - n7; ++n6) {
                    n5 = tip_cnt[tip_id[n6]];
                    n4 = tip_cnt[tip_id[n6 + 1]];
                    if (n5 <= n4) continue;
                    n3 = tip_id[n6]; tip_id[n6] = tip_id[n6 + 1]; tip_id[n6 + 1] = n3;
                }
            }
        }
    } else if (n == 6) {
        if (n2 != n) {
            for (n7 = 0; n7 < n8; ++n7) {
                for (n6 = 0; n6 < n8 - 1 - n7; ++n6) {
                    n5 = CpCanvas::tip_list[tip_id[n6]] >> 8 & 0xFF;
                    n4 = CpCanvas::tip_list[tip_id[n6 + 1]] >> 8 & 0xFF;
                    if (CpCanvas::tip[n5]->regu_you <= CpCanvas::tip[n4]->regu_you) continue;
                    n3 = tip_id[n6]; tip_id[n6] = tip_id[n6 + 1]; tip_id[n6 + 1] = n3;
                }
            }
        } else {
            for (n7 = 0; n7 < n8; ++n7) {
                for (n6 = 0; n6 < n8 - 1 - n7; ++n6) {
                    n5 = CpCanvas::tip_list[tip_id[n6]] >> 8 & 0xFF;
                    n4 = CpCanvas::tip_list[tip_id[n6 + 1]] >> 8 & 0xFF;
                    if (CpCanvas::tip[n5]->regu_you >= CpCanvas::tip[n4]->regu_you) continue;
                    n3 = tip_id[n6]; tip_id[n6] = tip_id[n6 + 1]; tip_id[n6 + 1] = n3;
                }
            }
        }
    }

    for (n7 = 0; n7 < 30; ++n7) {
        if (tip_id[n7] != n9) continue;
        regu_id = n7;
        break;
    }
    return (n2 != n) ? n : -1;
}

void Folder::RandSet(int n) {
    int n2;
    int n3 = 0;
    for (n2 = 0; n2 < n; ++n2) {
        if (CpCanvas::cas_tip[n2] >= 0) continue;
        if (tip_zan > 0) {
            int n4;
            if (CpCanvas::regu_flg != 0) {
                n4 = regu_id;
                CpCanvas::regu_flg = 0;
            } else {
                do {
                    n4 = static_cast<int>((CpCanvas::rand() & 0x7FFFFFFF) % 30);
                } while (used[n4] != 0);
            }
            used[n4] = 1;
            CpCanvas::cas_tip[n2]     = tip_id[n4];
            CpCanvas::fol_tip_no[n2]  = n4;
            --tip_zan;
            CpCanvas::cas_ok[n2] = 1;
            continue;
        }
        CpCanvas::cas_ok[n2] = 0;
        ++n3;
    }
    n -= n3;

    for (n2 = 0; n2 < 5; ++n2) CpCanvas::sel_code[n2] = 0;
    CpCanvas::now_code      = 0;
    CpCanvas::sel_tip       = 0;
    CpCanvas::sel_cnt       = 0;
    CpCanvas::sel_cas_mode  = 0;
    CpCanvas::sel_cas_tip   = 0;
    CpCanvas::cas_cnt       = -3;
    if (n == 0) CpCanvas::sel_cas_mode = 1;
    CpCanvas::max_sel = n;
}
