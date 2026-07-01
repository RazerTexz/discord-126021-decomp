package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public interface CameraSession$CreateSessionCallback {
    void onDone(CameraSession cameraSession);

    void onFailure(CameraSession$FailureType cameraSession$FailureType, String str);
}
