package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.j0;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends g<Float> {
    public l(float f) {
        super(Float.valueOf(f));
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public /* bridge */ /* synthetic */ c0 getType(d0.e0.p.d.m0.c.c0 c0Var) {
        return getType(c0Var);
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public String toString() {
        return getValue().floatValue() + ".toFloat()";
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public j0 getType(d0.e0.p.d.m0.c.c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        j0 floatType = c0Var.getBuiltIns().getFloatType();
        d0.z.d.m.checkNotNullExpressionValue(floatType, "module.builtIns.floatType");
        return floatType;
    }
}
