#pragma once
#include <string>
#include <cstdint>

class Mail {
public:
    int mail_id = 0;
    int face    = 0;
    int from    = 0;
    int to      = 0;
    int subject = 0;
    int ivent   = 0;
    std::string str_f;
    std::string str_t;
    std::string str_s;

    static const char* str_name[8];
    static const char* net_name[5];

    void init(int n, const uint8_t* fromData, const uint8_t* subjData);
};
