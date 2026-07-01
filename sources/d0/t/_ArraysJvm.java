package d0.t;

import d0.z.d.Intrinsics3;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: renamed from: d0.t.j, reason: use source file name */
/* JADX INFO: compiled from: _ArraysJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public class _ArraysJvm extends Arrays {

    /* JADX INFO: renamed from: d0.t.j$a */
    /* JADX INFO: compiled from: _ArraysJvm.kt */
    public static final class a extends AbstractList<Integer> implements RandomAccess {
        public final /* synthetic */ int[] k;

        public a(int[] iArr) {
            this.k = iArr;
        }

        @Override // d0.t.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Integer) {
                return contains(((Number) obj).intValue());
            }
            return false;
        }

        @Override // d0.t.AbstractCollection
        public int getSize() {
            return this.k.length;
        }

        @Override // d0.t.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return indexOf(((Number) obj).intValue());
            }
            return -1;
        }

        @Override // d0.t.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.k.length == 0;
        }

        @Override // d0.t.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return lastIndexOf(((Number) obj).intValue());
            }
            return -1;
        }

        public boolean contains(int i) {
            return _Arrays.contains(this.k, i);
        }

        @Override // d0.t.AbstractList, java.util.List
        public Integer get(int i) {
            return Integer.valueOf(this.k[i]);
        }

        public int indexOf(int i) {
            return _Arrays.indexOf(this.k, i);
        }

        public int lastIndexOf(int i) {
            return _Arrays.lastIndexOf(this.k, i);
        }
    }

    public static final <T> List<T> asList(T[] tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$asList");
        List<T> listAsList = Arrays.asList(tArr);
        Intrinsics3.checkNotNullExpressionValue(listAsList, "ArraysUtilJVM.asList(this)");
        return listAsList;
    }

    public static final <T> T[] copyInto(T[] tArr, T[] tArr2, int i, int i2, int i3) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$copyInto");
        Intrinsics3.checkNotNullParameter(tArr2, "destination");
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
        Intrinsics3.checkNotNullParameter(tArr, "$this$copyOfRangeImpl");
        ArraysJVM.copyOfRangeToIndexCheck(i2, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i, i2);
        Intrinsics3.checkNotNullExpressionValue(tArr2, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return tArr2;
    }

    public static final <T> void fill(T[] tArr, T t, int i, int i2) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$fill");
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
        Intrinsics3.checkNotNullParameter(tArr, "$this$plus");
        Intrinsics3.checkNotNullParameter(collection, "elements");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, collection.size() + length);
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            tArr2[length] = it.next();
            length++;
        }
        Intrinsics3.checkNotNullExpressionValue(tArr2, "result");
        return tArr2;
    }

    public static final <T> void sort(T[] tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$sort");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static final <T> void sortWith(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$sortWith");
        Intrinsics3.checkNotNullParameter(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static final byte[] copyInto(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        Intrinsics3.checkNotNullParameter(bArr, "$this$copyInto");
        Intrinsics3.checkNotNullParameter(bArr2, "destination");
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
        Intrinsics3.checkNotNullParameter(iArr, "$this$fill");
        Arrays.fill(iArr, i2, i3, i);
    }

    public static final List<Integer> asList(int[] iArr) {
        Intrinsics3.checkNotNullParameter(iArr, "$this$asList");
        return new a(iArr);
    }

    public static final byte[] copyOfRange(byte[] bArr, int i, int i2) {
        Intrinsics3.checkNotNullParameter(bArr, "$this$copyOfRangeImpl");
        ArraysJVM.copyOfRangeToIndexCheck(i2, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i2);
        Intrinsics3.checkNotNullExpressionValue(bArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return bArrCopyOfRange;
    }

    public static final <T> T[] plus(T[] tArr, T[] tArr2) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$plus");
        Intrinsics3.checkNotNullParameter(tArr2, "elements");
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] tArr3 = (T[]) Arrays.copyOf(tArr, length + length2);
        System.arraycopy(tArr2, 0, tArr3, length, length2);
        Intrinsics3.checkNotNullExpressionValue(tArr3, "result");
        return tArr3;
    }
}
