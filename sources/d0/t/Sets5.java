package d0.t;

import d0.z.d.Intrinsics3;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: renamed from: d0.t.n0, reason: use source file name */
/* JADX INFO: compiled from: Sets.kt */
/* JADX INFO: loaded from: classes3.dex */
public class Sets5 extends SetsJVM {
    public static final <T> Set<T> emptySet() {
        return Sets6.j;
    }

    public static final <T> HashSet<T> hashSetOf(T... tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "elements");
        return (HashSet) _Arrays.toCollection(tArr, new HashSet(MapsJVM.mapCapacity(tArr.length)));
    }

    public static final <T> LinkedHashSet<T> linkedSetOf(T... tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "elements");
        return (LinkedHashSet) _Arrays.toCollection(tArr, new LinkedHashSet(MapsJVM.mapCapacity(tArr.length)));
    }

    public static final <T> Set<T> mutableSetOf(T... tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "elements");
        return (Set) _Arrays.toCollection(tArr, new LinkedHashSet(MapsJVM.mapCapacity(tArr.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> optimizeReadOnlySet(Set<? extends T> set) {
        Intrinsics3.checkNotNullParameter(set, "$this$optimizeReadOnlySet");
        int size = set.size();
        if (size != 0) {
            return size != 1 ? set : SetsJVM.setOf(set.iterator().next());
        }
        return emptySet();
    }

    public static final <T> Set<T> setOf(T... tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "elements");
        return tArr.length > 0 ? _Arrays.toSet(tArr) : emptySet();
    }
}
