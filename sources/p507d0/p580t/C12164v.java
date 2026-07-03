package p507d0.p580t;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: renamed from: d0.t.v */
/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12164v implements ListIterator, InterfaceC12228a {

    /* JADX INFO: renamed from: j */
    public static final C12164v f25220j = new C12164v();

    @Override // java.util.ListIterator
    public /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return false;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return 0;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return -1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Void next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public Void previous() {
        throw new NoSuchElementException();
    }
}
