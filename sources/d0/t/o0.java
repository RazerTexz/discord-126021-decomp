package d0.t;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: _Sets.kt */
/* JADX INFO: loaded from: classes3.dex */
public class o0 extends n0 {
    public static final <T> Set<T> minus(Set<? extends T> set, T t) {
        d0.z.d.m.checkNotNullParameter(set, "$this$minus");
        LinkedHashSet linkedHashSet = new LinkedHashSet(g0.mapCapacity(set.size()));
        boolean z2 = false;
        for (T t2 : set) {
            boolean z3 = true;
            if (!z2 && d0.z.d.m.areEqual(t2, t)) {
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
        d0.z.d.m.checkNotNullParameter(set, "$this$plus");
        LinkedHashSet linkedHashSet = new LinkedHashSet(g0.mapCapacity(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t);
        return linkedHashSet;
    }

    public static final <T> Set<T> minus(Set<? extends T> set, Iterable<? extends T> iterable) {
        d0.z.d.m.checkNotNullParameter(set, "$this$minus");
        d0.z.d.m.checkNotNullParameter(iterable, "elements");
        Collection<?> collectionConvertToSetForSetOperationWith = o.convertToSetForSetOperationWith(iterable, set);
        if (collectionConvertToSetForSetOperationWith.isEmpty()) {
            return u.toSet(set);
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
        d0.z.d.m.checkNotNullParameter(set, "$this$plus");
        d0.z.d.m.checkNotNullParameter(iterable, "elements");
        Integer numCollectionSizeOrNull = o.collectionSizeOrNull(iterable);
        if (numCollectionSizeOrNull != null) {
            size = set.size() + numCollectionSizeOrNull.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(g0.mapCapacity(size));
        linkedHashSet.addAll(set);
        r.addAll(linkedHashSet, iterable);
        return linkedHashSet;
    }
}
