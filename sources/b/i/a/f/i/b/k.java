package b.i.a.f.i.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements Runnable {
    public final /* synthetic */ t5 j;
    public final /* synthetic */ i k;

    public k(i iVar, t5 t5Var) {
        this.k = iVar;
        this.j = t5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.k();
        if (ga.a()) {
            this.j.f().v(this);
            return;
        }
        boolean z2 = this.k.d != 0;
        this.k.d = 0L;
        if (z2) {
            this.k.a();
        }
    }
}
