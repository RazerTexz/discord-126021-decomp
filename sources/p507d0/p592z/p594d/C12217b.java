package p507d0.p592z.p594d;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: renamed from: d0.z.d.b */
/* JADX INFO: compiled from: ArrayIterator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12217b<T> implements Iterator<T>, InterfaceC12228a {

    /* JADX INFO: renamed from: j */
    public int f25277j;

    /* JADX INFO: renamed from: k */
    public final T[] f25278k;

    public C12217b(T[] tArr) {
        C12238m.checkNotNullParameter(tArr, "array");
        this.f25278k = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f25277j < this.f25278k.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f25278k;
            int i = this.f25277j;
            this.f25277j = i + 1;
            return tArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f25277j--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
