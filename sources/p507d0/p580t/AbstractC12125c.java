package p507d0.p580t;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: renamed from: d0.t.c */
/* JADX INFO: compiled from: AbstractList.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12125c<E> extends AbstractC12121a<E> implements List<E>, InterfaceC12228a {

    /* JADX INFO: renamed from: j */
    public static final a f25177j = new a(null);

    /* JADX INFO: renamed from: d0.t.c$a */
    /* JADX INFO: compiled from: AbstractList.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final void checkElementIndex$kotlin_stdlib(int i, int i2) {
            if (i < 0 || i >= i2) {
                throw new IndexOutOfBoundsException(C1643a.m875s("index: ", i, ", size: ", i2));
            }
        }

        public final void checkPositionIndex$kotlin_stdlib(int i, int i2) {
            if (i < 0 || i > i2) {
                throw new IndexOutOfBoundsException(C1643a.m875s("index: ", i, ", size: ", i2));
            }
        }

        public final void checkRangeIndexes$kotlin_stdlib(int i, int i2, int i3) {
            if (i < 0 || i2 > i3) {
                StringBuilder sbM835W = C1643a.m835W("fromIndex: ", i, ", toIndex: ", i2, ", size: ");
                sbM835W.append(i3);
                throw new IndexOutOfBoundsException(sbM835W.toString());
            }
            if (i > i2) {
                throw new IllegalArgumentException(C1643a.m875s("fromIndex: ", i, " > toIndex: ", i2));
            }
        }

        public final boolean orderedEquals$kotlin_stdlib(Collection<?> collection, Collection<?> collection2) {
            C12238m.checkNotNullParameter(collection, "c");
            C12238m.checkNotNullParameter(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it = collection2.iterator();
            Iterator<?> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!C12238m.areEqual(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int orderedHashCode$kotlin_stdlib(Collection<?> collection) {
            C12238m.checkNotNullParameter(collection, "c");
            Iterator<?> it = collection.iterator();
            int iHashCode = 1;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
            }
            return iHashCode;
        }
    }

    /* JADX INFO: renamed from: d0.t.c$b */
    /* JADX INFO: compiled from: AbstractList.kt */
    public class b implements Iterator<E>, InterfaceC12228a {

        /* JADX INFO: renamed from: j */
        public int f25178j;

        public b() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25178j < AbstractC12125c.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AbstractC12125c abstractC12125c = AbstractC12125c.this;
            int i = this.f25178j;
            this.f25178j = i + 1;
            return (E) abstractC12125c.get(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: renamed from: d0.t.c$c */
    /* JADX INFO: compiled from: AbstractList.kt */
    public class c extends AbstractC12125c<E>.b implements ListIterator<E>, InterfaceC12228a {
        public c(int i) {
            super();
            AbstractC12125c.f25177j.checkPositionIndex$kotlin_stdlib(i, AbstractC12125c.this.size());
            this.f25178j = i;
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f25178j > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f25178j;
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            AbstractC12125c abstractC12125c = AbstractC12125c.this;
            int i = this.f25178j - 1;
            this.f25178j = i;
            return (E) abstractC12125c.get(i);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f25178j - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: renamed from: d0.t.c$d */
    /* JADX INFO: compiled from: AbstractList.kt */
    public static final class d<E> extends AbstractC12125c<E> implements RandomAccess {

        /* JADX INFO: renamed from: k */
        public int f25181k;

        /* JADX INFO: renamed from: l */
        public final AbstractC12125c<E> f25182l;

        /* JADX INFO: renamed from: m */
        public final int f25183m;

        /* JADX WARN: Multi-variable type inference failed */
        public d(AbstractC12125c<? extends E> abstractC12125c, int i, int i2) {
            C12238m.checkNotNullParameter(abstractC12125c, "list");
            this.f25182l = abstractC12125c;
            this.f25183m = i;
            AbstractC12125c.f25177j.checkRangeIndexes$kotlin_stdlib(i, i2, abstractC12125c.size());
            this.f25181k = i2 - i;
        }

        @Override // p507d0.p580t.AbstractC12125c, java.util.List
        public E get(int i) {
            AbstractC12125c.f25177j.checkElementIndex$kotlin_stdlib(i, this.f25181k);
            return this.f25182l.get(this.f25183m + i);
        }

        @Override // p507d0.p580t.AbstractC12121a
        public int getSize() {
            return this.f25181k;
        }
    }

    @Override // java.util.List
    public void add(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return f25177j.orderedEquals$kotlin_stdlib(this, (Collection) obj);
        }
        return false;
    }

    public abstract E get(int i);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return f25177j.orderedHashCode$kotlin_stdlib(this);
    }

    public int indexOf(Object obj) {
        Iterator<E> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            if (C12238m.areEqual(it.next(), obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new b();
    }

    public int lastIndexOf(Object obj) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (C12238m.areEqual(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public E remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        return new d(this, i, i2);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        return new c(i);
    }
}
