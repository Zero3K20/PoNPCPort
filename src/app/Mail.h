#pragma once
#include "Types.h"
#include <string>

class Mail {
public:
    int mail_id;
    int face;
    int from;
    int to;
    int subject;
    int ivent;
    std::string str_f;
    std::string str_t;
    std::string str_s;

    static const char *str_name[8];
    static const char *net_name[5];

    Mail(int n, InputStream *inputStream, InputStream *inputStream2);
};
