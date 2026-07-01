package d0.e0.p.d.m0.n;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.d, reason: use source file name */
/* JADX INFO: compiled from: AbstractStrictEqualityTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AbstractStrictEqualityTypeChecker {
    public static final AbstractStrictEqualityTypeChecker a = new AbstractStrictEqualityTypeChecker();

    public final boolean a(d0.e0.p.d.m0.n.n1.n nVar, d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.i iVar2) {
        int iArgumentsCount;
        if (nVar.argumentsCount(iVar) == nVar.argumentsCount(iVar2) && nVar.isMarkedNullable(iVar) == nVar.isMarkedNullable(iVar2)) {
            if ((nVar.asDefinitelyNotNullType(iVar) == null) == (nVar.asDefinitelyNotNullType(iVar2) == null) && nVar.areEqualTypeConstructors(nVar.typeConstructor(iVar), nVar.typeConstructor(iVar2))) {
                if (!nVar.identicalArguments(iVar, iVar2) && (iArgumentsCount = nVar.argumentsCount(iVar)) > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        d0.e0.p.d.m0.n.n1.k argument = nVar.getArgument(iVar, i);
                        d0.e0.p.d.m0.n.n1.k argument2 = nVar.getArgument(iVar2, i);
                        if (nVar.isStarProjection(argument) != nVar.isStarProjection(argument2)) {
                            return false;
                        }
                        if (!nVar.isStarProjection(argument) && (nVar.getVariance(argument) != nVar.getVariance(argument2) || !b(nVar, nVar.getType(argument), nVar.getType(argument2)))) {
                            return false;
                        }
                        if (i2 < iArgumentsCount) {
                            i = i2;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final boolean b(d0.e0.p.d.m0.n.n1.n nVar, d0.e0.p.d.m0.n.n1.h hVar, d0.e0.p.d.m0.n.n1.h hVar2) {
        if (hVar == hVar2) {
            return true;
        }
        d0.e0.p.d.m0.n.n1.i iVarAsSimpleType = nVar.asSimpleType(hVar);
        d0.e0.p.d.m0.n.n1.i iVarAsSimpleType2 = nVar.asSimpleType(hVar2);
        if (iVarAsSimpleType != null && iVarAsSimpleType2 != null) {
            return a(nVar, iVarAsSimpleType, iVarAsSimpleType2);
        }
        d0.e0.p.d.m0.n.n1.f fVarAsFlexibleType = nVar.asFlexibleType(hVar);
        d0.e0.p.d.m0.n.n1.f fVarAsFlexibleType2 = nVar.asFlexibleType(hVar2);
        return fVarAsFlexibleType != null && fVarAsFlexibleType2 != null && a(nVar, nVar.lowerBound(fVarAsFlexibleType), nVar.lowerBound(fVarAsFlexibleType2)) && a(nVar, nVar.upperBound(fVarAsFlexibleType), nVar.upperBound(fVarAsFlexibleType2));
    }

    public final boolean strictEqualTypes(d0.e0.p.d.m0.n.n1.n nVar, d0.e0.p.d.m0.n.n1.h hVar, d0.e0.p.d.m0.n.n1.h hVar2) {
        Intrinsics3.checkNotNullParameter(nVar, "context");
        Intrinsics3.checkNotNullParameter(hVar, "a");
        Intrinsics3.checkNotNullParameter(hVar2, "b");
        return b(nVar, hVar, hVar2);
    }
}
