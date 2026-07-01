package androidx.core.util;

import d0.t.Iterators4;
import d0.t.Iterators6;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: androidx.core.util.SparseBooleanArrayKt, reason: use source file name */
/* JADX INFO: compiled from: SparseBooleanArray.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SparseBooleanArray {
    public static final boolean contains(android.util.SparseBooleanArray sparseBooleanArray, int i) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsKey(android.util.SparseBooleanArray sparseBooleanArray, int i) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsValue(android.util.SparseBooleanArray sparseBooleanArray, boolean z2) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfValue(z2) >= 0;
    }

    public static final void forEach(android.util.SparseBooleanArray sparseBooleanArray, Function2<? super Integer, ? super Boolean, Unit> function2) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        Intrinsics3.checkNotNullParameter(function2, "action");
        int size = sparseBooleanArray.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            function2.invoke(Integer.valueOf(sparseBooleanArray.keyAt(i)), Boolean.valueOf(sparseBooleanArray.valueAt(i)));
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final boolean getOrDefault(android.util.SparseBooleanArray sparseBooleanArray, int i, boolean z2) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.get(i, z2);
    }

    public static final boolean getOrElse(android.util.SparseBooleanArray sparseBooleanArray, int i, Function0<Boolean> function0) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        Intrinsics3.checkNotNullParameter(function0, "defaultValue");
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i);
        return iIndexOfKey >= 0 ? sparseBooleanArray.valueAt(iIndexOfKey) : function0.invoke().booleanValue();
    }

    public static final int getSize(android.util.SparseBooleanArray sparseBooleanArray) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size();
    }

    public static final boolean isEmpty(android.util.SparseBooleanArray sparseBooleanArray) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size() == 0;
    }

    public static final boolean isNotEmpty(android.util.SparseBooleanArray sparseBooleanArray) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size() != 0;
    }

    public static final Iterators4 keyIterator(final android.util.SparseBooleanArray sparseBooleanArray) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        return new Iterators4() { // from class: androidx.core.util.SparseBooleanArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // d0.t.Iterators4
            public int nextInt() {
                android.util.SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i = this.index;
                this.index = i + 1;
                return sparseBooleanArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    public static final android.util.SparseBooleanArray plus(android.util.SparseBooleanArray sparseBooleanArray, android.util.SparseBooleanArray sparseBooleanArray2) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        Intrinsics3.checkNotNullParameter(sparseBooleanArray2, "other");
        android.util.SparseBooleanArray sparseBooleanArray3 = new android.util.SparseBooleanArray(sparseBooleanArray2.size() + sparseBooleanArray.size());
        putAll(sparseBooleanArray3, sparseBooleanArray);
        putAll(sparseBooleanArray3, sparseBooleanArray2);
        return sparseBooleanArray3;
    }

    public static final void putAll(android.util.SparseBooleanArray sparseBooleanArray, android.util.SparseBooleanArray sparseBooleanArray2) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        Intrinsics3.checkNotNullParameter(sparseBooleanArray2, "other");
        int size = sparseBooleanArray2.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            sparseBooleanArray.put(sparseBooleanArray2.keyAt(i), sparseBooleanArray2.valueAt(i));
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final boolean remove(android.util.SparseBooleanArray sparseBooleanArray, int i, boolean z2) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i);
        if (iIndexOfKey < 0 || z2 != sparseBooleanArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i);
        return true;
    }

    public static final void set(android.util.SparseBooleanArray sparseBooleanArray, int i, boolean z2) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        sparseBooleanArray.put(i, z2);
    }

    public static final Iterators6 valueIterator(final android.util.SparseBooleanArray sparseBooleanArray) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        return new Iterators6() { // from class: androidx.core.util.SparseBooleanArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // d0.t.Iterators6
            public boolean nextBoolean() {
                android.util.SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i = this.index;
                this.index = i + 1;
                return sparseBooleanArray2.valueAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }
}
