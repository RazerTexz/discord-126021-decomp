package d0.t;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Iterables.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k$a<T> implements Iterable<T>, d0.z.d.g0.a {
    public final /* synthetic */ Object[] j;

    public k$a(Object[] objArr) {
        this.j = objArr;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return d0.z.d.c.iterator(this.j);
    }
}
