package b.i.b.b;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: RegularImmutableMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i0$b<K> extends r<K> {
    public final transient q<K, ?> m;
    public final transient p<K> n;

    public i0$b(q<K, ?> qVar, p<K> pVar) {
        this.m = qVar;
        this.n = pVar;
    }

    @Override // b.i.b.b.r, b.i.b.b.n
    public p<K> c() {
        return this.n;
    }

    @Override // b.i.b.b.n, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        return this.m.get(obj) != null;
    }

    @Override // b.i.b.b.n
    public int d(Object[] objArr, int i) {
        return this.n.d(objArr, i);
    }

    @Override // b.i.b.b.n
    public boolean i() {
        return true;
    }

    @Override // b.i.b.b.r, b.i.b.b.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return j();
    }

    @Override // b.i.b.b.n
    public s0<K> j() {
        return this.n.p();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.m.size();
    }
}
