package j0.l.a;

import java.util.List;
import rx.Observable;
import rx.Observable$a;
import rx.Subscriber;
import rx.functions.FuncN;

/* JADX INFO: compiled from: OnSubscribeCombineLatest.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f<T, R> implements Observable$a<R> {
    public final Iterable<? extends Observable<? extends T>> j;
    public final FuncN<? extends R> k;
    public final int l;

    public f(Iterable<? extends Observable<? extends T>> iterable, FuncN<? extends R> funcN) {
        int i = j0.l.e.i.j;
        this.j = iterable;
        this.k = funcN;
        this.l = i;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Observable[] observableArr;
        int length;
        Subscriber subscriber = (Subscriber) obj;
        Iterable<? extends Observable<? extends T>> iterable = this.j;
        if (iterable instanceof List) {
            List list = (List) iterable;
            observableArr = (Observable[]) list.toArray(new Observable[list.size()]);
            length = observableArr.length;
        } else {
            Observable[] observableArr2 = new Observable[8];
            int i = 0;
            for (Observable<? extends T> observable : iterable) {
                if (i == observableArr2.length) {
                    Observable[] observableArr3 = new Observable[(i >> 2) + i];
                    System.arraycopy(observableArr2, 0, observableArr3, 0, i);
                    observableArr2 = observableArr3;
                }
                observableArr2[i] = observable;
                i++;
            }
            observableArr = observableArr2;
            length = i;
        }
        if (length == 0) {
            subscriber.onCompleted();
            return;
        }
        f$b f_b = new f$b(subscriber, this.k, length, this.l, false);
        f$a<T, R>[] f_aArr = f_b.subscribers;
        int length2 = f_aArr.length;
        for (int i2 = 0; i2 < length2; i2++) {
            f_aArr[i2] = new f$a<>(f_b, i2);
        }
        f_b.lazySet(0);
        f_b.actual.add(f_b);
        f_b.actual.setProducer(f_b);
        for (int i3 = 0; i3 < length2 && !f_b.cancelled; i3++) {
            observableArr[i3].U(f_aArr[i3]);
        }
    }
}
