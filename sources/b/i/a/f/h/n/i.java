package b.i.a.f.h.n;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class i<E> {
    public final int j;
    public int k;
    public final k<E> l;

    public i(k<E> kVar, int i) {
        int size = kVar.size();
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException(b.i.a.f.e.o.f.u2(i, size, "index"));
        }
        this.j = size;
        this.k = i;
        this.l = kVar;
    }

    public final boolean hasNext() {
        return this.k < this.j;
    }

    public final boolean hasPrevious() {
        return this.k > 0;
    }

    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.k;
        this.k = i + 1;
        return this.l.get(i);
    }

    public final int nextIndex() {
        return this.k;
    }

    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.k - 1;
        this.k = i;
        return this.l.get(i);
    }

    public final int previousIndex() {
        return this.k - 1;
    }
}
