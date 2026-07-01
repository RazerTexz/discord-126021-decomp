package d0.e0.p.d.m0.n.p1;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.k.u.a.CapturedTypeConstructor2;
import d0.e0.p.d.m0.k.u.a.CapturedTypeConstructor4;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType3;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.KotlinTypeFactory;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.e0.p.d.m0.n.TypeProjectionImpl;
import d0.e0.p.d.m0.n.TypeSubstitution;
import d0.e0.p.d.m0.n.TypeSubstitutor2;
import d0.e0.p.d.m0.n.TypeUtils;
import d0.e0.p.d.m0.n.TypeWithEnhancement2;
import d0.e0.p.d.m0.n.Variance;
import d0.e0.p.d.m0.n.flexibleTypes2;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.p1.b, reason: use source file name */
/* JADX INFO: compiled from: CapturedTypeApproximation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CapturedTypeApproximation2 {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.p1.b$a */
    /* JADX INFO: compiled from: CapturedTypeApproximation.kt */
    public static final class a extends Lambda implements Function1<KotlinType3, Boolean> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(KotlinType3 kotlinType3) {
            Intrinsics3.checkNotNullExpressionValue(kotlinType3, "it");
            return Boolean.valueOf(CapturedTypeConstructor4.isCaptured(kotlinType3));
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00a5  */
    public static final KotlinType a(KotlinType kotlinType, List<CapturedTypeApproximation4> list) {
        TypeProjectionImpl typeProjectionImpl;
        kotlinType.getArguments().size();
        list.size();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        for (CapturedTypeApproximation4 capturedTypeApproximation4 : list) {
            Variance variance = Variance.OUT_VARIANCE;
            Variance variance2 = Variance.INVARIANT;
            capturedTypeApproximation4.isConsistent();
            if (Intrinsics3.areEqual(capturedTypeApproximation4.getInProjection(), capturedTypeApproximation4.getOutProjection())) {
                typeProjectionImpl = new TypeProjectionImpl(capturedTypeApproximation4.getInProjection());
            } else {
                Variance variance3 = capturedTypeApproximation4.getTypeParameter().getVariance();
                Variance variance4 = Variance.IN_VARIANCE;
                if (variance3 == variance4) {
                    typeProjectionImpl = new TypeProjectionImpl(capturedTypeApproximation4.getInProjection());
                } else if (KotlinBuiltIns.isNothing(capturedTypeApproximation4.getInProjection()) && capturedTypeApproximation4.getTypeParameter().getVariance() != variance4) {
                    if (variance == capturedTypeApproximation4.getTypeParameter().getVariance()) {
                        variance = variance2;
                    }
                    typeProjectionImpl = new TypeProjectionImpl(variance, capturedTypeApproximation4.getOutProjection());
                } else if (KotlinBuiltIns.isNullableAny(capturedTypeApproximation4.getOutProjection())) {
                    if (variance4 != capturedTypeApproximation4.getTypeParameter().getVariance()) {
                        variance2 = variance4;
                    }
                    typeProjectionImpl = new TypeProjectionImpl(variance2, capturedTypeApproximation4.getInProjection());
                } else {
                    if (variance == capturedTypeApproximation4.getTypeParameter().getVariance()) {
                        variance = variance2;
                    }
                    typeProjectionImpl = new TypeProjectionImpl(variance, capturedTypeApproximation4.getOutProjection());
                }
            }
            arrayList.add(typeProjectionImpl);
        }
        return TypeSubstitution.replace$default(kotlinType, arrayList, null, null, 6, null);
    }

    public static final CapturedTypeApproximation<KotlinType> approximateCapturedTypes(KotlinType kotlinType) {
        Object objA;
        CapturedTypeApproximation4 capturedTypeApproximation4;
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        if (flexibleTypes2.isFlexible(kotlinType)) {
            CapturedTypeApproximation<KotlinType> capturedTypeApproximationApproximateCapturedTypes = approximateCapturedTypes(flexibleTypes2.lowerIfFlexible(kotlinType));
            CapturedTypeApproximation<KotlinType> capturedTypeApproximationApproximateCapturedTypes2 = approximateCapturedTypes(flexibleTypes2.upperIfFlexible(kotlinType));
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
            return new CapturedTypeApproximation<>(TypeWithEnhancement2.inheritEnhancement(KotlinTypeFactory.flexibleType(flexibleTypes2.lowerIfFlexible(capturedTypeApproximationApproximateCapturedTypes.getLower()), flexibleTypes2.upperIfFlexible(capturedTypeApproximationApproximateCapturedTypes2.getLower())), kotlinType), TypeWithEnhancement2.inheritEnhancement(KotlinTypeFactory.flexibleType(flexibleTypes2.lowerIfFlexible(capturedTypeApproximationApproximateCapturedTypes.getUpper()), flexibleTypes2.upperIfFlexible(capturedTypeApproximationApproximateCapturedTypes2.getUpper())), kotlinType));
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        boolean z2 = true;
        if (CapturedTypeConstructor4.isCaptured(kotlinType)) {
            TypeProjection projection = ((CapturedTypeConstructor2) constructor).getProjection();
            KotlinType type = projection.getType();
            Intrinsics3.checkNotNullExpressionValue(type, "typeProjection.type");
            KotlinType kotlinTypeMakeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(type, kotlinType.isMarkedNullable());
            Intrinsics3.checkNotNullExpressionValue(kotlinTypeMakeNullableIfNeeded, "makeNullableIfNeeded(this, type.isMarkedNullable)");
            int iOrdinal = projection.getProjectionKind().ordinal();
            if (iOrdinal == 1) {
                KotlinType4 nullableAnyType = TypeUtils2.getBuiltIns(kotlinType).getNullableAnyType();
                Intrinsics3.checkNotNullExpressionValue(nullableAnyType, "type.builtIns.nullableAnyType");
                return new CapturedTypeApproximation<>(kotlinTypeMakeNullableIfNeeded, nullableAnyType);
            }
            if (iOrdinal != 2) {
                throw new AssertionError(Intrinsics3.stringPlus("Only nontrivial projections should have been captured, not: ", projection));
            }
            KotlinType4 nothingType = TypeUtils2.getBuiltIns(kotlinType).getNothingType();
            Intrinsics3.checkNotNullExpressionValue(nothingType, "type.builtIns.nothingType");
            KotlinType kotlinTypeMakeNullableIfNeeded2 = TypeUtils.makeNullableIfNeeded((KotlinType) nothingType, kotlinType.isMarkedNullable());
            Intrinsics3.checkNotNullExpressionValue(kotlinTypeMakeNullableIfNeeded2, "makeNullableIfNeeded(this, type.isMarkedNullable)");
            return new CapturedTypeApproximation<>(kotlinTypeMakeNullableIfNeeded2, kotlinTypeMakeNullableIfNeeded);
        }
        if (kotlinType.getArguments().isEmpty() || kotlinType.getArguments().size() != constructor.getParameters().size()) {
            return new CapturedTypeApproximation<>(kotlinType, kotlinType);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<TypeProjection> arguments = kotlinType.getArguments();
        List<TypeParameterDescriptor> parameters = constructor.getParameters();
        Intrinsics3.checkNotNullExpressionValue(parameters, "typeConstructor.parameters");
        for (Tuples2 tuples2 : _Collections.zip(arguments, parameters)) {
            TypeProjection typeProjection = (TypeProjection) tuples2.component1();
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) tuples2.component2();
            Intrinsics3.checkNotNullExpressionValue(typeParameterDescriptor, "typeParameter");
            int iOrdinal2 = TypeSubstitutor2.combine(typeParameterDescriptor.getVariance(), typeProjection).ordinal();
            if (iOrdinal2 == 0) {
                KotlinType type2 = typeProjection.getType();
                Intrinsics3.checkNotNullExpressionValue(type2, "type");
                KotlinType type3 = typeProjection.getType();
                Intrinsics3.checkNotNullExpressionValue(type3, "type");
                capturedTypeApproximation4 = new CapturedTypeApproximation4(typeParameterDescriptor, type2, type3);
            } else if (iOrdinal2 == 1) {
                KotlinType type4 = typeProjection.getType();
                Intrinsics3.checkNotNullExpressionValue(type4, "type");
                KotlinType4 nullableAnyType2 = DescriptorUtils2.getBuiltIns(typeParameterDescriptor).getNullableAnyType();
                Intrinsics3.checkNotNullExpressionValue(nullableAnyType2, "typeParameter.builtIns.nullableAnyType");
                capturedTypeApproximation4 = new CapturedTypeApproximation4(typeParameterDescriptor, type4, nullableAnyType2);
            } else {
                if (iOrdinal2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                KotlinType4 nothingType2 = DescriptorUtils2.getBuiltIns(typeParameterDescriptor).getNothingType();
                Intrinsics3.checkNotNullExpressionValue(nothingType2, "typeParameter.builtIns.nothingType");
                KotlinType type5 = typeProjection.getType();
                Intrinsics3.checkNotNullExpressionValue(type5, "type");
                capturedTypeApproximation4 = new CapturedTypeApproximation4(typeParameterDescriptor, nothingType2, type5);
            }
            if (typeProjection.isStarProjection()) {
                arrayList.add(capturedTypeApproximation4);
                arrayList2.add(capturedTypeApproximation4);
            } else {
                CapturedTypeApproximation<KotlinType> capturedTypeApproximationApproximateCapturedTypes3 = approximateCapturedTypes(capturedTypeApproximation4.getInProjection());
                KotlinType kotlinTypeComponent1 = capturedTypeApproximationApproximateCapturedTypes3.component1();
                KotlinType kotlinTypeComponent2 = capturedTypeApproximationApproximateCapturedTypes3.component2();
                CapturedTypeApproximation<KotlinType> capturedTypeApproximationApproximateCapturedTypes4 = approximateCapturedTypes(capturedTypeApproximation4.getOutProjection());
                CapturedTypeApproximation capturedTypeApproximation = new CapturedTypeApproximation(new CapturedTypeApproximation4(capturedTypeApproximation4.getTypeParameter(), kotlinTypeComponent2, capturedTypeApproximationApproximateCapturedTypes4.component1()), new CapturedTypeApproximation4(capturedTypeApproximation4.getTypeParameter(), kotlinTypeComponent1, capturedTypeApproximationApproximateCapturedTypes4.component2()));
                CapturedTypeApproximation4 capturedTypeApproximation5 = (CapturedTypeApproximation4) capturedTypeApproximation.component1();
                CapturedTypeApproximation4 capturedTypeApproximation6 = (CapturedTypeApproximation4) capturedTypeApproximation.component2();
                arrayList.add(capturedTypeApproximation5);
                arrayList2.add(capturedTypeApproximation6);
            }
        }
        if (arrayList.isEmpty()) {
            z2 = false;
            break;
        }
        Iterator it = arrayList.iterator();
        do {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
        } while (!(!((CapturedTypeApproximation4) it.next()).isConsistent()));
        if (z2) {
            objA = TypeUtils2.getBuiltIns(kotlinType).getNothingType();
            Intrinsics3.checkNotNullExpressionValue(objA, "type.builtIns.nothingType");
        } else {
            objA = a(kotlinType, arrayList);
        }
        return new CapturedTypeApproximation<>(objA, a(kotlinType, arrayList2));
    }

    public static final TypeProjection approximateCapturedTypesIfNecessary(TypeProjection typeProjection, boolean z2) {
        if (typeProjection == null) {
            return null;
        }
        if (typeProjection.isStarProjection()) {
            return typeProjection;
        }
        KotlinType type = typeProjection.getType();
        Intrinsics3.checkNotNullExpressionValue(type, "typeProjection.type");
        if (!TypeUtils.contains(type, a.j)) {
            return typeProjection;
        }
        Variance projectionKind = typeProjection.getProjectionKind();
        Intrinsics3.checkNotNullExpressionValue(projectionKind, "typeProjection.projectionKind");
        if (projectionKind == Variance.OUT_VARIANCE) {
            return new TypeProjectionImpl(projectionKind, approximateCapturedTypes(type).getUpper());
        }
        if (z2) {
            return new TypeProjectionImpl(projectionKind, approximateCapturedTypes(type).getLower());
        }
        TypeSubstitutor2 typeSubstitutor2Create = TypeSubstitutor2.create(new CapturedTypeApproximation3());
        Intrinsics3.checkNotNullExpressionValue(typeSubstitutor2Create, "create(object : TypeConstructorSubstitution() {\n        override fun get(key: TypeConstructor): TypeProjection? {\n            val capturedTypeConstructor = key as? CapturedTypeConstructor ?: return null\n            if (capturedTypeConstructor.projection.isStarProjection) {\n                return TypeProjectionImpl(Variance.OUT_VARIANCE, capturedTypeConstructor.projection.type)\n            }\n            return capturedTypeConstructor.projection\n        }\n    })");
        return typeSubstitutor2Create.substituteWithoutApproximation(typeProjection);
    }
}
