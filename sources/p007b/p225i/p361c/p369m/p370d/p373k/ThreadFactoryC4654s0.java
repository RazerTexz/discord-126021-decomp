package p007b.p225i.p361c.p369m.p370d.p373k;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: b.i.c.m.d.k.s0 */
/* JADX INFO: compiled from: ExecutorUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class ThreadFactoryC4654s0 implements ThreadFactory {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ String f12387j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ AtomicLong f12388k;

    /* JADX INFO: renamed from: b.i.c.m.d.k.s0$a */
    /* JADX INFO: compiled from: ExecutorUtils.java */
    public class a extends AbstractRunnableC4616d {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Runnable f12389j;

        public a(ThreadFactoryC4654s0 threadFactoryC4654s0, Runnable runnable) {
            this.f12389j = runnable;
        }

        @Override // p007b.p225i.p361c.p369m.p370d.p373k.AbstractRunnableC4616d
        /* JADX INFO: renamed from: a */
        public void mo6398a() {
            this.f12389j.run();
        }
    }

    public ThreadFactoryC4654s0(String str, AtomicLong atomicLong) {
        this.f12387j = str;
        this.f12388k = atomicLong;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = Executors.defaultThreadFactory().newThread(new a(this, runnable));
        threadNewThread.setName(this.f12387j + this.f12388k.getAndIncrement());
        return threadNewThread;
    }
}
