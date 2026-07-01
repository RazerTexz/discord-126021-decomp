package d0.e0.p.d.m0.n;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TypeUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class e1 {
    public static final j0 a = t.createErrorTypeWithCustomDebugName("DONT_CARE");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j0 f3522b = t.createErrorType("Cannot be inferred");
    public static final j0 c = new e1$a("NO_EXPECTED_TYPE");
    public static final j0 d = new e1$a("UNIT_EXPECTED_TYPE");

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

    public static boolean acceptsNullable(c0 c0Var) {
        if (c0Var == null) {
            a(28);
            throw null;
        }
        if (c0Var.isMarkedNullable()) {
            return true;
        }
        return y.isFlexible(c0Var) && acceptsNullable(y.asFlexibleType(c0Var).getUpperBound());
    }

    public static boolean b(c0 c0Var, Function1<i1, Boolean> function1, d0.e0.p.d.m0.p.j<c0> jVar) {
        if (function1 == null) {
            a(44);
            throw null;
        }
        if (c0Var == null) {
            return false;
        }
        i1 i1VarUnwrap = c0Var.unwrap();
        if (noExpectedType(c0Var)) {
            return function1.invoke(i1VarUnwrap).booleanValue();
        }
        if (jVar != null && jVar.contains(c0Var)) {
            return false;
        }
        if (function1.invoke(i1VarUnwrap).booleanValue()) {
            return true;
        }
        if (jVar == null) {
            jVar = d0.e0.p.d.m0.p.j.create();
        }
        jVar.add(c0Var);
        v vVar = i1VarUnwrap instanceof v ? (v) i1VarUnwrap : null;
        if (vVar != null && (b(vVar.getLowerBound(), function1, jVar) || b(vVar.getUpperBound(), function1, jVar))) {
            return true;
        }
        if ((i1VarUnwrap instanceof k) && b(((k) i1VarUnwrap).getOriginal(), function1, jVar)) {
            return true;
        }
        u0 constructor = c0Var.getConstructor();
        if (constructor instanceof a0) {
            Iterator<c0> it = ((a0) constructor).getSupertypes().iterator();
            while (it.hasNext()) {
                if (b(it.next(), function1, jVar)) {
                    return true;
                }
            }
            return false;
        }
        for (w0 w0Var : c0Var.getArguments()) {
            if (!w0Var.isStarProjection()) {
                if (b(w0Var.getType(), function1, jVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean contains(c0 c0Var, Function1<i1, Boolean> function1) {
        if (function1 != null) {
            return b(c0Var, function1, null);
        }
        a(43);
        throw null;
    }

    public static c0 createSubstitutedSupertype(c0 c0Var, c0 c0Var2, c1 c1Var) {
        if (c0Var == null) {
            a(20);
            throw null;
        }
        if (c0Var2 == null) {
            a(21);
            throw null;
        }
        if (c1Var == null) {
            a(22);
            throw null;
        }
        c0 c0VarSubstitute = c1Var.substitute(c0Var2, j1.INVARIANT);
        if (c0VarSubstitute != null) {
            return makeNullableIfNeeded(c0VarSubstitute, c0Var.isMarkedNullable());
        }
        return null;
    }

    public static d0.e0.p.d.m0.c.e getClassDescriptor(c0 c0Var) {
        if (c0Var == null) {
            a(30);
            throw null;
        }
        d0.e0.p.d.m0.c.h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof d0.e0.p.d.m0.c.e) {
            return (d0.e0.p.d.m0.c.e) declarationDescriptor;
        }
        return null;
    }

    public static List<w0> getDefaultTypeProjections(List<d0.e0.p.d.m0.c.z0> list) {
        if (list == null) {
            a(16);
            throw null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<d0.e0.p.d.m0.c.z0> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new y0(it.next().getDefaultType()));
        }
        List<w0> list2 = d0.t.u.toList(arrayList);
        if (list2 != null) {
            return list2;
        }
        a(17);
        throw null;
    }

    public static List<c0> getImmediateSupertypes(c0 c0Var) {
        if (c0Var == null) {
            a(18);
            throw null;
        }
        c1 c1VarCreate = c1.create(c0Var);
        Collection<c0> supertypes = c0Var.getConstructor().getSupertypes();
        ArrayList arrayList = new ArrayList(supertypes.size());
        Iterator<c0> it = supertypes.iterator();
        while (it.hasNext()) {
            c0 c0VarCreateSubstitutedSupertype = createSubstitutedSupertype(c0Var, it.next(), c1VarCreate);
            if (c0VarCreateSubstitutedSupertype != null) {
                arrayList.add(c0VarCreateSubstitutedSupertype);
            }
        }
        return arrayList;
    }

    public static d0.e0.p.d.m0.c.z0 getTypeParameterDescriptorOrNull(c0 c0Var) {
        if (c0Var == null) {
            a(62);
            throw null;
        }
        if (c0Var.getConstructor().getDeclarationDescriptor() instanceof d0.e0.p.d.m0.c.z0) {
            return (d0.e0.p.d.m0.c.z0) c0Var.getConstructor().getDeclarationDescriptor();
        }
        return null;
    }

    public static boolean hasNullableSuperType(c0 c0Var) {
        if (c0Var == null) {
            a(29);
            throw null;
        }
        if (c0Var.getConstructor().getDeclarationDescriptor() instanceof d0.e0.p.d.m0.c.e) {
            return false;
        }
        Iterator<c0> it = getImmediateSupertypes(c0Var).iterator();
        while (it.hasNext()) {
            if (isNullableType(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDontCarePlaceholder(c0 c0Var) {
        return c0Var != null && c0Var.getConstructor() == a.getConstructor();
    }

    public static boolean isNullableType(c0 c0Var) {
        if (c0Var == null) {
            a(27);
            throw null;
        }
        if (c0Var.isMarkedNullable()) {
            return true;
        }
        if (y.isFlexible(c0Var) && isNullableType(y.asFlexibleType(c0Var).getUpperBound())) {
            return true;
        }
        if (m0.isDefinitelyNotNullType(c0Var)) {
            return false;
        }
        if (isTypeParameter(c0Var)) {
            return hasNullableSuperType(c0Var);
        }
        u0 constructor = c0Var.getConstructor();
        if (constructor instanceof a0) {
            Iterator<c0> it = constructor.getSupertypes().iterator();
            while (it.hasNext()) {
                if (isNullableType(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isTypeParameter(c0 c0Var) {
        if (c0Var == null) {
            a(59);
            throw null;
        }
        if (getTypeParameterDescriptorOrNull(c0Var) != null) {
            return true;
        }
        c0Var.getConstructor();
        return false;
    }

    public static c0 makeNotNullable(c0 c0Var) {
        if (c0Var != null) {
            return makeNullableAsSpecified(c0Var, false);
        }
        a(2);
        throw null;
    }

    public static c0 makeNullable(c0 c0Var) {
        if (c0Var != null) {
            return makeNullableAsSpecified(c0Var, true);
        }
        a(1);
        throw null;
    }

    public static c0 makeNullableAsSpecified(c0 c0Var, boolean z2) {
        if (c0Var == null) {
            a(3);
            throw null;
        }
        i1 i1VarMakeNullableAsSpecified = c0Var.unwrap().makeNullableAsSpecified(z2);
        if (i1VarMakeNullableAsSpecified != null) {
            return i1VarMakeNullableAsSpecified;
        }
        a(4);
        throw null;
    }

    public static j0 makeNullableIfNeeded(j0 j0Var, boolean z2) {
        if (j0Var == null) {
            a(5);
            throw null;
        }
        if (!z2) {
            if (j0Var != null) {
                return j0Var;
            }
            a(7);
            throw null;
        }
        j0 j0VarMakeNullableAsSpecified = j0Var.makeNullableAsSpecified(true);
        if (j0VarMakeNullableAsSpecified != null) {
            return j0VarMakeNullableAsSpecified;
        }
        a(6);
        throw null;
    }

    public static w0 makeStarProjection(d0.e0.p.d.m0.c.z0 z0Var) {
        if (z0Var != null) {
            return new o0(z0Var);
        }
        a(45);
        throw null;
    }

    public static j0 makeUnsubstitutedType(d0.e0.p.d.m0.c.h hVar, d0.e0.p.d.m0.k.a0.i iVar, Function1<d0.e0.p.d.m0.n.l1.g, j0> function1) {
        if (!t.isError(hVar)) {
            return makeUnsubstitutedType(hVar.getTypeConstructor(), iVar, function1);
        }
        j0 j0VarCreateErrorType = t.createErrorType("Unsubstituted type for " + hVar);
        if (j0VarCreateErrorType != null) {
            return j0VarCreateErrorType;
        }
        a(11);
        throw null;
    }

    public static boolean noExpectedType(c0 c0Var) {
        if (c0Var != null) {
            return c0Var == c || c0Var == d;
        }
        a(0);
        throw null;
    }

    public static c0 makeNullableIfNeeded(c0 c0Var, boolean z2) {
        if (c0Var == null) {
            a(8);
            throw null;
        }
        if (z2) {
            return makeNullable(c0Var);
        }
        if (c0Var != null) {
            return c0Var;
        }
        a(9);
        throw null;
    }

    public static j0 makeUnsubstitutedType(u0 u0Var, d0.e0.p.d.m0.k.a0.i iVar, Function1<d0.e0.p.d.m0.n.l1.g, j0> function1) {
        if (u0Var == null) {
            a(12);
            throw null;
        }
        if (iVar == null) {
            a(13);
            throw null;
        }
        if (function1 != null) {
            j0 j0VarSimpleTypeWithNonTrivialMemberScope = d0.simpleTypeWithNonTrivialMemberScope(d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), u0Var, getDefaultTypeProjections(u0Var.getParameters()), false, iVar, function1);
            if (j0VarSimpleTypeWithNonTrivialMemberScope != null) {
                return j0VarSimpleTypeWithNonTrivialMemberScope;
            }
            a(15);
            throw null;
        }
        a(14);
        throw null;
    }
}
