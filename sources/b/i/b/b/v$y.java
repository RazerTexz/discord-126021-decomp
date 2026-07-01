package b.i.b.b;

import java.lang.ref.ReferenceQueue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v$y<K, V> extends v$d<K, V, v$y<K, V>> implements v$a0<K, V, v$y<K, V>> {
    public volatile v$b0<K, V, v$y<K, V>> c;

    public v$y(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl v$y<K, V> v_y) {
        super(referenceQueue, k, i, v_y);
        v$b0<Object, Object, v$e> v_b0 = v.j;
        this.c = (v$b0<K, V, v$y<K, V>>) v.j;
    }

    @Override // b.i.b.b.v$a0
    public v$b0<K, V, v$y<K, V>> b() {
        return this.c;
    }

    @Override // b.i.b.b.v$i
    public V getValue() {
        return this.c.get();
    }
}
