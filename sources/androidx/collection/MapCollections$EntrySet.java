package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Set;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: classes.dex */
public final class MapCollections$EntrySet<K, V> implements Set<Map$Entry<K, V>> {
    public final /* synthetic */ MapCollections this$0;

    public MapCollections$EntrySet(MapCollections mapCollections) {
        this.this$0 = mapCollections;
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return add((Map$Entry) obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends Map$Entry<K, V>> collection) {
        int iColGetSize = this.this$0.colGetSize();
        for (Map$Entry<K, V> map$Entry : collection) {
            this.this$0.colPut(map$Entry.getKey(), map$Entry.getValue());
        }
        return iColGetSize != this.this$0.colGetSize();
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.this$0.colClear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        if (!(obj instanceof Map$Entry)) {
            return false;
        }
        Map$Entry map$Entry = (Map$Entry) obj;
        int iColIndexOfKey = this.this$0.colIndexOfKey(map$Entry.getKey());
        if (iColIndexOfKey < 0) {
            return false;
        }
        return ContainerHelpers.equal(this.this$0.colGetEntry(iColIndexOfKey, 1), map$Entry.getValue());
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object obj) {
        return MapCollections.equalsSetHelper(this, obj);
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        int iHashCode = 0;
        for (int iColGetSize = this.this$0.colGetSize() - 1; iColGetSize >= 0; iColGetSize--) {
            Object objColGetEntry = this.this$0.colGetEntry(iColGetSize, 0);
            Object objColGetEntry2 = this.this$0.colGetEntry(iColGetSize, 1);
            iHashCode += (objColGetEntry == null ? 0 : objColGetEntry.hashCode()) ^ (objColGetEntry2 == null ? 0 : objColGetEntry2.hashCode());
        }
        return iHashCode;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.this$0.colGetSize() == 0;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<Map$Entry<K, V>> iterator() {
        return new MapCollections$MapIterator(this.this$0);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        return this.this$0.colGetSize();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public boolean add(Map$Entry<K, V> map$Entry) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        throw new UnsupportedOperationException();
    }
}
