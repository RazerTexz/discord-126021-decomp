package b.i.b.b;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Add missing generic type declarations: [V] */
/* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public class e$i$a<V> implements Iterator<V> {
    public final Iterator<V> j;
    public final Collection<V> k;
    public final /* synthetic */ e$i l;

    public e$i$a(e$i e_i) {
        this.l = e_i;
        Collection<V> collection = e_i.k;
        this.k = collection;
        this.j = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    public void a() {
        this.l.d();
        if (this.l.k != this.k) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        a();
        return this.j.hasNext();
    }

    @Override // java.util.Iterator
    public V next() {
        a();
        return this.j.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.j.remove();
        e.c(this.l.n);
        this.l.e();
    }

    public e$i$a(e$i e_i, Iterator<V> it) {
        this.l = e_i;
        this.k = e_i.k;
        this.j = it;
    }
}
