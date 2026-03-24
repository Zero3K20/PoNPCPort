#include "Tip.h"

void Tip::init(int n, InputStream *inputStream, InputStream *inputStream2)
{
    tip_id = n;
    if (inputStream) {
        try {
            unsigned char byArray[4];
            inputStream->read(byArray, 4);
            syu      = byArray[0] & 0xFF;
            aiu      = byArray[1] & 0xFF;
            pow      = ((byArray[2] & 0xFF) << 8) | (byArray[3] & 0xFF);
            inputStream->read(byArray, 4);
            zoku     = (byArray[0] & 0xF0) >> 4;
            rea      = byArray[0] & 0xF;
            setu_id  = byArray[1] & 0xFF;
            regu_you = byArray[2] & 0xFF;
            waza_id  = byArray[3] & 0xFF;
        } catch (...) {}
    }
    if (inputStream2) {
        try {
            unsigned char byArray[16];
            inputStream2->read(byArray, 16);
            int n2 = 0;
            while (n2 < 16 && byArray[n2] != 0) n2++;
            name = sjis_to_utf8(byArray, n2);
        } catch (...) {}
    }
}
