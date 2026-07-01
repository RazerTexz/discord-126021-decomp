package com.esotericsoftware.kryo.util;

import b.d.b.a.outline;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class ObjectMap<K, V> {
    private static final int PRIME2 = -1105259343;
    private static final int PRIME3 = -1262997959;
    private static final int PRIME4 = -825114047;
    public static Random random = new Random();
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
    public V[] valueTable;

    public static class Entries<K, V> extends MapIterator<K, V> implements Iterable<Entry<K, V>>, Iterator<Entry<K, V>> {
        public Entry<K, V> entry;

        public Entries(ObjectMap<K, V> objectMap) {
            super(objectMap);
            this.entry = new Entry<>();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override // java.lang.Iterable
        public Iterator<Entry<K, V>> iterator() {
            return this;
        }

        @Override // com.esotericsoftware.kryo.util.ObjectMap.MapIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            super.remove();
        }

        @Override // com.esotericsoftware.kryo.util.ObjectMap.MapIterator
        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        @Override // java.util.Iterator
        public Entry<K, V> next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            ObjectMap<K, V> objectMap = this.map;
            K[] kArr = objectMap.keyTable;
            Entry<K, V> entry = this.entry;
            int i = this.nextIndex;
            entry.key = kArr[i];
            entry.value = objectMap.valueTable[i];
            this.currentIndex = i;
            advance();
            return this.entry;
        }
    }

    public static class Entry<K, V> {
        public K key;
        public V value;

        public String toString() {
            return this.key + "=" + this.value;
        }
    }

    public static class Keys<K> extends MapIterator<K, Object> implements Iterable<K>, Iterator<K> {
        public Keys(ObjectMap<K, ?> objectMap) {
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

        @Override // com.esotericsoftware.kryo.util.ObjectMap.MapIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            super.remove();
        }

        @Override // com.esotericsoftware.kryo.util.ObjectMap.MapIterator
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

    public static class MapIterator<K, V> {
        public int currentIndex;
        public boolean hasNext;
        public final ObjectMap<K, V> map;
        public int nextIndex;

        public MapIterator(ObjectMap<K, V> objectMap) {
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

    public ObjectMap() {
        this(32, 0.8f);
    }

    private boolean containsKeyStash(K k) {
        K[] kArr = this.keyTable;
        int i = this.capacity;
        int i2 = this.stashSize + i;
        while (i < i2) {
            if (k.equals(kArr[i])) {
                return true;
            }
            i++;
        }
        return false;
    }

    private V getStash(K k) {
        K[] kArr = this.keyTable;
        int i = this.capacity;
        int i2 = this.stashSize + i;
        while (i < i2) {
            if (k.equals(kArr[i])) {
                return this.valueTable[i];
            }
            i++;
        }
        return null;
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

    public static int nextPowerOfTwo(int i) {
        if (i == 0) {
            return 1;
        }
        int i2 = i - 1;
        int i3 = i2 | (i2 >> 1);
        int i4 = i3 | (i3 >> 2);
        int i5 = i4 | (i4 >> 4);
        int i6 = i5 | (i5 >> 8);
        return (i6 | (i6 >> 16)) + 1;
    }

    private void push(K k, V v, int i, K k2, int i2, K k3, int i3, K k4, int i4, K k5) {
        K[] kArr = this.keyTable;
        V[] vArr = this.valueTable;
        int i5 = this.mask;
        boolean z2 = this.isBigTable;
        int i6 = this.pushIterations;
        int i7 = z2 ? 4 : 3;
        K k6 = k;
        V v2 = v;
        int i8 = i;
        K k7 = k2;
        int i9 = i2;
        K k8 = k3;
        int i10 = i3;
        K k9 = k4;
        int i11 = i4;
        K k10 = k5;
        int i12 = 0;
        while (true) {
            int iNextInt = random.nextInt(i7);
            int i13 = i7;
            if (iNextInt == 0) {
                V v3 = vArr[i8];
                kArr[i8] = k6;
                vArr[i8] = v2;
                k6 = k7;
                v2 = v3;
            } else if (iNextInt == 1) {
                V v4 = vArr[i9];
                kArr[i9] = k6;
                vArr[i9] = v2;
                v2 = v4;
                k6 = k8;
            } else if (iNextInt != 2) {
                V v5 = vArr[i11];
                kArr[i11] = k6;
                vArr[i11] = v2;
                v2 = v5;
                k6 = k10;
            } else {
                V v6 = vArr[i10];
                kArr[i10] = k6;
                vArr[i10] = v2;
                v2 = v6;
                k6 = k9;
            }
            int iHashCode = k6.hashCode();
            int i14 = iHashCode & i5;
            K k11 = kArr[i14];
            if (k11 == null) {
                kArr[i14] = k6;
                vArr[i14] = v2;
                int i15 = this.size;
                this.size = i15 + 1;
                if (i15 >= this.threshold) {
                    resize(this.capacity << 1);
                    return;
                }
                return;
            }
            int iHash2 = hash2(iHashCode);
            K k12 = kArr[iHash2];
            if (k12 == null) {
                kArr[iHash2] = k6;
                vArr[iHash2] = v2;
                int i16 = this.size;
                this.size = i16 + 1;
                if (i16 >= this.threshold) {
                    resize(this.capacity << 1);
                    return;
                }
                return;
            }
            int iHash3 = hash3(iHashCode);
            K k13 = kArr[iHash3];
            if (k13 == null) {
                kArr[iHash3] = k6;
                vArr[iHash3] = v2;
                int i17 = this.size;
                this.size = i17 + 1;
                if (i17 >= this.threshold) {
                    resize(this.capacity << 1);
                    return;
                }
                return;
            }
            if (z2) {
                int iHash4 = hash4(iHashCode);
                K k14 = kArr[iHash4];
                if (k14 == null) {
                    kArr[iHash4] = k6;
                    vArr[iHash4] = v2;
                    int i18 = this.size;
                    this.size = i18 + 1;
                    if (i18 >= this.threshold) {
                        resize(this.capacity << 1);
                        return;
                    }
                    return;
                }
                k10 = k14;
                i11 = iHash4;
            }
            int i19 = i12 + 1;
            if (i19 == i6) {
                putStash(k6, v2);
                return;
            }
            i12 = i19;
            i8 = i14;
            k7 = k11;
            i9 = iHash2;
            k8 = k12;
            i10 = iHash3;
            i7 = i13;
            k9 = k13;
        }
    }

    private void putResize(K k, V v) {
        K k2;
        int i;
        int iHashCode = k.hashCode();
        int i2 = iHashCode & this.mask;
        K[] kArr = this.keyTable;
        K k3 = kArr[i2];
        if (k3 == null) {
            kArr[i2] = k;
            this.valueTable[i2] = v;
            int i3 = this.size;
            this.size = i3 + 1;
            if (i3 >= this.threshold) {
                resize(this.capacity << 1);
                return;
            }
            return;
        }
        int iHash2 = hash2(iHashCode);
        K[] kArr2 = this.keyTable;
        K k4 = kArr2[iHash2];
        if (k4 == null) {
            kArr2[iHash2] = k;
            this.valueTable[iHash2] = v;
            int i4 = this.size;
            this.size = i4 + 1;
            if (i4 >= this.threshold) {
                resize(this.capacity << 1);
                return;
            }
            return;
        }
        int iHash3 = hash3(iHashCode);
        K[] kArr3 = this.keyTable;
        K k5 = kArr3[iHash3];
        if (k5 == null) {
            kArr3[iHash3] = k;
            this.valueTable[iHash3] = v;
            int i5 = this.size;
            this.size = i5 + 1;
            if (i5 >= this.threshold) {
                resize(this.capacity << 1);
                return;
            }
            return;
        }
        if (this.isBigTable) {
            int iHash4 = hash4(iHashCode);
            K[] kArr4 = this.keyTable;
            K k6 = kArr4[iHash4];
            if (k6 == null) {
                kArr4[iHash4] = k;
                this.valueTable[iHash4] = v;
                int i6 = this.size;
                this.size = i6 + 1;
                if (i6 >= this.threshold) {
                    resize(this.capacity << 1);
                    return;
                }
                return;
            }
            i = iHash4;
            k2 = k6;
        } else {
            k2 = null;
            i = -1;
        }
        push(k, v, i2, k3, iHash2, k4, iHash3, k5, i, k2);
    }

    private void putStash(K k, V v) {
        int i = this.stashSize;
        if (i == this.stashCapacity) {
            resize(this.capacity << 1);
            put_internal(k, v);
            return;
        }
        int i2 = this.capacity + i;
        this.keyTable[i2] = k;
        this.valueTable[i2] = v;
        this.stashSize = i + 1;
        this.size++;
    }

    private V put_internal(K k, V v) {
        Object obj;
        int i;
        Object[] objArr = this.keyTable;
        int i2 = this.mask;
        boolean z2 = this.isBigTable;
        int iHashCode = k.hashCode();
        int i3 = iHashCode & i2;
        K k2 = objArr[i3];
        if (k.equals(k2)) {
            V[] vArr = this.valueTable;
            V v2 = vArr[i3];
            vArr[i3] = v;
            return v2;
        }
        int iHash2 = hash2(iHashCode);
        K k3 = objArr[iHash2];
        if (k.equals(k3)) {
            V[] vArr2 = this.valueTable;
            V v3 = vArr2[iHash2];
            vArr2[iHash2] = v;
            return v3;
        }
        int iHash3 = hash3(iHashCode);
        K k4 = objArr[iHash3];
        if (k.equals(k4)) {
            V[] vArr3 = this.valueTable;
            V v4 = vArr3[iHash3];
            vArr3[iHash3] = v;
            return v4;
        }
        if (z2) {
            int iHash4 = hash4(iHashCode);
            Object obj2 = objArr[iHash4];
            if (k.equals(obj2)) {
                V[] vArr4 = this.valueTable;
                V v5 = vArr4[iHash4];
                vArr4[iHash4] = v;
                return v5;
            }
            i = iHash4;
            obj = obj2;
        } else {
            obj = null;
            i = -1;
        }
        int i4 = this.capacity;
        int i5 = this.stashSize + i4;
        while (i4 < i5) {
            if (k.equals(objArr[i4])) {
                V[] vArr5 = this.valueTable;
                V v6 = vArr5[i4];
                vArr5[i4] = v;
                return v6;
            }
            i4++;
        }
        if (k2 == null) {
            objArr[i3] = k;
            this.valueTable[i3] = v;
            int i6 = this.size;
            this.size = i6 + 1;
            if (i6 >= this.threshold) {
                resize(this.capacity << 1);
            }
            return null;
        }
        if (k3 == null) {
            objArr[iHash2] = k;
            this.valueTable[iHash2] = v;
            int i7 = this.size;
            this.size = i7 + 1;
            if (i7 >= this.threshold) {
                resize(this.capacity << 1);
            }
            return null;
        }
        if (k4 == null) {
            objArr[iHash3] = k;
            this.valueTable[iHash3] = v;
            int i8 = this.size;
            this.size = i8 + 1;
            if (i8 >= this.threshold) {
                resize(this.capacity << 1);
            }
            return null;
        }
        if (!z2 || obj != null) {
            push(k, v, i3, k2, iHash2, k3, iHash3, k4, i, obj);
            return null;
        }
        objArr[i] = k;
        this.valueTable[i] = v;
        int i9 = this.size;
        this.size = i9 + 1;
        if (i9 >= this.threshold) {
            resize(this.capacity << 1);
        }
        return null;
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
        V[] vArr = this.valueTable;
        int i3 = this.stashCapacity;
        this.keyTable = (K[]) new Object[i + i3];
        this.valueTable = (V[]) new Object[i + i3];
        int i4 = this.size;
        this.size = 0;
        this.stashSize = 0;
        if (i4 > 0) {
            for (int i5 = 0; i5 < i2; i5++) {
                K k = kArr[i5];
                if (k != null) {
                    putResize(k, vArr[i5]);
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
        int iHashCode = k.hashCode();
        if (k.equals(this.keyTable[this.mask & iHashCode])) {
            return true;
        }
        if (k.equals(this.keyTable[hash2(iHashCode)])) {
            return true;
        }
        if (k.equals(this.keyTable[hash3(iHashCode)])) {
            return true;
        }
        if (!this.isBigTable) {
            return containsKeyStash(k);
        }
        if (k.equals(this.keyTable[hash4(iHashCode)])) {
            return true;
        }
        return containsKeyStash(k);
    }

    public boolean containsValue(Object obj, boolean z2) {
        V[] vArr = this.valueTable;
        if (obj == null) {
            K[] kArr = this.keyTable;
            int i = this.capacity + this.stashSize;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    return false;
                }
                if (kArr[i2] != null && vArr[i2] == null) {
                    return true;
                }
                i = i2;
            }
        } else if (z2) {
            int i3 = this.capacity + this.stashSize;
            while (true) {
                int i4 = i3 - 1;
                if (i3 <= 0) {
                    return false;
                }
                if (vArr[i4] == obj) {
                    return true;
                }
                i3 = i4;
            }
        } else {
            int i5 = this.capacity + this.stashSize;
            while (true) {
                int i6 = i5 - 1;
                if (i5 <= 0) {
                    return false;
                }
                if (obj.equals(vArr[i6])) {
                    return true;
                }
                i5 = i6;
            }
        }
    }

    public void ensureCapacity(int i) {
        int i2 = this.size + i;
        if (i2 >= this.threshold) {
            resize(nextPowerOfTwo((int) (i2 / this.loadFactor)));
        }
    }

    public Entries<K, V> entries() {
        return new Entries<>(this);
    }

    public K findKey(Object obj, boolean z2) {
        V[] vArr = this.valueTable;
        if (obj == null) {
            K[] kArr = this.keyTable;
            int i = this.capacity + this.stashSize;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    return null;
                }
                if (kArr[i2] != null && vArr[i2] == null) {
                    return kArr[i2];
                }
                i = i2;
            }
        } else if (z2) {
            int i3 = this.capacity + this.stashSize;
            while (true) {
                int i4 = i3 - 1;
                if (i3 <= 0) {
                    return null;
                }
                if (vArr[i4] == obj) {
                    return this.keyTable[i4];
                }
                i3 = i4;
            }
        } else {
            int i5 = this.capacity + this.stashSize;
            while (true) {
                int i6 = i5 - 1;
                if (i5 <= 0) {
                    return null;
                }
                if (obj.equals(vArr[i6])) {
                    return this.keyTable[i6];
                }
                i5 = i6;
            }
        }
    }

    public V get(K k) {
        int iHashCode = k.hashCode();
        int iHash2 = this.mask & iHashCode;
        if (!k.equals(this.keyTable[iHash2])) {
            iHash2 = hash2(iHashCode);
            if (!k.equals(this.keyTable[iHash2])) {
                iHash2 = hash3(iHashCode);
                if (!k.equals(this.keyTable[iHash2])) {
                    if (!this.isBigTable) {
                        return getStash(k);
                    }
                    iHash2 = hash4(iHashCode);
                    if (!k.equals(this.keyTable[iHash2])) {
                        return getStash(k);
                    }
                }
            }
        }
        return this.valueTable[iHash2];
    }

    public Keys<K> keys() {
        return new Keys<>(this);
    }

    public V put(K k, V v) {
        if (k != null) {
            return put_internal(k, v);
        }
        throw new IllegalArgumentException("key cannot be null.");
    }

    public void putAll(ObjectMap<K, V> objectMap) {
        ensureCapacity(objectMap.size);
        for (Entry<K, V> entry : objectMap.entries()) {
            put(entry.key, entry.value);
        }
    }

    public V remove(K k) {
        int iHashCode = k.hashCode();
        int i = this.mask & iHashCode;
        if (k.equals(this.keyTable[i])) {
            this.keyTable[i] = null;
            V[] vArr = this.valueTable;
            V v = vArr[i];
            vArr[i] = null;
            this.size--;
            return v;
        }
        int iHash2 = hash2(iHashCode);
        if (k.equals(this.keyTable[iHash2])) {
            this.keyTable[iHash2] = null;
            V[] vArr2 = this.valueTable;
            V v2 = vArr2[iHash2];
            vArr2[iHash2] = null;
            this.size--;
            return v2;
        }
        int iHash3 = hash3(iHashCode);
        if (k.equals(this.keyTable[iHash3])) {
            this.keyTable[iHash3] = null;
            V[] vArr3 = this.valueTable;
            V v3 = vArr3[iHash3];
            vArr3[iHash3] = null;
            this.size--;
            return v3;
        }
        if (this.isBigTable) {
            int iHash4 = hash4(iHashCode);
            if (k.equals(this.keyTable[iHash4])) {
                this.keyTable[iHash4] = null;
                V[] vArr4 = this.valueTable;
                V v4 = vArr4[iHash4];
                vArr4[iHash4] = null;
                this.size--;
                return v4;
            }
        }
        return removeStash(k);
    }

    public V removeStash(K k) {
        K[] kArr = this.keyTable;
        int i = this.capacity;
        int i2 = this.stashSize + i;
        while (i < i2) {
            if (k.equals(kArr[i])) {
                V v = this.valueTable[i];
                removeStashIndex(i);
                this.size--;
                return v;
            }
            i++;
        }
        return null;
    }

    public void removeStashIndex(int i) {
        int i2 = this.stashSize - 1;
        this.stashSize = i2;
        int i3 = this.capacity + i2;
        if (i >= i3) {
            this.valueTable[i] = null;
            return;
        }
        K[] kArr = this.keyTable;
        kArr[i] = kArr[i3];
        V[] vArr = this.valueTable;
        vArr[i] = vArr[i3];
        vArr[i3] = null;
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
        resize(nextPowerOfTwo(i));
    }

    public String toString() {
        int i;
        if (this.size == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append('{');
        K[] kArr = this.keyTable;
        V[] vArr = this.valueTable;
        int length = kArr.length;
        while (true) {
            i = length - 1;
            if (length > 0) {
                K k = kArr[i];
                if (k != null) {
                    sb.append(k);
                    sb.append('=');
                    sb.append(vArr[i]);
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
                sb.append(vArr[i2]);
            }
            i = i2;
        }
    }

    public Values<V> values() {
        return new Values<>(this);
    }

    public ObjectMap(int i) {
        this(i, 0.8f);
    }

    public static class Values<V> extends MapIterator<Object, V> implements Iterable<V>, Iterator<V> {
        public Values(ObjectMap<?, V> objectMap) {
            super(objectMap);
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
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            V[] vArr = this.map.valueTable;
            int i = this.nextIndex;
            V v = vArr[i];
            this.currentIndex = i;
            advance();
            return v;
        }

        @Override // com.esotericsoftware.kryo.util.ObjectMap.MapIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            super.remove();
        }

        @Override // com.esotericsoftware.kryo.util.ObjectMap.MapIterator
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

    public ObjectMap(int i, float f) {
        if (i < 0) {
            throw new IllegalArgumentException(outline.q("initialCapacity must be >= 0: ", i));
        }
        if (i <= 1073741824) {
            int iNextPowerOfTwo = nextPowerOfTwo(i);
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
                this.valueTable = (V[]) new Object[kArr.length];
                return;
            }
            throw new IllegalArgumentException("loadFactor must be > 0: " + f);
        }
        throw new IllegalArgumentException(outline.q("initialCapacity is too large: ", i));
    }

    private V getStash(K k, V v) {
        K[] kArr = this.keyTable;
        int i = this.capacity;
        int i2 = this.stashSize + i;
        while (i < i2) {
            if (k.equals(kArr[i])) {
                return this.valueTable[i];
            }
            i++;
        }
        return v;
    }

    public void clear() {
        K[] kArr = this.keyTable;
        V[] vArr = this.valueTable;
        int i = this.capacity + this.stashSize;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                kArr[i2] = null;
                vArr[i2] = null;
                i = i2;
            } else {
                this.size = 0;
                this.stashSize = 0;
                return;
            }
        }
    }

    public V get(K k, V v) {
        int iHashCode = k.hashCode();
        int iHash2 = this.mask & iHashCode;
        if (!k.equals(this.keyTable[iHash2])) {
            iHash2 = hash2(iHashCode);
            if (!k.equals(this.keyTable[iHash2])) {
                iHash2 = hash3(iHashCode);
                if (!k.equals(this.keyTable[iHash2])) {
                    if (this.isBigTable) {
                        iHash2 = hash4(iHashCode);
                        if (!k.equals(this.keyTable[iHash2])) {
                            return getStash(k, v);
                        }
                    } else {
                        return getStash(k, v);
                    }
                }
            }
        }
        return this.valueTable[iHash2];
    }

    public ObjectMap(ObjectMap<? extends K, ? extends V> objectMap) {
        this(objectMap.capacity, objectMap.loadFactor);
        this.stashSize = objectMap.stashSize;
        Object[] objArr = objectMap.keyTable;
        System.arraycopy(objArr, 0, this.keyTable, 0, objArr.length);
        Object[] objArr2 = objectMap.valueTable;
        System.arraycopy(objArr2, 0, this.valueTable, 0, objArr2.length);
        this.size = objectMap.size;
    }
}
