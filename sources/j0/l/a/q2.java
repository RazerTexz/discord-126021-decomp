package j0.l.a;

import rx.Observable;
import rx.Observable$b;
import rx.Subscriber;
import rx.functions.Func2;
import rx.functions.FuncN;

/* JADX INFO: compiled from: OperatorZip.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q2<R> implements Observable$b<R, Observable<?>[]> {
    public final FuncN<? extends R> j;

    public q2(Func2 func2) {
        this.j = new j0.k.d(func2);
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        q2$a q2_a = new q2$a(subscriber, this.j);
        q2$b q2_b = new q2$b(q2_a);
        q2$c q2_c = new q2$c(this, subscriber, q2_a, q2_b);
        subscriber.add(q2_c);
        subscriber.setProducer(q2_b);
        return q2_c;
    }
}
