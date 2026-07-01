package b.i.b.b;

import b.i.b.b.v$i;
import b.i.b.b.v$n;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public interface v$j<K, V, E extends v$i<K, V, E>, S extends v$n<K, V, E, S>> {
    E a(S s2, E e, @NullableDecl E e2);

    v$p b();

    v$p c();

    void d(S s2, E e, V v);

    S e(v<K, V, E, S> vVar, int i, int i2);

    E f(S s2, K k, int i, @NullableDecl E e);
}
