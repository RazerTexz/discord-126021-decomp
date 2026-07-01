package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.b.PrimitiveType;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.FqNameUnsafe;
import d0.e0.p.d.m0.k.v.IntegerLiteralTypeConstructor;
import d0.e0.p.d.m0.n.AbstractTypeChecker3;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.TypeSubstitution3;
import d0.e0.p.d.m0.n.TypeSubstitutor2;
import d0.e0.p.d.m0.n.Variance;
import d0.e0.p.d.m0.n.l1.ClassicTypeSystemContext;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.a, reason: use source file name */
/* JADX INFO: compiled from: ClassicTypeCheckerContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public class ClassicTypeCheckerContext extends AbstractTypeChecker3 implements ClassicTypeSystemContext {
    public static final a e = new a(null);
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final KotlinTypeRefiner i;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.a$a */
    /* JADX INFO: compiled from: ClassicTypeCheckerContext.kt */
    public static final class a {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ClassicTypeCheckerContext.kt */
        public static final class C0413a extends AbstractTypeChecker3.b.a {
            public final /* synthetic */ ClassicTypeSystemContext a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TypeSubstitutor2 f3527b;

            public C0413a(ClassicTypeSystemContext classicTypeSystemContext, TypeSubstitutor2 typeSubstitutor2) {
                this.a = classicTypeSystemContext;
                this.f3527b = typeSubstitutor2;
            }

            @Override // d0.e0.p.d.m0.n.AbstractTypeChecker3.b
            public d0.e0.p.d.m0.n.n1.i transformType(AbstractTypeChecker3 abstractTypeChecker3, d0.e0.p.d.m0.n.n1.h hVar) {
                Intrinsics3.checkNotNullParameter(abstractTypeChecker3, "context");
                Intrinsics3.checkNotNullParameter(hVar, "type");
                ClassicTypeSystemContext classicTypeSystemContext = this.a;
                KotlinType kotlinTypeSafeSubstitute = this.f3527b.safeSubstitute((KotlinType) classicTypeSystemContext.lowerBoundIfFlexible(hVar), Variance.INVARIANT);
                Intrinsics3.checkNotNullExpressionValue(kotlinTypeSafeSubstitute, "substitutor.safeSubstitute(\n                        type.lowerBoundIfFlexible() as KotlinType,\n                        Variance.INVARIANT\n                    )");
                d0.e0.p.d.m0.n.n1.i iVarAsSimpleType = classicTypeSystemContext.asSimpleType(kotlinTypeSafeSubstitute);
                Intrinsics3.checkNotNull(iVarAsSimpleType);
                return iVarAsSimpleType;
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final AbstractTypeChecker3.b.a classicSubstitutionSupertypePolicy(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.i iVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "<this>");
            Intrinsics3.checkNotNullParameter(iVar, "type");
            if (iVar instanceof KotlinType4) {
                return new C0413a(classicTypeSystemContext, TypeSubstitution3.f3542b.create((KotlinType) iVar).buildSubstitutor());
            }
            throw new IllegalArgumentException(ClassicTypeCheckerContext2.access$errorMessage(iVar).toString());
        }
    }

    public /* synthetic */ ClassicTypeCheckerContext(boolean z2, boolean z3, boolean z4, KotlinTypeRefiner kotlinTypeRefiner, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, (i & 2) != 0 ? true : z3, (i & 4) != 0 ? true : z4, (i & 8) != 0 ? KotlinTypeRefiner.a.a : kotlinTypeRefiner);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean areEqualTypeConstructors(d0.e0.p.d.m0.n.n1.l lVar, d0.e0.p.d.m0.n.n1.l lVar2) {
        Intrinsics3.checkNotNullParameter(lVar, "c1");
        Intrinsics3.checkNotNullParameter(lVar2, "c2");
        if (!(lVar instanceof TypeConstructor)) {
            throw new IllegalArgumentException(ClassicTypeCheckerContext2.access$errorMessage(lVar).toString());
        }
        if (lVar2 instanceof TypeConstructor) {
            return areEqualTypeConstructors((TypeConstructor) lVar, (TypeConstructor) lVar2);
        }
        throw new IllegalArgumentException(ClassicTypeCheckerContext2.access$errorMessage(lVar2).toString());
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public int argumentsCount(d0.e0.p.d.m0.n.n1.h hVar) {
        return ClassicTypeSystemContext.a.argumentsCount(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.j asArgumentList(d0.e0.p.d.m0.n.n1.i iVar) {
        return ClassicTypeSystemContext.a.asArgumentList(this, iVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.c asCapturedType(d0.e0.p.d.m0.n.n1.i iVar) {
        return ClassicTypeSystemContext.a.asCapturedType(this, iVar);
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

    @Override // d0.e0.p.d.m0.n.n1.n, d0.e0.p.d.m0.n.l1.ClassicTypeSystemContext
    public d0.e0.p.d.m0.n.n1.i asSimpleType(d0.e0.p.d.m0.n.n1.h hVar) {
        return ClassicTypeSystemContext.a.asSimpleType(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.k asTypeArgument(d0.e0.p.d.m0.n.n1.h hVar) {
        return ClassicTypeSystemContext.a.asTypeArgument(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.i captureFromArguments(d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.b bVar) {
        return ClassicTypeSystemContext.a.captureFromArguments(this, iVar, bVar);
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

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.m getParameter(d0.e0.p.d.m0.n.n1.l lVar, int i) {
        return ClassicTypeSystemContext.a.getParameter(this, lVar, i);
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
    public d0.e0.p.d.m0.n.n1.h intersectTypes(List<? extends d0.e0.p.d.m0.n.n1.h> list) {
        return ClassicTypeSystemContext.a.intersectTypes(this, list);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isAnyConstructor(d0.e0.p.d.m0.n.n1.l lVar) {
        return ClassicTypeSystemContext.a.isAnyConstructor(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isClassTypeConstructor(d0.e0.p.d.m0.n.n1.l lVar) {
        return ClassicTypeSystemContext.a.isClassTypeConstructor(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isCommonFinalClassConstructor(d0.e0.p.d.m0.n.n1.l lVar) {
        return ClassicTypeSystemContext.a.isCommonFinalClassConstructor(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isDenotable(d0.e0.p.d.m0.n.n1.l lVar) {
        return ClassicTypeSystemContext.a.isDenotable(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isError(d0.e0.p.d.m0.n.n1.h hVar) {
        return ClassicTypeSystemContext.a.isError(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.AbstractTypeChecker3
    public boolean isErrorTypeEqualsToAnything() {
        return this.f;
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
    public boolean isIntersection(d0.e0.p.d.m0.n.n1.l lVar) {
        return ClassicTypeSystemContext.a.isIntersection(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isMarkedNullable(d0.e0.p.d.m0.n.n1.i iVar) {
        return ClassicTypeSystemContext.a.isMarkedNullable((ClassicTypeSystemContext) this, iVar);
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
    public boolean isProjectionNotNull(d0.e0.p.d.m0.n.n1.c cVar) {
        return ClassicTypeSystemContext.a.isProjectionNotNull(this, cVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isStarProjection(d0.e0.p.d.m0.n.n1.k kVar) {
        return ClassicTypeSystemContext.a.isStarProjection(this, kVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isStubType(d0.e0.p.d.m0.n.n1.i iVar) {
        return ClassicTypeSystemContext.a.isStubType(this, iVar);
    }

    @Override // d0.e0.p.d.m0.n.AbstractTypeChecker3
    public boolean isStubTypeEqualsToAnything() {
        return this.g;
    }

    @Override // d0.e0.p.d.m0.n.TypeSystemCommonBackendContext
    public boolean isUnderKotlinPackage(d0.e0.p.d.m0.n.n1.l lVar) {
        return ClassicTypeSystemContext.a.isUnderKotlinPackage(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n, d0.e0.p.d.m0.n.l1.ClassicTypeSystemContext
    public d0.e0.p.d.m0.n.n1.i lowerBound(d0.e0.p.d.m0.n.n1.f fVar) {
        return ClassicTypeSystemContext.a.lowerBound(this, fVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.h lowerType(d0.e0.p.d.m0.n.n1.c cVar) {
        return ClassicTypeSystemContext.a.lowerType(this, cVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.h makeDefinitelyNotNullOrNotNull(d0.e0.p.d.m0.n.n1.h hVar) {
        return ClassicTypeSystemContext.a.makeDefinitelyNotNullOrNotNull(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.TypeSystemCommonBackendContext
    public d0.e0.p.d.m0.n.n1.h makeNullable(d0.e0.p.d.m0.n.n1.h hVar) {
        return ClassicTypeSystemContext.a.makeNullable(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.i original(d0.e0.p.d.m0.n.n1.d dVar) {
        return ClassicTypeSystemContext.a.original(this, dVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public int parametersCount(d0.e0.p.d.m0.n.n1.l lVar) {
        return ClassicTypeSystemContext.a.parametersCount(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public Collection<d0.e0.p.d.m0.n.n1.h> possibleIntegerTypes(d0.e0.p.d.m0.n.n1.i iVar) {
        return ClassicTypeSystemContext.a.possibleIntegerTypes(this, iVar);
    }

    @Override // d0.e0.p.d.m0.n.AbstractTypeChecker3
    public d0.e0.p.d.m0.n.n1.h prepareType(d0.e0.p.d.m0.n.n1.h hVar) {
        Intrinsics3.checkNotNullParameter(hVar, "type");
        if (hVar instanceof KotlinType) {
            return NewKotlinTypeChecker.f3529b.getDefault().transformToNewType(((KotlinType) hVar).unwrap());
        }
        throw new IllegalArgumentException(ClassicTypeCheckerContext2.access$errorMessage(hVar).toString());
    }

    @Override // d0.e0.p.d.m0.n.AbstractTypeChecker3
    public d0.e0.p.d.m0.n.n1.h refineType(d0.e0.p.d.m0.n.n1.h hVar) {
        Intrinsics3.checkNotNullParameter(hVar, "type");
        if (hVar instanceof KotlinType) {
            return this.i.refineType((KotlinType) hVar);
        }
        throw new IllegalArgumentException(ClassicTypeCheckerContext2.access$errorMessage(hVar).toString());
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public Collection<d0.e0.p.d.m0.n.n1.h> supertypes(d0.e0.p.d.m0.n.n1.l lVar) {
        return ClassicTypeSystemContext.a.supertypes(this, lVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n, d0.e0.p.d.m0.n.l1.ClassicTypeSystemContext
    public d0.e0.p.d.m0.n.n1.l typeConstructor(d0.e0.p.d.m0.n.n1.i iVar) {
        return ClassicTypeSystemContext.a.typeConstructor((ClassicTypeSystemContext) this, iVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n, d0.e0.p.d.m0.n.l1.ClassicTypeSystemContext
    public d0.e0.p.d.m0.n.n1.i upperBound(d0.e0.p.d.m0.n.n1.f fVar) {
        return ClassicTypeSystemContext.a.upperBound(this, fVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.h withNullability(d0.e0.p.d.m0.n.n1.h hVar, boolean z2) {
        return ClassicTypeSystemContext.a.withNullability(this, hVar, z2);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.r getVariance(d0.e0.p.d.m0.n.n1.m mVar) {
        return ClassicTypeSystemContext.a.getVariance(this, mVar);
    }

    @Override // d0.e0.p.d.m0.n.AbstractTypeChecker3
    public AbstractTypeChecker3.b.a substitutionSupertypePolicy(d0.e0.p.d.m0.n.n1.i iVar) {
        Intrinsics3.checkNotNullParameter(iVar, "type");
        return e.classicSubstitutionSupertypePolicy(this, iVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n, d0.e0.p.d.m0.n.l1.ClassicTypeSystemContext
    public d0.e0.p.d.m0.n.n1.i withNullability(d0.e0.p.d.m0.n.n1.i iVar, boolean z2) {
        return ClassicTypeSystemContext.a.withNullability((ClassicTypeSystemContext) this, iVar, z2);
    }

    public ClassicTypeCheckerContext(boolean z2, boolean z3, boolean z4, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        this.f = z2;
        this.g = z3;
        this.h = z4;
        this.i = kotlinTypeRefiner;
    }

    public boolean areEqualTypeConstructors(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
        Intrinsics3.checkNotNullParameter(typeConstructor, "a");
        Intrinsics3.checkNotNullParameter(typeConstructor2, "b");
        if (typeConstructor instanceof IntegerLiteralTypeConstructor) {
            return ((IntegerLiteralTypeConstructor) typeConstructor).checkConstructor(typeConstructor2);
        }
        return typeConstructor2 instanceof IntegerLiteralTypeConstructor ? ((IntegerLiteralTypeConstructor) typeConstructor2).checkConstructor(typeConstructor) : Intrinsics3.areEqual(typeConstructor, typeConstructor2);
    }
}
