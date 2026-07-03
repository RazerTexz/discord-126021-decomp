package p007b.p225i.p226a.p228b.p229i.p230e;

import androidx.annotation.Nullable;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.b.i.e.g */
/* JADX INFO: compiled from: AutoValue_LogRequest.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2424g extends AbstractC2430m {

    /* JADX INFO: renamed from: a */
    public final long f5181a;

    /* JADX INFO: renamed from: b */
    public final long f5182b;

    /* JADX INFO: renamed from: c */
    public final AbstractC2428k f5183c;

    /* JADX INFO: renamed from: d */
    public final Integer f5184d;

    /* JADX INFO: renamed from: e */
    public final String f5185e;

    /* JADX INFO: renamed from: f */
    public final List<AbstractC2429l> f5186f;

    /* JADX INFO: renamed from: g */
    public final EnumC2433p f5187g;

    public C2424g(long j, long j2, AbstractC2428k abstractC2428k, Integer num, String str, List list, EnumC2433p enumC2433p, a aVar) {
        this.f5181a = j;
        this.f5182b = j2;
        this.f5183c = abstractC2428k;
        this.f5184d = num;
        this.f5185e = str;
        this.f5186f = list;
        this.f5187g = enumC2433p;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2430m
    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC2428k mo2323a() {
        return this.f5183c;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2430m
    @Nullable
    /* JADX INFO: renamed from: b */
    public List<AbstractC2429l> mo2324b() {
        return this.f5186f;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2430m
    @Nullable
    /* JADX INFO: renamed from: c */
    public Integer mo2325c() {
        return this.f5184d;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2430m
    @Nullable
    /* JADX INFO: renamed from: d */
    public String mo2326d() {
        return this.f5185e;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2430m
    @Nullable
    /* JADX INFO: renamed from: e */
    public EnumC2433p mo2327e() {
        return this.f5187g;
    }

    public boolean equals(Object obj) {
        AbstractC2428k abstractC2428k;
        Integer num;
        String str;
        List<AbstractC2429l> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2430m)) {
            return false;
        }
        AbstractC2430m abstractC2430m = (AbstractC2430m) obj;
        if (this.f5181a == abstractC2430m.mo2328f() && this.f5182b == abstractC2430m.mo2329g() && ((abstractC2428k = this.f5183c) != null ? abstractC2428k.equals(abstractC2430m.mo2323a()) : abstractC2430m.mo2323a() == null) && ((num = this.f5184d) != null ? num.equals(abstractC2430m.mo2325c()) : abstractC2430m.mo2325c() == null) && ((str = this.f5185e) != null ? str.equals(abstractC2430m.mo2326d()) : abstractC2430m.mo2326d() == null) && ((list = this.f5186f) != null ? list.equals(abstractC2430m.mo2324b()) : abstractC2430m.mo2324b() == null)) {
            EnumC2433p enumC2433p = this.f5187g;
            if (enumC2433p == null) {
                if (abstractC2430m.mo2327e() == null) {
                    return true;
                }
            } else if (enumC2433p.equals(abstractC2430m.mo2327e())) {
                return true;
            }
        }
        return false;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2430m
    /* JADX INFO: renamed from: f */
    public long mo2328f() {
        return this.f5181a;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2430m
    /* JADX INFO: renamed from: g */
    public long mo2329g() {
        return this.f5182b;
    }

    public int hashCode() {
        long j = this.f5181a;
        long j2 = this.f5182b;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        AbstractC2428k abstractC2428k = this.f5183c;
        int iHashCode = (i ^ (abstractC2428k == null ? 0 : abstractC2428k.hashCode())) * 1000003;
        Integer num = this.f5184d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f5185e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<AbstractC2429l> list = this.f5186f;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        EnumC2433p enumC2433p = this.f5187g;
        return iHashCode4 ^ (enumC2433p != null ? enumC2433p.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("LogRequest{requestTimeMs=");
        sbM833U.append(this.f5181a);
        sbM833U.append(", requestUptimeMs=");
        sbM833U.append(this.f5182b);
        sbM833U.append(", clientInfo=");
        sbM833U.append(this.f5183c);
        sbM833U.append(", logSource=");
        sbM833U.append(this.f5184d);
        sbM833U.append(", logSourceName=");
        sbM833U.append(this.f5185e);
        sbM833U.append(", logEvents=");
        sbM833U.append(this.f5186f);
        sbM833U.append(", qosTier=");
        sbM833U.append(this.f5187g);
        sbM833U.append("}");
        return sbM833U.toString();
    }
}
