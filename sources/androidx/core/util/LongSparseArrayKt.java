package androidx.core.util;

import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import p507d0.p580t.AbstractC12128d0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: compiled from: LongSparseArray.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LongSparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.core.util.LongSparseArrayKt$valueIterator$1 */
    /* JADX INFO: compiled from: LongSparseArray.kt */
    public static final class C02631<T> implements Iterator<T>, InterfaceC12228a {
        public final /* synthetic */ LongSparseArray<T> $this_valueIterator;
        private int index;

        public C02631(LongSparseArray<T> longSparseArray) {
            this.$this_valueIterator = longSparseArray;
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
            LongSparseArray<T> longSparseArray = this.$this_valueIterator;
            int i = this.index;
            this.index = i + 1;
            return longSparseArray.valueAt(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    @RequiresApi(16)
    public static final <T> boolean contains(LongSparseArray<T> longSparseArray, long j) {
        C12238m.checkNotNullParameter(longSparseArray, "<this>");
        return longSparseArray.indexOfKey(j) >= 0;
    }

    @RequiresApi(16)
    public static final <T> boolean containsKey(LongSparseArray<T> longSparseArray, long j) {
        C12238m.checkNotNullParameter(longSparseArray, "<this>");
        return longSparseArray.indexOfKey(j) >= 0;
    }

    @RequiresApi(16)
    public static final <T> boolean containsValue(LongSparseArray<T> longSparseArray, T t) {
        C12238m.checkNotNullParameter(longSparseArray, "<this>");
        return longSparseArray.indexOfValue(t) >= 0;
    }

    @RequiresApi(16)
    public static final <T> void forEach(LongSparseArray<T> longSparseArray, Function2<? super Long, ? super T, Unit> function2) {
        C12238m.checkNotNullParameter(longSparseArray, "<this>");
        C12238m.checkNotNullParameter(function2, "action");
        int size = longSparseArray.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            function2.invoke(Long.valueOf(longSparseArray.keyAt(i)), longSparseArray.valueAt(i));
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    @RequiresApi(16)
    public static final <T> T getOrDefault(LongSparseArray<T> longSparseArray, long j, T t) {
        C12238m.checkNotNullParameter(longSparseArray, "<this>");
        T t2 = longSparseArray.get(j);
        return t2 == null ? t : t2;
    }

    @RequiresApi(16)
    public static final <T> T getOrElse(LongSparseArray<T> longSparseArray, long j, Function0<? extends T> function0) {
        C12238m.checkNotNullParameter(longSparseArray, "<this>");
        C12238m.checkNotNullParameter(function0, "defaultValue");
        T t = longSparseArray.get(j);
        return t == null ? function0.invoke() : t;
    }

    @RequiresApi(16)
    public static final <T> int getSize(LongSparseArray<T> longSparseArray) {
        C12238m.checkNotNullParameter(longSparseArray, "<this>");
        return longSparseArray.size();
    }

    @RequiresApi(16)
    public static final <T> boolean isEmpty(LongSparseArray<T> longSparseArray) {
        C12238m.checkNotNullParameter(longSparseArray, "<this>");
        return longSparseArray.size() == 0;
    }

    @RequiresApi(16)
    public static final <T> boolean isNotEmpty(LongSparseArray<T> longSparseArray) {
        C12238m.checkNotNullParameter(longSparseArray, "<this>");
        return longSparseArray.size() != 0;
    }

    @RequiresApi(16)
    public static final <T> AbstractC12128d0 keyIterator(final LongSparseArray<T> longSparseArray) {
        C12238m.checkNotNullParameter(longSparseArray, "<this>");
        return new AbstractC12128d0() { // from class: androidx.core.util.LongSparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < longSparseArray.size();
            }

            @Override // p507d0.p580t.AbstractC12128d0
            public long nextLong() {
                LongSparseArray<T> longSparseArray2 = longSparseArray;
                int i = this.index;
                this.index = i + 1;
                return longSparseArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    @RequiresApi(16)
    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        C12238m.checkNotNullParameter(longSparseArray, "<this>");
        C12238m.checkNotNullParameter(longSparseArray2, "other");
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray2.size() + longSparseArray.size());
        putAll(longSparseArray3, longSparseArray);
        putAll(longSparseArray3, longSparseArray2);
        return longSparseArray3;
    }

    @RequiresApi(16)
    public static final <T> void putAll(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        C12238m.checkNotNullParameter(longSparseArray, "<this>");
        C12238m.checkNotNullParameter(longSparseArray2, "other");
        int size = longSparseArray2.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            longSparseArray.put(longSparseArray2.keyAt(i), longSparseArray2.valueAt(i));
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    @RequiresApi(16)
    public static final <T> boolean remove(LongSparseArray<T> longSparseArray, long j, T t) {
        C12238m.checkNotNullParameter(longSparseArray, "<this>");
        int iIndexOfKey = longSparseArray.indexOfKey(j);
        if (iIndexOfKey < 0 || !C12238m.areEqual(t, longSparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(iIndexOfKey);
        return true;
    }

    @RequiresApi(16)
    public static final <T> void set(LongSparseArray<T> longSparseArray, long j, T t) {
        C12238m.checkNotNullParameter(longSparseArray, "<this>");
        longSparseArray.put(j, t);
    }

    @RequiresApi(16)
    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> longSparseArray) {
        C12238m.checkNotNullParameter(longSparseArray, "<this>");
        return new C02631(longSparseArray);
    }
}
