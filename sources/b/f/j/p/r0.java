package b.f.j.p;

import android.net.Uri;
import androidx.annotation.VisibleForTesting;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PartialDiskCacheProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class r0 implements w0<b.f.j.j.e> {
    public final b.f.j.c.f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.f.j.c.i f635b;
    public final b.f.d.g.g c;
    public final b.f.d.g.a d;
    public final w0<b.f.j.j.e> e;

    public r0(b.f.j.c.f fVar, b.f.j.c.i iVar, b.f.d.g.g gVar, b.f.d.g.a aVar, w0<b.f.j.j.e> w0Var) {
        this.a = fVar;
        this.f635b = iVar;
        this.c = gVar;
        this.d = aVar;
        this.e = w0Var;
    }

    @VisibleForTesting
    public static Map<String, String> c(z0 z0Var, x0 x0Var, boolean z2, int i) {
        if (z0Var.g(x0Var, "PartialDiskCacheProducer")) {
            return z2 ? b.f.d.d.f.of("cached_value_found", String.valueOf(z2), "encodedImageSize", String.valueOf(i)) : b.f.d.d.f.of("cached_value_found", String.valueOf(z2));
        }
        return null;
    }

    @Override // b.f.j.p.w0
    public void b(l<b.f.j.j.e> lVar, x0 x0Var) {
        ImageRequest imageRequestE = x0Var.e();
        boolean zB = x0Var.e().b(16);
        z0 z0VarO = x0Var.o();
        z0VarO.e(x0Var, "PartialDiskCacheProducer");
        Uri uriBuild = imageRequestE.c.buildUpon().appendQueryParameter("fresco_partial", "true").build();
        b.f.j.c.i iVar = this.f635b;
        x0Var.b();
        Objects.requireNonNull((b.f.j.c.n) iVar);
        b.f.b.a.f fVar = new b.f.b.a.f(uriBuild.toString());
        if (!zB) {
            z0VarO.j(x0Var, "PartialDiskCacheProducer", c(z0VarO, x0Var, false, 0));
            d(lVar, x0Var, fVar, null);
        } else {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            this.a.e(fVar, atomicBoolean).b(new p0(this, x0Var.o(), x0Var, lVar, fVar));
            x0Var.f(new q0(this, atomicBoolean));
        }
    }

    public final void d(l<b.f.j.j.e> lVar, x0 x0Var, CacheKey cacheKey, b.f.j.j.e eVar) {
        this.e.b(new r0$a(lVar, this.a, cacheKey, this.c, this.d, eVar, x0Var.e().b(32), null), x0Var);
    }
}
