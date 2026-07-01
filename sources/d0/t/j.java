package d0.t;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: _ArraysJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public class j extends i {
    public static final <T> List<T> asList(T[] tArr) {
        d0.z.d.m.checkNotNullParameter(tArr, "$this$asList");
        List<T> listAsList = Arrays.asList(tArr);
        d0.z.d.m.checkNotNullExpressionValue(listAsList, "ArraysUtilJVM.asList(this)");
        return listAsList;
    }

    public static final <T> T[] copyInto(T[] tArr, T[] tArr2, int i, int i2, int i3) {
        d0.z.d.m.checkNotNullParameter(tArr, "$this$copyInto");
        d0.z.d.m.checkNotNullParameter(tArr2, "destination");
        System.arraycopy(tArr, i2, tArr2, i, i3 - i2);
        return tArr2;
    }

    public static /* synthetic */ Object[] copyInto$default(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return copyInto(objArr, objArr2, i, i2, i3);
    }

    public static final <T> T[] copyOfRange(T[] tArr, int i, int i2) {
        d0.z.d.m.checkNotNullParameter(tArr, "$this$copyOfRangeImpl");
        h.copyOfRangeToIndexCheck(i2, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i, i2);
        d0.z.d.m.checkNotNullExpressionValue(tArr2, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return tArr2;
    }

    public static final <T> void fill(T[] tArr, T t, int i, int i2) {
        d0.z.d.m.checkNotNullParameter(tArr, "$this$fill");
        Arrays.fill(tArr, i, i2, t);
    }

    public static /* synthetic */ void fill$default(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        fill(objArr, obj, i, i2);
    }

    public static final <T> T[] plus(T[] tArr, Collection<? extends T> collection) {
        d0.z.d.m.checkNotNullParameter(tArr, "$this$plus");
        d0.z.d.m.checkNotNullParameter(collection, "elements");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, collection.size() + length);
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            tArr2[length] = it.next();
            length++;
        }
        d0.z.d.m.checkNotNullExpressionValue(tArr2, "result");
        return tArr2;
    }

    public static final <T> void sort(T[] tArr) {
        d0.z.d.m.checkNotNullParameter(tArr, "$this$sort");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static final <T> void sortWith(T[] tArr, Comparator<? super T> comparator) {
        d0.z.d.m.checkNotNullParameter(tArr, "$this$sortWith");
        d0.z.d.m.checkNotNullParameter(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static final byte[] copyInto(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        d0.z.d.m.checkNotNullParameter(bArr, "$this$copyInto");
        d0.z.d.m.checkNotNullParameter(bArr2, "destination");
        System.arraycopy(bArr, i2, bArr2, i, i3 - i2);
        return bArr2;
    }

    public static /* synthetic */ byte[] copyInto$default(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length;
        }
        return copyInto(bArr, bArr2, i, i2, i3);
    }

    public static final void fill(int[] iArr, int i, int i2, int i3) {
        d0.z.d.m.checkNotNullParameter(iArr, "$this$fill");
        Arrays.fill(iArr, i2, i3, i);
    }

    public static final List<Integer> asList(int[] iArr) {
        d0.z.d.m.checkNotNullParameter(iArr, "$this$asList");
        return new j$a(iArr);
    }

    public static final byte[] copyOfRange(byte[] bArr, int i, int i2) {
        d0.z.d.m.checkNotNullParameter(bArr, "$this$copyOfRangeImpl");
        h.copyOfRangeToIndexCheck(i2, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i2);
        d0.z.d.m.checkNotNullExpressionValue(bArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return bArrCopyOfRange;
    }

    public static final <T> T[] plus(T[] tArr, T[] tArr2) {
        d0.z.d.m.checkNotNullParameter(tArr, "$this$plus");
        d0.z.d.m.checkNotNullParameter(tArr2, "elements");
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] tArr3 = (T[]) Arrays.copyOf(tArr, length + length2);
        System.arraycopy(tArr2, 0, tArr3, length, length2);
        d0.z.d.m.checkNotNullExpressionValue(tArr3, "result");
        return tArr3;
    }
}
