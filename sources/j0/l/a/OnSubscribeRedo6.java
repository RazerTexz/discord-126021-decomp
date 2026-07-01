package j0.l.a;

import j0.Notification;
import j0.k.Func1;
import j0.l.b.ProducerArbiter;
import j0.l.c.TrampolineScheduler;
import j0.n.Observers;
import j0.n.Subscribers;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;
import rx.subscriptions.SerialSubscription;

/* JADX INFO: renamed from: j0.l.a.y, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeRedo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OnSubscribeRedo6<T> implements Observable.a<T> {
    public final Observable<T> j;
    public final Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> k;
    public final boolean l;
    public final boolean m;

    public OnSubscribeRedo6(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, boolean z2, boolean z3, Scheduler scheduler) {
        this.j = observable;
        this.k = func1;
        this.l = z2;
        this.m = z3;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicLong atomicLong = new AtomicLong();
        TrampolineScheduler.a aVar = new TrampolineScheduler.a();
        subscriber.add(aVar);
        SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        SerializedSubject serializedSubject = new SerializedSubject(BehaviorSubject.k0());
        serializedSubject.U(new Subscribers(Observers.a));
        ProducerArbiter producerArbiter = new ProducerArbiter();
        OnSubscribeRedo onSubscribeRedo = new OnSubscribeRedo(this, subscriber, serializedSubject, producerArbiter, atomicLong, serialSubscription);
        aVar.a(new OnSubscribeRedo4(this, this.k.call(Observable.h0(new OnSubscribeLift(serializedSubject.j, new OnSubscribeRedo3(this)))), subscriber, atomicLong, aVar, onSubscribeRedo, atomicBoolean));
        subscriber.setProducer(new OnSubscribeRedo5(this, atomicLong, producerArbiter, atomicBoolean, aVar, onSubscribeRedo));
    }
}
