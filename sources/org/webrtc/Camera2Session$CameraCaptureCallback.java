package org.webrtc;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession$CaptureCallback;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;

/* JADX INFO: loaded from: classes3.dex */
public class Camera2Session$CameraCaptureCallback extends CameraCaptureSession$CaptureCallback {
    private Camera2Session$CameraCaptureCallback() {
    }

    @Override // android.hardware.camera2.CameraCaptureSession$CaptureCallback
    public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        Logging.d("Camera2Session", "Capture failed: " + captureFailure);
    }

    public /* synthetic */ Camera2Session$CameraCaptureCallback(Camera2Session$1 camera2Session$1) {
        this();
    }
}
