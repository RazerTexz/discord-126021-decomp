package i0;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ i$b$a j;
    public final /* synthetic */ f k;
    public final /* synthetic */ Throwable l;

    public /* synthetic */ a(i$b$a i_b_a, f fVar, Throwable th) {
        this.j = i_b_a;
        this.k = fVar;
        this.l = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i$b$a i_b_a = this.j;
        this.k.a(i_b_a.f3741b, this.l);
    }
}
