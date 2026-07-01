package j0.l.a;

import j0.l.b.SingleDelayedProducer;
import java.util.Comparator;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;

/* JADX INFO: renamed from: j0.l.a.o2, reason: use source file name */
/* JADX INFO: compiled from: OperatorToObservableSortedList.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorToObservableSortedList<T> implements Observable.b<List<T>, T> {
    public final Comparator<? super T> j;

    /* JADX INFO: renamed from: j0.l.a.o2$a */
    /* JADX INFO: compiled from: OperatorToObservableSortedList.java */
    public class a implements Comparator<T> {
        public final /* synthetic */ Func2 j;

        public a(OperatorToObservableSortedList operatorToObservableSortedList, Func2 func2) {
            this.j = func2;
        }

        @Override // java.util.Comparator
        public int compare(T t, T t2) {
            return ((Integer) this.j.call(t, t2)).intValue();
        }
    }

    public OperatorToObservableSortedList(Func2<? super T, ? super T, Integer> func2, int i) {
        this.j = new a(this, func2);
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        OperatorToObservableSortedList2 operatorToObservableSortedList2 = new OperatorToObservableSortedList2(this, singleDelayedProducer, subscriber);
        subscriber.add(operatorToObservableSortedList2);
        subscriber.setProducer(singleDelayedProducer);
        return operatorToObservableSortedList2;
    }
}
