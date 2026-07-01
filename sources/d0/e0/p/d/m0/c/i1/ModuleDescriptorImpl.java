package d0.e0.p.d.m0.c.i1;

import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.w, reason: use source file name */
/* JADX INFO: compiled from: ModuleDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ModuleDescriptorImpl {
    List<ModuleDescriptorImpl3> getAllDependencies();

    List<ModuleDescriptorImpl3> getDirectExpectedByDependencies();

    Set<ModuleDescriptorImpl3> getModulesWhoseInternalsAreVisible();
}
