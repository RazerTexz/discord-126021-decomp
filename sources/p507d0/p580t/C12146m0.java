package p507d0.p580t;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.m0 */
/* JADX INFO: compiled from: SetsJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12146m0 {
    public static final <T> Set<T> setOf(T t) {
        Set<T> setSingleton = Collections.singleton(t);
        C12238m.checkNotNullExpressionValue(setSingleton, "java.util.Collections.singleton(element)");
        return setSingleton;
    }

    public static final <T> TreeSet<T> sortedSetOf(Comparator<? super T> comparator, T... tArr) {
        C12238m.checkNotNullParameter(comparator, "comparator");
        C12238m.checkNotNullParameter(tArr, "elements");
        return (TreeSet) C12141k.toCollection(tArr, new TreeSet(comparator));
    }
}
