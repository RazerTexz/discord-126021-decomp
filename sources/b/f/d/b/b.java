package b.f.d.b;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ConstrainedExecutorService.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends AbstractExecutorService {
    public static final Class<?> j = b.class;
    public final String k;
    public final Executor l;
    public volatile int m;
    public final BlockingQueue<Runnable> n;
    public final b$b o;
    public final AtomicInteger p;
    public final AtomicInteger q;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.k = str;
        this.l = executor;
        this.m = i;
        this.n = blockingQueue;
        this.o = new b$b(this, null);
        this.p = new AtomicInteger(0);
        this.q = new AtomicInteger(0);
    }

    public final void a() {
        int i = this.p.get();
        while (i < this.m) {
            int i2 = i + 1;
            if (this.p.compareAndSet(i, i2)) {
                b.f.d.e.a.j(j, "%s: starting worker %d of %d", this.k, Integer.valueOf(i2), Integer.valueOf(this.m));
                this.l.execute(this.o);
                return;
            } else {
                int i3 = b.f.d.e.a.a;
                i = this.p.get();
            }
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Objects.requireNonNull(runnable, "runnable parameter is null");
        if (!this.n.offer(runnable)) {
            throw new RejectedExecutionException(this.k + " queue is full, size=" + this.n.size());
        }
        int size = this.n.size();
        int i = this.q.get();
        if (size > i && this.q.compareAndSet(i, size)) {
            int i2 = b.f.d.e.a.a;
        }
        a();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }
}
