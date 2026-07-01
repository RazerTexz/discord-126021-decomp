package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.findClassInModule;
import d0.e0.p.d.m0.n.ErrorUtils;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class z extends b0<Long> {
    public z(long j) {
        super(Long.valueOf(j));
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public KotlinType getType(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        ClassDescriptor classDescriptorFindClassAcrossModuleDependencies = findClassInModule.findClassAcrossModuleDependencies(moduleDescriptor2, StandardNames.a.f3224h0);
        KotlinType4 defaultType = classDescriptorFindClassAcrossModuleDependencies == null ? null : classDescriptorFindClassAcrossModuleDependencies.getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        KotlinType4 kotlinType4CreateErrorType = ErrorUtils.createErrorType("Unsigned type ULong not found");
        Intrinsics3.checkNotNullExpressionValue(kotlinType4CreateErrorType, "createErrorType(\"Unsigned type ULong not found\")");
        return kotlinType4CreateErrorType;
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public String toString() {
        return getValue().longValue() + ".toULong()";
    }
}
