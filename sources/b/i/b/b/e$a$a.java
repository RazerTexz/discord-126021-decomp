package b.i.b.b;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public class e$a$a<K, V> extends x<K, Collection<V>> {
    public final /* synthetic */ e$a j;

    public e$a$a(e$a e_a) {
        this.j = e_a;
    }

    @Override // b.i.b.b.x, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Set<Map$Entry<K, Collection<V>>> setEntrySet = this.j.l.entrySet();
        Objects.requireNonNull(setEntrySet);
        try {
            return setEntrySet.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map$Entry<K, Collection<V>>> iterator() {
        return new e$a$b(this.j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        Collection<V> collectionRemove;
        if (!contains(obj)) {
            return false;
        }
        e eVar = this.j.m;
        Object key = ((Map$Entry) obj).getKey();
        Map<K, Collection<V>> map = eVar.m;
        Objects.requireNonNull(map);
        try {
            collectionRemove = map.remove(key);
        } catch (ClassCastException | NullPointerException unused) {
            collectionRemove = null;
        }
        Collection<V> collection = collectionRemove;
        if (collection == null) {
            return true;
        }
        int size = collection.size();
        collection.clear();
        eVar.n -= size;
        return true;
    }
}
