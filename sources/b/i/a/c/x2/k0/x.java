package b.i.a.c.x2.k0;

import b.i.a.c.j1;
import b.i.a.c.j1$b;

/* JADX INFO: compiled from: PassthroughSectionPayloadReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class x implements c0 {
    public j1 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b.i.a.c.f3.d0 f1282b;
    public b.i.a.c.x2.w c;

    public x(String str) {
        j1$b j1_b = new j1$b();
        j1_b.k = str;
        this.a = j1_b.a();
    }

    @Override // b.i.a.c.x2.k0.c0
    public void a(b.i.a.c.f3.d0 d0Var, b.i.a.c.x2.j jVar, i0$d i0_d) {
        this.f1282b = d0Var;
        i0_d.a();
        b.i.a.c.x2.w wVarP = jVar.p(i0_d.c(), 5);
        this.c = wVarP;
        wVarP.e(this.a);
    }

    @Override // b.i.a.c.x2.k0.c0
    public void b(b.i.a.c.f3.x xVar) {
        long jC;
        b.c.a.a0.d.H(this.f1282b);
        int i = b.i.a.c.f3.e0.a;
        b.i.a.c.f3.d0 d0Var = this.f1282b;
        synchronized (d0Var) {
            long j = d0Var.c;
            jC = j != -9223372036854775807L ? j + d0Var.f966b : d0Var.c();
        }
        long jD = this.f1282b.d();
        if (jC == -9223372036854775807L || jD == -9223372036854775807L) {
            return;
        }
        j1 j1Var = this.a;
        if (jD != j1Var.A) {
            j1$b j1_bA = j1Var.a();
            j1_bA.o = jD;
            j1 j1VarA = j1_bA.a();
            this.a = j1VarA;
            this.c.e(j1VarA);
        }
        int iA = xVar.a();
        this.c.c(xVar, iA);
        this.c.d(jC, 1, iA, 0, null);
    }
}
