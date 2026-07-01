package b.i.b.b;

import b.i.b.b.v$i;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v$d<K, V, E extends v$i<K, V, E>> extends WeakReference<K> implements v$i<K, V, E> {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NullableDecl
    public final E f1651b;

    public v$d(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl E e) {
        super(k, referenceQueue);
        this.a = i;
        this.f1651b = e;
    }

    @Override // b.i.b.b.v$i
    public E a() {
        return this.f1651b;
    }

    @Override // b.i.b.b.v$i
    public int c() {
        return this.a;
    }

    @Override // b.i.b.b.v$i
    public K getKey() {
        return get();
    }
}
