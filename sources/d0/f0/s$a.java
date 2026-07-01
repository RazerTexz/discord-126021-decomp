package d0.f0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s$a<T> implements Iterator<T>, d0.z.d.g0.a {
    public int j;
    public final Iterator<T> k;

    public s$a(s sVar) {
        this.j = s.access$getCount$p(sVar);
        this.k = s.access$getSequence$p(sVar).iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.j > 0 && this.k.hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        int i = this.j;
        if (i == 0) {
            throw new NoSuchElementException();
        }
        this.j = i - 1;
        return this.k.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
