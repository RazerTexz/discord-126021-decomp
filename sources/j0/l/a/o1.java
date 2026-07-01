package j0.l.a;

import rx.Observable$b;
import rx.Subscriber;
import rx.functions.Func0;
import rx.functions.Func2;

/* JADX INFO: compiled from: OperatorScan.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o1<R, T> implements Observable$b<R, T> {
    public static final Object j = new Object();
    public final Func0<R> k;
    public final Func2<R, ? super T, R> l;

    public o1(R r, Func2<R, ? super T, R> func2) {
        this.k = new o1$a(r);
        this.l = func2;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        R rCall = this.k.call();
        if (rCall == j) {
            return new p1(this, subscriber, subscriber);
        }
        o1$b o1_b = new o1$b(rCall, subscriber);
        q1 q1Var = new q1(this, rCall, o1_b);
        subscriber.add(q1Var);
        subscriber.setProducer(o1_b);
        return q1Var;
    }
}
