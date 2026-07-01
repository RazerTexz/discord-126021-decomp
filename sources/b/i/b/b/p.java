package b.i.b.b;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: ImmutableList.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p<E> extends n<E> implements List<E>, RandomAccess {
    public static final a<Object> k = new p$b(h0.l, 0);

    public static <E> p<E> k(Object[] objArr) {
        return l(objArr, objArr.length);
    }

    public static <E> p<E> l(Object[] objArr, int i) {
        return i == 0 ? (p<E>) h0.l : new h0(objArr, i);
    }

    public static <E> p<E> m(Object... objArr) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            b.i.a.f.e.o.f.y(objArr[i], i);
        }
        return l(objArr, objArr.length);
    }

    public static <E> p<E> n(Collection<? extends E> collection) {
        if (!(collection instanceof n)) {
            return m(collection.toArray());
        }
        p<E> pVarC = ((n) collection).c();
        return pVarC.i() ? k(pVarC.toArray()) : pVarC;
    }

    public static <E> p<E> o(E[] eArr) {
        return eArr.length == 0 ? (p<E>) h0.l : m((Object[]) eArr.clone());
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E> p<E> u(E e) {
        return m(e);
    }

    public static <E> p<E> v(E e, E e2, E e3, E e4, E e5) {
        return m(e, e2, e3, e4, e5);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // b.i.b.b.n
    public final p<E> c() {
        return this;
    }

    @Override // b.i.b.b.n, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // b.i.b.b.n
    public int d(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@NullableDecl Object obj) {
        if (obj != this) {
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            int size = size();
            if (size != list.size()) {
                return false;
            }
            if (!(list instanceof RandomAccess)) {
                Iterator<E> it = iterator();
                Iterator<E> it2 = list.iterator();
                while (it.hasNext()) {
                    if (!it2.hasNext() || !b.i.a.f.e.o.f.V(it.next(), it2.next())) {
                        return false;
                    }
                }
                return !it2.hasNext();
            }
            for (int i = 0; i < size; i++) {
                if (!b.i.a.f.e.o.f.V(get(i), list.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~(get(i2).hashCode() + (i * 31)));
        }
        return i;
    }

    @Override // java.util.List
    public int indexOf(@NullableDecl Object obj) {
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

    @Override // b.i.b.b.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return p();
    }

    @Override // b.i.b.b.n
    public s0<E> j() {
        return p();
    }

    @Override // java.util.List
    public int lastIndexOf(@NullableDecl Object obj) {
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
    public /* bridge */ /* synthetic */ ListIterator listIterator() {
        return p();
    }

    public a<E> p() {
        return r(0);
    }

    public a<E> r(int i) {
        b.i.a.f.e.o.f.C(i, size());
        return isEmpty() ? (a<E>) k : new p$b(this, i);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return w(i, i2);
    }

    public p<E> w(int i, int i2) {
        b.i.a.f.e.o.f.D(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        return i3 == 0 ? (p<E>) h0.l : new p$d(this, i, i3);
    }

    @Override // b.i.b.b.n
    public Object writeReplace() {
        return new p$c(toArray());
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return r(i);
    }
}
