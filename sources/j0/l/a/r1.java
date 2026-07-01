package j0.l.a;

import rx.Observable$b;
import rx.Subscriber;

/* JADX INFO: compiled from: OperatorSingle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r1<T> implements Observable$b<T, T> {
    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        r1$b r1_b = new r1$b(subscriber, false, null);
        subscriber.add(r1_b);
        return r1_b;
    }
}
