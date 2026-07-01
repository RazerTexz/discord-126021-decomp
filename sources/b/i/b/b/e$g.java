package b.i.b.b;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public class e$g<K, V> extends e<K, V>.e$a implements SortedMap<K, Collection<V>> {

    @MonotonicNonNullDecl
    public SortedSet<K> n;
    public final /* synthetic */ e o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$g(e eVar, SortedMap<K, Collection<V>> sortedMap) {
        super(eVar, sortedMap);
        this.o = eVar;
    }

    public SortedSet<K> b() {
        return new e$h(this.o, d());
    }

    public SortedSet<K> c() {
        SortedSet<K> sortedSet = this.n;
        if (sortedSet != null) {
            return sortedSet;
        }
        SortedSet<K> sortedSetB = b();
        this.n = sortedSetB;
        return sortedSetB;
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return d().comparator();
    }

    public SortedMap<K, Collection<V>> d() {
        return (SortedMap) this.l;
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return d().firstKey();
    }

    public SortedMap<K, Collection<V>> headMap(K k) {
        return new e$g(this.o, d().headMap(k));
    }

    @Override // b.i.b.b.e$a, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return c();
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return d().lastKey();
    }

    public SortedMap<K, Collection<V>> subMap(K k, K k2) {
        return new e$g(this.o, d().subMap(k, k2));
    }

    public SortedMap<K, Collection<V>> tailMap(K k) {
        return new e$g(this.o, d().tailMap(k));
    }
}
