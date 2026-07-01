package b.f.j.c;

import b.f.d.d.Predicate2;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: renamed from: b.f.j.c.s, reason: use source file name */
/* JADX INFO: compiled from: InstrumentedMemoryCache.java */
/* JADX INFO: loaded from: classes.dex */
public class InstrumentedMemoryCache<K, V> implements MemoryCache<K, V> {
    public final MemoryCache<K, V> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MemoryCacheTracker f559b;

    public InstrumentedMemoryCache(MemoryCache<K, V> memoryCache, MemoryCacheTracker memoryCacheTracker) {
        this.a = memoryCache;
        this.f559b = memoryCacheTracker;
    }

    @Override // b.f.j.c.MemoryCache
    public CloseableReference<V> a(K k, CloseableReference<V> closeableReference) {
        this.f559b.c(k);
        return this.a.a(k, closeableReference);
    }

    @Override // b.f.j.c.MemoryCache
    public int d(Predicate2<K> predicate2) {
        return this.a.d(predicate2);
    }

    @Override // b.f.j.c.MemoryCache
    public CloseableReference<V> get(K k) {
        CloseableReference<V> closeableReference = this.a.get(k);
        if (closeableReference == null) {
            this.f559b.b(k);
        } else {
            this.f559b.a(k);
        }
        return closeableReference;
    }
}
