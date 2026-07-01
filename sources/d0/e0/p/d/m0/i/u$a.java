package d0.e0.p.d.m0.i;

import java.util.ListIterator;

/* JADX INFO: compiled from: UnmodifiableLazyStringList.java */
/* JADX INFO: loaded from: classes3.dex */
public class u$a implements ListIterator<String> {
    public ListIterator<String> j;
    public final /* synthetic */ int k;
    public final /* synthetic */ u l;

    public u$a(u uVar, int i) {
        this.l = uVar;
        this.k = i;
        this.j = uVar.j.listIterator(i);
    }

    @Override // java.util.ListIterator
    public /* bridge */ /* synthetic */ void add(String str) {
        add2(str);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.j.hasNext();
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.j.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.j.nextIndex();
    }

    @Override // java.util.ListIterator
    public /* bridge */ /* synthetic */ String previous() {
        return previous2();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.j.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public /* bridge */ /* synthetic */ void set(String str) {
        set2(str);
    }

    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public void add2(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public String next() {
        return this.j.next();
    }

    @Override // java.util.ListIterator
    /* JADX INFO: renamed from: previous, reason: avoid collision after fix types in other method */
    public String previous2() {
        return this.j.previous();
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(String str) {
        throw new UnsupportedOperationException();
    }
}
