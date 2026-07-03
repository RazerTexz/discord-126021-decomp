package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Pair;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ArrayMap.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ArrayMapKt {
    public static final <K, V> ArrayMap<K, V> arrayMapOf() {
        return new ArrayMap<>();
    }

    public static final <K, V> ArrayMap<K, V> arrayMapOf(Pair<? extends K, ? extends V>... pairArr) {
        C12238m.checkParameterIsNotNull(pairArr, "pairs");
        ArrayMap<K, V> arrayMap = new ArrayMap<>(pairArr.length);
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            arrayMap.put(pair.getFirst(), pair.getSecond());
        }
        return arrayMap;
    }
}
