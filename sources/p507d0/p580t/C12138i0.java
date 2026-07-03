package p507d0.p580t;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.sequences.Sequence;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.i0 */
/* JADX INFO: compiled from: _Maps.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12138i0 extends C12136h0 {
    public static final <K, V> Sequence<Map.Entry<K, V>> asSequence(Map<? extends K, ? extends V> map) {
        C12238m.checkNotNullParameter(map, "$this$asSequence");
        return C12163u.asSequence(map.entrySet());
    }

    public static final <K, V> List<Pair<K, V>> toList(Map<? extends K, ? extends V> map) {
        C12238m.checkNotNullParameter(map, "$this$toList");
        if (map.size() == 0) {
            return C12147n.emptyList();
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return C12147n.emptyList();
        }
        Map.Entry<? extends K, ? extends V> next = it.next();
        if (!it.hasNext()) {
            return C12145m.listOf(new Pair(next.getKey(), next.getValue()));
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new Pair(next.getKey(), next.getValue()));
        do {
            Map.Entry<? extends K, ? extends V> next2 = it.next();
            arrayList.add(new Pair(next2.getKey(), next2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }
}
