package b.f.d.b;

import android.os.Handler;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: ScheduledFutureImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class e<V> implements RunnableFuture<V>, ScheduledFuture<V> {
    public final FutureTask<V> j;

    public e(Handler handler, Callable<V> callable) {
        this.j = new FutureTask<>(callable);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        return this.j.cancel(z2);
    }

    @Override // java.lang.Comparable
    public int compareTo(Delayed delayed) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Future
    public V get() throws ExecutionException, InterruptedException {
        return this.j.get();
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.j.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.j.isDone();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        this.j.run();
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.j.get(j, timeUnit);
    }

    public e(Handler handler, Runnable runnable, V v) {
        this.j = new FutureTask<>(runnable, v);
    }
}
