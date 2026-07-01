package b.i.a.b.j.t.h;

import java.util.Set;

/* JADX INFO: compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends f$a {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f785b;
    public final Set<f$b> c;

    public c(long j, long j2, Set set, c$a c_a) {
        this.a = j;
        this.f785b = j2;
        this.c = set;
    }

    @Override // b.i.a.b.j.t.h.f$a
    public long b() {
        return this.a;
    }

    @Override // b.i.a.b.j.t.h.f$a
    public Set<f$b> c() {
        return this.c;
    }

    @Override // b.i.a.b.j.t.h.f$a
    public long d() {
        return this.f785b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f$a)) {
            return false;
        }
        f$a f_a = (f$a) obj;
        return this.a == f_a.b() && this.f785b == f_a.d() && this.c.equals(f_a.c());
    }

    public int hashCode() {
        long j = this.a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        long j2 = this.f785b;
        return this.c.hashCode() ^ ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("ConfigValue{delta=");
        sbU.append(this.a);
        sbU.append(", maxAllowedDelay=");
        sbU.append(this.f785b);
        sbU.append(", flags=");
        return b.d.b.a.a.N(sbU, this.c, "}");
    }
}
