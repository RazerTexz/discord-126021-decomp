package d0.e0.p.d.m0.k.v;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w extends g<String> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(String str) {
        super(str);
        Intrinsics3.checkNotNullParameter(str, "value");
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public String toString() {
        return outline.H(outline.Q('\"'), getValue(), '\"');
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public KotlinType4 getType(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        KotlinType4 stringType = moduleDescriptor2.getBuiltIns().getStringType();
        Intrinsics3.checkNotNullExpressionValue(stringType, "module.builtIns.stringType");
        return stringType;
    }
}
