package b.f.d.d;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: b.f.d.d.f, reason: use source file name */
/* JADX INFO: compiled from: ImmutableMap.java */
/* JADX INFO: loaded from: classes.dex */
public class ImmutableMap<K, V> extends HashMap<K, V> {
    public ImmutableMap(Map<? extends K, ? extends V> map) {
        super(map);
    }

    public static <K, V> Map<K, V> of(K k, V v) {
        HashMap map = new HashMap(1);
        map.put(k, v);
        return Collections.unmodifiableMap(map);
    }

    public static <K, V> Map<K, V> of(K k, V v, K k2, V v2) {
        HashMap map = new HashMap(2);
        map.put(k, v);
        map.put(k2, v2);
        return Collections.unmodifiableMap(map);
    }
}
