package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ArraySet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ArraySetKt {
    public static final <T> ArraySet<T> arraySetOf() {
        return new ArraySet<>();
    }

    public static final <T> ArraySet<T> arraySetOf(T... tArr) {
        C12238m.checkParameterIsNotNull(tArr, "values");
        ArraySet<T> arraySet = new ArraySet<>(tArr.length);
        for (T t : tArr) {
            arraySet.add(t);
        }
        return arraySet;
    }
}
