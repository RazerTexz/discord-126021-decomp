package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import j0.l.b.SingleDelayedProducer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.m2, reason: use source file name */
/* JADX INFO: compiled from: OperatorToObservableList.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorToObservableList<T> extends Subscriber<T> {
    public boolean j;
    public List<T> k = new LinkedList();
    public final /* synthetic */ SingleDelayedProducer l;
    public final /* synthetic */ Subscriber m;

    public OperatorToObservableList(OperatorToObservableList2 operatorToObservableList2, SingleDelayedProducer singleDelayedProducer, Subscriber subscriber) {
        this.l = singleDelayedProducer;
        this.m = subscriber;
    }

    @Override // j0.Observer2
    public void onCompleted() {
        if (this.j) {
            return;
        }
        this.j = true;
        try {
            ArrayList arrayList = new ArrayList(this.k);
            this.k = null;
            this.l.b(arrayList);
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
        if (this.j) {
            return;
        }
        this.k.add(t);
    }

    @Override // rx.Subscriber
    public void onStart() {
        request(RecyclerView.FOREVER_NS);
    }
}
