package d0.e0.p.d.n0;

import java.io.Serializable;

/* JADX INFO: compiled from: MapEntry.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e<K, V> implements Serializable {
    public final K key;
    public final V value;

    public e(K k, V v) {
        this.key = k;
        this.value = v;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        K k = this.key;
        if (k == null) {
            if (eVar.key != null) {
                return false;
            }
        } else if (!k.equals(eVar.key)) {
            return false;
        }
        V v = this.value;
        V v2 = eVar.value;
        if (v == null) {
            if (v2 != null) {
                return false;
            }
        } else if (!v.equals(v2)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        K k = this.key;
        int iHashCode = k == null ? 0 : k.hashCode();
        V v = this.value;
        return iHashCode ^ (v != null ? v.hashCode() : 0);
    }

    public String toString() {
        return this.key + "=" + this.value;
    }
}
