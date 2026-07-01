package d0.e0.p.d.m0.n;

/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e0 {
    public static final boolean isError(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        i1 i1VarUnwrap = c0Var.unwrap();
        return (i1VarUnwrap instanceof s) || ((i1VarUnwrap instanceof v) && (((v) i1VarUnwrap).getDelegate() instanceof s));
    }

    public static final boolean isNullable(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        return e1.isNullableType(c0Var);
    }
}
