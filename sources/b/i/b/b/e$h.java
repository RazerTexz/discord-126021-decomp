package b.i.b.b;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: Add missing generic type declarations: [K] */
/* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public class e$h<K> extends e<K, V>.e$c implements SortedSet<K> {
    public final /* synthetic */ e l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$h(e eVar, SortedMap<K, Collection<V>> sortedMap) {
        super(eVar, sortedMap);
        this.l = eVar;
    }

    public SortedMap<K, Collection<V>> c() {
        return (SortedMap) this.j;
    }

    @Override // java.util.SortedSet
    public Comparator<? super K> comparator() {
        return c().comparator();
    }

    @Override // java.util.SortedSet
    public K first() {
        return c().firstKey();
    }

    public SortedSet<K> headSet(K k) {
        return new e$h(this.l, c().headMap(k));
    }

    @Override // java.util.SortedSet
    public K last() {
        return c().lastKey();
    }

    public SortedSet<K> subSet(K k, K k2) {
        return new e$h(this.l, c().subMap(k, k2));
    }

    public SortedSet<K> tailSet(K k) {
        return new e$h(this.l, c().tailMap(k));
    }
}
