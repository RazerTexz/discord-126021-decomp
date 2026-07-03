package p007b.p225i.p355b.p358c;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.b.c.a */
/* JADX INFO: compiled from: Ints.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4538a extends AbstractList<Integer> implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0;
    public final int[] array;
    public final int end;
    public final int start;

    public C4538a(int[] iArr) {
        int length = iArr.length;
        this.array = iArr;
        this.start = 0;
        this.end = length;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001e A[RETURN, SYNTHETIC] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        if (obj instanceof Integer) {
            int[] iArr = this.array;
            int iIntValue = ((Integer) obj).intValue();
            int i = this.start;
            int i2 = this.end;
            while (i < i2) {
                if (iArr[i] != iIntValue) {
                    i++;
                } else if (i != -1) {
                    return true;
                }
            }
            i = -1;
            if (i != -1) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C4538a)) {
            return super.equals(obj);
        }
        C4538a c4538a = (C4538a) obj;
        int size = size();
        if (c4538a.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (this.array[this.start + i] != c4538a.array[c4538a.start + i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        C3404f.m4359x(i, size());
        return Integer.valueOf(this.array[this.start + i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i = 1;
        for (int i2 = this.start; i2 < this.end; i2++) {
            i = (i * 31) + this.array[i2];
        }
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001e  */
    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (obj instanceof Integer) {
            int[] iArr = this.array;
            int iIntValue = ((Integer) obj).intValue();
            int i = this.start;
            int i2 = this.end;
            while (i < i2) {
                if (iArr[i] != iIntValue) {
                    i++;
                } else if (i >= 0) {
                    return i - this.start;
                }
            }
            i = -1;
            if (i >= 0) {
                return i - this.start;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001f  */
    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        if (obj instanceof Integer) {
            int[] iArr = this.array;
            int iIntValue = ((Integer) obj).intValue();
            int i = this.start;
            int i2 = this.end - 1;
            while (i2 >= i) {
                if (iArr[i2] != iIntValue) {
                    i2--;
                } else if (i2 >= 0) {
                    return i2 - this.start;
                }
            }
            i2 = -1;
            if (i2 >= 0) {
                return i2 - this.start;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        Integer num = (Integer) obj;
        C3404f.m4359x(i, size());
        int[] iArr = this.array;
        int i2 = this.start + i;
        int i3 = iArr[i2];
        Objects.requireNonNull(num);
        iArr[i2] = num.intValue();
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.end - this.start;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<Integer> subList(int i, int i2) {
        C3404f.m4198D(i, i2, size());
        if (i == i2) {
            return Collections.emptyList();
        }
        int[] iArr = this.array;
        int i3 = this.start;
        return new C4538a(iArr, i + i3, i3 + i2);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder sb = new StringBuilder(size() * 5);
        sb.append('[');
        sb.append(this.array[this.start]);
        int i = this.start;
        while (true) {
            i++;
            if (i >= this.end) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(this.array[i]);
        }
    }

    public C4538a(int[] iArr, int i, int i2) {
        this.array = iArr;
        this.start = i;
        this.end = i2;
    }
}
