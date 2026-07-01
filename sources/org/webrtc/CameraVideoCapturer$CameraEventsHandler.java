package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public interface CameraVideoCapturer$CameraEventsHandler {
    void onCameraClosed();

    void onCameraDisconnected();

    void onCameraError(String str);

    void onCameraFreezed(String str);

    void onCameraOpening(String str);

    void onFirstFrameAvailable();
}
