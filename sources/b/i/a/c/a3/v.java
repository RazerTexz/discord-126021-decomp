package b.i.a.c.a3;

import androidx.annotation.Nullable;
import b.i.a.c.o1;
import b.i.a.c.o2;
import b.i.a.c.o2$b;
import b.i.a.c.o2$c;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: MaskingMediaSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends o<Void> {
    public final a0 j;
    public final boolean k;
    public final o2$c l;
    public final o2$b m;
    public v$a n;

    @Nullable
    public u o;
    public boolean p;
    public boolean q;
    public boolean r;

    public v(a0 a0Var, boolean z2) {
        this.j = a0Var;
        this.k = z2 && a0Var.i();
        this.l = new o2$c();
        this.m = new o2$b();
        o2 o2VarK = a0Var.k();
        if (o2VarK == null) {
            this.n = new v$a(new v$b(a0Var.e()), o2$c.j, v$a.l);
        } else {
            this.n = new v$a(o2VarK, null, null);
            this.r = true;
        }
    }

    @Override // b.i.a.c.a3.a0
    public o1 e() {
        return this.j.e();
    }

    @Override // b.i.a.c.a3.a0
    public void h() {
    }

    @Override // b.i.a.c.a3.a0
    public void j(x xVar) {
        u uVar = (u) xVar;
        if (uVar.n != null) {
            a0 a0Var = uVar.m;
            Objects.requireNonNull(a0Var);
            a0Var.j(uVar.n);
        }
        if (xVar == this.o) {
            this.o = null;
        }
    }

    @Override // b.i.a.c.a3.a0
    public /* bridge */ /* synthetic */ x n(a0$a a0_a, b.i.a.c.e3.o oVar, long j) {
        return u(a0_a, oVar, j);
    }

    @Override // b.i.a.c.a3.l
    public void q(@Nullable b.i.a.c.e3.a0 a0Var) {
        this.i = a0Var;
        this.h = b.i.a.c.f3.e0.j();
        if (this.k) {
            return;
        }
        this.p = true;
        t(null, this.j);
    }

    @Override // b.i.a.c.a3.l
    public void s() {
        this.q = false;
        this.p = false;
        for (o$b o_b : this.g.values()) {
            o_b.a.a(o_b.f831b);
            o_b.a.c(o_b.c);
            o_b.a.g(o_b.c);
        }
        this.g.clear();
    }

    public u u(a0$a a0_a, b.i.a.c.e3.o oVar, long j) {
        u uVar = new u(a0_a, oVar, j);
        a0 a0Var = this.j;
        b.c.a.a0.d.D(uVar.m == null);
        uVar.m = a0Var;
        if (this.q) {
            Object obj = a0_a.a;
            if (this.n.n != null && obj.equals(v$a.l)) {
                obj = this.n.n;
            }
            uVar.d(a0_a.b(obj));
        } else {
            this.o = uVar;
            if (!this.p) {
                this.p = true;
                t(null, this.j);
            }
        }
        return uVar;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    public final void v(long j) {
        u uVar = this.o;
        int iB = this.n.b(uVar.j.a);
        if (iB == -1) {
            return;
        }
        long j2 = this.n.f(iB, this.m).m;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        uVar.p = j;
    }
}
