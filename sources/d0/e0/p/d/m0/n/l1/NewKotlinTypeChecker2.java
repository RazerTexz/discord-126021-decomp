package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.k.OverridingUtil;
import d0.e0.p.d.m0.k.u.a.CapturedTypeConstructor3;
import d0.e0.p.d.m0.k.v.IntegerValueTypeConstructor;
import d0.e0.p.d.m0.n.AbstractTypeChecker2;
import d0.e0.p.d.m0.n.IntersectionTypeConstructor;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType3;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.KotlinType6;
import d0.e0.p.d.m0.n.KotlinTypeFactory;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.e0.p.d.m0.n.TypeUtils;
import d0.e0.p.d.m0.n.TypeWithEnhancement2;
import d0.e0.p.d.m0.n.Variance;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.m, reason: use source file name */
/* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NewKotlinTypeChecker2 implements NewKotlinTypeChecker {
    public final KotlinTypeRefiner c;
    public final OverridingUtil d;

    public NewKotlinTypeChecker2(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        this.c = kotlinTypeRefiner;
        OverridingUtil overridingUtilCreateWithTypeRefiner = OverridingUtil.createWithTypeRefiner(getKotlinTypeRefiner());
        Intrinsics3.checkNotNullExpressionValue(overridingUtilCreateWithTypeRefiner, "createWithTypeRefiner(kotlinTypeRefiner)");
        this.d = overridingUtilCreateWithTypeRefiner;
    }

    @Override // d0.e0.p.d.m0.n.l1.KotlinTypeChecker
    public boolean equalTypes(KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics3.checkNotNullParameter(kotlinType, "a");
        Intrinsics3.checkNotNullParameter(kotlinType2, "b");
        return equalTypes(new ClassicTypeCheckerContext(false, false, false, getKotlinTypeRefiner(), 6, null), kotlinType.unwrap(), kotlinType2.unwrap());
    }

    @Override // d0.e0.p.d.m0.n.l1.NewKotlinTypeChecker
    public KotlinTypeRefiner getKotlinTypeRefiner() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.n.l1.NewKotlinTypeChecker
    public OverridingUtil getOverridingUtil() {
        return this.d;
    }

    @Override // d0.e0.p.d.m0.n.l1.KotlinTypeChecker
    public boolean isSubtypeOf(KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics3.checkNotNullParameter(kotlinType, "subtype");
        Intrinsics3.checkNotNullParameter(kotlinType2, "supertype");
        return isSubtypeOf(new ClassicTypeCheckerContext(true, false, false, getKotlinTypeRefiner(), 6, null), kotlinType.unwrap(), kotlinType2.unwrap());
    }

    public final KotlinType4 transformToNewType(KotlinType4 kotlinType4) {
        KotlinType type;
        Intrinsics3.checkNotNullParameter(kotlinType4, "type");
        TypeConstructor constructor = kotlinType4.getConstructor();
        boolean z2 = false;
        IntersectionTypeConstructor alternative = null;
        kotlinType3Unwrap = null;
        KotlinType3 kotlinType3Unwrap = null;
        if (constructor instanceof CapturedTypeConstructor3) {
            CapturedTypeConstructor3 capturedTypeConstructor3 = (CapturedTypeConstructor3) constructor;
            TypeProjection projection = capturedTypeConstructor3.getProjection();
            if (!(projection.getProjectionKind() == Variance.IN_VARIANCE)) {
                projection = null;
            }
            if (projection != null && (type = projection.getType()) != null) {
                kotlinType3Unwrap = type.unwrap();
            }
            KotlinType3 kotlinType3 = kotlinType3Unwrap;
            if (capturedTypeConstructor3.getNewTypeConstructor() == null) {
                TypeProjection projection2 = capturedTypeConstructor3.getProjection();
                Collection<KotlinType> supertypes = capturedTypeConstructor3.getSupertypes();
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(supertypes, 10));
                Iterator<T> it = supertypes.iterator();
                while (it.hasNext()) {
                    arrayList.add(((KotlinType) it.next()).unwrap());
                }
                capturedTypeConstructor3.setNewTypeConstructor(new NewCapturedType2(projection2, arrayList, null, 4, null));
            }
            d0.e0.p.d.m0.n.n1.b bVar = d0.e0.p.d.m0.n.n1.b.FOR_SUBTYPING;
            NewCapturedType2 newTypeConstructor = capturedTypeConstructor3.getNewTypeConstructor();
            Intrinsics3.checkNotNull(newTypeConstructor);
            return new NewCapturedType(bVar, newTypeConstructor, kotlinType3, kotlinType4.getAnnotations(), kotlinType4.isMarkedNullable(), false, 32, null);
        }
        if (constructor instanceof IntegerValueTypeConstructor) {
            Collection<KotlinType> supertypes2 = ((IntegerValueTypeConstructor) constructor).getSupertypes();
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(supertypes2, 10));
            Iterator<T> it2 = supertypes2.iterator();
            while (it2.hasNext()) {
                KotlinType kotlinTypeMakeNullableAsSpecified = TypeUtils.makeNullableAsSpecified((KotlinType) it2.next(), kotlinType4.isMarkedNullable());
                Intrinsics3.checkNotNullExpressionValue(kotlinTypeMakeNullableAsSpecified, "makeNullableAsSpecified(it, type.isMarkedNullable)");
                arrayList2.add(kotlinTypeMakeNullableAsSpecified);
            }
            IntersectionTypeConstructor intersectionTypeConstructor = new IntersectionTypeConstructor(arrayList2);
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
            return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(kotlinType4.getAnnotations(), intersectionTypeConstructor, Collections2.emptyList(), false, kotlinType4.getMemberScope());
        }
        if (!(constructor instanceof IntersectionTypeConstructor) || !kotlinType4.isMarkedNullable()) {
            return kotlinType4;
        }
        IntersectionTypeConstructor intersectionTypeConstructor2 = (IntersectionTypeConstructor) constructor;
        Collection<KotlinType> supertypes3 = intersectionTypeConstructor2.getSupertypes();
        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(supertypes3, 10));
        Iterator<T> it3 = supertypes3.iterator();
        while (it3.hasNext()) {
            arrayList3.add(TypeUtils2.makeNullable((KotlinType) it3.next()));
            z2 = true;
        }
        if (z2) {
            KotlinType alternativeType = intersectionTypeConstructor2.getAlternativeType();
            alternative = new IntersectionTypeConstructor(arrayList3).setAlternative(alternativeType != null ? TypeUtils2.makeNullable(alternativeType) : null);
        }
        if (alternative != null) {
            intersectionTypeConstructor2 = alternative;
        }
        return intersectionTypeConstructor2.createType();
    }

    public final boolean equalTypes(ClassicTypeCheckerContext classicTypeCheckerContext, KotlinType3 kotlinType3, KotlinType3 kotlinType4) {
        Intrinsics3.checkNotNullParameter(classicTypeCheckerContext, "<this>");
        Intrinsics3.checkNotNullParameter(kotlinType3, "a");
        Intrinsics3.checkNotNullParameter(kotlinType4, "b");
        return AbstractTypeChecker2.a.equalTypes(classicTypeCheckerContext, kotlinType3, kotlinType4);
    }

    public final boolean isSubtypeOf(ClassicTypeCheckerContext classicTypeCheckerContext, KotlinType3 kotlinType3, KotlinType3 kotlinType4) {
        Intrinsics3.checkNotNullParameter(classicTypeCheckerContext, "<this>");
        Intrinsics3.checkNotNullParameter(kotlinType3, "subType");
        Intrinsics3.checkNotNullParameter(kotlinType4, "superType");
        return AbstractTypeChecker2.isSubtypeOf$default(AbstractTypeChecker2.a, classicTypeCheckerContext, kotlinType3, kotlinType4, false, 8, null);
    }

    public KotlinType3 transformToNewType(KotlinType3 kotlinType3) {
        KotlinType3 kotlinType3FlexibleType;
        Intrinsics3.checkNotNullParameter(kotlinType3, "type");
        if (kotlinType3 instanceof KotlinType4) {
            kotlinType3FlexibleType = transformToNewType((KotlinType4) kotlinType3);
        } else if (kotlinType3 instanceof KotlinType6) {
            KotlinType6 kotlinType6 = (KotlinType6) kotlinType3;
            KotlinType4 kotlinType4TransformToNewType = transformToNewType(kotlinType6.getLowerBound());
            KotlinType4 kotlinType4TransformToNewType2 = transformToNewType(kotlinType6.getUpperBound());
            if (kotlinType4TransformToNewType == kotlinType6.getLowerBound() && kotlinType4TransformToNewType2 == kotlinType6.getUpperBound()) {
                kotlinType3FlexibleType = kotlinType3;
            } else {
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
                kotlinType3FlexibleType = KotlinTypeFactory.flexibleType(kotlinType4TransformToNewType, kotlinType4TransformToNewType2);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return TypeWithEnhancement2.inheritEnhancement(kotlinType3FlexibleType, kotlinType3);
    }
}
