package b.i.b.b;

import com.google.j2objc.annotations.Weak;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: Maps.java */
/* JADX INFO: loaded from: classes3.dex */
public class z<K, V> extends AbstractCollection<V> {

    @Weak
    public final Map<K, V> j;

    public z(Map<K, V> map) {
        this.j = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.j.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(@NullableDecl Object obj) {
        return this.j.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.j.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        return new w(this.j.entrySet().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        try {
            return super.remove(obj);
        } catch (UnsupportedOperationException unused) {
            for (Map$Entry<K, V> map$Entry : this.j.entrySet()) {
                if (b.i.a.f.e.o.f.V(obj, map$Entry.getValue())) {
                    this.j.remove(map$Entry.getKey());
                    return true;
                }
            }
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        try {
            Objects.requireNonNull(collection);
            return super.removeAll(collection);
        } catch (UnsupportedOperationException unused) {
            HashSet hashSet = new HashSet();
            for (Map$Entry<K, V> map$Entry : this.j.entrySet()) {
                if (collection.contains(map$Entry.getValue())) {
                    hashSet.add(map$Entry.getKey());
                }
            }
            return this.j.keySet().removeAll(hashSet);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        try {
            Objects.requireNonNull(collection);
            return super.retainAll(collection);
        } catch (UnsupportedOperationException unused) {
            HashSet hashSet = new HashSet();
            for (Map$Entry<K, V> map$Entry : this.j.entrySet()) {
                if (collection.contains(map$Entry.getValue())) {
                    hashSet.add(map$Entry.getKey());
                }
            }
            return this.j.keySet().retainAll(hashSet);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.j.size();
    }
}
