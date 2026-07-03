package p507d0.p580t;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p007b.p085c.p086a.p095y.C1563b;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: renamed from: d0.t.b */
/* JADX INFO: compiled from: AbstractIterator.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12123b<T> implements Iterator<T>, InterfaceC12228a {

    /* JADX INFO: renamed from: j */
    public int f25173j = 2;

    /* JADX INFO: renamed from: k */
    public T f25174k;

    /* JADX INFO: renamed from: a */
    public abstract void mo10059a();

    /* JADX INFO: renamed from: b */
    public final void m10074b(T t) {
        this.f25174k = t;
        this.f25173j = 1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i = this.f25173j;
        if (!(i != 4)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int iM758h = C1563b.m758h(i);
        if (iM758h != 0) {
            if (iM758h == 2) {
                return false;
            }
            this.f25173j = 4;
            mo10059a();
            if (this.f25173j != 1) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f25173j = 2;
        return this.f25174k;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
