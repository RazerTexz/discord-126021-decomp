package j0.l.a;

import java.util.Comparator;
import rx.functions.Func2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: OperatorToObservableSortedList.java */
/* JADX INFO: loaded from: classes3.dex */
public class o2$a<T> implements Comparator<T> {
    public final /* synthetic */ Func2 j;

    public o2$a(o2 o2Var, Func2 func2) {
        this.j = func2;
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        return ((Integer) this.j.call(t, t2)).intValue();
    }
}
