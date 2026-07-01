package d0.f0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g$a<T> implements Iterator<T>, d0.z.d.g0.a {
    public final Iterator<T> j;
    public int k = -1;
    public T l;
    public final /* synthetic */ g m;

    public g$a(g gVar) {
        this.m = gVar;
        this.j = g.access$getSequence$p(gVar).iterator();
    }

    public final void a() {
        while (this.j.hasNext()) {
            T next = this.j.next();
            if (((Boolean) g.access$getPredicate$p(this.m).invoke(next)).booleanValue() == g.access$getSendWhen$p(this.m)) {
                this.l = next;
                this.k = 1;
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
