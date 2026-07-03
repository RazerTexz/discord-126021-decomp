package p507d0.p580t;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.ranges.IntRange;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p582u.C12169a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.n */
/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12147n extends C12145m {
    public static final <T> ArrayList<T> arrayListOf(T... tArr) {
        C12238m.checkNotNullParameter(tArr, "elements");
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new C12133g(tArr, true));
    }

    public static final <T> Collection<T> asCollection(T[] tArr) {
        C12238m.checkNotNullParameter(tArr, "$this$asCollection");
        return new C12133g(tArr, false);
    }

    public static final <T extends Comparable<? super T>> int binarySearch(List<? extends T> list, T t, int i, int i2) {
        C12238m.checkNotNullParameter(list, "$this$binarySearch");
        int size = list.size();
        if (i > i2) {
            throw new IllegalArgumentException("fromIndex (" + i + ") is greater than toIndex (" + i2 + ").");
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(C1643a.m873r("fromIndex (", i, ") is less than zero."));
        }
        if (i2 > size) {
            throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is greater than size (" + size + ").");
        }
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int iCompareValues = C12169a.compareValues(list.get(i4), t);
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
        return C12165w.f25221j;
    }

    public static final IntRange getIndices(Collection<?> collection) {
        C12238m.checkNotNullParameter(collection, "$this$indices");
        return new IntRange(0, collection.size() - 1);
    }

    public static final <T> int getLastIndex(List<? extends T> list) {
        C12238m.checkNotNullParameter(list, "$this$lastIndex");
        return list.size() - 1;
    }

    public static final <T> List<T> listOf(T... tArr) {
        C12238m.checkNotNullParameter(tArr, "elements");
        return tArr.length > 0 ? C12139j.asList(tArr) : emptyList();
    }

    public static final <T> List<T> listOfNotNull(T t) {
        return t != null ? C12145m.listOf(t) : emptyList();
    }

    public static final <T> List<T> mutableListOf(T... tArr) {
        C12238m.checkNotNullParameter(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new C12133g(tArr, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> list) {
        C12238m.checkNotNullParameter(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : C12145m.listOf(list.get(0));
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
        C12238m.checkNotNullParameter(tArr, "elements");
        return C12141k.filterNotNull(tArr);
    }
}
