package b.i.b.b;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public class e$a<K, V> extends a0<K, Collection<V>> {
    public final transient Map<K, Collection<V>> l;
    public final /* synthetic */ e m;

    public e$a(e eVar, Map<K, Collection<V>> map) {
        this.m = eVar;
        this.l = map;
    }

    public Map$Entry<K, Collection<V>> a(Map$Entry<K, Collection<V>> map$Entry) {
        K key = map$Entry.getKey();
        e eVar = this.m;
        Collection<V> value = map$Entry.getValue();
        c cVar = (c) eVar;
        Objects.requireNonNull(cVar);
        List list = (List) value;
        return new o(key, list instanceof RandomAccess ? new e$f(cVar, key, list, null) : new e$j(cVar, key, list, null));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Map<K, Collection<V>> map = this.l;
        e eVar = this.m;
        if (map == eVar.m) {
            eVar.d();
            return;
        }
        e$a$b e_a_b = new e$a$b(this);
        while (e_a_b.hasNext()) {
            e_a_b.next();
            e_a_b.remove();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Map<K, Collection<V>> map = this.l;
        Objects.requireNonNull(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(@NullableDecl Object obj) {
        return this == obj || this.l.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Collection<V> collection;
        Map<K, Collection<V>> map = this.l;
        Objects.requireNonNull(map);
        try {
            collection = map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            collection = null;
        }
        Collection<V> collection2 = collection;
        if (collection2 == null) {
            return null;
        }
        c cVar = (c) this.m;
        Objects.requireNonNull(cVar);
        List list = (List) collection2;
        return list instanceof RandomAccess ? new e$f(cVar, obj, list, null) : new e$j(cVar, obj, list, null);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return this.l.hashCode();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> e_h;
        e eVar = this.m;
        Set<K> set = eVar.j;
        if (set == null) {
            d0 d0Var = (d0) eVar;
            Map<K, Collection<V>> map = d0Var.m;
            if (map instanceof NavigableMap) {
                e_h = new e$e<>(d0Var, (NavigableMap) d0Var.m);
            } else {
                e_h = map instanceof SortedMap ? new e$h<>(d0Var, (SortedMap) d0Var.m) : new e$c<>(d0Var, d0Var.m);
            }
            set = e_h;
            eVar.j = set;
        }
        return set;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        Collection<V> collectionRemove = this.l.remove(obj);
        if (collectionRemove == null) {
            return null;
        }
        Collection<V> collectionE = this.m.e();
        collectionE.addAll(collectionRemove);
        this.m.n -= collectionRemove.size();
        collectionRemove.clear();
        return collectionE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.l.size();
    }

    @Override // java.util.AbstractMap
    public String toString() {
        return this.l.toString();
    }
}
