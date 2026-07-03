package p007b.p109f.p115d.p117b;

import android.os.Handler;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: renamed from: b.f.d.b.e */
/* JADX INFO: compiled from: ScheduledFutureImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class RunnableFutureC1674e<V> implements RunnableFuture<V>, ScheduledFuture<V> {

    /* JADX INFO: renamed from: j */
    public final FutureTask<V> f3089j;

    public RunnableFutureC1674e(Handler handler, Callable<V> callable) {
        this.f3089j = new FutureTask<>(callable);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        return this.f3089j.cancel(z2);
    }

    @Override // java.lang.Comparable
    public int compareTo(Delayed delayed) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Future
    public V get() throws ExecutionException, InterruptedException {
        return this.f3089j.get();
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f3089j.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f3089j.isDone();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        this.f3089j.run();
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.f3089j.get(j, timeUnit);
    }

    public RunnableFutureC1674e(Handler handler, Runnable runnable, V v) {
        this.f3089j = new FutureTask<>(runnable, v);
    }
}
