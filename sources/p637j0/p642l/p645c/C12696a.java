package p637j0.p642l.p645c;

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
import p637j0.p642l.p645c.RunnableC12705j;
import p637j0.p642l.p647e.ThreadFactoryC12720j;
import p637j0.p655r.C12787c;
import p658rx.Scheduler;
import p658rx.Subscription;
import p658rx.functions.Action0;
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: renamed from: j0.l.c.a */
/* JADX INFO: compiled from: CachedThreadScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12696a extends Scheduler implements InterfaceC12706k {

    /* JADX INFO: renamed from: a */
    public static final long f27166a;

    /* JADX INFO: renamed from: b */
    public static final TimeUnit f27167b = TimeUnit.SECONDS;

    /* JADX INFO: renamed from: c */
    public static final c f27168c;

    /* JADX INFO: renamed from: d */
    public static final a f27169d;

    /* JADX INFO: renamed from: e */
    public final ThreadFactory f27170e;

    /* JADX INFO: renamed from: f */
    public final AtomicReference<a> f27171f;

    /* JADX INFO: renamed from: j0.l.c.a$a */
    /* JADX INFO: compiled from: CachedThreadScheduler.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final ThreadFactory f27172a;

        /* JADX INFO: renamed from: b */
        public final long f27173b;

        /* JADX INFO: renamed from: c */
        public final ConcurrentLinkedQueue<c> f27174c;

        /* JADX INFO: renamed from: d */
        public final CompositeSubscription f27175d;

        /* JADX INFO: renamed from: e */
        public final ScheduledExecutorService f27176e;

        /* JADX INFO: renamed from: f */
        public final Future<?> f27177f;

        /* JADX INFO: renamed from: j0.l.c.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CachedThreadScheduler.java */
        public class ThreadFactoryC13351a implements ThreadFactory {

            /* JADX INFO: renamed from: j */
            public final /* synthetic */ ThreadFactory f27178j;

            public ThreadFactoryC13351a(a aVar, ThreadFactory threadFactory) {
                this.f27178j = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread threadNewThread = this.f27178j.newThread(runnable);
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
                if (aVar.f27174c.isEmpty()) {
                    return;
                }
                long jNanoTime = System.nanoTime();
                for (c cVar : aVar.f27174c) {
                    if (cVar.f27186r > jNanoTime) {
                        return;
                    }
                    if (aVar.f27174c.remove(cVar)) {
                        aVar.f27175d.m11138c(cVar);
                    }
                }
            }
        }

        public a(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            this.f27172a = threadFactory;
            long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f27173b = nanos;
            this.f27174c = new ConcurrentLinkedQueue<>();
            this.f27175d = new CompositeSubscription();
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = null;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new ThreadFactoryC13351a(this, threadFactory));
                C12702g.m10804g(scheduledExecutorServiceNewScheduledThreadPool);
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(new b(), nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFutureScheduleWithFixedDelay = null;
            }
            this.f27176e = scheduledExecutorServiceNewScheduledThreadPool;
            this.f27177f = scheduledFutureScheduleWithFixedDelay;
        }

        /* JADX INFO: renamed from: a */
        public void m10800a() {
            try {
                Future<?> future = this.f27177f;
                if (future != null) {
                    future.cancel(true);
                }
                ScheduledExecutorService scheduledExecutorService = this.f27176e;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                }
            } finally {
                this.f27175d.unsubscribe();
            }
        }
    }

    /* JADX INFO: renamed from: j0.l.c.a$b */
    /* JADX INFO: compiled from: CachedThreadScheduler.java */
    public static final class b extends Scheduler.Worker implements Action0 {

        /* JADX INFO: renamed from: k */
        public final a f27181k;

        /* JADX INFO: renamed from: l */
        public final c f27182l;

        /* JADX INFO: renamed from: j */
        public final CompositeSubscription f27180j = new CompositeSubscription();

        /* JADX INFO: renamed from: m */
        public final AtomicBoolean f27183m = new AtomicBoolean();

        /* JADX INFO: renamed from: j0.l.c.a$b$a */
        /* JADX INFO: compiled from: CachedThreadScheduler.java */
        public class a implements Action0 {

            /* JADX INFO: renamed from: j */
            public final /* synthetic */ Action0 f27184j;

            public a(Action0 action0) {
                this.f27184j = action0;
            }

            @Override // p658rx.functions.Action0
            public void call() {
                if (b.this.f27180j.f27656k) {
                    return;
                }
                this.f27184j.call();
            }
        }

        public b(a aVar) {
            c cVar;
            c cVar2;
            this.f27181k = aVar;
            if (aVar.f27175d.f27656k) {
                cVar2 = C12696a.f27168c;
            } else {
                do {
                    if (aVar.f27174c.isEmpty()) {
                        cVar = new c(aVar.f27172a);
                        aVar.f27175d.m11136a(cVar);
                        break;
                    }
                    cVar = aVar.f27174c.poll();
                } while (cVar == null);
                cVar2 = cVar;
            }
            this.f27182l = cVar2;
        }

        @Override // rx.Scheduler.Worker
        /* JADX INFO: renamed from: a */
        public Subscription mo10740a(Action0 action0) {
            return mo10741b(action0, 0L, null);
        }

        @Override // rx.Scheduler.Worker
        /* JADX INFO: renamed from: b */
        public Subscription mo10741b(Action0 action0, long j, TimeUnit timeUnit) {
            if (this.f27180j.f27656k) {
                return C12787c.f27422a;
            }
            RunnableC12705j runnableC12705jM10805f = this.f27182l.m10805f(new a(action0), j, timeUnit);
            this.f27180j.m11136a(runnableC12705jM10805f);
            runnableC12705jM10805f.cancel.m11128a(new RunnableC12705j.c(runnableC12705jM10805f, this.f27180j));
            return runnableC12705jM10805f;
        }

        @Override // p658rx.functions.Action0
        public void call() {
            a aVar = this.f27181k;
            c cVar = this.f27182l;
            Objects.requireNonNull(aVar);
            cVar.f27186r = System.nanoTime() + aVar.f27173b;
            aVar.f27174c.offer(cVar);
        }

        @Override // p658rx.Subscription
        public boolean isUnsubscribed() {
            return this.f27180j.f27656k;
        }

        @Override // p658rx.Subscription
        public void unsubscribe() {
            if (this.f27183m.compareAndSet(false, true)) {
                this.f27182l.mo10740a(this);
            }
            this.f27180j.unsubscribe();
        }
    }

    /* JADX INFO: renamed from: j0.l.c.a$c */
    /* JADX INFO: compiled from: CachedThreadScheduler.java */
    public static final class c extends C12702g {

        /* JADX INFO: renamed from: r */
        public long f27186r;

        public c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f27186r = 0L;
        }
    }

    static {
        c cVar = new c(ThreadFactoryC12720j.f27286j);
        f27168c = cVar;
        cVar.unsubscribe();
        a aVar = new a(null, 0L, null);
        f27169d = aVar;
        aVar.m10800a();
        f27166a = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    public C12696a(ThreadFactory threadFactory) {
        this.f27170e = threadFactory;
        a aVar = f27169d;
        AtomicReference<a> atomicReference = new AtomicReference<>(aVar);
        this.f27171f = atomicReference;
        a aVar2 = new a(threadFactory, f27166a, f27167b);
        if (atomicReference.compareAndSet(aVar, aVar2)) {
            return;
        }
        aVar2.m10800a();
    }

    @Override // p658rx.Scheduler
    /* JADX INFO: renamed from: a */
    public Scheduler.Worker mo10739a() {
        return new b(this.f27171f.get());
    }

    @Override // p637j0.p642l.p645c.InterfaceC12706k
    public void shutdown() {
        a aVar;
        a aVar2;
        do {
            aVar = this.f27171f.get();
            aVar2 = f27169d;
            if (aVar == aVar2) {
                return;
            }
        } while (!this.f27171f.compareAndSet(aVar, aVar2));
        aVar.m10800a();
    }
}
