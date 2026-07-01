package b.i.a.c.t2;

import b.i.a.c.j1;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ r$a j;
    public final /* synthetic */ j1 k;
    public final /* synthetic */ b.i.a.c.v2.g l;

    public /* synthetic */ e(r$a r_a, j1 j1Var, b.i.a.c.v2.g gVar) {
        this.j = r_a;
        this.k = j1Var;
        this.l = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r$a r_a = this.j;
        j1 j1Var = this.k;
        b.i.a.c.v2.g gVar = this.l;
        r rVar = r_a.f1126b;
        int i = b.i.a.c.f3.e0.a;
        rVar.U(j1Var);
        r_a.f1126b.I(j1Var, gVar);
    }
}
