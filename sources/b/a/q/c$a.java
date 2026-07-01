package b.a.q;

import android.os.Process;

/* JADX INFO: compiled from: MediaEngineExecutorService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c$a implements Runnable {
    public final /* synthetic */ c j;

    public c$a(c cVar) {
        this.j = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.k = Process.myTid();
        Thread threadCurrentThread = Thread.currentThread();
        d0.z.d.m.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
        threadCurrentThread.setName("MediaEngineExecutor-" + c.j.getAndIncrement());
    }
}
