package d0.t;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.Pair;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: _Maps.kt */
/* JADX INFO: loaded from: classes3.dex */
public class i0 extends h0 {
    public static final <K, V> Sequence<Map$Entry<K, V>> asSequence(Map<? extends K, ? extends V> map) {
        d0.z.d.m.checkNotNullParameter(map, "$this$asSequence");
        return u.asSequence(map.entrySet());
    }

    public static final <K, V> List<Pair<K, V>> toList(Map<? extends K, ? extends V> map) {
        d0.z.d.m.checkNotNullParameter(map, "$this$toList");
        if (map.size() == 0) {
            return n.emptyList();
        }
        Iterator<Map$Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return n.emptyList();
        }
        Map$Entry<? extends K, ? extends V> next = it.next();
        if (!it.hasNext()) {
            return m.listOf(new Pair(next.getKey(), next.getValue()));
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new Pair(next.getKey(), next.getValue()));
        do {
            Map$Entry<? extends K, ? extends V> next2 = it.next();
            arrayList.add(new Pair(next2.getKey(), next2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }
}
