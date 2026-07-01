package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.f$b;
import d0.e0.p.d.m0.n.f$b$a;
import d0.e0.p.d.m0.n.u0;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ClassicTypeCheckerContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a extends d0.e0.p.d.m0.n.f implements c {
    public static final a$a e = new a$a(null);
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final g i;

    public /* synthetic */ a(boolean z2, boolean z3, boolean z4, g gVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, (i & 2) != 0 ? true : z3, (i & 4) != 0 ? true : z4, (i & 8) != 0 ? g$a.a : gVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean areEqualTypeConstructors(d0.e0.p.d.m0.n.n1.l lVar, d0.e0.p.d.m0.n.n1.l lVar2) {
        d0.z.d.m.checkNotNullParameter(lVar, "c1");
        d0.z.d.m.checkNotNullParameter(lVar2, "c2");
        if (!(lVar instanceof u0)) {
            throw new IllegalArgumentException(b.access$errorMessage(lVar).toString());
        }
        if (lVar2 instanceof u0) {
            return areEqualTypeConstructors((u0) lVar, (u0) lVar2);
        }
        throw new IllegalArgumentException(b.access$errorMessage(lVar2).toString());
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public int argumentsCount(d0.e0.p.d.m0.n.n1.h hVar) {
        return c$a.argumentsCount(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.j asArgumentList(d0.e0.p.d.m0.n.n1.i iVar) {
        return c$a.asArgumentList(this, iVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.c asCapturedType(d0.e0.p.d.m0.n.n1.i iVar) {
        return c$a.asCapturedType(this, iVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.d asDefinitelyNotNullType(d0.e0.p.d.m0.n.n1.i iVar) {
        return c$a.asDefinitelyNotNullType(this, iVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.e asDynamicType(d0.e0.p.d.m0.n.n1.f fVar) {
        return c$a.asDynamicType(this, fVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.f asFlexibleType(d0.e0.p.d.m0.n.n1.h hVar) {
        return c$a.asFlexibleType(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n, d0.e0.p.d.m0.n.l1.c
    public d0.e0.p.d.m0.n.n1.i asSimpleType(d0.e0.p.d.m0.n.n1.h hVar) {
        return c$a.asSimpleType(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.k asTypeArgument(d0.e0.p.d.m0.n.n1.h hVar) {
        return c$a.asTypeArgument(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.i captureFromArguments(d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.b bVar) {
        return c$a.captureFromArguments(this, iVar, bVar);
    }

    @Override // d0.e0.p.d.m0.n.l1.c
    public d0.e0.p.d.m0.n.n1.h createFlexibleType(d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.i iVar2) {
        return c$a.createFlexibleType(this, iVar, iVar2);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.k getArgument(d0.e0.p.d.m0.n.n1.h hVar, int i) {
        return c$a.getArgument(this, hVar, i);
    }

    @Override // d0.e0.p.d.m0.n.d1
    public d0.e0.p.d.m0.g.c getClassFqNameUnsafe(d0.e0.p.d.m0.n.n1.l lVar) {
        return c$a.getClassFqNameUnsafe(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.m getParameter(d0.e0.p.d.m0.n.n1.l lVar, int i) {
        return c$a.getParameter(this, lVar, i);
    }

    @Override // d0.e0.p.d.m0.n.d1
    public d0.e0.p.d.m0.b.i getPrimitiveArrayType(d0.e0.p.d.m0.n.n1.l lVar) {
        return c$a.getPrimitiveArrayType(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.d1
    public d0.e0.p.d.m0.b.i getPrimitiveType(d0.e0.p.d.m0.n.n1.l lVar) {
        return c$a.getPrimitiveType(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.d1
    public d0.e0.p.d.m0.n.n1.h getRepresentativeUpperBound(d0.e0.p.d.m0.n.n1.m mVar) {
        return c$a.getRepresentativeUpperBound(this, mVar);
    }

    @Override // d0.e0.p.d.m0.n.d1
    public d0.e0.p.d.m0.n.n1.h getSubstitutedUnderlyingType(d0.e0.p.d.m0.n.n1.h hVar) {
        return c$a.getSubstitutedUnderlyingType(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.h getType(d0.e0.p.d.m0.n.n1.k kVar) {
        return c$a.getType(this, kVar);
    }

    @Override // d0.e0.p.d.m0.n.d1
    public d0.e0.p.d.m0.n.n1.m getTypeParameterClassifier(d0.e0.p.d.m0.n.n1.l lVar) {
        return c$a.getTypeParameterClassifier(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.r getVariance(d0.e0.p.d.m0.n.n1.k kVar) {
        return c$a.getVariance(this, kVar);
    }

    @Override // d0.e0.p.d.m0.n.d1
    public boolean hasAnnotation(d0.e0.p.d.m0.n.n1.h hVar, d0.e0.p.d.m0.g.b bVar) {
        return c$a.hasAnnotation(this, hVar, bVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.q
    public boolean identicalArguments(d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.i iVar2) {
        return c$a.identicalArguments(this, iVar, iVar2);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.h intersectTypes(List<? extends d0.e0.p.d.m0.n.n1.h> list) {
        return c$a.intersectTypes(this, list);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isAnyConstructor(d0.e0.p.d.m0.n.n1.l lVar) {
        return c$a.isAnyConstructor(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isClassTypeConstructor(d0.e0.p.d.m0.n.n1.l lVar) {
        return c$a.isClassTypeConstructor(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isCommonFinalClassConstructor(d0.e0.p.d.m0.n.n1.l lVar) {
        return c$a.isCommonFinalClassConstructor(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isDenotable(d0.e0.p.d.m0.n.n1.l lVar) {
        return c$a.isDenotable(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isError(d0.e0.p.d.m0.n.n1.h hVar) {
        return c$a.isError(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.f
    public boolean isErrorTypeEqualsToAnything() {
        return this.f;
    }

    @Override // d0.e0.p.d.m0.n.d1
    public boolean isInlineClass(d0.e0.p.d.m0.n.n1.l lVar) {
        return c$a.isInlineClass(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isIntegerLiteralTypeConstructor(d0.e0.p.d.m0.n.n1.l lVar) {
        return c$a.isIntegerLiteralTypeConstructor(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isIntersection(d0.e0.p.d.m0.n.n1.l lVar) {
        return c$a.isIntersection(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isMarkedNullable(d0.e0.p.d.m0.n.n1.i iVar) {
        return c$a.isMarkedNullable((c) this, iVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isNothingConstructor(d0.e0.p.d.m0.n.n1.l lVar) {
        return c$a.isNothingConstructor(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isNullableType(d0.e0.p.d.m0.n.n1.h hVar) {
        return c$a.isNullableType(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isPrimitiveType(d0.e0.p.d.m0.n.n1.i iVar) {
        return c$a.isPrimitiveType(this, iVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isProjectionNotNull(d0.e0.p.d.m0.n.n1.c cVar) {
        return c$a.isProjectionNotNull(this, cVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isStarProjection(d0.e0.p.d.m0.n.n1.k kVar) {
        return c$a.isStarProjection(this, kVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isStubType(d0.e0.p.d.m0.n.n1.i iVar) {
        return c$a.isStubType(this, iVar);
    }

    @Override // d0.e0.p.d.m0.n.f
    public boolean isStubTypeEqualsToAnything() {
        return this.g;
    }

    @Override // d0.e0.p.d.m0.n.d1
    public boolean isUnderKotlinPackage(d0.e0.p.d.m0.n.n1.l lVar) {
        return c$a.isUnderKotlinPackage(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n, d0.e0.p.d.m0.n.l1.c
    public d0.e0.p.d.m0.n.n1.i lowerBound(d0.e0.p.d.m0.n.n1.f fVar) {
        return c$a.lowerBound(this, fVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.h lowerType(d0.e0.p.d.m0.n.n1.c cVar) {
        return c$a.lowerType(this, cVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.h makeDefinitelyNotNullOrNotNull(d0.e0.p.d.m0.n.n1.h hVar) {
        return c$a.makeDefinitelyNotNullOrNotNull(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.d1
    public d0.e0.p.d.m0.n.n1.h makeNullable(d0.e0.p.d.m0.n.n1.h hVar) {
        return c$a.makeNullable(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.i original(d0.e0.p.d.m0.n.n1.d dVar) {
        return c$a.original(this, dVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public int parametersCount(d0.e0.p.d.m0.n.n1.l lVar) {
        return c$a.parametersCount(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public Collection<d0.e0.p.d.m0.n.n1.h> possibleIntegerTypes(d0.e0.p.d.m0.n.n1.i iVar) {
        return c$a.possibleIntegerTypes(this, iVar);
    }

    @Override // d0.e0.p.d.m0.n.f
    public d0.e0.p.d.m0.n.n1.h prepareType(d0.e0.p.d.m0.n.n1.h hVar) {
        d0.z.d.m.checkNotNullParameter(hVar, "type");
        if (hVar instanceof c0) {
            return l.f3529b.getDefault().transformToNewType(((c0) hVar).unwrap());
        }
        throw new IllegalArgumentException(b.access$errorMessage(hVar).toString());
    }

    @Override // d0.e0.p.d.m0.n.f
    public d0.e0.p.d.m0.n.n1.h refineType(d0.e0.p.d.m0.n.n1.h hVar) {
        d0.z.d.m.checkNotNullParameter(hVar, "type");
        if (hVar instanceof c0) {
            return this.i.refineType((c0) hVar);
        }
        throw new IllegalArgumentException(b.access$errorMessage(hVar).toString());
    }

    @Override // d0.e0.p.d.m0.n.f
    public /* bridge */ /* synthetic */ f$b substitutionSupertypePolicy(d0.e0.p.d.m0.n.n1.i iVar) {
        return substitutionSupertypePolicy(iVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public Collection<d0.e0.p.d.m0.n.n1.h> supertypes(d0.e0.p.d.m0.n.n1.l lVar) {
        return c$a.supertypes(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n, d0.e0.p.d.m0.n.l1.c
    public d0.e0.p.d.m0.n.n1.l typeConstructor(d0.e0.p.d.m0.n.n1.i iVar) {
        return c$a.typeConstructor((c) this, iVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n, d0.e0.p.d.m0.n.l1.c
    public d0.e0.p.d.m0.n.n1.i upperBound(d0.e0.p.d.m0.n.n1.f fVar) {
        return c$a.upperBound(this, fVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.h withNullability(d0.e0.p.d.m0.n.n1.h hVar, boolean z2) {
        return c$a.withNullability(this, hVar, z2);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.r getVariance(d0.e0.p.d.m0.n.n1.m mVar) {
        return c$a.getVariance(this, mVar);
    }

    @Override // d0.e0.p.d.m0.n.f
    public f$b$a substitutionSupertypePolicy(d0.e0.p.d.m0.n.n1.i iVar) {
        d0.z.d.m.checkNotNullParameter(iVar, "type");
        return e.classicSubstitutionSupertypePolicy(this, iVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n, d0.e0.p.d.m0.n.l1.c
    public d0.e0.p.d.m0.n.n1.i withNullability(d0.e0.p.d.m0.n.n1.i iVar, boolean z2) {
        return c$a.withNullability((c) this, iVar, z2);
    }

    public a(boolean z2, boolean z3, boolean z4, g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        this.f = z2;
        this.g = z3;
        this.h = z4;
        this.i = gVar;
    }

    public boolean areEqualTypeConstructors(u0 u0Var, u0 u0Var2) {
        d0.z.d.m.checkNotNullParameter(u0Var, "a");
        d0.z.d.m.checkNotNullParameter(u0Var2, "b");
        if (u0Var instanceof d0.e0.p.d.m0.k.v.n) {
            return ((d0.e0.p.d.m0.k.v.n) u0Var).checkConstructor(u0Var2);
        }
        return u0Var2 instanceof d0.e0.p.d.m0.k.v.n ? ((d0.e0.p.d.m0.k.v.n) u0Var2).checkConstructor(u0Var) : d0.z.d.m.areEqual(u0Var, u0Var2);
    }
}
