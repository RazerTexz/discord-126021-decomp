package b.a.q.m0.c;

import d0.z.d.Intrinsics3;
import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes.dex */
public final class n<T> implements Comparator<T> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return d0.u.a.compareValues(Integer.valueOf(!Intrinsics3.areEqual((String) t, "H264") ? 1 : 0), Integer.valueOf(!Intrinsics3.areEqual((String) t2, "H264") ? 1 : 0));
    }
}
