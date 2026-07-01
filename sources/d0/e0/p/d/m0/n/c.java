package d0.e0.p.d.m0.n;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: AbstractTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final c a = new c();

    public final boolean a(f fVar, d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.l lVar) {
        if (fVar.isNothing(iVar)) {
            return true;
        }
        if (fVar.isMarkedNullable(iVar)) {
            return false;
        }
        if (fVar.isStubTypeEqualsToAnything() && fVar.isStubType(iVar)) {
            return true;
        }
        return fVar.areEqualTypeConstructors(fVar.typeConstructor(iVar), lVar);
    }

    public final boolean hasNotNullSupertype(f fVar, d0.e0.p.d.m0.n.n1.i iVar, f$b f_b) {
        d0.z.d.m.checkNotNullParameter(fVar, "<this>");
        d0.z.d.m.checkNotNullParameter(iVar, "type");
        d0.z.d.m.checkNotNullParameter(f_b, "supertypesPolicy");
        if (!((fVar.isClassType(iVar) && !fVar.isMarkedNullable(iVar)) || fVar.isDefinitelyNotNullType(iVar))) {
            fVar.initialize();
            ArrayDeque<d0.e0.p.d.m0.n.n1.i> supertypesDeque = fVar.getSupertypesDeque();
            d0.z.d.m.checkNotNull(supertypesDeque);
            Set<d0.e0.p.d.m0.n.n1.i> supertypesSet = fVar.getSupertypesSet();
            d0.z.d.m.checkNotNull(supertypesSet);
            supertypesDeque.push(iVar);
            while (!supertypesDeque.isEmpty()) {
                if (supertypesSet.size() > 1000) {
                    StringBuilder sbZ = b.d.b.a.a.Z("Too many supertypes for type: ", iVar, ". Supertypes = ");
                    sbZ.append(d0.t.u.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null));
                    throw new IllegalStateException(sbZ.toString().toString());
                }
                d0.e0.p.d.m0.n.n1.i iVarPop = supertypesDeque.pop();
                d0.z.d.m.checkNotNullExpressionValue(iVarPop, "current");
                if (supertypesSet.add(iVarPop)) {
                    f$b f_b2 = fVar.isMarkedNullable(iVarPop) ? f$b$c.a : f_b;
                    if (!(!d0.z.d.m.areEqual(f_b2, f$b$c.a))) {
                        f_b2 = null;
                    }
                    if (f_b2 == null) {
                        continue;
                    } else {
                        Iterator<d0.e0.p.d.m0.n.n1.h> it = fVar.supertypes(fVar.typeConstructor(iVarPop)).iterator();
                        while (it.hasNext()) {
                            d0.e0.p.d.m0.n.n1.i iVarTransformType = f_b2.transformType(fVar, it.next());
                            if ((fVar.isClassType(iVarTransformType) && !fVar.isMarkedNullable(iVarTransformType)) || fVar.isDefinitelyNotNullType(iVarTransformType)) {
                                fVar.clear();
                            } else {
                                supertypesDeque.add(iVarTransformType);
                            }
                        }
                    }
                }
            }
            fVar.clear();
            return false;
        }
        return true;
    }

    public final boolean hasPathByNotMarkedNullableNodes(f fVar, d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.l lVar) {
        d0.z.d.m.checkNotNullParameter(fVar, "<this>");
        d0.z.d.m.checkNotNullParameter(iVar, "start");
        d0.z.d.m.checkNotNullParameter(lVar, "end");
        if (a(fVar, iVar, lVar)) {
            return true;
        }
        fVar.initialize();
        ArrayDeque<d0.e0.p.d.m0.n.n1.i> supertypesDeque = fVar.getSupertypesDeque();
        d0.z.d.m.checkNotNull(supertypesDeque);
        Set<d0.e0.p.d.m0.n.n1.i> supertypesSet = fVar.getSupertypesSet();
        d0.z.d.m.checkNotNull(supertypesSet);
        supertypesDeque.push(iVar);
        while (!supertypesDeque.isEmpty()) {
            if (supertypesSet.size() > 1000) {
                StringBuilder sbZ = b.d.b.a.a.Z("Too many supertypes for type: ", iVar, ". Supertypes = ");
                sbZ.append(d0.t.u.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null));
                throw new IllegalStateException(sbZ.toString().toString());
            }
            d0.e0.p.d.m0.n.n1.i iVarPop = supertypesDeque.pop();
            d0.z.d.m.checkNotNullExpressionValue(iVarPop, "current");
            if (supertypesSet.add(iVarPop)) {
                f$b f_b = fVar.isMarkedNullable(iVarPop) ? f$b$c.a : f$b$b.a;
                if (!(!d0.z.d.m.areEqual(f_b, f$b$c.a))) {
                    f_b = null;
                }
                if (f_b == null) {
                    continue;
                } else {
                    Iterator<d0.e0.p.d.m0.n.n1.h> it = fVar.supertypes(fVar.typeConstructor(iVarPop)).iterator();
                    while (it.hasNext()) {
                        d0.e0.p.d.m0.n.n1.i iVarTransformType = f_b.transformType(fVar, it.next());
                        if (a(fVar, iVarTransformType, lVar)) {
                            fVar.clear();
                            return true;
                        }
                        supertypesDeque.add(iVarTransformType);
                    }
                }
            }
        }
        fVar.clear();
        return false;
    }

    public final boolean isPossibleSubtype(f fVar, d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.i iVar2) {
        d0.z.d.m.checkNotNullParameter(fVar, "context");
        d0.z.d.m.checkNotNullParameter(iVar, "subType");
        d0.z.d.m.checkNotNullParameter(iVar2, "superType");
        if (fVar.isMarkedNullable(iVar2) || fVar.isDefinitelyNotNullType(iVar)) {
            return true;
        }
        if (((iVar instanceof d0.e0.p.d.m0.n.n1.c) && fVar.isProjectionNotNull((d0.e0.p.d.m0.n.n1.c) iVar)) || hasNotNullSupertype(fVar, iVar, f$b$b.a)) {
            return true;
        }
        if (fVar.isDefinitelyNotNullType(iVar2) || hasNotNullSupertype(fVar, iVar2, f$b$d.a) || fVar.isClassType(iVar)) {
            return false;
        }
        return hasPathByNotMarkedNullableNodes(fVar, iVar, fVar.typeConstructor(iVar2));
    }
}
