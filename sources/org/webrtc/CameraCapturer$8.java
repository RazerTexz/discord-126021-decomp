package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class CameraCapturer$8 implements Runnable {
    public final /* synthetic */ CameraCapturer this$0;
    public final /* synthetic */ String val$cameraName;
    public final /* synthetic */ CameraVideoCapturer$CameraSwitchHandler val$switchEventsHandler;

    public CameraCapturer$8(CameraCapturer cameraCapturer, CameraVideoCapturer$CameraSwitchHandler cameraVideoCapturer$CameraSwitchHandler, String str) {
        this.this$0 = cameraCapturer;
        this.val$switchEventsHandler = cameraVideoCapturer$CameraSwitchHandler;
        this.val$cameraName = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        CameraCapturer.access$1600(this.this$0, this.val$switchEventsHandler, this.val$cameraName);
    }
}
