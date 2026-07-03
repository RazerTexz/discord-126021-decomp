package p637j0.p642l.p643a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import p637j0.C12580f;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p644b.C12693a;
import p637j0.p642l.p645c.C12708m;
import p637j0.p651n.C12758a;
import p637j0.p651n.C12761d;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.Subscriber;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.SerializedSubject;
import p658rx.subscriptions.SerialSubscription;

/* JADX INFO: renamed from: j0.l.a.y */
/* JADX INFO: compiled from: OnSubscribeRedo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12687y<T> implements Observable.InterfaceC13005a<T> {

    /* JADX INFO: renamed from: j */
    public final Observable<T> f27120j;

    /* JADX INFO: renamed from: k */
    public final InterfaceC12589b<? super Observable<? extends C12580f<?>>, ? extends Observable<?>> f27121k;

    /* JADX INFO: renamed from: l */
    public final boolean f27122l;

    /* JADX INFO: renamed from: m */
    public final boolean f27123m;

    public C12687y(Observable<T> observable, InterfaceC12589b<? super Observable<? extends C12580f<?>>, ? extends Observable<?>> interfaceC12589b, boolean z2, boolean z3, Scheduler scheduler) {
        this.f27120j = observable;
        this.f27121k = interfaceC12589b;
        this.f27122l = z2;
        this.f27123m = z3;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicLong atomicLong = new AtomicLong();
        C12708m.a aVar = new C12708m.a();
        subscriber.add(aVar);
        SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        SerializedSubject serializedSubject = new SerializedSubject(BehaviorSubject.m11129k0());
        serializedSubject.m11095U(new C12761d(C12758a.f27363a));
        C12693a c12693a = new C12693a();
        C12672t c12672t = new C12672t(this, subscriber, serializedSubject, c12693a, atomicLong, serialSubscription);
        aVar.mo10740a(new C12681w(this, this.f27121k.call(Observable.m11074h0(new C12666r(serializedSubject.f27640j, new C12678v(this)))), subscriber, atomicLong, aVar, c12672t, atomicBoolean));
        subscriber.setProducer(new C12684x(this, atomicLong, c12693a, atomicBoolean, aVar, c12672t));
    }
}
