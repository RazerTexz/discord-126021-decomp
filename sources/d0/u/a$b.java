package d0.u;

import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$b<T> implements Comparator {
    public final /* synthetic */ Comparator j;
    public final /* synthetic */ Comparator k;

    public a$b(Comparator comparator, Comparator comparator2) {
        this.j = comparator;
        this.k = comparator2;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int iCompare = this.j.compare(t, t2);
        return iCompare != 0 ? iCompare : this.k.compare(t, t2);
    }
}
