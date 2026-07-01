package d0.t;

import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: d0.t.b, reason: use source file name */
/* JADX INFO: compiled from: AbstractIterator.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractIterator3<T> implements Iterator<T>, KMarkers {
    public int j = 2;
    public T k;

    public abstract void a();

    public final void b(T t) {
        this.k = t;
        this.j = 1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i = this.j;
        if (!(i != 4)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int iH = b.c.a.y.b.h(i);
        if (iH != 0) {
            if (iH == 2) {
                return false;
            }
            this.j = 4;
            a();
            if (this.j != 1) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.j = 2;
        return this.k;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
