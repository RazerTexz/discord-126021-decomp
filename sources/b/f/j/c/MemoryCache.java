package b.f.j.c;

import b.f.d.d.Predicate2;
import b.f.d.g.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: renamed from: b.f.j.c.w, reason: use source file name */
/* JADX INFO: compiled from: MemoryCache.java */
/* JADX INFO: loaded from: classes.dex */
public interface MemoryCache<K, V> extends MemoryTrimmable {

    /* JADX INFO: renamed from: b.f.j.c.w$a */
    /* JADX INFO: compiled from: MemoryCache.java */
    public interface a {
    }

    CloseableReference<V> a(K k, CloseableReference<V> closeableReference);

    boolean contains(K k);

    int d(Predicate2<K> predicate2);

    CloseableReference<V> get(K k);
}
