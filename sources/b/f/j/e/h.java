package b.f.j.e;

import b.f.j.c.w;
import b.f.j.p.b0;
import b.f.j.p.d1;
import b.f.j.p.g1;
import b.f.j.p.w0;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest$c;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: ImagePipeline.java */
/* JADX INFO: loaded from: classes.dex */
public class h {
    public final q a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.f.j.k.e f569b;
    public final b.f.j.k.d c;
    public final Supplier<Boolean> d;
    public final w<CacheKey, b.f.j.j.c> e;
    public final w<CacheKey, PooledByteBuffer> f;
    public final b.f.j.c.i g;
    public final Supplier<Boolean> h;
    public AtomicLong i = new AtomicLong();
    public final Supplier<Boolean> j = null;
    public final b.f.c.a k;
    public final k l;

    static {
        new CancellationException("Prefetching is not enabled");
    }

    public h(q qVar, Set<b.f.j.k.e> set, Set<b.f.j.k.d> set2, Supplier<Boolean> supplier, w<CacheKey, b.f.j.j.c> wVar, w<CacheKey, PooledByteBuffer> wVar2, b.f.j.c.f fVar, b.f.j.c.f fVar2, b.f.j.c.i iVar, g1 g1Var, Supplier<Boolean> supplier2, Supplier<Boolean> supplier3, b.f.c.a aVar, k kVar) {
        this.a = qVar;
        this.f569b = new b.f.j.k.c(set);
        this.c = new b.f.j.k.b(set2);
        this.d = supplier;
        this.e = wVar;
        this.f = wVar2;
        this.g = iVar;
        this.h = supplier2;
        this.k = aVar;
        this.l = kVar;
    }

    public DataSource<CloseableReference<b.f.j.j.c>> a(ImageRequest imageRequest, Object obj, ImageRequest$c imageRequest$c, b.f.j.k.e eVar, String str) {
        try {
            return b(this.a.c(imageRequest), imageRequest, imageRequest$c, obj, eVar, str);
        } catch (Exception e) {
            return b.c.a.a0.d.N0(e);
        }
    }

    public final <T> DataSource<CloseableReference<T>> b(w0<CloseableReference<T>> w0Var, ImageRequest imageRequest, ImageRequest$c imageRequest$c, Object obj, b.f.j.k.e eVar, String str) {
        b.f.j.k.c cVar;
        b.f.j.k.e cVar2;
        b.f.j.r.b.b();
        if (eVar == null) {
            b.f.j.k.e eVar2 = imageRequest.t;
            if (eVar2 == null) {
                cVar2 = this.f569b;
            } else {
                cVar = new b.f.j.k.c(this.f569b, eVar2);
                cVar2 = cVar;
            }
        } else {
            b.f.j.k.e eVar3 = imageRequest.t;
            if (eVar3 == null) {
                cVar2 = new b.f.j.k.c(this.f569b, eVar);
            } else {
                cVar = new b.f.j.k.c(this.f569b, eVar, eVar3);
                cVar2 = cVar;
            }
        }
        b0 b0Var = new b0(cVar2, this.c);
        b.f.c.a aVar = this.k;
        if (aVar != null) {
            aVar.a(obj, false);
        }
        try {
            d1 d1Var = new d1(imageRequest, String.valueOf(this.i.getAndIncrement()), str, b0Var, obj, ImageRequest$c.f(imageRequest.n, imageRequest$c), false, imageRequest.f || !b.f.d.l.b.e(imageRequest.c), imageRequest.m, this.l);
            b.f.j.r.b.b();
            b.f.j.f.d dVar = new b.f.j.f.d(w0Var, d1Var, b0Var);
            b.f.j.r.b.b();
            return dVar;
        } catch (Exception e) {
            return b.c.a.a0.d.N0(e);
        } finally {
            b.f.j.r.b.b();
        }
    }
}
