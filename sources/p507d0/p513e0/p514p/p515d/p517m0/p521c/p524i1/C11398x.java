package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import java.util.List;
import java.util.Set;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.x */
/* JADX INFO: compiled from: ModuleDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11398x implements InterfaceC11397w {

    /* JADX INFO: renamed from: a */
    public final List<C11399y> f22987a;

    /* JADX INFO: renamed from: b */
    public final Set<C11399y> f22988b;

    /* JADX INFO: renamed from: c */
    public final List<C11399y> f22989c;

    public C11398x(List<C11399y> list, Set<C11399y> set, List<C11399y> list2, Set<C11399y> set2) {
        C12238m.checkNotNullParameter(list, "allDependencies");
        C12238m.checkNotNullParameter(set, "modulesWhoseInternalsAreVisible");
        C12238m.checkNotNullParameter(list2, "directExpectedByDependencies");
        C12238m.checkNotNullParameter(set2, "allExpectedByDependencies");
        this.f22987a = list;
        this.f22988b = set;
        this.f22989c = list2;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.InterfaceC11397w
    public List<C11399y> getAllDependencies() {
        return this.f22987a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.InterfaceC11397w
    public List<C11399y> getDirectExpectedByDependencies() {
        return this.f22989c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.InterfaceC11397w
    public Set<C11399y> getModulesWhoseInternalsAreVisible() {
        return this.f22988b;
    }
}
