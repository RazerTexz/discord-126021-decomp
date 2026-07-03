package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.Map;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p643a.AbstractC12598a;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.functions.Func0;

/* JADX INFO: renamed from: j0.l.a.l0 */
/* JADX INFO: compiled from: OnSubscribeToMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12643l0<T, K, V> implements Observable.InterfaceC13005a<Map<K, V>>, Func0<Map<K, V>> {

    /* JADX INFO: renamed from: j */
    public final Observable<T> f26899j;

    /* JADX INFO: renamed from: k */
    public final InterfaceC12589b<? super T, ? extends K> f26900k;

    /* JADX INFO: renamed from: l */
    public final InterfaceC12589b<? super T, ? extends V> f26901l;

    /* JADX INFO: renamed from: m */
    public final Func0<? extends Map<K, V>> f26902m = this;

    /* JADX INFO: renamed from: j0.l.a.l0$a */
    /* JADX INFO: compiled from: OnSubscribeToMap.java */
    public static final class a<T, K, V> extends AbstractC12602b<T, Map<K, V>> {

        /* JADX INFO: renamed from: o */
        public final InterfaceC12589b<? super T, ? extends K> f26903o;

        /* JADX INFO: renamed from: p */
        public final InterfaceC12589b<? super T, ? extends V> f26904p;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Subscriber<? super Map<K, V>> subscriber, Map<K, V> map, InterfaceC12589b<? super T, ? extends K> interfaceC12589b, InterfaceC12589b<? super T, ? extends V> interfaceC12589b2) {
            super(subscriber);
            this.f26721l = map;
            this.f26720k = true;
            this.f26903o = interfaceC12589b;
            this.f26904p = interfaceC12589b2;
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) {
            if (this.f26737n) {
                return;
            }
            try {
                ((Map) this.f26721l).put(this.f26903o.call(t), this.f26904p.call(t));
            } catch (Throwable th) {
                C3404f.m4325o1(th);
                unsubscribe();
                onError(th);
            }
        }

        @Override // p658rx.Subscriber
        public void onStart() {
            request(RecyclerView.FOREVER_NS);
        }
    }

    public C12643l0(Observable<T> observable, InterfaceC12589b<? super T, ? extends K> interfaceC12589b, InterfaceC12589b<? super T, ? extends V> interfaceC12589b2) {
        this.f26899j = observable;
        this.f26900k = interfaceC12589b;
        this.f26901l = interfaceC12589b2;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        try {
            a aVar = new a(subscriber, this.f26902m.call(), this.f26900k, this.f26901l);
            Observable<T> observable = this.f26899j;
            Subscriber<? super R> subscriber2 = aVar.f26719j;
            subscriber2.add(aVar);
            subscriber2.setProducer(new AbstractC12598a.a(aVar));
            observable.m11107i0(aVar);
        } catch (Throwable th) {
            C3404f.m4325o1(th);
            subscriber.onError(th);
        }
    }

    @Override // p658rx.functions.Func0, java.util.concurrent.Callable
    public Object call() {
        return new HashMap();
    }
}
