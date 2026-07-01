package j0.l.a;

import rx.Observable;
import rx.Observable$a;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

/* JADX INFO: compiled from: OnSubscribeConcatMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h<T, R> implements Observable$a<R> {
    public final Observable<? extends T> j;
    public final j0.k.b<? super T, ? extends Observable<? extends R>> k;

    public h(Observable<? extends T> observable, j0.k.b<? super T, ? extends Observable<? extends R>> bVar, int i, int i2) {
        this.j = observable;
        this.k = bVar;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        h$c h_c = new h$c(new SerializedSubscriber(subscriber), this.k, 2, 0);
        subscriber.add(h_c);
        subscriber.add(h_c.q);
        subscriber.setProducer(new g(this, h_c));
        if (subscriber.isUnsubscribed()) {
            return;
        }
        this.j.i0(h_c);
    }
}
