package b.f.j.p;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest$c;

/* JADX INFO: compiled from: BitmapMemoryCacheProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class h implements w0<CloseableReference<b.f.j.j.c>> {
    public final b.f.j.c.w<CacheKey, b.f.j.j.c> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.f.j.c.i f613b;
    public final w0<CloseableReference<b.f.j.j.c>> c;

    public h(b.f.j.c.w<CacheKey, b.f.j.j.c> wVar, b.f.j.c.i iVar, w0<CloseableReference<b.f.j.j.c>> w0Var) {
        this.a = wVar;
        this.f613b = iVar;
        this.c = w0Var;
    }

    @Override // b.f.j.p.w0
    public void b(l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var) {
        try {
            b.f.j.r.b.b();
            z0 z0VarO = x0Var.o();
            z0VarO.e(x0Var, d());
            CacheKey cacheKeyA = ((b.f.j.c.n) this.f613b).a(x0Var.e(), x0Var.b());
            CloseableReference<b.f.j.j.c> closeableReference = x0Var.e().b(1) ? this.a.get(cacheKeyA) : null;
            if (closeableReference != null) {
                x0Var.j(closeableReference.u().a());
                boolean z2 = ((b.f.j.j.h) closeableReference.u().b()).d;
                if (z2) {
                    z0VarO.j(x0Var, d(), z0VarO.g(x0Var, d()) ? b.f.d.d.f.of("cached_value_found", "true") : null);
                    z0VarO.c(x0Var, d(), true);
                    x0Var.i("memory_bitmap", c());
                    lVar.a(1.0f);
                }
                lVar.b(closeableReference, z2 ? 1 : 0);
                closeableReference.close();
                if (z2) {
                    return;
                }
            }
            if (x0Var.q().g() >= ImageRequest$c.BITMAP_MEMORY_CACHE.g()) {
                z0VarO.j(x0Var, d(), z0VarO.g(x0Var, d()) ? b.f.d.d.f.of("cached_value_found", "false") : null);
                z0VarO.c(x0Var, d(), false);
                x0Var.i("memory_bitmap", c());
                lVar.b(null, 1);
                return;
            }
            l<CloseableReference<b.f.j.j.c>> lVarE = e(lVar, cacheKeyA, x0Var.e().b(2));
            z0VarO.j(x0Var, d(), z0VarO.g(x0Var, d()) ? b.f.d.d.f.of("cached_value_found", "false") : null);
            b.f.j.r.b.b();
            this.c.b(lVarE, x0Var);
            b.f.j.r.b.b();
        } finally {
            b.f.j.r.b.b();
        }
    }

    public String c() {
        return "pipe_bg";
    }

    public String d() {
        return "BitmapMemoryCacheProducer";
    }

    public l<CloseableReference<b.f.j.j.c>> e(l<CloseableReference<b.f.j.j.c>> lVar, CacheKey cacheKey, boolean z2) {
        return new h$a(this, lVar, cacheKey, z2);
    }
}
