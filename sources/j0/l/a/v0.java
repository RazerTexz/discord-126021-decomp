package j0.l.a;

import rx.Observable$b;
import rx.Subscriber;
import rx.functions.Action0;

/* JADX INFO: compiled from: OperatorDoOnSubscribe.java */
/* JADX INFO: loaded from: classes3.dex */
public class v0<T> implements Observable$b<T, T> {
    public final Action0 j;

    public v0(Action0 action0) {
        this.j = action0;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        this.j.call();
        return new j0.n.e(subscriber, subscriber);
    }
}
