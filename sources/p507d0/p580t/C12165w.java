package p507d0.p580t;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12227g;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: renamed from: d0.t.w */
/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12165w implements List, Serializable, RandomAccess, InterfaceC12228a {

    /* JADX INFO: renamed from: j */
    public static final C12165w f25221j = new C12165w();
    private static final long serialVersionUID = -7390468764508069838L;

    private final Object readResolve() {
        return f25221j;
    }

    @Override // java.util.List
    public /* synthetic */ void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
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

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        C12238m.checkNotNullParameter(collection, "elements");
        return collection.isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    public int getSize() {
        return 0;
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return 1;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Void) {
            return indexOf((Void) obj);
        }
        return -1;
    }

    public int indexOf(Void r2) {
        C12238m.checkNotNullParameter(r2, "element");
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return C12164v.f25220j;
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Void) {
            return lastIndexOf((Void) obj);
        }
        return -1;
    }

    public int lastIndexOf(Void r2) {
        C12238m.checkNotNullParameter(r2, "element");
        return -1;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return C12164v.f25220j;
    }

    @Override // java.util.List
    public /* synthetic */ Object remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* synthetic */ Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException(C1643a.m875s("fromIndex: ", i, ", toIndex: ", i2));
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return C12227g.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) C12227g.toArray(this, tArr);
    }

    public String toString() {
        return "[]";
    }

    @Override // java.util.List
    public Void get(int i) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + i + '.');
    }

    @Override // java.util.List
    public ListIterator listIterator(int i) {
        if (i == 0) {
            return C12164v.f25220j;
        }
        throw new IndexOutOfBoundsException(C1643a.m871q("Index: ", i));
    }
}
