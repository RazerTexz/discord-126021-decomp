package b.i.b.b;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public class e$c<K, V> extends y<K, Collection<V>> {
    public final /* synthetic */ e k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$c(e eVar, Map<K, Collection<V>> map) {
        super(map);
        this.k = eVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        Iterator<K> it = iterator();
        while (true) {
            e$c$a e_c_a = (e$c$a) it;
            if (!e_c_a.hasNext()) {
                return;
            }
            e_c_a.next();
            e_c_a.remove();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        return this.j.keySet().containsAll(collection);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        return this == obj || this.j.keySet().equals(obj);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.j.keySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<K> iterator() {
        return new e$c$a(this, this.j.entrySet().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int size;
        Collection collection = (Collection) this.j.remove(obj);
        if (collection != null) {
            size = collection.size();
            collection.clear();
            this.k.n -= size;
        } else {
            size = 0;
        }
        return size > 0;
    }
}
