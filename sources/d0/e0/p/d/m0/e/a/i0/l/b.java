package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.e.a.k0.w;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: DeclaredMemberIndex.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface b {
    d0.e0.p.d.m0.e.a.k0.n findFieldByName(d0.e0.p.d.m0.g.e eVar);

    Collection<d0.e0.p.d.m0.e.a.k0.r> findMethodsByName(d0.e0.p.d.m0.g.e eVar);

    w findRecordComponentByName(d0.e0.p.d.m0.g.e eVar);

    Set<d0.e0.p.d.m0.g.e> getFieldNames();

    Set<d0.e0.p.d.m0.g.e> getMethodNames();

    Set<d0.e0.p.d.m0.g.e> getRecordComponentNames();
}
