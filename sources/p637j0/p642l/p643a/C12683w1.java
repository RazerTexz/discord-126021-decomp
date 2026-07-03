package p637j0.p642l.p643a;

import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: j0.l.a.w1 */
/* JADX INFO: compiled from: OperatorSkipWhile.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12683w1<T> implements Observable.InterfaceC13006b<T, T> {

    /* JADX INFO: renamed from: j */
    public final Func2<? super T, Integer, Boolean> f27075j;

    public C12683w1(Func2<? super T, Integer, Boolean> func2) {
        this.f27075j = func2;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        return new C12677u1(this, subscriber, subscriber);
    }
}
