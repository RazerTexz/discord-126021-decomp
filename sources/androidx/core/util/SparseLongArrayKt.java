package androidx.core.util;

import android.util.SparseLongArray;
import androidx.annotation.RequiresApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import p507d0.p580t.AbstractC12126c0;
import p507d0.p580t.AbstractC12128d0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SparseLongArray.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SparseLongArrayKt {
    @RequiresApi(18)
    public static final boolean contains(SparseLongArray sparseLongArray, int i) {
        C12238m.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.indexOfKey(i) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsKey(SparseLongArray sparseLongArray, int i) {
        C12238m.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.indexOfKey(i) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsValue(SparseLongArray sparseLongArray, long j) {
        C12238m.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.indexOfValue(j) >= 0;
    }

    @RequiresApi(18)
    public static final void forEach(SparseLongArray sparseLongArray, Function2<? super Integer, ? super Long, Unit> function2) {
        C12238m.checkNotNullParameter(sparseLongArray, "<this>");
        C12238m.checkNotNullParameter(function2, "action");
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
    public static final long getOrDefault(SparseLongArray sparseLongArray, int i, long j) {
        C12238m.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.get(i, j);
    }

    @RequiresApi(18)
    public static final long getOrElse(SparseLongArray sparseLongArray, int i, Function0<Long> function0) {
        C12238m.checkNotNullParameter(sparseLongArray, "<this>");
        C12238m.checkNotNullParameter(function0, "defaultValue");
        int iIndexOfKey = sparseLongArray.indexOfKey(i);
        return iIndexOfKey >= 0 ? sparseLongArray.valueAt(iIndexOfKey) : function0.invoke().longValue();
    }

    @RequiresApi(18)
    public static final int getSize(SparseLongArray sparseLongArray) {
        C12238m.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.size();
    }

    @RequiresApi(18)
    public static final boolean isEmpty(SparseLongArray sparseLongArray) {
        C12238m.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.size() == 0;
    }

    @RequiresApi(18)
    public static final boolean isNotEmpty(SparseLongArray sparseLongArray) {
        C12238m.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.size() != 0;
    }

    @RequiresApi(18)
    public static final AbstractC12126c0 keyIterator(final SparseLongArray sparseLongArray) {
        C12238m.checkNotNullParameter(sparseLongArray, "<this>");
        return new AbstractC12126c0() { // from class: androidx.core.util.SparseLongArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // p507d0.p580t.AbstractC12126c0
            public int nextInt() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
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
    public static final SparseLongArray plus(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        C12238m.checkNotNullParameter(sparseLongArray, "<this>");
        C12238m.checkNotNullParameter(sparseLongArray2, "other");
        SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray2.size() + sparseLongArray.size());
        putAll(sparseLongArray3, sparseLongArray);
        putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    @RequiresApi(18)
    public static final void putAll(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        C12238m.checkNotNullParameter(sparseLongArray, "<this>");
        C12238m.checkNotNullParameter(sparseLongArray2, "other");
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
    public static final boolean remove(SparseLongArray sparseLongArray, int i, long j) {
        C12238m.checkNotNullParameter(sparseLongArray, "<this>");
        int iIndexOfKey = sparseLongArray.indexOfKey(i);
        if (iIndexOfKey < 0 || j != sparseLongArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(iIndexOfKey);
        return true;
    }

    @RequiresApi(18)
    public static final void set(SparseLongArray sparseLongArray, int i, long j) {
        C12238m.checkNotNullParameter(sparseLongArray, "<this>");
        sparseLongArray.put(i, j);
    }

    @RequiresApi(18)
    public static final AbstractC12128d0 valueIterator(final SparseLongArray sparseLongArray) {
        C12238m.checkNotNullParameter(sparseLongArray, "<this>");
        return new AbstractC12128d0() { // from class: androidx.core.util.SparseLongArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // p507d0.p580t.AbstractC12128d0
            public long nextLong() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
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
