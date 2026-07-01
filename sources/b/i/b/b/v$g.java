package b.i.b.b;

import java.util.Iterator;
import java.util.Map$Entry;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v$g<K, V> extends v$m<Map$Entry<K, V>> {
    public final /* synthetic */ v j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v$g(v vVar) {
        super(null);
        this.j = vVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.j.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Map$Entry map$Entry;
        Object key;
        Object obj2;
        return (obj instanceof Map$Entry) && (key = (map$Entry = (Map$Entry) obj).getKey()) != null && (obj2 = this.j.get(key)) != null && this.j.d().c(map$Entry.getValue(), obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.j.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map$Entry<K, V>> iterator() {
        return new v$f(this.j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        Map$Entry map$Entry;
        Object key;
        return (obj instanceof Map$Entry) && (key = (map$Entry = (Map$Entry) obj).getKey()) != null && this.j.remove(key, map$Entry.getValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.j.size();
    }
}
