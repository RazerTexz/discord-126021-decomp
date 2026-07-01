package b.i.a.f.i.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class b9 implements Runnable {
    public long j;
    public long k;
    public final /* synthetic */ x8 l;

    public b9(x8 x8Var, long j, long j2) {
        this.l = x8Var;
        this.j = j;
        this.k = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.l.f1579b.f().v(new a9(this));
    }
}
