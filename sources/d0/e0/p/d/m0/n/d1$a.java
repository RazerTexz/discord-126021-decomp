package d0.e0.p.d.m0.n;

/* JADX INFO: compiled from: TypeSystemCommonBackendContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d1$a {
    public static d0.e0.p.d.m0.n.n1.h makeNullable(d1 d1Var, d0.e0.p.d.m0.n.n1.h hVar) {
        d0.z.d.m.checkNotNullParameter(d1Var, "this");
        d0.z.d.m.checkNotNullParameter(hVar, "receiver");
        d0.e0.p.d.m0.n.n1.i iVarAsSimpleType = d1Var.asSimpleType(hVar);
        return iVarAsSimpleType == null ? hVar : d1Var.withNullability(iVarAsSimpleType, true);
    }
}
