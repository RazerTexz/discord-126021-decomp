package b.i.a.f.h.j;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class u0 implements Runnable {
    public final t0 j;
    public final int k;
    public final m0 l;

    public u0(t0 t0Var, int i, m0 m0Var) {
        this.j = t0Var;
        this.k = i;
        this.l = m0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t0 t0Var = this.j;
        int i = this.k;
        m0 m0Var = this.l;
        if (t0Var.c.b(i)) {
            m0Var.C("Local AnalyticsService processed last dispatch request");
        }
    }
}
