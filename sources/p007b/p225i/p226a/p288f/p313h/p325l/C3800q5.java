package p007b.p225i.p226a.p288f.p313h.p325l;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.f.h.l.q5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3800q5 extends AbstractC3772o3<Long> implements InterfaceC3611c5, InterfaceC3736l6, RandomAccess {

    /* JADX INFO: renamed from: k */
    public static final C3800q5 f10271k;

    /* JADX INFO: renamed from: l */
    public long[] f10272l;

    /* JADX INFO: renamed from: m */
    public int f10273m;

    static {
        C3800q5 c3800q5 = new C3800q5(new long[0], 0);
        f10271k = c3800q5;
        c3800q5.f10123j = false;
    }

    public C3800q5() {
        this.f10272l = new long[10];
        this.f10273m = 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        long jLongValue = ((Long) obj).longValue();
        m5153c();
        if (i < 0 || i > (i2 = this.f10273m)) {
            throw new IndexOutOfBoundsException(m5190i(i));
        }
        long[] jArr = this.f10272l;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.f10272l, i, jArr2, i + 1, this.f10273m - i);
            this.f10272l = jArr2;
        }
        this.f10272l[i] = jLongValue;
        this.f10273m++;
        ((AbstractList) this).modCount++;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        m5153c();
        Charset charset = C3877w4.f10379a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof C3800q5)) {
            return super.addAll(collection);
        }
        C3800q5 c3800q5 = (C3800q5) collection;
        int i = c3800q5.f10273m;
        if (i == 0) {
            return false;
        }
        int i2 = this.f10273m;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        long[] jArr = this.f10272l;
        if (i3 > jArr.length) {
            this.f10272l = Arrays.copyOf(jArr, i3);
        }
        System.arraycopy(c3800q5.f10272l, 0, this.f10272l, this.f10273m, c3800q5.f10273m);
        this.f10273m = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    /* JADX INFO: renamed from: d */
    public final void m5186d(long j) {
        m5153c();
        int i = this.f10273m;
        long[] jArr = this.f10272l;
        if (i == jArr.length) {
            long[] jArr2 = new long[((i * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.f10272l = jArr2;
        }
        long[] jArr3 = this.f10272l;
        int i2 = this.f10273m;
        this.f10273m = i2 + 1;
        jArr3[i2] = j;
    }

    /* JADX INFO: renamed from: e */
    public final long m5187e(int i) {
        m5189h(i);
        return this.f10272l[i];
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3800q5)) {
            return super.equals(obj);
        }
        C3800q5 c3800q5 = (C3800q5) obj;
        if (this.f10273m != c3800q5.f10273m) {
            return false;
        }
        long[] jArr = c3800q5.f10272l;
        for (int i = 0; i < this.f10273m; i++) {
            if (this.f10272l[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3597b5
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final InterfaceC3611c5 mo4569f(int i) {
        if (i >= this.f10273m) {
            return new C3800q5(Arrays.copyOf(this.f10272l, i), this.f10273m);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        m5189h(i);
        return Long.valueOf(this.f10272l[i]);
    }

    /* JADX INFO: renamed from: h */
    public final void m5189h(int i) {
        if (i < 0 || i >= this.f10273m) {
            throw new IndexOutOfBoundsException(m5190i(i));
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iM5344a = 1;
        for (int i = 0; i < this.f10273m; i++) {
            iM5344a = (iM5344a * 31) + C3877w4.m5344a(this.f10272l[i]);
        }
        return iM5344a;
    }

    /* JADX INFO: renamed from: i */
    public final String m5190i(int i) {
        return C1643a.m853h(35, "Index:", i, ", Size:", this.f10273m);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i = this.f10273m;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f10272l[i2] == jLongValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        m5153c();
        m5189h(i);
        long[] jArr = this.f10272l;
        long j = jArr[i];
        int i2 = this.f10273m;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.f10273m--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        m5153c();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f10272l;
        System.arraycopy(jArr, i2, jArr, i, this.f10273m - i2);
        this.f10273m -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        m5153c();
        m5189h(i);
        long[] jArr = this.f10272l;
        long j = jArr[i];
        jArr[i] = jLongValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f10273m;
    }

    public C3800q5(long[] jArr, int i) {
        this.f10272l = jArr;
        this.f10273m = i;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        m5186d(((Long) obj).longValue());
        return true;
    }
}
