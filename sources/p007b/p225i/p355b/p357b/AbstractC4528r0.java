package p007b.p225i.p355b.p357b;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.b.b.r0 */
/* JADX INFO: compiled from: TransformedIterator.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4528r0<F, T> implements Iterator<T> {

    /* JADX INFO: renamed from: j */
    public final Iterator<? extends F> f12059j;

    public AbstractC4528r0(Iterator<? extends F> it) {
        Objects.requireNonNull(it);
        this.f12059j = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12059j.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return (T) ((Map.Entry) this.f12059j.next()).getValue();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f12059j.remove();
    }
}
