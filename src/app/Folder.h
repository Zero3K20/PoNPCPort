#pragma once
#include "Types.h"

class Folder {
public:
    int tip_id[30];
    int used[30];
    int tip_zan;
    int m_cnt;
    int g_cnt;
    int tip_cnt[510];
    int tip_cnt2[200];
    int regu_flg;
    int regu_id;

    Folder();
    void init();
    int  FolSet(int n, int n2);
    void FolNon(int n);
    int  FolCh();
    int  Sort(int n, int n2);
    void RandSet(int n);
};
