package b.i.b.b;

import b.i.b.b.v$i;
import java.lang.ref.ReferenceQueue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public interface v$b0<K, V, E extends v$i<K, V, E>> {
    E a();

    v$b0<K, V, E> b(ReferenceQueue<V> referenceQueue, E e);

    void clear();

    @NullableDecl
    V get();
}
