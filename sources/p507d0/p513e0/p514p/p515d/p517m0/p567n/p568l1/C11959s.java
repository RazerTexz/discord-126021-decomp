package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.s */
/* JADX INFO: compiled from: TypeCheckerProcedureCallbacksImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11959s implements InterfaceC11961u {
    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m10013a(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
            case 4:
                objArr[0] = "b";
                break;
            case 2:
            case 7:
                objArr[0] = "typeCheckingProcedure";
                break;
            case 3:
            default:
                objArr[0] = "a";
                break;
            case 5:
            case 10:
                objArr[0] = "subtype";
                break;
            case 6:
            case 11:
                objArr[0] = "supertype";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 9:
                objArr[0] = "typeProjection";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl";
        switch (i) {
            case 3:
            case 4:
                objArr[2] = "assertEqualTypeConstructors";
                break;
            case 5:
            case 6:
            case 7:
                objArr[2] = "assertSubtype";
                break;
            case 8:
            case 9:
                objArr[2] = "capture";
                break;
            case 10:
            case 11:
                objArr[2] = "noCorrespondingSupertype";
                break;
            default:
                objArr[2] = "assertEqualTypes";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public boolean assertEqualTypeConstructors(InterfaceC12008u0 interfaceC12008u0, InterfaceC12008u0 interfaceC12008u1) {
        if (interfaceC12008u0 == null) {
            m10013a(3);
            throw null;
        }
        if (interfaceC12008u1 != null) {
            return interfaceC12008u0.equals(interfaceC12008u1);
        }
        m10013a(4);
        throw null;
    }
}
