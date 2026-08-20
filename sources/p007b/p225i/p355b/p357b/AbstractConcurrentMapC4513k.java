package p007b.p225i.p355b.p357b;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: renamed from: b.i.b.b.k */
/* JADX INFO: compiled from: ForwardingConcurrentMap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractConcurrentMapC4513k<K, V> extends AbstractC4515l<K, V> implements ConcurrentMap<K, V> {
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V putIfAbsent(K k, V v) {
        return ((ConcurrentMapC4533v.b) this).f12078j.putIfAbsent(k, v);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean remove(Object obj, Object obj2) {
        return ((ConcurrentMapC4533v.b) this).f12078j.remove(obj, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V replace(K k, V v) {
        return ((ConcurrentMapC4533v.b) this).f12078j.replace(k, v);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean replace(K k, V v, V v2) {
        return ((ConcurrentMapC4533v.b) this).f12078j.replace(k, v, v2);
    }
}
