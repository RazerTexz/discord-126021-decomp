package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class CameraVideoCapturer$CameraStatistics {
    private static final int CAMERA_FREEZE_REPORT_TIMOUT_MS = 4000;
    private static final int CAMERA_OBSERVER_PERIOD_MS = 2000;
    private static final String TAG = "CameraStatistics";
    private final Runnable cameraObserver;
    private final CameraVideoCapturer$CameraEventsHandler eventsHandler;
    private int frameCount;
    private int freezePeriodCount;
    private final SurfaceTextureHelper surfaceTextureHelper;

    public CameraVideoCapturer$CameraStatistics(SurfaceTextureHelper surfaceTextureHelper, CameraVideoCapturer$CameraEventsHandler cameraVideoCapturer$CameraEventsHandler) {
        CameraVideoCapturer$CameraStatistics$1 cameraVideoCapturer$CameraStatistics$1 = new CameraVideoCapturer$CameraStatistics$1(this);
        this.cameraObserver = cameraVideoCapturer$CameraStatistics$1;
        if (surfaceTextureHelper == null) {
            throw new IllegalArgumentException("SurfaceTextureHelper is null");
        }
        this.surfaceTextureHelper = surfaceTextureHelper;
        this.eventsHandler = cameraVideoCapturer$CameraEventsHandler;
        this.frameCount = 0;
        this.freezePeriodCount = 0;
        surfaceTextureHelper.getHandler().postDelayed(cameraVideoCapturer$CameraStatistics$1, 2000L);
    }

    public static /* synthetic */ int access$000(CameraVideoCapturer$CameraStatistics cameraVideoCapturer$CameraStatistics) {
        return cameraVideoCapturer$CameraStatistics.frameCount;
    }

    public static /* synthetic */ int access$002(CameraVideoCapturer$CameraStatistics cameraVideoCapturer$CameraStatistics, int i) {
        cameraVideoCapturer$CameraStatistics.frameCount = i;
        return i;
    }

    public static /* synthetic */ int access$100(CameraVideoCapturer$CameraStatistics cameraVideoCapturer$CameraStatistics) {
        return cameraVideoCapturer$CameraStatistics.freezePeriodCount;
    }

    public static /* synthetic */ int access$102(CameraVideoCapturer$CameraStatistics cameraVideoCapturer$CameraStatistics, int i) {
        cameraVideoCapturer$CameraStatistics.freezePeriodCount = i;
        return i;
    }

    public static /* synthetic */ int access$104(CameraVideoCapturer$CameraStatistics cameraVideoCapturer$CameraStatistics) {
        int i = cameraVideoCapturer$CameraStatistics.freezePeriodCount + 1;
        cameraVideoCapturer$CameraStatistics.freezePeriodCount = i;
        return i;
    }

    public static /* synthetic */ CameraVideoCapturer$CameraEventsHandler access$200(CameraVideoCapturer$CameraStatistics cameraVideoCapturer$CameraStatistics) {
        return cameraVideoCapturer$CameraStatistics.eventsHandler;
    }

    public static /* synthetic */ SurfaceTextureHelper access$300(CameraVideoCapturer$CameraStatistics cameraVideoCapturer$CameraStatistics) {
        return cameraVideoCapturer$CameraStatistics.surfaceTextureHelper;
    }

    private void checkThread() {
        if (Thread.currentThread() != this.surfaceTextureHelper.getHandler().getLooper().getThread()) {
            throw new IllegalStateException("Wrong thread");
        }
    }

    public void addFrame() {
        checkThread();
        this.frameCount++;
    }

    public void release() {
        this.surfaceTextureHelper.getHandler().removeCallbacks(this.cameraObserver);
    }
}
