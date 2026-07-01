package j0.l.a;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.i0, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeTimerOnce.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OnSubscribeTimerOnce2 implements Observable.a<Long> {
    public final long j;
    public final TimeUnit k;
    public final Scheduler l;

    public OnSubscribeTimerOnce2(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.j = j;
        this.k = timeUnit;
        this.l = scheduler;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler.Worker workerA = this.l.a();
        subscriber.add(workerA);
        workerA.b(new OnSubscribeTimerOnce(this, subscriber), this.j, this.k);
    }
}
