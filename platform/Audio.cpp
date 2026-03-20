#include "Audio.h"
#include <cstring>

namespace Audio {
    bool init() {
        if (Mix_OpenAudio(44100, MIX_DEFAULT_FORMAT, 2, 2048) < 0) {
            SDL_Log("SDL_mixer: %s", Mix_GetError());
            return false;
        }
        Mix_AllocateChannels(32);
        return true;
    }
    void quit() { Mix_CloseAudio(); }
}

AudioPresenter::AudioPresenter(Type t) : type(t) {}

AudioPresenter::~AudioPresenter() {
    stop();
    if (music)    { Mix_FreeMusic(music);  music    = nullptr; }
    if (chunk)    { Mix_FreeChunk(chunk);  chunk    = nullptr; }
    if (rw)       { SDL_RWclose(rw);       rw       = nullptr; }
    if (dataCopy) { SDL_free(dataCopy);    dataCopy = nullptr; }
}

void AudioPresenter::setData(const uint8_t* data, size_t len) {
    stop();
    if (music)    { Mix_FreeMusic(music);  music    = nullptr; }
    if (chunk)    { Mix_FreeChunk(chunk);  chunk    = nullptr; }
    if (rw)       { SDL_RWclose(rw);       rw       = nullptr; }
    if (dataCopy) { SDL_free(dataCopy);    dataCopy = nullptr; }

    dataCopy = SDL_malloc(len);
    if (!dataCopy) return;
    std::memcpy(dataCopy, data, len);
    rw = SDL_RWFromMem(dataCopy, (int)len);
    if (!rw) return;

    if (type == Type::BGM)
        music = Mix_LoadMUS_RW(rw, 0);
    else
        chunk = Mix_LoadWAV_RW(rw, 0);
}

void AudioPresenter::play(int loop) {
    if (type == Type::BGM && music)
        Mix_PlayMusic(music, (loop == 0) ? 1 : -1);
    else if (type == Type::SE && chunk)
        channel = Mix_PlayChannel(-1, chunk, (loop == 0) ? 0 : -1);
}

void AudioPresenter::stop() {
    if (type == Type::BGM)
        Mix_HaltMusic();
    else if (channel >= 0) {
        Mix_HaltChannel(channel);
        channel = -1;
    }
}

void AudioPresenter::setVolume(int vol) {
    int v = (vol * MIX_MAX_VOLUME) / 100;
    if (type == Type::BGM)  Mix_VolumeMusic(v);
    else if (chunk)         Mix_VolumeChunk(chunk, v);
}

bool AudioPresenter::isPlaying() const {
    if (type == Type::BGM) return Mix_PlayingMusic() != 0;
    return (channel >= 0) && Mix_Playing(channel);
}
