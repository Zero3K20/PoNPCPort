#pragma once
#include <cstdint>

class Folder {
public:
    int tip_id[30]   = {};
    int used[30]     = {};
    int tip_zan      = 0;
    int m_cnt        = 0;
    int g_cnt        = 0;
    int tip_cnt[510] = {};
    int tip_cnt2[200]= {};
    int regu_flg     = 0;
    int regu_id      = 0;

    void init();
    int  FolSet(int n, int n2);
    void FolNon(int n);
    int  FolCh();
    int  Sort(int n, int n2);
    void RandSet(int n);
};
