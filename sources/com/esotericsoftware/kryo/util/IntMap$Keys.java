package com.esotericsoftware.kryo.util;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class IntMap$Keys extends IntMap$MapIterator {
    public IntMap$Keys(IntMap intMap) {
        super(intMap);
    }

    public int next() {
        if (!this.hasNext) {
            throw new NoSuchElementException();
        }
        int i = this.nextIndex;
        int i2 = i == -1 ? 0 : this.map.keyTable[i];
        this.currentIndex = i;
        findNextIndex();
        return i2;
    }

    @Override // com.esotericsoftware.kryo.util.IntMap$MapIterator, java.util.Iterator
    public /* bridge */ /* synthetic */ void remove() {
        super.remove();
    }

    @Override // com.esotericsoftware.kryo.util.IntMap$MapIterator
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    public IntArray toArray() {
        IntArray intArray = new IntArray(true, this.map.size);
        while (this.hasNext) {
            intArray.add(next());
        }
        return intArray;
    }
}
