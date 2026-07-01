package j0.l.a;

import java.util.concurrent.TimeUnit;
import rx.Observable$b;
import rx.Scheduler;
import rx.Scheduler$Worker;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

/* JADX INFO: compiled from: OperatorDebounceWithTime.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q0<T> implements Observable$b<T, T> {
    public final long j;
    public final TimeUnit k;
    public final Scheduler l;

    public q0(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.j = j;
        this.k = timeUnit;
        this.l = scheduler;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler$Worker scheduler$WorkerA = this.l.a();
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        SerialSubscription serialSubscription = new SerialSubscription();
        serializedSubscriber.add(scheduler$WorkerA);
        serializedSubscriber.add(serialSubscription);
        return new p0(this, subscriber, serialSubscription, scheduler$WorkerA, serializedSubscriber);
    }
}
