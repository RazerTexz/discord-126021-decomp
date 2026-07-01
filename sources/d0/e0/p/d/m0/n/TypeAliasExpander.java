package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.TypeAliasDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.g1.Annotations5;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.n.TypeAliasExpansionReportStrategy;
import d0.e0.p.d.m0.n.l1.KotlinTypeChecker;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.q0, reason: use source file name */
/* JADX INFO: compiled from: TypeAliasExpander.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TypeAliasExpander {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAliasExpansionReportStrategy f3536b;
    public final boolean c;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.q0$a */
    /* JADX INFO: compiled from: TypeAliasExpander.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final void access$assertRecursionDepth(a aVar, int i, TypeAliasDescriptor typeAliasDescriptor) {
            Objects.requireNonNull(aVar);
            if (i > 100) {
                throw new AssertionError(Intrinsics3.stringPlus("Too deep recursion while expanding type alias ", typeAliasDescriptor.getName()));
            }
        }

        public final void checkBoundsInTypeAlias(TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy, KotlinType kotlinType, KotlinType kotlinType2, TypeParameterDescriptor typeParameterDescriptor, TypeSubstitutor2 typeSubstitutor2) {
            Intrinsics3.checkNotNullParameter(typeAliasExpansionReportStrategy, "reportStrategy");
            Intrinsics3.checkNotNullParameter(kotlinType, "unsubstitutedArgument");
            Intrinsics3.checkNotNullParameter(kotlinType2, "typeArgument");
            Intrinsics3.checkNotNullParameter(typeParameterDescriptor, "typeParameterDescriptor");
            Intrinsics3.checkNotNullParameter(typeSubstitutor2, "substitutor");
            Iterator<KotlinType> it = typeParameterDescriptor.getUpperBounds().iterator();
            while (it.hasNext()) {
                KotlinType kotlinTypeSafeSubstitute = typeSubstitutor2.safeSubstitute(it.next(), Variance.INVARIANT);
                Intrinsics3.checkNotNullExpressionValue(kotlinTypeSafeSubstitute, "substitutor.safeSubstitute(bound, Variance.INVARIANT)");
                if (!KotlinTypeChecker.a.isSubtypeOf(kotlinType2, kotlinTypeSafeSubstitute)) {
                    typeAliasExpansionReportStrategy.boundsViolationInSubstitution(kotlinTypeSafeSubstitute, kotlinType, kotlinType2, typeParameterDescriptor);
                }
            }
        }
    }

    static {
        new TypeAliasExpander(TypeAliasExpansionReportStrategy.a.a, false);
    }

    public TypeAliasExpander(TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy, boolean z2) {
        Intrinsics3.checkNotNullParameter(typeAliasExpansionReportStrategy, "reportStrategy");
        this.f3536b = typeAliasExpansionReportStrategy;
        this.c = z2;
    }

    public final void a(Annotations4 annotations4, Annotations4 annotations5) {
        HashSet hashSet = new HashSet();
        Iterator<AnnotationDescriptor> it = annotations4.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getFqName());
        }
        for (AnnotationDescriptor annotationDescriptor : annotations5) {
            if (hashSet.contains(annotationDescriptor.getFqName())) {
                this.f3536b.repeatedAnnotation(annotationDescriptor);
            }
        }
    }

    public final KotlinType4 b(KotlinType4 kotlinType4, Annotations4 annotations4) {
        return KotlinType2.isError(kotlinType4) ? kotlinType4 : TypeSubstitution.replace$default(kotlinType4, null, c(kotlinType4, annotations4), 1, null);
    }

    public final Annotations4 c(KotlinType kotlinType, Annotations4 annotations4) {
        return KotlinType2.isError(kotlinType) ? kotlinType.getAnnotations() : Annotations5.composeAnnotations(annotations4, kotlinType.getAnnotations());
    }

    public final KotlinType4 d(TypeAliasExpansion typeAliasExpansion, Annotations4 annotations4, boolean z2, int i, boolean z3) {
        TypeProjection typeProjectionE = e(new TypeProjectionImpl(Variance.INVARIANT, typeAliasExpansion.getDescriptor().getUnderlyingType()), typeAliasExpansion, null, i);
        KotlinType type = typeProjectionE.getType();
        Intrinsics3.checkNotNullExpressionValue(type, "expandedProjection.type");
        KotlinType4 kotlinType4AsSimpleType = TypeSubstitution.asSimpleType(type);
        if (KotlinType2.isError(kotlinType4AsSimpleType)) {
            return kotlinType4AsSimpleType;
        }
        typeProjectionE.getProjectionKind();
        a(kotlinType4AsSimpleType.getAnnotations(), annotations4);
        KotlinType4 kotlinType4MakeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(b(kotlinType4AsSimpleType, annotations4), z2);
        Intrinsics3.checkNotNullExpressionValue(kotlinType4MakeNullableIfNeeded, "expandedType.combineAnnotations(annotations).let { TypeUtils.makeNullableIfNeeded(it, isNullable) }");
        if (!z3) {
            return kotlinType4MakeNullableIfNeeded;
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        TypeConstructor typeConstructor = typeAliasExpansion.getDescriptor().getTypeConstructor();
        Intrinsics3.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
        return SpecialTypes5.withAbbreviation(kotlinType4MakeNullableIfNeeded, KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(annotations4, typeConstructor, typeAliasExpansion.getArguments(), z2, MemberScope3.b.f3461b));
    }

    public final TypeProjection e(TypeProjection typeProjection, TypeAliasExpansion typeAliasExpansion, TypeParameterDescriptor typeParameterDescriptor, int i) {
        KotlinType kotlinTypeB;
        Variance variance = Variance.INVARIANT;
        a.access$assertRecursionDepth(a, i, typeAliasExpansion.getDescriptor());
        if (typeProjection.isStarProjection()) {
            Intrinsics3.checkNotNull(typeParameterDescriptor);
            TypeProjection typeProjectionMakeStarProjection = TypeUtils.makeStarProjection(typeParameterDescriptor);
            Intrinsics3.checkNotNullExpressionValue(typeProjectionMakeStarProjection, "makeStarProjection(typeParameterDescriptor!!)");
            return typeProjectionMakeStarProjection;
        }
        KotlinType type = typeProjection.getType();
        Intrinsics3.checkNotNullExpressionValue(type, "underlyingProjection.type");
        TypeProjection replacement = typeAliasExpansion.getReplacement(type.getConstructor());
        if (replacement != null) {
            if (replacement.isStarProjection()) {
                Intrinsics3.checkNotNull(typeParameterDescriptor);
                TypeProjection typeProjectionMakeStarProjection2 = TypeUtils.makeStarProjection(typeParameterDescriptor);
                Intrinsics3.checkNotNullExpressionValue(typeProjectionMakeStarProjection2, "makeStarProjection(typeParameterDescriptor!!)");
                return typeProjectionMakeStarProjection2;
            }
            KotlinType3 kotlinType3Unwrap = replacement.getType().unwrap();
            Variance projectionKind = replacement.getProjectionKind();
            Intrinsics3.checkNotNullExpressionValue(projectionKind, "argument.projectionKind");
            Variance projectionKind2 = typeProjection.getProjectionKind();
            Intrinsics3.checkNotNullExpressionValue(projectionKind2, "underlyingProjection.projectionKind");
            if (projectionKind2 != projectionKind && projectionKind2 != variance) {
                if (projectionKind == variance) {
                    projectionKind = projectionKind2;
                } else {
                    this.f3536b.conflictingProjection(typeAliasExpansion.getDescriptor(), typeParameterDescriptor, kotlinType3Unwrap);
                }
            }
            Variance variance2 = typeParameterDescriptor == null ? null : typeParameterDescriptor.getVariance();
            if (variance2 == null) {
                variance2 = variance;
            }
            Intrinsics3.checkNotNullExpressionValue(variance2, "typeParameterDescriptor?.variance ?: Variance.INVARIANT");
            if (variance2 == projectionKind || variance2 == variance) {
                variance = projectionKind;
            } else if (projectionKind != variance) {
                this.f3536b.conflictingProjection(typeAliasExpansion.getDescriptor(), typeParameterDescriptor, kotlinType3Unwrap);
                variance = projectionKind;
            }
            a(type.getAnnotations(), kotlinType3Unwrap.getAnnotations());
            if (kotlinType3Unwrap instanceof dynamicTypes) {
                dynamicTypes dynamictypes = (dynamicTypes) kotlinType3Unwrap;
                kotlinTypeB = dynamictypes.replaceAnnotations(c(dynamictypes, type.getAnnotations()));
            } else {
                KotlinType4 kotlinType4MakeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(TypeSubstitution.asSimpleType(kotlinType3Unwrap), type.isMarkedNullable());
                Intrinsics3.checkNotNullExpressionValue(kotlinType4MakeNullableIfNeeded, "makeNullableIfNeeded(this, fromType.isMarkedNullable)");
                kotlinTypeB = b(kotlinType4MakeNullableIfNeeded, type.getAnnotations());
            }
            return new TypeProjectionImpl(variance, kotlinTypeB);
        }
        KotlinType3 kotlinType3Unwrap2 = typeProjection.getType().unwrap();
        if (dynamicTypes2.isDynamic(kotlinType3Unwrap2)) {
            return typeProjection;
        }
        KotlinType4 kotlinType4AsSimpleType = TypeSubstitution.asSimpleType(kotlinType3Unwrap2);
        if (KotlinType2.isError(kotlinType4AsSimpleType) || !TypeUtils2.requiresTypeAliasExpansion(kotlinType4AsSimpleType)) {
            return typeProjection;
        }
        TypeConstructor constructor = kotlinType4AsSimpleType.getConstructor();
        ClassifierDescriptor declarationDescriptor = constructor.getDeclarationDescriptor();
        constructor.getParameters().size();
        kotlinType4AsSimpleType.getArguments().size();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return typeProjection;
        }
        int i2 = 0;
        if (declarationDescriptor instanceof TypeAliasDescriptor) {
            TypeAliasDescriptor typeAliasDescriptor = (TypeAliasDescriptor) declarationDescriptor;
            if (typeAliasExpansion.isRecursion(typeAliasDescriptor)) {
                this.f3536b.recursiveTypeAlias(typeAliasDescriptor);
                return new TypeProjectionImpl(variance, ErrorUtils.createErrorType(Intrinsics3.stringPlus("Recursive type alias: ", typeAliasDescriptor.getName())));
            }
            List<TypeProjection> arguments = kotlinType4AsSimpleType.getArguments();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(arguments, 10));
            for (Object obj : arguments) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    Collections2.throwIndexOverflow();
                }
                arrayList.add(e((TypeProjection) obj, typeAliasExpansion, constructor.getParameters().get(i2), i + 1));
                i2 = i3;
            }
            KotlinType4 kotlinType4D = d(TypeAliasExpansion.a.create(typeAliasExpansion, typeAliasDescriptor, arrayList), kotlinType4AsSimpleType.getAnnotations(), kotlinType4AsSimpleType.isMarkedNullable(), i + 1, false);
            KotlinType4 kotlinType4F = f(kotlinType4AsSimpleType, typeAliasExpansion, i);
            if (!dynamicTypes2.isDynamic(kotlinType4D)) {
                kotlinType4D = SpecialTypes5.withAbbreviation(kotlinType4D, kotlinType4F);
            }
            return new TypeProjectionImpl(typeProjection.getProjectionKind(), kotlinType4D);
        }
        KotlinType4 kotlinType4F2 = f(kotlinType4AsSimpleType, typeAliasExpansion, i);
        TypeSubstitutor2 typeSubstitutor2Create = TypeSubstitutor2.create(kotlinType4F2);
        Intrinsics3.checkNotNullExpressionValue(typeSubstitutor2Create, "create(substitutedType)");
        for (Object obj2 : kotlinType4F2.getArguments()) {
            int i4 = i2 + 1;
            if (i2 < 0) {
                Collections2.throwIndexOverflow();
            }
            TypeProjection typeProjection2 = (TypeProjection) obj2;
            if (!typeProjection2.isStarProjection()) {
                KotlinType type2 = typeProjection2.getType();
                Intrinsics3.checkNotNullExpressionValue(type2, "substitutedArgument.type");
                if (!TypeUtils2.containsTypeAliasParameters(type2)) {
                    TypeProjection typeProjection3 = kotlinType4AsSimpleType.getArguments().get(i2);
                    TypeParameterDescriptor typeParameterDescriptor2 = kotlinType4AsSimpleType.getConstructor().getParameters().get(i2);
                    if (this.c) {
                        a aVar = a;
                        TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy = this.f3536b;
                        KotlinType type3 = typeProjection3.getType();
                        Intrinsics3.checkNotNullExpressionValue(type3, "unsubstitutedArgument.type");
                        KotlinType type4 = typeProjection2.getType();
                        Intrinsics3.checkNotNullExpressionValue(type4, "substitutedArgument.type");
                        Intrinsics3.checkNotNullExpressionValue(typeParameterDescriptor2, "typeParameter");
                        aVar.checkBoundsInTypeAlias(typeAliasExpansionReportStrategy, type3, type4, typeParameterDescriptor2, typeSubstitutor2Create);
                    }
                }
            }
            i2 = i4;
        }
        return new TypeProjectionImpl(typeProjection.getProjectionKind(), kotlinType4F2);
    }

    public final KotlinType4 expand(TypeAliasExpansion typeAliasExpansion, Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(typeAliasExpansion, "typeAliasExpansion");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        return d(typeAliasExpansion, annotations4, false, 0, true);
    }

    public final KotlinType4 f(KotlinType4 kotlinType4, TypeAliasExpansion typeAliasExpansion, int i) {
        TypeConstructor constructor = kotlinType4.getConstructor();
        List<TypeProjection> arguments = kotlinType4.getArguments();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(arguments, 10));
        int i2 = 0;
        for (Object obj : arguments) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                Collections2.throwIndexOverflow();
            }
            TypeProjection typeProjection = (TypeProjection) obj;
            TypeProjection typeProjectionE = e(typeProjection, typeAliasExpansion, constructor.getParameters().get(i2), i + 1);
            if (!typeProjectionE.isStarProjection()) {
                typeProjectionE = new TypeProjectionImpl(typeProjectionE.getProjectionKind(), TypeUtils.makeNullableIfNeeded(typeProjectionE.getType(), typeProjection.getType().isMarkedNullable()));
            }
            arrayList.add(typeProjectionE);
            i2 = i3;
        }
        return TypeSubstitution.replace$default(kotlinType4, arrayList, null, 2, null);
    }
}
