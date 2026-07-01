package org.webrtc;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera$CameraInfo;
import android.hardware.Camera$Parameters;
import android.os.Handler;
import b.d.b.a.a;
import h0.c.c;
import h0.c.l0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class Camera1Session implements CameraSession {
    private static final int NUMBER_OF_CAPTURE_BUFFERS = 3;
    private static final String TAG = "Camera1Session";
    private final Context applicationContext;
    private final Camera camera;
    private final int cameraId;
    private final Handler cameraThreadHandler;
    private final CameraEnumerationAndroid$CaptureFormat captureFormat;
    private final boolean captureToTexture;
    private final long constructionTimeNs;
    private final CameraSession$Events events;
    private boolean firstFrameReported;
    private final Camera$CameraInfo info;
    private Camera1Session$SessionState state;
    private final SurfaceTextureHelper surfaceTextureHelper;
    private static final Histogram camera1StartTimeMsHistogram = Histogram.createCounts("WebRTC.Android.Camera1.StartTimeMs", 1, 10000, 50);
    private static final Histogram camera1StopTimeMsHistogram = Histogram.createCounts("WebRTC.Android.Camera1.StopTimeMs", 1, 10000, 50);
    private static final Histogram camera1ResolutionHistogram = Histogram.createEnumeration("WebRTC.Android.Camera1.Resolution", CameraEnumerationAndroid.COMMON_RESOLUTIONS.size());

    private Camera1Session(CameraSession$Events cameraSession$Events, boolean z2, Context context, SurfaceTextureHelper surfaceTextureHelper, int i, Camera camera, Camera$CameraInfo camera$CameraInfo, CameraEnumerationAndroid$CaptureFormat cameraEnumerationAndroid$CaptureFormat, long j) {
        Logging.d(TAG, "Create new camera1 session on camera " + i);
        this.cameraThreadHandler = new Handler();
        this.events = cameraSession$Events;
        this.captureToTexture = z2;
        this.applicationContext = context;
        this.surfaceTextureHelper = surfaceTextureHelper;
        this.cameraId = i;
        this.camera = camera;
        this.info = camera$CameraInfo;
        this.captureFormat = cameraEnumerationAndroid$CaptureFormat;
        this.constructionTimeNs = j;
        surfaceTextureHelper.setTextureSize(cameraEnumerationAndroid$CaptureFormat.width, cameraEnumerationAndroid$CaptureFormat.height);
        startCapturing();
    }

    public static /* synthetic */ void access$000(Camera1Session camera1Session) {
        camera1Session.stopInternal();
    }

    public static /* synthetic */ CameraSession$Events access$100(Camera1Session camera1Session) {
        return camera1Session.events;
    }

    public static /* synthetic */ Handler access$1000(Camera1Session camera1Session) {
        return camera1Session.cameraThreadHandler;
    }

    public static /* synthetic */ void access$200(Camera1Session camera1Session) {
        camera1Session.checkIsOnCameraThread();
    }

    public static /* synthetic */ Camera access$300(Camera1Session camera1Session) {
        return camera1Session.camera;
    }

    public static /* synthetic */ Camera1Session$SessionState access$400(Camera1Session camera1Session) {
        return camera1Session.state;
    }

    public static /* synthetic */ boolean access$500(Camera1Session camera1Session) {
        return camera1Session.firstFrameReported;
    }

    public static /* synthetic */ boolean access$502(Camera1Session camera1Session, boolean z2) {
        camera1Session.firstFrameReported = z2;
        return z2;
    }

    public static /* synthetic */ long access$600(Camera1Session camera1Session) {
        return camera1Session.constructionTimeNs;
    }

    public static /* synthetic */ Histogram access$700() {
        return camera1StartTimeMsHistogram;
    }

    public static /* synthetic */ CameraEnumerationAndroid$CaptureFormat access$800(Camera1Session camera1Session) {
        return camera1Session.captureFormat;
    }

    public static /* synthetic */ int access$900(Camera1Session camera1Session) {
        return camera1Session.getFrameOrientation();
    }

    private static void cameraReleaseSafe(Camera camera) {
        try {
            camera.release();
        } catch (RuntimeException unused) {
        }
    }

    private void checkIsOnCameraThread() {
        if (Thread.currentThread() != this.cameraThreadHandler.getLooper().getThread()) {
            throw new IllegalStateException("Wrong thread");
        }
    }

    public static void create(CameraSession$CreateSessionCallback cameraSession$CreateSessionCallback, CameraSession$Events cameraSession$Events, boolean z2, Context context, SurfaceTextureHelper surfaceTextureHelper, int i, int i2, int i3, int i4) {
        long jNanoTime = System.nanoTime();
        Logging.d(TAG, "Open camera " + i);
        cameraSession$Events.onCameraOpening();
        try {
            Camera cameraOpen = Camera.open(i);
            if (cameraOpen == null) {
                cameraSession$CreateSessionCallback.onFailure(CameraSession$FailureType.ERROR, "android.hardware.Camera.open returned null for camera id = " + i);
                return;
            }
            try {
                cameraOpen.setPreviewTexture(surfaceTextureHelper.getSurfaceTexture());
                Camera$CameraInfo camera$CameraInfo = new Camera$CameraInfo();
                Camera.getCameraInfo(i, camera$CameraInfo);
                try {
                    Camera$Parameters parameters = cameraOpen.getParameters();
                    CameraEnumerationAndroid$CaptureFormat cameraEnumerationAndroid$CaptureFormatFindClosestCaptureFormat = findClosestCaptureFormat(parameters, i2, i3, i4);
                    updateCameraParameters(cameraOpen, parameters, cameraEnumerationAndroid$CaptureFormatFindClosestCaptureFormat, findClosestPictureSize(parameters, i2, i3), z2);
                    if (!z2) {
                        int iFrameSize = cameraEnumerationAndroid$CaptureFormatFindClosestCaptureFormat.frameSize();
                        for (int i5 = 0; i5 < 3; i5++) {
                            cameraOpen.addCallbackBuffer(ByteBuffer.allocateDirect(iFrameSize).array());
                        }
                    }
                    cameraOpen.setDisplayOrientation(0);
                    cameraSession$CreateSessionCallback.onDone(new Camera1Session(cameraSession$Events, z2, context, surfaceTextureHelper, i, cameraOpen, camera$CameraInfo, cameraEnumerationAndroid$CaptureFormatFindClosestCaptureFormat, jNanoTime));
                } catch (RuntimeException e) {
                    cameraReleaseSafe(cameraOpen);
                    cameraSession$CreateSessionCallback.onFailure(CameraSession$FailureType.ERROR, e.getMessage());
                }
            } catch (IOException | RuntimeException e2) {
                cameraReleaseSafe(cameraOpen);
                cameraSession$CreateSessionCallback.onFailure(CameraSession$FailureType.ERROR, e2.getMessage());
            }
        } catch (RuntimeException e3) {
            cameraSession$CreateSessionCallback.onFailure(CameraSession$FailureType.ERROR, e3.getMessage());
        }
    }

    private static CameraEnumerationAndroid$CaptureFormat findClosestCaptureFormat(Camera$Parameters camera$Parameters, int i, int i2, int i3) {
        List<CameraEnumerationAndroid$CaptureFormat$FramerateRange> listConvertFramerates = Camera1Enumerator.convertFramerates(camera$Parameters.getSupportedPreviewFpsRange());
        Logging.d(TAG, "Available fps ranges: " + listConvertFramerates);
        CameraEnumerationAndroid$CaptureFormat$FramerateRange closestSupportedFramerateRange = CameraEnumerationAndroid.getClosestSupportedFramerateRange(listConvertFramerates, i3);
        Size closestSupportedSize = CameraEnumerationAndroid.getClosestSupportedSize(Camera1Enumerator.convertSizes(camera$Parameters.getSupportedPreviewSizes()), i, i2);
        CameraEnumerationAndroid.reportCameraResolution(camera1ResolutionHistogram, closestSupportedSize);
        return new CameraEnumerationAndroid$CaptureFormat(closestSupportedSize.width, closestSupportedSize.height, closestSupportedFramerateRange);
    }

    private static Size findClosestPictureSize(Camera$Parameters camera$Parameters, int i, int i2) {
        return CameraEnumerationAndroid.getClosestSupportedSize(Camera1Enumerator.convertSizes(camera$Parameters.getSupportedPictureSizes()), i, i2);
    }

    private int getFrameOrientation() {
        int iB = l0.b(this.applicationContext);
        Camera$CameraInfo camera$CameraInfo = this.info;
        if (camera$CameraInfo.facing == 0) {
            iB = 360 - iB;
        }
        return (camera$CameraInfo.orientation + iB) % 360;
    }

    private /* synthetic */ void lambda$listenForTextureFrames$0(VideoFrame videoFrame) {
        checkIsOnCameraThread();
        if (this.state != Camera1Session$SessionState.RUNNING) {
            Logging.d(TAG, "Texture frame captured but camera is no longer running.");
            return;
        }
        if (!this.firstFrameReported) {
            camera1StartTimeMsHistogram.addSample((int) TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.constructionTimeNs));
            this.firstFrameReported = true;
        }
        VideoFrame videoFrame2 = new VideoFrame(l0.a((TextureBufferImpl) videoFrame.getBuffer(), this.info.facing == 1, 0), getFrameOrientation(), videoFrame.getTimestampNs());
        this.events.onFrameCaptured(this, videoFrame2);
        videoFrame2.release();
    }

    private void listenForBytebufferFrames() {
        this.camera.setPreviewCallbackWithBuffer(new Camera1Session$2(this));
    }

    private void listenForTextureFrames() {
        this.surfaceTextureHelper.startListening(new c(this));
    }

    private void startCapturing() {
        Logging.d(TAG, "Start capturing");
        checkIsOnCameraThread();
        this.state = Camera1Session$SessionState.RUNNING;
        this.camera.setErrorCallback(new Camera1Session$1(this));
        if (this.captureToTexture) {
            listenForTextureFrames();
        } else {
            listenForBytebufferFrames();
        }
        try {
            this.camera.startPreview();
        } catch (RuntimeException e) {
            stopInternal();
            this.events.onCameraError(this, e.getMessage());
        }
    }

    private void stopInternal() {
        Logging.d(TAG, "Stop internal");
        checkIsOnCameraThread();
        Camera1Session$SessionState camera1Session$SessionState = this.state;
        Camera1Session$SessionState camera1Session$SessionState2 = Camera1Session$SessionState.STOPPED;
        if (camera1Session$SessionState == camera1Session$SessionState2) {
            Logging.d(TAG, "Camera is already stopped");
            return;
        }
        this.state = camera1Session$SessionState2;
        this.surfaceTextureHelper.stopListening();
        this.camera.stopPreview();
        cameraReleaseSafe(this.camera);
        this.events.onCameraClosed(this);
        Logging.d(TAG, "Stop done");
    }

    private static void updateCameraParameters(Camera camera, Camera$Parameters camera$Parameters, CameraEnumerationAndroid$CaptureFormat cameraEnumerationAndroid$CaptureFormat, Size size, boolean z2) {
        List<String> supportedFocusModes = camera$Parameters.getSupportedFocusModes();
        CameraEnumerationAndroid$CaptureFormat$FramerateRange cameraEnumerationAndroid$CaptureFormat$FramerateRange = cameraEnumerationAndroid$CaptureFormat.framerate;
        camera$Parameters.setPreviewFpsRange(cameraEnumerationAndroid$CaptureFormat$FramerateRange.min, cameraEnumerationAndroid$CaptureFormat$FramerateRange.max);
        camera$Parameters.setPreviewSize(cameraEnumerationAndroid$CaptureFormat.width, cameraEnumerationAndroid$CaptureFormat.height);
        camera$Parameters.setPictureSize(size.width, size.height);
        if (!z2) {
            camera$Parameters.setPreviewFormat(17);
        }
        if (camera$Parameters.isVideoStabilizationSupported()) {
            camera$Parameters.setVideoStabilization(true);
        }
        if (supportedFocusModes.contains("continuous-video")) {
            camera$Parameters.setFocusMode("continuous-video");
        }
        camera.setParameters(camera$Parameters);
    }

    public /* synthetic */ void a(VideoFrame videoFrame) {
        lambda$listenForTextureFrames$0(videoFrame);
    }

    @Override // org.webrtc.CameraSession
    public void stop() {
        StringBuilder sbU = a.U("Stop camera1 session on camera ");
        sbU.append(this.cameraId);
        Logging.d(TAG, sbU.toString());
        checkIsOnCameraThread();
        if (this.state != Camera1Session$SessionState.STOPPED) {
            long jNanoTime = System.nanoTime();
            stopInternal();
            camera1StopTimeMsHistogram.addSample((int) TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime));
        }
    }
}
