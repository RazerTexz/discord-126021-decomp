package b.i.c.m.d.k;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: ExecutorUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class s0 implements ThreadFactory {
    public final /* synthetic */ String j;
    public final /* synthetic */ AtomicLong k;

    public s0(String str, AtomicLong atomicLong) {
        this.j = str;
        this.k = atomicLong;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = Executors.defaultThreadFactory().newThread(new s0$a(this, runnable));
        threadNewThread.setName(this.j + this.k.getAndIncrement());
        return threadNewThread;
    }
}
