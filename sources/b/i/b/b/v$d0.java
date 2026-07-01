package b.i.b.b;

import java.util.Map$Entry;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v$d0<K, V> extends f<K, V> {
    public final K j;
    public V k;
    public final /* synthetic */ v l;

    public v$d0(v vVar, K k, V v) {
        this.l = vVar;
        this.j = k;
        this.k = v;
    }

    @Override // b.i.b.b.f, java.util.Map$Entry
    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof Map$Entry)) {
            return false;
        }
        Map$Entry map$Entry = (Map$Entry) obj;
        return this.j.equals(map$Entry.getKey()) && this.k.equals(map$Entry.getValue());
    }

    @Override // b.i.b.b.f, java.util.Map$Entry
    public K getKey() {
        return this.j;
    }

    @Override // b.i.b.b.f, java.util.Map$Entry
    public V getValue() {
        return this.k;
    }

    @Override // b.i.b.b.f, java.util.Map$Entry
    public int hashCode() {
        return this.j.hashCode() ^ this.k.hashCode();
    }

    @Override // java.util.Map$Entry
    public V setValue(V v) {
        V v2 = (V) this.l.put(this.j, v);
        this.k = v;
        return v2;
    }
}
