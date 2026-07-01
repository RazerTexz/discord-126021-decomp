package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.e.a.i0.context3;
import d0.e0.p.d.m0.e.a.i0.m.RawType2;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType2;
import d0.e0.p.d.m0.n.KotlinType3;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.KotlinType6;
import d0.e0.p.d.m0.n.KotlinTypeFactory;
import d0.e0.p.d.m0.n.RawType3;
import d0.e0.p.d.m0.n.SpecialTypes5;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.e0.p.d.m0.n.TypeUtils;
import d0.e0.p.d.m0.n.TypeWithEnhancement2;
import d0.e0.p.d.m0.n.Variance;
import d0.e0.p.d.m0.n.flexibleTypes2;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.d, reason: use source file name */
/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class typeEnhancement4 {
    public final context3 a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.d$a */
    /* JADX INFO: compiled from: typeEnhancement.kt */
    public static class a {
        public final KotlinType a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3343b;
        public final boolean c;

        public a(KotlinType kotlinType, int i, boolean z2) {
            Intrinsics3.checkNotNullParameter(kotlinType, "type");
            this.a = kotlinType;
            this.f3343b = i;
            this.c = z2;
        }

        public final int getSubtreeSize() {
            return this.f3343b;
        }

        public KotlinType getType() {
            return this.a;
        }

        public final KotlinType getTypeIfChanged() {
            KotlinType type = getType();
            if (getWereChanges()) {
                return type;
            }
            return null;
        }

        public final boolean getWereChanges() {
            return this.c;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.d$b */
    /* JADX INFO: compiled from: typeEnhancement.kt */
    public static final class b extends a {
        public final KotlinType4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(KotlinType4 kotlinType4, int i, boolean z2) {
            super(kotlinType4, i, z2);
            Intrinsics3.checkNotNullParameter(kotlinType4, "type");
            this.d = kotlinType4;
        }

        @Override // d0.e0.p.d.m0.e.a.l0.typeEnhancement4.a
        public KotlinType4 getType() {
            return this.d;
        }
    }

    public typeEnhancement4(context3 context3Var) {
        Intrinsics3.checkNotNullParameter(context3Var, "javaResolverSettings");
        this.a = context3Var;
    }

    public final b a(KotlinType4 kotlinType4, Function1<? super Integer, typeQualifiers> function1, int i, TypeComponentPosition typeComponentPosition, boolean z2) {
        KotlinType3 kotlinType3WrapEnhancement;
        int subtreeSize;
        TypeProjection typeProjectionCreateProjection;
        if (!TypeComponentPosition2.shouldEnhance(typeComponentPosition) && kotlinType4.getArguments().isEmpty()) {
            return new b(kotlinType4, 1, false);
        }
        ClassifierDescriptor declarationDescriptor = kotlinType4.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return new b(kotlinType4, 1, false);
        }
        typeQualifiers typequalifiersInvoke = function1.invoke(Integer.valueOf(i));
        typeEnhancement3 typeenhancement3Access$enhanceMutability = typeEnhancement6.access$enhanceMutability(declarationDescriptor, typequalifiersInvoke, typeComponentPosition);
        ClassifierDescriptor classifierDescriptor = (ClassifierDescriptor) typeenhancement3Access$enhanceMutability.component1();
        Annotations4 annotations4Component2 = typeenhancement3Access$enhanceMutability.component2();
        TypeConstructor typeConstructor = classifierDescriptor.getTypeConstructor();
        Intrinsics3.checkNotNullExpressionValue(typeConstructor, "enhancedClassifier.typeConstructor");
        int i2 = i + 1;
        boolean z3 = annotations4Component2 != null;
        List<TypeProjection> arguments = kotlinType4.getArguments();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(arguments, 10));
        int i3 = 0;
        for (Object obj : arguments) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                Collections2.throwIndexOverflow();
            }
            TypeProjection typeProjection = (TypeProjection) obj;
            if (typeProjection.isStarProjection()) {
                subtreeSize = i2 + 1;
                if (function1.invoke(Integer.valueOf(i2)).getNullability() != typeQualifiers3.NOT_NULL || z2) {
                    typeProjectionCreateProjection = TypeUtils.makeStarProjection(classifierDescriptor.getTypeConstructor().getParameters().get(i3));
                    Intrinsics3.checkNotNullExpressionValue(typeProjectionCreateProjection, "{\n                    TypeUtils.makeStarProjection(enhancedClassifier.typeConstructor.parameters[localArgIndex])\n                }");
                } else {
                    KotlinType kotlinTypeMakeNotNullable = TypeUtils2.makeNotNullable(typeProjection.getType().unwrap());
                    Variance projectionKind = typeProjection.getProjectionKind();
                    Intrinsics3.checkNotNullExpressionValue(projectionKind, "arg.projectionKind");
                    typeProjectionCreateProjection = TypeUtils2.createProjection(kotlinTypeMakeNotNullable, projectionKind, typeConstructor.getParameters().get(i3));
                }
            } else {
                a aVarB = b(typeProjection.getType().unwrap(), function1, i2);
                z3 = z3 || aVarB.getWereChanges();
                subtreeSize = aVarB.getSubtreeSize() + i2;
                KotlinType type = aVarB.getType();
                Variance projectionKind2 = typeProjection.getProjectionKind();
                Intrinsics3.checkNotNullExpressionValue(projectionKind2, "arg.projectionKind");
                typeProjectionCreateProjection = TypeUtils2.createProjection(type, projectionKind2, typeConstructor.getParameters().get(i3));
            }
            i2 = subtreeSize;
            arrayList.add(typeProjectionCreateProjection);
            i3 = i4;
        }
        typeEnhancement3 typeenhancement3Access$getEnhancedNullability = typeEnhancement6.access$getEnhancedNullability(kotlinType4, typequalifiersInvoke, typeComponentPosition);
        boolean zBooleanValue = ((Boolean) typeenhancement3Access$getEnhancedNullability.component1()).booleanValue();
        Annotations4 annotations4Component3 = typeenhancement3Access$getEnhancedNullability.component2();
        int i5 = i2 - i;
        if (!(z3 || annotations4Component3 != null)) {
            return new b(kotlinType4, i5, false);
        }
        boolean z4 = false;
        Annotations4 annotations4Access$compositeAnnotationsOrSingle = typeEnhancement6.access$compositeAnnotationsOrSingle(Collections2.listOfNotNull((Object[]) new Annotations4[]{kotlinType4.getAnnotations(), annotations4Component2, annotations4Component3}));
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        KotlinType4 kotlinType4SimpleType$default = KotlinTypeFactory.simpleType$default(annotations4Access$compositeAnnotationsOrSingle, typeConstructor, arrayList, zBooleanValue, null, 16, null);
        if (typequalifiersInvoke.isNotNullTypeParameter()) {
            if (this.a.getCorrectNullabilityForNotNullTypeParameter()) {
                kotlinType3WrapEnhancement = kotlinType4SimpleType$default;
                kotlinType3WrapEnhancement = SpecialTypes5.makeSimpleTypeDefinitelyNotNullOrNotNull(kotlinType4SimpleType$default, true);
            } else {
                kotlinType3WrapEnhancement = kotlinType4SimpleType$default;
                kotlinType3WrapEnhancement = new typeEnhancement5(kotlinType4SimpleType$default);
            }
        }
        if (annotations4Component3 != null && typequalifiersInvoke.isNullabilityQualifierForWarning()) {
            z4 = true;
        }
        if (z4) {
            kotlinType3WrapEnhancement = TypeWithEnhancement2.wrapEnhancement(kotlinType4, kotlinType3WrapEnhancement);
        }
        return new b((KotlinType4) kotlinType3WrapEnhancement, i5, true);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005e  */
    public final a b(KotlinType3 kotlinType3, Function1<? super Integer, typeQualifiers> function1, int i) {
        KotlinType3 kotlinType3FlexibleType;
        if (KotlinType2.isError(kotlinType3)) {
            return new a(kotlinType3, 1, false);
        }
        if (!(kotlinType3 instanceof KotlinType6)) {
            if (kotlinType3 instanceof KotlinType4) {
                return a((KotlinType4) kotlinType3, function1, i, TypeComponentPosition.INFLEXIBLE, false);
            }
            throw new NoWhenBranchMatchedException();
        }
        boolean z2 = kotlinType3 instanceof RawType3;
        KotlinType6 kotlinType6 = (KotlinType6) kotlinType3;
        b bVarA = a(kotlinType6.getLowerBound(), function1, i, TypeComponentPosition.FLEXIBLE_LOWER, z2);
        b bVarA2 = a(kotlinType6.getUpperBound(), function1, i, TypeComponentPosition.FLEXIBLE_UPPER, z2);
        bVarA.getSubtreeSize();
        bVarA2.getSubtreeSize();
        boolean z3 = bVarA.getWereChanges() || bVarA2.getWereChanges();
        KotlinType4 type = bVarA.getType();
        KotlinType enhancement = TypeWithEnhancement2.getEnhancement(bVarA2.getType());
        KotlinType enhancement2 = TypeWithEnhancement2.getEnhancement(type);
        if (enhancement2 != null) {
            if (enhancement != null) {
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
                enhancement2 = KotlinTypeFactory.flexibleType(flexibleTypes2.lowerIfFlexible(enhancement2), flexibleTypes2.upperIfFlexible(enhancement));
            }
        } else if (enhancement == null) {
            enhancement2 = null;
        } else {
            enhancement2 = enhancement;
            if (enhancement != null) {
                KotlinTypeFactory kotlinTypeFactory2 = KotlinTypeFactory.a;
                enhancement2 = KotlinTypeFactory.flexibleType(flexibleTypes2.lowerIfFlexible(enhancement2), flexibleTypes2.upperIfFlexible(enhancement));
            }
        }
        if (z3) {
            if (kotlinType3 instanceof RawType2) {
                kotlinType3FlexibleType = new RawType2(bVarA.getType(), bVarA2.getType());
            } else {
                KotlinTypeFactory kotlinTypeFactory3 = KotlinTypeFactory.a;
                kotlinType3FlexibleType = KotlinTypeFactory.flexibleType(bVarA.getType(), bVarA2.getType());
            }
            kotlinType3 = TypeWithEnhancement2.wrapEnhancement(kotlinType3FlexibleType, enhancement2);
        }
        return new a(kotlinType3, bVarA.getSubtreeSize(), z3);
    }

    public final KotlinType enhance(KotlinType kotlinType, Function1<? super Integer, typeQualifiers> function1) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "qualifiers");
        return b(kotlinType.unwrap(), function1, 0).getTypeIfChanged();
    }
}
