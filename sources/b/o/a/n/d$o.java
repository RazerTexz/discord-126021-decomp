package b.o.a.n;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession$StateCallback;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.otaliastudios.cameraview.CameraException;

/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$o extends CameraCaptureSession$StateCallback {
    public final /* synthetic */ TaskCompletionSource a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f1925b;

    public d$o(d dVar, TaskCompletionSource taskCompletionSource) {
        this.f1925b = dVar;
        this.a = taskCompletionSource;
    }

    @Override // android.hardware.camera2.CameraCaptureSession$StateCallback
    public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
        RuntimeException runtimeException = new RuntimeException(i.j.a(3, "onConfigureFailed! Session", cameraCaptureSession));
        if (this.a.a.o()) {
            throw new CameraException(3);
        }
        this.a.a(new CameraException(runtimeException, 2));
    }

    @Override // android.hardware.camera2.CameraCaptureSession$StateCallback
    public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
        this.f1925b.f1920h0 = cameraCaptureSession;
        i.j.a(1, "onStartBind:", "Completed");
        this.a.b(null);
    }

    @Override // android.hardware.camera2.CameraCaptureSession$StateCallback
    public void onReady(@NonNull CameraCaptureSession cameraCaptureSession) {
        super.onReady(cameraCaptureSession);
        i.j.a(1, "CameraCaptureSession.StateCallback reported onReady.");
    }
}
