package b.f.j.a.c;

import androidx.annotation.VisibleForTesting;
import androidx.core.view.PointerIconCompat;
import b.f.d.d.i;
import com.facebook.cache.common.CacheKey;

/* JADX INFO: compiled from: AnimatedFrameCache.java */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
public class c$b implements CacheKey {
    public final CacheKey a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f550b;

    public c$b(CacheKey cacheKey, int i) {
        this.a = cacheKey;
        this.f550b = i;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean a() {
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    public String b() {
        return null;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c$b)) {
            return false;
        }
        c$b c_b = (c$b) obj;
        return this.f550b == c_b.f550b && this.a.equals(c_b.a);
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return (this.a.hashCode() * PointerIconCompat.TYPE_ALL_SCROLL) + this.f550b;
    }

    public String toString() {
        i iVarH2 = b.c.a.a0.d.h2(this);
        iVarH2.c("imageCacheKey", this.a);
        iVarH2.a("frameIndex", this.f550b);
        return iVarH2.toString();
    }
}
