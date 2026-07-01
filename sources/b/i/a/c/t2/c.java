package b.i.a.c.t2;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ r$a j;
    public final /* synthetic */ Exception k;

    public /* synthetic */ c(r$a r_a, Exception exc) {
        this.j = r_a;
        this.k = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r$a r_a = this.j;
        Exception exc = this.k;
        r rVar = r_a.f1126b;
        int i = b.i.a.c.f3.e0.a;
        rVar.T(exc);
    }
}
