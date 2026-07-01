package b.i.a.c.g3;

import b.i.a.c.f3.e0;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ x$a j;
    public final /* synthetic */ String k;
    public final /* synthetic */ long l;
    public final /* synthetic */ long m;

    public /* synthetic */ i(x$a x_a, String str, long j, long j2) {
        this.j = x_a;
        this.k = str;
        this.l = j;
        this.m = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x$a x_a = this.j;
        String str = this.k;
        long j = this.l;
        long j2 = this.m;
        x xVar = x_a.f995b;
        int i = e0.a;
        xVar.n(str, j, j2);
    }
}
