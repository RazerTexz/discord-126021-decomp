package com.esotericsoftware.kryo.util;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class IdentityMap$Keys<K> extends IdentityMap$MapIterator<K, Object> implements Iterable<K>, Iterator<K> {
    public IdentityMap$Keys(IdentityMap<K, ?> identityMap) {
        super(identityMap);
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
        K[] kArr = this.map.keyTable;
        int i = this.nextIndex;
        K k = kArr[i];
        this.currentIndex = i;
        findNextIndex();
        return k;
    }

    @Override // com.esotericsoftware.kryo.util.IdentityMap$MapIterator, java.util.Iterator
    public /* bridge */ /* synthetic */ void remove() {
        super.remove();
    }

    @Override // com.esotericsoftware.kryo.util.IdentityMap$MapIterator
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
