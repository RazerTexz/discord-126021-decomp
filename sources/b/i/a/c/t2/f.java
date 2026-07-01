package b.i.a.c.t2;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ r$a j;
    public final /* synthetic */ String k;
    public final /* synthetic */ long l;
    public final /* synthetic */ long m;

    public /* synthetic */ f(r$a r_a, String str, long j, long j2) {
        this.j = r_a;
        this.k = str;
        this.l = j;
        this.m = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r$a r_a = this.j;
        String str = this.k;
        long j = this.l;
        long j2 = this.m;
        r rVar = r_a.f1126b;
        int i = b.i.a.c.f3.e0.a;
        rVar.C(str, j, j2);
    }
}
