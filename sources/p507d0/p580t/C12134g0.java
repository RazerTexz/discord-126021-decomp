package p507d0.p580t;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.Pair;
import p507d0.p580t.p581q0.C12156c;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.g0 */
/* JADX INFO: compiled from: MapsJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12134g0 extends C12132f0 {
    public static final <K, V> Map<K, V> build(Map<K, V> map) {
        C12238m.checkNotNullParameter(map, "builder");
        return ((C12156c) map).build();
    }

    public static final <K, V> Map<K, V> createMapBuilder() {
        return new C12156c();
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
        C12238m.checkNotNullParameter(pair, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        C12238m.checkNotNullExpressionValue(mapSingletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return mapSingletonMap;
    }

    public static final <K, V> Map<K, V> toSingletonMap(Map<? extends K, ? extends V> map) {
        C12238m.checkNotNullParameter(map, "$this$toSingletonMap");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        C12238m.checkNotNullExpressionValue(mapSingletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return mapSingletonMap;
    }

    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> map) {
        C12238m.checkNotNullParameter(map, "$this$toSortedMap");
        return new TreeMap(map);
    }

    public static final <K, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        C12238m.checkNotNullParameter(map, "$this$toSortedMap");
        C12238m.checkNotNullParameter(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
