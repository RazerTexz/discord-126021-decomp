package b.i.b.b;

import java.io.Serializable;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v$b<K, V> extends k<K, V> implements Serializable {
    private static final long serialVersionUID = 3;
    public final int concurrencyLevel;
    public transient ConcurrentMap<K, V> j;
    public final b.i.b.a.d<Object> keyEquivalence;
    public final v$p keyStrength;
    public final b.i.b.a.d<Object> valueEquivalence;
    public final v$p valueStrength;

    public v$b(v$p v_p, v$p v_p2, b.i.b.a.d<Object> dVar, b.i.b.a.d<Object> dVar2, int i, ConcurrentMap<K, V> concurrentMap) {
        this.keyStrength = v_p;
        this.valueStrength = v_p2;
        this.keyEquivalence = dVar;
        this.valueEquivalence = dVar2;
        this.concurrencyLevel = i;
        this.j = concurrentMap;
    }
}
