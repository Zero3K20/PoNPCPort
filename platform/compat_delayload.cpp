/*
 * compat_delayload.cpp
 *
 * Delay-load failure hook that eliminates the hard dependency on
 * api-ms-win-core-com-l1-1-0.dll (a Windows 8+ API-set forwarding DLL).
 *
 * When the Windows 10 SDK links ole32.lib / windowscodecs.lib it can produce
 * imports against api-ms-win-core-com-l1-1-0.dll for CoInitializeEx,
 * CoUninitialize, etc.  That DLL does not exist on Windows 7, causing an
 * immediate "DLL not found" error at startup.
 *
 * By delay-loading api-ms-win-core-com-l1-1-0.dll and registering this hook,
 * the exe requires no such DLL at all: whenever the delay-load machinery
 * would try to load it, the hook transparently substitutes ole32.dll instead,
 * which exports every function the API-set DLL would have forwarded to anyway.
 *
 * Required linker settings (see PoNPCPort.vcxproj):
 *   /DELAYLOAD:api-ms-win-core-com-l1-1-0.dll
 *   delayimp.lib
 */

#define WIN32_LEAN_AND_MEAN
#include <windows.h>
#include <delayimp.h>

static FARPROC WINAPI compat_delayload_hook(unsigned dliNotify, PDelayLoadInfo pdli)
{
    if (dliNotify == dliFailLoadLib &&
        lstrcmpiA(pdli->szDll, "api-ms-win-core-com-l1-1-0.dll") == 0)
    {
        /* All functions forwarded by api-ms-win-core-com-l1-1-0.dll
         * (CoInitializeEx, CoUninitialize, CoGetCallContext, etc.) exist
         * directly in ole32.dll on every supported Windows version. */
        return reinterpret_cast<FARPROC>(LoadLibraryA("ole32.dll"));
    }
    return nullptr;
}

/* Register the hook with the delay-load runtime. */
extern "C" const PfnDliHook __pfnDliFailureHook2 = compat_delayload_hook;
