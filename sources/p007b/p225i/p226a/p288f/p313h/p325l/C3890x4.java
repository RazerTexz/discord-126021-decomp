package p007b.p225i.p226a.p288f.p313h.p325l;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.f.h.l.x4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3890x4 extends AbstractC3772o3<Integer> implements InterfaceC3916z4, InterfaceC3736l6, RandomAccess {

    /* JADX INFO: renamed from: k */
    public static final C3890x4 f10400k;

    /* JADX INFO: renamed from: l */
    public int[] f10401l;

    /* JADX INFO: renamed from: m */
    public int f10402m;

    static {
        C3890x4 c3890x4 = new C3890x4(new int[0], 0);
        f10400k = c3890x4;
        c3890x4.f10123j = false;
    }

    public C3890x4() {
        this.f10401l = new int[10];
        this.f10402m = 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        int iIntValue = ((Integer) obj).intValue();
        m5153c();
        if (i < 0 || i > (i2 = this.f10402m)) {
            throw new IndexOutOfBoundsException(m5360i(i));
        }
        int[] iArr = this.f10401l;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.f10401l, i, iArr2, i + 1, this.f10402m - i);
            this.f10401l = iArr2;
        }
        this.f10401l[i] = iIntValue;
        this.f10402m++;
        ((AbstractList) this).modCount++;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        m5153c();
        Charset charset = C3877w4.f10379a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof C3890x4)) {
            return super.addAll(collection);
        }
        C3890x4 c3890x4 = (C3890x4) collection;
        int i = c3890x4.f10402m;
        if (i == 0) {
            return false;
        }
        int i2 = this.f10402m;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        int[] iArr = this.f10401l;
        if (i3 > iArr.length) {
            this.f10401l = Arrays.copyOf(iArr, i3);
        }
        System.arraycopy(c3890x4.f10401l, 0, this.f10401l, this.f10402m, c3890x4.f10402m);
        this.f10402m = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3597b5
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final InterfaceC3916z4 mo4569f(int i) {
        if (i >= this.f10402m) {
            return new C3890x4(Arrays.copyOf(this.f10401l, i), this.f10402m);
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: renamed from: e */
    public final int m5357e(int i) {
        m5359h(i);
        return this.f10401l[i];
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3890x4)) {
            return super.equals(obj);
        }
        C3890x4 c3890x4 = (C3890x4) obj;
        if (this.f10402m != c3890x4.f10402m) {
            return false;
        }
        int[] iArr = c3890x4.f10401l;
        for (int i = 0; i < this.f10402m; i++) {
            if (this.f10401l[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: g */
    public final void m5358g(int i) {
        m5153c();
        int i2 = this.f10402m;
        int[] iArr = this.f10401l;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f10401l = iArr2;
        }
        int[] iArr3 = this.f10401l;
        int i3 = this.f10402m;
        this.f10402m = i3 + 1;
        iArr3[i3] = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        m5359h(i);
        return Integer.valueOf(this.f10401l[i]);
    }

    /* JADX INFO: renamed from: h */
    public final void m5359h(int i) {
        if (i < 0 || i >= this.f10402m) {
            throw new IndexOutOfBoundsException(m5360i(i));
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f10402m; i2++) {
            i = (i * 31) + this.f10401l[i2];
        }
        return i;
    }

    /* JADX INFO: renamed from: i */
    public final String m5360i(int i) {
        return C1643a.m853h(35, "Index:", i, ", Size:", this.f10402m);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i = this.f10402m;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f10401l[i2] == iIntValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        m5153c();
        m5359h(i);
        int[] iArr = this.f10401l;
        int i2 = iArr[i];
        int i3 = this.f10402m;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.f10402m--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        m5153c();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f10401l;
        System.arraycopy(iArr, i2, iArr, i, this.f10402m - i2);
        this.f10402m -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        m5153c();
        m5359h(i);
        int[] iArr = this.f10401l;
        int i2 = iArr[i];
        iArr[i] = iIntValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f10402m;
    }

    public C3890x4(int[] iArr, int i) {
        this.f10401l = iArr;
        this.f10402m = i;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        m5358g(((Integer) obj).intValue());
        return true;
    }
}
