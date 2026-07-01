package d0.t;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: compiled from: SetsJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class m0 {
    public static final <T> Set<T> setOf(T t) {
        Set<T> setSingleton = Collections.singleton(t);
        d0.z.d.m.checkNotNullExpressionValue(setSingleton, "java.util.Collections.singleton(element)");
        return setSingleton;
    }

    public static final <T> TreeSet<T> sortedSetOf(Comparator<? super T> comparator, T... tArr) {
        d0.z.d.m.checkNotNullParameter(comparator, "comparator");
        d0.z.d.m.checkNotNullParameter(tArr, "elements");
        return (TreeSet) k.toCollection(tArr, new TreeSet(comparator));
    }
}
