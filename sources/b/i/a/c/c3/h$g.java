package b.i.a.c.c3;

import androidx.annotation.Nullable;
import b.i.a.c.j1;
import b.i.b.b.f0;
import b.i.b.b.g0;
import b.i.b.b.k0;

/* JADX INFO: compiled from: DefaultTrackSelector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h$g implements Comparable<h$g> {
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final boolean r;

    public h$g(j1 j1Var, h$d h_d, int i, @Nullable String str) {
        int iC;
        boolean z2 = false;
        this.k = h.e(i, false);
        int i2 = j1Var.o & (~h_d.J);
        this.l = (i2 & 1) != 0;
        this.m = (i2 & 2) != 0;
        int i3 = Integer.MAX_VALUE;
        b.i.b.b.p<String> pVarU = h_d.B.isEmpty() ? b.i.b.b.p.u("") : h_d.B;
        int i4 = 0;
        while (true) {
            if (i4 >= pVarU.size()) {
                iC = 0;
                break;
            }
            iC = h.c(j1Var, pVarU.get(i4), h_d.D);
            if (iC > 0) {
                i3 = i4;
                break;
            }
            i4++;
        }
        this.n = i3;
        this.o = iC;
        int iBitCount = Integer.bitCount(j1Var.p & h_d.C);
        this.p = iBitCount;
        this.r = (j1Var.p & 1088) != 0;
        int iC2 = h.c(j1Var, str, h.g(str) == null);
        this.q = iC2;
        if (iC > 0 || ((h_d.B.isEmpty() && iBitCount > 0) || this.l || (this.m && iC2 > 0))) {
            z2 = true;
        }
        this.j = z2;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(h$g h_g) {
        return f(h_g);
    }

    public int f(h$g h_g) {
        b.i.b.b.j jVarC = b.i.b.b.j.a.c(this.k, h_g.k);
        Integer numValueOf = Integer.valueOf(this.n);
        Integer numValueOf2 = Integer.valueOf(h_g.n);
        g0 g0Var = f0.j;
        k0 k0Var = k0.j;
        b.i.b.b.j jVarC2 = jVarC.b(numValueOf, numValueOf2, k0Var).a(this.o, h_g.o).a(this.p, h_g.p).c(this.l, h_g.l);
        Boolean boolValueOf = Boolean.valueOf(this.m);
        Boolean boolValueOf2 = Boolean.valueOf(h_g.m);
        if (this.o != 0) {
            g0Var = k0Var;
        }
        b.i.b.b.j jVarA = jVarC2.b(boolValueOf, boolValueOf2, g0Var).a(this.q, h_g.q);
        if (this.p == 0) {
            jVarA = jVarA.d(this.r, h_g.r);
        }
        return jVarA.e();
    }
}
