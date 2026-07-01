package b.i.a.f.h.l;

import b.d.b.a.outline;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class y6<K, V> implements Comparable<y6>, Map.Entry<K, V> {

    /* JADX INFO: Incorrect field signature: TK; */
    public final Comparable j;
    public V k;
    public final /* synthetic */ r6 l;

    public y6(r6 r6Var, Map.Entry<K, V> entry) {
        Comparable comparable = (Comparable) entry.getKey();
        V value = entry.getValue();
        this.l = r6Var;
        this.j = comparable;
        this.k = value;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(y6 y6Var) {
        return this.j.compareTo(y6Var.j);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        boolean zEquals;
        boolean zEquals2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Comparable comparable = this.j;
        Object key = entry.getKey();
        if (comparable == null) {
            zEquals = key == null;
        } else {
            zEquals = comparable.equals(key);
        }
        if (zEquals) {
            V v = this.k;
            Object value = entry.getValue();
            if (v == null) {
                zEquals2 = value == null;
            } else {
                zEquals2 = v.equals(value);
            }
            if (zEquals2) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.j;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.k;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.j;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.k;
        return iHashCode ^ (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        r6 r6Var = this.l;
        int i = r6.j;
        r6Var.h();
        V v2 = this.k;
        this.k = v;
        return v2;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.j);
        String strValueOf2 = String.valueOf(this.k);
        return outline.k(strValueOf2.length() + strValueOf.length() + 1, strValueOf, "=", strValueOf2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y6(r6 r6Var, K k, V v) {
        this.l = r6Var;
        this.j = k;
        this.k = v;
    }
}
