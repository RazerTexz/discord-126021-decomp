package d0.t.q0;

import d0.z.d.m;
import java.util.Map$Entry;

/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$c<K, V> implements Map$Entry<K, V>, d0.z.d.g0.a {
    public final c<K, V> j;
    public final int k;

    public c$c(c<K, V> cVar, int i) {
        m.checkNotNullParameter(cVar, "map");
        this.j = cVar;
        this.k = i;
    }

    @Override // java.util.Map$Entry
    public boolean equals(Object obj) {
        if (obj instanceof Map$Entry) {
            Map$Entry map$Entry = (Map$Entry) obj;
            if (m.areEqual(map$Entry.getKey(), getKey()) && m.areEqual(map$Entry.getValue(), getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map$Entry
    public K getKey() {
        return (K) c.access$getKeysArray$p(this.j)[this.k];
    }

    @Override // java.util.Map$Entry
    public V getValue() {
        Object[] objArrAccess$getValuesArray$p = c.access$getValuesArray$p(this.j);
        m.checkNotNull(objArrAccess$getValuesArray$p);
        return (V) objArrAccess$getValuesArray$p[this.k];
    }

    @Override // java.util.Map$Entry
    public int hashCode() {
        K key = getKey();
        int iHashCode = key != null ? key.hashCode() : 0;
        V value = getValue();
        return iHashCode ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map$Entry
    public V setValue(V v) {
        this.j.checkIsMutable$kotlin_stdlib();
        Object[] objArrAccess$allocateValuesArray = c.access$allocateValuesArray(this.j);
        int i = this.k;
        V v2 = (V) objArrAccess$allocateValuesArray[i];
        objArrAccess$allocateValuesArray[i] = v;
        return v2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append('=');
        sb.append(getValue());
        return sb.toString();
    }
}
