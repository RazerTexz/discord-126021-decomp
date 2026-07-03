package p507d0.p580t.p581q0;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.q0.d */
/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12157d<K, V> extends AbstractC12154a<Map.Entry<K, V>, K, V> {

    /* JADX INFO: renamed from: j */
    public final C12156c<K, V> f25216j;

    public C12157d(C12156c<K, V> c12156c) {
        C12238m.checkNotNullParameter(c12156c, "backing");
        this.f25216j = c12156c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
        C12238m.checkNotNullParameter(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f25216j.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> collection) {
        C12238m.checkNotNullParameter(collection, "elements");
        return this.f25216j.containsAllEntries$kotlin_stdlib(collection);
    }

    @Override // p507d0.p580t.p581q0.AbstractC12154a
    public boolean containsEntry(Map.Entry<? extends K, ? extends V> entry) {
        C12238m.checkNotNullParameter(entry, "element");
        return this.f25216j.containsEntry$kotlin_stdlib(entry);
    }

    @Override // p507d0.p580t.AbstractC12131f
    public int getSize() {
        return this.f25216j.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f25216j.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.f25216j.entriesIterator$kotlin_stdlib();
    }

    @Override // p507d0.p580t.p581q0.AbstractC12154a
    public boolean remove(Map.Entry entry) {
        C12238m.checkNotNullParameter(entry, "element");
        return this.f25216j.removeEntry$kotlin_stdlib(entry);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> collection) {
        C12238m.checkNotNullParameter(collection, "elements");
        this.f25216j.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> collection) {
        C12238m.checkNotNullParameter(collection, "elements");
        this.f25216j.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Map.Entry<K, V> entry) {
        C12238m.checkNotNullParameter(entry, "element");
        throw new UnsupportedOperationException();
    }
}
