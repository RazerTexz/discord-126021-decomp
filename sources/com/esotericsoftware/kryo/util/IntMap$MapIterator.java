package com.esotericsoftware.kryo.util;

/* JADX INFO: loaded from: classes.dex */
public class IntMap$MapIterator<V> {
    public static final int INDEX_ILLEGAL = -2;
    public static final int INDEX_ZERO = -1;
    public int currentIndex;
    public boolean hasNext;
    public final IntMap<V> map;
    public int nextIndex;

    public IntMap$MapIterator(IntMap<V> intMap) {
        this.map = intMap;
        reset();
    }

    public void findNextIndex() {
        int i;
        this.hasNext = false;
        IntMap<V> intMap = this.map;
        int[] iArr = intMap.keyTable;
        int i2 = intMap.capacity + intMap.stashSize;
        do {
            i = this.nextIndex + 1;
            this.nextIndex = i;
            if (i >= i2) {
                return;
            }
        } while (iArr[i] == 0);
        this.hasNext = true;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001a  */
    /* JADX WARN: Code duplicated, block: B:11:0x0027  */
    /* JADX WARN: Code duplicated, block: B:14:0x003b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0012 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public void remove() {
        IntMap<V> intMap;
        int i = this.currentIndex;
        if (i == -1) {
            IntMap<V> intMap2 = this.map;
            if (intMap2.hasZeroValue) {
                intMap2.zeroValue = null;
                intMap2.hasZeroValue = false;
            } else {
                if (i >= 0) {
                    throw new IllegalStateException("next must be called before remove.");
                }
                intMap = this.map;
                if (i >= intMap.capacity) {
                    intMap.removeStashIndex(i);
                    this.nextIndex = this.currentIndex - 1;
                    findNextIndex();
                } else {
                    intMap.keyTable[i] = 0;
                    intMap.valueTable[i] = null;
                }
            }
        } else {
            if (i >= 0) {
                throw new IllegalStateException("next must be called before remove.");
            }
            intMap = this.map;
            if (i >= intMap.capacity) {
                intMap.removeStashIndex(i);
                this.nextIndex = this.currentIndex - 1;
                findNextIndex();
            } else {
                intMap.keyTable[i] = 0;
                intMap.valueTable[i] = null;
            }
        }
        this.currentIndex = -2;
        this.map.size--;
    }

    public void reset() {
        this.currentIndex = -2;
        this.nextIndex = -1;
        if (this.map.hasZeroValue) {
            this.hasNext = true;
        } else {
            findNextIndex();
        }
    }
}
