package j0.l.a;

import java.util.concurrent.TimeUnit;
import rx.Observable$b;
import rx.Scheduler;
import rx.Scheduler$Worker;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

/* JADX INFO: compiled from: OperatorSampleWithTime.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n1<T> implements Observable$b<T, T> {
    public final long j;
    public final TimeUnit k;
    public final Scheduler l;

    public n1(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.j = j;
        this.k = timeUnit;
        this.l = scheduler;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        Scheduler$Worker scheduler$WorkerA = this.l.a();
        subscriber.add(scheduler$WorkerA);
        n1$a n1_a = new n1$a(serializedSubscriber);
        subscriber.add(n1_a);
        long j = this.j;
        scheduler$WorkerA.c(n1_a, j, j, this.k);
        return n1_a;
    }
}
