package b.i.c.m.d.m;

import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.c.m.d.m.CrashlyticsReport;

/* JADX INFO: renamed from: b.i.c.m.d.m.r, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Device.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Event_Device extends CrashlyticsReport.d.AbstractC0049d.b {
    public final Double a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1733b;
    public final boolean c;
    public final int d;
    public final long e;
    public final long f;

    /* JADX INFO: renamed from: b.i.c.m.d.m.r$b */
    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Device.java */
    public static final class b extends CrashlyticsReport.d.AbstractC0049d.b.a {
        public Double a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f1734b;
        public Boolean c;
        public Integer d;
        public Long e;
        public Long f;

        public CrashlyticsReport.d.AbstractC0049d.b a() {
            String strW = this.f1734b == null ? " batteryVelocity" : "";
            if (this.c == null) {
                strW = outline.w(strW, " proximityOn");
            }
            if (this.d == null) {
                strW = outline.w(strW, " orientation");
            }
            if (this.e == null) {
                strW = outline.w(strW, " ramUsed");
            }
            if (this.f == null) {
                strW = outline.w(strW, " diskUsed");
            }
            if (strW.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Device(this.a, this.f1734b.intValue(), this.c.booleanValue(), this.d.intValue(), this.e.longValue(), this.f.longValue(), null);
            }
            throw new IllegalStateException(outline.w("Missing required properties:", strW));
        }
    }

    public AutoValue_CrashlyticsReport_Session_Event_Device(Double d, int i, boolean z2, int i2, long j, long j2, a aVar) {
        this.a = d;
        this.f1733b = i;
        this.c = z2;
        this.d = i2;
        this.e = j;
        this.f = j2;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.b
    @Nullable
    public Double a() {
        return this.a;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.b
    public int b() {
        return this.f1733b;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.b
    public long c() {
        return this.f;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.b
    public int d() {
        return this.d;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.b
    public long e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.d.AbstractC0049d.b)) {
            return false;
        }
        CrashlyticsReport.d.AbstractC0049d.b bVar = (CrashlyticsReport.d.AbstractC0049d.b) obj;
        Double d = this.a;
        if (d != null ? d.equals(bVar.a()) : bVar.a() == null) {
            if (this.f1733b == bVar.b() && this.c == bVar.f() && this.d == bVar.d() && this.e == bVar.e() && this.f == bVar.c()) {
                return true;
            }
        }
        return false;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.b
    public boolean f() {
        return this.c;
    }

    public int hashCode() {
        Double d = this.a;
        int iHashCode = ((((((((d == null ? 0 : d.hashCode()) ^ 1000003) * 1000003) ^ this.f1733b) * 1000003) ^ (this.c ? 1231 : 1237)) * 1000003) ^ this.d) * 1000003;
        long j = this.e;
        long j2 = this.f;
        return ((iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = outline.U("Device{batteryLevel=");
        sbU.append(this.a);
        sbU.append(", batteryVelocity=");
        sbU.append(this.f1733b);
        sbU.append(", proximityOn=");
        sbU.append(this.c);
        sbU.append(", orientation=");
        sbU.append(this.d);
        sbU.append(", ramUsed=");
        sbU.append(this.e);
        sbU.append(", diskUsed=");
        return outline.C(sbU, this.f, "}");
    }
}
