package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.n.u0;
import java.util.Collection;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KotlinTypeRefiner.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g {
    public abstract d0.e0.p.d.m0.c.e findClassAcrossModuleDependencies(d0.e0.p.d.m0.g.a aVar);

    public abstract <S extends d0.e0.p.d.m0.k.a0.i> S getOrPutScopeForClass(d0.e0.p.d.m0.c.e eVar, Function0<? extends S> function0);

    public abstract boolean isRefinementNeededForModule(c0 c0Var);

    public abstract boolean isRefinementNeededForTypeConstructor(u0 u0Var);

    public abstract d0.e0.p.d.m0.c.h refineDescriptor(d0.e0.p.d.m0.c.m mVar);

    public abstract Collection<d0.e0.p.d.m0.n.c0> refineSupertypes(d0.e0.p.d.m0.c.e eVar);

    public abstract d0.e0.p.d.m0.n.c0 refineType(d0.e0.p.d.m0.n.c0 c0Var);
}
