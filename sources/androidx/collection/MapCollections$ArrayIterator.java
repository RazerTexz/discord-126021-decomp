package androidx.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class MapCollections$ArrayIterator<T> implements Iterator<T> {
    public boolean mCanRemove = false;
    public int mIndex;
    public final int mOffset;
    public int mSize;
    public final /* synthetic */ MapCollections this$0;

    public MapCollections$ArrayIterator(MapCollections mapCollections, int i) {
        this.this$0 = mapCollections;
        this.mOffset = i;
        this.mSize = mapCollections.colGetSize();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.mIndex < this.mSize;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T t = (T) this.this$0.colGetEntry(this.mIndex, this.mOffset);
        this.mIndex++;
        this.mCanRemove = true;
        return t;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.mCanRemove) {
            throw new IllegalStateException();
        }
        int i = this.mIndex - 1;
        this.mIndex = i;
        this.mSize--;
        this.mCanRemove = false;
        this.this$0.colRemoveAt(i);
    }
}
