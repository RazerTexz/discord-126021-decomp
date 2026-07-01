package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.a;
import d0.t.n;
import d0.t.q;
import d0.t.s;
import d0.z.d.g;
import d0.z.d.g0.c;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SparseMutableList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SparseMutableList<T> implements List<T>, c {
    private final List<SparseMutableList$Chunk<T>> chunks;
    private final int expectedChunkSize;
    private int size;

    public SparseMutableList() {
        this(0, 0, 3, null);
    }

    public SparseMutableList(int i, int i2) {
        this.expectedChunkSize = i2;
        this.chunks = new ArrayList();
        this.size = i;
    }

    private final void addChunk(SparseMutableList$Chunk<T> chunk) {
        this.chunks.add(chunk);
        q.sort(this.chunks);
    }

    private final void decrementChunksFromIndex(int chunkIndex) {
        int lastIndex;
        int lastIndex2 = n.getLastIndex(this.chunks);
        if (chunkIndex < 0 || lastIndex2 < chunkIndex || chunkIndex > (lastIndex = n.getLastIndex(this.chunks))) {
            return;
        }
        while (true) {
            this.chunks.get(chunkIndex).decrementStartIndex();
            if (chunkIndex == lastIndex) {
                return;
            } else {
                chunkIndex++;
            }
        }
    }

    private final int getChunkIndex(int index) {
        Iterator<SparseMutableList$Chunk<T>> it = this.chunks.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().containsListIndex(index)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private final int getFirstChunkIndexAfter(int index) {
        Iterator<SparseMutableList$Chunk<T>> it = this.chunks.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().beginsAfterListIndex(index)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private final void incrementChunksFromIndex(int chunkIndex) {
        int lastIndex;
        int lastIndex2 = n.getLastIndex(this.chunks);
        if (chunkIndex < 0 || lastIndex2 < chunkIndex || chunkIndex > (lastIndex = n.getLastIndex(this.chunks))) {
            return;
        }
        while (true) {
            this.chunks.get(chunkIndex).incrementStartIndex();
            if (chunkIndex == lastIndex) {
                return;
            } else {
                chunkIndex++;
            }
        }
    }

    private final void resolveChunks() {
        q.sort(this.chunks);
        int i = 0;
        while (i < this.chunks.size() - 1) {
            SparseMutableList$Chunk<T> sparseMutableList$Chunk = this.chunks.get(i);
            if (sparseMutableList$Chunk.isEmpty()) {
                this.chunks.remove(i);
            } else {
                int i2 = i + 1;
                SparseMutableList$Chunk<T> sparseMutableList$ChunkTryMergeChunks = SparseMutableList$Chunk.Companion.tryMergeChunks(sparseMutableList$Chunk, this.chunks.get(i2));
                if (sparseMutableList$ChunkTryMergeChunks != null) {
                    this.chunks.set(i, sparseMutableList$ChunkTryMergeChunks);
                    this.chunks.remove(i2);
                } else {
                    i = i2;
                }
            }
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T element) {
        set(size(), element);
        return true;
    }

    @Override // java.util.List
    public boolean addAll(int index, Collection<? extends T> elements) {
        m.checkNotNullParameter(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.chunks.clear();
        setSize(0);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object element) {
        if (isEmpty()) {
            return false;
        }
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            if (m.areEqual(it.next(), element)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        m.checkNotNullParameter(elements, "elements");
        HashSet hashSet = new HashSet(elements);
        if (hashSet.size() > size()) {
            return false;
        }
        for (T t : this) {
            if (hashSet.contains(t)) {
                hashSet.remove(t);
                if (hashSet.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final SparseMutableList<T> deepCopy() {
        SparseMutableList<T> sparseMutableList = new SparseMutableList<>(size(), 0, 2, null);
        Iterator<T> it = this.chunks.iterator();
        while (it.hasNext()) {
            sparseMutableList.chunks.add(((SparseMutableList$Chunk) it.next()).deepCopy());
        }
        return sparseMutableList;
    }

    @Override // java.util.List
    public T get(int index) {
        if (index > n.getLastIndex(this)) {
            StringBuilder sbV = a.V("index ", index, " invalid in list of size ");
            sbV.append(size());
            throw new IndexOutOfBoundsException(sbV.toString());
        }
        int chunkIndex = getChunkIndex(index);
        SparseMutableList$Chunk<T> sparseMutableList$Chunk = chunkIndex >= 0 ? this.chunks.get(chunkIndex) : null;
        if (sparseMutableList$Chunk != null) {
            return sparseMutableList$Chunk.getAtListIndex(index);
        }
        return null;
    }

    public int getSize() {
        return this.size;
    }

    @Override // java.util.List
    public int indexOf(Object element) {
        if (element != null) {
            Iterator<T> it = this.chunks.iterator();
            while (it.hasNext()) {
                int iFirstListIndexOf = ((SparseMutableList$Chunk) it.next()).firstListIndexOf(element);
                if (iFirstListIndexOf >= 0) {
                    return iFirstListIndexOf;
                }
            }
            return -1;
        }
        int i = 0;
        for (T t : this) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            if (m.areEqual(t, element)) {
                return i;
            }
            i = i2;
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new SparseMutableList$SparseMutableListIterator(this, 0, 2, null);
    }

    @Override // java.util.List
    public int lastIndexOf(Object element) {
        if (element != null) {
            Iterator<T> it = s.asReversedMutable(this.chunks).iterator();
            while (it.hasNext()) {
                int iLastListIndexOf = ((SparseMutableList$Chunk) it.next()).lastListIndexOf(element);
                if (iLastListIndexOf >= 0) {
                    return iLastListIndexOf;
                }
            }
            return -1;
        }
        for (int lastIndex = n.getLastIndex(this); lastIndex >= 0; lastIndex--) {
            if (m.areEqual(get(lastIndex), element)) {
                return lastIndex;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return new SparseMutableList$SparseMutableListIterator(this, 0, 2, null);
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int i) {
        return removeAt(i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        m.checkNotNullParameter(elements, "elements");
        boolean z2 = false;
        SparseMutableList$SparseMutableListIterator sparseMutableList$SparseMutableListIterator = new SparseMutableList$SparseMutableListIterator(this, 0, 2, null);
        while (sparseMutableList$SparseMutableListIterator.hasNext()) {
            if (elements.contains(sparseMutableList$SparseMutableListIterator.next())) {
                sparseMutableList$SparseMutableListIterator.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public T removeAt(int index) {
        T tRemoveAtListIndex;
        if (index < 0 || index >= size()) {
            StringBuilder sbV = a.V("index: ", index, " -- size: ");
            sbV.append(size());
            throw new ArrayIndexOutOfBoundsException(sbV.toString());
        }
        int chunkIndex = getChunkIndex(index);
        if (chunkIndex >= 0) {
            tRemoveAtListIndex = this.chunks.get(chunkIndex).removeAtListIndex(index);
            decrementChunksFromIndex(chunkIndex + 1);
        } else {
            int firstChunkIndexAfter = getFirstChunkIndexAfter(index);
            if (firstChunkIndexAfter != -1) {
                decrementChunksFromIndex(firstChunkIndexAfter);
            }
            tRemoveAtListIndex = null;
        }
        setSize(size() - 1);
        resolveChunks();
        return tRemoveAtListIndex;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        m.checkNotNullParameter(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public T set(int index, T element) {
        if (index >= size()) {
            setSize(index + 1);
        }
        int chunkIndex = getChunkIndex(index);
        if (chunkIndex >= 0) {
            T atListIndex = this.chunks.get(chunkIndex).setAtListIndex(index, element);
            resolveChunks();
            return atListIndex;
        }
        if (element == null) {
            return null;
        }
        addChunk(SparseMutableList$Chunk.Companion.create(element, index, this.expectedChunkSize));
        resolveChunks();
        return null;
    }

    public void setSize(int i) {
        int i2 = this.size;
        if (i > i2) {
            this.size = i;
            return;
        }
        if (i < i2) {
            Iterator<T> it = this.chunks.iterator();
            while (it.hasNext()) {
                ((SparseMutableList$Chunk) it.next()).removeAfterInclusive(i);
            }
            this.size = i;
            resolveChunks();
        }
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return g.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) g.toArray(this, tArr);
    }

    @Override // java.util.List
    public void add(int index, T element) {
        if (index == size()) {
            add(element);
            return;
        }
        if (index > size()) {
            throw new IndexOutOfBoundsException();
        }
        int chunkIndex = getChunkIndex(index);
        if (element != null) {
            if (chunkIndex >= 0) {
                this.chunks.get(chunkIndex).addAtListIndex(index, element);
                incrementChunksFromIndex(chunkIndex + 1);
            } else {
                SparseMutableList$Chunk<T> sparseMutableList$ChunkCreate = SparseMutableList$Chunk.Companion.create(element, index, this.expectedChunkSize);
                int firstChunkIndexAfter = getFirstChunkIndexAfter(index);
                if (firstChunkIndexAfter == -1) {
                    addChunk(sparseMutableList$ChunkCreate);
                } else {
                    addChunk(firstChunkIndexAfter, sparseMutableList$ChunkCreate);
                    incrementChunksFromIndex(firstChunkIndexAfter + 1);
                }
            }
        } else if (chunkIndex >= 0) {
            this.chunks.get(chunkIndex).addAtListIndex(index, null);
            incrementChunksFromIndex(chunkIndex + 1);
        } else {
            int firstChunkIndexAfter2 = getFirstChunkIndexAfter(index);
            if (firstChunkIndexAfter2 != -1) {
                incrementChunksFromIndex(firstChunkIndexAfter2);
            }
        }
        setSize(size() + 1);
        resolveChunks();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> elements) {
        m.checkNotNullParameter(elements, "elements");
        return addAll(size(), elements);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int index) {
        return new SparseMutableList$SparseMutableListIterator(this, 0, 2, null);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object element) {
        SparseMutableList$SparseMutableListIterator sparseMutableList$SparseMutableListIterator = new SparseMutableList$SparseMutableListIterator(this, 0, 2, null);
        while (sparseMutableList$SparseMutableListIterator.hasNext()) {
            if (m.areEqual(sparseMutableList$SparseMutableListIterator.next(), element)) {
                sparseMutableList$SparseMutableListIterator.remove();
                return true;
            }
        }
        return false;
    }

    private final void addChunk(int index, SparseMutableList$Chunk<T> chunk) {
        this.chunks.add(index, chunk);
        q.sort(this.chunks);
    }

    public /* synthetic */ SparseMutableList(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 5 : i2);
    }

    public final <R> SparseMutableList<R> deepCopy(Function1<? super T, ? extends R> transform) {
        m.checkNotNullParameter(transform, "transform");
        SparseMutableList<R> sparseMutableList = new SparseMutableList<>(size(), 0, 2, null);
        Iterator<T> it = this.chunks.iterator();
        while (it.hasNext()) {
            sparseMutableList.chunks.add(((SparseMutableList$Chunk) it.next()).deepCopy(transform));
        }
        return sparseMutableList;
    }
}
