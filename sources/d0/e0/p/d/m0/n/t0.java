package d0.e0.p.d.m0.n;

/* JADX INFO: compiled from: TypeCapabilities.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t0 {
    public static final j getCustomTypeVariable(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        d0.e0.p.d.m0.n.n1.h hVarUnwrap = c0Var.unwrap();
        j jVar = hVarUnwrap instanceof j ? (j) hVarUnwrap : null;
        if (jVar != null && jVar.isTypeVariable()) {
            return jVar;
        }
        return null;
    }

    public static final boolean isCustomTypeVariable(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        d0.e0.p.d.m0.n.n1.h hVarUnwrap = c0Var.unwrap();
        j jVar = hVarUnwrap instanceof j ? (j) hVarUnwrap : null;
        if (jVar == null) {
            return false;
        }
        return jVar.isTypeVariable();
    }
}
