package com.esotericsoftware.kryo.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class ObjectMap$Keys<K> extends ObjectMap$MapIterator<K, Object> implements Iterable<K>, Iterator<K> {
    public ObjectMap$Keys(ObjectMap<K, ?> objectMap) {
        super(objectMap);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // java.lang.Iterable
    public Iterator<K> iterator() {
        return this;
    }

    @Override // java.util.Iterator
    public K next() {
        if (!this.hasNext) {
            throw new NoSuchElementException();
        }
        K[] kArr = this.map.keyTable;
        int i = this.nextIndex;
        K k = kArr[i];
        this.currentIndex = i;
        advance();
        return k;
    }

    @Override // com.esotericsoftware.kryo.util.ObjectMap$MapIterator, java.util.Iterator
    public /* bridge */ /* synthetic */ void remove() {
        super.remove();
    }

    @Override // com.esotericsoftware.kryo.util.ObjectMap$MapIterator
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    public ArrayList<K> toArray() {
        ArrayList<K> arrayList = new ArrayList<>(this.map.size);
        while (this.hasNext) {
            arrayList.add(next());
        }
        return arrayList;
    }
}
