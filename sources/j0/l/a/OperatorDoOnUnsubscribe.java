package j0.l.a;

import j0.n.Subscribers2;
import j0.r.BooleanSubscription;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.w0, reason: use source file name */
/* JADX INFO: compiled from: OperatorDoOnUnsubscribe.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorDoOnUnsubscribe<T> implements Observable.b<T, T> {
    public final Action0 j;

    public OperatorDoOnUnsubscribe(Action0 action0) {
        this.j = action0;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        subscriber.add(new BooleanSubscription(this.j));
        return new Subscribers2(subscriber, subscriber);
    }
}
