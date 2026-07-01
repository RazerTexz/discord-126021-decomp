package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: androidx.collection.ArraySetKt, reason: use source file name */
/* JADX INFO: compiled from: ArraySet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ArraySet2 {
    public static final <T> ArraySet<T> arraySetOf() {
        return new ArraySet<>();
    }

    public static final <T> ArraySet<T> arraySetOf(T... tArr) {
        Intrinsics3.checkParameterIsNotNull(tArr, "values");
        ArraySet<T> arraySet = new ArraySet<>(tArr.length);
        for (T t : tArr) {
            arraySet.add(t);
        }
        return arraySet;
    }
}
