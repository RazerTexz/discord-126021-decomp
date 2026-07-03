package p507d0.p580t;

import java.util.Map;
import java.util.NoSuchElementException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.f0 */
/* JADX INFO: compiled from: MapWithDefault.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12132f0 {
    public static final <K, V> V getOrImplicitDefaultNullable(Map<K, ? extends V> map, K k) {
        C12238m.checkNotNullParameter(map, "$this$getOrImplicitDefault");
        if (map instanceof InterfaceC12130e0) {
            return (V) ((InterfaceC12130e0) map).getOrImplicitDefault(k);
        }
        V v = map.get(k);
        if (v != null || map.containsKey(k)) {
            return v;
        }
        throw new NoSuchElementException("Key " + k + " is missing in the map.");
    }
}
