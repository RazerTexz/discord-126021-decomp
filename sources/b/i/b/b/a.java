package b.i.b.b;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: AbstractIndexedListIterator.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<E> implements ListIterator {
    public final int j;
    public int k;

    public a(int i, int i2) {
        b.i.a.f.e.o.f.C(i2, i);
        this.j = i;
        this.k = i2;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.k < this.j;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.k > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.k;
        this.k = i + 1;
        return ((p$b) this).l.get(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.k;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.k - 1;
        this.k = i;
        return ((p$b) this).l.get(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.k - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
