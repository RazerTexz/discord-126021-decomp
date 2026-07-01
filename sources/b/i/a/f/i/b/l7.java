package b.i.a.f.i.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class l7 implements Runnable {
    public final /* synthetic */ long j;
    public final /* synthetic */ h7 k;

    public l7(h7 h7Var, long j) {
        this.k = h7Var;
        this.j = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.k.m().t(this.j);
        this.k.e = null;
    }
}
