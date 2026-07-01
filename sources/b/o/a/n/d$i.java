package b.o.a.n;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession$CaptureCallback;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import java.util.Iterator;

/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$i extends CameraCaptureSession$CaptureCallback {
    public final /* synthetic */ d a;

    public d$i(d dVar) {
        this.a = dVar;
    }

    @Override // android.hardware.camera2.CameraCaptureSession$CaptureCallback
    public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        d dVar = this.a;
        dVar.f1922j0 = totalCaptureResult;
        Iterator<b.o.a.n.o.a> it = dVar.p0.iterator();
        while (it.hasNext()) {
            it.next().b(this.a, captureRequest, totalCaptureResult);
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession$CaptureCallback
    public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        Iterator<b.o.a.n.o.a> it = this.a.p0.iterator();
        while (it.hasNext()) {
            it.next().d(this.a, captureRequest, captureResult);
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession$CaptureCallback
    public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j, long j2) {
        Iterator<b.o.a.n.o.a> it = this.a.p0.iterator();
        while (it.hasNext()) {
            it.next().c(this.a, captureRequest);
        }
    }
}
