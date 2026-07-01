package j0.l.a;

import j0.k.Func1;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;

/* JADX INFO: renamed from: j0.l.a.i2, reason: use source file name */
/* JADX INFO: compiled from: OperatorTakeWhile.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorTakeWhile<T> implements Observable.b<T, T> {
    public final Func2<? super T, ? super Integer, Boolean> j;

    /* JADX INFO: renamed from: j0.l.a.i2$a */
    /* JADX INFO: compiled from: OperatorTakeWhile.java */
    public class a implements Func2<T, Integer, Boolean> {
        public final /* synthetic */ Func1 j;

        public a(Func1 func1) {
            this.j = func1;
        }

        @Override // rx.functions.Func2
        public Boolean call(Object obj, Integer num) {
            return (Boolean) this.j.call(obj);
        }
    }

    public OperatorTakeWhile(Func1<? super T, Boolean> func1) {
        this.j = new a(func1);
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        OperatorTakeWhile2 operatorTakeWhile2 = new OperatorTakeWhile2(this, subscriber, false, subscriber);
        subscriber.add(operatorTakeWhile2);
        return operatorTakeWhile2;
    }
}
