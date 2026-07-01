package com.google.android.gms.internal.measurement;

import b.i.a.f.h.l.c6;
import b.i.a.f.h.l.e4;
import b.i.a.f.h.l.g4;
import b.i.a.f.h.l.h5;
import b.i.a.f.h.l.j7;
import b.i.a.f.h.l.k7;
import b.i.a.f.h.l.l3;
import b.i.a.f.h.l.o7;
import b.i.a.f.h.l.q6;
import b.i.a.f.h.l.t3;
import b.i.a.f.h.l.u3;
import b.i.a.f.h.l.w4;
import java.io.IOException;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhi extends u3 {
    public static final Logger a = Logger.getLogger(zzhi.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f3007b = j7.g;
    public g4 c;

    public zzhi() {
    }

    public static int B(int i, long j) {
        return F(j) + L(i << 3);
    }

    public static int D(int i) {
        return L(i << 3);
    }

    public static int E(int i, long j) {
        return F(j) + L(i << 3);
    }

    public static int F(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static int H(int i) {
        if (i >= 0) {
            return L(i);
        }
        return 10;
    }

    public static int I(int i, int i2) {
        return H(i2) + L(i << 3);
    }

    public static int J(int i, long j) {
        return F(R(j)) + L(i << 3);
    }

    public static int K(long j) {
        return F(R(j));
    }

    public static int L(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int M(int i, int i2) {
        return L(i2) + L(i << 3);
    }

    public static int N(int i) {
        return L(i << 3) + 8;
    }

    public static int O(int i) {
        return L(V(i));
    }

    public static int P(int i, int i2) {
        return L(V(i2)) + L(i << 3);
    }

    public static int Q(int i) {
        return L(i << 3) + 8;
    }

    public static long R(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int S(int i) {
        return L(i << 3) + 4;
    }

    public static int T(int i) {
        return L(i << 3) + 4;
    }

    public static int U(int i, int i2) {
        return H(i2) + L(i << 3);
    }

    public static int V(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int b(h5 h5Var) {
        int iA = h5Var.a();
        return L(iA) + iA;
    }

    public static int c(c6 c6Var, q6 q6Var) {
        l3 l3Var = (l3) c6Var;
        int iE = l3Var.e();
        if (iE == -1) {
            iE = q6Var.e(l3Var);
            l3Var.l(iE);
        }
        return L(iE) + iE;
    }

    public static int n(int i) {
        return L(i << 3) + 4;
    }

    public static int o(int i, String str) {
        return q(str) + L(i << 3);
    }

    public static int p(t3 t3Var) {
        int iD = t3Var.d();
        return L(iD) + iD;
    }

    public static int q(String str) {
        int length;
        try {
            length = k7.a(str);
        } catch (o7 unused) {
            length = str.getBytes(w4.a).length;
        }
        return L(length) + length;
    }

    public static int u(int i) {
        return L(i << 3) + 8;
    }

    public static int v(int i) {
        return L(i << 3) + 1;
    }

    public static int w(int i, t3 t3Var) {
        int iL = L(i << 3);
        int iD = t3Var.d();
        return L(iD) + iD + iL;
    }

    @Deprecated
    public static int x(int i, c6 c6Var, q6 q6Var) {
        int iL = L(i << 3) << 1;
        l3 l3Var = (l3) c6Var;
        int iE = l3Var.e();
        if (iE == -1) {
            iE = q6Var.e(l3Var);
            l3Var.l(iE);
        }
        return iL + iE;
    }

    public abstract void A(long j) throws IOException;

    public abstract void C(int i) throws IOException;

    public abstract void G(int i, int i2) throws IOException;

    public abstract int a();

    public abstract void d(byte b2) throws IOException;

    public abstract void e(int i) throws IOException;

    public abstract void f(int i, int i2) throws IOException;

    public abstract void g(int i, long j) throws IOException;

    public abstract void h(int i, t3 t3Var) throws IOException;

    public abstract void i(int i, c6 c6Var) throws IOException;

    public abstract void j(int i, c6 c6Var, q6 q6Var) throws IOException;

    public abstract void k(int i, String str) throws IOException;

    public abstract void l(int i, boolean z2) throws IOException;

    public abstract void m(long j) throws IOException;

    public abstract void r(int i) throws IOException;

    public abstract void s(int i, int i2) throws IOException;

    public abstract void t(int i, t3 t3Var) throws IOException;

    public abstract void y(int i, int i2) throws IOException;

    public abstract void z(int i, long j) throws IOException;

    public zzhi(e4 e4Var) {
    }
}
