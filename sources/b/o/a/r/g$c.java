package b.o.a.r;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: WorkerHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class g$c implements Runnable {
    public final /* synthetic */ CountDownLatch j;

    public g$c(g gVar, CountDownLatch countDownLatch) {
        this.j = countDownLatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.j.countDown();
    }
}
