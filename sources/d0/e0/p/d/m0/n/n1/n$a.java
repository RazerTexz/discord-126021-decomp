package d0.e0.p.d.m0.n.n1;

import d0.z.d.a0;
import java.util.List;

/* JADX INFO: compiled from: TypeSystemContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n$a {
    public static List<i> fastCorrespondingSupertypes(n nVar, i iVar, l lVar) {
        d0.z.d.m.checkNotNullParameter(nVar, "this");
        d0.z.d.m.checkNotNullParameter(iVar, "receiver");
        d0.z.d.m.checkNotNullParameter(lVar, "constructor");
        return null;
    }

    public static k get(n nVar, j jVar, int i) {
        d0.z.d.m.checkNotNullParameter(nVar, "this");
        d0.z.d.m.checkNotNullParameter(jVar, "receiver");
        if (jVar instanceof i) {
            return nVar.getArgument((h) jVar, i);
        }
        if (jVar instanceof a) {
            k kVar = ((a) jVar).get(i);
            d0.z.d.m.checkNotNullExpressionValue(kVar, "get(index)");
            return kVar;
        }
        throw new IllegalStateException(("unknown type argument list type: " + jVar + ", " + a0.getOrCreateKotlinClass(jVar.getClass())).toString());
    }

    public static k getArgumentOrNull(n nVar, i iVar, int i) {
        d0.z.d.m.checkNotNullParameter(nVar, "this");
        d0.z.d.m.checkNotNullParameter(iVar, "receiver");
        boolean z2 = false;
        if (i >= 0 && i < nVar.argumentsCount(iVar)) {
            z2 = true;
        }
        if (z2) {
            return nVar.getArgument(iVar, i);
        }
        return null;
    }

    public static boolean hasFlexibleNullability(n nVar, h hVar) {
        d0.z.d.m.checkNotNullParameter(nVar, "this");
        d0.z.d.m.checkNotNullParameter(hVar, "receiver");
        return nVar.isMarkedNullable(nVar.lowerBoundIfFlexible(hVar)) != nVar.isMarkedNullable(nVar.upperBoundIfFlexible(hVar));
    }

    public static boolean isClassType(n nVar, i iVar) {
        d0.z.d.m.checkNotNullParameter(nVar, "this");
        d0.z.d.m.checkNotNullParameter(iVar, "receiver");
        return nVar.isClassTypeConstructor(nVar.typeConstructor(iVar));
    }

    public static boolean isDefinitelyNotNullType(n nVar, h hVar) {
        d0.z.d.m.checkNotNullParameter(nVar, "this");
        d0.z.d.m.checkNotNullParameter(hVar, "receiver");
        i iVarAsSimpleType = nVar.asSimpleType(hVar);
        return (iVarAsSimpleType == null ? null : nVar.asDefinitelyNotNullType(iVarAsSimpleType)) != null;
    }

    public static boolean isDynamic(n nVar, h hVar) {
        d0.z.d.m.checkNotNullParameter(nVar, "this");
        d0.z.d.m.checkNotNullParameter(hVar, "receiver");
        f fVarAsFlexibleType = nVar.asFlexibleType(hVar);
        return (fVarAsFlexibleType == null ? null : nVar.asDynamicType(fVarAsFlexibleType)) != null;
    }

    public static boolean isIntegerLiteralType(n nVar, i iVar) {
        d0.z.d.m.checkNotNullParameter(nVar, "this");
        d0.z.d.m.checkNotNullParameter(iVar, "receiver");
        return nVar.isIntegerLiteralTypeConstructor(nVar.typeConstructor(iVar));
    }

    public static boolean isMarkedNullable(n nVar, h hVar) {
        d0.z.d.m.checkNotNullParameter(nVar, "this");
        d0.z.d.m.checkNotNullParameter(hVar, "receiver");
        return (hVar instanceof i) && nVar.isMarkedNullable((i) hVar);
    }

    public static boolean isNothing(n nVar, h hVar) {
        d0.z.d.m.checkNotNullParameter(nVar, "this");
        d0.z.d.m.checkNotNullParameter(hVar, "receiver");
        return nVar.isNothingConstructor(nVar.typeConstructor(hVar)) && !nVar.isNullableType(hVar);
    }

    public static i lowerBoundIfFlexible(n nVar, h hVar) {
        d0.z.d.m.checkNotNullParameter(nVar, "this");
        d0.z.d.m.checkNotNullParameter(hVar, "receiver");
        f fVarAsFlexibleType = nVar.asFlexibleType(hVar);
        if (fVarAsFlexibleType != null) {
            return nVar.lowerBound(fVarAsFlexibleType);
        }
        i iVarAsSimpleType = nVar.asSimpleType(hVar);
        d0.z.d.m.checkNotNull(iVarAsSimpleType);
        return iVarAsSimpleType;
    }

    public static int size(n nVar, j jVar) {
        d0.z.d.m.checkNotNullParameter(nVar, "this");
        d0.z.d.m.checkNotNullParameter(jVar, "receiver");
        if (jVar instanceof i) {
            return nVar.argumentsCount((h) jVar);
        }
        if (jVar instanceof a) {
            return ((a) jVar).size();
        }
        throw new IllegalStateException(("unknown type argument list type: " + jVar + ", " + a0.getOrCreateKotlinClass(jVar.getClass())).toString());
    }

    public static l typeConstructor(n nVar, h hVar) {
        d0.z.d.m.checkNotNullParameter(nVar, "this");
        d0.z.d.m.checkNotNullParameter(hVar, "receiver");
        i iVarAsSimpleType = nVar.asSimpleType(hVar);
        if (iVarAsSimpleType == null) {
            iVarAsSimpleType = nVar.lowerBoundIfFlexible(hVar);
        }
        return nVar.typeConstructor(iVarAsSimpleType);
    }

    public static i upperBoundIfFlexible(n nVar, h hVar) {
        d0.z.d.m.checkNotNullParameter(nVar, "this");
        d0.z.d.m.checkNotNullParameter(hVar, "receiver");
        f fVarAsFlexibleType = nVar.asFlexibleType(hVar);
        if (fVarAsFlexibleType != null) {
            return nVar.upperBound(fVarAsFlexibleType);
        }
        i iVarAsSimpleType = nVar.asSimpleType(hVar);
        d0.z.d.m.checkNotNull(iVarAsSimpleType);
        return iVarAsSimpleType;
    }
}
