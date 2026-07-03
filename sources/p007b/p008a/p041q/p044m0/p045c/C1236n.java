package p007b.p008a.p041q.p044m0.p045c;

import java.util.Comparator;
import p507d0.p582u.C12169a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.m0.c.n */
/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1236n<T> implements Comparator<T> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return C12169a.compareValues(Integer.valueOf(!C12238m.areEqual((String) t, "H264") ? 1 : 0), Integer.valueOf(!C12238m.areEqual((String) t2, "H264") ? 1 : 0));
    }
}
