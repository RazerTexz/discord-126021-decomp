package p007b.p109f.p115d.p117b;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p007b.p109f.p115d.p120e.C1691a;

/* JADX INFO: renamed from: b.f.d.b.b */
/* JADX INFO: compiled from: ConstrainedExecutorService.java */
/* JADX INFO: loaded from: classes.dex */
public class C1671b extends AbstractExecutorService {

    /* JADX INFO: renamed from: j */
    public static final Class<?> f3079j = C1671b.class;

    /* JADX INFO: renamed from: k */
    public final String f3080k;

    /* JADX INFO: renamed from: l */
    public final Executor f3081l;

    /* JADX INFO: renamed from: m */
    public volatile int f3082m;

    /* JADX INFO: renamed from: n */
    public final BlockingQueue<Runnable> f3083n;

    /* JADX INFO: renamed from: o */
    public final b f3084o;

    /* JADX INFO: renamed from: p */
    public final AtomicInteger f3085p;

    /* JADX INFO: renamed from: q */
    public final AtomicInteger f3086q;

    /* JADX INFO: renamed from: b.f.d.b.b$b */
    /* JADX INFO: compiled from: ConstrainedExecutorService.java */
    public class b implements Runnable {
        public b(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runnable runnablePoll = C1671b.this.f3083n.poll();
                if (runnablePoll != null) {
                    runnablePoll.run();
                } else {
                    Class<?> cls = C1671b.f3079j;
                    Class<?> cls2 = C1671b.f3079j;
                    String str = C1671b.this.f3080k;
                    int i = C1691a.f3102a;
                }
            } finally {
                C1671b.this.f3085p.decrementAndGet();
                if (C1671b.this.f3083n.isEmpty()) {
                    Class<?> cls3 = C1671b.f3079j;
                    Class<?> cls4 = C1671b.f3079j;
                    String str2 = C1671b.this.f3080k;
                    int i2 = C1691a.f3102a;
                } else {
                    C1671b.this.m964a();
                }
            }
        }
    }

    public C1671b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.f3080k = str;
        this.f3081l = executor;
        this.f3082m = i;
        this.f3083n = blockingQueue;
        this.f3084o = new b(null);
        this.f3085p = new AtomicInteger(0);
        this.f3086q = new AtomicInteger(0);
    }

    /* JADX INFO: renamed from: a */
    public final void m964a() {
        int i = this.f3085p.get();
        while (i < this.f3082m) {
            int i2 = i + 1;
            if (this.f3085p.compareAndSet(i, i2)) {
                C1691a.m982j(f3079j, "%s: starting worker %d of %d", this.f3080k, Integer.valueOf(i2), Integer.valueOf(this.f3082m));
                this.f3081l.execute(this.f3084o);
                return;
            } else {
                int i3 = C1691a.f3102a;
                i = this.f3085p.get();
            }
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Objects.requireNonNull(runnable, "runnable parameter is null");
        if (!this.f3083n.offer(runnable)) {
            throw new RejectedExecutionException(this.f3080k + " queue is full, size=" + this.f3083n.size());
        }
        int size = this.f3083n.size();
        int i = this.f3086q.get();
        if (size > i && this.f3086q.compareAndSet(i, size)) {
            int i2 = C1691a.f3102a;
        }
        m964a();
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
