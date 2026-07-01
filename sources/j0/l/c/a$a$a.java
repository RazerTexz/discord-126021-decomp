package j0.l.c;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: CachedThreadScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$a$a implements ThreadFactory {
    public final /* synthetic */ ThreadFactory j;

    public a$a$a(a$a a_a, ThreadFactory threadFactory) {
        this.j = threadFactory;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.j.newThread(runnable);
        threadNewThread.setName(threadNewThread.getName() + " (Evictor)");
        return threadNewThread;
    }
}
