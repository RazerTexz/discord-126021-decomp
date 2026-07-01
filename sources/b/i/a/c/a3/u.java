package b.i.a.c.a3;

import androidx.annotation.Nullable;
import b.i.a.c.j2;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: MaskingMediaPeriod.java */
/* JADX INFO: loaded from: classes3.dex */
public final class u implements x, x$a {
    public final a0$a j;
    public final long k;
    public final b.i.a.c.e3.o l;
    public a0 m;
    public x n;

    @Nullable
    public x$a o;
    public long p = -9223372036854775807L;

    public u(a0$a a0_a, b.i.a.c.e3.o oVar, long j) {
        this.j = a0_a;
        this.l = oVar;
        this.k = j;
    }

    @Override // b.i.a.c.a3.j0$a
    public void a(j0 j0Var) {
        x$a x_a = this.o;
        int i = b.i.a.c.f3.e0.a;
        x_a.a(this);
    }

    @Override // b.i.a.c.a3.x$a
    public void b(x xVar) {
        x$a x_a = this.o;
        int i = b.i.a.c.f3.e0.a;
        x_a.b(this);
    }

    @Override // b.i.a.c.a3.x
    public long c() {
        x xVar = this.n;
        int i = b.i.a.c.f3.e0.a;
        return xVar.c();
    }

    public void d(a0$a a0_a) {
        long j = this.k;
        long j2 = this.p;
        if (j2 != -9223372036854775807L) {
            j = j2;
        }
        a0 a0Var = this.m;
        Objects.requireNonNull(a0Var);
        x xVarN = a0Var.n(a0_a, this.l, j);
        this.n = xVarN;
        if (this.o != null) {
            xVarN.l(this, j);
        }
    }

    @Override // b.i.a.c.a3.x
    public void e() throws IOException {
        try {
            x xVar = this.n;
            if (xVar != null) {
                xVar.e();
                return;
            }
            a0 a0Var = this.m;
            if (a0Var != null) {
                a0Var.h();
            }
        } catch (IOException e) {
            throw e;
        }
    }

    @Override // b.i.a.c.a3.x
    public long f(long j) {
        x xVar = this.n;
        int i = b.i.a.c.f3.e0.a;
        return xVar.f(j);
    }

    @Override // b.i.a.c.a3.x
    public boolean g(long j) {
        x xVar = this.n;
        return xVar != null && xVar.g(j);
    }

    @Override // b.i.a.c.a3.x
    public boolean h() {
        x xVar = this.n;
        return xVar != null && xVar.h();
    }

    @Override // b.i.a.c.a3.x
    public long i(long j, j2 j2Var) {
        x xVar = this.n;
        int i = b.i.a.c.f3.e0.a;
        return xVar.i(j, j2Var);
    }

    @Override // b.i.a.c.a3.x
    public long k() {
        x xVar = this.n;
        int i = b.i.a.c.f3.e0.a;
        return xVar.k();
    }

    @Override // b.i.a.c.a3.x
    public void l(x$a x_a, long j) {
        this.o = x_a;
        x xVar = this.n;
        if (xVar != null) {
            long j2 = this.k;
            long j3 = this.p;
            if (j3 != -9223372036854775807L) {
                j2 = j3;
            }
            xVar.l(this, j2);
        }
    }

    @Override // b.i.a.c.a3.x
    public long m(b.i.a.c.c3.j[] jVarArr, boolean[] zArr, i0[] i0VarArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.p;
        if (j3 == -9223372036854775807L || j != this.k) {
            j2 = j;
        } else {
            this.p = -9223372036854775807L;
            j2 = j3;
        }
        x xVar = this.n;
        int i = b.i.a.c.f3.e0.a;
        return xVar.m(jVarArr, zArr, i0VarArr, zArr2, j2);
    }

    @Override // b.i.a.c.a3.x
    public o0 n() {
        x xVar = this.n;
        int i = b.i.a.c.f3.e0.a;
        return xVar.n();
    }

    @Override // b.i.a.c.a3.x
    public long q() {
        x xVar = this.n;
        int i = b.i.a.c.f3.e0.a;
        return xVar.q();
    }

    @Override // b.i.a.c.a3.x
    public void r(long j, boolean z2) {
        x xVar = this.n;
        int i = b.i.a.c.f3.e0.a;
        xVar.r(j, z2);
    }

    @Override // b.i.a.c.a3.x
    public void s(long j) {
        x xVar = this.n;
        int i = b.i.a.c.f3.e0.a;
        xVar.s(j);
    }
}
