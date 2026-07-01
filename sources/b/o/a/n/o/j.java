package b.o.a.n.o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: TogetherAction.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class j extends e {
    public final List<e> e;
    public final List<e> f;

    public j(@NonNull List<e> list) {
        this.e = new ArrayList(list);
        this.f = new ArrayList(list);
        Iterator<e> it = list.iterator();
        while (it.hasNext()) {
            it.next().f(new j$a(this));
        }
    }

    @Override // b.o.a.n.o.e, b.o.a.n.o.a
    public void b(@NonNull c cVar, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        for (e eVar : this.e) {
            if (!eVar.g()) {
                eVar.b(cVar, captureRequest, totalCaptureResult);
            }
        }
    }

    @Override // b.o.a.n.o.e, b.o.a.n.o.a
    public void c(@NonNull c cVar, @NonNull CaptureRequest captureRequest) {
        if (this.d) {
            j(cVar);
            this.d = false;
        }
        for (e eVar : this.e) {
            if (!eVar.g()) {
                eVar.c(cVar, captureRequest);
            }
        }
    }

    @Override // b.o.a.n.o.e, b.o.a.n.o.a
    public void d(@NonNull c cVar, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        for (e eVar : this.e) {
            if (!eVar.g()) {
                eVar.d(cVar, captureRequest, captureResult);
            }
        }
    }

    @Override // b.o.a.n.o.e
    public void h(@NonNull c cVar) {
        for (e eVar : this.e) {
            if (!eVar.g()) {
                eVar.h(cVar);
            }
        }
    }

    @Override // b.o.a.n.o.e
    public void j(@NonNull c cVar) {
        this.c = cVar;
        for (e eVar : this.e) {
            if (!eVar.g()) {
                eVar.j(cVar);
            }
        }
    }
}
