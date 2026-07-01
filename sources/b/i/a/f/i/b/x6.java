package b.i.a.f.i.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class x6 implements Runnable {
    public final /* synthetic */ d j;
    public final /* synthetic */ long k;
    public final /* synthetic */ int l;
    public final /* synthetic */ long m;
    public final /* synthetic */ boolean n;
    public final /* synthetic */ c6 o;

    public x6(c6 c6Var, d dVar, long j, int i, long j2, boolean z2) {
        this.o = c6Var;
        this.j = dVar;
        this.k = j;
        this.l = i;
        this.m = j2;
        this.n = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.o.z(this.j);
        this.o.w(this.k, false);
        c6.C(this.o, this.j, this.l, this.m, true, this.n);
    }
}
