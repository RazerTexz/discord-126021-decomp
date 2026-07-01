package b.o.a.n.o;

import android.hardware.camera2.CameraCharacteristics$Key;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: BaseAction.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public abstract class e implements a {
    public final List<b> a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1935b;
    public c c;
    public boolean d;

    @Override // b.o.a.n.o.a
    public final void a(@NonNull c cVar) {
        ((b.o.a.n.d) cVar).p0.remove(this);
        if (!g()) {
            h(cVar);
            l(Integer.MAX_VALUE);
        }
        this.d = false;
    }

    @Override // b.o.a.n.o.a
    public void b(@NonNull c cVar, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
    }

    @Override // b.o.a.n.o.a
    @CallSuper
    public void c(@NonNull c cVar, @NonNull CaptureRequest captureRequest) {
        if (this.d) {
            j(cVar);
            this.d = false;
        }
    }

    @Override // b.o.a.n.o.a
    public void d(@NonNull c cVar, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
    }

    @Override // b.o.a.n.o.a
    public final void e(@NonNull c cVar) {
        this.c = cVar;
        b.o.a.n.d dVar = (b.o.a.n.d) cVar;
        if (!dVar.p0.contains(this)) {
            dVar.p0.add(this);
        }
        if (((b.o.a.n.d) cVar).f1922j0 != null) {
            j(cVar);
        } else {
            this.d = true;
        }
    }

    public void f(@NonNull b bVar) {
        if (this.a.contains(bVar)) {
            return;
        }
        this.a.add(bVar);
        bVar.a(this, this.f1935b);
    }

    public boolean g() {
        return this.f1935b == Integer.MAX_VALUE;
    }

    public void h(@NonNull c cVar) {
    }

    public void i(@NonNull c cVar) {
    }

    @CallSuper
    public void j(@NonNull c cVar) {
        this.c = cVar;
    }

    @NonNull
    public <T> T k(@NonNull CameraCharacteristics$Key<T> cameraCharacteristics$Key, @NonNull T t) {
        T t2 = (T) ((b.o.a.n.d) this.c).f1919g0.get(cameraCharacteristics$Key);
        return t2 == null ? t : t2;
    }

    public final void l(int i) {
        if (i != this.f1935b) {
            this.f1935b = i;
            Iterator<b> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.f1935b);
            }
            if (this.f1935b == Integer.MAX_VALUE) {
                ((b.o.a.n.d) this.c).p0.remove(this);
                i(this.c);
            }
        }
    }
}
