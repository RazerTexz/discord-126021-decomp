package androidx.core.util;

import androidx.annotation.RequiresApi;
import d0.t.Iterators4;
import d0.t.Iterators5;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: androidx.core.util.SparseLongArrayKt, reason: use source file name */
/* JADX INFO: compiled from: SparseLongArray.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SparseLongArray {
    @RequiresApi(18)
    public static final boolean contains(android.util.SparseLongArray sparseLongArray, int i) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.indexOfKey(i) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsKey(android.util.SparseLongArray sparseLongArray, int i) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.indexOfKey(i) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsValue(android.util.SparseLongArray sparseLongArray, long j) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.indexOfValue(j) >= 0;
    }

    @RequiresApi(18)
    public static final void forEach(android.util.SparseLongArray sparseLongArray, Function2<? super Integer, ? super Long, Unit> function2) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        Intrinsics3.checkNotNullParameter(function2, "action");
        int size = sparseLongArray.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            function2.invoke(Integer.valueOf(sparseLongArray.keyAt(i)), Long.valueOf(sparseLongArray.valueAt(i)));
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    @RequiresApi(18)
    public static final long getOrDefault(android.util.SparseLongArray sparseLongArray, int i, long j) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.get(i, j);
    }

    @RequiresApi(18)
    public static final long getOrElse(android.util.SparseLongArray sparseLongArray, int i, Function0<Long> function0) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        Intrinsics3.checkNotNullParameter(function0, "defaultValue");
        int iIndexOfKey = sparseLongArray.indexOfKey(i);
        return iIndexOfKey >= 0 ? sparseLongArray.valueAt(iIndexOfKey) : function0.invoke().longValue();
    }

    @RequiresApi(18)
    public static final int getSize(android.util.SparseLongArray sparseLongArray) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.size();
    }

    @RequiresApi(18)
    public static final boolean isEmpty(android.util.SparseLongArray sparseLongArray) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.size() == 0;
    }

    @RequiresApi(18)
    public static final boolean isNotEmpty(android.util.SparseLongArray sparseLongArray) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.size() != 0;
    }

    @RequiresApi(18)
    public static final Iterators4 keyIterator(final android.util.SparseLongArray sparseLongArray) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        return new Iterators4() { // from class: androidx.core.util.SparseLongArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // d0.t.Iterators4
            public int nextInt() {
                android.util.SparseLongArray sparseLongArray2 = sparseLongArray;
                int i = this.index;
                this.index = i + 1;
                return sparseLongArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    @RequiresApi(18)
    public static final android.util.SparseLongArray plus(android.util.SparseLongArray sparseLongArray, android.util.SparseLongArray sparseLongArray2) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        Intrinsics3.checkNotNullParameter(sparseLongArray2, "other");
        android.util.SparseLongArray sparseLongArray3 = new android.util.SparseLongArray(sparseLongArray2.size() + sparseLongArray.size());
        putAll(sparseLongArray3, sparseLongArray);
        putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    @RequiresApi(18)
    public static final void putAll(android.util.SparseLongArray sparseLongArray, android.util.SparseLongArray sparseLongArray2) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        Intrinsics3.checkNotNullParameter(sparseLongArray2, "other");
        int size = sparseLongArray2.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            sparseLongArray.put(sparseLongArray2.keyAt(i), sparseLongArray2.valueAt(i));
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    @RequiresApi(18)
    public static final boolean remove(android.util.SparseLongArray sparseLongArray, int i, long j) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        int iIndexOfKey = sparseLongArray.indexOfKey(i);
        if (iIndexOfKey < 0 || j != sparseLongArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(iIndexOfKey);
        return true;
    }

    @RequiresApi(18)
    public static final void set(android.util.SparseLongArray sparseLongArray, int i, long j) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        sparseLongArray.put(i, j);
    }

    @RequiresApi(18)
    public static final Iterators5 valueIterator(final android.util.SparseLongArray sparseLongArray) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        return new Iterators5() { // from class: androidx.core.util.SparseLongArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // d0.t.Iterators5
            public long nextLong() {
                android.util.SparseLongArray sparseLongArray2 = sparseLongArray;
                int i = this.index;
                this.index = i + 1;
                return sparseLongArray2.valueAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }
}
