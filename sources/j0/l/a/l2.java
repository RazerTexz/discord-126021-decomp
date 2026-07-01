package j0.l.a;

import java.util.concurrent.TimeUnit;
import rx.Observable$b;
import rx.Scheduler;
import rx.Subscriber;

/* JADX INFO: compiled from: OperatorThrottleFirst.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l2<T> implements Observable$b<T, T> {
    public final long j;
    public final Scheduler k;

    public l2(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.j = timeUnit.toMillis(j);
        this.k = scheduler;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        return new k2(this, subscriber, subscriber);
    }
}
