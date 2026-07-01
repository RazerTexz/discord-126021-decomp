package j0.l.a;

import java.util.concurrent.TimeUnit;
import rx.Observable$b;
import rx.Scheduler;
import rx.Scheduler$Worker;
import rx.Subscriber;

/* JADX INFO: compiled from: OperatorDelay.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s0<T> implements Observable$b<T, T> {
    public final long j;
    public final TimeUnit k;
    public final Scheduler l;

    public s0(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.j = j;
        this.k = timeUnit;
        this.l = scheduler;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler$Worker scheduler$WorkerA = this.l.a();
        subscriber.add(scheduler$WorkerA);
        return new r0(this, subscriber, scheduler$WorkerA, subscriber);
    }
}
