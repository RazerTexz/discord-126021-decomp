package b.i.b.b;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v$s<K, V> extends v$c<K, V, v$s<K, V>> implements v$a0<K, V, v$s<K, V>> {
    public volatile v$b0<K, V, v$s<K, V>> d;

    public v$s(K k, int i, @NullableDecl v$s<K, V> v_s) {
        super(k, i, v_s);
        v$b0<Object, Object, v$e> v_b0 = v.j;
        this.d = (v$b0<K, V, v$s<K, V>>) v.j;
    }

    @Override // b.i.b.b.v$a0
    public v$b0<K, V, v$s<K, V>> b() {
        return this.d;
    }

    @Override // b.i.b.b.v$i
    public V getValue() {
        return this.d.get();
    }
}
