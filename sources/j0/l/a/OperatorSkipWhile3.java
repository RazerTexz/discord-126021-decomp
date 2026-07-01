package j0.l.a;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;

/* JADX INFO: renamed from: j0.l.a.w1, reason: use source file name */
/* JADX INFO: compiled from: OperatorSkipWhile.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorSkipWhile3<T> implements Observable.b<T, T> {
    public final Func2<? super T, Integer, Boolean> j;

    public OperatorSkipWhile3(Func2<? super T, Integer, Boolean> func2) {
        this.j = func2;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        return new OperatorSkipWhile(this, subscriber, subscriber);
    }
}
