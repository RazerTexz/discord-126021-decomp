package b.f.b.a;

import com.facebook.cache.common.CacheKey;
import java.util.Objects;

/* JADX INFO: compiled from: MultiCacheKey.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements CacheKey {
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
        if (!(obj instanceof c)) {
            return false;
        }
        Objects.requireNonNull((c) obj);
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
