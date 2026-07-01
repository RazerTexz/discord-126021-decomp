package org.webrtc.audio;

/* JADX INFO: loaded from: classes3.dex */
public interface JavaAudioDeviceModule$AudioRecordErrorCallback {
    void onWebRtcAudioRecordError(String str);

    void onWebRtcAudioRecordInitError(String str);

    void onWebRtcAudioRecordStartError(JavaAudioDeviceModule$AudioRecordStartErrorCode javaAudioDeviceModule$AudioRecordStartErrorCode, String str);
}
