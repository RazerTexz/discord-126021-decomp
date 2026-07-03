package p637j0.p642l.p643a;

import p007b.p100d.p104b.p105a.C1643a;
import p658rx.Observable;
import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.c2 */
/* JADX INFO: compiled from: OperatorTake.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12609c2<T> implements Observable.InterfaceC13006b<T, T> {

    /* JADX INFO: renamed from: j */
    public final int f26758j;

    public C12609c2(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(C1643a.m871q("limit >= 0 required but it was ", i));
        }
        this.f26758j = i;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        C12605b2 c12605b2 = new C12605b2(this, subscriber);
        if (this.f26758j == 0) {
            subscriber.onCompleted();
            c12605b2.unsubscribe();
        }
        subscriber.add(c12605b2);
        return c12605b2;
    }
}
