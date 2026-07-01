package com.esotericsoftware.kryo.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class IdentityMap$Entries<K, V> extends IdentityMap$MapIterator<K, V> implements Iterable<IdentityMap$Entry<K, V>>, Iterator<IdentityMap$Entry<K, V>> {
    private IdentityMap$Entry<K, V> entry;

    public IdentityMap$Entries(IdentityMap<K, V> identityMap) {
        super(identityMap);
        this.entry = new IdentityMap$Entry<>();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // java.lang.Iterable
    public Iterator<IdentityMap$Entry<K, V>> iterator() {
        return this;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // com.esotericsoftware.kryo.util.IdentityMap$MapIterator, java.util.Iterator
    public /* bridge */ /* synthetic */ void remove() {
        super.remove();
    }

    @Override // com.esotericsoftware.kryo.util.IdentityMap$MapIterator
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    @Override // java.util.Iterator
    public IdentityMap$Entry<K, V> next() {
        if (!this.hasNext) {
            throw new NoSuchElementException();
        }
        IdentityMap<K, V> identityMap = this.map;
        K[] kArr = identityMap.keyTable;
        IdentityMap$Entry<K, V> identityMap$Entry = this.entry;
        int i = this.nextIndex;
        identityMap$Entry.key = kArr[i];
        identityMap$Entry.value = identityMap.valueTable[i];
        this.currentIndex = i;
        findNextIndex();
        return this.entry;
    }
}
