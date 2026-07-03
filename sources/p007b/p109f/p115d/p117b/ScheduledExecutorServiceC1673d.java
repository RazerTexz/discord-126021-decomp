package p007b.p109f.p115d.p117b;

import android.os.Handler;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: b.f.d.b.d */
/* JADX INFO: compiled from: HandlerExecutorServiceImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class ScheduledExecutorServiceC1673d extends AbstractExecutorService implements ScheduledExecutorService {

    /* JADX INFO: renamed from: j */
    public final Handler f3088j;

    public ScheduledExecutorServiceC1673d(Handler handler) {
        this.f3088j = handler;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        throw null;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return new RunnableFutureC1674e(this.f3088j, runnable, obj);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        RunnableFutureC1674e runnableFutureC1674e = new RunnableFutureC1674e(this.f3088j, runnable, null);
        this.f3088j.postDelayed(runnableFutureC1674e, timeUnit.toMillis(j));
        return runnableFutureC1674e;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable) {
        Objects.requireNonNull(runnable);
        RunnableFutureC1674e runnableFutureC1674e = new RunnableFutureC1674e(this.f3088j, runnable, null);
        execute(runnableFutureC1674e);
        return runnableFutureC1674e;
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public RunnableFuture newTaskFor(Callable callable) {
        return new RunnableFutureC1674e(this.f3088j, callable);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        RunnableFutureC1674e runnableFutureC1674e = new RunnableFutureC1674e(this.f3088j, callable);
        this.f3088j.postDelayed(runnableFutureC1674e, timeUnit.toMillis(j));
        return runnableFutureC1674e;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable, Object obj) {
        Objects.requireNonNull(runnable);
        RunnableFutureC1674e runnableFutureC1674e = new RunnableFutureC1674e(this.f3088j, runnable, obj);
        execute(runnableFutureC1674e);
        return runnableFutureC1674e;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future submit(Callable callable) {
        Objects.requireNonNull(callable);
        RunnableFutureC1674e runnableFutureC1674e = new RunnableFutureC1674e(this.f3088j, callable);
        execute(runnableFutureC1674e);
        return runnableFutureC1674e;
    }
}
