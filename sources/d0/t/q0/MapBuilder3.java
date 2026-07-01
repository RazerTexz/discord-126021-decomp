package d0.t.q0;

import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: d0.t.q0.d, reason: use source file name */
/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MapBuilder3<K, V> extends MapBuilder<Map.Entry<K, V>, K, V> {
    public final MapBuilder2<K, V> j;

    public MapBuilder3(MapBuilder2<K, V> mapBuilder2) {
        Intrinsics3.checkNotNullParameter(mapBuilder2, "backing");
        this.j = mapBuilder2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
        Intrinsics3.checkNotNullParameter(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.j.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics3.checkNotNullParameter(collection, "elements");
        return this.j.containsAllEntries$kotlin_stdlib(collection);
    }

    @Override // d0.t.q0.MapBuilder
    public boolean containsEntry(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics3.checkNotNullParameter(entry, "element");
        return this.j.containsEntry$kotlin_stdlib(entry);
    }

    @Override // d0.t.AbstractMutableSet
    public int getSize() {
        return this.j.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.j.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.j.entriesIterator$kotlin_stdlib();
    }

    @Override // d0.t.q0.MapBuilder
    public boolean remove(Map.Entry entry) {
        Intrinsics3.checkNotNullParameter(entry, "element");
        return this.j.removeEntry$kotlin_stdlib(entry);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> collection) {
        Intrinsics3.checkNotNullParameter(collection, "elements");
        this.j.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> collection) {
        Intrinsics3.checkNotNullParameter(collection, "elements");
        this.j.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Map.Entry<K, V> entry) {
        Intrinsics3.checkNotNullParameter(entry, "element");
        throw new UnsupportedOperationException();
    }
}
