package p637j0.p642l.p643a;

import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.observers.SerializedSubscriber;

/* JADX INFO: renamed from: j0.l.a.f2 */
/* JADX INFO: compiled from: OperatorTakeUntil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12621f2<T, E> implements Observable.InterfaceC13006b<T, T> {

    /* JADX INFO: renamed from: j */
    public final Observable<? extends E> f26789j;

    public C12621f2(Observable<? extends E> observable) {
        this.f26789j = observable;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber, false);
        C12613d2 c12613d2 = new C12613d2(this, serializedSubscriber, false, serializedSubscriber);
        C12617e2 c12617e2 = new C12617e2(this, c12613d2);
        serializedSubscriber.add(c12613d2);
        serializedSubscriber.add(c12617e2);
        subscriber.add(serializedSubscriber);
        this.f26789j.m11107i0(c12617e2);
        return c12613d2;
    }
}
