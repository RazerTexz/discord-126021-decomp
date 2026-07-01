package b.i.a.c.a3;

import android.os.Looper;
import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import b.i.a.c.j1;
import b.i.a.c.j1$b;
import b.i.a.c.k1;
import b.i.a.c.w2.u$b;
import b.i.a.c.x2.w$a;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import java.io.EOFException;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: SampleQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public class h0 implements b.i.a.c.x2.w {

    @Nullable
    public j1 A;

    @Nullable
    public j1 B;
    public boolean C;
    public boolean D;
    public final g0 a;

    @Nullable
    public final b.i.a.c.w2.u d;

    @Nullable
    public final b.i.a.c.w2.s$a e;

    @Nullable
    public final Looper f;

    @Nullable
    public h0$d g;

    @Nullable
    public j1 h;

    @Nullable
    public DrmSession i;
    public int q;
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f820s;
    public int t;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f821x;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0$b f819b = new h0$b();
    public int j = 1000;
    public int[] k = new int[1000];
    public long[] l = new long[1000];
    public long[] o = new long[1000];
    public int[] n = new int[1000];
    public int[] m = new int[1000];
    public w$a[] p = new w$a[1000];
    public final m0<h0$c> c = new m0<>(k.a);
    public long u = Long.MIN_VALUE;
    public long v = Long.MIN_VALUE;
    public long w = Long.MIN_VALUE;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f823z = true;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f822y = true;

    public h0(b.i.a.c.e3.o oVar, @Nullable Looper looper, @Nullable b.i.a.c.w2.u uVar, @Nullable b.i.a.c.w2.s$a s_a) {
        this.f = looper;
        this.d = uVar;
        this.e = s_a;
        this.a = new g0(oVar);
    }

    @Override // b.i.a.c.x2.w
    public final int a(b.i.a.c.e3.h hVar, int i, boolean z2, int i2) throws IOException {
        g0 g0Var = this.a;
        int iC = g0Var.c(i);
        g0$a g0_a = g0Var.f;
        int i3 = hVar.read(g0_a.d.a, g0_a.a(g0Var.g), iC);
        if (i3 != -1) {
            g0Var.b(i3);
            return i3;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // b.i.a.c.x2.w
    public /* synthetic */ int b(b.i.a.c.e3.h hVar, int i, boolean z2) {
        return b.i.a.c.x2.v.a(this, hVar, i, z2);
    }

    @Override // b.i.a.c.x2.w
    public /* synthetic */ void c(b.i.a.c.f3.x xVar, int i) {
        b.i.a.c.x2.v.b(this, xVar, i);
    }

    @Override // b.i.a.c.x2.w
    public void d(long j, int i, int i2, int i3, @Nullable w$a w_a) {
        u$b u_bB;
        int i4 = i & 1;
        boolean z2 = i4 != 0;
        if (this.f822y) {
            if (!z2) {
                return;
            } else {
                this.f822y = false;
            }
        }
        long j2 = j + 0;
        if (this.C) {
            if (j2 < this.u) {
                return;
            }
            if (i4 == 0) {
                if (!this.D) {
                    String strValueOf = String.valueOf(this.B);
                    b.d.b.a.a.h0(strValueOf.length() + 50, "Overriding unexpected non-sync sample for format: ", strValueOf, "SampleQueue");
                    this.D = true;
                }
                i |= 1;
            }
        }
        long j3 = (this.a.g - ((long) i2)) - ((long) i3);
        synchronized (this) {
            int i5 = this.q;
            if (i5 > 0) {
                int iL = l(i5 - 1);
                b.c.a.a0.d.j(this.l[iL] + ((long) this.m[iL]) <= j3);
            }
            this.f821x = (536870912 & i) != 0;
            this.w = Math.max(this.w, j2);
            int iL2 = l(this.q);
            this.o[iL2] = j2;
            this.l[iL2] = j3;
            this.m[iL2] = i2;
            this.n[iL2] = i;
            this.p[iL2] = w_a;
            this.k[iL2] = 0;
            if ((this.c.f829b.size() == 0) || !this.c.c().a.equals(this.B)) {
                b.i.a.c.w2.u uVar = this.d;
                if (uVar != null) {
                    Looper looper = this.f;
                    Objects.requireNonNull(looper);
                    u_bB = uVar.b(looper, this.e, this.B);
                } else {
                    u_bB = b.i.a.c.w2.m.f1153b;
                }
                m0<h0$c> m0Var = this.c;
                int iN = n();
                j1 j1Var = this.B;
                Objects.requireNonNull(j1Var);
                m0Var.a(iN, new h0$c(j1Var, u_bB, null));
            }
            int i6 = this.q + 1;
            this.q = i6;
            int i7 = this.j;
            if (i6 == i7) {
                int i8 = i7 + 1000;
                int[] iArr = new int[i8];
                long[] jArr = new long[i8];
                long[] jArr2 = new long[i8];
                int[] iArr2 = new int[i8];
                int[] iArr3 = new int[i8];
                w$a[] w_aArr = new w$a[i8];
                int i9 = this.f820s;
                int i10 = i7 - i9;
                System.arraycopy(this.l, i9, jArr, 0, i10);
                System.arraycopy(this.o, this.f820s, jArr2, 0, i10);
                System.arraycopy(this.n, this.f820s, iArr2, 0, i10);
                System.arraycopy(this.m, this.f820s, iArr3, 0, i10);
                System.arraycopy(this.p, this.f820s, w_aArr, 0, i10);
                System.arraycopy(this.k, this.f820s, iArr, 0, i10);
                int i11 = this.f820s;
                System.arraycopy(this.l, 0, jArr, i10, i11);
                System.arraycopy(this.o, 0, jArr2, i10, i11);
                System.arraycopy(this.n, 0, iArr2, i10, i11);
                System.arraycopy(this.m, 0, iArr3, i10, i11);
                System.arraycopy(this.p, 0, w_aArr, i10, i11);
                System.arraycopy(this.k, 0, iArr, i10, i11);
                this.l = jArr;
                this.o = jArr2;
                this.n = iArr2;
                this.m = iArr3;
                this.p = w_aArr;
                this.k = iArr;
                this.f820s = 0;
                this.j = i8;
            }
        }
    }

    @Override // b.i.a.c.x2.w
    public final void e(j1 j1Var) {
        boolean z2;
        this.A = j1Var;
        synchronized (this) {
            z2 = false;
            this.f823z = false;
            if (!b.i.a.c.f3.e0.a(j1Var, this.B)) {
                if ((this.c.f829b.size() == 0) || !this.c.c().a.equals(j1Var)) {
                    this.B = j1Var;
                } else {
                    this.B = this.c.c().a;
                }
                j1 j1Var2 = this.B;
                this.C = b.i.a.c.f3.t.a(j1Var2.w, j1Var2.t);
                this.D = false;
                z2 = true;
            }
        }
        h0$d h0_d = this.g;
        if (h0_d == null || !z2) {
            return;
        }
        e0 e0Var = (e0) h0_d;
        e0Var.A.post(e0Var.f811y);
    }

    @Override // b.i.a.c.x2.w
    public final void f(b.i.a.c.f3.x xVar, int i, int i2) {
        g0 g0Var = this.a;
        Objects.requireNonNull(g0Var);
        while (i > 0) {
            int iC = g0Var.c(i);
            g0$a g0_a = g0Var.f;
            xVar.e(g0_a.d.a, g0_a.a(g0Var.g), iC);
            i -= iC;
            g0Var.b(iC);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @GuardedBy("this")
    public final long g(int i) {
        this.v = Math.max(this.v, j(i));
        this.q -= i;
        int i2 = this.r + i;
        this.r = i2;
        int i3 = this.f820s + i;
        this.f820s = i3;
        int i4 = this.j;
        if (i3 >= i4) {
            this.f820s = i3 - i4;
        }
        int i5 = this.t - i;
        this.t = i5;
        int i6 = 0;
        if (i5 < 0) {
            this.t = 0;
        }
        m0<h0$c> m0Var = this.c;
        while (i6 < m0Var.f829b.size() - 1) {
            int i7 = i6 + 1;
            if (i2 < m0Var.f829b.keyAt(i7)) {
                break;
            }
            m0Var.c.accept((V) m0Var.f829b.valueAt(i6));
            m0Var.f829b.removeAt(i6);
            int i8 = m0Var.a;
            if (i8 > 0) {
                m0Var.a = i8 - 1;
            }
            i6 = i7;
        }
        if (this.q != 0) {
            return this.l[this.f820s];
        }
        int i9 = this.f820s;
        if (i9 == 0) {
            i9 = this.j;
        }
        int i10 = i9 - 1;
        return this.l[i10] + ((long) this.m[i10]);
    }

    public final void h() {
        long jG;
        g0 g0Var = this.a;
        synchronized (this) {
            int i = this.q;
            jG = i == 0 ? -1L : g(i);
        }
        g0Var.a(jG);
    }

    public final int i(int i, int i2, long j, boolean z2) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long[] jArr = this.o;
            if (jArr[i] > j) {
                return i3;
            }
            if (!z2 || (this.n[i] & 1) != 0) {
                if (jArr[i] == j) {
                    return i4;
                }
                i3 = i4;
            }
            i++;
            if (i == this.j) {
                i = 0;
            }
        }
        return i3;
    }

    public final long j(int i) {
        long jMax = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int iL = l(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            jMax = Math.max(jMax, this.o[iL]);
            if ((this.n[iL] & 1) != 0) {
                break;
            }
            iL--;
            if (iL == -1) {
                iL = this.j - 1;
            }
        }
        return jMax;
    }

    public final int k() {
        return this.r + this.t;
    }

    public final int l(int i) {
        int i2 = this.f820s + i;
        int i3 = this.j;
        return i2 < i3 ? i2 : i2 - i3;
    }

    @Nullable
    public final synchronized j1 m() {
        return this.f823z ? null : this.B;
    }

    public final int n() {
        return this.r + this.q;
    }

    public final boolean o() {
        return this.t != this.q;
    }

    @CallSuper
    public synchronized boolean p(boolean z2) {
        j1 j1Var;
        boolean z3 = true;
        if (o()) {
            if (this.c.b(k()).a != this.h) {
                return true;
            }
            return q(l(this.t));
        }
        if (!z2 && !this.f821x && ((j1Var = this.B) == null || j1Var == this.h)) {
            z3 = false;
        }
        return z3;
    }

    public final boolean q(int i) {
        DrmSession drmSession = this.i;
        return drmSession == null || drmSession.getState() == 4 || ((this.n[i] & BasicMeasure.EXACTLY) == 0 && this.i.d());
    }

    public final void r(j1 j1Var, k1 k1Var) {
        j1 j1VarA;
        j1 j1Var2 = this.h;
        boolean z2 = j1Var2 == null;
        DrmInitData drmInitData = z2 ? null : j1Var2.f1020z;
        this.h = j1Var;
        DrmInitData drmInitData2 = j1Var.f1020z;
        b.i.a.c.w2.u uVar = this.d;
        if (uVar != null) {
            int iD = uVar.d(j1Var);
            j1$b j1_bA = j1Var.a();
            j1_bA.D = iD;
            j1VarA = j1_bA.a();
        } else {
            j1VarA = j1Var;
        }
        k1Var.f1027b = j1VarA;
        k1Var.a = this.i;
        if (this.d == null) {
            return;
        }
        if (z2 || !b.i.a.c.f3.e0.a(drmInitData, drmInitData2)) {
            DrmSession drmSession = this.i;
            b.i.a.c.w2.u uVar2 = this.d;
            Looper looper = this.f;
            Objects.requireNonNull(looper);
            DrmSession drmSessionC = uVar2.c(looper, this.e, j1Var);
            this.i = drmSessionC;
            k1Var.a = drmSessionC;
            if (drmSession != null) {
                drmSession.b(this.e);
            }
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @CallSuper
    public void s(boolean z2) {
        g0 g0Var = this.a;
        g0$a g0_a = g0Var.d;
        if (g0_a.c) {
            g0$a g0_a2 = g0Var.f;
            int i = (((int) (g0_a2.a - g0_a.a)) / g0Var.f817b) + g0_a2.c;
            b.i.a.c.e3.e[] eVarArr = new b.i.a.c.e3.e[i];
            int i2 = 0;
            while (i2 < i) {
                eVarArr[i2] = g0_a.d;
                g0_a.d = null;
                g0$a g0_a3 = g0_a.e;
                g0_a.e = null;
                i2++;
                g0_a = g0_a3;
            }
            g0Var.a.a(eVarArr);
        }
        g0$a g0_a4 = new g0$a(0L, g0Var.f817b);
        g0Var.d = g0_a4;
        g0Var.e = g0_a4;
        g0Var.f = g0_a4;
        g0Var.g = 0L;
        g0Var.a.c();
        this.q = 0;
        this.r = 0;
        this.f820s = 0;
        this.t = 0;
        this.f822y = true;
        this.u = Long.MIN_VALUE;
        this.v = Long.MIN_VALUE;
        this.w = Long.MIN_VALUE;
        this.f821x = false;
        m0<h0$c> m0Var = this.c;
        for (int i3 = 0; i3 < m0Var.f829b.size(); i3++) {
            m0Var.c.accept((V) m0Var.f829b.valueAt(i3));
        }
        m0Var.a = -1;
        m0Var.f829b.clear();
        if (z2) {
            this.A = null;
            this.B = null;
            this.f823z = true;
        }
    }

    public final synchronized boolean t(long j, boolean z2) {
        synchronized (this) {
            this.t = 0;
            g0 g0Var = this.a;
            g0Var.e = g0Var.d;
        }
        int iL = l(0);
        if (o() && j >= this.o[iL] && (j <= this.w || z2)) {
            int i = i(iL, this.q - this.t, j, true);
            if (i == -1) {
                return false;
            }
            this.u = j;
            this.t += i;
            return true;
        }
        return false;
    }
}
