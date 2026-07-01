package b.i.a.f.i.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class w6 implements Runnable {
    public final /* synthetic */ d j;
    public final /* synthetic */ int k;
    public final /* synthetic */ long l;
    public final /* synthetic */ boolean m;
    public final /* synthetic */ c6 n;

    public w6(c6 c6Var, d dVar, int i, long j, boolean z2) {
        this.n = c6Var;
        this.j = dVar;
        this.k = i;
        this.l = j;
        this.m = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.z(this.j);
        c6.C(this.n, this.j, this.k, this.l, false, this.m);
    }
}
