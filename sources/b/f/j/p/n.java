package b.f.j.p;

import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: DecodeProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class n implements w0<CloseableReference<b.f.j.j.c>> {
    public final b.f.d.g.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f626b;
    public final b.f.j.h.b c;
    public final b.f.j.h.d d;
    public final w0<b.f.j.j.e> e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final b.f.j.e.a j;
    public final Runnable k;
    public final Supplier<Boolean> l;

    public n(b.f.d.g.a aVar, Executor executor, b.f.j.h.b bVar, b.f.j.h.d dVar, boolean z2, boolean z3, boolean z4, w0<b.f.j.j.e> w0Var, int i, b.f.j.e.a aVar2, Runnable runnable, Supplier<Boolean> supplier) {
        Objects.requireNonNull(aVar);
        this.a = aVar;
        Objects.requireNonNull(executor);
        this.f626b = executor;
        Objects.requireNonNull(bVar);
        this.c = bVar;
        Objects.requireNonNull(dVar);
        this.d = dVar;
        this.f = z2;
        this.g = z3;
        Objects.requireNonNull(w0Var);
        this.e = w0Var;
        this.h = z4;
        this.i = i;
        this.j = aVar2;
        this.k = null;
        this.l = supplier;
    }

    @Override // b.f.j.p.w0
    public void b(l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var) {
        try {
            b.f.j.r.b.b();
            this.e.b(!b.f.d.l.b.e(x0Var.e().c) ? new n$a(this, lVar, x0Var, this.h, this.i) : new n$b(this, lVar, x0Var, new b.f.j.h.e(this.a), this.d, this.h, this.i), x0Var);
        } finally {
            b.f.j.r.b.b();
        }
    }
}
