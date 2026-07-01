package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.j0;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends g<Double> {
    public i(double d) {
        super(Double.valueOf(d));
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public /* bridge */ /* synthetic */ c0 getType(d0.e0.p.d.m0.c.c0 c0Var) {
        return getType(c0Var);
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public String toString() {
        return getValue().doubleValue() + ".toDouble()";
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public j0 getType(d0.e0.p.d.m0.c.c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        j0 doubleType = c0Var.getBuiltIns().getDoubleType();
        d0.z.d.m.checkNotNullExpressionValue(doubleType, "module.builtIns.doubleType");
        return doubleType;
    }
}
