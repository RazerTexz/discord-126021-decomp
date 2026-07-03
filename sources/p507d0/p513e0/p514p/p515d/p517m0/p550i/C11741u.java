package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.u */
/* JADX INFO: compiled from: UnmodifiableLazyStringList.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11741u extends AbstractList<String> implements RandomAccess, InterfaceC11732l {

    /* JADX INFO: renamed from: j */
    public final InterfaceC11732l f24183j;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.u$a */
    /* JADX INFO: compiled from: UnmodifiableLazyStringList.java */
    public class a implements ListIterator<String> {

        /* JADX INFO: renamed from: j */
        public ListIterator<String> f24184j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ int f24185k;

        public a(int i) {
            this.f24185k = i;
            this.f24184j = C11741u.this.f24183j.listIterator(i);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f24184j.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f24184j.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f24184j.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f24184j.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public String next() {
            return this.f24184j.next();
        }

        @Override // java.util.ListIterator
        public String previous() {
            return this.f24184j.previous();
        }

        @Override // java.util.ListIterator
        public void set(String str) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.u$b */
    /* JADX INFO: compiled from: UnmodifiableLazyStringList.java */
    public class b implements Iterator<String> {

        /* JADX INFO: renamed from: j */
        public Iterator<String> f24187j;

        public b() {
            this.f24187j = C11741u.this.f24183j.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f24187j.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public String next() {
            return this.f24187j.next();
        }
    }

    public C11741u(InterfaceC11732l interfaceC11732l) {
        this.f24183j = interfaceC11732l;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11732l
    public void add(AbstractC11723c abstractC11723c) {
        throw new UnsupportedOperationException();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11732l
    public AbstractC11723c getByteString(int i) {
        return this.f24183j.getByteString(i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11732l
    public List<?> getUnderlyingElements() {
        return this.f24183j.getUnderlyingElements();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11732l
    public InterfaceC11732l getUnmodifiableView() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new b();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i) {
        return new a(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f24183j.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int i) {
        return this.f24183j.get(i);
    }
}
