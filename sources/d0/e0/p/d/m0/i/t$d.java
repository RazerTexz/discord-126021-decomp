package d0.e0.p.d.m0.i;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map$Entry;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: SmallSortedMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class t$d<K, V> extends AbstractSet<Map$Entry<K, V>> {
    public final /* synthetic */ t j;

    public t$d(t tVar, s sVar) {
        this.j = tVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return add((Map$Entry) obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.j.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Map$Entry map$Entry = (Map$Entry) obj;
        Object obj2 = this.j.get(map$Entry.getKey());
        Object value = map$Entry.getValue();
        return obj2 == value || (obj2 != null && obj2.equals(value));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map$Entry<K, V>> iterator() {
        return new t$c(this.j, null);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        Map$Entry map$Entry = (Map$Entry) obj;
        if (!contains(map$Entry)) {
            return false;
        }
        this.j.remove(map$Entry.getKey());
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.j.size();
    }

    public boolean add(Map$Entry<K, V> map$Entry) {
        if (contains(map$Entry)) {
            return false;
        }
        this.j.put((Comparable) map$Entry.getKey(), (Object) map$Entry.getValue());
        return true;
    }
}
