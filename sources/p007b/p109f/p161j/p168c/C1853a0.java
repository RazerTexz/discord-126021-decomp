package p007b.p109f.p161j.p168c;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p161j.p175j.C1919e;

/* JADX INFO: renamed from: b.f.j.c.a0 */
/* JADX INFO: compiled from: StagingArea.java */
/* JADX INFO: loaded from: classes.dex */
public class C1853a0 {

    /* JADX INFO: renamed from: a */
    public Map<CacheKey, C1919e> f3647a = new HashMap();

    /* JADX INFO: renamed from: a */
    public synchronized C1919e m1208a(CacheKey cacheKey) {
        Objects.requireNonNull(cacheKey);
        C1919e c1919eM1336a = this.f3647a.get(cacheKey);
        if (c1919eM1336a != null) {
            synchronized (c1919eM1336a) {
                if (!C1919e.m1338u(c1919eM1336a)) {
                    this.f3647a.remove(cacheKey);
                    C1691a.m985m(C1853a0.class, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(c1919eM1336a)), cacheKey.mo930b(), Integer.valueOf(System.identityHashCode(cacheKey)));
                    return null;
                }
                c1919eM1336a = C1919e.m1336a(c1919eM1336a);
            }
        }
        return c1919eM1336a;
    }

    /* JADX INFO: renamed from: b */
    public synchronized void m1209b(CacheKey cacheKey, C1919e c1919e) {
        C1460d.m527i(Boolean.valueOf(C1919e.m1338u(c1919e)));
        C1919e c1919ePut = this.f3647a.put(cacheKey, C1919e.m1336a(c1919e));
        if (c1919ePut != null) {
            c1919ePut.close();
        }
        synchronized (this) {
            this.f3647a.size();
            int i = C1691a.f3102a;
        }
    }

    /* JADX INFO: renamed from: c */
    public boolean m1210c(CacheKey cacheKey) {
        C1919e c1919eRemove;
        Objects.requireNonNull(cacheKey);
        synchronized (this) {
            c1919eRemove = this.f3647a.remove(cacheKey);
        }
        if (c1919eRemove == null) {
            return false;
        }
        try {
            return c1919eRemove.m1346t();
        } finally {
            c1919eRemove.close();
        }
    }

    /* JADX INFO: renamed from: d */
    public synchronized boolean m1211d(CacheKey cacheKey, C1919e c1919e) {
        Objects.requireNonNull(cacheKey);
        Objects.requireNonNull(c1919e);
        C1460d.m527i(Boolean.valueOf(C1919e.m1338u(c1919e)));
        C1919e c1919e2 = this.f3647a.get(cacheKey);
        if (c1919e2 == null) {
            return false;
        }
        CloseableReference<PooledByteBuffer> closeableReferenceM1340c = c1919e2.m1340c();
        CloseableReference<PooledByteBuffer> closeableReferenceM1340c2 = c1919e.m1340c();
        if (closeableReferenceM1340c != null && closeableReferenceM1340c2 != null) {
            try {
                if (closeableReferenceM1340c.m8642u() == closeableReferenceM1340c2.m8642u()) {
                    this.f3647a.remove(cacheKey);
                    closeableReferenceM1340c2.close();
                    closeableReferenceM1340c.close();
                    c1919e2.close();
                    synchronized (this) {
                        this.f3647a.size();
                        int i = C1691a.f3102a;
                    }
                    return true;
                }
            } catch (Throwable th) {
                closeableReferenceM1340c2.close();
                closeableReferenceM1340c.close();
                c1919e2.close();
                throw th;
            }
        }
        if (closeableReferenceM1340c2 != null) {
            closeableReferenceM1340c2.close();
        }
        if (closeableReferenceM1340c != null) {
            closeableReferenceM1340c.close();
        }
        c1919e2.close();
        return false;
    }
}
