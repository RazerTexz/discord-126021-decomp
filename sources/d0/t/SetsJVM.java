package d0.t;

import d0.z.d.Intrinsics3;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: renamed from: d0.t.m0, reason: use source file name */
/* JADX INFO: compiled from: SetsJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class SetsJVM {
    public static final <T> Set<T> setOf(T t) {
        Set<T> setSingleton = Collections.singleton(t);
        Intrinsics3.checkNotNullExpressionValue(setSingleton, "java.util.Collections.singleton(element)");
        return setSingleton;
    }

    public static final <T> TreeSet<T> sortedSetOf(Comparator<? super T> comparator, T... tArr) {
        Intrinsics3.checkNotNullParameter(comparator, "comparator");
        Intrinsics3.checkNotNullParameter(tArr, "elements");
        return (TreeSet) _Arrays.toCollection(tArr, new TreeSet(comparator));
    }
}
