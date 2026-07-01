package com.esotericsoftware.kryo.util;

import b.d.b.a.a;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class IntArray {
    public int[] items;
    public boolean ordered;
    public int size;

    public IntArray() {
        this(true, 16);
    }

    public void add(int i) {
        int[] iArrResize = this.items;
        int i2 = this.size;
        if (i2 == iArrResize.length) {
            iArrResize = resize(Math.max(8, (int) (i2 * 1.75f)));
        }
        int i3 = this.size;
        this.size = i3 + 1;
        iArrResize[i3] = i;
    }

    public void addAll(IntArray intArray) {
        addAll(intArray, 0, intArray.size);
    }

    public void clear() {
        this.size = 0;
    }

    public boolean contains(int i) {
        int i2 = this.size - 1;
        int[] iArr = this.items;
        while (i2 >= 0) {
            int i3 = i2 - 1;
            if (iArr[i2] == i) {
                return true;
            }
            i2 = i3;
        }
        return false;
    }

    public int[] ensureCapacity(int i) {
        int i2 = this.size + i;
        if (i2 >= this.items.length) {
            resize(Math.max(8, i2));
        }
        return this.items;
    }

    public int get(int i) {
        if (i < this.size) {
            return this.items[i];
        }
        throw new IndexOutOfBoundsException(String.valueOf(i));
    }

    public int indexOf(int i) {
        int[] iArr = this.items;
        int i2 = this.size;
        for (int i3 = 0; i3 < i2; i3++) {
            if (iArr[i3] == i) {
                return i3;
            }
        }
        return -1;
    }

    public void insert(int i, int i2) {
        int[] iArrResize = this.items;
        int i3 = this.size;
        if (i3 == iArrResize.length) {
            iArrResize = resize(Math.max(8, (int) (i3 * 1.75f)));
        }
        if (this.ordered) {
            System.arraycopy(iArrResize, i, iArrResize, i + 1, this.size - i);
        } else {
            iArrResize[this.size] = iArrResize[i];
        }
        this.size++;
        iArrResize[i] = i2;
    }

    public int peek() {
        return this.items[this.size - 1];
    }

    public int pop() {
        int[] iArr = this.items;
        int i = this.size - 1;
        this.size = i;
        return iArr[i];
    }

    public int removeIndex(int i) {
        int i2 = this.size;
        if (i >= i2) {
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }
        int[] iArr = this.items;
        int i3 = iArr[i];
        int i4 = i2 - 1;
        this.size = i4;
        if (this.ordered) {
            System.arraycopy(iArr, i + 1, iArr, i, i4 - i);
        } else {
            iArr[i] = iArr[i4];
        }
        return i3;
    }

    public boolean removeValue(int i) {
        int[] iArr = this.items;
        int i2 = this.size;
        for (int i3 = 0; i3 < i2; i3++) {
            if (iArr[i3] == i) {
                removeIndex(i3);
                return true;
            }
        }
        return false;
    }

    public int[] resize(int i) {
        int[] iArr = new int[i];
        int[] iArr2 = this.items;
        System.arraycopy(iArr2, 0, iArr, 0, Math.min(iArr2.length, i));
        this.items = iArr;
        return iArr;
    }

    public void reverse() {
        int i = this.size;
        int i2 = i - 1;
        int i3 = i / 2;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i2 - i4;
            int[] iArr = this.items;
            int i6 = iArr[i4];
            iArr[i4] = iArr[i5];
            iArr[i5] = i6;
        }
    }

    public void set(int i, int i2) {
        if (i >= this.size) {
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }
        this.items[i] = i2;
    }

    public void shrink() {
        resize(this.size);
    }

    public void sort() {
        Arrays.sort(this.items, 0, this.size);
    }

    public void swap(int i, int i2) {
        int i3 = this.size;
        if (i >= i3) {
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }
        if (i2 >= i3) {
            throw new IndexOutOfBoundsException(String.valueOf(i2));
        }
        int[] iArr = this.items;
        int i4 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i4;
    }

    public int[] toArray() {
        int i = this.size;
        int[] iArr = new int[i];
        System.arraycopy(this.items, 0, iArr, 0, i);
        return iArr;
    }

    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        int[] iArr = this.items;
        StringBuilder sb = new StringBuilder(32);
        sb.append('[');
        sb.append(iArr[0]);
        for (int i = 1; i < this.size; i++) {
            sb.append(", ");
            sb.append(iArr[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    public void truncate(int i) {
        if (this.size > i) {
            this.size = i;
        }
    }

    public IntArray(int i) {
        this(true, i);
    }

    public void addAll(IntArray intArray, int i, int i2) {
        if (i + i2 <= intArray.size) {
            addAll(intArray.items, i, i2);
        } else {
            StringBuilder sbW = a.W("offset + length must be <= size: ", i, " + ", i2, " <= ");
            sbW.append(intArray.size);
            throw new IllegalArgumentException(sbW.toString());
        }
    }

    public IntArray(boolean z2, int i) {
        this.ordered = z2;
        this.items = new int[i];
    }

    public void addAll(int[] iArr) {
        addAll(iArr, 0, iArr.length);
    }

    public IntArray(IntArray intArray) {
        this.ordered = intArray.ordered;
        int i = intArray.size;
        this.size = i;
        int[] iArr = new int[i];
        this.items = iArr;
        System.arraycopy(intArray.items, 0, iArr, 0, i);
    }

    public void addAll(int[] iArr, int i, int i2) {
        int[] iArrResize = this.items;
        int i3 = (this.size + i2) - i;
        if (i3 >= iArrResize.length) {
            iArrResize = resize(Math.max(8, (int) (i3 * 1.75f)));
        }
        System.arraycopy(iArr, i, iArrResize, this.size, i2);
        this.size += i2;
    }

    public IntArray(int[] iArr) {
        this(true, iArr);
    }

    public String toString(String str) {
        if (this.size == 0) {
            return "";
        }
        int[] iArr = this.items;
        StringBuilder sb = new StringBuilder(32);
        sb.append(iArr[0]);
        for (int i = 1; i < this.size; i++) {
            sb.append(str);
            sb.append(iArr[i]);
        }
        return sb.toString();
    }

    public IntArray(boolean z2, int[] iArr) {
        this(z2, iArr.length);
        int length = iArr.length;
        this.size = length;
        System.arraycopy(iArr, 0, this.items, 0, length);
    }
}
