package b.i.b.b;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Add missing generic type declarations: [K] */
/* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public class e$c$a<K> implements Iterator<K> {

    @NullableDecl
    public Map$Entry<K, Collection<V>> j;
    public final /* synthetic */ Iterator k;
    public final /* synthetic */ e$c l;

    public e$c$a(e$c e_c, Iterator it) {
        this.l = e_c;
        this.k = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.k.hasNext();
    }

    @Override // java.util.Iterator
    public K next() {
        Map$Entry<K, Collection<V>> map$Entry = (Map$Entry) this.k.next();
        this.j = map$Entry;
        return map$Entry.getKey();
    }

    @Override // java.util.Iterator
    public void remove() {
        b.i.a.f.e.o.f.E(this.j != null);
        Collection collection = (Collection) this.j.getValue();
        this.k.remove();
        this.l.k.n -= collection.size();
        collection.clear();
        this.j = null;
    }
}
