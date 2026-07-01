package d0.t;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes3.dex */
public class n extends m {
    public static final <T> ArrayList<T> arrayListOf(T... tArr) {
        d0.z.d.m.checkNotNullParameter(tArr, "elements");
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new g(tArr, true));
    }

    public static final <T> Collection<T> asCollection(T[] tArr) {
        d0.z.d.m.checkNotNullParameter(tArr, "$this$asCollection");
        return new g(tArr, false);
    }

    public static final <T extends Comparable<? super T>> int binarySearch(List<? extends T> list, T t, int i, int i2) {
        d0.z.d.m.checkNotNullParameter(list, "$this$binarySearch");
        int size = list.size();
        if (i > i2) {
            throw new IllegalArgumentException("fromIndex (" + i + ") is greater than toIndex (" + i2 + ").");
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(b.d.b.a.a.r("fromIndex (", i, ") is less than zero."));
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
        return w.j;
    }

    public static final IntRange getIndices(Collection<?> collection) {
        d0.z.d.m.checkNotNullParameter(collection, "$this$indices");
        return new IntRange(0, collection.size() - 1);
    }

    public static final <T> int getLastIndex(List<? extends T> list) {
        d0.z.d.m.checkNotNullParameter(list, "$this$lastIndex");
        return list.size() - 1;
    }

    public static final <T> List<T> listOf(T... tArr) {
        d0.z.d.m.checkNotNullParameter(tArr, "elements");
        return tArr.length > 0 ? j.asList(tArr) : emptyList();
    }

    public static final <T> List<T> listOfNotNull(T t) {
        return t != null ? m.listOf(t) : emptyList();
    }

    public static final <T> List<T> mutableListOf(T... tArr) {
        d0.z.d.m.checkNotNullParameter(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new g(tArr, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> list) {
        d0.z.d.m.checkNotNullParameter(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : m.listOf(list.get(0));
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
        d0.z.d.m.checkNotNullParameter(tArr, "elements");
        return k.filterNotNull(tArr);
    }
}
