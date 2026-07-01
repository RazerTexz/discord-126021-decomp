package b.i.b.b;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v$q<K, V> extends v$c<K, V, v$q<K, V>> implements v$i {

    @NullableDecl
    public volatile V d;

    public v$q(K k, int i, @NullableDecl v$q<K, V> v_q) {
        super(k, i, v_q);
        this.d = null;
    }

    @Override // b.i.b.b.v$i
    @NullableDecl
    public V getValue() {
        return this.d;
    }
}
