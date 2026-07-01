package b.i.a.f.h.l;

import b.d.b.a.outline;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class m6<E> extends o3<E> implements RandomAccess {
    public static final m6<Object> k;
    public E[] l;
    public int m;

    static {
        m6<Object> m6Var = new m6<>(new Object[0], 0);
        k = m6Var;
        m6Var.j = false;
    }

    public m6(E[] eArr, int i) {
        this.l = eArr;
        this.m = i;
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e) {
        c();
        int i = this.m;
        E[] eArr = this.l;
        if (i == eArr.length) {
            this.l = (E[]) Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.l;
        int i2 = this.m;
        this.m = i2 + 1;
        eArr2[i2] = e;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void d(int i) {
        if (i < 0 || i >= this.m) {
            throw new IndexOutOfBoundsException(e(i));
        }
    }

    public final String e(int i) {
        return outline.h(35, "Index:", i, ", Size:", this.m);
    }

    @Override // b.i.a.f.h.l.b5
    public final /* synthetic */ b5 f(int i) {
        if (i >= this.m) {
            return new m6(Arrays.copyOf(this.l, i), this.m);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        d(i);
        return this.l[i];
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        c();
        d(i);
        E[] eArr = this.l;
        E e = eArr[i];
        int i2 = this.m;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.m--;
        ((AbstractList) this).modCount++;
        return e;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i, E e) {
        c();
        d(i);
        E[] eArr = this.l;
        E e2 = eArr[i];
        eArr[i] = e;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.m;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, E e) {
        int i2;
        c();
        if (i >= 0 && i <= (i2 = this.m)) {
            E[] eArr = this.l;
            if (i2 < eArr.length) {
                System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
            } else {
                E[] eArr2 = (E[]) new Object[((i2 * 3) / 2) + 1];
                System.arraycopy(eArr, 0, eArr2, 0, i);
                System.arraycopy(this.l, i, eArr2, i + 1, this.m - i);
                this.l = eArr2;
            }
            this.l[i] = e;
            this.m++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(e(i));
    }
}
