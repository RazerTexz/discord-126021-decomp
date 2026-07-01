package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.b$a;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: ErrorUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class t {
    public static final d0.e0.p.d.m0.c.c0 a = new t$a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t$c f3538b;
    public static final j0 c;
    public static final c0 d;
    public static final d0.e0.p.d.m0.c.n0 e;
    public static final Set<d0.e0.p.d.m0.c.n0> f;

    static {
        t$c t_c = new t$c(d0.e0.p.d.m0.g.e.special("<ERROR CLASS>"));
        f3538b = t_c;
        c = createErrorType("<LOOP IN SUPERTYPES>");
        j0 j0VarCreateErrorType = createErrorType("<ERROR PROPERTY TYPE>");
        d = j0VarCreateErrorType;
        d0.e0.p.d.m0.c.i1.c0 c0VarCreate = d0.e0.p.d.m0.c.i1.c0.create(t_c, d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), d0.e0.p.d.m0.c.z.OPEN, d0.e0.p.d.m0.c.t.e, true, d0.e0.p.d.m0.g.e.special("<ERROR PROPERTY>"), b$a.DECLARATION, d0.e0.p.d.m0.c.u0.a, false, false, false, false, false, false);
        c0VarCreate.setType(j0VarCreateErrorType, Collections.emptyList(), null, null);
        e = c0VarCreate;
        f = Collections.singleton(c0VarCreate);
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 4 || i == 6 || i == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 6 || i == 19) ? 2 : 3];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 7:
            case 11:
            case 15:
                objArr[0] = "debugMessage";
                break;
            case 4:
            case 6:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
                break;
            case 5:
                objArr[0] = "ownerScope";
                break;
            case 8:
            case 9:
            case 16:
            case 17:
                objArr[0] = "debugName";
                break;
            case 10:
                objArr[0] = "typeConstructor";
                break;
            case 12:
            case 14:
                objArr[0] = "arguments";
                break;
            case 13:
                objArr[0] = "presentableName";
                break;
            case 18:
                objArr[0] = "errorClass";
                break;
            case 20:
                objArr[0] = "typeParameterDescriptor";
                break;
            default:
                objArr[0] = "function";
                break;
        }
        if (i == 4) {
            objArr[1] = "createErrorProperty";
        } else if (i == 6) {
            objArr[1] = "createErrorFunction";
        } else if (i != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
        } else {
            objArr[1] = "getErrorModule";
        }
        switch (i) {
            case 1:
                objArr[2] = "createErrorClass";
                break;
            case 2:
            case 3:
                objArr[2] = "createErrorScope";
                break;
            case 4:
            case 6:
            case 19:
                break;
            case 5:
                objArr[2] = "createErrorFunction";
                break;
            case 7:
                objArr[2] = "createErrorType";
                break;
            case 8:
                objArr[2] = "createErrorTypeWithCustomDebugName";
                break;
            case 9:
            case 10:
                objArr[2] = "createErrorTypeWithCustomConstructor";
                break;
            case 11:
            case 12:
                objArr[2] = "createErrorTypeWithArguments";
                break;
            case 13:
            case 14:
                objArr[2] = "createUnresolvedType";
                break;
            case 15:
                objArr[2] = "createErrorTypeConstructor";
                break;
            case 16:
            case 17:
            case 18:
                objArr[2] = "createErrorTypeConstructorWithCustomDebugName";
                break;
            case 20:
                objArr[2] = "createUninferredParameterType";
                break;
            default:
                objArr[2] = "containsErrorTypeInParameters";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 6 && i != 19) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static u0 b(String str, t$c t_c) {
        if (str == null) {
            a(17);
            throw null;
        }
        if (t_c != null) {
            return new t$b(t_c, str);
        }
        a(18);
        throw null;
    }

    public static d0.e0.p.d.m0.c.e createErrorClass(String str) {
        if (str == null) {
            a(1);
            throw null;
        }
        return new t$c(d0.e0.p.d.m0.g.e.special("<ERROR CLASS: " + str + ">"));
    }

    public static d0.e0.p.d.m0.k.a0.i createErrorScope(String str) {
        if (str != null) {
            return createErrorScope(str, false);
        }
        a(2);
        throw null;
    }

    public static j0 createErrorType(String str) {
        if (str != null) {
            return createErrorTypeWithArguments(str, Collections.emptyList());
        }
        a(7);
        throw null;
    }

    public static u0 createErrorTypeConstructor(String str) {
        if (str != null) {
            return b(b.d.b.a.a.y("[ERROR : ", str, "]"), f3538b);
        }
        a(15);
        throw null;
    }

    public static u0 createErrorTypeConstructorWithCustomDebugName(String str) {
        if (str != null) {
            return b(str, f3538b);
        }
        a(16);
        throw null;
    }

    public static j0 createErrorTypeWithArguments(String str, List<w0> list) {
        if (str == null) {
            a(11);
            throw null;
        }
        if (list != null) {
            return new s(createErrorTypeConstructor(str), createErrorScope(str), list, false);
        }
        a(12);
        throw null;
    }

    public static j0 createErrorTypeWithCustomConstructor(String str, u0 u0Var) {
        if (str == null) {
            a(9);
            throw null;
        }
        if (u0Var != null) {
            return new s(u0Var, createErrorScope(str));
        }
        a(10);
        throw null;
    }

    public static j0 createErrorTypeWithCustomDebugName(String str) {
        if (str != null) {
            return createErrorTypeWithCustomConstructor(str, createErrorTypeConstructorWithCustomDebugName(str));
        }
        a(8);
        throw null;
    }

    public static d0.e0.p.d.m0.c.c0 getErrorModule() {
        return a;
    }

    public static boolean isError(d0.e0.p.d.m0.c.m mVar) {
        if (mVar == null) {
            return false;
        }
        return (mVar instanceof t$c) || (mVar.getContainingDeclaration() instanceof t$c) || mVar == a;
    }

    public static boolean isUninferredParameter(c0 c0Var) {
        return c0Var != null && (c0Var.getConstructor() instanceof t$f);
    }

    public static d0.e0.p.d.m0.k.a0.i createErrorScope(String str, boolean z2) {
        if (str == null) {
            a(3);
            throw null;
        }
        if (z2) {
            return new t$e(str, null);
        }
        return new t$d(str, null);
    }
}
