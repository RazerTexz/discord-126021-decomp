package d0.t.q0;

import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;

/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d<K, V> extends a<Map$Entry<K, V>, K, V> {
    public final c<K, V> j;

    public d(c<K, V> cVar) {
        m.checkNotNullParameter(cVar, "backing");
        this.j = cVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return add((Map$Entry) obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends Map$Entry<K, V>> collection) {
        m.checkNotNullParameter(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.j.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> collection) {
        m.checkNotNullParameter(collection, "elements");
        return this.j.containsAllEntries$kotlin_stdlib(collection);
    }

    @Override // d0.t.q0.a
    public boolean containsEntry(Map$Entry<? extends K, ? extends V> map$Entry) {
        m.checkNotNullParameter(map$Entry, "element");
        return this.j.containsEntry$kotlin_stdlib(map$Entry);
    }

    @Override // d0.t.f
    public int getSize() {
        return this.j.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.j.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map$Entry<K, V>> iterator() {
        return this.j.entriesIterator$kotlin_stdlib();
    }

    @Override // d0.t.q0.a
    public boolean remove(Map$Entry map$Entry) {
        m.checkNotNullParameter(map$Entry, "element");
        return this.j.removeEntry$kotlin_stdlib(map$Entry);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> collection) {
        m.checkNotNullParameter(collection, "elements");
        this.j.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> collection) {
        m.checkNotNullParameter(collection, "elements");
        this.j.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }

    public boolean add(Map$Entry<K, V> map$Entry) {
        m.checkNotNullParameter(map$Entry, "element");
        throw new UnsupportedOperationException();
    }
}
