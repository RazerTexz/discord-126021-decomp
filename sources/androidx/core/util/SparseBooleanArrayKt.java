package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import p507d0.p580t.AbstractC12126c0;
import p507d0.p580t.AbstractC12143l;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SparseBooleanArray.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SparseBooleanArrayKt {
    public static final boolean contains(SparseBooleanArray sparseBooleanArray, int i) {
        C12238m.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsKey(SparseBooleanArray sparseBooleanArray, int i) {
        C12238m.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsValue(SparseBooleanArray sparseBooleanArray, boolean z2) {
        C12238m.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfValue(z2) >= 0;
    }

    public static final void forEach(SparseBooleanArray sparseBooleanArray, Function2<? super Integer, ? super Boolean, Unit> function2) {
        C12238m.checkNotNullParameter(sparseBooleanArray, "<this>");
        C12238m.checkNotNullParameter(function2, "action");
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

    public static final boolean getOrDefault(SparseBooleanArray sparseBooleanArray, int i, boolean z2) {
        C12238m.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.get(i, z2);
    }

    public static final boolean getOrElse(SparseBooleanArray sparseBooleanArray, int i, Function0<Boolean> function0) {
        C12238m.checkNotNullParameter(sparseBooleanArray, "<this>");
        C12238m.checkNotNullParameter(function0, "defaultValue");
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i);
        return iIndexOfKey >= 0 ? sparseBooleanArray.valueAt(iIndexOfKey) : function0.invoke().booleanValue();
    }

    public static final int getSize(SparseBooleanArray sparseBooleanArray) {
        C12238m.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size();
    }

    public static final boolean isEmpty(SparseBooleanArray sparseBooleanArray) {
        C12238m.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size() == 0;
    }

    public static final boolean isNotEmpty(SparseBooleanArray sparseBooleanArray) {
        C12238m.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size() != 0;
    }

    public static final AbstractC12126c0 keyIterator(final SparseBooleanArray sparseBooleanArray) {
        C12238m.checkNotNullParameter(sparseBooleanArray, "<this>");
        return new AbstractC12126c0() { // from class: androidx.core.util.SparseBooleanArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // p507d0.p580t.AbstractC12126c0
            public int nextInt() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i = this.index;
                this.index = i + 1;
                return sparseBooleanArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    public static final SparseBooleanArray plus(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        C12238m.checkNotNullParameter(sparseBooleanArray, "<this>");
        C12238m.checkNotNullParameter(sparseBooleanArray2, "other");
        SparseBooleanArray sparseBooleanArray3 = new SparseBooleanArray(sparseBooleanArray2.size() + sparseBooleanArray.size());
        putAll(sparseBooleanArray3, sparseBooleanArray);
        putAll(sparseBooleanArray3, sparseBooleanArray2);
        return sparseBooleanArray3;
    }

    public static final void putAll(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        C12238m.checkNotNullParameter(sparseBooleanArray, "<this>");
        C12238m.checkNotNullParameter(sparseBooleanArray2, "other");
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

    public static final boolean remove(SparseBooleanArray sparseBooleanArray, int i, boolean z2) {
        C12238m.checkNotNullParameter(sparseBooleanArray, "<this>");
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i);
        if (iIndexOfKey < 0 || z2 != sparseBooleanArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i);
        return true;
    }

    public static final void set(SparseBooleanArray sparseBooleanArray, int i, boolean z2) {
        C12238m.checkNotNullParameter(sparseBooleanArray, "<this>");
        sparseBooleanArray.put(i, z2);
    }

    public static final AbstractC12143l valueIterator(final SparseBooleanArray sparseBooleanArray) {
        C12238m.checkNotNullParameter(sparseBooleanArray, "<this>");
        return new AbstractC12143l() { // from class: androidx.core.util.SparseBooleanArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // p507d0.p580t.AbstractC12143l
            public boolean nextBoolean() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
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
