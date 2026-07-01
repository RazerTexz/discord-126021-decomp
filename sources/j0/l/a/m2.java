package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: OperatorToObservableList.java */
/* JADX INFO: loaded from: classes3.dex */
public class m2<T> extends Subscriber<T> {
    public boolean j;
    public List<T> k = new LinkedList();
    public final /* synthetic */ j0.l.b.b l;
    public final /* synthetic */ Subscriber m;

    public m2(n2 n2Var, j0.l.b.b bVar, Subscriber subscriber) {
        this.l = bVar;
        this.m = subscriber;
    }

    @Override // j0.g
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

    @Override // j0.g
    public void onError(Throwable th) {
        this.m.onError(th);
    }

    @Override // j0.g
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
