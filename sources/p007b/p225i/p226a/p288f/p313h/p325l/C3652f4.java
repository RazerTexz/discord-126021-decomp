package p007b.p225i.p226a.p288f.p313h.p325l;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.f.h.l.f4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3652f4 extends AbstractC3772o3<Double> implements InterfaceC3597b5<Double>, InterfaceC3736l6, RandomAccess {

    /* JADX INFO: renamed from: k */
    public double[] f9940k;

    /* JADX INFO: renamed from: l */
    public int f9941l;

    static {
        new C3652f4(new double[0], 0).f10123j = false;
    }

    public C3652f4() {
        this.f9940k = new double[10];
        this.f9941l = 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        double dDoubleValue = ((Double) obj).doubleValue();
        m5153c();
        if (i < 0 || i > (i2 = this.f9941l)) {
            throw new IndexOutOfBoundsException(m4879g(i));
        }
        double[] dArr = this.f9940k;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.f9940k, i, dArr2, i + 1, this.f9941l - i);
            this.f9940k = dArr2;
        }
        this.f9940k[i] = dDoubleValue;
        this.f9941l++;
        ((AbstractList) this).modCount++;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        m5153c();
        Charset charset = C3877w4.f10379a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof C3652f4)) {
            return super.addAll(collection);
        }
        C3652f4 c3652f4 = (C3652f4) collection;
        int i = c3652f4.f9941l;
        if (i == 0) {
            return false;
        }
        int i2 = this.f9941l;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        double[] dArr = this.f9940k;
        if (i3 > dArr.length) {
            this.f9940k = Arrays.copyOf(dArr, i3);
        }
        System.arraycopy(c3652f4.f9940k, 0, this.f9940k, this.f9941l, c3652f4.f9941l);
        this.f9941l = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    /* JADX INFO: renamed from: d */
    public final void m4877d(double d) {
        m5153c();
        int i = this.f9941l;
        double[] dArr = this.f9940k;
        if (i == dArr.length) {
            double[] dArr2 = new double[((i * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.f9940k = dArr2;
        }
        double[] dArr3 = this.f9940k;
        int i2 = this.f9941l;
        this.f9941l = i2 + 1;
        dArr3[i2] = d;
    }

    /* JADX INFO: renamed from: e */
    public final void m4878e(int i) {
        if (i < 0 || i >= this.f9941l) {
            throw new IndexOutOfBoundsException(m4879g(i));
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3652f4)) {
            return super.equals(obj);
        }
        C3652f4 c3652f4 = (C3652f4) obj;
        if (this.f9941l != c3652f4.f9941l) {
            return false;
        }
        double[] dArr = c3652f4.f9940k;
        for (int i = 0; i < this.f9941l; i++) {
            if (Double.doubleToLongBits(this.f9940k[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3597b5
    /* JADX INFO: renamed from: f */
    public final /* synthetic */ InterfaceC3597b5<Double> mo4569f(int i) {
        if (i >= this.f9941l) {
            return new C3652f4(Arrays.copyOf(this.f9940k, i), this.f9941l);
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: renamed from: g */
    public final String m4879g(int i) {
        return C1643a.m853h(35, "Index:", i, ", Size:", this.f9941l);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        m4878e(i);
        return Double.valueOf(this.f9940k[i]);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iM5344a = 1;
        for (int i = 0; i < this.f9941l; i++) {
            iM5344a = (iM5344a * 31) + C3877w4.m5344a(Double.doubleToLongBits(this.f9940k[i]));
        }
        return iM5344a;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int i = this.f9941l;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f9940k[i2] == dDoubleValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        m5153c();
        m4878e(i);
        double[] dArr = this.f9940k;
        double d = dArr[i];
        int i2 = this.f9941l;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.f9941l--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        m5153c();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f9940k;
        System.arraycopy(dArr, i2, dArr, i, this.f9941l - i2);
        this.f9941l -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        m5153c();
        m4878e(i);
        double[] dArr = this.f9940k;
        double d = dArr[i];
        dArr[i] = dDoubleValue;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f9941l;
    }

    public C3652f4(double[] dArr, int i) {
        this.f9940k = dArr;
        this.f9941l = i;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        m4877d(((Double) obj).doubleValue());
        return true;
    }
}
