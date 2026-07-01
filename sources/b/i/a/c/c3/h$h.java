package b.i.a.c.c3;

import b.i.a.c.j1;
import b.i.b.b.k0;

/* JADX INFO: compiled from: DefaultTrackSelector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h$h implements Comparable<h$h> {
    public final boolean j;
    public final h$d k;
    public final boolean l;
    public final boolean m;
    public final int n;
    public final int o;
    public final int p;

    /* JADX WARN: Code duplicated, block: B:21:0x0033  */
    /* JADX WARN: Code duplicated, block: B:41:0x005e  */
    public h$h(j1 j1Var, h$d h_d, int i, boolean z2) {
        boolean z3;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        this.k = h_d;
        boolean z4 = true;
        int i9 = -1;
        if (!z2 || (((i6 = j1Var.B) != -1 && i6 > h_d.k) || ((i7 = j1Var.C) != -1 && i7 > h_d.l))) {
            z3 = false;
        } else {
            float f = j1Var.D;
            if ((f == -1.0f || f <= h_d.m) && ((i8 = j1Var.f1017s) == -1 || i8 <= h_d.n)) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        this.j = z3;
        if (!z2 || (((i3 = j1Var.B) != -1 && i3 < h_d.o) || ((i4 = j1Var.C) != -1 && i4 < h_d.p))) {
            z4 = false;
        } else {
            float f2 = j1Var.D;
            if ((f2 != -1.0f && f2 < h_d.q) || ((i5 = j1Var.f1017s) != -1 && i5 < h_d.r)) {
                z4 = false;
            }
        }
        this.l = z4;
        this.m = h.e(i, false);
        this.n = j1Var.f1017s;
        int i10 = j1Var.B;
        if (i10 != -1 && (i2 = j1Var.C) != -1) {
            i9 = i10 * i2;
        }
        this.o = i9;
        int i11 = Integer.MAX_VALUE;
        for (int i12 = 0; i12 < h_d.v.size(); i12++) {
            String str = j1Var.w;
            if (str != null && str.equals(h_d.v.get(i12))) {
                i11 = i12;
                break;
            }
        }
        this.p = i11;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(h$h h_h) {
        return f(h_h);
    }

    public int f(h$h h_h) {
        Object objB = (this.j && this.m) ? h.c : h.c.b();
        return b.i.b.b.j.a.c(this.m, h_h.m).c(this.j, h_h.j).c(this.l, h_h.l).b(Integer.valueOf(this.p), Integer.valueOf(h_h.p), k0.j).b(Integer.valueOf(this.n), Integer.valueOf(h_h.n), this.k.E ? h.c.b() : h.d).b(Integer.valueOf(this.o), Integer.valueOf(h_h.o), objB).b(Integer.valueOf(this.n), Integer.valueOf(h_h.n), objB).e();
    }
}
