package p637j0.p642l.p643a;

import p637j0.p651n.C12762e;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.v0 */
/* JADX INFO: compiled from: OperatorDoOnSubscribe.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12679v0<T> implements Observable.InterfaceC13006b<T, T> {

    /* JADX INFO: renamed from: j */
    public final Action0 f27065j;

    public C12679v0(Action0 action0) {
        this.f27065j = action0;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        this.f27065j.call();
        return new C12762e(subscriber, subscriber);
    }
}
