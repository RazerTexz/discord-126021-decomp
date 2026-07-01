package d0.e0.p.d.m0.k;

import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.c.z;
import d0.e0.p.d.m0.k.a0.l$a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: SealedClassInheritorsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends s {
    public static final a a = new a();

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(d0.e0.p.d.m0.c.e eVar, LinkedHashSet<d0.e0.p.d.m0.c.e> linkedHashSet, d0.e0.p.d.m0.k.a0.i iVar, boolean z2) {
        for (d0.e0.p.d.m0.c.m mVar : l$a.getContributedDescriptors$default(iVar, d0.e0.p.d.m0.k.a0.d.o, null, 2, null)) {
            if (mVar instanceof d0.e0.p.d.m0.c.e) {
                d0.e0.p.d.m0.c.e eVar2 = (d0.e0.p.d.m0.c.e) mVar;
                if (e.isDirectSubclass(eVar2, eVar)) {
                    linkedHashSet.add(mVar);
                }
                if (z2) {
                    d0.e0.p.d.m0.k.a0.i unsubstitutedInnerClassesScope = eVar2.getUnsubstitutedInnerClassesScope();
                    d0.z.d.m.checkNotNullExpressionValue(unsubstitutedInnerClassesScope, "descriptor.unsubstitutedInnerClassesScope");
                    a(eVar, linkedHashSet, unsubstitutedInnerClassesScope, z2);
                }
            }
        }
    }

    public Collection<d0.e0.p.d.m0.c.e> computeSealedSubclasses(d0.e0.p.d.m0.c.e eVar, boolean z2) {
        d0.e0.p.d.m0.c.m next;
        d0.e0.p.d.m0.c.m containingDeclaration;
        d0.z.d.m.checkNotNullParameter(eVar, "sealedClass");
        if (eVar.getModality() != z.SEALED) {
            return d0.t.n.emptyList();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z2) {
            Iterator<d0.e0.p.d.m0.c.m> it = d0.e0.p.d.m0.k.x.a.getParents(eVar).iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(next instanceof e0));
            containingDeclaration = next;
        } else {
            containingDeclaration = eVar.getContainingDeclaration();
        }
        if (containingDeclaration instanceof e0) {
            a(eVar, linkedHashSet, ((e0) containingDeclaration).getMemberScope(), z2);
        }
        d0.e0.p.d.m0.k.a0.i unsubstitutedInnerClassesScope = eVar.getUnsubstitutedInnerClassesScope();
        d0.z.d.m.checkNotNullExpressionValue(unsubstitutedInnerClassesScope, "sealedClass.unsubstitutedInnerClassesScope");
        a(eVar, linkedHashSet, unsubstitutedInnerClassesScope, true);
        return linkedHashSet;
    }
}
