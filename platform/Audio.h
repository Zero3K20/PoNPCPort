#pragma once
#include "Platform.h"
#include <vector>

// XAudio2-backed replacement for com.nttdocomo.ui.AudioPresenter / MediaSound.
// Supports PCM WAV data (RIFF/WAVE).  Other formats are silently ignored.
class AudioPresenter {
public:
    enum class Type { BGM, SE };

    explicit AudioPresenter(Type t);
    ~AudioPresenter();

    void setData(const uint8_t* data, size_t len);
    void play(int loop = 0);   // 0 = once, non-zero = loop
    void stop();
    void setVolume(int vol);   // 0-100
    void setAttribute(int attr, int val); // attr 4 = volume (0-100)
    bool isPlaying() const;

    Type type;

private:
    IXAudio2SourceVoice*  m_voice   = nullptr;
    std::vector<uint8_t>  m_pcm;
    WAVEFORMATEX          m_wfx     = {};
    XAUDIO2_BUFFER        m_buf     = {};
    bool                  m_hasData = false;
    int                   m_loop    = 0;

    void releaseVoice();
};

namespace Audio {
    bool init();
    void quit();

    // Exposed for AudioPresenter
    IXAudio2*               engine();
    IXAudio2MasteringVoice* masterVoice();
}
