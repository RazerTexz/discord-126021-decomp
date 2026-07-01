package j0.l.a;

import rx.Observable;
import rx.Observable$a;
import rx.Subscriber;

/* JADX INFO: compiled from: OnSubscribeMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s<T, R> implements Observable$a<R> {
    public final Observable<T> j;
    public final j0.k.b<? super T, ? extends R> k;

    public s(Observable<T> observable, j0.k.b<? super T, ? extends R> bVar) {
        this.j = observable;
        this.k = bVar;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        s$a s_a = new s$a(subscriber, this.k);
        subscriber.add(s_a);
        this.j.i0(s_a);
    }
}
