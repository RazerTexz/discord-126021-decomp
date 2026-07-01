package b.o.a.n.o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: compiled from: SequenceAction.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class h extends e {
    public final List<e> e;
    public int f = -1;

    public h(@NonNull List<e> list) {
        this.e = list;
        m();
    }

    @Override // b.o.a.n.o.e, b.o.a.n.o.a
    public void b(@NonNull c cVar, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        int i = this.f;
        if (i >= 0) {
            this.e.get(i).b(cVar, captureRequest, totalCaptureResult);
        }
    }

    @Override // b.o.a.n.o.e, b.o.a.n.o.a
    public void c(@NonNull c cVar, @NonNull CaptureRequest captureRequest) {
        if (this.d) {
            j(cVar);
            this.d = false;
        }
        int i = this.f;
        if (i >= 0) {
            this.e.get(i).c(cVar, captureRequest);
        }
    }

    @Override // b.o.a.n.o.e, b.o.a.n.o.a
    public void d(@NonNull c cVar, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        int i = this.f;
        if (i >= 0) {
            this.e.get(i).d(cVar, captureRequest, captureResult);
        }
    }

    @Override // b.o.a.n.o.e
    public void h(@NonNull c cVar) {
        int i = this.f;
        if (i >= 0) {
            this.e.get(i).h(cVar);
        }
    }

    @Override // b.o.a.n.o.e
    public void j(@NonNull c cVar) {
        this.c = cVar;
        int i = this.f;
        if (i >= 0) {
            this.e.get(i).j(cVar);
        }
    }

    public final void m() {
        int i = this.f;
        boolean z2 = i == -1;
        if (i == this.e.size() - 1) {
            l(Integer.MAX_VALUE);
            return;
        }
        int i2 = this.f + 1;
        this.f = i2;
        this.e.get(i2).f(new h$a(this));
        if (z2) {
            return;
        }
        this.e.get(this.f).j(this.c);
    }
}
