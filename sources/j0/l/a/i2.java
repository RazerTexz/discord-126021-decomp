package j0.l.a;

import rx.Observable$b;
import rx.Subscriber;
import rx.functions.Func2;

/* JADX INFO: compiled from: OperatorTakeWhile.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i2<T> implements Observable$b<T, T> {
    public final Func2<? super T, ? super Integer, Boolean> j;

    public i2(j0.k.b<? super T, Boolean> bVar) {
        this.j = new i2$a(bVar);
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        j2 j2Var = new j2(this, subscriber, false, subscriber);
        subscriber.add(j2Var);
        return j2Var;
    }
}
