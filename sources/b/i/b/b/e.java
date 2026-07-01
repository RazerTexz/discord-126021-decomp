package b.i.b.b;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e<K, V> extends g<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    public transient Map<K, Collection<V>> m;
    public transient int n;

    public e(Map<K, Collection<V>> map) {
        b.i.a.f.e.o.f.v(map.isEmpty());
        this.m = map;
    }

    public static /* synthetic */ int b(e eVar) {
        int i = eVar.n;
        eVar.n = i + 1;
        return i;
    }

    public static /* synthetic */ int c(e eVar) {
        int i = eVar.n;
        eVar.n = i - 1;
        return i;
    }

    public void d() {
        Iterator<Collection<V>> it = this.m.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.m.clear();
        this.n = 0;
    }

    public abstract Collection<V> e();
}
