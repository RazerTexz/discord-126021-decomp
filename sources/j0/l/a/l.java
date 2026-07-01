package j0.l.a;

import rx.Observable;
import rx.Observable$a;
import rx.Subscriber;

/* JADX INFO: compiled from: OnSubscribeFilter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l<T> implements Observable$a<T> {
    public final Observable<T> j;
    public final j0.k.b<? super T, Boolean> k;

    public l(Observable<T> observable, j0.k.b<? super T, Boolean> bVar) {
        this.j = observable;
        this.k = bVar;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        l$a l_a = new l$a(subscriber, this.k);
        subscriber.add(l_a);
        this.j.i0(l_a);
    }
}
