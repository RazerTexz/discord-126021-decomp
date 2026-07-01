package b.i.b.b;

import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: b.i.b.b.s, reason: use source file name */
/* JADX INFO: compiled from: Iterators.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Iterators<T> extends UnmodifiableIterator<T> {
    public boolean j;
    public final /* synthetic */ Object k;

    public Iterators(Object obj) {
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
