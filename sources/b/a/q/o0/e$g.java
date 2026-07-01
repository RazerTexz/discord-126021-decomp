package b.a.q.o0;

import d0.z.d.m;

/* JADX INFO: compiled from: VideoQuality.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e$g {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f284b;
    public final e$a c;

    public e$g(long j, long j2, e$a e_a) {
        m.checkNotNullParameter(e_a, "aggregatedProperties");
        this.a = j;
        this.f284b = j2;
        this.c = e_a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e$g)) {
            return false;
        }
        e$g e_g = (e$g) obj;
        return this.a == e_g.a && this.f284b == e_g.f284b && m.areEqual(this.c, e_g.c);
    }

    public int hashCode() {
        int iA = (a0.a.a.b.a(this.f284b) + (a0.a.a.b.a(this.a) * 31)) * 31;
        e$a e_a = this.c;
        return iA + (e_a != null ? e_a.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("RawVideoStats(resolution=");
        sbU.append(this.a);
        sbU.append(", timestamp=");
        sbU.append(this.f284b);
        sbU.append(", aggregatedProperties=");
        sbU.append(this.c);
        sbU.append(")");
        return sbU.toString();
    }

    public e$g() {
        this(0L, 0L, new e$a(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 16383));
    }
}
