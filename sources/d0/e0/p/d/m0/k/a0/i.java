package d0.e0.p.d.m0.k.a0;

import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.t0;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: MemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface i extends l {
    public static final i$a a = i$a.a;

    Set<d0.e0.p.d.m0.g.e> getClassifierNames();

    Collection<? extends t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar);

    Collection<? extends n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar);

    Set<d0.e0.p.d.m0.g.e> getFunctionNames();

    Set<d0.e0.p.d.m0.g.e> getVariableNames();
}
