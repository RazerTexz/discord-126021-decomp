package b.i.a.c.a3;

import java.io.IOException;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ b0$a j;
    public final /* synthetic */ b0 k;
    public final /* synthetic */ t l;
    public final /* synthetic */ w m;
    public final /* synthetic */ IOException n;
    public final /* synthetic */ boolean o;

    public /* synthetic */ b(b0$a b0_a, b0 b0Var, t tVar, w wVar, IOException iOException, boolean z2) {
        this.j = b0_a;
        this.k = b0Var;
        this.l = tVar;
        this.m = wVar;
        this.n = iOException;
        this.o = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b0$a b0_a = this.j;
        this.k.g0(b0_a.a, b0_a.f807b, this.l, this.m, this.n, this.o);
    }
}
