package d0.e0.p.d;

import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f$b$a<T> implements Comparator<T> {
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return d0.u.a.compareValues(((d0.e0.f) t).getName(), ((d0.e0.f) t2).getName());
    }
}
