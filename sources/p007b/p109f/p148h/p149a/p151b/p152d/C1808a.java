package p007b.p109f.p148h.p149a.p151b.p152d;

import com.facebook.cache.common.CacheKey;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.f.h.a.b.d.a */
/* JADX INFO: compiled from: AnimationFrameCacheKey.java */
/* JADX INFO: loaded from: classes.dex */
public class C1808a implements CacheKey {

    /* JADX INFO: renamed from: a */
    public final String f3507a;

    /* JADX INFO: renamed from: b */
    public final boolean f3508b;

    public C1808a(int i, boolean z2) {
        this.f3507a = C1643a.m871q("anim://", i);
        this.f3508b = z2;
    }

    @Override // com.facebook.cache.common.CacheKey
    /* JADX INFO: renamed from: a */
    public boolean mo929a() {
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    /* JADX INFO: renamed from: b */
    public String mo930b() {
        return this.f3507a;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object obj) {
        if (!this.f3508b) {
            return super.equals(obj);
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || C1808a.class != obj.getClass()) {
            return false;
        }
        return this.f3507a.equals(((C1808a) obj).f3507a);
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return !this.f3508b ? super.hashCode() : this.f3507a.hashCode();
    }
}
