package org.webrtc;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession$StateCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest$Builder;
import android.util.Range;
import h0.c.d;
import h0.c.l0;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class Camera2Session$CaptureSessionCallback extends CameraCaptureSession$StateCallback {
    public final /* synthetic */ Camera2Session this$0;

    private Camera2Session$CaptureSessionCallback(Camera2Session camera2Session) {
        this.this$0 = camera2Session;
    }

    private void chooseFocusMode(CaptureRequest$Builder captureRequest$Builder) {
        for (int i : (int[]) Camera2Session.access$1500(this.this$0).get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES)) {
            if (i == 3) {
                captureRequest$Builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
                Logging.d("Camera2Session", "Using continuous video auto-focus.");
                return;
            }
        }
        Logging.d("Camera2Session", "Auto-focus is not available.");
    }

    private void chooseStabilizationMode(CaptureRequest$Builder captureRequest$Builder) {
        int[] iArr = (int[]) Camera2Session.access$1500(this.this$0).get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
        if (iArr != null) {
            for (int i : iArr) {
                if (i == 1) {
                    captureRequest$Builder.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, 1);
                    captureRequest$Builder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 0);
                    Logging.d("Camera2Session", "Using optical stabilization.");
                    return;
                }
            }
        }
        for (int i2 : (int[]) Camera2Session.access$1500(this.this$0).get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES)) {
            if (i2 == 1) {
                captureRequest$Builder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 1);
                captureRequest$Builder.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, 0);
                Logging.d("Camera2Session", "Using video stabilization.");
                return;
            }
        }
        Logging.d("Camera2Session", "Stabilization not available.");
    }

    private /* synthetic */ void lambda$onConfigured$0(VideoFrame videoFrame) {
        Camera2Session.access$000(this.this$0);
        if (Camera2Session.access$200(this.this$0) != Camera2Session$SessionState.RUNNING) {
            Logging.d("Camera2Session", "Texture frame captured but camera is no longer running.");
            return;
        }
        if (!Camera2Session.access$1600(this.this$0)) {
            Camera2Session.access$1602(this.this$0, true);
            Camera2Session.access$1800().addSample((int) TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - Camera2Session.access$1700(this.this$0)));
        }
        VideoFrame videoFrame2 = new VideoFrame(l0.a((TextureBufferImpl) videoFrame.getBuffer(), Camera2Session.access$1900(this.this$0), -Camera2Session.access$2000(this.this$0)), Camera2Session.access$2100(this.this$0), videoFrame.getTimestampNs());
        Camera2Session.access$500(this.this$0).onFrameCaptured(this.this$0, videoFrame2);
        videoFrame2.release();
    }

    public /* synthetic */ void a(VideoFrame videoFrame) {
        lambda$onConfigured$0(videoFrame);
    }

    @Override // android.hardware.camera2.CameraCaptureSession$StateCallback
    public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        Camera2Session.access$000(this.this$0);
        cameraCaptureSession.close();
        Camera2Session.access$600(this.this$0, "Failed to configure capture session.");
    }

    @Override // android.hardware.camera2.CameraCaptureSession$StateCallback
    public void onConfigured(CameraCaptureSession cameraCaptureSession) {
        Camera2Session.access$000(this.this$0);
        Logging.d("Camera2Session", "Camera capture session configured.");
        Camera2Session.access$102(this.this$0, cameraCaptureSession);
        try {
            CaptureRequest$Builder captureRequest$BuilderCreateCaptureRequest = Camera2Session.access$700(this.this$0).createCaptureRequest(3);
            captureRequest$BuilderCreateCaptureRequest.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, new Range(Integer.valueOf(Camera2Session.access$800(this.this$0).framerate.min / Camera2Session.access$1300(this.this$0)), Integer.valueOf(Camera2Session.access$800(this.this$0).framerate.max / Camera2Session.access$1300(this.this$0))));
            captureRequest$BuilderCreateCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, 1);
            captureRequest$BuilderCreateCaptureRequest.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.FALSE);
            chooseStabilizationMode(captureRequest$BuilderCreateCaptureRequest);
            chooseFocusMode(captureRequest$BuilderCreateCaptureRequest);
            captureRequest$BuilderCreateCaptureRequest.addTarget(Camera2Session.access$1000(this.this$0));
            cameraCaptureSession.setRepeatingRequest(captureRequest$BuilderCreateCaptureRequest.build(), new Camera2Session$CameraCaptureCallback(null), Camera2Session.access$1200(this.this$0));
            Camera2Session.access$900(this.this$0).startListening(new d(this));
            Logging.d("Camera2Session", "Camera device successfully started.");
            Camera2Session.access$400(this.this$0).onDone(this.this$0);
        } catch (CameraAccessException e) {
            Camera2Session.access$600(this.this$0, "Failed to start capture request. " + e);
        }
    }

    public /* synthetic */ Camera2Session$CaptureSessionCallback(Camera2Session camera2Session, Camera2Session$1 camera2Session$1) {
        this(camera2Session);
    }
}
