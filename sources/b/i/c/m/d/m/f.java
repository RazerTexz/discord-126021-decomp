package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends v$d {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1718b;
    public final long c;
    public final Long d;
    public final boolean e;
    public final v$d$a f;
    public final v$d$f g;
    public final v$d$e h;
    public final v$d$c i;
    public final w<v$d$d> j;
    public final int k;

    public f(String str, String str2, long j, Long l, boolean z2, v$d$a v_d_a, v$d$f v_d_f, v$d$e v_d_e, v$d$c v_d_c, w wVar, int i, f$a f_a) {
        this.a = str;
        this.f1718b = str2;
        this.c = j;
        this.d = l;
        this.e = z2;
        this.f = v_d_a;
        this.g = v_d_f;
        this.h = v_d_e;
        this.i = v_d_c;
        this.j = wVar;
        this.k = i;
    }

    @Override // b.i.c.m.d.m.v$d
    @NonNull
    public v$d$a a() {
        return this.f;
    }

    @Override // b.i.c.m.d.m.v$d
    @Nullable
    public v$d$c b() {
        return this.i;
    }

    @Override // b.i.c.m.d.m.v$d
    @Nullable
    public Long c() {
        return this.d;
    }

    @Override // b.i.c.m.d.m.v$d
    @Nullable
    public w<v$d$d> d() {
        return this.j;
    }

    @Override // b.i.c.m.d.m.v$d
    @NonNull
    public String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        Long l;
        v$d$f v_d_f;
        v$d$e v_d_e;
        v$d$c v_d_c;
        w<v$d$d> wVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v$d)) {
            return false;
        }
        v$d v_d = (v$d) obj;
        return this.a.equals(v_d.e()) && this.f1718b.equals(v_d.g()) && this.c == v_d.i() && ((l = this.d) != null ? l.equals(v_d.c()) : v_d.c() == null) && this.e == v_d.k() && this.f.equals(v_d.a()) && ((v_d_f = this.g) != null ? v_d_f.equals(v_d.j()) : v_d.j() == null) && ((v_d_e = this.h) != null ? v_d_e.equals(v_d.h()) : v_d.h() == null) && ((v_d_c = this.i) != null ? v_d_c.equals(v_d.b()) : v_d.b() == null) && ((wVar = this.j) != null ? wVar.equals(v_d.d()) : v_d.d() == null) && this.k == v_d.f();
    }

    @Override // b.i.c.m.d.m.v$d
    public int f() {
        return this.k;
    }

    @Override // b.i.c.m.d.m.v$d
    @NonNull
    public String g() {
        return this.f1718b;
    }

    @Override // b.i.c.m.d.m.v$d
    @Nullable
    public v$d$e h() {
        return this.h;
    }

    public int hashCode() {
        int iHashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f1718b.hashCode()) * 1000003;
        long j = this.c;
        int i = (iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        Long l = this.d;
        int iHashCode2 = (((((i ^ (l == null ? 0 : l.hashCode())) * 1000003) ^ (this.e ? 1231 : 1237)) * 1000003) ^ this.f.hashCode()) * 1000003;
        v$d$f v_d_f = this.g;
        int iHashCode3 = (iHashCode2 ^ (v_d_f == null ? 0 : v_d_f.hashCode())) * 1000003;
        v$d$e v_d_e = this.h;
        int iHashCode4 = (iHashCode3 ^ (v_d_e == null ? 0 : v_d_e.hashCode())) * 1000003;
        v$d$c v_d_c = this.i;
        int iHashCode5 = (iHashCode4 ^ (v_d_c == null ? 0 : v_d_c.hashCode())) * 1000003;
        w<v$d$d> wVar = this.j;
        return ((iHashCode5 ^ (wVar != null ? wVar.hashCode() : 0)) * 1000003) ^ this.k;
    }

    @Override // b.i.c.m.d.m.v$d
    public long i() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.v$d
    @Nullable
    public v$d$f j() {
        return this.g;
    }

    @Override // b.i.c.m.d.m.v$d
    public boolean k() {
        return this.e;
    }

    @Override // b.i.c.m.d.m.v$d
    public v$d$b l() {
        return new f$b(this, null);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Session{generator=");
        sbU.append(this.a);
        sbU.append(", identifier=");
        sbU.append(this.f1718b);
        sbU.append(", startedAt=");
        sbU.append(this.c);
        sbU.append(", endedAt=");
        sbU.append(this.d);
        sbU.append(", crashed=");
        sbU.append(this.e);
        sbU.append(", app=");
        sbU.append(this.f);
        sbU.append(", user=");
        sbU.append(this.g);
        sbU.append(", os=");
        sbU.append(this.h);
        sbU.append(", device=");
        sbU.append(this.i);
        sbU.append(", events=");
        sbU.append(this.j);
        sbU.append(", generatorType=");
        return b.d.b.a.a.B(sbU, this.k, "}");
    }
}
