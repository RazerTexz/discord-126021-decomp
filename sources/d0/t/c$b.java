package d0.t;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: compiled from: AbstractList.kt */
/* JADX INFO: loaded from: classes3.dex */
public class c$b<E> implements Iterator<E>, d0.z.d.g0.a {
    public int j;
    public final /* synthetic */ c k;

    public c$b(c cVar) {
        this.k = cVar;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.j < this.k.size();
    }

    @Override // java.util.Iterator
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        c cVar = this.k;
        int i = this.j;
        this.j = i + 1;
        return (E) cVar.get(i);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
