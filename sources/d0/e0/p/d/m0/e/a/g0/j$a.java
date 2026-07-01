package d0.e0.p.d.m0.e.a.g0;

import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.e.a.k0.r;
import d0.e0.p.d.m0.n.c0;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SignaturePropagator.java */
/* JADX INFO: loaded from: classes3.dex */
public class j$a implements j {
    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
                objArr[0] = "owner";
                break;
            case 2:
                objArr[0] = "returnType";
                break;
            case 3:
                objArr[0] = "valueParameters";
                break;
            case 4:
                objArr[0] = "typeParameters";
                break;
            case 5:
                objArr[0] = "descriptor";
                break;
            case 6:
                objArr[0] = "signatureErrors";
                break;
            default:
                objArr[0] = "method";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1";
        if (i == 5 || i == 6) {
            objArr[2] = "reportSignatureErrors";
        } else {
            objArr[2] = "resolvePropagatedSignature";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public void reportSignatureErrors(d0.e0.p.d.m0.c.b bVar, List<String> list) {
        if (bVar == null) {
            a(5);
            throw null;
        }
        if (list != null) {
            throw new UnsupportedOperationException("Should not be called");
        }
        a(6);
        throw null;
    }

    public j$b resolvePropagatedSignature(r rVar, d0.e0.p.d.m0.c.e eVar, c0 c0Var, c0 c0Var2, List<c1> list, List<z0> list2) {
        if (rVar == null) {
            a(0);
            throw null;
        }
        if (eVar == null) {
            a(1);
            throw null;
        }
        if (c0Var == null) {
            a(2);
            throw null;
        }
        if (list == null) {
            a(3);
            throw null;
        }
        if (list2 != null) {
            return new j$b(c0Var, c0Var2, list, list2, Collections.emptyList(), false);
        }
        a(4);
        throw null;
    }
}
