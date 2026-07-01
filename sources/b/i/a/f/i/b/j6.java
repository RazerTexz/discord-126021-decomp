package b.i.a.f.i.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class j6 implements Runnable {
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;
    public final /* synthetic */ Object l;
    public final /* synthetic */ long m;
    public final /* synthetic */ c6 n;

    public j6(c6 c6Var, String str, String str2, Object obj, long j) {
        this.n = c6Var;
        this.j = str;
        this.k = str2;
        this.l = obj;
        this.m = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.K(this.j, this.k, this.l, this.m);
    }
}
