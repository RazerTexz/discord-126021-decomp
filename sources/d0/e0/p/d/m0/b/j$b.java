package d0.e0.p.d.m0.b;

import d0.e0.p.d.m0.c.w;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.o0;
import d0.t.u;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ReflectionTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j$b {
    public j$b(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final c0 createKPropertyStarType(d0.e0.p.d.m0.c.c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        d0.e0.p.d.m0.c.e eVarFindClassAcrossModuleDependencies = w.findClassAcrossModuleDependencies(c0Var, k$a.Z);
        if (eVarFindClassAcrossModuleDependencies == null) {
            return null;
        }
        d0 d0Var = d0.a;
        d0.e0.p.d.m0.c.g1.g empty = d0.e0.p.d.m0.c.g1.g.f.getEMPTY();
        List<z0> parameters = eVarFindClassAcrossModuleDependencies.getTypeConstructor().getParameters();
        d0.z.d.m.checkNotNullExpressionValue(parameters, "kPropertyClass.typeConstructor.parameters");
        Object objSingle = u.single((List<? extends Object>) parameters);
        d0.z.d.m.checkNotNullExpressionValue(objSingle, "kPropertyClass.typeConstructor.parameters.single()");
        return d0.simpleNotNullType(empty, eVarFindClassAcrossModuleDependencies, d0.t.m.listOf(new o0((z0) objSingle)));
    }
}
