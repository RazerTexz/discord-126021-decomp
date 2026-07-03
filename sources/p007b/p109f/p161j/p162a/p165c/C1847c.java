package p007b.p109f.p161j.p162a.p165c;

import androidx.annotation.VisibleForTesting;
import androidx.core.view.PointerIconCompat;
import com.facebook.cache.common.CacheKey;
import java.util.LinkedHashSet;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p119d.C1686i;
import p007b.p109f.p161j.p168c.InterfaceC1866m;
import p007b.p109f.p161j.p175j.AbstractC1917c;

/* JADX INFO: renamed from: b.f.j.a.c.c */
/* JADX INFO: compiled from: AnimatedFrameCache.java */
/* JADX INFO: loaded from: classes2.dex */
public class C1847c {

    /* JADX INFO: renamed from: a */
    public final CacheKey f3634a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1866m<CacheKey, AbstractC1917c> f3635b;

    /* JADX INFO: renamed from: d */
    public final LinkedHashSet<CacheKey> f3637d = new LinkedHashSet<>();

    /* JADX INFO: renamed from: c */
    public final InterfaceC1866m.b<CacheKey> f3636c = new a();

    /* JADX INFO: renamed from: b.f.j.a.c.c$a */
    /* JADX INFO: compiled from: AnimatedFrameCache.java */
    public class a implements InterfaceC1866m.b<CacheKey> {
        public a() {
        }

        /* JADX INFO: renamed from: a */
        public void m1201a(Object obj, boolean z2) {
            CacheKey cacheKey = (CacheKey) obj;
            C1847c c1847c = C1847c.this;
            synchronized (c1847c) {
                try {
                    if (z2) {
                        c1847c.f3637d.add(cacheKey);
                    } else {
                        c1847c.f3637d.remove(cacheKey);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.f.j.a.c.c$b */
    /* JADX INFO: compiled from: AnimatedFrameCache.java */
    @VisibleForTesting
    public static class b implements CacheKey {

        /* JADX INFO: renamed from: a */
        public final CacheKey f3639a;

        /* JADX INFO: renamed from: b */
        public final int f3640b;

        public b(CacheKey cacheKey, int i) {
            this.f3639a = cacheKey;
            this.f3640b = i;
        }

        @Override // com.facebook.cache.common.CacheKey
        /* JADX INFO: renamed from: a */
        public boolean mo929a() {
            return false;
        }

        @Override // com.facebook.cache.common.CacheKey
        /* JADX INFO: renamed from: b */
        public String mo930b() {
            return null;
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f3640b == bVar.f3640b && this.f3639a.equals(bVar.f3639a);
        }

        @Override // com.facebook.cache.common.CacheKey
        public int hashCode() {
            return (this.f3639a.hashCode() * PointerIconCompat.TYPE_ALL_SCROLL) + this.f3640b;
        }

        public String toString() {
            C1686i c1686iM526h2 = C1460d.m526h2(this);
            c1686iM526h2.m971c("imageCacheKey", this.f3639a);
            c1686iM526h2.m969a("frameIndex", this.f3640b);
            return c1686iM526h2.toString();
        }
    }

    public C1847c(CacheKey cacheKey, InterfaceC1866m<CacheKey, AbstractC1917c> interfaceC1866m) {
        this.f3634a = cacheKey;
        this.f3635b = interfaceC1866m;
    }
}
