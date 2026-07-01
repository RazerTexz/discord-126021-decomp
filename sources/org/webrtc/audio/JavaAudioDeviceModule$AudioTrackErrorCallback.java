package org.webrtc.audio;

/* JADX INFO: loaded from: classes3.dex */
public interface JavaAudioDeviceModule$AudioTrackErrorCallback {
    void onWebRtcAudioTrackError(String str);

    void onWebRtcAudioTrackInitError(String str);

    void onWebRtcAudioTrackStartError(JavaAudioDeviceModule$AudioTrackStartErrorCode javaAudioDeviceModule$AudioTrackStartErrorCode, String str);
}
