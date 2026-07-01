package d0.e0.p.d.m0.p;

import d0.z.d.m;
import java.util.Iterator;

/* JADX INFO: compiled from: SmartSet.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j$a<T> implements Iterator<T>, d0.z.d.g0.a {
    public final Iterator<T> j;

    public j$a(T[] tArr) {
        m.checkNotNullParameter(tArr, "array");
        this.j = d0.z.d.c.iterator(tArr);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.j.hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        return this.j.next();
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ void remove() {
        remove();
    }

    @Override // java.util.Iterator
    public Void remove() {
        throw new UnsupportedOperationException();
    }
}
