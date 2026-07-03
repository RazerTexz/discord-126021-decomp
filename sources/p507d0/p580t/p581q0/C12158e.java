package p507d0.p580t.p581q0;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import p507d0.p580t.AbstractC12131f;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12232e;

/* JADX INFO: renamed from: d0.t.q0.e */
/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12158e<E> extends AbstractC12131f<E> implements Set<E>, InterfaceC12232e {

    /* JADX INFO: renamed from: j */
    public final C12156c<E, ?> f25217j;

    public C12158e(C12156c<E, ?> c12156c) {
        C12238m.checkNotNullParameter(c12156c, "backing");
        this.f25217j = c12156c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        C12238m.checkNotNullParameter(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f25217j.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f25217j.containsKey(obj);
    }

    @Override // p507d0.p580t.AbstractC12131f
    public int getSize() {
        return this.f25217j.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f25217j.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return this.f25217j.keysIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.f25217j.removeKey$kotlin_stdlib(obj) >= 0;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> collection) {
        C12238m.checkNotNullParameter(collection, "elements");
        this.f25217j.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> collection) {
        C12238m.checkNotNullParameter(collection, "elements");
        this.f25217j.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }
}
