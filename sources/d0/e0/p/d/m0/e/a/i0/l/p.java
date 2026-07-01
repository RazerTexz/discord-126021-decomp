package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.p.b$c;
import d0.t.u;
import java.util.Collection;

/* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p implements b$c<d0.e0.p.d.m0.c.e> {
    public static final p a = new p();

    @Override // d0.e0.p.d.m0.p.b$c
    public /* bridge */ /* synthetic */ Iterable<? extends d0.e0.p.d.m0.c.e> getNeighbors(d0.e0.p.d.m0.c.e eVar) {
        return getNeighbors2(eVar);
    }

    /* JADX INFO: renamed from: getNeighbors, reason: avoid collision after fix types in other method */
    public final Iterable<d0.e0.p.d.m0.c.e> getNeighbors2(d0.e0.p.d.m0.c.e eVar) {
        Collection<c0> supertypes = eVar.getTypeConstructor().getSupertypes();
        d0.z.d.m.checkNotNullExpressionValue(supertypes, "it.typeConstructor.supertypes");
        return d0.f0.q.asIterable(d0.f0.q.mapNotNull(u.asSequence(supertypes), p$a.j));
    }
}
