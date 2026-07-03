package androidx.core.util;

import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import p507d0.p580t.AbstractC12126c0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: compiled from: SparseArray.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.core.util.SparseArrayKt$valueIterator$1 */
    /* JADX INFO: compiled from: SparseArray.kt */
    public static final class C02701<T> implements Iterator<T>, InterfaceC12228a {
        public final /* synthetic */ SparseArray<T> $this_valueIterator;
        private int index;

        public C02701(SparseArray<T> sparseArray) {
            this.$this_valueIterator = sparseArray;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // java.util.Iterator
        public T next() {
            SparseArray<T> sparseArray = this.$this_valueIterator;
            int i = this.index;
            this.index = i + 1;
            return sparseArray.valueAt(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    public static final <T> boolean contains(SparseArray<T> sparseArray, int i) {
        C12238m.checkNotNullParameter(sparseArray, "<this>");
        return sparseArray.indexOfKey(i) >= 0;
    }

    public static final <T> boolean containsKey(SparseArray<T> sparseArray, int i) {
        C12238m.checkNotNullParameter(sparseArray, "<this>");
        return sparseArray.indexOfKey(i) >= 0;
    }

    public static final <T> boolean containsValue(SparseArray<T> sparseArray, T t) {
        C12238m.checkNotNullParameter(sparseArray, "<this>");
        return sparseArray.indexOfValue(t) >= 0;
    }

    public static final <T> void forEach(SparseArray<T> sparseArray, Function2<? super Integer, ? super T, Unit> function2) {
        C12238m.checkNotNullParameter(sparseArray, "<this>");
        C12238m.checkNotNullParameter(function2, "action");
        int size = sparseArray.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            function2.invoke(Integer.valueOf(sparseArray.keyAt(i)), sparseArray.valueAt(i));
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final <T> T getOrDefault(SparseArray<T> sparseArray, int i, T t) {
        C12238m.checkNotNullParameter(sparseArray, "<this>");
        T t2 = sparseArray.get(i);
        return t2 == null ? t : t2;
    }

    public static final <T> T getOrElse(SparseArray<T> sparseArray, int i, Function0<? extends T> function0) {
        C12238m.checkNotNullParameter(sparseArray, "<this>");
        C12238m.checkNotNullParameter(function0, "defaultValue");
        T t = sparseArray.get(i);
        return t == null ? function0.invoke() : t;
    }

    public static final <T> int getSize(SparseArray<T> sparseArray) {
        C12238m.checkNotNullParameter(sparseArray, "<this>");
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(SparseArray<T> sparseArray) {
        C12238m.checkNotNullParameter(sparseArray, "<this>");
        return sparseArray.size() == 0;
    }

    public static final <T> boolean isNotEmpty(SparseArray<T> sparseArray) {
        C12238m.checkNotNullParameter(sparseArray, "<this>");
        return sparseArray.size() != 0;
    }

    public static final <T> AbstractC12126c0 keyIterator(final SparseArray<T> sparseArray) {
        C12238m.checkNotNullParameter(sparseArray, "<this>");
        return new AbstractC12126c0() { // from class: androidx.core.util.SparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArray.size();
            }

            @Override // p507d0.p580t.AbstractC12126c0
            public int nextInt() {
                SparseArray<T> sparseArray2 = sparseArray;
                int i = this.index;
                this.index = i + 1;
                return sparseArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    public static final <T> SparseArray<T> plus(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        C12238m.checkNotNullParameter(sparseArray, "<this>");
        C12238m.checkNotNullParameter(sparseArray2, "other");
        SparseArray<T> sparseArray3 = new SparseArray<>(sparseArray2.size() + sparseArray.size());
        putAll(sparseArray3, sparseArray);
        putAll(sparseArray3, sparseArray2);
        return sparseArray3;
    }

    public static final <T> void putAll(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        C12238m.checkNotNullParameter(sparseArray, "<this>");
        C12238m.checkNotNullParameter(sparseArray2, "other");
        int size = sparseArray2.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            sparseArray.put(sparseArray2.keyAt(i), sparseArray2.valueAt(i));
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final <T> boolean remove(SparseArray<T> sparseArray, int i, T t) {
        C12238m.checkNotNullParameter(sparseArray, "<this>");
        int iIndexOfKey = sparseArray.indexOfKey(i);
        if (iIndexOfKey < 0 || !C12238m.areEqual(t, sparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        sparseArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final <T> void set(SparseArray<T> sparseArray, int i, T t) {
        C12238m.checkNotNullParameter(sparseArray, "<this>");
        sparseArray.put(i, t);
    }

    public static final <T> Iterator<T> valueIterator(SparseArray<T> sparseArray) {
        C12238m.checkNotNullParameter(sparseArray, "<this>");
        return new C02701(sparseArray);
    }
}
