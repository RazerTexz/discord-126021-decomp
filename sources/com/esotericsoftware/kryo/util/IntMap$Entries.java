package com.esotericsoftware.kryo.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class IntMap$Entries<V> extends IntMap$MapIterator<V> implements Iterable<IntMap$Entry<V>>, Iterator<IntMap$Entry<V>> {
    private IntMap$Entry<V> entry;

    public IntMap$Entries(IntMap intMap) {
        super(intMap);
        this.entry = new IntMap$Entry<>();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // java.lang.Iterable
    public Iterator<IntMap$Entry<V>> iterator() {
        return this;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // com.esotericsoftware.kryo.util.IntMap$MapIterator, java.util.Iterator
    public /* bridge */ /* synthetic */ void remove() {
        super.remove();
    }

    @Override // com.esotericsoftware.kryo.util.IntMap$MapIterator
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    @Override // java.util.Iterator
    public IntMap$Entry<V> next() {
        if (!this.hasNext) {
            throw new NoSuchElementException();
        }
        IntMap<V> intMap = this.map;
        int[] iArr = intMap.keyTable;
        int i = this.nextIndex;
        if (i == -1) {
            IntMap$Entry<V> intMap$Entry = this.entry;
            intMap$Entry.key = 0;
            intMap$Entry.value = intMap.zeroValue;
        } else {
            IntMap$Entry<V> intMap$Entry2 = this.entry;
            intMap$Entry2.key = iArr[i];
            intMap$Entry2.value = intMap.valueTable[i];
        }
        this.currentIndex = i;
        findNextIndex();
        return this.entry;
    }
}
