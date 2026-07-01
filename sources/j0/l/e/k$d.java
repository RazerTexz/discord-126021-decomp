package j0.l.e;

import rx.Observable$a;
import rx.Subscriber;

/* JADX INFO: compiled from: ScalarSynchronousObservable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k$d<T> implements Observable$a<T> {
    public final T j;

    public k$d(T t) {
        this.j = t;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        T t = this.j;
        subscriber.setProducer(k.k ? new j0.l.b.c(subscriber, t) : new k$g(subscriber, t));
    }
}
