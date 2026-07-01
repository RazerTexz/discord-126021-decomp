package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import j0.l.b.SingleDelayedProducer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.p2, reason: use source file name */
/* JADX INFO: compiled from: OperatorToObservableSortedList.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorToObservableSortedList2<T> extends Subscriber<T> {
    public List<T> j = new ArrayList(10);
    public boolean k;
    public final /* synthetic */ SingleDelayedProducer l;
    public final /* synthetic */ Subscriber m;
    public final /* synthetic */ OperatorToObservableSortedList n;

    public OperatorToObservableSortedList2(OperatorToObservableSortedList operatorToObservableSortedList, SingleDelayedProducer singleDelayedProducer, Subscriber subscriber) {
        this.n = operatorToObservableSortedList;
        this.l = singleDelayedProducer;
        this.m = subscriber;
    }

    @Override // j0.Observer2
    public void onCompleted() {
        if (this.k) {
            return;
        }
        this.k = true;
        List<T> list = this.j;
        this.j = null;
        try {
            Collections.sort(list, this.n.j);
            this.l.b(list);
        } catch (Throwable th) {
            b.i.a.f.e.o.f.o1(th);
            onError(th);
        }
    }

    @Override // j0.Observer2
    public void onError(Throwable th) {
        this.m.onError(th);
    }

    @Override // j0.Observer2
    public void onNext(T t) {
        if (this.k) {
            return;
        }
        this.j.add(t);
    }

    @Override // rx.Subscriber
    public void onStart() {
        request(RecyclerView.FOREVER_NS);
    }
}
