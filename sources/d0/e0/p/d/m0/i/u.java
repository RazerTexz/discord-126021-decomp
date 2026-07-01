package d0.e0.p.d.m0.i;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: UnmodifiableLazyStringList.java */
/* JADX INFO: loaded from: classes3.dex */
public class u extends AbstractList<String> implements RandomAccess, l {
    public final l j;

    public u(l lVar) {
        this.j = lVar;
    }

    @Override // d0.e0.p.d.m0.i.l
    public void add(c cVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int i) {
        return get(i);
    }

    @Override // d0.e0.p.d.m0.i.l
    public c getByteString(int i) {
        return this.j.getByteString(i);
    }

    @Override // d0.e0.p.d.m0.i.l
    public List<?> getUnderlyingElements() {
        return this.j.getUnderlyingElements();
    }

    @Override // d0.e0.p.d.m0.i.l
    public l getUnmodifiableView() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new u$b(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i) {
        return new u$a(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.j.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int i) {
        return this.j.get(i);
    }
}
