package d0.t;

import java.util.RandomAccess;

/* JADX INFO: compiled from: AbstractList.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$d<E> extends c<E> implements RandomAccess {
    public int k;
    public final c<E> l;
    public final int m;

    /* JADX WARN: Multi-variable type inference failed */
    public c$d(c<? extends E> cVar, int i, int i2) {
        d0.z.d.m.checkNotNullParameter(cVar, "list");
        this.l = cVar;
        this.m = i;
        c.j.checkRangeIndexes$kotlin_stdlib(i, i2, cVar.size());
        this.k = i2 - i;
    }

    @Override // d0.t.c, java.util.List
    public E get(int i) {
        c.j.checkElementIndex$kotlin_stdlib(i, this.k);
        return this.l.get(this.m + i);
    }

    @Override // d0.t.a
    public int getSize() {
        return this.k;
    }
}
