package j0.l.a;

import b.d.b.a.outline;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.c2, reason: use source file name */
/* JADX INFO: compiled from: OperatorTake.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorTake2<T> implements Observable.b<T, T> {
    public final int j;

    public OperatorTake2(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(outline.q("limit >= 0 required but it was ", i));
        }
        this.j = i;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        OperatorTake operatorTake = new OperatorTake(this, subscriber);
        if (this.j == 0) {
            subscriber.onCompleted();
            operatorTake.unsubscribe();
        }
        subscriber.add(operatorTake);
        return operatorTake;
    }
}
