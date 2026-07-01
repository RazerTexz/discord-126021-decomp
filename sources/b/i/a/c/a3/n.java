package b.i.a.c.a3;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.i.a.c.j1;
import b.i.a.c.j2;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: ClippingMediaPeriod.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements x, x$a {
    public final x j;

    @Nullable
    public x$a k;
    public n$a[] l = new n$a[0];
    public long m;
    public long n;
    public long o;

    public n(x xVar, boolean z2, long j, long j2) {
        this.j = xVar;
        this.m = z2 ? j : -9223372036854775807L;
        this.n = j;
        this.o = j2;
    }

    @Override // b.i.a.c.a3.j0$a
    public void a(j0 j0Var) {
        x$a x_a = this.k;
        Objects.requireNonNull(x_a);
        x_a.a(this);
    }

    @Override // b.i.a.c.a3.x$a
    public void b(x xVar) {
        x$a x_a = this.k;
        Objects.requireNonNull(x_a);
        x_a.b(this);
    }

    @Override // b.i.a.c.a3.x
    public long c() {
        long jC = this.j.c();
        if (jC != Long.MIN_VALUE) {
            long j = this.o;
            if (j == Long.MIN_VALUE || jC < j) {
                return jC;
            }
        }
        return Long.MIN_VALUE;
    }

    public boolean d() {
        return this.m != -9223372036854775807L;
    }

    @Override // b.i.a.c.a3.x
    public void e() throws IOException {
        this.j.e();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0033  */
    @Override // b.i.a.c.a3.x
    public long f(long j) {
        this.m = -9223372036854775807L;
        boolean z2 = false;
        for (n$a n_a : this.l) {
            if (n_a != null) {
                n_a.f830b = false;
            }
        }
        long jF = this.j.f(j);
        if (jF == j) {
            z2 = true;
        } else if (jF >= this.n) {
            long j2 = this.o;
            if (j2 == Long.MIN_VALUE || jF <= j2) {
                z2 = true;
            }
        }
        b.c.a.a0.d.D(z2);
        return jF;
    }

    @Override // b.i.a.c.a3.x
    public boolean g(long j) {
        return this.j.g(j);
    }

    @Override // b.i.a.c.a3.x
    public boolean h() {
        return this.j.h();
    }

    @Override // b.i.a.c.a3.x
    public long i(long j, j2 j2Var) {
        long j2 = this.n;
        if (j == j2) {
            return j2;
        }
        long jI = b.i.a.c.f3.e0.i(j2Var.c, 0L, j - j2);
        long j3 = j2Var.d;
        long j4 = this.o;
        long jI2 = b.i.a.c.f3.e0.i(j3, 0L, j4 == Long.MIN_VALUE ? RecyclerView.FOREVER_NS : j4 - j);
        if (jI != j2Var.c || jI2 != j2Var.d) {
            j2Var = new j2(jI, jI2);
        }
        return this.j.i(j, j2Var);
    }

    @Override // b.i.a.c.a3.x
    public long k() {
        if (d()) {
            long j = this.m;
            this.m = -9223372036854775807L;
            long jK = k();
            return jK != -9223372036854775807L ? jK : j;
        }
        long jK2 = this.j.k();
        if (jK2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z2 = true;
        b.c.a.a0.d.D(jK2 >= this.n);
        long j2 = this.o;
        if (j2 != Long.MIN_VALUE && jK2 > j2) {
            z2 = false;
        }
        b.c.a.a0.d.D(z2);
        return jK2;
    }

    @Override // b.i.a.c.a3.x
    public void l(x$a x_a, long j) {
        this.k = x_a;
        this.j.l(this, j);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006a  */
    /* JADX WARN: Code duplicated, block: B:36:0x0088  */
    @Override // b.i.a.c.a3.x
    public long m(b.i.a.c.c3.j[] jVarArr, boolean[] zArr, i0[] i0VarArr, boolean[] zArr2, long j) {
        long j2;
        boolean z2;
        this.l = new n$a[i0VarArr.length];
        i0[] i0VarArr2 = new i0[i0VarArr.length];
        int i = 0;
        while (true) {
            i0 i0Var = null;
            if (i >= i0VarArr.length) {
                break;
            }
            n$a[] n_aArr = this.l;
            n_aArr[i] = (n$a) i0VarArr[i];
            if (n_aArr[i] != null) {
                i0Var = n_aArr[i].a;
            }
            i0VarArr2[i] = i0Var;
            i++;
        }
        long jM = this.j.m(jVarArr, zArr, i0VarArr2, zArr2, j);
        boolean z3 = true;
        if (d()) {
            long j3 = this.n;
            if (j != j3) {
                j2 = -9223372036854775807L;
            } else {
                if (j3 == 0) {
                    z2 = false;
                    break;
                }
                int length = jVarArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z2 = false;
                        break;
                    }
                    b.i.a.c.c3.j jVar = jVarArr[i2];
                    if (jVar != null) {
                        j1 j1VarH = jVar.h();
                        if (!b.i.a.c.f3.t.a(j1VarH.w, j1VarH.t)) {
                            z2 = true;
                            break;
                        }
                    }
                    i2++;
                }
                if (z2) {
                    j2 = jM;
                } else {
                    j2 = -9223372036854775807L;
                }
            }
        } else {
            j2 = -9223372036854775807L;
        }
        this.m = j2;
        if (jM != j) {
            if (jM >= this.n) {
                long j4 = this.o;
                if (j4 != Long.MIN_VALUE && jM > j4) {
                    z3 = false;
                }
            } else {
                z3 = false;
            }
        }
        b.c.a.a0.d.D(z3);
        for (int i3 = 0; i3 < i0VarArr.length; i3++) {
            if (i0VarArr2[i3] == null) {
                this.l[i3] = null;
            } else {
                n$a[] n_aArr2 = this.l;
                if (n_aArr2[i3] == null || n_aArr2[i3].a != i0VarArr2[i3]) {
                    n_aArr2[i3] = new n$a(this, i0VarArr2[i3]);
                }
            }
            i0VarArr[i3] = this.l[i3];
        }
        return jM;
    }

    @Override // b.i.a.c.a3.x
    public o0 n() {
        return this.j.n();
    }

    @Override // b.i.a.c.a3.x
    public long q() {
        long jQ = this.j.q();
        if (jQ != Long.MIN_VALUE) {
            long j = this.o;
            if (j == Long.MIN_VALUE || jQ < j) {
                return jQ;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // b.i.a.c.a3.x
    public void r(long j, boolean z2) {
        this.j.r(j, z2);
    }

    @Override // b.i.a.c.a3.x
    public void s(long j) {
        this.j.s(j);
    }
}
