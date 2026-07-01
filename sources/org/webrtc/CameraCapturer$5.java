package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class CameraCapturer$5 implements Runnable {
    public final /* synthetic */ CameraCapturer this$0;

    public CameraCapturer$5(CameraCapturer cameraCapturer) {
        this.this$0 = cameraCapturer;
    }

    @Override // java.lang.Runnable
    public void run() {
        CameraCapturer cameraCapturer = this.this$0;
        cameraCapturer.createCameraSession(CameraCapturer.access$1900(cameraCapturer), CameraCapturer.access$2000(this.this$0), CameraCapturer.access$2100(this.this$0), CameraCapturer.access$900(this.this$0), CameraCapturer.access$1300(this.this$0), CameraCapturer.access$2200(this.this$0), CameraCapturer.access$2300(this.this$0), CameraCapturer.access$2400(this.this$0));
    }
}
