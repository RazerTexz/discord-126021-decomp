package b.a.q;

/* JADX INFO: compiled from: MediaEngineExecutorService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Runnable {
    public final /* synthetic */ IllegalStateException j;

    public d(IllegalStateException illegalStateException) {
        this.j = illegalStateException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        throw this.j;
    }
}
