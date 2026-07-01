package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.c.g1.g$b;
import java.util.Iterator;

/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements d0.e0.p.d.m0.c.g1.g {
    public final d0.e0.p.d.m0.g.b j;

    public b(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqNameToMatch");
        this.j = bVar;
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.g1.c findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        return findAnnotation(bVar);
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public boolean hasAnnotation(d0.e0.p.d.m0.g.b bVar) {
        return g$b.hasAnnotation(this, bVar);
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<d0.e0.p.d.m0.c.g1.c> iterator() {
        return d0.t.n.emptyList().iterator();
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public a findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        if (d0.z.d.m.areEqual(bVar, this.j)) {
            return a.a;
        }
        return null;
    }
}
