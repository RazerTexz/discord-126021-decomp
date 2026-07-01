package b.f.b.a;

import com.facebook.cache.common.CacheKey;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.b.a.c, reason: use source file name */
/* JADX INFO: compiled from: MultiCacheKey.java */
/* JADX INFO: loaded from: classes.dex */
public class MultiCacheKey implements CacheKey {
    @Override // com.facebook.cache.common.CacheKey
    public boolean a() {
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    public String b() {
        throw null;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MultiCacheKey)) {
            return false;
        }
        Objects.requireNonNull((MultiCacheKey) obj);
        throw null;
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        throw null;
    }

    public String toString() {
        new StringBuilder().append("MultiCacheKey:");
        throw null;
    }
}
