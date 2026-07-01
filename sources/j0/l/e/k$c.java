package j0.l.e;

import rx.Observable;
import rx.Observable$a;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: ScalarSynchronousObservable.java */
/* JADX INFO: loaded from: classes3.dex */
public class k$c<R> implements Observable$a<R> {
    public final /* synthetic */ j0.k.b j;
    public final /* synthetic */ k k;

    public k$c(k kVar, j0.k.b bVar) {
        this.k = kVar;
        this.j = bVar;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Observable observable = (Observable) this.j.call(this.k.l);
        if (!(observable instanceof k)) {
            observable.i0(new j0.n.e(subscriber, subscriber));
        } else {
            T t = ((k) observable).l;
            subscriber.setProducer(k.k ? new j0.l.b.c(subscriber, t) : new k$g(subscriber, t));
        }
    }
}
