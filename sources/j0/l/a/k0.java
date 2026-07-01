package j0.l.a;

import java.util.concurrent.TimeUnit;
import rx.Observable$a;
import rx.Scheduler;
import rx.Scheduler$Worker;
import rx.Subscriber;

/* JADX INFO: compiled from: OnSubscribeTimerPeriodically.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k0 implements Observable$a<Long> {
    public final long j;
    public final long k;
    public final TimeUnit l;
    public final Scheduler m;

    public k0(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.j = j;
        this.k = j2;
        this.l = timeUnit;
        this.m = scheduler;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler$Worker scheduler$WorkerA = this.m.a();
        subscriber.add(scheduler$WorkerA);
        scheduler$WorkerA.c(new j0(this, subscriber, scheduler$WorkerA), this.j, this.k, this.l);
    }
}
