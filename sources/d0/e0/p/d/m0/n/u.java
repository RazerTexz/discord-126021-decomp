package d0.e0.p.d.m0.n;

import java.util.HashSet;

/* JADX INFO: compiled from: expandedTypeUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u {
    public static final d0.e0.p.d.m0.n.n1.h a(d1 d1Var, d0.e0.p.d.m0.n.n1.h hVar, HashSet<d0.e0.p.d.m0.n.n1.l> hashSet) {
        d0.e0.p.d.m0.n.n1.h hVarA;
        d0.e0.p.d.m0.n.n1.l lVarTypeConstructor = d1Var.typeConstructor(hVar);
        if (!hashSet.add(lVarTypeConstructor)) {
            return null;
        }
        d0.e0.p.d.m0.n.n1.m typeParameterClassifier = d1Var.getTypeParameterClassifier(lVarTypeConstructor);
        if (typeParameterClassifier != null) {
            hVarA = a(d1Var, d1Var.getRepresentativeUpperBound(typeParameterClassifier), hashSet);
            if (hVarA == null) {
                return null;
            }
            if (!d1Var.isNullableType(hVarA) && d1Var.isMarkedNullable(hVar)) {
                return d1Var.makeNullable(hVarA);
            }
        } else {
            if (!d1Var.isInlineClass(lVarTypeConstructor)) {
                return hVar;
            }
            d0.e0.p.d.m0.n.n1.h substitutedUnderlyingType = d1Var.getSubstitutedUnderlyingType(hVar);
            if (substitutedUnderlyingType == null || (hVarA = a(d1Var, substitutedUnderlyingType, hashSet)) == null) {
                return null;
            }
            if (d1Var.isNullableType(hVar)) {
                if (d1Var.isNullableType(hVarA)) {
                    return hVar;
                }
                return ((hVarA instanceof d0.e0.p.d.m0.n.n1.i) && d1Var.isPrimitiveType((d0.e0.p.d.m0.n.n1.i) hVarA)) ? hVar : d1Var.makeNullable(hVarA);
            }
        }
        return hVarA;
    }

    public static final d0.e0.p.d.m0.n.n1.h computeExpandedTypeForInlineClass(d1 d1Var, d0.e0.p.d.m0.n.n1.h hVar) {
        d0.z.d.m.checkNotNullParameter(d1Var, "<this>");
        d0.z.d.m.checkNotNullParameter(hVar, "inlineClassType");
        return a(d1Var, hVar, new HashSet());
    }
}
