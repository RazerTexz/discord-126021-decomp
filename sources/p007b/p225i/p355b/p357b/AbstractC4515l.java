package p007b.p225i.p355b.p357b;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: renamed from: b.i.b.b.l */
/* JADX INFO: compiled from: ForwardingMap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4515l<K, V> extends AbstractC4517m implements Map<K, V> {
    @Override // java.util.Map
    public void clear() {
        ((ConcurrentMapC4533v.b) this).f12078j.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return ((ConcurrentMapC4533v.b) this).f12078j.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return ((ConcurrentMapC4533v.b) this).f12078j.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return ((ConcurrentMapC4533v.b) this).f12078j.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(@NullableDecl Object obj) {
        return obj == this || ((ConcurrentMapC4533v.b) this).f12078j.equals(obj);
    }

    @Override // java.util.Map
    public V get(@NullableDecl Object obj) {
        return ((ConcurrentMapC4533v.b) this).f12078j.get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return ((ConcurrentMapC4533v.b) this).f12078j.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return ((ConcurrentMapC4533v.b) this).f12078j.isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return ((ConcurrentMapC4533v.b) this).f12078j.keySet();
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    public V put(K k, V v) {
        return ((ConcurrentMapC4533v.b) this).f12078j.put(k, v);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ((ConcurrentMapC4533v.b) this).f12078j.putAll(map);
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    public V remove(Object obj) {
        return ((ConcurrentMapC4533v.b) this).f12078j.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return ((ConcurrentMapC4533v.b) this).f12078j.size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return ((ConcurrentMapC4533v.b) this).f12078j.values();
    }
}
