package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.j0;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x extends b0<Byte> {
    public x(byte b2) {
        super(Byte.valueOf(b2));
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public c0 getType(d0.e0.p.d.m0.c.c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        d0.e0.p.d.m0.c.e eVarFindClassAcrossModuleDependencies = d0.e0.p.d.m0.c.w.findClassAcrossModuleDependencies(c0Var, d0.e0.p.d.m0.b.k$a.f3221e0);
        j0 defaultType = eVarFindClassAcrossModuleDependencies == null ? null : eVarFindClassAcrossModuleDependencies.getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        j0 j0VarCreateErrorType = d0.e0.p.d.m0.n.t.createErrorType("Unsigned type UByte not found");
        d0.z.d.m.checkNotNullExpressionValue(j0VarCreateErrorType, "createErrorType(\"Unsigned type UByte not found\")");
        return j0VarCreateErrorType;
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public String toString() {
        return getValue().intValue() + ".toUByte()";
    }
}
