package b.o.a.n.o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: TimeoutAction.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class i extends d {
    public long e;
    public long f;
    public e g;

    public i(long j, @NonNull e eVar) {
        this.f = j;
        this.g = eVar;
    }

    @Override // b.o.a.n.o.d, b.o.a.n.o.e, b.o.a.n.o.a
    public void b(@NonNull c cVar, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.b(cVar, captureRequest, totalCaptureResult);
        if (g() || System.currentTimeMillis() <= this.e + this.f) {
            return;
        }
        this.g.a(cVar);
    }

    @Override // b.o.a.n.o.d, b.o.a.n.o.e
    public void j(@NonNull c cVar) {
        this.e = System.currentTimeMillis();
        super.j(cVar);
    }

    @Override // b.o.a.n.o.d
    @NonNull
    public e m() {
        return this.g;
    }
}
