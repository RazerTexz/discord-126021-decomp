package b.f.j.p;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest$c;
import java.io.Closeable;

/* JADX INFO: compiled from: BitmapMemoryCacheKeyMultiplexProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends l0<Pair<CacheKey, ImageRequest$c>, CloseableReference<b.f.j.j.c>> {
    public final b.f.j.c.i f;

    public g(b.f.j.c.i iVar, w0 w0Var) {
        super(w0Var, "BitmapMemoryCacheKeyMultiplexProducer", "multiplex_bmp_cnt");
        this.f = iVar;
    }

    @Override // b.f.j.p.l0
    public Closeable c(Closeable closeable) {
        return CloseableReference.n((CloseableReference) closeable);
    }

    @Override // b.f.j.p.l0
    public Pair<CacheKey, ImageRequest$c> d(x0 x0Var) {
        return Pair.create(((b.f.j.c.n) this.f).a(x0Var.e(), x0Var.b()), x0Var.q());
    }
}
