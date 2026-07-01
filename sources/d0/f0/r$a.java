package d0.f0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r$a<T> implements Iterator<T>, d0.z.d.g0.a {
    public final Iterator<T> j;
    public int k;
    public final /* synthetic */ r l;

    public r$a(r rVar) {
        this.l = rVar;
        this.j = r.access$getSequence$p(rVar).iterator();
    }

    public final void a() {
        while (this.k < r.access$getStartIndex$p(this.l) && this.j.hasNext()) {
            this.j.next();
            this.k++;
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        a();
        return this.k < r.access$getEndIndex$p(this.l) && this.j.hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        a();
        if (this.k >= r.access$getEndIndex$p(this.l)) {
            throw new NoSuchElementException();
        }
        this.k++;
        return this.j.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
