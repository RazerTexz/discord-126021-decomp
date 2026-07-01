package d0.t;

import java.util.Iterator;

/* JADX INFO: compiled from: Iterators.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b0<T> implements Iterator<z<? extends T>>, d0.z.d.g0.a {
    public int j;
    public final Iterator<T> k;

    /* JADX WARN: Multi-variable type inference failed */
    public b0(Iterator<? extends T> it) {
        d0.z.d.m.checkNotNullParameter(it, "iterator");
        this.k = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.k.hasNext();
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public final z<T> next() {
        int i = this.j;
        this.j = i + 1;
        if (i < 0) {
            n.throwIndexOverflow();
        }
        return new z<>(i, this.k.next());
    }
}
