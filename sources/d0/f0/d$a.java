package d0.f0;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a<T> implements Iterator<T>, d0.z.d.g0.a {
    public final Iterator<T> j;
    public int k;

    public d$a(d dVar) {
        this.j = d.access$getSequence$p(dVar).iterator();
        this.k = d.access$getCount$p(dVar);
    }

    public final void a() {
        while (this.k > 0 && this.j.hasNext()) {
            this.j.next();
            this.k--;
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        a();
        return this.j.hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        a();
        return this.j.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
