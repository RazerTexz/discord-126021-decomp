package b.i.c.m.d.m;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Device.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends v$d$d$b {
    public final Double a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1733b;
    public final boolean c;
    public final int d;
    public final long e;
    public final long f;

    public r(Double d, int i, boolean z2, int i2, long j, long j2, r$a r_a) {
        this.a = d;
        this.f1733b = i;
        this.c = z2;
        this.d = i2;
        this.e = j;
        this.f = j2;
    }

    @Override // b.i.c.m.d.m.v$d$d$b
    @Nullable
    public Double a() {
        return this.a;
    }

    @Override // b.i.c.m.d.m.v$d$d$b
    public int b() {
        return this.f1733b;
    }

    @Override // b.i.c.m.d.m.v$d$d$b
    public long c() {
        return this.f;
    }

    @Override // b.i.c.m.d.m.v$d$d$b
    public int d() {
        return this.d;
    }

    @Override // b.i.c.m.d.m.v$d$d$b
    public long e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v$d$d$b)) {
            return false;
        }
        v$d$d$b v_d_d_b = (v$d$d$b) obj;
        Double d = this.a;
        if (d != null ? d.equals(v_d_d_b.a()) : v_d_d_b.a() == null) {
            if (this.f1733b == v_d_d_b.b() && this.c == v_d_d_b.f() && this.d == v_d_d_b.d() && this.e == v_d_d_b.e() && this.f == v_d_d_b.c()) {
                return true;
            }
        }
        return false;
    }

    @Override // b.i.c.m.d.m.v$d$d$b
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
        StringBuilder sbU = b.d.b.a.a.U("Device{batteryLevel=");
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
        return b.d.b.a.a.C(sbU, this.f, "}");
    }
}
