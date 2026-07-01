package d0.e0.p.d.m0.n.n1;

import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: TypeSystemContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface n extends q {

    /* JADX INFO: compiled from: TypeSystemContext.kt */
    public static final class a {
        public static List<i> fastCorrespondingSupertypes(n nVar, i iVar, l lVar) {
            Intrinsics3.checkNotNullParameter(nVar, "this");
            Intrinsics3.checkNotNullParameter(iVar, "receiver");
            Intrinsics3.checkNotNullParameter(lVar, "constructor");
            return null;
        }

        public static k get(n nVar, j jVar, int i) {
            Intrinsics3.checkNotNullParameter(nVar, "this");
            Intrinsics3.checkNotNullParameter(jVar, "receiver");
            if (jVar instanceof i) {
                return nVar.getArgument((h) jVar, i);
            }
            if (jVar instanceof d0.e0.p.d.m0.n.n1.a) {
                k kVar = ((d0.e0.p.d.m0.n.n1.a) jVar).get(i);
                Intrinsics3.checkNotNullExpressionValue(kVar, "get(index)");
                return kVar;
            }
            throw new IllegalStateException(("unknown type argument list type: " + jVar + ", " + Reflection2.getOrCreateKotlinClass(jVar.getClass())).toString());
        }

        public static k getArgumentOrNull(n nVar, i iVar, int i) {
            Intrinsics3.checkNotNullParameter(nVar, "this");
            Intrinsics3.checkNotNullParameter(iVar, "receiver");
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
            Intrinsics3.checkNotNullParameter(nVar, "this");
            Intrinsics3.checkNotNullParameter(hVar, "receiver");
            return nVar.isMarkedNullable(nVar.lowerBoundIfFlexible(hVar)) != nVar.isMarkedNullable(nVar.upperBoundIfFlexible(hVar));
        }

        public static boolean isClassType(n nVar, i iVar) {
            Intrinsics3.checkNotNullParameter(nVar, "this");
            Intrinsics3.checkNotNullParameter(iVar, "receiver");
            return nVar.isClassTypeConstructor(nVar.typeConstructor(iVar));
        }

        public static boolean isDefinitelyNotNullType(n nVar, h hVar) {
            Intrinsics3.checkNotNullParameter(nVar, "this");
            Intrinsics3.checkNotNullParameter(hVar, "receiver");
            i iVarAsSimpleType = nVar.asSimpleType(hVar);
            return (iVarAsSimpleType == null ? null : nVar.asDefinitelyNotNullType(iVarAsSimpleType)) != null;
        }

        public static boolean isDynamic(n nVar, h hVar) {
            Intrinsics3.checkNotNullParameter(nVar, "this");
            Intrinsics3.checkNotNullParameter(hVar, "receiver");
            f fVarAsFlexibleType = nVar.asFlexibleType(hVar);
            return (fVarAsFlexibleType == null ? null : nVar.asDynamicType(fVarAsFlexibleType)) != null;
        }

        public static boolean isIntegerLiteralType(n nVar, i iVar) {
            Intrinsics3.checkNotNullParameter(nVar, "this");
            Intrinsics3.checkNotNullParameter(iVar, "receiver");
            return nVar.isIntegerLiteralTypeConstructor(nVar.typeConstructor(iVar));
        }

        public static boolean isMarkedNullable(n nVar, h hVar) {
            Intrinsics3.checkNotNullParameter(nVar, "this");
            Intrinsics3.checkNotNullParameter(hVar, "receiver");
            return (hVar instanceof i) && nVar.isMarkedNullable((i) hVar);
        }

        public static boolean isNothing(n nVar, h hVar) {
            Intrinsics3.checkNotNullParameter(nVar, "this");
            Intrinsics3.checkNotNullParameter(hVar, "receiver");
            return nVar.isNothingConstructor(nVar.typeConstructor(hVar)) && !nVar.isNullableType(hVar);
        }

        public static i lowerBoundIfFlexible(n nVar, h hVar) {
            Intrinsics3.checkNotNullParameter(nVar, "this");
            Intrinsics3.checkNotNullParameter(hVar, "receiver");
            f fVarAsFlexibleType = nVar.asFlexibleType(hVar);
            if (fVarAsFlexibleType != null) {
                return nVar.lowerBound(fVarAsFlexibleType);
            }
            i iVarAsSimpleType = nVar.asSimpleType(hVar);
            Intrinsics3.checkNotNull(iVarAsSimpleType);
            return iVarAsSimpleType;
        }

        public static int size(n nVar, j jVar) {
            Intrinsics3.checkNotNullParameter(nVar, "this");
            Intrinsics3.checkNotNullParameter(jVar, "receiver");
            if (jVar instanceof i) {
                return nVar.argumentsCount((h) jVar);
            }
            if (jVar instanceof d0.e0.p.d.m0.n.n1.a) {
                return ((d0.e0.p.d.m0.n.n1.a) jVar).size();
            }
            throw new IllegalStateException(("unknown type argument list type: " + jVar + ", " + Reflection2.getOrCreateKotlinClass(jVar.getClass())).toString());
        }

        public static l typeConstructor(n nVar, h hVar) {
            Intrinsics3.checkNotNullParameter(nVar, "this");
            Intrinsics3.checkNotNullParameter(hVar, "receiver");
            i iVarAsSimpleType = nVar.asSimpleType(hVar);
            if (iVarAsSimpleType == null) {
                iVarAsSimpleType = nVar.lowerBoundIfFlexible(hVar);
            }
            return nVar.typeConstructor(iVarAsSimpleType);
        }

        public static i upperBoundIfFlexible(n nVar, h hVar) {
            Intrinsics3.checkNotNullParameter(nVar, "this");
            Intrinsics3.checkNotNullParameter(hVar, "receiver");
            f fVarAsFlexibleType = nVar.asFlexibleType(hVar);
            if (fVarAsFlexibleType != null) {
                return nVar.upperBound(fVarAsFlexibleType);
            }
            i iVarAsSimpleType = nVar.asSimpleType(hVar);
            Intrinsics3.checkNotNull(iVarAsSimpleType);
            return iVarAsSimpleType;
        }
    }

    boolean areEqualTypeConstructors(l lVar, l lVar2);

    int argumentsCount(h hVar);

    j asArgumentList(i iVar);

    c asCapturedType(i iVar);

    d asDefinitelyNotNullType(i iVar);

    e asDynamicType(f fVar);

    f asFlexibleType(h hVar);

    i asSimpleType(h hVar);

    k asTypeArgument(h hVar);

    i captureFromArguments(i iVar, b bVar);

    k getArgument(h hVar, int i);

    m getParameter(l lVar, int i);

    h getType(k kVar);

    r getVariance(k kVar);

    r getVariance(m mVar);

    h intersectTypes(List<? extends h> list);

    boolean isAnyConstructor(l lVar);

    boolean isClassTypeConstructor(l lVar);

    boolean isCommonFinalClassConstructor(l lVar);

    boolean isDenotable(l lVar);

    boolean isError(h hVar);

    boolean isIntegerLiteralTypeConstructor(l lVar);

    boolean isIntersection(l lVar);

    boolean isMarkedNullable(h hVar);

    boolean isMarkedNullable(i iVar);

    boolean isNothingConstructor(l lVar);

    boolean isNullableType(h hVar);

    boolean isPrimitiveType(i iVar);

    boolean isProjectionNotNull(c cVar);

    boolean isStarProjection(k kVar);

    boolean isStubType(i iVar);

    i lowerBound(f fVar);

    i lowerBoundIfFlexible(h hVar);

    h lowerType(c cVar);

    h makeDefinitelyNotNullOrNotNull(h hVar);

    i original(d dVar);

    int parametersCount(l lVar);

    Collection<h> possibleIntegerTypes(i iVar);

    Collection<h> supertypes(l lVar);

    l typeConstructor(h hVar);

    l typeConstructor(i iVar);

    i upperBound(f fVar);

    i upperBoundIfFlexible(h hVar);

    h withNullability(h hVar, boolean z2);

    i withNullability(i iVar, boolean z2);
}
