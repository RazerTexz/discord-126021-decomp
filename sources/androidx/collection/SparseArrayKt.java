package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import d0.t.c0;
import d0.z.d.m;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SparseArray.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SparseArrayKt {
    public static final <T> boolean contains(SparseArrayCompat<T> sparseArrayCompat, int i) {
        m.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        return sparseArrayCompat.containsKey(i);
    }

    public static final <T> void forEach(SparseArrayCompat<T> sparseArrayCompat, Function2<? super Integer, ? super T, Unit> function2) {
        m.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        m.checkParameterIsNotNull(function2, "action");
        int size = sparseArrayCompat.size();
        for (int i = 0; i < size; i++) {
            function2.invoke(Integer.valueOf(sparseArrayCompat.keyAt(i)), sparseArrayCompat.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(SparseArrayCompat<T> sparseArrayCompat, int i, T t) {
        m.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        return sparseArrayCompat.get(i, t);
    }

    public static final <T> T getOrElse(SparseArrayCompat<T> sparseArrayCompat, int i, Function0<? extends T> function0) {
        m.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        m.checkParameterIsNotNull(function0, "defaultValue");
        T t = sparseArrayCompat.get(i);
        return t != null ? t : function0.invoke();
    }

    public static final <T> int getSize(SparseArrayCompat<T> sparseArrayCompat) {
        m.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        return sparseArrayCompat.size();
    }

    public static final <T> boolean isNotEmpty(SparseArrayCompat<T> sparseArrayCompat) {
        m.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        return !sparseArrayCompat.isEmpty();
    }

    public static final <T> c0 keyIterator(SparseArrayCompat<T> sparseArrayCompat) {
        m.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        return new SparseArrayKt$keyIterator$1(sparseArrayCompat);
    }

    public static final <T> SparseArrayCompat<T> plus(SparseArrayCompat<T> sparseArrayCompat, SparseArrayCompat<T> sparseArrayCompat2) {
        m.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        m.checkParameterIsNotNull(sparseArrayCompat2, "other");
        SparseArrayCompat<T> sparseArrayCompat3 = new SparseArrayCompat<>(sparseArrayCompat2.size() + sparseArrayCompat.size());
        sparseArrayCompat3.putAll(sparseArrayCompat);
        sparseArrayCompat3.putAll(sparseArrayCompat2);
        return sparseArrayCompat3;
    }

    public static final <T> boolean remove(SparseArrayCompat<T> sparseArrayCompat, int i, T t) {
        m.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        return sparseArrayCompat.remove(i, t);
    }

    public static final <T> void set(SparseArrayCompat<T> sparseArrayCompat, int i, T t) {
        m.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        sparseArrayCompat.put(i, t);
    }

    public static final <T> Iterator<T> valueIterator(SparseArrayCompat<T> sparseArrayCompat) {
        m.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        return new SparseArrayKt$valueIterator$1(sparseArrayCompat);
    }
}
