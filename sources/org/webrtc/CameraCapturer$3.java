package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class CameraCapturer$3 implements Runnable {
    public final /* synthetic */ CameraCapturer this$0;

    public CameraCapturer$3(CameraCapturer cameraCapturer) {
        this.this$0 = cameraCapturer;
    }

    @Override // java.lang.Runnable
    public void run() {
        CameraCapturer.access$1000(this.this$0).onCameraError("Camera failed to start within timeout.");
    }
}
