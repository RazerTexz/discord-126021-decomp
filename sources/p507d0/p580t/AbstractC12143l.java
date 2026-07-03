package p507d0.p580t;

import java.util.Iterator;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: renamed from: d0.t.l */
/* JADX INFO: compiled from: Iterators.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12143l implements Iterator<Boolean>, InterfaceC12228a {
    public abstract boolean nextBoolean();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public final Boolean next() {
        return Boolean.valueOf(nextBoolean());
    }
}
