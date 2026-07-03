package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.f.h.l.m6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3749m6<E> extends AbstractC3772o3<E> implements RandomAccess {

    /* JADX INFO: renamed from: k */
    public static final C3749m6<Object> f10094k;

    /* JADX INFO: renamed from: l */
    public E[] f10095l;

    /* JADX INFO: renamed from: m */
    public int f10096m;

    static {
        C3749m6<Object> c3749m6 = new C3749m6<>(new Object[0], 0);
        f10094k = c3749m6;
        c3749m6.f10123j = false;
    }

    public C3749m6(E[] eArr, int i) {
        this.f10095l = eArr;
        this.f10096m = i;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e) {
        m5153c();
        int i = this.f10096m;
        E[] eArr = this.f10095l;
        if (i == eArr.length) {
            this.f10095l = (E[]) Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.f10095l;
        int i2 = this.f10096m;
        this.f10096m = i2 + 1;
        eArr2[i2] = e;
        ((AbstractList) this).modCount++;
        return true;
    }

    /* JADX INFO: renamed from: d */
    public final void m5072d(int i) {
        if (i < 0 || i >= this.f10096m) {
            throw new IndexOutOfBoundsException(m5073e(i));
        }
    }

    /* JADX INFO: renamed from: e */
    public final String m5073e(int i) {
        return C1643a.m853h(35, "Index:", i, ", Size:", this.f10096m);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3597b5
    /* JADX INFO: renamed from: f */
    public final /* synthetic */ InterfaceC3597b5 mo4569f(int i) {
        if (i >= this.f10096m) {
            return new C3749m6(Arrays.copyOf(this.f10095l, i), this.f10096m);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        m5072d(i);
        return this.f10095l[i];
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        m5153c();
        m5072d(i);
        E[] eArr = this.f10095l;
        E e = eArr[i];
        int i2 = this.f10096m;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.f10096m--;
        ((AbstractList) this).modCount++;
        return e;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i, E e) {
        m5153c();
        m5072d(i);
        E[] eArr = this.f10095l;
        E e2 = eArr[i];
        eArr[i] = e;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f10096m;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, E e) {
        int i2;
        m5153c();
        if (i >= 0 && i <= (i2 = this.f10096m)) {
            E[] eArr = this.f10095l;
            if (i2 < eArr.length) {
                System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
            } else {
                E[] eArr2 = (E[]) new Object[((i2 * 3) / 2) + 1];
                System.arraycopy(eArr, 0, eArr2, 0, i);
                System.arraycopy(this.f10095l, i, eArr2, i + 1, this.f10096m - i);
                this.f10095l = eArr2;
            }
            this.f10095l[i] = e;
            this.f10096m++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(m5073e(i));
    }
}
