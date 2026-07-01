package d0.t;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: Sets.kt */
/* JADX INFO: loaded from: classes3.dex */
public class n0 extends m0 {
    public static final <T> Set<T> emptySet() {
        return y.j;
    }

    public static final <T> HashSet<T> hashSetOf(T... tArr) {
        d0.z.d.m.checkNotNullParameter(tArr, "elements");
        return (HashSet) k.toCollection(tArr, new HashSet(g0.mapCapacity(tArr.length)));
    }

    public static final <T> LinkedHashSet<T> linkedSetOf(T... tArr) {
        d0.z.d.m.checkNotNullParameter(tArr, "elements");
        return (LinkedHashSet) k.toCollection(tArr, new LinkedHashSet(g0.mapCapacity(tArr.length)));
    }

    public static final <T> Set<T> mutableSetOf(T... tArr) {
        d0.z.d.m.checkNotNullParameter(tArr, "elements");
        return (Set) k.toCollection(tArr, new LinkedHashSet(g0.mapCapacity(tArr.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> optimizeReadOnlySet(Set<? extends T> set) {
        d0.z.d.m.checkNotNullParameter(set, "$this$optimizeReadOnlySet");
        int size = set.size();
        if (size != 0) {
            return size != 1 ? set : m0.setOf(set.iterator().next());
        }
        return emptySet();
    }

    public static final <T> Set<T> setOf(T... tArr) {
        d0.z.d.m.checkNotNullParameter(tArr, "elements");
        return tArr.length > 0 ? k.toSet(tArr) : emptySet();
    }
}
