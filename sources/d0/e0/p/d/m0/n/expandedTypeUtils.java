package d0.e0.p.d.m0.n;

import d0.z.d.Intrinsics3;
import java.util.HashSet;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.u, reason: use source file name */
/* JADX INFO: compiled from: expandedTypeUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class expandedTypeUtils {
    public static final d0.e0.p.d.m0.n.n1.h a(TypeSystemCommonBackendContext typeSystemCommonBackendContext, d0.e0.p.d.m0.n.n1.h hVar, HashSet<d0.e0.p.d.m0.n.n1.l> hashSet) {
        d0.e0.p.d.m0.n.n1.h hVarA;
        d0.e0.p.d.m0.n.n1.l lVarTypeConstructor = typeSystemCommonBackendContext.typeConstructor(hVar);
        if (!hashSet.add(lVarTypeConstructor)) {
            return null;
        }
        d0.e0.p.d.m0.n.n1.m typeParameterClassifier = typeSystemCommonBackendContext.getTypeParameterClassifier(lVarTypeConstructor);
        if (typeParameterClassifier != null) {
            hVarA = a(typeSystemCommonBackendContext, typeSystemCommonBackendContext.getRepresentativeUpperBound(typeParameterClassifier), hashSet);
            if (hVarA == null) {
                return null;
            }
            if (!typeSystemCommonBackendContext.isNullableType(hVarA) && typeSystemCommonBackendContext.isMarkedNullable(hVar)) {
                return typeSystemCommonBackendContext.makeNullable(hVarA);
            }
        } else {
            if (!typeSystemCommonBackendContext.isInlineClass(lVarTypeConstructor)) {
                return hVar;
            }
            d0.e0.p.d.m0.n.n1.h substitutedUnderlyingType = typeSystemCommonBackendContext.getSubstitutedUnderlyingType(hVar);
            if (substitutedUnderlyingType == null || (hVarA = a(typeSystemCommonBackendContext, substitutedUnderlyingType, hashSet)) == null) {
                return null;
            }
            if (typeSystemCommonBackendContext.isNullableType(hVar)) {
                if (typeSystemCommonBackendContext.isNullableType(hVarA)) {
                    return hVar;
                }
                return ((hVarA instanceof d0.e0.p.d.m0.n.n1.i) && typeSystemCommonBackendContext.isPrimitiveType((d0.e0.p.d.m0.n.n1.i) hVarA)) ? hVar : typeSystemCommonBackendContext.makeNullable(hVarA);
            }
        }
        return hVarA;
    }

    public static final d0.e0.p.d.m0.n.n1.h computeExpandedTypeForInlineClass(TypeSystemCommonBackendContext typeSystemCommonBackendContext, d0.e0.p.d.m0.n.n1.h hVar) {
        Intrinsics3.checkNotNullParameter(typeSystemCommonBackendContext, "<this>");
        Intrinsics3.checkNotNullParameter(hVar, "inlineClassType");
        return a(typeSystemCommonBackendContext, hVar, new HashSet());
    }
}
