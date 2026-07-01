package j0.l.a;

import rx.Observable$b;
import rx.Subscriber;
import rx.functions.Action0;

/* JADX INFO: compiled from: OperatorDoOnUnsubscribe.java */
/* JADX INFO: loaded from: classes3.dex */
public class w0<T> implements Observable$b<T, T> {
    public final Action0 j;

    public w0(Action0 action0) {
        this.j = action0;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        subscriber.add(new j0.r.a(this.j));
        return new j0.n.e(subscriber, subscriber);
    }
}
