package p637j0.p642l.p647e;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: j0.l.e.j */
/* JADX INFO: compiled from: RxThreadFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ThreadFactoryC12720j extends AtomicLong implements ThreadFactory {

    /* JADX INFO: renamed from: j */
    public static final ThreadFactory f27286j = new a();
    private static final long serialVersionUID = -8841098858898482335L;
    public final String prefix;

    /* JADX INFO: renamed from: j0.l.e.j$a */
    /* JADX INFO: compiled from: RxThreadFactory.java */
    public static class a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            throw new AssertionError("No threads allowed.");
        }
    }

    public ThreadFactoryC12720j(String str) {
        this.prefix = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.prefix + incrementAndGet());
        thread.setDaemon(true);
        return thread;
    }
}
