package d0.t;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.ranges.Ranges2;

/* JADX INFO: renamed from: d0.t.n, reason: use source file name */
/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes3.dex */
public class Collections2 extends CollectionsJVM {
    public static final <T> ArrayList<T> arrayListOf(T... tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "elements");
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new Collections(tArr, true));
    }

    public static final <T> Collection<T> asCollection(T[] tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$asCollection");
        return new Collections(tArr, false);
    }

    public static final <T extends Comparable<? super T>> int binarySearch(List<? extends T> list, T t, int i, int i2) {
        Intrinsics3.checkNotNullParameter(list, "$this$binarySearch");
        int size = list.size();
        if (i > i2) {
            throw new IllegalArgumentException("fromIndex (" + i + ") is greater than toIndex (" + i2 + ").");
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(outline.r("fromIndex (", i, ") is less than zero."));
        }
        if (i2 > size) {
            throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is greater than size (" + size + ").");
        }
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int iCompareValues = d0.u.a.compareValues(list.get(i4), t);
            if (iCompareValues < 0) {
                i = i4 + 1;
            } else {
                if (iCompareValues <= 0) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static /* synthetic */ int binarySearch$default(List list, Comparable comparable, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        return binarySearch(list, comparable, i, i2);
    }

    public static final <T> List<T> emptyList() {
        return Collections4.j;
    }

    public static final Ranges2 getIndices(Collection<?> collection) {
        Intrinsics3.checkNotNullParameter(collection, "$this$indices");
        return new Ranges2(0, collection.size() - 1);
    }

    public static final <T> int getLastIndex(List<? extends T> list) {
        Intrinsics3.checkNotNullParameter(list, "$this$lastIndex");
        return list.size() - 1;
    }

    public static final <T> List<T> listOf(T... tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "elements");
        return tArr.length > 0 ? _ArraysJvm.asList(tArr) : emptyList();
    }

    public static final <T> List<T> listOfNotNull(T t) {
        return t != null ? CollectionsJVM.listOf(t) : emptyList();
    }

    public static final <T> List<T> mutableListOf(T... tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new Collections(tArr, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> list) {
        Intrinsics3.checkNotNullParameter(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : CollectionsJVM.listOf(list.get(0));
        }
        return emptyList();
    }

    public static final void throwCountOverflow() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static final void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static final <T> List<T> listOfNotNull(T... tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "elements");
        return _Arrays.filterNotNull(tArr);
    }
}
