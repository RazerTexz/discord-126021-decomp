package p637j0.p642l.p643a;

import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p644b.C12693a;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.subscriptions.SerialSubscription;

/* JADX INFO: renamed from: j0.l.a.f1 */
/* JADX INFO: compiled from: OperatorOnErrorResumeNextViaFunction.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12620f1<T> implements Observable.InterfaceC13006b<T, T> {

    /* JADX INFO: renamed from: j */
    public final InterfaceC12589b<? super Throwable, ? extends Observable<? extends T>> f26788j;

    public C12620f1(InterfaceC12589b<? super Throwable, ? extends Observable<? extends T>> interfaceC12589b) {
        this.f26788j = interfaceC12589b;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        C12693a c12693a = new C12693a();
        SerialSubscription serialSubscription = new SerialSubscription();
        C12616e1 c12616e1 = new C12616e1(this, subscriber, c12693a, serialSubscription);
        serialSubscription.m11139a(c12616e1);
        subscriber.add(serialSubscription);
        subscriber.setProducer(c12693a);
        return c12616e1;
    }
}
