package b.i.a.c;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.i.a.c.a3.a0$a;
import b.i.b.b.p$a;

/* JADX INFO: compiled from: MediaPeriodQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s1 {
    public final o2$b a = new o2$b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o2$c f1062b = new o2$c();

    @Nullable
    public final b.i.a.c.s2.g1 c;
    public final Handler d;
    public long e;
    public int f;
    public boolean g;

    @Nullable
    public q1 h;

    @Nullable
    public q1 i;

    @Nullable
    public q1 j;
    public int k;

    @Nullable
    public Object l;
    public long m;

    public s1(@Nullable b.i.a.c.s2.g1 g1Var, Handler handler) {
        this.c = g1Var;
        this.d = handler;
    }

    public static a0$a p(o2 o2Var, Object obj, long j, long j2, o2$b o2_b) {
        o2Var.h(obj, o2_b);
        b.i.a.c.a3.p0.c cVar = o2_b.p;
        long j3 = o2_b.m;
        int i = cVar.n - 1;
        while (i >= 0) {
            boolean z2 = false;
            if (j != Long.MIN_VALUE) {
                long j4 = cVar.a(i).k;
                if (j4 != Long.MIN_VALUE ? j < j4 : !(j3 != -9223372036854775807L && j >= j3)) {
                    z2 = true;
                }
            }
            if (!z2) {
                break;
            }
            i--;
        }
        if (i < 0 || !cVar.a(i).b()) {
            i = -1;
        }
        if (i == -1) {
            return new a0$a(obj, j2, o2_b.b(j));
        }
        return new a0$a(obj, i, o2_b.d(i), j2);
    }

    @Nullable
    public q1 a() {
        q1 q1Var = this.h;
        if (q1Var == null) {
            return null;
        }
        if (q1Var == this.i) {
            this.i = q1Var.l;
        }
        q1Var.h();
        int i = this.k - 1;
        this.k = i;
        if (i == 0) {
            this.j = null;
            q1 q1Var2 = this.h;
            this.l = q1Var2.f1056b;
            this.m = q1Var2.f.a.d;
        }
        this.h = this.h.l;
        l();
        return this.h;
    }

    public void b() {
        if (this.k == 0) {
            return;
        }
        q1 q1Var = this.h;
        b.c.a.a0.d.H(q1Var);
        q1 q1Var2 = q1Var;
        this.l = q1Var2.f1056b;
        this.m = q1Var2.f.a.d;
        while (q1Var2 != null) {
            q1Var2.h();
            q1Var2 = q1Var2.l;
        }
        this.h = null;
        this.j = null;
        this.i = null;
        this.k = 0;
        l();
    }

    @Nullable
    public final r1 c(o2 o2Var, q1 q1Var, long j) {
        long j2;
        r1 r1Var = q1Var.f;
        long j3 = (q1Var.o + r1Var.e) - j;
        long j4 = 0;
        if (r1Var.g) {
            int iD = o2Var.d(o2Var.b(r1Var.a.a), this.a, this.f1062b, this.f, this.g);
            if (iD == -1) {
                return null;
            }
            int i = o2Var.g(iD, this.a, true).l;
            Object obj = this.a.k;
            long j5 = r1Var.a.d;
            if (o2Var.n(i, this.f1062b).B == iD) {
                Pair<Object, Long> pairK = o2Var.k(this.f1062b, this.a, i, -9223372036854775807L, Math.max(0L, j3));
                if (pairK == null) {
                    return null;
                }
                obj = pairK.first;
                long jLongValue = ((Long) pairK.second).longValue();
                q1 q1Var2 = q1Var.l;
                if (q1Var2 == null || !q1Var2.f1056b.equals(obj)) {
                    j5 = this.e;
                    this.e = 1 + j5;
                } else {
                    j5 = q1Var2.f.a.d;
                }
                j2 = jLongValue;
                j4 = -9223372036854775807L;
            } else {
                j2 = 0;
            }
            return d(o2Var, p(o2Var, obj, j2, j5, this.a), j4, j2);
        }
        a0$a a0_a = r1Var.a;
        o2Var.h(a0_a.a, this.a);
        if (!a0_a.a()) {
            int iD2 = this.a.d(a0_a.e);
            if (iD2 != this.a.p.a(a0_a.e).l) {
                return e(o2Var, a0_a.a, a0_a.e, iD2, r1Var.e, a0_a.d);
            }
            return f(o2Var, a0_a.a, g(o2Var, a0_a.a, a0_a.e), r1Var.e, a0_a.d);
        }
        int i2 = a0_a.f835b;
        int i3 = this.a.p.a(i2).l;
        if (i3 == -1) {
            return null;
        }
        int iA = this.a.p.a(i2).a(a0_a.c);
        if (iA < i3) {
            return e(o2Var, a0_a.a, i2, iA, r1Var.c, a0_a.d);
        }
        long jLongValue2 = r1Var.c;
        if (jLongValue2 == -9223372036854775807L) {
            o2$c o2_c = this.f1062b;
            o2$b o2_b = this.a;
            Pair<Object, Long> pairK2 = o2Var.k(o2_c, o2_b, o2_b.l, -9223372036854775807L, Math.max(0L, j3));
            if (pairK2 == null) {
                return null;
            }
            jLongValue2 = ((Long) pairK2.second).longValue();
        }
        return f(o2Var, a0_a.a, Math.max(g(o2Var, a0_a.a, a0_a.f835b), jLongValue2), r1Var.c, a0_a.d);
    }

    @Nullable
    public final r1 d(o2 o2Var, a0$a a0_a, long j, long j2) {
        o2Var.h(a0_a.a, this.a);
        return a0_a.a() ? e(o2Var, a0_a.a, a0_a.f835b, a0_a.c, j, a0_a.d) : f(o2Var, a0_a.a, j2, j, a0_a.d);
    }

    public final r1 e(o2 o2Var, Object obj, int i, int i2, long j, long j2) {
        a0$a a0_a = new a0$a(obj, i, i2, j2);
        long jA = o2Var.h(obj, this.a).a(i, i2);
        long j3 = i2 == this.a.p.a(i).a(-1) ? this.a.p.o : 0L;
        return new r1(a0_a, (jA == -9223372036854775807L || j3 < jA) ? j3 : Math.max(0L, jA - 1), j, -9223372036854775807L, jA, this.a.p.a(i).q, false, false, false);
    }

    public final r1 f(o2 o2Var, Object obj, long j, long j2, long j3) {
        long jMax = j;
        o2Var.h(obj, this.a);
        int iB = this.a.b(jMax);
        a0$a a0_a = new a0$a(obj, j3, iB);
        boolean zI = i(a0_a);
        boolean zK = k(o2Var, a0_a);
        boolean zJ = j(o2Var, a0_a, zI);
        boolean z2 = iB != -1 && this.a.e(iB);
        long jC = iB != -1 ? this.a.c(iB) : -9223372036854775807L;
        long j4 = (jC == -9223372036854775807L || jC == Long.MIN_VALUE) ? this.a.m : jC;
        if (j4 != -9223372036854775807L && jMax >= j4) {
            jMax = Math.max(0L, j4 - 1);
        }
        return new r1(a0_a, jMax, j2, jC, j4, z2, zI, zK, zJ);
    }

    public final long g(o2 o2Var, Object obj, int i) {
        o2Var.h(obj, this.a);
        long j = this.a.p.a(i).k;
        return j == Long.MIN_VALUE ? this.a.m : j + this.a.p.a(i).p;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0060  */
    /* JADX WARN: Code duplicated, block: B:23:0x006a  */
    /* JADX WARN: Code duplicated, block: B:28:0x0079  */
    public r1 h(o2 o2Var, r1 r1Var) {
        long jA;
        long j;
        int i;
        boolean zE;
        int i2;
        a0$a a0_a = r1Var.a;
        boolean zI = i(a0_a);
        boolean zK = k(o2Var, a0_a);
        boolean zJ = j(o2Var, a0_a, zI);
        o2Var.h(r1Var.a.a, this.a);
        long jC = (a0_a.a() || (i2 = a0_a.e) == -1) ? -9223372036854775807L : this.a.c(i2);
        if (!a0_a.a()) {
            if (jC == -9223372036854775807L || jC == Long.MIN_VALUE) {
                jA = this.a.m;
            } else {
                j = jC;
            }
            if (a0_a.a()) {
                zE = this.a.e(a0_a.f835b);
            } else {
                i = a0_a.e;
                if (i == -1 && this.a.e(i)) {
                    zE = true;
                } else {
                    zE = false;
                }
            }
            return new r1(a0_a, r1Var.f1058b, r1Var.c, jC, j, zE, zI, zK, zJ);
        }
        jA = this.a.a(a0_a.f835b, a0_a.c);
        j = jA;
        if (a0_a.a()) {
            zE = this.a.e(a0_a.f835b);
        } else {
            i = a0_a.e;
            if (i == -1) {
                zE = false;
            } else {
                zE = false;
            }
        }
        return new r1(a0_a, r1Var.f1058b, r1Var.c, jC, j, zE, zI, zK, zJ);
    }

    public final boolean i(a0$a a0_a) {
        return !a0_a.a() && a0_a.e == -1;
    }

    public final boolean j(o2 o2Var, a0$a a0_a, boolean z2) {
        int iB = o2Var.b(a0_a.a);
        if (o2Var.n(o2Var.f(iB, this.a).l, this.f1062b).v) {
            return false;
        }
        return (o2Var.d(iB, this.a, this.f1062b, this.f, this.g) == -1) && z2;
    }

    public final boolean k(o2 o2Var, a0$a a0_a) {
        if (i(a0_a)) {
            return o2Var.n(o2Var.h(a0_a.a, this.a).l, this.f1062b).C == o2Var.b(a0_a.a);
        }
        return false;
    }

    public final void l() {
        if (this.c != null) {
            b.i.b.b.a<Object> aVar = b.i.b.b.p.k;
            p$a p_a = new p$a();
            for (q1 q1Var = this.h; q1Var != null; q1Var = q1Var.l) {
                p_a.b(q1Var.f.a);
            }
            q1 q1Var2 = this.i;
            this.d.post(new m0(this, p_a, q1Var2 == null ? null : q1Var2.f.a));
        }
    }

    public void m(long j) {
        q1 q1Var = this.j;
        if (q1Var != null) {
            b.c.a.a0.d.D(q1Var.g());
            if (q1Var.d) {
                q1Var.a.s(j - q1Var.o);
            }
        }
    }

    public boolean n(q1 q1Var) {
        boolean z2 = false;
        b.c.a.a0.d.D(q1Var != null);
        if (q1Var.equals(this.j)) {
            return false;
        }
        this.j = q1Var;
        while (true) {
            q1Var = q1Var.l;
            if (q1Var == null) {
                break;
            }
            if (q1Var == this.i) {
                this.i = this.h;
                z2 = true;
            }
            q1Var.h();
            this.k--;
        }
        q1 q1Var2 = this.j;
        if (q1Var2.l != null) {
            q1Var2.b();
            q1Var2.l = null;
            q1Var2.c();
        }
        l();
        return z2;
    }

    public a0$a o(o2 o2Var, Object obj, long j) {
        long j2;
        int iB;
        int i = o2Var.h(obj, this.a).l;
        Object obj2 = this.l;
        if (obj2 == null || (iB = o2Var.b(obj2)) == -1 || o2Var.f(iB, this.a).l != i) {
            for (q1 q1Var = this.h; q1Var != null; q1Var = q1Var.l) {
                if (q1Var.f1056b.equals(obj)) {
                    j2 = q1Var.f.a.d;
                }
            }
            for (q1 q1Var2 = this.h; q1Var2 != null; q1Var2 = q1Var2.l) {
                int iB2 = o2Var.b(q1Var2.f1056b);
                if (iB2 != -1 && o2Var.f(iB2, this.a).l == i) {
                    j2 = q1Var2.f.a.d;
                }
            }
            j2 = this.e;
            this.e = 1 + j2;
            if (this.h == null) {
                this.l = obj;
                this.m = j2;
            }
        } else {
            j2 = this.m;
        }
        return p(o2Var, obj, j, j2, this.a);
    }

    public final boolean q(o2 o2Var) {
        q1 q1Var;
        q1 q1Var2 = this.h;
        if (q1Var2 == null) {
            return true;
        }
        int iB = o2Var.b(q1Var2.f1056b);
        while (true) {
            iB = o2Var.d(iB, this.a, this.f1062b, this.f, this.g);
            while (true) {
                q1Var = q1Var2.l;
                if (q1Var == null || q1Var2.f.g) {
                    break;
                }
                q1Var2 = q1Var;
            }
            if (iB == -1 || q1Var == null || o2Var.b(q1Var.f1056b) != iB) {
                break;
            }
            q1Var2 = q1Var;
        }
        boolean zN = n(q1Var2);
        q1Var2.f = h(o2Var, q1Var2.f);
        return !zN;
    }

    public boolean r(o2 o2Var, long j, long j2) {
        boolean zN;
        r1 r1VarH;
        q1 q1Var = this.h;
        q1 q1Var2 = null;
        while (q1Var != null) {
            r1 r1Var = q1Var.f;
            if (q1Var2 != null) {
                r1 r1VarC = c(o2Var, q1Var2, j);
                if (r1VarC == null) {
                    zN = n(q1Var2);
                } else {
                    if (r1Var.f1058b == r1VarC.f1058b && r1Var.a.equals(r1VarC.a)) {
                        r1VarH = r1VarC;
                    } else {
                        zN = n(q1Var2);
                    }
                }
                return !zN;
            }
            r1VarH = h(o2Var, r1Var);
            q1Var.f = r1VarH.a(r1Var.c);
            long j3 = r1Var.e;
            if (!(j3 == -9223372036854775807L || j3 == r1VarH.e)) {
                q1Var.j();
                long j4 = r1VarH.e;
                return (n(q1Var) || (q1Var == this.i && !q1Var.f.f && ((j2 > Long.MIN_VALUE ? 1 : (j2 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j2 > ((j4 > (-9223372036854775807L) ? 1 : (j4 == (-9223372036854775807L) ? 0 : -1)) == 0 ? RecyclerView.FOREVER_NS : j4 + q1Var.o) ? 1 : (j2 == ((j4 > (-9223372036854775807L) ? 1 : (j4 == (-9223372036854775807L) ? 0 : -1)) == 0 ? RecyclerView.FOREVER_NS : j4 + q1Var.o) ? 0 : -1)) >= 0))) ? false : true;
            }
            q1Var2 = q1Var;
            q1Var = q1Var.l;
        }
        return true;
    }
}
