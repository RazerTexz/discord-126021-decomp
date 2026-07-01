package org.webrtc.audio;

/* JADX INFO: loaded from: classes3.dex */
public interface AudioDeviceModule {
    long getNativeAudioDeviceModulePointer();

    void release();

    void setMicrophoneMute(boolean z2);

    void setSpeakerMute(boolean z2);
}
