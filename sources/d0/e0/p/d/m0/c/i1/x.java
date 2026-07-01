package d0.e0.p.d.m0.c.i1;

import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: ModuleDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x implements w {
    public final List<y> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<y> f3277b;
    public final List<y> c;

    public x(List<y> list, Set<y> set, List<y> list2, Set<y> set2) {
        d0.z.d.m.checkNotNullParameter(list, "allDependencies");
        d0.z.d.m.checkNotNullParameter(set, "modulesWhoseInternalsAreVisible");
        d0.z.d.m.checkNotNullParameter(list2, "directExpectedByDependencies");
        d0.z.d.m.checkNotNullParameter(set2, "allExpectedByDependencies");
        this.a = list;
        this.f3277b = set;
        this.c = list2;
    }

    @Override // d0.e0.p.d.m0.c.i1.w
    public List<y> getAllDependencies() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.c.i1.w
    public List<y> getDirectExpectedByDependencies() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.c.i1.w
    public Set<y> getModulesWhoseInternalsAreVisible() {
        return this.f3277b;
    }
}
