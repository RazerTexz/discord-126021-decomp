package com.esotericsoftware.kryo.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class IntMap$Values<V> extends IntMap$MapIterator<V> implements Iterable<V>, Iterator<V> {
    public IntMap$Values(IntMap<V> intMap) {
        super(intMap);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // java.lang.Iterable
    public Iterator<V> iterator() {
        return this;
    }

    @Override // java.util.Iterator
    public V next() {
        if (!this.hasNext) {
            throw new NoSuchElementException();
        }
        int i = this.nextIndex;
        V v = i == -1 ? this.map.zeroValue : this.map.valueTable[i];
        this.currentIndex = i;
        findNextIndex();
        return v;
    }

    @Override // com.esotericsoftware.kryo.util.IntMap$MapIterator, java.util.Iterator
    public /* bridge */ /* synthetic */ void remove() {
        super.remove();
    }

    @Override // com.esotericsoftware.kryo.util.IntMap$MapIterator
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    public ArrayList<V> toArray() {
        ArrayList<V> arrayList = new ArrayList<>(this.map.size);
        while (this.hasNext) {
            arrayList.add(next());
        }
        return arrayList;
    }
}
