package com.esotericsoftware.kryo.util;

/* JADX INFO: loaded from: classes.dex */
public class IdentityMap$MapIterator<K, V> {
    public int currentIndex;
    public boolean hasNext;
    public final IdentityMap<K, V> map;
    public int nextIndex;

    public IdentityMap$MapIterator(IdentityMap<K, V> identityMap) {
        this.map = identityMap;
        reset();
    }

    public void findNextIndex() {
        int i;
        this.hasNext = false;
        IdentityMap<K, V> identityMap = this.map;
        K[] kArr = identityMap.keyTable;
        int i2 = identityMap.capacity + identityMap.stashSize;
        do {
            i = this.nextIndex + 1;
            this.nextIndex = i;
            if (i >= i2) {
                return;
            }
        } while (kArr[i] == null);
        this.hasNext = true;
    }

    public void remove() {
        int i = this.currentIndex;
        if (i < 0) {
            throw new IllegalStateException("next must be called before remove.");
        }
        IdentityMap<K, V> identityMap = this.map;
        if (i >= identityMap.capacity) {
            identityMap.removeStashIndex(i);
            this.nextIndex = this.currentIndex - 1;
            findNextIndex();
        } else {
            identityMap.keyTable[i] = null;
            identityMap.valueTable[i] = null;
        }
        this.currentIndex = -1;
        this.map.size--;
    }

    public void reset() {
        this.currentIndex = -1;
        this.nextIndex = -1;
        findNextIndex();
    }
}
