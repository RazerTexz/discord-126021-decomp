package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends g<Double> {
    public i(double d) {
        super(Double.valueOf(d));
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public String toString() {
        return getValue().doubleValue() + ".toDouble()";
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public KotlinType4 getType(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        KotlinType4 doubleType = moduleDescriptor2.getBuiltIns().getDoubleType();
        Intrinsics3.checkNotNullExpressionValue(doubleType, "module.builtIns.doubleType");
        return doubleType;
    }
}
