package b.f.j.p;

import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ResizeAndRotateProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class c1 implements w0<b.f.j.j.e> {
    public final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.f.d.g.g f607b;
    public final w0<b.f.j.j.e> c;
    public final boolean d;
    public final b.f.j.s.c e;

    public c1(Executor executor, b.f.d.g.g gVar, w0<b.f.j.j.e> w0Var, boolean z2, b.f.j.s.c cVar) {
        Objects.requireNonNull(executor);
        this.a = executor;
        Objects.requireNonNull(gVar);
        this.f607b = gVar;
        Objects.requireNonNull(w0Var);
        this.c = w0Var;
        Objects.requireNonNull(cVar);
        this.e = cVar;
        this.d = z2;
    }

    @Override // b.f.j.p.w0
    public void b(l<b.f.j.j.e> lVar, x0 x0Var) {
        this.c.b(new c1$a(this, lVar, x0Var, this.d, this.e), x0Var);
    }
}
