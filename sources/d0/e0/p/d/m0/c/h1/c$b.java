package d0.e0.p.d.m0.c.h1;

import d0.e0.p.d.m0.c.t0;
import d0.z.d.m;

/* JADX INFO: compiled from: PlatformDependentDeclarationFilter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$b implements c {
    public static final c$b a = new c$b();

    @Override // d0.e0.p.d.m0.c.h1.c
    public boolean isFunctionAvailable(d0.e0.p.d.m0.c.e eVar, t0 t0Var) {
        m.checkNotNullParameter(eVar, "classDescriptor");
        m.checkNotNullParameter(t0Var, "functionDescriptor");
        return !t0Var.getAnnotations().hasAnnotation(d.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME());
    }
}
