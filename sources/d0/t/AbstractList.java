package d0.t;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.t.c, reason: use source file name */
/* JADX INFO: compiled from: AbstractList.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E>, KMarkers {
    public static final a j = new a(null);

    /* JADX INFO: renamed from: d0.t.c$a */
    /* JADX INFO: compiled from: AbstractList.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final void checkElementIndex$kotlin_stdlib(int i, int i2) {
            if (i < 0 || i >= i2) {
                throw new IndexOutOfBoundsException(outline.s("index: ", i, ", size: ", i2));
            }
        }

        public final void checkPositionIndex$kotlin_stdlib(int i, int i2) {
            if (i < 0 || i > i2) {
                throw new IndexOutOfBoundsException(outline.s("index: ", i, ", size: ", i2));
            }
        }

        public final void checkRangeIndexes$kotlin_stdlib(int i, int i2, int i3) {
            if (i < 0 || i2 > i3) {
                StringBuilder sbW = outline.W("fromIndex: ", i, ", toIndex: ", i2, ", size: ");
                sbW.append(i3);
                throw new IndexOutOfBoundsException(sbW.toString());
            }
            if (i > i2) {
                throw new IllegalArgumentException(outline.s("fromIndex: ", i, " > toIndex: ", i2));
            }
        }

        public final boolean orderedEquals$kotlin_stdlib(Collection<?> collection, Collection<?> collection2) {
            Intrinsics3.checkNotNullParameter(collection, "c");
            Intrinsics3.checkNotNullParameter(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it = collection2.iterator();
            Iterator<?> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!Intrinsics3.areEqual(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int orderedHashCode$kotlin_stdlib(Collection<?> collection) {
            Intrinsics3.checkNotNullParameter(collection, "c");
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
    public class b implements Iterator<E>, KMarkers {
        public int j;

        public b() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.j < AbstractList.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AbstractList abstractList = AbstractList.this;
            int i = this.j;
            this.j = i + 1;
            return (E) abstractList.get(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: renamed from: d0.t.c$c */
    /* JADX INFO: compiled from: AbstractList.kt */
    public class c extends AbstractList<E>.b implements ListIterator<E>, KMarkers {
        public c(int i) {
            super();
            AbstractList.j.checkPositionIndex$kotlin_stdlib(i, AbstractList.this.size());
            this.j = i;
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.j > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.j;
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            AbstractList abstractList = AbstractList.this;
            int i = this.j - 1;
            this.j = i;
            return (E) abstractList.get(i);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.j - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: renamed from: d0.t.c$d */
    /* JADX INFO: compiled from: AbstractList.kt */
    public static final class d<E> extends AbstractList<E> implements RandomAccess {
        public int k;
        public final AbstractList<E> l;
        public final int m;

        /* JADX WARN: Multi-variable type inference failed */
        public d(AbstractList<? extends E> abstractList, int i, int i2) {
            Intrinsics3.checkNotNullParameter(abstractList, "list");
            this.l = abstractList;
            this.m = i;
            AbstractList.j.checkRangeIndexes$kotlin_stdlib(i, i2, abstractList.size());
            this.k = i2 - i;
        }

        @Override // d0.t.AbstractList, java.util.List
        public E get(int i) {
            AbstractList.j.checkElementIndex$kotlin_stdlib(i, this.k);
            return this.l.get(this.m + i);
        }

        @Override // d0.t.AbstractCollection
        public int getSize() {
            return this.k;
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
            return j.orderedEquals$kotlin_stdlib(this, (Collection) obj);
        }
        return false;
    }

    public abstract E get(int i);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return j.orderedHashCode$kotlin_stdlib(this);
    }

    public int indexOf(Object obj) {
        Iterator<E> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            if (Intrinsics3.areEqual(it.next(), obj)) {
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
            if (Intrinsics3.areEqual(listIterator.previous(), obj)) {
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
