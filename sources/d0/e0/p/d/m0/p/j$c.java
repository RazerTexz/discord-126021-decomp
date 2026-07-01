package d0.e0.p.d.m0.p;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SmartSet.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j$c<T> implements Iterator<T>, d0.z.d.g0.a {
    public final T j;
    public boolean k = true;

    public j$c(T t) {
        this.j = t;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.k;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!this.k) {
            throw new NoSuchElementException();
        }
        this.k = false;
        return this.j;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ void remove() {
        remove();
    }

    @Override // java.util.Iterator
    public Void remove() {
        throw new UnsupportedOperationException();
    }
}
