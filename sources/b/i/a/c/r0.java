package b.i.a.c;

import android.util.Pair;
import java.util.Objects;

/* JADX INFO: compiled from: AbstractConcatenatedTimeline.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r0 extends o2 {
    public final int k;
    public final b.i.a.c.a3.k0 l;
    public final boolean m;

    public r0(boolean z2, b.i.a.c.a3.k0 k0Var) {
        this.m = z2;
        this.l = k0Var;
        this.k = k0Var.b();
    }

    @Override // b.i.a.c.o2
    public int a(boolean z2) {
        if (this.k == 0) {
            return -1;
        }
        if (this.m) {
            z2 = false;
        }
        int iC = z2 ? this.l.c() : 0;
        do {
            c2 c2Var = (c2) this;
            if (!c2Var.r[iC].q()) {
                return c2Var.r[iC].a(z2) + c2Var.q[iC];
            }
            iC = r(iC, z2);
        } while (iC != -1);
        return -1;
    }

    @Override // b.i.a.c.o2
    public final int b(Object obj) {
        int iB;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        c2 c2Var = (c2) this;
        Integer num = c2Var.t.get(obj2);
        int iIntValue = num == null ? -1 : num.intValue();
        if (iIntValue == -1 || (iB = c2Var.r[iIntValue].b(obj3)) == -1) {
            return -1;
        }
        return c2Var.p[iIntValue] + iB;
    }

    @Override // b.i.a.c.o2
    public int c(boolean z2) {
        int i = this.k;
        if (i == 0) {
            return -1;
        }
        if (this.m) {
            z2 = false;
        }
        int iG = z2 ? this.l.g() : i - 1;
        do {
            c2 c2Var = (c2) this;
            if (!c2Var.r[iG].q()) {
                return c2Var.r[iG].c(z2) + c2Var.q[iG];
            }
            iG = s(iG, z2);
        } while (iG != -1);
        return -1;
    }

    @Override // b.i.a.c.o2
    public int e(int i, int i2, boolean z2) {
        if (this.m) {
            if (i2 == 1) {
                i2 = 2;
            }
            z2 = false;
        }
        c2 c2Var = (c2) this;
        int iD = b.i.a.c.f3.e0.d(c2Var.q, i + 1, false, false);
        int i3 = c2Var.q[iD];
        int iE = c2Var.r[iD].e(i - i3, i2 != 2 ? i2 : 0, z2);
        if (iE != -1) {
            return i3 + iE;
        }
        int iR = r(iD, z2);
        while (iR != -1 && c2Var.r[iR].q()) {
            iR = r(iR, z2);
        }
        if (iR != -1) {
            return c2Var.r[iR].a(z2) + c2Var.q[iR];
        }
        if (i2 == 2) {
            return a(z2);
        }
        return -1;
    }

    @Override // b.i.a.c.o2
    public final o2$b g(int i, o2$b o2_b, boolean z2) {
        c2 c2Var = (c2) this;
        int iD = b.i.a.c.f3.e0.d(c2Var.p, i + 1, false, false);
        int i2 = c2Var.q[iD];
        c2Var.r[iD].g(i - c2Var.p[iD], o2_b, z2);
        o2_b.l += i2;
        if (z2) {
            Object obj = c2Var.f895s[iD];
            Object obj2 = o2_b.k;
            Objects.requireNonNull(obj2);
            o2_b.k = Pair.create(obj, obj2);
        }
        return o2_b;
    }

    @Override // b.i.a.c.o2
    public final o2$b h(Object obj, o2$b o2_b) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        c2 c2Var = (c2) this;
        Integer num = c2Var.t.get(obj2);
        int iIntValue = num == null ? -1 : num.intValue();
        int i = c2Var.q[iIntValue];
        c2Var.r[iIntValue].h(obj3, o2_b);
        o2_b.l += i;
        o2_b.k = obj;
        return o2_b;
    }

    @Override // b.i.a.c.o2
    public int l(int i, int i2, boolean z2) {
        if (this.m) {
            if (i2 == 1) {
                i2 = 2;
            }
            z2 = false;
        }
        c2 c2Var = (c2) this;
        int iD = b.i.a.c.f3.e0.d(c2Var.q, i + 1, false, false);
        int i3 = c2Var.q[iD];
        int iL = c2Var.r[iD].l(i - i3, i2 != 2 ? i2 : 0, z2);
        if (iL != -1) {
            return i3 + iL;
        }
        int iS = s(iD, z2);
        while (iS != -1 && c2Var.r[iS].q()) {
            iS = s(iS, z2);
        }
        if (iS != -1) {
            return c2Var.r[iS].c(z2) + c2Var.q[iS];
        }
        if (i2 == 2) {
            return c(z2);
        }
        return -1;
    }

    @Override // b.i.a.c.o2
    public final Object m(int i) {
        c2 c2Var = (c2) this;
        int iD = b.i.a.c.f3.e0.d(c2Var.p, i + 1, false, false);
        return Pair.create(c2Var.f895s[iD], c2Var.r[iD].m(i - c2Var.p[iD]));
    }

    @Override // b.i.a.c.o2
    public final o2$c o(int i, o2$c o2_c, long j) {
        c2 c2Var = (c2) this;
        int iD = b.i.a.c.f3.e0.d(c2Var.q, i + 1, false, false);
        int i2 = c2Var.q[iD];
        int i3 = c2Var.p[iD];
        c2Var.r[iD].o(i - i2, o2_c, j);
        Object objCreate = c2Var.f895s[iD];
        if (!o2$c.j.equals(o2_c.n)) {
            objCreate = Pair.create(objCreate, o2_c.n);
        }
        o2_c.n = objCreate;
        o2_c.B += i3;
        o2_c.C += i3;
        return o2_c;
    }

    public final int r(int i, boolean z2) {
        if (z2) {
            return this.l.e(i);
        }
        if (i < this.k - 1) {
            return i + 1;
        }
        return -1;
    }

    public final int s(int i, boolean z2) {
        if (z2) {
            return this.l.d(i);
        }
        if (i > 0) {
            return i - 1;
        }
        return -1;
    }
}
