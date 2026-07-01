package d0.e0.p.d.m0.n.n1;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: TypeSystemContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface n extends q {
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
