package p007b.p225i.p226a.p228b.p229i.p230e;

import androidx.annotation.Nullable;
import java.util.Arrays;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.b.i.e.f */
/* JADX INFO: compiled from: AutoValue_LogEvent.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2423f extends AbstractC2429l {

    /* JADX INFO: renamed from: a */
    public final long f5167a;

    /* JADX INFO: renamed from: b */
    public final Integer f5168b;

    /* JADX INFO: renamed from: c */
    public final long f5169c;

    /* JADX INFO: renamed from: d */
    public final byte[] f5170d;

    /* JADX INFO: renamed from: e */
    public final String f5171e;

    /* JADX INFO: renamed from: f */
    public final long f5172f;

    /* JADX INFO: renamed from: g */
    public final AbstractC2432o f5173g;

    /* JADX INFO: renamed from: b.i.a.b.i.e.f$b */
    /* JADX INFO: compiled from: AutoValue_LogEvent.java */
    public static final class b extends AbstractC2429l.a {

        /* JADX INFO: renamed from: a */
        public Long f5174a;

        /* JADX INFO: renamed from: b */
        public Integer f5175b;

        /* JADX INFO: renamed from: c */
        public Long f5176c;

        /* JADX INFO: renamed from: d */
        public byte[] f5177d;

        /* JADX INFO: renamed from: e */
        public String f5178e;

        /* JADX INFO: renamed from: f */
        public Long f5179f;

        /* JADX INFO: renamed from: g */
        public AbstractC2432o f5180g;
    }

    public C2423f(long j, Integer num, long j2, byte[] bArr, String str, long j3, AbstractC2432o abstractC2432o, a aVar) {
        this.f5167a = j;
        this.f5168b = num;
        this.f5169c = j2;
        this.f5170d = bArr;
        this.f5171e = str;
        this.f5172f = j3;
        this.f5173g = abstractC2432o;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2429l
    @Nullable
    /* JADX INFO: renamed from: a */
    public Integer mo2316a() {
        return this.f5168b;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2429l
    /* JADX INFO: renamed from: b */
    public long mo2317b() {
        return this.f5167a;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2429l
    /* JADX INFO: renamed from: c */
    public long mo2318c() {
        return this.f5169c;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2429l
    @Nullable
    /* JADX INFO: renamed from: d */
    public AbstractC2432o mo2319d() {
        return this.f5173g;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2429l
    @Nullable
    /* JADX INFO: renamed from: e */
    public byte[] mo2320e() {
        return this.f5170d;
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2429l)) {
            return false;
        }
        AbstractC2429l abstractC2429l = (AbstractC2429l) obj;
        if (this.f5167a == abstractC2429l.mo2317b() && ((num = this.f5168b) != null ? num.equals(abstractC2429l.mo2316a()) : abstractC2429l.mo2316a() == null) && this.f5169c == abstractC2429l.mo2318c()) {
            if (Arrays.equals(this.f5170d, abstractC2429l instanceof C2423f ? ((C2423f) abstractC2429l).f5170d : abstractC2429l.mo2320e()) && ((str = this.f5171e) != null ? str.equals(abstractC2429l.mo2321f()) : abstractC2429l.mo2321f() == null) && this.f5172f == abstractC2429l.mo2322g()) {
                AbstractC2432o abstractC2432o = this.f5173g;
                if (abstractC2432o == null) {
                    if (abstractC2429l.mo2319d() == null) {
                        return true;
                    }
                } else if (abstractC2432o.equals(abstractC2429l.mo2319d())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2429l
    @Nullable
    /* JADX INFO: renamed from: f */
    public String mo2321f() {
        return this.f5171e;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2429l
    /* JADX INFO: renamed from: g */
    public long mo2322g() {
        return this.f5172f;
    }

    public int hashCode() {
        long j = this.f5167a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f5168b;
        int iHashCode = num == null ? 0 : num.hashCode();
        long j2 = this.f5169c;
        int iHashCode2 = (((((i ^ iHashCode) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f5170d)) * 1000003;
        String str = this.f5171e;
        int iHashCode3 = str == null ? 0 : str.hashCode();
        long j3 = this.f5172f;
        int i2 = (((iHashCode2 ^ iHashCode3) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        AbstractC2432o abstractC2432o = this.f5173g;
        return i2 ^ (abstractC2432o != null ? abstractC2432o.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("LogEvent{eventTimeMs=");
        sbM833U.append(this.f5167a);
        sbM833U.append(", eventCode=");
        sbM833U.append(this.f5168b);
        sbM833U.append(", eventUptimeMs=");
        sbM833U.append(this.f5169c);
        sbM833U.append(", sourceExtension=");
        sbM833U.append(Arrays.toString(this.f5170d));
        sbM833U.append(", sourceExtensionJsonProto3=");
        sbM833U.append(this.f5171e);
        sbM833U.append(", timezoneOffsetSeconds=");
        sbM833U.append(this.f5172f);
        sbM833U.append(", networkConnectionInfo=");
        sbM833U.append(this.f5173g);
        sbM833U.append("}");
        return sbM833U.toString();
    }
}
