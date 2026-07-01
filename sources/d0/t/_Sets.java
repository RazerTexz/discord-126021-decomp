package d0.t;

import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: renamed from: d0.t.o0, reason: use source file name */
/* JADX INFO: compiled from: _Sets.kt */
/* JADX INFO: loaded from: classes3.dex */
public class _Sets extends Sets5 {
    public static final <T> Set<T> minus(Set<? extends T> set, T t) {
        Intrinsics3.checkNotNullParameter(set, "$this$minus");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsJVM.mapCapacity(set.size()));
        boolean z2 = false;
        for (T t2 : set) {
            boolean z3 = true;
            if (!z2 && Intrinsics3.areEqual(t2, t)) {
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
        Intrinsics3.checkNotNullParameter(set, "$this$plus");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsJVM.mapCapacity(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t);
        return linkedHashSet;
    }

    public static final <T> Set<T> minus(Set<? extends T> set, Iterable<? extends T> iterable) {
        Intrinsics3.checkNotNullParameter(set, "$this$minus");
        Intrinsics3.checkNotNullParameter(iterable, "elements");
        Collection<?> collectionConvertToSetForSetOperationWith = Iterables2.convertToSetForSetOperationWith(iterable, set);
        if (collectionConvertToSetForSetOperationWith.isEmpty()) {
            return _Collections.toSet(set);
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
        Intrinsics3.checkNotNullParameter(set, "$this$plus");
        Intrinsics3.checkNotNullParameter(iterable, "elements");
        Integer numCollectionSizeOrNull = Iterables2.collectionSizeOrNull(iterable);
        if (numCollectionSizeOrNull != null) {
            size = set.size() + numCollectionSizeOrNull.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsJVM.mapCapacity(size));
        linkedHashSet.addAll(set);
        MutableCollections.addAll(linkedHashSet, iterable);
        return linkedHashSet;
    }
}
