package p007b.p225i.p226a.p228b.p231j;

import androidx.annotation.Nullable;
import java.util.Map;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p228b.p231j.AbstractC2439f;

/* JADX INFO: renamed from: b.i.a.b.j.a */
/* JADX INFO: compiled from: AutoValue_EventInternal.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2434a extends AbstractC2439f {

    /* JADX INFO: renamed from: a */
    public final String f5246a;

    /* JADX INFO: renamed from: b */
    public final Integer f5247b;

    /* JADX INFO: renamed from: c */
    public final C2438e f5248c;

    /* JADX INFO: renamed from: d */
    public final long f5249d;

    /* JADX INFO: renamed from: e */
    public final long f5250e;

    /* JADX INFO: renamed from: f */
    public final Map<String, String> f5251f;

    /* JADX INFO: renamed from: b.i.a.b.j.a$b */
    /* JADX INFO: compiled from: AutoValue_EventInternal.java */
    public static final class b extends AbstractC2439f.a {

        /* JADX INFO: renamed from: a */
        public String f5252a;

        /* JADX INFO: renamed from: b */
        public Integer f5253b;

        /* JADX INFO: renamed from: c */
        public C2438e f5254c;

        /* JADX INFO: renamed from: d */
        public Long f5255d;

        /* JADX INFO: renamed from: e */
        public Long f5256e;

        /* JADX INFO: renamed from: f */
        public Map<String, String> f5257f;

        @Override // p007b.p225i.p226a.p228b.p231j.AbstractC2439f.a
        /* JADX INFO: renamed from: b */
        public AbstractC2439f mo2342b() {
            String strM883w = this.f5252a == null ? " transportName" : "";
            if (this.f5254c == null) {
                strM883w = C1643a.m883w(strM883w, " encodedPayload");
            }
            if (this.f5255d == null) {
                strM883w = C1643a.m883w(strM883w, " eventMillis");
            }
            if (this.f5256e == null) {
                strM883w = C1643a.m883w(strM883w, " uptimeMillis");
            }
            if (this.f5257f == null) {
                strM883w = C1643a.m883w(strM883w, " autoMetadata");
            }
            if (strM883w.isEmpty()) {
                return new C2434a(this.f5252a, this.f5253b, this.f5254c, this.f5255d.longValue(), this.f5256e.longValue(), this.f5257f, null);
            }
            throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w));
        }

        @Override // p007b.p225i.p226a.p228b.p231j.AbstractC2439f.a
        /* JADX INFO: renamed from: c */
        public Map<String, String> mo2343c() {
            Map<String, String> map = this.f5257f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        /* JADX INFO: renamed from: d */
        public AbstractC2439f.a m2344d(C2438e c2438e) {
            Objects.requireNonNull(c2438e, "Null encodedPayload");
            this.f5254c = c2438e;
            return this;
        }

        /* JADX INFO: renamed from: e */
        public AbstractC2439f.a m2345e(long j) {
            this.f5255d = Long.valueOf(j);
            return this;
        }

        /* JADX INFO: renamed from: f */
        public AbstractC2439f.a m2346f(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.f5252a = str;
            return this;
        }

        /* JADX INFO: renamed from: g */
        public AbstractC2439f.a m2347g(long j) {
            this.f5256e = Long.valueOf(j);
            return this;
        }
    }

    public C2434a(String str, Integer num, C2438e c2438e, long j, long j2, Map map, a aVar) {
        this.f5246a = str;
        this.f5247b = num;
        this.f5248c = c2438e;
        this.f5249d = j;
        this.f5250e = j2;
        this.f5251f = map;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.AbstractC2439f
    /* JADX INFO: renamed from: b */
    public Map<String, String> mo2336b() {
        return this.f5251f;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.AbstractC2439f
    @Nullable
    /* JADX INFO: renamed from: c */
    public Integer mo2337c() {
        return this.f5247b;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.AbstractC2439f
    /* JADX INFO: renamed from: d */
    public C2438e mo2338d() {
        return this.f5248c;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.AbstractC2439f
    /* JADX INFO: renamed from: e */
    public long mo2339e() {
        return this.f5249d;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2439f)) {
            return false;
        }
        AbstractC2439f abstractC2439f = (AbstractC2439f) obj;
        return this.f5246a.equals(abstractC2439f.mo2340g()) && ((num = this.f5247b) != null ? num.equals(abstractC2439f.mo2337c()) : abstractC2439f.mo2337c() == null) && this.f5248c.equals(abstractC2439f.mo2338d()) && this.f5249d == abstractC2439f.mo2339e() && this.f5250e == abstractC2439f.mo2341h() && this.f5251f.equals(abstractC2439f.mo2336b());
    }

    @Override // p007b.p225i.p226a.p228b.p231j.AbstractC2439f
    /* JADX INFO: renamed from: g */
    public String mo2340g() {
        return this.f5246a;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.AbstractC2439f
    /* JADX INFO: renamed from: h */
    public long mo2341h() {
        return this.f5250e;
    }

    public int hashCode() {
        int iHashCode = (this.f5246a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f5247b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f5248c.hashCode()) * 1000003;
        long j = this.f5249d;
        int i = (iHashCode2 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.f5250e;
        return ((i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.f5251f.hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("EventInternal{transportName=");
        sbM833U.append(this.f5246a);
        sbM833U.append(", code=");
        sbM833U.append(this.f5247b);
        sbM833U.append(", encodedPayload=");
        sbM833U.append(this.f5248c);
        sbM833U.append(", eventMillis=");
        sbM833U.append(this.f5249d);
        sbM833U.append(", uptimeMillis=");
        sbM833U.append(this.f5250e);
        sbM833U.append(", autoMetadata=");
        return C1643a.m825M(sbM833U, this.f5251f, "}");
    }
}
