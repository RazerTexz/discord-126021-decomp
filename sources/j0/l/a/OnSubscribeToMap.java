package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import j0.k.Func1;
import j0.l.a.DeferredScalarSubscriber;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;

/* JADX INFO: renamed from: j0.l.a.l0, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeToMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OnSubscribeToMap<T, K, V> implements Observable.a<Map<K, V>>, Func0<Map<K, V>> {
    public final Observable<T> j;
    public final Func1<? super T, ? extends K> k;
    public final Func1<? super T, ? extends V> l;
    public final Func0<? extends Map<K, V>> m = this;

    /* JADX INFO: renamed from: j0.l.a.l0$a */
    /* JADX INFO: compiled from: OnSubscribeToMap.java */
    public static final class a<T, K, V> extends DeferredScalarSubscriberSafe<T, Map<K, V>> {
        public final Func1<? super T, ? extends K> o;
        public final Func1<? super T, ? extends V> p;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Subscriber<? super Map<K, V>> subscriber, Map<K, V> map, Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func2) {
            super(subscriber);
            this.l = map;
            this.k = true;
            this.o = func1;
            this.p = func2;
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            if (this.n) {
                return;
            }
            try {
                ((Map) this.l).put(this.o.call(t), this.p.call(t));
            } catch (Throwable th) {
                b.i.a.f.e.o.f.o1(th);
                unsubscribe();
                onError(th);
            }
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(RecyclerView.FOREVER_NS);
        }
    }

    public OnSubscribeToMap(Observable<T> observable, Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func2) {
        this.j = observable;
        this.k = func1;
        this.l = func2;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        try {
            a aVar = new a(subscriber, this.m.call(), this.k, this.l);
            Observable<T> observable = this.j;
            Subscriber<? super R> subscriber2 = aVar.j;
            subscriber2.add(aVar);
            subscriber2.setProducer(new DeferredScalarSubscriber.a(aVar));
            observable.i0(aVar);
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
