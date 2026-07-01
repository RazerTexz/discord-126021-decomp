package j0.l.a;

import j0.n.Subscribers2;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;

/* JADX INFO: renamed from: j0.l.a.j, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeDefer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OnSubscribeDefer<T> implements Observable.a<T> {
    public final Func0<? extends Observable<? extends T>> j;

    public OnSubscribeDefer(Func0<? extends Observable<? extends T>> func0) {
        this.j = func0;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        try {
            this.j.call().i0(new Subscribers2(subscriber, subscriber));
        } catch (Throwable th) {
            b.i.a.f.e.o.f.o1(th);
            subscriber.onError(th);
        }
    }
}
