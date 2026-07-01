package d0.t;

import d0.z.d.Intrinsics3;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: d0.t.f0, reason: use source file name */
/* JADX INFO: compiled from: MapWithDefault.kt */
/* JADX INFO: loaded from: classes3.dex */
public class MapWithDefault2 {
    public static final <K, V> V getOrImplicitDefaultNullable(Map<K, ? extends V> map, K k) {
        Intrinsics3.checkNotNullParameter(map, "$this$getOrImplicitDefault");
        if (map instanceof MapWithDefault) {
            return (V) ((MapWithDefault) map).getOrImplicitDefault(k);
        }
        V v = map.get(k);
        if (v != null || map.containsKey(k)) {
            return v;
        }
        throw new NoSuchElementException("Key " + k + " is missing in the map.");
    }
}
