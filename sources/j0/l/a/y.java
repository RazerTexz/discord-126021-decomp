package j0.l.a;

import j0.l.c.m$a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observable$a;
import rx.Scheduler;
import rx.Subscriber;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;
import rx.subscriptions.SerialSubscription;

/* JADX INFO: compiled from: OnSubscribeRedo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class y<T> implements Observable$a<T> {
    public final Observable<T> j;
    public final j0.k.b<? super Observable<? extends j0.f<?>>, ? extends Observable<?>> k;
    public final boolean l;
    public final boolean m;

    public y(Observable<T> observable, j0.k.b<? super Observable<? extends j0.f<?>>, ? extends Observable<?>> bVar, boolean z2, boolean z3, Scheduler scheduler) {
        this.j = observable;
        this.k = bVar;
        this.l = z2;
        this.m = z3;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicLong atomicLong = new AtomicLong();
        m$a m_a = new m$a();
        subscriber.add(m_a);
        SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        SerializedSubject serializedSubject = new SerializedSubject(BehaviorSubject.k0());
        serializedSubject.U(new j0.n.d(j0.n.a.a));
        j0.l.b.a aVar = new j0.l.b.a();
        t tVar = new t(this, subscriber, serializedSubject, aVar, atomicLong, serialSubscription);
        m_a.a(new w(this, this.k.call(Observable.h0(new r(serializedSubject.j, new v(this)))), subscriber, atomicLong, m_a, tVar, atomicBoolean));
        subscriber.setProducer(new x(this, atomicLong, aVar, atomicBoolean, m_a, tVar));
    }
}
