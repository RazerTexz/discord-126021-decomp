package b.i.b.b;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public class e$a$b<K, V> implements Iterator<Map$Entry<K, Collection<V>>> {
    public final Iterator<Map$Entry<K, Collection<V>>> j;

    @NullableDecl
    public Collection<V> k;
    public final /* synthetic */ e$a l;

    public e$a$b(e$a e_a) {
        this.l = e_a;
        this.j = e_a.l.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.j.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        Map$Entry<K, Collection<V>> next = this.j.next();
        this.k = next.getValue();
        return this.l.a(next);
    }

    @Override // java.util.Iterator
    public void remove() {
        b.i.a.f.e.o.f.E(this.k != null);
        this.j.remove();
        this.l.m.n -= this.k.size();
        this.k.clear();
        this.k = null;
    }
}
