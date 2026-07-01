package b.i.b.b;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.b.b.r0, reason: use source file name */
/* JADX INFO: compiled from: TransformedIterator.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TransformedIterator<F, T> implements Iterator<T> {
    public final Iterator<? extends F> j;

    public TransformedIterator(Iterator<? extends F> it) {
        Objects.requireNonNull(it);
        this.j = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.j.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return (T) ((Map.Entry) this.j.next()).getValue();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.j.remove();
    }
}
