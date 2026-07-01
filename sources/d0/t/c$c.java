package d0.t;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: compiled from: AbstractList.kt */
/* JADX INFO: loaded from: classes3.dex */
public class c$c<E> extends c<E>.c$b implements ListIterator<E>, d0.z.d.g0.a {
    public final /* synthetic */ c l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c$c(c cVar, int i) {
        super(cVar);
        this.l = cVar;
        c.j.checkPositionIndex$kotlin_stdlib(i, cVar.size());
        this.j = i;
    }

    @Override // java.util.ListIterator
    public void add(E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.j > 0;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.j;
    }

    @Override // java.util.ListIterator
    public E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        c cVar = this.l;
        int i = this.j - 1;
        this.j = i;
        return (E) cVar.get(i);
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.j - 1;
    }

    @Override // java.util.ListIterator
    public void set(E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
