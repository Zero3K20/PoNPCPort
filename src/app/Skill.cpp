#include "Skill.h"

int Skill::ski_id = 0;

Skill::Skill(int n, InputStream *inputStream, InputStream *inputStream2)
    : you(0), param(0)
{
    ski_id = n;
    if (inputStream) {
        try {
            unsigned char byArray[4];
            inputStream->read(byArray, 4);
            you   = byArray[3] & 0xFF;
            param = ((byArray[0] & 0xFF) << 8) | (byArray[1] & 0xFF);
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
