package b.a.q;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import b.c.a.a0.AnimatableValueParser;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: b.a.q.c, reason: use source file name */
/* JADX INFO: compiled from: MediaEngineExecutorService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaEngineExecutorService implements ExecutorService {
    public static final AtomicInteger j = new AtomicInteger();
    public volatile int k;
    public final ExecutorService l;
    public final boolean m;

    /* JADX INFO: renamed from: b.a.q.c$a */
    /* JADX INFO: compiled from: MediaEngineExecutorService.kt */
    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MediaEngineExecutorService.this.k = Process.myTid();
            Thread threadCurrentThread = Thread.currentThread();
            Intrinsics3.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
            threadCurrentThread.setName("MediaEngineExecutor-" + MediaEngineExecutorService.j.getAndIncrement());
        }
    }

    public MediaEngineExecutorService(ExecutorService executorService, boolean z2) {
        Intrinsics3.checkNotNullParameter(executorService, "es");
        this.l = executorService;
        this.m = z2;
        this.k = -1;
        executorService.submit(new a());
    }

    public final void a() {
        if (Process.myTid() != this.k) {
            IllegalStateException illegalStateException = new IllegalStateException("oops! not called on the MediaEngineExecutor");
            AnimatableValueParser.c1("MediaEngineExecutor", "oops! not called on the MediaEngineExecutor", illegalStateException);
            if (this.m) {
                new Handler(Looper.getMainLooper()).post(new MediaEngineExecutorService2(illegalStateException));
            }
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j2, TimeUnit timeUnit) {
        return this.l.awaitTermination(j2, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.l.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        return this.l.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) {
        return this.l.invokeAll(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        return (T) this.l.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) {
        return (T) this.l.invokeAny(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.l.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.l.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.l.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.l.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.l.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.l.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.l.submit(callable);
    }
}
