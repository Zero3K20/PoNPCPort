/*
 * compat_delayload.cpp
 *
 * Eliminates the hard startup dependency on api-ms-win-core-com-l1-1-0.dll
 * (a Windows 8+ API-set forwarding DLL that does not exist on Windows 7).
 *
 * Strategy:
 *  1. #pragma comment(linker, ...) ensures /DELAYLOAD is always active for
 *     that DLL, removing it from the static import table so Windows never
 *     needs to find it at startup.
 *  2. __pfnDliFailureHook2 is the MSVC delay-load failure callback.  When
 *     the delay-load thunk tries to load api-ms-win-core-com-l1-1-0.dll and
 *     cannot find it, this hook fires and transparently substitutes ole32.dll,
 *     which exports every COM function (CoInitializeEx, CoUninitialize, etc.)
 *     that the API-set DLL forwards on Windows 8+.
 */

#define WIN32_LEAN_AND_MEAN
#include <windows.h>
#include <delayimp.h>

/* These pragmas make the file self-contained: even if the .vcxproj settings
 * are not applied for some reason, compiling this translation unit is enough
 * to enable the delay-load and register the hook. */
#pragma comment(lib, "delayimp.lib")
#pragma comment(linker, "/DELAYLOAD:api-ms-win-core-com-l1-1-0.dll")

static FARPROC WINAPI compat_delayload_hook(unsigned dliNotify, PDelayLoadInfo pdli)
{
    if (dliNotify == dliFailLoadLib &&
        lstrcmpiA(pdli->szDll, "api-ms-win-core-com-l1-1-0.dll") == 0)
    {
        /* Every function forwarded by api-ms-win-core-com-l1-1-0.dll
         * (CoInitializeEx, CoUninitialize, CoGetCallContext, etc.) is
         * exported directly by ole32.dll on all supported Windows versions. */
        return reinterpret_cast<FARPROC>(LoadLibraryA("ole32.dll"));
    }
    return nullptr;
}

/* Override the weak NULL definition supplied by delayimp.lib.
 * Declared as 'const' in the VS2019 SDK delayimp.h; definition must match. */
extern "C" const PfnDliHook __pfnDliFailureHook2 = compat_delayload_hook;
