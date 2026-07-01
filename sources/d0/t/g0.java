package d0.t;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.Pair;

/* JADX INFO: compiled from: MapsJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class g0 extends f0 {
    public static final <K, V> Map<K, V> build(Map<K, V> map) {
        d0.z.d.m.checkNotNullParameter(map, "builder");
        return ((d0.t.q0.c) map).build();
    }

    public static final <K, V> Map<K, V> createMapBuilder() {
        return new d0.t.q0.c();
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

    public static final <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V> pair) {
        d0.z.d.m.checkNotNullParameter(pair, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        d0.z.d.m.checkNotNullExpressionValue(mapSingletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return mapSingletonMap;
    }

    public static final <K, V> Map<K, V> toSingletonMap(Map<? extends K, ? extends V> map) {
        d0.z.d.m.checkNotNullParameter(map, "$this$toSingletonMap");
        Map$Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        d0.z.d.m.checkNotNullExpressionValue(mapSingletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return mapSingletonMap;
    }

    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> map) {
        d0.z.d.m.checkNotNullParameter(map, "$this$toSortedMap");
        return new TreeMap(map);
    }

    public static final <K, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        d0.z.d.m.checkNotNullParameter(map, "$this$toSortedMap");
        d0.z.d.m.checkNotNullParameter(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
