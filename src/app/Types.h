#pragma once
/*
 * Types.h - Common types and utilities for the P.o.N. PC port
 */
#include "../platform/Platform.h"
#include <string>
#include <vector>

/* Utility: read big-endian 32-bit int from byte array */
inline int intChange(const unsigned char *b, int off)
{
    return ((b[off] & 0xFF) << 24) | ((b[off+1] & 0xFF) << 16)
         | ((b[off+2] & 0xFF) << 8)  |  (b[off+3] & 0xFF);
}

/* Safe array bounds check (like Java array access, returns 0 on OOB) */
template<typename T>
inline T safe_get(const T *arr, int idx, int size, T def = T())
{
    return (idx >= 0 && idx < size) ? arr[idx] : def;
}

/* Java-style string operations */
inline std::string sjis_to_utf8(const unsigned char *data, int len)
{
    /* Convert Shift-JIS bytes to UTF-8 string via Win32 */
    if (len <= 0) return "";
    int wlen = MultiByteToWideChar(932, 0, (LPCSTR)data, len, nullptr, 0);
    if (wlen <= 0) return std::string((const char*)data, len);
    std::vector<wchar_t> wbuf(wlen + 1, 0);
    MultiByteToWideChar(932, 0, (LPCSTR)data, len, wbuf.data(), wlen);
    int ulen = WideCharToMultiByte(CP_UTF8, 0, wbuf.data(), wlen, nullptr, 0, nullptr, nullptr);
    if (ulen <= 0) return std::string((const char*)data, len);
    std::vector<char> ubuf(ulen + 1, 0);
    WideCharToMultiByte(CP_UTF8, 0, wbuf.data(), wlen, ubuf.data(), ulen, nullptr, nullptr);
    return std::string(ubuf.data(), ulen);
}

/* Java String from Shift-JIS bytes, null terminated within a fixed buffer */
inline std::string sjis_string_from_buf(const unsigned char *buf, int buflen)
{
    int len = 0;
    while (len < buflen && buf[len] != 0) len++;
    return sjis_to_utf8(buf, len);
}
