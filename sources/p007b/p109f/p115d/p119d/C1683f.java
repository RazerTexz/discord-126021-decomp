package p007b.p109f.p115d.p119d;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: b.f.d.d.f */
/* JADX INFO: compiled from: ImmutableMap.java */
/* JADX INFO: loaded from: classes.dex */
public class C1683f<K, V> extends HashMap<K, V> {
    public C1683f(Map<? extends K, ? extends V> map) {
        super(map);
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> Map<K, V> m967of(K k, V v) {
        HashMap map = new HashMap(1);
        map.put(k, v);
        return Collections.unmodifiableMap(map);
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> Map<K, V> m968of(K k, V v, K k2, V v2) {
        HashMap map = new HashMap(2);
        map.put(k, v);
        map.put(k2, v2);
        return Collections.unmodifiableMap(map);
    }
}
