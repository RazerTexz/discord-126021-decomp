package j0.l.a;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.s0, reason: use source file name */
/* JADX INFO: compiled from: OperatorDelay.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorDelay2<T> implements Observable.b<T, T> {
    public final long j;
    public final TimeUnit k;
    public final Scheduler l;

    public OperatorDelay2(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.j = j;
        this.k = timeUnit;
        this.l = scheduler;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler.Worker workerA = this.l.a();
        subscriber.add(workerA);
        return new OperatorDelay(this, subscriber, workerA, subscriber);
    }
}
