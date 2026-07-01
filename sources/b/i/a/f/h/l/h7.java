package b.i.a.f.h.l;

import java.util.ListIterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class h7 implements ListIterator<String> {
    public ListIterator<String> j;
    public final /* synthetic */ int k;
    public final /* synthetic */ e7 l;

    public h7(e7 e7Var, int i) {
        this.l = e7Var;
        this.k = i;
        this.j = e7Var.j.listIterator(i);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.j.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.j.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.j.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.j.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.j.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.j.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }
}
