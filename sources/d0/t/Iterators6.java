package d0.t;

import d0.z.d.g0.KMarkers;
import java.util.Iterator;

/* JADX INFO: renamed from: d0.t.l, reason: use source file name */
/* JADX INFO: compiled from: Iterators.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Iterators6 implements Iterator<Boolean>, KMarkers {
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
