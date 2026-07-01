package b.i.a.f.i.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class j7 implements Runnable {
    public final /* synthetic */ i7 j;
    public final /* synthetic */ i7 k;
    public final /* synthetic */ long l;
    public final /* synthetic */ boolean m;
    public final /* synthetic */ h7 n;

    public j7(h7 h7Var, i7 i7Var, i7 i7Var2, long j, boolean z2) {
        this.n = h7Var;
        this.j = i7Var;
        this.k = i7Var2;
        this.l = j;
        this.m = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.B(this.j, this.k, this.l, this.m, null);
    }
}
