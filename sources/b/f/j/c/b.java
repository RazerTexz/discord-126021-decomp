package b.f.j.c;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.time.RealtimeSinceBootClock;
import java.util.Objects;

/* JADX INFO: compiled from: BitmapMemoryCacheKey.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements CacheKey {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.f.j.d.e f553b;
    public final b.f.j.d.f c;
    public final b.f.j.d.b d;
    public final CacheKey e;
    public final String f;
    public final int g;
    public final Object h;

    public b(String str, b.f.j.d.e eVar, b.f.j.d.f fVar, b.f.j.d.b bVar, CacheKey cacheKey, String str2, Object obj) {
        Objects.requireNonNull(str);
        this.a = str;
        this.f553b = eVar;
        this.c = fVar;
        this.d = bVar;
        this.e = cacheKey;
        this.f = str2;
        Integer numValueOf = Integer.valueOf(str.hashCode());
        Integer numValueOf2 = Integer.valueOf(eVar != null ? eVar.hashCode() : 0);
        Integer numValueOf3 = Integer.valueOf(fVar.hashCode());
        int iHashCode = numValueOf == null ? 0 : numValueOf.hashCode();
        int iHashCode2 = numValueOf2 == null ? 0 : numValueOf2.hashCode();
        int iHashCode3 = numValueOf3 == null ? 0 : numValueOf3.hashCode();
        int iHashCode4 = bVar == null ? 0 : bVar.hashCode();
        this.g = ((((((((((iHashCode + 31) * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + (cacheKey == null ? 0 : cacheKey.hashCode())) * 31) + (str2 != null ? str2.hashCode() : 0);
        this.h = obj;
        RealtimeSinceBootClock.get().now();
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
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.g == bVar.g && this.a.equals(bVar.a) && b.c.a.a0.d.g0(this.f553b, bVar.f553b) && b.c.a.a0.d.g0(this.c, bVar.c) && b.c.a.a0.d.g0(this.d, bVar.d) && b.c.a.a0.d.g0(this.e, bVar.e) && b.c.a.a0.d.g0(this.f, bVar.f);
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return this.g;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.a, this.f553b, this.c, this.d, this.e, this.f, Integer.valueOf(this.g));
    }
}
