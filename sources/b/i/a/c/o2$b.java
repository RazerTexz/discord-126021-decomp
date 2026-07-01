package b.i.a.c;

import androidx.annotation.Nullable;
import b.i.a.c.a3.p0.c$a;
import java.util.Objects;

/* JADX INFO: compiled from: Timeline.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o2$b implements w0 {

    @Nullable
    public Object j;

    @Nullable
    public Object k;
    public int l;
    public long m;
    public long n;
    public boolean o;
    public b.i.a.c.a3.p0.c p = b.i.a.c.a3.p0.c.j;

    public long a(int i, int i2) {
        c$a c_aA = this.p.a(i);
        if (c_aA.l != -1) {
            return c_aA.o[i2];
        }
        return -9223372036854775807L;
    }

    public int b(long j) {
        b.i.a.c.a3.p0.c cVar = this.p;
        long j2 = this.m;
        Objects.requireNonNull(cVar);
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        if (j2 != -9223372036854775807L && j >= j2) {
            return -1;
        }
        int i = cVar.q;
        while (i < cVar.n) {
            if (cVar.a(i).k == Long.MIN_VALUE || cVar.a(i).k > j) {
                c$a c_aA = cVar.a(i);
                if (c_aA.l == -1 || c_aA.a(-1) < c_aA.l) {
                    break;
                }
            }
            i++;
        }
        if (i < cVar.n) {
            return i;
        }
        return -1;
    }

    public long c(int i) {
        return this.p.a(i).k;
    }

    public int d(int i) {
        return this.p.a(i).a(-1);
    }

    public boolean e(int i) {
        return this.p.a(i).q;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !o2$b.class.equals(obj.getClass())) {
            return false;
        }
        o2$b o2_b = (o2$b) obj;
        return b.i.a.c.f3.e0.a(this.j, o2_b.j) && b.i.a.c.f3.e0.a(this.k, o2_b.k) && this.l == o2_b.l && this.m == o2_b.m && this.n == o2_b.n && this.o == o2_b.o && b.i.a.c.f3.e0.a(this.p, o2_b.p);
    }

    public o2$b f(@Nullable Object obj, @Nullable Object obj2, int i, long j, long j2, b.i.a.c.a3.p0.c cVar, boolean z2) {
        this.j = obj;
        this.k = obj2;
        this.l = i;
        this.m = j;
        this.n = j2;
        this.p = cVar;
        this.o = z2;
        return this;
    }

    public int hashCode() {
        Object obj = this.j;
        int iHashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
        Object obj2 = this.k;
        int iHashCode2 = (((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.l) * 31;
        long j = this.m;
        int i = (iHashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.n;
        return this.p.hashCode() + ((((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.o ? 1 : 0)) * 31);
    }
}
