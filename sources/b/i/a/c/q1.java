package b.i.a.c;

import android.util.Pair;
import androidx.annotation.Nullable;
import b.i.a.c.a3.a0$a;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.util.Objects;

/* JADX INFO: compiled from: MediaPeriodHolder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q1 {
    public final b.i.a.c.a3.x a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1056b;
    public final b.i.a.c.a3.i0[] c;
    public boolean d;
    public boolean e;
    public r1 f;
    public boolean g;
    public final boolean[] h;
    public final g2[] i;
    public final b.i.a.c.c3.q j;
    public final u1 k;

    @Nullable
    public q1 l;
    public b.i.a.c.a3.o0 m;
    public b.i.a.c.c3.r n;
    public long o;

    public q1(g2[] g2VarArr, long j, b.i.a.c.c3.q qVar, b.i.a.c.e3.o oVar, u1 u1Var, r1 r1Var, b.i.a.c.c3.r rVar) {
        this.i = g2VarArr;
        this.o = j;
        this.j = qVar;
        this.k = u1Var;
        a0$a a0_a = r1Var.a;
        this.f1056b = a0_a.a;
        this.f = r1Var;
        this.m = b.i.a.c.a3.o0.j;
        this.n = rVar;
        this.c = new b.i.a.c.a3.i0[g2VarArr.length];
        this.h = new boolean[g2VarArr.length];
        long j2 = r1Var.f1058b;
        long j3 = r1Var.d;
        Objects.requireNonNull(u1Var);
        Pair pair = (Pair) a0_a.a;
        Object obj = pair.first;
        a0$a a0_aB = a0_a.b(pair.second);
        u1$c u1_c = u1Var.c.get(obj);
        Objects.requireNonNull(u1_c);
        u1Var.h.add(u1_c);
        u1$b u1_b = u1Var.g.get(u1_c);
        if (u1_b != null) {
            u1_b.a.m(u1_b.f1138b);
        }
        u1_c.c.add(a0_aB);
        b.i.a.c.a3.x xVarU = u1_c.a.u(a0_aB, oVar, j2);
        u1Var.f1137b.put(xVarU, u1_c);
        u1Var.d();
        this.a = j3 != -9223372036854775807L ? new b.i.a.c.a3.n(xVarU, true, 0L, j3) : xVarU;
    }

    public long a(b.i.a.c.c3.r rVar, long j, boolean z2, boolean[] zArr) {
        int i = 0;
        while (true) {
            boolean z3 = true;
            if (i >= rVar.a) {
                break;
            }
            boolean[] zArr2 = this.h;
            if (z2 || !rVar.a(this.n, i)) {
                z3 = false;
            }
            zArr2[i] = z3;
            i++;
        }
        b.i.a.c.a3.i0[] i0VarArr = this.c;
        int i2 = 0;
        while (true) {
            g2[] g2VarArr = this.i;
            if (i2 >= g2VarArr.length) {
                break;
            }
            if (((v0) g2VarArr[i2]).j == -2) {
                i0VarArr[i2] = null;
            }
            i2++;
        }
        b();
        this.n = rVar;
        c();
        long jM = this.a.m(rVar.c, this.h, this.c, zArr, j);
        b.i.a.c.a3.i0[] i0VarArr2 = this.c;
        int i3 = 0;
        while (true) {
            g2[] g2VarArr2 = this.i;
            if (i3 >= g2VarArr2.length) {
                break;
            }
            if (((v0) g2VarArr2[i3]).j == -2 && this.n.b(i3)) {
                i0VarArr2[i3] = new b.i.a.c.a3.q();
            }
            i3++;
        }
        this.e = false;
        int i4 = 0;
        while (true) {
            b.i.a.c.a3.i0[] i0VarArr3 = this.c;
            if (i4 >= i0VarArr3.length) {
                return jM;
            }
            if (i0VarArr3[i4] != null) {
                b.c.a.a0.d.D(rVar.b(i4));
                if (((v0) this.i[i4]).j != -2) {
                    this.e = true;
                }
            } else {
                b.c.a.a0.d.D(rVar.c[i4] == null);
            }
            i4++;
        }
    }

    public final void b() {
        if (!g()) {
            return;
        }
        int i = 0;
        while (true) {
            b.i.a.c.c3.r rVar = this.n;
            if (i >= rVar.a) {
                return;
            }
            boolean zB = rVar.b(i);
            b.i.a.c.c3.j jVar = this.n.c[i];
            if (zB && jVar != null) {
                jVar.g();
            }
            i++;
        }
    }

    public final void c() {
        if (!g()) {
            return;
        }
        int i = 0;
        while (true) {
            b.i.a.c.c3.r rVar = this.n;
            if (i >= rVar.a) {
                return;
            }
            boolean zB = rVar.b(i);
            b.i.a.c.c3.j jVar = this.n.c[i];
            if (zB && jVar != null) {
                jVar.e();
            }
            i++;
        }
    }

    public long d() {
        if (!this.d) {
            return this.f.f1058b;
        }
        long jQ = this.e ? this.a.q() : Long.MIN_VALUE;
        return jQ == Long.MIN_VALUE ? this.f.e : jQ;
    }

    public long e() {
        return this.f.f1058b + this.o;
    }

    public boolean f() {
        return this.d && (!this.e || this.a.q() == Long.MIN_VALUE);
    }

    public final boolean g() {
        return this.l == null;
    }

    public void h() {
        b();
        u1 u1Var = this.k;
        b.i.a.c.a3.x xVar = this.a;
        try {
            if (xVar instanceof b.i.a.c.a3.n) {
                u1Var.h(((b.i.a.c.a3.n) xVar).j);
            } else {
                u1Var.h(xVar);
            }
        } catch (RuntimeException e) {
            b.i.a.c.f3.q.b("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public b.i.a.c.c3.r i(float f, o2 o2Var) throws ExoPlaybackException {
        b.i.a.c.c3.r rVarB = this.j.b(this.i, this.m, this.f.a, o2Var);
        for (b.i.a.c.c3.j jVar : rVarB.c) {
            if (jVar != null) {
                jVar.i(f);
            }
        }
        return rVarB;
    }

    public void j() {
        b.i.a.c.a3.x xVar = this.a;
        if (xVar instanceof b.i.a.c.a3.n) {
            long j = this.f.d;
            if (j == -9223372036854775807L) {
                j = Long.MIN_VALUE;
            }
            b.i.a.c.a3.n nVar = (b.i.a.c.a3.n) xVar;
            nVar.n = 0L;
            nVar.o = j;
        }
    }
}
