package b.g.a.c.i0;

/* JADX INFO: renamed from: b.g.a.c.i0.j, reason: use source file name */
/* JADX INFO: compiled from: LookupCache.java */
/* JADX INFO: loaded from: classes3.dex */
public interface LookupCache<K, V> {
    V get(Object obj);

    V putIfAbsent(K k, V v);
}
