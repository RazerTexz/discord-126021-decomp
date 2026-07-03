package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import p507d0.p580t.AbstractC12126c0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SparseIntArray.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SparseIntArrayKt {
    public static final boolean contains(SparseIntArray sparseIntArray, int i) {
        C12238m.checkNotNullParameter(sparseIntArray, "<this>");
        return sparseIntArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsKey(SparseIntArray sparseIntArray, int i) {
        C12238m.checkNotNullParameter(sparseIntArray, "<this>");
        return sparseIntArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsValue(SparseIntArray sparseIntArray, int i) {
        C12238m.checkNotNullParameter(sparseIntArray, "<this>");
        return sparseIntArray.indexOfValue(i) >= 0;
    }

    public static final void forEach(SparseIntArray sparseIntArray, Function2<? super Integer, ? super Integer, Unit> function2) {
        C12238m.checkNotNullParameter(sparseIntArray, "<this>");
        C12238m.checkNotNullParameter(function2, "action");
        int size = sparseIntArray.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            function2.invoke(Integer.valueOf(sparseIntArray.keyAt(i)), Integer.valueOf(sparseIntArray.valueAt(i)));
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final int getOrDefault(SparseIntArray sparseIntArray, int i, int i2) {
        C12238m.checkNotNullParameter(sparseIntArray, "<this>");
        return sparseIntArray.get(i, i2);
    }

    public static final int getOrElse(SparseIntArray sparseIntArray, int i, Function0<Integer> function0) {
        C12238m.checkNotNullParameter(sparseIntArray, "<this>");
        C12238m.checkNotNullParameter(function0, "defaultValue");
        int iIndexOfKey = sparseIntArray.indexOfKey(i);
        return iIndexOfKey >= 0 ? sparseIntArray.valueAt(iIndexOfKey) : function0.invoke().intValue();
    }

    public static final int getSize(SparseIntArray sparseIntArray) {
        C12238m.checkNotNullParameter(sparseIntArray, "<this>");
        return sparseIntArray.size();
    }

    public static final boolean isEmpty(SparseIntArray sparseIntArray) {
        C12238m.checkNotNullParameter(sparseIntArray, "<this>");
        return sparseIntArray.size() == 0;
    }

    public static final boolean isNotEmpty(SparseIntArray sparseIntArray) {
        C12238m.checkNotNullParameter(sparseIntArray, "<this>");
        return sparseIntArray.size() != 0;
    }

    public static final AbstractC12126c0 keyIterator(final SparseIntArray sparseIntArray) {
        C12238m.checkNotNullParameter(sparseIntArray, "<this>");
        return new AbstractC12126c0() { // from class: androidx.core.util.SparseIntArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseIntArray.size();
            }

            @Override // p507d0.p580t.AbstractC12126c0
            public int nextInt() {
                SparseIntArray sparseIntArray2 = sparseIntArray;
                int i = this.index;
                this.index = i + 1;
                return sparseIntArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    public static final SparseIntArray plus(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        C12238m.checkNotNullParameter(sparseIntArray, "<this>");
        C12238m.checkNotNullParameter(sparseIntArray2, "other");
        SparseIntArray sparseIntArray3 = new SparseIntArray(sparseIntArray2.size() + sparseIntArray.size());
        putAll(sparseIntArray3, sparseIntArray);
        putAll(sparseIntArray3, sparseIntArray2);
        return sparseIntArray3;
    }

    public static final void putAll(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        C12238m.checkNotNullParameter(sparseIntArray, "<this>");
        C12238m.checkNotNullParameter(sparseIntArray2, "other");
        int size = sparseIntArray2.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            sparseIntArray.put(sparseIntArray2.keyAt(i), sparseIntArray2.valueAt(i));
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final boolean remove(SparseIntArray sparseIntArray, int i, int i2) {
        C12238m.checkNotNullParameter(sparseIntArray, "<this>");
        int iIndexOfKey = sparseIntArray.indexOfKey(i);
        if (iIndexOfKey < 0 || i2 != sparseIntArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseIntArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final void set(SparseIntArray sparseIntArray, int i, int i2) {
        C12238m.checkNotNullParameter(sparseIntArray, "<this>");
        sparseIntArray.put(i, i2);
    }

    public static final AbstractC12126c0 valueIterator(final SparseIntArray sparseIntArray) {
        C12238m.checkNotNullParameter(sparseIntArray, "<this>");
        return new AbstractC12126c0() { // from class: androidx.core.util.SparseIntArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseIntArray.size();
            }

            @Override // p507d0.p580t.AbstractC12126c0
            public int nextInt() {
                SparseIntArray sparseIntArray2 = sparseIntArray;
                int i = this.index;
                this.index = i + 1;
                return sparseIntArray2.valueAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }
}
