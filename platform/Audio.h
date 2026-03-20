#pragma once
#include "Platform.h"

// SDL2_mixer-backed replacement for com.nttdocomo.ui.AudioPresenter / MediaSound
class AudioPresenter {
public:
    enum class Type { BGM, SE };

    explicit AudioPresenter(Type t);
    ~AudioPresenter();

    void setData(const uint8_t* data, size_t len);
    void play(int loop = 0);   // 0=once, -1=loop
    void stop();
    void setVolume(int vol);   // 0-100
    bool isPlaying() const;

    Type type;
private:
    Mix_Music* music   = nullptr;
    Mix_Chunk* chunk   = nullptr;
    int        channel = -1;
    void*      dataCopy = nullptr;
    SDL_RWops* rw      = nullptr;
};

namespace Audio {
    bool init();
    void quit();
}
