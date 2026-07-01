package f0.e0.f;

import d0.z.d.m;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: TaskRunner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$c implements d$a {
    public final ThreadPoolExecutor a;

    public d$c(ThreadFactory threadFactory) {
        m.checkParameterIsNotNull(threadFactory, "threadFactory");
        this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
    }

    @Override // f0.e0.f.d$a
    public void a(d dVar) {
        m.checkParameterIsNotNull(dVar, "taskRunner");
        dVar.notify();
    }

    @Override // f0.e0.f.d$a
    public void b(d dVar, long j) throws InterruptedException {
        m.checkParameterIsNotNull(dVar, "taskRunner");
        long j2 = j / 1000000;
        long j3 = j - (1000000 * j2);
        if (j2 > 0 || j > 0) {
            dVar.wait(j2, (int) j3);
        }
    }

    @Override // f0.e0.f.d$a
    public long c() {
        return System.nanoTime();
    }

    @Override // f0.e0.f.d$a
    public void execute(Runnable runnable) {
        m.checkParameterIsNotNull(runnable, "runnable");
        this.a.execute(runnable);
    }
}
