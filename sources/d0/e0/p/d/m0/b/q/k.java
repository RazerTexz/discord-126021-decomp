package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.p.b$c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements b$c<d0.e0.p.d.m0.c.e> {
    public final /* synthetic */ g a;

    public k(g gVar) {
        this.a = gVar;
    }

    @Override // d0.e0.p.d.m0.p.b$c
    public /* bridge */ /* synthetic */ Iterable<? extends d0.e0.p.d.m0.c.e> getNeighbors(d0.e0.p.d.m0.c.e eVar) {
        return getNeighbors2(eVar);
    }

    /* JADX INFO: renamed from: getNeighbors, reason: avoid collision after fix types in other method */
    public final Iterable<d0.e0.p.d.m0.c.e> getNeighbors2(d0.e0.p.d.m0.c.e eVar) {
        Collection<c0> supertypes = eVar.getTypeConstructor().getSupertypes();
        d0.z.d.m.checkNotNullExpressionValue(supertypes, "it.typeConstructor.supertypes");
        g gVar = this.a;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            d0.e0.p.d.m0.c.h declarationDescriptor = ((c0) it.next()).getConstructor().getDeclarationDescriptor();
            d0.e0.p.d.m0.c.h original = declarationDescriptor == null ? null : declarationDescriptor.getOriginal();
            d0.e0.p.d.m0.c.e eVar2 = original instanceof d0.e0.p.d.m0.c.e ? (d0.e0.p.d.m0.c.e) original : null;
            d0.e0.p.d.m0.e.a.i0.l.f fVarAccess$getJavaAnalogue = eVar2 != null ? g.access$getJavaAnalogue(gVar, eVar2) : null;
            if (fVarAccess$getJavaAnalogue != null) {
                arrayList.add(fVarAccess$getJavaAnalogue);
            }
        }
        return arrayList;
    }
}
