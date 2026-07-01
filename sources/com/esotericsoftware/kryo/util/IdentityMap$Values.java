package com.esotericsoftware.kryo.util;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class IdentityMap$Values<V> extends IdentityMap$MapIterator<Object, V> implements Iterable<V>, Iterator<V> {
    public IdentityMap$Values(IdentityMap<?, V> identityMap) {
        super(identityMap);
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
        V[] vArr = this.map.valueTable;
        int i = this.nextIndex;
        V v = vArr[i];
        this.currentIndex = i;
        findNextIndex();
        return v;
    }

    @Override // com.esotericsoftware.kryo.util.IdentityMap$MapIterator, java.util.Iterator
    public /* bridge */ /* synthetic */ void remove() {
        super.remove();
    }

    @Override // com.esotericsoftware.kryo.util.IdentityMap$MapIterator
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

    public void toArray(ArrayList<V> arrayList) {
        while (this.hasNext) {
            arrayList.add(next());
        }
    }
}
