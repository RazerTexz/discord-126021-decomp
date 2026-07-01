package b.i.a.c;

import androidx.annotation.Nullable;
import b.i.a.c.a3.a0$a;

/* JADX INFO: compiled from: MediaPeriodInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r1 {
    public final a0$a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1058b;
    public final long c;
    public final long d;
    public final long e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    public r1(a0$a a0_a, long j, long j2, long j3, long j4, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6 = false;
        b.c.a.a0.d.j(!z5 || z3);
        b.c.a.a0.d.j(!z4 || z3);
        if (!z2 || (!z3 && !z4 && !z5)) {
            z6 = true;
        }
        b.c.a.a0.d.j(z6);
        this.a = a0_a;
        this.f1058b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = z2;
        this.g = z3;
        this.h = z4;
        this.i = z5;
    }

    public r1 a(long j) {
        return j == this.c ? this : new r1(this.a, this.f1058b, j, this.d, this.e, this.f, this.g, this.h, this.i);
    }

    public r1 b(long j) {
        return j == this.f1058b ? this : new r1(this.a, j, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r1.class != obj.getClass()) {
            return false;
        }
        r1 r1Var = (r1) obj;
        return this.f1058b == r1Var.f1058b && this.c == r1Var.c && this.d == r1Var.d && this.e == r1Var.e && this.f == r1Var.f && this.g == r1Var.g && this.h == r1Var.h && this.i == r1Var.i && b.i.a.c.f3.e0.a(this.a, r1Var.a);
    }

    public int hashCode() {
        return ((((((((((((((((this.a.hashCode() + 527) * 31) + ((int) this.f1058b)) * 31) + ((int) this.c)) * 31) + ((int) this.d)) * 31) + ((int) this.e)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0);
    }
}
