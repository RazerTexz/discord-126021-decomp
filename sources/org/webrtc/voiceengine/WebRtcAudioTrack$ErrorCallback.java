package org.webrtc.voiceengine;

/* JADX INFO: loaded from: classes3.dex */
public interface WebRtcAudioTrack$ErrorCallback {
    void onWebRtcAudioTrackError(String str);

    void onWebRtcAudioTrackInitError(String str);

    void onWebRtcAudioTrackStartError(WebRtcAudioTrack$AudioTrackStartErrorCode webRtcAudioTrack$AudioTrackStartErrorCode, String str);
}
