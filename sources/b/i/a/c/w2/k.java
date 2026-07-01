package b.i.a.c.w2;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ s$a j;
    public final /* synthetic */ s k;
    public final /* synthetic */ Exception l;

    public /* synthetic */ k(s$a s_a, s sVar, Exception exc) {
        this.j = s_a;
        this.k = sVar;
        this.l = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s$a s_a = this.j;
        this.k.u(s_a.a, s_a.f1156b, this.l);
    }
}
