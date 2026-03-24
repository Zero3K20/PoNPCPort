#include "Mail.h"

/* Shift-JIS encoded names (stored as raw bytes for correct display) */
const char *Mail::str_name[8] = {
    "\xe3\x83\x87\xe3\x83\xb3\xe3\x82\xb5\xe3\x83\xb3\xe3\x83\x8b\xe3\x83\xa5\xe3\x83\xbc\xe3\x82\xb9", /* デンサンニュース */
    "\xe3\x83\x87\xe3\x82\xab\xe3\x82\xaa",                /* デカオ */
    "\xe3\x83\xa1\xe3\x82\xa4\xe3\x83\xab",                /* メイル */
    "\xe6\x97\xa5\xe6\x9a\xae",                             /* 日暮 */
    "\xe3\x83\x91\xe3\x83\x91",                             /* パパ */
    "\xe3\x83\x89\xe3\x83\xbc\xe3\x83\xa0\xe5\xa4\xa7\xe4\xbc\x9a\xe4\xba\x8b\xe5\x8b\x99\xe5\xb1\x80", /* ドーム大会事務局 */
    "\xe4\xbf\xae\xe4\xb8\x80",                             /* 修一 */
    "\xe7\xa7\x91\xe5\xad\xa6\xe7\x9c\x81"                 /* 科学省 */
};

const char *Mail::net_name[5] = {
    "\xe7\xa7\x8b\xe5\x8e\x9f\xef\xbc\xad\xef\xbc\xac",   /* 秋原ＭＬ */
    "\xe7\x86\xb1\xe9\x97\x98",                             /* 熱闘 */
    "\xe7\x86\xb1\xe9\x97\x98\xe3\x81\x8f\xe3\x82\x93",   /* 熱闘くん */
    "\xe5\x85\x89\xe3\x80\x80\xe7\x86\xb1\xe9\x97\x98\xe9\x81\xb8\xe6\x89\x8b", /* 光　熱闘選手 */
    "\xe5\x85\x89\xe3\x80\x80\xe7\x86\xb1\xe9\x97\x98\xe3\x81\x95\xe3\x81\xbe"  /* 光　熱闘さま */
};

Mail::Mail(int n, InputStream *inputStream, InputStream *inputStream2)
    : mail_id(n), face(0), from(0), to(0), subject(0), ivent(0)
{
    if (inputStream) {
        try {
            face    = inputStream->read();
            from    = inputStream->read();
            to      = inputStream->read();
            subject = inputStream->read();
            if (from >= 0 && from < 8) str_f = str_name[from];
            if (to >= 0 && to < 5) str_t = net_name[to];
        } catch (...) {}
    }
    if (inputStream2) {
        try {
            unsigned char byArray[30];
            inputStream2->read(byArray, 30);
            int n2 = 0;
            while (n2 < 30 && byArray[n2] != 0) n2++;
            str_s = sjis_to_utf8(byArray, n2);
        } catch (...) {}
    }
}
