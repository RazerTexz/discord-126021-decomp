package b.i.b.b;

import b.i.b.b.MapMakerInternalMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: renamed from: b.i.b.b.l, reason: use source file name */
/* JADX INFO: compiled from: ForwardingMap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ForwardingMap<K, V> extends ForwardingObject implements Map<K, V> {
    @Override // java.util.Map
    public void clear() {
        ((MapMakerInternalMap.b) this).j.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return ((MapMakerInternalMap.b) this).j.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return ((MapMakerInternalMap.b) this).j.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return ((MapMakerInternalMap.b) this).j.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(@NullableDecl Object obj) {
        return obj == this || ((MapMakerInternalMap.b) this).j.equals(obj);
    }

    @Override // java.util.Map
    public V get(@NullableDecl Object obj) {
        return ((MapMakerInternalMap.b) this).j.get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return ((MapMakerInternalMap.b) this).j.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return ((MapMakerInternalMap.b) this).j.isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return ((MapMakerInternalMap.b) this).j.keySet();
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    public V put(K k, V v) {
        return ((MapMakerInternalMap.b) this).j.put(k, v);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ((MapMakerInternalMap.b) this).j.putAll(map);
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    public V remove(Object obj) {
        return ((MapMakerInternalMap.b) this).j.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return ((MapMakerInternalMap.b) this).j.size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return ((MapMakerInternalMap.b) this).j.values();
    }
}
