package d0.e0.p.d.n0;

import java.util.Iterator;

/* JADX INFO: compiled from: ConsPStack.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$a<E> implements Iterator<E> {
    public a<E> j;

    public a$a(a<E> aVar) {
        this.j = aVar;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.j.m > 0;
    }

    @Override // java.util.Iterator
    public E next() {
        a<E> aVar = this.j;
        E e = aVar.k;
        this.j = aVar.l;
        return e;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
