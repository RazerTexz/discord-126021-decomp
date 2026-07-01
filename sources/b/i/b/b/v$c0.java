package b.i.b.b;

import b.i.b.b.v$i;
import com.google.j2objc.annotations.Weak;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v$c0<K, V, E extends v$i<K, V, E>> extends WeakReference<V> implements v$b0<K, V, E> {

    @Weak
    public final E a;

    public v$c0(ReferenceQueue<V> referenceQueue, V v, E e) {
        super(v, referenceQueue);
        this.a = e;
    }

    @Override // b.i.b.b.v$b0
    public E a() {
        return this.a;
    }

    @Override // b.i.b.b.v$b0
    public v$b0<K, V, E> b(ReferenceQueue<V> referenceQueue, E e) {
        return new v$c0(referenceQueue, get(), e);
    }
}
