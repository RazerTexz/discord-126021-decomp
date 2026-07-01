package b.i.b.b;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e$b<T> implements Iterator<T> {
    public final Iterator<Map$Entry<K, Collection<V>>> j;

    @NullableDecl
    public K k = null;

    @MonotonicNonNullDecl
    public Collection<V> l = null;
    public Iterator<V> m = t.INSTANCE;
    public final /* synthetic */ e n;

    public e$b(e eVar) {
        this.n = eVar;
        this.j = eVar.m.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.j.hasNext() || this.m.hasNext();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [K, java.lang.Object] */
    @Override // java.util.Iterator
    public T next() {
        if (!this.m.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) this.j.next();
            this.k = map$Entry.getKey();
            Collection<V> collection = (Collection) map$Entry.getValue();
            this.l = collection;
            this.m = collection.iterator();
        }
        return (T) this.m.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.m.remove();
        if (this.l.isEmpty()) {
            this.j.remove();
        }
        e.c(this.n);
    }
}
