package b.i.b.b;

import java.util.Map$Entry;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: AbstractMapEntry.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f<K, V> implements Map$Entry<K, V> {
    @Override // java.util.Map$Entry
    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof Map$Entry)) {
            return false;
        }
        Map$Entry map$Entry = (Map$Entry) obj;
        return b.i.a.f.e.o.f.V(getKey(), map$Entry.getKey()) && b.i.a.f.e.o.f.V(getValue(), map$Entry.getValue());
    }

    @Override // java.util.Map$Entry
    public abstract K getKey();

    @Override // java.util.Map$Entry
    public abstract V getValue();

    @Override // java.util.Map$Entry
    public int hashCode() {
        K key = getKey();
        V value = getValue();
        return (key == null ? 0 : key.hashCode()) ^ (value != null ? value.hashCode() : 0);
    }

    public String toString() {
        return getKey() + "=" + getValue();
    }
}
