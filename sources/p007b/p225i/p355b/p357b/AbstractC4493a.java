package p007b.p225i.p355b.p357b;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.AbstractC4523p;

/* JADX INFO: renamed from: b.i.b.b.a */
/* JADX INFO: compiled from: AbstractIndexedListIterator.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4493a<E> implements ListIterator {

    /* JADX INFO: renamed from: j */
    public final int f11966j;

    /* JADX INFO: renamed from: k */
    public int f11967k;

    public AbstractC4493a(int i, int i2) {
        C3404f.m4195C(i2, i);
        this.f11966j = i;
        this.f11967k = i2;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f11967k < this.f11966j;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f11967k > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.f11967k;
        this.f11967k = i + 1;
        return ((AbstractC4523p.b) this).f12046l.get(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f11967k;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.f11967k - 1;
        this.f11967k = i;
        return ((AbstractC4523p.b) this).f12046l.get(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f11967k - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
