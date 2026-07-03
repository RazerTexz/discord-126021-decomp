package p507d0.p580t;

import java.util.Iterator;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: renamed from: d0.t.b0 */
/* JADX INFO: compiled from: Iterators.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12124b0<T> implements Iterator<C12168z<? extends T>>, InterfaceC12228a {

    /* JADX INFO: renamed from: j */
    public int f25175j;

    /* JADX INFO: renamed from: k */
    public final Iterator<T> f25176k;

    /* JADX WARN: Multi-variable type inference failed */
    public C12124b0(Iterator<? extends T> it) {
        C12238m.checkNotNullParameter(it, "iterator");
        this.f25176k = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f25176k.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public final C12168z<T> next() {
        int i = this.f25175j;
        this.f25175j = i + 1;
        if (i < 0) {
            C12147n.throwIndexOverflow();
        }
        return new C12168z<>(i, this.f25176k.next());
    }
}
