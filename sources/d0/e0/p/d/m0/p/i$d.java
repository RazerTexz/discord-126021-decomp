package d0.e0.p.d.m0.p;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SmartList.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i$d<T> implements Iterator<T> {
    public boolean j;

    public i$d(i$a i_a) {
    }

    public abstract void a();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.j;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (this.j) {
            throw new NoSuchElementException();
        }
        this.j = true;
        a();
        return (T) ((i$c) this).l.k;
    }
}
