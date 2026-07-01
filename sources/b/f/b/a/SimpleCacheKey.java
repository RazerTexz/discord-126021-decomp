package b.f.b.a;

import com.facebook.cache.common.CacheKey;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.b.a.f, reason: use source file name */
/* JADX INFO: compiled from: SimpleCacheKey.java */
/* JADX INFO: loaded from: classes.dex */
public class SimpleCacheKey implements CacheKey {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f456b;

    public SimpleCacheKey(String str) {
        Objects.requireNonNull(str);
        this.a = str;
        this.f456b = false;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean a() {
        return this.f456b;
    }

    @Override // com.facebook.cache.common.CacheKey
    public String b() {
        return this.a;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SimpleCacheKey) {
            return this.a.equals(((SimpleCacheKey) obj).a);
        }
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a;
    }
}
