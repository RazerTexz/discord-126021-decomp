package b.f.j.p;

import com.facebook.cache.common.CacheKey;

/* JADX INFO: compiled from: EncodedProbeProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class w implements w0<b.f.j.j.e> {
    public final b.f.j.c.f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.f.j.c.f f641b;
    public final b.f.j.c.i c;
    public final w0<b.f.j.j.e> d;
    public final b.f.j.c.d<CacheKey> e;
    public final b.f.j.c.d<CacheKey> f;

    public w(b.f.j.c.f fVar, b.f.j.c.f fVar2, b.f.j.c.i iVar, b.f.j.c.d dVar, b.f.j.c.d dVar2, w0<b.f.j.j.e> w0Var) {
        this.a = fVar;
        this.f641b = fVar2;
        this.c = iVar;
        this.e = dVar;
        this.f = dVar2;
        this.d = w0Var;
    }

    @Override // b.f.j.p.w0
    public void b(l<b.f.j.j.e> lVar, x0 x0Var) {
        try {
            b.f.j.r.b.b();
            z0 z0VarO = x0Var.o();
            z0VarO.e(x0Var, "EncodedProbeProducer");
            w$a w_a = new w$a(lVar, x0Var, this.a, this.f641b, this.c, this.e, this.f);
            z0VarO.j(x0Var, "EncodedProbeProducer", null);
            b.f.j.r.b.b();
            this.d.b(w_a, x0Var);
            b.f.j.r.b.b();
        } finally {
            b.f.j.r.b.b();
        }
    }
}
