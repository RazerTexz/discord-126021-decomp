package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.t */
/* JADX INFO: compiled from: TypeCheckingProcedure.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11960t {
    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m10014a(int i) {
        String str = (i == 7 || i == 10) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 7 || i == 10) ? 2 : 3];
        switch (i) {
            case 1:
            case 3:
            case 16:
            case 18:
                objArr[0] = "supertype";
                break;
            case 2:
            case 15:
            case 17:
            default:
                objArr[0] = "subtype";
                break;
            case 4:
                objArr[0] = "typeCheckingProcedureCallbacks";
                break;
            case 5:
            case 8:
            case 21:
                objArr[0] = "parameter";
                break;
            case 6:
            case 9:
                objArr[0] = "argument";
                break;
            case 7:
            case 10:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure";
                break;
            case 11:
                objArr[0] = "type1";
                break;
            case 12:
                objArr[0] = "type2";
                break;
            case 13:
                objArr[0] = "typeParameter";
                break;
            case 14:
                objArr[0] = "typeArgument";
                break;
            case 19:
                objArr[0] = "subtypeArgumentProjection";
                break;
            case 20:
                objArr[0] = "supertypeArgumentProjection";
                break;
        }
        if (i == 7) {
            objArr[1] = "getOutType";
        } else if (i != 10) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure";
        } else {
            objArr[1] = "getInType";
        }
        switch (i) {
            case 5:
            case 6:
                objArr[2] = "getOutType";
                break;
            case 7:
            case 10:
                break;
            case 8:
            case 9:
                objArr[2] = "getInType";
                break;
            case 11:
            case 12:
                objArr[2] = "equalTypes";
                break;
            case 13:
            case 14:
                objArr[2] = "getEffectiveProjectionKind";
                break;
            case 15:
            case 16:
                objArr[2] = "isSubtypeOf";
                break;
            case 17:
            case 18:
                objArr[2] = "checkSubtypeForTheSameConstructor";
                break;
            case 19:
            case 20:
            case 21:
                objArr[2] = "capture";
                break;
            default:
                objArr[2] = "findCorrespondingSupertype";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 7 && i != 10) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static AbstractC11913c0 findCorrespondingSupertype(AbstractC11913c0 abstractC11913c0, AbstractC11913c0 abstractC11913c1) {
        if (abstractC11913c0 == null) {
            m10014a(0);
            throw null;
        }
        if (abstractC11913c1 != null) {
            return findCorrespondingSupertype(abstractC11913c0, abstractC11913c1, new C11959s());
        }
        m10014a(1);
        throw null;
    }

    public static AbstractC11913c0 findCorrespondingSupertype(AbstractC11913c0 abstractC11913c0, AbstractC11913c0 abstractC11913c1, InterfaceC11961u interfaceC11961u) {
        if (abstractC11913c0 == null) {
            m10014a(2);
            throw null;
        }
        if (abstractC11913c1 == null) {
            m10014a(3);
            throw null;
        }
        if (interfaceC11961u != null) {
            return C11966z.findCorrespondingSupertype(abstractC11913c0, abstractC11913c1, interfaceC11961u);
        }
        m10014a(4);
        throw null;
    }
}
