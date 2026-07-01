package b.f.j.p;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: compiled from: BitmapProbeProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class j implements w0<CloseableReference<b.f.j.j.c>> {
    public final b.f.j.c.w<CacheKey, PooledByteBuffer> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.f.j.c.f f617b;
    public final b.f.j.c.f c;
    public final b.f.j.c.i d;
    public final w0<CloseableReference<b.f.j.j.c>> e;
    public final b.f.j.c.d<CacheKey> f;
    public final b.f.j.c.d<CacheKey> g;

    public j(b.f.j.c.w<CacheKey, PooledByteBuffer> wVar, b.f.j.c.f fVar, b.f.j.c.f fVar2, b.f.j.c.i iVar, b.f.j.c.d<CacheKey> dVar, b.f.j.c.d<CacheKey> dVar2, w0<CloseableReference<b.f.j.j.c>> w0Var) {
        this.a = wVar;
        this.f617b = fVar;
        this.c = fVar2;
        this.d = iVar;
        this.f = dVar;
        this.g = dVar2;
        this.e = w0Var;
    }

    @Override // b.f.j.p.w0
    public void b(l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var) {
        try {
            b.f.j.r.b.b();
            z0 z0VarO = x0Var.o();
            z0VarO.e(x0Var, "BitmapProbeProducer");
            j$a j_a = new j$a(lVar, x0Var, this.a, this.f617b, this.c, this.d, this.f, this.g);
            z0VarO.j(x0Var, "BitmapProbeProducer", null);
            b.f.j.r.b.b();
            this.e.b(j_a, x0Var);
            b.f.j.r.b.b();
        } finally {
            b.f.j.r.b.b();
        }
    }
}
