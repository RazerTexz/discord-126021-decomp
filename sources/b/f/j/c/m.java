package b.f.j.c;

import com.facebook.common.references.CloseableReference;

/* JADX INFO: compiled from: CountingMemoryCache.java */
/* JADX INFO: loaded from: classes.dex */
public interface m<K, V> extends w<K, V>, b.f.d.g.b {
    CloseableReference<V> b(K k);

    CloseableReference<V> c(K k, CloseableReference<V> closeableReference, m$b<K> m_b);
}
