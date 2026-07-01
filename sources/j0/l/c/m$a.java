package j0.l.c;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Scheduler$Worker;
import rx.Subscription;
import rx.functions.Action0;

/* JADX INFO: compiled from: TrampolineScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m$a extends Scheduler$Worker implements Subscription {
    public final AtomicInteger j = new AtomicInteger();
    public final PriorityBlockingQueue<m$b> k = new PriorityBlockingQueue<>();
    public final j0.r.a l = new j0.r.a();
    public final AtomicInteger m = new AtomicInteger();

    @Override // rx.Scheduler$Worker
    public Subscription a(Action0 action0) {
        return d(action0, System.currentTimeMillis());
    }

    @Override // rx.Scheduler$Worker
    public Subscription b(Action0 action0, long j, TimeUnit timeUnit) {
        long millis = timeUnit.toMillis(j) + System.currentTimeMillis();
        return d(new l(action0, this, millis), millis);
    }

    public final Subscription d(Action0 action0, long j) {
        if (this.l.isUnsubscribed()) {
            return j0.r.c.a;
        }
        m$b m_b = new m$b(action0, Long.valueOf(j), this.j.incrementAndGet());
        this.k.add(m_b);
        if (this.m.getAndIncrement() != 0) {
            return new j0.r.a(new m$a$a(this, m_b));
        }
        do {
            m$b m_bPoll = this.k.poll();
            if (m_bPoll != null) {
                m_bPoll.j.call();
            }
        } while (this.m.decrementAndGet() > 0);
        return j0.r.c.a;
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
