package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.x0;
import d0.e0.p.d.m0.n.j1;

/* JADX INFO: compiled from: AbstractLazyTypeParameterDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d0.e0.p.d.m0.m.o oVar, d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.g.e eVar, j1 j1Var, boolean z2, int i, u0 u0Var, x0 x0Var) {
        super(oVar, mVar, d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), eVar, j1Var, z2, i, u0Var, x0Var);
        if (oVar == null) {
            a(0);
            throw null;
        }
        if (mVar == null) {
            a(1);
            throw null;
        }
        if (eVar == null) {
            a(2);
            throw null;
        }
        if (j1Var == null) {
            a(3);
            throw null;
        }
        if (u0Var == null) {
            a(4);
            throw null;
        }
        if (x0Var != null) {
        } else {
            a(5);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i == 2) {
            objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
        } else if (i == 3) {
            objArr[0] = "variance";
        } else if (i == 4) {
            objArr[0] = "source";
        } else if (i != 5) {
            objArr[0] = "storageManager";
        } else {
            objArr[0] = "supertypeLoopChecker";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        objArr[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // d0.e0.p.d.m0.c.i1.k
    public String toString() {
        Object[] objArr = new Object[3];
        String str = "";
        objArr[0] = isReified() ? "reified " : "";
        if (getVariance() != j1.INVARIANT) {
            str = getVariance() + " ";
        }
        objArr[1] = str;
        objArr[2] = getName();
        return String.format("%s%s%s", objArr);
    }
}
