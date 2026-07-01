package d0.f0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$a<E> implements Iterator<E>, d0.z.d.g0.a {
    public final Iterator<T> j;
    public Iterator<? extends E> k;
    public final /* synthetic */ h l;

    public h$a(h hVar) {
        this.l = hVar;
        this.j = h.access$getSequence$p(hVar).iterator();
    }

    public final boolean a() {
        Iterator<? extends E> it = this.k;
        if (it != null && !it.hasNext()) {
            this.k = null;
        }
        while (this.k == null) {
            if (!this.j.hasNext()) {
                return false;
            }
            Iterator<? extends E> it2 = (Iterator) h.access$getIterator$p(this.l).invoke(h.access$getTransformer$p(this.l).invoke(this.j.next()));
            if (it2.hasNext()) {
                this.k = it2;
                break;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return a();
    }

    @Override // java.util.Iterator
    public E next() {
        if (!a()) {
            throw new NoSuchElementException();
        }
        Iterator<? extends E> it = this.k;
        d0.z.d.m.checkNotNull(it);
        return it.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
