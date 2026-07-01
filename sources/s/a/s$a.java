package s.a;

import b.d.b.a.a;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: CommonPool.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s$a implements ThreadFactory {
    public final /* synthetic */ AtomicInteger j;

    public s$a(AtomicInteger atomicInteger) {
        this.j = atomicInteger;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        StringBuilder sbU = a.U("CommonPool-worker-");
        sbU.append(this.j.incrementAndGet());
        Thread thread = new Thread(runnable, sbU.toString());
        thread.setDaemon(true);
        return thread;
    }
}
