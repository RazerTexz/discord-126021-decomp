package d0.e0.p.d.m0.c;

/* JADX INFO: compiled from: ModuleDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c0$a {
    public static <R, D> R accept(c0 c0Var, o<R, D> oVar, D d) {
        d0.z.d.m.checkNotNullParameter(c0Var, "this");
        d0.z.d.m.checkNotNullParameter(oVar, "visitor");
        return oVar.visitModuleDeclaration(c0Var, d);
    }

    public static m getContainingDeclaration(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "this");
        return null;
    }
}
