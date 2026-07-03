package p507d0.p580t;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.n0 */
/* JADX INFO: compiled from: Sets.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12148n0 extends C12146m0 {
    public static final <T> Set<T> emptySet() {
        return C12167y.f25223j;
    }

    public static final <T> HashSet<T> hashSetOf(T... tArr) {
        C12238m.checkNotNullParameter(tArr, "elements");
        return (HashSet) C12141k.toCollection(tArr, new HashSet(C12134g0.mapCapacity(tArr.length)));
    }

    public static final <T> LinkedHashSet<T> linkedSetOf(T... tArr) {
        C12238m.checkNotNullParameter(tArr, "elements");
        return (LinkedHashSet) C12141k.toCollection(tArr, new LinkedHashSet(C12134g0.mapCapacity(tArr.length)));
    }

    public static final <T> Set<T> mutableSetOf(T... tArr) {
        C12238m.checkNotNullParameter(tArr, "elements");
        return (Set) C12141k.toCollection(tArr, new LinkedHashSet(C12134g0.mapCapacity(tArr.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> optimizeReadOnlySet(Set<? extends T> set) {
        C12238m.checkNotNullParameter(set, "$this$optimizeReadOnlySet");
        int size = set.size();
        if (size != 0) {
            return size != 1 ? set : C12146m0.setOf(set.iterator().next());
        }
        return emptySet();
    }

    public static final <T> Set<T> setOf(T... tArr) {
        C12238m.checkNotNullParameter(tArr, "elements");
        return tArr.length > 0 ? C12141k.toSet(tArr) : emptySet();
    }
}
