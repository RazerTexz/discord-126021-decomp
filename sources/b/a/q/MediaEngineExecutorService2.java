package b.a.q;

/* JADX INFO: renamed from: b.a.q.d, reason: use source file name */
/* JADX INFO: compiled from: MediaEngineExecutorService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaEngineExecutorService2 implements Runnable {
    public final /* synthetic */ IllegalStateException j;

    public MediaEngineExecutorService2(IllegalStateException illegalStateException) {
        this.j = illegalStateException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        throw this.j;
    }
}
