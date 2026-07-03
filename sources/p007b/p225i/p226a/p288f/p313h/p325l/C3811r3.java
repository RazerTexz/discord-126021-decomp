package p007b.p225i.p226a.p288f.p313h.p325l;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.f.h.l.r3 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3811r3 extends AbstractC3772o3<Boolean> implements InterfaceC3597b5<Boolean>, InterfaceC3736l6, RandomAccess {

    /* JADX INFO: renamed from: k */
    public boolean[] f10283k;

    /* JADX INFO: renamed from: l */
    public int f10284l;

    static {
        new C3811r3(new boolean[0], 0).f10123j = false;
    }

    public C3811r3() {
        this.f10283k = new boolean[10];
        this.f10284l = 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        m5153c();
        if (i < 0 || i > (i2 = this.f10284l)) {
            throw new IndexOutOfBoundsException(m5200g(i));
        }
        boolean[] zArr = this.f10283k;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.f10283k, i, zArr2, i + 1, this.f10284l - i);
            this.f10283k = zArr2;
        }
        this.f10283k[i] = zBooleanValue;
        this.f10284l++;
        ((AbstractList) this).modCount++;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        m5153c();
        Charset charset = C3877w4.f10379a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof C3811r3)) {
            return super.addAll(collection);
        }
        C3811r3 c3811r3 = (C3811r3) collection;
        int i = c3811r3.f10284l;
        if (i == 0) {
            return false;
        }
        int i2 = this.f10284l;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        boolean[] zArr = this.f10283k;
        if (i3 > zArr.length) {
            this.f10283k = Arrays.copyOf(zArr, i3);
        }
        System.arraycopy(c3811r3.f10283k, 0, this.f10283k, this.f10284l, c3811r3.f10284l);
        this.f10284l = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    /* JADX INFO: renamed from: d */
    public final void m5198d(boolean z2) {
        m5153c();
        int i = this.f10284l;
        boolean[] zArr = this.f10283k;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[((i * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.f10283k = zArr2;
        }
        boolean[] zArr3 = this.f10283k;
        int i2 = this.f10284l;
        this.f10284l = i2 + 1;
        zArr3[i2] = z2;
    }

    /* JADX INFO: renamed from: e */
    public final void m5199e(int i) {
        if (i < 0 || i >= this.f10284l) {
            throw new IndexOutOfBoundsException(m5200g(i));
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3811r3)) {
            return super.equals(obj);
        }
        C3811r3 c3811r3 = (C3811r3) obj;
        if (this.f10284l != c3811r3.f10284l) {
            return false;
        }
        boolean[] zArr = c3811r3.f10283k;
        for (int i = 0; i < this.f10284l; i++) {
            if (this.f10283k[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3597b5
    /* JADX INFO: renamed from: f */
    public final /* synthetic */ InterfaceC3597b5<Boolean> mo4569f(int i) {
        if (i >= this.f10284l) {
            return new C3811r3(Arrays.copyOf(this.f10283k, i), this.f10284l);
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: renamed from: g */
    public final String m5200g(int i) {
        return C1643a.m853h(35, "Index:", i, ", Size:", this.f10284l);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        m5199e(i);
        return Boolean.valueOf(this.f10283k[i]);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iM5345b = 1;
        for (int i = 0; i < this.f10284l; i++) {
            iM5345b = (iM5345b * 31) + C3877w4.m5345b(this.f10283k[i]);
        }
        return iM5345b;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int i = this.f10284l;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f10283k[i2] == zBooleanValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        m5153c();
        m5199e(i);
        boolean[] zArr = this.f10283k;
        boolean z2 = zArr[i];
        int i2 = this.f10284l;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.f10284l--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        m5153c();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.f10283k;
        System.arraycopy(zArr, i2, zArr, i, this.f10284l - i2);
        this.f10284l -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        m5153c();
        m5199e(i);
        boolean[] zArr = this.f10283k;
        boolean z2 = zArr[i];
        zArr[i] = zBooleanValue;
        return Boolean.valueOf(z2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f10284l;
    }

    public C3811r3(boolean[] zArr, int i) {
        this.f10283k = zArr;
        this.f10284l = i;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        m5198d(((Boolean) obj).booleanValue());
        return true;
    }
}
