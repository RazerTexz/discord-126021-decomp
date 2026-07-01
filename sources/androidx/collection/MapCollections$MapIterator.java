package androidx.collection;

import java.util.Iterator;
import java.util.Map$Entry;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: classes.dex */
public final class MapCollections$MapIterator<K, V> implements Iterator<Map$Entry<K, V>>, Map$Entry<K, V> {
    public int mEnd;
    public boolean mEntryValid = false;
    public int mIndex = -1;
    public final /* synthetic */ MapCollections this$0;

    public MapCollections$MapIterator(MapCollections mapCollections) {
        this.this$0 = mapCollections;
        this.mEnd = mapCollections.colGetSize() - 1;
    }

    @Override // java.util.Map$Entry
    public boolean equals(Object obj) {
        if (!this.mEntryValid) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (!(obj instanceof Map$Entry)) {
            return false;
        }
        Map$Entry map$Entry = (Map$Entry) obj;
        return ContainerHelpers.equal(map$Entry.getKey(), this.this$0.colGetEntry(this.mIndex, 0)) && ContainerHelpers.equal(map$Entry.getValue(), this.this$0.colGetEntry(this.mIndex, 1));
    }

    @Override // java.util.Map$Entry
    public K getKey() {
        if (this.mEntryValid) {
            return (K) this.this$0.colGetEntry(this.mIndex, 0);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Map$Entry
    public V getValue() {
        if (this.mEntryValid) {
            return (V) this.this$0.colGetEntry(this.mIndex, 1);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.mIndex < this.mEnd;
    }

    @Override // java.util.Map$Entry
    public int hashCode() {
        if (!this.mEntryValid) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        Object objColGetEntry = this.this$0.colGetEntry(this.mIndex, 0);
        Object objColGetEntry2 = this.this$0.colGetEntry(this.mIndex, 1);
        return (objColGetEntry == null ? 0 : objColGetEntry.hashCode()) ^ (objColGetEntry2 != null ? objColGetEntry2.hashCode() : 0);
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.mEntryValid) {
            throw new IllegalStateException();
        }
        this.this$0.colRemoveAt(this.mIndex);
        this.mIndex--;
        this.mEnd--;
        this.mEntryValid = false;
    }

    @Override // java.util.Map$Entry
    public V setValue(V v) {
        if (this.mEntryValid) {
            return (V) this.this$0.colSetValue(this.mIndex, v);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public String toString() {
        return getKey() + "=" + getValue();
    }

    @Override // java.util.Iterator
    public Map$Entry<K, V> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.mIndex++;
        this.mEntryValid = true;
        return this;
    }
}
