package j0.l.a;

import rx.Observable;
import rx.Observable$b;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

/* JADX INFO: compiled from: OperatorTakeUntil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f2<T, E> implements Observable$b<T, T> {
    public final Observable<? extends E> j;

    public f2(Observable<? extends E> observable) {
        this.j = observable;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber, false);
        d2 d2Var = new d2(this, serializedSubscriber, false, serializedSubscriber);
        e2 e2Var = new e2(this, d2Var);
        serializedSubscriber.add(d2Var);
        serializedSubscriber.add(e2Var);
        subscriber.add(serializedSubscriber);
        this.j.i0(e2Var);
        return d2Var;
    }
}
