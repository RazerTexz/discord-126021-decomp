package j0.l.a;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.l2, reason: use source file name */
/* JADX INFO: compiled from: OperatorThrottleFirst.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorThrottleFirst2<T> implements Observable.b<T, T> {
    public final long j;
    public final Scheduler k;

    public OperatorThrottleFirst2(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.j = timeUnit.toMillis(j);
        this.k = scheduler;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        return new OperatorThrottleFirst(this, subscriber, subscriber);
    }
}
