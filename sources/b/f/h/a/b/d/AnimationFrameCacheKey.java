package b.f.h.a.b.d;

import b.d.b.a.outline;
import com.facebook.cache.common.CacheKey;

/* JADX INFO: renamed from: b.f.h.a.b.d.a, reason: use source file name */
/* JADX INFO: compiled from: AnimationFrameCacheKey.java */
/* JADX INFO: loaded from: classes.dex */
public class AnimationFrameCacheKey implements CacheKey {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f527b;

    public AnimationFrameCacheKey(int i, boolean z2) {
        this.a = outline.q("anim://", i);
        this.f527b = z2;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean a() {
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    public String b() {
        return this.a;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object obj) {
        if (!this.f527b) {
            return super.equals(obj);
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || AnimationFrameCacheKey.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((AnimationFrameCacheKey) obj).a);
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return !this.f527b ? super.hashCode() : this.a.hashCode();
    }
}
