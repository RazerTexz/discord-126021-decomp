package b.i.b.b;

import java.util.AbstractCollection;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [V] */
/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v$v<V> extends AbstractCollection<V> {
    public final /* synthetic */ v j;

    public v$v(v vVar) {
        this.j = vVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.j.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.j.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.j.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        return new v$u(this.j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.j.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return v.a(this).toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) v.a(this).toArray(tArr);
    }
}
