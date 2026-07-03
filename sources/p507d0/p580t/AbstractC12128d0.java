package p507d0.p580t;

import java.util.Iterator;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: renamed from: d0.t.d0 */
/* JADX INFO: compiled from: Iterators.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12128d0 implements Iterator<Long>, InterfaceC12228a {
    public abstract long nextLong();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public final Long next() {
        return Long.valueOf(nextLong());
    }
}
