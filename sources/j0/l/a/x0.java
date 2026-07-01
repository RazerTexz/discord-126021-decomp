package j0.l.a;

import rx.Observable;
import rx.Observable$b;
import rx.Subscriber;

/* JADX INFO: compiled from: OperatorMerge.java */
/* JADX INFO: loaded from: classes3.dex */
public final class x0<T> implements Observable$b<T, Observable<? extends T>> {
    public final boolean j;

    public x0(boolean z2, int i) {
        this.j = z2;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        x0$e x0_e = new x0$e(subscriber, this.j, Integer.MAX_VALUE);
        x0$d<T> x0_d = new x0$d<>(x0_e);
        x0_e.n = x0_d;
        subscriber.add(x0_e);
        subscriber.setProducer(x0_d);
        return x0_e;
    }
}
