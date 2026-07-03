package p007b.p195g.p196a.p205c.p219i0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: b.g.a.c.i0.b */
/* JADX INFO: compiled from: ArrayIterator.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2340b<T> implements Iterator<T>, Iterable<T> {

    /* JADX INFO: renamed from: j */
    public final T[] f4941j;

    /* JADX INFO: renamed from: k */
    public int f4942k = 0;

    public C2340b(T[] tArr) {
        this.f4941j = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f4942k < this.f4941j.length;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this;
    }

    @Override // java.util.Iterator
    public T next() {
        int i = this.f4942k;
        T[] tArr = this.f4941j;
        if (i >= tArr.length) {
            throw new NoSuchElementException();
        }
        this.f4942k = i + 1;
        return tArr[i];
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
