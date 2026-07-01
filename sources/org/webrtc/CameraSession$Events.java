package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public interface CameraSession$Events {
    void onCameraClosed(CameraSession cameraSession);

    void onCameraDisconnected(CameraSession cameraSession);

    void onCameraError(CameraSession cameraSession, String str);

    void onCameraOpening();

    void onFrameCaptured(CameraSession cameraSession, VideoFrame videoFrame);
}
