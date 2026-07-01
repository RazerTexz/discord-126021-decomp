package d0.t;

import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Tuples2;

/* JADX INFO: renamed from: d0.t.h0, reason: use source file name */
/* JADX INFO: compiled from: Maps.kt */
/* JADX INFO: loaded from: classes3.dex */
public class Maps6 extends MapsJVM {
    public static final <K, V> Map<K, V> emptyMap() {
        return Maps7.j;
    }

    public static final <K, V> V getValue(Map<K, ? extends V> map, K k) {
        Intrinsics3.checkNotNullParameter(map, "$this$getValue");
        return (V) MapWithDefault2.getOrImplicitDefaultNullable(map, k);
    }

    public static final <K, V> HashMap<K, V> hashMapOf(Tuples2<? extends K, ? extends V>... tuples2Arr) {
        Intrinsics3.checkNotNullParameter(tuples2Arr, "pairs");
        HashMap<K, V> map = new HashMap<>(MapsJVM.mapCapacity(tuples2Arr.length));
        putAll(map, tuples2Arr);
        return map;
    }

    public static final <K, V> LinkedHashMap<K, V> linkedMapOf(Tuples2<? extends K, ? extends V>... tuples2Arr) {
        Intrinsics3.checkNotNullParameter(tuples2Arr, "pairs");
        return (LinkedHashMap) toMap(tuples2Arr, new LinkedHashMap(MapsJVM.mapCapacity(tuples2Arr.length)));
    }

    public static final <K, V> Map<K, V> mapOf(Tuples2<? extends K, ? extends V>... tuples2Arr) {
        Intrinsics3.checkNotNullParameter(tuples2Arr, "pairs");
        return tuples2Arr.length > 0 ? toMap(tuples2Arr, new LinkedHashMap(MapsJVM.mapCapacity(tuples2Arr.length))) : emptyMap();
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, K k) {
        Intrinsics3.checkNotNullParameter(map, "$this$minus");
        Map mutableMap = toMutableMap(map);
        mutableMap.remove(k);
        return optimizeReadOnlyMap(mutableMap);
    }

    public static final <K, V> Map<K, V> mutableMapOf(Tuples2<? extends K, ? extends V>... tuples2Arr) {
        Intrinsics3.checkNotNullParameter(tuples2Arr, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(tuples2Arr.length));
        putAll(linkedHashMap, tuples2Arr);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> optimizeReadOnlyMap(Map<K, ? extends V> map) {
        Intrinsics3.checkNotNullParameter(map, "$this$optimizeReadOnlyMap");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : MapsJVM.toSingletonMap(map);
        }
        return emptyMap();
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Tuples2<? extends K, ? extends V> tuples2) {
        Intrinsics3.checkNotNullParameter(map, "$this$plus");
        Intrinsics3.checkNotNullParameter(tuples2, "pair");
        if (map.isEmpty()) {
            return MapsJVM.mapOf(tuples2);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(tuples2.getFirst(), tuples2.getSecond());
        return linkedHashMap;
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> map, Tuples2<? extends K, ? extends V>[] tuples2Arr) {
        Intrinsics3.checkNotNullParameter(map, "$this$putAll");
        Intrinsics3.checkNotNullParameter(tuples2Arr, "pairs");
        for (Tuples2<? extends K, ? extends V> tuples2 : tuples2Arr) {
            map.put(tuples2.component1(), tuples2.component2());
        }
    }

    public static final <K, V> Map<K, V> toMap(Iterable<? extends Tuples2<? extends K, ? extends V>> iterable) {
        Intrinsics3.checkNotNullParameter(iterable, "$this$toMap");
        if (!(iterable instanceof Collection)) {
            return optimizeReadOnlyMap(toMap(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return emptyMap();
        }
        if (size != 1) {
            return toMap(iterable, new LinkedHashMap(MapsJVM.mapCapacity(collection.size())));
        }
        return MapsJVM.mapOf(iterable instanceof List ? (Tuples2<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <K, V> Map<K, V> toMutableMap(Map<? extends K, ? extends V> map) {
        Intrinsics3.checkNotNullParameter(map, "$this$toMutableMap");
        return new LinkedHashMap(map);
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, Iterable<? extends K> iterable) {
        Intrinsics3.checkNotNullParameter(map, "$this$minus");
        Intrinsics3.checkNotNullParameter(iterable, "keys");
        Map mutableMap = toMutableMap(map);
        MutableCollections.removeAll(mutableMap.keySet(), iterable);
        return optimizeReadOnlyMap(mutableMap);
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        Intrinsics3.checkNotNullParameter(map, "$this$plus");
        Intrinsics3.checkNotNullParameter(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> map, Iterable<? extends Tuples2<? extends K, ? extends V>> iterable) {
        Intrinsics3.checkNotNullParameter(map, "$this$putAll");
        Intrinsics3.checkNotNullParameter(iterable, "pairs");
        for (Tuples2<? extends K, ? extends V> tuples2 : iterable) {
            map.put(tuples2.component1(), tuples2.component2());
        }
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Iterable<? extends Tuples2<? extends K, ? extends V>> iterable, M m) {
        Intrinsics3.checkNotNullParameter(iterable, "$this$toMap");
        Intrinsics3.checkNotNullParameter(m, "destination");
        putAll(m, iterable);
        return m;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Tuples2<? extends K, ? extends V>[] tuples2Arr, M m) {
        Intrinsics3.checkNotNullParameter(tuples2Arr, "$this$toMap");
        Intrinsics3.checkNotNullParameter(m, "destination");
        putAll(m, tuples2Arr);
        return m;
    }

    public static final <K, V> Map<K, V> toMap(Map<? extends K, ? extends V> map) {
        Intrinsics3.checkNotNullParameter(map, "$this$toMap");
        int size = map.size();
        if (size == 0) {
            return emptyMap();
        }
        if (size != 1) {
            return toMutableMap(map);
        }
        return MapsJVM.toSingletonMap(map);
    }
}
