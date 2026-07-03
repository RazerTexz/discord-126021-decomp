package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12042j;
import p507d0.p580t.C12163u;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.e1 */
/* JADX INFO: compiled from: TypeUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11920e1 {

    /* JADX INFO: renamed from: a */
    public static final AbstractC11934j0 f24753a = C12005t.createErrorTypeWithCustomDebugName("DONT_CARE");

    /* JADX INFO: renamed from: b */
    public static final AbstractC11934j0 f24754b = C12005t.createErrorType("Cannot be inferred");

    /* JADX INFO: renamed from: c */
    public static final AbstractC11934j0 f24755c = new a("NO_EXPECTED_TYPE");

    /* JADX INFO: renamed from: d */
    public static final AbstractC11934j0 f24756d = new a("UNIT_EXPECTED_TYPE");

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.e1$a */
    /* JADX INFO: compiled from: TypeUtils.java */
    public static class a extends AbstractC11967m {

        /* JADX INFO: renamed from: k */
        public final String f24757k;

        public a(String str) {
            this.f24757k = str;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0030  */
        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m10010a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11967m
        public AbstractC11934j0 getDelegate() {
            throw new IllegalStateException(this.f24757k);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11967m, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
        public a refine(AbstractC11947g abstractC11947g) {
            if (abstractC11947g != null) {
                return this;
            }
            m10010a(3);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11967m
        public AbstractC11967m replaceDelegate(AbstractC11934j0 abstractC11934j0) {
            if (abstractC11934j0 != null) {
                throw new IllegalStateException(this.f24757k);
            }
            m10010a(2);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0
        public String toString() {
            String str = this.f24757k;
            if (str != null) {
                return str;
            }
            m10010a(1);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
        public AbstractC11934j0 makeNullableAsSpecified(boolean z2) {
            throw new IllegalStateException(this.f24757k);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
        public AbstractC11934j0 replaceAnnotations(InterfaceC11344g interfaceC11344g) {
            if (interfaceC11344g != null) {
                throw new IllegalStateException(this.f24757k);
            }
            m10010a(0);
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0035  */
    /* JADX WARN: Code duplicated, block: B:33:0x0055  */
    /* JADX WARN: Code duplicated, block: B:75:0x0105  */
    /* JADX WARN: Code duplicated, block: B:82:0x0120  */
    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m10008a(int i) {
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

    public static boolean acceptsNullable(AbstractC11913c0 abstractC11913c0) {
        if (abstractC11913c0 == null) {
            m10008a(28);
            throw null;
        }
        if (abstractC11913c0.isMarkedNullable()) {
            return true;
        }
        return C12015y.isFlexible(abstractC11913c0) && acceptsNullable(C12015y.asFlexibleType(abstractC11913c0).getUpperBound());
    }

    /* JADX INFO: renamed from: b */
    public static boolean m10009b(AbstractC11913c0 abstractC11913c0, Function1<AbstractC11932i1, Boolean> function1, C12042j<AbstractC11913c0> c12042j) {
        if (function1 == null) {
            m10008a(44);
            throw null;
        }
        if (abstractC11913c0 == null) {
            return false;
        }
        AbstractC11932i1 abstractC11932i1Unwrap = abstractC11913c0.unwrap();
        if (noExpectedType(abstractC11913c0)) {
            return function1.invoke(abstractC11932i1Unwrap).booleanValue();
        }
        if (c12042j != null && c12042j.contains(abstractC11913c0)) {
            return false;
        }
        if (function1.invoke(abstractC11932i1Unwrap).booleanValue()) {
            return true;
        }
        if (c12042j == null) {
            c12042j = C12042j.create();
        }
        c12042j.add(abstractC11913c0);
        AbstractC12009v abstractC12009v = abstractC11932i1Unwrap instanceof AbstractC12009v ? (AbstractC12009v) abstractC11932i1Unwrap : null;
        if (abstractC12009v != null && (m10009b(abstractC12009v.getLowerBound(), function1, c12042j) || m10009b(abstractC12009v.getUpperBound(), function1, c12042j))) {
            return true;
        }
        if ((abstractC11932i1Unwrap instanceof C11936k) && m10009b(((C11936k) abstractC11932i1Unwrap).getOriginal(), function1, c12042j)) {
            return true;
        }
        InterfaceC12008u0 constructor = abstractC11913c0.getConstructor();
        if (constructor instanceof C11907a0) {
            Iterator<AbstractC11913c0> it = ((C11907a0) constructor).getSupertypes().iterator();
            while (it.hasNext()) {
                if (m10009b(it.next(), function1, c12042j)) {
                    return true;
                }
            }
            return false;
        }
        for (InterfaceC12012w0 interfaceC12012w0 : abstractC11913c0.getArguments()) {
            if (!interfaceC12012w0.isStarProjection()) {
                if (m10009b(interfaceC12012w0.getType(), function1, c12042j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean contains(AbstractC11913c0 abstractC11913c0, Function1<AbstractC11932i1, Boolean> function1) {
        if (function1 != null) {
            return m10009b(abstractC11913c0, function1, null);
        }
        m10008a(43);
        throw null;
    }

    public static AbstractC11913c0 createSubstitutedSupertype(AbstractC11913c0 abstractC11913c0, AbstractC11913c0 abstractC11913c1, C11914c1 c11914c1) {
        if (abstractC11913c0 == null) {
            m10008a(20);
            throw null;
        }
        if (abstractC11913c1 == null) {
            m10008a(21);
            throw null;
        }
        if (c11914c1 == null) {
            m10008a(22);
            throw null;
        }
        AbstractC11913c0 abstractC11913c0Substitute = c11914c1.substitute(abstractC11913c1, EnumC11935j1.INVARIANT);
        if (abstractC11913c0Substitute != null) {
            return makeNullableIfNeeded(abstractC11913c0Substitute, abstractC11913c0.isMarkedNullable());
        }
        return null;
    }

    public static InterfaceC11330e getClassDescriptor(AbstractC11913c0 abstractC11913c0) {
        if (abstractC11913c0 == null) {
            m10008a(30);
            throw null;
        }
        InterfaceC11352h declarationDescriptor = abstractC11913c0.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof InterfaceC11330e) {
            return (InterfaceC11330e) declarationDescriptor;
        }
        return null;
    }

    public static List<InterfaceC12012w0> getDefaultTypeProjections(List<InterfaceC11477z0> list) {
        if (list == null) {
            m10008a(16);
            throw null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<InterfaceC11477z0> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new C12016y0(it.next().getDefaultType()));
        }
        List<InterfaceC12012w0> list2 = C12163u.toList(arrayList);
        if (list2 != null) {
            return list2;
        }
        m10008a(17);
        throw null;
    }

    public static List<AbstractC11913c0> getImmediateSupertypes(AbstractC11913c0 abstractC11913c0) {
        if (abstractC11913c0 == null) {
            m10008a(18);
            throw null;
        }
        C11914c1 c11914c1Create = C11914c1.create(abstractC11913c0);
        Collection<AbstractC11913c0> supertypes = abstractC11913c0.getConstructor().getSupertypes();
        ArrayList arrayList = new ArrayList(supertypes.size());
        Iterator<AbstractC11913c0> it = supertypes.iterator();
        while (it.hasNext()) {
            AbstractC11913c0 abstractC11913c0CreateSubstitutedSupertype = createSubstitutedSupertype(abstractC11913c0, it.next(), c11914c1Create);
            if (abstractC11913c0CreateSubstitutedSupertype != null) {
                arrayList.add(abstractC11913c0CreateSubstitutedSupertype);
            }
        }
        return arrayList;
    }

    public static InterfaceC11477z0 getTypeParameterDescriptorOrNull(AbstractC11913c0 abstractC11913c0) {
        if (abstractC11913c0 == null) {
            m10008a(62);
            throw null;
        }
        if (abstractC11913c0.getConstructor().getDeclarationDescriptor() instanceof InterfaceC11477z0) {
            return (InterfaceC11477z0) abstractC11913c0.getConstructor().getDeclarationDescriptor();
        }
        return null;
    }

    public static boolean hasNullableSuperType(AbstractC11913c0 abstractC11913c0) {
        if (abstractC11913c0 == null) {
            m10008a(29);
            throw null;
        }
        if (abstractC11913c0.getConstructor().getDeclarationDescriptor() instanceof InterfaceC11330e) {
            return false;
        }
        Iterator<AbstractC11913c0> it = getImmediateSupertypes(abstractC11913c0).iterator();
        while (it.hasNext()) {
            if (isNullableType(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDontCarePlaceholder(AbstractC11913c0 abstractC11913c0) {
        return abstractC11913c0 != null && abstractC11913c0.getConstructor() == f24753a.getConstructor();
    }

    public static boolean isNullableType(AbstractC11913c0 abstractC11913c0) {
        if (abstractC11913c0 == null) {
            m10008a(27);
            throw null;
        }
        if (abstractC11913c0.isMarkedNullable()) {
            return true;
        }
        if (C12015y.isFlexible(abstractC11913c0) && isNullableType(C12015y.asFlexibleType(abstractC11913c0).getUpperBound())) {
            return true;
        }
        if (C11968m0.isDefinitelyNotNullType(abstractC11913c0)) {
            return false;
        }
        if (isTypeParameter(abstractC11913c0)) {
            return hasNullableSuperType(abstractC11913c0);
        }
        InterfaceC12008u0 constructor = abstractC11913c0.getConstructor();
        if (constructor instanceof C11907a0) {
            Iterator<AbstractC11913c0> it = constructor.getSupertypes().iterator();
            while (it.hasNext()) {
                if (isNullableType(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isTypeParameter(AbstractC11913c0 abstractC11913c0) {
        if (abstractC11913c0 == null) {
            m10008a(59);
            throw null;
        }
        if (getTypeParameterDescriptorOrNull(abstractC11913c0) != null) {
            return true;
        }
        abstractC11913c0.getConstructor();
        return false;
    }

    public static AbstractC11913c0 makeNotNullable(AbstractC11913c0 abstractC11913c0) {
        if (abstractC11913c0 != null) {
            return makeNullableAsSpecified(abstractC11913c0, false);
        }
        m10008a(2);
        throw null;
    }

    public static AbstractC11913c0 makeNullable(AbstractC11913c0 abstractC11913c0) {
        if (abstractC11913c0 != null) {
            return makeNullableAsSpecified(abstractC11913c0, true);
        }
        m10008a(1);
        throw null;
    }

    public static AbstractC11913c0 makeNullableAsSpecified(AbstractC11913c0 abstractC11913c0, boolean z2) {
        if (abstractC11913c0 == null) {
            m10008a(3);
            throw null;
        }
        AbstractC11932i1 abstractC11932i1MakeNullableAsSpecified = abstractC11913c0.unwrap().makeNullableAsSpecified(z2);
        if (abstractC11932i1MakeNullableAsSpecified != null) {
            return abstractC11932i1MakeNullableAsSpecified;
        }
        m10008a(4);
        throw null;
    }

    public static AbstractC11934j0 makeNullableIfNeeded(AbstractC11934j0 abstractC11934j0, boolean z2) {
        if (abstractC11934j0 == null) {
            m10008a(5);
            throw null;
        }
        if (!z2) {
            if (abstractC11934j0 != null) {
                return abstractC11934j0;
            }
            m10008a(7);
            throw null;
        }
        AbstractC11934j0 abstractC11934j0MakeNullableAsSpecified = abstractC11934j0.makeNullableAsSpecified(true);
        if (abstractC11934j0MakeNullableAsSpecified != null) {
            return abstractC11934j0MakeNullableAsSpecified;
        }
        m10008a(6);
        throw null;
    }

    public static InterfaceC12012w0 makeStarProjection(InterfaceC11477z0 interfaceC11477z0) {
        if (interfaceC11477z0 != null) {
            return new C11991o0(interfaceC11477z0);
        }
        m10008a(45);
        throw null;
    }

    public static AbstractC11934j0 makeUnsubstitutedType(InterfaceC11352h interfaceC11352h, InterfaceC11770i interfaceC11770i, Function1<AbstractC11947g, AbstractC11934j0> function1) {
        if (!C12005t.isError(interfaceC11352h)) {
            return makeUnsubstitutedType(interfaceC11352h.getTypeConstructor(), interfaceC11770i, function1);
        }
        AbstractC11934j0 abstractC11934j0CreateErrorType = C12005t.createErrorType("Unsubstituted type for " + interfaceC11352h);
        if (abstractC11934j0CreateErrorType != null) {
            return abstractC11934j0CreateErrorType;
        }
        m10008a(11);
        throw null;
    }

    public static boolean noExpectedType(AbstractC11913c0 abstractC11913c0) {
        if (abstractC11913c0 != null) {
            return abstractC11913c0 == f24755c || abstractC11913c0 == f24756d;
        }
        m10008a(0);
        throw null;
    }

    public static AbstractC11913c0 makeNullableIfNeeded(AbstractC11913c0 abstractC11913c0, boolean z2) {
        if (abstractC11913c0 == null) {
            m10008a(8);
            throw null;
        }
        if (z2) {
            return makeNullable(abstractC11913c0);
        }
        if (abstractC11913c0 != null) {
            return abstractC11913c0;
        }
        m10008a(9);
        throw null;
    }

    public static AbstractC11934j0 makeUnsubstitutedType(InterfaceC12008u0 interfaceC12008u0, InterfaceC11770i interfaceC11770i, Function1<AbstractC11947g, AbstractC11934j0> function1) {
        if (interfaceC12008u0 == null) {
            m10008a(12);
            throw null;
        }
        if (interfaceC11770i == null) {
            m10008a(13);
            throw null;
        }
        if (function1 != null) {
            AbstractC11934j0 abstractC11934j0SimpleTypeWithNonTrivialMemberScope = C11916d0.simpleTypeWithNonTrivialMemberScope(InterfaceC11344g.f22735f.getEMPTY(), interfaceC12008u0, getDefaultTypeProjections(interfaceC12008u0.getParameters()), false, interfaceC11770i, function1);
            if (abstractC11934j0SimpleTypeWithNonTrivialMemberScope != null) {
                return abstractC11934j0SimpleTypeWithNonTrivialMemberScope;
            }
            m10008a(15);
            throw null;
        }
        m10008a(14);
        throw null;
    }
}
