package d0.t;

import d0.t.q0.MapBuilder2;
import d0.z.d.Intrinsics3;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.Tuples2;

/* JADX INFO: renamed from: d0.t.g0, reason: use source file name */
/* JADX INFO: compiled from: MapsJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class MapsJVM extends MapWithDefault2 {
    public static final <K, V> Map<K, V> build(Map<K, V> map) {
        Intrinsics3.checkNotNullParameter(map, "builder");
        return ((MapBuilder2) map).build();
    }

    public static final <K, V> Map<K, V> createMapBuilder() {
        return new MapBuilder2();
    }

    public static final int mapCapacity(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final <K, V> Map<K, V> mapOf(Tuples2<? extends K, ? extends V> tuples2) {
        Intrinsics3.checkNotNullParameter(tuples2, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(tuples2.getFirst(), tuples2.getSecond());
        Intrinsics3.checkNotNullExpressionValue(mapSingletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return mapSingletonMap;
    }

    public static final <K, V> Map<K, V> toSingletonMap(Map<? extends K, ? extends V> map) {
        Intrinsics3.checkNotNullParameter(map, "$this$toSingletonMap");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        Intrinsics3.checkNotNullExpressionValue(mapSingletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return mapSingletonMap;
    }

    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> map) {
        Intrinsics3.checkNotNullParameter(map, "$this$toSortedMap");
        return new TreeMap(map);
    }

    public static final <K, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        Intrinsics3.checkNotNullParameter(map, "$this$toSortedMap");
        Intrinsics3.checkNotNullParameter(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
