package j0.l.a;

import rx.Observable;
import rx.Observable$b;
import rx.Subscriber;

/* JADX INFO: compiled from: OperatorSwitch.java */
/* JADX INFO: loaded from: classes3.dex */
public final class y1<T> implements Observable$b<T, Observable<? extends T>> {
    public final boolean j;

    public y1(boolean z2) {
        this.j = z2;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        y1$c y1_c = new y1$c(subscriber, this.j);
        subscriber.add(y1_c);
        y1_c.k.add(y1_c.l);
        y1_c.k.add(new j0.r.a(new z1(y1_c)));
        y1_c.k.setProducer(new a2(y1_c));
        return y1_c;
    }
}
