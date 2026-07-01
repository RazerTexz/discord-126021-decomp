package b.m.a.g.d;

import d0.z.d.m;

/* JADX INFO: compiled from: SntpResponseCache.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements f {
    public final b.m.a.f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.m.a.b f1908b;

    public g(b.m.a.f fVar, b.m.a.b bVar) {
        m.checkParameterIsNotNull(fVar, "syncResponseCache");
        m.checkParameterIsNotNull(bVar, "deviceClock");
        this.a = fVar;
        this.f1908b = bVar;
    }

    @Override // b.m.a.g.d.f
    public void a(e$b e_b) {
        m.checkParameterIsNotNull(e_b, "response");
        this.a.f(e_b.a);
        this.a.a(e_b.f1907b);
        this.a.b(e_b.c);
    }

    @Override // b.m.a.g.d.f
    public void clear() {
        this.a.clear();
    }

    @Override // b.m.a.g.d.f
    public e$b get() {
        long jE = this.a.e();
        long jC = this.a.c();
        long jD = this.a.d();
        if (jC == 0) {
            return null;
        }
        return new e$b(jE, jC, jD, this.f1908b);
    }
}
