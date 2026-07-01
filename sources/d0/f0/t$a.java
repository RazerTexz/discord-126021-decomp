package d0.f0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t$a<T> implements Iterator<T>, d0.z.d.g0.a {
    public final Iterator<T> j;
    public int k = -1;
    public T l;
    public final /* synthetic */ t m;

    public t$a(t tVar) {
        this.m = tVar;
        this.j = t.access$getSequence$p(tVar).iterator();
    }

    public final void a() {
        if (this.j.hasNext()) {
            T next = this.j.next();
            if (((Boolean) t.access$getPredicate$p(this.m).invoke(next)).booleanValue()) {
                this.k = 1;
                this.l = next;
                return;
            }
        }
        this.k = 0;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.k == -1) {
            a();
        }
        return this.k == 1;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.k == -1) {
            a();
        }
        if (this.k == 0) {
            throw new NoSuchElementException();
        }
        T t = this.l;
        this.l = null;
        this.k = -1;
        return t;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
