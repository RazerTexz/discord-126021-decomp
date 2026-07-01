package com.esotericsoftware.kryo.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class ObjectMap$Entries<K, V> extends ObjectMap$MapIterator<K, V> implements Iterable<ObjectMap$Entry<K, V>>, Iterator<ObjectMap$Entry<K, V>> {
    public ObjectMap$Entry<K, V> entry;

    public ObjectMap$Entries(ObjectMap<K, V> objectMap) {
        super(objectMap);
        this.entry = new ObjectMap$Entry<>();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // java.lang.Iterable
    public Iterator<ObjectMap$Entry<K, V>> iterator() {
        return this;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // com.esotericsoftware.kryo.util.ObjectMap$MapIterator, java.util.Iterator
    public /* bridge */ /* synthetic */ void remove() {
        super.remove();
    }

    @Override // com.esotericsoftware.kryo.util.ObjectMap$MapIterator
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    @Override // java.util.Iterator
    public ObjectMap$Entry<K, V> next() {
        if (!this.hasNext) {
            throw new NoSuchElementException();
        }
        ObjectMap<K, V> objectMap = this.map;
        K[] kArr = objectMap.keyTable;
        ObjectMap$Entry<K, V> objectMap$Entry = this.entry;
        int i = this.nextIndex;
        objectMap$Entry.key = kArr[i];
        objectMap$Entry.value = objectMap.valueTable[i];
        this.currentIndex = i;
        advance();
        return this.entry;
    }
}
