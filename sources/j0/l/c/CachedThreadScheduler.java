package j0.l.c;

import j0.l.c.ScheduledAction;
import j0.l.e.RxThreadFactory;
import j0.r.Subscriptions;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: renamed from: j0.l.c.a, reason: use source file name */
/* JADX INFO: compiled from: CachedThreadScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class CachedThreadScheduler extends Scheduler implements SchedulerLifecycle {
    public static final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TimeUnit f3785b = TimeUnit.SECONDS;
    public static final c c;
    public static final a d;
    public final ThreadFactory e;
    public final AtomicReference<a> f;

    /* JADX INFO: renamed from: j0.l.c.a$a */
    /* JADX INFO: compiled from: CachedThreadScheduler.java */
    public static final class a {
        public final ThreadFactory a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f3786b;
        public final ConcurrentLinkedQueue<c> c;
        public final CompositeSubscription d;
        public final ScheduledExecutorService e;
        public final Future<?> f;

        /* JADX INFO: renamed from: j0.l.c.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CachedThreadScheduler.java */
        public class ThreadFactoryC0429a implements ThreadFactory {
            public final /* synthetic */ ThreadFactory j;

            public ThreadFactoryC0429a(a aVar, ThreadFactory threadFactory) {
                this.j = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread threadNewThread = this.j.newThread(runnable);
                threadNewThread.setName(threadNewThread.getName() + " (Evictor)");
                return threadNewThread;
            }
        }

        /* JADX INFO: renamed from: j0.l.c.a$a$b */
        /* JADX INFO: compiled from: CachedThreadScheduler.java */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                if (aVar.c.isEmpty()) {
                    return;
                }
                long jNanoTime = System.nanoTime();
                for (c cVar : aVar.c) {
                    if (cVar.r > jNanoTime) {
                        return;
                    }
                    if (aVar.c.remove(cVar)) {
                        aVar.d.c(cVar);
                    }
                }
            }
        }

        public a(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            this.a = threadFactory;
            long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f3786b = nanos;
            this.c = new ConcurrentLinkedQueue<>();
            this.d = new CompositeSubscription();
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = null;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new ThreadFactoryC0429a(this, threadFactory));
                NewThreadWorker.g(scheduledExecutorServiceNewScheduledThreadPool);
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(new b(), nanos, nanos, TimeUnit.NANOSECONDS);
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

    /* JADX INFO: renamed from: j0.l.c.a$b */
    /* JADX INFO: compiled from: CachedThreadScheduler.java */
    public static final class b extends Scheduler.Worker implements Action0 {
        public final a k;
        public final c l;
        public final CompositeSubscription j = new CompositeSubscription();
        public final AtomicBoolean m = new AtomicBoolean();

        /* JADX INFO: renamed from: j0.l.c.a$b$a */
        /* JADX INFO: compiled from: CachedThreadScheduler.java */
        public class a implements Action0 {
            public final /* synthetic */ Action0 j;

            public a(Action0 action0) {
                this.j = action0;
            }

            @Override // rx.functions.Action0
            public void call() {
                if (b.this.j.k) {
                    return;
                }
                this.j.call();
            }
        }

        public b(a aVar) {
            c cVar;
            c cVar2;
            this.k = aVar;
            if (aVar.d.k) {
                cVar2 = CachedThreadScheduler.c;
            } else {
                do {
                    if (aVar.c.isEmpty()) {
                        cVar = new c(aVar.a);
                        aVar.d.a(cVar);
                        break;
                    }
                    cVar = aVar.c.poll();
                } while (cVar == null);
                cVar2 = cVar;
            }
            this.l = cVar2;
        }

        @Override // rx.Scheduler.Worker
        public Subscription a(Action0 action0) {
            return b(action0, 0L, null);
        }

        @Override // rx.Scheduler.Worker
        public Subscription b(Action0 action0, long j, TimeUnit timeUnit) {
            if (this.j.k) {
                return Subscriptions.a;
            }
            ScheduledAction scheduledActionF = this.l.f(new a(action0), j, timeUnit);
            this.j.a(scheduledActionF);
            scheduledActionF.cancel.a(new ScheduledAction.c(scheduledActionF, this.j));
            return scheduledActionF;
        }

        @Override // rx.functions.Action0
        public void call() {
            a aVar = this.k;
            c cVar = this.l;
            Objects.requireNonNull(aVar);
            cVar.r = System.nanoTime() + aVar.f3786b;
            aVar.c.offer(cVar);
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.j.k;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (this.m.compareAndSet(false, true)) {
                this.l.a(this);
            }
            this.j.unsubscribe();
        }
    }

    /* JADX INFO: renamed from: j0.l.c.a$c */
    /* JADX INFO: compiled from: CachedThreadScheduler.java */
    public static final class c extends NewThreadWorker {
        public long r;

        public c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.r = 0L;
        }
    }

    static {
        c cVar = new c(RxThreadFactory.j);
        c = cVar;
        cVar.unsubscribe();
        a aVar = new a(null, 0L, null);
        d = aVar;
        aVar.a();
        a = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    public CachedThreadScheduler(ThreadFactory threadFactory) {
        this.e = threadFactory;
        a aVar = d;
        AtomicReference<a> atomicReference = new AtomicReference<>(aVar);
        this.f = atomicReference;
        a aVar2 = new a(threadFactory, a, f3785b);
        if (atomicReference.compareAndSet(aVar, aVar2)) {
            return;
        }
        aVar2.a();
    }

    @Override // rx.Scheduler
    public Scheduler.Worker a() {
        return new b(this.f.get());
    }

    @Override // j0.l.c.SchedulerLifecycle
    public void shutdown() {
        a aVar;
        a aVar2;
        do {
            aVar = this.f.get();
            aVar2 = d;
            if (aVar == aVar2) {
                return;
            }
        } while (!this.f.compareAndSet(aVar, aVar2));
        aVar.a();
    }
}
