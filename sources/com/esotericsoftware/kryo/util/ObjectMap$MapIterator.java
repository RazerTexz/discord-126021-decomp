package com.esotericsoftware.kryo.util;

/* JADX INFO: loaded from: classes.dex */
public class ObjectMap$MapIterator<K, V> {
    public int currentIndex;
    public boolean hasNext;
    public final ObjectMap<K, V> map;
    public int nextIndex;

    public ObjectMap$MapIterator(ObjectMap<K, V> objectMap) {
        this.map = objectMap;
        reset();
    }

    public void advance() {
        int i;
        this.hasNext = false;
        ObjectMap<K, V> objectMap = this.map;
        K[] kArr = objectMap.keyTable;
        int i2 = objectMap.capacity + objectMap.stashSize;
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
        ObjectMap<K, V> objectMap = this.map;
        if (i >= objectMap.capacity) {
            objectMap.removeStashIndex(i);
            this.nextIndex = this.currentIndex - 1;
            advance();
        } else {
            objectMap.keyTable[i] = null;
            objectMap.valueTable[i] = null;
        }
        this.currentIndex = -1;
        this.map.size--;
    }

    public void reset() {
        this.currentIndex = -1;
        this.nextIndex = -1;
        advance();
    }
}
