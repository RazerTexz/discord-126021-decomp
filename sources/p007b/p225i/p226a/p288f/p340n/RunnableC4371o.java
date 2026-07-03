package p007b.p225i.p226a.p288f.p340n;

/* JADX INFO: renamed from: b.i.a.f.n.o */
/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4371o implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C4372p f11500j;

    public RunnableC4371o(C4372p c4372p) {
        this.f11500j = c4372p;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f11500j.f11502b) {
            InterfaceC4355b interfaceC4355b = this.f11500j.f11503c;
            if (interfaceC4355b != null) {
                interfaceC4355b.mo6005b();
            }
        }
    }
}
