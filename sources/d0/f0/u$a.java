package d0.f0;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u$a<R> implements Iterator<R>, d0.z.d.g0.a {
    public final Iterator<T> j;
    public final /* synthetic */ u k;

    public u$a(u uVar) {
        this.k = uVar;
        this.j = u.access$getSequence$p(uVar).iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.j.hasNext();
    }

    @Override // java.util.Iterator
    public R next() {
        return (R) u.access$getTransformer$p(this.k).invoke(this.j.next());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
