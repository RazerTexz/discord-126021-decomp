package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.e0.p.d.m0.p.SmartSet;
import d0.t._Collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.e1, reason: use source file name */
/* JADX INFO: compiled from: TypeUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class TypeUtils {
    public static final KotlinType4 a = ErrorUtils.createErrorTypeWithCustomDebugName("DONT_CARE");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final KotlinType4 f3522b = ErrorUtils.createErrorType("Cannot be inferred");
    public static final KotlinType4 c = new a("NO_EXPECTED_TYPE");
    public static final KotlinType4 d = new a("UNIT_EXPECTED_TYPE");

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.e1$a */
    /* JADX INFO: compiled from: TypeUtils.java */
    public static class a extends SpecialTypes4 {
        public final String k;

        public a(String str) {
            this.k = str;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0030  */
        public static /* synthetic */ void a(int i) {
            String str = (i == 1 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 1 || i == 4) ? 2 : 3];
            if (i == 1) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            } else if (i == 2) {
                objArr[0] = "delegate";
            } else if (i == 3) {
                objArr[0] = "kotlinTypeRefiner";
            } else if (i != 4) {
                objArr[0] = "newAnnotations";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            }
            if (i == 1) {
                objArr[1] = "toString";
            } else if (i != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            } else {
                objArr[1] = "refine";
            }
            if (i != 1) {
                if (i == 2) {
                    objArr[2] = "replaceDelegate";
                } else if (i == 3) {
                    objArr[2] = "refine";
                } else if (i != 4) {
                    objArr[2] = "replaceAnnotations";
                }
            }
            String str2 = String.format(str, objArr);
            if (i != 1 && i != 4) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @Override // d0.e0.p.d.m0.n.SpecialTypes4
        public KotlinType4 getDelegate() {
            throw new IllegalStateException(this.k);
        }

        @Override // d0.e0.p.d.m0.n.SpecialTypes4, d0.e0.p.d.m0.n.KotlinType3, d0.e0.p.d.m0.n.KotlinType
        public a refine(KotlinTypeRefiner kotlinTypeRefiner) {
            if (kotlinTypeRefiner != null) {
                return this;
            }
            a(3);
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.SpecialTypes4
        public SpecialTypes4 replaceDelegate(KotlinType4 kotlinType4) {
            if (kotlinType4 != null) {
                throw new IllegalStateException(this.k);
            }
            a(2);
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.KotlinType4
        public String toString() {
            String str = this.k;
            if (str != null) {
                return str;
            }
            a(1);
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.KotlinType3
        public KotlinType4 makeNullableAsSpecified(boolean z2) {
            throw new IllegalStateException(this.k);
        }

        @Override // d0.e0.p.d.m0.n.KotlinType3
        public KotlinType4 replaceAnnotations(Annotations4 annotations4) {
            if (annotations4 != null) {
                throw new IllegalStateException(this.k);
            }
            a(0);
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0035  */
    /* JADX WARN: Code duplicated, block: B:33:0x0055  */
    /* JADX WARN: Code duplicated, block: B:75:0x0105  */
    /* JADX WARN: Code duplicated, block: B:82:0x0120  */
    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        if (i != 4 && i != 9 && i != 11 && i != 15 && i != 17 && i != 19 && i != 26 && i != 35 && i != 47 && i != 52 && i != 6 && i != 7) {
            switch (i) {
                case 55:
                case 56:
                case 57:
                case 58:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 4 && i != 9 && i != 11 && i != 15 && i != 17 && i != 19 && i != 26 && i != 35 && i != 47 && i != 52 && i != 6 && i != 7) {
            switch (i) {
                case 55:
                case 56:
                case 57:
                case 58:
                    i2 = 2;
                    break;
                default:
                    i2 = 3;
                    break;
            }
        } else {
            i2 = 2;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case 47:
            case 52:
            case 55:
            case 56:
            case 57:
            case 58:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                break;
            case 5:
            case 8:
            case 10:
            case 18:
            case 23:
            case 25:
            case 27:
            case 28:
            case 29:
            case 30:
            case 38:
            case 40:
            default:
                objArr[0] = "type";
                break;
            case 12:
                objArr[0] = "typeConstructor";
                break;
            case 13:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 14:
                objArr[0] = "refinedTypeFactory";
                break;
            case 16:
                objArr[0] = "parameters";
                break;
            case 20:
                objArr[0] = "subType";
                break;
            case 21:
                objArr[0] = "superType";
                break;
            case 22:
                objArr[0] = "substitutor";
                break;
            case 24:
                objArr[0] = "result";
                break;
            case 31:
            case 33:
                objArr[0] = "clazz";
                break;
            case 32:
                objArr[0] = "typeArguments";
                break;
            case 34:
                objArr[0] = "projections";
                break;
            case 36:
                objArr[0] = "a";
                break;
            case 37:
                objArr[0] = "b";
                break;
            case 39:
                objArr[0] = "typeParameters";
                break;
            case 41:
                objArr[0] = "typeParameterConstructors";
                break;
            case 42:
                objArr[0] = "specialType";
                break;
            case 43:
            case 44:
                objArr[0] = "isSpecialType";
                break;
            case 45:
                objArr[0] = "parameterDescriptor";
                break;
            case 46:
            case 50:
                objArr[0] = "numberValueTypeConstructor";
                break;
            case 48:
            case 49:
                objArr[0] = "supertypes";
                break;
            case 51:
            case 54:
                objArr[0] = "expectedType";
                break;
            case 53:
                objArr[0] = "literalTypeConstructor";
                break;
        }
        if (i == 4) {
            objArr[1] = "makeNullableAsSpecified";
        } else if (i == 9) {
            objArr[1] = "makeNullableIfNeeded";
        } else if (i == 11 || i == 15) {
            objArr[1] = "makeUnsubstitutedType";
        } else if (i == 17) {
            objArr[1] = "getDefaultTypeProjections";
        } else if (i == 19) {
            objArr[1] = "getImmediateSupertypes";
        } else if (i == 26) {
            objArr[1] = "getAllSupertypes";
        } else if (i == 35) {
            objArr[1] = "substituteProjectionsForParameters";
        } else if (i == 47) {
            objArr[1] = "getDefaultPrimitiveNumberType";
        } else if (i != 52) {
            if (i != 6 && i != 7) {
                switch (i) {
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                        objArr[1] = "getPrimitiveNumberType";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                        break;
                }
            } else {
                objArr[1] = "makeNullableIfNeeded";
            }
        } else {
            objArr[1] = "getPrimitiveNumberType";
        }
        switch (i) {
            case 1:
                objArr[2] = "makeNullable";
                break;
            case 2:
                objArr[2] = "makeNotNullable";
                break;
            case 3:
                objArr[2] = "makeNullableAsSpecified";
                break;
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case 47:
            case 52:
            case 55:
            case 56:
            case 57:
            case 58:
                break;
            case 5:
            case 8:
                objArr[2] = "makeNullableIfNeeded";
                break;
            case 10:
                objArr[2] = "canHaveSubtypes";
                break;
            case 12:
            case 13:
            case 14:
                objArr[2] = "makeUnsubstitutedType";
                break;
            case 16:
                objArr[2] = "getDefaultTypeProjections";
                break;
            case 18:
                objArr[2] = "getImmediateSupertypes";
                break;
            case 20:
            case 21:
            case 22:
                objArr[2] = "createSubstitutedSupertype";
                break;
            case 23:
            case 24:
                objArr[2] = "collectAllSupertypes";
                break;
            case 25:
                objArr[2] = "getAllSupertypes";
                break;
            case 27:
                objArr[2] = "isNullableType";
                break;
            case 28:
                objArr[2] = "acceptsNullable";
                break;
            case 29:
                objArr[2] = "hasNullableSuperType";
                break;
            case 30:
                objArr[2] = "getClassDescriptor";
                break;
            case 31:
            case 32:
                objArr[2] = "substituteParameters";
                break;
            case 33:
            case 34:
                objArr[2] = "substituteProjectionsForParameters";
                break;
            case 36:
            case 37:
                objArr[2] = "equalTypes";
                break;
            case 38:
            case 39:
                objArr[2] = "dependsOnTypeParameters";
                break;
            case 40:
            case 41:
                objArr[2] = "dependsOnTypeConstructors";
                break;
            case 42:
            case 43:
            case 44:
                objArr[2] = "contains";
                break;
            case 45:
                objArr[2] = "makeStarProjection";
                break;
            case 46:
            case 48:
                objArr[2] = "getDefaultPrimitiveNumberType";
                break;
            case 49:
                objArr[2] = "findByFqName";
                break;
            case 50:
            case 51:
            case 53:
            case 54:
                objArr[2] = "getPrimitiveNumberType";
                break;
            case 59:
                objArr[2] = "isTypeParameter";
                break;
            case 60:
                objArr[2] = "isReifiedTypeParameter";
                break;
            case 61:
                objArr[2] = "isNonReifiedTypeParameter";
                break;
            case 62:
                objArr[2] = "getTypeParameterDescriptorOrNull";
                break;
            default:
                objArr[2] = "noExpectedType";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 9 && i != 11 && i != 15 && i != 17 && i != 19 && i != 26 && i != 35 && i != 47 && i != 52 && i != 6 && i != 7) {
            switch (i) {
                case 55:
                case 56:
                case 57:
                case 58:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    public static boolean acceptsNullable(KotlinType kotlinType) {
        if (kotlinType == null) {
            a(28);
            throw null;
        }
        if (kotlinType.isMarkedNullable()) {
            return true;
        }
        return flexibleTypes2.isFlexible(kotlinType) && acceptsNullable(flexibleTypes2.asFlexibleType(kotlinType).getUpperBound());
    }

    public static boolean b(KotlinType kotlinType, Function1<KotlinType3, Boolean> function1, SmartSet<KotlinType> smartSet) {
        if (function1 == null) {
            a(44);
            throw null;
        }
        if (kotlinType == null) {
            return false;
        }
        KotlinType3 kotlinType3Unwrap = kotlinType.unwrap();
        if (noExpectedType(kotlinType)) {
            return function1.invoke(kotlinType3Unwrap).booleanValue();
        }
        if (smartSet != null && smartSet.contains(kotlinType)) {
            return false;
        }
        if (function1.invoke(kotlinType3Unwrap).booleanValue()) {
            return true;
        }
        if (smartSet == null) {
            smartSet = SmartSet.create();
        }
        smartSet.add(kotlinType);
        KotlinType6 kotlinType6 = kotlinType3Unwrap instanceof KotlinType6 ? (KotlinType6) kotlinType3Unwrap : null;
        if (kotlinType6 != null && (b(kotlinType6.getLowerBound(), function1, smartSet) || b(kotlinType6.getUpperBound(), function1, smartSet))) {
            return true;
        }
        if ((kotlinType3Unwrap instanceof SpecialTypes3) && b(((SpecialTypes3) kotlinType3Unwrap).getOriginal(), function1, smartSet)) {
            return true;
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (constructor instanceof IntersectionTypeConstructor) {
            Iterator<KotlinType> it = ((IntersectionTypeConstructor) constructor).getSupertypes().iterator();
            while (it.hasNext()) {
                if (b(it.next(), function1, smartSet)) {
                    return true;
                }
            }
            return false;
        }
        for (TypeProjection typeProjection : kotlinType.getArguments()) {
            if (!typeProjection.isStarProjection()) {
                if (b(typeProjection.getType(), function1, smartSet)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean contains(KotlinType kotlinType, Function1<KotlinType3, Boolean> function1) {
        if (function1 != null) {
            return b(kotlinType, function1, null);
        }
        a(43);
        throw null;
    }

    public static KotlinType createSubstitutedSupertype(KotlinType kotlinType, KotlinType kotlinType2, TypeSubstitutor2 typeSubstitutor2) {
        if (kotlinType == null) {
            a(20);
            throw null;
        }
        if (kotlinType2 == null) {
            a(21);
            throw null;
        }
        if (typeSubstitutor2 == null) {
            a(22);
            throw null;
        }
        KotlinType kotlinTypeSubstitute = typeSubstitutor2.substitute(kotlinType2, Variance.INVARIANT);
        if (kotlinTypeSubstitute != null) {
            return makeNullableIfNeeded(kotlinTypeSubstitute, kotlinType.isMarkedNullable());
        }
        return null;
    }

    public static ClassDescriptor getClassDescriptor(KotlinType kotlinType) {
        if (kotlinType == null) {
            a(30);
            throw null;
        }
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) declarationDescriptor;
        }
        return null;
    }

    public static List<TypeProjection> getDefaultTypeProjections(List<TypeParameterDescriptor> list) {
        if (list == null) {
            a(16);
            throw null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<TypeParameterDescriptor> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new TypeProjectionImpl(it.next().getDefaultType()));
        }
        List<TypeProjection> list2 = _Collections.toList(arrayList);
        if (list2 != null) {
            return list2;
        }
        a(17);
        throw null;
    }

    public static List<KotlinType> getImmediateSupertypes(KotlinType kotlinType) {
        if (kotlinType == null) {
            a(18);
            throw null;
        }
        TypeSubstitutor2 typeSubstitutor2Create = TypeSubstitutor2.create(kotlinType);
        Collection<KotlinType> supertypes = kotlinType.getConstructor().getSupertypes();
        ArrayList arrayList = new ArrayList(supertypes.size());
        Iterator<KotlinType> it = supertypes.iterator();
        while (it.hasNext()) {
            KotlinType kotlinTypeCreateSubstitutedSupertype = createSubstitutedSupertype(kotlinType, it.next(), typeSubstitutor2Create);
            if (kotlinTypeCreateSubstitutedSupertype != null) {
                arrayList.add(kotlinTypeCreateSubstitutedSupertype);
            }
        }
        return arrayList;
    }

    public static TypeParameterDescriptor getTypeParameterDescriptorOrNull(KotlinType kotlinType) {
        if (kotlinType == null) {
            a(62);
            throw null;
        }
        if (kotlinType.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor) {
            return (TypeParameterDescriptor) kotlinType.getConstructor().getDeclarationDescriptor();
        }
        return null;
    }

    public static boolean hasNullableSuperType(KotlinType kotlinType) {
        if (kotlinType == null) {
            a(29);
            throw null;
        }
        if (kotlinType.getConstructor().getDeclarationDescriptor() instanceof ClassDescriptor) {
            return false;
        }
        Iterator<KotlinType> it = getImmediateSupertypes(kotlinType).iterator();
        while (it.hasNext()) {
            if (isNullableType(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDontCarePlaceholder(KotlinType kotlinType) {
        return kotlinType != null && kotlinType.getConstructor() == a.getConstructor();
    }

    public static boolean isNullableType(KotlinType kotlinType) {
        if (kotlinType == null) {
            a(27);
            throw null;
        }
        if (kotlinType.isMarkedNullable()) {
            return true;
        }
        if (flexibleTypes2.isFlexible(kotlinType) && isNullableType(flexibleTypes2.asFlexibleType(kotlinType).getUpperBound())) {
            return true;
        }
        if (SpecialTypes5.isDefinitelyNotNullType(kotlinType)) {
            return false;
        }
        if (isTypeParameter(kotlinType)) {
            return hasNullableSuperType(kotlinType);
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (constructor instanceof IntersectionTypeConstructor) {
            Iterator<KotlinType> it = constructor.getSupertypes().iterator();
            while (it.hasNext()) {
                if (isNullableType(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isTypeParameter(KotlinType kotlinType) {
        if (kotlinType == null) {
            a(59);
            throw null;
        }
        if (getTypeParameterDescriptorOrNull(kotlinType) != null) {
            return true;
        }
        kotlinType.getConstructor();
        return false;
    }

    public static KotlinType makeNotNullable(KotlinType kotlinType) {
        if (kotlinType != null) {
            return makeNullableAsSpecified(kotlinType, false);
        }
        a(2);
        throw null;
    }

    public static KotlinType makeNullable(KotlinType kotlinType) {
        if (kotlinType != null) {
            return makeNullableAsSpecified(kotlinType, true);
        }
        a(1);
        throw null;
    }

    public static KotlinType makeNullableAsSpecified(KotlinType kotlinType, boolean z2) {
        if (kotlinType == null) {
            a(3);
            throw null;
        }
        KotlinType3 kotlinType3MakeNullableAsSpecified = kotlinType.unwrap().makeNullableAsSpecified(z2);
        if (kotlinType3MakeNullableAsSpecified != null) {
            return kotlinType3MakeNullableAsSpecified;
        }
        a(4);
        throw null;
    }

    public static KotlinType4 makeNullableIfNeeded(KotlinType4 kotlinType4, boolean z2) {
        if (kotlinType4 == null) {
            a(5);
            throw null;
        }
        if (!z2) {
            if (kotlinType4 != null) {
                return kotlinType4;
            }
            a(7);
            throw null;
        }
        KotlinType4 kotlinType4MakeNullableAsSpecified = kotlinType4.makeNullableAsSpecified(true);
        if (kotlinType4MakeNullableAsSpecified != null) {
            return kotlinType4MakeNullableAsSpecified;
        }
        a(6);
        throw null;
    }

    public static TypeProjection makeStarProjection(TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor != null) {
            return new StarProjectionImpl2(typeParameterDescriptor);
        }
        a(45);
        throw null;
    }

    public static KotlinType4 makeUnsubstitutedType(ClassifierDescriptor classifierDescriptor, MemberScope3 memberScope3, Function1<KotlinTypeRefiner, KotlinType4> function1) {
        if (!ErrorUtils.isError(classifierDescriptor)) {
            return makeUnsubstitutedType(classifierDescriptor.getTypeConstructor(), memberScope3, function1);
        }
        KotlinType4 kotlinType4CreateErrorType = ErrorUtils.createErrorType("Unsubstituted type for " + classifierDescriptor);
        if (kotlinType4CreateErrorType != null) {
            return kotlinType4CreateErrorType;
        }
        a(11);
        throw null;
    }

    public static boolean noExpectedType(KotlinType kotlinType) {
        if (kotlinType != null) {
            return kotlinType == c || kotlinType == d;
        }
        a(0);
        throw null;
    }

    public static KotlinType makeNullableIfNeeded(KotlinType kotlinType, boolean z2) {
        if (kotlinType == null) {
            a(8);
            throw null;
        }
        if (z2) {
            return makeNullable(kotlinType);
        }
        if (kotlinType != null) {
            return kotlinType;
        }
        a(9);
        throw null;
    }

    public static KotlinType4 makeUnsubstitutedType(TypeConstructor typeConstructor, MemberScope3 memberScope3, Function1<KotlinTypeRefiner, KotlinType4> function1) {
        if (typeConstructor == null) {
            a(12);
            throw null;
        }
        if (memberScope3 == null) {
            a(13);
            throw null;
        }
        if (function1 != null) {
            KotlinType4 kotlinType4SimpleTypeWithNonTrivialMemberScope = KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(Annotations4.f.getEMPTY(), typeConstructor, getDefaultTypeProjections(typeConstructor.getParameters()), false, memberScope3, function1);
            if (kotlinType4SimpleTypeWithNonTrivialMemberScope != null) {
                return kotlinType4SimpleTypeWithNonTrivialMemberScope;
            }
            a(15);
            throw null;
        }
        a(14);
        throw null;
    }
}
