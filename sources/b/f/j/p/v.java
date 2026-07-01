package b.f.j.p;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest$c;

/* JADX INFO: compiled from: EncodedMemoryCacheProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class v implements w0<b.f.j.j.e> {
    public final b.f.j.c.w<CacheKey, PooledByteBuffer> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.f.j.c.i f640b;
    public final w0<b.f.j.j.e> c;

    public v(b.f.j.c.w<CacheKey, PooledByteBuffer> wVar, b.f.j.c.i iVar, w0<b.f.j.j.e> w0Var) {
        this.a = wVar;
        this.f640b = iVar;
        this.c = w0Var;
    }

    @Override // b.f.j.p.w0
    public void b(l<b.f.j.j.e> lVar, x0 x0Var) {
        try {
            b.f.j.r.b.b();
            z0 z0VarO = x0Var.o();
            z0VarO.e(x0Var, "EncodedMemoryCacheProducer");
            CacheKey cacheKeyB = ((b.f.j.c.n) this.f640b).b(x0Var.e(), x0Var.b());
            CloseableReference<PooledByteBuffer> closeableReference = x0Var.e().b(4) ? this.a.get(cacheKeyB) : null;
            try {
                if (closeableReference != null) {
                    b.f.j.j.e eVar = new b.f.j.j.e(closeableReference);
                    try {
                        z0VarO.j(x0Var, "EncodedMemoryCacheProducer", z0VarO.g(x0Var, "EncodedMemoryCacheProducer") ? b.f.d.d.f.of("cached_value_found", "true") : null);
                        z0VarO.c(x0Var, "EncodedMemoryCacheProducer", true);
                        x0Var.n("memory_encoded");
                        lVar.a(1.0f);
                        lVar.b(eVar, 1);
                        eVar.close();
                        closeableReference.close();
                        b.f.j.r.b.b();
                        return;
                    } catch (Throwable th) {
                        eVar.close();
                        throw th;
                    }
                }
                if (x0Var.q().g() < ImageRequest$c.ENCODED_MEMORY_CACHE.g()) {
                    v$a v_a = new v$a(lVar, this.a, cacheKeyB, x0Var.e().b(8), x0Var.g().getExperiments().e);
                    z0VarO.j(x0Var, "EncodedMemoryCacheProducer", z0VarO.g(x0Var, "EncodedMemoryCacheProducer") ? b.f.d.d.f.of("cached_value_found", "false") : null);
                    this.c.b(v_a, x0Var);
                    Class<CloseableReference> cls = CloseableReference.j;
                    if (closeableReference != null) {
                        closeableReference.close();
                    }
                    b.f.j.r.b.b();
                    return;
                }
                z0VarO.j(x0Var, "EncodedMemoryCacheProducer", z0VarO.g(x0Var, "EncodedMemoryCacheProducer") ? b.f.d.d.f.of("cached_value_found", "false") : null);
                z0VarO.c(x0Var, "EncodedMemoryCacheProducer", false);
                x0Var.i("memory_encoded", "nil-result");
                lVar.b(null, 1);
                Class<CloseableReference> cls2 = CloseableReference.j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
                b.f.j.r.b.b();
            } catch (Throwable th2) {
                Class<CloseableReference> cls3 = CloseableReference.j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
                throw th2;
            }
        } catch (Throwable th3) {
            b.f.j.r.b.b();
            throw th3;
        }
    }
}
