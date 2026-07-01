package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.b.PrimitiveType;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.FqNameUnsafe;
import d0.e0.p.d.m0.n.AbstractTypeChecker3;
import d0.e0.p.d.m0.n.l1.ClassicTypeSystemContext;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.p, reason: use source file name */
/* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NewKotlinTypeChecker4 implements ClassicTypeSystemContext {
    public static final NewKotlinTypeChecker4 a = new NewKotlinTypeChecker4();

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean areEqualTypeConstructors(d0.e0.p.d.m0.n.n1.l lVar, d0.e0.p.d.m0.n.n1.l lVar2) {
        return ClassicTypeSystemContext.a.areEqualTypeConstructors(this, lVar, lVar2);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public int argumentsCount(d0.e0.p.d.m0.n.n1.h hVar) {
        return ClassicTypeSystemContext.a.argumentsCount(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.d asDefinitelyNotNullType(d0.e0.p.d.m0.n.n1.i iVar) {
        return ClassicTypeSystemContext.a.asDefinitelyNotNullType(this, iVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.e asDynamicType(d0.e0.p.d.m0.n.n1.f fVar) {
        return ClassicTypeSystemContext.a.asDynamicType(this, fVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.f asFlexibleType(d0.e0.p.d.m0.n.n1.h hVar) {
        return ClassicTypeSystemContext.a.asFlexibleType(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.l1.ClassicTypeSystemContext
    public d0.e0.p.d.m0.n.n1.i asSimpleType(d0.e0.p.d.m0.n.n1.h hVar) {
        return ClassicTypeSystemContext.a.asSimpleType(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.l1.ClassicTypeSystemContext
    public d0.e0.p.d.m0.n.n1.h createFlexibleType(d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.i iVar2) {
        return ClassicTypeSystemContext.a.createFlexibleType(this, iVar, iVar2);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.k getArgument(d0.e0.p.d.m0.n.n1.h hVar, int i) {
        return ClassicTypeSystemContext.a.getArgument(this, hVar, i);
    }

    @Override // d0.e0.p.d.m0.n.TypeSystemCommonBackendContext
    public FqNameUnsafe getClassFqNameUnsafe(d0.e0.p.d.m0.n.n1.l lVar) {
        return ClassicTypeSystemContext.a.getClassFqNameUnsafe(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.TypeSystemCommonBackendContext
    public PrimitiveType getPrimitiveArrayType(d0.e0.p.d.m0.n.n1.l lVar) {
        return ClassicTypeSystemContext.a.getPrimitiveArrayType(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.TypeSystemCommonBackendContext
    public PrimitiveType getPrimitiveType(d0.e0.p.d.m0.n.n1.l lVar) {
        return ClassicTypeSystemContext.a.getPrimitiveType(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.TypeSystemCommonBackendContext
    public d0.e0.p.d.m0.n.n1.h getRepresentativeUpperBound(d0.e0.p.d.m0.n.n1.m mVar) {
        return ClassicTypeSystemContext.a.getRepresentativeUpperBound(this, mVar);
    }

    @Override // d0.e0.p.d.m0.n.TypeSystemCommonBackendContext
    public d0.e0.p.d.m0.n.n1.h getSubstitutedUnderlyingType(d0.e0.p.d.m0.n.n1.h hVar) {
        return ClassicTypeSystemContext.a.getSubstitutedUnderlyingType(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.h getType(d0.e0.p.d.m0.n.n1.k kVar) {
        return ClassicTypeSystemContext.a.getType(this, kVar);
    }

    @Override // d0.e0.p.d.m0.n.TypeSystemCommonBackendContext
    public d0.e0.p.d.m0.n.n1.m getTypeParameterClassifier(d0.e0.p.d.m0.n.n1.l lVar) {
        return ClassicTypeSystemContext.a.getTypeParameterClassifier(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.r getVariance(d0.e0.p.d.m0.n.n1.k kVar) {
        return ClassicTypeSystemContext.a.getVariance(this, kVar);
    }

    @Override // d0.e0.p.d.m0.n.TypeSystemCommonBackendContext
    public boolean hasAnnotation(d0.e0.p.d.m0.n.n1.h hVar, FqName fqName) {
        return ClassicTypeSystemContext.a.hasAnnotation(this, hVar, fqName);
    }

    @Override // d0.e0.p.d.m0.n.n1.q
    public boolean identicalArguments(d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.i iVar2) {
        return ClassicTypeSystemContext.a.identicalArguments(this, iVar, iVar2);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isClassTypeConstructor(d0.e0.p.d.m0.n.n1.l lVar) {
        return ClassicTypeSystemContext.a.isClassTypeConstructor(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.TypeSystemCommonBackendContext
    public boolean isInlineClass(d0.e0.p.d.m0.n.n1.l lVar) {
        return ClassicTypeSystemContext.a.isInlineClass(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isIntegerLiteralTypeConstructor(d0.e0.p.d.m0.n.n1.l lVar) {
        return ClassicTypeSystemContext.a.isIntegerLiteralTypeConstructor(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isMarkedNullable(d0.e0.p.d.m0.n.n1.h hVar) {
        return ClassicTypeSystemContext.a.isMarkedNullable(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isNothingConstructor(d0.e0.p.d.m0.n.n1.l lVar) {
        return ClassicTypeSystemContext.a.isNothingConstructor(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isNullableType(d0.e0.p.d.m0.n.n1.h hVar) {
        return ClassicTypeSystemContext.a.isNullableType(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isPrimitiveType(d0.e0.p.d.m0.n.n1.i iVar) {
        return ClassicTypeSystemContext.a.isPrimitiveType(this, iVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isStarProjection(d0.e0.p.d.m0.n.n1.k kVar) {
        return ClassicTypeSystemContext.a.isStarProjection(this, kVar);
    }

    @Override // d0.e0.p.d.m0.n.TypeSystemCommonBackendContext
    public boolean isUnderKotlinPackage(d0.e0.p.d.m0.n.n1.l lVar) {
        return ClassicTypeSystemContext.a.isUnderKotlinPackage(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.l1.ClassicTypeSystemContext
    public d0.e0.p.d.m0.n.n1.i lowerBound(d0.e0.p.d.m0.n.n1.f fVar) {
        return ClassicTypeSystemContext.a.lowerBound(this, fVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.i lowerBoundIfFlexible(d0.e0.p.d.m0.n.n1.h hVar) {
        return ClassicTypeSystemContext.a.lowerBoundIfFlexible(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.TypeSystemCommonBackendContext
    public d0.e0.p.d.m0.n.n1.h makeNullable(d0.e0.p.d.m0.n.n1.h hVar) {
        return ClassicTypeSystemContext.a.makeNullable(this, hVar);
    }

    public AbstractTypeChecker3 newBaseTypeCheckerContext(boolean z2, boolean z3) {
        return ClassicTypeSystemContext.a.newBaseTypeCheckerContext(this, z2, z3);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.l typeConstructor(d0.e0.p.d.m0.n.n1.h hVar) {
        return ClassicTypeSystemContext.a.typeConstructor(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.l1.ClassicTypeSystemContext
    public d0.e0.p.d.m0.n.n1.i upperBound(d0.e0.p.d.m0.n.n1.f fVar) {
        return ClassicTypeSystemContext.a.upperBound(this, fVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.i upperBoundIfFlexible(d0.e0.p.d.m0.n.n1.h hVar) {
        return ClassicTypeSystemContext.a.upperBoundIfFlexible(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.l1.ClassicTypeSystemContext
    public d0.e0.p.d.m0.n.n1.i withNullability(d0.e0.p.d.m0.n.n1.i iVar, boolean z2) {
        return ClassicTypeSystemContext.a.withNullability((ClassicTypeSystemContext) this, iVar, z2);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isMarkedNullable(d0.e0.p.d.m0.n.n1.i iVar) {
        return ClassicTypeSystemContext.a.isMarkedNullable((ClassicTypeSystemContext) this, iVar);
    }

    @Override // d0.e0.p.d.m0.n.l1.ClassicTypeSystemContext
    public d0.e0.p.d.m0.n.n1.l typeConstructor(d0.e0.p.d.m0.n.n1.i iVar) {
        return ClassicTypeSystemContext.a.typeConstructor((ClassicTypeSystemContext) this, iVar);
    }
}
