package org.webrtc;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CameraCapturer$7 implements Runnable {
    public final /* synthetic */ CameraCapturer this$0;
    public final /* synthetic */ CameraVideoCapturer$CameraSwitchHandler val$switchEventsHandler;

    public CameraCapturer$7(CameraCapturer cameraCapturer, CameraVideoCapturer$CameraSwitchHandler cameraVideoCapturer$CameraSwitchHandler) {
        this.this$0 = cameraCapturer;
        this.val$switchEventsHandler = cameraVideoCapturer$CameraSwitchHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        List listAsList = Arrays.asList(CameraCapturer.access$1400(this.this$0).getDeviceNames());
        if (listAsList.size() < 2) {
            CameraCapturer.access$2500(this.this$0, "No camera to switch to.", this.val$switchEventsHandler);
        } else {
            CameraCapturer.access$1600(this.this$0, this.val$switchEventsHandler, (String) listAsList.get((listAsList.indexOf(CameraCapturer.access$1300(this.this$0)) + 1) % listAsList.size()));
        }
    }
}
