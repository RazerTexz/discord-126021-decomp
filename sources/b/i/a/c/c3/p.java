package b.i.a.c.c3;

import androidx.annotation.Nullable;
import b.i.a.c.w0;

/* JADX INFO: compiled from: TrackSelectionParameters.java */
/* JADX INFO: loaded from: classes3.dex */
public class p implements w0 {
    public static final p j = new p(new p$a());
    public final b.i.b.b.p<String> A;
    public final b.i.b.b.p<String> B;
    public final int C;
    public final boolean D;
    public final boolean E;
    public final boolean F;
    public final o G;
    public final b.i.b.b.r<Integer> H;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f905s;
    public final int t;
    public final boolean u;
    public final b.i.b.b.p<String> v;
    public final b.i.b.b.p<String> w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f906x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f907y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f908z;

    public p(p$a p_a) {
        this.k = p_a.a;
        this.l = p_a.f909b;
        this.m = p_a.c;
        this.n = p_a.d;
        this.o = p_a.e;
        this.p = p_a.f;
        this.q = p_a.g;
        this.r = p_a.h;
        this.f905s = p_a.i;
        this.t = p_a.j;
        this.u = p_a.k;
        this.v = p_a.l;
        this.w = p_a.m;
        this.f906x = p_a.n;
        this.f907y = p_a.o;
        this.f908z = p_a.p;
        this.A = p_a.q;
        this.B = p_a.r;
        this.C = p_a.f910s;
        this.D = p_a.t;
        this.E = p_a.u;
        this.F = p_a.v;
        this.G = p_a.w;
        this.H = p_a.f911x;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        return this.k == pVar.k && this.l == pVar.l && this.m == pVar.m && this.n == pVar.n && this.o == pVar.o && this.p == pVar.p && this.q == pVar.q && this.r == pVar.r && this.u == pVar.u && this.f905s == pVar.f905s && this.t == pVar.t && this.v.equals(pVar.v) && this.w.equals(pVar.w) && this.f906x == pVar.f906x && this.f907y == pVar.f907y && this.f908z == pVar.f908z && this.A.equals(pVar.A) && this.B.equals(pVar.B) && this.C == pVar.C && this.D == pVar.D && this.E == pVar.E && this.F == pVar.F && this.G.equals(pVar.G) && this.H.equals(pVar.H);
    }

    public int hashCode() {
        return this.H.hashCode() + ((this.G.hashCode() + ((((((((((this.B.hashCode() + ((this.A.hashCode() + ((((((((this.w.hashCode() + ((this.v.hashCode() + ((((((((((((((((((((((this.k + 31) * 31) + this.l) * 31) + this.m) * 31) + this.n) * 31) + this.o) * 31) + this.p) * 31) + this.q) * 31) + this.r) * 31) + (this.u ? 1 : 0)) * 31) + this.f905s) * 31) + this.t) * 31)) * 31)) * 31) + this.f906x) * 31) + this.f907y) * 31) + this.f908z) * 31)) * 31)) * 31) + this.C) * 31) + (this.D ? 1 : 0)) * 31) + (this.E ? 1 : 0)) * 31) + (this.F ? 1 : 0)) * 31)) * 31);
    }
}
