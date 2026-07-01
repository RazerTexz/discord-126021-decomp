package b.i.a.f.h.l;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class v3 implements Iterator {
    public int j = 0;
    public final int k;
    public final /* synthetic */ t3 l;

    public v3(t3 t3Var) {
        this.l = t3Var;
        this.k = t3Var.d();
    }

    public final byte a() {
        int i = this.j;
        if (i >= this.k) {
            throw new NoSuchElementException();
        }
        this.j = i + 1;
        return this.l.k(i);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.j < this.k;
    }

    @Override // java.util.Iterator
    public /* synthetic */ Object next() {
        return Byte.valueOf(a());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
