package b.i.a.f.i.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class o7 implements Runnable {
    public final /* synthetic */ i7 j;
    public final /* synthetic */ long k;
    public final /* synthetic */ h7 l;

    public o7(h7 h7Var, i7 i7Var, long j) {
        this.l = h7Var;
        this.j = i7Var;
        this.k = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.l.C(this.j, false, this.k);
        h7 h7Var = this.l;
        h7Var.e = null;
        q7 q7VarP = h7Var.p();
        q7VarP.b();
        q7VarP.t();
        q7VarP.z(new w7(q7VarP, null));
    }
}
