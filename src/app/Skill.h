#pragma once
#include "Types.h"
#include <string>

class Skill {
public:
    static int ski_id;
    int you;
    int param;
    std::string name;

    Skill(int n, InputStream *inputStream, InputStream *inputStream2);
};
