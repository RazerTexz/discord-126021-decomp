package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.n.l1.NewCapturedType;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.m0, reason: use source file name */
/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SpecialTypes5 {
    public static final KotlinType4 a(KotlinType kotlinType) {
        IntersectionTypeConstructor alternative;
        TypeConstructor constructor = kotlinType.getConstructor();
        IntersectionTypeConstructor intersectionTypeConstructor = constructor instanceof IntersectionTypeConstructor ? (IntersectionTypeConstructor) constructor : null;
        if (intersectionTypeConstructor == null) {
            return null;
        }
        Collection<KotlinType> supertypes = intersectionTypeConstructor.getSupertypes();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(supertypes, 10));
        boolean z2 = false;
        for (KotlinType kotlinTypeMakeDefinitelyNotNullOrNotNull$default : supertypes) {
            if (TypeUtils.isNullableType(kotlinTypeMakeDefinitelyNotNullOrNotNull$default)) {
                kotlinTypeMakeDefinitelyNotNullOrNotNull$default = makeDefinitelyNotNullOrNotNull$default(kotlinTypeMakeDefinitelyNotNullOrNotNull$default.unwrap(), false, 1, null);
                z2 = true;
            }
            arrayList.add(kotlinTypeMakeDefinitelyNotNullOrNotNull$default);
        }
        if (z2) {
            KotlinType alternativeType = intersectionTypeConstructor.getAlternativeType();
            if (alternativeType == null) {
                alternativeType = null;
            } else if (TypeUtils.isNullableType(alternativeType)) {
                alternativeType = makeDefinitelyNotNullOrNotNull$default(alternativeType.unwrap(), false, 1, null);
            }
            alternative = new IntersectionTypeConstructor(arrayList).setAlternative(alternativeType);
        } else {
            alternative = null;
        }
        if (alternative == null) {
            return null;
        }
        return alternative.createType();
    }

    public static final SpecialTypes getAbbreviatedType(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        KotlinType3 kotlinType3Unwrap = kotlinType.unwrap();
        if (kotlinType3Unwrap instanceof SpecialTypes) {
            return (SpecialTypes) kotlinType3Unwrap;
        }
        return null;
    }

    public static final KotlinType4 getAbbreviation(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        SpecialTypes abbreviatedType = getAbbreviatedType(kotlinType);
        if (abbreviatedType == null) {
            return null;
        }
        return abbreviatedType.getAbbreviation();
    }

    public static final boolean isDefinitelyNotNullType(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        return kotlinType.unwrap() instanceof SpecialTypes3;
    }

    public static final KotlinType3 makeDefinitelyNotNullOrNotNull(KotlinType3 kotlinType3, boolean z2) {
        Intrinsics3.checkNotNullParameter(kotlinType3, "<this>");
        SpecialTypes3 specialTypes3MakeDefinitelyNotNull$descriptors = SpecialTypes3.k.makeDefinitelyNotNull$descriptors(kotlinType3, z2);
        if (specialTypes3MakeDefinitelyNotNull$descriptors != null) {
            return specialTypes3MakeDefinitelyNotNull$descriptors;
        }
        KotlinType4 kotlinType4A = a(kotlinType3);
        return kotlinType4A == null ? kotlinType3.makeNullableAsSpecified(false) : kotlinType4A;
    }

    public static /* synthetic */ KotlinType3 makeDefinitelyNotNullOrNotNull$default(KotlinType3 kotlinType3, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return makeDefinitelyNotNullOrNotNull(kotlinType3, z2);
    }

    public static final KotlinType4 makeSimpleTypeDefinitelyNotNullOrNotNull(KotlinType4 kotlinType4, boolean z2) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "<this>");
        SpecialTypes3 specialTypes3MakeDefinitelyNotNull$descriptors = SpecialTypes3.k.makeDefinitelyNotNull$descriptors(kotlinType4, z2);
        if (specialTypes3MakeDefinitelyNotNull$descriptors != null) {
            return specialTypes3MakeDefinitelyNotNull$descriptors;
        }
        KotlinType4 kotlinType4A = a(kotlinType4);
        return kotlinType4A == null ? kotlinType4.makeNullableAsSpecified(false) : kotlinType4A;
    }

    public static /* synthetic */ KotlinType4 makeSimpleTypeDefinitelyNotNullOrNotNull$default(KotlinType4 kotlinType4, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return makeSimpleTypeDefinitelyNotNullOrNotNull(kotlinType4, z2);
    }

    public static final KotlinType4 withAbbreviation(KotlinType4 kotlinType4, KotlinType4 kotlinType5) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "<this>");
        Intrinsics3.checkNotNullParameter(kotlinType5, "abbreviatedType");
        return KotlinType2.isError(kotlinType4) ? kotlinType4 : new SpecialTypes(kotlinType4, kotlinType5);
    }

    public static final NewCapturedType withNotNullProjection(NewCapturedType newCapturedType) {
        Intrinsics3.checkNotNullParameter(newCapturedType, "<this>");
        return new NewCapturedType(newCapturedType.getCaptureStatus(), newCapturedType.getConstructor(), newCapturedType.getLowerType(), newCapturedType.getAnnotations(), newCapturedType.isMarkedNullable(), true);
    }
}
