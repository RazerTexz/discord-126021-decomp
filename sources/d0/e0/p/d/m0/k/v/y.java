package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.j0;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y extends b0<Integer> {
    public y(int i) {
        super(Integer.valueOf(i));
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public c0 getType(d0.e0.p.d.m0.c.c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        d0.e0.p.d.m0.c.e eVarFindClassAcrossModuleDependencies = d0.e0.p.d.m0.c.w.findClassAcrossModuleDependencies(c0Var, d0.e0.p.d.m0.b.k$a.f3223g0);
        j0 defaultType = eVarFindClassAcrossModuleDependencies == null ? null : eVarFindClassAcrossModuleDependencies.getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        j0 j0VarCreateErrorType = d0.e0.p.d.m0.n.t.createErrorType("Unsigned type UInt not found");
        d0.z.d.m.checkNotNullExpressionValue(j0VarCreateErrorType, "createErrorType(\"Unsigned type UInt not found\")");
        return j0VarCreateErrorType;
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public String toString() {
        return getValue().intValue() + ".toUInt()";
    }
}
