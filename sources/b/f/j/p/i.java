package b.f.j.p;

import com.facebook.common.references.CloseableReference;
import java.util.Objects;

/* JADX INFO: compiled from: BitmapPrepareProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class i implements w0<CloseableReference<b.f.j.j.c>> {
    public final w0<CloseableReference<b.f.j.j.c>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f615b;
    public final int c;
    public final boolean d;

    public i(w0<CloseableReference<b.f.j.j.c>> w0Var, int i, int i2, boolean z2) {
        b.c.a.a0.d.i(Boolean.valueOf(i <= i2));
        Objects.requireNonNull(w0Var);
        this.a = w0Var;
        this.f615b = i;
        this.c = i2;
        this.d = z2;
    }

    @Override // b.f.j.p.w0
    public void b(l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var) {
        if (!x0Var.k() || this.d) {
            this.a.b(new i$a(lVar, this.f615b, this.c), x0Var);
        } else {
            this.a.b(lVar, x0Var);
        }
    }
}
