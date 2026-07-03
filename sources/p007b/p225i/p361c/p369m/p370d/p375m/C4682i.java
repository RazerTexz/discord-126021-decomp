package p007b.p225i.p361c.p369m.p370d.p375m;

import androidx.annotation.NonNull;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v;

/* JADX INFO: renamed from: b.i.c.m.d.m.i */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Device.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4682i extends AbstractC4695v.d.c {

    /* JADX INFO: renamed from: a */
    public final int f12569a;

    /* JADX INFO: renamed from: b */
    public final String f12570b;

    /* JADX INFO: renamed from: c */
    public final int f12571c;

    /* JADX INFO: renamed from: d */
    public final long f12572d;

    /* JADX INFO: renamed from: e */
    public final long f12573e;

    /* JADX INFO: renamed from: f */
    public final boolean f12574f;

    /* JADX INFO: renamed from: g */
    public final int f12575g;

    /* JADX INFO: renamed from: h */
    public final String f12576h;

    /* JADX INFO: renamed from: i */
    public final String f12577i;

    /* JADX INFO: renamed from: b.i.c.m.d.m.i$b */
    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Device.java */
    public static final class b extends AbstractC4695v.d.c.a {

        /* JADX INFO: renamed from: a */
        public Integer f12578a;

        /* JADX INFO: renamed from: b */
        public String f12579b;

        /* JADX INFO: renamed from: c */
        public Integer f12580c;

        /* JADX INFO: renamed from: d */
        public Long f12581d;

        /* JADX INFO: renamed from: e */
        public Long f12582e;

        /* JADX INFO: renamed from: f */
        public Boolean f12583f;

        /* JADX INFO: renamed from: g */
        public Integer f12584g;

        /* JADX INFO: renamed from: h */
        public String f12585h;

        /* JADX INFO: renamed from: i */
        public String f12586i;

        /* JADX INFO: renamed from: a */
        public AbstractC4695v.d.c m6562a() {
            String strM883w = this.f12578a == null ? " arch" : "";
            if (this.f12579b == null) {
                strM883w = C1643a.m883w(strM883w, " model");
            }
            if (this.f12580c == null) {
                strM883w = C1643a.m883w(strM883w, " cores");
            }
            if (this.f12581d == null) {
                strM883w = C1643a.m883w(strM883w, " ram");
            }
            if (this.f12582e == null) {
                strM883w = C1643a.m883w(strM883w, " diskSpace");
            }
            if (this.f12583f == null) {
                strM883w = C1643a.m883w(strM883w, " simulator");
            }
            if (this.f12584g == null) {
                strM883w = C1643a.m883w(strM883w, " state");
            }
            if (this.f12585h == null) {
                strM883w = C1643a.m883w(strM883w, " manufacturer");
            }
            if (this.f12586i == null) {
                strM883w = C1643a.m883w(strM883w, " modelClass");
            }
            if (strM883w.isEmpty()) {
                return new C4682i(this.f12578a.intValue(), this.f12579b, this.f12580c.intValue(), this.f12581d.longValue(), this.f12582e.longValue(), this.f12583f.booleanValue(), this.f12584g.intValue(), this.f12585h, this.f12586i, null);
            }
            throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w));
        }
    }

    public C4682i(int i, String str, int i2, long j, long j2, boolean z2, int i3, String str2, String str3, a aVar) {
        this.f12569a = i;
        this.f12570b = str;
        this.f12571c = i2;
        this.f12572d = j;
        this.f12573e = j2;
        this.f12574f = z2;
        this.f12575g = i3;
        this.f12576h = str2;
        this.f12577i = str3;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.c
    @NonNull
    /* JADX INFO: renamed from: a */
    public int mo6553a() {
        return this.f12569a;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.c
    /* JADX INFO: renamed from: b */
    public int mo6554b() {
        return this.f12571c;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.c
    /* JADX INFO: renamed from: c */
    public long mo6555c() {
        return this.f12573e;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.c
    @NonNull
    /* JADX INFO: renamed from: d */
    public String mo6556d() {
        return this.f12576h;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.c
    @NonNull
    /* JADX INFO: renamed from: e */
    public String mo6557e() {
        return this.f12570b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4695v.d.c)) {
            return false;
        }
        AbstractC4695v.d.c cVar = (AbstractC4695v.d.c) obj;
        return this.f12569a == cVar.mo6553a() && this.f12570b.equals(cVar.mo6557e()) && this.f12571c == cVar.mo6554b() && this.f12572d == cVar.mo6559g() && this.f12573e == cVar.mo6555c() && this.f12574f == cVar.mo6561i() && this.f12575g == cVar.mo6560h() && this.f12576h.equals(cVar.mo6556d()) && this.f12577i.equals(cVar.mo6558f());
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.c
    @NonNull
    /* JADX INFO: renamed from: f */
    public String mo6558f() {
        return this.f12577i;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.c
    /* JADX INFO: renamed from: g */
    public long mo6559g() {
        return this.f12572d;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.c
    /* JADX INFO: renamed from: h */
    public int mo6560h() {
        return this.f12575g;
    }

    public int hashCode() {
        int iHashCode = (((((this.f12569a ^ 1000003) * 1000003) ^ this.f12570b.hashCode()) * 1000003) ^ this.f12571c) * 1000003;
        long j = this.f12572d;
        int i = (iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.f12573e;
        return ((((((((i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ (this.f12574f ? 1231 : 1237)) * 1000003) ^ this.f12575g) * 1000003) ^ this.f12576h.hashCode()) * 1000003) ^ this.f12577i.hashCode();
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.c
    /* JADX INFO: renamed from: i */
    public boolean mo6561i() {
        return this.f12574f;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Device{arch=");
        sbM833U.append(this.f12569a);
        sbM833U.append(", model=");
        sbM833U.append(this.f12570b);
        sbM833U.append(", cores=");
        sbM833U.append(this.f12571c);
        sbM833U.append(", ram=");
        sbM833U.append(this.f12572d);
        sbM833U.append(", diskSpace=");
        sbM833U.append(this.f12573e);
        sbM833U.append(", simulator=");
        sbM833U.append(this.f12574f);
        sbM833U.append(", state=");
        sbM833U.append(this.f12575g);
        sbM833U.append(", manufacturer=");
        sbM833U.append(this.f12576h);
        sbM833U.append(", modelClass=");
        return C1643a.m822J(sbM833U, this.f12577i, "}");
    }
}
