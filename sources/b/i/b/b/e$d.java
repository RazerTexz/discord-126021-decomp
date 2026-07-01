package b.i.b.b;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public class e$d<K, V> extends e<K, V>.e$g implements NavigableMap<K, Collection<V>> {
    public final /* synthetic */ e p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$d(e eVar, NavigableMap<K, Collection<V>> navigableMap) {
        super(eVar, navigableMap);
        this.p = eVar;
    }

    @Override // b.i.b.b.e$g
    public SortedSet b() {
        return new e$e(this.p, g());
    }

    @Override // b.i.b.b.e$g
    public /* bridge */ /* synthetic */ SortedSet c() {
        return e();
    }

    @Override // java.util.NavigableMap
    public Map$Entry<K, Collection<V>> ceilingEntry(K k) {
        Map$Entry<K, Collection<V>> map$EntryCeilingEntry = g().ceilingEntry(k);
        if (map$EntryCeilingEntry == null) {
            return null;
        }
        return a(map$EntryCeilingEntry);
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k) {
        return g().ceilingKey(k);
    }

    @Override // b.i.b.b.e$g
    public /* bridge */ /* synthetic */ SortedMap d() {
        return g();
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return ((e$d) descendingMap()).navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, Collection<V>> descendingMap() {
        return new e$d(this.p, g().descendingMap());
    }

    public NavigableSet<K> e() {
        SortedSet<K> sortedSetB = this.n;
        if (sortedSetB == null) {
            sortedSetB = b();
            this.n = sortedSetB;
        }
        return (NavigableSet) sortedSetB;
    }

    public Map$Entry<K, Collection<V>> f(Iterator<Map$Entry<K, Collection<V>>> it) {
        if (!it.hasNext()) {
            return null;
        }
        Map$Entry<K, Collection<V>> next = it.next();
        Collection<V> collectionE = this.p.e();
        collectionE.addAll(next.getValue());
        it.remove();
        K key = next.getKey();
        Objects.requireNonNull((c) this.p);
        return new o(key, Collections.unmodifiableList((List) collectionE));
    }

    @Override // java.util.NavigableMap
    public Map$Entry<K, Collection<V>> firstEntry() {
        Map$Entry<K, Collection<V>> map$EntryFirstEntry = g().firstEntry();
        if (map$EntryFirstEntry == null) {
            return null;
        }
        return a(map$EntryFirstEntry);
    }

    @Override // java.util.NavigableMap
    public Map$Entry<K, Collection<V>> floorEntry(K k) {
        Map$Entry<K, Collection<V>> map$EntryFloorEntry = g().floorEntry(k);
        if (map$EntryFloorEntry == null) {
            return null;
        }
        return a(map$EntryFloorEntry);
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k) {
        return g().floorKey(k);
    }

    public NavigableMap<K, Collection<V>> g() {
        return (NavigableMap) ((SortedMap) this.l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.i.b.b.e$g, java.util.SortedMap, java.util.NavigableMap
    public SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    @Override // java.util.NavigableMap
    public Map$Entry<K, Collection<V>> higherEntry(K k) {
        Map$Entry<K, Collection<V>> map$EntryHigherEntry = g().higherEntry(k);
        if (map$EntryHigherEntry == null) {
            return null;
        }
        return a(map$EntryHigherEntry);
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k) {
        return g().higherKey(k);
    }

    @Override // b.i.b.b.e$g, b.i.b.b.e$a, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return e();
    }

    @Override // java.util.NavigableMap
    public Map$Entry<K, Collection<V>> lastEntry() {
        Map$Entry<K, Collection<V>> map$EntryLastEntry = g().lastEntry();
        if (map$EntryLastEntry == null) {
            return null;
        }
        return a(map$EntryLastEntry);
    }

    @Override // java.util.NavigableMap
    public Map$Entry<K, Collection<V>> lowerEntry(K k) {
        Map$Entry<K, Collection<V>> map$EntryLowerEntry = g().lowerEntry(k);
        if (map$EntryLowerEntry == null) {
            return null;
        }
        return a(map$EntryLowerEntry);
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k) {
        return g().lowerKey(k);
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        return e();
    }

    @Override // java.util.NavigableMap
    public Map$Entry<K, Collection<V>> pollFirstEntry() {
        return f(entrySet().iterator());
    }

    @Override // java.util.NavigableMap
    public Map$Entry<K, Collection<V>> pollLastEntry() {
        return f(((a0) descendingMap()).entrySet().iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.i.b.b.e$g, java.util.SortedMap, java.util.NavigableMap
    public SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.i.b.b.e$g, java.util.SortedMap, java.util.NavigableMap
    public SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, Collection<V>> headMap(K k, boolean z2) {
        return new e$d(this.p, g().headMap(k, z2));
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, Collection<V>> subMap(K k, boolean z2, K k2, boolean z3) {
        return new e$d(this.p, g().subMap(k, z2, k2, z3));
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, Collection<V>> tailMap(K k, boolean z2) {
        return new e$d(this.p, g().tailMap(k, z2));
    }
}
