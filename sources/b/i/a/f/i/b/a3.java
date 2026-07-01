package b.i.a.f.i.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class a3 implements Runnable {
    public final /* synthetic */ long j;
    public final /* synthetic */ a k;

    public a3(a aVar, long j) {
        this.k = aVar;
        this.j = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.k.x(this.j);
    }
}
