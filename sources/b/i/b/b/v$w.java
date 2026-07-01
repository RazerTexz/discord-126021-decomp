package b.i.b.b;

import java.lang.ref.ReferenceQueue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v$w<K, V> extends v$d<K, V, v$w<K, V>> implements v$i {

    @NullableDecl
    public volatile V c;

    public v$w(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl v$w<K, V> v_w) {
        super(referenceQueue, k, i, v_w);
        this.c = null;
    }

    @Override // b.i.b.b.v$i
    @NullableDecl
    public V getValue() {
        return this.c;
    }
}
