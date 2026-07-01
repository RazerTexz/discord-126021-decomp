package b.f.j.a.c;

import b.f.j.c.m;
import b.f.j.c.m$b;
import com.facebook.cache.common.CacheKey;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: AnimatedFrameCache.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public final CacheKey a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m<CacheKey, b.f.j.j.c> f549b;
    public final LinkedHashSet<CacheKey> d = new LinkedHashSet<>();
    public final m$b<CacheKey> c = new c$a(this);

    public c(CacheKey cacheKey, m<CacheKey, b.f.j.j.c> mVar) {
        this.a = cacheKey;
        this.f549b = mVar;
    }
}
