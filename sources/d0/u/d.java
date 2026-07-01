package d0.u;

import d0.z.d.Intrinsics3;
import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements Comparator<Comparable<? super Object>> {
    public static final d j = new d();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Comparable<? super Object> comparable, Comparable<? super Object> comparable2) {
        return compare2((Comparable<Object>) comparable, (Comparable<Object>) comparable2);
    }

    @Override // java.util.Comparator
    public final Comparator<Comparable<? super Object>> reversed() {
        return c.j;
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(Comparable<Object> comparable, Comparable<Object> comparable2) {
        Intrinsics3.checkNotNullParameter(comparable, "a");
        Intrinsics3.checkNotNullParameter(comparable2, "b");
        return comparable2.compareTo(comparable);
    }
}
