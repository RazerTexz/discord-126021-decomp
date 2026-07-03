package p507d0.p513e0.p514p.p515d.p577n0;

import java.io.Serializable;

/* JADX INFO: renamed from: d0.e0.p.d.n0.e */
/* JADX INFO: compiled from: MapEntry.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12048e<K, V> implements Serializable {
    public final K key;
    public final V value;

    public C12048e(K k, V v) {
        this.key = k;
        this.value = v;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C12048e)) {
            return false;
        }
        C12048e c12048e = (C12048e) obj;
        K k = this.key;
        if (k == null) {
            if (c12048e.key != null) {
                return false;
            }
        } else if (!k.equals(c12048e.key)) {
            return false;
        }
        V v = this.value;
        V v2 = c12048e.value;
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
