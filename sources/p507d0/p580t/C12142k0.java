package p507d0.p580t;

import java.util.List;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.k0 */
/* JADX INFO: compiled from: ReversedViews.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12142k0<T> extends AbstractC12125c<T> {

    /* JADX INFO: renamed from: k */
    public final List<T> f25190k;

    /* JADX WARN: Multi-variable type inference failed */
    public C12142k0(List<? extends T> list) {
        C12238m.checkNotNullParameter(list, "delegate");
        this.f25190k = list;
    }

    @Override // p507d0.p580t.AbstractC12125c, java.util.List
    public T get(int i) {
        return this.f25190k.get(C12161s.access$reverseElementIndex(this, i));
    }

    @Override // p507d0.p580t.AbstractC12121a
    public int getSize() {
        return this.f25190k.size();
    }
}
