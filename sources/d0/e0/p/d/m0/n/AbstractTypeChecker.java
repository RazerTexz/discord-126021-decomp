package d0.e0.p.d.m0.n;

import b.d.b.a.outline;
import d0.e0.p.d.m0.n.AbstractTypeChecker3;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.c, reason: use source file name */
/* JADX INFO: compiled from: AbstractTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AbstractTypeChecker {
    public static final AbstractTypeChecker a = new AbstractTypeChecker();

    public final boolean a(AbstractTypeChecker3 abstractTypeChecker3, d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.l lVar) {
        if (abstractTypeChecker3.isNothing(iVar)) {
            return true;
        }
        if (abstractTypeChecker3.isMarkedNullable(iVar)) {
            return false;
        }
        if (abstractTypeChecker3.isStubTypeEqualsToAnything() && abstractTypeChecker3.isStubType(iVar)) {
            return true;
        }
        return abstractTypeChecker3.areEqualTypeConstructors(abstractTypeChecker3.typeConstructor(iVar), lVar);
    }

    public final boolean hasNotNullSupertype(AbstractTypeChecker3 abstractTypeChecker3, d0.e0.p.d.m0.n.n1.i iVar, AbstractTypeChecker3.b bVar) {
        Intrinsics3.checkNotNullParameter(abstractTypeChecker3, "<this>");
        Intrinsics3.checkNotNullParameter(iVar, "type");
        Intrinsics3.checkNotNullParameter(bVar, "supertypesPolicy");
        if (!((abstractTypeChecker3.isClassType(iVar) && !abstractTypeChecker3.isMarkedNullable(iVar)) || abstractTypeChecker3.isDefinitelyNotNullType(iVar))) {
            abstractTypeChecker3.initialize();
            ArrayDeque<d0.e0.p.d.m0.n.n1.i> supertypesDeque = abstractTypeChecker3.getSupertypesDeque();
            Intrinsics3.checkNotNull(supertypesDeque);
            Set<d0.e0.p.d.m0.n.n1.i> supertypesSet = abstractTypeChecker3.getSupertypesSet();
            Intrinsics3.checkNotNull(supertypesSet);
            supertypesDeque.push(iVar);
            while (!supertypesDeque.isEmpty()) {
                if (supertypesSet.size() > 1000) {
                    StringBuilder sbZ = outline.Z("Too many supertypes for type: ", iVar, ". Supertypes = ");
                    sbZ.append(_Collections.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null));
                    throw new IllegalStateException(sbZ.toString().toString());
                }
                d0.e0.p.d.m0.n.n1.i iVarPop = supertypesDeque.pop();
                Intrinsics3.checkNotNullExpressionValue(iVarPop, "current");
                if (supertypesSet.add(iVarPop)) {
                    AbstractTypeChecker3.b bVar2 = abstractTypeChecker3.isMarkedNullable(iVarPop) ? AbstractTypeChecker3.b.c.a : bVar;
                    if (!(!Intrinsics3.areEqual(bVar2, AbstractTypeChecker3.b.c.a))) {
                        bVar2 = null;
                    }
                    if (bVar2 == null) {
                        continue;
                    } else {
                        Iterator<d0.e0.p.d.m0.n.n1.h> it = abstractTypeChecker3.supertypes(abstractTypeChecker3.typeConstructor(iVarPop)).iterator();
                        while (it.hasNext()) {
                            d0.e0.p.d.m0.n.n1.i iVarTransformType = bVar2.transformType(abstractTypeChecker3, it.next());
                            if ((abstractTypeChecker3.isClassType(iVarTransformType) && !abstractTypeChecker3.isMarkedNullable(iVarTransformType)) || abstractTypeChecker3.isDefinitelyNotNullType(iVarTransformType)) {
                                abstractTypeChecker3.clear();
                            } else {
                                supertypesDeque.add(iVarTransformType);
                            }
                        }
                    }
                }
            }
            abstractTypeChecker3.clear();
            return false;
        }
        return true;
    }

    public final boolean hasPathByNotMarkedNullableNodes(AbstractTypeChecker3 abstractTypeChecker3, d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.l lVar) {
        Intrinsics3.checkNotNullParameter(abstractTypeChecker3, "<this>");
        Intrinsics3.checkNotNullParameter(iVar, "start");
        Intrinsics3.checkNotNullParameter(lVar, "end");
        if (a(abstractTypeChecker3, iVar, lVar)) {
            return true;
        }
        abstractTypeChecker3.initialize();
        ArrayDeque<d0.e0.p.d.m0.n.n1.i> supertypesDeque = abstractTypeChecker3.getSupertypesDeque();
        Intrinsics3.checkNotNull(supertypesDeque);
        Set<d0.e0.p.d.m0.n.n1.i> supertypesSet = abstractTypeChecker3.getSupertypesSet();
        Intrinsics3.checkNotNull(supertypesSet);
        supertypesDeque.push(iVar);
        while (!supertypesDeque.isEmpty()) {
            if (supertypesSet.size() > 1000) {
                StringBuilder sbZ = outline.Z("Too many supertypes for type: ", iVar, ". Supertypes = ");
                sbZ.append(_Collections.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null));
                throw new IllegalStateException(sbZ.toString().toString());
            }
            d0.e0.p.d.m0.n.n1.i iVarPop = supertypesDeque.pop();
            Intrinsics3.checkNotNullExpressionValue(iVarPop, "current");
            if (supertypesSet.add(iVarPop)) {
                AbstractTypeChecker3.b bVar = abstractTypeChecker3.isMarkedNullable(iVarPop) ? AbstractTypeChecker3.b.c.a : AbstractTypeChecker3.b.C0411b.a;
                if (!(!Intrinsics3.areEqual(bVar, AbstractTypeChecker3.b.c.a))) {
                    bVar = null;
                }
                if (bVar == null) {
                    continue;
                } else {
                    Iterator<d0.e0.p.d.m0.n.n1.h> it = abstractTypeChecker3.supertypes(abstractTypeChecker3.typeConstructor(iVarPop)).iterator();
                    while (it.hasNext()) {
                        d0.e0.p.d.m0.n.n1.i iVarTransformType = bVar.transformType(abstractTypeChecker3, it.next());
                        if (a(abstractTypeChecker3, iVarTransformType, lVar)) {
                            abstractTypeChecker3.clear();
                            return true;
                        }
                        supertypesDeque.add(iVarTransformType);
                    }
                }
            }
        }
        abstractTypeChecker3.clear();
        return false;
    }

    public final boolean isPossibleSubtype(AbstractTypeChecker3 abstractTypeChecker3, d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.i iVar2) {
        Intrinsics3.checkNotNullParameter(abstractTypeChecker3, "context");
        Intrinsics3.checkNotNullParameter(iVar, "subType");
        Intrinsics3.checkNotNullParameter(iVar2, "superType");
        if (abstractTypeChecker3.isMarkedNullable(iVar2) || abstractTypeChecker3.isDefinitelyNotNullType(iVar)) {
            return true;
        }
        if (((iVar instanceof d0.e0.p.d.m0.n.n1.c) && abstractTypeChecker3.isProjectionNotNull((d0.e0.p.d.m0.n.n1.c) iVar)) || hasNotNullSupertype(abstractTypeChecker3, iVar, AbstractTypeChecker3.b.C0411b.a)) {
            return true;
        }
        if (abstractTypeChecker3.isDefinitelyNotNullType(iVar2) || hasNotNullSupertype(abstractTypeChecker3, iVar2, AbstractTypeChecker3.b.d.a) || abstractTypeChecker3.isClassType(iVar)) {
            return false;
        }
        return hasPathByNotMarkedNullableNodes(abstractTypeChecker3, iVar, abstractTypeChecker3.typeConstructor(iVar2));
    }
}
