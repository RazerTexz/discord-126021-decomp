package d0.e0.p.d.m0.c.i1;

import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.x, reason: use source file name */
/* JADX INFO: compiled from: ModuleDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ModuleDescriptorImpl2 implements ModuleDescriptorImpl {
    public final List<ModuleDescriptorImpl3> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<ModuleDescriptorImpl3> f3277b;
    public final List<ModuleDescriptorImpl3> c;

    public ModuleDescriptorImpl2(List<ModuleDescriptorImpl3> list, Set<ModuleDescriptorImpl3> set, List<ModuleDescriptorImpl3> list2, Set<ModuleDescriptorImpl3> set2) {
        Intrinsics3.checkNotNullParameter(list, "allDependencies");
        Intrinsics3.checkNotNullParameter(set, "modulesWhoseInternalsAreVisible");
        Intrinsics3.checkNotNullParameter(list2, "directExpectedByDependencies");
        Intrinsics3.checkNotNullParameter(set2, "allExpectedByDependencies");
        this.a = list;
        this.f3277b = set;
        this.c = list2;
    }

    @Override // d0.e0.p.d.m0.c.i1.ModuleDescriptorImpl
    public List<ModuleDescriptorImpl3> getAllDependencies() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.c.i1.ModuleDescriptorImpl
    public List<ModuleDescriptorImpl3> getDirectExpectedByDependencies() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.c.i1.ModuleDescriptorImpl
    public Set<ModuleDescriptorImpl3> getModulesWhoseInternalsAreVisible() {
        return this.f3277b;
    }
}
