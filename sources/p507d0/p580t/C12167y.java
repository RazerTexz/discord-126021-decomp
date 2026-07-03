package p507d0.p580t;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import p507d0.p592z.p594d.C12227g;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: renamed from: d0.t.y */
/* JADX INFO: compiled from: Sets.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12167y implements Set, Serializable, InterfaceC12228a {

    /* JADX INFO: renamed from: j */
    public static final C12167y f25223j = new C12167y();
    private static final long serialVersionUID = 3406603774387020532L;

    private final Object readResolve() {
        return f25223j;
    }

    @Override // java.util.Set, java.util.Collection
    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Void) {
            return contains((Void) obj);
        }
        return false;
    }

    public boolean contains(Void r2) {
        C12238m.checkNotNullParameter(r2, "element");
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection collection) {
        C12238m.checkNotNullParameter(collection, "elements");
        return collection.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    public int getSize() {
        return 0;
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return C12164v.f25220j;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return C12227g.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) C12227g.toArray(this, tArr);
    }

    public String toString() {
        return "[]";
    }
}
