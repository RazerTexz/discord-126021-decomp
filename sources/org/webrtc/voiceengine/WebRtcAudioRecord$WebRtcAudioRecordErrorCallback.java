package org.webrtc.voiceengine;

/* JADX INFO: loaded from: classes3.dex */
public interface WebRtcAudioRecord$WebRtcAudioRecordErrorCallback {
    void onWebRtcAudioRecordError(String str);

    void onWebRtcAudioRecordInitError(String str);

    void onWebRtcAudioRecordStartError(WebRtcAudioRecord$AudioRecordStartErrorCode webRtcAudioRecord$AudioRecordStartErrorCode, String str);
}
