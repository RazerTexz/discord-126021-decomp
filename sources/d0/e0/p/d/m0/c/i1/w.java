package d0.e0.p.d.m0.c.i1;

import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: ModuleDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface w {
    List<y> getAllDependencies();

    List<y> getDirectExpectedByDependencies();

    Set<y> getModulesWhoseInternalsAreVisible();
}
