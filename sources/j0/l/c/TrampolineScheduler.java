package j0.l.c;

import j0.r.BooleanSubscription;
import j0.r.Subscriptions;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.c.m, reason: use source file name */
/* JADX INFO: compiled from: TrampolineScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TrampolineScheduler extends Scheduler {
    public static final TrampolineScheduler a = new TrampolineScheduler();

    /* JADX INFO: renamed from: j0.l.c.m$a */
    /* JADX INFO: compiled from: TrampolineScheduler.java */
    public static final class a extends Scheduler.Worker implements Subscription {
        public final AtomicInteger j = new AtomicInteger();
        public final PriorityBlockingQueue<b> k = new PriorityBlockingQueue<>();
        public final BooleanSubscription l = new BooleanSubscription();
        public final AtomicInteger m = new AtomicInteger();

        /* JADX INFO: renamed from: j0.l.c.m$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: TrampolineScheduler.java */
        public class C0432a implements Action0 {
            public final /* synthetic */ b j;

            public C0432a(b bVar) {
                this.j = bVar;
            }

            @Override // rx.functions.Action0
            public void call() {
                a.this.k.remove(this.j);
            }
        }

        @Override // rx.Scheduler.Worker
        public Subscription a(Action0 action0) {
            return d(action0, System.currentTimeMillis());
        }

        @Override // rx.Scheduler.Worker
        public Subscription b(Action0 action0, long j, TimeUnit timeUnit) {
            long millis = timeUnit.toMillis(j) + System.currentTimeMillis();
            return d(new SleepingAction(action0, this, millis), millis);
        }

        public final Subscription d(Action0 action0, long j) {
            if (this.l.isUnsubscribed()) {
                return Subscriptions.a;
            }
            b bVar = new b(action0, Long.valueOf(j), this.j.incrementAndGet());
            this.k.add(bVar);
            if (this.m.getAndIncrement() != 0) {
                return new BooleanSubscription(new C0432a(bVar));
            }
            do {
                b bVarPoll = this.k.poll();
                if (bVarPoll != null) {
                    bVarPoll.j.call();
                }
            } while (this.m.decrementAndGet() > 0);
            return Subscriptions.a;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.l.isUnsubscribed();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.l.unsubscribe();
        }
    }

    /* JADX INFO: renamed from: j0.l.c.m$b */
    /* JADX INFO: compiled from: TrampolineScheduler.java */
    public static final class b implements Comparable<b> {
        public final Action0 j;
        public final Long k;
        public final int l;

        public b(Action0 action0, Long l, int i) {
            this.j = action0;
            this.k = l;
            this.l = i;
        }

        @Override // java.lang.Comparable
        public int compareTo(b bVar) {
            b bVar2 = bVar;
            int iCompareTo = this.k.compareTo(bVar2.k);
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            int i = this.l;
            int i2 = bVar2.l;
            if (i < i2) {
                return -1;
            }
            return i == i2 ? 0 : 1;
        }
    }

    @Override // rx.Scheduler
    public Scheduler.Worker a() {
        return new a();
    }
}
