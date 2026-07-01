package b.i.a.c.a3;

import b.i.a.c.x2.t$b;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ e0 j;
    public final /* synthetic */ b.i.a.c.x2.t k;

    public /* synthetic */ h(e0 e0Var, b.i.a.c.x2.t tVar) {
        this.j = e0Var;
        this.k = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e0 e0Var = this.j;
        b.i.a.c.x2.t tVar = this.k;
        e0Var.J = e0Var.C == null ? tVar : new t$b(-9223372036854775807L, 0L);
        e0Var.K = tVar.i();
        boolean z2 = e0Var.Q == -1 && tVar.i() == -9223372036854775807L;
        e0Var.L = z2;
        e0Var.M = z2 ? 7 : 1;
        ((f0) e0Var.r).u(e0Var.K, tVar.c(), e0Var.L);
        if (e0Var.G) {
            return;
        }
        e0Var.x();
    }
}
