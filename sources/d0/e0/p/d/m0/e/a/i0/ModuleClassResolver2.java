package d0.e0.p.d.m0.e.a.i0;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.k.y.JavaDescriptorResolver;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.j, reason: use source file name */
/* JADX INFO: compiled from: ModuleClassResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ModuleClassResolver2 implements ModuleClassResolver {
    public JavaDescriptorResolver a;

    public final JavaDescriptorResolver getResolver() {
        JavaDescriptorResolver javaDescriptorResolver = this.a;
        if (javaDescriptorResolver != null) {
            return javaDescriptorResolver;
        }
        Intrinsics3.throwUninitializedPropertyAccessException("resolver");
        throw null;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.ModuleClassResolver
    public ClassDescriptor resolveClass(d0.e0.p.d.m0.e.a.k0.g gVar) {
        Intrinsics3.checkNotNullParameter(gVar, "javaClass");
        return getResolver().resolveClass(gVar);
    }

    public final void setResolver(JavaDescriptorResolver javaDescriptorResolver) {
        Intrinsics3.checkNotNullParameter(javaDescriptorResolver, "<set-?>");
        this.a = javaDescriptorResolver;
    }
}
