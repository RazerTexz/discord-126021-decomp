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
public final class q5 extends o3<Long> implements c5, l6, RandomAccess {
    public static final q5 k;
    public long[] l;
    public int m;

    static {
        q5 q5Var = new q5(new long[0], 0);
        k = q5Var;
        q5Var.j = false;
    }

    public q5() {
        this.l = new long[10];
        this.m = 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        long jLongValue = ((Long) obj).longValue();
        c();
        if (i < 0 || i > (i2 = this.m)) {
            throw new IndexOutOfBoundsException(i(i));
        }
        long[] jArr = this.l;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.l, i, jArr2, i + 1, this.m - i);
            this.l = jArr2;
        }
        this.l[i] = jLongValue;
        this.m++;
        ((AbstractList) this).modCount++;
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        c();
        Charset charset = w4.a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof q5)) {
            return super.addAll(collection);
        }
        q5 q5Var = (q5) collection;
        int i = q5Var.m;
        if (i == 0) {
            return false;
        }
        int i2 = this.m;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        long[] jArr = this.l;
        if (i3 > jArr.length) {
            this.l = Arrays.copyOf(jArr, i3);
        }
        System.arraycopy(q5Var.l, 0, this.l, this.m, q5Var.m);
        this.m = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(long j) {
        c();
        int i = this.m;
        long[] jArr = this.l;
        if (i == jArr.length) {
            long[] jArr2 = new long[((i * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.l = jArr2;
        }
        long[] jArr3 = this.l;
        int i2 = this.m;
        this.m = i2 + 1;
        jArr3[i2] = j;
    }

    public final long e(int i) {
        h(i);
        return this.l[i];
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q5)) {
            return super.equals(obj);
        }
        q5 q5Var = (q5) obj;
        if (this.m != q5Var.m) {
            return false;
        }
        long[] jArr = q5Var.l;
        for (int i = 0; i < this.m; i++) {
            if (this.l[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // b.i.a.f.h.l.b5
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final c5 f(int i) {
        if (i >= this.m) {
            return new q5(Arrays.copyOf(this.l, i), this.m);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        h(i);
        return Long.valueOf(this.l[i]);
    }

    public final void h(int i) {
        if (i < 0 || i >= this.m) {
            throw new IndexOutOfBoundsException(i(i));
        }
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iA = 1;
        for (int i = 0; i < this.m; i++) {
            iA = (iA * 31) + w4.a(this.l[i]);
        }
        return iA;
    }

    public final String i(int i) {
        return outline.h(35, "Index:", i, ", Size:", this.m);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i = this.m;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.l[i2] == jLongValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        c();
        h(i);
        long[] jArr = this.l;
        long j = jArr[i];
        int i2 = this.m;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.m--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        c();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.l;
        System.arraycopy(jArr, i2, jArr, i, this.m - i2);
        this.m -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        c();
        h(i);
        long[] jArr = this.l;
        long j = jArr[i];
        jArr[i] = jLongValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.m;
    }

    public q5(long[] jArr, int i) {
        this.l = jArr;
        this.m = i;
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        d(((Long) obj).longValue());
        return true;
    }
}
