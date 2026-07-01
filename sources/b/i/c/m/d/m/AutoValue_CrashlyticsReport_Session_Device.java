package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import b.d.b.a.outline;
import b.i.c.m.d.m.CrashlyticsReport;

/* JADX INFO: renamed from: b.i.c.m.d.m.i, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Device.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Device extends CrashlyticsReport.d.c {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1721b;
    public final int c;
    public final long d;
    public final long e;
    public final boolean f;
    public final int g;
    public final String h;
    public final String i;

    /* JADX INFO: renamed from: b.i.c.m.d.m.i$b */
    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Device.java */
    public static final class b extends CrashlyticsReport.d.c.a {
        public Integer a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f1722b;
        public Integer c;
        public Long d;
        public Long e;
        public Boolean f;
        public Integer g;
        public String h;
        public String i;

        public CrashlyticsReport.d.c a() {
            String strW = this.a == null ? " arch" : "";
            if (this.f1722b == null) {
                strW = outline.w(strW, " model");
            }
            if (this.c == null) {
                strW = outline.w(strW, " cores");
            }
            if (this.d == null) {
                strW = outline.w(strW, " ram");
            }
            if (this.e == null) {
                strW = outline.w(strW, " diskSpace");
            }
            if (this.f == null) {
                strW = outline.w(strW, " simulator");
            }
            if (this.g == null) {
                strW = outline.w(strW, " state");
            }
            if (this.h == null) {
                strW = outline.w(strW, " manufacturer");
            }
            if (this.i == null) {
                strW = outline.w(strW, " modelClass");
            }
            if (strW.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Device(this.a.intValue(), this.f1722b, this.c.intValue(), this.d.longValue(), this.e.longValue(), this.f.booleanValue(), this.g.intValue(), this.h, this.i, null);
            }
            throw new IllegalStateException(outline.w("Missing required properties:", strW));
        }
    }

    public AutoValue_CrashlyticsReport_Session_Device(int i, String str, int i2, long j, long j2, boolean z2, int i3, String str2, String str3, a aVar) {
        this.a = i;
        this.f1721b = str;
        this.c = i2;
        this.d = j;
        this.e = j2;
        this.f = z2;
        this.g = i3;
        this.h = str2;
        this.i = str3;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.c
    @NonNull
    public int a() {
        return this.a;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.c
    public int b() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.c
    public long c() {
        return this.e;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.c
    @NonNull
    public String d() {
        return this.h;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.c
    @NonNull
    public String e() {
        return this.f1721b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.d.c)) {
            return false;
        }
        CrashlyticsReport.d.c cVar = (CrashlyticsReport.d.c) obj;
        return this.a == cVar.a() && this.f1721b.equals(cVar.e()) && this.c == cVar.b() && this.d == cVar.g() && this.e == cVar.c() && this.f == cVar.i() && this.g == cVar.h() && this.h.equals(cVar.d()) && this.i.equals(cVar.f());
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.c
    @NonNull
    public String f() {
        return this.i;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.c
    public long g() {
        return this.d;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.c
    public int h() {
        return this.g;
    }

    public int hashCode() {
        int iHashCode = (((((this.a ^ 1000003) * 1000003) ^ this.f1721b.hashCode()) * 1000003) ^ this.c) * 1000003;
        long j = this.d;
        int i = (iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.e;
        return ((((((((i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ (this.f ? 1231 : 1237)) * 1000003) ^ this.g) * 1000003) ^ this.h.hashCode()) * 1000003) ^ this.i.hashCode();
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.c
    public boolean i() {
        return this.f;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Device{arch=");
        sbU.append(this.a);
        sbU.append(", model=");
        sbU.append(this.f1721b);
        sbU.append(", cores=");
        sbU.append(this.c);
        sbU.append(", ram=");
        sbU.append(this.d);
        sbU.append(", diskSpace=");
        sbU.append(this.e);
        sbU.append(", simulator=");
        sbU.append(this.f);
        sbU.append(", state=");
        sbU.append(this.g);
        sbU.append(", manufacturer=");
        sbU.append(this.h);
        sbU.append(", modelClass=");
        return outline.J(sbU, this.i, "}");
    }
}
