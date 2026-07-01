package b.i.c.m.d.k;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: b.i.c.m.d.k.s0, reason: use source file name */
/* JADX INFO: compiled from: ExecutorUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExecutorUtils implements ThreadFactory {
    public final /* synthetic */ String j;
    public final /* synthetic */ AtomicLong k;

    /* JADX INFO: renamed from: b.i.c.m.d.k.s0$a */
    /* JADX INFO: compiled from: ExecutorUtils.java */
    public class a extends BackgroundPriorityRunnable {
        public final /* synthetic */ Runnable j;

        public a(ExecutorUtils executorUtils, Runnable runnable) {
            this.j = runnable;
        }

        @Override // b.i.c.m.d.k.BackgroundPriorityRunnable
        public void a() {
            this.j.run();
        }
    }

    public ExecutorUtils(String str, AtomicLong atomicLong) {
        this.j = str;
        this.k = atomicLong;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = Executors.defaultThreadFactory().newThread(new a(this, runnable));
        threadNewThread.setName(this.j + this.k.getAndIncrement());
        return threadNewThread;
    }
}
