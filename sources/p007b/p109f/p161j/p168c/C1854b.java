package p007b.p109f.p161j.p168c;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.time.RealtimeSinceBootClock;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p161j.p169d.C1881b;
import p007b.p109f.p161j.p169d.C1884e;
import p007b.p109f.p161j.p169d.C1885f;

/* JADX INFO: renamed from: b.f.j.c.b */
/* JADX INFO: compiled from: BitmapMemoryCacheKey.java */
/* JADX INFO: loaded from: classes.dex */
public class C1854b implements CacheKey {

    /* JADX INFO: renamed from: a */
    public final String f3648a;

    /* JADX INFO: renamed from: b */
    public final C1884e f3649b;

    /* JADX INFO: renamed from: c */
    public final C1885f f3650c;

    /* JADX INFO: renamed from: d */
    public final C1881b f3651d;

    /* JADX INFO: renamed from: e */
    public final CacheKey f3652e;

    /* JADX INFO: renamed from: f */
    public final String f3653f;

    /* JADX INFO: renamed from: g */
    public final int f3654g;

    /* JADX INFO: renamed from: h */
    public final Object f3655h;

    public C1854b(String str, C1884e c1884e, C1885f c1885f, C1881b c1881b, CacheKey cacheKey, String str2, Object obj) {
        Objects.requireNonNull(str);
        this.f3648a = str;
        this.f3649b = c1884e;
        this.f3650c = c1885f;
        this.f3651d = c1881b;
        this.f3652e = cacheKey;
        this.f3653f = str2;
        Integer numValueOf = Integer.valueOf(str.hashCode());
        Integer numValueOf2 = Integer.valueOf(c1884e != null ? c1884e.hashCode() : 0);
        Integer numValueOf3 = Integer.valueOf(c1885f.hashCode());
        int iHashCode = numValueOf == null ? 0 : numValueOf.hashCode();
        int iHashCode2 = numValueOf2 == null ? 0 : numValueOf2.hashCode();
        int iHashCode3 = numValueOf3 == null ? 0 : numValueOf3.hashCode();
        int iHashCode4 = c1881b == null ? 0 : c1881b.hashCode();
        this.f3654g = ((((((((((iHashCode + 31) * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + (cacheKey == null ? 0 : cacheKey.hashCode())) * 31) + (str2 != null ? str2.hashCode() : 0);
        this.f3655h = obj;
        RealtimeSinceBootClock.get().now();
    }

    @Override // com.facebook.cache.common.CacheKey
    /* JADX INFO: renamed from: a */
    public boolean mo929a() {
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    /* JADX INFO: renamed from: b */
    public String mo930b() {
        return this.f3648a;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object obj) {
        if (!(obj instanceof C1854b)) {
            return false;
        }
        C1854b c1854b = (C1854b) obj;
        return this.f3654g == c1854b.f3654g && this.f3648a.equals(c1854b.f3648a) && C1460d.m520g0(this.f3649b, c1854b.f3649b) && C1460d.m520g0(this.f3650c, c1854b.f3650c) && C1460d.m520g0(this.f3651d, c1854b.f3651d) && C1460d.m520g0(this.f3652e, c1854b.f3652e) && C1460d.m520g0(this.f3653f, c1854b.f3653f);
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return this.f3654g;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.f3648a, this.f3649b, this.f3650c, this.f3651d, this.f3652e, this.f3653f, Integer.valueOf(this.f3654g));
    }
}
