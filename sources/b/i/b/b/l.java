package b.i.b.b;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: ForwardingMap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l<K, V> extends m implements Map<K, V> {
    @Override // java.util.Map
    public void clear() {
        ((v$b) this).j.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return ((v$b) this).j.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return ((v$b) this).j.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map$Entry<K, V>> entrySet() {
        return ((v$b) this).j.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(@NullableDecl Object obj) {
        return obj == this || ((v$b) this).j.equals(obj);
    }

    @Override // java.util.Map
    public V get(@NullableDecl Object obj) {
        return ((v$b) this).j.get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return ((v$b) this).j.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return ((v$b) this).j.isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return ((v$b) this).j.keySet();
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    public V put(K k, V v) {
        return ((v$b) this).j.put(k, v);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ((v$b) this).j.putAll(map);
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    public V remove(Object obj) {
        return ((v$b) this).j.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return ((v$b) this).j.size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return ((v$b) this).j.values();
    }
}
