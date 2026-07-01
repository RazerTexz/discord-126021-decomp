package j0.l.a;

import j0.n.Subscribers2;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.v0, reason: use source file name */
/* JADX INFO: compiled from: OperatorDoOnSubscribe.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorDoOnSubscribe<T> implements Observable.b<T, T> {
    public final Action0 j;

    public OperatorDoOnSubscribe(Action0 action0) {
        this.j = action0;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        this.j.call();
        return new Subscribers2(subscriber, subscriber);
    }
}
