package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class CameraCapturer$1 implements CameraSession$CreateSessionCallback {
    public final /* synthetic */ CameraCapturer this$0;

    public CameraCapturer$1(CameraCapturer cameraCapturer) {
        this.this$0 = cameraCapturer;
    }

    @Override // org.webrtc.CameraSession$CreateSessionCallback
    public void onDone(CameraSession cameraSession) {
        CameraCapturer.access$000(this.this$0);
        Logging.d("CameraCapturer", "Create session done. Switch state: " + CameraCapturer.access$100(this.this$0));
        CameraCapturer.access$300(this.this$0).removeCallbacks(CameraCapturer.access$200(this.this$0));
        synchronized (CameraCapturer.access$400(this.this$0)) {
            CameraCapturer.access$500(this.this$0).onCapturerStarted(true);
            CameraCapturer.access$602(this.this$0, false);
            CameraCapturer.access$702(this.this$0, cameraSession);
            CameraCapturer cameraCapturer = this.this$0;
            CameraCapturer.access$802(cameraCapturer, new CameraVideoCapturer$CameraStatistics(CameraCapturer.access$900(cameraCapturer), CameraCapturer.access$1000(this.this$0)));
            CameraCapturer.access$1102(this.this$0, false);
            CameraCapturer.access$400(this.this$0).notifyAll();
            if (CameraCapturer.access$100(this.this$0) == CameraCapturer$SwitchState.IN_PROGRESS) {
                CameraCapturer.access$102(this.this$0, CameraCapturer$SwitchState.IDLE);
                if (CameraCapturer.access$1200(this.this$0) != null) {
                    CameraCapturer.access$1200(this.this$0).onCameraSwitchDone(CameraCapturer.access$1400(this.this$0).isFrontFacing(CameraCapturer.access$1300(this.this$0)));
                    CameraCapturer.access$1202(this.this$0, null);
                }
            } else if (CameraCapturer.access$100(this.this$0) == CameraCapturer$SwitchState.PENDING) {
                String strAccess$1500 = CameraCapturer.access$1500(this.this$0);
                CameraCapturer.access$1502(this.this$0, null);
                CameraCapturer.access$102(this.this$0, CameraCapturer$SwitchState.IDLE);
                CameraCapturer cameraCapturer2 = this.this$0;
                CameraCapturer.access$1600(cameraCapturer2, CameraCapturer.access$1200(cameraCapturer2), strAccess$1500);
            }
        }
    }

    @Override // org.webrtc.CameraSession$CreateSessionCallback
    public void onFailure(CameraSession$FailureType cameraSession$FailureType, String str) {
        CameraCapturer.access$000(this.this$0);
        CameraCapturer.access$300(this.this$0).removeCallbacks(CameraCapturer.access$200(this.this$0));
        synchronized (CameraCapturer.access$400(this.this$0)) {
            CameraCapturer.access$500(this.this$0).onCapturerStarted(false);
            CameraCapturer.access$1710(this.this$0);
            if (CameraCapturer.access$1700(this.this$0) <= 0) {
                Logging.w("CameraCapturer", "Opening camera failed, passing: " + str);
                CameraCapturer.access$602(this.this$0, false);
                CameraCapturer.access$400(this.this$0).notifyAll();
                CameraCapturer$SwitchState cameraCapturer$SwitchStateAccess$100 = CameraCapturer.access$100(this.this$0);
                CameraCapturer$SwitchState cameraCapturer$SwitchState = CameraCapturer$SwitchState.IDLE;
                if (cameraCapturer$SwitchStateAccess$100 != cameraCapturer$SwitchState) {
                    if (CameraCapturer.access$1200(this.this$0) != null) {
                        CameraCapturer.access$1200(this.this$0).onCameraSwitchError(str);
                        CameraCapturer.access$1202(this.this$0, null);
                    }
                    CameraCapturer.access$102(this.this$0, cameraCapturer$SwitchState);
                }
                if (cameraSession$FailureType == CameraSession$FailureType.DISCONNECTED) {
                    CameraCapturer.access$1000(this.this$0).onCameraDisconnected();
                } else {
                    CameraCapturer.access$1000(this.this$0).onCameraError(str);
                }
            } else {
                Logging.w("CameraCapturer", "Opening camera failed, retry: " + str);
                CameraCapturer.access$1800(this.this$0, 500);
            }
        }
    }
}
