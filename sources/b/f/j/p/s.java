package b.f.j.p;

import androidx.annotation.VisibleForTesting;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest$b;
import com.facebook.imagepipeline.request.ImageRequest$c;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: DiskCacheReadProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class s implements w0<b.f.j.j.e> {
    public final b.f.j.c.f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.f.j.c.f f636b;
    public final b.f.j.c.i c;
    public final w0<b.f.j.j.e> d;

    public s(b.f.j.c.f fVar, b.f.j.c.f fVar2, b.f.j.c.i iVar, w0<b.f.j.j.e> w0Var) {
        this.a = fVar;
        this.f636b = fVar2;
        this.c = iVar;
        this.d = w0Var;
    }

    @VisibleForTesting
    public static Map<String, String> c(z0 z0Var, x0 x0Var, boolean z2, int i) {
        if (z0Var.g(x0Var, "DiskCacheProducer")) {
            return z2 ? b.f.d.d.f.of("cached_value_found", String.valueOf(z2), "encodedImageSize", String.valueOf(i)) : b.f.d.d.f.of("cached_value_found", String.valueOf(z2));
        }
        return null;
    }

    @Override // b.f.j.p.w0
    public void b(l<b.f.j.j.e> lVar, x0 x0Var) {
        ImageRequest imageRequestE = x0Var.e();
        if (!x0Var.e().b(16)) {
            if (x0Var.q().g() < ImageRequest$c.DISK_CACHE.g()) {
                this.d.b(lVar, x0Var);
                return;
            } else {
                x0Var.i("disk", "nil-result_read");
                lVar.b(null, 1);
                return;
            }
        }
        x0Var.o().e(x0Var, "DiskCacheProducer");
        CacheKey cacheKeyB = ((b.f.j.c.n) this.c).b(imageRequestE, x0Var.b());
        b.f.j.c.f fVar = imageRequestE.f2902b == ImageRequest$b.SMALL ? this.f636b : this.a;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        fVar.e(cacheKeyB, atomicBoolean).b(new q(this, x0Var.o(), x0Var, lVar));
        x0Var.f(new r(this, atomicBoolean));
    }
}
