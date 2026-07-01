package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Map;
import rx.Subscriber;

/* JADX INFO: compiled from: OnSubscribeToMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l0$a<T, K, V> extends b<T, Map<K, V>> {
    public final j0.k.b<? super T, ? extends K> o;
    public final j0.k.b<? super T, ? extends V> p;

    /* JADX WARN: Multi-variable type inference failed */
    public l0$a(Subscriber<? super Map<K, V>> subscriber, Map<K, V> map, j0.k.b<? super T, ? extends K> bVar, j0.k.b<? super T, ? extends V> bVar2) {
        super(subscriber);
        this.l = map;
        this.k = true;
        this.o = bVar;
        this.p = bVar2;
    }

    @Override // j0.g
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
