package j0.l.a;

import rx.Observable$b;
import rx.Subscriber;
import rx.functions.Func2;

/* JADX INFO: compiled from: OperatorSkipWhile.java */
/* JADX INFO: loaded from: classes3.dex */
public final class w1<T> implements Observable$b<T, T> {
    public final Func2<? super T, Integer, Boolean> j;

    public w1(Func2<? super T, Integer, Boolean> func2) {
        this.j = func2;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        return new u1(this, subscriber, subscriber);
    }
}
