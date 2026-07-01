package b.i.a.f.h.l;

import b.d.b.a.outline;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class r3 extends o3<Boolean> implements b5<Boolean>, l6, RandomAccess {
    public boolean[] k;
    public int l;

    static {
        new r3(new boolean[0], 0).j = false;
    }

    public r3() {
        this.k = new boolean[10];
        this.l = 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        c();
        if (i < 0 || i > (i2 = this.l)) {
            throw new IndexOutOfBoundsException(g(i));
        }
        boolean[] zArr = this.k;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.k, i, zArr2, i + 1, this.l - i);
            this.k = zArr2;
        }
        this.k[i] = zBooleanValue;
        this.l++;
        ((AbstractList) this).modCount++;
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        c();
        Charset charset = w4.a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof r3)) {
            return super.addAll(collection);
        }
        r3 r3Var = (r3) collection;
        int i = r3Var.l;
        if (i == 0) {
            return false;
        }
        int i2 = this.l;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        boolean[] zArr = this.k;
        if (i3 > zArr.length) {
            this.k = Arrays.copyOf(zArr, i3);
        }
        System.arraycopy(r3Var.k, 0, this.k, this.l, r3Var.l);
        this.l = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(boolean z2) {
        c();
        int i = this.l;
        boolean[] zArr = this.k;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[((i * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.k = zArr2;
        }
        boolean[] zArr3 = this.k;
        int i2 = this.l;
        this.l = i2 + 1;
        zArr3[i2] = z2;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.l) {
            throw new IndexOutOfBoundsException(g(i));
        }
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r3)) {
            return super.equals(obj);
        }
        r3 r3Var = (r3) obj;
        if (this.l != r3Var.l) {
            return false;
        }
        boolean[] zArr = r3Var.k;
        for (int i = 0; i < this.l; i++) {
            if (this.k[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // b.i.a.f.h.l.b5
    public final /* synthetic */ b5<Boolean> f(int i) {
        if (i >= this.l) {
            return new r3(Arrays.copyOf(this.k, i), this.l);
        }
        throw new IllegalArgumentException();
    }

    public final String g(int i) {
        return outline.h(35, "Index:", i, ", Size:", this.l);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        e(i);
        return Boolean.valueOf(this.k[i]);
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iB = 1;
        for (int i = 0; i < this.l; i++) {
            iB = (iB * 31) + w4.b(this.k[i]);
        }
        return iB;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int i = this.l;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.k[i2] == zBooleanValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        c();
        e(i);
        boolean[] zArr = this.k;
        boolean z2 = zArr[i];
        int i2 = this.l;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.l--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        c();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.k;
        System.arraycopy(zArr, i2, zArr, i, this.l - i2);
        this.l -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        c();
        e(i);
        boolean[] zArr = this.k;
        boolean z2 = zArr[i];
        zArr[i] = zBooleanValue;
        return Boolean.valueOf(z2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.l;
    }

    public r3(boolean[] zArr, int i) {
        this.k = zArr;
        this.l = i;
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        d(((Boolean) obj).booleanValue());
        return true;
    }
}
