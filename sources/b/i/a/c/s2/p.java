package b.i.a.c.s2;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class p implements Runnable {
    public final /* synthetic */ g1 j;

    public /* synthetic */ p(g1 g1Var) {
        this.j = g1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g1 g1Var = this.j;
        h1$a h1_aK0 = g1Var.k0();
        x0 x0Var = new x0(h1_aK0);
        g1Var.n.put(1036, h1_aK0);
        b.i.a.c.f3.p<h1> pVar = g1Var.o;
        pVar.b(1036, x0Var);
        pVar.a();
        g1Var.o.c();
    }
}
