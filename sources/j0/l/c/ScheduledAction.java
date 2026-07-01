package j0.l.c;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action0;
import rx.internal.util.SubscriptionList;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: renamed from: j0.l.c.j, reason: use source file name */
/* JADX INFO: compiled from: ScheduledAction.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, Subscription {
    private static final long serialVersionUID = -3962399486978279857L;
    public final Action0 action;
    public final SubscriptionList cancel;

    /* JADX INFO: renamed from: j0.l.c.j$a */
    /* JADX INFO: compiled from: ScheduledAction.java */
    public final class a implements Subscription {
        public final Future<?> j;

        public a(Future<?> future) {
            this.j = future;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.j.isCancelled();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.j.cancel(true);
            } else {
                this.j.cancel(false);
            }
        }
    }

    /* JADX INFO: renamed from: j0.l.c.j$b */
    /* JADX INFO: compiled from: ScheduledAction.java */
    public static final class b extends AtomicBoolean implements Subscription {
        private static final long serialVersionUID = 247232374289553518L;
        public final SubscriptionList parent;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final ScheduledAction f3792s;

        public b(ScheduledAction scheduledAction, SubscriptionList subscriptionList) {
            this.f3792s = scheduledAction;
            this.parent = subscriptionList;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.f3792s.cancel.k;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                SubscriptionList subscriptionList = this.parent;
                ScheduledAction scheduledAction = this.f3792s;
                if (subscriptionList.k) {
                    return;
                }
                synchronized (subscriptionList) {
                    List<Subscription> list = subscriptionList.j;
                    if (!subscriptionList.k && list != null) {
                        boolean zRemove = list.remove(scheduledAction);
                        if (zRemove) {
                            scheduledAction.unsubscribe();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: j0.l.c.j$c */
    /* JADX INFO: compiled from: ScheduledAction.java */
    public static final class c extends AtomicBoolean implements Subscription {
        private static final long serialVersionUID = 247232374289553518L;
        public final CompositeSubscription parent;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final ScheduledAction f3793s;

        public c(ScheduledAction scheduledAction, CompositeSubscription compositeSubscription) {
            this.f3793s = scheduledAction;
            this.parent = compositeSubscription;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.f3793s.cancel.k;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.c(this.f3793s);
            }
        }
    }

    public ScheduledAction(Action0 action0) {
        this.action = action0;
        this.cancel = new SubscriptionList();
    }

    public void a(Future<?> future) {
        this.cancel.a(new a(future));
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.cancel.k;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                lazySet(Thread.currentThread());
                this.action.call();
            } catch (Throwable th) {
                unsubscribe();
                throw th;
            }
        } catch (OnErrorNotImplementedException e) {
            IllegalStateException illegalStateException = new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e);
            j0.o.l.b(illegalStateException);
            Thread threadCurrentThread = Thread.currentThread();
            threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, illegalStateException);
        } catch (Throwable th2) {
            IllegalStateException illegalStateException2 = new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th2);
            j0.o.l.b(illegalStateException2);
            Thread threadCurrentThread2 = Thread.currentThread();
            threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, illegalStateException2);
        }
        unsubscribe();
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (this.cancel.k) {
            return;
        }
        this.cancel.unsubscribe();
    }

    public ScheduledAction(Action0 action0, CompositeSubscription compositeSubscription) {
        this.action = action0;
        this.cancel = new SubscriptionList(new c(this, compositeSubscription));
    }

    public ScheduledAction(Action0 action0, SubscriptionList subscriptionList) {
        this.action = action0;
        this.cancel = new SubscriptionList(new b(this, subscriptionList));
    }
}
