package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends g<Boolean> {
    public c(boolean z2) {
        super(Boolean.valueOf(z2));
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public KotlinType4 getType(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        KotlinType4 booleanType = moduleDescriptor2.getBuiltIns().getBooleanType();
        Intrinsics3.checkNotNullExpressionValue(booleanType, "module.builtIns.booleanType");
        return booleanType;
    }
}
