package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class CameraVideoCapturer$CameraStatistics$1 implements Runnable {
    public final /* synthetic */ CameraVideoCapturer$CameraStatistics this$0;

    public CameraVideoCapturer$CameraStatistics$1(CameraVideoCapturer$CameraStatistics cameraVideoCapturer$CameraStatistics) {
        this.this$0 = cameraVideoCapturer$CameraStatistics;
    }

    @Override // java.lang.Runnable
    public void run() {
        Logging.d("CameraStatistics", "Camera fps: " + Math.round((CameraVideoCapturer$CameraStatistics.access$000(this.this$0) * 1000.0f) / 2000.0f) + ".");
        if (CameraVideoCapturer$CameraStatistics.access$000(this.this$0) == 0) {
            CameraVideoCapturer$CameraStatistics.access$104(this.this$0);
            if (CameraVideoCapturer$CameraStatistics.access$100(this.this$0) * 2000 >= 4000 && CameraVideoCapturer$CameraStatistics.access$200(this.this$0) != null) {
                Logging.e("CameraStatistics", "Camera freezed.");
                if (CameraVideoCapturer$CameraStatistics.access$300(this.this$0).isTextureInUse()) {
                    CameraVideoCapturer$CameraStatistics.access$200(this.this$0).onCameraFreezed("Camera failure. Client must return video buffers.");
                    return;
                } else {
                    CameraVideoCapturer$CameraStatistics.access$200(this.this$0).onCameraFreezed("Camera failure.");
                    return;
                }
            }
        } else {
            CameraVideoCapturer$CameraStatistics.access$102(this.this$0, 0);
        }
        CameraVideoCapturer$CameraStatistics.access$002(this.this$0, 0);
        CameraVideoCapturer$CameraStatistics.access$300(this.this$0).getHandler().postDelayed(this, 2000L);
    }
}
