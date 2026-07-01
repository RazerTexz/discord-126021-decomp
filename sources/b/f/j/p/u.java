package b.f.j.p;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest$c;
import java.io.Closeable;

/* JADX INFO: compiled from: EncodedCacheKeyMultiplexProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class u extends l0<Pair<CacheKey, ImageRequest$c>, b.f.j.j.e> {
    public final b.f.j.c.i f;

    public u(b.f.j.c.i iVar, boolean z2, w0 w0Var) {
        super(w0Var, "EncodedCacheKeyMultiplexProducer", "multiplex_enc_cnt", z2);
        this.f = iVar;
    }

    @Override // b.f.j.p.l0
    public Closeable c(Closeable closeable) {
        return b.f.j.j.e.a((b.f.j.j.e) closeable);
    }

    @Override // b.f.j.p.l0
    public Pair<CacheKey, ImageRequest$c> d(x0 x0Var) {
        return Pair.create(((b.f.j.c.n) this.f).b(x0Var.e(), x0Var.b()), x0Var.q());
    }
}
