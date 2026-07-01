package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Intrinsics3;
import kotlin.Tuples2;

/* JADX INFO: renamed from: androidx.collection.ArrayMapKt, reason: use source file name */
/* JADX INFO: compiled from: ArrayMap.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ArrayMap2 {
    public static final <K, V> ArrayMap<K, V> arrayMapOf() {
        return new ArrayMap<>();
    }

    public static final <K, V> ArrayMap<K, V> arrayMapOf(Tuples2<? extends K, ? extends V>... tuples2Arr) {
        Intrinsics3.checkParameterIsNotNull(tuples2Arr, "pairs");
        ArrayMap<K, V> arrayMap = new ArrayMap<>(tuples2Arr.length);
        for (Tuples2<? extends K, ? extends V> tuples2 : tuples2Arr) {
            arrayMap.put(tuples2.getFirst(), tuples2.getSecond());
        }
        return arrayMap;
    }
}
