package b.i.b.b;

import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Iterators.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s<T> extends s0<T> {
    public boolean j;
    public final /* synthetic */ Object k;

    public s(Object obj) {
        this.k = obj;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this.j;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.j) {
            throw new NoSuchElementException();
        }
        this.j = true;
        return (T) this.k;
    }
}
