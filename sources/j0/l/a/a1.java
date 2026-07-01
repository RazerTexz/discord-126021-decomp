package j0.l.a;

import j0.a$b;
import rx.Observable$b;
import rx.Subscriber;

/* JADX INFO: compiled from: OperatorOnBackpressureBuffer.java */
/* JADX INFO: loaded from: classes3.dex */
public class a1<T> implements Observable$b<T, T> {
    public final a$b j;

    public a1() {
        int i = j0.a.a;
        this.j = j0.a$a.a;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        a1$a a1_a = new a1$a(subscriber, null, null, this.j);
        subscriber.add(a1_a);
        subscriber.setProducer(a1_a.n);
        return a1_a;
    }
}
