package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends p<Short> {
    public v(short s2) {
        super(Short.valueOf(s2));
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public String toString() {
        return getValue().intValue() + ".toShort()";
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public KotlinType4 getType(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        KotlinType4 shortType = moduleDescriptor2.getBuiltIns().getShortType();
        Intrinsics3.checkNotNullExpressionValue(shortType, "module.builtIns.shortType");
        return shortType;
    }
}
