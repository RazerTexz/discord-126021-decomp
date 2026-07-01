package b.f.j.a.c;

import b.f.j.c.m$b;
import com.facebook.cache.common.CacheKey;

/* JADX INFO: compiled from: AnimatedFrameCache.java */
/* JADX INFO: loaded from: classes2.dex */
public class c$a implements m$b<CacheKey> {
    public final /* synthetic */ c a;

    public c$a(c cVar) {
        this.a = cVar;
    }

    public void a(Object obj, boolean z2) {
        CacheKey cacheKey = (CacheKey) obj;
        c cVar = this.a;
        synchronized (cVar) {
            try {
                if (z2) {
                    cVar.d.add(cacheKey);
                } else {
                    cVar.d.remove(cacheKey);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
