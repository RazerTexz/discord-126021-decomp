package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: Add missing generic type declarations: [K] */
/* JADX INFO: loaded from: classes.dex */
public final class MapCollections$KeySet<K> implements Set<K> {
    public final /* synthetic */ MapCollections this$0;

    public MapCollections$KeySet(MapCollections mapCollections) {
        this.this$0 = mapCollections;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(K k) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends K> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.this$0.colClear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.this$0.colIndexOfKey(obj) >= 0;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return MapCollections.containsAllHelper(this.this$0.colGetMap(), collection);
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
            iHashCode += objColGetEntry == null ? 0 : objColGetEntry.hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.this$0.colGetSize() == 0;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<K> iterator() {
        return new MapCollections$ArrayIterator(this.this$0, 0);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        int iColIndexOfKey = this.this$0.colIndexOfKey(obj);
        if (iColIndexOfKey < 0) {
            return false;
        }
        this.this$0.colRemoveAt(iColIndexOfKey);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return MapCollections.removeAllHelper(this.this$0.colGetMap(), collection);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return MapCollections.retainAllHelper(this.this$0.colGetMap(), collection);
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        return this.this$0.colGetSize();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return this.this$0.toArrayHelper(0);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.this$0.toArrayHelper(tArr, 0);
    }
}
