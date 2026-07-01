package j0.l.a;

import rx.Observable$b;
import rx.Subscriber;

/* JADX INFO: compiled from: OperatorOnBackpressureLatest.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b1<T> implements Observable$b<T, T> {
    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        b1$b b1_b = new b1$b(subscriber);
        b1$c<? super T> b1_c = new b1$c<>(b1_b);
        b1_b.parent = b1_c;
        subscriber.add(b1_c);
        subscriber.add(b1_b);
        subscriber.setProducer(b1_b);
        return b1_c;
    }
}
