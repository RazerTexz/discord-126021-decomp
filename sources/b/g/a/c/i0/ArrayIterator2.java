package b.g.a.c.i0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: b.g.a.c.i0.b, reason: use source file name */
/* JADX INFO: compiled from: ArrayIterator.java */
/* JADX INFO: loaded from: classes3.dex */
public class ArrayIterator2<T> implements Iterator<T>, Iterable<T> {
    public final T[] j;
    public int k = 0;

    public ArrayIterator2(T[] tArr) {
        this.j = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.k < this.j.length;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this;
    }

    @Override // java.util.Iterator
    public T next() {
        int i = this.k;
        T[] tArr = this.j;
        if (i >= tArr.length) {
            throw new NoSuchElementException();
        }
        this.k = i + 1;
        return tArr[i];
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
