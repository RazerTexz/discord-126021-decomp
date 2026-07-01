package j0.l.a;

import rx.Observable;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

/* JADX INFO: renamed from: j0.l.a.f2, reason: use source file name */
/* JADX INFO: compiled from: OperatorTakeUntil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorTakeUntil3<T, E> implements Observable.b<T, T> {
    public final Observable<? extends E> j;

    public OperatorTakeUntil3(Observable<? extends E> observable) {
        this.j = observable;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber, false);
        OperatorTakeUntil operatorTakeUntil = new OperatorTakeUntil(this, serializedSubscriber, false, serializedSubscriber);
        OperatorTakeUntil2 operatorTakeUntil2 = new OperatorTakeUntil2(this, operatorTakeUntil);
        serializedSubscriber.add(operatorTakeUntil);
        serializedSubscriber.add(operatorTakeUntil2);
        subscriber.add(serializedSubscriber);
        this.j.i0(operatorTakeUntil2);
        return operatorTakeUntil;
    }
}
