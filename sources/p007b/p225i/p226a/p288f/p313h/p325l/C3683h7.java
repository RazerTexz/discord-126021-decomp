package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.ListIterator;

/* JADX INFO: renamed from: b.i.a.f.h.l.h7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3683h7 implements ListIterator<String> {

    /* JADX INFO: renamed from: j */
    public ListIterator<String> f9992j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ int f9993k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C3641e7 f9994l;

    public C3683h7(C3641e7 c3641e7, int i) {
        this.f9994l = c3641e7;
        this.f9993k = i;
        this.f9992j = c3641e7.f9930j.listIterator(i);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f9992j.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f9992j.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f9992j.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f9992j.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.f9992j.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f9992j.previousIndex();
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
