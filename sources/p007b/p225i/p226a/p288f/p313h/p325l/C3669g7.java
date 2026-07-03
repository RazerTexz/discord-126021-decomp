package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.Iterator;

/* JADX INFO: renamed from: b.i.a.f.h.l.g7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3669g7 implements Iterator<String> {

    /* JADX INFO: renamed from: j */
    public Iterator<String> f9972j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C3641e7 f9973k;

    public C3669g7(C3641e7 c3641e7) {
        this.f9973k = c3641e7;
        this.f9972j = c3641e7.f9930j.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9972j.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f9972j.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
