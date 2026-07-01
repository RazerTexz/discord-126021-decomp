package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.n, reason: use source file name */
/* JADX INFO: compiled from: EmptyPackageFragmentDesciptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class EmptyPackageFragmentDesciptor extends PackageFragmentDescriptorImpl {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyPackageFragmentDesciptor(ModuleDescriptor2 moduleDescriptor2, FqName fqName) {
        super(moduleDescriptor2, fqName);
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
    }

    @Override // d0.e0.p.d.m0.c.PackageFragmentDescriptor
    public MemberScope3.b getMemberScope() {
        return MemberScope3.b.f3461b;
    }
}
