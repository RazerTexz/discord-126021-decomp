package p007b.p008a.p041q;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p007b.p085c.p086a.p087a0.C1460d;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.c */
/* JADX INFO: compiled from: MediaEngineExecutorService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ExecutorServiceC1192c implements ExecutorService {

    /* JADX INFO: renamed from: j */
    public static final AtomicInteger f1607j = new AtomicInteger();

    /* JADX INFO: renamed from: k */
    public volatile int f1608k;

    /* JADX INFO: renamed from: l */
    public final ExecutorService f1609l;

    /* JADX INFO: renamed from: m */
    public final boolean f1610m;

    /* JADX INFO: renamed from: b.a.q.c$a */
    /* JADX INFO: compiled from: MediaEngineExecutorService.kt */
    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ExecutorServiceC1192c.this.f1608k = Process.myTid();
            Thread threadCurrentThread = Thread.currentThread();
            C12238m.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
            threadCurrentThread.setName("MediaEngineExecutor-" + ExecutorServiceC1192c.f1607j.getAndIncrement());
        }
    }

    public ExecutorServiceC1192c(ExecutorService executorService, boolean z2) {
        C12238m.checkNotNullParameter(executorService, "es");
        this.f1609l = executorService;
        this.f1610m = z2;
        this.f1608k = -1;
        executorService.submit(new a());
    }

    /* JADX INFO: renamed from: a */
    public final void m266a() {
        if (Process.myTid() != this.f1608k) {
            IllegalStateException illegalStateException = new IllegalStateException("oops! not called on the MediaEngineExecutor");
            C1460d.m505c1("MediaEngineExecutor", "oops! not called on the MediaEngineExecutor", illegalStateException);
            if (this.f1610m) {
                new Handler(Looper.getMainLooper()).post(new RunnableC1194d(illegalStateException));
            }
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.f1609l.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f1609l.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        return this.f1609l.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return this.f1609l.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        return (T) this.f1609l.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return (T) this.f1609l.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f1609l.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f1609l.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f1609l.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.f1609l.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.f1609l.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.f1609l.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.f1609l.submit(callable);
    }
}
