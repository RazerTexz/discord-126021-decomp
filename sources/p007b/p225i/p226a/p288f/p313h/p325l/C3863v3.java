package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: b.i.a.f.h.l.v3 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3863v3 implements Iterator {

    /* JADX INFO: renamed from: j */
    public int f10360j = 0;

    /* JADX INFO: renamed from: k */
    public final int f10361k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ AbstractC3837t3 f10362l;

    public C3863v3(AbstractC3837t3 abstractC3837t3) {
        this.f10362l = abstractC3837t3;
        this.f10361k = abstractC3837t3.mo5282d();
    }

    /* JADX INFO: renamed from: a */
    public final byte m5332a() {
        int i = this.f10360j;
        if (i >= this.f10361k) {
            throw new NoSuchElementException();
        }
        this.f10360j = i + 1;
        return this.f10362l.mo5287k(i);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f10360j < this.f10361k;
    }

    @Override // java.util.Iterator
    public /* synthetic */ Object next() {
        return Byte.valueOf(m5332a());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
