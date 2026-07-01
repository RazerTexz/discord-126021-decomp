package d0.t;

import d0.z.d.Intrinsics3;
import d0.z.d.TypeIntrinsics;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: renamed from: d0.t.r, reason: use source file name */
/* JADX INFO: compiled from: MutableCollections.kt */
/* JADX INFO: loaded from: classes3.dex */
public class MutableCollections extends MutableCollectionsJVM {
    public static final <T> boolean a(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1, boolean z2) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            if (function1.invoke(it.next()).booleanValue() == z2) {
                it.remove();
                z3 = true;
            }
        }
        return z3;
    }

    public static final <T> boolean addAll(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics3.checkNotNullParameter(collection, "$this$addAll");
        Intrinsics3.checkNotNullParameter(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z2 = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z2 = true;
            }
        }
        return z2;
    }

    public static final <T> boolean removeAll(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics3.checkNotNullParameter(collection, "$this$removeAll");
        Intrinsics3.checkNotNullParameter(iterable, "elements");
        return TypeIntrinsics.asMutableCollection(collection).removeAll(Iterables2.convertToSetForSetOperationWith(iterable, collection));
    }

    public static final <T> T removeFirst(List<T> list) {
        Intrinsics3.checkNotNullParameter(list, "$this$removeFirst");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(0);
    }

    public static final <T> boolean retainAll(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics3.checkNotNullParameter(collection, "$this$retainAll");
        Intrinsics3.checkNotNullParameter(iterable, "elements");
        return TypeIntrinsics.asMutableCollection(collection).retainAll(Iterables2.convertToSetForSetOperationWith(iterable, collection));
    }

    public static final <T> boolean removeAll(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(iterable, "$this$removeAll");
        Intrinsics3.checkNotNullParameter(function1, "predicate");
        return a(iterable, function1, true);
    }

    public static final <T> boolean removeAll(List<T> list, Function1<? super T, Boolean> function1) {
        int i;
        Intrinsics3.checkNotNullParameter(list, "$this$removeAll");
        Intrinsics3.checkNotNullParameter(function1, "predicate");
        if (!(list instanceof RandomAccess)) {
            Objects.requireNonNull(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T>");
            return a(TypeIntrinsics.asMutableIterable(list), function1, true);
        }
        int lastIndex = Collections2.getLastIndex(list);
        if (lastIndex >= 0) {
            int i2 = 0;
            i = 0;
            while (true) {
                T t = list.get(i2);
                if (!function1.invoke(t).booleanValue()) {
                    if (i != i2) {
                        list.set(i, t);
                    }
                    i++;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i >= list.size()) {
            return false;
        }
        int lastIndex2 = Collections2.getLastIndex(list);
        if (lastIndex2 >= i) {
            while (true) {
                list.remove(lastIndex2);
                if (lastIndex2 == i) {
                    break;
                }
                lastIndex2--;
            }
        }
        return true;
    }

    public static final <T> boolean addAll(Collection<? super T> collection, Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(collection, "$this$addAll");
        Intrinsics3.checkNotNullParameter(sequence, "elements");
        Iterator<? extends T> it = sequence.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z2 = true;
            }
        }
        return z2;
    }

    public static final <T> boolean addAll(Collection<? super T> collection, T[] tArr) {
        Intrinsics3.checkNotNullParameter(collection, "$this$addAll");
        Intrinsics3.checkNotNullParameter(tArr, "elements");
        return collection.addAll(_ArraysJvm.asList(tArr));
    }
}
