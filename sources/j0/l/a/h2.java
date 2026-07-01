package j0.l.a;

import rx.Observable$b;
import rx.Subscriber;

/* JADX INFO: compiled from: OperatorTakeUntilPredicate.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h2<T> implements Observable$b<T, T> {
    public final j0.k.b<? super T, Boolean> j;

    public h2(j0.k.b<? super T, Boolean> bVar) {
        this.j = bVar;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        h2$a h2_a = new h2$a(this, subscriber);
        subscriber.add(h2_a);
        subscriber.setProducer(new g2(this, h2_a));
        return h2_a;
    }
}
