package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class CameraCapturer$2 implements CameraSession$Events {
    public final /* synthetic */ CameraCapturer this$0;

    public CameraCapturer$2(CameraCapturer cameraCapturer) {
        this.this$0 = cameraCapturer;
    }

    @Override // org.webrtc.CameraSession$Events
    public void onCameraClosed(CameraSession cameraSession) {
        CameraCapturer.access$000(this.this$0);
        synchronized (CameraCapturer.access$400(this.this$0)) {
            if (cameraSession == CameraCapturer.access$700(this.this$0) || CameraCapturer.access$700(this.this$0) == null) {
                CameraCapturer.access$1000(this.this$0).onCameraClosed();
            } else {
                Logging.d("CameraCapturer", "onCameraClosed from another session.");
            }
        }
    }

    @Override // org.webrtc.CameraSession$Events
    public void onCameraDisconnected(CameraSession cameraSession) {
        CameraCapturer.access$000(this.this$0);
        synchronized (CameraCapturer.access$400(this.this$0)) {
            if (cameraSession != CameraCapturer.access$700(this.this$0)) {
                Logging.w("CameraCapturer", "onCameraDisconnected from another session.");
            } else {
                CameraCapturer.access$1000(this.this$0).onCameraDisconnected();
                this.this$0.stopCapture();
            }
        }
    }

    @Override // org.webrtc.CameraSession$Events
    public void onCameraError(CameraSession cameraSession, String str) {
        CameraCapturer.access$000(this.this$0);
        synchronized (CameraCapturer.access$400(this.this$0)) {
            if (cameraSession == CameraCapturer.access$700(this.this$0)) {
                CameraCapturer.access$1000(this.this$0).onCameraError(str);
                this.this$0.stopCapture();
            } else {
                Logging.w("CameraCapturer", "onCameraError from another session: " + str);
            }
        }
    }

    @Override // org.webrtc.CameraSession$Events
    public void onCameraOpening() {
        CameraCapturer.access$000(this.this$0);
        synchronized (CameraCapturer.access$400(this.this$0)) {
            if (CameraCapturer.access$700(this.this$0) != null) {
                Logging.w("CameraCapturer", "onCameraOpening while session was open.");
            } else {
                CameraCapturer.access$1000(this.this$0).onCameraOpening(CameraCapturer.access$1300(this.this$0));
            }
        }
    }

    @Override // org.webrtc.CameraSession$Events
    public void onFrameCaptured(CameraSession cameraSession, VideoFrame videoFrame) {
        CameraCapturer.access$000(this.this$0);
        synchronized (CameraCapturer.access$400(this.this$0)) {
            if (cameraSession != CameraCapturer.access$700(this.this$0)) {
                Logging.w("CameraCapturer", "onFrameCaptured from another session.");
                return;
            }
            if (!CameraCapturer.access$1100(this.this$0)) {
                CameraCapturer.access$1000(this.this$0).onFirstFrameAvailable();
                CameraCapturer.access$1102(this.this$0, true);
            }
            CameraCapturer.access$800(this.this$0).addFrame();
            CameraCapturer.access$500(this.this$0).onFrameCaptured(videoFrame);
        }
    }
}
