package b.i.a.f.d;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i implements Runnable {
    public final g j;

    public i(g gVar) {
        this.j = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g gVar = this.j;
        synchronized (gVar) {
            if (gVar.j == 1) {
                gVar.a(1, "Timed out while binding");
            }
        }
    }
}
