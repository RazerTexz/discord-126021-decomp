package p007b.p109f.p111b.p112a;

import com.facebook.cache.common.CacheKey;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.b.a.f */
/* JADX INFO: compiled from: SimpleCacheKey.java */
/* JADX INFO: loaded from: classes.dex */
public class C1656f implements CacheKey {

    /* JADX INFO: renamed from: a */
    public final String f3019a;

    /* JADX INFO: renamed from: b */
    public final boolean f3020b;

    public C1656f(String str) {
        Objects.requireNonNull(str);
        this.f3019a = str;
        this.f3020b = false;
    }

    @Override // com.facebook.cache.common.CacheKey
    /* JADX INFO: renamed from: a */
    public boolean mo929a() {
        return this.f3020b;
    }

    @Override // com.facebook.cache.common.CacheKey
    /* JADX INFO: renamed from: b */
    public String mo930b() {
        return this.f3019a;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1656f) {
            return this.f3019a.equals(((C1656f) obj).f3019a);
        }
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return this.f3019a.hashCode();
    }

    public String toString() {
        return this.f3019a;
    }
}
