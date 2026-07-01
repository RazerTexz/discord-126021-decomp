package j0.l.a;

import rx.Observable;
import rx.Observable$a;
import rx.Scheduler;
import rx.Scheduler$Worker;
import rx.Subscriber;

/* JADX INFO: compiled from: OperatorSubscribeOn.java */
/* JADX INFO: loaded from: classes3.dex */
public final class x1<T> implements Observable$a<T> {
    public final Scheduler j;
    public final Observable<T> k;
    public final boolean l;

    public x1(Observable<T> observable, Scheduler scheduler, boolean z2) {
        this.j = scheduler;
        this.k = observable;
        this.l = z2;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler$Worker scheduler$WorkerA = this.j.a();
        x1$a x1_a = new x1$a(subscriber, this.l, scheduler$WorkerA, this.k);
        subscriber.add(x1_a);
        subscriber.add(scheduler$WorkerA);
        scheduler$WorkerA.a(x1_a);
    }
}
