package b.o.a.n.o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: ActionWrapper.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public abstract class d extends e {
    @Override // b.o.a.n.o.e, b.o.a.n.o.a
    public void b(@NonNull c cVar, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        m().b(cVar, captureRequest, totalCaptureResult);
    }

    @Override // b.o.a.n.o.e, b.o.a.n.o.a
    public void c(@NonNull c cVar, @NonNull CaptureRequest captureRequest) {
        if (this.d) {
            j(cVar);
            this.d = false;
        }
        m().c(cVar, captureRequest);
    }

    @Override // b.o.a.n.o.e, b.o.a.n.o.a
    public void d(@NonNull c cVar, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        m().d(cVar, captureRequest, captureResult);
    }

    @Override // b.o.a.n.o.e
    public void h(@NonNull c cVar) {
        m().h(cVar);
    }

    @Override // b.o.a.n.o.e
    public void j(@NonNull c cVar) {
        this.c = cVar;
        m().f(new d$a(this));
        m().j(cVar);
    }

    @NonNull
    public abstract e m();
}
