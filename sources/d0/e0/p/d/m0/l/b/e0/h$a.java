package d0.e0.p.d.m0.l.b.e0;

import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.c.y0;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DeserializedMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface h$a {
    void addFunctionsAndPropertiesTo(Collection<d0.e0.p.d.m0.c.m> collection, d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1, d0.e0.p.d.m0.d.b.b bVar);

    Collection<t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar);

    Collection<n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar);

    Set<d0.e0.p.d.m0.g.e> getFunctionNames();

    y0 getTypeAliasByName(d0.e0.p.d.m0.g.e eVar);

    Set<d0.e0.p.d.m0.g.e> getTypeAliasNames();

    Set<d0.e0.p.d.m0.g.e> getVariableNames();
}
