package b.i.b.b;

import b.i.b.b.v$i;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v$c<K, V, E extends v$i<K, V, E>> implements v$i<K, V, E> {
    public final K a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1650b;

    @NullableDecl
    public final E c;

    public v$c(K k, int i, @NullableDecl E e) {
        this.a = k;
        this.f1650b = i;
        this.c = e;
    }

    @Override // b.i.b.b.v$i
    public E a() {
        return this.c;
    }

    @Override // b.i.b.b.v$i
    public int c() {
        return this.f1650b;
    }

    @Override // b.i.b.b.v$i
    public K getKey() {
        return this.a;
    }
}
