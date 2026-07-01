package j0.l.c;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Scheduler$Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: CachedThreadScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$b extends Scheduler$Worker implements Action0 {
    public final a$a k;
    public final a$c l;
    public final CompositeSubscription j = new CompositeSubscription();
    public final AtomicBoolean m = new AtomicBoolean();

    public a$b(a$a a_a) {
        a$c a_c;
        a$c a_c2;
        this.k = a_a;
        if (a_a.d.k) {
            a_c2 = a.c;
        } else {
            do {
                if (a_a.c.isEmpty()) {
                    a_c = new a$c(a_a.a);
                    a_a.d.a(a_c);
                    break;
                }
                a_c = a_a.c.poll();
            } while (a_c == null);
            a_c2 = a_c;
        }
        this.l = a_c2;
    }

    @Override // rx.Scheduler$Worker
    public Subscription a(Action0 action0) {
        return b(action0, 0L, null);
    }

    @Override // rx.Scheduler$Worker
    public Subscription b(Action0 action0, long j, TimeUnit timeUnit) {
        if (this.j.k) {
            return j0.r.c.a;
        }
        j jVarF = this.l.f(new a$b$a(this, action0), j, timeUnit);
        this.j.a(jVarF);
        jVarF.cancel.a(new j$c(jVarF, this.j));
        return jVarF;
    }

    @Override // rx.functions.Action0
    public void call() {
        a$a a_a = this.k;
        a$c a_c = this.l;
        Objects.requireNonNull(a_a);
        a_c.r = System.nanoTime() + a_a.f3786b;
        a_a.c.offer(a_c);
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
