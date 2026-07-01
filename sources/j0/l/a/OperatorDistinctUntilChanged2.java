package j0.l.a;

import j0.k.Func1;
import j0.l.e.UtilityFunctions;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;

/* JADX INFO: renamed from: j0.l.a.u0, reason: use source file name */
/* JADX INFO: compiled from: OperatorDistinctUntilChanged.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorDistinctUntilChanged2<T, U> implements Observable.b<T, T>, Func2<U, U, Boolean> {
    public final Func1<? super T, ? extends U> j;
    public final Func2<? super U, ? super U, Boolean> k;

    /* JADX INFO: renamed from: j0.l.a.u0$a */
    /* JADX INFO: compiled from: OperatorDistinctUntilChanged.java */
    public static final class a {
        public static final OperatorDistinctUntilChanged2<?, ?> a = new OperatorDistinctUntilChanged2<>(UtilityFunctions.a.INSTANCE);
    }

    public OperatorDistinctUntilChanged2(Func1<? super T, ? extends U> func1) {
        this.j = func1;
        this.k = this;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        return new OperatorDistinctUntilChanged(this, subscriber, subscriber);
    }

    @Override // rx.functions.Func2
    public Boolean call(Object obj, Object obj2) {
        return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
    }

    public OperatorDistinctUntilChanged2(Func2<? super U, ? super U, Boolean> func2) {
        this.j = UtilityFunctions.a.INSTANCE;
        this.k = func2;
    }
}
