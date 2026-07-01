package j0.l.a;

import rx.Observable;
import rx.Observable$a;
import rx.Subscriber;

/* JADX INFO: compiled from: OnSubscribeFlattenIterable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n<T, R> implements Observable$a<R> {
    public final Observable<? extends T> j;
    public final j0.k.b<? super T, ? extends Iterable<? extends R>> k;
    public final int l;

    public n(Observable<? extends T> observable, j0.k.b<? super T, ? extends Iterable<? extends R>> bVar, int i) {
        this.j = observable;
        this.k = bVar;
        this.l = i;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        n$a n_a = new n$a(subscriber, this.k, this.l);
        subscriber.add(n_a);
        subscriber.setProducer(new m(this, n_a));
        this.j.i0(n_a);
    }
}
