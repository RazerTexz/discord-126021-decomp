package p637j0.p642l.p643a;

import p007b.p100d.p104b.p105a.C1643a;
import p658rx.Observable;
import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.t1 */
/* JADX INFO: compiled from: OperatorSkip.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12674t1<T> implements Observable.InterfaceC13006b<T, T> {

    /* JADX INFO: renamed from: j */
    public final int f27054j;

    public C12674t1(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(C1643a.m871q("n >= 0 required but it was ", i));
        }
        this.f27054j = i;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        return new C12671s1(this, subscriber, subscriber);
    }
}
