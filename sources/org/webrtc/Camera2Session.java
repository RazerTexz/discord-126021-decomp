package org.webrtc;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import android.util.Range;
import android.view.Surface;
import androidx.annotation.Nullable;
import b.d.b.a.a;
import h0.c.l0;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
@TargetApi(21)
public class Camera2Session implements CameraSession {
    private static final String TAG = "Camera2Session";
    private final Context applicationContext;
    private final CameraSession$CreateSessionCallback callback;
    private CameraCharacteristics cameraCharacteristics;

    @Nullable
    private CameraDevice cameraDevice;
    private final String cameraId;
    private final CameraManager cameraManager;
    private int cameraOrientation;
    private final Handler cameraThreadHandler;
    private CameraEnumerationAndroid$CaptureFormat captureFormat;

    @Nullable
    private CameraCaptureSession captureSession;
    private final long constructionTimeNs;
    private final CameraSession$Events events;
    private boolean firstFrameReported;
    private int fpsUnitFactor;
    private final int framerate;
    private final int height;
    private boolean isCameraFrontFacing;
    private Camera2Session$SessionState state = Camera2Session$SessionState.RUNNING;

    @Nullable
    private Surface surface;
    private final SurfaceTextureHelper surfaceTextureHelper;
    private final int width;
    private static final Histogram camera2StartTimeMsHistogram = Histogram.createCounts("WebRTC.Android.Camera2.StartTimeMs", 1, 10000, 50);
    private static final Histogram camera2StopTimeMsHistogram = Histogram.createCounts("WebRTC.Android.Camera2.StopTimeMs", 1, 10000, 50);
    private static final Histogram camera2ResolutionHistogram = Histogram.createEnumeration("WebRTC.Android.Camera2.Resolution", CameraEnumerationAndroid.COMMON_RESOLUTIONS.size());

    private Camera2Session(CameraSession$CreateSessionCallback cameraSession$CreateSessionCallback, CameraSession$Events cameraSession$Events, Context context, CameraManager cameraManager, SurfaceTextureHelper surfaceTextureHelper, String str, int i, int i2, int i3) {
        Logging.d(TAG, "Create new camera2 session on camera " + str);
        this.constructionTimeNs = System.nanoTime();
        this.cameraThreadHandler = new Handler();
        this.callback = cameraSession$CreateSessionCallback;
        this.events = cameraSession$Events;
        this.applicationContext = context;
        this.cameraManager = cameraManager;
        this.surfaceTextureHelper = surfaceTextureHelper;
        this.cameraId = str;
        this.width = i;
        this.height = i2;
        this.framerate = i3;
        start();
    }

    public static /* synthetic */ void access$000(Camera2Session camera2Session) {
        camera2Session.checkIsOnCameraThread();
    }

    public static /* synthetic */ CameraCaptureSession access$100(Camera2Session camera2Session) {
        return camera2Session.captureSession;
    }

    public static /* synthetic */ Surface access$1000(Camera2Session camera2Session) {
        return camera2Session.surface;
    }

    public static /* synthetic */ Surface access$1002(Camera2Session camera2Session, Surface surface) {
        camera2Session.surface = surface;
        return surface;
    }

    public static /* synthetic */ CameraCaptureSession access$102(Camera2Session camera2Session, CameraCaptureSession cameraCaptureSession) {
        camera2Session.captureSession = cameraCaptureSession;
        return cameraCaptureSession;
    }

    public static /* synthetic */ Handler access$1200(Camera2Session camera2Session) {
        return camera2Session.cameraThreadHandler;
    }

    public static /* synthetic */ int access$1300(Camera2Session camera2Session) {
        return camera2Session.fpsUnitFactor;
    }

    public static /* synthetic */ CameraCharacteristics access$1500(Camera2Session camera2Session) {
        return camera2Session.cameraCharacteristics;
    }

    public static /* synthetic */ boolean access$1600(Camera2Session camera2Session) {
        return camera2Session.firstFrameReported;
    }

    public static /* synthetic */ boolean access$1602(Camera2Session camera2Session, boolean z2) {
        camera2Session.firstFrameReported = z2;
        return z2;
    }

    public static /* synthetic */ long access$1700(Camera2Session camera2Session) {
        return camera2Session.constructionTimeNs;
    }

    public static /* synthetic */ Histogram access$1800() {
        return camera2StartTimeMsHistogram;
    }

    public static /* synthetic */ boolean access$1900(Camera2Session camera2Session) {
        return camera2Session.isCameraFrontFacing;
    }

    public static /* synthetic */ Camera2Session$SessionState access$200(Camera2Session camera2Session) {
        return camera2Session.state;
    }

    public static /* synthetic */ int access$2000(Camera2Session camera2Session) {
        return camera2Session.cameraOrientation;
    }

    public static /* synthetic */ Camera2Session$SessionState access$202(Camera2Session camera2Session, Camera2Session$SessionState camera2Session$SessionState) {
        camera2Session.state = camera2Session$SessionState;
        return camera2Session$SessionState;
    }

    public static /* synthetic */ int access$2100(Camera2Session camera2Session) {
        return camera2Session.getFrameOrientation();
    }

    public static /* synthetic */ void access$300(Camera2Session camera2Session) {
        camera2Session.stopInternal();
    }

    public static /* synthetic */ CameraSession$CreateSessionCallback access$400(Camera2Session camera2Session) {
        return camera2Session.callback;
    }

    public static /* synthetic */ CameraSession$Events access$500(Camera2Session camera2Session) {
        return camera2Session.events;
    }

    public static /* synthetic */ void access$600(Camera2Session camera2Session, String str) {
        camera2Session.reportError(str);
    }

    public static /* synthetic */ CameraDevice access$700(Camera2Session camera2Session) {
        return camera2Session.cameraDevice;
    }

    public static /* synthetic */ CameraDevice access$702(Camera2Session camera2Session, CameraDevice cameraDevice) {
        camera2Session.cameraDevice = cameraDevice;
        return cameraDevice;
    }

    public static /* synthetic */ CameraEnumerationAndroid$CaptureFormat access$800(Camera2Session camera2Session) {
        return camera2Session.captureFormat;
    }

    public static /* synthetic */ SurfaceTextureHelper access$900(Camera2Session camera2Session) {
        return camera2Session.surfaceTextureHelper;
    }

    private void checkIsOnCameraThread() {
        if (Thread.currentThread() != this.cameraThreadHandler.getLooper().getThread()) {
            throw new IllegalStateException("Wrong thread");
        }
    }

    public static void create(CameraSession$CreateSessionCallback cameraSession$CreateSessionCallback, CameraSession$Events cameraSession$Events, Context context, CameraManager cameraManager, SurfaceTextureHelper surfaceTextureHelper, String str, int i, int i2, int i3) {
        new Camera2Session(cameraSession$CreateSessionCallback, cameraSession$Events, context, cameraManager, surfaceTextureHelper, str, i, i2, i3);
    }

    private void findCaptureFormat() {
        checkIsOnCameraThread();
        Range[] rangeArr = (Range[]) this.cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        int fpsUnitFactor = Camera2Enumerator.getFpsUnitFactor(rangeArr);
        this.fpsUnitFactor = fpsUnitFactor;
        List<CameraEnumerationAndroid$CaptureFormat$FramerateRange> listConvertFramerates = Camera2Enumerator.convertFramerates(rangeArr, fpsUnitFactor);
        List<Size> supportedSizes = Camera2Enumerator.getSupportedSizes(this.cameraCharacteristics);
        Logging.d(TAG, "Available preview sizes: " + supportedSizes);
        Logging.d(TAG, "Available fps ranges: " + listConvertFramerates);
        if (listConvertFramerates.isEmpty() || supportedSizes.isEmpty()) {
            reportError("No supported capture formats.");
            return;
        }
        CameraEnumerationAndroid$CaptureFormat$FramerateRange closestSupportedFramerateRange = CameraEnumerationAndroid.getClosestSupportedFramerateRange(listConvertFramerates, this.framerate);
        Size closestSupportedSize = CameraEnumerationAndroid.getClosestSupportedSize(supportedSizes, this.width, this.height);
        CameraEnumerationAndroid.reportCameraResolution(camera2ResolutionHistogram, closestSupportedSize);
        this.captureFormat = new CameraEnumerationAndroid$CaptureFormat(closestSupportedSize.width, closestSupportedSize.height, closestSupportedFramerateRange);
        StringBuilder sbU = a.U("Using capture format: ");
        sbU.append(this.captureFormat);
        Logging.d(TAG, sbU.toString());
    }

    private int getFrameOrientation() {
        int iB = l0.b(this.applicationContext);
        if (!this.isCameraFrontFacing) {
            iB = 360 - iB;
        }
        return (this.cameraOrientation + iB) % 360;
    }

    private void openCamera() {
        checkIsOnCameraThread();
        StringBuilder sbU = a.U("Opening camera ");
        sbU.append(this.cameraId);
        Logging.d(TAG, sbU.toString());
        this.events.onCameraOpening();
        try {
            this.cameraManager.openCamera(this.cameraId, new Camera2Session$CameraStateCallback(this, null), this.cameraThreadHandler);
        } catch (CameraAccessException e) {
            reportError("Failed to open camera: " + e);
        }
    }

    private void reportError(String str) {
        checkIsOnCameraThread();
        Logging.e(TAG, "Error: " + str);
        boolean z2 = this.captureSession == null && this.state != Camera2Session$SessionState.STOPPED;
        this.state = Camera2Session$SessionState.STOPPED;
        stopInternal();
        if (z2) {
            this.callback.onFailure(CameraSession$FailureType.ERROR, str);
        } else {
            this.events.onCameraError(this, str);
        }
    }

    private void start() {
        checkIsOnCameraThread();
        Logging.d(TAG, "start");
        try {
            CameraCharacteristics cameraCharacteristics = this.cameraManager.getCameraCharacteristics(this.cameraId);
            this.cameraCharacteristics = cameraCharacteristics;
            this.cameraOrientation = ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
            this.isCameraFrontFacing = ((Integer) this.cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
            findCaptureFormat();
            openCamera();
        } catch (CameraAccessException e) {
            StringBuilder sbU = a.U("getCameraCharacteristics(): ");
            sbU.append(e.getMessage());
            reportError(sbU.toString());
        }
    }

    private void stopInternal() {
        Logging.d(TAG, "Stop internal");
        checkIsOnCameraThread();
        this.surfaceTextureHelper.stopListening();
        CameraCaptureSession cameraCaptureSession = this.captureSession;
        if (cameraCaptureSession != null) {
            cameraCaptureSession.close();
            this.captureSession = null;
        }
        Surface surface = this.surface;
        if (surface != null) {
            surface.release();
            this.surface = null;
        }
        CameraDevice cameraDevice = this.cameraDevice;
        if (cameraDevice != null) {
            cameraDevice.close();
            this.cameraDevice = null;
        }
        Logging.d(TAG, "Stop done");
    }

    @Override // org.webrtc.CameraSession
    public void stop() {
        StringBuilder sbU = a.U("Stop camera2 session on camera ");
        sbU.append(this.cameraId);
        Logging.d(TAG, sbU.toString());
        checkIsOnCameraThread();
        Camera2Session$SessionState camera2Session$SessionState = this.state;
        Camera2Session$SessionState camera2Session$SessionState2 = Camera2Session$SessionState.STOPPED;
        if (camera2Session$SessionState != camera2Session$SessionState2) {
            long jNanoTime = System.nanoTime();
            this.state = camera2Session$SessionState2;
            stopInternal();
            camera2StopTimeMsHistogram.addSample((int) TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime));
        }
    }
}
