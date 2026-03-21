#pragma once
// COM initialisation helpers that load ole32.dll at runtime,
// avoiding any dependency on UCRT API-set forwarder DLLs.

bool COM_Init();  // CoInitializeEx(nullptr, COINIT_MULTITHREADED)
void COM_Quit();  // CoUninitialize
