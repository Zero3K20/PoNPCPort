#include "Platform.h"   // windows.h

// Function-pointer types for the two COM functions we need.
// Defined locally so we do not need to #include <objbase.h>.
typedef HRESULT (WINAPI *PFN_CoInitializeEx)(LPVOID pvReserved, DWORD dwCoInit);
typedef void    (WINAPI *PFN_CoUninitialize)();

// COINIT_MULTITHREADED = 0  (from objbase.h / combaseapi.h)
static const DWORD COMPAT_COINIT_MULTITHREADED = 0x0;

static HMODULE           s_hOle32            = nullptr;
static PFN_CoUninitialize s_pfnCoUninitialize = nullptr;

bool COM_Init()
{
    s_hOle32 = LoadLibraryW(L"ole32.dll");
    if (!s_hOle32)
        return false;

    auto pfnCoInitEx = reinterpret_cast<PFN_CoInitializeEx>(
        GetProcAddress(s_hOle32, "CoInitializeEx"));
    s_pfnCoUninitialize = reinterpret_cast<PFN_CoUninitialize>(
        GetProcAddress(s_hOle32, "CoUninitialize"));

    if (!pfnCoInitEx || !s_pfnCoUninitialize) {
        FreeLibrary(s_hOle32);
        s_hOle32 = nullptr;
        return false;
    }

    HRESULT hr = pfnCoInitEx(nullptr, COMPAT_COINIT_MULTITHREADED);
    // S_OK (0) or S_FALSE (1) = success; RPC_E_CHANGED_MODE is also acceptable
    return SUCCEEDED(hr) || hr == static_cast<HRESULT>(0x80010106);
}

void COM_Quit()
{
    if (s_pfnCoUninitialize) {
        s_pfnCoUninitialize();
        s_pfnCoUninitialize = nullptr;
    }
    if (s_hOle32) {
        FreeLibrary(s_hOle32);
        s_hOle32 = nullptr;
    }
}
