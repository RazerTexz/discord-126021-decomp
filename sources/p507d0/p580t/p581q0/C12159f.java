package p507d0.p580t.p581q0;

import java.util.Collection;
import java.util.Iterator;
import p507d0.p580t.AbstractC12127d;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12229b;

/* JADX INFO: renamed from: d0.t.q0.f */
/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12159f<V> extends AbstractC12127d<V> implements Collection<V>, InterfaceC12229b {

    /* JADX INFO: renamed from: j */
    public final C12156c<?, V> f25218j;

    public C12159f(C12156c<?, V> c12156c) {
        C12238m.checkNotNullParameter(c12156c, "backing");
        this.f25218j = c12156c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends V> collection) {
        C12238m.checkNotNullParameter(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f25218j.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f25218j.containsValue(obj);
    }

    @Override // p507d0.p580t.AbstractC12127d
    public int getSize() {
        return this.f25218j.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f25218j.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        return this.f25218j.valuesIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return this.f25218j.removeValue$kotlin_stdlib(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        C12238m.checkNotNullParameter(collection, "elements");
        this.f25218j.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        C12238m.checkNotNullParameter(collection, "elements");
        this.f25218j.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }
}
