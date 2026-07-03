package p637j0.p642l.p643a;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p651n.C12762e;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.functions.Func0;

/* JADX INFO: renamed from: j0.l.a.j */
/* JADX INFO: compiled from: OnSubscribeDefer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12634j<T> implements Observable.InterfaceC13005a<T> {

    /* JADX INFO: renamed from: j */
    public final Func0<? extends Observable<? extends T>> f26853j;

    public C12634j(Func0<? extends Observable<? extends T>> func0) {
        this.f26853j = func0;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        try {
            this.f26853j.call().m11107i0(new C12762e(subscriber, subscriber));
        } catch (Throwable th) {
            C3404f.m4325o1(th);
            subscriber.onError(th);
        }
    }
}
