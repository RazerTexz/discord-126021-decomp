package d0.e0.p.d.m0.c.g1;

import d0.f0.q;
import d0.t.u;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements g {
    public final List<g> j;

    /* JADX WARN: Multi-variable type inference failed */
    public k(List<? extends g> list) {
        d0.z.d.m.checkNotNullParameter(list, "delegates");
        this.j = list;
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public c findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        return (c) q.firstOrNull(q.mapNotNull(u.asSequence(this.j), new k$a(bVar)));
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public boolean hasAnnotation(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        Iterator it = u.asSequence(this.j).iterator();
        while (it.hasNext()) {
            if (((g) it.next()).hasAnnotation(bVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public boolean isEmpty() {
        List<g> list = this.j;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((g) it.next()).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<c> iterator() {
        return q.flatMap(u.asSequence(this.j), k$b.j).iterator();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(g... gVarArr) {
        this((List<? extends g>) d0.t.k.toList(gVarArr));
        d0.z.d.m.checkNotNullParameter(gVarArr, "delegates");
    }
}
