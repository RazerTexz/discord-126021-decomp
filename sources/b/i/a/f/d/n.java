package b.i.a.f.d;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class n implements Runnable {
    public final g j;

    public n(g gVar) {
        this.j = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.a(2, "Service disconnected");
    }
}
