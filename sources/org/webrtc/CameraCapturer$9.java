package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class CameraCapturer$9 implements Runnable {
    public final /* synthetic */ CameraCapturer this$0;
    public final /* synthetic */ CameraSession val$oldSession;

    public CameraCapturer$9(CameraCapturer cameraCapturer, CameraSession cameraSession) {
        this.this$0 = cameraCapturer;
        this.val$oldSession = cameraSession;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$oldSession.stop();
    }
}
