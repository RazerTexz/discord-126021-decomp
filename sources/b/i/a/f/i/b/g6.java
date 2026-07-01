package b.i.a.f.i.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class g6 implements Runnable {
    public final /* synthetic */ boolean j;
    public final /* synthetic */ c6 k;

    public g6(c6 c6Var, boolean z2) {
        this.k = c6Var;
        this.j = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zD = this.k.a.d();
        boolean zB = this.k.a.B();
        this.k.a.B = Boolean.valueOf(this.j);
        if (zB == this.j) {
            this.k.a.g().n.b("Default data collection state already set to", Boolean.valueOf(this.j));
        }
        if (this.k.a.d() == zD || this.k.a.d() != this.k.a.B()) {
            this.k.a.g().k.c("Default data collection is different than actual status", Boolean.valueOf(this.j), Boolean.valueOf(zD));
        }
        this.k.P();
    }
}
