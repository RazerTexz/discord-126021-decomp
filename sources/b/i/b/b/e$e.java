package b.i.b.b;

import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: Add missing generic type declarations: [K] */
/* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public class e$e<K> extends e<K, V>.e$h implements NavigableSet<K> {
    public final /* synthetic */ e m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$e(e eVar, NavigableMap<K, Collection<V>> navigableMap) {
        super(eVar, navigableMap);
        this.m = eVar;
    }

    @Override // b.i.b.b.e$h
    public /* bridge */ /* synthetic */ SortedMap c() {
        return d();
    }

    @Override // java.util.NavigableSet
    public K ceiling(K k) {
        return d().ceilingKey(k);
    }

    public NavigableMap<K, Collection<V>> d() {
        return (NavigableMap) ((SortedMap) this.j);
    }

    @Override // java.util.NavigableSet
    public Iterator<K> descendingIterator() {
        return ((e$c) descendingSet()).iterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<K> descendingSet() {
        return new e$e(this.m, d().descendingMap());
    }

    @Override // java.util.NavigableSet
    public K floor(K k) {
        return d().floorKey(k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.i.b.b.e$h, java.util.SortedSet, java.util.NavigableSet
    public SortedSet headSet(Object obj) {
        return headSet(obj, false);
    }

    @Override // java.util.NavigableSet
    public K higher(K k) {
        return d().higherKey(k);
    }

    @Override // java.util.NavigableSet
    public K lower(K k) {
        return d().lowerKey(k);
    }

    @Override // java.util.NavigableSet
    public K pollFirst() {
        e$c$a e_c_a = (e$c$a) iterator();
        if (!e_c_a.hasNext()) {
            return null;
        }
        K k = (K) e_c_a.next();
        e_c_a.remove();
        return k;
    }

    @Override // java.util.NavigableSet
    public K pollLast() {
        Iterator<K> itDescendingIterator = descendingIterator();
        if (!itDescendingIterator.hasNext()) {
            return null;
        }
        K next = itDescendingIterator.next();
        itDescendingIterator.remove();
        return next;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.i.b.b.e$h, java.util.SortedSet, java.util.NavigableSet
    public SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.i.b.b.e$h, java.util.SortedSet, java.util.NavigableSet
    public SortedSet tailSet(Object obj) {
        return tailSet(obj, true);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<K> headSet(K k, boolean z2) {
        return new e$e(this.m, d().headMap(k, z2));
    }

    @Override // java.util.NavigableSet
    public NavigableSet<K> subSet(K k, boolean z2, K k2, boolean z3) {
        return new e$e(this.m, d().subMap(k, z2, k2, z3));
    }

    @Override // java.util.NavigableSet
    public NavigableSet<K> tailSet(K k, boolean z2) {
        return new e$e(this.m, d().tailMap(k, z2));
    }
}
