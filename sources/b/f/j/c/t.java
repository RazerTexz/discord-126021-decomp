package b.f.j.c;

import com.facebook.cache.common.CacheKey;
import java.util.Objects;

/* JADX INFO: compiled from: InstrumentedMemoryCacheBitmapMemoryCacheFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class t implements x<CacheKey> {
    public final /* synthetic */ r a;

    public t(r rVar) {
        this.a = rVar;
    }

    @Override // b.f.j.c.x
    public void a(CacheKey cacheKey) {
        Objects.requireNonNull((z) this.a);
    }

    @Override // b.f.j.c.x
    public void b(CacheKey cacheKey) {
        Objects.requireNonNull((z) this.a);
    }

    @Override // b.f.j.c.x
    public void c(CacheKey cacheKey) {
        Objects.requireNonNull((z) this.a);
    }
}
