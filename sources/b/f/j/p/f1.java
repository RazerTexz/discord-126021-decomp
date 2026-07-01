package b.f.j.p;

import java.util.Objects;

/* JADX INFO: compiled from: ThreadHandoffProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class f1<T> implements w0<T> {
    public final w0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g1 f610b;

    public f1(w0<T> w0Var, g1 g1Var) {
        Objects.requireNonNull(w0Var);
        this.a = w0Var;
        this.f610b = g1Var;
    }

    @Override // b.f.j.p.w0
    public void b(l<T> lVar, x0 x0Var) {
        try {
            b.f.j.r.b.b();
            z0 z0VarO = x0Var.o();
            Objects.requireNonNull(x0Var.g().getExperiments());
            f1$a f1_a = new f1$a(this, lVar, z0VarO, x0Var, "BackgroundThreadHandoffProducer", z0VarO, x0Var, lVar);
            x0Var.f(new f1$b(this, f1_a));
            h1 h1Var = (h1) this.f610b;
            synchronized (h1Var) {
                h1Var.f614b.execute(f1_a);
            }
            b.f.j.r.b.b();
        } catch (Throwable th) {
            b.f.j.r.b.b();
            throw th;
        }
    }
}
