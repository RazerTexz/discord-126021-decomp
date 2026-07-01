package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends g<Float> {
    public l(float f) {
        super(Float.valueOf(f));
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public String toString() {
        return getValue().floatValue() + ".toFloat()";
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public KotlinType4 getType(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        KotlinType4 floatType = moduleDescriptor2.getBuiltIns().getFloatType();
        Intrinsics3.checkNotNullExpressionValue(floatType, "module.builtIns.floatType");
        return floatType;
    }
}
