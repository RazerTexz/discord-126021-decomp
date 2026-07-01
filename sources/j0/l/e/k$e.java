package j0.l.e;

import rx.Observable$a;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;

/* JADX INFO: compiled from: ScalarSynchronousObservable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k$e<T> implements Observable$a<T> {
    public final T j;
    public final j0.k.b<Action0, Subscription> k;

    public k$e(T t, j0.k.b<Action0, Subscription> bVar) {
        this.j = t;
        this.k = bVar;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        subscriber.setProducer(new k$f(subscriber, this.j, this.k));
    }
}
