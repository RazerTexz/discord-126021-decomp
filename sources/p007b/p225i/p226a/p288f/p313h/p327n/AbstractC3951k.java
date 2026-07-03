package p007b.p225i.p226a.p288f.p313h.p327n;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.f.h.n.k */
/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3951k<E> extends AbstractC3948h<E> implements List<E>, RandomAccess {

    /* JADX INFO: renamed from: k */
    public static final AbstractC3953m<Object> f10489k = new C3949i(C3952l.f10490l, 0);

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p327n.AbstractC3948h
    /* JADX INFO: renamed from: c */
    public int mo5430c(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        if (C3404f.m4318m2(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator<E> it2 = list.iterator();
                while (it.hasNext()) {
                    if (it2.hasNext() && C3404f.m4318m2(it.next(), it2.next())) {
                    }
                }
                if (!it2.hasNext()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public AbstractC3951k<E> subList(int i, int i2) {
        C3404f.m4342s2(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        return i3 == 0 ? (AbstractC3951k<E>) C3952l.f10490l : new C3950j(this, i, i3);
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i = 0; i < size; i++) {
            iHashCode = (iHashCode * 31) + get(i).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final AbstractC3953m<E> listIterator(int i) {
        int size = size();
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException(C3404f.m4350u2(i, size, "index"));
        }
        return isEmpty() ? (AbstractC3953m<E>) f10489k : new C3949i(this, i);
    }

    @Override // java.util.List
    public final int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }
}
