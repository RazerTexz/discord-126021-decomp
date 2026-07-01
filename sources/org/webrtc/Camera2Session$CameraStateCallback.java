package org.webrtc;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice$StateCallback;
import android.view.Surface;
import b.d.b.a.a;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class Camera2Session$CameraStateCallback extends CameraDevice$StateCallback {
    public final /* synthetic */ Camera2Session this$0;

    private Camera2Session$CameraStateCallback(Camera2Session camera2Session) {
        this.this$0 = camera2Session;
    }

    private String getErrorDescription(int i) {
        if (i == 1) {
            return "Camera device is in use already.";
        }
        if (i == 2) {
            return "Camera device could not be opened because there are too many other open camera devices.";
        }
        if (i == 3) {
            return "Camera device could not be opened due to a device policy.";
        }
        if (i != 4) {
            return i != 5 ? a.q("Unknown camera error: ", i) : "Camera service has encountered a fatal error.";
        }
        return "Camera device has encountered a fatal error.";
    }

    @Override // android.hardware.camera2.CameraDevice$StateCallback
    public void onClosed(CameraDevice cameraDevice) {
        Camera2Session.access$000(this.this$0);
        Logging.d("Camera2Session", "Camera device closed.");
        Camera2Session.access$500(this.this$0).onCameraClosed(this.this$0);
    }

    @Override // android.hardware.camera2.CameraDevice$StateCallback
    public void onDisconnected(CameraDevice cameraDevice) {
        Camera2Session.access$000(this.this$0);
        boolean z2 = Camera2Session.access$100(this.this$0) == null && Camera2Session.access$200(this.this$0) != Camera2Session$SessionState.STOPPED;
        Camera2Session.access$202(this.this$0, Camera2Session$SessionState.STOPPED);
        Camera2Session.access$300(this.this$0);
        if (z2) {
            Camera2Session.access$400(this.this$0).onFailure(CameraSession$FailureType.DISCONNECTED, "Camera disconnected / evicted.");
        } else {
            Camera2Session.access$500(this.this$0).onCameraDisconnected(this.this$0);
        }
    }

    @Override // android.hardware.camera2.CameraDevice$StateCallback
    public void onError(CameraDevice cameraDevice, int i) {
        Camera2Session.access$000(this.this$0);
        Camera2Session.access$600(this.this$0, getErrorDescription(i));
    }

    @Override // android.hardware.camera2.CameraDevice$StateCallback
    public void onOpened(CameraDevice cameraDevice) {
        Camera2Session.access$000(this.this$0);
        Logging.d("Camera2Session", "Camera opened.");
        Camera2Session.access$702(this.this$0, cameraDevice);
        Camera2Session.access$900(this.this$0).setTextureSize(Camera2Session.access$800(this.this$0).width, Camera2Session.access$800(this.this$0).height);
        Camera2Session.access$1002(this.this$0, new Surface(Camera2Session.access$900(this.this$0).getSurfaceTexture()));
        try {
            cameraDevice.createCaptureSession(Arrays.asList(Camera2Session.access$1000(this.this$0)), new Camera2Session$CaptureSessionCallback(this.this$0, null), Camera2Session.access$1200(this.this$0));
        } catch (CameraAccessException e) {
            Camera2Session.access$600(this.this$0, "Failed to create capture session. " + e);
        }
    }

    public /* synthetic */ Camera2Session$CameraStateCallback(Camera2Session camera2Session, Camera2Session$1 camera2Session$1) {
        this(camera2Session);
    }
}
