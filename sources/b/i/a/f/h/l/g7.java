package b.i.a.f.h.l;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class g7 implements Iterator<String> {
    public Iterator<String> j;
    public final /* synthetic */ e7 k;

    public g7(e7 e7Var) {
        this.k = e7Var;
        this.j = e7Var.j.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.j.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.j.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
