package j0.l.c;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: CachedThreadScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a {
    public final ThreadFactory a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3786b;
    public final ConcurrentLinkedQueue<a$c> c;
    public final CompositeSubscription d;
    public final ScheduledExecutorService e;
    public final Future<?> f;

    public a$a(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
        ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
        this.a = threadFactory;
        long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0L;
        this.f3786b = nanos;
        this.c = new ConcurrentLinkedQueue<>();
        this.d = new CompositeSubscription();
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = null;
        if (timeUnit != null) {
            scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new a$a$a(this, threadFactory));
            g.g(scheduledExecutorServiceNewScheduledThreadPool);
            scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(new a$a$b(this), nanos, nanos, TimeUnit.NANOSECONDS);
        } else {
            scheduledFutureScheduleWithFixedDelay = null;
        }
        this.e = scheduledExecutorServiceNewScheduledThreadPool;
        this.f = scheduledFutureScheduleWithFixedDelay;
    }

    public void a() {
        try {
            Future<?> future = this.f;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.e;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        } finally {
            this.d.unsubscribe();
        }
    }
}
