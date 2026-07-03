package p007b.p225i.p226a.p288f.p313h.p327n;

import java.util.NoSuchElementException;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.f.h.n.i */
/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3949i<E> {

    /* JADX INFO: renamed from: j */
    public final int f10484j;

    /* JADX INFO: renamed from: k */
    public int f10485k;

    /* JADX INFO: renamed from: l */
    public final AbstractC3951k<E> f10486l;

    public C3949i(AbstractC3951k<E> abstractC3951k, int i) {
        int size = abstractC3951k.size();
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException(C3404f.m4350u2(i, size, "index"));
        }
        this.f10484j = size;
        this.f10485k = i;
        this.f10486l = abstractC3951k;
    }

    public final boolean hasNext() {
        return this.f10485k < this.f10484j;
    }

    public final boolean hasPrevious() {
        return this.f10485k > 0;
    }

    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.f10485k;
        this.f10485k = i + 1;
        return this.f10486l.get(i);
    }

    public final int nextIndex() {
        return this.f10485k;
    }

    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.f10485k - 1;
        this.f10485k = i;
        return this.f10486l.get(i);
    }

    public final int previousIndex() {
        return this.f10485k - 1;
    }
}
