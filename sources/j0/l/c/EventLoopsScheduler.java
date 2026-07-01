package j0.l.c;

import j0.l.e.RxThreadFactory;
import j0.r.Subscriptions;
import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.SubscriptionList;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: renamed from: j0.l.c.b, reason: use source file name */
/* JADX INFO: compiled from: EventLoopsScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class EventLoopsScheduler extends Scheduler implements SchedulerLifecycle {
    public static final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f3787b;
    public static final b c;
    public final ThreadFactory d;
    public final AtomicReference<b> e;

    /* JADX INFO: renamed from: j0.l.c.b$a */
    /* JADX INFO: compiled from: EventLoopsScheduler.java */
    public static final class a extends Scheduler.Worker {
        public final SubscriptionList j;
        public final CompositeSubscription k;
        public final SubscriptionList l;
        public final c m;

        /* JADX INFO: renamed from: j0.l.c.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: EventLoopsScheduler.java */
        public class C0430a implements Action0 {
            public final /* synthetic */ Action0 j;

            public C0430a(Action0 action0) {
                this.j = action0;
            }

            @Override // rx.functions.Action0
            public void call() {
                if (a.this.l.k) {
                    return;
                }
                this.j.call();
            }
        }

        /* JADX INFO: renamed from: j0.l.c.b$a$b */
        /* JADX INFO: compiled from: EventLoopsScheduler.java */
        public class b implements Action0 {
            public final /* synthetic */ Action0 j;

            public b(Action0 action0) {
                this.j = action0;
            }

            @Override // rx.functions.Action0
            public void call() {
                if (a.this.l.k) {
                    return;
                }
                this.j.call();
            }
        }

        public a(c cVar) {
            SubscriptionList subscriptionList = new SubscriptionList();
            this.j = subscriptionList;
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            this.k = compositeSubscription;
            this.l = new SubscriptionList(subscriptionList, compositeSubscription);
            this.m = cVar;
        }

        @Override // rx.Scheduler.Worker
        public Subscription a(Action0 action0) {
            if (this.l.k) {
                return Subscriptions.a;
            }
            c cVar = this.m;
            C0430a c0430a = new C0430a(action0);
            SubscriptionList subscriptionList = this.j;
            Objects.requireNonNull(cVar);
            ScheduledAction scheduledAction = new ScheduledAction(j0.o.l.d(c0430a), subscriptionList);
            subscriptionList.a(scheduledAction);
            scheduledAction.a(cVar.p.submit(scheduledAction));
            return scheduledAction;
        }

        @Override // rx.Scheduler.Worker
        public Subscription b(Action0 action0, long j, TimeUnit timeUnit) {
            if (this.l.k) {
                return Subscriptions.a;
            }
            c cVar = this.m;
            b bVar = new b(action0);
            CompositeSubscription compositeSubscription = this.k;
            Objects.requireNonNull(cVar);
            ScheduledAction scheduledAction = new ScheduledAction(j0.o.l.d(bVar), compositeSubscription);
            compositeSubscription.a(scheduledAction);
            scheduledAction.a(j <= 0 ? cVar.p.submit(scheduledAction) : cVar.p.schedule(scheduledAction, j, timeUnit));
            return scheduledAction;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.l.k;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.l.unsubscribe();
        }
    }

    /* JADX INFO: renamed from: j0.l.c.b$b */
    /* JADX INFO: compiled from: EventLoopsScheduler.java */
    public static final class b {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c[] f3788b;
        public long c;

        public b(ThreadFactory threadFactory, int i) {
            this.a = i;
            this.f3788b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f3788b[i2] = new c(threadFactory);
            }
        }

        public c a() {
            int i = this.a;
            if (i == 0) {
                return EventLoopsScheduler.f3787b;
            }
            c[] cVarArr = this.f3788b;
            long j = this.c;
            this.c = 1 + j;
            return cVarArr[(int) (j % ((long) i))];
        }
    }

    /* JADX INFO: renamed from: j0.l.c.b$c */
    /* JADX INFO: compiled from: EventLoopsScheduler.java */
    public static final class c extends NewThreadWorker {
        public c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        int iIntValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        if (iIntValue <= 0 || iIntValue > iAvailableProcessors) {
            iIntValue = iAvailableProcessors;
        }
        a = iIntValue;
        c cVar = new c(RxThreadFactory.j);
        f3787b = cVar;
        cVar.unsubscribe();
        c = new b(null, 0);
    }

    public EventLoopsScheduler(ThreadFactory threadFactory) {
        this.d = threadFactory;
        b bVar = c;
        AtomicReference<b> atomicReference = new AtomicReference<>(bVar);
        this.e = atomicReference;
        b bVar2 = new b(threadFactory, a);
        if (atomicReference.compareAndSet(bVar, bVar2)) {
            return;
        }
        for (c cVar : bVar2.f3788b) {
            cVar.unsubscribe();
        }
    }

    @Override // rx.Scheduler
    public Scheduler.Worker a() {
        return new a(this.e.get().a());
    }

    @Override // j0.l.c.SchedulerLifecycle
    public void shutdown() {
        b bVar;
        b bVar2;
        do {
            bVar = this.e.get();
            bVar2 = c;
            if (bVar == bVar2) {
                return;
            }
        } while (!this.e.compareAndSet(bVar, bVar2));
        for (c cVar : bVar.f3788b) {
            cVar.unsubscribe();
        }
    }
}
