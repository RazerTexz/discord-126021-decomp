package b.i.b.b;

import b.i.b.b.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: renamed from: b.i.b.b.p, reason: use source file name */
/* JADX INFO: compiled from: ImmutableList.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ImmutableList2<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {
    public static final AbstractIndexedListIterator<Object> k = new b(RegularImmutableList.l, 0);

    /* JADX INFO: renamed from: b.i.b.b.p$a */
    /* JADX INFO: compiled from: ImmutableList.java */
    public static final class a<E> extends ImmutableCollection.a<E> {
        public a() {
            super(4);
        }

        @CanIgnoreReturnValue
        public a<E> b(E e) {
            Objects.requireNonNull(e);
            int i = this.f1647b + 1;
            Object[] objArr = this.a;
            if (objArr.length < i) {
                this.a = Arrays.copyOf(objArr, ImmutableCollection.b.a(objArr.length, i));
                this.c = false;
            } else if (this.c) {
                this.a = (Object[]) objArr.clone();
                this.c = false;
            }
            Object[] objArr2 = this.a;
            int i2 = this.f1647b;
            this.f1647b = i2 + 1;
            objArr2[i2] = e;
            return this;
        }

        public ImmutableList2<E> c() {
            this.c = true;
            return ImmutableList2.l(this.a, this.f1647b);
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.p$b */
    /* JADX INFO: compiled from: ImmutableList.java */
    public static class b<E> extends AbstractIndexedListIterator<E> {
        public final ImmutableList2<E> l;

        public b(ImmutableList2<E> immutableList2, int i) {
            super(immutableList2.size(), i);
            this.l = immutableList2;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.p$c */
    /* JADX INFO: compiled from: ImmutableList.java */
    public static class c implements Serializable {
        private static final long serialVersionUID = 0;
        public final Object[] elements;

        public c(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            return ImmutableList2.o(this.elements);
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.p$d */
    /* JADX INFO: compiled from: ImmutableList.java */
    public class d extends ImmutableList2<E> {
        public final transient int l;
        public final transient int m;

        public d(int i, int i2) {
            this.l = i;
            this.m = i2;
        }

        @Override // b.i.b.b.ImmutableCollection
        public Object[] e() {
            return ImmutableList2.this.e();
        }

        @Override // b.i.b.b.ImmutableCollection
        public int g() {
            return ImmutableList2.this.h() + this.l + this.m;
        }

        @Override // java.util.List
        public E get(int i) {
            b.i.a.f.e.o.f.x(i, this.m);
            return ImmutableList2.this.get(i + this.l);
        }

        @Override // b.i.b.b.ImmutableCollection
        public int h() {
            return ImmutableList2.this.h() + this.l;
        }

        @Override // b.i.b.b.ImmutableCollection
        public boolean i() {
            return true;
        }

        @Override // b.i.b.b.ImmutableList2, b.i.b.b.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return listIterator();
        }

        @Override // b.i.b.b.ImmutableList2, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.m;
        }

        @Override // b.i.b.b.ImmutableList2, java.util.List
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
        public ImmutableList2<E> subList(int i, int i2) {
            b.i.a.f.e.o.f.D(i, i2, this.m);
            ImmutableList2 immutableList2 = ImmutableList2.this;
            int i3 = this.l;
            return immutableList2.subList(i + i3, i2 + i3);
        }

        @Override // b.i.b.b.ImmutableList2, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
            return listIterator(i);
        }
    }

    public static <E> ImmutableList2<E> k(Object[] objArr) {
        return l(objArr, objArr.length);
    }

    public static <E> ImmutableList2<E> l(Object[] objArr, int i) {
        return i == 0 ? (ImmutableList2<E>) RegularImmutableList.l : new RegularImmutableList(objArr, i);
    }

    public static <E> ImmutableList2<E> m(Object... objArr) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            b.i.a.f.e.o.f.y(objArr[i], i);
        }
        return l(objArr, objArr.length);
    }

    public static <E> ImmutableList2<E> n(Collection<? extends E> collection) {
        if (!(collection instanceof ImmutableCollection)) {
            return m(collection.toArray());
        }
        ImmutableList2<E> immutableList2C = ((ImmutableCollection) collection).c();
        return immutableList2C.i() ? k(immutableList2C.toArray()) : immutableList2C;
    }

    public static <E> ImmutableList2<E> o(E[] eArr) {
        return eArr.length == 0 ? (ImmutableList2<E>) RegularImmutableList.l : m((Object[]) eArr.clone());
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E> ImmutableList2<E> u(E e) {
        return m(e);
    }

    public static <E> ImmutableList2<E> v(E e, E e2, E e3, E e4, E e5) {
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

    @Override // b.i.b.b.ImmutableCollection
    public final ImmutableList2<E> c() {
        return this;
    }

    @Override // b.i.b.b.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // b.i.b.b.ImmutableCollection
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

    @Override // b.i.b.b.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return listIterator();
    }

    @Override // b.i.b.b.ImmutableCollection
    /* JADX INFO: renamed from: j */
    public UnmodifiableIterator<E> iterator() {
        return listIterator();
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
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public AbstractIndexedListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public AbstractIndexedListIterator<E> listIterator(int i) {
        b.i.a.f.e.o.f.C(i, size());
        return isEmpty() ? (AbstractIndexedListIterator<E>) k : new b(this, i);
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
    /* JADX INFO: renamed from: w */
    public ImmutableList2<E> subList(int i, int i2) {
        b.i.a.f.e.o.f.D(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        return i3 == 0 ? (ImmutableList2<E>) RegularImmutableList.l : new d(i, i3);
    }

    @Override // b.i.b.b.ImmutableCollection
    public Object writeReplace() {
        return new c(toArray());
    }
}
