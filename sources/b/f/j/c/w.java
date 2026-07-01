package b.f.j.c;

import com.facebook.common.references.CloseableReference;

/* JADX INFO: compiled from: MemoryCache.java */
/* JADX INFO: loaded from: classes.dex */
public interface w<K, V> extends b.f.d.g.b {
    CloseableReference<V> a(K k, CloseableReference<V> closeableReference);

    boolean contains(K k);

    int d(b.f.d.d.j<K> jVar);

    CloseableReference<V> get(K k);
}
