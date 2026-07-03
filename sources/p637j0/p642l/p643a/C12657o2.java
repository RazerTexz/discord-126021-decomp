package p637j0.p642l.p643a;

import java.util.Comparator;
import java.util.List;
import p637j0.p642l.p644b.C12694b;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: j0.l.a.o2 */
/* JADX INFO: compiled from: OperatorToObservableSortedList.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12657o2<T> implements Observable.InterfaceC13006b<List<T>, T> {

    /* JADX INFO: renamed from: j */
    public final Comparator<? super T> f26970j;

    /* JADX INFO: renamed from: j0.l.a.o2$a */
    /* JADX INFO: compiled from: OperatorToObservableSortedList.java */
    public class a implements Comparator<T> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Func2 f26971j;

        public a(C12657o2 c12657o2, Func2 func2) {
            this.f26971j = func2;
        }

        @Override // java.util.Comparator
        public int compare(T t, T t2) {
            return ((Integer) this.f26971j.call(t, t2)).intValue();
        }
    }

    public C12657o2(Func2<? super T, ? super T, Integer> func2, int i) {
        this.f26970j = new a(this, func2);
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        C12694b c12694b = new C12694b(subscriber);
        C12661p2 c12661p2 = new C12661p2(this, c12694b, subscriber);
        subscriber.add(c12661p2);
        subscriber.setProducer(c12694b);
        return c12661p2;
    }
}
