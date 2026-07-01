package j0.l.c;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import rx.Scheduler$Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.SubscriptionList;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: EventLoopsScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b$a extends Scheduler$Worker {
    public final SubscriptionList j;
    public final CompositeSubscription k;
    public final SubscriptionList l;
    public final b$c m;

    public b$a(b$c b_c) {
        SubscriptionList subscriptionList = new SubscriptionList();
        this.j = subscriptionList;
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        this.k = compositeSubscription;
        this.l = new SubscriptionList(subscriptionList, compositeSubscription);
        this.m = b_c;
    }

    @Override // rx.Scheduler$Worker
    public Subscription a(Action0 action0) {
        if (this.l.k) {
            return j0.r.c.a;
        }
        b$c b_c = this.m;
        b$a$a b_a_a = new b$a$a(this, action0);
        SubscriptionList subscriptionList = this.j;
        Objects.requireNonNull(b_c);
        j jVar = new j(j0.o.l.d(b_a_a), subscriptionList);
        subscriptionList.a(jVar);
        jVar.a(b_c.p.submit(jVar));
        return jVar;
    }

    @Override // rx.Scheduler$Worker
    public Subscription b(Action0 action0, long j, TimeUnit timeUnit) {
        if (this.l.k) {
            return j0.r.c.a;
        }
        b$c b_c = this.m;
        b$a$b b_a_b = new b$a$b(this, action0);
        CompositeSubscription compositeSubscription = this.k;
        Objects.requireNonNull(b_c);
        j jVar = new j(j0.o.l.d(b_a_b), compositeSubscription);
        compositeSubscription.a(jVar);
        jVar.a(j <= 0 ? b_c.p.submit(jVar) : b_c.p.schedule(jVar, j, timeUnit));
        return jVar;
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
