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
public final class f4 extends o3<Double> implements b5<Double>, l6, RandomAccess {
    public double[] k;
    public int l;

    static {
        new f4(new double[0], 0).j = false;
    }

    public f4() {
        this.k = new double[10];
        this.l = 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        double dDoubleValue = ((Double) obj).doubleValue();
        c();
        if (i < 0 || i > (i2 = this.l)) {
            throw new IndexOutOfBoundsException(g(i));
        }
        double[] dArr = this.k;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.k, i, dArr2, i + 1, this.l - i);
            this.k = dArr2;
        }
        this.k[i] = dDoubleValue;
        this.l++;
        ((AbstractList) this).modCount++;
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        c();
        Charset charset = w4.a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof f4)) {
            return super.addAll(collection);
        }
        f4 f4Var = (f4) collection;
        int i = f4Var.l;
        if (i == 0) {
            return false;
        }
        int i2 = this.l;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        double[] dArr = this.k;
        if (i3 > dArr.length) {
            this.k = Arrays.copyOf(dArr, i3);
        }
        System.arraycopy(f4Var.k, 0, this.k, this.l, f4Var.l);
        this.l = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(double d) {
        c();
        int i = this.l;
        double[] dArr = this.k;
        if (i == dArr.length) {
            double[] dArr2 = new double[((i * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.k = dArr2;
        }
        double[] dArr3 = this.k;
        int i2 = this.l;
        this.l = i2 + 1;
        dArr3[i2] = d;
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
        if (!(obj instanceof f4)) {
            return super.equals(obj);
        }
        f4 f4Var = (f4) obj;
        if (this.l != f4Var.l) {
            return false;
        }
        double[] dArr = f4Var.k;
        for (int i = 0; i < this.l; i++) {
            if (Double.doubleToLongBits(this.k[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // b.i.a.f.h.l.b5
    public final /* synthetic */ b5<Double> f(int i) {
        if (i >= this.l) {
            return new f4(Arrays.copyOf(this.k, i), this.l);
        }
        throw new IllegalArgumentException();
    }

    public final String g(int i) {
        return outline.h(35, "Index:", i, ", Size:", this.l);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        e(i);
        return Double.valueOf(this.k[i]);
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iA = 1;
        for (int i = 0; i < this.l; i++) {
            iA = (iA * 31) + w4.a(Double.doubleToLongBits(this.k[i]));
        }
        return iA;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int i = this.l;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.k[i2] == dDoubleValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        c();
        e(i);
        double[] dArr = this.k;
        double d = dArr[i];
        int i2 = this.l;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.l--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        c();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.k;
        System.arraycopy(dArr, i2, dArr, i, this.l - i2);
        this.l -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        c();
        e(i);
        double[] dArr = this.k;
        double d = dArr[i];
        dArr[i] = dDoubleValue;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.l;
    }

    public f4(double[] dArr, int i) {
        this.k = dArr;
        this.l = i;
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        d(((Double) obj).doubleValue());
        return true;
    }
}
