package p507d0.p580t;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.o0 */
/* JADX INFO: compiled from: _Sets.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12150o0 extends C12148n0 {
    public static final <T> Set<T> minus(Set<? extends T> set, T t) {
        C12238m.checkNotNullParameter(set, "$this$minus");
        LinkedHashSet linkedHashSet = new LinkedHashSet(C12134g0.mapCapacity(set.size()));
        boolean z2 = false;
        for (T t2 : set) {
            boolean z3 = true;
            if (!z2 && C12238m.areEqual(t2, t)) {
                z2 = true;
                z3 = false;
            }
            if (z3) {
                linkedHashSet.add(t2);
            }
        }
        return linkedHashSet;
    }

    public static final <T> Set<T> plus(Set<? extends T> set, T t) {
        C12238m.checkNotNullParameter(set, "$this$plus");
        LinkedHashSet linkedHashSet = new LinkedHashSet(C12134g0.mapCapacity(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t);
        return linkedHashSet;
    }

    public static final <T> Set<T> minus(Set<? extends T> set, Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(set, "$this$minus");
        C12238m.checkNotNullParameter(iterable, "elements");
        Collection<?> collectionConvertToSetForSetOperationWith = C12149o.convertToSetForSetOperationWith(iterable, set);
        if (collectionConvertToSetForSetOperationWith.isEmpty()) {
            return C12163u.toSet(set);
        }
        if (collectionConvertToSetForSetOperationWith instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t : set) {
                if (!collectionConvertToSetForSetOperationWith.contains(t)) {
                    linkedHashSet.add(t);
                }
            }
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(set);
        linkedHashSet2.removeAll(collectionConvertToSetForSetOperationWith);
        return linkedHashSet2;
    }

    public static final <T> Set<T> plus(Set<? extends T> set, Iterable<? extends T> iterable) {
        int size;
        C12238m.checkNotNullParameter(set, "$this$plus");
        C12238m.checkNotNullParameter(iterable, "elements");
        Integer numCollectionSizeOrNull = C12149o.collectionSizeOrNull(iterable);
        if (numCollectionSizeOrNull != null) {
            size = set.size() + numCollectionSizeOrNull.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(C12134g0.mapCapacity(size));
        linkedHashSet.addAll(set);
        C12160r.addAll(linkedHashSet, iterable);
        return linkedHashSet;
    }
}
