package b.i.a.f.h.l;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class x4 extends o3<Integer> implements z4, l6, RandomAccess {
    public static final x4 k;
    public int[] l;
    public int m;

    static {
        x4 x4Var = new x4(new int[0], 0);
        k = x4Var;
        x4Var.j = false;
    }

    public x4() {
        this.l = new int[10];
        this.m = 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        int iIntValue = ((Integer) obj).intValue();
        c();
        if (i < 0 || i > (i2 = this.m)) {
            throw new IndexOutOfBoundsException(i(i));
        }
        int[] iArr = this.l;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.l, i, iArr2, i + 1, this.m - i);
            this.l = iArr2;
        }
        this.l[i] = iIntValue;
        this.m++;
        ((AbstractList) this).modCount++;
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        c();
        Charset charset = w4.a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof x4)) {
            return super.addAll(collection);
        }
        x4 x4Var = (x4) collection;
        int i = x4Var.m;
        if (i == 0) {
            return false;
        }
        int i2 = this.m;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        int[] iArr = this.l;
        if (i3 > iArr.length) {
            this.l = Arrays.copyOf(iArr, i3);
        }
        System.arraycopy(x4Var.l, 0, this.l, this.m, x4Var.m);
        this.m = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final z4 d(int i) {
        if (i >= this.m) {
            return new x4(Arrays.copyOf(this.l, i), this.m);
        }
        throw new IllegalArgumentException();
    }

    public final int e(int i) {
        h(i);
        return this.l[i];
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x4)) {
            return super.equals(obj);
        }
        x4 x4Var = (x4) obj;
        if (this.m != x4Var.m) {
            return false;
        }
        int[] iArr = x4Var.l;
        for (int i = 0; i < this.m; i++) {
            if (this.l[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // b.i.a.f.h.l.b5
    public final /* synthetic */ b5<Integer> f(int i) {
        return d(i);
    }

    public final void g(int i) {
        c();
        int i2 = this.m;
        int[] iArr = this.l;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.l = iArr2;
        }
        int[] iArr3 = this.l;
        int i3 = this.m;
        this.m = i3 + 1;
        iArr3[i3] = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        h(i);
        return Integer.valueOf(this.l[i]);
    }

    public final void h(int i) {
        if (i < 0 || i >= this.m) {
            throw new IndexOutOfBoundsException(i(i));
        }
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.m; i2++) {
            i = (i * 31) + this.l[i2];
        }
        return i;
    }

    public final String i(int i) {
        return b.d.b.a.a.h(35, "Index:", i, ", Size:", this.m);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i = this.m;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.l[i2] == iIntValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        c();
        h(i);
        int[] iArr = this.l;
        int i2 = iArr[i];
        int i3 = this.m;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.m--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        c();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.l;
        System.arraycopy(iArr, i2, iArr, i, this.m - i2);
        this.m -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        c();
        h(i);
        int[] iArr = this.l;
        int i2 = iArr[i];
        iArr[i] = iIntValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.m;
    }

    public x4(int[] iArr, int i) {
        this.l = iArr;
        this.m = i;
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        g(((Integer) obj).intValue());
        return true;
    }
}
