package d0.e0.p.d.m0.i;

import java.util.Map$Entry;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: SmallSortedMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class t$b<K, V> implements Comparable<t<K, V>.t$b>, Map$Entry<K, V> {

    /* JADX INFO: Incorrect field signature: TK; */
    public final Comparable j;
    public V k;
    public final /* synthetic */ t l;

    public t$b(t tVar, Map$Entry<K, V> map$Entry) {
        Comparable comparable = (Comparable) map$Entry.getKey();
        V value = map$Entry.getValue();
        this.l = tVar;
        this.j = comparable;
        this.k = value;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((t$b) obj);
    }

    @Override // java.util.Map$Entry
    public boolean equals(Object obj) {
        boolean zEquals;
        boolean zEquals2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map$Entry)) {
            return false;
        }
        Map$Entry map$Entry = (Map$Entry) obj;
        Comparable comparable = this.j;
        Object key = map$Entry.getKey();
        if (comparable == null) {
            zEquals = key == null;
        } else {
            zEquals = comparable.equals(key);
        }
        if (zEquals) {
            V v = this.k;
            Object value = map$Entry.getValue();
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

    @Override // java.util.Map$Entry
    public /* bridge */ /* synthetic */ Object getKey() {
        return getKey();
    }

    @Override // java.util.Map$Entry
    public V getValue() {
        return this.k;
    }

    @Override // java.util.Map$Entry
    public int hashCode() {
        Comparable comparable = this.j;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.k;
        return iHashCode ^ (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map$Entry
    public V setValue(V v) {
        t tVar = this.l;
        int i = t.j;
        tVar.b();
        V v2 = this.k;
        this.k = v;
        return v2;
    }

    public String toString() {
        String strValueOf = String.valueOf(this.j);
        String strValueOf2 = String.valueOf(this.k);
        return b.d.b.a.a.K(new StringBuilder(strValueOf2.length() + strValueOf.length() + 1), strValueOf, "=", strValueOf2);
    }

    /* JADX WARN: Incorrect inner types in method signature: (Ld0/e0/p/d/m0/i/t<TK;TV;>.b;)I */
    public int compareTo(t$b t_b) {
        return getKey().compareTo(t_b.getKey());
    }

    /* JADX WARN: Incorrect return type in method signature: ()TK; */
    @Override // java.util.Map$Entry
    public Comparable getKey() {
        return this.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t$b(t tVar, K k, V v) {
        this.l = tVar;
        this.j = k;
        this.k = v;
    }
}
