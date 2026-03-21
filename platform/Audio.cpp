#include "Audio.h"
#include <cstring>

// ── Engine singletons ──────────────────────────────────────────────────────
static IXAudio2*               s_engine     = nullptr;
static IXAudio2MasteringVoice* s_masterVoice = nullptr;

namespace Audio {
    bool init() {
        if (FAILED(XAudio2Create(&s_engine, 0, XAUDIO2_DEFAULT_PROCESSOR)))
            return false;
        if (FAILED(s_engine->CreateMasteringVoice(&s_masterVoice))) {
            s_engine->Release(); s_engine = nullptr;
            return false;
        }
        return true;
    }
    void quit() {
        if (s_masterVoice) { s_masterVoice->DestroyVoice(); s_masterVoice = nullptr; }
        if (s_engine)      { s_engine->Release();           s_engine      = nullptr; }
    }
    IXAudio2*               engine()     { return s_engine; }
    IXAudio2MasteringVoice* masterVoice(){ return s_masterVoice; }
}

// ── Minimal WAV parser ─────────────────────────────────────────────────────
// Returns true if data is a valid RIFF/WAVE file and fills wfx + pcm.
static bool parseWav(const uint8_t* data, size_t len,
                     WAVEFORMATEX& wfx, std::vector<uint8_t>& pcm) {
    if (len < 44) return false;
    if (std::memcmp(data, "RIFF", 4) != 0) return false;
    if (std::memcmp(data + 8, "WAVE", 4) != 0) return false;

    const uint8_t* p   = data + 12;
    const uint8_t* end = data + len;
    bool gotFmt = false, gotData = false;

    while (p + 8 <= end) {
        // Use memcpy for safe unaligned reads
        uint32_t chunkId   = 0;
        uint32_t chunkSize = 0;
        std::memcpy(&chunkId,   p,     sizeof(chunkId));
        std::memcpy(&chunkSize, p + 4, sizeof(chunkSize));
        p += 8;
        if (p + chunkSize > end) break;

        if (chunkId == 0x20746d66u /* "fmt " */ && chunkSize >= 16) {
            std::memcpy(&wfx, p, sizeof(WAVEFORMATEX));
            wfx.cbSize = 0;
            gotFmt = true;
        } else if (chunkId == 0x61746164u /* "data" */) {
            pcm.assign(p, p + chunkSize);
            gotData = true;
        }
        p += (chunkSize + 1) & ~1u;   // word-align
    }
    return gotFmt && gotData;
}

// ── AudioPresenter ─────────────────────────────────────────────────────────
AudioPresenter::AudioPresenter(Type t) : type(t) {}

AudioPresenter::~AudioPresenter() {
    releaseVoice();
}

void AudioPresenter::releaseVoice() {
    if (m_voice) {
        m_voice->Stop();
        m_voice->FlushSourceBuffers();
        m_voice->DestroyVoice();
        m_voice = nullptr;
    }
    m_hasData = false;
}

void AudioPresenter::setData(const uint8_t* data, size_t len) {
    releaseVoice();
    m_pcm.clear();
    std::memset(&m_wfx, 0, sizeof(m_wfx));
    std::memset(&m_buf, 0, sizeof(m_buf));
    m_hasData = false;

    if (!data || !len) return;
    if (!s_engine)    return;

    WAVEFORMATEX wfx = {};
    std::vector<uint8_t> pcm;
    if (!parseWav(data, len, wfx, pcm)) return;  // non-WAV → silent stub

    m_wfx = wfx;
    m_pcm = std::move(pcm);
    m_hasData = true;
}

void AudioPresenter::play(int loop) {
    if (!m_hasData || !s_engine) return;
    releaseVoice();

    if (FAILED(s_engine->CreateSourceVoice(&m_voice, &m_wfx)))
        return;

    m_loop = loop;
    m_buf                = {};
    m_buf.AudioBytes     = (UINT32)m_pcm.size();
    m_buf.pAudioData     = m_pcm.data();
    m_buf.Flags          = XAUDIO2_END_OF_STREAM;
    m_buf.LoopCount      = (loop != 0) ? XAUDIO2_LOOP_INFINITE : 0;

    m_voice->SubmitSourceBuffer(&m_buf);
    m_voice->Start();
}

void AudioPresenter::stop() {
    if (m_voice) {
        m_voice->Stop();
        m_voice->FlushSourceBuffers();
    }
}

void AudioPresenter::setVolume(int vol) {
    if (m_voice) {
        float v = (float)vol / 100.0f;
        m_voice->SetVolume(v);
    }
}

void AudioPresenter::setAttribute(int attr, int val) {
    if (attr == 4) {
        setVolume(val);
    }
}

bool AudioPresenter::isPlaying() const {
    if (!m_voice) return false;
    XAUDIO2_VOICE_STATE state = {};
    m_voice->GetState(&state);
    return state.BuffersQueued > 0;
}
