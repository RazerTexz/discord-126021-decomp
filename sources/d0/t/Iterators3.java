package d0.t;

import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;

/* JADX INFO: renamed from: d0.t.b0, reason: use source file name */
/* JADX INFO: compiled from: Iterators.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Iterators3<T> implements Iterator<IndexedValue<? extends T>>, KMarkers {
    public int j;
    public final Iterator<T> k;

    /* JADX WARN: Multi-variable type inference failed */
    public Iterators3(Iterator<? extends T> it) {
        Intrinsics3.checkNotNullParameter(it, "iterator");
        this.k = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.k.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public final IndexedValue<T> next() {
        int i = this.j;
        this.j = i + 1;
        if (i < 0) {
            Collections2.throwIndexOverflow();
        }
        return new IndexedValue<>(i, this.k.next());
    }
}
