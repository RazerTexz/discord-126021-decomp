package j0.l.a;

import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import rx.Observable$a;
import rx.Subscriber;
import rx.functions.Func0;

/* JADX INFO: compiled from: OnSubscribeToMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l0<T, K, V> implements Observable$a<Map<K, V>>, Func0<Map<K, V>> {
    public final Observable<T> j;
    public final j0.k.b<? super T, ? extends K> k;
    public final j0.k.b<? super T, ? extends V> l;
    public final Func0<? extends Map<K, V>> m = this;

    public l0(Observable<T> observable, j0.k.b<? super T, ? extends K> bVar, j0.k.b<? super T, ? extends V> bVar2) {
        this.j = observable;
        this.k = bVar;
        this.l = bVar2;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        try {
            l0$a l0_a = new l0$a(subscriber, this.m.call(), this.k, this.l);
            Observable<T> observable = this.j;
            Subscriber<? super R> subscriber2 = l0_a.j;
            subscriber2.add(l0_a);
            subscriber2.setProducer(new a$a(l0_a));
            observable.i0(l0_a);
        } catch (Throwable th) {
            b.i.a.f.e.o.f.o1(th);
            subscriber.onError(th);
        }
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public Object call() {
        return new HashMap();
    }
}
