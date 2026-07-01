package d0.e0.p.d.m0.p;

import java.util.ConcurrentModificationException;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: compiled from: SmartList.java */
/* JADX INFO: loaded from: classes3.dex */
public class i$c<E> extends i$d<E> {
    public final int k;
    public final /* synthetic */ i l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i$c(i iVar) {
        super(null);
        this.l = iVar;
        this.k = i.d(iVar);
    }

    @Override // d0.e0.p.d.m0.p.i$d
    public void a() {
        if (i.e(this.l) == this.k) {
            return;
        }
        StringBuilder sbU = b.d.b.a.a.U("ModCount: ");
        sbU.append(i.g(this.l));
        sbU.append("; expected: ");
        sbU.append(this.k);
        throw new ConcurrentModificationException(sbU.toString());
    }

    @Override // java.util.Iterator
    public void remove() {
        a();
        this.l.clear();
    }
}
