package org.webrtc;

import android.content.Context;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import b.d.b.a.a;
import h0.c.m0;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CameraCapturer implements CameraVideoCapturer {
    private static final int MAX_OPEN_CAMERA_ATTEMPTS = 3;
    private static final int OPEN_CAMERA_DELAY_MS = 500;
    private static final int OPEN_CAMERA_TIMEOUT = 10000;
    private static final String TAG = "CameraCapturer";
    private Context applicationContext;
    private final CameraEnumerator cameraEnumerator;
    private String cameraName;

    @Nullable
    private CameraVideoCapturer$CameraStatistics cameraStatistics;
    private Handler cameraThreadHandler;
    private CapturerObserver capturerObserver;

    @Nullable
    private CameraSession currentSession;
    private final CameraVideoCapturer$CameraEventsHandler eventsHandler;
    private boolean firstFrameObserved;
    private int framerate;
    private int height;
    private int openAttemptsRemaining;
    private String pendingCameraName;
    private boolean sessionOpening;
    private SurfaceTextureHelper surfaceHelper;

    @Nullable
    private CameraVideoCapturer$CameraSwitchHandler switchEventsHandler;
    private final Handler uiThreadHandler;
    private int width;

    @Nullable
    private final CameraSession$CreateSessionCallback createSessionCallback = new CameraCapturer$1(this);

    @Nullable
    private final CameraSession$Events cameraSessionEventsHandler = new CameraCapturer$2(this);
    private final Runnable openCameraTimeoutRunnable = new CameraCapturer$3(this);
    private final Object stateLock = new Object();
    private CameraCapturer$SwitchState switchState = CameraCapturer$SwitchState.IDLE;

    public CameraCapturer(String str, @Nullable CameraVideoCapturer$CameraEventsHandler cameraVideoCapturer$CameraEventsHandler, CameraEnumerator cameraEnumerator) {
        this.eventsHandler = cameraVideoCapturer$CameraEventsHandler == null ? new CameraCapturer$4(this) : cameraVideoCapturer$CameraEventsHandler;
        this.cameraEnumerator = cameraEnumerator;
        this.cameraName = str;
        List listAsList = Arrays.asList(cameraEnumerator.getDeviceNames());
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        if (listAsList.isEmpty()) {
            throw new RuntimeException("No cameras attached.");
        }
        if (!listAsList.contains(this.cameraName)) {
            throw new IllegalArgumentException(a.J(a.U("Camera name "), this.cameraName, " does not match any known camera device."));
        }
    }

    public static /* synthetic */ void access$000(CameraCapturer cameraCapturer) {
        cameraCapturer.checkIsOnCameraThread();
    }

    public static /* synthetic */ CameraCapturer$SwitchState access$100(CameraCapturer cameraCapturer) {
        return cameraCapturer.switchState;
    }

    public static /* synthetic */ CameraVideoCapturer$CameraEventsHandler access$1000(CameraCapturer cameraCapturer) {
        return cameraCapturer.eventsHandler;
    }

    public static /* synthetic */ CameraCapturer$SwitchState access$102(CameraCapturer cameraCapturer, CameraCapturer$SwitchState cameraCapturer$SwitchState) {
        cameraCapturer.switchState = cameraCapturer$SwitchState;
        return cameraCapturer$SwitchState;
    }

    public static /* synthetic */ boolean access$1100(CameraCapturer cameraCapturer) {
        return cameraCapturer.firstFrameObserved;
    }

    public static /* synthetic */ boolean access$1102(CameraCapturer cameraCapturer, boolean z2) {
        cameraCapturer.firstFrameObserved = z2;
        return z2;
    }

    public static /* synthetic */ CameraVideoCapturer$CameraSwitchHandler access$1200(CameraCapturer cameraCapturer) {
        return cameraCapturer.switchEventsHandler;
    }

    public static /* synthetic */ CameraVideoCapturer$CameraSwitchHandler access$1202(CameraCapturer cameraCapturer, CameraVideoCapturer$CameraSwitchHandler cameraVideoCapturer$CameraSwitchHandler) {
        cameraCapturer.switchEventsHandler = cameraVideoCapturer$CameraSwitchHandler;
        return cameraVideoCapturer$CameraSwitchHandler;
    }

    public static /* synthetic */ String access$1300(CameraCapturer cameraCapturer) {
        return cameraCapturer.cameraName;
    }

    public static /* synthetic */ CameraEnumerator access$1400(CameraCapturer cameraCapturer) {
        return cameraCapturer.cameraEnumerator;
    }

    public static /* synthetic */ String access$1500(CameraCapturer cameraCapturer) {
        return cameraCapturer.pendingCameraName;
    }

    public static /* synthetic */ String access$1502(CameraCapturer cameraCapturer, String str) {
        cameraCapturer.pendingCameraName = str;
        return str;
    }

    public static /* synthetic */ void access$1600(CameraCapturer cameraCapturer, CameraVideoCapturer$CameraSwitchHandler cameraVideoCapturer$CameraSwitchHandler, String str) {
        cameraCapturer.switchCameraInternal(cameraVideoCapturer$CameraSwitchHandler, str);
    }

    public static /* synthetic */ int access$1700(CameraCapturer cameraCapturer) {
        return cameraCapturer.openAttemptsRemaining;
    }

    public static /* synthetic */ int access$1710(CameraCapturer cameraCapturer) {
        int i = cameraCapturer.openAttemptsRemaining;
        cameraCapturer.openAttemptsRemaining = i - 1;
        return i;
    }

    public static /* synthetic */ void access$1800(CameraCapturer cameraCapturer, int i) {
        cameraCapturer.createSessionInternal(i);
    }

    public static /* synthetic */ CameraSession$CreateSessionCallback access$1900(CameraCapturer cameraCapturer) {
        return cameraCapturer.createSessionCallback;
    }

    public static /* synthetic */ Runnable access$200(CameraCapturer cameraCapturer) {
        return cameraCapturer.openCameraTimeoutRunnable;
    }

    public static /* synthetic */ CameraSession$Events access$2000(CameraCapturer cameraCapturer) {
        return cameraCapturer.cameraSessionEventsHandler;
    }

    public static /* synthetic */ Context access$2100(CameraCapturer cameraCapturer) {
        return cameraCapturer.applicationContext;
    }

    public static /* synthetic */ int access$2200(CameraCapturer cameraCapturer) {
        return cameraCapturer.width;
    }

    public static /* synthetic */ int access$2300(CameraCapturer cameraCapturer) {
        return cameraCapturer.height;
    }

    public static /* synthetic */ int access$2400(CameraCapturer cameraCapturer) {
        return cameraCapturer.framerate;
    }

    public static /* synthetic */ void access$2500(CameraCapturer cameraCapturer, String str, CameraVideoCapturer$CameraSwitchHandler cameraVideoCapturer$CameraSwitchHandler) {
        cameraCapturer.reportCameraSwitchError(str, cameraVideoCapturer$CameraSwitchHandler);
    }

    public static /* synthetic */ Handler access$300(CameraCapturer cameraCapturer) {
        return cameraCapturer.uiThreadHandler;
    }

    public static /* synthetic */ Object access$400(CameraCapturer cameraCapturer) {
        return cameraCapturer.stateLock;
    }

    public static /* synthetic */ CapturerObserver access$500(CameraCapturer cameraCapturer) {
        return cameraCapturer.capturerObserver;
    }

    public static /* synthetic */ boolean access$602(CameraCapturer cameraCapturer, boolean z2) {
        cameraCapturer.sessionOpening = z2;
        return z2;
    }

    public static /* synthetic */ CameraSession access$700(CameraCapturer cameraCapturer) {
        return cameraCapturer.currentSession;
    }

    public static /* synthetic */ CameraSession access$702(CameraCapturer cameraCapturer, CameraSession cameraSession) {
        cameraCapturer.currentSession = cameraSession;
        return cameraSession;
    }

    public static /* synthetic */ CameraVideoCapturer$CameraStatistics access$800(CameraCapturer cameraCapturer) {
        return cameraCapturer.cameraStatistics;
    }

    public static /* synthetic */ CameraVideoCapturer$CameraStatistics access$802(CameraCapturer cameraCapturer, CameraVideoCapturer$CameraStatistics cameraVideoCapturer$CameraStatistics) {
        cameraCapturer.cameraStatistics = cameraVideoCapturer$CameraStatistics;
        return cameraVideoCapturer$CameraStatistics;
    }

    public static /* synthetic */ SurfaceTextureHelper access$900(CameraCapturer cameraCapturer) {
        return cameraCapturer.surfaceHelper;
    }

    private void checkIsOnCameraThread() {
        if (Thread.currentThread() == this.cameraThreadHandler.getLooper().getThread()) {
            return;
        }
        Logging.e(TAG, "Check is on camera thread failed.");
        throw new RuntimeException("Not on camera thread.");
    }

    private void createSessionInternal(int i) {
        this.uiThreadHandler.postDelayed(this.openCameraTimeoutRunnable, i + OPEN_CAMERA_TIMEOUT);
        this.cameraThreadHandler.postDelayed(new CameraCapturer$5(this), i);
    }

    private void reportCameraSwitchError(String str, @Nullable CameraVideoCapturer$CameraSwitchHandler cameraVideoCapturer$CameraSwitchHandler) {
        Logging.e(TAG, str);
        if (cameraVideoCapturer$CameraSwitchHandler != null) {
            cameraVideoCapturer$CameraSwitchHandler.onCameraSwitchError(str);
        }
    }

    private void switchCameraInternal(@Nullable CameraVideoCapturer$CameraSwitchHandler cameraVideoCapturer$CameraSwitchHandler, String str) {
        Logging.d(TAG, "switchCamera internal");
        if (!Arrays.asList(this.cameraEnumerator.getDeviceNames()).contains(str)) {
            reportCameraSwitchError(a.w("Attempted to switch to unknown camera device ", str), cameraVideoCapturer$CameraSwitchHandler);
            return;
        }
        synchronized (this.stateLock) {
            if (this.switchState != CameraCapturer$SwitchState.IDLE) {
                reportCameraSwitchError("Camera switch already in progress.", cameraVideoCapturer$CameraSwitchHandler);
                return;
            }
            boolean z2 = this.sessionOpening;
            if (!z2 && this.currentSession == null) {
                reportCameraSwitchError("switchCamera: camera is not running.", cameraVideoCapturer$CameraSwitchHandler);
                return;
            }
            this.switchEventsHandler = cameraVideoCapturer$CameraSwitchHandler;
            if (z2) {
                this.switchState = CameraCapturer$SwitchState.PENDING;
                this.pendingCameraName = str;
                return;
            }
            this.switchState = CameraCapturer$SwitchState.IN_PROGRESS;
            Logging.d(TAG, "switchCamera: Stopping session");
            this.cameraStatistics.release();
            this.cameraStatistics = null;
            this.cameraThreadHandler.post(new CameraCapturer$9(this, this.currentSession));
            this.currentSession = null;
            this.cameraName = str;
            this.sessionOpening = true;
            this.openAttemptsRemaining = 1;
            createSessionInternal(0);
            Logging.d(TAG, "switchCamera done");
        }
    }

    @Override // org.webrtc.CameraVideoCapturer
    public /* synthetic */ void addMediaRecorderToCamera(MediaRecorder mediaRecorder, CameraVideoCapturer$MediaRecorderHandler cameraVideoCapturer$MediaRecorderHandler) {
        m0.a(this, mediaRecorder, cameraVideoCapturer$MediaRecorderHandler);
    }

    @Override // org.webrtc.VideoCapturer
    public void changeCaptureFormat(int i, int i2, int i3) {
        StringBuilder sbW = a.W("changeCaptureFormat: ", i, "x", i2, "@");
        sbW.append(i3);
        Logging.d(TAG, sbW.toString());
        synchronized (this.stateLock) {
            stopCapture();
            startCapture(i, i2, i3);
        }
    }

    public abstract void createCameraSession(CameraSession$CreateSessionCallback cameraSession$CreateSessionCallback, CameraSession$Events cameraSession$Events, Context context, SurfaceTextureHelper surfaceTextureHelper, String str, int i, int i2, int i3);

    @Override // org.webrtc.VideoCapturer
    public void dispose() {
        Logging.d(TAG, "dispose");
        stopCapture();
    }

    public String getCameraName() {
        String str;
        synchronized (this.stateLock) {
            str = this.cameraName;
        }
        return str;
    }

    @Override // org.webrtc.VideoCapturer
    public void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver) {
        this.applicationContext = context;
        this.capturerObserver = capturerObserver;
        this.surfaceHelper = surfaceTextureHelper;
        this.cameraThreadHandler = surfaceTextureHelper.getHandler();
    }

    @Override // org.webrtc.VideoCapturer
    public boolean isScreencast() {
        return false;
    }

    public void printStackTrace() {
        Handler handler = this.cameraThreadHandler;
        Thread thread = handler != null ? handler.getLooper().getThread() : null;
        if (thread != null) {
            StackTraceElement[] stackTrace = thread.getStackTrace();
            if (stackTrace.length > 0) {
                Logging.d(TAG, "CameraCapturer stack trace:");
                for (StackTraceElement stackTraceElement : stackTrace) {
                    Logging.d(TAG, stackTraceElement.toString());
                }
            }
        }
    }

    @Override // org.webrtc.CameraVideoCapturer
    public /* synthetic */ void removeMediaRecorderFromCamera(CameraVideoCapturer$MediaRecorderHandler cameraVideoCapturer$MediaRecorderHandler) {
        m0.b(this, cameraVideoCapturer$MediaRecorderHandler);
    }

    @Override // org.webrtc.VideoCapturer
    public void startCapture(int i, int i2, int i3) {
        StringBuilder sbW = a.W("startCapture: ", i, "x", i2, "@");
        sbW.append(i3);
        Logging.d(TAG, sbW.toString());
        if (this.applicationContext == null) {
            throw new RuntimeException("CameraCapturer must be initialized before calling startCapture.");
        }
        synchronized (this.stateLock) {
            if (!this.sessionOpening && this.currentSession == null) {
                this.width = i;
                this.height = i2;
                this.framerate = i3;
                this.sessionOpening = true;
                this.openAttemptsRemaining = 3;
                createSessionInternal(0);
                return;
            }
            Logging.w(TAG, "Session already open");
        }
    }

    @Override // org.webrtc.VideoCapturer
    public void stopCapture() {
        Logging.d(TAG, "Stop capture");
        synchronized (this.stateLock) {
            while (this.sessionOpening) {
                Logging.d(TAG, "Stop capture: Waiting for session to open");
                try {
                    this.stateLock.wait();
                } catch (InterruptedException unused) {
                    Logging.w(TAG, "Stop capture interrupted while waiting for the session to open.");
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if (this.currentSession != null) {
                Logging.d(TAG, "Stop capture: Nulling session");
                this.cameraStatistics.release();
                this.cameraStatistics = null;
                this.cameraThreadHandler.post(new CameraCapturer$6(this, this.currentSession));
                this.currentSession = null;
                this.capturerObserver.onCapturerStopped();
            } else {
                Logging.d(TAG, "Stop capture: No session open");
            }
        }
        Logging.d(TAG, "Stop capture done");
    }

    @Override // org.webrtc.CameraVideoCapturer
    public void switchCamera(CameraVideoCapturer$CameraSwitchHandler cameraVideoCapturer$CameraSwitchHandler) {
        Logging.d(TAG, "switchCamera");
        this.cameraThreadHandler.post(new CameraCapturer$7(this, cameraVideoCapturer$CameraSwitchHandler));
    }

    @Override // org.webrtc.CameraVideoCapturer
    public void switchCamera(CameraVideoCapturer$CameraSwitchHandler cameraVideoCapturer$CameraSwitchHandler, String str) {
        Logging.d(TAG, "switchCamera");
        this.cameraThreadHandler.post(new CameraCapturer$8(this, cameraVideoCapturer$CameraSwitchHandler, str));
    }
}
