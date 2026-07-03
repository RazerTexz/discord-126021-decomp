package p507d0.p580t;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.h0 */
/* JADX INFO: compiled from: Maps.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12136h0 extends C12134g0 {
    public static final <K, V> Map<K, V> emptyMap() {
        return C12166x.f25222j;
    }

    public static final <K, V> V getValue(Map<K, ? extends V> map, K k) {
        C12238m.checkNotNullParameter(map, "$this$getValue");
        return (V) C12132f0.getOrImplicitDefaultNullable(map, k);
    }

    public static final <K, V> HashMap<K, V> hashMapOf(Pair<? extends K, ? extends V>... pairArr) {
        C12238m.checkNotNullParameter(pairArr, "pairs");
        HashMap<K, V> map = new HashMap<>(C12134g0.mapCapacity(pairArr.length));
        putAll(map, pairArr);
        return map;
    }

    public static final <K, V> LinkedHashMap<K, V> linkedMapOf(Pair<? extends K, ? extends V>... pairArr) {
        C12238m.checkNotNullParameter(pairArr, "pairs");
        return (LinkedHashMap) toMap(pairArr, new LinkedHashMap(C12134g0.mapCapacity(pairArr.length)));
    }

    public static final <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V>... pairArr) {
        C12238m.checkNotNullParameter(pairArr, "pairs");
        return pairArr.length > 0 ? toMap(pairArr, new LinkedHashMap(C12134g0.mapCapacity(pairArr.length))) : emptyMap();
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, K k) {
        C12238m.checkNotNullParameter(map, "$this$minus");
        Map mutableMap = toMutableMap(map);
        mutableMap.remove(k);
        return optimizeReadOnlyMap(mutableMap);
    }

    public static final <K, V> Map<K, V> mutableMapOf(Pair<? extends K, ? extends V>... pairArr) {
        C12238m.checkNotNullParameter(pairArr, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(C12134g0.mapCapacity(pairArr.length));
        putAll(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> optimizeReadOnlyMap(Map<K, ? extends V> map) {
        C12238m.checkNotNullParameter(map, "$this$optimizeReadOnlyMap");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : C12134g0.toSingletonMap(map);
        }
        return emptyMap();
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Pair<? extends K, ? extends V> pair) {
        C12238m.checkNotNullParameter(map, "$this$plus");
        C12238m.checkNotNullParameter(pair, "pair");
        if (map.isEmpty()) {
            return C12134g0.mapOf(pair);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(pair.getFirst(), pair.getSecond());
        return linkedHashMap;
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairArr) {
        C12238m.checkNotNullParameter(map, "$this$putAll");
        C12238m.checkNotNullParameter(pairArr, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            map.put(pair.component1(), pair.component2());
        }
    }

    public static final <K, V> Map<K, V> toMap(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$toMap");
        if (!(iterable instanceof Collection)) {
            return optimizeReadOnlyMap(toMap(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return emptyMap();
        }
        if (size != 1) {
            return toMap(iterable, new LinkedHashMap(C12134g0.mapCapacity(collection.size())));
        }
        return C12134g0.mapOf(iterable instanceof List ? (Pair<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <K, V> Map<K, V> toMutableMap(Map<? extends K, ? extends V> map) {
        C12238m.checkNotNullParameter(map, "$this$toMutableMap");
        return new LinkedHashMap(map);
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, Iterable<? extends K> iterable) {
        C12238m.checkNotNullParameter(map, "$this$minus");
        C12238m.checkNotNullParameter(iterable, "keys");
        Map mutableMap = toMutableMap(map);
        C12160r.removeAll(mutableMap.keySet(), iterable);
        return optimizeReadOnlyMap(mutableMap);
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        C12238m.checkNotNullParameter(map, "$this$plus");
        C12238m.checkNotNullParameter(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        C12238m.checkNotNullParameter(map, "$this$putAll");
        C12238m.checkNotNullParameter(iterable, "pairs");
        for (Pair<? extends K, ? extends V> pair : iterable) {
            map.put(pair.component1(), pair.component2());
        }
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Iterable<? extends Pair<? extends K, ? extends V>> iterable, M m) {
        C12238m.checkNotNullParameter(iterable, "$this$toMap");
        C12238m.checkNotNullParameter(m, "destination");
        putAll(m, iterable);
        return m;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Pair<? extends K, ? extends V>[] pairArr, M m) {
        C12238m.checkNotNullParameter(pairArr, "$this$toMap");
        C12238m.checkNotNullParameter(m, "destination");
        putAll(m, pairArr);
        return m;
    }

    public static final <K, V> Map<K, V> toMap(Map<? extends K, ? extends V> map) {
        C12238m.checkNotNullParameter(map, "$this$toMap");
        int size = map.size();
        if (size == 0) {
            return emptyMap();
        }
        if (size != 1) {
            return toMutableMap(map);
        }
        return C12134g0.toSingletonMap(map);
    }
}
