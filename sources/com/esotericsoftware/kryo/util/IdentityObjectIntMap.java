package com.esotericsoftware.kryo.util;

import b.d.b.a.outline;

/* JADX INFO: loaded from: classes.dex */
public class IdentityObjectIntMap<K> {
    private static final int PRIME2 = -1105259343;
    private static final int PRIME3 = -1262997959;
    private static final int PRIME4 = -825114047;
    public int capacity;
    private int hashShift;
    private boolean isBigTable;
    public K[] keyTable;
    private float loadFactor;
    private int mask;
    private int pushIterations;
    public int size;
    private int stashCapacity;
    public int stashSize;
    private int threshold;
    public int[] valueTable;

    public IdentityObjectIntMap() {
        this(32, 0.8f);
    }

    private boolean containsKeyStash(K k) {
        K[] kArr = this.keyTable;
        int i = this.capacity;
        int i2 = this.stashSize + i;
        while (i < i2) {
            if (k == kArr[i]) {
                return true;
            }
            i++;
        }
        return false;
    }

    private int getAndIncrementStash(K k, int i, int i2) {
        K[] kArr = this.keyTable;
        int i3 = this.capacity;
        int i4 = this.stashSize + i3;
        while (i3 < i4) {
            if (k == kArr[i3]) {
                int[] iArr = this.valueTable;
                int i5 = iArr[i3];
                iArr[i3] = i2 + i5;
                return i5;
            }
            i3++;
        }
        put(k, i2 + i);
        return i;
    }

    private int getStash(K k, int i) {
        K[] kArr = this.keyTable;
        int i2 = this.capacity;
        int i3 = this.stashSize + i2;
        while (i2 < i3) {
            if (k == kArr[i2]) {
                return this.valueTable[i2];
            }
            i2++;
        }
        return i;
    }

    private int hash2(int i) {
        int i2 = i * PRIME2;
        return (i2 ^ (i2 >>> this.hashShift)) & this.mask;
    }

    private int hash3(int i) {
        int i2 = i * PRIME3;
        return (i2 ^ (i2 >>> this.hashShift)) & this.mask;
    }

    private int hash4(int i) {
        int i2 = i * PRIME4;
        return (i2 ^ (i2 >>> this.hashShift)) & this.mask;
    }

    private void push(K k, int i, int i2, K k2, int i3, K k3, int i4, K k4, int i5, K k5) {
        K[] kArr = this.keyTable;
        int[] iArr = this.valueTable;
        int i6 = this.mask;
        boolean z2 = this.isBigTable;
        int i7 = this.pushIterations;
        int i8 = z2 ? 4 : 3;
        K k6 = k;
        int i9 = i;
        int i10 = i2;
        K k7 = k2;
        int i11 = i3;
        K k8 = k3;
        int i12 = i4;
        K k9 = k4;
        int i13 = i5;
        K k10 = k5;
        int i14 = 0;
        while (true) {
            int iNextInt = ObjectMap.random.nextInt(i8);
            int i15 = i8;
            if (iNextInt == 0) {
                int i16 = iArr[i10];
                kArr[i10] = k6;
                iArr[i10] = i9;
                k6 = k7;
                i9 = i16;
            } else if (iNextInt == 1) {
                int i17 = iArr[i11];
                kArr[i11] = k6;
                iArr[i11] = i9;
                i9 = i17;
                k6 = k8;
            } else if (iNextInt != 2) {
                int i18 = iArr[i13];
                kArr[i13] = k6;
                iArr[i13] = i9;
                i9 = i18;
                k6 = k10;
            } else {
                int i19 = iArr[i12];
                kArr[i12] = k6;
                iArr[i12] = i9;
                i9 = i19;
                k6 = k9;
            }
            int iIdentityHashCode = System.identityHashCode(k6);
            int i20 = iIdentityHashCode & i6;
            K k11 = kArr[i20];
            if (k11 == null) {
                kArr[i20] = k6;
                iArr[i20] = i9;
                int i21 = this.size;
                this.size = i21 + 1;
                if (i21 >= this.threshold) {
                    resize(this.capacity << 1);
                    return;
                }
                return;
            }
            int iHash2 = hash2(iIdentityHashCode);
            K k12 = kArr[iHash2];
            if (k12 == null) {
                kArr[iHash2] = k6;
                iArr[iHash2] = i9;
                int i22 = this.size;
                this.size = i22 + 1;
                if (i22 >= this.threshold) {
                    resize(this.capacity << 1);
                    return;
                }
                return;
            }
            int iHash3 = hash3(iIdentityHashCode);
            K k13 = kArr[iHash3];
            if (k13 == null) {
                kArr[iHash3] = k6;
                iArr[iHash3] = i9;
                int i23 = this.size;
                this.size = i23 + 1;
                if (i23 >= this.threshold) {
                    resize(this.capacity << 1);
                    return;
                }
                return;
            }
            if (z2) {
                int iHash4 = hash4(iIdentityHashCode);
                K k14 = kArr[iHash4];
                if (k14 == null) {
                    kArr[iHash4] = k6;
                    iArr[iHash4] = i9;
                    int i24 = this.size;
                    this.size = i24 + 1;
                    if (i24 >= this.threshold) {
                        resize(this.capacity << 1);
                        return;
                    }
                    return;
                }
                k10 = k14;
                i13 = iHash4;
            }
            int i25 = i14 + 1;
            if (i25 == i7) {
                putStash(k6, i9);
                return;
            }
            i14 = i25;
            i10 = i20;
            k7 = k11;
            i11 = iHash2;
            k8 = k12;
            i12 = iHash3;
            i8 = i15;
            k9 = k13;
        }
    }

    private void putResize(K k, int i) {
        K k2;
        int i2;
        int iIdentityHashCode = System.identityHashCode(k);
        int i3 = iIdentityHashCode & this.mask;
        K[] kArr = this.keyTable;
        K k3 = kArr[i3];
        if (k3 == null) {
            kArr[i3] = k;
            this.valueTable[i3] = i;
            int i4 = this.size;
            this.size = i4 + 1;
            if (i4 >= this.threshold) {
                resize(this.capacity << 1);
                return;
            }
            return;
        }
        int iHash2 = hash2(iIdentityHashCode);
        K[] kArr2 = this.keyTable;
        K k4 = kArr2[iHash2];
        if (k4 == null) {
            kArr2[iHash2] = k;
            this.valueTable[iHash2] = i;
            int i5 = this.size;
            this.size = i5 + 1;
            if (i5 >= this.threshold) {
                resize(this.capacity << 1);
                return;
            }
            return;
        }
        int iHash3 = hash3(iIdentityHashCode);
        K[] kArr3 = this.keyTable;
        K k5 = kArr3[iHash3];
        if (k5 == null) {
            kArr3[iHash3] = k;
            this.valueTable[iHash3] = i;
            int i6 = this.size;
            this.size = i6 + 1;
            if (i6 >= this.threshold) {
                resize(this.capacity << 1);
                return;
            }
            return;
        }
        if (this.isBigTable) {
            int iHash4 = hash4(iIdentityHashCode);
            K[] kArr4 = this.keyTable;
            K k6 = kArr4[iHash4];
            if (k6 == null) {
                kArr4[iHash4] = k;
                this.valueTable[iHash4] = i;
                int i7 = this.size;
                this.size = i7 + 1;
                if (i7 >= this.threshold) {
                    resize(this.capacity << 1);
                    return;
                }
                return;
            }
            i2 = iHash4;
            k2 = k6;
        } else {
            k2 = null;
            i2 = -1;
        }
        push(k, i, i3, k3, iHash2, k4, iHash3, k5, i2, k2);
    }

    private void putStash(K k, int i) {
        int i2 = this.stashSize;
        if (i2 == this.stashCapacity) {
            resize(this.capacity << 1);
            put(k, i);
            return;
        }
        int i3 = this.capacity + i2;
        this.keyTable[i3] = k;
        this.valueTable[i3] = i;
        this.stashSize = i2 + 1;
        this.size++;
    }

    private void resize(int i) {
        int i2 = this.capacity + this.stashSize;
        this.capacity = i;
        this.threshold = (int) (i * this.loadFactor);
        this.mask = i - 1;
        this.hashShift = 31 - Integer.numberOfTrailingZeros(i);
        double d = i;
        this.stashCapacity = Math.max(3, ((int) Math.ceil(Math.log(d))) * 2);
        this.pushIterations = Math.max(Math.min(i, 8), ((int) Math.sqrt(d)) / 8);
        this.isBigTable = (this.capacity >>> 16) != 0;
        K[] kArr = this.keyTable;
        int[] iArr = this.valueTable;
        int i3 = this.stashCapacity;
        this.keyTable = (K[]) new Object[i + i3];
        this.valueTable = new int[i + i3];
        int i4 = this.size;
        this.size = 0;
        this.stashSize = 0;
        if (i4 > 0) {
            for (int i5 = 0; i5 < i2; i5++) {
                K k = kArr[i5];
                if (k != null) {
                    putResize(k, iArr[i5]);
                }
            }
        }
    }

    public void clear(int i) {
        if (this.capacity <= i) {
            clear();
        } else {
            this.size = 0;
            resize(i);
        }
    }

    public boolean containsKey(K k) {
        int iIdentityHashCode = System.identityHashCode(k);
        if (k == this.keyTable[this.mask & iIdentityHashCode]) {
            return true;
        }
        if (k == this.keyTable[hash2(iIdentityHashCode)]) {
            return true;
        }
        if (k == this.keyTable[hash3(iIdentityHashCode)]) {
            return true;
        }
        if (!this.isBigTable) {
            return containsKeyStash(k);
        }
        if (k != this.keyTable[hash4(iIdentityHashCode)]) {
            return containsKeyStash(k);
        }
        return true;
    }

    public boolean containsValue(int i) {
        K[] kArr = this.keyTable;
        int[] iArr = this.valueTable;
        int i2 = this.capacity + this.stashSize;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                return false;
            }
            if (kArr[i3] != null && iArr[i3] == i) {
                return true;
            }
            i2 = i3;
        }
    }

    public void ensureCapacity(int i) {
        int i2 = this.size + i;
        if (i2 >= this.threshold) {
            resize(ObjectMap.nextPowerOfTwo((int) (i2 / this.loadFactor)));
        }
    }

    public K findKey(int i) {
        K[] kArr = this.keyTable;
        int[] iArr = this.valueTable;
        int i2 = this.capacity + this.stashSize;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                return null;
            }
            if (kArr[i3] != null && iArr[i3] == i) {
                return kArr[i3];
            }
            i2 = i3;
        }
    }

    public int get(K k, int i) {
        int iIdentityHashCode = System.identityHashCode(k);
        int iHash2 = this.mask & iIdentityHashCode;
        if (k != this.keyTable[iHash2]) {
            iHash2 = hash2(iIdentityHashCode);
            if (k != this.keyTable[iHash2]) {
                iHash2 = hash3(iIdentityHashCode);
                if (k != this.keyTable[iHash2]) {
                    if (!this.isBigTable) {
                        return getStash(k, i);
                    }
                    iHash2 = hash4(iIdentityHashCode);
                    if (k != this.keyTable[iHash2]) {
                        return getStash(k, i);
                    }
                }
            }
        }
        return this.valueTable[iHash2];
    }

    public int getAndIncrement(K k, int i, int i2) {
        int iIdentityHashCode = System.identityHashCode(k);
        int iHash2 = this.mask & iIdentityHashCode;
        if (k != this.keyTable[iHash2]) {
            iHash2 = hash2(iIdentityHashCode);
            if (k != this.keyTable[iHash2]) {
                iHash2 = hash3(iIdentityHashCode);
                if (k != this.keyTable[iHash2]) {
                    if (!this.isBigTable) {
                        return getAndIncrementStash(k, i, i2);
                    }
                    iHash2 = hash4(iIdentityHashCode);
                    if (k != this.keyTable[iHash2]) {
                        return getAndIncrementStash(k, i, i2);
                    }
                }
            }
        }
        int[] iArr = this.valueTable;
        int i3 = iArr[iHash2];
        iArr[iHash2] = i2 + i3;
        return i3;
    }

    public void put(K k, int i) {
        K k2;
        int i2;
        if (k == null) {
            throw new IllegalArgumentException("key cannot be null.");
        }
        K[] kArr = this.keyTable;
        int i3 = this.mask;
        boolean z2 = this.isBigTable;
        int iIdentityHashCode = System.identityHashCode(k);
        int i4 = iIdentityHashCode & i3;
        K k3 = kArr[i4];
        if (k == k3) {
            this.valueTable[i4] = i;
            return;
        }
        int iHash2 = hash2(iIdentityHashCode);
        K k4 = kArr[iHash2];
        if (k == k4) {
            this.valueTable[iHash2] = i;
            return;
        }
        int iHash3 = hash3(iIdentityHashCode);
        K k5 = kArr[iHash3];
        if (k == k5) {
            this.valueTable[iHash3] = i;
            return;
        }
        if (z2) {
            int iHash4 = hash4(iIdentityHashCode);
            K k6 = kArr[iHash4];
            if (k == k6) {
                this.valueTable[iHash4] = i;
                return;
            } else {
                i2 = iHash4;
                k2 = k6;
            }
        } else {
            k2 = null;
            i2 = -1;
        }
        int i5 = this.capacity;
        int i6 = this.stashSize + i5;
        while (i5 < i6) {
            if (kArr[i5] == k) {
                this.valueTable[i5] = i;
                return;
            }
            i5++;
        }
        if (k3 == null) {
            kArr[i4] = k;
            this.valueTable[i4] = i;
            int i7 = this.size;
            this.size = i7 + 1;
            if (i7 >= this.threshold) {
                resize(this.capacity << 1);
                return;
            }
            return;
        }
        if (k4 == null) {
            kArr[iHash2] = k;
            this.valueTable[iHash2] = i;
            int i8 = this.size;
            this.size = i8 + 1;
            if (i8 >= this.threshold) {
                resize(this.capacity << 1);
                return;
            }
            return;
        }
        if (k5 == null) {
            kArr[iHash3] = k;
            this.valueTable[iHash3] = i;
            int i9 = this.size;
            this.size = i9 + 1;
            if (i9 >= this.threshold) {
                resize(this.capacity << 1);
                return;
            }
            return;
        }
        if (!z2 || k2 != null) {
            push(k, i, i4, k3, iHash2, k4, iHash3, k5, i2, k2);
            return;
        }
        kArr[i2] = k;
        this.valueTable[i2] = i;
        int i10 = this.size;
        this.size = i10 + 1;
        if (i10 >= this.threshold) {
            resize(this.capacity << 1);
        }
    }

    public int remove(K k, int i) {
        int iIdentityHashCode = System.identityHashCode(k);
        int i2 = this.mask & iIdentityHashCode;
        K[] kArr = this.keyTable;
        if (k == kArr[i2]) {
            kArr[i2] = null;
            int i3 = this.valueTable[i2];
            this.size--;
            return i3;
        }
        int iHash2 = hash2(iIdentityHashCode);
        K[] kArr2 = this.keyTable;
        if (k == kArr2[iHash2]) {
            kArr2[iHash2] = null;
            int i4 = this.valueTable[iHash2];
            this.size--;
            return i4;
        }
        int iHash3 = hash3(iIdentityHashCode);
        K[] kArr3 = this.keyTable;
        if (k == kArr3[iHash3]) {
            kArr3[iHash3] = null;
            int i5 = this.valueTable[iHash3];
            this.size--;
            return i5;
        }
        if (this.isBigTable) {
            int iHash4 = hash4(iIdentityHashCode);
            K[] kArr4 = this.keyTable;
            if (k == kArr4[iHash4]) {
                kArr4[iHash4] = null;
                int i6 = this.valueTable[iHash4];
                this.size--;
                return i6;
            }
        }
        return removeStash(k, i);
    }

    public int removeStash(K k, int i) {
        K[] kArr = this.keyTable;
        int i2 = this.capacity;
        int i3 = this.stashSize + i2;
        while (i2 < i3) {
            if (k == kArr[i2]) {
                int i4 = this.valueTable[i2];
                removeStashIndex(i2);
                this.size--;
                return i4;
            }
            i2++;
        }
        return i;
    }

    public void removeStashIndex(int i) {
        int i2 = this.stashSize - 1;
        this.stashSize = i2;
        int i3 = this.capacity + i2;
        if (i < i3) {
            K[] kArr = this.keyTable;
            kArr[i] = kArr[i3];
            int[] iArr = this.valueTable;
            iArr[i] = iArr[i3];
        }
    }

    public void shrink(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(outline.q("maximumCapacity must be >= 0: ", i));
        }
        int i2 = this.size;
        if (i2 > i) {
            i = i2;
        }
        if (this.capacity <= i) {
            return;
        }
        resize(ObjectMap.nextPowerOfTwo(i));
    }

    public String toString() {
        int i;
        if (this.size == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append('{');
        K[] kArr = this.keyTable;
        int[] iArr = this.valueTable;
        int length = kArr.length;
        while (true) {
            i = length - 1;
            if (length > 0) {
                K k = kArr[i];
                if (k != null) {
                    sb.append(k);
                    sb.append('=');
                    sb.append(iArr[i]);
                    break;
                }
                length = i;
            } else {
                break;
            }
        }
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                sb.append('}');
                return sb.toString();
            }
            K k2 = kArr[i2];
            if (k2 != null) {
                sb.append(", ");
                sb.append(k2);
                sb.append('=');
                sb.append(iArr[i2]);
            }
            i = i2;
        }
    }

    public IdentityObjectIntMap(int i) {
        this(i, 0.8f);
    }

    public IdentityObjectIntMap(int i, float f) {
        if (i >= 0) {
            if (this.capacity <= 1073741824) {
                int iNextPowerOfTwo = ObjectMap.nextPowerOfTwo(i);
                this.capacity = iNextPowerOfTwo;
                if (f > 0.0f) {
                    this.loadFactor = f;
                    this.isBigTable = (iNextPowerOfTwo >>> 16) != 0;
                    this.threshold = (int) (iNextPowerOfTwo * f);
                    this.mask = iNextPowerOfTwo - 1;
                    this.hashShift = 31 - Integer.numberOfTrailingZeros(iNextPowerOfTwo);
                    this.stashCapacity = Math.max(3, ((int) Math.ceil(Math.log(this.capacity))) * 2);
                    this.pushIterations = Math.max(Math.min(this.capacity, 8), ((int) Math.sqrt(this.capacity)) / 8);
                    K[] kArr = (K[]) new Object[this.capacity + this.stashCapacity];
                    this.keyTable = kArr;
                    this.valueTable = new int[kArr.length];
                    return;
                }
                throw new IllegalArgumentException("loadFactor must be > 0: " + f);
            }
            throw new IllegalArgumentException(outline.q("initialCapacity is too large: ", i));
        }
        throw new IllegalArgumentException(outline.q("initialCapacity must be >= 0: ", i));
    }

    public void clear() {
        K[] kArr = this.keyTable;
        int i = this.capacity + this.stashSize;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                kArr[i2] = null;
                i = i2;
            } else {
                this.size = 0;
                this.stashSize = 0;
                return;
            }
        }
    }
}
