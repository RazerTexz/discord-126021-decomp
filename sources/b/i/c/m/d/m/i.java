package b.i.c.m.d.m;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Device.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends v$d$c {
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

    public i(int i, String str, int i2, long j, long j2, boolean z2, int i3, String str2, String str3, i$a i_a) {
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

    @Override // b.i.c.m.d.m.v$d$c
    @NonNull
    public int a() {
        return this.a;
    }

    @Override // b.i.c.m.d.m.v$d$c
    public int b() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.v$d$c
    public long c() {
        return this.e;
    }

    @Override // b.i.c.m.d.m.v$d$c
    @NonNull
    public String d() {
        return this.h;
    }

    @Override // b.i.c.m.d.m.v$d$c
    @NonNull
    public String e() {
        return this.f1721b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v$d$c)) {
            return false;
        }
        v$d$c v_d_c = (v$d$c) obj;
        return this.a == v_d_c.a() && this.f1721b.equals(v_d_c.e()) && this.c == v_d_c.b() && this.d == v_d_c.g() && this.e == v_d_c.c() && this.f == v_d_c.i() && this.g == v_d_c.h() && this.h.equals(v_d_c.d()) && this.i.equals(v_d_c.f());
    }

    @Override // b.i.c.m.d.m.v$d$c
    @NonNull
    public String f() {
        return this.i;
    }

    @Override // b.i.c.m.d.m.v$d$c
    public long g() {
        return this.d;
    }

    @Override // b.i.c.m.d.m.v$d$c
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

    @Override // b.i.c.m.d.m.v$d$c
    public boolean i() {
        return this.f;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Device{arch=");
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
        return b.d.b.a.a.J(sbU, this.i, "}");
    }
}
